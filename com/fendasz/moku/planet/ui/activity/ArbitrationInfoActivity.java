package com.fendasz.moku.planet.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
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
import com.fendasz.moku.planet.ui.base.activity.BaseBackActivity;
import com.fendasz.moku.planet.utils.LogUtils;
import com.fendasz.moku.planet.utils.PhoneScreenUtils;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class ArbitrationInfoActivity extends BaseBackActivity {
    public static final int REQUEST_CODE_FORM_MOKU_ARBITRATIONDETAIL = 300;
    private LinearLayout mContentView;
    private Context mContext;
    private PhoneScreenUtils mPhoneScreenUtils;
    private MokuJsObjectListenerImpl mokuJsListener = null;
    private int taskDataId;
    private int taskRecordId;
    private WebView webView;
    private static final String DATA_DETAILURL_DEBUG = MokuConstants.H5Url.H5_ARBITRATION_DETAIL_DEBUG_LOCAL.getUrl();
    private static final String DATA_DETAILURL_RELEASE = MokuConstants.H5Url.H5_ARBITRATION_DETAIL_RELEASE.getUrl();
    private static final String TAG = "ArbitrationInfoActivity";

    @Override // com.fendasz.moku.planet.ui.base.activity.BaseActivity
    public View initContentView(ViewGroup viewGroup) {
        this.mPhoneScreenUtils = PhoneScreenUtils.getInstance();
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.moku_task_arbitration, (ViewGroup) null);
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
        WebView webView = (WebView) this.mContentView.findViewById(R.id.webview_moku_arbitration);
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
        this.webView.setWebViewClient(new WebViewClient() { // from class: com.fendasz.moku.planet.ui.activity.ArbitrationInfoActivity.1
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
                    Log.d(ArbitrationInfoActivity.TAG, "request==>,errorCode==" + webResourceError.getErrorCode() + ",errorMsg=>" + ((Object) webResourceError.getDescription()) + i.d);
                }
            }
        });
        this.webView.loadUrl(DATA_DETAILURL_RELEASE + "?arbitrationId=" + this.taskRecordId + "&recordstate=4");
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == 602) {
            setResult(602);
            finish();
        }
    }

    private void initMokuJsLisetener() {
        this.mokuJsListener = new MokuJsObjectListenerImpl(this) { // from class: com.fendasz.moku.planet.ui.activity.ArbitrationInfoActivity.2
            @Override // com.fendasz.moku.planet.common.MokuJsObjectListenerImpl
            protected void setTitle(String str) {
                super.setTitle(str);
                ArbitrationInfoActivity.this.mTvTitle.getCenterTextView().setText(str);
            }

            @Override // com.fendasz.moku.planet.common.MokuJsObjectListenerImpl
            protected void notifyH5Token(int i, String str) {
                super.notifyH5Token(i, str);
                if (Build.VERSION.SDK_INT >= 19) {
                    ArbitrationInfoActivity.this.webView.evaluateJavascript("javascript:androidToken(" + i + ",'" + str + "')", new ValueCallback<String>() { // from class: com.fendasz.moku.planet.ui.activity.ArbitrationInfoActivity.2.1
                        @Override // android.webkit.ValueCallback
                        public void onReceiveValue(String str2) {
                            Log.d(ArbitrationInfoActivity.TAG, str2);
                        }
                    });
                } else {
                    ArbitrationInfoActivity.this.webView.loadUrl("javascript:androidToken(" + i + ",'" + str + "')");
                }
            }
        };
    }
}
