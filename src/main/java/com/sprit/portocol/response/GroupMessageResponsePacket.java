package com.sprit.portocol.response;

import com.sprit.portocol.AbstractPacket;
import com.sprit.session.Session;
import lombok.Data;

import static com.sprit.portocol.command.Command.GROUP_MESSAGE_RESPONSE;

/**
 * @author: xiaohuaxin
 * @Description:
 * @Date: Created in 2018/10/25
 * @return
 */
@Data
public class GroupMessageResponsePacket extends AbstractPacket {

    private String fromGroupId;

    private Session fromUser;

    private String message;

    @Override
    public Byte getCommand() {
        return GROUP_MESSAGE_RESPONSE;
    }
}
