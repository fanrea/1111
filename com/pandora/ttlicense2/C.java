package com.pandora.ttlicense2;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class C {
    static final int LOADER_BACKUP_RETRY_COUNT = 3;
    static final int LOADER_BACKUP_RETRY_DELAY = 1000;
    static final int LOADER_MAIN_RETRY_COUNT = 5;
    static final int LOADER_MAIN_RETRY_DELAY = 1000;
    static final int SESSION_RETRY_COUNT = 10;

    public static final class Edition {
        public static final String EDITION_ENTERPRISE = "enterprise_edition";
        public static final String EDITION_PREMIUM = "premium_edition";
        public static final String EDITION_STANDARD = "standard_edition";
    }

    public static final class Feature {
        public static final String FEATURE_ABR = "abr";
        public static final String FEATURE_BVC1 = "bvc1";
        public static final String FEATURE_H266 = "h266";
        public static final String FEATURE_INTERTRUST_DRM = "intertrust_drm";
        public static final String FEATURE_LITE = "lite";
        public static final String FEATURE_PCDN = "pcdn";
        public static final String FEATURE_SUPER_RESOLUTION = "super_resolution";
        public static final String FEATURE_VOLUME_BALANCE = "volume_balance";
        public static final String FEATURE_VR_PANORAMA = "vr_panorama";
    }

    public static final class LicenseStatus {
        public static final int LICENSE_STATUS_ERROR_PARAM_EDITION = 400;
        public static final int LICENSE_STATUS_ERROR_PARAM_FEATURE_NAME = 402;
        public static final int LICENSE_STATUS_ERROR_PARAM_MODULE_NAME = 403;
        public static final int LICENSE_STATUS_ERROR_PARAM_PACKAGE_NAME = 401;
        public static final int LICENSE_STATUS_EXPIRED = 2;
        public static final int LICENSE_STATUS_INVALID = 0;
        public static final int LICENSE_STATUS_OK = 1;
    }

    public static final class SDK {
        public static final String SDK_LIVE_PULL = "live_pull";
        public static final String SDK_LIVE_PUSH = "live_push";
        public static final String SDK_VOD_PLAY = "vod_play";
        public static final String SDK_VOD_UPLOAD = "vod_upload";
    }
}
