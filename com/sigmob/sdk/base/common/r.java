package com.sigmob.sdk.base.common;

import com.sigmob.sdk.base.models.BaseAdUnit;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public interface r {
    boolean a(final BaseAdUnit adUnit);

    boolean a(BaseAdUnit adUnit, final int duration, final int endTime);

    boolean a(BaseAdUnit adUnit, final String event, final int playheadMillis);

    boolean a(BaseAdUnit adUnit, final boolean isForceShow, final int playheadMillis);

    boolean b(BaseAdUnit adUnit);
}
