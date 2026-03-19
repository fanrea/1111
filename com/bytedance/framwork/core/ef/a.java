package com.bytedance.framwork.core.ef;

import android.content.Context;
import android.text.TextUtils;
import java.util.List;

/* compiled from: LogHandler.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public abstract class a {
    private String a;
    private c b;
    protected String c;
    protected b d;
    protected d e;
    private long f;

    /* compiled from: LogHandler.java */
    /* renamed from: com.bytedance.framwork.core.ef.a$a, reason: collision with other inner class name */
    public static abstract class AbstractC0210a implements b {
        @Override // com.bytedance.framwork.core.ef.a.b
        public int c() {
            return 4;
        }

        @Override // com.bytedance.framwork.core.ef.a.b
        public long d() {
            return 15000L;
        }

        @Override // com.bytedance.framwork.core.ef.a.b
        public String e() {
            return null;
        }

        @Override // com.bytedance.framwork.core.ef.a.b
        public long f() {
            return 604800000L;
        }
    }

    /* compiled from: LogHandler.java */
    public interface b {
        String a();

        List<String> b();

        int c();

        long d();

        String e();

        long f();
    }

    /* compiled from: LogHandler.java */
    public interface c {
        boolean a();

        long b();

        boolean c();
    }

    protected void a(byte[] bArr, boolean z) {
    }

    protected abstract boolean a(String str, byte[] bArr);

    public long a() {
        return this.f;
    }

    public void a(long j) {
        this.f = j;
    }

    public a(Context context, b bVar, c cVar) {
        this.d = bVar;
        this.b = cVar;
        if (bVar == null) {
            throw new IllegalArgumentException("config is null.");
        }
        if (cVar == null) {
            throw new IllegalArgumentException("responseConfig is null");
        }
        String strA = bVar.a();
        this.c = strA;
        if (TextUtils.isEmpty(strA)) {
            throw new IllegalArgumentException("type is empty.");
        }
        d dVarA = d.a(context);
        this.e = dVarA;
        dVarA.a(this.c, this);
    }

    public boolean a(String str) {
        return a(com.bytedance.framwork.core.ef.c.a(str));
    }

    public boolean a(byte[] bArr) {
        return this.e.a(this.c, bArr);
    }

    b b() {
        return this.d;
    }

    c c() {
        return this.b;
    }

    String d() {
        return this.a;
    }

    public void b(String str) {
        this.a = str;
    }
}
