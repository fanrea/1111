package com.fendasz.moku.planet.ui.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.alibaba.fastjson.JSON;
import com.alipay.sdk.m.l.a;
import com.fendasz.moku.planet.R;
import com.fendasz.moku.planet.common.MokuJsObject;
import com.fendasz.moku.planet.common.MokuJsObjectListenerImpl;
import com.fendasz.moku.planet.entity.ApiDataCallBack;
import com.fendasz.moku.planet.entity.EasyCollectionEntity;
import com.fendasz.moku.planet.helper.ApiDataHelper;
import com.fendasz.moku.planet.helper.MokuConfigure;
import com.fendasz.moku.planet.ui.base.activity.BaseBackActivity;
import com.fendasz.moku.planet.ui.customview.MokuIconTextView;
import com.fendasz.moku.planet.ui.dialog.CustomBuildDialog;
import com.fendasz.moku.planet.ui.dialog.EasyTaskReachedDialog;
import com.fendasz.moku.planet.ui.dialog.LoadingDialog;
import com.fendasz.moku.planet.utils.AppUsageStatsManager;
import com.fendasz.moku.planet.utils.LogUtils;
import com.fendasz.moku.planet.utils.PermissionUtils;
import com.fendasz.moku.planet.utils.PhoneScreenUtils;
import com.fendasz.moku.planet.utils.StringUtils;
import com.fendasz.moku.planet.utils.canvas.CanvasUtils;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URISyntaxException;
import java.net.URLDecoder;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class EasyCollectionDetailActivity extends BaseBackActivity {
    private static final float CLICK_MOVE_DIS = 100.0f;
    private static final Long CLICK_TIME_RANGE = 70L;
    private static final int RESULT_CODE_EASYCOLLECTION = 500;
    private static final String TAG = "EasyCollectionDetailActivity==>";
    private Integer averageTimes;
    private Integer browseTime;
    private EasyCollectionEntity collectionEntity;
    private Integer currentClickTime;
    private ImageView ivTaskCollection;
    private Long lastClickTime;
    private LinearLayout mContentView;
    private Context mContext;
    private PhoneScreenUtils mPhoneScreenUtils;
    private String mediaUrl;
    private ProHandler proHandler;
    private ProThread proThread;
    private ProgressBar progressBar;
    private LinearLayout progressLayout;
    private String taskInfo;
    private TextView tvTaskDataKey;
    private WebView webView;
    private Long webviewDownTime;
    private Long webviewUpTime;
    private MokuJsObjectListenerImpl mokuJsListener = null;
    private Integer requiredTimes = 5;
    private Integer timeProgress = 0;
    private boolean isLoading = false;
    private boolean isTaskFinish = false;
    private long openAppTime = 0;
    private int detailIndex = 0;

    @Override // com.fendasz.moku.planet.ui.base.activity.BaseActivity
    public View initContentView(ViewGroup viewGroup) {
        this.mPhoneScreenUtils = PhoneScreenUtils.getInstance();
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.moku_eastytask_collection_detai, (ViewGroup) null);
        this.mContentView = linearLayout;
        this.progressBar = (ProgressBar) linearLayout.findViewById(R.id.bar_moku_easy_collection);
        this.tvTaskDataKey = (TextView) this.mContentView.findViewById(R.id.tv_task_datakey);
        this.ivTaskCollection = (ImageView) this.mContentView.findViewById(R.id.iv_easy_collection);
        this.progressLayout = (LinearLayout) this.mContentView.findViewById(R.id.ll_task_progressbar);
        return this.mContentView;
    }

    @Override // com.fendasz.moku.planet.ui.base.activity.BaseActivity
    public void initTitle(TextView textView) {
        if (textView != null) {
            textView.setText("简单任务合集");
            textView.getPaint().setTextSize(CanvasUtils.getTextSize(this.phoneScreenUtils.getScale(this, 70.0f)));
        }
    }

    @Override // com.fendasz.moku.planet.ui.base.activity.BaseBackActivity, com.fendasz.moku.planet.ui.base.activity.BaseActivity
    public void initRightView(MokuIconTextView mokuIconTextView) {
        mokuIconTextView.setVisibility(0);
    }

    @Override // com.fendasz.moku.planet.ui.base.activity.BaseBackActivity, com.fendasz.moku.planet.ui.base.activity.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.detailIndex = 0;
    }

    @Override // com.fendasz.moku.planet.ui.base.activity.BaseActivity
    public void initRightView(MokuIconTextView mokuIconTextView, ImageView imageView) {
        super.initRightView(mokuIconTextView, imageView);
        imageView.setImageResource(R.drawable.moku_close_white);
        imageView.setVisibility(0);
        mokuIconTextView.setText("关闭");
        mokuIconTextView.setOnClickListener(new View.OnClickListener() { // from class: com.fendasz.moku.planet.ui.activity.EasyCollectionDetailActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (EasyCollectionDetailActivity.this.isTaskFinish) {
                    EasyCollectionDetailActivity.this.finish();
                } else {
                    new CustomBuildDialog.DialogBuilder(EasyCollectionDetailActivity.this.mContext).setTitleImage(Integer.valueOf(R.drawable.moku_tips_icon)).setTitleText("再过几秒就完成啦~").setDetailText("当前任务未完成，退出后需要重新开始").setCancelable(false).setLeftBtn("退出", new CustomBuildDialog.DialogButtonOnClickListener() { // from class: com.fendasz.moku.planet.ui.activity.EasyCollectionDetailActivity.1.2
                        @Override // com.fendasz.moku.planet.ui.dialog.CustomBuildDialog.DialogButtonOnClickListener
                        public void onClick(TextView textView, CustomBuildDialog customBuildDialog) {
                            EasyCollectionDetailActivity.this.finish();
                        }
                    }).setRightBtn("留下继续", new CustomBuildDialog.DialogButtonOnClickListener() { // from class: com.fendasz.moku.planet.ui.activity.EasyCollectionDetailActivity.1.1
                        @Override // com.fendasz.moku.planet.ui.dialog.CustomBuildDialog.DialogButtonOnClickListener
                        public void onClick(TextView textView, CustomBuildDialog customBuildDialog) {
                            customBuildDialog.dismiss();
                        }
                    }).create().show();
                }
            }
        });
    }

    @Override // com.fendasz.moku.planet.ui.base.activity.BaseBackActivity, com.fendasz.moku.planet.ui.base.activity.BaseActivity
    public void initLeftView(TextView textView) {
        textView.setVisibility(0);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.fendasz.moku.planet.ui.activity.EasyCollectionDetailActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EasyCollectionDetailActivity.this.setResult(500);
                EasyCollectionDetailActivity.this.finish();
            }
        });
    }

    @Override // com.fendasz.moku.planet.ui.base.activity.BaseActivity
    protected void onLoad() throws NoSuchMethodException, SecurityException {
        if (!checkUsageStatsPermission(this)) {
            finish();
            return;
        }
        if (1 == this.collectionEntity.getMonitorMethod().intValue()) {
            this.progressLayout.setVisibility(0);
            Integer clickNumber = this.collectionEntity.getClickNumber();
            this.requiredTimes = clickNumber;
            if (clickNumber == null || clickNumber.intValue() == 0) {
                showToast("任务信息获取失败,要求点击次数设置错误");
                finish();
                return;
            } else {
                this.averageTimes = Integer.valueOf(this.browseTime.intValue() / this.requiredTimes.intValue());
                Integer num = 0;
                this.currentClickTime = num;
                this.timeProgress = Integer.valueOf((num.intValue() * 100) / this.requiredTimes.intValue());
            }
        } else {
            this.progressLayout.setVisibility(8);
        }
        this.proHandler = new ProHandler(this);
        this.progressBar.setProgress(this.timeProgress.intValue());
        this.tvTaskDataKey.setText(this.collectionEntity.getTaskDataKey());
        this.ivTaskCollection.setImageResource(R.drawable.moku_easy_collection_taskey);
        MokuConfigure.getInstance().updateSubmitTaskDataId(this.mContext, this.collectionEntity.getId());
        MokuConfigure.getInstance().updateUserType(this.mContext, 5);
        ApiDataHelper.getApiDataHelper().uploadDeviceInfo(this.mContext, new ApiDataCallBack<Object>() { // from class: com.fendasz.moku.planet.ui.activity.EasyCollectionDetailActivity.3
            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void success(int i, Object obj) throws Exception {
                Log.d(EasyCollectionDetailActivity.TAG, "upload device info success");
            }

            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void error(int i, String str) throws Exception {
                LogUtils.logE(EasyCollectionDetailActivity.TAG, "upload device info error,code=>" + i + ",message" + str);
            }
        });
        initWebView();
        this.mediaUrl = this.collectionEntity.getShowUrl();
        Integer monitorMethod = this.collectionEntity.getMonitorMethod();
        LogUtils.logD(TAG, "onLoad,monitorMethod:" + monitorMethod + ",mediaUrl:" + this.mediaUrl + ",packageName:" + this.collectionEntity.getTaskDataApplicationId());
        if (monitorMethod != null && 2 == monitorMethod.intValue()) {
            String str = this.mediaUrl;
            if (str != null) {
                if (str.toLowerCase().startsWith(a.r)) {
                    loadMediaUrl();
                    return;
                }
                try {
                    this.openAppTime = System.currentTimeMillis();
                    startActivity(new Intent("android.intent.action.VIEW", Uri.parse(this.mediaUrl)));
                    return;
                } catch (Exception unused) {
                    LogUtils.logE(TAG, "open app whith scheme error in coolection task");
                    try {
                        LogUtils.logE(TAG, "mediaUrl urldecode open again");
                        this.mediaUrl = URLDecoder.decode(this.mediaUrl, "UTF-8");
                        LogUtils.logD(TAG, "mediaUrl urldecode result:" + this.mediaUrl);
                        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(this.mediaUrl)));
                        return;
                    } catch (UnsupportedEncodingException unused2) {
                        LogUtils.logE(TAG, "mediaUrl urldecode again, open app whith scheme error in coolection task");
                        this.openAppTime = 0L;
                        finish();
                        return;
                    }
                }
            }
            return;
        }
        loadMediaUrl();
    }

    @Override // com.fendasz.moku.planet.ui.base.activity.BaseActivity
    public void onSuperCreate(Bundle bundle) {
        this.mContext = this;
        if (bundle == null) {
            this.taskInfo = getIntent().getStringExtra("taskInfo");
        } else {
            this.taskInfo = bundle.getString("taskInfo");
        }
        LogUtils.logD(TAG, "taskInfo=>" + this.taskInfo);
        String str = this.taskInfo;
        if (str == null || StringUtils.isEmpty(str)) {
            showToast("任务信息获取失败");
            finish();
            return;
        }
        EasyCollectionEntity easyCollectionEntity = (EasyCollectionEntity) JSON.parseObject(this.taskInfo, EasyCollectionEntity.class);
        this.collectionEntity = easyCollectionEntity;
        if (easyCollectionEntity == null) {
            showToast("任务信息获取失败");
            finish();
            return;
        }
        Integer browseTime = easyCollectionEntity.getBrowseTime();
        this.browseTime = browseTime;
        if (browseTime == null) {
            showToast("任务信息获取失败,总时长错误");
            finish();
        }
    }

    private void initWebView() {
        WebView webView = (WebView) this.mContentView.findViewById(R.id.webview_moku_easytask_detail);
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
        this.webView.setWebChromeClient(new WebChromeClient() { // from class: com.fendasz.moku.planet.ui.activity.EasyCollectionDetailActivity.4
            @Override // android.webkit.WebChromeClient
            public boolean onJsAlert(WebView webView2, String str, String str2, JsResult jsResult) {
                LogUtils.logD(EasyCollectionDetailActivity.TAG, "WebChromeClient_onJsAlert,url:" + str + ",message:" + str2);
                new AlertDialog.Builder(webView2.getContext()).setMessage(str2).setPositiveButton("确定", (DialogInterface.OnClickListener) null).create().show();
                jsResult.confirm();
                return true;
            }

            @Override // android.webkit.WebChromeClient
            public boolean onJsConfirm(WebView webView2, String str, String str2, final JsResult jsResult) {
                LogUtils.logD(EasyCollectionDetailActivity.TAG, "WebChromeClient_onJsConfirm,url:" + str + ",message:" + str2);
                new AlertDialog.Builder(webView2.getContext()).setMessage(str2).setPositiveButton("确定", new DialogInterface.OnClickListener() { // from class: com.fendasz.moku.planet.ui.activity.EasyCollectionDetailActivity.4.2
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        jsResult.confirm();
                    }
                }).setNegativeButton("取消", new DialogInterface.OnClickListener() { // from class: com.fendasz.moku.planet.ui.activity.EasyCollectionDetailActivity.4.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        jsResult.cancel();
                    }
                }).create().show();
                return true;
            }

            @Override // android.webkit.WebChromeClient
            public boolean onJsPrompt(WebView webView2, String str, String str2, String str3, JsPromptResult jsPromptResult) {
                LogUtils.logD(EasyCollectionDetailActivity.TAG, "WebChromeClient_onJsPrompt,url:" + str + ",message:" + str2);
                return super.onJsPrompt(webView2, str, str2, str3, jsPromptResult);
            }

            @Override // android.webkit.WebChromeClient
            public boolean onJsBeforeUnload(WebView webView2, String str, String str2, JsResult jsResult) {
                LogUtils.logD(EasyCollectionDetailActivity.TAG, "WebChromeClient_onJsBeforeUnload,url:" + str + ",message:" + str2);
                return super.onJsBeforeUnload(webView2, str, str2, jsResult);
            }

            @Override // android.webkit.WebChromeClient
            public boolean onJsTimeout() {
                LogUtils.logD(EasyCollectionDetailActivity.TAG, "WebChromeClient_onJsTimeout");
                return super.onJsTimeout();
            }
        });
        this.webView.setWebViewClient(new WebViewClient() { // from class: com.fendasz.moku.planet.ui.activity.EasyCollectionDetailActivity.5
            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView2, String str) throws URISyntaxException {
                LogUtils.logD(EasyCollectionDetailActivity.TAG, "URL=>" + str);
                if (str.startsWith(a.r)) {
                    webView2.loadUrl(str);
                } else {
                    try {
                        EasyCollectionDetailActivity.this.openAppTime = System.currentTimeMillis();
                        EasyCollectionDetailActivity.this.startActivity(Intent.parseUri(str, 1));
                    } catch (Exception e) {
                        EasyCollectionDetailActivity.this.openAppTime = System.currentTimeMillis();
                        e.printStackTrace();
                        return false;
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
        });
        if (1 == this.collectionEntity.getMonitorMethod().intValue()) {
            this.webView.setOnTouchListener(new View.OnTouchListener() { // from class: com.fendasz.moku.planet.ui.activity.EasyCollectionDetailActivity.6
                private float downX;
                private float downY;

                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    int action = motionEvent.getAction();
                    if (action == 0) {
                        LogUtils.logD(EasyCollectionDetailActivity.TAG, "webView=>OnTouchListener_ACTION_DOWN");
                        EasyCollectionDetailActivity.this.webviewDownTime = Long.valueOf(System.currentTimeMillis());
                        this.downX = motionEvent.getX();
                        this.downY = motionEvent.getY();
                    } else {
                        if (action == 1) {
                            EasyCollectionDetailActivity.this.webviewUpTime = Long.valueOf(System.currentTimeMillis());
                            float fAbs = Math.abs(motionEvent.getX() - this.downX);
                            float fAbs2 = Math.abs(motionEvent.getY() - this.downY);
                            LogUtils.logD(EasyCollectionDetailActivity.TAG, "webView=>OnTouchListener_ACTION_UP movex=>" + fAbs + ",movey=>" + fAbs2);
                            if (fAbs <= EasyCollectionDetailActivity.CLICK_MOVE_DIS && fAbs2 <= EasyCollectionDetailActivity.CLICK_MOVE_DIS) {
                                Long lValueOf = Long.valueOf(EasyCollectionDetailActivity.this.webviewUpTime.longValue() - EasyCollectionDetailActivity.this.webviewDownTime.longValue());
                                LogUtils.logD(EasyCollectionDetailActivity.TAG, "webView=>OnTouchListener_ACTION_UP spaceTime=>" + lValueOf);
                                if (lValueOf.longValue() <= EasyCollectionDetailActivity.CLICK_TIME_RANGE.longValue()) {
                                    LogUtils.logD(EasyCollectionDetailActivity.TAG, "webView=>OnTouchListener_ACTION_UP lastClickTime=>" + EasyCollectionDetailActivity.this.lastClickTime);
                                    if (EasyCollectionDetailActivity.this.lastClickTime != null && EasyCollectionDetailActivity.this.lastClickTime.longValue() > 0) {
                                        long jLongValue = (EasyCollectionDetailActivity.this.webviewUpTime.longValue() - EasyCollectionDetailActivity.this.lastClickTime.longValue()) / 1000;
                                        LogUtils.logD(EasyCollectionDetailActivity.TAG, "webView=>OnTouchListener_ACTION_UP,lastClickTime not null and not 0,clickSpaceTime=>" + jLongValue);
                                        if (jLongValue > EasyCollectionDetailActivity.this.averageTimes.intValue()) {
                                            LogUtils.logD(EasyCollectionDetailActivity.TAG, "webView=>OnTouchListener_ACTION_UP,add once click");
                                            EasyCollectionDetailActivity.this.addClickNumber();
                                            EasyCollectionDetailActivity easyCollectionDetailActivity = EasyCollectionDetailActivity.this;
                                            easyCollectionDetailActivity.lastClickTime = easyCollectionDetailActivity.webviewUpTime;
                                        }
                                    } else {
                                        LogUtils.logD(EasyCollectionDetailActivity.TAG, "webView=>OnTouchListener_ACTION_UP,lastClickTime is null or 0,add once click");
                                        EasyCollectionDetailActivity.this.addClickNumber();
                                        EasyCollectionDetailActivity easyCollectionDetailActivity2 = EasyCollectionDetailActivity.this;
                                        easyCollectionDetailActivity2.lastClickTime = easyCollectionDetailActivity2.webviewUpTime;
                                    }
                                    return false;
                                }
                                LogUtils.logD(EasyCollectionDetailActivity.TAG, "webView=>OnTouchListener_ACTION_UP not click,beacouse of space time");
                                return false;
                            }
                            LogUtils.logD(EasyCollectionDetailActivity.TAG, "webView=>OnTouchListener_ACTION_UP not click,return because moveXY");
                            return false;
                        }
                        if (action == 2) {
                            LogUtils.logD(EasyCollectionDetailActivity.TAG, "webView=>OnTouchListener_ACTION_MOVE");
                        }
                    }
                    return false;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadMediaUrl() {
        if (StringUtils.isEmpty(this.mediaUrl)) {
            showToast("任务信息获取失败");
            finish();
        } else if (this.webView != null) {
            LogUtils.logD(TAG, "mediaUrl:" + this.mediaUrl);
            this.webView.loadUrl(this.mediaUrl);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void addClickNumber() {
        LogUtils.logD(TAG, "addClickNumber");
        Integer numValueOf = Integer.valueOf(this.currentClickTime.intValue() + 1);
        this.currentClickTime = numValueOf;
        Integer numValueOf2 = Integer.valueOf((numValueOf.intValue() * 100) / this.requiredTimes.intValue());
        this.timeProgress = numValueOf2;
        this.progressBar.setProgress(numValueOf2.intValue());
        if (this.currentClickTime.intValue() >= this.requiredTimes.intValue()) {
            uploadEasyCollection();
        }
    }

    private synchronized void uploadEasyCollection() {
        synchronized (EasyCollectionDetailActivity.class) {
            if (this.isLoading) {
                return;
            }
            this.isLoading = true;
            if (this.isTaskFinish) {
                return;
            }
            LoadingDialog.show(this.mContext);
            ApiDataHelper.getApiDataHelper().easyCollection(this.collectionEntity.getId(), this.mContext, new ApiDataCallBack<Object>() { // from class: com.fendasz.moku.planet.ui.activity.EasyCollectionDetailActivity.7
                @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
                public void success(int i, Object obj) throws Exception {
                    EasyCollectionDetailActivity.this.isTaskFinish = true;
                    EasyCollectionDetailActivity.this.isLoading = false;
                    LoadingDialog.dismiss();
                    EasyCollectionDetailActivity easyCollectionDetailActivity = EasyCollectionDetailActivity.this;
                    easyCollectionDetailActivity.showToast(easyCollectionDetailActivity.getString(R.string.moku_easy_collection_success));
                    EasyCollectionDetailActivity.this.tvTaskDataKey.setText(R.string.moku_easy_collection_success);
                    Integer monitorMethod = EasyCollectionDetailActivity.this.collectionEntity.getMonitorMethod();
                    if (monitorMethod == null || 2 != monitorMethod.intValue()) {
                        return;
                    }
                    EasyCollectionDetailActivity.this.openAppTime = 0L;
                    EasyCollectionDetailActivity.this.finish();
                }

                @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
                public void error(int i, String str) throws Exception {
                    EasyCollectionDetailActivity.this.isLoading = false;
                    LoadingDialog.dismiss();
                    EasyCollectionDetailActivity.this.showToast(str);
                }
            });
        }
    }

    /* renamed from: com.fendasz.moku.planet.ui.activity.EasyCollectionDetailActivity$8, reason: invalid class name */
    class AnonymousClass8 extends MokuJsObjectListenerImpl {
        @Override // com.fendasz.moku.planet.common.MokuJsObjectListenerImpl, com.fendasz.moku.planet.common.MokuJsObject.OnMokuJsListener
        public void showScreenImage(String str) {
        }

        AnonymousClass8(Context context) {
            super(context);
        }

        @Override // com.fendasz.moku.planet.common.MokuJsObjectListenerImpl, com.fendasz.moku.planet.common.MokuJsObject.OnMokuJsListener
        public void refreshData() {
            if (EasyCollectionDetailActivity.this.mediaUrl != null) {
                EasyCollectionDetailActivity.this.webView.loadUrl(EasyCollectionDetailActivity.this.mediaUrl);
            }
        }

        @Override // com.fendasz.moku.planet.common.MokuJsObjectListenerImpl
        public String taskDataId() {
            return EasyCollectionDetailActivity.this.collectionEntity != null ? EasyCollectionDetailActivity.this.collectionEntity.getTaskId().toString() : "";
        }

        @Override // com.fendasz.moku.planet.common.MokuJsObjectListenerImpl
        public void toCustomerService() {
            super.toCustomerService();
            EasyCollectionDetailActivity.this.startActivityForResult(new Intent(EasyCollectionDetailActivity.this, (Class<?>) MokuCustomerServiceActivity.class), 400);
        }

        @Override // com.fendasz.moku.planet.common.MokuJsObjectListenerImpl
        protected void setTitle(String str) {
            super.setTitle(str);
            EasyCollectionDetailActivity.this.mTvTitle.getCenterTextView().setText(str);
        }

        @Override // com.fendasz.moku.planet.common.MokuJsObjectListenerImpl
        protected void notifyH5Token(int i, String str) {
            super.notifyH5Token(i, str);
            if (Build.VERSION.SDK_INT >= 19) {
                EasyCollectionDetailActivity.this.webView.evaluateJavascript("javascript:androidToken(" + i + ",'" + str + "')", new ValueCallback() { // from class: com.fendasz.moku.planet.ui.activity.EasyCollectionDetailActivity$8$$ExternalSyntheticLambda0
                    @Override // android.webkit.ValueCallback
                    public final void onReceiveValue(Object obj) {
                        LogUtils.logD(EasyCollectionDetailActivity.TAG, (String) obj);
                    }
                });
            } else {
                EasyCollectionDetailActivity.this.webView.loadUrl("javascript:androidToken(" + i + ",'" + str + "')");
            }
        }

        @Override // com.fendasz.moku.planet.common.MokuJsObjectListenerImpl
        protected void webviewFinish() {
            super.webviewFinish();
            finish();
        }
    }

    private void initMokuJsLisetener() {
        this.mokuJsListener = new AnonymousClass8(this);
    }

    @Override // com.fendasz.moku.planet.ui.base.activity.BaseBackActivity, com.fendasz.moku.planet.ui.base.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.detailIndex = 0;
        WebView webView = this.webView;
        if (webView != null) {
            webView.removeAllViews();
            this.webView.destroy();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        EasyCollectionEntity easyCollectionEntity;
        super.onResume();
        Integer monitorMethod = this.collectionEntity.getMonitorMethod();
        if (monitorMethod == null || 2 != monitorMethod.intValue() || this.detailIndex <= 0 || (easyCollectionEntity = this.collectionEntity) == null) {
            return;
        }
        String taskDataApplicationId = easyCollectionEntity.getTaskDataApplicationId();
        if (Build.VERSION.SDK_INT >= 21) {
            long appTotalTimeInForeground = AppUsageStatsManager.getInstance().getAppTotalTimeInForeground(this, taskDataApplicationId, this.openAppTime, System.currentTimeMillis());
            LogUtils.logD(TAG, "onResume_openAppTime:" + this.openAppTime + ",AppTotalTimeInForeground:" + appTotalTimeInForeground);
            if (this.browseTime != null) {
                if (appTotalTimeInForeground > r2.intValue()) {
                    LogUtils.logD(TAG, "onResume app open time in foreground ok,upload easy task");
                    uploadEasyCollection();
                } else {
                    LogUtils.logD(TAG, "onResume app open time in foreground not enought");
                    final EasyTaskReachedDialog easyTaskReachedDialog = new EasyTaskReachedDialog(this.mContext);
                    easyTaskReachedDialog.setOnEasyTaskReachedDialog(new EasyTaskReachedDialog.OnEasyTaskReachedDialog() { // from class: com.fendasz.moku.planet.ui.activity.EasyCollectionDetailActivity.9
                        @Override // com.fendasz.moku.planet.ui.dialog.EasyTaskReachedDialog.OnEasyTaskReachedDialog
                        public void onCancel() {
                            EasyCollectionDetailActivity.this.openAppTime = 0L;
                            EasyCollectionDetailActivity.this.finish();
                        }

                        @Override // com.fendasz.moku.planet.ui.dialog.EasyTaskReachedDialog.OnEasyTaskReachedDialog
                        public void onOpen() {
                            easyTaskReachedDialog.dismiss();
                            try {
                                if (EasyCollectionDetailActivity.this.mediaUrl.startsWith(a.r)) {
                                    EasyCollectionDetailActivity.this.webView.clearCache(true);
                                    EasyCollectionDetailActivity.this.webView.clearHistory();
                                    EasyCollectionDetailActivity.this.loadMediaUrl();
                                } else {
                                    EasyCollectionDetailActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(EasyCollectionDetailActivity.this.mediaUrl)));
                                }
                            } catch (Exception unused) {
                                EasyCollectionDetailActivity.this.showToast("未找到软件");
                                EasyCollectionDetailActivity.this.openAppTime = 0L;
                            }
                        }
                    });
                    easyTaskReachedDialog.show();
                }
            }
        }
    }

    @Override // com.fendasz.moku.planet.ui.base.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
    }

    @Override // com.fendasz.moku.planet.ui.base.activity.BaseBackActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
        this.detailIndex++;
    }

    private static class ProHandler extends Handler {
        private final WeakReference<EasyCollectionDetailActivity> mActivity;

        public ProHandler(EasyCollectionDetailActivity easyCollectionDetailActivity) {
            this.mActivity = new WeakReference<>(easyCollectionDetailActivity);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            EasyCollectionDetailActivity easyCollectionDetailActivity = this.mActivity.get();
            if (easyCollectionDetailActivity != null) {
                easyCollectionDetailActivity.progressBar.setProgress(message.what);
            }
        }
    }

    private boolean checkUsageStatsPermission(Context context) {
        if (PermissionUtils.checkUsageStatsPermissions(context)) {
            return true;
        }
        if (context instanceof Activity) {
            Toast.makeText(context, "请按照示意图开启相关权限", 0).show();
            context.startActivity(new Intent(context, (Class<?>) UsageTipsActivity.class));
        }
        return false;
    }

    class ProThread extends Thread {
        private int maxProgress;
        private int minProgerss;
        private boolean proFlag;

        ProThread() {
        }

        public boolean isProFlag() {
            return this.proFlag;
        }

        public void setProFlag(boolean z) {
            this.proFlag = z;
        }

        public int getMaxProgress() {
            return this.maxProgress;
        }

        public void setMaxProgress(int i) {
            this.maxProgress = i;
        }

        public int getMinProgerss() {
            return this.minProgerss;
        }

        public void setMinProgerss(int i) {
            this.minProgerss = i;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() throws InterruptedException {
            while (this.proFlag && this.minProgerss < this.maxProgress) {
                ProHandler proHandler = EasyCollectionDetailActivity.this.proHandler;
                int i = this.minProgerss;
                this.minProgerss = i + 1;
                proHandler.sendEmptyMessage(i);
                try {
                    Thread.sleep(500L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
