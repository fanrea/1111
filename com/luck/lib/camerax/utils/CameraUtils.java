package com.luck.lib.camerax.utils;

import android.content.ContentValues;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class CameraUtils {
    public static final String CAMERA = "Camera";
    public static final String DCIM_CAMERA = "DCIM/Camera";
    public static final String JPEG = ".jpeg";
    public static final String MIME_TYPE_IMAGE = "image/jpeg";
    public static final String MIME_TYPE_PREFIX_IMAGE = "image";
    public static final String MIME_TYPE_PREFIX_VIDEO = "video";
    public static final String MIME_TYPE_VIDEO = "video/mp4";
    public static final String MP4 = ".mp4";
    public static final int TYPE_IMAGE = 1;
    public static final int TYPE_VIDEO = 2;

    public static ContentValues buildImageContentValues(String str, String str2) {
        String strValueOf = String.valueOf(System.currentTimeMillis());
        ContentValues contentValues = new ContentValues(3);
        if (TextUtils.isEmpty(str) || str.lastIndexOf(".") == -1) {
            contentValues.put("_display_name", DateUtils.getCreateFileName("IMG_"));
        } else {
            contentValues.put("_display_name", str.replaceAll(str.substring(str.lastIndexOf(".")), ""));
        }
        if (TextUtils.isEmpty(str2) || str2.startsWith("video")) {
            str2 = "image/jpeg";
        }
        contentValues.put("mime_type", str2);
        if (Build.VERSION.SDK_INT >= 29) {
            contentValues.put("datetaken", strValueOf);
            contentValues.put("relative_path", "DCIM/Camera");
        }
        return contentValues;
    }

    public static ContentValues buildVideoContentValues(String str, String str2) {
        String strValueOf = String.valueOf(System.currentTimeMillis());
        ContentValues contentValues = new ContentValues(3);
        if (TextUtils.isEmpty(str) || str.lastIndexOf(".") == -1) {
            contentValues.put("_display_name", DateUtils.getCreateFileName("VID_"));
        } else {
            contentValues.put("_display_name", str.replaceAll(str.substring(str.lastIndexOf(".")), ""));
        }
        if (TextUtils.isEmpty(str2) || str2.startsWith("image")) {
            str2 = "video/mp4";
        }
        contentValues.put("mime_type", str2);
        if (Build.VERSION.SDK_INT >= 29) {
            contentValues.put("datetaken", strValueOf);
            contentValues.put("relative_path", Environment.DIRECTORY_MOVIES);
        }
        return contentValues;
    }
}
