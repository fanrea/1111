package com.bytedance.embedapplog;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.embedapplog.ic;
import com.bytedance.embedapplog.rs;
import com.bytedance.embedapplog.u;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
final class ho {
    private static final List<u> c = new ArrayList();
    static final String d;
    private static final String hc;
    private static long mk;
    private static boolean mq;
    private static String tc;
    private final boolean an;
    private final Context gb;
    private final cj h;
    private Long k;
    private final ic u;
    private Map<String, String> uo;
    private final ReentrantLock b = new ReentrantLock();
    private final AtomicBoolean tt = new AtomicBoolean(false);

    static {
        String str = "ho#";
        hc = str;
        d = str;
    }

    ho(Context context) {
        this.gb = context.getApplicationContext();
        ic icVarD = ec.d(context);
        this.u = icVarD;
        if (icVarD != null) {
            this.an = icVarD.d(context);
        } else {
            this.an = false;
        }
        this.h = new cj(context);
    }

    public Map<String, String> d(long j) {
        if (!this.an) {
            return null;
        }
        if (!d.hc) {
            jm jmVarD = this.h.d();
            if (jmVarD != null) {
                return jmVarD.d();
            }
            return null;
        }
        hc();
        if (this.uo == null) {
            SystemClock.elapsedRealtime();
            try {
                if (this.b.tryLock(j, TimeUnit.MILLISECONDS)) {
                    this.b.unlock();
                }
            } catch (InterruptedException e) {
                um.d(e);
            }
        }
        return this.uo;
    }

    static void d(u uVar) {
        List<u> list = c;
        synchronized (list) {
            list.add(uVar);
        }
        if (tc != null) {
            d(new u.d(tc, mq, mk), new Object[]{uVar});
        }
    }

    public ic d() {
        return this.u;
    }

    private static Object[] b() {
        Object[] array;
        List<u> list = c;
        synchronized (list) {
            array = list.size() > 0 ? list.toArray() : null;
        }
        return array;
    }

    private static void d(u.d dVar, Object[] objArr) {
        if (dVar == null || objArr == null) {
            return;
        }
        for (Object obj : objArr) {
            ((u) obj).d(dVar);
        }
    }

    static void d(JSONObject jSONObject, String str, Object obj) throws JSONException {
        if (TextUtils.isEmpty(str) || obj == null) {
            return;
        }
        try {
            jSONObject.put(str, obj);
        } catch (JSONException e) {
            um.d(e);
        }
    }

    static <K, V> void d(Map<K, V> map, K k, V v) {
        if (k == null || v == null) {
            return;
        }
        map.put(k, v);
    }

    public void hc() {
        if (this.tt.compareAndSet(false, true)) {
            d(new Runnable() { // from class: com.bytedance.embedapplog.ho.1
                @Override // java.lang.Runnable
                public void run() {
                    ho.this.c();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        try {
            this.b.lock();
            jm jmVarD = this.h.d();
            long jLongValue = -1;
            boolean z = false;
            if (jmVarD != null) {
                tc = jmVarD.d;
                mq = jmVarD.b != null && jmVarD.b.booleanValue();
                mk = jmVarD.h == null ? -1L : jmVarD.h.longValue();
                this.uo = jmVarD.d();
            }
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            Pair<String, Boolean> pairD = d(this.gb);
            long jElapsedRealtime2 = SystemClock.elapsedRealtime() - jElapsedRealtime;
            jm jmVar = null;
            String string = null;
            if (pairD.first != null) {
                int iIntValue = -1;
                if (jmVarD != null) {
                    string = jmVarD.hc;
                    iIntValue = jmVarD.an.intValue() + 1;
                }
                if (TextUtils.isEmpty(string)) {
                    string = UUID.randomUUID().toString();
                }
                String str = string;
                if (iIntValue <= 0) {
                    iIntValue = 1;
                }
                jm jmVar2 = new jm((String) pairD.first, str, (Boolean) pairD.second, Long.valueOf(jElapsedRealtime2), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(iIntValue), this.k);
                this.h.d(jmVar2);
                jmVar = jmVar2;
            }
            if (jmVar != null) {
                tc = jmVar.d;
                if (jmVar.b != null && jmVar.b.booleanValue()) {
                    z = true;
                }
                mq = z;
                if (jmVar.h != null) {
                    jLongValue = jmVar.h.longValue();
                }
                mk = jLongValue;
                this.uo = jmVar.d();
            }
        } finally {
            this.b.unlock();
            d(new u.d(tc, mq, mk), b());
        }
    }

    private Pair<String, Boolean> d(Context context) {
        Boolean boolValueOf;
        ic.d dVarHc;
        ic icVar = this.u;
        String str = null;
        if (icVar == null || (dVarHc = icVar.hc(context)) == null) {
            boolValueOf = null;
        } else {
            str = dVarHc.hc;
            boolValueOf = Boolean.valueOf(dVarHc.b);
            if (dVarHc instanceof rs.d) {
                this.k = Long.valueOf(((rs.d) dVarHc).d);
            }
        }
        return new Pair<>(str, boolValueOf);
    }

    private static void d(Runnable runnable) {
        oc.d(d + "-query", runnable);
    }
}
