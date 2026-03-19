package com.kwad.sdk.utils;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import com.kwad.sdk.api.core.fragment.FileProvider;
import java.io.File;
import java.util.Iterator;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class at {
    public static PendingIntent a(Context context, int i, Intent intent) {
        if (Build.VERSION.SDK_INT >= 23) {
            return PendingIntent.getBroadcast(context, i, intent, 201326592);
        }
        return PendingIntent.getBroadcast(context, i, intent, 134217728);
    }

    private static PendingIntent b(Context context, int i, Intent intent) {
        if (Build.VERSION.SDK_INT >= 23) {
            return PendingIntent.getActivity(context, i, intent, 201326592);
        }
        return PendingIntent.getActivity(context, i, intent, 134217728);
    }

    public static PendingIntent a(Context context, File file, int i, boolean z) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(268435459);
        Uri uriC = c(context, file);
        intent.setDataAndType(uriC, "application/vnd.android.package-archive");
        Iterator<ResolveInfo> it = context.getPackageManager().queryIntentActivities(intent, 65536).iterator();
        while (it.hasNext()) {
            context.grantUriPermission(it.next().activityInfo.packageName, uriC, 3);
        }
        if (z) {
            com.kwad.sdk.c.SL();
            if (com.kwad.sdk.c.SO()) {
                intent = j(intent);
            }
        }
        return b(context, i, intent);
    }

    private static Uri c(Context context, File file) {
        if (Build.VERSION.SDK_INT >= 24) {
            return FileProvider.getUriForFile(context, context.getPackageName() + ".adFileProvider", file);
        }
        return Uri.fromFile(file);
    }

    private static Intent j(Intent intent) {
        Intent intent2 = new Intent("intent.action.requestInstallPermission");
        intent2.putExtra("fromNotification", true);
        intent2.putExtra("pendingIntent", intent);
        intent2.addFlags(268435456);
        return intent2;
    }

    public static PendingIntent e(Context context, String str, int i) {
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
        if (launchIntentForPackage == null) {
            return null;
        }
        return b(context, i, launchIntentForPackage);
    }
}
