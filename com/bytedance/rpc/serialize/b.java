package com.bytedance.rpc.serialize;

import com.bytedance.rpc.d;

/* compiled from: AbstractSerializer.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public abstract class b implements i {
    protected Object b;
    protected SerializeType c;

    public abstract byte[] a(Object obj, String str) throws Exception;

    public b(Object obj, SerializeType serializeType) {
        this.b = obj;
        this.c = serializeType;
    }

    protected String a() {
        return this.c.getContentType();
    }

    @Override // com.bytedance.rpc.serialize.i
    public final c b() throws Exception {
        String strA = a();
        Object objA = a(this.b, false);
        return new c(objA == null ? null : a(objA, strA), strA);
    }

    public static Object a(Object obj, boolean z) {
        if (obj == null || !(obj instanceof Object[])) {
            return obj;
        }
        Object[] objArr = (Object[]) obj;
        if (objArr.length == 0) {
            return null;
        }
        return (z || objArr.length == 1) ? objArr[0] : obj;
    }

    public static d.a a(Object obj) {
        Object objA = a(obj, true);
        if (objA instanceof com.bytedance.rpc.d) {
            return ((com.bytedance.rpc.d) objA).a();
        }
        if (objA instanceof d.a) {
            return (d.a) objA;
        }
        return null;
    }
}
