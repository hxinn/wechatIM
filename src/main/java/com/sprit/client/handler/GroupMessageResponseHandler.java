package com.sprit.client.handler;

import com.sprit.portocol.response.GroupMessageResponsePacket;
import com.sprit.session.Session;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author: xiaohuaxin
 * @Description:
 * @Date: Created in 2018/10/25
 * @return
 */
public class GroupMessageResponseHandler extends SimpleChannelInboundHandler<GroupMessageResponsePacket> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, GroupMessageResponsePacket msg) throws Exception {
        String fromGroupId = msg.getFromGroupId();
        Session fromUser = msg.getFromUser();
        String message = msg.getMessage();
        System.out.println("收到群[" + fromGroupId + "]中[" + fromUser + "]发来的消息：" + message);
    }
}
