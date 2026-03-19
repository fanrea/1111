package com.kuaishou.livestream.message.nano;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface LiveProfitAreaMessages {

    @Retention(RetentionPolicy.SOURCE)
    public @interface ProfitAreaItemBizType {
        public static final int LITE_LUCKY_STAR = 1;
        public static final int LITE_RED_PACK = 2;
        public static final int MERCHANT_DY_LITE_PROFIT = 3;
        public static final int UNKNOWN_PROFIT_AREA_BIZ_TYPE = 0;
    }
}
