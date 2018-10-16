package com.sprit.server.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.nio.charset.Charset;
import java.util.Date;

/**
 * @author: xiaohuaxin
 * @Description:
 * @Date: Created in 2018/10/15
 * @return
 */
public class FirstServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf byteBuf = (ByteBuf) msg;
        //表示byteBuf底层占用多少字节的内存
        int capacity = byteBuf.capacity();
        //表示byteBuf底层最大能占用多少字节的内存 当向bytebuf中写数据的时候 如果容量不足 则进行扩容直到maxCapacity 超出则报错
        int maxCapacity = byteBuf.maxCapacity();
        //当前可读字节数
        int i = byteBuf.readableBytes();

        System.out.println("占用多少内存："+capacity);
        System.out.println("可用最大内存："+maxCapacity);
        System.out.println(new Date() + ": 服务端读到数据 -> " + byteBuf.toString(Charset.forName("utf-8")));

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ByteBuf buffer = ctx.alloc().buffer();
        byte[] bytes = "服务器收到链接".getBytes(Charset.forName("utf-8"));
        buffer.writeBytes(bytes);
        ctx.channel().writeAndFlush(buffer);
    }
}
