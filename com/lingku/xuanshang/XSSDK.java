package com.lingku.xuanshang;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.lingku.xuanshang.core.data.model.XSListener;
import com.lingku.xuanshang.core.ui.MainActivity;
import lkxssdk.a.a;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class XSSDK {
    public static boolean hasInit() {
        return a.g();
    }

    public static void init(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("the mtId must not be null");
        }
        if (TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("the mtKey must not be null");
        }
        a.a = str;
        a.b = str2;
        a.c = str3;
    }

    public static void setUserId(String str) {
        a.c = str;
    }

    public static void show(Activity activity, String str) {
        show(activity, str, "", null);
    }

    public static void show(Activity activity, String str, XSListener xSListener) {
        show(activity, str, "", xSListener);
    }

    public static void show(Activity activity, String str, String str2) {
        show(activity, str, str2, null);
    }

    public static void show(Activity activity, String str, String str2, XSListener xSListener) {
        a.f = xSListener;
        if (!a.g()) {
            Log.e("XSSDK", "请先初始化SDK,再调用show()接口");
            XSListener xSListener2 = a.f;
            if (xSListener2 != null) {
                xSListener2.onError(-1, "请先初始化SDK");
                return;
            }
            return;
        }
        if (activity != null) {
            a.d = str;
            a.e = str2;
            activity.startActivity(new Intent(activity, (Class<?>) MainActivity.class));
        } else {
            Log.e("XSSDK", "调用show()接口，参数：aty 不能为null");
            XSListener xSListener3 = a.f;
            if (xSListener3 != null) {
                xSListener3.onError(-2, "调用show()接口，参数:aty 不能为null");
            }
        }
    }
}
