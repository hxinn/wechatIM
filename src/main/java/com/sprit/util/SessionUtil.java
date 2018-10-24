package com.sprit.util;

import com.sprit.attribute.Attributes;
import com.sprit.session.Session;
import io.netty.channel.Channel;
import io.netty.channel.group.ChannelGroup;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author xiaohuaxin
 * @Description
 * @Date Created in 2018/10/19
 * @return
 */
public class SessionUtil {
    private static final Map<String, Channel> userIdChannelMap = new ConcurrentHashMap<>();
    private static final Map<String, ChannelGroup> groupIdChannelGroupMap = new ConcurrentHashMap<>();

    public static void bindSession(Session session,Channel channel){
        userIdChannelMap.put(session.getUserId(),channel);
        channel.attr(Attributes.SESSION).set(session);
    }

    public static void unBindSession(Channel channel){
        if (hasLogin(channel)){
            Session session = getSession(channel);
            userIdChannelMap.remove(session.getUserId());
            channel.attr(Attributes.SESSION).set(null);
            System.out.println(session + " 退出登录!");
        }
    }

    public static boolean hasLogin(Channel channel){
        //返回 此channel是否有指定的标识 才返回true
        return channel.hasAttr(Attributes.SESSION);
    }

    public static Session getSession(Channel channel){
        return channel.attr(Attributes.SESSION).get();
    }

    public static Channel getChannel(String userId){
        return userIdChannelMap.get(userId);
    }

    public static void bindChannelGroup(String groupId,ChannelGroup group){
        groupIdChannelGroupMap.put(groupId,group);
    }

    public static ChannelGroup getChannelGroup(String groupId){
        return groupIdChannelGroupMap.get(groupId);
    }
}
