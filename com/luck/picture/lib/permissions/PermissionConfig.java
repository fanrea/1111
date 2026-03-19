package com.luck.picture.lib.permissions;

import android.content.Context;
import com.fendasz.moku.planet.utils.PermissionUtils;
import com.luck.picture.lib.config.SelectMimeType;
import com.luck.picture.lib.utils.SdkVersionUtils;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class PermissionConfig {
    public static final String READ_EXTERNAL_STORAGE = "android.permission.READ_EXTERNAL_STORAGE";
    public static final String READ_MEDIA_AUDIO = "android.permission.READ_MEDIA_AUDIO";
    public static final String READ_MEDIA_IMAGES = "android.permission.READ_MEDIA_IMAGES";
    public static final String READ_MEDIA_VIDEO = "android.permission.READ_MEDIA_VIDEO";
    public static final String WRITE_EXTERNAL_STORAGE = "android.permission.WRITE_EXTERNAL_STORAGE";
    public static String[] CURRENT_REQUEST_PERMISSION = new String[0];
    public static final String[] CAMERA = {PermissionUtils.PERMISSION_CAMERA};

    public static String[] getReadPermissionArray(Context context, int i) {
        if (SdkVersionUtils.isTIRAMISU()) {
            int i2 = context.getApplicationInfo().targetSdkVersion;
            if (i == SelectMimeType.ofImage()) {
                if (i2 >= 33) {
                    return new String[]{"android.permission.READ_MEDIA_IMAGES"};
                }
                return new String[]{"android.permission.READ_MEDIA_IMAGES", "android.permission.READ_EXTERNAL_STORAGE"};
            }
            if (i == SelectMimeType.ofVideo()) {
                if (i2 >= 33) {
                    return new String[]{"android.permission.READ_MEDIA_VIDEO"};
                }
                return new String[]{"android.permission.READ_MEDIA_VIDEO", "android.permission.READ_EXTERNAL_STORAGE"};
            }
            if (i == SelectMimeType.ofAudio()) {
                if (i2 >= 33) {
                    return new String[]{READ_MEDIA_AUDIO};
                }
                return new String[]{READ_MEDIA_AUDIO, "android.permission.READ_EXTERNAL_STORAGE"};
            }
            if (i2 >= 33) {
                return new String[]{"android.permission.READ_MEDIA_IMAGES", "android.permission.READ_MEDIA_VIDEO"};
            }
            return new String[]{"android.permission.READ_MEDIA_IMAGES", "android.permission.READ_MEDIA_VIDEO", "android.permission.READ_EXTERNAL_STORAGE"};
        }
        return new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"};
    }
}
