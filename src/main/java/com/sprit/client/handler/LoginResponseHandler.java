package com.sprit.client.handler;

import com.sprit.portocol.response.LoginResponsePacket;
import com.sprit.session.Session;
import com.sprit.util.SessionUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;


/**
 * @author: xiaohuaxin
 * @Description:
 * @Date: Created in 2018/10/18
 * @return
 */
public class LoginResponseHandler extends SimpleChannelInboundHandler<LoginResponsePacket> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LoginResponsePacket msg) throws Exception {
        if(msg.isSuccess()){
            System.out.println("[" + msg.getUserName() + "]登录成功，userId 为: " + msg.getUserId());
            SessionUtil.bindSession(new Session(msg.getUserId(), msg.getUserName()), ctx.channel());
        }else {
            System.out.println("失败："+msg.getReason());
        }
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) {
        System.out.println("客户端连接被关闭!");
    }
}
