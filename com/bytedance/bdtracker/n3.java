package com.bytedance.bdtracker;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.applog.profile.UserProfileCallback;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class n3 implements Runnable {
    public static final Handler g = new Handler(Looper.getMainLooper());
    public final String a;
    public final String b;
    public final JSONObject c;
    public final UserProfileCallback d;
    public final Context e;
    public final d f;

    public n3(d dVar, String str, String str2, JSONObject jSONObject, UserProfileCallback userProfileCallback, Context context) {
        this.f = dVar;
        this.a = str;
        this.b = str2;
        this.c = jSONObject;
        this.d = userProfileCallback;
        this.e = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (!s4.b(this.e)) {
                g.post(new l3(this, 0));
                return;
            }
            HashMap map = new HashMap();
            map.put("Content-Type", "application/json");
            map.put("X-APIKEY", this.b);
            this.f.getNetClient().execute((byte) 1, this.a, this.c, map, (byte) 0, false, 60000);
            g.post(new m3(this));
        } catch (Throwable th) {
            this.f.D.error(9, "Report profile failed", th, new Object[0]);
            g.post(new l3(this, 1));
        }
    }
}
