package com.baidu.mobads.container.components.h;

import android.text.TextUtils;
import com.baidu.mobads.container.adrequest.j;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class c {
    public j a;
    public long b;
    public String c;
    public long d;
    public AtomicBoolean e = new AtomicBoolean(false);
    public AtomicBoolean f = new AtomicBoolean(false);
    private HashMap<String, String> g = new HashMap<>();
    private StringBuilder h = new StringBuilder();

    public c(long j, String str, j jVar) {
        this.b = j;
        this.c = str;
        this.a = jVar;
    }

    public void a(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            this.g.put(str, str2);
            this.d = System.currentTimeMillis();
            a(b.f.equals(str));
        }
    }

    public void a(a aVar) {
        if (aVar != null && aVar.b() > 0) {
            this.h.append(aVar.b());
            this.d = System.currentTimeMillis();
            a(false);
        }
    }

    public void a(boolean z) {
        if (this.e.get() != z) {
            this.e.set(z);
        }
        if (!z) {
            b(false);
        }
    }

    public void b(boolean z) {
        if (this.f.get() != z) {
            this.f.set(z);
        }
    }

    public HashMap<String, String> a() {
        return this.g;
    }

    public String b() {
        return this.h.toString();
    }
}
