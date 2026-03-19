package com.bytedance.bdtracker;

import com.bytedance.applog.exposure.ViewExposureData;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class s0 {
    public final ViewExposureData a;
    public boolean b;

    public /* synthetic */ s0(ViewExposureData viewExposureData, boolean z, int i) {
        z = (i & 2) != 0 ? false : z;
        Intrinsics.checkParameterIsNotNull(viewExposureData, "data");
        this.a = viewExposureData;
        this.b = z;
    }
}
