package com.luck.lib.camerax.permissions;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.luck.lib.camerax.PictureCameraActivity;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class PermissionChecker {
    public static final int PERMISSION_RECORD_AUDIO_SETTING_CODE = 1103;
    public static final int PERMISSION_SETTING_CODE = 1102;
    private static final int REQUEST_CODE = 10086;
    private static PermissionChecker mInstance;

    private PermissionChecker() {
    }

    public static PermissionChecker getInstance() {
        if (mInstance == null) {
            synchronized (PermissionChecker.class) {
                if (mInstance == null) {
                    mInstance = new PermissionChecker();
                }
            }
        }
        return mInstance;
    }

    public void requestPermissions(Activity activity, String[] strArr, PermissionResultCallback permissionResultCallback) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(strArr);
        requestPermissions(activity, arrayList, 10086, permissionResultCallback);
    }

    public void requestPermissions(Activity activity, List<String[]> list, PermissionResultCallback permissionResultCallback) {
        requestPermissions(activity, list, 10086, permissionResultCallback);
    }

    private void requestPermissions(Activity activity, List<String[]> list, int i, PermissionResultCallback permissionResultCallback) {
        if (activity instanceof PictureCameraActivity) {
            if (Build.VERSION.SDK_INT < 23) {
                if (permissionResultCallback != null) {
                    permissionResultCallback.onGranted();
                    return;
                }
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (String[] strArr : list) {
                for (String str : strArr) {
                    if (ContextCompat.checkSelfPermission(activity, str) != 0) {
                        arrayList.add(str);
                    }
                }
            }
            if (arrayList.size() <= 0) {
                if (permissionResultCallback != null) {
                    permissionResultCallback.onGranted();
                }
            } else {
                ((PictureCameraActivity) activity).setPermissionsResultAction(permissionResultCallback);
                String[] strArr2 = new String[arrayList.size()];
                arrayList.toArray(strArr2);
                ActivityCompat.requestPermissions(activity, strArr2, i);
            }
        }
    }

    public void onRequestPermissionsResult(int[] iArr, PermissionResultCallback permissionResultCallback) {
        if (SimpleXPermissionUtil.isAllGranted(iArr)) {
            permissionResultCallback.onGranted();
        } else {
            permissionResultCallback.onDenied();
        }
    }

    public static boolean checkSelfPermission(Context context, String[] strArr) {
        for (String str : strArr) {
            if (ContextCompat.checkSelfPermission(context.getApplicationContext(), str) != 0) {
                return false;
            }
        }
        return true;
    }
}
