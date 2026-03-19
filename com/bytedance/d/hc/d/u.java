package com.bytedance.d.hc.d;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Looper;
import android.os.Process;
import com.bytedance.d.hc.gb.k;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class u {
    public static JSONObject d(boolean z) throws JSONException {
        StackTraceElement[] stackTrace = Looper.getMainLooper().getThread().getStackTrace();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("thread_number", 1);
        jSONObject.put("mainStackFromTrace", k.d(stackTrace));
        return jSONObject;
    }

    static String d(Context context, int i) {
        ActivityManager.ProcessErrorStateInfo processErrorStateInfoD = com.bytedance.d.hc.gb.d.d(context, i);
        if (processErrorStateInfoD == null || Process.myPid() != processErrorStateInfoD.pid) {
            return null;
        }
        return hc.d(processErrorStateInfoD);
    }
}
