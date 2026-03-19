package com.ss.android.downloadlib.h;

import java.io.File;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class h {
    public static long d(File file) {
        if (file == null || !file.exists()) {
            return 0L;
        }
        return d(file, file.lastModified(), 0);
    }

    private static long d(File file, long j, int i) {
        File[] fileArrListFiles;
        if (file != null && file.exists()) {
            j = Math.max(j, file.lastModified());
            int i2 = i + 1;
            if (i2 >= 50) {
                return j;
            }
            if (file.isDirectory() && (fileArrListFiles = file.listFiles()) != null) {
                for (File file2 : fileArrListFiles) {
                    j = Math.max(j, d(file2, j, i2));
                }
            }
        }
        return j;
    }
}
