package com.sprit.client.handler;

import com.sprit.portocol.response.LogoutResponsePacket;
import com.sprit.util.SessionUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author: xiaohuaxin
 * @Description:
 * @Date: Created in 2018/10/25
 * @return
 */
public class LogoutResponseHandler extends SimpleChannelInboundHandler<LogoutResponsePacket> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LogoutResponsePacket msg) throws Exception {
        if (msg.isSuccess()){
            System.out.println("退出成功");
            SessionUtil.unBindSession(ctx.channel());
        }
    }
}
