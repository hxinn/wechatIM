package com.sprit.server.handler;

import com.sprit.portocol.request.MessageRequestPacket;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author: xiaohuaxin
 * @Description:
 * @Date: Created in 2018/10/16
 * @return
 */
public class MessageRequestHandler extends SimpleChannelInboundHandler<MessageRequestPacket> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessageRequestPacket msg) throws Exception {

    }
}
