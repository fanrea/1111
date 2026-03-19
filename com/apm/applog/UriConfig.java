package com.apm.applog;

import ca.da.ca.ja.s;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class UriConfig {
    public static final String DEFAULT_DOMAIN = "https://apmplus.volces.com";
    public static final String HTTPS = "https://";
    public static final String PATH_AB = "/service/2/abtest_config/";
    public static final String PATH_ACTIVE = "/service/2/app_alert_check/";
    public static final String PATH_ALINK_ATTRIBUTION = "/service/2/attribution_data";
    public static final String PATH_ALINK_QUERY = "/service/2/alink_data";
    public static final String PATH_CONFIG = "/service/2/log_settings/";
    public static final String PATH_PROFILE = "/service/2/profile/";
    public static final String PATH_REGISTER = "/apm/device_register";
    public static final String PATH_SEND = "/monitor/collect/c/session";
    public final String a;
    public final String b;
    public final String[] c;
    public final String[] d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public final String i;
    public final String j;

    public static class Builder {
        public String a;
        public String b;
        public String[] c;
        public String[] d;
        public String e;
        public String f;
        public String g;
        public String h;
        public String i;
        public String j;

        public UriConfig build() {
            return new UriConfig(this, null);
        }

        public Builder setALinkAttributionUri(String str) {
            this.j = str;
            return this;
        }

        public Builder setALinkQueryUri(String str) {
            this.i = str;
            return this;
        }

        public Builder setAbUri(String str) {
            this.f = str;
            return this;
        }

        public Builder setActiveUri(String str) {
            this.b = str;
            return this;
        }

        public Builder setMonitor(String str) {
            this.h = str;
            return this;
        }

        public Builder setProfileUri(String str) {
            this.g = str;
            return this;
        }

        public Builder setRealUris(String[] strArr) {
            this.d = strArr;
            return this;
        }

        public Builder setRegisterUri(String str) {
            this.a = str;
            return this;
        }

        public Builder setSendUris(String[] strArr) {
            this.c = strArr;
            return this;
        }

        public Builder setSettingUri(String str) {
            this.e = str;
            return this;
        }
    }

    public /* synthetic */ UriConfig(Builder builder, a aVar) {
        this.a = builder.a;
        this.b = builder.b;
        this.c = builder.c;
        this.d = builder.d;
        this.e = builder.e;
        this.f = builder.f;
        this.g = builder.g;
        this.h = builder.h;
        this.i = builder.i;
        this.j = builder.j;
    }

    public static UriConfig createByDomain(String str, String[] strArr) {
        Builder builder = new Builder();
        builder.setRegisterUri(str + PATH_REGISTER).setActiveUri(str + "/service/2/app_alert_check/").setALinkAttributionUri(str + "/service/2/attribution_data").setALinkQueryUri(str + "/service/2/alink_data");
        if (strArr == null || strArr.length == 0) {
            builder.setSendUris(new String[]{str + PATH_SEND});
        } else {
            int length = strArr.length + 1;
            String[] strArr2 = new String[length];
            strArr2[0] = str + PATH_SEND;
            for (int i = 1; i < length; i++) {
                strArr2[i] = ca.ca.ca.ca.a.a(new StringBuilder(), strArr[i - 1], PATH_SEND);
            }
            builder.setSendUris(strArr2);
        }
        builder.setSettingUri(str + "/service/2/log_settings/").setAbUri(str + "/service/2/abtest_config/").setProfileUri(str + "/service/2/profile/");
        return builder.build();
    }

    public static UriConfig createUriConfig(int i) {
        return s.b;
    }

    public String getAbUri() {
        return this.f;
    }

    public String getActiveUri() {
        return this.b;
    }

    public String getAlinkAttributionUri() {
        return this.j;
    }

    public String getAlinkQueryUri() {
        return this.i;
    }

    public String getMonitorUri() {
        return this.h;
    }

    public String getProfileUri() {
        return this.g;
    }

    public String[] getRealUris() {
        return this.d;
    }

    public String getRegisterUri() {
        return this.a;
    }

    public String[] getSendUris() {
        return this.c;
    }

    public String getSettingUri() {
        return this.e;
    }
}
