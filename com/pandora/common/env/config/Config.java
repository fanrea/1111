package com.pandora.common.env.config;

import android.content.Context;
import android.text.TextUtils;
import com.pandora.common.env.config.LogConfig;
import com.pandora.common.env.config.VodConfig;
import com.pandora.common.vod.EngineParams;
import com.pandora.ttlicense2.LicenseManager;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class Config {
    private final String appChannel;
    private final String appID;
    private final String appName;
    private final String appRegion;
    private final String appVersion;
    private final Context applicationContext;
    private final boolean autoStartAppLog;
    private LicenseManager.Callback licenseCallback;
    private final String licenseUri;
    public LogConfig logConfig;
    private final boolean securityDeviceId;
    private final VodConfig vodConfig;

    private Config(final Builder builder) {
        this.applicationContext = builder.applicationContext;
        this.appID = builder.appID;
        this.appName = builder.appName;
        this.appVersion = builder.appVersion;
        this.appChannel = builder.appChannel;
        this.appRegion = builder.appRegion;
        this.licenseUri = builder.licenseUri;
        this.licenseCallback = builder.licenseCallback;
        this.securityDeviceId = builder.securityDeviceId;
        this.autoStartAppLog = builder.autoStartAppLog;
        this.vodConfig = builder.vodConfig;
        this.logConfig = builder.logConfig;
    }

    public Context getApplicationContext() {
        return this.applicationContext;
    }

    public String getAppID() {
        return this.appID;
    }

    public String getAppName() {
        return this.appName;
    }

    public String getAppVersion() {
        return this.appVersion;
    }

    public String getAppChannel() {
        return this.appChannel;
    }

    public String getAppRegion() {
        return this.appRegion;
    }

    public String getLicenseUri() {
        return this.licenseUri;
    }

    public LicenseManager.Callback getLicenseCallback() {
        return this.licenseCallback;
    }

    public VodConfig getVodConfig() {
        return this.vodConfig;
    }

    public LogConfig getLogConfig() {
        return this.logConfig;
    }

    public boolean isSecurityDeviceId() {
        return this.securityDeviceId;
    }

    public boolean isAutoStartAppLog() {
        return this.autoStartAppLog;
    }

    public String toString() {
        return "Config{applicationContext=" + this.applicationContext + ", appID='" + this.appID + "', appName='" + this.appName + "', appVersion='" + this.appVersion + "', appChannel='" + this.appChannel + "', appRegion='" + this.appRegion + "', licenseUri='" + this.licenseUri + "', licenseCallback='" + this.licenseCallback + "', securityDeviceId=" + this.securityDeviceId + ", vodConfig=" + this.vodConfig + '}';
    }

    public static class Builder {
        private String appChannel;
        private String appID;
        private String appName;
        private String appVersion;
        private Context applicationContext;
        private LicenseManager.Callback licenseCallback;
        private String licenseUri;
        private LogConfig logConfig;
        private VodConfig vodConfig;
        private boolean securityDeviceId = true;
        private boolean autoStartAppLog = true;
        private String appRegion = EngineParams.getDefaultAppRegion();

        public Config build() {
            if (this.applicationContext == null) {
                throw new NullPointerException("applicationContext is null");
            }
            if (TextUtils.isEmpty(this.appID)) {
                throw new NullPointerException("appID is null");
            }
            if (TextUtils.isEmpty(this.appChannel)) {
                throw new NullPointerException("appChannel is null");
            }
            if (TextUtils.isEmpty(this.appRegion)) {
                throw new NullPointerException("appRegion is null");
            }
            if (this.vodConfig == null) {
                this.vodConfig = new VodConfig.Builder(this.applicationContext).build();
            }
            if (this.logConfig == null) {
                this.logConfig = new LogConfig.Builder(this.applicationContext).build();
            }
            return new Config(this);
        }

        public Builder setApplicationContext(final Context applicationContext) {
            this.applicationContext = applicationContext;
            return this;
        }

        public Builder setAppID(final String appID) {
            this.appID = appID;
            return this;
        }

        public Builder setAppName(final String appName) {
            this.appName = appName;
            return this;
        }

        public Builder setAppVersion(final String appVersion) {
            this.appVersion = appVersion;
            return this;
        }

        public Builder setAppChannel(final String appChannel) {
            this.appChannel = appChannel;
            return this;
        }

        public Builder setAppRegion(final String appRegion) {
            this.appRegion = appRegion;
            return this;
        }

        public Builder setLicenseUri(final String licenseUri) {
            this.licenseUri = licenseUri;
            return this;
        }

        public Builder setLicenseCallback(LicenseManager.Callback licenseCallback) {
            this.licenseCallback = licenseCallback;
            return this;
        }

        public Builder setVodConfig(final VodConfig vodConfig) {
            this.vodConfig = vodConfig;
            return this;
        }

        public Builder securityDeviceId(final boolean securityDeviceId) {
            this.securityDeviceId = securityDeviceId;
            return this;
        }

        public Builder setAutoStartAppLog(boolean autoStartAppLog) {
            this.autoStartAppLog = autoStartAppLog;
            return this;
        }

        public Builder setLogConfig(LogConfig logConfig) {
            this.logConfig = logConfig;
            return this;
        }
    }
}
