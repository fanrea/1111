package lkxssdk.j0;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import com.luck.picture.lib.permissions.PermissionUtil;
import com.permissionx.guolindev.request.RequestManageExternalStoragePermission;
import java.util.ArrayList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public class d {
    public static boolean a(Context context, Intent intent) {
        PackageManager packageManager = context.getPackageManager();
        return !(Build.VERSION.SDK_INT >= 33 ? packageManager.queryIntentActivities(intent, PackageManager.ResolveInfoFlags.of(65536L)) : packageManager.queryIntentActivities(intent, 65536)).isEmpty();
    }

    public static boolean b(Context context) {
        return a() ? Environment.isExternalStorageManager() : Build.VERSION.SDK_INT < 23 || context.checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") == 0;
    }

    public static void c(Context context) {
        Intent intentA;
        String str = c.a;
        if (str.contains("huawei")) {
            intentA = new Intent();
            intentA.setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.permissionmanager.ui.MainActivity"));
            if (!c.a(context, intentA)) {
                intentA.setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.systemmanager.addviewmonitor.AddViewMonitorActivity"));
                if (!c.a(context, intentA)) {
                    intentA.setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.notificationmanager.ui.NotificationManagmentActivity"));
                }
            }
        } else if (str.contains("xiaomi")) {
            intentA = new Intent("miui.intent.action.APP_PERM_EDITOR");
            intentA.putExtra("extra_pkgname", context.getPackageName());
            if (!c.a(context, intentA)) {
                intentA.setPackage("com.miui.securitycenter");
                if (!c.a(context, intentA)) {
                    intentA.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
                    if (!c.a(context, intentA)) {
                        intentA.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.PermissionsEditorActivity");
                    }
                }
            }
        } else if (str.contains("oppo")) {
            intentA = new Intent();
            intentA.putExtra("packageName", context.getPackageName());
            intentA.setClassName("com.color.safecenter", "com.color.safecenter.permission.floatwindow.FloatWindowListActivity");
            if (!c.a(context, intentA)) {
                intentA.setClassName("com.coloros.safecenter", "com.coloros.safecenter.sysfloatwindow.FloatWindowListActivity");
                if (!c.a(context, intentA)) {
                    intentA.setClassName("com.oppo.safe", "com.oppo.safe.permission.PermissionAppListActivity");
                }
            }
        } else if (str.contains("vivo")) {
            intentA = new Intent();
            intentA.setClassName("com.iqoo.secure", "com.iqoo.secure.ui.phoneoptimize.FloatWindowManager");
            intentA.putExtra("packagename", context.getPackageName());
            if (!c.a(context, intentA)) {
                intentA.setComponent(new ComponentName("com.iqoo.secure", "com.iqoo.secure.safeguard.SoftPermissionDetailActivity"));
            }
        } else if (str.contains("meizu")) {
            intentA = new Intent("com.meizu.safe.security.SHOW_APPSEC");
            intentA.putExtra("packageName", context.getPackageName());
            intentA.setComponent(new ComponentName("com.meizu.safe", "com.meizu.safe.security.AppSecActivity"));
        } else {
            intentA = c.a(context);
        }
        intentA.addFlags(268435456);
        try {
            context.startActivity(intentA);
        } catch (Exception unused) {
            Intent intentA2 = c.a(context);
            intentA2.addFlags(268435456);
            context.startActivity(intentA2);
        }
    }

    public static Intent a(Context context) {
        Intent intent = new Intent("android.settings.MANAGE_APP_ALL_FILES_ACCESS_PERMISSION");
        intent.setData(Uri.parse("package:" + context.getPackageName()));
        if (!a(context, intent)) {
            intent = new Intent(PermissionUtil.ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION);
        }
        if (a(context, intent)) {
            return intent;
        }
        Intent intent2 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent2.setData(Uri.parse("package:" + context.getPackageName()));
        if (a(context, intent2)) {
            return intent2;
        }
        Intent intent3 = new Intent("android.settings.APPLICATION_SETTINGS");
        if (a(context, intent3)) {
            return intent3;
        }
        Intent intent4 = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
        return a(context, intent4) ? intent4 : new Intent("android.settings.SETTINGS");
    }

    public static boolean a(Context context, String str) {
        if (str.equals(RequestManageExternalStoragePermission.MANAGE_EXTERNAL_STORAGE)) {
            return Environment.isExternalStorageManager();
        }
        return Build.VERSION.SDK_INT < 23 || context.checkSelfPermission(str) == 0;
    }

    public static boolean a() {
        return (Build.VERSION.SDK_INT >= 30) && lkxssdk.a.a.d().getApplicationInfo().targetSdkVersion >= 30;
    }

    public static void a(Activity activity, String[] strArr, a aVar) {
        if (strArr == null || strArr.length == 0) {
            return;
        }
        if (Build.VERSION.SDK_INT < 23 && aVar != null) {
            aVar.a();
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList<String> arrayList2 = new ArrayList<>();
        for (String str : strArr) {
            if (a(activity.getApplicationContext(), str)) {
                arrayList.add(str);
            } else {
                arrayList2.add(str);
            }
        }
        if (arrayList2.size() == 0) {
            if (aVar != null) {
                aVar.a();
                return;
            }
            return;
        }
        b bVar = new b();
        Bundle bundle = new Bundle();
        bundle.putInt("request_code", 110);
        bundle.putStringArrayList("request_permissions", arrayList2);
        bVar.setArguments(bundle);
        bVar.a = aVar;
        activity.getFragmentManager().beginTransaction().add(bVar, activity.getClass().getName()).commit();
    }

    public static void a(Activity activity, a aVar) {
        if (Build.VERSION.SDK_INT < 23) {
            aVar.a();
            return;
        }
        if (!a()) {
            a(activity, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"}, aVar);
        } else {
            if (Environment.isExternalStorageManager()) {
                aVar.a();
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(RequestManageExternalStoragePermission.MANAGE_EXTERNAL_STORAGE);
            aVar.a(arrayList, true);
        }
    }
}
