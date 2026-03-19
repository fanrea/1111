package com.luck.lib.camerax;

import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.fendasz.moku.planet.utils.PermissionUtils;
import com.luck.lib.camerax.listener.CameraListener;
import com.luck.lib.camerax.listener.ClickListener;
import com.luck.lib.camerax.listener.IObtainCameraView;
import com.luck.lib.camerax.listener.ImageCallbackListener;
import com.luck.lib.camerax.permissions.PermissionChecker;
import com.luck.lib.camerax.permissions.PermissionResultCallback;
import com.luck.lib.camerax.utils.SimpleXSpUtils;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class PictureCameraActivity extends AppCompatActivity implements IObtainCameraView {
    private CustomCameraView mCameraView;
    private PermissionResultCallback mPermissionResultCallback;

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        getWindow().setFlags(1024, 1024);
        getWindow().setFlags(67108864, 67108864);
        getWindow().setFlags(134217728, 134217728);
        if (Build.VERSION.SDK_INT >= 28) {
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.layoutInDisplayCutoutMode = 1;
            getWindow().setAttributes(attributes);
        }
        getWindow().addFlags(128);
        super.onCreate(bundle);
        this.mCameraView = new CustomCameraView(this);
        this.mCameraView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        setContentView(this.mCameraView);
        this.mCameraView.post(new Runnable() { // from class: com.luck.lib.camerax.PictureCameraActivity.1
            @Override // java.lang.Runnable
            public void run() {
                PictureCameraActivity.this.mCameraView.setCameraConfig(PictureCameraActivity.this.getIntent());
            }
        });
        this.mCameraView.setImageCallbackListener(new ImageCallbackListener() { // from class: com.luck.lib.camerax.PictureCameraActivity.2
            @Override // com.luck.lib.camerax.listener.ImageCallbackListener
            public void onLoadImage(String str, ImageView imageView) {
                if (CustomCameraConfig.imageEngine != null) {
                    CustomCameraConfig.imageEngine.loadImage(imageView.getContext(), str, imageView);
                }
            }
        });
        this.mCameraView.setCameraListener(new CameraListener() { // from class: com.luck.lib.camerax.PictureCameraActivity.3
            @Override // com.luck.lib.camerax.listener.CameraListener
            public void onPictureSuccess(String str) {
                PictureCameraActivity.this.handleCameraSuccess();
            }

            @Override // com.luck.lib.camerax.listener.CameraListener
            public void onRecordSuccess(String str) {
                PictureCameraActivity.this.handleCameraSuccess();
            }

            @Override // com.luck.lib.camerax.listener.CameraListener
            public void onError(int i, String str, Throwable th) {
                Toast.makeText(PictureCameraActivity.this.getApplicationContext(), str, 1).show();
            }
        });
        this.mCameraView.setOnCancelClickListener(new ClickListener() { // from class: com.luck.lib.camerax.PictureCameraActivity.4
            @Override // com.luck.lib.camerax.listener.ClickListener
            public void onClick() {
                PictureCameraActivity.this.handleCameraCancel();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleCameraSuccess() {
        new Intent().putExtra("output", (Uri) getIntent().getParcelableExtra("output"));
        setResult(-1, getIntent());
        onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleCameraCancel() {
        setResult(0);
        onBackPressed();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            this.mCameraView.onCancelMedia();
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.mCameraView.onConfigurationChanged(configuration);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        CustomCameraConfig.destroy();
        if (Build.VERSION.SDK_INT == 29) {
            finishAfterTransition();
        } else {
            super.onBackPressed();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (CustomCameraConfig.explainListener != null) {
            CustomCameraConfig.explainListener.onDismiss(this.mCameraView);
        }
        if (i == 1102) {
            if (PermissionChecker.checkSelfPermission(this, new String[]{PermissionUtils.PERMISSION_CAMERA})) {
                this.mCameraView.buildUseCameraCases();
                return;
            } else {
                SimpleXSpUtils.putBoolean(this, PermissionUtils.PERMISSION_CAMERA, true);
                handleCameraCancel();
                return;
            }
        }
        if (i != 1103 || PermissionChecker.checkSelfPermission(this, new String[]{PermissionUtils.PERMISSION_RECORD_AUDIO})) {
            return;
        }
        SimpleXSpUtils.putBoolean(this, PermissionUtils.PERMISSION_RECORD_AUDIO, true);
        Toast.makeText(getApplicationContext(), "Missing recording permission", 1).show();
    }

    public void setPermissionsResultAction(PermissionResultCallback permissionResultCallback) {
        this.mPermissionResultCallback = permissionResultCallback;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        this.mCameraView.onDestroy();
        super.onDestroy();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (this.mPermissionResultCallback != null) {
            PermissionChecker.getInstance().onRequestPermissionsResult(iArr, this.mPermissionResultCallback);
            this.mPermissionResultCallback = null;
        }
    }

    @Override // com.luck.lib.camerax.listener.IObtainCameraView
    public ViewGroup getCustomCameraView() {
        return this.mCameraView;
    }
}
