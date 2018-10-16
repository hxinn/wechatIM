package com.sprit.server.handler;

import com.sprit.portocol.request.LoginRequestPacket;
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

    }
}
