package com.bytedance.rpc.serialize;

import java.lang.reflect.Type;

/* compiled from: AbstractDeserializer.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public abstract class a implements d {
    protected Type a;
    protected com.bytedance.sdk.djx.proguard3.d.d b;

    protected abstract Object a(com.bytedance.sdk.djx.proguard3.d.d dVar, Type type) throws Exception;

    public a(com.bytedance.sdk.djx.proguard3.d.d dVar, Type type) {
        this.a = type;
        this.b = dVar;
    }

    @Override // com.bytedance.rpc.serialize.d
    public final Object a() throws Exception {
        return a(this.b, this.a);
    }
}
