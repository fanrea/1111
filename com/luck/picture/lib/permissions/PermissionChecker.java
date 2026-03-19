package com.luck.picture.lib.permissions;

import android.content.Context;
import android.os.Build;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.fendasz.moku.planet.utils.PermissionUtils;
import com.luck.picture.lib.basic.PictureCommonFragment;
import com.luck.picture.lib.config.SelectMimeType;
import com.luck.picture.lib.utils.ActivityCompatHelper;
import com.luck.picture.lib.utils.SdkVersionUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class PermissionChecker {
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

    public void requestPermissions(Fragment fragment, String[] strArr, PermissionResultCallback permissionResultCallback) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(strArr);
        requestPermissions(fragment, arrayList, 10086, permissionResultCallback);
    }

    public void requestPermissions(Fragment fragment, List<String[]> list, PermissionResultCallback permissionResultCallback) {
        requestPermissions(fragment, list, 10086, permissionResultCallback);
    }

    private void requestPermissions(Fragment fragment, List<String[]> list, int i, PermissionResultCallback permissionResultCallback) {
        if (!ActivityCompatHelper.isDestroy(fragment.getActivity()) && (fragment instanceof PictureCommonFragment)) {
            if (Build.VERSION.SDK_INT < 23) {
                if (permissionResultCallback != null) {
                    permissionResultCallback.onGranted();
                    return;
                }
                return;
            }
            FragmentActivity activity = fragment.getActivity();
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
                ((PictureCommonFragment) fragment).setPermissionsResultAction(permissionResultCallback);
                String[] strArr2 = new String[arrayList.size()];
                arrayList.toArray(strArr2);
                fragment.requestPermissions(strArr2, i);
                ActivityCompat.requestPermissions(activity, strArr2, i);
            }
        }
    }

    public void onRequestPermissionsResult(int[] iArr, PermissionResultCallback permissionResultCallback) {
        if (PermissionUtil.isAllGranted(iArr)) {
            permissionResultCallback.onGranted();
        } else {
            permissionResultCallback.onDenied();
        }
    }

    public static boolean checkSelfPermission(Context context, String[] strArr) {
        if (strArr != null) {
            for (String str : strArr) {
                if (ContextCompat.checkSelfPermission(context.getApplicationContext(), str) != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isCheckReadStorage(int i, Context context) {
        if (SdkVersionUtils.isTIRAMISU()) {
            if (i == SelectMimeType.ofImage()) {
                return isCheckReadImages(context);
            }
            if (i == SelectMimeType.ofVideo()) {
                return isCheckReadVideo(context);
            }
            if (i == SelectMimeType.ofAudio()) {
                return isCheckReadAudio(context);
            }
            return isCheckReadImages(context) && isCheckReadVideo(context);
        }
        return isCheckReadExternalStorage(context);
    }

    public static boolean isCheckReadImages(Context context) {
        return checkSelfPermission(context, new String[]{"android.permission.READ_MEDIA_IMAGES"});
    }

    public static boolean isCheckReadVideo(Context context) {
        return checkSelfPermission(context, new String[]{"android.permission.READ_MEDIA_VIDEO"});
    }

    public static boolean isCheckReadAudio(Context context) {
        return checkSelfPermission(context, new String[]{PermissionConfig.READ_MEDIA_AUDIO});
    }

    public static boolean isCheckWriteExternalStorage(Context context) {
        return checkSelfPermission(context, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"});
    }

    public static boolean isCheckReadExternalStorage(Context context) {
        return checkSelfPermission(context, new String[]{"android.permission.READ_EXTERNAL_STORAGE"});
    }

    public static boolean isCheckCamera(Context context) {
        return checkSelfPermission(context, new String[]{PermissionUtils.PERMISSION_CAMERA});
    }

    public static boolean isCheckSelfPermission(Context context, String[] strArr) {
        return checkSelfPermission(context, strArr);
    }
}
