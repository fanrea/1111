package com.fendasz.moku.planet.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.alibaba.fastjson.JSON;
import com.alipay.sdk.m.l.a;
import com.alipay.sdk.m.u.b;
import com.alipay.sdk.m.u.i;
import com.bytedance.sdk.djx.core.log.ILogConst;
import com.fendasz.moku.planet.R;
import com.fendasz.moku.planet.common.MokuJsObject;
import com.fendasz.moku.planet.common.MokuJsObjectListenerImpl;
import com.fendasz.moku.planet.constants.MokuConstants;
import com.fendasz.moku.planet.entity.ApiDataCallBack;
import com.fendasz.moku.planet.entity.EasyCollectionEntity;
import com.fendasz.moku.planet.entity.PhoneInfo;
import com.fendasz.moku.planet.entity.TokenInfo;
import com.fendasz.moku.planet.helper.ApiDataHelper;
import com.fendasz.moku.planet.helper.ApiTaskOperationHelper;
import com.fendasz.moku.planet.helper.MokuConfigure;
import com.fendasz.moku.planet.source.bean.ClientGameTaskData;
import com.fendasz.moku.planet.ui.base.activity.BaseBackActivity;
import com.fendasz.moku.planet.ui.customview.MokuIconTextView;
import com.fendasz.moku.planet.ui.dialog.CustomBuildDialog;
import com.fendasz.moku.planet.ui.dialog.GuideDialog;
import com.fendasz.moku.planet.ui.dialog.LoadingDialog;
import com.fendasz.moku.planet.utils.AesUtil;
import com.fendasz.moku.planet.utils.LogUtils;
import com.fendasz.moku.planet.utils.PhoneScreenUtils;
import com.fendasz.moku.planet.utils.StringUtils;
import com.fendasz.moku.planet.utils.canvas.CanvasUtils;
import java.net.URISyntaxException;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class EasyTaskDetailActivity extends BaseBackActivity {
    private static final int CODE_COUNT_DOWN = 3;
    private static final int CODE_START_TASK = 0;
    private static final int CODE_SUBMIT_ANSWER = 5;
    private static final int CODE_TASK_STATUS = 4;
    private static final int CODE_UPLOAD_SCREENSHOT = 1;
    private static final int CODE_VIEW_INIT = 2;
    private static final String DATA_EASYTASKURL_DEBUG = MokuConstants.H5Url.H5_EASYTASK_DEBUG.getUrl();
    private static final String DATA_EASYTASK_RELEASE = MokuConstants.H5Url.H5_EASYTASK_RELEASE.getUrl();
    public static final int REQUEST_CODE_OPENEASYCOLLECTION = 20;
    public static final int RESULT_CODE_FOR_FINISH = 2;
    public static final int RESULT_CODE_FOR_REFRESH_TASK_LIST = 300;
    private static final String TAG = "EasyTaskDetailActivity==>";
    private String mAdditionalData;
    private ApiTaskOperationHelper mApiTaskOperationHelper;
    private Button mBtnStartTask;
    private ClientGameTaskData mClientGameTaskData;
    private LinearLayout mContentView;
    private Context mContext;
    private String mExpirationTime;
    private String mGateType;
    private CustomBuildDialog mGoOnTaskDialog;
    private GuideDialog mGuideDialog;
    private LinearLayout mLlOnTask;
    private ProgressBar mPbDownload;
    private PhoneScreenUtils mPhoneScreenUtils;
    private RelativeLayout mRlDownload;
    private int mTaskDataId;
    private Integer mTime;
    private TextView mTvDownload;
    private LinearLayout suspendLayout;
    private String url;
    private WebView webView;
    private long clickTime = 0;
    private ScheduledExecutorService scheduled = null;
    private Long currentTime = null;
    private long refreClickTime = 0;
    private boolean isInit = true;
    private MokuJsObjectListenerImpl mokuJsListener = null;
    private int fromType = 1000;
    private int cplLogResult = 0;
    private boolean isAddsuspendLayout = false;
    private Integer goBackTime = 0;

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshTaskDetail() {
    }

    @Override // android.view.Window.Callback
    public void onPointerCaptureChanged(boolean z) {
    }

    @Override // com.fendasz.moku.planet.ui.base.activity.BaseActivity
    public View initContentView(ViewGroup viewGroup) {
        this.mPhoneScreenUtils = PhoneScreenUtils.getInstance();
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.moku_eastytask_detai, (ViewGroup) null);
        this.mContentView = linearLayout;
        return linearLayout;
    }

    @Override // com.fendasz.moku.planet.ui.base.activity.BaseActivity
    public void initTitle(TextView textView) {
        if (textView != null) {
            textView.setText("任务详情");
            textView.getPaint().setTextSize(CanvasUtils.getTextSize(this.phoneScreenUtils.getScale(this, 70.0f)));
        }
    }

    @Override // com.fendasz.moku.planet.ui.base.activity.BaseBackActivity, com.fendasz.moku.planet.ui.base.activity.BaseActivity
    public void initRightView(MokuIconTextView mokuIconTextView) {
        mokuIconTextView.setVisibility(0);
    }

    @Override // com.fendasz.moku.planet.ui.base.activity.BaseActivity
    public void initRightView(MokuIconTextView mokuIconTextView, ImageView imageView) {
        super.initRightView(mokuIconTextView, imageView);
        imageView.setImageResource(R.drawable.moku_close_white);
        imageView.setVisibility(0);
        mokuIconTextView.setText("关闭");
        mokuIconTextView.setOnClickListener(new AnonymousClass1());
    }

    /* renamed from: com.fendasz.moku.planet.ui.activity.EasyTaskDetailActivity$1, reason: invalid class name */
    class AnonymousClass1 implements View.OnClickListener {
        AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (Build.VERSION.SDK_INT >= 19) {
                EasyTaskDetailActivity.this.webView.evaluateJavascript("javascript:xxxx()", new ValueCallback() { // from class: com.fendasz.moku.planet.ui.activity.EasyTaskDetailActivity$1$$ExternalSyntheticLambda0
                    @Override // android.webkit.ValueCallback
                    public final void onReceiveValue(Object obj) {
                        this.f$0.m405xdab6d57f((String) obj);
                    }
                });
            } else {
                EasyTaskDetailActivity.this.finish();
            }
        }

        /* renamed from: lambda$onClick$0$com-fendasz-moku-planet-ui-activity-EasyTaskDetailActivity$1, reason: not valid java name */
        /* synthetic */ void m405xdab6d57f(String str) {
            synchronized (this) {
                LogUtils.logD(EasyTaskDetailActivity.TAG, "htmlHistoryBcak=" + str);
                if (str == null || StringUtils.isEmpty(str) || ILogConst.CACHE_PLAY_REASON_NULL.equals(str)) {
                    if (EasyTaskDetailActivity.this.webView.canGoBack()) {
                        EasyTaskDetailActivity.this.goBackTime = 0;
                        EasyTaskDetailActivity.this.webView.goBack();
                    } else {
                        EasyTaskDetailActivity.this.finish();
                    }
                } else {
                    try {
                        if (Boolean.parseBoolean(str)) {
                            EasyTaskDetailActivity.this.finish();
                        }
                    } catch (Exception unused) {
                        EasyTaskDetailActivity.this.finish();
                    }
                }
            }
        }
    }

    /* renamed from: com.fendasz.moku.planet.ui.activity.EasyTaskDetailActivity$2, reason: invalid class name */
    class AnonymousClass2 implements View.OnClickListener {
        AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (Build.VERSION.SDK_INT >= 19) {
                EasyTaskDetailActivity.this.webView.evaluateJavascript("javascript:htmlHistoryBcak()", new ValueCallback() { // from class: com.fendasz.moku.planet.ui.activity.EasyTaskDetailActivity$2$$ExternalSyntheticLambda0
                    @Override // android.webkit.ValueCallback
                    public final void onReceiveValue(Object obj) {
                        this.f$0.m406xdab6d580((String) obj);
                    }
                });
            } else {
                EasyTaskDetailActivity.this.finish();
            }
        }

        /* renamed from: lambda$onClick$0$com-fendasz-moku-planet-ui-activity-EasyTaskDetailActivity$2, reason: not valid java name */
        /* synthetic */ void m406xdab6d580(String str) {
            synchronized (this) {
                LogUtils.logD(EasyTaskDetailActivity.TAG, "htmlHistoryBcak=" + str);
                if (str == null || StringUtils.isEmpty(str) || ILogConst.CACHE_PLAY_REASON_NULL.equals(str)) {
                    if (EasyTaskDetailActivity.this.webView.canGoBack()) {
                        EasyTaskDetailActivity.this.goBackTime = 0;
                        EasyTaskDetailActivity.this.webView.goBack();
                    } else {
                        EasyTaskDetailActivity.this.finish();
                    }
                } else {
                    try {
                        if (Boolean.parseBoolean(str)) {
                            EasyTaskDetailActivity.this.finish();
                        }
                    } catch (Exception unused) {
                        EasyTaskDetailActivity.this.finish();
                    }
                }
            }
        }
    }

    @Override // com.fendasz.moku.planet.ui.base.activity.BaseBackActivity, com.fendasz.moku.planet.ui.base.activity.BaseActivity
    public void initLeftView(TextView textView) {
        textView.setVisibility(0);
        textView.setOnClickListener(new AnonymousClass2());
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
            this.mTaskDataId = intent.getIntExtra("taskDataId", -1);
            this.mGateType = intent.getStringExtra("gateType");
            this.mAdditionalData = intent.getStringExtra("additionalData");
            this.fromType = intent.getIntExtra(this.mContext.getString(R.string.moku_intent_extra_cpl_from_type_key), 1000);
            this.url = intent.getStringExtra("taskDataUrl");
        } else {
            this.mTaskDataId = bundle.getInt("taskDataId", -1);
            this.mGateType = bundle.getString("gateType");
            this.mAdditionalData = bundle.getString("additionalData");
            this.fromType = bundle.getInt(this.mContext.getString(R.string.moku_intent_extra_cpl_from_type_key), 1000);
            this.url = bundle.getString("taskDataUrl");
        }
        String str = this.mAdditionalData;
        if (str == null || StringUtils.isEmpty(str)) {
            this.mAdditionalData = MokuConfigure.getInstance().getMokuOptions(this).getString("additionalData", null);
        }
    }

    private void initWebView() {
        WebView webView = (WebView) this.mContentView.findViewById(R.id.webview_moku_taskdetail);
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
        this.webView.setWebViewClient(new WebViewClient() { // from class: com.fendasz.moku.planet.ui.activity.EasyTaskDetailActivity.3
            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView2, String str) throws URISyntaxException {
                LogUtils.logD(EasyTaskDetailActivity.TAG, "URL=>" + str);
                if (str.startsWith(a.r)) {
                    webView2.loadUrl(str);
                } else {
                    try {
                        EasyTaskDetailActivity.this.startActivity(Intent.parseUri(str, 1));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
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
                    Log.d(EasyTaskDetailActivity.TAG, "request==>,errorCode==" + webResourceError.getErrorCode() + ",errorMsg=>" + ((Object) webResourceError.getDescription()) + i.d);
                }
            }
        });
        if (StringUtils.isEmpty(this.url)) {
            finish();
        } else {
            this.webView.loadUrl(this.url);
        }
    }

    /* renamed from: com.fendasz.moku.planet.ui.activity.EasyTaskDetailActivity$4, reason: invalid class name */
    class AnonymousClass4 extends MokuJsObjectListenerImpl {
        @Override // com.fendasz.moku.planet.common.MokuJsObjectListenerImpl, com.fendasz.moku.planet.common.MokuJsObject.OnMokuJsListener
        public void showScreenImage(String str) {
        }

        AnonymousClass4(Context context) {
            super(context);
        }

        @Override // com.fendasz.moku.planet.common.MokuJsObjectListenerImpl, com.fendasz.moku.planet.common.MokuJsObject.OnMokuJsListener
        public void refreshData() {
            if (EasyTaskDetailActivity.this.refreClickTime == 0) {
                EasyTaskDetailActivity.this.refreshTaskDetail();
                EasyTaskDetailActivity.this.refreClickTime = System.currentTimeMillis();
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j = jCurrentTimeMillis - EasyTaskDetailActivity.this.refreClickTime;
            Log.d(EasyTaskDetailActivity.TAG, "refreClickTime===>" + j);
            if (j > b.a) {
                EasyTaskDetailActivity.this.refreClickTime = jCurrentTimeMillis;
                EasyTaskDetailActivity.this.refreshTaskDetail();
            }
        }

        @Override // com.fendasz.moku.planet.common.MokuJsObjectListenerImpl
        public String taskDataId() {
            return String.valueOf(EasyTaskDetailActivity.this.mTaskDataId);
        }

        @Override // com.fendasz.moku.planet.common.MokuJsObjectListenerImpl
        public void toCustomerService() {
            super.toCustomerService();
            EasyTaskDetailActivity.this.startActivityForResult(new Intent(EasyTaskDetailActivity.this, (Class<?>) MokuCustomerServiceActivity.class), 400);
        }

        @Override // com.fendasz.moku.planet.common.MokuJsObjectListenerImpl
        protected void setTitle(String str) {
            super.setTitle(str);
            EasyTaskDetailActivity.this.mTvTitle.getCenterTextView().setText(str);
        }

        @Override // com.fendasz.moku.planet.common.MokuJsObjectListenerImpl
        protected void notifyH5Token(int i, String str) {
            super.notifyH5Token(i, str);
            if (Build.VERSION.SDK_INT >= 19) {
                EasyTaskDetailActivity.this.webView.evaluateJavascript("javascript:androidToken(" + i + ",'" + str + "')", new ValueCallback() { // from class: com.fendasz.moku.planet.ui.activity.EasyTaskDetailActivity$4$$ExternalSyntheticLambda0
                    @Override // android.webkit.ValueCallback
                    public final void onReceiveValue(Object obj) {
                        LogUtils.logD(EasyTaskDetailActivity.TAG, (String) obj);
                    }
                });
            } else {
                EasyTaskDetailActivity.this.webView.loadUrl("javascript:androidToken(" + i + ",'" + str + "')");
            }
        }

        @Override // com.fendasz.moku.planet.common.MokuJsObjectListenerImpl
        protected void webviewFinish() {
            super.webviewFinish();
            EasyTaskDetailActivity.this.finish();
        }

        @Override // com.fendasz.moku.planet.common.MokuJsObjectListenerImpl
        protected void openEasyCollectionDetail(String str) {
            super.openEasyCollectionDetail(str);
            EasyTaskDetailActivity.this.beginEasyCollection(str);
        }

        @Override // com.fendasz.moku.planet.common.MokuJsObjectListenerImpl, com.fendasz.moku.planet.common.MokuJsObject.OnMokuJsListener
        public void uploadDeviceInfo(String str) {
            super.uploadDeviceInfo(str);
            if (StringUtils.isEmpty(str)) {
                return;
            }
            try {
                MokuConfigure.getInstance().updateSubmitTaskDataId(EasyTaskDetailActivity.this.mContext, Integer.valueOf(Integer.parseInt(str)));
                MokuConfigure.getInstance().updateUserType(EasyTaskDetailActivity.this.mContext, 5);
                ApiDataHelper.getApiDataHelper().uploadDeviceInfo(EasyTaskDetailActivity.this.mContext, new ApiDataCallBack<Object>() { // from class: com.fendasz.moku.planet.ui.activity.EasyTaskDetailActivity.4.1
                    @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
                    public void success(int i, Object obj) throws Exception {
                        Log.d(EasyTaskDetailActivity.TAG, "upload device s");
                    }

                    @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
                    public void error(int i, String str2) throws Exception {
                        Log.d(EasyTaskDetailActivity.TAG, "upload device e");
                    }
                });
            } catch (Exception unused) {
                LogUtils.logE(EasyTaskDetailActivity.TAG, "upload error 1");
            }
        }
    }

    private void initMokuJsLisetener() {
        this.mokuJsListener = new AnonymousClass4(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        LogUtils.logD(TAG, "onActivityResult, webview load url");
        LoadingDialog.show(this.mContext);
        ApiDataHelper.getApiDataHelper().getNetTime(this.mContext, new ApiDataCallBack<Long>() { // from class: com.fendasz.moku.planet.ui.activity.EasyTaskDetailActivity.5
            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void success(int i3, Long l) throws Exception {
                TokenInfo tokenInfo = new TokenInfo();
                PhoneInfo phoneInfo = MokuConfigure.getInstance().getPhoneInfo(EasyTaskDetailActivity.this.mContext);
                tokenInfo.setAppId(phoneInfo.getAppId());
                tokenInfo.setDeviceId(phoneInfo.getDeviceId());
                tokenInfo.setSdkAppUserId(phoneInfo.getSdkAppUserId());
                tokenInfo.setTime(phoneInfo.getNetTime().longValue());
                String strEncrypt = AesUtil.encrypt(JSON.toJSONString(tokenInfo), MokuConfigure.getInstance().getPhoneInfo(EasyTaskDetailActivity.this.mContext).getAppId() + MokuConfigure.getInstance().getPhoneInfo(EasyTaskDetailActivity.this.mContext).getAppSecret());
                LogUtils.log(EasyTaskDetailActivity.TAG, "token >> " + strEncrypt);
                LoadingDialog.dismiss();
                if (Build.VERSION.SDK_INT >= 19) {
                    EasyTaskDetailActivity.this.webView.evaluateJavascript("javascript:androidToken(" + i3 + ",'" + strEncrypt + "')", new ValueCallback<String>() { // from class: com.fendasz.moku.planet.ui.activity.EasyTaskDetailActivity.5.1
                        @Override // android.webkit.ValueCallback
                        public void onReceiveValue(String str) {
                            if (!StringUtils.isEmpty(EasyTaskDetailActivity.this.url)) {
                                EasyTaskDetailActivity.this.webView.loadUrl(EasyTaskDetailActivity.this.url);
                            } else {
                                EasyTaskDetailActivity.this.finish();
                            }
                        }
                    });
                    return;
                }
                EasyTaskDetailActivity.this.webView.loadUrl("javascript:androidToken(" + i3 + ",'" + strEncrypt + "')");
                if (!StringUtils.isEmpty(EasyTaskDetailActivity.this.url)) {
                    EasyTaskDetailActivity.this.webView.loadUrl(EasyTaskDetailActivity.this.url);
                } else {
                    EasyTaskDetailActivity.this.finish();
                }
            }

            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void error(int i3, String str) throws Exception {
                LoadingDialog.dismiss();
                EasyTaskDetailActivity.this.showToast(str);
            }
        });
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (Build.VERSION.SDK_INT >= 19) {
                this.webView.evaluateJavascript("javascript:htmlHistoryBcak()", new ValueCallback<String>() { // from class: com.fendasz.moku.planet.ui.activity.EasyTaskDetailActivity.6
                    /* JADX WARN: Removed duplicated region for block: B:9:0x0014 A[Catch: all -> 0x0016, DONT_GENERATE, TryCatch #1 {, blocks: (B:4:0x0003, B:6:0x0009, B:9:0x0014, B:8:0x000f), top: B:14:0x0003, inners: #0 }] */
                    @Override // android.webkit.ValueCallback
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public void onReceiveValue(java.lang.String r1) {
                        /*
                            r0 = this;
                            monitor-enter(r0)
                            if (r1 == 0) goto L14
                            boolean r1 = java.lang.Boolean.parseBoolean(r1)     // Catch: java.lang.Exception -> Lf java.lang.Throwable -> L16
                            if (r1 == 0) goto L14
                            com.fendasz.moku.planet.ui.activity.EasyTaskDetailActivity r1 = com.fendasz.moku.planet.ui.activity.EasyTaskDetailActivity.this     // Catch: java.lang.Exception -> Lf java.lang.Throwable -> L16
                            r1.finish()     // Catch: java.lang.Exception -> Lf java.lang.Throwable -> L16
                            goto L14
                        Lf:
                            com.fendasz.moku.planet.ui.activity.EasyTaskDetailActivity r1 = com.fendasz.moku.planet.ui.activity.EasyTaskDetailActivity.this     // Catch: java.lang.Throwable -> L16
                            r1.finish()     // Catch: java.lang.Throwable -> L16
                        L14:
                            monitor-exit(r0)     // Catch: java.lang.Throwable -> L16
                            return
                        L16:
                            r1 = move-exception
                            monitor-exit(r0)     // Catch: java.lang.Throwable -> L16
                            throw r1
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.fendasz.moku.planet.ui.activity.EasyTaskDetailActivity.AnonymousClass6.onReceiveValue(java.lang.String):void");
                    }
                });
                return true;
            }
            return super.onKeyDown(i, keyEvent);
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void beginEasyCollection(final String str) {
        Integer id;
        try {
            id = ((EasyCollectionEntity) JSON.parseObject(str, EasyCollectionEntity.class)).getId();
        } catch (Exception unused) {
            showToast("任务详情获取失败");
            id = null;
        }
        if (id == null) {
            showToast("任务详情获取失败");
        } else {
            LoadingDialog.show(this.mContext);
            ApiDataHelper.getApiDataHelper().beginEasyCollection(id, this.mContext, new ApiDataCallBack<EasyCollectionEntity>() { // from class: com.fendasz.moku.planet.ui.activity.EasyTaskDetailActivity.7
                @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
                public void success(int i, EasyCollectionEntity easyCollectionEntity) throws Exception {
                    LoadingDialog.dismiss();
                    Intent intent = new Intent(EasyTaskDetailActivity.this.mContext, (Class<?>) EasyCollectionDetailActivity.class);
                    intent.putExtra("taskInfo", str);
                    EasyTaskDetailActivity.this.startActivityForResult(intent, 20);
                }

                @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
                public void error(int i, String str2) throws Exception {
                    LoadingDialog.dismiss();
                    EasyTaskDetailActivity.this.showToast(str2);
                }
            });
        }
    }

    private void uplodatePackage() {
        ApiDataHelper.getApiDataHelper().postPackages(this.mContext, new ApiDataCallBack<String>() { // from class: com.fendasz.moku.planet.ui.activity.EasyTaskDetailActivity.8
            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void success(int i, String str) throws Exception {
                LogUtils.logD(EasyTaskDetailActivity.TAG, "upload postPackages success");
            }

            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void error(int i, String str) throws Exception {
                LogUtils.logE(EasyTaskDetailActivity.TAG, "upload postPackages error,message=>" + str);
            }
        });
    }
}
