package com.qq.e.comm.dynamic;

import android.text.TextUtils;
import com.qq.e.comm.plugin.ey;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class a extends b {
    private QuickJS a;

    public a() {
        try {
            this.a = QuickJS.a();
        } catch (Exception unused) {
            ey.a();
        }
    }

    @Override // com.qq.e.comm.dynamic.b
    public void a() {
        if (b()) {
            this.a.close();
            this.a = null;
        }
    }

    @Override // com.qq.e.comm.dynamic.b
    public Object b(String str) throws Throwable {
        if (!b() || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.a.a(str);
    }

    @Override // com.qq.e.comm.dynamic.b
    public <T> void a(String str, Class<T> cls, T t) throws SecurityException {
        if (b()) {
            this.a.a(str, cls, t);
        }
    }

    @Override // com.qq.e.comm.dynamic.b
    public Object a(byte[] bArr) throws Throwable {
        if (!b() || bArr == null || bArr.length <= 0) {
            return null;
        }
        return this.a.a(bArr);
    }

    @Override // com.qq.e.comm.dynamic.b
    public byte[] a(String str) throws Throwable {
        if (!b() || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.a.a(str, "?");
    }

    @Override // com.qq.e.comm.dynamic.b
    public boolean b() {
        return this.a != null;
    }
}
