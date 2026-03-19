package com.qq.e.comm.plugin;

import android.text.TextUtils;
import android.view.View;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class u2 {
    private static volatile u2 c;
    private final Map<Integer, r5> a = new ConcurrentHashMap();
    private final AtomicBoolean b = new AtomicBoolean(false);

    private u2() {
        ru.a();
    }

    public u2 a(View view, h4 h4Var) {
        return a(view, h4Var, (String) null);
    }

    public r5 d(View view) {
        if (view == null) {
            return null;
        }
        r5 r5Var = this.a.get(Integer.valueOf(e(view)));
        if (r5Var == null) {
            ja jaVar = new ja();
            jaVar.a("msg", view.toString());
            z2.a(jaVar);
        }
        return r5Var;
    }

    public String c(View view) {
        return b(view, null, 1);
    }

    public u2 a(View view, h4 h4Var, String str) {
        if (view != null && h4Var != null) {
            int iE = e(view);
            r5 r5Var = new r5(iE, view, h4Var);
            this.a.put(Integer.valueOf(iE), r5Var);
            if (!TextUtils.isEmpty(str)) {
                r5Var.b(str);
            }
            z2.a(view, h4Var);
        } else {
            z2.a(h4Var);
        }
        return this;
    }

    public void b(View view) {
        if (view != null) {
            int iE = e(view);
            r5 r5Var = this.a.get(Integer.valueOf(iE));
            if (r5Var != null) {
                r5Var.f(iE);
                this.a.remove(Integer.valueOf(iE));
            }
        }
    }

    public static int e(View view) {
        return System.identityHashCode(view);
    }

    public void c() {
        b(null, "", 4);
        this.b.compareAndSet(false, true);
    }

    private ij a(View view, String str, int i) {
        if (i != 1 && i != 2) {
            if (i == 4) {
                return new dw(str);
            }
            return null;
        }
        if (view == null) {
            return null;
        }
        r5 r5Var = this.a.get(Integer.valueOf(e(view)));
        if (r5Var != null) {
            return new zc(r5Var, view);
        }
        return null;
    }

    private String b(View view, String str, int i) throws JSONException {
        System.currentTimeMillis();
        ij ijVarA = a(view, str, i);
        String strA = ijVarA != null ? ijVarA.a(i) : "";
        if (TextUtils.isEmpty(strA)) {
            z2.a(i, view == null ? 1 : ijVarA == null ? 2 : 3);
        }
        if (view != null) {
            z2.a(view.getContext(), strA);
        }
        return strA;
    }

    public String a(View view) {
        return b(view, null, 2);
    }

    public boolean b() {
        return this.b.get();
    }

    public String a(String str) throws JSONException {
        String strB = b(null, str, 4);
        return !TextUtils.isEmpty(strB) ? ac.a(strB, "request") : strB;
    }

    public static u2 a() {
        if (c == null) {
            synchronized (u2.class) {
                if (c == null) {
                    c = new u2();
                }
            }
        }
        return c;
    }
}
