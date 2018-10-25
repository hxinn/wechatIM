package com.sprit.client.handler;

import com.sprit.portocol.response.ListGroupMembersResponsePacket;
import com.sprit.session.Session;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.List;

/**
 * @author: xiaohuaxin
 * @Description:
 * @Date: Created in 2018/10/25
 * @return
 */
public class ListGroupMembersResponseHandler extends SimpleChannelInboundHandler<ListGroupMembersResponsePacket> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ListGroupMembersResponsePacket msg) throws Exception {
        String groupId = msg.getGroupId();
        List<Session> sessions = msg.getSessions();

        System.out.println("群[" + groupId + "]中的人包括：" + sessions);
    }
}
