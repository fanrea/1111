package com.kuaishou.livestream.message.nano;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface LivePaidChatMessages {

    @Retention(RetentionPolicy.SOURCE)
    public @interface LivePaidChatPayType {
        public static final int BOTH_PAY = 4;
        public static final int INVITEE_USER_PAY = 3;
        public static final int INVITER_USER_PAY = 2;
        public static final int NO_NEED_PAY = 1;
        public static final int UNKNOWN_PAY_TYPE = 0;
    }
}
