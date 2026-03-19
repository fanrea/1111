package ca.da.ca.ia;

import android.os.Handler;
import android.text.TextUtils;
import ca.da.ca.ja.t;

/* compiled from: CacheHelper.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public abstract class c {
    public c a;
    public Handler b;

    /* compiled from: CacheHelper.java */
    public interface d<L> {
        L a();

        L a(L l, L l2, c cVar);

        boolean a(L l);

        boolean a(L l, L l2);

        void b(L l);
    }

    public void a(String str) {
        c cVar = this.a;
        if (cVar != null) {
            cVar.a(str);
        }
    }

    public abstract void a(String str, String str2);

    public abstract String b(String str);

    public String b(String str, String str2) {
        return (String) a(str, str2, new b());
    }

    public String c(String str, String str2) {
        return (String) a(str, str2, new C0030c());
    }

    public String d(String str, String str2) {
        return (String) a(str, str2, new a());
    }

    /* compiled from: CacheHelper.java */
    public class a implements d<String> {
        public a() {
        }

        @Override // ca.da.ca.ia.c.d
        public boolean a(String str) {
            return t.b(str);
        }

        @Override // ca.da.ca.ia.c.d
        public void b(String str) {
            c.this.a("openudid", str);
        }

        @Override // ca.da.ca.ia.c.d
        public boolean a(String str, String str2) {
            return t.a(str, str2);
        }

        @Override // ca.da.ca.ia.c.d
        public String a(String str, String str2, c cVar) {
            String str3 = str;
            return cVar == null ? str3 : cVar.d(str3, str2);
        }

        @Override // ca.da.ca.ia.c.d
        public String a() {
            return c.this.b("openudid");
        }
    }

    /* compiled from: CacheHelper.java */
    public class b implements d<String> {
        public b() {
        }

        @Override // ca.da.ca.ia.c.d
        public boolean a(String str) {
            return t.b(str);
        }

        @Override // ca.da.ca.ia.c.d
        public void b(String str) {
            c.this.a("clientudid", str);
        }

        @Override // ca.da.ca.ia.c.d
        public boolean a(String str, String str2) {
            return t.a(str, str2);
        }

        @Override // ca.da.ca.ia.c.d
        public String a(String str, String str2, c cVar) {
            String str3 = str;
            return cVar == null ? str3 : cVar.b(str3, str2);
        }

        @Override // ca.da.ca.ia.c.d
        public String a() {
            return c.this.b("clientudid");
        }
    }

    /* compiled from: CacheHelper.java */
    /* renamed from: ca.da.ca.ia.c$c, reason: collision with other inner class name */
    public class C0030c implements d<String> {
        public C0030c() {
        }

        @Override // ca.da.ca.ia.c.d
        public boolean a(String str) {
            return !TextUtils.isEmpty(str);
        }

        @Override // ca.da.ca.ia.c.d
        public void b(String str) {
            c.this.a(com.baidu.mobads.upgrade.remote.gray.c.l, str);
        }

        @Override // ca.da.ca.ia.c.d
        public boolean a(String str, String str2) {
            return t.a(str, str2);
        }

        @Override // ca.da.ca.ia.c.d
        public String a(String str, String str2, c cVar) {
            String str3 = str;
            return cVar == null ? str3 : cVar.c(str3, str2);
        }

        @Override // ca.da.ca.ia.c.d
        public String a() {
            return c.this.b(com.baidu.mobads.upgrade.remote.gray.c.l);
        }
    }

    public final <T> T a(T t, T t2, d<T> dVar) {
        if (dVar != null) {
            c cVar = this.a;
            T tA = dVar.a();
            boolean zA = dVar.a(t);
            boolean zA2 = dVar.a(tA);
            if (!zA && zA2) {
                t = tA;
            }
            if (cVar != null) {
                T tA2 = dVar.a(t, t2, cVar);
                if (!dVar.a(tA2, tA)) {
                    dVar.b(tA2);
                }
                return tA2;
            }
            boolean z = false;
            if (zA || zA2) {
                t2 = t;
            } else {
                z = true;
            }
            if ((z && dVar.a(t2)) || (zA && !dVar.a(t2, tA))) {
                dVar.b(t2);
            }
            return t2;
        }
        throw new IllegalArgumentException("agent == null");
    }

    public void a(Handler handler) {
        c cVar = this.a;
        if (cVar != null) {
            cVar.a(handler);
        }
        this.b = handler;
    }
}
