package ca.da.da;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import ca.da.ca.e;
import ca.da.da.h;
import ca.da.da.n;
import com.bytedance.common.utility.DeviceUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Oaid.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public final class m {
    public static final String i;
    public static final String j;
    public static final List<ca.da.ca.e> k = new ArrayList();
    public static String l;
    public final n b;
    public final boolean c;
    public final p d;
    public final Context e;
    public Map<String, String> g;
    public Long h;
    public final ReentrantLock a = new ReentrantLock();
    public final AtomicBoolean f = new AtomicBoolean(false);

    /* compiled from: Oaid.java */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            m.this.b();
        }
    }

    static {
        String str = "m#";
        i = str;
        j = str;
    }

    public m(Context context) throws IOException {
        this.e = context.getApplicationContext();
        n hVar = null;
        if (ca.da.ca.ja.p.c()) {
            hVar = new r(new w());
        } else if (w.a()) {
            hVar = new w();
        } else if (q.a()) {
            hVar = new q();
        } else if (ca.da.ca.ja.p.b().toUpperCase().contains("HUAWEI") || ca.da.ca.ja.p.e()) {
            hVar = new h();
        } else if ("OnePlus".equalsIgnoreCase(Build.MANUFACTURER)) {
            hVar = new r(null);
        } else {
            String str = Build.BRAND;
            if (str == null ? false : str.toLowerCase(Locale.ENGLISH).contains("meizu")) {
                hVar = new k();
            } else if (Build.VERSION.SDK_INT > 28) {
                boolean zContains = true;
                if (DeviceUtils.ROM_SAMSUNG.equalsIgnoreCase(Build.BRAND) || DeviceUtils.ROM_SAMSUNG.equalsIgnoreCase(Build.MANUFACTURER)) {
                    hVar = new u();
                } else if (ca.da.ca.ja.p.b().toUpperCase().contains("NUBIA")) {
                    hVar = new l();
                } else {
                    String str2 = Build.FINGERPRINT;
                    if (TextUtils.isEmpty(str2)) {
                        String strA = ca.da.ca.ja.p.a("ro.build.version.incremental");
                        if (TextUtils.isEmpty(strA) || !strA.contains("VIBEUI_V2")) {
                            zContains = false;
                        }
                    } else {
                        zContains = str2.contains("VIBEUI_V2");
                    }
                    hVar = zContains ? new j() : ca.da.ca.ja.p.b().toUpperCase().contains("ASUS") ? new ca.da.da.a() : new e();
                }
            } else if (!ca.da.ca.ja.p.f() && h.c(context)) {
                hVar = new h();
            }
        }
        this.b = hVar;
        if (hVar != null) {
            this.c = hVar.b(context);
        } else {
            this.c = false;
        }
        this.d = new p(context);
    }

    public static void b(ca.da.ca.e eVar) {
        List<ca.da.ca.e> list = k;
        synchronized (list) {
            list.add(eVar);
        }
        String str = l;
        if (str != null) {
            a(new e.a(str), new Object[]{eVar});
        }
    }

    public static Object[] c() {
        Object[] array;
        List<ca.da.ca.e> list = k;
        synchronized (list) {
            array = list.size() > 0 ? list.toArray() : null;
        }
        return array;
    }

    public static void a(ca.da.ca.e eVar) {
        List<ca.da.ca.e> list = k;
        synchronized (list) {
            list.remove(eVar);
        }
    }

    public static void a(e.a aVar, Object[] objArr) {
        if (aVar == null || objArr == null) {
            return;
        }
        for (Object obj : objArr) {
            ((ca.da.ca.e) obj).a(aVar);
        }
    }

    public static void a(JSONObject jSONObject, String str, Object obj) throws JSONException {
        if (TextUtils.isEmpty(str) || obj == null) {
            return;
        }
        try {
            jSONObject.put(str, obj);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public final void b() {
        String str;
        Boolean boolValueOf;
        n.a aVarA;
        try {
            this.a.lock();
            o oVarA = this.d.a();
            String str2 = "Oaid#initOaid fetch=" + oVarA;
            if (oVarA != null) {
                l = oVarA.a;
                this.g = oVarA.a();
            }
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            Context context = this.e;
            n nVar = this.b;
            o oVar = null;
            String string = null;
            if (nVar == null || (aVarA = nVar.a(context)) == null) {
                str = null;
                boolValueOf = null;
            } else {
                str = aVarA.a;
                boolValueOf = Boolean.valueOf(aVarA.b);
                if (aVarA instanceof h.b) {
                    this.h = Long.valueOf(((h.b) aVarA).c);
                }
            }
            Pair pair = new Pair(str, boolValueOf);
            long jElapsedRealtime2 = SystemClock.elapsedRealtime() - jElapsedRealtime;
            if (pair.first != null) {
                int iIntValue = -1;
                int i2 = 1;
                if (oVarA != null) {
                    string = oVarA.b;
                    iIntValue = oVarA.f.intValue() + 1;
                }
                if (TextUtils.isEmpty(string)) {
                    string = UUID.randomUUID().toString();
                }
                if (iIntValue > 0) {
                    i2 = iIntValue;
                }
                o oVar2 = new o((String) pair.first, string, (Boolean) pair.second, Long.valueOf(jElapsedRealtime2), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(i2), this.h);
                this.d.a(oVar2);
                oVar = oVar2;
            }
            if (oVar != null) {
                l = oVar.a;
                this.g = oVar.a();
            }
            String str3 = "Oaid#initOaid oaidModel=" + oVar;
        } finally {
            this.a.unlock();
            a(new e.a(l), c());
        }
    }

    public static <K, V> void a(Map<K, V> map, K k2, V v) {
        if (k2 == null || v == null) {
            return;
        }
        map.put(k2, v);
    }

    public void a() {
        if (this.f.compareAndSet(false, true)) {
            a aVar = new a();
            String strA = ca.ca.ca.ca.a.a(new StringBuilder(), j, "-query");
            if (TextUtils.isEmpty(strA)) {
                strA = "TrackerDr";
            }
            new Thread(new g(aVar, strA), strA).start();
        }
    }
}
