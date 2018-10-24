package com.sprit.console;

import com.sprit.portocol.request.CreateGroupRequestPacket;
import io.netty.channel.Channel;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: xiaohuaxin
 * @Description:
 * @Date: Created in 2018/10/24
 * @return
 */
public class CreateGroupConsoleCommand implements ConsoleCommand {
    private static final  String USER_ID_SPLITER = ",";

    @Override
    public void exec(Scanner scanner, Channel channel) {
        CreateGroupRequestPacket groupRequestPacket = new CreateGroupRequestPacket();

        System.out.println("拉入群聊请输入userid,多个之间用英文逗号隔开：");
        String userIds = scanner.next();
        groupRequestPacket.setUserIdList(Arrays.asList(userIds.split(USER_ID_SPLITER)));
        channel.writeAndFlush(groupRequestPacket);
    }
}
