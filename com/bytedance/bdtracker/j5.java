package com.bytedance.bdtracker;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.applog.IOaidObserver;
import com.bytedance.applog.log.LoggerImpl;
import com.bytedance.bdtracker.e0;
import com.bytedance.dr.OaidApi;
import com.bytedance.dr.OaidFactory;
import com.bytedance.dr.impl.e;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class j5 {
    public static final String h;
    public static final String i;
    public static final List<IOaidObserver> j = new ArrayList();
    public static g k;
    public static String l;
    public static Map<String, String> m;
    public final OaidApi b;
    public final boolean c;
    public final l5 d;
    public final Context e;
    public Long g;
    public final ReentrantLock a = new ReentrantLock();
    public final AtomicBoolean f = new AtomicBoolean(false);

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            j5.this.b();
        }
    }

    static {
        String str = "j5#";
        h = str;
        i = str;
    }

    public j5(Context context) {
        this.e = context.getApplicationContext();
        OaidApi oaidApiCreateOaidImpl = OaidFactory.createOaidImpl(context);
        this.b = oaidApiCreateOaidImpl;
        if (oaidApiCreateOaidImpl != null) {
            this.c = oaidApiCreateOaidImpl.support(context);
        } else {
            this.c = false;
        }
        this.d = new l5(context);
    }

    public static void a(IOaidObserver.Oaid oaid, Object[] objArr) {
        if (oaid == null || objArr == null) {
            return;
        }
        for (Object obj : objArr) {
            ((IOaidObserver) obj).onOaidLoaded(oaid);
        }
    }

    public static void a(IOaidObserver iOaidObserver) {
        g gVar;
        List<IOaidObserver> list = j;
        synchronized (list) {
            list.add(iOaidObserver);
        }
        String str = l;
        if (str != null) {
            a(new IOaidObserver.Oaid(str), new Object[]{iOaidObserver});
        }
        Map<String, String> map = m;
        if (map == null || (gVar = k) == null) {
            return;
        }
        ((e0.b) gVar).a(map);
    }

    public static <K, V> void a(Map<K, V> map, K k2, V v) {
        if (k2 == null || v == null) {
            return;
        }
        map.put(k2, v);
    }

    public static void a(JSONObject jSONObject, String str, Object obj) {
        if (TextUtils.isEmpty(str) || obj == null) {
            return;
        }
        try {
            jSONObject.put(str, obj);
        } catch (Throwable th) {
            LoggerImpl.global().error(1, "JSON put failed", th, new Object[0]);
        }
    }

    public static void b(IOaidObserver iOaidObserver) {
        List<IOaidObserver> list = j;
        synchronized (list) {
            list.remove(iOaidObserver);
        }
    }

    public static Object[] c() {
        Object[] array;
        List<IOaidObserver> list = j;
        synchronized (list) {
            array = list.size() > 0 ? list.toArray() : null;
        }
        return array;
    }

    public void a() {
        if (this.f.compareAndSet(false, true)) {
            a aVar = new a();
            String str = i + "-query";
            if (TextUtils.isEmpty(str)) {
                str = "TrackerDr";
            }
            new Thread(new i5(aVar, str), str).start();
        }
    }

    public final void b() {
        String str;
        Boolean boolValueOf;
        OaidApi.a oaid;
        LoggerImpl.global().debug(1, "Oaid#initOaid", new Object[0]);
        try {
            this.a.lock();
            LoggerImpl.global().debug(1, "Oaid#initOaid exec", new Object[0]);
            k5 k5VarA = this.d.a();
            LoggerImpl.global().debug(1, "Oaid#initOaid fetch={}", k5VarA);
            if (k5VarA != null) {
                l = k5VarA.a;
                m = k5VarA.a();
            }
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            Context context = this.e;
            OaidApi oaidApi = this.b;
            k5 k5Var = null;
            String string = null;
            if (oaidApi == null || (oaid = oaidApi.getOaid(context)) == null) {
                str = null;
                boolValueOf = null;
            } else {
                str = oaid.a;
                boolValueOf = Boolean.valueOf(oaid.b);
                if (oaid instanceof e.b) {
                    this.g = Long.valueOf(((e.b) oaid).c);
                }
            }
            Pair pair = new Pair(str, boolValueOf);
            long jElapsedRealtime2 = SystemClock.elapsedRealtime() - jElapsedRealtime;
            if (pair.first != null) {
                int iIntValue = -1;
                if (k5VarA != null) {
                    string = k5VarA.b;
                    iIntValue = k5VarA.f.intValue() + 1;
                }
                if (TextUtils.isEmpty(string)) {
                    string = UUID.randomUUID().toString();
                }
                String str2 = string;
                if (iIntValue <= 0) {
                    iIntValue = 1;
                }
                k5 k5Var2 = new k5((String) pair.first, str2, (Boolean) pair.second, Long.valueOf(jElapsedRealtime2), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(iIntValue), this.g);
                this.d.a(k5Var2);
                k5Var = k5Var2;
            }
            if (k5Var != null) {
                l = k5Var.a;
                m = k5Var.a();
            }
            LoggerImpl.global().debug(1, "Oaid#initOaid oaidModel={}", k5Var);
        } finally {
            this.a.unlock();
            a(new IOaidObserver.Oaid(l), c());
            g gVar = k;
            if (gVar != null) {
                ((e0.b) gVar).a(m);
            }
        }
    }
}
