package com.netease.htprotect.p010Ooo.p017oO;

import androidx.core.app.NotificationCompat;
import com.baidu.mobads.container.rewardvideo.NativeRewardActivity;
import com.sigmob.sdk.base.mta.PointCategory;
import java.util.ArrayList;

/* renamed from: com.netease.htprotect.〇Ooo.〇oO.O8〇oO8〇88, reason: invalid class name */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class O8oO888 {
    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private static String m1033O8oO888(int i) {
        switch (i) {
            case -1:
                return "unspecified";
            case 0:
                return NativeRewardActivity.SCREEN_LANDSCAPE;
            case 1:
                return NativeRewardActivity.SCREEN_PORTRAIT;
            case 2:
                return "user";
            case 3:
                return "behind";
            case 4:
                return "sensor";
            case 5:
                return "nosensor";
            case 6:
                return "sensorLandscape";
            case 7:
                return "sensorPortrait";
            case 8:
                return "reverseLandscape";
            case 9:
                return "reversePortrait";
            case 10:
                return "fullSensor";
            case 11:
                return "userLandscape";
            case 12:
                return "userPortrait";
            case 13:
                return "fullUser";
            case 14:
                return PointCategory.LOCKED;
            default:
                return "ScreenOrientation:" + Integer.toHexString(i);
        }
    }

    private static String Oo0(int i) {
        return i != 0 ? i != 1 ? i != 2 ? "installLocation:" + Integer.toHexString(i) : "preferExternal" : "internalOnly" : "auto";
    }

    /* renamed from: 〇O8, reason: contains not printable characters */
    private static String m1034O8(int i) {
        String str;
        ArrayList arrayList = new ArrayList();
        if ((i & 4096) != 0) {
            str = "density";
        } else if ((1073741824 & i) != 0) {
            str = "fontScale";
        } else if ((i & 16) != 0) {
            str = "keyboard";
        } else if ((i & 32) != 0) {
            str = "keyboardHidden";
        } else if ((i & 8192) != 0) {
            str = "direction";
        } else if ((i & 4) != 0) {
            str = "locale";
        } else if ((i & 1) != 0) {
            str = "mcc";
        } else if ((i & 2) != 0) {
            str = "mnc";
        } else if ((i & 64) != 0) {
            str = NotificationCompat.CATEGORY_NAVIGATION;
        } else if ((i & 128) != 0) {
            str = "orientation";
        } else if ((i & 256) != 0) {
            str = "screenLayout";
        } else if ((i & 1024) != 0) {
            str = "screenSize";
        } else if ((i & 2048) != 0) {
            str = "smallestScreenSize";
        } else {
            if ((i & 8) == 0) {
                if ((i & 512) != 0) {
                    str = "uiMode";
                }
                return O.m1053O8oO888((Iterable) arrayList, "|");
            }
            str = "touchscreen";
        }
        arrayList.add(str);
        return O.m1053O8oO888((Iterable) arrayList, "|");
    }

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    private static String m1035Ooo(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? "LaunchMode:" + Integer.toHexString(i) : "singleInstance" : "singleTask" : "singleTop" : "standard";
    }

    /* renamed from: 〇o0〇o0, reason: contains not printable characters */
    private static String m1036o0o0(int i) {
        int i2 = i & 240;
        int i3 = i & 15;
        ArrayList arrayList = new ArrayList(2);
        if (i2 != 0) {
            arrayList.add(i2 != 16 ? i2 != 32 ? i2 != 48 ? "WindowInputModeAdjust:" + Integer.toHexString(i2) : "adjustNothing" : "adjustPan" : "adjustResize");
        }
        if (i3 != 0) {
            arrayList.add(i3 != 1 ? i3 != 2 ? i3 != 3 ? i3 != 4 ? i3 != 5 ? "WindowInputModeState:" + Integer.toHexString(i3) : "stateAlwaysVisible" : "stateVisible" : "stateAlwaysHidden" : "stateHidden" : "stateUnchanged");
        }
        return O.m1053O8oO888((Iterable) arrayList, "|");
    }

    /* renamed from: 〇oO, reason: contains not printable characters */
    private static String m1037oO(int i) {
        ArrayList arrayList = new ArrayList(3);
        if ((i & 16) != 0) {
            i ^= 16;
            arrayList.add("system");
        }
        if ((i & 32) != 0) {
            i ^= 32;
            arrayList.add("development");
        }
        arrayList.add(i != 0 ? i != 1 ? i != 2 ? i != 3 ? "ProtectionLevel:" + Integer.toHexString(i) : "signatureOrSystem" : "signature" : "dangerous" : "normal");
        return O.m1053O8oO888((Iterable) arrayList, "|");
    }
}
