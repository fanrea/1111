package com.fendasz.moku.planet.ui.activity;

import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.alipay.sdk.m.l.a;
import com.fendasz.moku.planet.R;
import com.fendasz.moku.planet.common.ReWebChromeClient;
import com.fendasz.moku.planet.helper.CustomerConfigManager;
import com.fendasz.moku.planet.ui.base.activity.BaseBackActivity;
import com.fendasz.moku.planet.utils.ContentUtil;
import com.fendasz.moku.planet.utils.ImageUtils;
import com.fendasz.moku.planet.utils.LogUtils;
import com.fendasz.moku.planet.utils.PermissionUtils;
import com.fendasz.moku.planet.utils.PhoneScreenUtils;
import com.luck.picture.lib.config.SelectMimeType;
import java.io.File;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class MokuCustomerServiceActivity extends BaseBackActivity implements ReWebChromeClient.OpenFileChooserCallBack {
    private static final int REQUEST_CODE_PICK_FILE = 3;
    private static final int REQUEST_CODE_PICK_IMAGE = 1;
    private static final int REQUEST_CODE_TAKE_PHOTO = 2;
    private static final String TAG = "MokuCustomerServiceActivity";
    private static final String baseUtl = "https://tb.53kf.com/code/client/0e85b72dee293d2eb8d729efc730a0137/1";
    private Uri imageUri;
    private LinearLayout mContentView;
    private Context mContext;
    private PhoneScreenUtils mPhoneScreenUtils;
    private Intent mSourceIntent;
    private ValueCallback<Uri> mUploadMsg;
    private ValueCallback<Uri[]> mUploadMsgForAndroid5;
    private WebView webView;

    @Override // android.view.Window.Callback
    public void onPointerCaptureChanged(boolean z) {
    }

    @Override // com.fendasz.moku.planet.ui.base.activity.BaseActivity
    public View initContentView(ViewGroup viewGroup) {
        this.mPhoneScreenUtils = PhoneScreenUtils.getInstance();
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.moku_activity_qqcustomer, (ViewGroup) null);
        this.mContentView = linearLayout;
        return linearLayout;
    }

    @Override // com.fendasz.moku.planet.ui.base.activity.BaseActivity
    public void initTitle(TextView textView) {
        textView.setText("客服中心");
    }

    @Override // com.fendasz.moku.planet.ui.base.activity.BaseActivity
    protected void onLoad() {
        initWebView();
    }

    @Override // com.fendasz.moku.planet.ui.base.activity.BaseActivity
    public void onSuperCreate(Bundle bundle) {
        this.mContext = this;
    }

    private void initWebView() {
        WebView webView = (WebView) this.mContentView.findViewById(R.id.webview_moku_qqservice);
        this.webView = webView;
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setBlockNetworkImage(false);
        if (Build.VERSION.SDK_INT >= 21) {
            settings.setMixedContentMode(0);
        }
        settings.setDomStorageEnabled(true);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(true);
        settings.setCacheMode(2);
        settings.setAllowFileAccess(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setLoadsImagesAutomatically(true);
        settings.setDefaultTextEncodingName("utf-8");
        this.webView.addJavascriptInterface(new JSAndroid(this), "Android");
        this.webView.setWebViewClient(new WebViewClient() { // from class: com.fendasz.moku.planet.ui.activity.MokuCustomerServiceActivity.1
            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView2, String str) {
                if (str.startsWith(a.r)) {
                    webView2.loadUrl(str);
                    return false;
                }
                try {
                    MokuCustomerServiceActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                    return true;
                } catch (Exception e) {
                    e.printStackTrace();
                    return true;
                }
            }

            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView2, String str, Bitmap bitmap) {
                super.onPageStarted(webView2, str, bitmap);
                MokuCustomerServiceActivity.this.webView.setVisibility(0);
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView2, String str) {
                super.onPageFinished(webView2, str);
                TextUtils.isEmpty(webView2.getTitle());
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView2, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                super.onReceivedError(webView2, webResourceRequest, webResourceError);
                int i = Build.VERSION.SDK_INT;
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedSslError(WebView webView2, SslErrorHandler sslErrorHandler, SslError sslError) {
                super.onReceivedSslError(webView2, sslErrorHandler, sslError);
                sslErrorHandler.proceed();
            }
        });
        this.webView.loadUrl(baseUtl);
        this.webView.setWebChromeClient(new ReWebChromeClient(this));
    }

    @Override // com.fendasz.moku.planet.common.ReWebChromeClient.OpenFileChooserCallBack
    public void openFileChooserCallBack(ValueCallback<Uri> valueCallback, String str) {
        this.mUploadMsg = valueCallback;
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setType(SelectMimeType.SYSTEM_IMAGE);
        Intent intentCreateChooser = Intent.createChooser(intent, null);
        this.mSourceIntent = intentCreateChooser;
        startActivityForResult(intentCreateChooser, 1);
    }

    @Override // com.fendasz.moku.planet.common.ReWebChromeClient.OpenFileChooserCallBack
    public boolean openFileChooserCallBackAndroid5(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
        this.mUploadMsgForAndroid5 = valueCallback;
        if (fileChooserParams.getMode() == 0) {
            Intent intent = new Intent("android.intent.action.GET_CONTENT");
            intent.setType(SelectMimeType.SYSTEM_IMAGE);
            Intent intentCreateChooser = Intent.createChooser(intent, null);
            this.mSourceIntent = intentCreateChooser;
            startActivityForResult(intentCreateChooser, 1);
        } else if (PermissionUtils.isGranted(this, "android.permission.READ_EXTERNAL_STORAGE")) {
            Intent intent2 = new Intent("android.intent.action.GET_CONTENT");
            intent2.setType("*/*");
            intent2.addCategory("android.intent.category.OPENABLE");
            startActivityForResult(intent2, 3);
        }
        return true;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) throws Throwable {
        super.onActivityResult(i, i2, intent);
        if (i2 != -1) {
            ValueCallback<Uri> valueCallback = this.mUploadMsg;
            if (valueCallback != null) {
                valueCallback.onReceiveValue(null);
            }
            ValueCallback<Uri[]> valueCallback2 = this.mUploadMsgForAndroid5;
            if (valueCallback2 != null) {
                valueCallback2.onReceiveValue(null);
                return;
            }
            return;
        }
        if (i != 1) {
            if (i != 3) {
                return;
            }
            try {
                if (intent.getData() != null) {
                    String str = TAG;
                    LogUtils.logI(str, "file1=> " + intent.getData().getPath());
                    String filePathFromURI = ContentUtil.getFilePathFromURI(this, intent.getData());
                    if (filePathFromURI == null) {
                        Toast.makeText(this, "获取文件失败", 0).show();
                        return;
                    }
                    LogUtils.logI(str, "file2=> " + filePathFromURI);
                    this.mUploadMsgForAndroid5.onReceiveValue(new Uri[]{Uri.fromFile(new File(filePathFromURI))});
                    return;
                }
                return;
            } catch (Exception e) {
                this.mUploadMsgForAndroid5.onReceiveValue(new Uri[]{Uri.fromFile(new File(intent.getData().getPath()))});
                e.printStackTrace();
                return;
            }
        }
        try {
            if (Build.VERSION.SDK_INT < 21) {
                if (this.mUploadMsg == null) {
                    return;
                }
                String str2 = TAG;
                LogUtils.logI(str2, "imagepath_1=>: " + intent.getData().getPath());
                String strRetrievePath = ImageUtils.retrievePath(this, this.mSourceIntent, intent);
                LogUtils.logI(str2, "imagepath_2=>: " + strRetrievePath);
                if (!TextUtils.isEmpty(strRetrievePath) && new File(strRetrievePath).exists()) {
                    this.mUploadMsg.onReceiveValue(Uri.fromFile(new File(strRetrievePath)));
                }
            } else {
                if (this.mUploadMsgForAndroid5 == null) {
                    return;
                }
                String strRetrievePath2 = ImageUtils.retrievePath(this, this.mSourceIntent, intent);
                if (!TextUtils.isEmpty(strRetrievePath2) && new File(strRetrievePath2).exists()) {
                    this.mUploadMsgForAndroid5.onReceiveValue(new Uri[]{Uri.fromFile(new File(strRetrievePath2))});
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void onActivityResultAboveL(int i, int i2, Intent intent) {
        Uri[] uriArr;
        Uri[] uriArr2;
        if (i != 2 || this.mUploadMsgForAndroid5 == null) {
            return;
        }
        if (i2 != -1) {
            uriArr = null;
        } else if (intent == null) {
            uriArr = new Uri[]{this.imageUri};
        } else {
            String dataString = intent.getDataString();
            ClipData clipData = intent.getClipData();
            if (clipData != null) {
                uriArr2 = new Uri[clipData.getItemCount()];
                for (int i3 = 0; i3 < clipData.getItemCount(); i3++) {
                    uriArr2[i3] = clipData.getItemAt(i3).getUri();
                }
            } else {
                uriArr2 = null;
            }
            uriArr = dataString != null ? new Uri[]{Uri.parse(dataString)} : uriArr2;
        }
        this.mUploadMsgForAndroid5.onReceiveValue(uriArr);
        this.mUploadMsgForAndroid5 = null;
    }

    private class JSAndroid {
        private Activity activity;
        private CustomerConfigManager configManager;

        public JSAndroid(Activity activity) {
            this.activity = activity;
        }

        @JavascriptInterface
        public void openAndroid(String str) {
            this.activity.finish();
        }

        @JavascriptInterface
        public void writeData(String str) {
            CustomerConfigManager customerConfigManager = CustomerConfigManager.getInstance(this.activity);
            this.configManager = customerConfigManager;
            customerConfigManager.setString("js", str);
        }

        @JavascriptInterface
        public String giveInformation(String str) {
            CustomerConfigManager customerConfigManager = CustomerConfigManager.getInstance(this.activity);
            this.configManager = customerConfigManager;
            return customerConfigManager.getString("js");
        }
    }
}
