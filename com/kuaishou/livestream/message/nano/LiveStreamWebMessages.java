package com.kuaishou.livestream.message.nano;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface LiveStreamWebMessages {

    @Retention(RetentionPolicy.SOURCE)
    public @interface WebRedPackCoverType {
        public static final int NORMAL_COVER = 1;
        public static final int PRETTY_COVER = 2;
        public static final int UNKNOWN_COVER_TYPE = 0;
    }
}
