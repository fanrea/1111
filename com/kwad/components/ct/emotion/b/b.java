package com.kwad.components.ct.emotion.b;

import android.text.TextUtils;
import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b {
    private static volatile b aCn;
    private Map<String, String> aCo = new ConcurrentHashMap();
    private Map<String, String> aCp = new ConcurrentHashMap();
    private String aCq;

    public static b DO() {
        if (aCn == null) {
            synchronized (b.class) {
                if (aCn == null) {
                    aCn = new b();
                }
            }
        }
        return aCn;
    }

    private b() {
    }

    public final void bJ(String str) {
        File[] fileArrListFiles;
        File[] fileArrListFiles2;
        this.aCq = str + File.separator + "message_emoji_resource";
        File file = new File(this.aCq);
        if (!file.exists()) {
            file.mkdir();
        }
        File file2 = new File(DP());
        if (file2.exists() && file2.isDirectory() && (fileArrListFiles2 = file2.listFiles()) != null) {
            for (File file3 : fileArrListFiles2) {
                int iLastIndexOf = file3.getName().lastIndexOf(46);
                if (iLastIndexOf > 0) {
                    this.aCo.put(file3.getName().substring(0, iLastIndexOf), file3.getAbsolutePath());
                }
            }
        }
        File file4 = new File(DQ());
        if (file4.exists() && file4.isDirectory() && (fileArrListFiles = file4.listFiles()) != null) {
            for (File file5 : fileArrListFiles) {
                int iLastIndexOf2 = file5.getName().lastIndexOf(46);
                if (iLastIndexOf2 > 0) {
                    this.aCp.put(file5.getName().substring(0, iLastIndexOf2), file5.getAbsolutePath());
                }
            }
        }
    }

    final String DP() {
        return TextUtils.isEmpty(this.aCq) ? "" : this.aCq + File.separator + "small";
    }

    final String DQ() {
        return TextUtils.isEmpty(this.aCq) ? "" : this.aCq + File.separator + "big";
    }

    final void f(String str, String str2, boolean z) {
        if (z) {
            this.aCp.put(str, DQ() + File.separator + str2);
        } else {
            this.aCo.put(str, DP() + File.separator + str2);
        }
    }

    public final String c(String str, boolean z) {
        if (z) {
            return this.aCp.get(str);
        }
        return this.aCo.get(str);
    }

    public final boolean d(String str, boolean z) {
        if (z) {
            return this.aCp.containsKey(str);
        }
        return this.aCo.containsKey(str);
    }
}
