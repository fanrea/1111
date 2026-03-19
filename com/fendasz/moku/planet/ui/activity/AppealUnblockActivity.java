package com.fendasz.moku.planet.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.alipay.sdk.m.u.i;
import com.fendasz.moku.planet.R;
import com.fendasz.moku.planet.common.MokuJsObject;
import com.fendasz.moku.planet.common.MokuJsObjectListenerImpl;
import com.fendasz.moku.planet.constants.MokuConstants;
import com.fendasz.moku.planet.entity.ApiDataCallBack;
import com.fendasz.moku.planet.helper.ApiDataHelper;
import com.fendasz.moku.planet.source.bean.UploadVideoReponse;
import com.fendasz.moku.planet.ui.base.activity.BaseBackActivity;
import com.fendasz.moku.planet.ui.dialog.LoadingDialog;
import com.fendasz.moku.planet.utils.FileUtils;
import com.fendasz.moku.planet.utils.LogUtils;
import com.fendasz.moku.planet.utils.PhoneScreenUtils;
import com.fendasz.moku.planet.utils.system.utils.SystemUtils;
import com.luck.picture.lib.config.SelectMimeType;
import java.io.File;
import java.io.IOException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class AppealUnblockActivity extends BaseBackActivity {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int REQUEST_CODE_VIDEO = 400;
    private LinearLayout mContentView;
    private Context mContext;
    private PhoneScreenUtils mPhoneScreenUtils;
    private MokuJsObjectListenerImpl mokuJsListener = null;
    private int taskDataId;
    private int taskRecordId;
    private String uninstallPackageName;
    private WebView webView;
    private static final String DATA_APPEALUNBLOCK_DEBUG = MokuConstants.H5Url.H5_APPEALUNBLOCK_DEBUG.getUrl();
    private static final String DATA_APPEALUNBLOCK_RELEASE = MokuConstants.H5Url.H5_APPEALUNBLOCK_RELEASE.getUrl();
    private static final Long MAX_VIDEO_SIZE = 15360L;
    private static final Long MAX_VIDEO_DURING = 30L;
    private static final String TAG = "AppealUnblockActivity";

    @Override // com.fendasz.moku.planet.ui.base.activity.BaseActivity
    public View initContentView(ViewGroup viewGroup) {
        this.mPhoneScreenUtils = PhoneScreenUtils.getInstance();
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.moku_appeal_unblock, (ViewGroup) null);
        this.mContentView = linearLayout;
        return linearLayout;
    }

    @Override // com.fendasz.moku.planet.ui.base.activity.BaseActivity
    public void initTitle(TextView textView) {
        textView.setText("");
    }

    @Override // com.fendasz.moku.planet.ui.base.activity.BaseActivity
    protected void onLoad() {
        initWebView();
    }

    @Override // com.fendasz.moku.planet.ui.base.activity.BaseActivity
    public void onSuperCreate(Bundle bundle) {
        this.mContext = this;
        if (bundle == null) {
            Intent intent = getIntent();
            this.taskDataId = intent.getIntExtra("taskDataId", -1);
            this.taskRecordId = intent.getIntExtra("taskRecordId", 0);
        } else {
            this.taskDataId = bundle.getInt("taskDataId", -1);
            this.taskRecordId = bundle.getInt("taskRecordId", 0);
        }
        LogUtils.logD(TAG, "onSuperCreate,taskDataId==>" + this.taskDataId + ",taskRecordId==>" + this.taskRecordId);
    }

    private void initWebView() {
        WebView webView = (WebView) this.mContentView.findViewById(R.id.webview_moku_unblock);
        this.webView = webView;
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(false);
        settings.setAllowFileAccess(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setLoadsImagesAutomatically(true);
        settings.setDefaultTextEncodingName("utf-8");
        settings.setDomStorageEnabled(true);
        settings.setDatabaseEnabled(true);
        settings.setAppCacheEnabled(false);
        settings.setCacheMode(2);
        settings.setAllowUniversalAccessFromFileURLs(true);
        settings.setAllowFileAccessFromFileURLs(true);
        MokuJsObject mokuJsObject = new MokuJsObject();
        initMokuJsLisetener();
        mokuJsObject.setOnMokuJsListener(this.mokuJsListener);
        this.webView.addJavascriptInterface(mokuJsObject, "android");
        this.webView.setWebViewClient(new WebViewClient() { // from class: com.fendasz.moku.planet.ui.activity.AppealUnblockActivity.1
            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView2, String str) {
                webView2.loadUrl(str);
                return true;
            }

            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView2, String str, Bitmap bitmap) {
                super.onPageStarted(webView2, str, bitmap);
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView2, String str) {
                super.onPageFinished(webView2, str);
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView2, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                super.onReceivedError(webView2, webResourceRequest, webResourceError);
                if (Build.VERSION.SDK_INT >= 23) {
                    LogUtils.logD(AppealUnblockActivity.TAG, "request==>,errorCode==" + webResourceError.getErrorCode() + ",errorMsg=>" + ((Object) webResourceError.getDescription()) + i.d);
                }
            }
        });
        this.webView.loadUrl(DATA_APPEALUNBLOCK_RELEASE);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        String str;
        super.onStart();
        LogUtils.logD(TAG, "uninstallPackageName==>" + this.uninstallPackageName);
        if (SystemUtils.isAppExist(this, this.uninstallPackageName) || (str = this.uninstallPackageName) == null || str.isEmpty()) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            this.webView.evaluateJavascript("javascript:getUninstallApp('" + this.uninstallPackageName + "')", new ValueCallback<String>() { // from class: com.fendasz.moku.planet.ui.activity.AppealUnblockActivity.2
                @Override // android.webkit.ValueCallback
                public void onReceiveValue(String str2) {
                }
            });
        } else {
            this.webView.loadUrl("javascript:getUninstallApp(" + this.uninstallPackageName + ")");
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        super.onActivityResult(i, i2, intent);
        if (i != 400 || intent == null) {
            return;
        }
        String uriPath = null;
        try {
            uriPath = FileUtils.getUriPath(this, intent.getData());
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (TextUtils.isEmpty(uriPath)) {
            return;
        }
        LoadingDialog.show(this.mContext);
        System.currentTimeMillis();
        File file = new File(uriPath);
        long length = file.length() / 1024;
        if (0 == length) {
            return;
        }
        if (length > MAX_VIDEO_SIZE.longValue()) {
            showToast("视频超出限制");
            return;
        }
        MediaPlayer mediaPlayer = new MediaPlayer();
        try {
            mediaPlayer.setDataSource(file.getPath());
            mediaPlayer.prepare();
            if (mediaPlayer.getDuration() / 1000 > MAX_VIDEO_DURING.longValue()) {
                showToast("视频超出限制");
                return;
            }
        } catch (IOException e2) {
            showToast("视频处理异常，请重新操作");
            LogUtils.logE(TAG, "dispose video error,because " + e2.getMessage());
        }
        uploadFile(file);
    }

    /* renamed from: com.fendasz.moku.planet.ui.activity.AppealUnblockActivity$3, reason: invalid class name */
    class AnonymousClass3 extends MokuJsObjectListenerImpl {
        AnonymousClass3(Context context) {
            super(context);
        }

        @Override // com.fendasz.moku.planet.common.MokuJsObjectListenerImpl
        protected void setTitle(String str) {
            super.setTitle(str);
            AppealUnblockActivity.this.mTvTitle.getCenterTextView().setText(str);
        }

        @Override // com.fendasz.moku.planet.common.MokuJsObjectListenerImpl
        protected void notifyH5Token(int i, String str) {
            super.notifyH5Token(i, str);
            if (Build.VERSION.SDK_INT >= 19) {
                AppealUnblockActivity.this.webView.evaluateJavascript("javascript:androidToken(" + i + ",'" + str + "')", new ValueCallback() { // from class: com.fendasz.moku.planet.ui.activity.AppealUnblockActivity$3$$ExternalSyntheticLambda0
                    @Override // android.webkit.ValueCallback
                    public final void onReceiveValue(Object obj) {
                        LogUtils.logD(AppealUnblockActivity.TAG, (String) obj);
                    }
                });
            } else {
                AppealUnblockActivity.this.webView.loadUrl("javascript:androidToken(" + i + ",'" + str + "')");
            }
        }

        @Override // com.fendasz.moku.planet.common.MokuJsObjectListenerImpl
        protected void uninstallPackage(String str) {
            super.uninstallPackage(str);
            AppealUnblockActivity.this.uninstallPackageName = str;
        }

        @Override // com.fendasz.moku.planet.common.MokuJsObjectListenerImpl
        protected void webviewFinish() {
            super.webviewFinish();
            AppealUnblockActivity.this.finish();
        }

        @Override // com.fendasz.moku.planet.common.MokuJsObjectListenerImpl
        protected void selectVideo() {
            super.selectVideo();
            Intent intent = new Intent();
            if (Build.VERSION.SDK_INT < 19) {
                intent.setAction("android.intent.action.GET_CONTENT");
            } else {
                intent.setAction("android.intent.action.OPEN_DOCUMENT");
            }
            intent.setType(SelectMimeType.SYSTEM_VIDEO);
            intent.addCategory("android.intent.category.OPENABLE");
            try {
                ((AppealUnblockActivity) AppealUnblockActivity.this.mContext).startActivityForResult(intent, 400);
            } catch (Exception unused) {
                LogUtils.logD(AppealUnblockActivity.TAG, "no activity found");
            }
        }

        @Override // com.fendasz.moku.planet.common.MokuJsObjectListenerImpl
        protected void unblockResult(boolean z) {
            super.unblockResult(z);
            Intent intent = new Intent();
            intent.putExtra(MokuConstants.INTENT_KEY_UNBLOCKRESULT, z);
            AppealUnblockActivity.this.setResult(800, intent);
            AppealUnblockActivity.this.finish();
        }
    }

    private void initMokuJsLisetener() {
        this.mokuJsListener = new AnonymousClass3(this);
    }

    private void uploadFile(File file) {
        LoadingDialog.show(this.mContext);
        ApiDataHelper.getApiDataHelper().uploadVideo(this.mContext, file, new ApiDataCallBack<UploadVideoReponse>() { // from class: com.fendasz.moku.planet.ui.activity.AppealUnblockActivity.4
            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void success(int i, UploadVideoReponse uploadVideoReponse) throws Exception {
                LoadingDialog.dismiss();
                if (Build.VERSION.SDK_INT >= 19) {
                    AppealUnblockActivity.this.webView.evaluateJavascript("javascript:receptionVideoUrl('" + uploadVideoReponse.getDownloadPath() + "')", new ValueCallback<String>() { // from class: com.fendasz.moku.planet.ui.activity.AppealUnblockActivity.4.1
                        @Override // android.webkit.ValueCallback
                        public void onReceiveValue(String str) {
                        }
                    });
                } else {
                    AppealUnblockActivity.this.webView.loadUrl("javascript:receptionVideoUrl(" + uploadVideoReponse.getDownloadPath() + ")");
                }
            }

            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void error(int i, String str) throws Exception {
                LogUtils.logE(AppealUnblockActivity.TAG, "upload video error,code=>" + i);
                LoadingDialog.dismiss();
                AppealUnblockActivity.this.showToast(str);
            }
        });
    }

    @Override // com.fendasz.moku.planet.ui.base.activity.BaseBackActivity, com.fendasz.moku.planet.ui.base.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        this.webView.removeAllViews();
        this.mContentView.removeView(this.webView);
        this.webView.destroy();
        this.mokuJsListener.finish();
        this.webView = null;
        super.onDestroy();
    }
}
