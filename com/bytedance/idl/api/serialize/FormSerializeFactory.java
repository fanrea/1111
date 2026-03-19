package com.bytedance.idl.api.serialize;

import com.bytedance.rpc.serialize.SerializeType;
import com.bytedance.rpc.serialize.d;
import com.bytedance.rpc.serialize.f;
import com.bytedance.rpc.serialize.i;
import com.bytedance.sdk.djx.proguard3.b.a;
import com.bytedance.sdk.djx.proguard3.b.b;
import com.google.gson.Gson;
import java.lang.reflect.Type;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class FormSerializeFactory implements f {
    private volatile Gson mGson = new Gson();

    @Override // com.bytedance.rpc.serialize.f
    public boolean isReflectSupported() {
        return true;
    }

    @Override // com.bytedance.rpc.serialize.f
    public d getDeserializer(com.bytedance.sdk.djx.proguard3.d.d dVar, Type type) {
        return new a(dVar, type);
    }

    @Override // com.bytedance.rpc.serialize.f
    public i getSerializer(Object obj, SerializeType serializeType) {
        return new b(obj, serializeType, this.mGson);
    }

    @Override // com.bytedance.rpc.serialize.f
    public SerializeType getSerializeType() {
        return SerializeType.FORM;
    }
}
