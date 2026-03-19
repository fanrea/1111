package com.fendasz.moku.planet.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Base64;
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
import com.fendasz.moku.planet.utils.FileUtils;
import com.fendasz.moku.planet.utils.ImageUtils;
import com.fendasz.moku.planet.utils.LogUtils;
import com.fendasz.moku.planet.utils.PhoneScreenUtils;
import com.luck.picture.lib.config.SelectMimeType;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class ComplaintActivity extends BaseBackActivity {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String DATA_DETAILURL_DEBUG = MokuConstants.H5Url.H5_COMPLAINT_DEBUG_LOCAL.getUrl();
    private static final String DATA_DETAILURL_RELEASE = MokuConstants.H5Url.H5_COMPLAINT_RELEASE.getUrl();
    private static final String TAG = "ArbitrationInfoActivity";
    private LinearLayout mContentView;
    private Context mContext;
    private PhoneScreenUtils mPhoneScreenUtils;
    private MokuJsObjectListenerImpl mokuJsListener = null;
    private int taskDataId;
    private int taskRecordId;
    private WebView webView;

    @Override // com.fendasz.moku.planet.ui.base.activity.BaseActivity
    public View initContentView(ViewGroup viewGroup) {
        this.mPhoneScreenUtils = PhoneScreenUtils.getInstance();
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.moku_task_complaint, (ViewGroup) null);
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
        WebView webView = (WebView) this.mContentView.findViewById(R.id.webview_moku_complaint);
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
        this.webView.setWebViewClient(new WebViewClient() { // from class: com.fendasz.moku.planet.ui.activity.ComplaintActivity.1
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
                    Log.d(ComplaintActivity.TAG, "request==>,errorCode==" + webResourceError.getErrorCode() + ",errorMsg=>" + ((Object) webResourceError.getDescription()) + i.d);
                }
            }
        });
        this.webView.loadUrl(DATA_DETAILURL_RELEASE + "?taskDataId=" + this.taskDataId);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) throws UnsupportedEncodingException {
        String uriPath;
        super.onActivityResult(i, i2, intent);
        if (intent == null) {
            return;
        }
        try {
            uriPath = FileUtils.getUriPath(this, intent.getData());
        } catch (Exception e) {
            e.printStackTrace();
            uriPath = null;
        }
        if (TextUtils.isEmpty(uriPath)) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            File fileCompressSize = ImageUtils.compressSize(getExternalCacheDir().getPath(), uriPath);
            if (fileCompressSize == null) {
                return;
            }
            sendImageCropressBroadcast(true, null);
            String strEncodeToString = Base64.encodeToString(FileUtils.readFile(fileCompressSize), 0);
            try {
                strEncodeToString = URLEncoder.encode(strEncodeToString, "UTF-8");
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
            if (Build.VERSION.SDK_INT >= 19) {
                this.webView.evaluateJavascript("javascript:readFileSend('" + strEncodeToString + "'," + i + ")", new ValueCallback() { // from class: com.fendasz.moku.planet.ui.activity.ComplaintActivity$$ExternalSyntheticLambda0
                    @Override // android.webkit.ValueCallback
                    public final void onReceiveValue(Object obj) {
                        Log.d(ComplaintActivity.TAG, (String) obj);
                    }
                });
            } else {
                this.webView.loadUrl("javascript:readFileSend('" + strEncodeToString + "')");
            }
            Log.d(TAG, "readFileSend_time==>" + (System.currentTimeMillis() - jCurrentTimeMillis));
        } catch (Exception e3) {
            e3.printStackTrace();
            sendImageCropressBroadcast(false, e3.getMessage());
        }
    }

    private void sendImageCropressBroadcast(boolean z, String str) {
        Intent intent = new Intent(this.mContext.getString(R.string.moku_broadcast_name_action_compress));
        intent.putExtra(this.mContext.getString(R.string.moku_intent_extra_compress_image_code), z ? 0 : -1);
        if (z) {
            str = "success";
        }
        intent.putExtra(this.mContext.getString(R.string.moku_intent_extra_compress_image_message), str);
        intent.setPackage(getPackageName());
        sendBroadcast(intent);
    }

    private void initMokuJsLisetener() {
        this.mokuJsListener = new MokuJsObjectListenerImpl(this) { // from class: com.fendasz.moku.planet.ui.activity.ComplaintActivity.2
            @Override // com.fendasz.moku.planet.common.MokuJsObjectListenerImpl
            protected void setTitle(String str) {
                super.setTitle(str);
                ComplaintActivity.this.mTvTitle.getCenterTextView().setText(str);
            }

            @Override // com.fendasz.moku.planet.common.MokuJsObjectListenerImpl
            protected void webviewFinish() {
                super.webviewFinish();
                Log.d(ComplaintActivity.TAG, "mokuJsListener_webviewFinish");
                ComplaintActivity.this.finish();
            }

            @Override // com.fendasz.moku.planet.common.MokuJsObjectListenerImpl
            public void openPhoneAlbum(int i) {
                super.openPhoneAlbum(i);
                Intent intent = new Intent();
                if (Build.VERSION.SDK_INT < 19) {
                    intent.setAction("android.intent.action.GET_CONTENT");
                } else {
                    intent.setAction("android.intent.action.OPEN_DOCUMENT");
                }
                intent.setType(SelectMimeType.SYSTEM_IMAGE);
                intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
                intent.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                intent.addCategory("android.intent.category.OPENABLE");
                try {
                    ((ComplaintActivity) ComplaintActivity.this.mContext).startActivityForResult(intent, i);
                } catch (Exception unused) {
                    Log.d(ComplaintActivity.TAG, "no activity found");
                }
            }

            @Override // com.fendasz.moku.planet.common.MokuJsObjectListenerImpl
            protected void notifyH5Token(int i, String str) {
                super.notifyH5Token(i, str);
                if (Build.VERSION.SDK_INT >= 19) {
                    ComplaintActivity.this.webView.evaluateJavascript("javascript:androidToken(" + i + ",'" + str + "')", new ValueCallback<String>() { // from class: com.fendasz.moku.planet.ui.activity.ComplaintActivity.2.1
                        @Override // android.webkit.ValueCallback
                        public void onReceiveValue(String str2) {
                            Log.d(ComplaintActivity.TAG, str2);
                        }
                    });
                } else {
                    ComplaintActivity.this.webView.loadUrl("javascript:androidToken(" + i + ",'" + str + "')");
                }
            }
        };
    }

    @Override // com.fendasz.moku.planet.ui.base.activity.BaseBackActivity, com.fendasz.moku.planet.ui.base.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.webView.removeAllViews();
        this.webView.destroy();
        this.mokuJsListener.finish();
    }
}
