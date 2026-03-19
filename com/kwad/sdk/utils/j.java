package com.kwad.sdk.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import com.bytedance.common.utility.DeviceUtils;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class j {
    private static String clq = Build.BRAND;
    private static String clr = DeviceUtils.ROM_OPPO;
    private static String cls = "vivo";
    private static String clt = "Xiaomi";
    private static String clu = "Meizu";
    private static String clv = "HUAWEI";
    private static String clw = "HONOR";

    public static void cY(Context context) {
        Intent intentCZ;
        if (context == null || (intentCZ = cZ(context)) == null) {
            return;
        }
        try {
            context.startActivity(intentCZ);
        } catch (Exception unused) {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.parse("package:" + context.getPackageName()));
            context.startActivity(intent);
        }
    }

    private static Intent cZ(Context context) {
        Intent intent;
        if (anP()) {
            return ab(context, anU());
        }
        if (anQ() || anR()) {
            intent = new Intent();
            intent.setFlags(268435456);
            intent.putExtra("packageName", context.getPackageName());
            intent.setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.permissionmanager.ui.MainActivity"));
        } else if (anN()) {
            intent = new Intent("com.meizu.safe.security.SHOW_APPSEC");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.putExtra("packageName", context.getPackageName());
        } else if (anS() || anT()) {
            intent = new Intent();
            intent.setFlags(268435456);
            intent.putExtra("packageName", context.getPackageName());
            intent.setComponent(new ComponentName("com.color.safecenter", "com.color.safecenter.permission.PermissionManagerActivity"));
        } else if (anO()) {
            intent = new Intent("android.intent.action.MAIN");
            intent.setFlags(268435456);
            intent.putExtra("packageName", context.getPackageName());
            intent.setComponent(new ComponentName("com.qihoo360.mobilesafe", "com.qihoo360.mobilesafe.ui.index.AppEnterActivity"));
        } else {
            intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.parse("package:" + context.getPackageName()));
        }
        return intent;
    }

    private static Intent ab(Context context, String str) {
        if ("V5".equals(str)) {
            return new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:" + context.getPackageName()));
        }
        if ("V6".equals(str) || "V7".equals(str)) {
            Intent intent = new Intent("miui.intent.action.APP_PERM_EDITOR");
            intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
            intent.putExtra("extra_pkgname", context.getPackageName());
            return intent;
        }
        Intent intent2 = new Intent("miui.intent.action.APP_PERM_EDITOR");
        intent2.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.PermissionsEditorActivity");
        intent2.putExtra("extra_pkgname", context.getPackageName());
        return intent2;
    }

    private static boolean anN() throws ClassNotFoundException {
        String str = "";
        try {
            Class<?> cls2 = Class.forName("android.os.SystemProperties");
            str = (String) cls2.getMethod("get", String.class, String.class).invoke(cls2, "ro.build.display.id", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str.toLowerCase().contains("flyme");
    }

    private static boolean anO() {
        return DeviceUtils.ROM_QIKU.equals(Build.MANUFACTURER.toUpperCase()) || "360".equals(Build.MANUFACTURER.toUpperCase());
    }

    private static boolean anP() {
        return clq.equalsIgnoreCase(clt);
    }

    public static boolean anQ() {
        return clq.equalsIgnoreCase(clv);
    }

    public static boolean anR() {
        return clq.equalsIgnoreCase(clw);
    }

    private static boolean anS() {
        return clq.equalsIgnoreCase(clr);
    }

    private static boolean anT() {
        return clq.equalsIgnoreCase(cls);
    }

    private static String anU() {
        return av("ro.miui.ui.version.name", "");
    }

    private static String av(String str, String str2) throws ClassNotFoundException {
        try {
            Class<?> cls2 = Class.forName("android.os.SystemProperties");
            return (String) cls2.getMethod("get", String.class, String.class).invoke(cls2, str, str2);
        } catch (Exception unused) {
            return str2;
        }
    }
}
