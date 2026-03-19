package com.sigmob.sdk.videocache.file;

import android.text.TextUtils;
import com.sigmob.sdk.videocache.r;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class f implements c {
    private static final int a = 4;

    private String b(String url) {
        int iLastIndexOf = url.lastIndexOf(46);
        return (iLastIndexOf == -1 || iLastIndexOf <= url.lastIndexOf(47) || (iLastIndexOf + 2) + 4 <= url.length()) ? "" : url.substring(iLastIndexOf + 1, url.length());
    }

    @Override // com.sigmob.sdk.videocache.file.c
    public String a(String url) {
        String strB = b(url);
        String strD = r.d(url);
        return TextUtils.isEmpty(strB) ? strD : strD + "." + strB;
    }
}
