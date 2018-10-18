package com.sprit.client.handler;

import com.sprit.portocol.request.LoginRequestPacket;
import com.sprit.portocol.response.LoginResponsePacket;
import com.sprit.util.LoginUtil;
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
    public void channelActive(ChannelHandlerContext ctx) {
        System.out.println("发送登录请求");
        // 创建登录对象
        LoginRequestPacket loginRequestPacket = new LoginRequestPacket();
        loginRequestPacket.setUid(1024);
        loginRequestPacket.setUserName("xiao");
        loginRequestPacket.setPassWord("123456");
        // 写数据
        ctx.channel().writeAndFlush(loginRequestPacket);
    }
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LoginResponsePacket msg) throws Exception {
        if(msg.isSuccess()){
            System.out.println("登录成功");
            LoginUtil.markAsLogin(ctx.channel());
        }else {
            System.out.println("失败："+msg.getReason());
        }
    }
}
