package com.bytedance.bmf_mods_lite_api.bean;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class SRConfig {
    public static int MODEL_SOURCE_CUSTOM_DOWNLOAD = 2;
    public static int MODEL_SOURCE_DAVINCI_DOWNLOAD = 1;
    public static int MODEL_SOURCE_LOCAL = 0;
    public static int SHARP_LEVEL_DEFAULT = 1;
    public static int SHARP_LEVEL_MEDIUM = 4;
    public static int SHARP_LEVEL_STRONG = 8;
    public static int SHARP_LEVEL_WEAK = 2;
    private final boolean isAllowFallback;
    private final Map<String, String> paramMap;
    private final int sharpLevels;
    private int modelSource = MODEL_SOURCE_LOCAL;
    private String modelName = "";

    public SRConfig(Map<String, String> map, int sharpLevels, boolean allowFallback) {
        this.paramMap = map;
        this.sharpLevels = sharpLevels;
        this.isAllowFallback = allowFallback;
    }

    public int getSharpLevels() {
        return this.sharpLevels;
    }

    public boolean isAllowFallback() {
        return this.isAllowFallback;
    }

    public Map<String, String> getParamMap() {
        return this.paramMap;
    }

    public int getModelSource() {
        return this.modelSource;
    }

    public String getModelName() {
        return this.modelName;
    }

    public static class Builder {
        private boolean isAllowFallback;
        private int sharpLevels = -1;
        private final Map<String, String> paramMap = new HashMap();
        private int modelSource = 0;
        private String modelName = "";

        public Builder setHostAndAccessKey(String host, String accessKey) {
            this.paramMap.put("host", host);
            this.paramMap.put("accessKey", accessKey);
            return this;
        }

        public Builder setSharpLevels(int sharpLevels, boolean isAllowFallback) {
            this.sharpLevels = sharpLevels;
            this.isAllowFallback = isAllowFallback;
            return this;
        }

        public Builder setDeviceId(String deviceId) {
            this.paramMap.put("deviceId", deviceId);
            return this;
        }

        public Builder setAppVersion(String appVersion) {
            this.paramMap.put("appVersion", appVersion);
            return this;
        }

        public Builder setAppId(String appId) {
            this.paramMap.put("appID", appId);
            return this;
        }

        public Builder setPlatformSdkVersion(String platformSdkVersion) {
            this.paramMap.put("platformSdkVersion", platformSdkVersion);
            return this;
        }

        public Builder setModelSource(int source) {
            this.modelSource = source;
            return this;
        }

        public Builder setModelName(String modelName) {
            this.modelName = modelName;
            return this;
        }

        public SRConfig build() {
            int i;
            if (!this.paramMap.containsKey("host") || !this.paramMap.containsKey("accessKey") || TextUtils.isEmpty(this.paramMap.get("host")) || TextUtils.isEmpty(this.paramMap.get("accessKey")) || (i = this.sharpLevels) < 0 || (i & 15) == 0) {
                return null;
            }
            SRConfig sRConfig = new SRConfig(this.paramMap, this.sharpLevels, this.isAllowFallback);
            sRConfig.modelSource = this.modelSource;
            sRConfig.modelName = this.modelName;
            return sRConfig;
        }
    }
}
