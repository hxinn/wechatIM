package com.sprit.server.handler;

import com.sprit.portocol.command.AbstractPacket;
import com.sprit.portocol.command.PacketCodec;
import com.sprit.portocol.request.LoginRequestPacket;
import com.sprit.portocol.response.LoginResponsePacket;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.Date;

/**
 * @author: xiaohuaxin
 * @Description:
 * @Date: Created in 2018/10/16
 * @return
 */
public class ServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println(new Date()+"：服务收到消息");
        ByteBuf byteBuf = (ByteBuf) msg;

        AbstractPacket abstractPacket = PacketCodec.INSTANCE.decode(byteBuf);
        //判断是否为登录请求
        if(abstractPacket instanceof LoginRequestPacket){
            LoginRequestPacket loginPacket = (LoginRequestPacket) abstractPacket;

            LoginResponsePacket responsePacket = new LoginResponsePacket();
            responsePacket.setVersion(abstractPacket.getVersion());

            if(valid(loginPacket)){
                System.out.println("验证通过");
                responsePacket.setSuccess(true);
            }else {
                System.out.println("验证失败");
                responsePacket.setSuccess(false);
                responsePacket.setReason("密码错误！");
            }
            //登录响应
            ByteBuf respon = PacketCodec.INSTANCE.encode(ctx.alloc(), responsePacket);
            ctx.channel().writeAndFlush(respon);
        }
    }

    private boolean valid(LoginRequestPacket loginRequestPacket){
        if(loginRequestPacket!=null){
            if("xiao".equals(loginRequestPacket.getUserName())&&"123456".equals(loginRequestPacket.getPassWord())){
                return true;
            }
        }
        return false;
    }
}
