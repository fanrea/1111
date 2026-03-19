package com.luck.picture.lib;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.luck.picture.lib.basic.PictureCommonFragment;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.permissions.PermissionChecker;
import com.luck.picture.lib.permissions.PermissionConfig;
import com.luck.picture.lib.permissions.PermissionResultCallback;
import com.luck.picture.lib.utils.SdkVersionUtils;
import com.luck.picture.lib.utils.ToastUtils;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class PictureOnlyCameraFragment extends PictureCommonFragment {
    public static final String TAG = "PictureOnlyCameraFragment";

    public static PictureOnlyCameraFragment newInstance() {
        return new PictureOnlyCameraFragment();
    }

    @Override // com.luck.picture.lib.basic.PictureCommonFragment
    public String getFragmentTag() {
        return TAG;
    }

    @Override // com.luck.picture.lib.basic.PictureCommonFragment, com.luck.picture.lib.basic.IPictureSelectorCommonEvent
    public int getResourceId() {
        return R.layout.ps_empty;
    }

    @Override // com.luck.picture.lib.basic.PictureCommonFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (bundle == null) {
            if (SdkVersionUtils.isQ()) {
                openSelectedCamera();
            } else {
                final String[] strArr = {"android.permission.WRITE_EXTERNAL_STORAGE"};
                PermissionChecker.getInstance().requestPermissions(this, strArr, new PermissionResultCallback() { // from class: com.luck.picture.lib.PictureOnlyCameraFragment.1
                    @Override // com.luck.picture.lib.permissions.PermissionResultCallback
                    public void onGranted() {
                        PictureOnlyCameraFragment.this.openSelectedCamera();
                    }

                    @Override // com.luck.picture.lib.permissions.PermissionResultCallback
                    public void onDenied() {
                        PictureOnlyCameraFragment.this.handlePermissionDenied(strArr);
                    }
                });
            }
        }
    }

    @Override // com.luck.picture.lib.basic.PictureCommonFragment, com.luck.picture.lib.basic.IPictureSelectorCommonEvent
    public void dispatchCameraMediaResult(LocalMedia localMedia) {
        if (confirmSelect(localMedia, false) == 0) {
            dispatchTransformResult();
        } else {
            onKeyBackFragmentFinish();
        }
    }

    @Override // com.luck.picture.lib.basic.PictureCommonFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == 0) {
            onKeyBackFragmentFinish();
        }
    }

    @Override // com.luck.picture.lib.basic.PictureCommonFragment, com.luck.picture.lib.basic.IPictureSelectorCommonEvent
    public void handlePermissionSettingResult(String[] strArr) {
        boolean zIsCheckCamera;
        onPermissionExplainEvent(false, null);
        if (this.selectorConfig.onPermissionsEventListener != null) {
            zIsCheckCamera = this.selectorConfig.onPermissionsEventListener.hasPermissions(this, strArr);
        } else {
            zIsCheckCamera = PermissionChecker.isCheckCamera(getContext());
            if (!SdkVersionUtils.isQ()) {
                zIsCheckCamera = PermissionChecker.isCheckWriteExternalStorage(getContext());
            }
        }
        if (zIsCheckCamera) {
            openSelectedCamera();
        } else {
            if (!PermissionChecker.isCheckCamera(getContext())) {
                ToastUtils.showToast(getContext(), getString(R.string.ps_camera));
            } else if (!PermissionChecker.isCheckWriteExternalStorage(getContext())) {
                ToastUtils.showToast(getContext(), getString(R.string.ps_jurisdiction));
            }
            onKeyBackFragmentFinish();
        }
        PermissionConfig.CURRENT_REQUEST_PERMISSION = new String[0];
    }
}
