package com.fendasz.moku.planet.ui.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.webkit.ValueCallback;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.alibaba.fastjson.JSON;
import com.alipay.sdk.m.u.i;
import com.fendasz.moku.planet.R;
import com.fendasz.moku.planet.common.MokuJsObject;
import com.fendasz.moku.planet.common.MokuJsObjectListenerImpl;
import com.fendasz.moku.planet.constants.MokuConstants;
import com.fendasz.moku.planet.entity.ApiDataCallBack;
import com.fendasz.moku.planet.entity.ApiOperationCallBack;
import com.fendasz.moku.planet.entity.H5SubmitTaskData;
import com.fendasz.moku.planet.entity.OperationEnum;
import com.fendasz.moku.planet.helper.AliyunHelper;
import com.fendasz.moku.planet.helper.ApiDataHelper;
import com.fendasz.moku.planet.helper.ApiTaskOperationHelper;
import com.fendasz.moku.planet.helper.MokuConfigure;
import com.fendasz.moku.planet.interf.Finish;
import com.fendasz.moku.planet.interf.Success;
import com.fendasz.moku.planet.source.bean.ClientDetailTaskData;
import com.fendasz.moku.planet.source.bean.ClientTaskDataSubmitFormModel;
import com.fendasz.moku.planet.source.bean.CpaData;
import com.fendasz.moku.planet.source.bean.TaskDataApplyRecord;
import com.fendasz.moku.planet.source.bean.taskdatagroup.ClientGroupTaskData;
import com.fendasz.moku.planet.ui.base.activity.BaseBackActivity;
import com.fendasz.moku.planet.ui.customview.MokuIconTextView;
import com.fendasz.moku.planet.ui.dialog.CustomBuildDialog;
import com.fendasz.moku.planet.ui.dialog.GuideDialog;
import com.fendasz.moku.planet.ui.dialog.LoadingDialog;
import com.fendasz.moku.planet.ui.dialog.ViewImageDialog;
import com.fendasz.moku.planet.utils.DateUtils;
import com.fendasz.moku.planet.utils.FileUtils;
import com.fendasz.moku.planet.utils.FloatingUtil;
import com.fendasz.moku.planet.utils.GetInfoUtil;
import com.fendasz.moku.planet.utils.ImageUtils;
import com.fendasz.moku.planet.utils.LogUtils;
import com.fendasz.moku.planet.utils.MokuUtils;
import com.fendasz.moku.planet.utils.PermissionUtils;
import com.fendasz.moku.planet.utils.PhoneScreenUtils;
import com.fendasz.moku.planet.utils.QrCodeUtils;
import com.fendasz.moku.planet.utils.ScreenAdaptationUtils;
import com.fendasz.moku.planet.utils.SharedPreferencesUtils;
import com.fendasz.moku.planet.utils.StorageUtils;
import com.fendasz.moku.planet.utils.StringUtils;
import com.fendasz.moku.planet.utils.ViewUtil;
import com.fendasz.moku.planet.utils.WeChatUtils;
import com.fendasz.moku.planet.utils.canvas.CanvasUtils;
import com.fendasz.moku.planet.utils.system.utils.SystemUtils;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.config.SelectMimeType;
import com.pandora.common.utils.Times;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class RewardTaskDetailActivity extends BaseBackActivity implements ApiOperationCallBack {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int CODE_COUNT_DOWN = 3;
    private static final int CODE_START_TASK = 0;
    private static final int CODE_SUBMIT_ANSWER = 5;
    private static final int CODE_TASK_STATUS = 4;
    private static final int CODE_UPLOAD_SCREENSHOT = 1;
    private static final int CODE_VIEW_INIT = 2;
    private static final String DATA_DETAILURL_DEBUG = MokuConstants.H5Url.H5_REWARD_DEBUG.getUrl();
    private static final String DATA_DETAILURL_RELEASE = MokuConstants.H5Url.H5_REWARD_RELEASE.getUrl();
    public static final int REQUEST_CODE_COMPLAINT = 50;
    public static final int REQUEST_CODE_TASKRESET = 51;
    public static final int RESULT_CODE_FOR_FINISH = 2;
    public static final int RESULT_CODE_FOR_REFRESH_TASK_LIST = 300;
    private static final String TAG = "M_Reward==>";
    private LinearLayout bottomLayout;
    private Bitmap currentBitmap;
    private String currentUrl;
    private List<EditText> etFormList;
    private List<ClientTaskDataSubmitFormModel> formDatas;
    private boolean isTaskGroup;
    private List<ImageView> ivUploadImageList;
    private MokuJsObjectListenerImpl jsObjectListener;
    private Integer locationStatus;
    private String mAdditionalData;
    private String mAnswer;
    private ApiTaskOperationHelper mApiTaskOperationHelper;
    private Button mBtnStartTask;
    private Button mBtnSubmit;
    ClientDetailTaskData mClientDetailTaskData;
    private LinearLayout mContentView;
    private Context mContext;
    private EditText mEtInput;
    private String mExpirationTime;
    private String mGateType;
    private CustomBuildDialog mGoOnTaskDialog;
    private GuideDialog mGuideDialog;
    private LinearLayout mLlBrowser;
    private LinearLayout mLlOnTask;
    private LinearLayout mLlOptions;
    private LinearLayout mLlWeChat;
    private int mNumberOfAttempts;
    private ProgressBar mPbDownload;
    private PhoneScreenUtils mPhoneScreenUtils;
    private RelativeLayout mRlDownload;
    private RelativeLayout mRlOptionsContainer;
    private int mTaskDataId;
    private Integer mTime;
    private TextView mTvAnswerError;
    private TextView mTvAnswerErrorTip;
    private TextView mTvAnswerTips;
    private TextView mTvBtnCommentCopy;
    private TextView mTvCancelTask;
    private TextView mTvCommentContent;
    private TextView mTvDownload;
    private TextView mTvFlow;
    private TextView mTvSearchTerms;
    private List<LinearLayout> mllAnswerList;
    private LinearLayout mllSearchTerms;
    private int operationType;
    private ImageView rightImageView;
    private LinearLayout suspendLayout;
    private TreeMap<Integer, File> updateFileMap;
    private WebView webView;
    private ScheduledExecutorService scheduled = null;
    private Long currentTime = null;
    private boolean isStartSubmitCpaNormalTask = false;
    private long clickTime = 0;
    private long refreClickTime = 0;
    private boolean isAddsuspendLayout = false;

    @Override // com.fendasz.moku.planet.ui.base.activity.BaseActivity
    public boolean needLightSensor() {
        return true;
    }

    static /* synthetic */ int access$3708(RewardTaskDetailActivity rewardTaskDetailActivity) {
        int i = rewardTaskDetailActivity.mNumberOfAttempts;
        rewardTaskDetailActivity.mNumberOfAttempts = i + 1;
        return i;
    }

    @Override // com.fendasz.moku.planet.ui.base.activity.BaseBackActivity, com.fendasz.moku.planet.ui.base.activity.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.fendasz.moku.planet.ui.base.activity.BaseActivity
    public View initContentView(ViewGroup viewGroup) {
        this.mPhoneScreenUtils = PhoneScreenUtils.getInstance();
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.moku_task_reward_detail, (ViewGroup) null);
        this.mContentView = linearLayout;
        return linearLayout;
    }

    @Override // com.fendasz.moku.planet.ui.base.activity.BaseActivity
    public void initTitle(TextView textView) {
        if (textView != null) {
            textView.setText("任务详情");
            textView.getPaint().setTextSize(CanvasUtils.getTextSize(this.phoneScreenUtils.getScale(this.mContext, 70.0f)));
        }
    }

    @Override // com.fendasz.moku.planet.ui.base.activity.BaseActivity
    public void initRightView(MokuIconTextView mokuIconTextView, ImageView imageView) {
        super.initRightView(mokuIconTextView, imageView);
        this.rightImageView = imageView;
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        int iDp2px = ViewUtil.dp2px(30);
        if (layoutParams != null) {
            layoutParams.width = iDp2px;
            layoutParams.height = iDp2px;
        } else {
            layoutParams = new ViewGroup.LayoutParams(iDp2px, iDp2px);
        }
        this.rightImageView.setLayoutParams(layoutParams);
        this.rightImageView.setVisibility(0);
        this.rightImageView.setImageResource(R.drawable.moku_menu_more);
        this.rightImageView.setOnClickListener(new View.OnClickListener() { // from class: com.fendasz.moku.planet.ui.activity.RewardTaskDetailActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent(RewardTaskDetailActivity.this, (Class<?>) ComplaintActivity.class);
                intent.putExtra("taskDataId", RewardTaskDetailActivity.this.mClientDetailTaskData.getTaskDataId());
                RewardTaskDetailActivity.this.startActivityForResult(intent, 50);
            }
        });
    }

    @Override // com.fendasz.moku.planet.ui.base.activity.BaseBackActivity, com.fendasz.moku.planet.ui.base.activity.BaseActivity
    public void initLeftView(TextView textView) {
        super.initLeftView(textView);
        textView.setVisibility(0);
        textView.setOnClickListener(new AnonymousClass2());
    }

    /* renamed from: com.fendasz.moku.planet.ui.activity.RewardTaskDetailActivity$2, reason: invalid class name */
    class AnonymousClass2 implements View.OnClickListener {
        AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (Build.VERSION.SDK_INT >= 19) {
                RewardTaskDetailActivity.this.webView.evaluateJavascript("javascript:htmlHistoryBcak()", new ValueCallback() { // from class: com.fendasz.moku.planet.ui.activity.RewardTaskDetailActivity$2$$ExternalSyntheticLambda0
                    @Override // android.webkit.ValueCallback
                    public final void onReceiveValue(Object obj) {
                        this.f$0.m422xaf1296d((String) obj);
                    }
                });
            } else {
                RewardTaskDetailActivity.this.finish();
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:9:0x0014 A[Catch: all -> 0x0016, DONT_GENERATE, TryCatch #1 {, blocks: (B:4:0x0003, B:6:0x0009, B:9:0x0014, B:8:0x000f), top: B:14:0x0003, inners: #0 }] */
        /* renamed from: lambda$onClick$0$com-fendasz-moku-planet-ui-activity-RewardTaskDetailActivity$2, reason: not valid java name */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        /* synthetic */ void m422xaf1296d(java.lang.String r1) {
            /*
                r0 = this;
                monitor-enter(r0)
                if (r1 == 0) goto L14
                boolean r1 = java.lang.Boolean.parseBoolean(r1)     // Catch: java.lang.Exception -> Lf java.lang.Throwable -> L16
                if (r1 == 0) goto L14
                com.fendasz.moku.planet.ui.activity.RewardTaskDetailActivity r1 = com.fendasz.moku.planet.ui.activity.RewardTaskDetailActivity.this     // Catch: java.lang.Exception -> Lf java.lang.Throwable -> L16
                r1.finish()     // Catch: java.lang.Exception -> Lf java.lang.Throwable -> L16
                goto L14
            Lf:
                com.fendasz.moku.planet.ui.activity.RewardTaskDetailActivity r1 = com.fendasz.moku.planet.ui.activity.RewardTaskDetailActivity.this     // Catch: java.lang.Throwable -> L16
                r1.finish()     // Catch: java.lang.Throwable -> L16
            L14:
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L16
                return
            L16:
                r1 = move-exception
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L16
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fendasz.moku.planet.ui.activity.RewardTaskDetailActivity.AnonymousClass2.m422xaf1296d(java.lang.String):void");
        }
    }

    @Override // com.fendasz.moku.planet.ui.base.activity.BaseActivity
    protected void onLoad() {
        initLoad();
        initView();
        initLlOptionsView();
        initStaticViewListener();
        onReady();
    }

    private void onReady() {
        if (SharedPreferencesUtils.getInstance(this.mContext).getBoolean(getString(R.string.moku_sp_is_open_first_at_rewardtask), true)) {
            showOpenFirstGuide();
        } else {
            getTaskDetail(false, false, false, new Success<ClientDetailTaskData>() { // from class: com.fendasz.moku.planet.ui.activity.RewardTaskDetailActivity.3
                @Override // com.fendasz.moku.planet.interf.Success
                public void success(Integer num, ClientDetailTaskData clientDetailTaskData) {
                    if (TextUtils.isEmpty(RewardTaskDetailActivity.this.mGateType) || clientDetailTaskData == null) {
                        return;
                    }
                    LogUtils.log(RewardTaskDetailActivity.TAG, "postGateType " + RewardTaskDetailActivity.this.mGateType);
                    ApiDataHelper.getApiDataHelper().postGateType(RewardTaskDetailActivity.this.mContext, RewardTaskDetailActivity.this.mGateType, clientDetailTaskData.getTaskDataId(), new ApiDataCallBack<Object>() { // from class: com.fendasz.moku.planet.ui.activity.RewardTaskDetailActivity.3.1
                        @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
                        public void success(int i, Object obj) throws Exception {
                            LogUtils.log(RewardTaskDetailActivity.TAG, "postGateType success");
                        }

                        @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
                        public void error(int i, String str) throws Exception {
                            LogUtils.log(RewardTaskDetailActivity.TAG, "postGateType error >> " + str);
                        }
                    });
                }
            });
        }
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
            this.operationType = intent.getIntExtra("operationType", 100);
        } else {
            this.mTaskDataId = bundle.getInt("taskDataId", -1);
            this.mGateType = bundle.getString("gateType");
            this.mAdditionalData = bundle.getString("additionalData");
            this.operationType = bundle.getInt("operationType", 100);
        }
        Log.d(TAG, "operationType==>" + this.operationType);
        String str = this.mAdditionalData;
        if (str == null || StringUtils.isEmpty(str)) {
            this.mAdditionalData = MokuConfigure.getInstance().getMokuOptions(this.mContext).getString("additionalData", null);
        }
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("taskDataId", this.mTaskDataId);
        bundle.putString("gateType", this.mGateType);
    }

    @Override // com.fendasz.moku.planet.ui.base.activity.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (this.suspendLayout == null || !this.isAddsuspendLayout) {
            return;
        }
        ((WindowManager) getSystemService("window")).removeView(this.suspendLayout);
        this.isAddsuspendLayout = false;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
        if (this.suspendLayout == null || !this.isAddsuspendLayout) {
            return;
        }
        ((WindowManager) getSystemService("window")).removeView(this.suspendLayout);
        this.isAddsuspendLayout = false;
    }

    @Override // com.fendasz.moku.planet.ui.base.activity.BaseActivity
    public void initView() {
        this.bottomLayout = (LinearLayout) this.mContentView.findViewById(R.id.ll_bottom);
        this.mBtnStartTask = (Button) this.mContentView.findViewById(R.id.btn_start_task);
        this.mLlOnTask = (LinearLayout) this.mContentView.findViewById(R.id.ll_on_task);
        this.mRlDownload = (RelativeLayout) this.mContentView.findViewById(R.id.rl_download);
        this.mTvDownload = (TextView) this.mContentView.findViewById(R.id.tv_download);
        this.mPbDownload = (ProgressBar) this.mContentView.findViewById(R.id.pb_download);
        this.mTvCancelTask = (TextView) this.mContentView.findViewById(R.id.tv_cancel_task);
        if (101 == this.operationType) {
            this.bottomLayout.setVisibility(8);
        }
        initWebView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh(boolean z, boolean z2) {
        this.updateFileMap.clear();
        this.ivUploadImageList.clear();
        this.mllAnswerList.clear();
        this.etFormList.clear();
        this.formDatas.clear();
        this.isStartSubmitCpaNormalTask = false;
        getTaskDetail(true, z, z2, null);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getTaskDetail(final boolean z, boolean z2, final boolean z3, final Success<ClientDetailTaskData> success) {
        getTaskDetailData(this.mTaskDataId, false, new Consumer<ClientDetailTaskData>() { // from class: com.fendasz.moku.planet.ui.activity.RewardTaskDetailActivity.4
            @Override // io.reactivex.functions.Consumer
            public void accept(ClientDetailTaskData clientDetailTaskData) throws Exception {
                RewardTaskDetailActivity.this.mClientDetailTaskData = clientDetailTaskData;
                MokuConfigure.getInstance().updateSubmitTaskDataId(RewardTaskDetailActivity.this.mContext, RewardTaskDetailActivity.this.mClientDetailTaskData.getTaskDataId());
                RewardTaskDetailActivity rewardTaskDetailActivity = RewardTaskDetailActivity.this;
                rewardTaskDetailActivity.isTaskGroup = rewardTaskDetailActivity.mClientDetailTaskData.getClientGroupTaskDataList() != null && RewardTaskDetailActivity.this.mClientDetailTaskData.getClientGroupTaskDataList().size() > 0;
                if (RewardTaskDetailActivity.this.mClientDetailTaskData.getTaskDataApplyRecord() != null && RewardTaskDetailActivity.this.mClientDetailTaskData.getTaskDataApplyRecord().getStatus().equals(TaskDataApplyRecord.STATUS_OF_APPLYING)) {
                    RewardTaskDetailActivity rewardTaskDetailActivity2 = RewardTaskDetailActivity.this;
                    rewardTaskDetailActivity2.mExpirationTime = rewardTaskDetailActivity2.mClientDetailTaskData.getTaskDataApplyRecord().getExpirationTime();
                }
                RewardTaskDetailActivity.this.initDynamicViewListener();
                RewardTaskDetailActivity.this.mApiTaskOperationHelper = new ApiTaskOperationHelper.HelperBuilder(RewardTaskDetailActivity.this.mClientDetailTaskData).setCallBack(RewardTaskDetailActivity.this).create();
                if (z) {
                    RewardTaskDetailActivity.this.mApiTaskOperationHelper.init(RewardTaskDetailActivity.this.mContext);
                } else {
                    RewardTaskDetailActivity.this.mApiTaskOperationHelper.onRestart(RewardTaskDetailActivity.this.mContext);
                }
                RewardTaskDetailActivity.this.onInitComplete(z3);
                Success success2 = success;
                if (success2 != null) {
                    success2.success(0, RewardTaskDetailActivity.this.mClientDetailTaskData);
                }
                Integer suspendedSwitch = RewardTaskDetailActivity.this.mClientDetailTaskData.getSuspendedSwitch();
                if (suspendedSwitch != null && suspendedSwitch.intValue() == 1) {
                    RewardTaskDetailActivity rewardTaskDetailActivity3 = RewardTaskDetailActivity.this;
                    boolean zIsNeedShowFloatnigDialog = FloatingUtil.isNeedShowFloatnigDialog(rewardTaskDetailActivity3, rewardTaskDetailActivity3.mClientDetailTaskData);
                    Log.d(RewardTaskDetailActivity.TAG, "is show floating dialog=>" + zIsNeedShowFloatnigDialog);
                    if (zIsNeedShowFloatnigDialog) {
                        FloatingUtil.showFloatingDialog(RewardTaskDetailActivity.this);
                    }
                }
                RewardTaskDetailActivity.this.locationStatus = clientDetailTaskData.getLocationStatus();
                LogUtils.logD(RewardTaskDetailActivity.TAG, "get task detail,locationStatus=>" + RewardTaskDetailActivity.this.locationStatus);
                if (RewardTaskDetailActivity.this.locationStatus == null || RewardTaskDetailActivity.this.locationStatus.intValue() != 1) {
                    return;
                }
                RewardTaskDetailActivity.this.queryLocationInfo();
            }
        });
    }

    private void getTaskDetailData(int i, final boolean z, final Consumer<ClientDetailTaskData> consumer) {
        LoadingDialog.show(this.mContext);
        int i2 = this.operationType == 101 ? 1 : 0;
        Log.d(TAG, "getTaskDetailData queryType==>" + i2);
        ApiDataHelper.getApiDataHelper().getTaskDetail(this.mContext, Integer.valueOf(i), i2, new ApiDataCallBack<ClientDetailTaskData>() { // from class: com.fendasz.moku.planet.ui.activity.RewardTaskDetailActivity.5
            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void success(int i3, ClientDetailTaskData clientDetailTaskData) {
                LoadingDialog.dismiss();
                try {
                    consumer.accept(clientDetailTaskData);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                RewardTaskDetailActivity.this.locationStatus = clientDetailTaskData.getLocationStatus();
                if (RewardTaskDetailActivity.this.locationStatus == null || 1 != RewardTaskDetailActivity.this.locationStatus.intValue()) {
                    return;
                }
                RewardTaskDetailActivity.this.queryLocationInfo();
            }

            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void error(int i3, String str) {
                LoadingDialog.dismiss();
                LogUtils.log(RewardTaskDetailActivity.TAG, "code:" + i3 + " message:" + str);
                if (z) {
                    Toast.makeText(RewardTaskDetailActivity.this.mContext, str + i3, 1).show();
                    return;
                }
                if (i3 == 5000 || i3 == 5001) {
                    Toast.makeText(RewardTaskDetailActivity.this.mContext, str + i3, 1).show();
                    return;
                }
                String string = RewardTaskDetailActivity.this.getString(R.string.moku_internet_error_tip);
                if (101 != RewardTaskDetailActivity.this.operationType) {
                    Toast.makeText(RewardTaskDetailActivity.this.mContext, "code:" + i3 + " message:" + str, 1).show();
                    str = string;
                }
                RewardTaskDetailActivity.this.showErrorDialog(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onInitComplete(boolean z) throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        OperationEnum operationEnum = this.mApiTaskOperationHelper.getOperationEnum();
        if (!operationEnum.equals(OperationEnum.SUCCESS_START) && !operationEnum.equals(OperationEnum.ERROR_OVERTIME) && !operationEnum.equals(OperationEnum.ERROR_TAKEUP)) {
            startCountDown();
        } else if (z && !getIsFirstCpaTask()) {
            getTaskDataStatus(true);
        }
        showUiTips(2);
        onInitStatusComplete();
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
    public void startCountDown() {
        LogUtils.log(TAG, "倒计时开始");
        initCountDown();
        if (this.currentTime == null) {
            this.currentTime = Long.valueOf(SharedPreferencesUtils.getInstance(this.mContext).getLong("mokuTime", System.currentTimeMillis()));
        }
        if (this.scheduled == null) {
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);
            this.scheduled = scheduledThreadPoolExecutor;
            scheduledThreadPoolExecutor.scheduleAtFixedRate(new Runnable() { // from class: com.fendasz.moku.planet.ui.activity.RewardTaskDetailActivity.6
                @Override // java.lang.Runnable
                public void run() {
                    ((Activity) RewardTaskDetailActivity.this.mContext).runOnUiThread(new Runnable() { // from class: com.fendasz.moku.planet.ui.activity.RewardTaskDetailActivity.6.1
                        @Override // java.lang.Runnable
                        public void run() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                            TaskDataApplyRecord taskDataApplyRecord;
                            if (RewardTaskDetailActivity.this.currentTime != null) {
                                RewardTaskDetailActivity.this.currentTime = Long.valueOf(RewardTaskDetailActivity.this.currentTime.longValue() + 1000);
                                if (RewardTaskDetailActivity.this.mExpirationTime != null) {
                                    if (DateUtils.getDate(RewardTaskDetailActivity.this.mExpirationTime, "yyyy-MM-dd HH:mm:ss").getTime() - RewardTaskDetailActivity.this.currentTime.longValue() > 0) {
                                        RewardTaskDetailActivity.this.showUiTips(3);
                                        return;
                                    }
                                    LogUtils.log(RewardTaskDetailActivity.TAG, "任务已超时");
                                    if (RewardTaskDetailActivity.this.mClientDetailTaskData != null && (taskDataApplyRecord = RewardTaskDetailActivity.this.mClientDetailTaskData.getTaskDataApplyRecord()) != null) {
                                        taskDataApplyRecord.setStatus(MokuConstants.STATUS_OF_OVERTIME);
                                    }
                                    RewardTaskDetailActivity.this.mApiTaskOperationHelper.init(RewardTaskDetailActivity.this.mContext);
                                    RewardTaskDetailActivity.this.showUiTips(3);
                                    RewardTaskDetailActivity.this.initCountDown();
                                }
                            }
                        }
                    });
                }
            }, 0L, 1L, TimeUnit.SECONDS);
        }
    }

    private String getRemainTime() {
        String str = this.mExpirationTime;
        if (str == null || this.currentTime == null) {
            return "";
        }
        long time = DateUtils.getDate(str, "yyyy-MM-dd HH:mm:ss").getTime() - this.currentTime.longValue();
        return time > 0 ? DateUtils.getFormatDate(time, "小时", "分钟", "秒") : "00小时00分钟00秒";
    }

    /* renamed from: com.fendasz.moku.planet.ui.activity.RewardTaskDetailActivity$7, reason: invalid class name */
    class AnonymousClass7 implements View.OnClickListener {
        AnonymousClass7() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            if (RewardTaskDetailActivity.this.mApiTaskOperationHelper.getOperationEnum() != OperationEnum.SUCCESS_SUBMIT) {
                RewardTaskDetailActivity.this.showUiTips(0);
                RewardTaskDetailActivity.this.executeTask();
            } else if (RewardTaskDetailActivity.this.mClientDetailTaskData.getClassify().equals("cpa") && !RewardTaskDetailActivity.this.mClientDetailTaskData.getTaskData().getCpaType().equals(MokuConstants.CPA_TYPE_NORMAL)) {
                SystemUtils.openPackage(RewardTaskDetailActivity.this.mContext, RewardTaskDetailActivity.this.mClientDetailTaskData.getPackageName());
            } else if (Build.VERSION.SDK_INT >= 19) {
                RewardTaskDetailActivity.this.webView.evaluateJavascript("javascript:send()", new ValueCallback() { // from class: com.fendasz.moku.planet.ui.activity.RewardTaskDetailActivity$7$$ExternalSyntheticLambda0
                    @Override // android.webkit.ValueCallback
                    public final void onReceiveValue(Object obj) {
                        Log.d(RewardTaskDetailActivity.TAG, (String) obj);
                    }
                });
            } else {
                RewardTaskDetailActivity.this.webView.loadUrl("javascript:send()");
            }
        }
    }

    private void initStaticViewListener() {
        RelativeLayout relativeLayout = this.mRlDownload;
        if (relativeLayout != null) {
            relativeLayout.setOnClickListener(new AnonymousClass7());
        }
        Button button = this.mBtnStartTask;
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() { // from class: com.fendasz.moku.planet.ui.activity.RewardTaskDetailActivity.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    if (jCurrentTimeMillis - RewardTaskDetailActivity.this.clickTime > 1000) {
                        RewardTaskDetailActivity.this.clickTime = jCurrentTimeMillis;
                        RewardTaskDetailActivity.this.getTaskDataStatus(false);
                    } else {
                        LogUtils.log(RewardTaskDetailActivity.TAG, "repeat click");
                        Toast.makeText(RewardTaskDetailActivity.this.mContext, "不要重复点击", 1).show();
                    }
                }
            });
        }
        TextView textView = this.mTvCancelTask;
        if (textView != null) {
            textView.setOnClickListener(new AnonymousClass9());
        }
    }

    /* renamed from: com.fendasz.moku.planet.ui.activity.RewardTaskDetailActivity$9, reason: invalid class name */
    class AnonymousClass9 implements View.OnClickListener {
        AnonymousClass9() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            new CustomBuildDialog.DialogBuilder(RewardTaskDetailActivity.this.mContext).setTitleImage(Integer.valueOf(R.drawable.moku_tips_icon)).setDetailText("任务取消2次后，当天不再展示\n确定取消这个任务么？").setCancelable(false).setLeftBtn("确定取消", new CustomBuildDialog.DialogButtonOnClickListener() { // from class: com.fendasz.moku.planet.ui.activity.RewardTaskDetailActivity.9.2
                @Override // com.fendasz.moku.planet.ui.dialog.CustomBuildDialog.DialogButtonOnClickListener
                public void onClick(TextView textView, CustomBuildDialog customBuildDialog) {
                    customBuildDialog.dismiss();
                    RewardTaskDetailActivity.this.cancelTask(RewardTaskDetailActivity.this.mClientDetailTaskData, new com.fendasz.moku.planet.interf.functions.Consumer<TaskDataApplyRecord>() { // from class: com.fendasz.moku.planet.ui.activity.RewardTaskDetailActivity.9.2.1
                        @Override // com.fendasz.moku.planet.interf.functions.Consumer
                        public void accept(TaskDataApplyRecord taskDataApplyRecord) throws Exception {
                            RewardTaskDetailActivity.this.cancelTaskCallBack(taskDataApplyRecord);
                        }
                    });
                }
            }).setRightBtn("继续任务", new CustomBuildDialog.DialogButtonOnClickListener() { // from class: com.fendasz.moku.planet.ui.activity.RewardTaskDetailActivity.9.1
                @Override // com.fendasz.moku.planet.ui.dialog.CustomBuildDialog.DialogButtonOnClickListener
                public void onClick(TextView textView, CustomBuildDialog customBuildDialog) {
                    customBuildDialog.dismiss();
                }
            }).create().show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelTaskCallBack(TaskDataApplyRecord taskDataApplyRecord) {
        this.mClientDetailTaskData.setTaskDataApplyRecord(taskDataApplyRecord);
        for (int i = 0; i < this.etFormList.size(); i++) {
            this.etFormList.get(i).setEnabled(false);
        }
        if (this.mClientDetailTaskData.getClassify().equals("comment")) {
            if (taskDataApplyRecord == null || !taskDataApplyRecord.getStatus().equals(TaskDataApplyRecord.STATUS_OF_APPLYING)) {
                TextView textView = this.mTvCommentContent;
                if (textView != null) {
                    textView.setEnabled(false);
                    this.mTvCommentContent.setText("请先开始任务");
                }
                TextView textView2 = this.mTvBtnCommentCopy;
                if (textView2 != null) {
                    textView2.setEnabled(false);
                    return;
                }
                return;
            }
            return;
        }
        if ("cpa".equals(this.mClientDetailTaskData.getClassify())) {
            int iIntValue = this.mClientDetailTaskData.getTaskDataApplyRecord().getId().intValue();
            String listenedTag = this.mApiTaskOperationHelper.getListenedTag(this, iIntValue, this.mClientDetailTaskData.getPackageName(), this.mClientDetailTaskData.getPackageName());
            Log.d("listenedTag==>", listenedTag);
            if (!StringUtils.isEmpty(listenedTag)) {
                ApiDataHelper.getApiDataHelper().cancelWithoutMonitor(this.mContext, this.mClientDetailTaskData.getTaskDataId(), Integer.valueOf(iIntValue), new ApiDataCallBack<Object>() { // from class: com.fendasz.moku.planet.ui.activity.RewardTaskDetailActivity.10
                    @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
                    public void success(int i2, Object obj) throws Exception {
                        RewardTaskDetailActivity.this.mApiTaskOperationHelper.cancelTask(RewardTaskDetailActivity.this.mContext);
                        RewardTaskDetailActivity.this.finish();
                    }

                    @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
                    public void error(int i2, String str) throws Exception {
                        RewardTaskDetailActivity.this.mApiTaskOperationHelper.cancelTask(RewardTaskDetailActivity.this.mContext);
                        RewardTaskDetailActivity.this.finish();
                    }
                });
                return;
            } else {
                this.mApiTaskOperationHelper.cancelTask(this.mContext);
                finish();
                return;
            }
        }
        this.mApiTaskOperationHelper.cancelTask(this.mContext);
        finish();
    }

    @Override // com.fendasz.moku.planet.ui.base.activity.BaseActivity, android.app.Activity
    public void finish() {
        LogUtils.logD(TAG, "finish==>");
        super.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkAndSubmit(Action action) throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        if (checkForm()) {
            submitTask(action);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getTaskDataStatus(final boolean z) {
        LoadingDialog.show(this.mContext);
        ApiDataHelper.getApiDataHelper().getTaskDataStatus(this.mContext, new ApiDataCallBack<TaskDataApplyRecord>() { // from class: com.fendasz.moku.planet.ui.activity.RewardTaskDetailActivity.11
            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void success(int i, TaskDataApplyRecord taskDataApplyRecord) throws Exception {
                LoadingDialog.dismiss();
                if (taskDataApplyRecord == null || taskDataApplyRecord.getTaskDataId().intValue() == RewardTaskDetailActivity.this.mTaskDataId) {
                    RewardTaskDetailActivity.this.applyTask(!z);
                } else {
                    RewardTaskDetailActivity.this.showApplyingTask(taskDataApplyRecord);
                }
            }

            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void error(int i, String str) throws Exception {
                LoadingDialog.dismiss();
                LogUtils.log(RewardTaskDetailActivity.TAG, "code:" + i + " message:" + str);
                Toast.makeText(RewardTaskDetailActivity.this.mContext, str + i, 1).show();
            }
        });
    }

    /* renamed from: com.fendasz.moku.planet.ui.activity.RewardTaskDetailActivity$12, reason: invalid class name */
    class AnonymousClass12 implements Consumer<ClientDetailTaskData> {
        AnonymousClass12() {
        }

        @Override // io.reactivex.functions.Consumer
        public void accept(final ClientDetailTaskData clientDetailTaskData) throws Exception {
            LinearLayout linearLayout = new LinearLayout(RewardTaskDetailActivity.this.mContext);
            linearLayout.setOrientation(0);
            linearLayout.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
            final ImageView imageView = new ImageView(RewardTaskDetailActivity.this.mContext);
            linearLayout.addView(imageView);
            ((LinearLayout.LayoutParams) imageView.getLayoutParams()).gravity = 16;
            ScreenAdaptationUtils.setSize(RewardTaskDetailActivity.this.mContext, imageView, 120, 120);
            ScreenAdaptationUtils.setMarginRight(RewardTaskDetailActivity.this.mContext, imageView, 20);
            ImageUtils.getInstance().setImageView(RewardTaskDetailActivity.this.mContext, clientDetailTaskData.getIcon(), new com.fendasz.moku.planet.interf.functions.Consumer<Bitmap>() { // from class: com.fendasz.moku.planet.ui.activity.RewardTaskDetailActivity.12.1
                @Override // com.fendasz.moku.planet.interf.functions.Consumer
                public void accept(Bitmap bitmap) throws Exception {
                    imageView.setImageBitmap(bitmap);
                }
            }, Float.valueOf(RewardTaskDetailActivity.this.mPhoneScreenUtils.getScale(RewardTaskDetailActivity.this.mContext, 120.0f)), Float.valueOf(RewardTaskDetailActivity.this.mPhoneScreenUtils.getScale(RewardTaskDetailActivity.this.mContext, 120.0f)));
            LinearLayout linearLayout2 = new LinearLayout(RewardTaskDetailActivity.this.mContext);
            linearLayout2.setLayoutParams(new RelativeLayout.LayoutParams(-2, -1));
            linearLayout2.setOrientation(1);
            linearLayout.addView(linearLayout2);
            TextView textView = new TextView(RewardTaskDetailActivity.this.mContext);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, 0);
            layoutParams.weight = 1.0f;
            textView.setLayoutParams(layoutParams);
            textView.setSingleLine(true);
            textView.setEllipsize(TextUtils.TruncateAt.END);
            textView.setTextColor(RewardTaskDetailActivity.this.mContext.getResources().getColor(R.color.black));
            linearLayout2.addView(textView);
            textView.setText(clientDetailTaskData.getShowName());
            textView.setTextSize(RewardTaskDetailActivity.this.phoneScreenUtils.getNormalTextSize(RewardTaskDetailActivity.this.mContext));
            TextView textView2 = new TextView(RewardTaskDetailActivity.this.mContext);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, 0);
            layoutParams2.weight = 1.0f;
            textView2.setLayoutParams(layoutParams2);
            textView2.setSingleLine(true);
            textView2.setEllipsize(TextUtils.TruncateAt.END);
            textView2.setTextColor(RewardTaskDetailActivity.this.mContext.getResources().getColor(R.color.moku_yellow_golden));
            linearLayout2.addView(textView2);
            textView2.setTextSize(RewardTaskDetailActivity.this.phoneScreenUtils.getNormalTextSize(RewardTaskDetailActivity.this.mContext));
            textView2.setText(clientDetailTaskData.getShowMoney().toPlainString() + clientDetailTaskData.getCybermoneyName());
            new CustomBuildDialog.DialogBuilder(RewardTaskDetailActivity.this.mContext).setTitleImage(Integer.valueOf(R.drawable.moku_tips_icon)).setDetailText("您有一个进行中的任务，是否放弃此任务，开始当前任务？").setCustomView(linearLayout).setCancelable(false).setLeftBtn("返回完成", new CustomBuildDialog.DialogButtonOnClickListener() { // from class: com.fendasz.moku.planet.ui.activity.RewardTaskDetailActivity.12.3
                @Override // com.fendasz.moku.planet.ui.dialog.CustomBuildDialog.DialogButtonOnClickListener
                public void onClick(TextView textView3, CustomBuildDialog customBuildDialog) {
                    customBuildDialog.dismiss();
                    RewardTaskDetailActivity.this.mTaskDataId = clientDetailTaskData.getTaskDataId().intValue();
                    if (clientDetailTaskData.getTaskType().intValue() == 0) {
                        Intent intent = new Intent(RewardTaskDetailActivity.this.mContext, (Class<?>) TaskDetailActivity.class);
                        intent.putExtra("taskDataId", RewardTaskDetailActivity.this.mTaskDataId);
                        intent.putExtra("taskDataUrl", clientDetailTaskData.getUrl());
                        String gateType = clientDetailTaskData.getGateType();
                        if (!TextUtils.isEmpty(gateType)) {
                            intent.putExtra("gateType", gateType);
                        }
                        intent.putExtra("operationType", 100);
                        RewardTaskDetailActivity.this.startActivityForResult(intent, 51);
                        return;
                    }
                    RewardTaskDetailActivity.this.mClientDetailTaskData = clientDetailTaskData;
                    RewardTaskDetailActivity.this.loadUrl();
                    RewardTaskDetailActivity.this.refresh(true, false);
                }
            }).setRightBtn(RewardTaskDetailActivity.this.mContext.getString(R.string.moku_btn_confirm), new CustomBuildDialog.DialogButtonOnClickListener() { // from class: com.fendasz.moku.planet.ui.activity.RewardTaskDetailActivity.12.2
                @Override // com.fendasz.moku.planet.ui.dialog.CustomBuildDialog.DialogButtonOnClickListener
                public void onClick(TextView textView3, CustomBuildDialog customBuildDialog) {
                    customBuildDialog.dismiss();
                    RewardTaskDetailActivity.this.cancelTask(clientDetailTaskData, new com.fendasz.moku.planet.interf.functions.Consumer<TaskDataApplyRecord>() { // from class: com.fendasz.moku.planet.ui.activity.RewardTaskDetailActivity.12.2.1
                        @Override // com.fendasz.moku.planet.interf.functions.Consumer
                        public void accept(TaskDataApplyRecord taskDataApplyRecord) throws Exception {
                            Toast.makeText(RewardTaskDetailActivity.this.mContext, "任务(taskDataId:" + taskDataApplyRecord.getTaskDataId() + ")取消成功", 0).show();
                            RewardTaskDetailActivity.this.applyTask(true);
                        }
                    });
                }
            }).setShowClose(true).create().show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showApplyingTask(TaskDataApplyRecord taskDataApplyRecord) {
        LogUtils.log(TAG, "another task is applying while the taskId is " + taskDataApplyRecord.getTaskDataId() + " and applyId is " + taskDataApplyRecord.getId());
        getTaskDetailData(taskDataApplyRecord.getTaskDataId().intValue(), true, new AnonymousClass12());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void applyTask(final boolean z) {
        if (this.operationType == 101) {
            return;
        }
        Integer num = this.locationStatus;
        if (num != null && 1 == num.intValue() && !PermissionUtils.hasLocationPermissions(this)) {
            queryLocationInfo();
            return;
        }
        if (PermissionUtils.hasLocationPermissions(this)) {
            Log.d(TAG, "getSimCardInfo");
            GetInfoUtil.getSimCardInfo(this, this);
        }
        if (z) {
            LoadingDialog.show(this.mContext);
        }
        Integer numCheckIsCanStartTask = this.mApiTaskOperationHelper.checkIsCanStartTask(this.mContext);
        if (numCheckIsCanStartTask.equals(MokuConstants.CHECK_CAN_START_TASK)) {
            ApiDataHelper.getApiDataHelper().applyTask(this.mContext, this.mClientDetailTaskData.getTaskDataId(), new ApiDataCallBack<TaskDataApplyRecord>() { // from class: com.fendasz.moku.planet.ui.activity.RewardTaskDetailActivity.13
                @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
                public void success(int i, TaskDataApplyRecord taskDataApplyRecord) throws Exception {
                    LoadingDialog.dismiss();
                    LogUtils.log(RewardTaskDetailActivity.TAG, "TaskDataApplyRecord >> " + JSON.toJSONString(taskDataApplyRecord));
                    Toast.makeText(RewardTaskDetailActivity.this.mContext, "任务开始了，按任务要求完成吧~", 0).show();
                    RewardTaskDetailActivity.this.mClientDetailTaskData.setTaskDataApplyRecord(taskDataApplyRecord);
                    RewardTaskDetailActivity.this.mExpirationTime = taskDataApplyRecord.getExpirationTime();
                    RewardTaskDetailActivity.this.startCountDown();
                    RewardTaskDetailActivity.this.setResult(300);
                    for (int i2 = 0; i2 < RewardTaskDetailActivity.this.etFormList.size(); i2++) {
                        ((EditText) RewardTaskDetailActivity.this.etFormList.get(i2)).setEnabled(true);
                    }
                    if (RewardTaskDetailActivity.this.mClientDetailTaskData.getClassify().equals("comment")) {
                        if (taskDataApplyRecord.getStatus().equals(TaskDataApplyRecord.STATUS_OF_APPLYING)) {
                            if (RewardTaskDetailActivity.this.mTvCommentContent != null) {
                                RewardTaskDetailActivity.this.mTvCommentContent.setEnabled(true);
                                RewardTaskDetailActivity.this.mTvCommentContent.setText(!TextUtils.isEmpty(taskDataApplyRecord.getTaskDataCommentData().getTaskDataCommentData()) ? taskDataApplyRecord.getTaskDataCommentData().getTaskDataCommentData() : "");
                            }
                            if (RewardTaskDetailActivity.this.mTvBtnCommentCopy != null) {
                                RewardTaskDetailActivity.this.mTvBtnCommentCopy.setEnabled(true);
                            }
                        }
                        if (RewardTaskDetailActivity.this.mTvCommentContent != null && RewardTaskDetailActivity.this.mTvCommentContent.isEnabled()) {
                            try {
                                SystemUtils.copyToClipboard(RewardTaskDetailActivity.this.mContext, "comment", RewardTaskDetailActivity.this.mTvCommentContent.getText().toString());
                                Toast.makeText(RewardTaskDetailActivity.this.mContext, "评论已复制到剪贴板", 0).show();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    RewardTaskDetailActivity.this.mApiTaskOperationHelper.init(RewardTaskDetailActivity.this.mContext);
                    if (z) {
                        RewardTaskDetailActivity.this.executeTask();
                    }
                    RewardTaskDetailActivity.this.onInitStatusComplete();
                    Integer checkTheState = taskDataApplyRecord.getCheckTheState();
                    LogUtils.logD(RewardTaskDetailActivity.TAG, "checkTheState=>" + checkTheState);
                    if (checkTheState == null || 1 != checkTheState.intValue()) {
                        return;
                    }
                    RewardTaskDetailActivity.this.uplodatePackage();
                }

                @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
                public void error(int i, String str) throws Exception {
                    LoadingDialog.dismiss();
                    LogUtils.log(RewardTaskDetailActivity.TAG, "code:" + i + " message:" + str);
                    if (i == 5007) {
                        RewardTaskDetailActivity.this.showErrorDialog(str);
                    } else if ("系统异常".equals(str)) {
                        Toast.makeText(RewardTaskDetailActivity.this.mContext, "申请失败，设备/账号已申请该任务" + i, 1).show();
                    } else {
                        Toast.makeText(RewardTaskDetailActivity.this.mContext, str + i, 1).show();
                    }
                }
            });
            return;
        }
        LoadingDialog.dismiss();
        if (numCheckIsCanStartTask.equals(MokuConstants.CHECK_APP_EXIST)) {
            CustomBuildDialog.DialogBuilder dialogBuilder = new CustomBuildDialog.DialogBuilder(this.mContext);
            dialogBuilder.setTitleImage(Integer.valueOf(R.drawable.moku_tips_icon)).setDetailText("开始该任务，必须先卸载手机上的【" + this.mClientDetailTaskData.getTaskData().getTaskDataDetail().getAppName() + "】，否则没有奖励呢~").setCancelable(false);
            if (PermissionUtils.checkIsRequestDeletePackagesPermissionGranted(this.mContext)) {
                dialogBuilder.setLeftBtn(this.mContext.getString(R.string.moku_btn_no), new CustomBuildDialog.DialogButtonOnClickListener() { // from class: com.fendasz.moku.planet.ui.activity.RewardTaskDetailActivity.15
                    @Override // com.fendasz.moku.planet.ui.dialog.CustomBuildDialog.DialogButtonOnClickListener
                    public void onClick(TextView textView, CustomBuildDialog customBuildDialog) {
                        customBuildDialog.dismiss();
                    }
                }).setRightBtn(this.mContext.getString(R.string.moku_uninstall), new CustomBuildDialog.DialogButtonOnClickListener() { // from class: com.fendasz.moku.planet.ui.activity.RewardTaskDetailActivity.14
                    @Override // com.fendasz.moku.planet.ui.dialog.CustomBuildDialog.DialogButtonOnClickListener
                    public void onClick(TextView textView, CustomBuildDialog customBuildDialog) {
                        customBuildDialog.dismiss();
                        SystemUtils.uninstallApp(RewardTaskDetailActivity.this.mContext, RewardTaskDetailActivity.this.mClientDetailTaskData.getPackageName());
                    }
                });
            } else {
                dialogBuilder.setRightBtn(this.mContext.getString(R.string.moku_btn_ok), new CustomBuildDialog.DialogButtonOnClickListener() { // from class: com.fendasz.moku.planet.ui.activity.RewardTaskDetailActivity.16
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
    public void onInitStatusComplete() throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        Button button;
        ClientDetailTaskData clientDetailTaskData = this.mClientDetailTaskData;
        if (clientDetailTaskData != null && clientDetailTaskData.isCheckUsage() && this.mClientDetailTaskData.isApplyRecordNullOrCanceled() && this.mClientDetailTaskData.isNewTaskGroup() && MokuUtils.isAppExistEver(this.mContext, this.mClientDetailTaskData.getPackageName()) && (button = this.mBtnStartTask) != null) {
            button.setText(this.mContext.getString(R.string.moku_start_task_btn_text_pkg_exist));
            this.mBtnStartTask.setEnabled(false);
        }
        ApiTaskOperationHelper apiTaskOperationHelper = this.mApiTaskOperationHelper;
        if (apiTaskOperationHelper != null && apiTaskOperationHelper.getOperationEnum() != null) {
            if (this.mApiTaskOperationHelper.getOperationEnum().equals(OperationEnum.SUCCESS_SUBMIT) && this.mClientDetailTaskData.getClassify().equals("cpa") && this.mClientDetailTaskData.getTaskData().getCpaType().equals(MokuConstants.CPA_TYPE_NORMAL) && !this.isStartSubmitCpaNormalTask) {
                this.isStartSubmitCpaNormalTask = true;
                checkAndSubmit(new Action() { // from class: com.fendasz.moku.planet.ui.activity.RewardTaskDetailActivity.17
                    @Override // io.reactivex.functions.Action
                    public void run() throws Exception {
                        RewardTaskDetailActivity.this.submitNormalTask();
                    }
                });
                return;
            }
            return;
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doSubmitNormalTask() {
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<Integer, File>> it = this.updateFileMap.entrySet().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getValue());
        }
        ApiDataHelper.getApiDataHelper().submitTask(this.mContext, this.mClientDetailTaskData, arrayList, this.formDatas, this.mAdditionalData, new AnonymousClass18());
    }

    /* renamed from: com.fendasz.moku.planet.ui.activity.RewardTaskDetailActivity$18, reason: invalid class name */
    class AnonymousClass18 implements ApiDataCallBack<String> {
        AnonymousClass18() {
        }

        @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
        public void success(int i, String str) throws Exception {
            LoadingDialog.dismiss();
            LogUtils.log(RewardTaskDetailActivity.TAG, JSON.toJSONString(str));
            RewardTaskDetailActivity.this.setResult(300);
            if (RewardTaskDetailActivity.this.isTaskGroup) {
                if (RewardTaskDetailActivity.this.mClientDetailTaskData.getClassify().equals("cpa")) {
                    RewardTaskDetailActivity.this.submitTaskGroupInitSpAndDialog(null, 1);
                } else {
                    RewardTaskDetailActivity.this.submitTaskGroupInitSpAndDialog(str, 0);
                }
            } else {
                new CustomBuildDialog.DialogBuilder(RewardTaskDetailActivity.this.mContext).setTitleImage(Integer.valueOf(R.drawable.moku_task_finished)).setTitleText("提交成功").setDetailText("预计<font color=\"#ff0000\">" + str + "</font>前审核完成").setRightBtn(RewardTaskDetailActivity.this.getString(R.string.moku_btn_continue), new CustomBuildDialog.DialogButtonOnClickListener() { // from class: com.fendasz.moku.planet.ui.activity.RewardTaskDetailActivity$18$$ExternalSyntheticLambda0
                    @Override // com.fendasz.moku.planet.ui.dialog.CustomBuildDialog.DialogButtonOnClickListener
                    public final void onClick(TextView textView, CustomBuildDialog customBuildDialog) {
                        this.f$0.m421x44a6fae6(textView, customBuildDialog);
                    }
                }).setCancelable(false).create().show();
            }
            RewardTaskDetailActivity.this.sendTaskSubmitBroadcast();
        }

        /* renamed from: lambda$success$0$com-fendasz-moku-planet-ui-activity-RewardTaskDetailActivity$18, reason: not valid java name */
        /* synthetic */ void m421x44a6fae6(TextView textView, CustomBuildDialog customBuildDialog) {
            if (RewardTaskDetailActivity.this.operationType == 101) {
                RewardTaskDetailActivity.this.setResult(602);
                RewardTaskDetailActivity.this.removeSuspendLayout();
                RewardTaskDetailActivity.this.finish();
            } else {
                customBuildDialog.dismiss();
                RewardTaskDetailActivity.this.putSpIsShowGuideMyParticipateInTip();
                RewardTaskDetailActivity.this.finish();
            }
        }

        @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
        public void error(int i, String str) throws Exception {
            LoadingDialog.dismiss();
            LogUtils.log(RewardTaskDetailActivity.TAG, "code:" + i + " message:" + str);
            Toast.makeText(RewardTaskDetailActivity.this.mContext, str + i, 1).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void submitNormalTask() throws NoSuchMethodException, SecurityException {
        LoadingDialog.show(this.mContext);
        MokuConfigure.getInstance().updateUserType(this.mContext, 2);
        MokuConfigure.getInstance().updateSubmitTaskDataId(this.mContext, this.mClientDetailTaskData.getTaskDataId());
        ApiDataHelper.getApiDataHelper().uploadDeviceInfo(this, new ApiDataCallBack<Object>() { // from class: com.fendasz.moku.planet.ui.activity.RewardTaskDetailActivity.19
            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void success(int i, Object obj) throws Exception {
                Log.d(RewardTaskDetailActivity.TAG, "upload device info success");
                RewardTaskDetailActivity.this.doSubmitNormalTask();
            }

            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void error(int i, String str) throws Exception {
                LogUtils.logE(RewardTaskDetailActivity.TAG, "upload device info error,code=>" + i + ",message" + str);
                RewardTaskDetailActivity.this.doSubmitNormalTask();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void submitAppealTask(int i, List<ClientTaskDataSubmitFormModel> list, String str) {
        LoadingDialog.show(this.mContext);
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<Integer, File>> it = this.updateFileMap.entrySet().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getValue());
        }
        ApiDataHelper.getApiDataHelper().submitAppealTask(this.mContext, Integer.valueOf(i), arrayList, list, str, new AnonymousClass20());
    }

    /* renamed from: com.fendasz.moku.planet.ui.activity.RewardTaskDetailActivity$20, reason: invalid class name */
    class AnonymousClass20 implements ApiDataCallBack<String> {
        AnonymousClass20() {
        }

        @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
        public void success(int i, String str) throws Exception {
            LoadingDialog.dismiss();
            LogUtils.log(RewardTaskDetailActivity.TAG, JSON.toJSONString(str));
            RewardTaskDetailActivity.this.setResult(300);
            if (RewardTaskDetailActivity.this.isTaskGroup) {
                if (RewardTaskDetailActivity.this.mClientDetailTaskData.getClassify().equals("cpa")) {
                    RewardTaskDetailActivity.this.submitTaskGroupInitSpAndDialog(null, 1);
                } else {
                    RewardTaskDetailActivity.this.submitTaskGroupInitSpAndDialog(str, 0);
                }
            } else {
                new CustomBuildDialog.DialogBuilder(RewardTaskDetailActivity.this.mContext).setTitleImage(Integer.valueOf(R.drawable.moku_task_finished)).setTitleText("提交成功").setDetailText("预计<font color=\"#ff0000\">" + str + "</font>前审核完成").setRightBtn(RewardTaskDetailActivity.this.getString(R.string.moku_btn_continue), new CustomBuildDialog.DialogButtonOnClickListener() { // from class: com.fendasz.moku.planet.ui.activity.RewardTaskDetailActivity$20$$ExternalSyntheticLambda0
                    @Override // com.fendasz.moku.planet.ui.dialog.CustomBuildDialog.DialogButtonOnClickListener
                    public final void onClick(TextView textView, CustomBuildDialog customBuildDialog) {
                        this.f$0.m423x44a6fafd(textView, customBuildDialog);
                    }
                }).setCancelable(false).create().show();
            }
            RewardTaskDetailActivity.this.sendTaskSubmitBroadcast();
        }

        /* renamed from: lambda$success$0$com-fendasz-moku-planet-ui-activity-RewardTaskDetailActivity$20, reason: not valid java name */
        /* synthetic */ void m423x44a6fafd(TextView textView, CustomBuildDialog customBuildDialog) {
            if (RewardTaskDetailActivity.this.operationType == 101) {
                RewardTaskDetailActivity.this.setResult(602);
                RewardTaskDetailActivity.this.finish();
            } else {
                customBuildDialog.dismiss();
                RewardTaskDetailActivity.this.putSpIsShowGuideMyParticipateInTip();
                RewardTaskDetailActivity.this.finish();
            }
        }

        @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
        public void error(int i, String str) throws Exception {
            LoadingDialog.dismiss();
            LogUtils.log(RewardTaskDetailActivity.TAG, "code:" + i + " message:" + str);
            Toast.makeText(RewardTaskDetailActivity.this.mContext, str + i, 1).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void putSpIsShowGuideMyParticipateInTip() {
        if (SharedPreferencesUtils.getInstance(this.mContext).getInt(this.mContext.getString(R.string.moku_sp_is_show_guide_my_participate_in_tip), 0) == 0) {
            SharedPreferencesUtils.getInstance(this.mContext).putInt(this.mContext.getString(R.string.moku_sp_is_show_guide_my_participate_in_tip), 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void submitTaskGroupInitSpAndDialog(String str, int i) {
        if (SharedPreferencesUtils.getInstance(this.mContext).getInt(MokuMainActivity.TASK_GROUP_TIPS_IMAGE_VIEW_SP, 0) == 0) {
            SharedPreferencesUtils.getInstance(this.mContext).putInt(MokuMainActivity.TASK_GROUP_TIPS_IMAGE_VIEW_SP, 1);
            SharedPreferencesUtils.getInstance(this.mContext).putString(MokuMainActivity.TASK_GROUP_TIPS_DATE_SP, DateUtils.getFormatDate(SharedPreferencesUtils.getInstance(this.mContext).getLong("mokuTime", System.currentTimeMillis()), Times.YYYY_MM_DD) + " 00:00:00");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getTaskGroupDataList(final List<ClientGroupTaskData> list, final Consumer<List<ClientGroupTaskData>> consumer) {
        LoadingDialog.show(this.mContext);
        ApiDataHelper.getApiDataHelper().getTaskDetail(this.mContext, list.get(this.mNumberOfAttempts).getTaskDataId(), 0, new ApiDataCallBack<ClientDetailTaskData>() { // from class: com.fendasz.moku.planet.ui.activity.RewardTaskDetailActivity.21
            /* JADX WARN: Removed duplicated region for block: B:9:0x001f A[Catch: Exception -> 0x0043, TryCatch #0 {Exception -> 0x0043, blocks: (B:4:0x0005, B:6:0x000b, B:8:0x0015, B:9:0x001f, B:11:0x0032, B:12:0x003c), top: B:18:0x0005 }] */
            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void success(int r2, com.fendasz.moku.planet.source.bean.ClientDetailTaskData r3) {
                /*
                    r1 = this;
                    com.fendasz.moku.planet.ui.dialog.LoadingDialog.dismiss()
                    if (r3 == 0) goto L1f
                    java.util.List r2 = r3.getClientGroupTaskDataList()     // Catch: java.lang.Exception -> L43
                    if (r2 == 0) goto L1f
                    java.util.List r2 = r3.getClientGroupTaskDataList()     // Catch: java.lang.Exception -> L43
                    int r2 = r2.size()     // Catch: java.lang.Exception -> L43
                    if (r2 <= 0) goto L1f
                    io.reactivex.functions.Consumer r2 = r2     // Catch: java.lang.Exception -> L43
                    java.util.List r3 = r3.getClientGroupTaskDataList()     // Catch: java.lang.Exception -> L43
                    r2.accept(r3)     // Catch: java.lang.Exception -> L43
                    goto L47
                L1f:
                    com.fendasz.moku.planet.ui.activity.RewardTaskDetailActivity r2 = com.fendasz.moku.planet.ui.activity.RewardTaskDetailActivity.this     // Catch: java.lang.Exception -> L43
                    com.fendasz.moku.planet.ui.activity.RewardTaskDetailActivity.access$3708(r2)     // Catch: java.lang.Exception -> L43
                    com.fendasz.moku.planet.ui.activity.RewardTaskDetailActivity r2 = com.fendasz.moku.planet.ui.activity.RewardTaskDetailActivity.this     // Catch: java.lang.Exception -> L43
                    int r2 = com.fendasz.moku.planet.ui.activity.RewardTaskDetailActivity.access$3700(r2)     // Catch: java.lang.Exception -> L43
                    java.util.List r3 = r3     // Catch: java.lang.Exception -> L43
                    int r3 = r3.size()     // Catch: java.lang.Exception -> L43
                    if (r2 >= r3) goto L3c
                    com.fendasz.moku.planet.ui.activity.RewardTaskDetailActivity r2 = com.fendasz.moku.planet.ui.activity.RewardTaskDetailActivity.this     // Catch: java.lang.Exception -> L43
                    java.util.List r3 = r3     // Catch: java.lang.Exception -> L43
                    io.reactivex.functions.Consumer r0 = r2     // Catch: java.lang.Exception -> L43
                    com.fendasz.moku.planet.ui.activity.RewardTaskDetailActivity.access$3800(r2, r3, r0)     // Catch: java.lang.Exception -> L43
                    goto L47
                L3c:
                    io.reactivex.functions.Consumer r2 = r2     // Catch: java.lang.Exception -> L43
                    r3 = 0
                    r2.accept(r3)     // Catch: java.lang.Exception -> L43
                    goto L47
                L43:
                    r2 = move-exception
                    r2.printStackTrace()
                L47:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.fendasz.moku.planet.ui.activity.RewardTaskDetailActivity.AnonymousClass21.success(int, com.fendasz.moku.planet.source.bean.ClientDetailTaskData):void");
            }

            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void error(int i, String str) {
                LoadingDialog.dismiss();
                LogUtils.log(RewardTaskDetailActivity.TAG, "code:" + i + " message:" + str);
                Toast.makeText(RewardTaskDetailActivity.this.mContext, str, 0).show();
                try {
                    RewardTaskDetailActivity.access$3708(RewardTaskDetailActivity.this);
                    if (RewardTaskDetailActivity.this.mNumberOfAttempts < list.size()) {
                        RewardTaskDetailActivity.this.getTaskGroupDataList(list, consumer);
                    } else {
                        consumer.accept(null);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /* renamed from: lambda$showTaskGroupDialog$0$com-fendasz-moku-planet-ui-activity-RewardTaskDetailActivity, reason: not valid java name */
    /* synthetic */ void m415x227bdb63(TextView textView, CustomBuildDialog customBuildDialog) {
        customBuildDialog.dismiss();
        refresh(true, true);
    }

    /* renamed from: lambda$showTaskGroupDialog$1$com-fendasz-moku-planet-ui-activity-RewardTaskDetailActivity, reason: not valid java name */
    /* synthetic */ void m416xb6ba4b02(TextView textView, CustomBuildDialog customBuildDialog) {
        customBuildDialog.dismiss();
        refresh(true, false);
    }

    private void showTaskGroupDialog(String str, int i) {
        if (i == 0) {
            new CustomBuildDialog.DialogBuilder(this.mContext).setTitleImage(Integer.valueOf(R.drawable.moku_task_finished)).setTitleText("提交成功").setDetailText("预计<font color=\"#ff0000\">" + str + "</font>前审核完成\n是否继续下一个任务？").setRightBtn(getString(R.string.moku_btn_continue_task), new CustomBuildDialog.DialogButtonOnClickListener() { // from class: com.fendasz.moku.planet.ui.activity.RewardTaskDetailActivity$$ExternalSyntheticLambda2
                @Override // com.fendasz.moku.planet.ui.dialog.CustomBuildDialog.DialogButtonOnClickListener
                public final void onClick(TextView textView, CustomBuildDialog customBuildDialog) {
                    this.f$0.m415x227bdb63(textView, customBuildDialog);
                }
            }).setLeftBtn(getString(R.string.moku_btn_no), new CustomBuildDialog.DialogButtonOnClickListener() { // from class: com.fendasz.moku.planet.ui.activity.RewardTaskDetailActivity$$ExternalSyntheticLambda3
                @Override // com.fendasz.moku.planet.ui.dialog.CustomBuildDialog.DialogButtonOnClickListener
                public final void onClick(TextView textView, CustomBuildDialog customBuildDialog) {
                    this.f$0.m416xb6ba4b02(textView, customBuildDialog);
                }
            }).setCancelable(false).create().show();
        } else if (i == 1) {
            new CustomBuildDialog.DialogBuilder(this.mContext).setTitleImage(Integer.valueOf(R.drawable.moku_task_finished)).setTitleText("+" + getTaskDataMoney() + this.mClientDetailTaskData.getCybermoneyName()).setDetailText(getString(R.string.moku_task_reward_arrived)).setRightBtn(getString(R.string.moku_btn_continue_task), new CustomBuildDialog.DialogButtonOnClickListener() { // from class: com.fendasz.moku.planet.ui.activity.RewardTaskDetailActivity$$ExternalSyntheticLambda4
                @Override // com.fendasz.moku.planet.ui.dialog.CustomBuildDialog.DialogButtonOnClickListener
                public final void onClick(TextView textView, CustomBuildDialog customBuildDialog) {
                    this.f$0.m417x4af8baa1(textView, customBuildDialog);
                }
            }).setLeftBtn(getString(R.string.moku_btn_no), new CustomBuildDialog.DialogButtonOnClickListener() { // from class: com.fendasz.moku.planet.ui.activity.RewardTaskDetailActivity$$ExternalSyntheticLambda5
                @Override // com.fendasz.moku.planet.ui.dialog.CustomBuildDialog.DialogButtonOnClickListener
                public final void onClick(TextView textView, CustomBuildDialog customBuildDialog) {
                    this.f$0.m418xdf372a40(textView, customBuildDialog);
                }
            }).setCancelable(false).create().show();
        } else if (i == 2) {
            new CustomBuildDialog.DialogBuilder(this.mContext).setTitleImage(Integer.valueOf(R.drawable.moku_answer_incorrect)).setTitleText(getString(R.string.moku_answer_incorrect_title)).setDetailText(getString(R.string.moku_answer_incorrect_content_for_task_group)).setRightBtn(getString(R.string.moku_btn_continue_task), new CustomBuildDialog.DialogButtonOnClickListener() { // from class: com.fendasz.moku.planet.ui.activity.RewardTaskDetailActivity$$ExternalSyntheticLambda6
                @Override // com.fendasz.moku.planet.ui.dialog.CustomBuildDialog.DialogButtonOnClickListener
                public final void onClick(TextView textView, CustomBuildDialog customBuildDialog) {
                    this.f$0.m419x737599df(textView, customBuildDialog);
                }
            }).setLeftBtn(getString(R.string.moku_btn_no), new CustomBuildDialog.DialogButtonOnClickListener() { // from class: com.fendasz.moku.planet.ui.activity.RewardTaskDetailActivity$$ExternalSyntheticLambda7
                @Override // com.fendasz.moku.planet.ui.dialog.CustomBuildDialog.DialogButtonOnClickListener
                public final void onClick(TextView textView, CustomBuildDialog customBuildDialog) {
                    this.f$0.m420x7b4097e(textView, customBuildDialog);
                }
            }).setCancelable(false).create().show();
        }
    }

    /* renamed from: lambda$showTaskGroupDialog$2$com-fendasz-moku-planet-ui-activity-RewardTaskDetailActivity, reason: not valid java name */
    /* synthetic */ void m417x4af8baa1(TextView textView, CustomBuildDialog customBuildDialog) {
        customBuildDialog.dismiss();
        refresh(true, true);
    }

    /* renamed from: lambda$showTaskGroupDialog$3$com-fendasz-moku-planet-ui-activity-RewardTaskDetailActivity, reason: not valid java name */
    /* synthetic */ void m418xdf372a40(TextView textView, CustomBuildDialog customBuildDialog) {
        customBuildDialog.dismiss();
        refresh(true, false);
    }

    /* renamed from: lambda$showTaskGroupDialog$4$com-fendasz-moku-planet-ui-activity-RewardTaskDetailActivity, reason: not valid java name */
    /* synthetic */ void m419x737599df(TextView textView, CustomBuildDialog customBuildDialog) {
        customBuildDialog.dismiss();
        refresh(true, true);
    }

    /* renamed from: lambda$showTaskGroupDialog$5$com-fendasz-moku-planet-ui-activity-RewardTaskDetailActivity, reason: not valid java name */
    /* synthetic */ void m420x7b4097e(TextView textView, CustomBuildDialog customBuildDialog) {
        customBuildDialog.dismiss();
        refresh(true, false);
    }

    private String getTaskDataMoney() {
        List<ClientGroupTaskData> clientGroupTaskDataList = this.mClientDetailTaskData.getClientGroupTaskDataList();
        if (clientGroupTaskDataList != null && clientGroupTaskDataList.size() > 0) {
            for (int i = 0; i < clientGroupTaskDataList.size(); i++) {
                ClientGroupTaskData clientGroupTaskData = clientGroupTaskDataList.get(i);
                if (clientGroupTaskData.getTaskDataId().equals(this.mClientDetailTaskData.getTaskDataId())) {
                    return clientGroupTaskData.getShowMoney().toString();
                }
            }
        }
        return this.mClientDetailTaskData.getShowMoney().toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelTask(ClientDetailTaskData clientDetailTaskData, final com.fendasz.moku.planet.interf.functions.Consumer<TaskDataApplyRecord> consumer) {
        LoadingDialog.show(this.mContext);
        ApiDataHelper.getApiDataHelper().cancelTask(this.mContext, clientDetailTaskData, new ApiDataCallBack<TaskDataApplyRecord>() { // from class: com.fendasz.moku.planet.ui.activity.RewardTaskDetailActivity.22
            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void success(int i, TaskDataApplyRecord taskDataApplyRecord) throws Exception {
                LoadingDialog.dismiss();
                RewardTaskDetailActivity.this.setResult(300);
                com.fendasz.moku.planet.interf.functions.Consumer consumer2 = consumer;
                if (consumer2 != null) {
                    consumer2.accept(taskDataApplyRecord);
                }
            }

            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void error(int i, String str) throws Exception {
                LoadingDialog.dismiss();
                LogUtils.log(RewardTaskDetailActivity.TAG, "code:" + i + " message:" + str);
                Toast.makeText(RewardTaskDetailActivity.this.mContext, str + i, 1).show();
            }
        });
    }

    private boolean checkForm() {
        for (int i = 0; i < this.etFormList.size(); i++) {
            String string = this.etFormList.get(i).getText().toString();
            if (TextUtils.isEmpty(string)) {
                Toast.makeText(this.mContext, "请输入" + this.formDatas.get(i).getKey(), 0).show();
                return false;
            }
            if (this.formDatas.get(i).getKey().contains("手机") && (string.length() != 11 || !StringUtils.isNumber(string))) {
                Toast.makeText(this.mContext, "手机格式错误", 0).show();
                return false;
            }
            this.formDatas.get(i).setValue(string);
        }
        return true;
    }

    public void submitTask(final Action action) throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        List<EditText> list;
        AliyunHelper.getInstance().uploadDeviceToken(this.mContext, new AliyunHelper.SessionCallBack() { // from class: com.fendasz.moku.planet.ui.activity.RewardTaskDetailActivity.23
            @Override // com.fendasz.moku.planet.helper.AliyunHelper.SessionCallBack
            public void onSession(Integer num, String str, String str2) {
                if (7700 == num.intValue()) {
                    RewardTaskDetailActivity.this.showToast(str);
                }
            }
        });
        List<ImageView> list2 = this.ivUploadImageList;
        if ((list2 != null && list2.size() > 0) || ((list = this.etFormList) != null && list.size() > 0)) {
            if (!SharedPreferencesUtils.getInstance(this.mContext).getBoolean("isNotShowSubmitTaskTip", false)) {
                final CheckBox checkBox = (CheckBox) LayoutInflater.from(this.mContext).inflate(R.layout.moku_checkbox_is_not_show_submit_task_tip, (ViewGroup) null);
                checkBox.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
                checkBox.setText("以后不再提示");
                checkBox.setTextSize(this.mPhoneScreenUtils.getSmallTextSize(this.mContext));
                new CustomBuildDialog.DialogBuilder(this.mContext).setTitleImage(Integer.valueOf(R.drawable.moku_tips_icon)).setDetailText("截图禁止修改，请勿涂鸦、裁剪。搜索任务必须使用指定搜索词，否则无奖励。").setCustomView(checkBox).setCancelable(false).setLeftBtn("我再想想", new CustomBuildDialog.DialogButtonOnClickListener() { // from class: com.fendasz.moku.planet.ui.activity.RewardTaskDetailActivity.25
                    @Override // com.fendasz.moku.planet.ui.dialog.CustomBuildDialog.DialogButtonOnClickListener
                    public void onClick(TextView textView, CustomBuildDialog customBuildDialog) {
                        if (checkBox.isChecked()) {
                            SharedPreferencesUtils.getInstance(RewardTaskDetailActivity.this.mContext).putBoolean("isNotShowSubmitTaskTip", true);
                        }
                        customBuildDialog.dismiss();
                    }
                }).setRightBtn("确认提交", new CustomBuildDialog.DialogButtonOnClickListener() { // from class: com.fendasz.moku.planet.ui.activity.RewardTaskDetailActivity.24
                    @Override // com.fendasz.moku.planet.ui.dialog.CustomBuildDialog.DialogButtonOnClickListener
                    public void onClick(TextView textView, CustomBuildDialog customBuildDialog) {
                        if (checkBox.isChecked()) {
                            SharedPreferencesUtils.getInstance(RewardTaskDetailActivity.this.mContext).putBoolean("isNotShowSubmitTaskTip", true);
                        }
                        customBuildDialog.dismiss();
                        try {
                            action.run();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }).create().show();
                return;
            }
            try {
                action.run();
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        try {
            action.run();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void initLoad() {
        this.ivUploadImageList = new ArrayList();
        this.mllAnswerList = new ArrayList();
        this.etFormList = new ArrayList();
        this.formDatas = new ArrayList();
        this.updateFileMap = new TreeMap<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initDynamicViewListener() {
        TextView textView = this.mTvBtnCommentCopy;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.fendasz.moku.planet.ui.activity.RewardTaskDetailActivity.26
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (RewardTaskDetailActivity.this.mTvCommentContent == null || !RewardTaskDetailActivity.this.mTvCommentContent.isEnabled()) {
                        return;
                    }
                    try {
                        SystemUtils.copyToClipboard(RewardTaskDetailActivity.this.mContext, "comment", RewardTaskDetailActivity.this.mTvCommentContent.getText().toString());
                        Toast.makeText(RewardTaskDetailActivity.this.mContext, "评论已复制到剪贴板", 0).show();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        LinearLayout linearLayout = this.mllSearchTerms;
        if (linearLayout != null) {
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.fendasz.moku.planet.ui.activity.RewardTaskDetailActivity.27
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (RewardTaskDetailActivity.this.mTvSearchTerms != null) {
                        try {
                            SystemUtils.copyToClipboard(RewardTaskDetailActivity.this.mContext, "keyword", RewardTaskDetailActivity.this.mTvSearchTerms.getText().toString());
                            Toast.makeText(RewardTaskDetailActivity.this.mContext, "已复制搜索词", 0).show();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }
        List<ImageView> list = this.ivUploadImageList;
        if (list != null && list.size() > 0) {
            for (final int i = 0; i < this.ivUploadImageList.size(); i++) {
                this.ivUploadImageList.get(i).setOnClickListener(new View.OnClickListener() { // from class: com.fendasz.moku.planet.ui.activity.RewardTaskDetailActivity.28
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                        if (RewardTaskDetailActivity.this.mApiTaskOperationHelper.getOperationEnum() != OperationEnum.SUCCESS_SUBMIT) {
                            RewardTaskDetailActivity.this.showUiTips(1);
                            return;
                        }
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
                            ((TaskDetailActivity) RewardTaskDetailActivity.this.mContext).startActivityForResult(intent, i);
                        } catch (Exception unused) {
                            Log.d(RewardTaskDetailActivity.TAG, "no activity found");
                        }
                    }
                });
            }
        }
        List<LinearLayout> list2 = this.mllAnswerList;
        if (list2 != null && list2.size() > 0) {
            for (final int i2 = 0; i2 < this.mllAnswerList.size(); i2++) {
                final LinearLayout linearLayout2 = this.mllAnswerList.get(i2);
                linearLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.fendasz.moku.planet.ui.activity.RewardTaskDetailActivity.29
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
                        if (RewardTaskDetailActivity.this.mApiTaskOperationHelper.getOperationEnum() != OperationEnum.SUCCESS_SUBMIT) {
                            RewardTaskDetailActivity.this.showUiTips(5);
                            return;
                        }
                        RewardTaskDetailActivity.this.hideTips();
                        linearLayout2.setBackground(RewardTaskDetailActivity.this.getResources().getDrawable(R.drawable.moku_blue_circular_rectangle_shape));
                        HashMap map = RewardTaskDetailActivity.this.mClientDetailTaskData.getTaskData().getTaskDataDetail().getAnswerList().get(i2);
                        RewardTaskDetailActivity rewardTaskDetailActivity = RewardTaskDetailActivity.this;
                        rewardTaskDetailActivity.mTvAnswerError = (TextView) ((LinearLayout) rewardTaskDetailActivity.mllAnswerList.get(i2)).findViewById(R.id.tv_answer_error);
                        RewardTaskDetailActivity.this.mAnswer = (String) map.get("answer");
                        for (int i3 = 0; i3 < RewardTaskDetailActivity.this.mllAnswerList.size(); i3++) {
                            if (i3 != i2) {
                                ((LinearLayout) RewardTaskDetailActivity.this.mllAnswerList.get(i3)).setBackground(RewardTaskDetailActivity.this.getResources().getDrawable(R.drawable.moku_gray_border_rectangle_shape));
                            }
                        }
                        RewardTaskDetailActivity.this.checkAndSubmit(new Action() { // from class: com.fendasz.moku.planet.ui.activity.RewardTaskDetailActivity.29.1
                            @Override // io.reactivex.functions.Action
                            public void run() throws Exception {
                                RewardTaskDetailActivity.this.submitCpaTask();
                            }
                        });
                    }
                });
            }
        }
        Button button = this.mBtnSubmit;
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() { // from class: com.fendasz.moku.planet.ui.activity.RewardTaskDetailActivity.30
                @Override // android.view.View.OnClickListener
                public void onClick(View view) throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
                    if (RewardTaskDetailActivity.this.mApiTaskOperationHelper.getOperationEnum() != OperationEnum.SUCCESS_SUBMIT) {
                        RewardTaskDetailActivity.this.showUiTips(5);
                        return;
                    }
                    if (RewardTaskDetailActivity.this.mEtInput != null) {
                        if (TextUtils.isEmpty(RewardTaskDetailActivity.this.mEtInput.getText().toString().trim())) {
                            Toast.makeText(RewardTaskDetailActivity.this.mContext, "请选择或填写答案", 0).show();
                            return;
                        }
                        RewardTaskDetailActivity rewardTaskDetailActivity = RewardTaskDetailActivity.this;
                        rewardTaskDetailActivity.mAnswer = rewardTaskDetailActivity.mEtInput.getText().toString();
                        RewardTaskDetailActivity.this.checkAndSubmit(new Action() { // from class: com.fendasz.moku.planet.ui.activity.RewardTaskDetailActivity.30.1
                            @Override // io.reactivex.functions.Action
                            public void run() throws Exception {
                                RewardTaskDetailActivity.this.submitCpaTask();
                            }
                        });
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void submitCpaTask() throws NoSuchMethodException, SecurityException {
        LoadingDialog.show(this.mContext);
        MokuConfigure.getInstance().updateUserType(this.mContext, 2);
        MokuConfigure.getInstance().updateSubmitTaskDataId(this.mContext, this.mClientDetailTaskData.getTaskDataId());
        ApiDataHelper.getApiDataHelper().uploadDeviceInfo(this, new ApiDataCallBack<Object>() { // from class: com.fendasz.moku.planet.ui.activity.RewardTaskDetailActivity.31
            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void success(int i, Object obj) throws Exception {
                Log.d(RewardTaskDetailActivity.TAG, "upload device info success");
                RewardTaskDetailActivity.this.doSubmitCPATask();
            }

            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void error(int i, String str) throws Exception {
                LogUtils.logE(RewardTaskDetailActivity.TAG, "upload device info error,code=>" + i + ",message" + str);
                RewardTaskDetailActivity.this.doSubmitCPATask();
            }
        });
    }

    /* renamed from: com.fendasz.moku.planet.ui.activity.RewardTaskDetailActivity$32, reason: invalid class name */
    class AnonymousClass32 implements ApiDataCallBack<String> {
        AnonymousClass32() {
        }

        @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
        public void success(int i, String str) throws Exception {
            CpaData cpaData;
            LoadingDialog.dismiss();
            RewardTaskDetailActivity.this.setResult(300);
            if (RewardTaskDetailActivity.this.mllAnswerList != null) {
                for (int i2 = 0; i2 < RewardTaskDetailActivity.this.mllAnswerList.size(); i2++) {
                    ((LinearLayout) RewardTaskDetailActivity.this.mllAnswerList.get(i2)).setBackground(RewardTaskDetailActivity.this.getResources().getDrawable(R.drawable.moku_gray_border_rectangle_shape));
                }
            }
            if (TextUtils.isEmpty(str) || (cpaData = (CpaData) JSON.parseObject(str, CpaData.class)) == null) {
                return;
            }
            if (!cpaData.isFlag()) {
                if (cpaData.getCount().intValue() == 1) {
                    LogUtils.log(RewardTaskDetailActivity.TAG, "answer incorrect firstly");
                    RewardTaskDetailActivity.this.showAnswerTips();
                    return;
                } else {
                    if (cpaData.getCount().intValue() == 2) {
                        LogUtils.log(RewardTaskDetailActivity.TAG, "answer incorrect secondly");
                        if (RewardTaskDetailActivity.this.isTaskGroup) {
                            RewardTaskDetailActivity.this.submitTaskGroupInitSpAndDialog(null, 2);
                        } else {
                            new CustomBuildDialog.DialogBuilder(RewardTaskDetailActivity.this.mContext).setTitleImage(Integer.valueOf(R.drawable.moku_answer_incorrect)).setTitleText(RewardTaskDetailActivity.this.getString(R.string.moku_answer_incorrect_title)).setDetailText(RewardTaskDetailActivity.this.getString(R.string.moku_answer_incorrect_content)).setRightBtn(RewardTaskDetailActivity.this.getString(R.string.moku_btn_ok), new CustomBuildDialog.DialogButtonOnClickListener() { // from class: com.fendasz.moku.planet.ui.activity.RewardTaskDetailActivity$32$$ExternalSyntheticLambda0
                                @Override // com.fendasz.moku.planet.ui.dialog.CustomBuildDialog.DialogButtonOnClickListener
                                public final void onClick(TextView textView, CustomBuildDialog customBuildDialog) {
                                    this.f$0.m424x44a6fb1e(textView, customBuildDialog);
                                }
                            }).setCancelable(false).create().show();
                        }
                        RewardTaskDetailActivity.this.sendTaskSubmitBroadcast();
                        return;
                    }
                    return;
                }
            }
            LogUtils.log(RewardTaskDetailActivity.TAG, "answer right");
            RewardTaskDetailActivity.this.hideTips();
            if (RewardTaskDetailActivity.this.isTaskGroup) {
                RewardTaskDetailActivity.this.submitTaskGroupInitSpAndDialog(null, 1);
            } else {
                new CustomBuildDialog.DialogBuilder(RewardTaskDetailActivity.this.mContext).setTitleImage(Integer.valueOf(R.drawable.moku_task_finished)).setTitleText("+" + RewardTaskDetailActivity.this.mClientDetailTaskData.getShowMoney() + RewardTaskDetailActivity.this.mClientDetailTaskData.getCybermoneyName()).setDetailText(RewardTaskDetailActivity.this.getString(R.string.moku_task_continue_content)).setRightBtn(RewardTaskDetailActivity.this.getString(R.string.moku_btn_continue), new CustomBuildDialog.DialogButtonOnClickListener() { // from class: com.fendasz.moku.planet.ui.activity.RewardTaskDetailActivity$32$$ExternalSyntheticLambda1
                    @Override // com.fendasz.moku.planet.ui.dialog.CustomBuildDialog.DialogButtonOnClickListener
                    public final void onClick(TextView textView, CustomBuildDialog customBuildDialog) {
                        this.f$0.m425x9266731f(textView, customBuildDialog);
                    }
                }).setCancelable(false).create().show();
            }
            RewardTaskDetailActivity.this.sendTaskSubmitBroadcast();
        }

        /* renamed from: lambda$success$0$com-fendasz-moku-planet-ui-activity-RewardTaskDetailActivity$32, reason: not valid java name */
        /* synthetic */ void m424x44a6fb1e(TextView textView, CustomBuildDialog customBuildDialog) {
            customBuildDialog.dismiss();
            RewardTaskDetailActivity.this.finish();
        }

        /* renamed from: lambda$success$1$com-fendasz-moku-planet-ui-activity-RewardTaskDetailActivity$32, reason: not valid java name */
        /* synthetic */ void m425x9266731f(TextView textView, CustomBuildDialog customBuildDialog) {
            if (RewardTaskDetailActivity.this.operationType == 101) {
                RewardTaskDetailActivity.this.setResult(602);
                RewardTaskDetailActivity.this.finish();
            } else {
                customBuildDialog.dismiss();
                RewardTaskDetailActivity.this.putSpIsShowGuideMyParticipateInTip();
                RewardTaskDetailActivity.this.finish();
            }
        }

        @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
        public void error(int i, String str) throws Exception {
            LoadingDialog.dismiss();
            if (RewardTaskDetailActivity.this.mllAnswerList != null) {
                for (int i2 = 0; i2 < RewardTaskDetailActivity.this.mllAnswerList.size(); i2++) {
                    ((LinearLayout) RewardTaskDetailActivity.this.mllAnswerList.get(i2)).setBackground(RewardTaskDetailActivity.this.getResources().getDrawable(R.drawable.moku_gray_border_rectangle_shape));
                }
            }
            LogUtils.log(RewardTaskDetailActivity.TAG, "code:" + i + " message:" + str);
            Toast.makeText(RewardTaskDetailActivity.this.mContext, str + i, 1).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doSubmitCPATask() {
        ApiDataHelper.getApiDataHelper().submitTask(this.mContext, this.mClientDetailTaskData, (List<File>) null, (List<ClientTaskDataSubmitFormModel>) null, this.mAdditionalData, new AnonymousClass32());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendTaskSubmitBroadcast() {
        Intent intent = new Intent(this.mContext.getString(R.string.moku_broadcast_name_action_task_submit));
        intent.putExtra(this.mContext.getString(R.string.moku_intent_extra__submit_task), this.mClientDetailTaskData);
        intent.setPackage(getPackageName());
        sendBroadcast(intent);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void showMasking(View view, Bitmap bitmap, GuideDialog.Orientation orientation, Integer[] numArr, Integer[] numArr2, View view2) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void showAnswerTips() {
        TextView textView = this.mTvAnswerError;
        if (textView != null) {
            textView.setVisibility(0);
        }
        TextView textView2 = this.mTvAnswerErrorTip;
        if (textView2 != null) {
            textView2.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showErrorDialog(String str) {
        new CustomBuildDialog.DialogBuilder(this.mContext).setTitleImage(Integer.valueOf(R.drawable.moku_tips_icon)).setDetailText(str).setRightBtn(getString(R.string.moku_btn_ok), new CustomBuildDialog.DialogButtonOnClickListener() { // from class: com.fendasz.moku.planet.ui.activity.RewardTaskDetailActivity$$ExternalSyntheticLambda1
            @Override // com.fendasz.moku.planet.ui.dialog.CustomBuildDialog.DialogButtonOnClickListener
            public final void onClick(TextView textView, CustomBuildDialog customBuildDialog) {
                this.f$0.m413xa2b468cf(textView, customBuildDialog);
            }
        }).setCancelable(false).create().show();
    }

    /* renamed from: lambda$showErrorDialog$6$com-fendasz-moku-planet-ui-activity-RewardTaskDetailActivity, reason: not valid java name */
    /* synthetic */ void m413xa2b468cf(TextView textView, CustomBuildDialog customBuildDialog) {
        customBuildDialog.dismiss();
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideTips() {
        TextView textView = this.mTvAnswerError;
        if (textView != null) {
            textView.setVisibility(8);
        }
        TextView textView2 = this.mTvAnswerErrorTip;
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
    }

    private void showGoOnTaskDialog() {
        if (this.mTime != null) {
            CustomBuildDialog.DialogBuilder titleImage = new CustomBuildDialog.DialogBuilder(this.mContext).setTitleImage(Integer.valueOf(R.drawable.moku_tips_icon));
            if (this.mClientDetailTaskData.getClassify().equals("cpa") && !this.mClientDetailTaskData.getTaskData().getCpaType().equals(MokuConstants.CPA_TYPE_NORMAL)) {
                titleImage.setDetailText("试玩时间未到，还需试玩" + this.mTime + "分钟，即可提交答案");
            } else {
                titleImage.setDetailText("试玩时间未到，还需试玩" + this.mTime + "分钟，即可提交任务");
            }
            CustomBuildDialog customBuildDialog = this.mGoOnTaskDialog;
            if (customBuildDialog != null && customBuildDialog.isShowing()) {
                this.mGoOnTaskDialog.dismiss();
            }
            CustomBuildDialog customBuildDialogCreate = titleImage.setRightBtn("继续试玩", new CustomBuildDialog.DialogButtonOnClickListener() { // from class: com.fendasz.moku.planet.ui.activity.RewardTaskDetailActivity$$ExternalSyntheticLambda8
                @Override // com.fendasz.moku.planet.ui.dialog.CustomBuildDialog.DialogButtonOnClickListener
                public final void onClick(TextView textView, CustomBuildDialog customBuildDialog2) {
                    this.f$0.m414x846ab0f6(textView, customBuildDialog2);
                }
            }).setCancelable(true).create();
            this.mGoOnTaskDialog = customBuildDialogCreate;
            customBuildDialogCreate.show();
        }
    }

    /* renamed from: lambda$showGoOnTaskDialog$7$com-fendasz-moku-planet-ui-activity-RewardTaskDetailActivity, reason: not valid java name */
    /* synthetic */ void m414x846ab0f6(TextView textView, CustomBuildDialog customBuildDialog) {
        customBuildDialog.dismiss();
        executeTask();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void executeTask() {
        OperationEnum operationEnum = this.mApiTaskOperationHelper.getOperationEnum();
        if (operationEnum.equals(OperationEnum.SUCCESS_AUTO_INSTALL_APP) || operationEnum.equals(OperationEnum.SUCCESS_INSTALL_APP)) {
            showGalleryTipDialog(new Finish() { // from class: com.fendasz.moku.planet.ui.activity.RewardTaskDetailActivity.33
                @Override // com.fendasz.moku.planet.interf.Finish
                public void finish() {
                    if (RewardTaskDetailActivity.this.mApiTaskOperationHelper != null) {
                        RewardTaskDetailActivity.this.mApiTaskOperationHelper.executeTask(RewardTaskDetailActivity.this.mContext);
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
        dialogBuilder.setCustomView(imageView).setRightBtn(this.mContext.getString(R.string.moku_dialog_btn_text__i_know), new CustomBuildDialog.DialogButtonOnClickListener() { // from class: com.fendasz.moku.planet.ui.activity.RewardTaskDetailActivity.34
            @Override // com.fendasz.moku.planet.ui.dialog.CustomBuildDialog.DialogButtonOnClickListener
            public void onClick(TextView textView, CustomBuildDialog customBuildDialog) {
                customBuildDialog.dismiss();
                SharedPreferencesUtils.getInstance(RewardTaskDetailActivity.this.mContext).putBoolean(RewardTaskDetailActivity.this.mContext.getString(R.string.moku_sp_is_show_dialog_gallery_tip), false);
                Finish finish2 = finish;
                if (finish2 != null) {
                    finish2.finish();
                }
            }
        }).setCancelable(false).create().show();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) throws UnsupportedEncodingException {
        String uriPath;
        super.onActivityResult(i, i2, intent);
        if (50 == i) {
            loadUrl();
            refresh(false, false);
            return;
        }
        if (51 == i) {
            setResult(i2);
            finish();
            return;
        }
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
            this.updateFileMap.put(Integer.valueOf(i), fileCompressSize);
            String strEncodeToString = Base64.encodeToString(FileUtils.readFile(fileCompressSize), 0);
            try {
                strEncodeToString = URLEncoder.encode(strEncodeToString, "UTF-8");
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
            if (Build.VERSION.SDK_INT >= 19) {
                this.webView.evaluateJavascript("javascript:readFileSend('" + strEncodeToString + "'," + i + ")", new ValueCallback() { // from class: com.fendasz.moku.planet.ui.activity.RewardTaskDetailActivity$$ExternalSyntheticLambda0
                    @Override // android.webkit.ValueCallback
                    public final void onReceiveValue(Object obj) {
                        Log.d(RewardTaskDetailActivity.TAG, (String) obj);
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

    private void clearWebview() {
        this.webView.removeAllViews();
        this.mContentView.removeView(this.webView);
        this.webView.destroy();
        this.jsObjectListener.finish();
        this.webView = null;
    }

    @Override // com.fendasz.moku.planet.ui.base.activity.BaseBackActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
        CustomBuildDialog customBuildDialog = this.mGoOnTaskDialog;
        if (customBuildDialog != null && customBuildDialog.isShowing()) {
            this.mGoOnTaskDialog.dismiss();
        }
        ApiTaskOperationHelper apiTaskOperationHelper = this.mApiTaskOperationHelper;
        if (apiTaskOperationHelper != null) {
            apiTaskOperationHelper.onDestroy();
        }
        ClientDetailTaskData clientDetailTaskData = this.mClientDetailTaskData;
        if (clientDetailTaskData != null) {
            if ((clientDetailTaskData.getTaskDataApplyRecord() != null ? this.mClientDetailTaskData.getTaskDataApplyRecord().getStatus().intValue() : 66) == 0 && FloatingUtil.canDrawOverlays(this)) {
                this.isAddsuspendLayout = true;
                this.suspendLayout = FloatingUtil.getInstance().addBaseView(this, this.mClientDetailTaskData, new FloatingUtil.OnFloatingListener() { // from class: com.fendasz.moku.planet.ui.activity.RewardTaskDetailActivity.35
                    @Override // com.fendasz.moku.planet.utils.FloatingUtil.OnFloatingListener
                    public void onFloating() {
                        if (Build.VERSION.SDK_INT < 29) {
                            FloatingUtil.getInstance().moveAppToFront(RewardTaskDetailActivity.this.getApplication());
                        } else {
                            RewardTaskDetailActivity.this.startActivity(new Intent(RewardTaskDetailActivity.this, (Class<?>) RewardTaskDetailActivity.class));
                        }
                    }
                });
            }
        }
    }

    @Override // com.fendasz.moku.planet.ui.base.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        CustomBuildDialog customBuildDialog = this.mGoOnTaskDialog;
        if (customBuildDialog == null || !customBuildDialog.isShowing()) {
            return;
        }
        this.mGoOnTaskDialog.dismiss();
    }

    @Override // android.app.Activity
    protected void onRestart() throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        super.onRestart();
        ApiTaskOperationHelper apiTaskOperationHelper = this.mApiTaskOperationHelper;
        if (apiTaskOperationHelper != null) {
            apiTaskOperationHelper.onRestart(this.mContext);
        }
        onInitStatusComplete();
    }

    @Override // com.fendasz.moku.planet.ui.base.activity.BaseBackActivity, com.fendasz.moku.planet.ui.base.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        clearWebview();
        initCountDown();
        if (this.suspendLayout != null && this.isAddsuspendLayout) {
            ((WindowManager) getSystemService("window")).removeView(this.suspendLayout);
            this.isAddsuspendLayout = false;
        }
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
    public void showUiTips(int i) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        OperationEnum operationEnum = this.mApiTaskOperationHelper.getOperationEnum();
        if (i == 4) {
            this.mBtnStartTask.setVisibility(8);
            this.mLlOnTask.setVisibility(0);
            this.mPbDownload.setProgress(100);
        }
        switch (AnonymousClass54.$SwitchMap$com$fendasz$moku$planet$entity$OperationEnum[operationEnum.ordinal()]) {
            case 1:
                if (i == 4) {
                    Button button = this.mBtnStartTask;
                    if (button != null) {
                        button.setVisibility(0);
                    }
                    LinearLayout linearLayout = this.mLlOnTask;
                    if (linearLayout != null) {
                        linearLayout.setVisibility(8);
                    }
                }
                if (i == 1) {
                    Toast.makeText(this.mContext, "请先【开始任务】", 0).show();
                }
                if (i == 5) {
                    showMasking(this.mBtnStartTask, BitmapFactory.decodeResource(this.mContext.getResources(), R.drawable.moku_masking2), GuideDialog.Orientation.TOP_RIGHT, new Integer[]{Integer.valueOf(this.mPhoneScreenUtils.getScale(this.mContext, 10.0f)), Integer.valueOf(this.mPhoneScreenUtils.getScale(this.mContext, 10.0f)), Integer.valueOf(this.mPhoneScreenUtils.getScale(this.mContext, 10.0f)), Integer.valueOf(this.mPhoneScreenUtils.getScale(this.mContext, 10.0f))}, new Integer[]{Integer.valueOf(this.mPhoneScreenUtils.getScale(this.mContext, 0.0f)), Integer.valueOf(this.mPhoneScreenUtils.getScale(this.mContext, 150.0f)), Integer.valueOf(this.mPhoneScreenUtils.getScale(this.mContext, 20.0f)), Integer.valueOf(this.mPhoneScreenUtils.getScale(this.mContext, 0.0f))}, null);
                }
                if (i == 2 && this.mClientDetailTaskData.getClassify().equals("cpa") && getIsFirstCpaTask() && this.mBtnStartTask.isEnabled()) {
                    final LinearLayout linearLayout2 = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.moku_masking_button, (ViewGroup) null);
                    final TextView textView = (TextView) linearLayout2.findViewById(R.id.tv_btn_masking);
                    textView.setTextColor(this.mContext.getResources().getColor(R.color.white));
                    textView.setTextSize(this.mPhoneScreenUtils.getBigTextSize(this.mContext));
                    ScreenAdaptationUtils.setPaddingTopAndBottom(this.mContext, textView, 15);
                    ScreenAdaptationUtils.setPaddingLeftAndRight(this.mContext, textView, 70);
                    textView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.fendasz.moku.planet.ui.activity.RewardTaskDetailActivity.36
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            float height = textView.getHeight() / 2;
                            ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{height, height, height, height, height, height, height, height}, null, null));
                            shapeDrawable.getPaint().setColor(RewardTaskDetailActivity.this.mContext.getResources().getColor(R.color.white));
                            shapeDrawable.getPaint().setStyle(Paint.Style.STROKE);
                            shapeDrawable.getPaint().setStrokeWidth(2.0f);
                            textView.setBackground(shapeDrawable);
                        }
                    });
                    textView.setOnClickListener(new View.OnClickListener() { // from class: com.fendasz.moku.planet.ui.activity.RewardTaskDetailActivity.37
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (RewardTaskDetailActivity.this.mGuideDialog != null && RewardTaskDetailActivity.this.mGuideDialog.isShowing()) {
                                RewardTaskDetailActivity.this.mGuideDialog.dismiss();
                            }
                            RewardTaskDetailActivity.this.getTaskDataStatus(false);
                        }
                    });
                    this.mTvFlow.post(new Runnable() { // from class: com.fendasz.moku.planet.ui.activity.RewardTaskDetailActivity.38
                        @Override // java.lang.Runnable
                        public void run() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                            Integer[] numArr = {Integer.valueOf(RewardTaskDetailActivity.this.mPhoneScreenUtils.getScale(RewardTaskDetailActivity.this.mContext, 10.0f)), Integer.valueOf(RewardTaskDetailActivity.this.mPhoneScreenUtils.getScale(RewardTaskDetailActivity.this.mContext, 10.0f)), Integer.valueOf(RewardTaskDetailActivity.this.mPhoneScreenUtils.getScale(RewardTaskDetailActivity.this.mContext, 10.0f)), Integer.valueOf(RewardTaskDetailActivity.this.mPhoneScreenUtils.getScale(RewardTaskDetailActivity.this.mContext, 10.0f))};
                            Integer[] numArr2 = {Integer.valueOf(RewardTaskDetailActivity.this.mPhoneScreenUtils.getScale(RewardTaskDetailActivity.this.mContext, 20.0f)), Integer.valueOf(RewardTaskDetailActivity.this.mPhoneScreenUtils.getScale(RewardTaskDetailActivity.this.mContext, 20.0f)), Integer.valueOf(RewardTaskDetailActivity.this.mPhoneScreenUtils.getScale(RewardTaskDetailActivity.this.mContext, 20.0f)), Integer.valueOf(RewardTaskDetailActivity.this.mPhoneScreenUtils.getScale(RewardTaskDetailActivity.this.mContext, 20.0f))};
                            if (!RewardTaskDetailActivity.this.mClientDetailTaskData.getTaskData().getCpaType().equals(MokuConstants.CPA_TYPE_NORMAL)) {
                                RewardTaskDetailActivity rewardTaskDetailActivity = RewardTaskDetailActivity.this;
                                rewardTaskDetailActivity.showMasking(rewardTaskDetailActivity.mTvFlow, BitmapFactory.decodeResource(RewardTaskDetailActivity.this.mContext.getResources(), R.drawable.moku_masking1), GuideDialog.Orientation.BOTTOM_LEFT, numArr, numArr2, linearLayout2);
                                SharedPreferencesUtils.getInstance(RewardTaskDetailActivity.this.mContext).putBoolean("moku_first_cpa_answer_task", false);
                            } else {
                                RewardTaskDetailActivity rewardTaskDetailActivity2 = RewardTaskDetailActivity.this;
                                rewardTaskDetailActivity2.showMasking(rewardTaskDetailActivity2.mTvFlow, BitmapFactory.decodeResource(RewardTaskDetailActivity.this.mContext.getResources(), R.drawable.moku_masking_cpa_normal), GuideDialog.Orientation.BOTTOM_LEFT, numArr, numArr2, linearLayout2);
                                SharedPreferencesUtils.getInstance(RewardTaskDetailActivity.this.mContext).putBoolean("moku_first_cpa_normal_task", false);
                            }
                        }
                    });
                    break;
                }
                break;
            case 2:
                if (i == 4) {
                    for (int i2 = 0; i2 < this.etFormList.size(); i2++) {
                        this.etFormList.get(i2).setEnabled(true);
                    }
                    break;
                }
                break;
            case 3:
                if (i == 4 || i == 3) {
                    this.mTvDownload.setText("下载应用市场" + (TextUtils.isEmpty(this.mExpirationTime) ? "" : "\n任务剩余：" + getRemainTime()));
                    this.mTvDownload.setTextSize(this.mPhoneScreenUtils.getMiddleTextSize(this.mContext));
                    break;
                }
            case 4:
                if (i == 4 || i == 3) {
                    this.mTvDownload.setText("下载应用" + (TextUtils.isEmpty(this.mExpirationTime) ? "" : "\n任务剩余：" + getRemainTime()));
                    this.mTvDownload.setTextSize(this.mPhoneScreenUtils.getMiddleTextSize(this.mContext));
                }
                if (i == 0 || i == 1) {
                    Toast.makeText(this.mContext, "请先下载安装指定应用", 0).show();
                    break;
                }
            case 6:
                if (i == 4 || i == 3) {
                    this.mTvDownload.setText("继续下载" + (TextUtils.isEmpty(this.mExpirationTime) ? "" : "\n任务剩余：" + getRemainTime()));
                    this.mTvDownload.setTextSize(this.mPhoneScreenUtils.getMiddleTextSize(this.mContext));
                    break;
                }
            case 7:
                if (i == 4 || i == 3) {
                    this.mTvDownload.setText("继续下载" + (TextUtils.isEmpty(this.mExpirationTime) ? "" : "\n任务剩余：" + getRemainTime()));
                    this.mTvDownload.setTextSize(this.mPhoneScreenUtils.getMiddleTextSize(this.mContext));
                    break;
                }
            case 8:
                if (i == 4 || i == 3) {
                    this.mTvDownload.setText("打开应用市场" + (TextUtils.isEmpty(this.mExpirationTime) ? "" : "\n任务剩余：" + getRemainTime()));
                    this.mTvDownload.setTextSize(this.mPhoneScreenUtils.getMiddleTextSize(this.mContext));
                }
                if (i == 0 || i == 1) {
                    Toast.makeText(this.mContext, "请去应用市场下载指定软件，若您已经下载，请检查下载是否正确，软件为【" + this.mClientDetailTaskData.getTaskData().getTaskDataDetail().getAppName() + "】", 0).show();
                    break;
                }
            case 9:
                if (i == 4 || i == 3) {
                    this.mTvDownload.setText("打开应用" + (TextUtils.isEmpty(this.mExpirationTime) ? "" : "\n任务剩余：" + getRemainTime()));
                    this.mTvDownload.setTextSize(this.mPhoneScreenUtils.getMiddleTextSize(this.mContext));
                }
                if ((i == 0 || i == 1) && this.mClientDetailTaskData.getListenerTime() != null && this.mClientDetailTaskData.getListenerTime().intValue() > 0) {
                    if (this.mClientDetailTaskData.getClassify().equals("cpa") && !this.mClientDetailTaskData.getTaskData().getCpaType().equals(MokuConstants.CPA_TYPE_NORMAL)) {
                        Toast.makeText(this.mContext, "请先打开软件试玩" + this.mClientDetailTaskData.getListenerTime() + "s，即可答题", 0).show();
                    } else if (this.mClientDetailTaskData.getClassify().equals("cpa") && this.mClientDetailTaskData.getTaskData().getCpaType().equals(MokuConstants.CPA_TYPE_NORMAL)) {
                        Toast.makeText(this.mContext, "请先打开软件试玩" + this.mClientDetailTaskData.getListenerTime() + "s，即可获得奖励", 0).show();
                    } else {
                        Toast.makeText(this.mContext, "请先打开软件试玩" + this.mClientDetailTaskData.getListenerTime() + "s，即可上传图片", 0).show();
                    }
                }
                if (i == 5) {
                    Toast.makeText(this.mContext, "请先下载安装指定应用，并打开体验！", 0).show();
                    break;
                }
                break;
            case 10:
                if (i == 4 || i == 3) {
                    this.mTvDownload.setText("安装应用市场" + (TextUtils.isEmpty(this.mExpirationTime) ? "" : "\n任务剩余：" + getRemainTime()));
                    this.mTvDownload.setTextSize(this.mPhoneScreenUtils.getMiddleTextSize(this.mContext));
                    break;
                }
            case 11:
                if (i == 4 || i == 3) {
                    this.mTvDownload.setText("安装应用" + (TextUtils.isEmpty(this.mExpirationTime) ? "" : "\n任务剩余：" + getRemainTime()));
                    this.mTvDownload.setTextSize(this.mPhoneScreenUtils.getMiddleTextSize(this.mContext));
                }
                if (i == 0 || i == 1) {
                    Toast.makeText(this.mContext, "请先下载安装指定应用", 0).show();
                }
                if (i == 5) {
                    Toast.makeText(this.mContext, "请先下载安装指定应用，并打开体验！", 0).show();
                    break;
                }
                break;
            case 12:
                if (i == 4) {
                    this.mTvDownload.setText("安装应用" + (TextUtils.isEmpty(this.mExpirationTime) ? "" : "\n任务剩余：" + getRemainTime()));
                    this.mTvDownload.setTextSize(this.mPhoneScreenUtils.getMiddleTextSize(this.mContext));
                    executeTask();
                }
                if (i == 3) {
                    this.mTvDownload.setText("安装应用" + (TextUtils.isEmpty(this.mExpirationTime) ? "" : "\n任务剩余：" + getRemainTime()));
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
                    if (this.mClientDetailTaskData.getClassify().equals("cpa")) {
                        this.mTvDownload.setText("继续试玩" + (TextUtils.isEmpty(this.mExpirationTime) ? "" : "\n任务剩余：" + getRemainTime()));
                    } else {
                        this.mTvDownload.setText("提交任务" + (TextUtils.isEmpty(this.mExpirationTime) ? "" : "\n任务剩余：" + getRemainTime()));
                    }
                    this.mTvDownload.setTextSize(this.mPhoneScreenUtils.getMiddleTextSize(this.mContext));
                }
                if (i == 3) {
                    if (this.mClientDetailTaskData.getClassify().equals("cpa")) {
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
                    new CustomBuildDialog.DialogBuilder(this.mContext).setTitleImage(Integer.valueOf(R.drawable.moku_tips_icon)).setDetailText("您的任务已经超时啦~\n需要帮您重新开始么").setCancelable(false).setLeftBtn("不了", new CustomBuildDialog.DialogButtonOnClickListener() { // from class: com.fendasz.moku.planet.ui.activity.RewardTaskDetailActivity.40
                        @Override // com.fendasz.moku.planet.ui.dialog.CustomBuildDialog.DialogButtonOnClickListener
                        public void onClick(TextView textView2, CustomBuildDialog customBuildDialog2) {
                            customBuildDialog2.dismiss();
                            RewardTaskDetailActivity rewardTaskDetailActivity = RewardTaskDetailActivity.this;
                            rewardTaskDetailActivity.cancelTask(rewardTaskDetailActivity.mClientDetailTaskData, new com.fendasz.moku.planet.interf.functions.Consumer<TaskDataApplyRecord>() { // from class: com.fendasz.moku.planet.ui.activity.RewardTaskDetailActivity.40.1
                                @Override // com.fendasz.moku.planet.interf.functions.Consumer
                                public void accept(TaskDataApplyRecord taskDataApplyRecord) throws Exception {
                                    RewardTaskDetailActivity.this.cancelTaskCallBack(taskDataApplyRecord);
                                }
                            });
                        }
                    }).setRightBtn("重新开始", new CustomBuildDialog.DialogButtonOnClickListener() { // from class: com.fendasz.moku.planet.ui.activity.RewardTaskDetailActivity.39
                        @Override // com.fendasz.moku.planet.ui.dialog.CustomBuildDialog.DialogButtonOnClickListener
                        public void onClick(TextView textView2, CustomBuildDialog customBuildDialog2) {
                            customBuildDialog2.dismiss();
                            RewardTaskDetailActivity.this.getTaskDataStatus(false);
                        }
                    }).create().show();
                    break;
                }
            case 16:
                if (i == 2) {
                    this.mBtnStartTask.setVisibility(0);
                    this.mLlOnTask.setVisibility(8);
                    this.mBtnStartTask.setText(this.mContext.getString(R.string.moku_start_task_btn_text__take_up));
                    this.mBtnStartTask.setEnabled(false);
                    if (this.operationType != 101) {
                        Toast.makeText(this.mContext, "这个任务已经被抢完啦~", 0).show();
                        break;
                    }
                }
                break;
        }
    }

    /* renamed from: com.fendasz.moku.planet.ui.activity.RewardTaskDetailActivity$54, reason: invalid class name */
    static /* synthetic */ class AnonymousClass54 {
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

    private boolean getIsFirstCpaTask() {
        if (!this.mClientDetailTaskData.getClassify().equals("cpa")) {
            return false;
        }
        if (!this.mClientDetailTaskData.getTaskData().getCpaType().equals(MokuConstants.CPA_TYPE_NORMAL)) {
            return SharedPreferencesUtils.getInstance(this.mContext).getBoolean("moku_first_cpa_answer_task", true);
        }
        return SharedPreferencesUtils.getInstance(this.mContext).getBoolean("moku_first_cpa_normal_task", true);
    }

    @Override // com.fendasz.moku.planet.entity.ApiOperationCallBack
    public void taskStatus(OperationEnum operationEnum) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        LogUtils.log(TAG, "operationEnum >> code:" + operationEnum.getCode() + " message:" + operationEnum.getMessage());
        showUiTips(4);
    }

    @Override // com.fendasz.moku.planet.entity.ApiOperationCallBack
    public void downloadProgress(OperationEnum operationEnum, String str) {
        LogUtils.log(TAG, "operationEnum >> " + operationEnum.getCode() + ":" + operationEnum.getMessage() + " progress >> " + str);
        int i = (int) Double.parseDouble(str);
        String str2 = i + "%";
        if (this.mClientDetailTaskData.getClassify().equals("keyword") || this.mClientDetailTaskData.getClassify().equals("comment")) {
            this.mTvDownload.setText("下载应用市场 " + str2);
        } else {
            this.mTvDownload.setText("下载应用 " + str2);
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

    @Override // com.fendasz.moku.planet.entity.ApiOperationCallBack
    public void copyContent(OperationEnum operationEnum, String str) {
        LogUtils.log(TAG, "operationEnum >> " + operationEnum.getCode() + ":" + operationEnum.getMessage() + " content " + str);
        try {
            SystemUtils.copyToClipboard(this.mContext, "keyword", str);
            Toast.makeText(this.mContext, "已复制搜索词", 0).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void back() {
        finish();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            back();
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void initWebView() {
        Log.d(TAG, "initWebView==>");
        WebView webView = this.webView;
        if (webView != null) {
            this.mContentView.removeView(webView);
        }
        this.webView = new WebView(this.mContext);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
        layoutParams.weight = 12.0f;
        this.webView.setLayoutParams(layoutParams);
        this.mContentView.addView(this.webView, 0);
        WebSettings settings = this.webView.getSettings();
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
        settings.setPluginState(WebSettings.PluginState.ON);
        MokuJsObject mokuJsObject = new MokuJsObject();
        initJsObjectListener();
        mokuJsObject.setOnMokuJsListener(this.jsObjectListener);
        this.webView.addJavascriptInterface(mokuJsObject, "android");
        this.webView.setWebViewClient(new WebViewClient() { // from class: com.fendasz.moku.planet.ui.activity.RewardTaskDetailActivity.41
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
                    Log.d(RewardTaskDetailActivity.TAG, "request==>,errorCode==" + webResourceError.getErrorCode() + ",errorMsg=>" + ((Object) webResourceError.getDescription()) + i.d);
                }
            }
        });
        if (Build.VERSION.SDK_INT >= 19) {
            ApplicationInfo applicationInfo = getApplicationInfo();
            int i = 2 & applicationInfo.flags;
            applicationInfo.flags = i;
            if (i != 0) {
                WebView.setWebContentsDebuggingEnabled(true);
            }
        }
        loadUrl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadUrl() {
        Log.d(TAG, "loadUrl start");
        String str = DATA_DETAILURL_DEBUG + "?type=1";
        String str2 = 101 == this.operationType ? DATA_DETAILURL_RELEASE + "?type=1" : DATA_DETAILURL_RELEASE;
        Log.d(TAG, "webview load url=>" + str2);
        this.webView.loadUrl(str2);
    }

    private void initLlOptionsView() {
        RelativeLayout rlContentBottom = ((RewardTaskDetailActivity) this.mContext).getRlContentBottom();
        rlContentBottom.setVisibility(0);
        RelativeLayout relativeLayout = new RelativeLayout(this.mContext);
        this.mRlOptionsContainer = relativeLayout;
        rlContentBottom.addView(relativeLayout);
        this.mRlOptionsContainer.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.mRlOptionsContainer.setVisibility(8);
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.moku_image_options, (ViewGroup) this.mRlOptionsContainer, false);
        this.mLlOptions = linearLayout;
        this.mRlOptionsContainer.addView(linearLayout);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        this.mLlOptions.setLayoutParams(layoutParams);
        LinearLayout linearLayout2 = (LinearLayout) this.mLlOptions.findViewById(R.id.ll_save);
        ScreenAdaptationUtils.setPaddingTopAndBottom(this.mContext, linearLayout2, 20, 20);
        LinearLayout linearLayout3 = (LinearLayout) this.mLlOptions.findViewById(R.id.ll_we_chat);
        this.mLlWeChat = linearLayout3;
        ScreenAdaptationUtils.setPaddingTopAndBottom(this.mContext, linearLayout3, 20, 20);
        LinearLayout linearLayout4 = (LinearLayout) this.mLlOptions.findViewById(R.id.ll_browser);
        this.mLlBrowser = linearLayout4;
        ScreenAdaptationUtils.setPaddingTopAndBottom(this.mContext, linearLayout4, 20, 20);
        ScreenAdaptationUtils.setSize(this.mContext, (ImageView) this.mLlOptions.findViewById(R.id.iv_save), 100, 100);
        ScreenAdaptationUtils.setSize(this.mContext, (ImageView) this.mLlOptions.findViewById(R.id.iv_we_chat), 100, 100);
        ScreenAdaptationUtils.setSize(this.mContext, (ImageView) this.mLlOptions.findViewById(R.id.iv_browser), 100, 100);
        TextView textView = (TextView) this.mLlOptions.findViewById(R.id.tv_save);
        textView.setTextSize(this.mPhoneScreenUtils.getMiddleTextSize(this.mContext));
        ScreenAdaptationUtils.setMarginTop(this.mContext, textView, 10);
        TextView textView2 = (TextView) this.mLlOptions.findViewById(R.id.tv_we_chat);
        textView2.setTextSize(this.mPhoneScreenUtils.getMiddleTextSize(this.mContext));
        ScreenAdaptationUtils.setMarginTop(this.mContext, textView2, 10);
        TextView textView3 = (TextView) this.mLlOptions.findViewById(R.id.tv_browser);
        textView3.setTextSize(this.mPhoneScreenUtils.getMiddleTextSize(this.mContext));
        ScreenAdaptationUtils.setMarginTop(this.mContext, textView3, 10);
        TextView textView4 = (TextView) this.mLlOptions.findViewById(R.id.tv_cancel);
        ScreenAdaptationUtils.setPaddingTopAndBottom(this.mContext, textView4, 20);
        textView4.setTextSize(this.mPhoneScreenUtils.getBigTextSize(this.mContext));
        initLlOptionsListener(linearLayout2, this.mLlWeChat, this.mLlBrowser, textView4);
    }

    private void initLlOptionsListener(LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, TextView textView) {
        RelativeLayout relativeLayout = this.mRlOptionsContainer;
        if (relativeLayout != null) {
            relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.fendasz.moku.planet.ui.activity.RewardTaskDetailActivity.42
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    RewardTaskDetailActivity.this.mRlOptionsContainer.setVisibility(8);
                }
            });
        }
        LinearLayout linearLayout4 = this.mLlOptions;
        if (linearLayout4 != null) {
            linearLayout4.setOnTouchListener(new View.OnTouchListener() { // from class: com.fendasz.moku.planet.ui.activity.RewardTaskDetailActivity.43
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    return true;
                }
            });
        }
        if (linearLayout != null) {
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.fendasz.moku.planet.ui.activity.RewardTaskDetailActivity.44
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    RewardTaskDetailActivity.this.saveBitmap("保存成功", "保存失败");
                    if (RewardTaskDetailActivity.this.mRlOptionsContainer != null) {
                        RewardTaskDetailActivity.this.mRlOptionsContainer.setVisibility(8);
                    }
                }
            });
        }
        if (linearLayout2 != null) {
            linearLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.fendasz.moku.planet.ui.activity.RewardTaskDetailActivity.45
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (RewardTaskDetailActivity.this.mRlOptionsContainer != null) {
                        RewardTaskDetailActivity.this.mRlOptionsContainer.setVisibility(8);
                    }
                    RewardTaskDetailActivity.this.showQrCodeScanTipDialog(new com.fendasz.moku.planet.interf.functions.Action() { // from class: com.fendasz.moku.planet.ui.activity.RewardTaskDetailActivity.45.1
                        @Override // com.fendasz.moku.planet.interf.functions.Action
                        public void run() throws Exception {
                            RewardTaskDetailActivity.this.saveBitmap("图片已保存", "图片保存失败");
                            if (WeChatUtils.openWeChatQrCode(RewardTaskDetailActivity.this.mContext)) {
                                return;
                            }
                            Toast.makeText(RewardTaskDetailActivity.this.mContext, "请先安装微信", 0).show();
                        }
                    });
                }
            });
        }
        if (linearLayout3 != null) {
            linearLayout3.setOnClickListener(new View.OnClickListener() { // from class: com.fendasz.moku.planet.ui.activity.RewardTaskDetailActivity.46
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (RewardTaskDetailActivity.this.mRlOptionsContainer != null) {
                        RewardTaskDetailActivity.this.mRlOptionsContainer.setVisibility(8);
                    }
                    RewardTaskDetailActivity.this.showQrCodeScanTipDialog(new com.fendasz.moku.planet.interf.functions.Action() { // from class: com.fendasz.moku.planet.ui.activity.RewardTaskDetailActivity.46.1
                        @Override // com.fendasz.moku.planet.interf.functions.Action
                        public void run() throws Exception {
                            RewardTaskDetailActivity.this.saveBitmap("图片已保存", "图片保存失败");
                            if (TextUtils.isEmpty(RewardTaskDetailActivity.this.currentUrl)) {
                                return;
                            }
                            LogUtils.log(RewardTaskDetailActivity.TAG, "开始打开浏览器，链接：" + RewardTaskDetailActivity.this.currentUrl);
                            SystemUtils.openBrowser(RewardTaskDetailActivity.this.mContext, RewardTaskDetailActivity.this.currentUrl);
                        }
                    });
                }
            });
        }
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.fendasz.moku.planet.ui.activity.RewardTaskDetailActivity.47
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (RewardTaskDetailActivity.this.mRlOptionsContainer != null) {
                        RewardTaskDetailActivity.this.mRlOptionsContainer.setVisibility(8);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveBitmap(String str, String str2) {
        Bitmap bitmap = this.currentBitmap;
        if (bitmap != null) {
            if (StorageUtils.saveBitmap(this.mContext, bitmap, "screenShot_" + System.currentTimeMillis() + PictureMimeType.JPG)) {
                Toast.makeText(this.mContext, str, 0).show();
            } else {
                Toast.makeText(this.mContext, str2, 0).show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showQrCodeScanTipDialog(final com.fendasz.moku.planet.interf.functions.Action action) {
        final SharedPreferencesUtils sharedPreferencesUtils = SharedPreferencesUtils.getInstance(this.mContext);
        if (sharedPreferencesUtils.getBoolean(this.mContext.getString(R.string.moku_sp_is_show_qr_code_scan_tip), true)) {
            new CustomBuildDialog.DialogBuilder(this.mContext).setCancelable(false).setTitleImage(Integer.valueOf(R.drawable.moku_tips_icon)).setDetailText(this.mContext.getString(R.string.moku_dialog_detail_text_qr_code_scan_tip)).setRightBtn(this.mContext.getString(R.string.moku_dialog_btn_text__i_know), new CustomBuildDialog.DialogButtonOnClickListener() { // from class: com.fendasz.moku.planet.ui.activity.RewardTaskDetailActivity.48
                @Override // com.fendasz.moku.planet.ui.dialog.CustomBuildDialog.DialogButtonOnClickListener
                public void onClick(TextView textView, CustomBuildDialog customBuildDialog) {
                    sharedPreferencesUtils.putBoolean(RewardTaskDetailActivity.this.mContext.getString(R.string.moku_sp_is_show_qr_code_scan_tip), false);
                    customBuildDialog.dismiss();
                    try {
                        action.run();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).create().show();
            return;
        }
        try {
            action.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: com.fendasz.moku.planet.ui.activity.RewardTaskDetailActivity$49, reason: invalid class name */
    class AnonymousClass49 extends MokuJsObjectListenerImpl {
        AnonymousClass49(Context context) {
            super(context);
        }

        @Override // com.fendasz.moku.planet.common.MokuJsObjectListenerImpl, com.fendasz.moku.planet.common.MokuJsObject.OnMokuJsListener
        public void refreshData() {
            RewardTaskDetailActivity.this.loadUrl();
            RewardTaskDetailActivity.this.refresh(false, false);
        }

        @Override // com.fendasz.moku.planet.common.MokuJsObjectListenerImpl
        protected void bottomVisibility(boolean z) {
            super.bottomVisibility(z);
            if (z) {
                RewardTaskDetailActivity.this.bottomLayout.setVisibility(0);
            } else {
                RewardTaskDetailActivity.this.bottomLayout.setVisibility(8);
            }
        }

        @Override // com.fendasz.moku.planet.common.MokuJsObjectListenerImpl, com.fendasz.moku.planet.common.MokuJsObject.OnMokuJsListener
        public void showScreenImage(String str) {
            ImageUtils.getInstance().setImageView(RewardTaskDetailActivity.this.mContext, str, new com.fendasz.moku.planet.interf.functions.Consumer<Bitmap>() { // from class: com.fendasz.moku.planet.ui.activity.RewardTaskDetailActivity.49.1
                @Override // com.fendasz.moku.planet.interf.functions.Consumer
                public void accept(Bitmap bitmap) throws Exception {
                    new ViewImageDialog.Builder(RewardTaskDetailActivity.this.mContext).setBitmap(bitmap).create().show();
                }
            }, Float.valueOf(RewardTaskDetailActivity.this.mPhoneScreenUtils.getWidthPixels(RewardTaskDetailActivity.this.mContext)), Float.valueOf(RewardTaskDetailActivity.this.mPhoneScreenUtils.getHeightPixels(RewardTaskDetailActivity.this.mContext)));
        }

        @Override // com.fendasz.moku.planet.common.MokuJsObjectListenerImpl
        public String taskDataId() {
            return String.valueOf(RewardTaskDetailActivity.this.mTaskDataId);
        }

        @Override // com.fendasz.moku.planet.common.MokuJsObjectListenerImpl
        public void onImageClick(String str, final boolean z) {
            super.onImageClick(str, z);
            ImageUtils.getInstance().setImageView(RewardTaskDetailActivity.this.mContext, str, new com.fendasz.moku.planet.interf.functions.Consumer<Bitmap>() { // from class: com.fendasz.moku.planet.ui.activity.RewardTaskDetailActivity.49.2
                @Override // com.fendasz.moku.planet.interf.functions.Consumer
                public void accept(Bitmap bitmap) throws Exception {
                    new ViewImageDialog.Builder(RewardTaskDetailActivity.this.mContext).setBitmap(bitmap).setIsMiniProgrammer(z).isReward(true).create().show();
                }
            }, null, null);
        }

        @Override // com.fendasz.moku.planet.common.MokuJsObjectListenerImpl
        public void onImageLongClick(String str, final boolean z) {
            super.onImageLongClick(str, z);
            RewardTaskDetailActivity.this.mRlOptionsContainer.setVisibility(0);
            RewardTaskDetailActivity.this.mLlWeChat.setVisibility(4);
            RewardTaskDetailActivity.this.mLlBrowser.setVisibility(4);
            ImageUtils.getInstance().setImageView(RewardTaskDetailActivity.this.mContext, str, new com.fendasz.moku.planet.interf.functions.Consumer<Bitmap>() { // from class: com.fendasz.moku.planet.ui.activity.RewardTaskDetailActivity.49.3
                @Override // com.fendasz.moku.planet.interf.functions.Consumer
                public void accept(final Bitmap bitmap) throws Exception {
                    RewardTaskDetailActivity.this.mRlOptionsContainer.setVisibility(0);
                    RewardTaskDetailActivity.this.currentBitmap = bitmap;
                    if (z) {
                        LogUtils.log(RewardTaskDetailActivity.TAG, "is mini programmer");
                        RewardTaskDetailActivity.this.mLlWeChat.setVisibility(0);
                        RewardTaskDetailActivity.this.mLlBrowser.setVisibility(0);
                    }
                    new Thread(new Runnable() { // from class: com.fendasz.moku.planet.ui.activity.RewardTaskDetailActivity.49.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            RewardTaskDetailActivity.this.currentUrl = QrCodeUtils.parseQrCode(bitmap);
                        }
                    }).start();
                }
            }, null, null);
        }

        @Override // com.fendasz.moku.planet.common.MokuJsObjectListenerImpl
        public void openPhoneAlbum(int i) {
            super.openPhoneAlbum(i);
            Intent intent = new Intent("android.intent.action.GET_CONTENT");
            intent.setType(SelectMimeType.SYSTEM_IMAGE);
            intent.addCategory("android.intent.category.OPENABLE");
            intent.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            intent.addCategory("android.intent.category.OPENABLE");
            try {
                ((RewardTaskDetailActivity) RewardTaskDetailActivity.this.mContext).startActivityForResult(intent, i);
            } catch (Exception unused) {
                Log.d(RewardTaskDetailActivity.TAG, "no activity found");
            }
        }

        @Override // com.fendasz.moku.planet.common.MokuJsObjectListenerImpl
        public void submitTaskData(String str) throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
            super.submitTaskData(str);
            if (str == null || TextUtils.isEmpty(str)) {
                return;
            }
            try {
                RewardTaskDetailActivity.this.formDatas = JSON.parseArray(str, ClientTaskDataSubmitFormModel.class);
            } catch (Exception unused) {
            }
            RewardTaskDetailActivity.this.submitTask(new Action() { // from class: com.fendasz.moku.planet.ui.activity.RewardTaskDetailActivity.49.4
                @Override // io.reactivex.functions.Action
                public void run() throws Exception {
                    if (!SharedPreferencesUtils.getInstance(RewardTaskDetailActivity.this.mContext).getBoolean("isNotShowSubmitTaskTip", false)) {
                        final CheckBox checkBox = (CheckBox) LayoutInflater.from(RewardTaskDetailActivity.this.mContext).inflate(R.layout.moku_checkbox_is_not_show_submit_task_tip, (ViewGroup) null);
                        checkBox.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
                        checkBox.setText("以后不再提示");
                        checkBox.setTextSize(RewardTaskDetailActivity.this.mPhoneScreenUtils.getSmallTextSize(RewardTaskDetailActivity.this.mContext));
                        new CustomBuildDialog.DialogBuilder(RewardTaskDetailActivity.this.mContext).setTitleImage(Integer.valueOf(R.drawable.moku_tips_icon)).setDetailText("1、禁止提交与任务无关截图，情节严重者将封号处理<br/>2、如若审核失败，可在”我参与的-未通过”中进行申诉").setCustomView(checkBox).setCancelable(false).setLeftBtn("我再想想", new CustomBuildDialog.DialogButtonOnClickListener() { // from class: com.fendasz.moku.planet.ui.activity.RewardTaskDetailActivity.49.4.2
                            @Override // com.fendasz.moku.planet.ui.dialog.CustomBuildDialog.DialogButtonOnClickListener
                            public void onClick(TextView textView, CustomBuildDialog customBuildDialog) {
                                if (checkBox.isChecked()) {
                                    SharedPreferencesUtils.getInstance(RewardTaskDetailActivity.this.mContext).putBoolean("isNotShowSubmitTaskTip", true);
                                }
                                customBuildDialog.dismiss();
                            }
                        }).setRightBtn("确认提交", new CustomBuildDialog.DialogButtonOnClickListener() { // from class: com.fendasz.moku.planet.ui.activity.RewardTaskDetailActivity.49.4.1
                            @Override // com.fendasz.moku.planet.ui.dialog.CustomBuildDialog.DialogButtonOnClickListener
                            public void onClick(TextView textView, CustomBuildDialog customBuildDialog) {
                                if (checkBox.isChecked()) {
                                    SharedPreferencesUtils.getInstance(RewardTaskDetailActivity.this.mContext).putBoolean("isNotShowSubmitTaskTip", true);
                                }
                                customBuildDialog.dismiss();
                                try {
                                    RewardTaskDetailActivity.this.submitNormalTask();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        }).create().show();
                        return;
                    }
                    RewardTaskDetailActivity.this.submitNormalTask();
                }
            });
        }

        @Override // com.fendasz.moku.planet.common.MokuJsObjectListenerImpl, com.fendasz.moku.planet.common.MokuJsObject.OnMokuJsListener
        public Integer taskApplyRecordState() {
            Integer status;
            return (RewardTaskDetailActivity.this.mClientDetailTaskData == null || RewardTaskDetailActivity.this.mClientDetailTaskData.getTaskDataApplyRecord() == null || (status = RewardTaskDetailActivity.this.mClientDetailTaskData.getTaskDataApplyRecord().getStatus()) == null) ? super.taskApplyRecordState() : status;
        }

        @Override // com.fendasz.moku.planet.common.MokuJsObjectListenerImpl, com.fendasz.moku.planet.common.MokuJsObject.OnMokuJsListener
        public Integer taskSubmitRecordId() {
            return Integer.valueOf(RewardTaskDetailActivity.this.mTaskDataId);
        }

        @Override // com.fendasz.moku.planet.common.MokuJsObjectListenerImpl
        protected void submitArbitrationTask(String str) {
            super.submitArbitrationTask(str);
            if (str == null || TextUtils.isEmpty(str)) {
                return;
            }
            try {
                H5SubmitTaskData h5SubmitTaskData = (H5SubmitTaskData) JSON.parseObject(str, H5SubmitTaskData.class);
                RewardTaskDetailActivity.this.submitAppealTask(h5SubmitTaskData.getSubmitRecordId().intValue(), h5SubmitTaskData.getFromlist(), h5SubmitTaskData.getReason());
            } catch (Exception e) {
                e.printStackTrace();
                RewardTaskDetailActivity.this.showToast("提交失败,请重试");
            }
        }

        @Override // com.fendasz.moku.planet.common.MokuJsObjectListenerImpl
        protected void notifyH5Token(int i, String str) {
            super.notifyH5Token(i, str);
            if (Build.VERSION.SDK_INT >= 19) {
                RewardTaskDetailActivity.this.webView.evaluateJavascript("javascript:androidToken(" + i + ",'" + str + "')", new ValueCallback() { // from class: com.fendasz.moku.planet.ui.activity.RewardTaskDetailActivity$49$$ExternalSyntheticLambda0
                    @Override // android.webkit.ValueCallback
                    public final void onReceiveValue(Object obj) {
                        Log.d(RewardTaskDetailActivity.TAG, (String) obj);
                    }
                });
            } else {
                RewardTaskDetailActivity.this.webView.loadUrl("javascript:androidToken(" + i + ",'" + str + "')");
            }
        }
    }

    private void initJsObjectListener() {
        this.jsObjectListener = new AnonymousClass49(this.mContext);
    }

    @Override // com.fendasz.moku.planet.ui.base.activity.BaseActivity
    public void acceptLightData(float f) throws NoSuchMethodException, SecurityException {
        super.acceptLightData(f);
        MokuConfigure.getInstance().updateOptical(this.mContext, String.valueOf(f));
    }

    private void showOpenFirstGuide() {
        final LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.moku_masking_button, (ViewGroup) null);
        final TextView textView = (TextView) linearLayout.findViewById(R.id.tv_btn_masking);
        textView.setTextColor(this.mContext.getResources().getColor(R.color.white));
        textView.setTextSize(this.phoneScreenUtils.getBigTextSize(this.mContext));
        textView.setText(this.mContext.getString(R.string.moku_btn_ok));
        ScreenAdaptationUtils.setPaddingTopAndBottom(this.mContext, textView, 15);
        ScreenAdaptationUtils.setPaddingLeftAndRight(this.mContext, textView, 70);
        textView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.fendasz.moku.planet.ui.activity.RewardTaskDetailActivity.50
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                float height = textView.getHeight() / 2;
                ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{height, height, height, height, height, height, height, height}, null, null));
                shapeDrawable.getPaint().setColor(RewardTaskDetailActivity.this.mContext.getResources().getColor(R.color.white));
                shapeDrawable.getPaint().setStyle(Paint.Style.STROKE);
                shapeDrawable.getPaint().setStrokeWidth(2.0f);
                textView.setBackground(shapeDrawable);
            }
        });
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.fendasz.moku.planet.ui.activity.RewardTaskDetailActivity.51
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SharedPreferencesUtils.getInstance(RewardTaskDetailActivity.this.mContext).putBoolean(RewardTaskDetailActivity.this.getString(R.string.moku_sp_is_open_first_at_rewardtask), false);
                if (RewardTaskDetailActivity.this.mGuideDialog != null && RewardTaskDetailActivity.this.mGuideDialog.isShowing()) {
                    RewardTaskDetailActivity.this.mGuideDialog.dismiss();
                }
                RewardTaskDetailActivity.this.getTaskDetail(false, false, false, new Success<ClientDetailTaskData>() { // from class: com.fendasz.moku.planet.ui.activity.RewardTaskDetailActivity.51.1
                    @Override // com.fendasz.moku.planet.interf.Success
                    public void success(Integer num, ClientDetailTaskData clientDetailTaskData) {
                        if (TextUtils.isEmpty(RewardTaskDetailActivity.this.mGateType) || clientDetailTaskData == null) {
                            return;
                        }
                        LogUtils.log(RewardTaskDetailActivity.TAG, "postGateType " + RewardTaskDetailActivity.this.mGateType);
                        ApiDataHelper.getApiDataHelper().postGateType(RewardTaskDetailActivity.this.mContext, RewardTaskDetailActivity.this.mGateType, clientDetailTaskData.getTaskDataId(), new ApiDataCallBack<Object>() { // from class: com.fendasz.moku.planet.ui.activity.RewardTaskDetailActivity.51.1.1
                            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
                            public void success(int i, Object obj) throws Exception {
                                LogUtils.log(RewardTaskDetailActivity.TAG, "postGateType success");
                            }

                            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
                            public void error(int i, String str) throws Exception {
                                LogUtils.log(RewardTaskDetailActivity.TAG, "postGateType error >> " + str);
                            }
                        });
                    }
                });
            }
        });
        this.rightImageView.post(new Runnable() { // from class: com.fendasz.moku.planet.ui.activity.RewardTaskDetailActivity.52
            @Override // java.lang.Runnable
            public void run() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                if (RewardTaskDetailActivity.this.rightImageView == null || linearLayout == null) {
                    return;
                }
                Integer[] numArr = {Integer.valueOf(RewardTaskDetailActivity.this.phoneScreenUtils.getScale(RewardTaskDetailActivity.this.mContext, 0.0f)), Integer.valueOf(RewardTaskDetailActivity.this.phoneScreenUtils.getScale(RewardTaskDetailActivity.this.mContext, 0.0f)), Integer.valueOf(RewardTaskDetailActivity.this.phoneScreenUtils.getScale(RewardTaskDetailActivity.this.mContext, 0.0f)), Integer.valueOf(RewardTaskDetailActivity.this.phoneScreenUtils.getScale(RewardTaskDetailActivity.this.mContext, 0.0f))};
                Integer[] numArr2 = {Integer.valueOf(RewardTaskDetailActivity.this.phoneScreenUtils.getScale(RewardTaskDetailActivity.this.mContext, 10.0f)), Integer.valueOf(RewardTaskDetailActivity.this.phoneScreenUtils.getScale(RewardTaskDetailActivity.this.mContext, 50.0f)), Integer.valueOf(RewardTaskDetailActivity.this.phoneScreenUtils.getScale(RewardTaskDetailActivity.this.mContext, 0.0f)), Integer.valueOf(RewardTaskDetailActivity.this.phoneScreenUtils.getScale(RewardTaskDetailActivity.this.mContext, 50.0f))};
                SharedPreferencesUtils.getInstance(RewardTaskDetailActivity.this.mContext).putInt(RewardTaskDetailActivity.this.mContext.getString(R.string.moku_sp_is_show_guide_my_participate_in_tip), 4);
                RewardTaskDetailActivity rewardTaskDetailActivity = RewardTaskDetailActivity.this;
                rewardTaskDetailActivity.showMasking(rewardTaskDetailActivity.rightImageView, false, BitmapFactory.decodeResource(RewardTaskDetailActivity.this.mContext.getResources(), R.drawable.moku_reward_complaint_tips), GuideDialog.Orientation.BOTTOM_LEFT, numArr, numArr2, linearLayout);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showMasking(View view, Boolean bool, Bitmap bitmap, GuideDialog.Orientation orientation, Integer[] numArr, Integer[] numArr2, View view2) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        GuideDialog.Builder builder = new GuideDialog.Builder(this.mContext);
        if (view != null) {
            builder.setHighlightView(view);
        }
        if (bool != null) {
            builder.setIsHighlight(bool.booleanValue());
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

    /* JADX INFO: Access modifiers changed from: private */
    public void uplodatePackage() {
        ApiDataHelper.getApiDataHelper().postPackages(this.mContext, new ApiDataCallBack<String>() { // from class: com.fendasz.moku.planet.ui.activity.RewardTaskDetailActivity.53
            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void success(int i, String str) throws Exception {
                LogUtils.logD(RewardTaskDetailActivity.TAG, "upload postPackages success");
            }

            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void error(int i, String str) throws Exception {
                LogUtils.logE(RewardTaskDetailActivity.TAG, "upload postPackages error,message=>" + str);
            }
        });
    }
}
