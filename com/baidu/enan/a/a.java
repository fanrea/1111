package com.baidu.enan.a;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class a {
    private static boolean a(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            System.load(str);
            return true;
        } catch (Throwable th) {
            com.baidu.enan.f.a.a(th);
            return false;
        }
    }

    public static void a(Context context, String str, String str2, String str3) {
        try {
            File file = new File(new File(com.baidu.enan.f.b.b(context), "enan_tmp"), ".tmp_enan");
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(file, com.baidu.enan.f.b.a());
            if (!file2.exists()) {
                file2.mkdirs();
            }
            File file3 = new File(file2, str3 + ".so");
            if (!b.a(str, str2, file3) || a(file3.getAbsolutePath())) {
                return;
            }
            file3.delete();
        } catch (Throwable th) {
            com.baidu.enan.f.a.a(th);
        }
    }
}
