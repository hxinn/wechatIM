package com.sprit.serialize;

import com.sprit.serialize.impl.JSONSerializer;

/**
 * @author: xiaohuaxin
 * @Description: 定义序列化接口
 * @Date: Created in 2018/10/16
 * @return
 */
public interface Serializer {
    Serializer DEFAULT = new JSONSerializer();
    /**
     * 协议算法
     */
    byte getSerializerAlgorithm();

    /**
     * java 对象二进制转换
     */
    byte[] serialize(Object object);

    /**
     * 二进制转换为JAVA对象
     */
    <T> T deserialize(Class<T> clazz,byte[] bytes);
}
