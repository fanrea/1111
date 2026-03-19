package com.bytedance.sdk.djx.core.util;

import android.text.TextUtils;
import com.bytedance.sdk.djx.core.settings.SettingData;
import com.bytedance.sdk.djx.model.DJXImage;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class ImageUtil {
    public static String getCover(List<DJXImage> list, String str) {
        DJXImage dJXImageGuess;
        if (list != null && !list.isEmpty() && (dJXImageGuess = guess("360", list)) != null) {
            if (!TextUtils.isEmpty(dJXImageGuess.url)) {
                return dJXImageGuess.url;
            }
            if (!TextUtils.isEmpty(dJXImageGuess.backupUrl)) {
                return dJXImageGuess.backupUrl;
            }
        }
        return str;
    }

    public static String getVideoFrame(List<DJXImage> list, List<DJXImage> list2, String str) {
        DJXImage dJXImageGuess;
        DJXImage dJXImageGuess2;
        if (!"poster".equalsIgnoreCase(SettingData.getInstance().getShortPlayFirstFrame()) && list2 != null && !list2.isEmpty() && (dJXImageGuess2 = guess("540", list2)) != null) {
            if (!TextUtils.isEmpty(dJXImageGuess2.url)) {
                return dJXImageGuess2.url;
            }
            if (!TextUtils.isEmpty(dJXImageGuess2.backupUrl)) {
                return dJXImageGuess2.backupUrl;
            }
        }
        if (list != null && !list.isEmpty() && (dJXImageGuess = guess("540", list)) != null) {
            if (!TextUtils.isEmpty(dJXImageGuess.url)) {
                return dJXImageGuess.url;
            }
            if (!TextUtils.isEmpty(dJXImageGuess.backupUrl)) {
                return dJXImageGuess.backupUrl;
            }
        }
        return str;
    }

    private static DJXImage guess(String str, List<DJXImage> list) {
        DJXImage dJXImage = null;
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList<DJXImage> arrayList = new ArrayList(list);
        DJXImage dJXImage2 = null;
        DJXImage dJXImage3 = null;
        DJXImage dJXImage4 = null;
        for (DJXImage dJXImage5 : arrayList) {
            if ("original".equalsIgnoreCase(dJXImage5.definition)) {
                dJXImage2 = dJXImage5;
            } else if ("360".equalsIgnoreCase(dJXImage5.definition)) {
                dJXImage3 = dJXImage5;
            } else if ("540".equalsIgnoreCase(dJXImage5.definition)) {
                dJXImage4 = dJXImage5;
            }
        }
        if ("original".equalsIgnoreCase(str)) {
            dJXImage = dJXImage2;
        } else if ("360".equalsIgnoreCase(str)) {
            dJXImage = dJXImage3;
        } else if ("540".equalsIgnoreCase(str)) {
            dJXImage = dJXImage4;
        }
        return dJXImage == null ? (DJXImage) arrayList.get(0) : dJXImage;
    }
}
