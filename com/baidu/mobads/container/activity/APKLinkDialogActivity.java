package com.baidu.mobads.container.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import com.baidu.mobads.sdk.api.IActivityImpl;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class APKLinkDialogActivity implements IActivityImpl {
    public static final String APP_NAME = "app_name";
    public static final String DOWNLOAD_DIALOG_TYPE = "download_dialog_type";
    private static final String TAG = APKLinkDialogActivity.class.getSimpleName();
    private Activity activity;
    private String mAppName = "";
    private int mDownloadDialogType = 0;

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onCreate(Bundle bundle) {
        if (this.activity == null) {
            return;
        }
        e.a().a(10);
        Intent intent = this.activity.getIntent();
        if (com.baidu.mobads.container.util.x.a(this.activity).a() >= 21) {
            try {
                this.activity.getWindow().clearFlags(67108864);
                this.activity.getWindow().addFlags(Integer.MIN_VALUE);
                this.activity.getWindow().getDecorView().setSystemUiVisibility(1024);
                this.activity.getWindow().setStatusBarColor(0);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (intent != null) {
            this.mAppName = intent.getStringExtra("app_name");
            this.mDownloadDialogType = intent.getIntExtra(DOWNLOAD_DIALOG_TYPE, 0);
        }
        this.activity.setContentView(new com.baidu.mobads.container.components.a.a(this.activity.getApplicationContext(), true, this.mDownloadDialogType, this.mAppName, new a(this)));
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onStart() {
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onResume() {
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onPause() {
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onStop() {
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onNewIntent(Intent intent) {
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public boolean onBackPressed() {
        return true;
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onActivityResult(int i, int i2, Intent intent) {
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onWindowFocusChanged(boolean z) {
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onAttachedToWindow() {
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onDetachedFromWindow() {
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return false;
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return false;
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        return false;
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onSaveInstanceState(Bundle bundle) {
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onRestoreInstanceState(Bundle bundle) {
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void overridePendingTransition(int i, int i2) {
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void setLpBussParam(JSONObject jSONObject) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishActivity() {
        if (this.activity != null) {
            this.activity.finish();
        }
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onDestroy() {
    }
}
