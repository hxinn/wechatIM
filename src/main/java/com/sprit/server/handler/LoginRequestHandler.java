package com.sprit.server.handler;

import com.sprit.portocol.request.LoginRequestPacket;
import com.sprit.portocol.response.LoginResponsePacket;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author: xiaohuaxin
 * @Description: 登录处理器
 * @Date: Created in 2018/10/16
 * @return
 */
public class LoginRequestHandler extends SimpleChannelInboundHandler<LoginRequestPacket> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LoginRequestPacket msg) throws Exception {
        System.out.println("服务端收到请求");
        LoginResponsePacket responsePacket = new LoginResponsePacket();
        responsePacket.setVersion(msg.getVersion());
        if(valid(msg)){
            System.out.println("验证通过");
            responsePacket.setSuccess(true);
        }else {
            System.out.println("验证失败");
            responsePacket.setSuccess(false);
            responsePacket.setReason("密码错误！");
        }
        ctx.channel().writeAndFlush(responsePacket);
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
