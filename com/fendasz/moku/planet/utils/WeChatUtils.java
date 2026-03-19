package com.fendasz.moku.planet.utils;

import android.content.Context;
import android.content.Intent;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class WeChatUtils {
    public static boolean openWeChatQrCode(Context context) {
        try {
            Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage("com.tencent.mm");
            if (launchIntentForPackage == null) {
                return false;
            }
            launchIntentForPackage.putExtra("LauncherUI.From.Scaner.Shortcut", true);
            launchIntentForPackage.setAction("android.intent.action.VIEW");
            launchIntentForPackage.setFlags(335544320);
            context.startActivity(launchIntentForPackage);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
