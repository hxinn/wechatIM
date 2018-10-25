package com.sprit.portocol.request;

import com.sprit.portocol.AbstractPacket;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.sprit.portocol.command.Command.GROUP_MESSAGE_REQUEST;

/**
 * @author: xiaohuaxin
 * @Description:
 * @Date: Created in 2018/10/25
 * @return
 */
@Data
@NoArgsConstructor
public class GroupMessageRequestPacket extends AbstractPacket {

    private String toGroupId;
    private String message;

    @Override
    public Byte getCommand() {
        return GROUP_MESSAGE_REQUEST;
    }

    public GroupMessageRequestPacket(String toGroupId, String message) {
        this.toGroupId = toGroupId;
        this.message = message;
    }
}
