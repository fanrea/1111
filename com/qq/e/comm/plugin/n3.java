package com.qq.e.comm.plugin;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import java.io.File;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class n3 {
    private static Boolean a;
    private static Boolean b;
    private static Boolean c;

    public static long a(Context context) {
        if (context == null) {
            return 0L;
        }
        try {
            return new File(context.getApplicationContext().getPackageManager().getApplicationInfo(context.getPackageName(), 0).sourceDir).length();
        } catch (Exception e) {
            e.getMessage();
            return 0L;
        }
    }

    public static boolean a() {
        if (a == null) {
            try {
                a = Boolean.valueOf((r1.d().a().getApplicationInfo().flags & 2) != 0);
            } catch (Exception unused) {
                a = Boolean.FALSE;
            }
        }
        return a.booleanValue();
    }

    public static boolean b(Context context) {
        ActivityInfo activityInfo;
        if (context == null) {
            return false;
        }
        Boolean bool = b;
        if (bool != null) {
            return bool.booleanValue();
        }
        String str = context.getApplicationInfo().packageName;
        if (!TextUtils.isEmpty(str)) {
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.HOME");
            try {
                ResolveInfo resolveInfoResolveActivity = context.getPackageManager().resolveActivity(intent, 0);
                if (resolveInfoResolveActivity != null && (activityInfo = resolveInfoResolveActivity.activityInfo) != null) {
                    Boolean boolValueOf = Boolean.valueOf(str.equals(activityInfo.packageName));
                    b = boolValueOf;
                    return boolValueOf.booleanValue();
                }
                b = Boolean.FALSE;
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public static boolean b() {
        return r1.d().f().a("ecgpi", 1) == 1;
    }

    public static boolean c(Context context) {
        return (context == null || (context.getApplicationInfo().flags & 1) == 0) ? false : true;
    }

    public static boolean c() {
        Boolean bool = c;
        if (bool != null) {
            return bool.booleanValue();
        }
        r1 r1VarD = r1.d();
        Context contextA = r1VarD.a();
        if (contextA == null) {
            return true;
        }
        boolean zEquals = TextUtils.equals(contextA.getApplicationContext().getPackageName(), r1VarD.b().f());
        c = Boolean.valueOf(zEquals);
        return zEquals;
    }
}
