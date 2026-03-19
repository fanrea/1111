package com.fc.tjcpl.sdk;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.fragment.app.Fragment;
import com.fc.tjcpl.sdk.a.f;
import com.fc.tjcpl.sdk.b.a;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class TJSDK {
    public static Fragment getTJFragment(String str, String str2) {
        f fVar = new f();
        Bundle bundle = new Bundle();
        bundle.putString("taskId", str);
        bundle.putString("oaid", str2);
        fVar.setArguments(bundle);
        return fVar;
    }

    public static boolean hasInit() {
        return a.f();
    }

    public static void init(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("the appId must not be null");
        }
        if (TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("the appKey must not be null");
        }
        a.c = str;
        a.d = str2;
        a.e = str3;
    }

    public static void setUserId(String str) {
        a.e = str;
    }

    public static void show(Activity activity, String str) {
        show(activity, str, null);
    }

    public static void show(Activity activity, String str, TJListener tJListener) {
        a.f = tJListener;
        if (!a.f()) {
            Log.e("TJSDK", "请先初始化SDK,再调用show()接口");
            TJListener tJListener2 = a.f;
            if (tJListener2 != null) {
                tJListener2.onError(-1, "请先初始化SDK");
                return;
            }
            return;
        }
        if (activity != null) {
            Intent intent = new Intent(activity, (Class<?>) TJActivity.class);
            intent.putExtra("oaid", str);
            activity.startActivity(intent);
        } else {
            Log.e("TJSDK", "调用show()接口，参数：aty 不能为null");
            TJListener tJListener3 = a.f;
            if (tJListener3 != null) {
                tJListener3.onError(-2, "调用show()接口，参数:aty 不能为null");
            }
        }
    }

    public static void showDetail(Activity activity, String str, String str2) {
        showDetail(activity, str, str2, null);
    }

    public static void showDetail(Activity activity, String str, String str2, TJListener tJListener) {
        a.f = tJListener;
        if (!a.f()) {
            Log.e("TJSDK", "请先初始化SDK,再调用showDetail()接口");
            TJListener tJListener2 = a.f;
            if (tJListener2 != null) {
                tJListener2.onError(-1, "请先初始化SDK");
                return;
            }
            return;
        }
        if (activity == null) {
            Log.e("TJSDK", "调用showDetail()接口，参数：aty 不能为null");
            TJListener tJListener3 = a.f;
            if (tJListener3 != null) {
                tJListener3.onError(-2, "调用showDetail()接口，参数:aty 不能为null");
                return;
            }
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            Intent intent = new Intent(activity, (Class<?>) TJActivity.class);
            intent.putExtra("taskId", str);
            intent.putExtra("oaid", str2);
            activity.startActivity(intent);
            return;
        }
        Log.e("TJSDK", "调用showDetail()接口，参数：idTask 不能为空");
        TJListener tJListener4 = a.f;
        if (tJListener4 != null) {
            tJListener4.onError(-2, "调用showDetail()接口，参数:idTask 不能为空");
        }
    }
}
