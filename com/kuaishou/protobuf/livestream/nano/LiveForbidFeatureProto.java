package com.kuaishou.protobuf.livestream.nano;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface LiveForbidFeatureProto {

    @Retention(RetentionPolicy.SOURCE)
    public @interface ForbidFeatureType {
        public static final int FORBID_FEATURE_AD_SOCIAL_BELL = 2;
        public static final int FORBID_FEATURE_COMMENT_NOTICE = 3;
        public static final int FORBID_FEATURE_SERVICE_ACCOUNT = 1;
        public static final int UNKNOWN_FORBID_FEATURE_TYPE = 0;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ForbidType {
        public static final int FORBID_ALL = 1;
        public static final int FORBID_APPOINT_BIZ = 2;
        public static final int UNKNOWN_FORBID_TYPE = 0;
    }
}
