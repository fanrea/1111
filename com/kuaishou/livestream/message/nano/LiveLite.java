package com.kuaishou.livestream.message.nano;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface LiveLite {

    @Retention(RetentionPolicy.SOURCE)
    public @interface LiveModel {
        public static final int LIVE_MODEL_LITE = 2;
        public static final int LIVE_MODEL_NORMAL = 1;
        public static final int LIVE_MODEL_REFRESHING = 3;
        public static final int LIVE_MODEL_UNKNOWN = 0;
    }
}
