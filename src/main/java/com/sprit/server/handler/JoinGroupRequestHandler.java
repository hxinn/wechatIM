package com.sprit.server.handler;

import com.sprit.portocol.request.JoinGroupRequestPacket;
import com.sprit.portocol.response.JoinGroupResponsePacket;
import com.sprit.util.SessionUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;

/**
 * @author: xiaohuaxin
 * @Description:
 * @Date: Created in 2018/10/24
 * @return
 */
public class JoinGroupRequestHandler extends SimpleChannelInboundHandler<JoinGroupRequestPacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, JoinGroupRequestPacket msg) throws Exception {
        //获取对应的 channelGroup,然后将当期用户的 channel 添加进去
        String groupId = msg.getGroupId();
        ChannelGroup channelGroup = SessionUtil.getChannelGroup(groupId);
        JoinGroupResponsePacket responsePacket = new JoinGroupResponsePacket();
        if(channelGroup !=  null){
            channelGroup.add(ctx.channel());
            //构造加群响应发送给客户端
            responsePacket.setSuccess(true);
            responsePacket.setGroupId(groupId);
        }else {
            responsePacket.setSuccess(false);
            responsePacket.setReason("未找到该群聊");
        }
        ctx.channel().writeAndFlush(responsePacket);
    }
}
