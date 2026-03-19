package com.luck.picture.lib.utils;

import android.content.Context;
import android.os.Environment;
import java.util.HashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class FileDirMap {
    private static final HashMap<Integer, String> dirMap = new HashMap<>();

    public static void init(Context context) {
        if (ActivityCompatHelper.assertValidRequest(context)) {
            HashMap<Integer, String> map = dirMap;
            if (map.get(1) == null) {
                map.put(1, context.getExternalFilesDir(Environment.DIRECTORY_PICTURES).getPath());
            }
            if (map.get(2) == null) {
                map.put(2, context.getExternalFilesDir(Environment.DIRECTORY_MOVIES).getPath());
            }
            if (map.get(3) == null) {
                map.put(3, context.getExternalFilesDir(Environment.DIRECTORY_MUSIC).getPath());
            }
        }
    }

    public static String getFileDirPath(Context context, int i) {
        HashMap<Integer, String> map = dirMap;
        String str = map.get(Integer.valueOf(i));
        if (str != null) {
            return str;
        }
        init(context);
        return map.get(Integer.valueOf(i));
    }

    public static void clear() {
        dirMap.clear();
    }
}
