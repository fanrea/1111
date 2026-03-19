package com.fendasz.moku.planet.utils;

import android.app.Activity;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Process;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.fendasz.moku.planet.utils.system.utils.SystemUtils;
import com.kuaishou.weapon.p0.g;
import java.util.ArrayList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class PermissionUtils {
    public static final int CODE_ACCESS_COARSE_LOCATION = 6;
    public static final int CODE_ACCESS_FINE_LOCATION = 5;
    public static final int CODE_ALL_PERMISSION = 8848;
    public static final int CODE_CALL_PHONE = 3;
    public static final int CODE_CAMERA = 4;
    public static final int CODE_GET_ACCOUNTS = 1;
    public static final int CODE_MULTI_PERMISSION = 8880;
    public static final int CODE_READ_EXTERNAL_STORAGE = 7;
    public static final int CODE_READ_PHONE_STATE = 2;
    public static final int CODE_RECORD_AUDIO = 0;
    public static final int CODE_WRITE_EXTERNAL_STORAGE = 8;
    public static final String PERMISSION_ACCESS_COARSE_LOCATION = "android.permission.ACCESS_FINE_LOCATION";
    public static final String PERMISSION_ACCESS_FINE_LOCATION = "android.permission.ACCESS_FINE_LOCATION";
    public static final String PERMISSION_GET_ACCOUNTS = "android.permission.GET_ACCOUNTS";
    public static final String PERMISSION_READ_EXTERNAL_STORAGE = "android.permission.READ_EXTERNAL_STORAGE";
    public static final String PERMISSION_READ_MEDIA_IMAGES = "android.permission.READ_MEDIA_IMAGES";
    public static final String PERMISSION_READ_MEDIA_VIDEO = "android.permission.READ_MEDIA_VIDEO";
    public static final String PERMISSION_READ_PHONE_STATE = "android.permission.READ_PHONE_STATE";
    public static final String PERMISSION_WRITE_EXTERNAL_STORAGE = "android.permission.WRITE_EXTERNAL_STORAGE";
    private static String TAG = "PermissionUtils";
    public static final String PERMISSION_RECORD_AUDIO = "android.permission.RECORD_AUDIO";
    public static final String PERMISSION_CALL_PHONE = "android.permission.CALL_PHONE";
    public static final String PERMISSION_CAMERA = "android.permission.CAMERA";
    private static final String[] REQUEST_PERMISSIONS = {PERMISSION_RECORD_AUDIO, "android.permission.GET_ACCOUNTS", "android.permission.READ_PHONE_STATE", PERMISSION_CALL_PHONE, PERMISSION_CAMERA, "android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_FINE_LOCATION", "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"};

    public interface PermissionInterface {
        void onPermissionGranted(int i);

        void onShouldShowRationale(String[] strArr);
    }

    public static void requestPermission(Activity activity, int i, PermissionInterface permissionInterface) {
        if (activity != null && i >= 0) {
            String[] strArr = REQUEST_PERMISSIONS;
            if (i > strArr.length) {
                return;
            }
            if (Build.VERSION.SDK_INT < 23) {
                permissionInterface.onPermissionGranted(i);
                return;
            }
            String str = strArr[i];
            if (ActivityCompat.checkSelfPermission(activity, str) != 0) {
                boolean z = SharedPreferencesUtils.getInstance(activity).getBoolean(str, true);
                boolean zShouldShowRequestPermissionRationale = ActivityCompat.shouldShowRequestPermissionRationale(activity, str);
                if (!z && !zShouldShowRequestPermissionRationale) {
                    permissionInterface.onShouldShowRationale(new String[]{str});
                    return;
                } else {
                    SharedPreferencesUtils.getInstance(activity).putBoolean(str, false);
                    ActivityCompat.requestPermissions(activity, new String[]{str}, i);
                    return;
                }
            }
            permissionInterface.onPermissionGranted(i);
        }
    }

    public static void requestMultiPermissions(Activity activity, String[] strArr, PermissionInterface permissionInterface) {
        ArrayList<String> noGrantedPermission = getNoGrantedPermission(activity, strArr, false);
        ArrayList<String> noGrantedPermission2 = getNoGrantedPermission(activity, strArr, true);
        if (noGrantedPermission.size() > 0) {
            ActivityCompat.requestPermissions(activity, (String[]) noGrantedPermission.toArray(new String[0]), CODE_MULTI_PERMISSION);
        } else if (noGrantedPermission2.size() > 0) {
            permissionInterface.onShouldShowRationale((String[]) noGrantedPermission2.toArray(new String[0]));
        } else {
            permissionInterface.onPermissionGranted(CODE_MULTI_PERMISSION);
        }
    }

    public static void openPermissionSettingActivity(Context context) {
        Intent intent = new Intent();
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", context.getPackageName(), null));
        context.startActivity(intent);
    }

    private static ArrayList<String> getNoGrantedPermission(Activity activity, String[] strArr, boolean z) {
        ArrayList<String> arrayList = new ArrayList<>();
        if (Build.VERSION.SDK_INT >= 23) {
            for (String str : strArr) {
                if (ActivityCompat.checkSelfPermission(activity, str) != 0) {
                    boolean z2 = SharedPreferencesUtils.getInstance(activity).getBoolean(str, true);
                    boolean zShouldShowRequestPermissionRationale = ActivityCompat.shouldShowRequestPermissionRationale(activity, str);
                    if (z2 || zShouldShowRequestPermissionRationale) {
                        SharedPreferencesUtils.getInstance(activity).putBoolean(str, false);
                        if (!z) {
                            arrayList.add(str);
                        }
                    } else if (z) {
                        arrayList.add(str);
                    }
                }
            }
        }
        return arrayList;
    }

    public static boolean isGranted(Context context, String str) {
        if (str == null) {
            return false;
        }
        int i = Build.VERSION.SDK_INT;
        if (i < 23) {
            return true;
        }
        return (i < 33 || !(str.equals("android.permission.READ_EXTERNAL_STORAGE") || str.equals("android.permission.WRITE_EXTERNAL_STORAGE"))) ? ActivityCompat.checkSelfPermission(context, str) == 0 : ActivityCompat.checkSelfPermission(context, "android.permission.READ_MEDIA_IMAGES") == 0 && ActivityCompat.checkSelfPermission(context, "android.permission.READ_MEDIA_VIDEO") == 0;
    }

    public static boolean checkIsRequestDeletePackagesPermissionGranted(Context context) {
        if (SystemUtils.VERSON.ANDROID_VERSION < 28) {
            return true;
        }
        return isGranted(context, "android.permission.REQUEST_DELETE_PACKAGES");
    }

    public static boolean checkUsageStatsPermissions(Context context) {
        return Build.VERSION.SDK_INT < 21 || ((AppOpsManager) context.getSystemService("appops")).checkOpNoThrow("android:get_usage_stats", Process.myUid(), context.getPackageName()) == 0;
    }

    public static void applyUsageStatsPermissions(Context context) {
        if (Build.VERSION.SDK_INT >= 21) {
            context.startActivity(new Intent("android.settings.USAGE_ACCESS_SETTINGS"));
        }
    }

    public static boolean hasLocationPermissions(Context context) {
        if (Build.VERSION.SDK_INT < 23) {
            return true;
        }
        return ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_FINE_LOCATION") == 0 && ActivityCompat.checkSelfPermission(context, g.h) == 0;
    }
}
