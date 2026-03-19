package com.alliance.ssp.ad.k0;

import androidx.collection.ArraySet;
import com.alliance.ssp.ad.oaidgithub.ykrank.androidlifecycle.event.ActivityEvent;
import java.util.Set;

/* compiled from: ActivityLifeCycleManager.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class a {
    public final com.alliance.ssp.ad.i0.a a = new com.alliance.ssp.ad.i0.a();

    public a a(ActivityEvent activityEvent, com.alliance.ssp.ad.i0.b bVar) {
        com.alliance.ssp.ad.i0.a aVar = this.a;
        synchronized (aVar) {
            Set<com.alliance.ssp.ad.i0.b> arraySet = aVar.a.get(activityEvent);
            if (arraySet == null) {
                arraySet = new ArraySet<>();
                aVar.a.put(activityEvent, arraySet);
            }
            arraySet.add(bVar);
        }
        return this;
    }
}
