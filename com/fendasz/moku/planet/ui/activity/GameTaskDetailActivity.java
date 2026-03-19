package com.fendasz.moku.planet.ui.activity;

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
import com.fendasz.moku.planet.ui.base.activity.BaseBackActivity;
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
public class GameTaskDetailActivity extends BaseBackActivity implements ApiOperationCallBack {
    private static final int CODE_COUNT_DOWN = 3;
    private static final int CODE_START_TASK = 0;
    private static final int CODE_SUBMIT_ANSWER = 5;
    private static final int CODE_TASK_STATUS = 4;
    private static final int CODE_UPLOAD_SCREENSHOT = 1;
    private static final int CODE_VIEW_INIT = 2;
    public static final int RESULT_CODE_FOR_FINISH = 2;
    public static final int RESULT_CODE_FOR_REFRESH_TASK_LIST = 300;
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
    private static final String DATA_DETAILURL_DEBUG = MokuConstants.H5Url.H5_CPL_DEBUG.getUrl();
    private static final String DATA_DETAILURL_RELEASE = MokuConstants.H5Url.H5_CPL_RELEASE.getUrl();
    private static final String TAG = "GameTaskDetailActivity";
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
        String str2 = TAG;
        LogUtils.log(str2, "operationEnum >> " + operationEnum.getCode() + ":" + operationEnum.getMessage() + " progress >> " + str);
        int i = (int) Double.parseDouble(str);
        String str3 = i + "%";
        if (this.mClientGameTaskData.getClassify().equals("keyword") || this.mClientGameTaskData.getClassify().equals("comment")) {
            this.mTvDownload.setText("下载应用市场 " + str3);
        } else {
            this.mTvDownload.setText("下载" + this.mClientGameTaskData.getTagText() + str3);
        }
        LogUtils.log(str2, "strProgress:" + str3);
        this.mPbDownload.setProgress(i);
        LogUtils.log(str2, "progressValue:" + i);
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

    @Override // com.fendasz.moku.planet.ui.base.activity.BaseActivity
    public void initTitle(TextView textView) {
        if (textView != null) {
            textView.setText("任务详情");
            textView.getPaint().setTextSize(CanvasUtils.getTextSize(this.phoneScreenUtils.getScale(this, 70.0f)));
        }
    }

    @Override // com.fendasz.moku.planet.ui.base.activity.BaseActivity
    protected void onLoad() {
        initView();
        initWebView();
        initStaticViewListener();
    }

    @Override // com.fendasz.moku.planet.ui.base.activity.BaseBackActivity, com.fendasz.moku.planet.ui.base.activity.BaseActivity
    public void initLeftView(TextView textView) {
        super.initLeftView(textView);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.fendasz.moku.planet.ui.activity.GameTaskDetailActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT >= 19) {
                    GameTaskDetailActivity.this.webView.evaluateJavascript("javascript:htmlHistoryBcak()", new ValueCallback<String>() { // from class: com.fendasz.moku.planet.ui.activity.GameTaskDetailActivity.1.1
                        @Override // android.webkit.ValueCallback
                        public void onReceiveValue(String str) {
                            if (str != null) {
                                try {
                                    if (Boolean.parseBoolean(str)) {
                                        GameTaskDetailActivity.this.finish();
                                    }
                                } catch (Exception unused) {
                                    GameTaskDetailActivity.this.finish();
                                }
                            }
                        }
                    });
                } else {
                    GameTaskDetailActivity.this.finish();
                }
            }
        });
    }

    private void initStaticViewListener() {
        RelativeLayout relativeLayout = this.mRlDownload;
        if (relativeLayout != null) {
            relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.fendasz.moku.planet.ui.activity.GameTaskDetailActivity.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                    if (GameTaskDetailActivity.this.mApiTaskOperationHelper.getOperationEnum() != OperationEnum.SUCCESS_SUBMIT) {
                        GameTaskDetailActivity.this.showUiTips(0);
                        if (SystemUtils.isAppExist(GameTaskDetailActivity.this.mContext, GameTaskDetailActivity.this.mClientGameTaskData.getApkApplicationId())) {
                            SystemUtils.openPackage(GameTaskDetailActivity.this.mContext, GameTaskDetailActivity.this.mClientGameTaskData.getPackageName());
                            return;
                        } else {
                            GameTaskDetailActivity.this.executeTask();
                            return;
                        }
                    }
                    if (!"cpa".equals(GameTaskDetailActivity.this.mClientGameTaskData.getClassify()) || MokuConstants.CPA_TYPE_NORMAL.equals(GameTaskDetailActivity.this.mClientGameTaskData.getTaskData().getCpaType())) {
                        if (MokuConstants.TASK_TYPE_CPL.equals(GameTaskDetailActivity.this.mClientGameTaskData.getClassify())) {
                            SystemUtils.openPackage(GameTaskDetailActivity.this.mContext, GameTaskDetailActivity.this.mClientGameTaskData.getPackageName());
                            return;
                        } else {
                            GameTaskDetailActivity.this.checkAndSubmit(new Action() { // from class: com.fendasz.moku.planet.ui.activity.GameTaskDetailActivity.2.1
                                @Override // io.reactivex.functions.Action
                                public void run() throws Exception {
                                    GameTaskDetailActivity.this.submitNormalTask();
                                }
                            });
                            return;
                        }
                    }
                    SystemUtils.openPackage(GameTaskDetailActivity.this.mContext, GameTaskDetailActivity.this.mClientGameTaskData.getPackageName());
                }
            });
        }
        Button button = this.mBtnStartTask;
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() { // from class: com.fendasz.moku.planet.ui.activity.GameTaskDetailActivity.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    if (jCurrentTimeMillis - GameTaskDetailActivity.this.clickTime > 1000) {
                        GameTaskDetailActivity.this.clickTime = jCurrentTimeMillis;
                        GameTaskDetailActivity.this.getTaskDataStatus(false);
                    } else {
                        LogUtils.log(GameTaskDetailActivity.TAG, "repeat click");
                        Toast.makeText(GameTaskDetailActivity.this.mContext, "不要重复点击", 1).show();
                    }
                }
            });
        }
    }

    private void onReady() {
        getTaskDetail(true, false, false, new Success<ClientGameTaskData>() { // from class: com.fendasz.moku.planet.ui.activity.GameTaskDetailActivity.4
            @Override // com.fendasz.moku.planet.interf.Success
            public void success(Integer num, ClientGameTaskData clientGameTaskData) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, SecurityException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
                GameTaskDetailActivity.this.loactionState = clientGameTaskData.getLocationStatus();
                LogUtils.logD(GameTaskDetailActivity.TAG, "get task detail,loactionState=>" + GameTaskDetailActivity.this.loactionState + ",isInti=>" + GameTaskDetailActivity.this.isInit);
                if (1 == GameTaskDetailActivity.this.loactionState.intValue()) {
                    GameTaskDetailActivity.this.queryLocationInfo();
                }
                if (!TextUtils.isEmpty(GameTaskDetailActivity.this.mGateType) && clientGameTaskData != null) {
                    LogUtils.log(GameTaskDetailActivity.TAG, "postGateType " + GameTaskDetailActivity.this.mGateType);
                    ApiDataHelper.getApiDataHelper().postGateType(GameTaskDetailActivity.this.mContext, GameTaskDetailActivity.this.mGateType, clientGameTaskData.getTaskDataId(), new ApiDataCallBack<Object>() { // from class: com.fendasz.moku.planet.ui.activity.GameTaskDetailActivity.4.1
                        @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
                        public void success(int i, Object obj) throws Exception {
                            LogUtils.log(GameTaskDetailActivity.TAG, "postGateType success");
                        }

                        @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
                        public void error(int i, String str) throws Exception {
                            LogUtils.log(GameTaskDetailActivity.TAG, "postGateType error >> " + str);
                        }
                    });
                }
                GameTaskDetailActivity.this.cplLog();
                if (GameTaskDetailActivity.this.fromType == 1001) {
                    GameTaskDetailActivity.this.applyTask(true);
                }
            }
        });
    }

    @Override // com.fendasz.moku.planet.ui.base.activity.BaseActivity
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
        this.webView.setWebViewClient(new WebViewClient() { // from class: com.fendasz.moku.planet.ui.activity.GameTaskDetailActivity.5
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
                    Log.d(GameTaskDetailActivity.TAG, "request==>,errorCode==" + webResourceError.getErrorCode() + ",errorMsg=>" + ((Object) webResourceError.getDescription()) + i.d);
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
        ApiDataHelper.getApiDataHelper().getTaskDataStatus(this.mContext, new ApiDataCallBack<TaskDataApplyRecord>() { // from class: com.fendasz.moku.planet.ui.activity.GameTaskDetailActivity.6
            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void success(int i, TaskDataApplyRecord taskDataApplyRecord) throws Exception {
                LoadingDialog.dismiss();
                if (taskDataApplyRecord == null || taskDataApplyRecord.getTaskDataId().intValue() == GameTaskDetailActivity.this.mTaskDataId) {
                    GameTaskDetailActivity.this.applyTask(!z);
                } else {
                    GameTaskDetailActivity.this.showApplyingTask(taskDataApplyRecord);
                }
            }

            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void error(int i, String str) throws Exception {
                LoadingDialog.dismiss();
                LogUtils.log(GameTaskDetailActivity.TAG, "code:" + i + " message:" + str);
                Toast.makeText(GameTaskDetailActivity.this.mContext, str + i, 1).show();
            }
        });
    }

    /* renamed from: com.fendasz.moku.planet.ui.activity.GameTaskDetailActivity$7, reason: invalid class name */
    class AnonymousClass7 implements Consumer<ClientGameTaskData> {
        AnonymousClass7() {
        }

        @Override // io.reactivex.functions.Consumer
        public void accept(final ClientGameTaskData clientGameTaskData) throws Exception {
            LinearLayout linearLayout = new LinearLayout(GameTaskDetailActivity.this.mContext);
            linearLayout.setOrientation(0);
            linearLayout.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
            final ImageView imageView = new ImageView(GameTaskDetailActivity.this.mContext);
            linearLayout.addView(imageView);
            ((LinearLayout.LayoutParams) imageView.getLayoutParams()).gravity = 16;
            ScreenAdaptationUtils.setSize(GameTaskDetailActivity.this.mContext, imageView, 120, 120);
            ScreenAdaptationUtils.setMarginRight(GameTaskDetailActivity.this.mContext, imageView, 20);
            ImageUtils.getInstance().setImageView(GameTaskDetailActivity.this.mContext, clientGameTaskData.getIcon(), new com.fendasz.moku.planet.interf.functions.Consumer<Bitmap>() { // from class: com.fendasz.moku.planet.ui.activity.GameTaskDetailActivity.7.1
                @Override // com.fendasz.moku.planet.interf.functions.Consumer
                public void accept(Bitmap bitmap) throws Exception {
                    imageView.setImageBitmap(bitmap);
                }
            }, Float.valueOf(GameTaskDetailActivity.this.mPhoneScreenUtils.getScale(GameTaskDetailActivity.this.mContext, 120.0f)), Float.valueOf(GameTaskDetailActivity.this.mPhoneScreenUtils.getScale(GameTaskDetailActivity.this.mContext, 120.0f)));
            LinearLayout linearLayout2 = new LinearLayout(GameTaskDetailActivity.this.mContext);
            linearLayout2.setLayoutParams(new RelativeLayout.LayoutParams(-2, -1));
            linearLayout2.setOrientation(1);
            linearLayout.addView(linearLayout2);
            TextView textView = new TextView(GameTaskDetailActivity.this.mContext);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, 0);
            layoutParams.weight = 1.0f;
            textView.setLayoutParams(layoutParams);
            textView.setSingleLine(true);
            textView.setEllipsize(TextUtils.TruncateAt.END);
            textView.setTextColor(GameTaskDetailActivity.this.mContext.getResources().getColor(R.color.black));
            linearLayout2.addView(textView);
            textView.setText(clientGameTaskData.getShowName());
            textView.setTextSize(GameTaskDetailActivity.this.phoneScreenUtils.getNormalTextSize(GameTaskDetailActivity.this.mContext));
            TextView textView2 = new TextView(GameTaskDetailActivity.this.mContext);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, 0);
            layoutParams2.weight = 1.0f;
            textView2.setLayoutParams(layoutParams2);
            textView2.setSingleLine(true);
            textView2.setEllipsize(TextUtils.TruncateAt.END);
            textView2.setTextColor(GameTaskDetailActivity.this.mContext.getResources().getColor(R.color.moku_yellow_golden));
            linearLayout2.addView(textView2);
            textView2.setTextSize(GameTaskDetailActivity.this.phoneScreenUtils.getNormalTextSize(GameTaskDetailActivity.this.mContext));
            textView2.setText(clientGameTaskData.getShowMoney() + clientGameTaskData.getCybermoneyName());
            new CustomBuildDialog.DialogBuilder(GameTaskDetailActivity.this.mContext).setTitleImage(Integer.valueOf(R.drawable.moku_tips_icon)).setDetailText("您有一个进行中的任务，是否放弃此任务，开始当前任务？").setCustomView(linearLayout).setCancelable(false).setLeftBtn("返回完成", new CustomBuildDialog.DialogButtonOnClickListener() { // from class: com.fendasz.moku.planet.ui.activity.GameTaskDetailActivity.7.3
                @Override // com.fendasz.moku.planet.ui.dialog.CustomBuildDialog.DialogButtonOnClickListener
                public void onClick(TextView textView3, CustomBuildDialog customBuildDialog) {
                    customBuildDialog.dismiss();
                    if (clientGameTaskData.getCpl() == null || !clientGameTaskData.getCpl().booleanValue()) {
                        Intent intent = new Intent(GameTaskDetailActivity.this, (Class<?>) TaskDetailActivity.class);
                        intent.putExtra("taskDataId", clientGameTaskData.getTaskDataId());
                        intent.putExtra("taskDataUrl", clientGameTaskData.getUrl());
                        String gateType = clientGameTaskData.getGateType();
                        if (!TextUtils.isEmpty(gateType)) {
                            intent.putExtra("gateType", gateType);
                        }
                        intent.putExtra("operationType", 100);
                        GameTaskDetailActivity.this.startActivityForResult(intent, 200);
                        return;
                    }
                    GameTaskDetailActivity.this.mTaskDataId = clientGameTaskData.getTaskDataId().intValue();
                    GameTaskDetailActivity.this.getTaskDetail(true, true, false, null);
                }
            }).setRightBtn(GameTaskDetailActivity.this.mContext.getString(R.string.moku_btn_confirm), new CustomBuildDialog.DialogButtonOnClickListener() { // from class: com.fendasz.moku.planet.ui.activity.GameTaskDetailActivity.7.2
                @Override // com.fendasz.moku.planet.ui.dialog.CustomBuildDialog.DialogButtonOnClickListener
                public void onClick(TextView textView3, CustomBuildDialog customBuildDialog) {
                    customBuildDialog.dismiss();
                    GameTaskDetailActivity.this.cancelTask(clientGameTaskData, new com.fendasz.moku.planet.interf.functions.Consumer<TaskDataApplyRecord>() { // from class: com.fendasz.moku.planet.ui.activity.GameTaskDetailActivity.7.2.1
                        @Override // com.fendasz.moku.planet.interf.functions.Consumer
                        public void accept(TaskDataApplyRecord taskDataApplyRecord) throws Exception {
                            Toast.makeText(GameTaskDetailActivity.this.mContext, "任务(taskDataId:" + taskDataApplyRecord.getTaskDataId() + ")取消成功", 0).show();
                            GameTaskDetailActivity.this.applyTask(true);
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
        ApiDataHelper.getApiDataHelper().getGameTaskDetail(this.mContext, Integer.valueOf(i), new ApiDataCallBack<ClientGameTaskData>() { // from class: com.fendasz.moku.planet.ui.activity.GameTaskDetailActivity.8
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
                LogUtils.log(GameTaskDetailActivity.TAG, "code:" + i2 + " message:" + str);
                if (z) {
                    Toast.makeText(GameTaskDetailActivity.this.mContext, str + i2, 1).show();
                } else if (i2 == 5000 || i2 == 5001) {
                    Toast.makeText(GameTaskDetailActivity.this.mContext, str + i2, 1).show();
                } else {
                    Toast.makeText(GameTaskDetailActivity.this.mContext, "code:" + i2 + " message:" + str, 1).show();
                    GameTaskDetailActivity.this.showErrorDialog(str);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showErrorDialog(String str) {
        new CustomBuildDialog.DialogBuilder(this.mContext).setTitleImage(Integer.valueOf(R.drawable.moku_tips_icon)).setDetailText(str).setRightBtn(getString(R.string.moku_btn_ok), new CustomBuildDialog.DialogButtonOnClickListener() { // from class: com.fendasz.moku.planet.ui.activity.GameTaskDetailActivity$$ExternalSyntheticLambda1
            @Override // com.fendasz.moku.planet.ui.dialog.CustomBuildDialog.DialogButtonOnClickListener
            public final void onClick(TextView textView, CustomBuildDialog customBuildDialog) {
                this.f$0.m407xbace5158(textView, customBuildDialog);
            }
        }).setCancelable(false).create().show();
    }

    /* renamed from: lambda$showErrorDialog$0$com-fendasz-moku-planet-ui-activity-GameTaskDetailActivity, reason: not valid java name */
    /* synthetic */ void m407xbace5158(TextView textView, CustomBuildDialog customBuildDialog) {
        customBuildDialog.dismiss();
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelTask(ClientGameTaskData clientGameTaskData, final com.fendasz.moku.planet.interf.functions.Consumer<TaskDataApplyRecord> consumer) {
        LoadingDialog.show(this.mContext);
        ApiDataHelper.getApiDataHelper().cancelTask(this.mContext, clientGameTaskData, new ApiDataCallBack<TaskDataApplyRecord>() { // from class: com.fendasz.moku.planet.ui.activity.GameTaskDetailActivity.9
            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void success(int i, TaskDataApplyRecord taskDataApplyRecord) throws Exception {
                LoadingDialog.dismiss();
                GameTaskDetailActivity.this.setResult(300);
                com.fendasz.moku.planet.interf.functions.Consumer consumer2 = consumer;
                if (consumer2 != null) {
                    consumer2.accept(taskDataApplyRecord);
                }
            }

            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void error(int i, String str) throws Exception {
                LoadingDialog.dismiss();
                LogUtils.log(GameTaskDetailActivity.TAG, "code:" + i + " message:" + str);
                Toast.makeText(GameTaskDetailActivity.this.mContext, str + i, 1).show();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getTaskDetail(final boolean z, boolean z2, final boolean z3, final Success<ClientGameTaskData> success) {
        getTaskDetailData(this.mTaskDataId, false, new Consumer<ClientGameTaskData>() { // from class: com.fendasz.moku.planet.ui.activity.GameTaskDetailActivity.10
            @Override // io.reactivex.functions.Consumer
            public void accept(ClientGameTaskData clientGameTaskData) throws Exception {
                GameTaskDetailActivity.this.mClientGameTaskData = clientGameTaskData;
                MokuConfigure.getInstance().updateSubmitTaskDataId(GameTaskDetailActivity.this.mContext, GameTaskDetailActivity.this.mClientGameTaskData.getTaskDataId());
                if (GameTaskDetailActivity.this.mClientGameTaskData.getTaskDataApplyRecord() != null && GameTaskDetailActivity.this.mClientGameTaskData.getTaskDataApplyRecord().getStatus().equals(TaskDataApplyRecord.STATUS_OF_APPLYING)) {
                    GameTaskDetailActivity gameTaskDetailActivity = GameTaskDetailActivity.this;
                    gameTaskDetailActivity.mExpirationTime = gameTaskDetailActivity.mClientGameTaskData.getTaskDataApplyRecord().getExpirationTime();
                }
                GameTaskDetailActivity.this.mApiTaskOperationHelper = new ApiTaskOperationHelper.HelperBuilder(GameTaskDetailActivity.this.mClientGameTaskData).setCallBack(GameTaskDetailActivity.this).create();
                if (z) {
                    GameTaskDetailActivity.this.mApiTaskOperationHelper.init(GameTaskDetailActivity.this.mContext);
                } else {
                    GameTaskDetailActivity.this.mApiTaskOperationHelper.onRestart(GameTaskDetailActivity.this.mContext);
                }
                GameTaskDetailActivity.this.onInitComplete(z3);
                Success success2 = success;
                if (success2 != null) {
                    success2.success(0, GameTaskDetailActivity.this.mClientGameTaskData);
                }
                Integer suspendedSwitch = GameTaskDetailActivity.this.mClientGameTaskData.getSuspendedSwitch();
                if (suspendedSwitch == null || suspendedSwitch.intValue() != 1) {
                    return;
                }
                GameTaskDetailActivity gameTaskDetailActivity2 = GameTaskDetailActivity.this;
                if (FloatingUtil.isNeedShowFloatnigDialog(gameTaskDetailActivity2, gameTaskDetailActivity2.mClientGameTaskData)) {
                    FloatingUtil.showFloatingDialog(GameTaskDetailActivity.this);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void applyTask(final boolean z) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, SecurityException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        if (this.loactionState.intValue() == 1 && !PermissionUtils.hasLocationPermissions(this)) {
            queryLocationInfo();
            return;
        }
        LoadingDialog.show(this.mContext);
        if (PermissionUtils.hasLocationPermissions(this)) {
            Log.d(TAG, "getSimCardInfo");
            GetInfoUtil.getSimCardInfo(this, this);
        }
        MokuConfigure.getInstance().updateUserType(this.mContext, 3);
        ApiDataHelper.getApiDataHelper().uploadDeviceInfo(this, new ApiDataCallBack<Object>() { // from class: com.fendasz.moku.planet.ui.activity.GameTaskDetailActivity.11
            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void success(int i, Object obj) throws Exception {
                Log.d(GameTaskDetailActivity.TAG, "upload device info success");
            }

            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void error(int i, String str) throws Exception {
                LogUtils.logE(GameTaskDetailActivity.TAG, "upload device info error,code=>" + i + ",message" + str);
            }
        });
        Log.d(TAG, "start uploadDeviceToken");
        AliyunHelper.getInstance().uploadDeviceToken(this.mContext, new AliyunHelper.SessionCallBack() { // from class: com.fendasz.moku.planet.ui.activity.GameTaskDetailActivity.12
            @Override // com.fendasz.moku.planet.helper.AliyunHelper.SessionCallBack
            public void onSession(Integer num, String str, String str2) {
                Log.d(GameTaskDetailActivity.TAG, "uploadDeviceToken onSession,code:" + num + ",message:" + str);
                if (7700 == num.intValue()) {
                    GameTaskDetailActivity.this.showToast(str);
                }
            }
        });
        Integer numCheckIsCanStartTask = this.mApiTaskOperationHelper.checkIsCanStartTask(this.mContext);
        if (numCheckIsCanStartTask.equals(MokuConstants.CHECK_CAN_START_TASK)) {
            ApiDataHelper.getApiDataHelper().applyTask(this.mContext, this.mClientGameTaskData.getTaskDataId(), new ApiDataCallBack<TaskDataApplyRecord>() { // from class: com.fendasz.moku.planet.ui.activity.GameTaskDetailActivity.13
                @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
                public void success(int i, TaskDataApplyRecord taskDataApplyRecord) throws Exception {
                    LoadingDialog.dismiss();
                    Toast.makeText(GameTaskDetailActivity.this.mContext, "任务开始了，按任务要求完成吧~", 0).show();
                    GameTaskDetailActivity.this.mClientGameTaskData.setTaskDataApplyRecord(taskDataApplyRecord);
                    GameTaskDetailActivity.this.mExpirationTime = taskDataApplyRecord.getExpirationTime();
                    GameTaskDetailActivity.this.startCountDown();
                    GameTaskDetailActivity.this.setResult(300);
                    GameTaskDetailActivity.this.mApiTaskOperationHelper.init(GameTaskDetailActivity.this.mContext);
                    if (z) {
                        GameTaskDetailActivity.this.executeTask();
                    }
                    GameTaskDetailActivity.this.onInitStatusComplete();
                    if (1 == taskDataApplyRecord.getLocationStatus().intValue()) {
                        GameTaskDetailActivity.this.queryLocationInfo();
                    }
                    Integer checkTheState = taskDataApplyRecord.getCheckTheState();
                    LogUtils.logD(GameTaskDetailActivity.TAG, "checkTheState=>" + checkTheState);
                    if (checkTheState == null || 1 != checkTheState.intValue()) {
                        return;
                    }
                    GameTaskDetailActivity.this.uplodatePackage();
                }

                @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
                public void error(int i, String str) throws Exception {
                    LoadingDialog.dismiss();
                    LogUtils.log(GameTaskDetailActivity.TAG, "code:" + i + " message:" + str);
                    if (i == 5007) {
                        GameTaskDetailActivity.this.showErrorDialog(str);
                    } else if ("系统异常".equals(str)) {
                        Toast.makeText(GameTaskDetailActivity.this.mContext, "申请失败，设备/账号已申请该任务" + i, 1).show();
                    } else {
                        Toast.makeText(GameTaskDetailActivity.this.mContext, str + i, 1).show();
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
                dialogBuilder.setLeftBtn(this.mContext.getString(R.string.moku_btn_no), new CustomBuildDialog.DialogButtonOnClickListener() { // from class: com.fendasz.moku.planet.ui.activity.GameTaskDetailActivity.15
                    @Override // com.fendasz.moku.planet.ui.dialog.CustomBuildDialog.DialogButtonOnClickListener
                    public void onClick(TextView textView, CustomBuildDialog customBuildDialog) {
                        customBuildDialog.dismiss();
                    }
                }).setRightBtn(this.mContext.getString(R.string.moku_uninstall), new CustomBuildDialog.DialogButtonOnClickListener() { // from class: com.fendasz.moku.planet.ui.activity.GameTaskDetailActivity.14
                    @Override // com.fendasz.moku.planet.ui.dialog.CustomBuildDialog.DialogButtonOnClickListener
                    public void onClick(TextView textView, CustomBuildDialog customBuildDialog) {
                        customBuildDialog.dismiss();
                        SystemUtils.uninstallApp(GameTaskDetailActivity.this.mContext, GameTaskDetailActivity.this.mClientGameTaskData.getPackageName());
                    }
                });
            } else {
                dialogBuilder.setRightBtn(this.mContext.getString(R.string.moku_btn_ok), new CustomBuildDialog.DialogButtonOnClickListener() { // from class: com.fendasz.moku.planet.ui.activity.GameTaskDetailActivity.16
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
            scheduledThreadPoolExecutor.scheduleAtFixedRate(new Runnable() { // from class: com.fendasz.moku.planet.ui.activity.GameTaskDetailActivity.17
                @Override // java.lang.Runnable
                public void run() {
                    ((Activity) GameTaskDetailActivity.this.mContext).runOnUiThread(new Runnable() { // from class: com.fendasz.moku.planet.ui.activity.GameTaskDetailActivity.17.1
                        @Override // java.lang.Runnable
                        public void run() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                            TaskDataApplyRecord taskDataApplyRecord;
                            if (GameTaskDetailActivity.this.currentTime != null) {
                                GameTaskDetailActivity.this.currentTime = Long.valueOf(GameTaskDetailActivity.this.currentTime.longValue() + 1000);
                                if (GameTaskDetailActivity.this.mExpirationTime != null) {
                                    if (DateUtils.getDate(GameTaskDetailActivity.this.mExpirationTime, "yyyy-MM-dd HH:mm:ss").getTime() - GameTaskDetailActivity.this.currentTime.longValue() > 0) {
                                        GameTaskDetailActivity.this.showUiTips(3);
                                        return;
                                    }
                                    LogUtils.log(GameTaskDetailActivity.TAG, "任务已超时");
                                    if (GameTaskDetailActivity.this.mClientGameTaskData != null && (taskDataApplyRecord = GameTaskDetailActivity.this.mClientGameTaskData.getTaskDataApplyRecord()) != null) {
                                        taskDataApplyRecord.setStatus(MokuConstants.STATUS_OF_OVERTIME);
                                    }
                                    GameTaskDetailActivity.this.mApiTaskOperationHelper.init(GameTaskDetailActivity.this.mContext);
                                    GameTaskDetailActivity.this.showUiTips(3);
                                    GameTaskDetailActivity.this.initCountDown();
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
            showGalleryTipDialog(new Finish() { // from class: com.fendasz.moku.planet.ui.activity.GameTaskDetailActivity.18
                @Override // com.fendasz.moku.planet.interf.Finish
                public void finish() {
                    if (GameTaskDetailActivity.this.mApiTaskOperationHelper != null) {
                        GameTaskDetailActivity.this.mApiTaskOperationHelper.executeTask(GameTaskDetailActivity.this.mContext);
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
        dialogBuilder.setCustomView(imageView).setRightBtn(this.mContext.getString(R.string.moku_dialog_btn_text__i_know), new CustomBuildDialog.DialogButtonOnClickListener() { // from class: com.fendasz.moku.planet.ui.activity.GameTaskDetailActivity.19
            @Override // com.fendasz.moku.planet.ui.dialog.CustomBuildDialog.DialogButtonOnClickListener
            public void onClick(TextView textView, CustomBuildDialog customBuildDialog) {
                customBuildDialog.dismiss();
                SharedPreferencesUtils.getInstance(GameTaskDetailActivity.this.mContext).putBoolean(GameTaskDetailActivity.this.mContext.getString(R.string.moku_sp_is_show_dialog_gallery_tip), false);
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
                            long openAppLong = this.mApiTaskOperationHelper.getOpenAppLong(this.mContext, this.mClientGameTaskData.getPackageName(), false);
                            if (getCplTaskLogFlag(this.mContext, this.mClientGameTaskData.getTaskDataId().intValue(), this.mClientGameTaskData.getPackageName(), this.mClientGameTaskData.getApkApplicationId()) == 0 && openAppLong > 0) {
                                recordCplTaskLogFlag(this.mContext, this.mClientGameTaskData.getTaskDataId().intValue(), this.mClientGameTaskData.getPackageName(), this.mClientGameTaskData.getApkApplicationId());
                                this.mApiTaskOperationHelper.cplLog(this.mContext, this.mClientGameTaskData.getPackageName(), false);
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
                    new CustomBuildDialog.DialogBuilder(this.mContext).setTitleImage(Integer.valueOf(R.drawable.moku_tips_icon)).setDetailText("您的任务已经超时啦~\n需要帮您重新开始么").setCancelable(false).setLeftBtn("不了", new CustomBuildDialog.DialogButtonOnClickListener() { // from class: com.fendasz.moku.planet.ui.activity.GameTaskDetailActivity.21
                        @Override // com.fendasz.moku.planet.ui.dialog.CustomBuildDialog.DialogButtonOnClickListener
                        public void onClick(TextView textView, CustomBuildDialog customBuildDialog2) {
                            customBuildDialog2.dismiss();
                            GameTaskDetailActivity gameTaskDetailActivity = GameTaskDetailActivity.this;
                            gameTaskDetailActivity.cancelTask(gameTaskDetailActivity.mClientGameTaskData, new com.fendasz.moku.planet.interf.functions.Consumer<TaskDataApplyRecord>() { // from class: com.fendasz.moku.planet.ui.activity.GameTaskDetailActivity.21.1
                                @Override // com.fendasz.moku.planet.interf.functions.Consumer
                                public void accept(TaskDataApplyRecord taskDataApplyRecord) throws Exception {
                                    GameTaskDetailActivity.this.cancelTaskCallBack(taskDataApplyRecord);
                                }
                            });
                        }
                    }).setRightBtn("重新开始", new CustomBuildDialog.DialogButtonOnClickListener() { // from class: com.fendasz.moku.planet.ui.activity.GameTaskDetailActivity.20
                        @Override // com.fendasz.moku.planet.ui.dialog.CustomBuildDialog.DialogButtonOnClickListener
                        public void onClick(TextView textView, CustomBuildDialog customBuildDialog2) {
                            customBuildDialog2.dismiss();
                            GameTaskDetailActivity.this.getTaskDataStatus(false);
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

    /* renamed from: com.fendasz.moku.planet.ui.activity.GameTaskDetailActivity$29, reason: invalid class name */
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
            CustomBuildDialog customBuildDialogCreate = titleImage.setRightBtn("继续试玩", new CustomBuildDialog.DialogButtonOnClickListener() { // from class: com.fendasz.moku.planet.ui.activity.GameTaskDetailActivity$$ExternalSyntheticLambda0
                @Override // com.fendasz.moku.planet.ui.dialog.CustomBuildDialog.DialogButtonOnClickListener
                public final void onClick(TextView textView, CustomBuildDialog customBuildDialog2) {
                    this.f$0.m408xc5f6773f(textView, customBuildDialog2);
                }
            }).setCancelable(true).create();
            this.mGoOnTaskDialog = customBuildDialogCreate;
            customBuildDialogCreate.show();
        }
    }

    /* renamed from: lambda$showGoOnTaskDialog$1$com-fendasz-moku-planet-ui-activity-GameTaskDetailActivity, reason: not valid java name */
    /* synthetic */ void m408xc5f6773f(TextView textView, CustomBuildDialog customBuildDialog) {
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
        ApiDataHelper.getApiDataHelper().uploadDeviceInfo(this, new ApiDataCallBack<Object>() { // from class: com.fendasz.moku.planet.ui.activity.GameTaskDetailActivity.22
            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void success(int i, Object obj) throws Exception {
                Log.d(GameTaskDetailActivity.TAG, "device info success");
            }

            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void error(int i, String str) throws Exception {
                LogUtils.logE(GameTaskDetailActivity.TAG, "device info error,code=>" + i + ",message" + str);
            }
        });
        ApiDataHelper.getApiDataHelper().submitTask(this.mContext, this.mClientGameTaskData, (List<File>) null, (List<ClientTaskDataSubmitFormModel>) null, this.mAdditionalData, new AnonymousClass23());
    }

    /* renamed from: com.fendasz.moku.planet.ui.activity.GameTaskDetailActivity$23, reason: invalid class name */
    class AnonymousClass23 implements ApiDataCallBack<String> {
        AnonymousClass23() {
        }

        @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
        public void success(int i, String str) throws Exception {
            LoadingDialog.dismiss();
            LogUtils.log(GameTaskDetailActivity.TAG, "submit task success");
            GameTaskDetailActivity.this.setResult(300);
            new CustomBuildDialog.DialogBuilder(GameTaskDetailActivity.this.mContext).setTitleImage(Integer.valueOf(R.drawable.moku_task_finished)).setTitleText("提交成功").setDetailText("预计<font color=\"#ff0000\">" + str + "</font>前审核完成").setRightBtn(GameTaskDetailActivity.this.getString(R.string.moku_btn_continue), new CustomBuildDialog.DialogButtonOnClickListener() { // from class: com.fendasz.moku.planet.ui.activity.GameTaskDetailActivity$23$$ExternalSyntheticLambda0
                @Override // com.fendasz.moku.planet.ui.dialog.CustomBuildDialog.DialogButtonOnClickListener
                public final void onClick(TextView textView, CustomBuildDialog customBuildDialog) {
                    this.f$0.m409xabfc1ddd(textView, customBuildDialog);
                }
            }).setCancelable(false).create().show();
            GameTaskDetailActivity.this.sendTaskSubmitBroadcast();
        }

        /* renamed from: lambda$success$0$com-fendasz-moku-planet-ui-activity-GameTaskDetailActivity$23, reason: not valid java name */
        /* synthetic */ void m409xabfc1ddd(TextView textView, CustomBuildDialog customBuildDialog) {
            customBuildDialog.dismiss();
            GameTaskDetailActivity.this.putSpIsShowGuideMyParticipateInTip();
            GameTaskDetailActivity.this.removeSuspendLayout();
            GameTaskDetailActivity.this.finish();
        }

        @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
        public void error(int i, String str) throws Exception {
            LoadingDialog.dismiss();
            LogUtils.log(GameTaskDetailActivity.TAG, "code:" + i + " message:" + str);
            Toast.makeText(GameTaskDetailActivity.this.mContext, str + i, 1).show();
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
        getTaskDetail(false, false, false, new Success<ClientGameTaskData>() { // from class: com.fendasz.moku.planet.ui.activity.GameTaskDetailActivity.24
            @Override // com.fendasz.moku.planet.interf.Success
            public void success(Integer num, ClientGameTaskData clientGameTaskData) {
                LoadingDialog.dismiss();
                GameTaskDetailActivity.this.loactionState = clientGameTaskData.getLocationStatus();
                GameTaskDetailActivity.this.runOnUiThread(new Runnable() { // from class: com.fendasz.moku.planet.ui.activity.GameTaskDetailActivity.24.1
                    @Override // java.lang.Runnable
                    public void run() {
                        GameTaskDetailActivity.this.webView.reload();
                    }
                });
            }
        });
    }

    private int getCplTaskLogFlag(Context context, int i, String str, String str2) {
        return SharedPreferencesUtils.getInstance(context).getInt(i + str + str2, 0);
    }

    private void recordCplTaskLogFlag(Context context, int i, String str, String str2) {
        SharedPreferencesUtils.getInstance(context).putInt(i + str + str2, 1);
    }

    private void initMokuJsLisetener() {
        this.mokuJsListener = new MokuJsObjectListenerImpl(this) { // from class: com.fendasz.moku.planet.ui.activity.GameTaskDetailActivity.25
            @Override // com.fendasz.moku.planet.common.MokuJsObjectListenerImpl, com.fendasz.moku.planet.common.MokuJsObject.OnMokuJsListener
            public void showScreenImage(String str) {
            }

            @Override // com.fendasz.moku.planet.common.MokuJsObjectListenerImpl, com.fendasz.moku.planet.common.MokuJsObject.OnMokuJsListener
            public void refreshData() {
                if (GameTaskDetailActivity.this.refreClickTime == 0) {
                    GameTaskDetailActivity.this.refreshTaskDetail();
                    GameTaskDetailActivity.this.refreClickTime = System.currentTimeMillis();
                } else {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    if (jCurrentTimeMillis - GameTaskDetailActivity.this.refreClickTime > b.a) {
                        GameTaskDetailActivity.this.refreClickTime = jCurrentTimeMillis;
                        GameTaskDetailActivity.this.refreshTaskDetail();
                    }
                }
            }

            @Override // com.fendasz.moku.planet.common.MokuJsObjectListenerImpl
            public String taskDataId() {
                return String.valueOf(GameTaskDetailActivity.this.mTaskDataId);
            }

            @Override // com.fendasz.moku.planet.common.MokuJsObjectListenerImpl
            public void toCustomerService() {
                super.toCustomerService();
                GameTaskDetailActivity.this.startActivityForResult(new Intent(GameTaskDetailActivity.this, (Class<?>) MokuCustomerServiceActivity.class), 400);
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
            this.suspendLayout = FloatingUtil.getInstance().addBaseView((Activity) this.mContext, this.mClientGameTaskData, new FloatingUtil.OnFloatingListener() { // from class: com.fendasz.moku.planet.ui.activity.GameTaskDetailActivity.26
                @Override // com.fendasz.moku.planet.utils.FloatingUtil.OnFloatingListener
                public void onFloating() {
                    if (Build.VERSION.SDK_INT < 29) {
                        FloatingUtil.getInstance().moveAppToFront(GameTaskDetailActivity.this.getApplication());
                    } else {
                        GameTaskDetailActivity.this.startActivity(new Intent(GameTaskDetailActivity.this, (Class<?>) GameTaskDetailActivity.class));
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
        ApiDataHelper.getApiDataHelper().cpaLog(this.mContext, GlobalSetting.UNIFIED_INTERSTITIAL_HS_AD, this.mClientGameTaskData.getTaskDataId(), new ApiDataCallBack<Object>() { // from class: com.fendasz.moku.planet.ui.activity.GameTaskDetailActivity.27
            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void success(int i, Object obj) throws Exception {
                Log.d(GameTaskDetailActivity.TAG, "cpaLog success");
                GameTaskDetailActivity.this.cplLogResult = 1;
            }

            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void error(int i, String str) throws Exception {
                Log.d(GameTaskDetailActivity.TAG, "cpaLog error,message:" + str);
                GameTaskDetailActivity.this.cplLogResult = 0;
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
        ApiDataHelper.getApiDataHelper().postPackages(this.mContext, new ApiDataCallBack<String>() { // from class: com.fendasz.moku.planet.ui.activity.GameTaskDetailActivity.28
            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void success(int i, String str) throws Exception {
                LogUtils.logD(GameTaskDetailActivity.TAG, "upload postPackages success");
            }

            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void error(int i, String str) throws Exception {
                LogUtils.logE(GameTaskDetailActivity.TAG, "upload postPackages error,message=>" + str);
            }
        });
    }
}
