package com.pangrowth.adclog;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class k2 {
    public static boolean a = false;
    public static String b;

    public static File a(Context context, String str) throws Throwable {
        if (!TextUtils.isEmpty(str)) {
            a = true;
            b = str;
        }
        StringBuilder sbAppend = new StringBuilder().append(context.getApplicationInfo().dataDir);
        String str2 = File.separator;
        String string = sbAppend.append(str2).append("databases").toString();
        String str3 = context.getApplicationInfo().dataDir + str2 + "dbFiles";
        String str4 = str3 + str2 + "/tmp";
        File file = new File(string);
        if (file.exists()) {
            for (File file2 : file.listFiles()) {
                String name = file2.getName();
                if (name.endsWith(".db") && !a && !s2.a(file2.getAbsolutePath(), str4, name)) {
                    return null;
                }
                if (a && !TextUtils.isEmpty(b) && b.equals(name) && !s2.a(file2.getAbsolutePath(), str4, name)) {
                    return null;
                }
            }
        }
        try {
            StringBuilder sbAppend2 = new StringBuilder().append(str3);
            String str5 = File.separator;
            s2.b(str4, sbAppend2.append(str5).append("db.zip").toString());
            s2.a(str4);
            return new File(str3 + str5 + "db.zip");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
