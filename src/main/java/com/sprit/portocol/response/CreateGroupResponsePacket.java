package com.sprit.portocol.response;

import com.sprit.portocol.AbstractPacket;
import lombok.Data;

import java.util.List;

import static com.sprit.portocol.command.Command.CREATE_GROUP_RESPONSE;

/**
 * @author: xiaohuaxin
 * @Description:
 * @Date: Created in 2018/10/24
 * @return
 */
@Data
public class CreateGroupResponsePacket extends AbstractPacket {

    private boolean success;

    private String groupId;

    private List<String> userNameList;

    @Override
    public Byte getCommand() {
        return CREATE_GROUP_RESPONSE;
    }
}
