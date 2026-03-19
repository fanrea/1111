package com.baidu.mobstat.forbes.util;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.helios.OnGetIdResultCallback;
import com.baidu.mobstat.forbes.ap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class CuidUtil {
    public static String getOaid(Context context) {
        return "";
    }

    /* renamed from: com.baidu.mobstat.forbes.util.CuidUtil$1, reason: invalid class name */
    final class AnonymousClass1 implements OnGetIdResultCallback<String> {
        AnonymousClass1() {
        }

        public void onResult(String str, Bundle bundle) {
        }

        public void onError(int i, Throwable th, Bundle bundle) {
        }
    }

    public static String getCuid3(Context context) {
        return "";
    }

    /* renamed from: com.baidu.mobstat.forbes.util.CuidUtil$2, reason: invalid class name */
    final class AnonymousClass2 implements OnGetIdResultCallback<String> {
        AnonymousClass2() {
        }

        public void onResult(String str, Bundle bundle) {
        }

        public void onError(int i, Throwable th, Bundle bundle) {
        }
    }

    public static String getSsaid(Context context) {
        return "";
    }

    public static String getIid(Context context) {
        return "";
    }

    public static String getGaid(Context context) {
        return "";
    }

    /* renamed from: com.baidu.mobstat.forbes.util.CuidUtil$3, reason: invalid class name */
    final class AnonymousClass3 implements OnGetIdResultCallback<String> {
        AnonymousClass3() {
        }

        public void onResult(String str, Bundle bundle) {
            if (!TextUtils.isEmpty(str)) {
                ap.a().b(str);
            }
        }

        public void onError(int i, Throwable th, Bundle bundle) {
        }
    }
}
