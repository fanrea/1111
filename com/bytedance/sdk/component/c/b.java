package com.bytedance.sdk.component.c;

import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.openadsdk.ats.ATSApi;
import com.bytedance.sdk.openadsdk.ats.ATSMethod;
import org.json.JSONObject;

@ATSApi(NotificationCompat.CATEGORY_EVENT)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public interface b {
    @ATSMethod(2)
    void d(String str, JSONObject jSONObject);

    @ATSMethod(1)
    void d(String str, JSONObject jSONObject, Throwable th);
}
