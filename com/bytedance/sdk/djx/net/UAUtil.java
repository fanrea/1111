package com.bytedance.sdk.djx.net;

import android.os.Build;
import android.text.TextUtils;
import android.webkit.WebSettings;
import com.bytedance.sdk.djx.net.k3.internal.Version;
import com.bytedance.sdk.djx.utils.InnerManager;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class UAUtil {
    private static String sUSER_AGENT;

    public static String getUserAgent() {
        if (TextUtils.isEmpty(sUSER_AGENT)) {
            if (Build.VERSION.SDK_INT >= 17) {
                try {
                    sUSER_AGENT = WebSettings.getDefaultUserAgent(InnerManager.getContext());
                } catch (Throwable unused) {
                }
            }
            if (TextUtils.isEmpty(sUSER_AGENT)) {
                try {
                    sUSER_AGENT = System.getProperty("http.agent");
                } catch (Throwable unused2) {
                    sUSER_AGENT = "unknow";
                }
            }
            String str = sUSER_AGENT + " " + Version.userAgent() + " djxsdk/2.9.0.2";
            sUSER_AGENT = str;
            try {
                if (!TextUtils.isEmpty(str)) {
                    StringBuilder sb = new StringBuilder();
                    int length = sUSER_AGENT.length();
                    for (int i = 0; i < length; i++) {
                        char cCharAt = sUSER_AGENT.charAt(i);
                        if ((cCharAt > 31 || cCharAt == '\t') && cCharAt < 127) {
                            sb.append(cCharAt);
                        } else {
                            try {
                                sb.append(String.format("\\u%04x", Integer.valueOf(cCharAt)));
                            } catch (Throwable unused3) {
                            }
                        }
                    }
                    sUSER_AGENT = sb.toString();
                }
            } catch (Throwable unused4) {
            }
        }
        String str2 = sUSER_AGENT;
        return str2 == null ? Version.userAgent() : str2;
    }
}
