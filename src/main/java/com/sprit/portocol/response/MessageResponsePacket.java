package com.sprit.portocol.response;

import com.sprit.portocol.AbstractPacket;
import lombok.Data;

import static com.sprit.portocol.command.Command.MESSAGE_RESPONSE;

/**
 * @author: xiaohuaxin
 * @Description:
 * @Date: Created in 2018/10/16
 * @return
 */
@Data
public class MessageResponsePacket extends AbstractPacket {
    private String message;


    @Override
    public Byte getCommand() {
        return MESSAGE_RESPONSE;
    }
}
