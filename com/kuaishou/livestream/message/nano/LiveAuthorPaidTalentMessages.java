package com.kuaishou.livestream.message.nano;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface LiveAuthorPaidTalentMessages {

    @Retention(RetentionPolicy.SOURCE)
    public @interface LiveAuthorPaidTalentAuthorPermission {
        public static final int PERMISSION_BANNED = 2;
        public static final int PERMISSION_NOT_BANNED = 1;
        public static final int UNKNOWN_AUTHOR_PERMISSION = 0;
    }
}
