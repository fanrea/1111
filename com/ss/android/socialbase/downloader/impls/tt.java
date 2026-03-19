package com.ss.android.socialbase.downloader.impls;

import android.text.TextUtils;
import java.security.NoSuchAlgorithmException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class tt implements com.ss.android.socialbase.downloader.downloader.uo {
    @Override // com.ss.android.socialbase.downloader.downloader.uo
    public int d(String str, String str2) throws NoSuchAlgorithmException {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return 0;
        }
        String strU = com.ss.android.socialbase.downloader.e.an.u(String.format("%s_%s", str, str2));
        if (TextUtils.isEmpty(strU)) {
            return 0;
        }
        return strU.hashCode();
    }
}
