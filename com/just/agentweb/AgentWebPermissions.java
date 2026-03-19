package com.just.agentweb;

import android.os.Build;
import com.fendasz.moku.planet.utils.PermissionUtils;
import com.kuaishou.weapon.p0.g;
import com.luck.picture.lib.permissions.PermissionConfig;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class AgentWebPermissions {
    public static final String ACTION_CAMERA = "Camera";
    public static final String ACTION_LOCATION = "Location";
    public static final String ACTION_MEDIA = "Media";
    public static String[] CAMERA = {PermissionUtils.PERMISSION_CAMERA};
    public static String[] LOCATION = {"android.permission.ACCESS_FINE_LOCATION", g.h};
    public static String[] MEDIA;

    static {
        if (Build.VERSION.SDK_INT >= 33) {
            MEDIA = new String[]{"android.permission.READ_MEDIA_VIDEO", PermissionConfig.READ_MEDIA_AUDIO, "android.permission.READ_MEDIA_IMAGES"};
        } else {
            MEDIA = new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"};
        }
    }

    public static void dontAskUnnecessaryPermissions() {
        if (Build.VERSION.SDK_INT >= 29) {
            emptyMediaPermission();
            emptyCameraPermission();
        }
    }

    private static void emptyCameraPermission() {
        CAMERA = new String[0];
    }

    private static void emptyMediaPermission() {
        MEDIA = new String[0];
    }
}
