package com.bytedance.sdk.component.an;

import com.bytedance.sdk.openadsdk.ats.ATSApi;
import com.bytedance.sdk.openadsdk.ats.ATSMethod;
import java.io.InputStream;

@ATSApi("img_service")
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public interface e {
    @ATSMethod(4)
    void b(double d);

    @ATSMethod(1)
    tc d(String str);

    @ATSMethod(6)
    InputStream d(String str, String str2);

    @ATSMethod(7)
    InputStream d(String str, String str2, String str3);

    @ATSMethod(5)
    void d();

    @ATSMethod(2)
    void d(double d);

    @ATSMethod(3)
    void hc(double d);

    @ATSMethod(8)
    boolean hc(String str, String str2, String str3);
}
