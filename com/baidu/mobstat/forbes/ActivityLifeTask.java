package com.baidu.mobstat.forbes;

import android.content.Context;
import com.baidu.mobstat.forbes.ActivityLifeObserver;
import com.baidu.mobstat.forbes.AutoTrack;
import com.baidu.mobstat.forbes.b;
import com.baidu.mobstat.forbes.p;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class ActivityLifeTask {
    private static boolean a = false;
    private static ActivityLifeObserver.IActivityLifeCallback b;
    private static ActivityLifeObserver.IActivityLifeCallback c;
    private static ActivityLifeObserver.IActivityLifeCallback d;
    private static ActivityLifeObserver.IActivityLifeCallback e;

    public static synchronized void registerActivityLifeCallback(Context context) {
        if (a) {
            return;
        }
        a(context);
        ActivityLifeObserver.instance().clearObservers();
        ActivityLifeObserver.instance().addObserver(b);
        ActivityLifeObserver.instance().addObserver(d);
        ActivityLifeObserver.instance().addObserver(c);
        ActivityLifeObserver.instance().addObserver(e);
        ActivityLifeObserver.instance().registerActivityLifeCallback(context);
        a = true;
    }

    private static synchronized void a(Context context) {
        b = new AutoTrack.MyActivityLifeCallback(1);
        d = new b.a();
        c = new p.a();
        e = new AutoTrack.MyActivityLifeCallback(2);
    }
}
