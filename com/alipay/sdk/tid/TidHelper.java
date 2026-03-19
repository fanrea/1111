package com.alipay.sdk.tid;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.alipay.sdk.m.q.c;
import com.alipay.sdk.m.s.a;
import com.alipay.sdk.m.s.b;
import com.alipay.sdk.m.u.e;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class TidHelper {
    public static void a(Context context) {
        if (context == null) {
            return;
        }
        b.d().a(context);
    }

    public static Tid b(Context context) throws Exception {
        try {
            com.alipay.sdk.m.p.b bVarA = new c().a(a.h(), context);
            if (bVarA != null) {
                JSONObject jSONObject = new JSONObject(bVarA.a());
                com.alipay.sdk.m.t.a aVarA = com.alipay.sdk.m.t.a.a(context);
                String strOptString = jSONObject.optString("tid");
                String string = jSONObject.getString(com.alipay.sdk.m.t.a.j);
                if (!TextUtils.isEmpty(strOptString) && !TextUtils.isEmpty(string)) {
                    aVarA.a(strOptString, string);
                }
                return a(context, aVarA);
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static void clearTID(Context context) {
        com.alipay.sdk.m.t.a.a(context).a();
    }

    public static String getIMEI(Context context) {
        a(context);
        return com.alipay.sdk.m.u.c.b(context).b();
    }

    public static String getIMSI(Context context) {
        a(context);
        return com.alipay.sdk.m.u.c.b(context).c();
    }

    public static synchronized String getTIDValue(Context context) {
        Tid tidLoadOrCreateTID;
        tidLoadOrCreateTID = loadOrCreateTID(context);
        return Tid.isEmpty(tidLoadOrCreateTID) ? "" : tidLoadOrCreateTID.getTid();
    }

    public static String getVirtualImei(Context context) {
        a(context);
        com.alipay.sdk.m.m.b.b();
        return com.alipay.sdk.m.m.b.f();
    }

    public static String getVirtualImsi(Context context) {
        a(context);
        com.alipay.sdk.m.m.b.b();
        return com.alipay.sdk.m.m.b.g();
    }

    public static Tid loadLocalTid(Context context) {
        com.alipay.sdk.m.t.a aVarA = com.alipay.sdk.m.t.a.a(context);
        if (aVarA.h()) {
            return null;
        }
        return new Tid(aVarA.d(), aVarA.c(), aVarA.e().longValue());
    }

    public static synchronized Tid loadOrCreateTID(Context context) {
        e.b(com.alipay.sdk.m.l.a.A, "load_create_tid");
        a(context);
        Tid tidLoadTID = loadTID(context);
        if (Tid.isEmpty(tidLoadTID)) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                return null;
            }
            try {
                tidLoadTID = b(context);
            } catch (Throwable unused) {
            }
        }
        return tidLoadTID;
    }

    public static Tid loadTID(Context context) {
        a(context);
        Tid tidA = a(context, com.alipay.sdk.m.t.a.a(context));
        if (tidA == null) {
            e.b(com.alipay.sdk.m.l.a.A, "load_tid null");
        }
        return tidA;
    }

    public static boolean resetTID(Context context) throws Exception {
        e.b(com.alipay.sdk.m.l.a.A, "reset_tid");
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new Exception("Must be called on worker thread");
        }
        a(context);
        clearTID(context);
        Tid tidB = null;
        try {
            tidB = b(context);
        } catch (Throwable unused) {
        }
        return !Tid.isEmpty(tidB);
    }

    public static Tid a(Context context, com.alipay.sdk.m.t.a aVar) {
        if (aVar == null || aVar.i()) {
            return null;
        }
        return new Tid(aVar.d(), aVar.c(), aVar.e().longValue());
    }
}
