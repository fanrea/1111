package com.qq.e.comm.plugin;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.baidu.mobstat.forbes.Config;
import com.fendasz.moku.planet.utils.QqUtils;
import org.json.JSONException;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class m3 {
    private static final boolean a;
    private static volatile String b;

    static {
        a = r1.d().f().a("gvfqe", 1) == 1;
    }

    private static String a(String str) throws JSONException, PackageManager.NameNotFoundException {
        ja jaVar = new ja();
        if (TextUtils.isEmpty(str)) {
            b10.b(100192, null, 1, jaVar);
            return null;
        }
        jaVar.a(Config.INPUT_DEF_PKG, str);
        Context contextA = r1.d().a();
        if (contextA == null) {
            b10.b(100192, null, 2, jaVar);
            return null;
        }
        try {
            PackageManager packageManager = contextA.getPackageManager();
            if (packageManager == null) {
                b10.b(100192, null, 3, jaVar);
                return null;
            }
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            if (packageInfo == null) {
                b10.b(100192, null, 4, jaVar);
                return "";
            }
            return packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.toString();
            b10.b(100192, null, 5, jaVar);
            return "";
        } catch (Exception e2) {
            e2.toString();
            b10.b(100192, null, 6, jaVar);
            return "";
        }
    }

    public static String a() {
        if (!a) {
            return "";
        }
        if (b == null) {
            synchronized (m3.class) {
                if (b == null) {
                    b = a(QqUtils.PACKAGENAME_QQ);
                }
            }
        }
        return b == null ? "" : b;
    }
}
