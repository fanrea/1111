package com.bytedance.sdk.djx.core.business.view.share;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DJXShareConfig {

    public static class CHANNEL_NAME {
        public static final String PRIVACY_SETTING = "privacy_setting";
        public static final String REPORT = "report";

        public static boolean isValid(String str) {
            return str != null && (str.equals("report") || str.equals(PRIVACY_SETTING));
        }
    }
}
