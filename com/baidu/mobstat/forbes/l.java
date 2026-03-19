package com.baidu.mobstat.forbes;

import android.app.Activity;
import android.view.View;
import com.baidu.mobstat.forbes.MtjConfig;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class l {
    public static void a(MtjConfig.FeedTrackStrategy feedTrackStrategy) {
        n.a().a(feedTrackStrategy);
    }

    public static void a(Activity activity, boolean z) {
        if (!z || m.a().b() || n.a().b()) {
            return;
        }
        n.a().a(activity);
    }

    public static void b(Activity activity, boolean z) {
        if (!z || m.a().b() || n.a().b()) {
            return;
        }
        n.a().b(activity);
    }

    public static void c(Activity activity, boolean z) {
        if (!z || m.a().b() || n.a().b()) {
            return;
        }
        n.a().c(activity);
    }

    public static void a(View view, Activity activity) {
        if (m.a().b() || n.a().b()) {
            return;
        }
        n.a().a(view, activity);
    }
}
