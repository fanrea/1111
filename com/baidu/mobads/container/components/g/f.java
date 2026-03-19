package com.baidu.mobads.container.components.g;

import android.net.Uri;
import com.baidu.mobads.container.components.g.i;
import com.baidu.mobads.container.util.bq;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class f {
    public static final String a = "URLConnection";
    public static final String b = "POST";
    public static final String c = "GET";
    public static final String d = "application/json";
    public static final String e = "text/plain";
    public static final int f = 1;
    public static final int g = 2;
    private HttpURLConnection h;
    private bq i;
    private a j;
    private b k;
    private String l;
    private String m;
    private String n;
    private String o;
    private int p;
    private int q;
    private boolean r;
    private Uri.Builder s;
    private int t;

    public interface a {
        void a(long j);

        void a(String str, int i);

        void a(String str, String str2);
    }

    public interface b {
        void a(String str, int i);

        void a(String str, k kVar);
    }

    public f(int i, String str) {
        this(i, str, "GET");
    }

    public f(int i, String str, String str2) {
        this.i = bq.a();
        this.j = null;
        this.k = null;
        this.o = "text/plain";
        this.p = 10000;
        this.q = 10000;
        this.r = false;
        this.s = null;
        this.t = i;
        this.l = str;
        this.m = str2;
    }

    public void a() {
        try {
            b();
        } catch (Exception e2) {
            this.i.c(a, e2);
        }
    }

    public void b() {
        i.a aVarC = new i.a().a(this.l).a(this.p).b(this.q).c(this.o);
        if (this.l != null && this.l.contains("//m.baidu.com/")) {
            HashMap map = new HashMap();
            map.put("X-Requested-With2", com.baidu.mobads.container.config.b.a().i());
            aVarC.a(map);
        }
        if ("POST".equalsIgnoreCase(this.m) && this.s != null) {
            aVarC.b(this.s.build().getEncodedQuery());
        }
        e.a().a(aVarC.b()).a(new g(this));
    }

    public void a(Map<String, String> map) {
        if (this.h != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                this.h.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
    }

    public void a(a aVar) {
        this.j = aVar;
    }

    public void a(b bVar) {
        this.k = bVar;
    }

    public void a(int i) {
        this.p = i;
    }

    public void b(int i) {
        this.q = i;
    }

    public void a(Uri.Builder builder) {
        this.s = builder;
    }

    public void a(String str) {
        this.o = str;
    }
}
