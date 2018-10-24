package com.sprit.console;

import com.sprit.portocol.request.MessageRequestPacket;
import io.netty.channel.Channel;

import java.util.Scanner;

/**
 * @author: xiaohuaxin
 * @Description:
 * @Date: Created in 2018/10/24
 * @return
 */
public class SendToUserConsoleCommand implements ConsoleCommand {


    @Override
    public void exec(Scanner scanner, Channel channel) {
        System.out.print("发送消息给某个某个用户：");

        String toUserId = scanner.next();
        String message = scanner.next();
        channel.writeAndFlush(new MessageRequestPacket(message,toUserId));
    }
}
