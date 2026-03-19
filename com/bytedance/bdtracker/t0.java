package com.bytedance.bdtracker;

import android.app.Activity;
import com.bytedance.applog.exposure.ViewExposureManager;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class t0 extends Lambda implements Function1<Activity, Unit> {
    public final /* synthetic */ ViewExposureManager a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t0(ViewExposureManager viewExposureManager) {
        super(1);
        this.a = viewExposureManager;
    }

    public Object invoke(Object obj) {
        Intrinsics.checkParameterIsNotNull((Activity) obj, "it");
        ViewExposureManager.access$getTask$p(this.a).b.a();
        return Unit.INSTANCE;
    }
}
