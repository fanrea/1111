package com.pangrowth.adclog;

import java.io.File;
import java.io.FilenameFilter;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class e implements FilenameFilter {
    @Override // java.io.FilenameFilter
    public boolean accept(File file, String str) {
        if (str.endsWith(".hoting")) {
            return true;
        }
        return str.endsWith(".hot") && !str.endsWith(".alog.hot");
    }
}
