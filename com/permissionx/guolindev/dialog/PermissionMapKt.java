package com.permissionx.guolindev.dialog;

import com.fendasz.moku.planet.utils.PermissionUtils;
import com.kuaishou.weapon.p0.g;
import com.luck.picture.lib.permissions.PermissionConfig;
import com.permissionx.guolindev.PermissionX;
import com.permissionx.guolindev.request.RequestBackgroundLocationPermission;
import com.permissionx.guolindev.request.RequestBodySensorsBackgroundPermission;
import com.permissionx.guolindev.request.RequestInstallPackagesPermission;
import com.permissionx.guolindev.request.RequestManageExternalStoragePermission;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;

/* compiled from: PermissionMap.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\t\"\u0017\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\"\"\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\"\"\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b\"\"\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\b\"\"\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\b¨\u0006\u000f"}, d2 = {"allSpecialPermissions", "", "", "getAllSpecialPermissions", "()Ljava/util/Set;", "permissionMapOnQ", "", "getPermissionMapOnQ", "()Ljava/util/Map;", "permissionMapOnR", "getPermissionMapOnR", "permissionMapOnS", "getPermissionMapOnS", "permissionMapOnT", "getPermissionMapOnT", "permissionx_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class PermissionMapKt {
    private static final Set<String> allSpecialPermissions = SetsKt.setOf(new String[]{RequestBackgroundLocationPermission.ACCESS_BACKGROUND_LOCATION, "android.permission.SYSTEM_ALERT_WINDOW", "android.permission.WRITE_SETTINGS", RequestManageExternalStoragePermission.MANAGE_EXTERNAL_STORAGE, RequestInstallPackagesPermission.REQUEST_INSTALL_PACKAGES, PermissionX.permission.POST_NOTIFICATIONS, RequestBodySensorsBackgroundPermission.BODY_SENSORS_BACKGROUND});
    private static final Map<String, String> permissionMapOnQ;
    private static final Map<String, String> permissionMapOnR;
    private static final Map<String, String> permissionMapOnS;
    private static final Map<String, String> permissionMapOnT;

    public static final Set<String> getAllSpecialPermissions() {
        return allSpecialPermissions;
    }

    static {
        Map<String, String> mapMapOf = MapsKt.mapOf(new Pair[]{TuplesKt.to("android.permission.READ_CALENDAR", "android.permission-group.CALENDAR"), TuplesKt.to("android.permission.WRITE_CALENDAR", "android.permission-group.CALENDAR"), TuplesKt.to("android.permission.READ_CALL_LOG", "android.permission-group.CALL_LOG"), TuplesKt.to("android.permission.WRITE_CALL_LOG", "android.permission-group.CALL_LOG"), TuplesKt.to("android.permission.PROCESS_OUTGOING_CALLS", "android.permission-group.CALL_LOG"), TuplesKt.to(PermissionUtils.PERMISSION_CAMERA, "android.permission-group.CAMERA"), TuplesKt.to("android.permission.READ_CONTACTS", "android.permission-group.CONTACTS"), TuplesKt.to("android.permission.WRITE_CONTACTS", "android.permission-group.CONTACTS"), TuplesKt.to("android.permission.GET_ACCOUNTS", "android.permission-group.CONTACTS"), TuplesKt.to("android.permission.ACCESS_FINE_LOCATION", "android.permission-group.LOCATION"), TuplesKt.to(g.h, "android.permission-group.LOCATION"), TuplesKt.to(RequestBackgroundLocationPermission.ACCESS_BACKGROUND_LOCATION, "android.permission-group.LOCATION"), TuplesKt.to(PermissionUtils.PERMISSION_RECORD_AUDIO, "android.permission-group.MICROPHONE"), TuplesKt.to("android.permission.READ_PHONE_STATE", "android.permission-group.PHONE"), TuplesKt.to("android.permission.READ_PHONE_NUMBERS", "android.permission-group.PHONE"), TuplesKt.to(PermissionUtils.PERMISSION_CALL_PHONE, "android.permission-group.PHONE"), TuplesKt.to("android.permission.ANSWER_PHONE_CALLS", "android.permission-group.PHONE"), TuplesKt.to("com.android.voicemail.permission.ADD_VOICEMAIL", "android.permission-group.PHONE"), TuplesKt.to("android.permission.USE_SIP", "android.permission-group.PHONE"), TuplesKt.to("android.permission.ACCEPT_HANDOVER", "android.permission-group.PHONE"), TuplesKt.to("android.permission.BODY_SENSORS", "android.permission-group.SENSORS"), TuplesKt.to("android.permission.ACTIVITY_RECOGNITION", "android.permission-group.ACTIVITY_RECOGNITION"), TuplesKt.to("android.permission.SEND_SMS", "android.permission-group.SMS"), TuplesKt.to("android.permission.RECEIVE_SMS", "android.permission-group.SMS"), TuplesKt.to("android.permission.READ_SMS", "android.permission-group.SMS"), TuplesKt.to("android.permission.RECEIVE_WAP_PUSH", "android.permission-group.SMS"), TuplesKt.to("android.permission.RECEIVE_MMS", "android.permission-group.SMS"), TuplesKt.to("android.permission.READ_EXTERNAL_STORAGE", "android.permission-group.STORAGE"), TuplesKt.to("android.permission.WRITE_EXTERNAL_STORAGE", "android.permission-group.STORAGE"), TuplesKt.to("android.permission.ACCESS_MEDIA_LOCATION", "android.permission-group.STORAGE")});
        permissionMapOnQ = mapMapOf;
        Map mutableMap = MapsKt.toMutableMap(MapsKt.mapOf(TuplesKt.to(RequestManageExternalStoragePermission.MANAGE_EXTERNAL_STORAGE, "android.permission-group.STORAGE")));
        mutableMap.putAll(mapMapOf);
        Map<String, String> map = MapsKt.toMap(mutableMap);
        permissionMapOnR = map;
        Map mutableMap2 = MapsKt.toMutableMap(MapsKt.mapOf(new Pair[]{TuplesKt.to("android.permission.BLUETOOTH_SCAN", "android.permission-group.NEARBY_DEVICES"), TuplesKt.to("android.permission.BLUETOOTH_ADVERTISE", "android.permission-group.NEARBY_DEVICES"), TuplesKt.to("android.permission.BLUETOOTH_CONNECT", "android.permission-group.NEARBY_DEVICES")}));
        mutableMap2.putAll(map);
        Map<String, String> map2 = MapsKt.toMap(mutableMap2);
        permissionMapOnS = map2;
        Map mutableMap3 = MapsKt.toMutableMap(MapsKt.mapOf(new Pair[]{TuplesKt.to("android.permission.READ_MEDIA_IMAGES", "android.permission-group.READ_MEDIA_VISUAL"), TuplesKt.to("android.permission.READ_MEDIA_VIDEO", "android.permission-group.READ_MEDIA_VISUAL"), TuplesKt.to(PermissionConfig.READ_MEDIA_AUDIO, "android.permission-group.READ_MEDIA_AURAL"), TuplesKt.to(PermissionX.permission.POST_NOTIFICATIONS, "android.permission-group.NOTIFICATIONS"), TuplesKt.to("android.permission.NEARBY_WIFI_DEVICES", "android.permission-group.NEARBY_DEVICES"), TuplesKt.to(RequestBodySensorsBackgroundPermission.BODY_SENSORS_BACKGROUND, "android.permission-group.SENSORS")}));
        mutableMap3.putAll(map2);
        permissionMapOnT = MapsKt.toMap(mutableMap3);
    }

    public static final Map<String, String> getPermissionMapOnQ() {
        return permissionMapOnQ;
    }

    public static final Map<String, String> getPermissionMapOnR() {
        return permissionMapOnR;
    }

    public static final Map<String, String> getPermissionMapOnS() {
        return permissionMapOnS;
    }

    public static final Map<String, String> getPermissionMapOnT() {
        return permissionMapOnT;
    }
}
