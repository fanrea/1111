package ca.da.ca.fa;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.applog.util.SensitiveUtils;
import org.json.JSONObject;

/* compiled from: AppKeyLoader.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class a extends c {
    public Context e;

    public a(Context context) {
        super(true, false);
        this.e = context;
    }

    @Override // ca.da.ca.fa.c
    public boolean a(JSONObject jSONObject) {
        try {
            Bundle bundle = this.e.getPackageManager().getApplicationInfo(this.e.getPackageName(), 128).metaData;
            if (bundle == null || TextUtils.isEmpty(SensitiveUtils.CHANNEL_APP_KEY)) {
                return true;
            }
            jSONObject.put(com.alipay.sdk.m.s.a.r, bundle.getString(SensitiveUtils.CHANNEL_APP_KEY));
            return true;
        } catch (Throwable unused) {
            return true;
        }
    }
}
