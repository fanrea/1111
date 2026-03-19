package ca.da.ca.ja;

import org.json.JSONArray;

/* compiled from: EventsSenderUtils.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class i {
    public static l a;

    static {
        l lVar;
        try {
            Object objInvoke = Class.forName("com.bytedance.applog.et_verify.EventVerify").getMethod("inst", new Class[0]).invoke(null, new Object[0]);
            lVar = objInvoke instanceof l ? (l) objInvoke : null;
        } catch (Exception unused) {
            lVar = null;
        } catch (Throwable th) {
            r.a("can't find event verify, should compile with ET", (Throwable) null);
            throw th;
        }
        if (lVar == null) {
            r.a("can't find event verify, should compile with ET", (Throwable) null);
        } else {
            r.a(lVar.toString());
        }
        a = lVar;
    }

    public static void a(String str, JSONArray jSONArray) {
        l lVar = a;
        if (lVar != null) {
            lVar.a(str, jSONArray);
        }
    }

    public static boolean a() {
        l lVar = a;
        if (lVar != null) {
            return lVar.a();
        }
        return false;
    }
}
