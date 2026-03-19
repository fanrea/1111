package com.pangrowth.adclog;

import java.io.File;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class c0 {
    public static long a(File file) {
        File[] fileArrListFiles = file.listFiles();
        long jA = 0;
        if (fileArrListFiles == null) {
            return 0L;
        }
        for (File file2 : fileArrListFiles) {
            jA += file2.isDirectory() ? a(file2) : file2.length();
        }
        return jA;
    }
}
