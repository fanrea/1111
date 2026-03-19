package com.qq.e.comm.plugin;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.provider.Settings;
import android.view.View;
import android.view.ViewGroup;
import com.qq.e.comm.util.GDTLogger;
import java.util.List;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class c1 {
    public static Activity a(Context context) {
        if (!(context instanceof ContextWrapper)) {
            return null;
        }
        if (context instanceof Activity) {
            return (Activity) context;
        }
        return a(((ContextWrapper) context).getBaseContext());
    }

    public static Activity b(Context context) {
        int i;
        Activity activityA = a(context);
        int i2 = 0;
        if (a(activityA)) {
            i = 0;
        } else {
            int i3 = activityA == null ? 1 : 2;
            Activity activityA2 = s3.b().a();
            if (!a(activityA2)) {
                i2 = activityA2 == null ? 1 : 2;
                GDTLogger.e("没有获取到Activity，将会影响弹窗展示！请尝试：1、实例化广告时Context传入Activity，并保证传入的Activity不被销毁；2、提早初始化SDK");
            }
            i = i3;
            activityA = activityA2;
        }
        b10.a(9130071, null, Integer.valueOf(i), Integer.valueOf(i2), null);
        return activityA;
    }

    public static boolean b() {
        return Build.VERSION.SDK_INT >= 17 && Settings.Global.getInt(r1.d().a().getContentResolver(), "always_finish_activities", 0) == 1;
    }

    public static Activity a(View view) {
        View rootView;
        if (view == null || (rootView = view.getRootView()) == null) {
            return null;
        }
        Activity activityA = a(rootView.getContext());
        if (activityA != null) {
            return activityA;
        }
        if (rootView instanceof ViewGroup) {
            return a((ViewGroup) rootView);
        }
        return null;
    }

    private static Activity a(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt != null) {
                Activity activityA = a(childAt.getContext());
                if (activityA != null) {
                    return activityA;
                }
                if (childAt instanceof ViewGroup) {
                    return a((ViewGroup) childAt);
                }
            }
        }
        return null;
    }

    public static boolean a(Activity activity) {
        if (activity == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 17) {
            return (activity.isFinishing() || activity.isDestroyed()) ? false : true;
        }
        return !activity.isFinishing();
    }

    public static void a() {
        ActivityManager activityManager;
        List<ActivityManager.RunningTaskInfo> runningTasks;
        if (r1.d().f().a("bappf", 1) == 0) {
            return;
        }
        try {
            Context contextA = r1.d().a();
            if ((Build.VERSION.SDK_INT < 23 || contextA.checkSelfPermission("android.permission.REORDER_TASKS") == 0) && (runningTasks = (activityManager = (ActivityManager) contextA.getSystemService("activity")).getRunningTasks(20)) != null) {
                for (ActivityManager.RunningTaskInfo runningTaskInfo : runningTasks) {
                    if (contextA.getPackageName().equals(runningTaskInfo.topActivity.getPackageName())) {
                        activityManager.moveTaskToFront(runningTaskInfo.id, 1);
                        return;
                    }
                }
            }
        } catch (Exception unused) {
        }
    }
}
