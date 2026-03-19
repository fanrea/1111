package com.alliance.ssp.ad.api;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public final class SAAllianceAdInitParams {
    private String androidId;
    private boolean canUseAndroidId;
    private boolean canUseCarrier;
    private boolean canUseIMei;
    private boolean canUseInstallAppList;
    private boolean canUseLocation;
    private boolean canUseMac;
    private boolean canUseMotionSensor;
    private boolean canUseOaid;
    private boolean canUseWifiState;
    private String carrier;
    private boolean enablePersonalized;
    private String imei;
    private boolean isDebug;
    private double[] location;
    private String mac;
    private String oaid;
    private String userId;

    public static class Builder {
        private double[] location;
        private boolean isDebug = false;
        private String androidId = "";
        private String imei = "";
        private String oaid = "";
        private String mac = "";
        private String carrier = "";
        private boolean enablePersonalized = true;
        private String userId = "";
        private boolean canUseIMei = true;
        private boolean canUseOaid = true;
        private boolean canUseAndroidId = true;
        private boolean canUseLocation = true;
        private boolean canUseMac = true;
        private boolean canUseCarrier = true;
        private boolean canUseInstallAppList = true;
        private boolean canUseMotionSensor = true;
        private boolean canUseWifiState = true;

        public SAAllianceAdInitParams build() {
            return new SAAllianceAdInitParams(this);
        }

        public Builder setCanUseAndroidId(boolean z) {
            this.canUseAndroidId = z;
            return this;
        }

        public Builder setCanUseCarrier(boolean z) {
            this.canUseCarrier = z;
            return this;
        }

        public Builder setCanUseIMei(boolean z) {
            this.canUseIMei = z;
            return this;
        }

        @Deprecated
        public Builder setCanUseInstallAppList(boolean z) {
            this.canUseInstallAppList = z;
            return this;
        }

        public Builder setCanUseLocation(boolean z) {
            this.canUseLocation = z;
            return this;
        }

        public Builder setCanUseMac(boolean z) {
            this.canUseMac = z;
            return this;
        }

        @Deprecated
        public Builder setCanUseMotionSensor(boolean z) {
            this.canUseMotionSensor = z;
            return this;
        }

        public Builder setCanUseOaid(boolean z) {
            this.canUseOaid = z;
            return this;
        }

        public Builder setCanUseWifiState(boolean z) {
            this.canUseWifiState = z;
            return this;
        }

        public Builder setCustomAndroidId(String str) {
            this.androidId = str;
            return this;
        }

        public Builder setCustomCarrier(String str) {
            this.carrier = str;
            return this;
        }

        public Builder setCustomImei(String str) {
            this.imei = str;
            return this;
        }

        public Builder setCustomLocation(double[] dArr) {
            this.location = dArr;
            return this;
        }

        public Builder setCustomMacAddress(String str) {
            this.mac = str;
            return this;
        }

        public Builder setCustomOaid(String str) {
            this.oaid = str;
            return this;
        }

        public Builder setCustomUserId(String str) {
            this.userId = str;
            return this;
        }

        public Builder setDebug(boolean z) {
            this.isDebug = z;
            return this;
        }

        public Builder setEnablePersonalized(boolean z) {
            this.enablePersonalized = z;
            return this;
        }
    }

    public String getAndroidId() {
        return this.androidId;
    }

    public String getCarrier() {
        return this.carrier;
    }

    public boolean getDebug() {
        return this.isDebug;
    }

    public String getImei() {
        return this.imei;
    }

    public double[] getLocation() {
        return this.location;
    }

    public String getMac() {
        return this.mac;
    }

    public String getOaid() {
        return this.oaid;
    }

    public String getUserId() {
        return this.userId;
    }

    public boolean isCanUseAndroidId() {
        return this.canUseAndroidId;
    }

    public boolean isCanUseCarrier() {
        return this.canUseCarrier;
    }

    public boolean isCanUseIMei() {
        return this.canUseIMei;
    }

    public boolean isCanUseInstallAppList() {
        return this.canUseInstallAppList;
    }

    public boolean isCanUseLocation() {
        return this.canUseLocation;
    }

    public boolean isCanUseMac() {
        return this.canUseMac;
    }

    public boolean isCanUseMotionSensor() {
        return this.canUseMotionSensor;
    }

    public boolean isCanUseOaid() {
        return this.canUseOaid;
    }

    public boolean isCanUseWifiState() {
        return this.canUseWifiState;
    }

    public boolean isDebug() {
        return this.isDebug;
    }

    public boolean isEnablePersonalized() {
        return this.enablePersonalized;
    }

    private SAAllianceAdInitParams(Builder builder) {
        this.isDebug = false;
        this.androidId = "";
        this.imei = "";
        this.oaid = "";
        this.mac = "";
        this.enablePersonalized = true;
        this.userId = "";
        this.carrier = "";
        this.canUseIMei = true;
        this.canUseOaid = true;
        this.canUseAndroidId = true;
        this.canUseLocation = true;
        this.canUseMac = true;
        this.canUseCarrier = true;
        this.canUseInstallAppList = true;
        this.canUseMotionSensor = true;
        this.canUseWifiState = true;
        this.isDebug = builder.isDebug;
        this.androidId = builder.androidId;
        this.imei = builder.imei;
        this.oaid = builder.oaid;
        this.mac = builder.mac;
        this.userId = builder.userId;
        this.enablePersonalized = builder.enablePersonalized;
        this.location = builder.location;
        this.carrier = builder.carrier;
        this.canUseIMei = builder.canUseIMei;
        this.canUseOaid = builder.canUseOaid;
        this.canUseAndroidId = builder.canUseAndroidId;
        this.canUseLocation = builder.canUseLocation;
        this.canUseMac = builder.canUseMac;
        this.canUseCarrier = builder.canUseCarrier;
        this.canUseInstallAppList = builder.canUseInstallAppList;
        this.canUseMotionSensor = builder.canUseMotionSensor;
        this.canUseWifiState = builder.canUseWifiState;
    }
}
