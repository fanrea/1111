package com.bytedance.rpc.serialize;

import java.lang.reflect.Type;

/* compiled from: SerializeFactory.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public interface f {
    d getDeserializer(com.bytedance.sdk.djx.proguard3.d.d dVar, Type type);

    SerializeType getSerializeType();

    i getSerializer(Object obj, SerializeType serializeType);

    boolean isReflectSupported();
}
