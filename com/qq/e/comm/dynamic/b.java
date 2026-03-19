package com.qq.e.comm.dynamic;

import com.qq.e.comm.dynamic.c;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public abstract class b {
    public static b a(int i) {
        if (i != 1 || !c.a().e()) {
            c.a().a((c.e) null, false);
            return null;
        }
        a aVar = new a();
        if (aVar.b()) {
            return aVar;
        }
        return null;
    }

    public abstract Object a(byte[] bArr) throws Throwable;

    public abstract void a();

    public abstract <T> void a(String str, Class<T> cls, T t);

    public abstract byte[] a(String str) throws Throwable;

    public abstract Object b(String str) throws Throwable;

    public abstract boolean b();
}
