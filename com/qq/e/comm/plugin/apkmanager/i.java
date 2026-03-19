package com.qq.e.comm.plugin.apkmanager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.bytedance.pangle.provider.ContentProviderManager;
import com.qq.e.comm.plugin.r1;
import com.qq.e.comm.plugin.wx;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class i {
    static Intent a(Context context) {
        return b(context).putExtra("create_service", true);
    }

    static Intent b(Context context) {
        Intent intent = new Intent();
        intent.setClassName(context, wx.b());
        intent.putExtra(ContentProviderManager.PLUGIN_PROCESS_NAME, r1.d().b().f());
        intent.putExtra("GDT_APPID", r1.d().b().a());
        return intent;
    }

    static Intent c(Context context) {
        return b(context).putExtra("recover", true);
    }

    static Intent d(Context context) {
        return b(context).putExtra("repair", true);
    }

    static boolean e(Intent intent) {
        return intent.getBooleanExtra("trigger_by_notify_bar", false);
    }

    static boolean f(Intent intent) {
        return intent.getBooleanExtra("recover", false);
    }

    static boolean g(Intent intent) {
        return intent.getBooleanExtra("repair", false);
    }

    static Intent a(Context context, ApkDownloadTask apkDownloadTask) {
        return b(context).putExtra("gdt_apkdownload_task", apkDownloadTask.z()).putExtra("download", true);
    }

    static boolean c(Intent intent) {
        return intent.getBooleanExtra("create_service", false);
    }

    static boolean d(Intent intent) {
        return intent.getBooleanExtra("download", false);
    }

    public static void a(Intent intent, boolean z) {
        intent.putExtra("trigger_by_notify_bar", z);
    }

    public static String a(Intent intent) {
        return intent.getStringExtra(ContentProviderManager.PLUGIN_PROCESS_NAME);
    }

    static Bundle b(Intent intent) {
        return intent.getBundleExtra("gdt_apkdownload_task");
    }
}
