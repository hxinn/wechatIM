package com.sprit.server.handler;

import com.sprit.portocol.request.ListGroupMembersRequestPacket;
import com.sprit.portocol.response.ListGroupMembersResponsePacket;
import com.sprit.session.Session;
import com.sprit.util.SessionUtil;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: xiaohuaxin
 * @Description:
 * @Date: Created in 2018/10/25
 * @return
 */
@ChannelHandler.Sharable
public class ListGroupMembersRequestHandler extends SimpleChannelInboundHandler<ListGroupMembersRequestPacket> {
    public static final ListGroupMembersRequestHandler INSTANCE = new ListGroupMembersRequestHandler();

    public ListGroupMembersRequestHandler() {
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ListGroupMembersRequestPacket msg) throws Exception {
        String groupId = msg.getGroupId();
        ChannelGroup channelGroup = SessionUtil.getChannelGroup(groupId);

        List<Session> sessions = new ArrayList<>();

        for (Channel channel : channelGroup) {
            Session session = SessionUtil.getSession(channel);
            sessions.add(session);
        }

        ListGroupMembersResponsePacket responsePacket = new ListGroupMembersResponsePacket();
        responsePacket.setGroupId(groupId);
        responsePacket.setSessions(sessions);
        ctx.channel().writeAndFlush(responsePacket);

    }
}
