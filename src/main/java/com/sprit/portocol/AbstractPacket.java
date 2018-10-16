package com.sprit.portocol;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * @author: xiaohuaxin
 * @Description: 数据包
 * @Date: Created in 2018/10/16
 * @return
 */
@Data
public abstract class AbstractPacket {
    /**
     * 协议版本
     */
    @JSONField(deserialize = false, serialize = false)
    private Byte version = 1;

    /**
     * 指令方法
     */
    @JSONField(serialize = false)
    public abstract Byte getCommand();

}
