package com.sprit.portocol.request;

import com.sprit.portocol.AbstractPacket;
import lombok.Data;

import static com.sprit.portocol.command.Command.JOIN_GROUP_REQUEST;

/**
 * @author: xiaohuaxin
 * @Description:
 * @Date: Created in 2018/10/24
 * @return
 */
@Data
public class JoinGroupRequestPacket extends AbstractPacket {
    private String groupId;

    @Override
    public Byte getCommand() {
        return JOIN_GROUP_REQUEST;
    }
}
