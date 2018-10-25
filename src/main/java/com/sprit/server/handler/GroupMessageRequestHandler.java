package com.sprit.server.handler;
import com.sprit.session.Session;

import com.sprit.portocol.request.GroupMessageRequestPacket;
import com.sprit.portocol.response.GroupMessageResponsePacket;
import com.sprit.util.SessionUtil;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;

/**
 * @author: xiaohuaxin
 * @Description:
 * @Date: Created in 2018/10/25
 * @return
 */
@ChannelHandler.Sharable
public class GroupMessageRequestHandler extends SimpleChannelInboundHandler<GroupMessageRequestPacket> {
    public static final GroupMessageRequestHandler INSTANCE = new GroupMessageRequestHandler();

    public GroupMessageRequestHandler() {
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, GroupMessageRequestPacket msg) throws Exception {
        System.out.println("收到群聊");
        String toGroupId = msg.getToGroupId();

        Session session = SessionUtil.getSession(ctx.channel());
        ChannelGroup channelGroup = SessionUtil.getChannelGroup(toGroupId);


        GroupMessageResponsePacket responsePacket = new GroupMessageResponsePacket();

        responsePacket.setFromGroupId(toGroupId);
        responsePacket.setFromUser(session);
        responsePacket.setMessage(msg.getMessage());

        channelGroup.writeAndFlush(responsePacket);


    }
}
