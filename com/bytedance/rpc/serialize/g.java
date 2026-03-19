package com.bytedance.rpc.serialize;

import java.lang.reflect.Type;

/* compiled from: SerializeFactoryContainer.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class g implements f {
    SerializeType a;
    f[] b;

    g(SerializeType serializeType, f[] fVarArr) {
        this.a = serializeType;
        this.b = fVarArr;
    }

    @Override // com.bytedance.rpc.serialize.f
    public d getDeserializer(com.bytedance.sdk.djx.proguard3.d.d dVar, Type type) {
        for (f fVar : this.b) {
            d deserializer = fVar.getDeserializer(dVar, type);
            if (deserializer != null) {
                return deserializer;
            }
        }
        return null;
    }

    @Override // com.bytedance.rpc.serialize.f
    public i getSerializer(Object obj, SerializeType serializeType) {
        for (f fVar : this.b) {
            i serializer = fVar.getSerializer(obj, serializeType);
            if (serializer != null) {
                return serializer;
            }
        }
        return null;
    }

    @Override // com.bytedance.rpc.serialize.f
    public SerializeType getSerializeType() {
        return this.a;
    }

    @Override // com.bytedance.rpc.serialize.f
    public boolean isReflectSupported() {
        for (f fVar : this.b) {
            if (fVar.isReflectSupported()) {
                return true;
            }
        }
        return false;
    }
}
