package com.baidu.mobads.container.components.h.a;

import android.text.TextUtils;
import com.alipay.sdk.m.u.i;
import com.baidu.mobads.container.components.command.OtherDLInfoManager;
import com.baidu.mobads.container.util.bq;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class a {
    private static volatile a a;
    private final int b = 10;
    private final List<C0122a> c = new ArrayList();

    private a() {
    }

    public static a a() {
        if (a == null) {
            synchronized (a.class) {
                if (a == null) {
                    a = new a();
                }
            }
        }
        return a;
    }

    public void a(String str, String str2, String str3, int i, boolean z) {
        if (!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) {
            try {
                C0122a c0122aB = b(str, str2);
                if (c0122aB != null) {
                    this.c.remove(c0122aB);
                    c0122aB.d();
                } else if (this.c.size() >= 10) {
                    c0122aB = this.c.remove(0);
                    c0122aB.e();
                } else {
                    c0122aB = new C0122a();
                }
                c0122aB.a(str, str2);
                c0122aB.a(str3);
                c0122aB.a(i);
                c0122aB.a(z);
                this.c.add(c0122aB);
            } catch (Throwable th) {
                bq.a().d(th);
            }
        }
    }

    public void a(String str, String str2, int i, boolean z) {
        C0122a c0122aB;
        if ((!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) && (c0122aB = b(str, str2)) != null) {
            c0122aB.b(i);
            c0122aB.a(z);
        }
    }

    public void b(String str, String str2, int i, boolean z) {
        C0122a c0122aB;
        if ((!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) && (c0122aB = b(str, str2)) != null) {
            c0122aB.c(i);
            c0122aB.a(z);
        }
    }

    public void c(String str, String str2, int i, boolean z) {
        C0122a c0122aB;
        if ((!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) && (c0122aB = b(str, str2)) != null) {
            c0122aB.d(i);
            c0122aB.a(z);
        }
    }

    public void a(String str, String str2) {
        C0122a c0122aB;
        if ((!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) && (c0122aB = b(str, str2)) != null) {
            c0122aB.a(true);
        }
    }

    public String b() {
        try {
            JSONArray jSONArray = new JSONArray();
            String strC = c();
            if (!TextUtils.isEmpty(strC)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("k", "mobads_st");
                jSONObject.put("v", strC);
                jSONArray.put(jSONObject);
            }
            if (OtherDLInfoManager.getInstance().a()) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("k", "compet_st");
                jSONObject2.put("v", OtherDLInfoManager.getInstance().b());
                jSONArray.put(jSONObject2);
            }
            if (jSONArray.length() > 0) {
                return jSONArray.toString();
            }
            return "";
        } catch (Throwable th) {
            bq.a().d(th);
            return "";
        }
    }

    public String c() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.c.size(); i++) {
            C0122a c0122a = this.c.get(i);
            if (c0122a.a()) {
                String strC = c0122a.c();
                if (!TextUtils.isEmpty(strC)) {
                    sb.append(strC);
                }
            }
        }
        return sb.toString();
    }

    private C0122a b(String str, String str2) {
        for (C0122a c0122a : this.c) {
            if (c0122a != null && c0122a.b(str, str2)) {
                return c0122a;
            }
        }
        return null;
    }

    /* renamed from: com.baidu.mobads.container.components.h.a.a$a, reason: collision with other inner class name */
    public static class C0122a {
        private String e = "";
        private String f = "";
        private String g = "";
        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;
        private long h = 0;
        private long i = 0;
        private boolean j = false;
        private String k = "";

        public void a(String str, String str2) {
            this.f = str;
            this.g = str2;
        }

        public void a(String str) {
            this.e = str;
        }

        public void a(int i) {
            this.a = i;
            this.h = System.currentTimeMillis();
            this.i = this.h;
        }

        public void b(int i) {
            this.b = i;
            this.i = System.currentTimeMillis();
        }

        public void c(int i) {
            this.c = i;
            this.i = System.currentTimeMillis();
        }

        public void d(int i) {
            this.d = i;
            this.i = System.currentTimeMillis();
        }

        public void a(boolean z) {
            this.j = z;
        }

        public boolean a() {
            return this.j;
        }

        public String b() {
            StringBuilder sb = new StringBuilder();
            if (this.a > 0) {
                sb.append(this.a);
            }
            if (this.b > 0) {
                sb.append(this.b);
            }
            if (this.c > 0) {
                sb.append(this.c);
            }
            if (this.d > 0) {
                sb.append(this.d);
            }
            return sb.toString();
        }

        public String c() {
            StringBuilder sb = new StringBuilder();
            String strB = b();
            if (!TextUtils.isEmpty(this.e) && !TextUtils.isEmpty(strB) && !TextUtils.equals(strB, this.k)) {
                sb.append(this.e).append(",").append(this.f).append(",").append(this.g).append(",").append(this.i).append(",").append(strB).append(i.b);
                this.k = strB;
            }
            a(false);
            return sb.toString();
        }

        public boolean b(String str, String str2) {
            return TextUtils.equals(this.f, str) && TextUtils.equals(this.g, str2);
        }

        public boolean a(C0122a c0122a) {
            return c0122a != null && TextUtils.equals(this.f, c0122a.f) && TextUtils.equals(this.g, c0122a.g);
        }

        public void d() {
            this.a = 0;
            this.b = 0;
            this.c = 0;
            this.d = 0;
            this.h = 0L;
            this.i = 0L;
            this.j = false;
        }

        public void e() {
            this.e = "";
            this.f = "";
            this.g = "";
            this.a = 0;
            this.b = 0;
            this.c = 0;
            this.d = 0;
            this.h = 0L;
            this.i = 0L;
            this.k = "";
            this.j = false;
        }
    }
}
