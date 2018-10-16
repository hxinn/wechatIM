package com.sprit.client.handler;

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
public class FirstClientHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(new Date()+":客户端发送数据");
        ByteBuf buffer = ctx.alloc().buffer();
        byte[] bytes = "客户端链接成功 发送请求".getBytes(Charset.forName("utf-8"));
        buffer.writeBytes(bytes);
        ctx.channel().writeAndFlush(buffer);
    }
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        ByteBuf byteBuf = (ByteBuf) msg;

        System.out.println(new Date() + ": 客户端读到数据 -> " + byteBuf.toString(Charset.forName("utf-8")));
    }
}
