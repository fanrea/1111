package com.luck.picture.lib.utils;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import androidx.fragment.app.FragmentActivity;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class ActivityCompatHelper {
    private static final int MIN_FRAGMENT_COUNT = 1;

    public static boolean isDestroy(Activity activity) {
        return activity == null || activity.isFinishing() || activity.isDestroyed();
    }

    public static boolean checkFragmentNonExits(FragmentActivity fragmentActivity, String str) {
        return !isDestroy(fragmentActivity) && fragmentActivity.getSupportFragmentManager().findFragmentByTag(str) == null;
    }

    public static boolean assertValidRequest(Context context) {
        if (context instanceof Activity) {
            return !isDestroy((Activity) context);
        }
        if (context instanceof ContextWrapper) {
            if (((ContextWrapper) context).getBaseContext() instanceof Activity) {
                return !isDestroy((Activity) r2.getBaseContext());
            }
        }
        return true;
    }

    public static boolean checkRootFragment(FragmentActivity fragmentActivity) {
        return !isDestroy(fragmentActivity) && fragmentActivity.getSupportFragmentManager().getBackStackEntryCount() == 1;
    }
}
