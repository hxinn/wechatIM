package com.sprit.console;

import io.netty.channel.Channel;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author: xiaohuaxin
 * @Description:
 * @Date: Created in 2018/10/24
 * @return
 */
public class ConsoleCommandMannager implements ConsoleCommand {
    private Map<String,ConsoleCommand> consoleCommandMap;

    public ConsoleCommandMannager(){
        consoleCommandMap = new HashMap<>();
        consoleCommandMap.put("sendToUser",new SendToUserConsoleCommand());
        consoleCommandMap.put("createGroup",new CreateGroupConsoleCommand());
        consoleCommandMap.put("joinGroup",new JoinGroupConsoleCommand());

    }

    @Override
    public void exec(Scanner scanner, Channel channel) {
        //获取第一个指令
        String command = scanner.next();

        ConsoleCommand consoleCommand = consoleCommandMap.get(command);
        if(consoleCommand != null){
            consoleCommand.exec(scanner,channel);
        }else {
            System.err.println("无法识别["+command+"]指令，请重新输入");
        }
    }
}
