package com.sprit.client.handler;

import com.sprit.portocol.response.MessageResponsePacket;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Date;

/**
 * @author: xiaohuaxin
 * @Description:
 * @Date: Created in 2018/10/18
 * @return
 */
public class MessageResponseHandler extends SimpleChannelInboundHandler<MessageResponsePacket> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessageResponsePacket msg) throws Exception {
        String fromUserId = msg.getFromUserId();
        String fromUserName = msg.getFromUserName();
        System.out.println("[回复：]" +fromUserId+ "-- "+fromUserName+": " + msg.getMessage());
    }
}
