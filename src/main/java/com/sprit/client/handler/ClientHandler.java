package com.sprit.client.handler;

import com.sprit.portocol.AbstractPacket;
import com.sprit.portocol.PacketCodec;
import com.sprit.portocol.request.LoginRequestPacket;
import com.sprit.portocol.response.LoginResponsePacket;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.Date;

/**
 * @author: xiaohuaxin
 * @Description: 客户端登录处理
 * @Date: Created in 2018/10/16
 * @return
 */
public class ClientHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(new Date()+"：客户端开始登录");
        LoginRequestPacket loginPacket = new LoginRequestPacket();
        loginPacket.setUid(7911);
        loginPacket.setUserName("xiao");
        loginPacket.setPassWord("456");
        ByteBuf byteBuf = PacketCodec.INSTANCE.encode(ctx.alloc(),loginPacket);
        ctx.channel().writeAndFlush(byteBuf);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf byteBuf = (ByteBuf) msg;

        AbstractPacket packet = PacketCodec.INSTANCE.decode(byteBuf);

        if (packet instanceof LoginResponsePacket) {
            LoginResponsePacket loginResponsePacket = (LoginResponsePacket) packet;

            if (loginResponsePacket.isSuccess()) {
                System.out.println(new Date() + ": 客户端登录成功");
            } else {
                System.out.println(new Date() + ": 客户端登录失败，原因：" + loginResponsePacket.getReason());
            }
        }
    }
}
