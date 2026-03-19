package com.bykv.vk.component.ttvideo.utils;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class LiveUtils {
    public static int versionStringToInt(String str) throws NumberFormatException {
        if (str == null || str.isEmpty()) {
            return 0;
        }
        String[] strArrSplit = str.split("\\.");
        if (strArrSplit.length <= 0) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < strArrSplit.length; i2++) {
            if (i2 == 0) {
                i = Integer.parseInt(strArrSplit[i2]);
            } else {
                i = (i * 100) + Integer.parseInt(strArrSplit[i2]);
            }
        }
        return i;
    }
}
