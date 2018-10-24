package com.sprit.portocol.request;

import com.sprit.portocol.AbstractPacket;
import lombok.Data;

import java.util.List;

import static com.sprit.portocol.command.Command.CREATE_GROUP_REQUEST;

/**
 * @author: xiaohuaxin
 * @Description:
 * @Date: Created in 2018/10/24
 * @return
 */
@Data
public class CreateGroupRequestPacket extends AbstractPacket {
    private List<String> userIdList;

    @Override
    public Byte getCommand() {
        return CREATE_GROUP_REQUEST;
    }
}
