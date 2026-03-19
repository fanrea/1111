package com.alliance.ssp.ad.i0;

import androidx.collection.ArraySet;
import com.alliance.ssp.ad.oaidgithub.ykrank.androidlifecycle.event.ActivityEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: ActivityLifeCycle.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class a {
    public Map<ActivityEvent, Set<b>> a = new HashMap(8);

    public void a() {
        Iterator it = ((ArrayList) a(ActivityEvent.DESTROY)).iterator();
        while (it.hasNext()) {
            ((b) it.next()).a();
        }
        this.a.clear();
    }

    public void b() {
        Iterator it = ((ArrayList) a(ActivityEvent.PAUSE)).iterator();
        while (it.hasNext()) {
            ((b) it.next()).a();
        }
    }

    public void c() {
        Iterator it = ((ArrayList) a(ActivityEvent.RESUME)).iterator();
        while (it.hasNext()) {
            ((b) it.next()).a();
        }
    }

    public void d() {
        Iterator it = ((ArrayList) a(ActivityEvent.START)).iterator();
        while (it.hasNext()) {
            ((b) it.next()).a();
        }
    }

    public void e() {
        Iterator it = ((ArrayList) a(ActivityEvent.STOP)).iterator();
        while (it.hasNext()) {
            ((b) it.next()).a();
        }
    }

    public List<b> a(ActivityEvent activityEvent) {
        ArrayList arrayList;
        synchronized (this) {
            Set<b> arraySet = this.a.get(activityEvent);
            if (arraySet == null) {
                arraySet = new ArraySet<>();
                this.a.put(activityEvent, arraySet);
            }
            arrayList = new ArrayList(arraySet.size());
            Iterator<b> it = arraySet.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next());
            }
        }
        return arrayList;
    }
}
