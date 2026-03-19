package com.bytedance.bdtracker;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.applog.log.LoggerImpl;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class x1 extends l1 {
    public final Context e;
    public final q1 f;

    public x1(Context context, q1 q1Var) {
        super(false, false);
        this.e = context;
        this.f = q1Var;
    }

    @Override // com.bytedance.bdtracker.l1
    public String a() {
        return "Gaid";
    }

    @Override // com.bytedance.bdtracker.l1
    public boolean a(JSONObject jSONObject) {
        if (!this.f.c.isGaidEnabled()) {
            return true;
        }
        String googleAid = this.f.c.getGoogleAid();
        if (TextUtils.isEmpty(googleAid)) {
            try {
                googleAid = p4.a(this.e, this.f);
            } catch (InterruptedException | ExecutionException | Exception unused) {
            } catch (TimeoutException e) {
                LoggerImpl.global().error("Query Gaid Timeout", e, new Object[0]);
            }
        }
        s1.a(jSONObject, "google_aid", googleAid);
        return true;
    }
}
