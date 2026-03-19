package com.fc.tjcpl.sdk.k;

import android.content.Context;
import android.content.Intent;
import android.os.Build;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class c {
    public static final String a = Build.MANUFACTURER.toLowerCase();

    public static boolean a(Context context, Intent intent) {
        return context.getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
    }
}
