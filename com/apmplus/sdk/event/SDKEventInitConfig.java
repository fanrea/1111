package com.apmplus.sdk.event;

import android.content.Context;
import android.text.TextUtils;
import com.apm.applog.UriConfig;
import com.bytedance.framwork.core.de.fg.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class SDKEventInitConfig {
    private final String a;
    private final String b;
    private final String c;
    private final boolean d;
    private final String e;
    private final Context f;
    private final String g;
    private final String h;
    private List<String> i;
    private List<String> j;
    private SDKEventIDynamicParams k;

    public static Builder builder() {
        return new Builder();
    }

    private SDKEventInitConfig(Builder builder) {
        this.a = builder.a;
        this.b = builder.b;
        this.c = builder.c;
        this.d = builder.e;
        this.f = builder.f;
        this.e = builder.g;
        this.g = builder.h;
        this.h = builder.d;
        this.i = builder.i;
        this.j = builder.j;
        this.k = builder.k;
    }

    public String getAid() {
        return this.a;
    }

    public String getToken() {
        return this.b;
    }

    public String getChannel() {
        return this.c;
    }

    public boolean isDebug() {
        return this.d;
    }

    public SDKEventIDynamicParams getDynamicParams() {
        return this.k;
    }

    public List<String> getEventRequestUrls() {
        return this.i;
    }

    public List<String> getEventUploadUrls() {
        return this.j;
    }

    public String getUpdateVersionCode() {
        return this.e;
    }

    public String getAppVersion() {
        return this.g;
    }

    public String getHostAid() {
        return this.h;
    }

    public Context getContext() {
        return this.f;
    }

    public static final class Builder {
        private String a;
        private String b;
        private String c;
        private String d;
        private boolean e;
        private Context f;
        private String g;
        private String h;
        private List<String> i = f.a;
        private List<String> j = f.b;
        private SDKEventIDynamicParams k;

        Builder() {
        }

        public Builder context(Context context) {
            this.f = context;
            return this;
        }

        public Builder aid(String str) {
            this.a = str;
            return this;
        }

        public Builder token(String str) {
            this.b = str;
            return this;
        }

        public Builder channel(String str) {
            this.c = str;
            return this;
        }

        public Builder hostAid(String str) {
            this.d = str;
            return this;
        }

        public Builder appVersion(String str) {
            this.h = str;
            return this;
        }

        public Builder updateVersionCode(String str) {
            this.g = str;
            return this;
        }

        public Builder debugMode(boolean z) {
            this.e = z;
            return this;
        }

        public Builder defaultReportDomain(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.i = a(str, f.a, UriConfig.DEFAULT_DOMAIN);
                this.j = a(str, f.b, UriConfig.DEFAULT_DOMAIN);
            }
            return this;
        }

        public Builder setDynamicParams(SDKEventIDynamicParams sDKEventIDynamicParams) {
            this.k = sDKEventIDynamicParams;
            return this;
        }

        private List<String> a(String str, List<String> list, String str2) {
            ArrayList arrayList = new ArrayList();
            if (!TextUtils.isEmpty(str) && list != null && list.size() > 0) {
                Iterator<String> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().replace(str2, str));
                }
            }
            return arrayList;
        }

        public SDKEventInitConfig build() {
            if (TextUtils.isEmpty(this.a)) {
                throw new IllegalArgumentException("aid must not be empty");
            }
            if (this.f == null) {
                throw new IllegalArgumentException("context must not be empty");
            }
            if (this.k == null) {
                throw new IllegalArgumentException("SDKEventIDynamicParams must not be empty");
            }
            return new SDKEventInitConfig(this);
        }
    }
}
