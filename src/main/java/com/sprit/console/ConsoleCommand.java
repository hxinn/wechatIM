package com.sprit.console;

import io.netty.channel.Channel;

import java.util.Scanner;

/**
 * @author: xiaohuaxin
 * @Description:
 * @Date: Created in 2018/10/24
 * @return
 */
public interface ConsoleCommand {

    void exec(Scanner scanner, Channel channel);
}
