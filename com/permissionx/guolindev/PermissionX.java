package com.permissionx.guolindev;

import android.content.Context;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class PermissionX {

    public static final class permission {
        public static final String POST_NOTIFICATIONS = "android.permission.POST_NOTIFICATIONS";
    }

    public static PermissionMediator init(FragmentActivity fragmentActivity) {
        return new PermissionMediator(fragmentActivity);
    }

    public static PermissionMediator init(Fragment fragment) {
        return new PermissionMediator(fragment);
    }

    public static boolean isGranted(Context context, String str) {
        return ContextCompat.checkSelfPermission(context, str) == 0;
    }

    public static boolean areNotificationsEnabled(Context context) {
        return NotificationManagerCompat.from(context).areNotificationsEnabled();
    }
}
