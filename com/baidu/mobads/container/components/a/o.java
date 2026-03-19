package com.baidu.mobads.container.components.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.mobads.container.util.bj;
import com.component.a.a.b;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class o {
    private final l a;
    private final com.baidu.mobads.container.components.command.a b;
    private final j c;
    private final HashMap<Integer, a> d;
    private Context e;
    private int f;

    public static class b {
        public static final int a = 200;
        public static final int b = 201;
        public static final int c = 202;
        public static final int d = 203;
        public static final int e = 204;
        public static final int f = 205;
        public static final int g = 206;
    }

    /* synthetic */ o(p pVar) {
        this();
    }

    private class c implements k {
        private final com.baidu.mobads.container.components.command.j b;
        private final int c;

        public c(int i, com.baidu.mobads.container.components.command.j jVar) {
            this.c = i;
            this.b = jVar;
        }

        @Override // com.baidu.mobads.container.components.a.k
        public void a() {
            switch (this.c) {
                case 201:
                    o.this.a(this.c, 102, this.b, null);
                    break;
                case 202:
                    o.this.a(this.c, 102, this.b, null);
                    break;
                case 203:
                    o.this.a(this.c, 202, this.b, null);
                    com.baidu.mobads.container.components.command.m.b(o.this.e, this.b);
                    break;
                case 204:
                    if (com.baidu.mobads.container.components.command.m.c(o.this.e, this.b)) {
                        o.this.a(this.c, 116, this.b, null);
                        break;
                    } else {
                        o.this.a(this.c, 404, this.b, "ApkFileError.");
                        break;
                    }
                case 205:
                case 206:
                    if (o.this.e != null && this.b != null) {
                        if (bj.c(o.this.e, this.b.d())) {
                            o.this.a(this.c, 118, this.b, null);
                            bj.a(o.this.e, this.b);
                            break;
                        } else {
                            o.this.a(this.c, 404, this.b, "ApkRemove");
                            break;
                        }
                    }
                    break;
            }
        }

        @Override // com.baidu.mobads.container.components.a.k
        public void b() {
            o.this.a(this.c, 401, this.b, null);
            switch (this.c) {
                case 205:
                    o.a().a(206, this.b);
                    break;
            }
        }

        @Override // com.baidu.mobads.container.components.a.k
        public void c() {
        }
    }

    private static class d {
        private static final o a = new o(null);

        private d() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class a {
        private static final long h = 1440000;
        private static final long i = 5000;
        public int a = 0;
        public int b;
        public long c;
        public long d;
        public String e;
        public com.baidu.mobads.container.components.command.j f;
        public i g;

        public a(String str, int i2, long j, long j2) {
            this.e = str;
            this.b = i2;
            this.c = j;
            this.d = j2;
        }

        public void a(com.baidu.mobads.container.components.command.j jVar) {
            this.f = jVar;
            b(this.f.aD);
        }

        public long a() {
            if (this.c > 0 && this.d > 0 && System.currentTimeMillis() - this.c > this.d * 2) {
                return 5000L;
            }
            return this.d;
        }

        public boolean b() {
            return System.currentTimeMillis() - this.c <= h;
        }

        private void b(String str) {
            try {
                if (TextUtils.isEmpty(str)) {
                    str = "{}";
                }
                JSONObject jSONObject = new JSONObject(str);
                switch (this.b) {
                    case 201:
                        this.a = jSONObject.optInt("dl_detain", 0);
                        break;
                    case 202:
                        this.a = jSONObject.optInt("u_dl", 0);
                        this.d = jSONObject.optInt("u_dl_st", 3) * 1000;
                        break;
                    case 203:
                        this.a = jSONObject.optInt("u_continue_dl", 0);
                        this.d = jSONObject.optInt("u_continue_dl_st", 10) * 1000;
                        break;
                    case 204:
                        this.a = jSONObject.optInt("u_install_type", 0);
                        this.d = jSONObject.optInt("u_install_wt", 60) * 1000;
                        break;
                    case 205:
                        this.a = jSONObject.optInt("once_acti_win", 0);
                        this.d = jSONObject.optInt("once_acti_win_wt", 300) * 1000;
                        break;
                    case 206:
                        this.a = jSONObject.optInt("sec_acti_win", 0);
                        this.d = jSONObject.optInt("sec_acti_win_wt", 300) * 1000;
                        break;
                }
            } catch (Throwable th) {
                com.baidu.mobads.container.l.g.b(th);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(Context context) {
            try {
                SharedPreferences.Editor editorEdit = context.getSharedPreferences(com.baidu.mobads.container.util.j.d, 0).edit();
                editorEdit.putString("" + this.b, c());
                editorEdit.apply();
            } catch (Throwable th) {
                com.baidu.mobads.container.l.g.b(th);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(Context context) {
            try {
                SharedPreferences.Editor editorEdit = context.getSharedPreferences(com.baidu.mobads.container.util.j.d, 0).edit();
                editorEdit.remove("" + this.b);
                editorEdit.apply();
            } catch (Throwable th) {
                com.baidu.mobads.container.l.g.b(th);
            }
        }

        public static a a(String str) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    JSONObject jSONObject = new JSONObject(str);
                    int i2 = jSONObject.getInt("type");
                    String string = jSONObject.getString("pk");
                    long j = jSONObject.getLong("start");
                    long j2 = jSONObject.getLong(b.e.c);
                    if (!TextUtils.isEmpty(string)) {
                        return new a(string, i2, j, j2);
                    }
                    return null;
                }
                return null;
            } catch (Throwable th) {
                com.baidu.mobads.container.l.g.b(th);
                return null;
            }
        }

        public String c() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("type", this.b);
                jSONObject.put("pk", this.e);
                jSONObject.put("start", this.c);
                jSONObject.put(b.e.c, this.d);
                return jSONObject.toString();
            } catch (Throwable th) {
                com.baidu.mobads.container.l.g.b(th);
                return "";
            }
        }
    }

    private o() {
        this.a = new l();
        this.b = new com.baidu.mobads.container.components.command.a();
        this.c = new j();
        this.d = new HashMap<>();
        this.f = -1;
    }

    public static o a() {
        return d.a;
    }

    public boolean b() {
        if (this.f < 0) {
            if ("0".equals(com.baidu.mobads.container.h.a.a().a("function", com.baidu.mobads.container.h.a.o))) {
                this.f = 0;
            } else {
                this.f = 1;
            }
        }
        return this.f != 0;
    }

    public void a(Context context) {
        this.e = context.getApplicationContext();
        if (!b()) {
            return;
        }
        this.c.a(1000L);
        this.c.a(true);
        com.baidu.mobads.container.components.b.c.a().a(this.e, this.c);
        com.baidu.mobads.container.d.b.a().a(new p(this));
    }

    public void a(int i, com.baidu.mobads.container.components.command.j jVar) {
        if (!b()) {
            return;
        }
        a aVar = this.d.get(200);
        if (aVar == null || aVar.b <= i) {
            a aVar2 = new a(jVar.Z, i, System.currentTimeMillis(), 60000L);
            aVar2.a(jVar);
            aVar2.a(this.e);
            a(aVar2);
        }
    }

    public boolean a(int i, String str) {
        a aVar = this.d.get(200);
        if (aVar != null && aVar.b == i && aVar.f != null && TextUtils.equals(aVar.f.Z, str)) {
            a(200);
            return true;
        }
        return false;
    }

    public void a(int i) {
        a aVarRemove = this.d.remove(Integer.valueOf(i));
        if (aVarRemove != null) {
            if (aVarRemove.g != null) {
                aVarRemove.g.a();
            }
            aVarRemove.b(this.e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a aVar) {
        if (aVar.a == 0) {
            return;
        }
        aVar.g = new q(this, aVar.a(), 0L, 0L, aVar);
        if (aVar.b == 206 || aVar.b == 205) {
            aVar.g.a(1);
        } else {
            aVar.g.a(0);
        }
        this.d.put(200, aVar);
        this.c.a(aVar.g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a aVar, boolean z) {
        try {
            if (b(aVar, z)) {
                this.a.a(this.e, aVar.b, aVar.f, new c(aVar.b, aVar.f));
            }
            a(200);
        } catch (Exception e) {
            a(aVar.b, 404, aVar.f, e.getMessage());
        }
    }

    private boolean b(a aVar, boolean z) {
        int i = aVar.b;
        if (aVar.f == null) {
            a(i, 404, null, "NullDownloadInfo.");
            return false;
        }
        if (!z) {
            a(i, 404, aVar.f, "AppBackground.");
            return false;
        }
        if (!aVar.b()) {
            a(i, 404, aVar.f, "AdExpired.");
            return false;
        }
        if (i == 204) {
            if (com.baidu.mobads.container.util.j.b(this.e, aVar.f.Z)) {
                a(i, 404, aVar.f, "AlreadyInstalled.");
                return false;
            }
            if (aVar.a == 1) {
                new c(i, aVar.f).a();
                return false;
            }
        }
        return true;
    }

    public void a(int i, int i2, com.baidu.mobads.container.components.command.j jVar, String str) {
        this.b.a(this.e, i, i2, jVar, str);
    }
}
