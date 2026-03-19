package com.qq.e.comm.plugin;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class rb {
    private final ExecutorService a;
    private HashSet<Integer> c;
    private HashSet<Integer> d;
    private final Context b = r1.d().a();
    private final Map<String, JSONObject> e = new ConcurrentHashMap();

    public rb(ExecutorService executorService) {
        this.a = executorService;
        c();
        b();
        if (yb.a("hasp", false)) {
            return;
        }
        yb.b("hasp", true);
    }

    private void c() {
        this.c = a(r1.d().f().b("eeiwlst", ""));
        this.d = a(r1.d().f().b("eeiblst", ""));
    }

    /* compiled from: A */
    class a implements Runnable {
        final /* synthetic */ qc a;

        a(qc qcVar) {
            this.a = qcVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            qb.a(rb.this.b).b(this.a);
        }
    }

    /* compiled from: A */
    class b implements Runnable {
        final /* synthetic */ int[] a;

        b(int[] iArr) {
            this.a = iArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            qb.a(rb.this.b).a(this.a);
        }
    }

    public void a(qc qcVar, boolean z) {
        if ((!z || this.d.contains(Integer.valueOf(qcVar.c()))) && !this.c.contains(Integer.valueOf(qcVar.c()))) {
            return;
        }
        this.a.submit(new a(qcVar));
    }

    private String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return yb.a(str, (String) null);
    }

    private void b() {
        if (System.currentTimeMillis() - yb.a("lddtime", 0L) < 86400000) {
            return;
        }
        String strB = r1.d().f().b("emded", "");
        try {
            if (TextUtils.isEmpty(strB)) {
                return;
            }
            String[] strArrSplit = strB.split(",");
            int[] iArr = new int[strArrSplit.length];
            for (int i = 0; i < strArrSplit.length; i++) {
                iArr[i] = Integer.parseInt(strArrSplit[i]);
            }
            yb.b("lddtime", System.currentTimeMillis());
            a(iArr);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    /* compiled from: A */
    class c implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            yb.a();
            qb.a(r1.d().a()).a((int[]) null);
        }

        c() {
        }
    }

    public void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.e.remove(str);
        yb.a(str);
    }

    private void a(int[] iArr) {
        this.a.submit(new b(iArr));
    }

    private HashSet<Integer> a(String str) {
        String[] strArrSplit;
        HashSet<Integer> hashSet = new HashSet<>();
        if (TextUtils.isEmpty(str)) {
            return hashSet;
        }
        try {
            strArrSplit = str.split(",");
        } catch (Exception e) {
            e.getMessage();
        }
        if (strArrSplit != null && strArrSplit.length > 0) {
            for (String str2 : strArrSplit) {
                hashSet.add(Integer.valueOf(Integer.parseInt(str2)));
            }
            return hashSet;
        }
        return hashSet;
    }

    public JSONObject a(String str, String str2, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObjectA = this.e.get(str);
        if (jSONObjectA == null) {
            String strB = b(str);
            if (!TextUtils.isEmpty(strB)) {
                jSONObjectA = new jn(strB).a();
            }
        }
        if (jSONObjectA == null) {
            return null;
        }
        if (!z || (!TextUtils.isEmpty(str2) && str2.equals(jSONObjectA.optString("ph")))) {
            return jSONObjectA;
        }
        c(str);
        return null;
    }

    public boolean a(JSONObject jSONObject, int i) {
        if (jSONObject == null) {
            return false;
        }
        int iOptInt = jSONObject.optInt("iv", 0);
        if (iOptInt != 0) {
            i = iOptInt;
        }
        long jOptLong = jSONObject.optLong(com.baidu.mobads.container.components.command.j.s, 0L);
        return i > 0 ? jOptLong + (((long) i) * 1000) > System.currentTimeMillis() : k20.a(i + 1) < jOptLong;
    }

    public void a(String str, JSONObject jSONObject) {
        this.e.put(str, jSONObject);
    }

    public static void a() {
        if (yb.a("hasp", false)) {
            qg.b.submit(new c());
        }
    }
}
