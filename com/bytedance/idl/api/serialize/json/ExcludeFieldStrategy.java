package com.bytedance.idl.api.serialize.json;

import com.bytedance.rpc.annotation.e;
import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class ExcludeFieldStrategy implements ExclusionStrategy {
    boolean mSerialize;

    @Override // com.google.gson.ExclusionStrategy
    public boolean shouldSkipClass(Class<?> cls) {
        return false;
    }

    public ExcludeFieldStrategy(boolean z) {
        this.mSerialize = z;
    }

    @Override // com.google.gson.ExclusionStrategy
    public boolean shouldSkipField(FieldAttributes fieldAttributes) {
        if (this.mSerialize) {
            if (fieldAttributes.getAnnotation(e.class) != null) {
                return true;
            }
        } else if (fieldAttributes.getAnnotation(com.bytedance.rpc.annotation.c.class) != null) {
            return true;
        }
        return (fieldAttributes.getAnnotation(com.bytedance.rpc.annotation.b.class) == null || ((com.bytedance.rpc.annotation.b) fieldAttributes.getAnnotation(com.bytedance.rpc.annotation.b.class)).a() == com.bytedance.rpc.serialize.e.BODY) ? false : true;
    }
}
