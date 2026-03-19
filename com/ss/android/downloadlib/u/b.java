package com.ss.android.downloadlib.u;

import android.text.TextUtils;
import android.util.Log;
import com.ss.android.downloadlib.addownload.mq;
import com.ss.android.downloadlib.h.uo;
import com.ss.android.socialbase.appdownloader.an.an;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class b implements com.ss.android.d.d.c.d {

    private static class d {
        private static b d = new b();
    }

    public static b d() {
        return d.d;
    }

    @Override // com.ss.android.d.d.c.d
    public void d(Throwable th, String str) throws JSONException {
        d(true, th, str);
    }

    public void d(boolean z, Throwable th, String str) throws JSONException {
        if (hc()) {
            return;
        }
        if (th == null) {
            th = new Throwable();
        }
        if (z) {
            hc(th);
        }
        JSONObject jSONObject = new JSONObject();
        if (TextUtils.isEmpty(str)) {
            str = th.getMessage();
        }
        uo.d(jSONObject, "msg", str);
        uo.d(jSONObject, "stack", Log.getStackTraceString(th));
        mq.gb();
    }

    public void d(String str) throws JSONException {
        d(true, str);
    }

    public void d(boolean z, String str) throws JSONException {
        if (hc()) {
            return;
        }
        if (z) {
            hc(new RuntimeException(str));
        }
        JSONObject jSONObject = new JSONObject();
        uo.d(jSONObject, "msg", str);
        uo.d(jSONObject, "stack", d(new Throwable()));
        mq.gb();
    }

    public void hc(String str) throws JSONException {
        hc(true, str);
    }

    public void hc(boolean z, String str) throws JSONException {
        if (hc()) {
            return;
        }
        if (z) {
            hc(new RuntimeException(str));
        }
        JSONObject jSONObject = new JSONObject();
        uo.d(jSONObject, "msg", str);
        uo.d(jSONObject, "stack", d(new Throwable()));
        mq.gb();
    }

    private void hc(Throwable th) {
        if (an.hc(mq.getContext())) {
            throw new com.ss.android.downloadlib.u.d(th);
        }
    }

    public static String d(Throwable th) {
        try {
            return Log.getStackTraceString(th);
        } catch (Exception unused) {
            return null;
        }
    }

    private boolean hc() {
        return mq.tt().optInt("enable_monitor", 1) != 1;
    }
}
