package com.sprit.server.handler;

import com.sprit.portocol.request.LoginRequestPacket;
import com.sprit.portocol.response.LoginResponsePacket;
import com.sprit.session.Session;
import com.sprit.util.LoginUtil;
import com.sprit.util.SessionUtil;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import java.util.UUID;

/**
 * @author: xiaohuaxin
 * @Description: 登录处理器
 * @Date: Created in 2018/10/16
 * @return
 */
@ChannelHandler.Sharable
public class LoginRequestHandler extends SimpleChannelInboundHandler<LoginRequestPacket> {
    public static final LoginRequestHandler INSTANCE = new LoginRequestHandler();

    public LoginRequestHandler() {
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LoginRequestPacket msg) throws Exception {
        LoginResponsePacket responsePacket = new LoginResponsePacket();
        responsePacket.setVersion(msg.getVersion());
        responsePacket.setUserName(msg.getUserName());
        if(valid(msg)){
            responsePacket.setSuccess(true);
            String userId = randomUserId();
            responsePacket.setUserId(userId);
            System.out.println("[" + msg.getUserName() + "]登录成功");
            SessionUtil.bindSession(new Session(userId,msg.getUserName()),ctx.channel());

            LoginUtil.markAsLogin(ctx.channel());
        }else {
            System.out.println("验证失败");
            responsePacket.setSuccess(false);
            responsePacket.setReason("密码错误！");
        }
        ctx.channel().writeAndFlush(responsePacket);
    }

    private boolean valid(LoginRequestPacket loginRequestPacket){
//        if(loginRequestPacket!=null){
//            if("xiao".equals(loginRequestPacket.getUserName())&&"123456".equals(loginRequestPacket.getPassWord())){
//                return true;
//            }
//        }
        return true;
    }


    private static String randomUserId() {
        return UUID.randomUUID().toString().split("-")[0];
    }

    /**
     * 链接关闭取消绑定
     * @param ctx
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) {
        SessionUtil.unBindSession(ctx.channel());
    }
}
