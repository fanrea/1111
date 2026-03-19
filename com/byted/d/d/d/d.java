package com.byted.d.d.d;

import android.content.Context;
import com.bytedance.sdk.openadsdk.ats.ATSApi;
import com.bytedance.sdk.openadsdk.ats.ATSMethod;
import java.util.concurrent.ScheduledExecutorService;
import org.json.JSONObject;

@ATSApi("alog")
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public interface d {
    @ATSMethod(17)
    void b();

    @ATSMethod(10)
    void b(String str, String str2);

    @ATSMethod(11)
    void c(String str, String str2);

    @ATSMethod(3)
    void d();

    @ATSMethod(4)
    void d(int i);

    @ATSMethod(5)
    void d(Context context, String str, String str2);

    @ATSMethod(1)
    void d(Context context, JSONObject jSONObject);

    @ATSMethod(6)
    void d(String str);

    @ATSMethod(8)
    void d(String str, String str2);

    @ATSMethod(13)
    void d(String str, String str2, Throwable th);

    @ATSMethod(12)
    void d(String str, Throwable th);

    @ATSMethod(2)
    void d(ScheduledExecutorService scheduledExecutorService);

    @ATSMethod(7)
    void hc();

    @ATSMethod(9)
    void hc(String str, String str2);

    @ATSMethod(15)
    void hc(String str, String str2, Throwable th);

    @ATSMethod(16)
    void hc(String str, Throwable th);

    @ATSMethod(14)
    void u(String str, String str2);
}
