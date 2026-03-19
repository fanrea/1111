package com.blankj.utilcode.constant;

import android.os.Build;
import com.fendasz.moku.planet.utils.PermissionUtils;
import com.kuaishou.weapon.p0.g;
import com.permissionx.guolindev.request.RequestBackgroundLocationPermission;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public final class PermissionConstants {
    public static final String ACTIVITY_RECOGNITION = "ACTIVITY_RECOGNITION";
    public static final String CALENDAR = "CALENDAR";
    public static final String CAMERA = "CAMERA";
    public static final String CONTACTS = "CONTACTS";
    public static final String LOCATION = "LOCATION";
    public static final String MICROPHONE = "MICROPHONE";
    public static final String PHONE = "PHONE";
    public static final String SENSORS = "SENSORS";
    public static final String SMS = "SMS";
    public static final String STORAGE = "STORAGE";
    private static final String[] GROUP_CALENDAR = {"android.permission.READ_CALENDAR", "android.permission.WRITE_CALENDAR"};
    private static final String[] GROUP_CAMERA = {PermissionUtils.PERMISSION_CAMERA};
    private static final String[] GROUP_CONTACTS = {"android.permission.READ_CONTACTS", "android.permission.WRITE_CONTACTS", "android.permission.GET_ACCOUNTS"};
    private static final String[] GROUP_LOCATION = {"android.permission.ACCESS_FINE_LOCATION", g.h, RequestBackgroundLocationPermission.ACCESS_BACKGROUND_LOCATION};
    private static final String[] GROUP_MICROPHONE = {PermissionUtils.PERMISSION_RECORD_AUDIO};
    private static final String[] GROUP_PHONE = {"android.permission.READ_PHONE_STATE", "android.permission.READ_PHONE_NUMBERS", PermissionUtils.PERMISSION_CALL_PHONE, "android.permission.READ_CALL_LOG", "android.permission.WRITE_CALL_LOG", "com.android.voicemail.permission.ADD_VOICEMAIL", "android.permission.USE_SIP", "android.permission.PROCESS_OUTGOING_CALLS", "android.permission.ANSWER_PHONE_CALLS"};
    private static final String[] GROUP_PHONE_BELOW_O = {"android.permission.READ_PHONE_STATE", "android.permission.READ_PHONE_NUMBERS", PermissionUtils.PERMISSION_CALL_PHONE, "android.permission.READ_CALL_LOG", "android.permission.WRITE_CALL_LOG", "com.android.voicemail.permission.ADD_VOICEMAIL", "android.permission.USE_SIP", "android.permission.PROCESS_OUTGOING_CALLS"};
    private static final String[] GROUP_SENSORS = {"android.permission.BODY_SENSORS"};
    private static final String[] GROUP_SMS = {"android.permission.SEND_SMS", "android.permission.RECEIVE_SMS", "android.permission.READ_SMS", "android.permission.RECEIVE_WAP_PUSH", "android.permission.RECEIVE_MMS"};
    private static final String[] GROUP_STORAGE = {"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"};
    private static final String[] GROUP_ACTIVITY_RECOGNITION = {"android.permission.ACTIVITY_RECOGNITION"};

    @Retention(RetentionPolicy.SOURCE)
    public @interface PermissionGroup {
    }

    public static String[] getPermissions(String str) {
        if (str == null) {
            return new String[0];
        }
        str.hashCode();
        switch (str) {
            case "LOCATION":
                return GROUP_LOCATION;
            case "SENSORS":
                return GROUP_SENSORS;
            case "STORAGE":
                return GROUP_STORAGE;
            case "SMS":
                return GROUP_SMS;
            case "PHONE":
                if (Build.VERSION.SDK_INT < 26) {
                    return GROUP_PHONE_BELOW_O;
                }
                return GROUP_PHONE;
            case "ACTIVITY_RECOGNITION":
                return GROUP_ACTIVITY_RECOGNITION;
            case "CONTACTS":
                return GROUP_CONTACTS;
            case "CALENDAR":
                return GROUP_CALENDAR;
            case "MICROPHONE":
                return GROUP_MICROPHONE;
            case "CAMERA":
                return GROUP_CAMERA;
            default:
                return new String[]{str};
        }
    }
}
