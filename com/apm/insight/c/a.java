package com.apm.insight.c;

import com.apm.insight.g;
import com.baidu.mobstat.forbes.Config;
import java.io.File;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class a {
    public static void a() {
        File[] fileArrListFiles;
        File file = new File(g.f().getFilesDir(), "apminsight/crashCommand");
        if (file.exists() && (fileArrListFiles = file.listFiles()) != null) {
            for (File file2 : fileArrListFiles) {
                try {
                    String[] strArrSplit = file2.getName().split(Config.replace);
                    if (strArrSplit[0].equals(String.valueOf(0))) {
                        a(strArrSplit);
                    }
                    file2.delete();
                } catch (Throwable th) {
                    com.apm.insight.b.a().a("NPTH_CATCH", th);
                    try {
                        file2.delete();
                    } catch (Throwable unused) {
                    }
                }
            }
        }
    }

    private static void a(String... strArr) {
    }
}
