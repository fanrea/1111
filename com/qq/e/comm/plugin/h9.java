package com.qq.e.comm.plugin;

import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import yaq.pro;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class h9 {
    private static final String g = "kg";
    private static final h9 h = new h9();
    private final Map<String, i9> a = new ConcurrentHashMap();
    private final AtomicBoolean b = new AtomicBoolean(false);
    private final AtomicBoolean c = new AtomicBoolean(false);
    private final AtomicBoolean d = new AtomicBoolean(true);
    private volatile int e = -1;
    private volatile int f = -1;

    private void a(i9 i9Var, i9 i9Var2) {
        pro.getVresult(610, 0, this, i9Var, i9Var2);
    }

    public static h9 c() {
        return h;
    }

    private void d(String str) throws JSONException {
        ja jaVar = new ja();
        jaVar.a("data", str);
        b10.a(9130079, null, 1, null, jaVar);
    }

    public void a() {
        pro.getVresult(611, 0, this);
    }

    public void a(boolean z) {
        pro.getVresult(612, 0, this, Boolean.valueOf(z));
    }

    private boolean c(String str) {
        i9 i9Var;
        long jA = r1.d().f().a("ecdrt", 0) * 1000;
        return jA > 0 && (i9Var = this.a.get(str)) != null && (System.currentTimeMillis() - i9Var.d) - (i9Var.c * 1000) > jA;
    }

    private h9() {
    }

    private boolean b() {
        if (this.f < 0) {
            this.f = r1.d().f().a("prhcdr", 0);
        }
        return this.f > 0;
    }

    private boolean b(String str) {
        i9 i9Var = this.a.get(str);
        if (i9Var != null) {
            double dCurrentTimeMillis = System.currentTimeMillis() - i9Var.d;
            double d = i9Var.c * 1000;
            Double.isNaN(d);
            if (dCurrentTimeMillis > d * 0.8d) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    List<String> a(String str) {
        i9 i9Var = this.a.get(str);
        boolean zCompareAndSet = this.d.compareAndSet(true, false);
        ?? r1 = zCompareAndSet;
        if (zCompareAndSet) {
            r1 = zCompareAndSet;
            if (kg.d().n()) {
                r1 = 2;
            }
        }
        int iG = (r1 * 10) + kg.d().g();
        if (i9Var != null) {
            if (i9Var.e == 3 && kg.d().b() <= 1 && kg.d().u()) {
                i9Var.e = 2;
                if (this.e < 0) {
                    this.e = r1.d().f().a("fsdcht", 5);
                }
                i9Var.c = this.e;
            }
            ArrayList arrayList = new ArrayList(i9Var.a());
            boolean zB = b(str);
            if (zB) {
                long j = i9Var.d;
                long j2 = i9Var.c;
                if (kg.d().b() > 1) {
                    kg.d().a(false);
                    if (c(str)) {
                        long j3 = i9Var.d;
                        long j4 = i9Var.c;
                        this.a.remove(str);
                    }
                } else if (kg.d().u()) {
                    this.a.remove(str);
                    kg.d().r();
                }
            }
            j9.a(iG, zB, str);
            return arrayList;
        }
        j9.a(iG, str);
        return null;
    }

    public void a(String str, List<String> list, long j, int i) {
        if (TextUtils.isEmpty(str) || list == null || list.isEmpty()) {
            return;
        }
        i9 i9Var = this.a.get(str);
        if (i9Var != null && i9Var.e == 1 && i == 2) {
            qm$h$$ExternalSyntheticBackport0.m(i9Var);
            return;
        }
        synchronized (this) {
            i9 i9Var2 = this.a.get(str);
            if (i9Var2 != null && i9Var2.e == 1 && i == 2) {
                qm$h$$ExternalSyntheticBackport0.m(i9Var2);
            } else {
                qm$h$$ExternalSyntheticBackport0.m(list);
                i9 i9Var3 = new i9();
                i9Var3.a = str;
                i9Var3.c = j;
                i9Var3.d = System.currentTimeMillis();
                CopyOnWriteArrayList<gl> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
                Iterator<String> it = list.iterator();
                while (it.hasNext()) {
                    copyOnWriteArrayList.add(new gl(it.next()));
                }
                i9Var3.b = copyOnWriteArrayList;
                i9Var3.e = i;
                this.a.put(str, i9Var3);
                a(i9Var2, i9Var3);
            }
        }
    }

    private void a(Exception exc) throws JSONException {
        ja jaVar = new ja();
        jaVar.a("data", Log.getStackTraceString(exc));
        b10.a(9130079, null, 2, null, jaVar);
    }
}
