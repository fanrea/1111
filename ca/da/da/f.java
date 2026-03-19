package ca.da.da;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.SystemClock;
import com.apm.applog.AppLog;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* compiled from: Dr.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public final class f {
    public static final String a = "f#";
    public static b<m> b = new a();

    /* compiled from: Dr.java */
    public static class a extends b<m> {
        @Override // ca.da.da.b
        public m a(Object[] objArr) {
            return new m((Context) objArr[0]);
        }
    }

    public static String a(SharedPreferences sharedPreferences) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        String strB = d.a.b(sharedPreferences);
        String str = a + "getCdid takes " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms";
        return strB;
    }

    public static void b(ca.da.ca.e eVar) {
        m.b(eVar);
    }

    public static boolean b(Context context) {
        return AppLog.isOAIdEnabled() && b.b(context).c;
    }

    public static Map a(Context context) {
        Map<String, String> map;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        boolean zTryLock = false;
        m mVarB = b.b(context);
        if (mVarB.c) {
            mVarB.a();
            String str = "Oaid#getOaid timeoutMills=100";
            if (mVarB.g == null) {
                long jElapsedRealtime2 = SystemClock.elapsedRealtime();
                try {
                    try {
                        zTryLock = mVarB.a.tryLock(100L, TimeUnit.MILLISECONDS);
                        String str2 = "Oaid#getOaid locked=" + zTryLock + ", took " + (SystemClock.elapsedRealtime() - jElapsedRealtime2) + " ms";
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        if (zTryLock) {
                        }
                    }
                    if (zTryLock) {
                        mVarB.a.unlock();
                    }
                } catch (Throwable th) {
                    if (zTryLock) {
                        mVarB.a.unlock();
                    }
                    throw th;
                }
            }
            ca.ca.ca.ca.a.a("Oaid#getOaid return apiMap=").append(mVarB.g).toString();
            map = mVarB.g;
        } else {
            map = null;
        }
        String str3 = a + "getOaid takes " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms";
        return map;
    }

    public static String a(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optString("id", null);
        }
        return null;
    }

    public static void a(ca.da.ca.e eVar) {
        m.a(eVar);
    }
}
