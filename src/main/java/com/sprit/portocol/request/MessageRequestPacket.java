package com.sprit.portocol.request;

import com.sprit.portocol.AbstractPacket;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.sprit.portocol.command.Command.MESSAGE_REQUEST;

/**
 * @author: xiaohuaxin
 * @Description:
 * @Date: Created in 2018/10/16
 * @return
 */
@Data
@NoArgsConstructor
public class MessageRequestPacket extends AbstractPacket {

    private String message;

        public MessageRequestPacket(String message) {
        this.message = message;
    }

    @Override
    public Byte getCommand() {
        return MESSAGE_REQUEST;
    }
}
