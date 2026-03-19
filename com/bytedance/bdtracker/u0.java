package com.bytedance.bdtracker;

import android.app.Activity;
import android.view.View;
import com.bytedance.applog.exposure.ViewExposureManager;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class u0 extends Lambda implements Function1<Activity, Unit> {
    public final /* synthetic */ ViewExposureManager a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u0(ViewExposureManager viewExposureManager) {
        super(1);
        this.a = viewExposureManager;
    }

    public Object invoke(Object obj) {
        WeakHashMap<View, s0> weakHashMap;
        Activity activity = (Activity) obj;
        if (activity != null && (weakHashMap = this.a.getActivitiesMap$agent_liteChinaRelease().get(activity)) != null) {
            Intrinsics.checkExpressionValueIsNotNull(weakHashMap, "activitiesMap[activity] …erActivityStoppedCallback");
            Iterator<Map.Entry<View, s0>> it = weakHashMap.entrySet().iterator();
            while (it.hasNext()) {
                it.next().getValue().b = false;
            }
        }
        return Unit.INSTANCE;
    }
}
