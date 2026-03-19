package com.qq.e.comm.plugin;

import android.text.TextUtils;
import android.util.LruCache;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class a50 {
    public static int b = 10;
    public static boolean c;
    public static int d;
    public static boolean e;
    private static volatile a50 f;
    private final LruCache<String, z40> a = new a(b);

    /* compiled from: A */
    public interface b {
        void a(int i, int i2);
    }

    static {
        e = r1.d().f().a("dlvrcnf", 0) == 1;
    }

    public static a50 a() {
        if (f == null) {
            synchronized (a50.class) {
                if (f == null) {
                    f = new a50();
                }
            }
        }
        return f;
    }

    public synchronized im a(String str, b bVar) {
        if (!c && g7.g.b) {
            z40 z40Var = this.a.get(str);
            if (z40Var == null) {
                bVar.a(1, 0);
                return null;
            }
            im imVarD = z40Var.d();
            if (imVarD == null) {
                bVar.a(2, z40Var.b());
                return null;
            }
            bVar.a(3, z40Var.b());
            return imVarD;
        }
        bVar.a(0, 0);
        return null;
    }

    public synchronized void a(String str, int i, im imVar, int i2) {
        if (!c && !TextUtils.isEmpty(str) && imVar != null) {
            z40 z40Var = this.a.get(str);
            if (z40Var == null) {
                this.a.put(str, new z40(str, i, imVar, i2));
            } else {
                z40Var.a(imVar);
            }
        }
    }

    public synchronized boolean a(String str, int i) {
        if (c) {
            return false;
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        z40 z40Var = this.a.get(str);
        if (z40Var == null) {
            return true;
        }
        if (z40Var.c() != i) {
            this.a.remove(str);
            return true;
        }
        return z40Var.e();
    }

    private a50() {
    }

    /* compiled from: A */
    class a extends LruCache<String, z40> {
        a(int i) {
            super(i);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.util.LruCache
        public void entryRemoved(boolean z, String str, z40 z40Var, z40 z40Var2) {
            super.entryRemoved(z, (boolean) str, z40Var, z40Var2);
            synchronized (a50.this) {
                if (z40Var != null) {
                    z40Var.a();
                }
            }
        }
    }
}
