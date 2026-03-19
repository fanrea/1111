package com.baidu.enan.e.b.g;

import android.os.Build;
import com.baidu.enan.e.d.c;
import java.io.File;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class a {
    public static String[] a(String str) {
        String[] strArr = {"", "", "", ""};
        try {
            File file = new File(str);
            if (file.exists()) {
                if (Build.VERSION.SDK_INT <= 22) {
                    strArr[2] = String.valueOf(file.lastModified());
                    return strArr;
                }
                for (String str2 : c.a("stat " + file.getAbsolutePath(), false).b.split("\\|")) {
                    if (str2.contains("Device")) {
                        String[] strArrSplit = str2.split("Inode:");
                        if (strArrSplit.length > 1) {
                            String[] strArrSplit2 = strArrSplit[1].split("Links");
                            if (strArrSplit2.length > 0) {
                                strArr[0] = strArrSplit2[0].trim();
                            }
                        }
                    }
                    if (str2.contains("Access") && !str2.contains("Uid")) {
                        String[] strArrSplit3 = str2.split("Access:");
                        if (strArrSplit3.length > 1) {
                            strArr[1] = strArrSplit3[1].trim();
                        }
                    }
                    if (str2.contains("Modify")) {
                        String[] strArrSplit4 = str2.split("Modify:");
                        if (strArrSplit4.length > 1) {
                            strArr[2] = strArrSplit4[1].trim();
                        }
                    }
                    if (str2.contains("Change")) {
                        String[] strArrSplit5 = str2.split("Change:");
                        if (strArrSplit5.length > 1) {
                            strArr[3] = strArrSplit5[1].trim();
                        }
                    }
                }
            }
        } catch (Throwable th) {
            com.baidu.enan.f.b.a(th);
        }
        return strArr;
    }
}
