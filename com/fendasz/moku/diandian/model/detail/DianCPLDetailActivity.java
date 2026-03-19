package com.fendasz.moku.diandian.model.detail;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
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
import android.widget.Toast;
import com.alipay.sdk.m.u.b;
import com.alipay.sdk.m.u.i;
import com.fendasz.moku.diandian.commons.MokuDianActivity;
import com.fendasz.moku.planet.R;
import com.fendasz.moku.planet.common.MokuJsObject;
import com.fendasz.moku.planet.common.MokuJsObjectListenerImpl;
import com.fendasz.moku.planet.constants.MokuConstants;
import com.fendasz.moku.planet.entity.ApiDataCallBack;
import com.fendasz.moku.planet.entity.ApiOperationCallBack;
import com.fendasz.moku.planet.entity.OperationEnum;
import com.fendasz.moku.planet.exception.MokuException;
import com.fendasz.moku.planet.helper.AliyunHelper;
import com.fendasz.moku.planet.helper.ApiDataHelper;
import com.fendasz.moku.planet.helper.ApiTaskOperationHelper;
import com.fendasz.moku.planet.helper.MokuConfigure;
import com.fendasz.moku.planet.interf.Finish;
import com.fendasz.moku.planet.interf.Success;
import com.fendasz.moku.planet.source.bean.ClientGameTaskData;
import com.fendasz.moku.planet.source.bean.ClientTaskDataSubmitFormModel;
import com.fendasz.moku.planet.source.bean.TaskDataApplyRecord;
import com.fendasz.moku.planet.ui.activity.MokuCustomerServiceActivity;
import com.fendasz.moku.planet.ui.dialog.CustomBuildDialog;
import com.fendasz.moku.planet.ui.dialog.GuideDialog;
import com.fendasz.moku.planet.ui.dialog.LoadingDialog;
import com.fendasz.moku.planet.utils.DateUtils;
import com.fendasz.moku.planet.utils.FloatingUtil;
import com.fendasz.moku.planet.utils.GetInfoUtil;
import com.fendasz.moku.planet.utils.ImageUtils;
import com.fendasz.moku.planet.utils.LogUtils;
import com.fendasz.moku.planet.utils.MokuUtils;
import com.fendasz.moku.planet.utils.PermissionUtils;
import com.fendasz.moku.planet.utils.PhoneScreenUtils;
import com.fendasz.moku.planet.utils.ScreenAdaptationUtils;
import com.fendasz.moku.planet.utils.SharedPreferencesUtils;
import com.fendasz.moku.planet.utils.StringUtils;
import com.fendasz.moku.planet.utils.canvas.CanvasUtils;
import com.fendasz.moku.planet.utils.system.utils.SystemUtils;
import com.qq.e.comm.managers.setting.GlobalSetting;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class DianCPLDetailActivity extends MokuDianActivity implements ApiOperationCallBack {
    private static final int CODE_COUNT_DOWN = 3;
    private static final int CODE_START_TASK = 0;
    private static final int CODE_SUBMIT_ANSWER = 5;
    private static final int CODE_TASK_STATUS = 4;
    private static final int CODE_UPLOAD_SCREENSHOT = 1;
    private static final int CODE_VIEW_INIT = 2;
    private static final String DATA_DETAILURL_DEBUG = MokuConstants.H5Url.H5_CPL_DEBUG.getUrl();
    private static final String DATA_DETAILURL_RELEASE = MokuConstants.H5Url.H5_CPL_RELEASE.getUrl();
    public static final int RESULT_CODE_FOR_FINISH = 2;
    public static final int RESULT_CODE_FOR_REFRESH_TASK_LIST = 300;
    private static final String TAG = "Dian_CPL_Detail";
    private Integer loactionState;
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
    private long onResumeTime = 0;

    @Override // com.fendasz.moku.planet.entity.ApiOperationCallBack
    public void copyContent(OperationEnum operationEnum, String str) {
    }

    @Override // com.fendasz.moku.planet.ui.base.activity.BaseActivity
    public boolean needLightSensor() {
        return true;
    }

    @Override // android.view.Window.Callback
    public void onPointerCaptureChanged(boolean z) {
    }

    @Override // com.fendasz.moku.planet.entity.ApiOperationCallBack
    public void taskStatus(OperationEnum operationEnum) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        showUiTips(4);
    }

    @Override // com.fendasz.moku.planet.entity.ApiOperationCallBack
    public void downloadProgress(OperationEnum operationEnum, String str) {
        LogUtils.log(TAG, "operationEnum >> " + operationEnum.getCode() + ":" + operationEnum.getMessage() + " progress >> " + str);
        int i = (int) Double.parseDouble(str);
        String str2 = i + "%";
        if (this.mClientGameTaskData.getClassify().equals("keyword") || this.mClientGameTaskData.getClassify().equals("comment")) {
            this.mTvDownload.setText("下载应用市场 " + str2);
        } else {
            this.mTvDownload.setText("下载" + this.mClientGameTaskData.getTagText() + str2);
        }
        LogUtils.log(TAG, "strProgress:" + str2);
        this.mPbDownload.setProgress(i);
        LogUtils.log(TAG, "progressValue:" + i);
    }

    @Override // com.fendasz.moku.planet.entity.ApiOperationCallBack
    public void listenerTime(OperationEnum operationEnum, int i) {
        this.mTime = Integer.valueOf(i);
        LogUtils.log(TAG, "operationEnum >> " + operationEnum.getCode() + ":" + operationEnum.getMessage() + " time >> " + i + " 分钟");
    }

    @Override // com.fendasz.moku.planet.ui.base.activity.BaseActivity
    public View initContentView(ViewGroup viewGroup) {
        this.mPhoneScreenUtils = PhoneScreenUtils.getInstance();
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.moku_gametask_detail, (ViewGroup) null);
        this.mContentView = linearLayout;
        return linearLayout;
    }

    @Override // com.fendasz.moku.diandian.commons.MokuDianActivity, com.fendasz.moku.planet.ui.base.activity.BaseActivity
    public void initTitle(TextView textView) {
        if (textView != null) {
            textView.setText("任务详情");
            textView.getPaint().setTextSize(CanvasUtils.getTextSize(this.phoneScreenUtils.getScale(this, 70.0f)));
        }
    }

    @Override // com.fendasz.moku.diandian.commons.MokuDianActivity, com.fendasz.moku.planet.ui.base.activity.BaseActivity
    protected void onLoad() {
        initView();
        initWebView();
        initStaticViewListener();
    }

    @Override // com.fendasz.moku.diandian.commons.MokuDianActivity, com.fendasz.moku.planet.ui.base.activity.BaseBackActivity, com.fendasz.moku.planet.ui.base.activity.BaseActivity
    public void initLeftView(TextView textView) {
        super.initLeftView(textView);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.fendasz.moku.diandian.model.detail.DianCPLDetailActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT >= 19) {
                    DianCPLDetailActivity.this.webView.evaluateJavascript("javascript:htmlHistoryBcak()", new ValueCallback<String>() { // from class: com.fendasz.moku.diandian.model.detail.DianCPLDetailActivity.1.1
                        @Override // android.webkit.ValueCallback
                        public void onReceiveValue(String str) {
                            if (str != null) {
                                try {
                                    if (Boolean.parseBoolean(str)) {
                                        DianCPLDetailActivity.this.finish();
                                    }
                                } catch (Exception unused) {
                                    DianCPLDetailActivity.this.finish();
                                }
                            }
                        }
                    });
                } else {
                    DianCPLDetailActivity.this.finish();
                }
            }
        });
    }

    private void initStaticViewListener() {
        RelativeLayout relativeLayout = this.mRlDownload;
        if (relativeLayout != null) {
            relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.fendasz.moku.diandian.model.detail.DianCPLDetailActivity.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                    if (DianCPLDetailActivity.this.mApiTaskOperationHelper.getOperationEnum() != OperationEnum.SUCCESS_SUBMIT) {
                        DianCPLDetailActivity.this.showUiTips(0);
                        if (SystemUtils.isAppExist(DianCPLDetailActivity.this.mContext, DianCPLDetailActivity.this.mClientGameTaskData.getApkApplicationId())) {
                            SystemUtils.openPackage(DianCPLDetailActivity.this.mContext, DianCPLDetailActivity.this.mClientGameTaskData.getPackageName());
                            return;
                        } else {
                            DianCPLDetailActivity.this.executeTask();
                            return;
                        }
                    }
                    if (!"cpa".equals(DianCPLDetailActivity.this.mClientGameTaskData.getClassify()) || MokuConstants.CPA_TYPE_NORMAL.equals(DianCPLDetailActivity.this.mClientGameTaskData.getTaskData().getCpaType())) {
                        if (MokuConstants.TASK_TYPE_CPL.equals(DianCPLDetailActivity.this.mClientGameTaskData.getClassify())) {
                            SystemUtils.openPackage(DianCPLDetailActivity.this.mContext, DianCPLDetailActivity.this.mClientGameTaskData.getPackageName());
                            return;
                        } else {
                            DianCPLDetailActivity.this.checkAndSubmit(new Action() { // from class: com.fendasz.moku.diandian.model.detail.DianCPLDetailActivity.2.1
                                @Override // io.reactivex.functions.Action
                                public void run() throws Exception {
                                    DianCPLDetailActivity.this.submitNormalTask();
                                }
                            });
                            return;
                        }
                    }
                    SystemUtils.openPackage(DianCPLDetailActivity.this.mContext, DianCPLDetailActivity.this.mClientGameTaskData.getPackageName());
                }
            });
        }
        Button button = this.mBtnStartTask;
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() { // from class: com.fendasz.moku.diandian.model.detail.DianCPLDetailActivity.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    if (jCurrentTimeMillis - DianCPLDetailActivity.this.clickTime > 1000) {
                        DianCPLDetailActivity.this.clickTime = jCurrentTimeMillis;
                        DianCPLDetailActivity.this.getTaskDataStatus(false);
                    } else {
                        LogUtils.log(DianCPLDetailActivity.TAG, "repeat click");
                        Toast.makeText(DianCPLDetailActivity.this.mContext, "不要重复点击", 1).show();
                    }
                }
            });
        }
    }

    private void onReady() {
        getTaskDetail(true, false, false, new Success<ClientGameTaskData>() { // from class: com.fendasz.moku.diandian.model.detail.DianCPLDetailActivity.4
            @Override // com.fendasz.moku.planet.interf.Success
            public void success(Integer num, ClientGameTaskData clientGameTaskData) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, SecurityException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
                DianCPLDetailActivity.this.loactionState = clientGameTaskData.getLocationStatus();
                LogUtils.logD(DianCPLDetailActivity.TAG, "get task detail,loactionState=>" + DianCPLDetailActivity.this.loactionState + ",isInti=>" + DianCPLDetailActivity.this.isInit);
                if (1 == DianCPLDetailActivity.this.loactionState.intValue()) {
                    DianCPLDetailActivity.this.queryLocationInfo();
                }
                if (!TextUtils.isEmpty(DianCPLDetailActivity.this.mGateType) && clientGameTaskData != null) {
                    LogUtils.log(DianCPLDetailActivity.TAG, "postGateType " + DianCPLDetailActivity.this.mGateType);
                    ApiDataHelper.getApiDataHelper().postGateType(DianCPLDetailActivity.this.mContext, DianCPLDetailActivity.this.mGateType, clientGameTaskData.getTaskDataId(), new ApiDataCallBack<Object>() { // from class: com.fendasz.moku.diandian.model.detail.DianCPLDetailActivity.4.1
                        @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
                        public void success(int i, Object obj) throws Exception {
                            LogUtils.log(DianCPLDetailActivity.TAG, "postGateType success");
                        }

                        @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
                        public void error(int i, String str) throws Exception {
                            LogUtils.log(DianCPLDetailActivity.TAG, "postGateType error >> " + str);
                        }
                    });
                }
                DianCPLDetailActivity.this.cplLog();
                if (DianCPLDetailActivity.this.fromType == 1001) {
                    DianCPLDetailActivity.this.applyTask(true);
                }
            }
        });
    }

    @Override // com.fendasz.moku.diandian.commons.MokuDianActivity, com.fendasz.moku.planet.ui.base.activity.BaseActivity
    public void onSuperCreate(Bundle bundle) {
        this.mContext = this;
        LogUtils.logD(TAG, "on supercreate,start to get oaid");
        updateOaid();
        if (bundle == null) {
            Intent intent = getIntent();
            this.mTaskDataId = intent.getIntExtra("taskDataId", -1);
            this.mGateType = intent.getStringExtra("gateType");
            this.mAdditionalData = intent.getStringExtra("additionalData");
            this.fromType = intent.getIntExtra(this.mContext.getString(R.string.moku_intent_extra_cpl_from_type_key), 1000);
        } else {
            this.mTaskDataId = bundle.getInt("taskDataId", -1);
            this.mGateType = bundle.getString("gateType");
            this.mAdditionalData = bundle.getString("additionalData");
            this.fromType = bundle.getInt(this.mContext.getString(R.string.moku_intent_extra_cpl_from_type_key), 1000);
        }
        String str = this.mAdditionalData;
        if (str == null || StringUtils.isEmpty(str)) {
            this.mAdditionalData = MokuConfigure.getInstance().getMokuOptions(this).getString("additionalData", null);
        }
        MokuConfigure.getInstance().getMokuOptions(this).putString("additionalData", this.mAdditionalData);
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("taskDataId", this.mTaskDataId);
        bundle.putString("gateType", this.mGateType);
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
        this.webView.setWebViewClient(new WebViewClient() { // from class: com.fendasz.moku.diandian.model.detail.DianCPLDetailActivity.5
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
                    Log.d(DianCPLDetailActivity.TAG, "request==>,errorCode==" + webResourceError.getErrorCode() + ",errorMsg=>" + ((Object) webResourceError.getDescription()) + i.d);
                }
            }
        });
        String string = MokuConfigure.getInstance().getMokuOptions(this).getString("appId", "");
        String stringExtra = (string == null || TextUtils.isEmpty(string) || !("QRoFgbS0".equals(string) || "R0AAJHSK".equals(string))) ? null : getIntent().getStringExtra("diamondAppData");
        if (stringExtra != null && !TextUtils.isEmpty(stringExtra)) {
            this.webView.loadUrl(DATA_DETAILURL_RELEASE + "?diamondAppData=" + stringExtra);
        } else {
            this.webView.loadUrl(DATA_DETAILURL_RELEASE);
        }
    }

    @Override // com.fendasz.moku.planet.ui.base.activity.BaseActivity
    public void initView() {
        this.mBtnStartTask = (Button) this.mContentView.findViewById(R.id.btn_start_task);
        this.mLlOnTask = (LinearLayout) this.mContentView.findViewById(R.id.ll_on_task);
        this.mRlDownload = (RelativeLayout) this.mContentView.findViewById(R.id.rl_download);
        this.mTvDownload = (TextView) this.mContentView.findViewById(R.id.tv_download);
        this.mPbDownload = (ProgressBar) this.mContentView.findViewById(R.id.pb_download);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initCountDown() {
        ScheduledExecutorService scheduledExecutorService = this.scheduled;
        if (scheduledExecutorService != null) {
            if (!scheduledExecutorService.isShutdown()) {
                this.scheduled.shutdownNow();
            }
            this.scheduled = null;
        }
        this.currentTime = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getTaskDataStatus(final boolean z) {
        LoadingDialog.show(this.mContext);
        ApiDataHelper.getApiDataHelper().dianGetTaskDataStatus(this.mContext, new ApiDataCallBack<TaskDataApplyRecord>() { // from class: com.fendasz.moku.diandian.model.detail.DianCPLDetailActivity.6
            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void success(int i, TaskDataApplyRecord taskDataApplyRecord) throws Exception {
                LoadingDialog.dismiss();
                if (taskDataApplyRecord == null || taskDataApplyRecord.getTaskDataId().intValue() == DianCPLDetailActivity.this.mTaskDataId) {
                    DianCPLDetailActivity.this.applyTask(!z);
                } else {
                    DianCPLDetailActivity.this.showApplyingTask(taskDataApplyRecord);
                }
            }

            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void error(int i, String str) throws Exception {
                LoadingDialog.dismiss();
                LogUtils.log(DianCPLDetailActivity.TAG, "code:" + i + " message:" + str);
                Toast.makeText(DianCPLDetailActivity.this.mContext, str + i, 1).show();
            }
        });
    }

    /* renamed from: com.fendasz.moku.diandian.model.detail.DianCPLDetailActivity$7, reason: invalid class name */
    class AnonymousClass7 implements Consumer<ClientGameTaskData> {
        AnonymousClass7() {
        }

        @Override // io.reactivex.functions.Consumer
        public void accept(final ClientGameTaskData clientGameTaskData) throws Exception {
            LinearLayout linearLayout = new LinearLayout(DianCPLDetailActivity.this.mContext);
            linearLayout.setOrientation(0);
            linearLayout.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
            final ImageView imageView = new ImageView(DianCPLDetailActivity.this.mContext);
            linearLayout.addView(imageView);
            ((LinearLayout.LayoutParams) imageView.getLayoutParams()).gravity = 16;
            ScreenAdaptationUtils.setSize(DianCPLDetailActivity.this.mContext, imageView, 120, 120);
            ScreenAdaptationUtils.setMarginRight(DianCPLDetailActivity.this.mContext, imageView, 20);
            ImageUtils.getInstance().setImageView(DianCPLDetailActivity.this.mContext, clientGameTaskData.getIcon(), new com.fendasz.moku.planet.interf.functions.Consumer<Bitmap>() { // from class: com.fendasz.moku.diandian.model.detail.DianCPLDetailActivity.7.1
                @Override // com.fendasz.moku.planet.interf.functions.Consumer
                public void accept(Bitmap bitmap) throws Exception {
                    imageView.setImageBitmap(bitmap);
                }
            }, Float.valueOf(DianCPLDetailActivity.this.mPhoneScreenUtils.getScale(DianCPLDetailActivity.this.mContext, 120.0f)), Float.valueOf(DianCPLDetailActivity.this.mPhoneScreenUtils.getScale(DianCPLDetailActivity.this.mContext, 120.0f)));
            LinearLayout linearLayout2 = new LinearLayout(DianCPLDetailActivity.this.mContext);
            linearLayout2.setLayoutParams(new RelativeLayout.LayoutParams(-2, -1));
            linearLayout2.setOrientation(1);
            linearLayout.addView(linearLayout2);
            TextView textView = new TextView(DianCPLDetailActivity.this.mContext);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, 0);
            layoutParams.weight = 1.0f;
            textView.setLayoutParams(layoutParams);
            textView.setSingleLine(true);
            textView.setEllipsize(TextUtils.TruncateAt.END);
            textView.setTextColor(DianCPLDetailActivity.this.mContext.getResources().getColor(R.color.black));
            linearLayout2.addView(textView);
            textView.setText(clientGameTaskData.getShowName());
            textView.setTextSize(DianCPLDetailActivity.this.phoneScreenUtils.getNormalTextSize(DianCPLDetailActivity.this.mContext));
            TextView textView2 = new TextView(DianCPLDetailActivity.this.mContext);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, 0);
            layoutParams2.weight = 1.0f;
            textView2.setLayoutParams(layoutParams2);
            textView2.setSingleLine(true);
            textView2.setEllipsize(TextUtils.TruncateAt.END);
            textView2.setTextColor(DianCPLDetailActivity.this.mContext.getResources().getColor(R.color.moku_yellow_golden));
            linearLayout2.addView(textView2);
            textView2.setTextSize(DianCPLDetailActivity.this.phoneScreenUtils.getNormalTextSize(DianCPLDetailActivity.this.mContext));
            textView2.setText(clientGameTaskData.getShowMoney() + clientGameTaskData.getCybermoneyName());
            new CustomBuildDialog.DialogBuilder(DianCPLDetailActivity.this.mContext).setTitleImage(Integer.valueOf(R.drawable.moku_tips_icon)).setDetailText("您有一个进行中的任务，是否放弃此任务，开始当前任务？").setCustomView(linearLayout).setCancelable(false).setLeftBtn("返回完成", new CustomBuildDialog.DialogButtonOnClickListener() { // from class: com.fendasz.moku.diandian.model.detail.DianCPLDetailActivity.7.3
                @Override // com.fendasz.moku.planet.ui.dialog.CustomBuildDialog.DialogButtonOnClickListener
                public void onClick(TextView textView3, CustomBuildDialog customBuildDialog) {
                    customBuildDialog.dismiss();
                    if (clientGameTaskData.getCpl() == null || !clientGameTaskData.getCpl().booleanValue()) {
                        Intent intent = new Intent(DianCPLDetailActivity.this, (Class<?>) DianCpaDetailActivity.class);
                        intent.putExtra("taskDataId", clientGameTaskData.getTaskDataId());
                        intent.putExtra("taskDataUrl", clientGameTaskData.getUrl());
                        String gateType = clientGameTaskData.getGateType();
                        if (!TextUtils.isEmpty(gateType)) {
                            intent.putExtra("gateType", gateType);
                        }
                        intent.putExtra("operationType", 100);
                        DianCPLDetailActivity.this.startActivityForResult(intent, 200);
                        return;
                    }
                    DianCPLDetailActivity.this.mTaskDataId = clientGameTaskData.getTaskDataId().intValue();
                    DianCPLDetailActivity.this.getTaskDetail(true, true, false, null);
                }
            }).setRightBtn(DianCPLDetailActivity.this.mContext.getString(R.string.moku_btn_confirm), new CustomBuildDialog.DialogButtonOnClickListener() { // from class: com.fendasz.moku.diandian.model.detail.DianCPLDetailActivity.7.2
                @Override // com.fendasz.moku.planet.ui.dialog.CustomBuildDialog.DialogButtonOnClickListener
                public void onClick(TextView textView3, CustomBuildDialog customBuildDialog) {
                    customBuildDialog.dismiss();
                    DianCPLDetailActivity.this.cancelTask(clientGameTaskData, new com.fendasz.moku.planet.interf.functions.Consumer<TaskDataApplyRecord>() { // from class: com.fendasz.moku.diandian.model.detail.DianCPLDetailActivity.7.2.1
                        @Override // com.fendasz.moku.planet.interf.functions.Consumer
                        public void accept(TaskDataApplyRecord taskDataApplyRecord) throws Exception {
                            Toast.makeText(DianCPLDetailActivity.this.mContext, "任务(taskDataId:" + taskDataApplyRecord.getTaskDataId() + ")取消成功", 0).show();
                            DianCPLDetailActivity.this.applyTask(true);
                        }
                    });
                }
            }).setShowClose(true).create().show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showApplyingTask(TaskDataApplyRecord taskDataApplyRecord) {
        LogUtils.log(TAG, "another task is applying while the taskId is " + taskDataApplyRecord.getTaskDataId() + " and applyId is " + taskDataApplyRecord.getId());
        getTaskDetailData(taskDataApplyRecord.getTaskDataId().intValue(), true, new AnonymousClass7());
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 200) {
            setResult(300);
            finish();
        }
    }

    private void getTaskDetailData(int i, final boolean z, final Consumer<ClientGameTaskData> consumer) {
        LoadingDialog.show(this.mContext);
        ApiDataHelper.getApiDataHelper().dianCPLTaskDetail(this.mContext, Integer.valueOf(i), new ApiDataCallBack<ClientGameTaskData>() { // from class: com.fendasz.moku.diandian.model.detail.DianCPLDetailActivity.8
            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void success(int i2, ClientGameTaskData clientGameTaskData) {
                LoadingDialog.dismiss();
                try {
                    consumer.accept(clientGameTaskData);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void error(int i2, String str) {
                LoadingDialog.dismiss();
                LogUtils.log(DianCPLDetailActivity.TAG, "code:" + i2 + " message:" + str);
                if (z) {
                    Toast.makeText(DianCPLDetailActivity.this.mContext, str + i2, 1).show();
                } else if (i2 == 5000 || i2 == 5001) {
                    Toast.makeText(DianCPLDetailActivity.this.mContext, str + i2, 1).show();
                } else {
                    Toast.makeText(DianCPLDetailActivity.this.mContext, "code:" + i2 + " message:" + str, 1).show();
                    DianCPLDetailActivity.this.showErrorDialog(str);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showErrorDialog(String str) {
        new CustomBuildDialog.DialogBuilder(this.mContext).setTitleImage(Integer.valueOf(R.drawable.moku_tips_icon)).setDetailText(str).setRightBtn(getString(R.string.moku_btn_ok), new CustomBuildDialog.DialogButtonOnClickListener() { // from class: com.fendasz.moku.diandian.model.detail.DianCPLDetailActivity$$ExternalSyntheticLambda1
            @Override // com.fendasz.moku.planet.ui.dialog.CustomBuildDialog.DialogButtonOnClickListener
            public final void onClick(TextView textView, CustomBuildDialog customBuildDialog) {
                this.f$0.m384x1d7baba5(textView, customBuildDialog);
            }
        }).setCancelable(false).create().show();
    }

    /* renamed from: lambda$showErrorDialog$0$com-fendasz-moku-diandian-model-detail-DianCPLDetailActivity, reason: not valid java name */
    /* synthetic */ void m384x1d7baba5(TextView textView, CustomBuildDialog customBuildDialog) {
        customBuildDialog.dismiss();
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Deprecated
    public void cancelTask(ClientGameTaskData clientGameTaskData, final com.fendasz.moku.planet.interf.functions.Consumer<TaskDataApplyRecord> consumer) {
        LoadingDialog.show(this.mContext);
        ApiDataHelper.getApiDataHelper().cancelTask(this.mContext, clientGameTaskData, new ApiDataCallBack<TaskDataApplyRecord>() { // from class: com.fendasz.moku.diandian.model.detail.DianCPLDetailActivity.9
            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void success(int i, TaskDataApplyRecord taskDataApplyRecord) throws Exception {
                LoadingDialog.dismiss();
                DianCPLDetailActivity.this.setResult(300);
                com.fendasz.moku.planet.interf.functions.Consumer consumer2 = consumer;
                if (consumer2 != null) {
                    consumer2.accept(taskDataApplyRecord);
                }
            }

            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void error(int i, String str) throws Exception {
                LoadingDialog.dismiss();
                LogUtils.log(DianCPLDetailActivity.TAG, "code:" + i + " message:" + str);
                Toast.makeText(DianCPLDetailActivity.this.mContext, str + i, 1).show();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getTaskDetail(final boolean z, boolean z2, final boolean z3, final Success<ClientGameTaskData> success) {
        getTaskDetailData(this.mTaskDataId, false, new Consumer<ClientGameTaskData>() { // from class: com.fendasz.moku.diandian.model.detail.DianCPLDetailActivity.10
            @Override // io.reactivex.functions.Consumer
            public void accept(ClientGameTaskData clientGameTaskData) throws Exception {
                DianCPLDetailActivity.this.mClientGameTaskData = clientGameTaskData;
                MokuConfigure.getInstance().updateSubmitTaskDataId(DianCPLDetailActivity.this.mContext, DianCPLDetailActivity.this.mClientGameTaskData.getTaskDataId());
                if (DianCPLDetailActivity.this.mClientGameTaskData.getTaskDataApplyRecord() != null && DianCPLDetailActivity.this.mClientGameTaskData.getTaskDataApplyRecord().getStatus().equals(TaskDataApplyRecord.STATUS_OF_APPLYING)) {
                    DianCPLDetailActivity dianCPLDetailActivity = DianCPLDetailActivity.this;
                    dianCPLDetailActivity.mExpirationTime = dianCPLDetailActivity.mClientGameTaskData.getTaskDataApplyRecord().getExpirationTime();
                }
                DianCPLDetailActivity.this.mApiTaskOperationHelper = new ApiTaskOperationHelper.HelperBuilder(DianCPLDetailActivity.this.mClientGameTaskData).setCallBack(DianCPLDetailActivity.this).create();
                if (z) {
                    DianCPLDetailActivity.this.mApiTaskOperationHelper.init(DianCPLDetailActivity.this.mContext);
                } else {
                    DianCPLDetailActivity.this.mApiTaskOperationHelper.onRestart(DianCPLDetailActivity.this.mContext);
                }
                DianCPLDetailActivity.this.onInitComplete(z3);
                Success success2 = success;
                if (success2 != null) {
                    success2.success(0, DianCPLDetailActivity.this.mClientGameTaskData);
                }
                Integer suspendedSwitch = DianCPLDetailActivity.this.mClientGameTaskData.getSuspendedSwitch();
                if (suspendedSwitch == null || suspendedSwitch.intValue() != 1) {
                    return;
                }
                DianCPLDetailActivity dianCPLDetailActivity2 = DianCPLDetailActivity.this;
                if (FloatingUtil.isNeedShowFloatnigDialog(dianCPLDetailActivity2, dianCPLDetailActivity2.mClientGameTaskData)) {
                    FloatingUtil.showFloatingDialog(DianCPLDetailActivity.this);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void applyTask(final boolean z) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, SecurityException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        if (this.loactionState.intValue() == 1) {
            Integer numQueryLocationInfo = queryLocationInfo();
            LogUtils.logD(TAG, "applyTask queryLocationInfo:" + numQueryLocationInfo);
            if (numQueryLocationInfo == null || numQueryLocationInfo.intValue() != 1) {
                LoadingDialog.dismiss();
                return;
            } else if (!PermissionUtils.hasLocationPermissions(this)) {
                queryLocationInfo();
                return;
            }
        }
        LoadingDialog.show(this.mContext);
        if (PermissionUtils.hasLocationPermissions(this)) {
            Log.d(TAG, "getSimCardInfo");
            GetInfoUtil.getSimCardInfo(this, this);
        }
        MokuConfigure.getInstance().updateUserType(this.mContext, 3);
        ApiDataHelper.getApiDataHelper().uploadDeviceInfo(this, new ApiDataCallBack<Object>() { // from class: com.fendasz.moku.diandian.model.detail.DianCPLDetailActivity.11
            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void success(int i, Object obj) throws Exception {
                Log.d(DianCPLDetailActivity.TAG, "upload device info success");
            }

            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void error(int i, String str) throws Exception {
                LogUtils.logE(DianCPLDetailActivity.TAG, "upload device info error,code=>" + i + ",message" + str);
            }
        });
        Log.d(TAG, "start uploadDeviceToken");
        AliyunHelper.getInstance().uploadDeviceToken(this.mContext, new AliyunHelper.SessionCallBack() { // from class: com.fendasz.moku.diandian.model.detail.DianCPLDetailActivity.12
            @Override // com.fendasz.moku.planet.helper.AliyunHelper.SessionCallBack
            public void onSession(Integer num, String str, String str2) {
                Log.d(DianCPLDetailActivity.TAG, "uploadDeviceToken onSession,code:" + num + ",message:" + str);
                if (7700 == num.intValue()) {
                    DianCPLDetailActivity.this.showToast(str);
                }
            }
        });
        Integer numCheckIsCanStartTask = this.mApiTaskOperationHelper.checkIsCanStartTask(this.mContext);
        if (numCheckIsCanStartTask.equals(MokuConstants.CHECK_CAN_START_TASK)) {
            ApiDataHelper.getApiDataHelper().dianApplyTask(this.mContext, this.mClientGameTaskData.getTaskDataId(), new ApiDataCallBack<TaskDataApplyRecord>() { // from class: com.fendasz.moku.diandian.model.detail.DianCPLDetailActivity.13
                @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
                public void success(int i, TaskDataApplyRecord taskDataApplyRecord) throws Exception {
                    LoadingDialog.dismiss();
                    Toast.makeText(DianCPLDetailActivity.this.mContext, "任务开始了，按任务要求完成吧~", 0).show();
                    DianCPLDetailActivity.this.mClientGameTaskData.setTaskDataApplyRecord(taskDataApplyRecord);
                    DianCPLDetailActivity.this.mExpirationTime = taskDataApplyRecord.getExpirationTime();
                    DianCPLDetailActivity.this.startCountDown();
                    DianCPLDetailActivity.this.setResult(300);
                    DianCPLDetailActivity.this.mApiTaskOperationHelper.init(DianCPLDetailActivity.this.mContext);
                    if (z) {
                        DianCPLDetailActivity.this.executeTask();
                    }
                    DianCPLDetailActivity.this.onInitStatusComplete();
                    if (1 == taskDataApplyRecord.getLocationStatus().intValue()) {
                        DianCPLDetailActivity.this.queryLocationInfo();
                    }
                    Integer checkTheState = taskDataApplyRecord.getCheckTheState();
                    LogUtils.logD(DianCPLDetailActivity.TAG, "checkTheState=>" + checkTheState);
                    if (checkTheState == null || 1 != checkTheState.intValue()) {
                        return;
                    }
                    DianCPLDetailActivity.this.uplodatePackage();
                }

                @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
                public void error(int i, String str) throws Exception {
                    LoadingDialog.dismiss();
                    LogUtils.log(DianCPLDetailActivity.TAG, "code:" + i + " message:" + str);
                    if (i == 5007) {
                        DianCPLDetailActivity.this.showErrorDialog(str);
                    } else if ("系统异常".equals(str)) {
                        Toast.makeText(DianCPLDetailActivity.this.mContext, "申请失败，设备/账号已申请该任务" + i, 1).show();
                    } else {
                        Toast.makeText(DianCPLDetailActivity.this.mContext, str + i, 1).show();
                    }
                }
            });
            return;
        }
        LoadingDialog.dismiss();
        if (numCheckIsCanStartTask.equals(MokuConstants.CHECK_APP_EXIST)) {
            CustomBuildDialog.DialogBuilder dialogBuilder = new CustomBuildDialog.DialogBuilder(this.mContext);
            dialogBuilder.setTitleImage(Integer.valueOf(R.drawable.moku_tips_icon)).setDetailText("开始该任务，必须先卸载手机上的【" + this.mClientGameTaskData.getTaskData().getTaskDataDetail().getAppName() + "】，否则没有奖励呢~").setCancelable(false);
            if (PermissionUtils.checkIsRequestDeletePackagesPermissionGranted(this.mContext)) {
                dialogBuilder.setLeftBtn(this.mContext.getString(R.string.moku_btn_no), new CustomBuildDialog.DialogButtonOnClickListener() { // from class: com.fendasz.moku.diandian.model.detail.DianCPLDetailActivity.15
                    @Override // com.fendasz.moku.planet.ui.dialog.CustomBuildDialog.DialogButtonOnClickListener
                    public void onClick(TextView textView, CustomBuildDialog customBuildDialog) {
                        customBuildDialog.dismiss();
                    }
                }).setRightBtn(this.mContext.getString(R.string.moku_uninstall), new CustomBuildDialog.DialogButtonOnClickListener() { // from class: com.fendasz.moku.diandian.model.detail.DianCPLDetailActivity.14
                    @Override // com.fendasz.moku.planet.ui.dialog.CustomBuildDialog.DialogButtonOnClickListener
                    public void onClick(TextView textView, CustomBuildDialog customBuildDialog) {
                        customBuildDialog.dismiss();
                        SystemUtils.uninstallApp(DianCPLDetailActivity.this.mContext, DianCPLDetailActivity.this.mClientGameTaskData.getPackageName());
                    }
                });
            } else {
                dialogBuilder.setRightBtn(this.mContext.getString(R.string.moku_btn_ok), new CustomBuildDialog.DialogButtonOnClickListener() { // from class: com.fendasz.moku.diandian.model.detail.DianCPLDetailActivity.16
                    @Override // com.fendasz.moku.planet.ui.dialog.CustomBuildDialog.DialogButtonOnClickListener
                    public void onClick(TextView textView, CustomBuildDialog customBuildDialog) {
                        customBuildDialog.dismiss();
                    }
                });
            }
            dialogBuilder.create().show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onInitStatusComplete() {
        Button button;
        ClientGameTaskData clientGameTaskData = this.mClientGameTaskData;
        if (clientGameTaskData != null && clientGameTaskData.isCheckUsage() && this.mClientGameTaskData.isApplyRecordNullOrCanceled() && this.mClientGameTaskData.isNewTaskGroup() && MokuUtils.isAppExistEver(this.mContext, this.mClientGameTaskData.getPackageName()) && (button = this.mBtnStartTask) != null) {
            button.setText(this.mContext.getString(R.string.moku_start_task_btn_text_pkg_exist));
            this.mBtnStartTask.setEnabled(false);
        }
        ApiTaskOperationHelper apiTaskOperationHelper = this.mApiTaskOperationHelper;
        if (apiTaskOperationHelper != null && apiTaskOperationHelper.getOperationEnum() != null) {
            this.mApiTaskOperationHelper.getOperationEnum();
        } else {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startCountDown() {
        LogUtils.log(TAG, "倒计时开始");
        initCountDown();
        if (this.currentTime == null) {
            this.currentTime = Long.valueOf(SharedPreferencesUtils.getInstance(this.mContext).getLong("mokuTime", System.currentTimeMillis()));
        }
        if (this.scheduled == null) {
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);
            this.scheduled = scheduledThreadPoolExecutor;
            scheduledThreadPoolExecutor.scheduleAtFixedRate(new Runnable() { // from class: com.fendasz.moku.diandian.model.detail.DianCPLDetailActivity.17
                @Override // java.lang.Runnable
                public void run() {
                    ((Activity) DianCPLDetailActivity.this.mContext).runOnUiThread(new Runnable() { // from class: com.fendasz.moku.diandian.model.detail.DianCPLDetailActivity.17.1
                        @Override // java.lang.Runnable
                        public void run() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                            TaskDataApplyRecord taskDataApplyRecord;
                            if (DianCPLDetailActivity.this.currentTime != null) {
                                DianCPLDetailActivity.this.currentTime = Long.valueOf(DianCPLDetailActivity.this.currentTime.longValue() + 1000);
                                if (DianCPLDetailActivity.this.mExpirationTime != null) {
                                    if (DateUtils.getDate(DianCPLDetailActivity.this.mExpirationTime, "yyyy-MM-dd HH:mm:ss").getTime() - DianCPLDetailActivity.this.currentTime.longValue() > 0) {
                                        DianCPLDetailActivity.this.showUiTips(3);
                                        return;
                                    }
                                    LogUtils.log(DianCPLDetailActivity.TAG, "任务已超时");
                                    if (DianCPLDetailActivity.this.mClientGameTaskData != null && (taskDataApplyRecord = DianCPLDetailActivity.this.mClientGameTaskData.getTaskDataApplyRecord()) != null) {
                                        taskDataApplyRecord.setStatus(MokuConstants.STATUS_OF_OVERTIME);
                                    }
                                    DianCPLDetailActivity.this.mApiTaskOperationHelper.init(DianCPLDetailActivity.this.mContext);
                                    DianCPLDetailActivity.this.showUiTips(3);
                                    DianCPLDetailActivity.this.initCountDown();
                                }
                            }
                        }
                    });
                }
            }, 0L, 1L, TimeUnit.SECONDS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void executeTask() {
        OperationEnum operationEnum = this.mApiTaskOperationHelper.getOperationEnum();
        if (operationEnum.equals(OperationEnum.SUCCESS_AUTO_INSTALL_APP) || operationEnum.equals(OperationEnum.SUCCESS_INSTALL_APP)) {
            showGalleryTipDialog(new Finish() { // from class: com.fendasz.moku.diandian.model.detail.DianCPLDetailActivity.18
                @Override // com.fendasz.moku.planet.interf.Finish
                public void finish() {
                    if (DianCPLDetailActivity.this.mApiTaskOperationHelper != null) {
                        DianCPLDetailActivity.this.mApiTaskOperationHelper.executeTask(DianCPLDetailActivity.this.mContext);
                    }
                }
            });
            return;
        }
        ApiTaskOperationHelper apiTaskOperationHelper = this.mApiTaskOperationHelper;
        if (apiTaskOperationHelper != null) {
            apiTaskOperationHelper.executeTask(this.mContext);
        }
    }

    public void showGalleryTipDialog(final Finish finish) {
        if (!SharedPreferencesUtils.getInstance(this.mContext).getBoolean(this.mContext.getString(R.string.moku_sp_is_show_dialog_gallery_tip), true)) {
            if (finish != null) {
                finish.finish();
                return;
            }
            return;
        }
        CustomBuildDialog.DialogBuilder dialogBuilder = new CustomBuildDialog.DialogBuilder(this.mContext);
        ImageView imageView = new ImageView(this.mContext);
        Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(this.mContext.getResources(), R.drawable.gallery_tip);
        if (bitmapDecodeResource != null) {
            float scale = this.mPhoneScreenUtils.getScale(this.mContext, 800.0f);
            ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams((int) scale, (int) ((bitmapDecodeResource.getHeight() * scale) / bitmapDecodeResource.getWidth()));
            marginLayoutParams.topMargin = this.mPhoneScreenUtils.getScale(this.mContext, 50.0f);
            marginLayoutParams.bottomMargin = this.mPhoneScreenUtils.getScale(this.mContext, 50.0f);
            imageView.setLayoutParams(marginLayoutParams);
            imageView.setBackgroundResource(R.color.moku_transparent);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setImageBitmap(bitmapDecodeResource);
        }
        dialogBuilder.setCustomView(imageView).setRightBtn(this.mContext.getString(R.string.moku_dialog_btn_text__i_know), new CustomBuildDialog.DialogButtonOnClickListener() { // from class: com.fendasz.moku.diandian.model.detail.DianCPLDetailActivity.19
            @Override // com.fendasz.moku.planet.ui.dialog.CustomBuildDialog.DialogButtonOnClickListener
            public void onClick(TextView textView, CustomBuildDialog customBuildDialog) {
                customBuildDialog.dismiss();
                SharedPreferencesUtils.getInstance(DianCPLDetailActivity.this.mContext).putBoolean(DianCPLDetailActivity.this.mContext.getString(R.string.moku_sp_is_show_dialog_gallery_tip), false);
                Finish finish2 = finish;
                if (finish2 != null) {
                    finish2.finish();
                }
            }
        }).setCancelable(false).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showUiTips(int i) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        OperationEnum operationEnum = this.mApiTaskOperationHelper.getOperationEnum();
        if (i == 4) {
            this.mBtnStartTask.setVisibility(8);
            this.mLlOnTask.setVisibility(0);
            this.mPbDownload.setProgress(100);
        }
        switch (AnonymousClass29.$SwitchMap$com$fendasz$moku$planet$entity$OperationEnum[operationEnum.ordinal()]) {
            case 1:
                if (i == 4) {
                    this.mBtnStartTask.setVisibility(0);
                    this.mLlOnTask.setVisibility(8);
                }
                if (i == 1) {
                    Toast.makeText(this.mContext, "请先【开始任务】", 0).show();
                }
                if (i == 5) {
                    showMasking(this.mBtnStartTask, BitmapFactory.decodeResource(this.mContext.getResources(), R.drawable.moku_masking2), GuideDialog.Orientation.TOP_RIGHT, new Integer[]{Integer.valueOf(this.mPhoneScreenUtils.getScale(this.mContext, 10.0f)), Integer.valueOf(this.mPhoneScreenUtils.getScale(this.mContext, 10.0f)), Integer.valueOf(this.mPhoneScreenUtils.getScale(this.mContext, 10.0f)), Integer.valueOf(this.mPhoneScreenUtils.getScale(this.mContext, 10.0f))}, new Integer[]{Integer.valueOf(this.mPhoneScreenUtils.getScale(this.mContext, 0.0f)), Integer.valueOf(this.mPhoneScreenUtils.getScale(this.mContext, 150.0f)), Integer.valueOf(this.mPhoneScreenUtils.getScale(this.mContext, 20.0f)), Integer.valueOf(this.mPhoneScreenUtils.getScale(this.mContext, 0.0f))}, null);
                }
                if ((i == 2 || i == 4) && -1 != this.mClientGameTaskData.getCplTaskStatus().intValue()) {
                    this.mBtnStartTask.setVisibility(8);
                    this.mLlOnTask.setVisibility(0);
                    if (SystemUtils.isAppExist(this.mContext, this.mClientGameTaskData.getApkApplicationId())) {
                        this.mTvDownload.setText("打开" + this.mClientGameTaskData.getTagText());
                        try {
                            long openAppLong = this.mApiTaskOperationHelper.getOpenAppLong(this.mContext, this.mClientGameTaskData.getPackageName(), true);
                            if (getCplTaskLogFlag(this.mContext, this.mClientGameTaskData.getTaskDataId().intValue(), this.mClientGameTaskData.getPackageName(), this.mClientGameTaskData.getApkApplicationId()) == 0 && openAppLong > 0) {
                                recordCplTaskLogFlag(this.mContext, this.mClientGameTaskData.getTaskDataId().intValue(), this.mClientGameTaskData.getPackageName(), this.mClientGameTaskData.getApkApplicationId());
                                this.mApiTaskOperationHelper.dianCplLog(this.mContext, this.mClientGameTaskData.getPackageName(), false);
                                break;
                            }
                        } catch (MokuException e) {
                            e.printStackTrace();
                            return;
                        }
                    } else {
                        this.mTvDownload.setText("安装" + this.mClientGameTaskData.getTagText());
                        break;
                    }
                }
                break;
            case 3:
                if (i == 4 || i == 3) {
                    this.mTvDownload.setText("下载" + this.mClientGameTaskData.getTagText() + (TextUtils.isEmpty(this.mExpirationTime) ? "" : "\n任务剩余：" + getRemainTime()));
                    this.mTvDownload.setTextSize(this.mPhoneScreenUtils.getMiddleTextSize(this.mContext));
                    break;
                }
                break;
            case 4:
                if (i == 4 || i == 3) {
                    this.mTvDownload.setText("下载" + this.mClientGameTaskData.getTagText() + (TextUtils.isEmpty(this.mExpirationTime) ? "" : "\n任务剩余：" + getRemainTime()));
                    this.mTvDownload.setTextSize(this.mPhoneScreenUtils.getMiddleTextSize(this.mContext));
                }
                if (i == 0 || i == 1) {
                    Toast.makeText(this.mContext, "请先下载安装指定" + this.mClientGameTaskData.getTagText(), 0).show();
                    break;
                }
                break;
            case 6:
                if (i == 4 || i == 3) {
                    this.mTvDownload.setText("继续下载" + (TextUtils.isEmpty(this.mExpirationTime) ? "" : "\n任务剩余：" + getRemainTime()));
                    this.mTvDownload.setTextSize(this.mPhoneScreenUtils.getMiddleTextSize(this.mContext));
                    break;
                }
                break;
            case 7:
                if (i == 4 || i == 3) {
                    this.mTvDownload.setText("继续下载" + (TextUtils.isEmpty(this.mExpirationTime) ? "" : "\n任务剩余：" + getRemainTime()));
                    this.mTvDownload.setTextSize(this.mPhoneScreenUtils.getMiddleTextSize(this.mContext));
                    break;
                }
                break;
            case 8:
                if (i == 4 || i == 3) {
                    this.mTvDownload.setText("打开" + this.mClientGameTaskData.getTagText() + (TextUtils.isEmpty(this.mExpirationTime) ? "" : "\n任务剩余：" + getRemainTime()));
                    this.mTvDownload.setTextSize(this.mPhoneScreenUtils.getMiddleTextSize(this.mContext));
                }
                if (i == 0 || i == 1) {
                    Toast.makeText(this.mContext, "请去应用市场下载指定软件，若您已经下载，请检查下载是否正确，软件为【" + this.mClientGameTaskData.getTaskData().getTaskDataDetail().getAppName() + "】", 0).show();
                    break;
                }
                break;
            case 9:
                if (i == 4 || i == 3) {
                    this.mTvDownload.setText("打开" + this.mClientGameTaskData.getTagText() + (TextUtils.isEmpty(this.mExpirationTime) ? "" : "\n任务剩余：" + getRemainTime()));
                    this.mTvDownload.setTextSize(this.mPhoneScreenUtils.getMiddleTextSize(this.mContext));
                }
                if ((i == 0 || i == 1) && this.mClientGameTaskData.getListenerTime() != null && this.mClientGameTaskData.getListenerTime().intValue() > 0) {
                    if (this.mClientGameTaskData.getClassify().equals("cpa") && !this.mClientGameTaskData.getTaskData().getCpaType().equals(MokuConstants.CPA_TYPE_NORMAL)) {
                        Toast.makeText(this.mContext, "请先打开软件试玩" + this.mClientGameTaskData.getListenerTime() + "s，即可答题", 0).show();
                    } else if (this.mClientGameTaskData.getClassify().equals("cpa") && this.mClientGameTaskData.getTaskData().getCpaType().equals(MokuConstants.CPA_TYPE_NORMAL)) {
                        Toast.makeText(this.mContext, "请先打开软件试玩" + this.mClientGameTaskData.getListenerTime() + "s，即可获得奖励", 0).show();
                    } else {
                        Toast.makeText(this.mContext, "请先打开软件试玩" + this.mClientGameTaskData.getListenerTime() + "s，即可上传图片", 0).show();
                    }
                }
                if (i == 5) {
                    Toast.makeText(this.mContext, "请先下载安装指定" + this.mClientGameTaskData.getTagText() + "，并打开体验！", 0).show();
                    break;
                }
                break;
            case 10:
                if (i == 4 || i == 3) {
                    this.mTvDownload.setText("安装" + this.mClientGameTaskData.getTagText() + (TextUtils.isEmpty(this.mExpirationTime) ? "" : "\n任务剩余：" + getRemainTime()));
                    this.mTvDownload.setTextSize(this.mPhoneScreenUtils.getMiddleTextSize(this.mContext));
                    break;
                }
                break;
            case 11:
                if (i == 4 || i == 3) {
                    if (-1 != this.mClientGameTaskData.getCplTaskStatus().intValue()) {
                        this.mTvDownload.setText("安装" + this.mClientGameTaskData.getTagText() + (TextUtils.isEmpty(this.mExpirationTime) ? "" : "\n任务剩余：" + getRemainTime()));
                        this.mTvDownload.setTextSize(this.mPhoneScreenUtils.getMiddleTextSize(this.mContext));
                    } else {
                        this.mTvDownload.setText("开始任务" + (TextUtils.isEmpty(this.mExpirationTime) ? "" : "\n任务剩余：" + getRemainTime()));
                        this.mTvDownload.setTextSize(this.mPhoneScreenUtils.getMiddleTextSize(this.mContext));
                    }
                }
                if (i == 0 || i == 1) {
                    Toast.makeText(this.mContext, "请先下载安装指定" + this.mClientGameTaskData.getTagText(), 0).show();
                }
                if (i == 5) {
                    Toast.makeText(this.mContext, "请先下载安装指定" + this.mClientGameTaskData.getTagText() + "，并打开体验！", 0).show();
                    break;
                }
                break;
            case 12:
                if (i == 4) {
                    this.mTvDownload.setText("安装" + this.mClientGameTaskData.getTagText() + (TextUtils.isEmpty(this.mExpirationTime) ? "" : "\n任务剩余：" + getRemainTime()));
                    this.mTvDownload.setTextSize(this.mPhoneScreenUtils.getMiddleTextSize(this.mContext));
                    executeTask();
                }
                if (i == 3) {
                    this.mTvDownload.setText("安装" + this.mClientGameTaskData.getTagText() + (TextUtils.isEmpty(this.mExpirationTime) ? "" : "\n任务剩余：" + getRemainTime()));
                    this.mTvDownload.setTextSize(this.mPhoneScreenUtils.getMiddleTextSize(this.mContext));
                    break;
                }
                break;
            case 13:
                if (i == 4) {
                    this.mTvDownload.setText("继续试玩" + (TextUtils.isEmpty(this.mExpirationTime) ? "" : "\n任务剩余：" + getRemainTime()));
                    this.mTvDownload.setTextSize(this.mPhoneScreenUtils.getMiddleTextSize(this.mContext));
                    showGoOnTaskDialog();
                }
                if (i == 3) {
                    this.mTvDownload.setText("继续试玩" + (TextUtils.isEmpty(this.mExpirationTime) ? "" : "\n任务剩余：" + getRemainTime()));
                    this.mTvDownload.setTextSize(this.mPhoneScreenUtils.getMiddleTextSize(this.mContext));
                }
                if (i == 1 || i == 5) {
                    showGoOnTaskDialog();
                    break;
                }
                break;
            case 14:
                if (i == 4) {
                    CustomBuildDialog customBuildDialog = this.mGoOnTaskDialog;
                    if (customBuildDialog != null && customBuildDialog.isShowing()) {
                        this.mGoOnTaskDialog.dismiss();
                    }
                    if (this.mClientGameTaskData.getClassify().equals("cpa")) {
                        this.mTvDownload.setText("继续试玩" + (TextUtils.isEmpty(this.mExpirationTime) ? "" : "\n任务剩余：" + getRemainTime()));
                    } else if (MokuConstants.TASK_TYPE_CPL.equals(this.mClientGameTaskData.getClassify())) {
                        this.mTvDownload.setText("打开" + this.mClientGameTaskData.getTagText());
                    } else {
                        this.mTvDownload.setText("提交任务" + (TextUtils.isEmpty(this.mExpirationTime) ? "" : "\n任务剩余：" + getRemainTime()));
                    }
                    this.mTvDownload.setTextSize(this.mPhoneScreenUtils.getMiddleTextSize(this.mContext));
                }
                if (i == 3) {
                    if (this.mClientGameTaskData.getClassify().equals("cpa")) {
                        this.mTvDownload.setText("继续试玩" + (TextUtils.isEmpty(this.mExpirationTime) ? "" : "\n任务剩余：" + getRemainTime()));
                    } else {
                        this.mTvDownload.setText("提交任务" + (TextUtils.isEmpty(this.mExpirationTime) ? "" : "\n任务剩余：" + getRemainTime()));
                    }
                    this.mTvDownload.setTextSize(this.mPhoneScreenUtils.getMiddleTextSize(this.mContext));
                    break;
                }
                break;
            case 15:
                if (i == 4) {
                    this.mTvDownload.setText("任务超时" + (TextUtils.isEmpty(this.mExpirationTime) ? "" : "\n任务剩余：" + getRemainTime()));
                    this.mTvDownload.setTextSize(this.mPhoneScreenUtils.getMiddleTextSize(this.mContext));
                    this.mPbDownload.setProgress(0);
                    this.mBtnStartTask.setVisibility(0);
                    this.mLlOnTask.setVisibility(8);
                }
                if (i == 2 || i == 3) {
                    new CustomBuildDialog.DialogBuilder(this.mContext).setTitleImage(Integer.valueOf(R.drawable.moku_tips_icon)).setDetailText("您的任务已经超时啦~\n需要帮您重新开始么").setCancelable(false).setLeftBtn("不了", new CustomBuildDialog.DialogButtonOnClickListener() { // from class: com.fendasz.moku.diandian.model.detail.DianCPLDetailActivity.21
                        @Override // com.fendasz.moku.planet.ui.dialog.CustomBuildDialog.DialogButtonOnClickListener
                        public void onClick(TextView textView, CustomBuildDialog customBuildDialog2) {
                            customBuildDialog2.dismiss();
                            DianCPLDetailActivity dianCPLDetailActivity = DianCPLDetailActivity.this;
                            dianCPLDetailActivity.cancelTask(dianCPLDetailActivity.mClientGameTaskData, new com.fendasz.moku.planet.interf.functions.Consumer<TaskDataApplyRecord>() { // from class: com.fendasz.moku.diandian.model.detail.DianCPLDetailActivity.21.1
                                @Override // com.fendasz.moku.planet.interf.functions.Consumer
                                public void accept(TaskDataApplyRecord taskDataApplyRecord) throws Exception {
                                    DianCPLDetailActivity.this.cancelTaskCallBack(taskDataApplyRecord);
                                }
                            });
                        }
                    }).setRightBtn("重新开始", new CustomBuildDialog.DialogButtonOnClickListener() { // from class: com.fendasz.moku.diandian.model.detail.DianCPLDetailActivity.20
                        @Override // com.fendasz.moku.planet.ui.dialog.CustomBuildDialog.DialogButtonOnClickListener
                        public void onClick(TextView textView, CustomBuildDialog customBuildDialog2) {
                            customBuildDialog2.dismiss();
                            DianCPLDetailActivity.this.getTaskDataStatus(false);
                        }
                    }).create().show();
                    break;
                }
                break;
            case 16:
                if (i == 2) {
                    this.mBtnStartTask.setVisibility(0);
                    this.mLlOnTask.setVisibility(8);
                    this.mBtnStartTask.setText(this.mContext.getString(R.string.moku_start_task_btn_text__take_up));
                    this.mBtnStartTask.setEnabled(false);
                    Toast.makeText(this.mContext, "这个任务已经被抢完啦~", 0).show();
                    break;
                }
                break;
        }
    }

    /* renamed from: com.fendasz.moku.diandian.model.detail.DianCPLDetailActivity$29, reason: invalid class name */
    static /* synthetic */ class AnonymousClass29 {
        static final /* synthetic */ int[] $SwitchMap$com$fendasz$moku$planet$entity$OperationEnum;

        static {
            int[] iArr = new int[OperationEnum.values().length];
            $SwitchMap$com$fendasz$moku$planet$entity$OperationEnum = iArr;
            try {
                iArr[OperationEnum.SUCCESS_START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$fendasz$moku$planet$entity$OperationEnum[OperationEnum.SUCCESS_APPLY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$fendasz$moku$planet$entity$OperationEnum[OperationEnum.SUCCESS_DOWNLOAD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$fendasz$moku$planet$entity$OperationEnum[OperationEnum.SUCCESS_DOWNLOAD_APP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$fendasz$moku$planet$entity$OperationEnum[OperationEnum.SUCCESS_DOWNLOAD_LOADING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$fendasz$moku$planet$entity$OperationEnum[OperationEnum.SUCCESS_CONTINUE_DOWNLOAD.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$fendasz$moku$planet$entity$OperationEnum[OperationEnum.ERROR_DOWNLOAD.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$fendasz$moku$planet$entity$OperationEnum[OperationEnum.SUCCESS_OPEN.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$fendasz$moku$planet$entity$OperationEnum[OperationEnum.SUCCESS_OPEN_APP.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$fendasz$moku$planet$entity$OperationEnum[OperationEnum.SUCCESS_INSTALL.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$fendasz$moku$planet$entity$OperationEnum[OperationEnum.SUCCESS_INSTALL_APP.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$fendasz$moku$planet$entity$OperationEnum[OperationEnum.SUCCESS_AUTO_INSTALL_APP.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$fendasz$moku$planet$entity$OperationEnum[OperationEnum.SUCCESS_CONTINUE_DEMO.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$fendasz$moku$planet$entity$OperationEnum[OperationEnum.SUCCESS_SUBMIT.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$fendasz$moku$planet$entity$OperationEnum[OperationEnum.ERROR_OVERTIME.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$fendasz$moku$planet$entity$OperationEnum[OperationEnum.ERROR_TAKEUP.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
        }
    }

    private void showMasking(View view, Bitmap bitmap, GuideDialog.Orientation orientation, Integer[] numArr, Integer[] numArr2, View view2) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        GuideDialog.Builder builder = new GuideDialog.Builder(this.mContext);
        if (view != null) {
            builder.setHighlightView(view);
        }
        if (bitmap != null) {
            builder.setGuideBitmap(bitmap);
        }
        if (orientation != null) {
            builder.setOrientation(orientation);
        }
        if (numArr != null) {
            builder.setHighlightViewMargin(numArr[0], numArr[1], numArr[2], numArr[3]);
        }
        if (numArr2 != null) {
            builder.setGuideBitMapMargin(numArr2[0], numArr2[1], numArr2[2], numArr2[3]);
        }
        if (view2 != null) {
            builder.setView(view2);
        }
        GuideDialog guideDialogCreate = builder.create();
        this.mGuideDialog = guideDialogCreate;
        guideDialogCreate.show();
    }

    private String getRemainTime() {
        String str = this.mExpirationTime;
        if (str == null || this.currentTime == null) {
            return "";
        }
        long time = DateUtils.getDate(str, "yyyy-MM-dd HH:mm:ss").getTime() - this.currentTime.longValue();
        return time > 0 ? DateUtils.getFormatDate(time, "小时", "分钟", "秒") : "00小时00分钟00秒";
    }

    private void showGoOnTaskDialog() {
        if (this.mTime != null) {
            CustomBuildDialog.DialogBuilder titleImage = new CustomBuildDialog.DialogBuilder(this.mContext).setTitleImage(Integer.valueOf(R.drawable.moku_tips_icon));
            if (this.mClientGameTaskData.getClassify().equals("cpa") && !this.mClientGameTaskData.getTaskData().getCpaType().equals(MokuConstants.CPA_TYPE_NORMAL)) {
                titleImage.setDetailText("试玩时间未到，还需试玩" + this.mTime + "分钟，即可提交答案");
            } else {
                titleImage.setDetailText("试玩时间未到，还需试玩" + this.mTime + "分钟，即可提交任务");
            }
            CustomBuildDialog customBuildDialog = this.mGoOnTaskDialog;
            if (customBuildDialog != null && customBuildDialog.isShowing()) {
                this.mGoOnTaskDialog.dismiss();
            }
            CustomBuildDialog customBuildDialogCreate = titleImage.setRightBtn("继续试玩", new CustomBuildDialog.DialogButtonOnClickListener() { // from class: com.fendasz.moku.diandian.model.detail.DianCPLDetailActivity$$ExternalSyntheticLambda0
                @Override // com.fendasz.moku.planet.ui.dialog.CustomBuildDialog.DialogButtonOnClickListener
                public final void onClick(TextView textView, CustomBuildDialog customBuildDialog2) {
                    this.f$0.m385xff31f3cc(textView, customBuildDialog2);
                }
            }).setCancelable(true).create();
            this.mGoOnTaskDialog = customBuildDialogCreate;
            customBuildDialogCreate.show();
        }
    }

    /* renamed from: lambda$showGoOnTaskDialog$1$com-fendasz-moku-diandian-model-detail-DianCPLDetailActivity, reason: not valid java name */
    /* synthetic */ void m385xff31f3cc(TextView textView, CustomBuildDialog customBuildDialog) {
        customBuildDialog.dismiss();
        executeTask();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelTaskCallBack(TaskDataApplyRecord taskDataApplyRecord) {
        this.mClientGameTaskData.setTaskDataApplyRecord(taskDataApplyRecord);
        this.mApiTaskOperationHelper.cancelTask(this.mContext);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onInitComplete(boolean z) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        OperationEnum operationEnum = this.mApiTaskOperationHelper.getOperationEnum();
        if (operationEnum != null && !operationEnum.equals(OperationEnum.SUCCESS_START) && !operationEnum.equals(OperationEnum.ERROR_OVERTIME) && !operationEnum.equals(OperationEnum.ERROR_TAKEUP)) {
            startCountDown();
        } else if (z && !getIsFirstCpaTask()) {
            getTaskDataStatus(true);
        }
        showUiTips(2);
        onInitStatusComplete();
    }

    private boolean getIsFirstCpaTask() {
        if (!"cpa".equals(this.mClientGameTaskData.getClassify())) {
            return false;
        }
        if (!this.mClientGameTaskData.getTaskData().getCpaType().equals(MokuConstants.CPA_TYPE_NORMAL)) {
            return SharedPreferencesUtils.getInstance(this.mContext).getBoolean("moku_first_cpa_answer_task", true);
        }
        return SharedPreferencesUtils.getInstance(this.mContext).getBoolean("moku_first_cpa_normal_task", true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkAndSubmit(Action action) {
        submitTask(action);
    }

    private void submitTask(Action action) {
        try {
            action.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void submitNormalTask() throws NoSuchMethodException, SecurityException {
        LoadingDialog.show(this.mContext);
        MokuConfigure.getInstance().updateUserType(this.mContext, 2);
        ApiDataHelper.getApiDataHelper().uploadDeviceInfo(this, new ApiDataCallBack<Object>() { // from class: com.fendasz.moku.diandian.model.detail.DianCPLDetailActivity.22
            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void success(int i, Object obj) throws Exception {
                Log.d(DianCPLDetailActivity.TAG, "device info success");
            }

            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void error(int i, String str) throws Exception {
                LogUtils.logE(DianCPLDetailActivity.TAG, "device info error,code=>" + i + ",message" + str);
            }
        });
        ApiDataHelper.getApiDataHelper().submitTask(this.mContext, this.mClientGameTaskData, (List<File>) null, (List<ClientTaskDataSubmitFormModel>) null, this.mAdditionalData, new AnonymousClass23());
    }

    /* renamed from: com.fendasz.moku.diandian.model.detail.DianCPLDetailActivity$23, reason: invalid class name */
    class AnonymousClass23 implements ApiDataCallBack<String> {
        AnonymousClass23() {
        }

        @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
        public void success(int i, String str) throws Exception {
            LoadingDialog.dismiss();
            LogUtils.log(DianCPLDetailActivity.TAG, "submit task success");
            DianCPLDetailActivity.this.setResult(300);
            new CustomBuildDialog.DialogBuilder(DianCPLDetailActivity.this.mContext).setTitleImage(Integer.valueOf(R.drawable.moku_task_finished)).setTitleText("提交成功").setDetailText("预计<font color=\"#ff0000\">" + str + "</font>前审核完成").setRightBtn(DianCPLDetailActivity.this.getString(R.string.moku_btn_continue), new CustomBuildDialog.DialogButtonOnClickListener() { // from class: com.fendasz.moku.diandian.model.detail.DianCPLDetailActivity$23$$ExternalSyntheticLambda0
                @Override // com.fendasz.moku.planet.ui.dialog.CustomBuildDialog.DialogButtonOnClickListener
                public final void onClick(TextView textView, CustomBuildDialog customBuildDialog) {
                    this.f$0.m386xf15e9070(textView, customBuildDialog);
                }
            }).setCancelable(false).create().show();
            DianCPLDetailActivity.this.sendTaskSubmitBroadcast();
        }

        /* renamed from: lambda$success$0$com-fendasz-moku-diandian-model-detail-DianCPLDetailActivity$23, reason: not valid java name */
        /* synthetic */ void m386xf15e9070(TextView textView, CustomBuildDialog customBuildDialog) {
            customBuildDialog.dismiss();
            DianCPLDetailActivity.this.putSpIsShowGuideMyParticipateInTip();
            DianCPLDetailActivity.this.removeSuspendLayout();
            DianCPLDetailActivity.this.finish();
        }

        @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
        public void error(int i, String str) throws Exception {
            LoadingDialog.dismiss();
            LogUtils.log(DianCPLDetailActivity.TAG, "code:" + i + " message:" + str);
            Toast.makeText(DianCPLDetailActivity.this.mContext, str + i, 1).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void putSpIsShowGuideMyParticipateInTip() {
        if (SharedPreferencesUtils.getInstance(this.mContext).getInt(this.mContext.getString(R.string.moku_sp_is_show_guide_my_participate_in_tip), 0) == 0) {
            SharedPreferencesUtils.getInstance(this.mContext).putInt(this.mContext.getString(R.string.moku_sp_is_show_guide_my_participate_in_tip), 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendTaskSubmitBroadcast() {
        Intent intent = new Intent(this.mContext.getString(R.string.moku_broadcast_name_action_task_submit));
        intent.putExtra(this.mContext.getString(R.string.moku_intent_extra__submit_task), this.mClientGameTaskData);
        intent.setPackage(getPackageName());
        sendBroadcast(intent);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        removeSuspendLayout();
        if (this.isInit) {
            this.isInit = false;
            onReady();
        } else {
            refreshTaskDetail();
        }
        this.onResumeTime++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshTaskDetail() {
        getTaskDetail(false, false, false, new Success<ClientGameTaskData>() { // from class: com.fendasz.moku.diandian.model.detail.DianCPLDetailActivity.24
            @Override // com.fendasz.moku.planet.interf.Success
            public void success(Integer num, ClientGameTaskData clientGameTaskData) {
                LoadingDialog.dismiss();
                DianCPLDetailActivity.this.loactionState = clientGameTaskData.getLocationStatus();
                DianCPLDetailActivity.this.runOnUiThread(new Runnable() { // from class: com.fendasz.moku.diandian.model.detail.DianCPLDetailActivity.24.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DianCPLDetailActivity.this.webView.reload();
                    }
                });
            }
        });
    }

    private int getCplTaskLogFlag(Context context, int i, String str, String str2) {
        return SharedPreferencesUtils.getInstance(context).getInt(i + str + str2 + "_dian", 0);
    }

    private void recordCplTaskLogFlag(Context context, int i, String str, String str2) {
        SharedPreferencesUtils.getInstance(context).putInt(i + str + str2 + "_dian", 1);
    }

    private void initMokuJsLisetener() {
        this.mokuJsListener = new MokuJsObjectListenerImpl(this) { // from class: com.fendasz.moku.diandian.model.detail.DianCPLDetailActivity.25
            @Override // com.fendasz.moku.planet.common.MokuJsObjectListenerImpl, com.fendasz.moku.planet.common.MokuJsObject.OnMokuJsListener
            public boolean isDian() {
                return true;
            }

            @Override // com.fendasz.moku.planet.common.MokuJsObjectListenerImpl, com.fendasz.moku.planet.common.MokuJsObject.OnMokuJsListener
            public void showScreenImage(String str) {
            }

            @Override // com.fendasz.moku.planet.common.MokuJsObjectListenerImpl, com.fendasz.moku.planet.common.MokuJsObject.OnMokuJsListener
            public void refreshData() {
                if (DianCPLDetailActivity.this.refreClickTime == 0) {
                    DianCPLDetailActivity.this.refreshTaskDetail();
                    DianCPLDetailActivity.this.refreClickTime = System.currentTimeMillis();
                } else {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    if (jCurrentTimeMillis - DianCPLDetailActivity.this.refreClickTime > b.a) {
                        DianCPLDetailActivity.this.refreClickTime = jCurrentTimeMillis;
                        DianCPLDetailActivity.this.refreshTaskDetail();
                    }
                }
            }

            @Override // com.fendasz.moku.planet.common.MokuJsObjectListenerImpl
            public String taskDataId() {
                return String.valueOf(DianCPLDetailActivity.this.mTaskDataId);
            }

            @Override // com.fendasz.moku.planet.common.MokuJsObjectListenerImpl
            public void toCustomerService() {
                super.toCustomerService();
                DianCPLDetailActivity.this.startActivityForResult(new Intent(DianCPLDetailActivity.this, (Class<?>) MokuCustomerServiceActivity.class), 400);
            }
        };
    }

    @Override // com.fendasz.moku.planet.ui.base.activity.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.d(TAG, "onNewIntent==>");
        if (this.suspendLayout != null && this.isAddsuspendLayout) {
            ((WindowManager) getSystemService("window")).removeView(this.suspendLayout);
            this.isAddsuspendLayout = false;
        }
        onSuperCreate(intent.getExtras());
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        WindowManager windowManager;
        super.onStart();
        if (this.suspendLayout == null || !this.isAddsuspendLayout || (windowManager = (WindowManager) getSystemService("window")) == null) {
            return;
        }
        windowManager.removeView(this.suspendLayout);
        this.isAddsuspendLayout = false;
    }

    @Override // com.fendasz.moku.planet.ui.base.activity.BaseBackActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
        Integer cplTaskStatus = -1;
        ClientGameTaskData clientGameTaskData = this.mClientGameTaskData;
        if (clientGameTaskData != null && clientGameTaskData.getCplTaskStatus() != null) {
            cplTaskStatus = this.mClientGameTaskData.getCplTaskStatus();
        }
        if (cplTaskStatus.intValue() == -1 || isFinishing()) {
            return;
        }
        this.isAddsuspendLayout = true;
        try {
            this.suspendLayout = FloatingUtil.getInstance().addBaseView((Activity) this.mContext, this.mClientGameTaskData, new FloatingUtil.OnFloatingListener() { // from class: com.fendasz.moku.diandian.model.detail.DianCPLDetailActivity.26
                @Override // com.fendasz.moku.planet.utils.FloatingUtil.OnFloatingListener
                public void onFloating() {
                    if (Build.VERSION.SDK_INT < 29) {
                        FloatingUtil.getInstance().moveAppToFront(DianCPLDetailActivity.this.getApplication());
                    } else {
                        DianCPLDetailActivity.this.startActivity(new Intent(DianCPLDetailActivity.this, (Class<?>) DianCPLDetailActivity.class));
                    }
                }
            });
        } catch (Exception unused) {
            LogUtils.logE(TAG, "task detail activity add suspend layout error");
        }
    }

    @Override // com.fendasz.moku.planet.ui.base.activity.BaseBackActivity, com.fendasz.moku.planet.ui.base.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        Log.d(TAG, "onDestroy==>");
        this.webView.removeAllViews();
        this.webView.destroy();
        this.mokuJsListener.finish();
        if (this.suspendLayout != null && this.isAddsuspendLayout) {
            ((WindowManager) getSystemService("window")).removeViewImmediate(this.suspendLayout);
            this.isAddsuspendLayout = false;
        }
        this.mApiTaskOperationHelper.onDestroy();
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeSuspendLayout() {
        if (this.suspendLayout == null || !this.isAddsuspendLayout) {
            return;
        }
        this.isAddsuspendLayout = false;
        ((WindowManager) getSystemService("window")).removeView(this.suspendLayout);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void cplLog() {
        if (this.fromType != 1001) {
            return;
        }
        if (this.cplLogResult != 0) {
            return;
        }
        ApiDataHelper.getApiDataHelper().dianCpaLog(this.mContext, GlobalSetting.UNIFIED_INTERSTITIAL_HS_AD, this.mClientGameTaskData.getTaskDataId(), new ApiDataCallBack<Object>() { // from class: com.fendasz.moku.diandian.model.detail.DianCPLDetailActivity.27
            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void success(int i, Object obj) throws Exception {
                Log.d(DianCPLDetailActivity.TAG, "cpaLog success");
                DianCPLDetailActivity.this.cplLogResult = 1;
            }

            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void error(int i, String str) throws Exception {
                Log.d(DianCPLDetailActivity.TAG, "cpaLog error,message:" + str);
                DianCPLDetailActivity.this.cplLogResult = 0;
            }
        });
    }

    @Override // com.fendasz.moku.planet.ui.base.activity.BaseActivity
    public void acceptLightData(float f) throws NoSuchMethodException, SecurityException {
        super.acceptLightData(f);
        MokuConfigure.getInstance().updateOptical(this.mContext, String.valueOf(f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uplodatePackage() {
        ApiDataHelper.getApiDataHelper().postPackages(this.mContext, new ApiDataCallBack<String>() { // from class: com.fendasz.moku.diandian.model.detail.DianCPLDetailActivity.28
            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void success(int i, String str) throws Exception {
                LogUtils.logD(DianCPLDetailActivity.TAG, "upload postPackages success");
            }

            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void error(int i, String str) throws Exception {
                LogUtils.logE(DianCPLDetailActivity.TAG, "upload postPackages error,message=>" + str);
            }
        });
    }
}
