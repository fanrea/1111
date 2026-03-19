package com.baidu.mobads.container.activity;

import android.animation.Animator;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.Window;
import android.view.WindowManager;
import com.baidu.mobads.container.XAdInstanceInfoExt;
import com.baidu.mobads.container.util.bq;
import com.baidu.mobads.container.util.by;
import com.baidu.mobads.sdk.api.IActivityImpl;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;
import com.style.widget.b.e;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class DownloadDialogActivity implements IActivityImpl {
    public static final String AD_DIALOG_TYPE = "dialogType";
    public static final String AD_PARCEL_INFO = "adElementInfo";
    private static final String TAG = DownloadDialogActivity.class.getSimpleName();
    private Activity activity;
    private XAdInstanceInfoExt adInfo;
    private IOAdEventListener lpCloseListener;
    private Dialog mDlKeepDialog;
    private com.baidu.mobads.container.components.a.k mDlKeepDialogEventListener;
    private com.style.widget.b.e mDownloadDialogView;
    private Dialog mPromoteDlDialog;
    private com.baidu.mobads.container.components.a.k mPromoteDlDialogEventListener;
    private String appSid = "";
    private String prod = "";
    private String apId = "";
    private int dialogType = 0;
    private int needDlKeepDialog = 0;
    private int mPromoteDlDialogTimeMs = -1;
    Handler mApkLinkDialogHandler = new Handler();
    private boolean mPromoteDlDialogShow = false;
    private boolean mApkLinkDialogShow = false;

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onCreate(Bundle bundle) {
        e.a().a(1);
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
            String stringExtra = intent.getStringExtra("adElementInfo");
            if (!TextUtils.isEmpty(stringExtra)) {
                try {
                    this.adInfo = new XAdInstanceInfoExt(new JSONObject(stringExtra));
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            this.appSid = intent.getStringExtra("appsid");
            this.prod = intent.getStringExtra("prod");
            this.apId = intent.getStringExtra("apid");
            this.dialogType = intent.getIntExtra(AD_DIALOG_TYPE, 0);
            this.needDlKeepDialog = intent.getIntExtra(com.baidu.mobads.container.landingpage.a.q, this.needDlKeepDialog);
            this.mPromoteDlDialogTimeMs = intent.getIntExtra(com.baidu.mobads.container.landingpage.a.r, this.mPromoteDlDialogTimeMs);
        }
        sendDownloadDialogLog("download_dialog_open");
        Window window = this.activity.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = -1;
        attributes.gravity = 80;
        window.setAttributes(attributes);
        this.mDownloadDialogView = new e.a(this.adInfo).a(com.baidu.mobads.container.config.b.a().f()).a(this.appSid, this.prod, this.apId).a(new f(this, this.activity, this.adInfo)).a(this.activity, this.dialogType);
        this.mDownloadDialogView.a();
        this.activity.setContentView(this.mDownloadDialogView);
        if (this.needDlKeepDialog == 1) {
            this.mDlKeepDialogEventListener = new i(this);
        }
        if (this.mPromoteDlDialogTimeMs != -1) {
            this.mPromoteDlDialogEventListener = new j(this);
        }
        if (this.mPromoteDlDialogTimeMs != -1) {
            this.mApkLinkDialogHandler.postDelayed(new k(this), this.mPromoteDlDialogTimeMs);
        }
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
        return false;
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
        com.baidu.mobads.container.l.g.h(TAG).e("onConfigurationChanged: " + configuration.orientation);
        if (this.mDownloadDialogView != null) {
            this.mDownloadDialogView.removeAllViews();
            this.mDownloadDialogView.a(configuration.orientation);
        }
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
    public String getAdInfo(String str) {
        JSONObject originJsonObject;
        if (this.adInfo != null && (originJsonObject = this.adInfo.getOriginJsonObject()) != null && !TextUtils.isEmpty(str)) {
            return originJsonObject.optString(str);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendDownloadDialogLog(String str) {
        if (this.adInfo == null) {
            return;
        }
        try {
            by.a.a(this.activity.getApplicationContext()).a(803).a(this.adInfo).a(this.appSid).b(this.apId).c(this.prod).a("reason", str).a("materialtype", this.adInfo.getMaterialType()).a("dialogtype", this.dialogType).g();
        } catch (Throwable th) {
            bq.a().c(TAG, th.getMessage());
        }
    }

    private static class a implements IOAdEventListener {
        private a() {
        }

        /* synthetic */ a(f fVar) {
            this();
        }

        @Override // com.baidu.mobads.sdk.api.IOAdEventListener
        public void run(IOAdEvent iOAdEvent) {
            if (com.baidu.mobads.container.components.k.b.F.equals(iOAdEvent.getType())) {
                e.a().a(6);
            }
            if (com.baidu.mobads.container.components.k.b.G.equals(iOAdEvent.getType())) {
                e.a().a(9);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void registerLpCloseReceiver(Context context, String str) {
        this.lpCloseListener = new a(null);
        com.baidu.mobads.container.landingpage.ad.a(context).a();
        com.baidu.mobads.container.landingpage.ad.a(context).addEventListener(str, this.lpCloseListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishActivityWithAnim() {
        com.baidu.mobads.container.util.animation.a aVarB;
        if (this.mDownloadDialogView != null && (aVarB = this.mDownloadDialogView.b()) != null) {
            Animator animatorI = aVarB.i();
            animatorI.addListener(new m(this, animatorI));
            com.baidu.mobads.container.l.g.h(TAG).d("dialogExitAnimation start");
            return;
        }
        finishActivity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishActivity() {
        if (this.activity != null) {
            if (this.mPromoteDlDialogTimeMs != -1 && !this.mPromoteDlDialogShow) {
                sendWinUrl(404, "dialogClose", 202);
            }
            this.activity.finish();
        }
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onDestroy() {
        if (this.mPromoteDlDialog != null) {
            this.mPromoteDlDialog.dismiss();
        }
        if (this.mDlKeepDialog != null) {
            this.mDlKeepDialog.dismiss();
        }
        this.mApkLinkDialogHandler.removeCallbacksAndMessages(null);
        e.a().a(2);
        if (this.activity != null && this.lpCloseListener != null) {
            com.baidu.mobads.container.landingpage.ad.a(this.activity.getApplicationContext()).b();
            this.lpCloseListener = null;
        }
    }

    private boolean isRecreatingActivity() {
        if (this.activity != null) {
            return this.activity.isChangingConfigurations() || (com.baidu.mobads.container.util.x.a(null).a() >= 24 && this.activity.isInMultiWindowMode());
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initDialog(Context context, int i, String str, com.baidu.mobads.container.components.a.k kVar, Dialog dialog) {
        dialog.setCancelable(false);
        dialog.requestWindowFeature(1);
        dialog.setContentView(new com.baidu.mobads.container.components.a.a(context, false, i, str, kVar));
        if (dialog.getWindow() != null) {
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
            WindowManager.LayoutParams attributes = dialog.getWindow().getAttributes();
            if (attributes != null) {
                attributes.width = -1;
                attributes.height = -2;
                dialog.getWindow().setAttributes(attributes);
            }
        }
        dialog.setOnKeyListener(new n(this));
        dialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendWinUrl(int i, String str, int i2) {
        if (this.activity != null && this.adInfo != null) {
            new com.baidu.mobads.container.components.command.a().a(this.activity.getApplicationContext(), 1, this.prod, this.adInfo.getBuyer(), this.adInfo.getQueryKey(), this.adInfo.getAdId(), this.adInfo.getAppPackageName(), i, str, i2);
        }
    }
}
