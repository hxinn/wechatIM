package com.sprit.serialize.impl;

import com.alibaba.fastjson.JSON;
import com.sprit.serialize.SerializeAlgorithm;
import com.sprit.serialize.Serializer;

/**
 * @author: xiaohuaxin
 * @Description: JSON 序列化接口
 * @Date: Created in 2018/10/16
 * @return
 */
public class JSONSerializer implements Serializer {


    @Override
    public byte getSerializerAlgorithm() {
        return SerializeAlgorithm.JSON;
    }

    @Override
    public byte[] serialize(Object object) {
        return JSON.toJSONBytes(object);
    }

    @Override
    public <T> T deserialize(Class<T> clazz, byte[] bytes) {
        return JSON.parseObject(bytes, clazz);
    }
}
