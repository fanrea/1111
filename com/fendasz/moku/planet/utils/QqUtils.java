package com.fendasz.moku.planet.utils;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.fendasz.moku.planet.utils.system.utils.SystemUtils;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class QqUtils {
    public static final String PACKAGENAME_QQ = "com.tencent.mobileqq";

    public static boolean checkQqApkInstalled(Context context) {
        return SystemUtils.isAppExist(context, PACKAGENAME_QQ);
    }

    public static boolean openQqChat(Context context, String str) {
        try {
            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("mqqwpa://im/chat?chat_type=wpa&uin=" + str)));
            return true;
        } catch (ActivityNotFoundException unused) {
            return false;
        }
    }

    public static boolean joinQqGroup(Context context, String str) {
        try {
            Intent intent = new Intent();
            intent.setData(Uri.parse("mqqopensdkapi://bizAgent/qm/qr?url=http%3A%2F%2Fqm.qq.com%2Fcgi-bin%2Fqm%2Fqr%3Ffrom%3Dapp%26p%3Dandroid%26k%3D" + str));
            context.startActivity(intent);
            return true;
        } catch (ActivityNotFoundException unused) {
            return false;
        }
    }

    public static boolean openQqGroup(Context context, String str) {
        try {
            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("mqqwpa://im/chat?chat_type=group&uin=" + str)));
            return true;
        } catch (ActivityNotFoundException unused) {
            return false;
        }
    }
}
