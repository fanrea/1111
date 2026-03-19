package com.bytedance.sdk.djx.core.toast;

import android.app.Activity;
import android.content.Context;
import androidx.core.app.NotificationManagerCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DJXToast {
    public static final int DURATION_LONG = 3500;
    public static final int DURATION_SHORT = 2000;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Duration {
    }

    public static IToast make(Context context) {
        if (context == null) {
            return new EmptyToast();
        }
        if (NotificationManagerCompat.from(context).areNotificationsEnabled() || SystemToast.isValid4HookINotificationManager() || ToastWhite.isWhiteList()) {
            return new SystemToast(context);
        }
        if ((context instanceof Activity) && CompatToast.isBadChoice()) {
            return new ActivityToast(context);
        }
        return new CompatToast(context);
    }

    public static void cancel() {
        CompatToast.cancelAll();
        SystemToast.cancelAll();
    }

    public static void cancelActivityToast(Activity activity) {
        CompatToast.cancelActivityToast(activity);
    }
}
