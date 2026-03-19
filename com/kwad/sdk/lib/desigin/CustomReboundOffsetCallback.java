package com.kwad.sdk.lib.desigin;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public interface CustomReboundOffsetCallback {
    public static final int REBOUND_TYPE_FLING = 2;
    public static final int REBOUND_TYPE_TOUCH = 1;

    @Retention(RetentionPolicy.SOURCE)
    public @interface ReboundType {
    }

    void rebound(int i, float f, int i2);
}
