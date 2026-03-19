package com.fendasz.moku.diandian.model.detail;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.fendasz.moku.diandian.commons.MokuDianActivity;
import com.fendasz.moku.planet.R;
import com.fendasz.moku.planet.constants.MokuConstants;
import com.fendasz.moku.planet.entity.ApiDataCallBack;
import com.fendasz.moku.planet.entity.ApiOperationCallBack;
import com.fendasz.moku.planet.entity.OperationEnum;
import com.fendasz.moku.planet.helper.AliyunHelper;
import com.fendasz.moku.planet.helper.ApiDataHelper;
import com.fendasz.moku.planet.helper.ApiTaskOperationHelper;
import com.fendasz.moku.planet.helper.MokuConfigure;
import com.fendasz.moku.planet.interf.Finish;
import com.fendasz.moku.planet.interf.Success;
import com.fendasz.moku.planet.interf.TaskGroupUpdateDetailInterface;
import com.fendasz.moku.planet.interf.functions.Consumer;
import com.fendasz.moku.planet.interf.observer.RecursiveDirectoryWatcher;
import com.fendasz.moku.planet.source.bean.ClientDetailTaskData;
import com.fendasz.moku.planet.source.bean.ClientTaskDataSubmitFormModel;
import com.fendasz.moku.planet.source.bean.CpaData;
import com.fendasz.moku.planet.source.bean.CpaQuestionData;
import com.fendasz.moku.planet.source.bean.TaskDataApplyRecord;
import com.fendasz.moku.planet.source.bean.taskdatagroup.ClientGroupTaskData;
import com.fendasz.moku.planet.source.bean.taskdatagroup.ClientGroupTaskDataStatusEnum;
import com.fendasz.moku.planet.ui.activity.MokuMainActivity;
import com.fendasz.moku.planet.ui.activity.RewardTaskDetailActivity;
import com.fendasz.moku.planet.ui.dialog.CustomBuildDialog;
import com.fendasz.moku.planet.ui.dialog.GuideDialog;
import com.fendasz.moku.planet.ui.dialog.LoadingDialog;
import com.fendasz.moku.planet.ui.view.TaskDetailView;
import com.fendasz.moku.planet.utils.ApkScanTask;
import com.fendasz.moku.planet.utils.DateUtils;
import com.fendasz.moku.planet.utils.FileUtils;
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
import com.google.gson.Gson;
import com.luck.picture.lib.config.SelectMimeType;
import com.pandora.common.utils.Times;
import io.reactivex.functions.Action;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class DianCpaDetailActivity extends MokuDianActivity implements ApiOperationCallBack {
    private static final int CODE_COUNT_DOWN = 3;
    private static final int CODE_START_TASK = 0;
    private static final int CODE_SUBMIT_ANSWER = 5;
    private static final int CODE_TASK_STATUS = 4;
    private static final int CODE_UPLOAD_SCREENSHOT = 1;
    private static final int CODE_VIEW_INIT = 2;
    public static final int REQUEST_RESULT_TASK = 100;
    public static final int RESULT_CODE_FOR_FINISH = 2;
    public static final int RESULT_CODE_FOR_REFRESH_TASK_LIST = 300;
    private static final String TAG = "Dian_CPA_Detail=>";
    private List<String> answerList;
    private Map<Integer, String> choiceMap;
    private RecursiveDirectoryWatcher directoryWatcher;
    private List<EditText> etAnswerList;
    private List<EditText> etFormList;
    private List<File> fileUploadImageList;
    private List<ClientTaskDataSubmitFormModel> formDatas;
    private Gson gson;
    private boolean isAPPShopFileCreate;
    private boolean isAPPShopFileVisit;
    private int isQQPackageExists;
    private boolean isTaskGroup;
    private boolean isWechatPackageExists;
    private List<ImageView> ivUploadImageList;
    private Integer locationStatus;
    private String mAdditionalData;
    private String mAnswer;
    private ApiTaskOperationHelper mApiTaskOperationHelper;
    private Button mBtnStartTask;
    private Button mBtnSubmit;
    ClientDetailTaskData mClientDetailTaskData;
    private Context mContext;
    private EditText mEtInput;
    private List<EditText> mEtInputList;
    private String mExpirationTime;
    private String mGateType;
    private CustomBuildDialog mGoOnTaskDialog;
    private GuideDialog mGuideDialog;
    private LinearLayout mLlOnTask;
    private int mNumberOfAttempts;
    private ProgressBar mPbDownload;
    private PhoneScreenUtils mPhoneScreenUtils;
    private RelativeLayout mRlDownload;
    private int mTaskDataId;
    private TaskDetailView mTaskDetailView;
    private Integer mTime;
    private TextView mTvAnswerError;
    private List<TextView> mTvAnswerErrorList;
    private TextView mTvAnswerErrorTip;
    private List<TextView> mTvAnswerErrorTipList;
    private TextView mTvAnswerTips;
    private List<TextView> mTvAnswerTipsList;
    private TextView mTvBtnCommentCopy;
    private TextView mTvCancelTask;
    private TextView mTvCommentContent;
    private TextView mTvDownload;
    private TextView mTvFlow;
    private TextView mTvSearchTerms;
    private List<LinearLayout> mllAnswerList;
    private LinearLayout mllSearchTerms;
    private LinearLayout rootView;
    private ApkScanTask scanTask;
    private LinearLayout suspendLayout;
    private ScheduledExecutorService scheduled = null;
    private Long currentTime = null;
    private boolean isStartSubmitCpaNormalTask = false;
    private long clickTime = 0;
    private boolean isAddsuspendLayout = false;
    private boolean isWatcherIng = false;
    private boolean isSubmiting = false;

    static /* synthetic */ int access$2908(DianCpaDetailActivity dianCpaDetailActivity) {
        int i = dianCpaDetailActivity.mNumberOfAttempts;
        dianCpaDetailActivity.mNumberOfAttempts = i + 1;
        return i;
    }

    @Override // com.fendasz.moku.diandian.commons.MokuDianActivity, com.fendasz.moku.planet.ui.base.activity.BaseActivity
    public void onSuperCreate(Bundle bundle) {
        super.onSuperCreate(bundle);
        LogUtils.logD(TAG, "onSuperCreate invoke");
        this.mContext = this;
        updateOaid();
        if (bundle == null) {
            Intent intent = getIntent();
            this.mTaskDataId = intent.getIntExtra("taskDataId", -1);
            this.mGateType = intent.getStringExtra("gateType");
            this.mAdditionalData = intent.getStringExtra("additionalData");
        } else {
            this.mTaskDataId = bundle.getInt("taskDataId", -1);
            this.mGateType = bundle.getString("gateType");
            this.mAdditionalData = bundle.getString("additionalData");
        }
        String str = this.mAdditionalData;
        if (str == null || StringUtils.isEmpty(str)) {
            this.mAdditionalData = MokuConfigure.getInstance().getMokuOptions(this.mContext).getString("additionalData", null);
        }
        LogUtils.logD(TAG, "mAdditionalData=>" + this.mAdditionalData);
    }

    @Override // com.fendasz.moku.planet.ui.base.activity.BaseActivity
    public View initContentView(ViewGroup viewGroup) {
        this.mPhoneScreenUtils = PhoneScreenUtils.getInstance();
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.moku_task_detail_cpa, (ViewGroup) null);
        this.rootView = linearLayout;
        return linearLayout;
    }

    @Override // com.fendasz.moku.diandian.commons.MokuDianActivity, com.fendasz.moku.planet.ui.base.activity.BaseActivity
    public void initTitle(TextView textView) {
        if (textView != null) {
            textView.setText("任务详情");
            textView.getPaint().setTextSize(CanvasUtils.getTextSize(this.phoneScreenUtils.getScale(this.mContext, 70.0f)));
        }
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("taskDataId", this.mTaskDataId);
        bundle.putString("gateType", this.mGateType);
    }

    @Override // com.fendasz.moku.planet.ui.base.activity.BaseActivity
    public void initView() {
        super.initView();
        TaskDetailView taskDetailView = new TaskDetailView(this.mContext, this.rootView, this.mPhoneScreenUtils);
        this.mTaskDetailView = taskDetailView;
        taskDetailView.initStaticView();
        this.fileUploadImageList = new ArrayList();
        this.ivUploadImageList = new ArrayList();
        this.mllAnswerList = new ArrayList();
        this.choiceMap = new HashMap();
        this.etFormList = new ArrayList();
        this.formDatas = new ArrayList();
        this.gson = new Gson();
    }

    @Override // com.fendasz.moku.diandian.commons.MokuDianActivity, com.fendasz.moku.planet.ui.base.activity.BaseActivity
    protected void onLoad() {
        super.onLoad();
        initStaticViewListener();
        getTaskDetail(false, false, false, new Success<ClientDetailTaskData>() { // from class: com.fendasz.moku.diandian.model.detail.DianCpaDetailActivity.1
            @Override // com.fendasz.moku.planet.interf.Success
            public void success(Integer num, ClientDetailTaskData clientDetailTaskData) {
                if (TextUtils.isEmpty(DianCpaDetailActivity.this.mGateType) || clientDetailTaskData == null) {
                    return;
                }
                LogUtils.log(DianCpaDetailActivity.TAG, "postGateType " + DianCpaDetailActivity.this.mGateType);
                ApiDataHelper.getApiDataHelper().postGateType(DianCpaDetailActivity.this.mContext, DianCpaDetailActivity.this.mGateType, clientDetailTaskData.getTaskDataId(), new ApiDataCallBack<Object>() { // from class: com.fendasz.moku.diandian.model.detail.DianCpaDetailActivity.1.1
                    @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
                    public void success(int i, Object obj) throws Exception {
                        LogUtils.log(DianCpaDetailActivity.TAG, "postGateType success");
                    }

                    @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
                    public void error(int i, String str) throws Exception {
                        LogUtils.log(DianCpaDetailActivity.TAG, "postGateType error >> " + str);
                    }
                });
            }
        });
    }

    public void initStaticView(LinearLayout linearLayout, RelativeLayout relativeLayout, TextView textView, Button button, TextView textView2, ProgressBar progressBar) {
        this.mLlOnTask = linearLayout;
        this.mRlDownload = relativeLayout;
        this.mTvDownload = textView;
        this.mBtnStartTask = button;
        this.mTvCancelTask = textView2;
        this.mPbDownload = progressBar;
    }

    public void initTaskFlowView(TextView textView, TextView textView2, LinearLayout linearLayout, TextView textView3) {
        this.mTvCommentContent = textView;
        this.mTvBtnCommentCopy = textView2;
        this.mllSearchTerms = linearLayout;
        this.mTvSearchTerms = textView3;
    }

    public void initTaskAnswerView(EditText editText, Button button, TextView textView, TextView textView2, TextView textView3) {
        this.mEtInput = editText;
        this.mBtnSubmit = button;
        this.mTvAnswerError = textView;
        this.mTvAnswerErrorTip = textView2;
        this.mTvAnswerTips = textView3;
    }

    public void initBTaskAnswerView(List<EditText> list, List<TextView> list2, List<TextView> list3, List<TextView> list4, List<EditText> list5, int i) {
        this.mEtInputList = list;
        this.mTvAnswerErrorList = list2;
        this.mTvAnswerErrorTipList = list3;
        this.mTvAnswerTipsList = list4;
        this.etAnswerList = list5;
        this.answerList = new ArrayList(Arrays.asList(new String[i]));
    }

    private void initStaticViewListener() {
        TaskDetailView taskDetailView = this.mTaskDetailView;
        if (taskDetailView != null) {
            taskDetailView.setOnUpdateDetailView(new TaskGroupUpdateDetailInterface() { // from class: com.fendasz.moku.diandian.model.detail.DianCpaDetailActivity.2
                @Override // com.fendasz.moku.planet.interf.TaskGroupUpdateDetailInterface
                public void updateDetail(int i) {
                    DianCpaDetailActivity.this.mTaskDataId = i;
                    DianCpaDetailActivity.this.refresh(false, false);
                }
            });
        }
        RelativeLayout relativeLayout = this.mRlDownload;
        if (relativeLayout != null) {
            relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.fendasz.moku.diandian.model.detail.DianCpaDetailActivity.3
                /* JADX WARN: Removed duplicated region for block: B:42:0x00c2  */
                @Override // android.view.View.OnClickListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public void onClick(android.view.View r6) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
                    /*
                        Method dump skipped, instructions count: 416
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.fendasz.moku.diandian.model.detail.DianCpaDetailActivity.AnonymousClass3.onClick(android.view.View):void");
                }
            });
        }
        Button button = this.mBtnStartTask;
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() { // from class: com.fendasz.moku.diandian.model.detail.DianCpaDetailActivity.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    if (jCurrentTimeMillis - DianCpaDetailActivity.this.clickTime > 1000) {
                        DianCpaDetailActivity.this.clickTime = jCurrentTimeMillis;
                        DianCpaDetailActivity.this.getTaskDataStatus(false);
                    } else {
                        LogUtils.log(DianCpaDetailActivity.TAG, "repeat click");
                        Toast.makeText(DianCpaDetailActivity.this.mContext, "不要重复点击", 1).show();
                    }
                }
            });
        }
        TextView textView = this.mTvCancelTask;
        if (textView != null) {
            textView.setOnClickListener(new AnonymousClass5());
        }
    }

    /* renamed from: com.fendasz.moku.diandian.model.detail.DianCpaDetailActivity$5, reason: invalid class name */
    class AnonymousClass5 implements View.OnClickListener {
        AnonymousClass5() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            new CustomBuildDialog.DialogBuilder(DianCpaDetailActivity.this.mContext).setTitleImage(Integer.valueOf(R.drawable.moku_tips_icon)).setDetailText("任务取消2次后，当天不再展示\n确定取消这个任务么？").setCancelable(false).setLeftBtn("确定取消", new CustomBuildDialog.DialogButtonOnClickListener() { // from class: com.fendasz.moku.diandian.model.detail.DianCpaDetailActivity.5.2
                @Override // com.fendasz.moku.planet.ui.dialog.CustomBuildDialog.DialogButtonOnClickListener
                public void onClick(TextView textView, CustomBuildDialog customBuildDialog) {
                    customBuildDialog.dismiss();
                    DianCpaDetailActivity.this.cancelTask(DianCpaDetailActivity.this.mClientDetailTaskData, new Consumer<TaskDataApplyRecord>() { // from class: com.fendasz.moku.diandian.model.detail.DianCpaDetailActivity.5.2.1
                        @Override // com.fendasz.moku.planet.interf.functions.Consumer
                        public void accept(TaskDataApplyRecord taskDataApplyRecord) throws Exception {
                            DianCpaDetailActivity.this.cancelTaskCallBack(taskDataApplyRecord);
                        }
                    });
                }
            }).setRightBtn("继续任务", new CustomBuildDialog.DialogButtonOnClickListener() { // from class: com.fendasz.moku.diandian.model.detail.DianCpaDetailActivity.5.1
                @Override // com.fendasz.moku.planet.ui.dialog.CustomBuildDialog.DialogButtonOnClickListener
                public void onClick(TextView textView, CustomBuildDialog customBuildDialog) {
                    customBuildDialog.dismiss();
                }
            }).create().show();
        }
    }

    public void initBasicInfoView(TextView textView) {
        this.mTvFlow = textView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkAndSubmit(Action action) {
        Integer num = this.locationStatus;
        if (num != null && 1 == num.intValue() && 1 != queryLocationInfo().intValue()) {
            LoadingDialog.dismiss();
            return;
        }
        if (checkForm()) {
            setSubmitState(true);
            submitTask(action);
        } else if (LoadingDialog.isShowing()) {
            LoadingDialog.dismiss();
        }
    }

    private boolean checkForm() throws NumberFormatException {
        for (int i = 0; i < this.fileUploadImageList.size(); i++) {
            if (this.fileUploadImageList.get(i) == null) {
                LoadingDialog.dismiss();
                Toast.makeText(this.mContext, "图片" + (i + 1) + "不能为空", 0).show();
                return false;
            }
        }
        for (int i2 = 0; i2 < this.etFormList.size(); i2++) {
            String string = this.etFormList.get(i2).getText().toString();
            if (TextUtils.isEmpty(string)) {
                Toast.makeText(this.mContext, "请输入" + this.formDatas.get(i2).getKey(), 0).show();
                LoadingDialog.dismiss();
                return false;
            }
            if (this.formDatas.get(i2).getKey().contains("手机") && (string.length() != 11 || !StringUtils.isNumber(string))) {
                Toast.makeText(this.mContext, "手机格式错误", 0).show();
                LoadingDialog.dismiss();
                return false;
            }
            this.formDatas.get(i2).setValue(string);
        }
        List<EditText> list = this.etAnswerList;
        if (list != null && !list.isEmpty()) {
            try {
                for (EditText editText : this.etAnswerList) {
                    String string2 = editText.getText().toString();
                    if (TextUtils.isEmpty(string2)) {
                        Toast.makeText(this.mContext, "请选择或填写答案", 0).show();
                        return false;
                    }
                    Object tag = editText.getTag();
                    if (tag != null) {
                        this.answerList.set(Integer.parseInt(tag.toString()) - 1, string2);
                    } else {
                        this.answerList.add(string2);
                    }
                }
            } catch (Exception unused) {
                return false;
            }
        }
        List<LinearLayout> list2 = this.mllAnswerList;
        if (list2 != null && !list2.isEmpty()) {
            if (this.choiceMap == null) {
                Toast.makeText(this.mContext, "请选择选择题选项", 0).show();
                return false;
            }
            HashMap map = new HashMap();
            try {
                Iterator<LinearLayout> it = this.mllAnswerList.iterator();
                while (it.hasNext()) {
                    Object tag2 = it.next().getTag();
                    if (tag2 != null) {
                        map.put(Integer.valueOf(Integer.parseInt(tag2.toString())), "");
                    }
                }
                if (this.choiceMap.size() != map.size()) {
                    Toast.makeText(this.mContext, "请选择选择题选项", 0).show();
                    return false;
                }
            } catch (Exception unused2) {
                Toast.makeText(this.mContext, "请选择选择题选项", 0).show();
                return false;
            }
        }
        return true;
    }

    private void getTaskDetail(final boolean z, final boolean z2, final boolean z3, final Success<ClientDetailTaskData> success) {
        getTaskDetailData(this.mTaskDataId, false, new io.reactivex.functions.Consumer<ClientDetailTaskData>() { // from class: com.fendasz.moku.diandian.model.detail.DianCpaDetailActivity.6
            @Override // io.reactivex.functions.Consumer
            public void accept(ClientDetailTaskData clientDetailTaskData) throws Exception {
                DianCpaDetailActivity.this.mClientDetailTaskData = clientDetailTaskData;
                try {
                    MokuConfigure.getInstance().updateSubmitTaskDataId(DianCpaDetailActivity.this.mContext, DianCpaDetailActivity.this.mClientDetailTaskData.getTaskDataId());
                    DianCpaDetailActivity dianCpaDetailActivity = DianCpaDetailActivity.this;
                    dianCpaDetailActivity.isTaskGroup = dianCpaDetailActivity.mClientDetailTaskData.getClientGroupTaskDataList() != null && DianCpaDetailActivity.this.mClientDetailTaskData.getClientGroupTaskDataList().size() > 0;
                    if (DianCpaDetailActivity.this.mClientDetailTaskData.getTaskDataApplyRecord() != null && DianCpaDetailActivity.this.mClientDetailTaskData.getTaskDataApplyRecord().getStatus().equals(TaskDataApplyRecord.STATUS_OF_APPLYING)) {
                        DianCpaDetailActivity dianCpaDetailActivity2 = DianCpaDetailActivity.this;
                        dianCpaDetailActivity2.mExpirationTime = dianCpaDetailActivity2.mClientDetailTaskData.getTaskDataApplyRecord().getExpirationTime();
                    }
                    DianCpaDetailActivity.this.mTaskDetailView.initDynamicData(DianCpaDetailActivity.this.mClientDetailTaskData, DianCpaDetailActivity.this.fileUploadImageList, DianCpaDetailActivity.this.ivUploadImageList, DianCpaDetailActivity.this.etFormList, DianCpaDetailActivity.this.formDatas, DianCpaDetailActivity.this.mllAnswerList, z2);
                    DianCpaDetailActivity.this.mTaskDetailView.initDynamicView();
                    DianCpaDetailActivity.this.initDynamicViewListener();
                    DianCpaDetailActivity.this.mApiTaskOperationHelper = new ApiTaskOperationHelper.HelperBuilder(DianCpaDetailActivity.this.mClientDetailTaskData).setCallBack(DianCpaDetailActivity.this).create();
                    if (z) {
                        DianCpaDetailActivity.this.mApiTaskOperationHelper.init(DianCpaDetailActivity.this.mContext);
                    } else {
                        DianCpaDetailActivity.this.mApiTaskOperationHelper.onRestart(DianCpaDetailActivity.this.mContext);
                    }
                    DianCpaDetailActivity.this.onInitComplete(z3);
                    Success success2 = success;
                    if (success2 != null) {
                        success2.success(0, DianCpaDetailActivity.this.mClientDetailTaskData);
                    }
                    Integer suspendedSwitch = DianCpaDetailActivity.this.mClientDetailTaskData.getSuspendedSwitch();
                    LogUtils.logD(DianCpaDetailActivity.TAG, "suppendedSwitch=>" + suspendedSwitch);
                    if (suspendedSwitch != null && suspendedSwitch.intValue() == 1) {
                        DianCpaDetailActivity dianCpaDetailActivity3 = DianCpaDetailActivity.this;
                        if (FloatingUtil.isNeedShowFloatnigDialog(dianCpaDetailActivity3, dianCpaDetailActivity3.mClientDetailTaskData)) {
                            FloatingUtil.showFloatingDialog(DianCpaDetailActivity.this);
                        }
                    }
                    DianCpaDetailActivity.this.locationStatus = clientDetailTaskData.getLocationStatus();
                    if (1 == DianCpaDetailActivity.this.locationStatus.intValue()) {
                        DianCpaDetailActivity.this.queryLocationInfo();
                    }
                } catch (Exception e) {
                    LogUtils.logE(DianCpaDetailActivity.TAG, "getTaskDetail:" + e.getMessage());
                    DianCpaDetailActivity.this.showToast("任务详情获取失败,请重试");
                }
            }
        });
    }

    private void getTaskDetailData(int i, final boolean z, final io.reactivex.functions.Consumer<ClientDetailTaskData> consumer) {
        if (!LoadingDialog.isShowing()) {
            LoadingDialog.show(this.mContext, true);
        }
        ApiDataHelper.getApiDataHelper().getDianTaskDetail(this.mContext, Integer.valueOf(i), new ApiDataCallBack<ClientDetailTaskData>() { // from class: com.fendasz.moku.diandian.model.detail.DianCpaDetailActivity.7
            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void success(int i2, ClientDetailTaskData clientDetailTaskData) {
                LoadingDialog.dismiss();
                try {
                    consumer.accept(clientDetailTaskData);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void error(int i2, String str) {
                LoadingDialog.dismiss();
                LogUtils.log(DianCpaDetailActivity.TAG, "code:" + i2 + " message:" + str);
                if (z) {
                    Toast.makeText(DianCpaDetailActivity.this.mContext, str + i2, 1).show();
                } else if (i2 == 5000 || i2 == 5001) {
                    Toast.makeText(DianCpaDetailActivity.this.mContext, str + i2, 1).show();
                } else {
                    Toast.makeText(DianCpaDetailActivity.this.mContext, "code:" + i2 + " message:" + str, 1).show();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getTaskGroupDataList(final List<ClientGroupTaskData> list, final io.reactivex.functions.Consumer<List<ClientGroupTaskData>> consumer) {
        LoadingDialog.show(this.mContext);
        ApiDataHelper.getApiDataHelper().getDianTaskDetail(this.mContext, list.get(this.mNumberOfAttempts).getTaskDataId(), new ApiDataCallBack<ClientDetailTaskData>() { // from class: com.fendasz.moku.diandian.model.detail.DianCpaDetailActivity.8
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
                    com.fendasz.moku.diandian.model.detail.DianCpaDetailActivity r2 = com.fendasz.moku.diandian.model.detail.DianCpaDetailActivity.this     // Catch: java.lang.Exception -> L43
                    com.fendasz.moku.diandian.model.detail.DianCpaDetailActivity.access$2908(r2)     // Catch: java.lang.Exception -> L43
                    com.fendasz.moku.diandian.model.detail.DianCpaDetailActivity r2 = com.fendasz.moku.diandian.model.detail.DianCpaDetailActivity.this     // Catch: java.lang.Exception -> L43
                    int r2 = com.fendasz.moku.diandian.model.detail.DianCpaDetailActivity.access$2900(r2)     // Catch: java.lang.Exception -> L43
                    java.util.List r3 = r3     // Catch: java.lang.Exception -> L43
                    int r3 = r3.size()     // Catch: java.lang.Exception -> L43
                    if (r2 >= r3) goto L3c
                    com.fendasz.moku.diandian.model.detail.DianCpaDetailActivity r2 = com.fendasz.moku.diandian.model.detail.DianCpaDetailActivity.this     // Catch: java.lang.Exception -> L43
                    java.util.List r3 = r3     // Catch: java.lang.Exception -> L43
                    io.reactivex.functions.Consumer r0 = r2     // Catch: java.lang.Exception -> L43
                    com.fendasz.moku.diandian.model.detail.DianCpaDetailActivity.access$3000(r2, r3, r0)     // Catch: java.lang.Exception -> L43
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
                throw new UnsupportedOperationException("Method not decompiled: com.fendasz.moku.diandian.model.detail.DianCpaDetailActivity.AnonymousClass8.success(int, com.fendasz.moku.planet.source.bean.ClientDetailTaskData):void");
            }

            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void error(int i, String str) {
                LoadingDialog.dismiss();
                LogUtils.log(DianCpaDetailActivity.TAG, "code:" + i + " message:" + str);
                Toast.makeText(DianCpaDetailActivity.this.mContext, str, 0).show();
                try {
                    DianCpaDetailActivity.access$2908(DianCpaDetailActivity.this);
                    if (DianCpaDetailActivity.this.mNumberOfAttempts < list.size()) {
                        DianCpaDetailActivity.this.getTaskGroupDataList(list, consumer);
                    } else {
                        consumer.accept(null);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
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

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh(boolean z, boolean z2) {
        this.fileUploadImageList.clear();
        this.ivUploadImageList.clear();
        this.mllAnswerList.clear();
        this.etFormList.clear();
        this.formDatas.clear();
        this.choiceMap.clear();
        this.isStartSubmitCpaNormalTask = false;
        getTaskDetail(true, z, z2, null);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void onInitComplete(boolean z) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
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
    public void showUiTips(int i) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        List<String> formList;
        Log.d(TAG, "showUiTips=>" + i);
        OperationEnum operationEnum = this.mApiTaskOperationHelper.getOperationEnum();
        int i2 = 0;
        if (i == 4) {
            this.mBtnStartTask.setVisibility(8);
            this.mLlOnTask.setVisibility(0);
            this.mPbDownload.setProgress(100);
        }
        if (LoadingDialog.isShowing() && AnonymousClass42.$SwitchMap$com$fendasz$moku$planet$entity$OperationEnum[operationEnum.ordinal()] != 1) {
            LoadingDialog.dismiss();
        }
        switch (AnonymousClass42.$SwitchMap$com$fendasz$moku$planet$entity$OperationEnum[operationEnum.ordinal()]) {
            case 1:
                Log.d(TAG, "showUiTips_SUCCESS_SUBMIT:" + currentTimeMillis());
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
                        List<CpaQuestionData> cpaQuestionData = (this.mClientDetailTaskData.getTaskData() == null || this.mClientDetailTaskData.getTaskData().getTaskDataDetail() == null) ? null : this.mClientDetailTaskData.getTaskData().getTaskDataDetail().getCpaQuestionData();
                        if (cpaQuestionData != null) {
                            for (CpaQuestionData cpaQuestionData2 : cpaQuestionData) {
                                Integer questionType = cpaQuestionData2.getQuestionType();
                                if (questionType != null && (1 == questionType.intValue() || (3 == questionType.intValue() && (formList = cpaQuestionData2.getFormList()) != null && !formList.isEmpty()))) {
                                    i2 = 1;
                                }
                            }
                        }
                        if (i2 != 0) {
                            this.mTvDownload.setText("提交答案" + (TextUtils.isEmpty(this.mExpirationTime) ? "" : "\n任务剩余：" + getRemainTime()));
                        } else {
                            this.mTvDownload.setText("继续试玩" + (TextUtils.isEmpty(this.mExpirationTime) ? "" : "\n任务剩余：" + getRemainTime()));
                        }
                    } else {
                        this.mTvDownload.setText("提交任务" + (TextUtils.isEmpty(this.mExpirationTime) ? "" : "\n任务剩余：" + getRemainTime()));
                    }
                    this.mTvDownload.setTextSize(this.mPhoneScreenUtils.getMiddleTextSize(this.mContext));
                    break;
                }
                break;
            case 2:
                Log.d(TAG, "showUiTips_SUCCESS_START:" + currentTimeMillis());
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
                if (i == 2 && this.mClientDetailTaskData.getClassify().equals("cpa") && getIsFirstCpaTask() && this.mBtnStartTask.isEnabled()) {
                    final LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.moku_masking_button, (ViewGroup) null);
                    final TextView textView = (TextView) linearLayout.findViewById(R.id.tv_btn_masking);
                    textView.setTextColor(this.mContext.getResources().getColor(R.color.white));
                    textView.setTextSize(this.mPhoneScreenUtils.getBigTextSize(this.mContext));
                    ScreenAdaptationUtils.setPaddingTopAndBottom(this.mContext, textView, 15);
                    ScreenAdaptationUtils.setPaddingLeftAndRight(this.mContext, textView, 70);
                    textView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.fendasz.moku.diandian.model.detail.DianCpaDetailActivity.9
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            float height = textView.getHeight() / 2;
                            ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{height, height, height, height, height, height, height, height}, null, null));
                            shapeDrawable.getPaint().setColor(DianCpaDetailActivity.this.mContext.getResources().getColor(R.color.white));
                            shapeDrawable.getPaint().setStyle(Paint.Style.STROKE);
                            shapeDrawable.getPaint().setStrokeWidth(2.0f);
                            textView.setBackground(shapeDrawable);
                        }
                    });
                    textView.setOnClickListener(new View.OnClickListener() { // from class: com.fendasz.moku.diandian.model.detail.DianCpaDetailActivity.10
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (DianCpaDetailActivity.this.mGuideDialog != null && DianCpaDetailActivity.this.mGuideDialog.isShowing()) {
                                DianCpaDetailActivity.this.mGuideDialog.dismiss();
                            }
                            DianCpaDetailActivity.this.getTaskDataStatus(false);
                        }
                    });
                    this.mTvFlow.post(new Runnable() { // from class: com.fendasz.moku.diandian.model.detail.DianCpaDetailActivity.11
                        @Override // java.lang.Runnable
                        public void run() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                            Integer[] numArr = {Integer.valueOf(DianCpaDetailActivity.this.mPhoneScreenUtils.getScale(DianCpaDetailActivity.this.mContext, 10.0f)), Integer.valueOf(DianCpaDetailActivity.this.mPhoneScreenUtils.getScale(DianCpaDetailActivity.this.mContext, 10.0f)), Integer.valueOf(DianCpaDetailActivity.this.mPhoneScreenUtils.getScale(DianCpaDetailActivity.this.mContext, 10.0f)), Integer.valueOf(DianCpaDetailActivity.this.mPhoneScreenUtils.getScale(DianCpaDetailActivity.this.mContext, 10.0f))};
                            Integer[] numArr2 = {Integer.valueOf(DianCpaDetailActivity.this.mPhoneScreenUtils.getScale(DianCpaDetailActivity.this.mContext, 20.0f)), Integer.valueOf(DianCpaDetailActivity.this.mPhoneScreenUtils.getScale(DianCpaDetailActivity.this.mContext, 20.0f)), Integer.valueOf(DianCpaDetailActivity.this.mPhoneScreenUtils.getScale(DianCpaDetailActivity.this.mContext, 20.0f)), Integer.valueOf(DianCpaDetailActivity.this.mPhoneScreenUtils.getScale(DianCpaDetailActivity.this.mContext, 20.0f))};
                            if (!DianCpaDetailActivity.this.mClientDetailTaskData.getTaskData().getCpaType().equals(MokuConstants.CPA_TYPE_NORMAL)) {
                                DianCpaDetailActivity dianCpaDetailActivity = DianCpaDetailActivity.this;
                                dianCpaDetailActivity.showMasking(dianCpaDetailActivity.mTvFlow, BitmapFactory.decodeResource(DianCpaDetailActivity.this.mContext.getResources(), R.drawable.moku_masking1), GuideDialog.Orientation.BOTTOM_LEFT, numArr, numArr2, linearLayout);
                                SharedPreferencesUtils.getInstance(DianCpaDetailActivity.this.mContext).putBoolean("dian_moku_first_cpa_answer_task", false);
                            } else {
                                DianCpaDetailActivity dianCpaDetailActivity2 = DianCpaDetailActivity.this;
                                dianCpaDetailActivity2.showMasking(dianCpaDetailActivity2.mTvFlow, BitmapFactory.decodeResource(DianCpaDetailActivity.this.mContext.getResources(), R.drawable.moku_masking_cpa_normal), GuideDialog.Orientation.BOTTOM_LEFT, numArr, numArr2, linearLayout);
                                SharedPreferencesUtils.getInstance(DianCpaDetailActivity.this.mContext).putBoolean("dian_moku_first_cpa_normal_task", false);
                            }
                        }
                    });
                    break;
                }
                break;
            case 3:
                Log.d(TAG, "showUiTips_SUCCESS_APPLY:" + currentTimeMillis());
                if (i == 4) {
                    while (i2 < this.etFormList.size()) {
                        this.etFormList.get(i2).setEnabled(true);
                        i2++;
                    }
                }
                if ("cpa".equals(this.mClientDetailTaskData.getClassify())) {
                    Log.d(TAG, "mTime===>" + this.mTime);
                    List<String> formList2 = this.mClientDetailTaskData.getFormList();
                    Integer cpaType = this.mClientDetailTaskData.getTaskData().getCpaType();
                    if (cpaType != null && MokuConstants.CPA_TYPE_NORMAL_FORM.equals(cpaType) && formList2 != null && !formList2.isEmpty()) {
                        this.mTvDownload.setText("提交答案");
                        break;
                    }
                }
                break;
            case 4:
                Log.d(TAG, "showUiTips_SUCCESS_DOWNLOAD:" + currentTimeMillis());
                if (i == 4 || i == 3) {
                    this.mTvDownload.setText("下载应用市场" + (TextUtils.isEmpty(this.mExpirationTime) ? "" : "\n任务剩余：" + getRemainTime()));
                    this.mTvDownload.setTextSize(this.mPhoneScreenUtils.getMiddleTextSize(this.mContext));
                    break;
                }
            case 5:
                Log.d(TAG, "showUiTips_SUCCESS_DOWNLOAD_APP:" + currentTimeMillis());
                if (i == 4 || i == 3) {
                    this.mTvDownload.setText("下载应用" + (TextUtils.isEmpty(this.mExpirationTime) ? "" : "\n任务剩余：" + getRemainTime()));
                    this.mTvDownload.setTextSize(this.mPhoneScreenUtils.getMiddleTextSize(this.mContext));
                }
                if (i == 0 || i == 1) {
                    Toast.makeText(this.mContext, "请先下载安装指定应用", 0).show();
                    break;
                }
                break;
            case 7:
                Log.d(TAG, "showUiTips_SUCCESS_CONTINUE_DOWNLOAD:" + currentTimeMillis());
                if (i == 4 || i == 3) {
                    this.mTvDownload.setText("继续下载" + (TextUtils.isEmpty(this.mExpirationTime) ? "" : "\n任务剩余：" + getRemainTime()));
                    this.mTvDownload.setTextSize(this.mPhoneScreenUtils.getMiddleTextSize(this.mContext));
                    break;
                }
            case 8:
                Log.d(TAG, "showUiTips_ERROR_DOWNLOAD:" + currentTimeMillis());
                if (i == 4 || i == 3) {
                    this.mTvDownload.setText("下载失败,继续下载" + (TextUtils.isEmpty(this.mExpirationTime) ? "" : "\n任务剩余：" + getRemainTime()));
                    this.mTvDownload.setTextSize(this.mPhoneScreenUtils.getMiddleTextSize(this.mContext));
                    break;
                }
            case 9:
                Log.d(TAG, "showUiTips_SUCCESS_OPEN:" + currentTimeMillis());
                if (i == 4 || i == 3) {
                    this.mTvDownload.setText("打开应用市场" + (TextUtils.isEmpty(this.mExpirationTime) ? "" : "\n任务剩余：" + getRemainTime()));
                    this.mTvDownload.setTextSize(this.mPhoneScreenUtils.getMiddleTextSize(this.mContext));
                }
                if (i == 0 || i == 1) {
                    Toast.makeText(this.mContext, "请去应用市场下载指定软件，若您已经下载，请检查下载是否正确，软件为【" + this.mClientDetailTaskData.getTaskData().getTaskDataDetail().getAppName() + "】", 0).show();
                    break;
                }
                break;
            case 10:
            case 11:
                Log.d(TAG, "showUiTips_SUCCESS_OPEN_APP:" + currentTimeMillis());
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
            case 12:
                Log.d(TAG, "showUiTips_SUCCESS_INSTALL:" + currentTimeMillis());
                if (i == 4 || i == 3) {
                    this.mTvDownload.setText("安装应用市场" + (TextUtils.isEmpty(this.mExpirationTime) ? "" : "\n任务剩余：" + getRemainTime()));
                    this.mTvDownload.setTextSize(this.mPhoneScreenUtils.getMiddleTextSize(this.mContext));
                    break;
                }
            case 13:
                Log.d(TAG, "showUiTips_SUCCESS_INSTALL_APP:" + currentTimeMillis());
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
            case 14:
                Log.d(TAG, "showUiTips_SUCCESS_AUTO_INSTALL_APP:" + currentTimeMillis());
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
            case 15:
                Log.d(TAG, "showUiTips_SUCCESS_CONTINUE_DEMO:" + currentTimeMillis());
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
            case 16:
                Log.d(TAG, "showUiTips_ERROR_OVERTIME:" + currentTimeMillis());
                if (i == 4) {
                    this.mTvDownload.setText("任务超时" + (TextUtils.isEmpty(this.mExpirationTime) ? "" : "\n任务剩余：" + getRemainTime()));
                    this.mTvDownload.setTextSize(this.mPhoneScreenUtils.getMiddleTextSize(this.mContext));
                    this.mPbDownload.setProgress(0);
                    this.mBtnStartTask.setVisibility(0);
                    this.mLlOnTask.setVisibility(8);
                }
                if (i == 2 || i == 3) {
                    new CustomBuildDialog.DialogBuilder(this).setTitleImage(Integer.valueOf(R.drawable.moku_tips_icon)).setDetailText("您的任务已经超时啦~\n需要帮您重新开始么").setCancelable(false).setLeftBtn("不了", new CustomBuildDialog.DialogButtonOnClickListener() { // from class: com.fendasz.moku.diandian.model.detail.DianCpaDetailActivity.13
                        @Override // com.fendasz.moku.planet.ui.dialog.CustomBuildDialog.DialogButtonOnClickListener
                        public void onClick(TextView textView2, CustomBuildDialog customBuildDialog2) {
                            customBuildDialog2.dismiss();
                            DianCpaDetailActivity dianCpaDetailActivity = DianCpaDetailActivity.this;
                            dianCpaDetailActivity.cancelTask(dianCpaDetailActivity.mClientDetailTaskData, new Consumer<TaskDataApplyRecord>() { // from class: com.fendasz.moku.diandian.model.detail.DianCpaDetailActivity.13.1
                                @Override // com.fendasz.moku.planet.interf.functions.Consumer
                                public void accept(TaskDataApplyRecord taskDataApplyRecord) throws Exception {
                                    DianCpaDetailActivity.this.cancelTaskCallBack(taskDataApplyRecord);
                                }
                            });
                        }
                    }).setRightBtn("重新开始", new CustomBuildDialog.DialogButtonOnClickListener() { // from class: com.fendasz.moku.diandian.model.detail.DianCpaDetailActivity.12
                        @Override // com.fendasz.moku.planet.ui.dialog.CustomBuildDialog.DialogButtonOnClickListener
                        public void onClick(TextView textView2, CustomBuildDialog customBuildDialog2) {
                            customBuildDialog2.dismiss();
                            DianCpaDetailActivity.this.getTaskDataStatus(false);
                        }
                    }).create().show();
                    break;
                }
            case 17:
                Log.d(TAG, "showUiTips_ERROR_TAKEUP:" + currentTimeMillis());
                if (i == 2) {
                    this.mBtnStartTask.setVisibility(0);
                    this.mLlOnTask.setVisibility(8);
                    this.mBtnStartTask.setText(this.mContext.getString(R.string.moku_start_task_btn_text__take_up));
                    this.mBtnStartTask.setEnabled(false);
                    Toast.makeText(this.mContext, "这个任务已经被抢完啦~", 0).show();
                    break;
                }
                break;
            case 18:
                Log.d(TAG, "showUiTips_SUCCESS_OPEN_MARKETDOWNLOAD:" + currentTimeMillis());
                if (i == 4 || i == 3) {
                    this.mTvDownload.setText("跳转应用市场" + (TextUtils.isEmpty(this.mExpirationTime) ? "" : "\n任务剩余：" + getRemainTime()));
                    break;
                }
        }
    }

    /* renamed from: com.fendasz.moku.diandian.model.detail.DianCpaDetailActivity$42, reason: invalid class name */
    static /* synthetic */ class AnonymousClass42 {
        static final /* synthetic */ int[] $SwitchMap$com$fendasz$moku$planet$entity$OperationEnum;

        static {
            int[] iArr = new int[OperationEnum.values().length];
            $SwitchMap$com$fendasz$moku$planet$entity$OperationEnum = iArr;
            try {
                iArr[OperationEnum.SUCCESS_SUBMIT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$fendasz$moku$planet$entity$OperationEnum[OperationEnum.SUCCESS_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$fendasz$moku$planet$entity$OperationEnum[OperationEnum.SUCCESS_APPLY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$fendasz$moku$planet$entity$OperationEnum[OperationEnum.SUCCESS_DOWNLOAD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$fendasz$moku$planet$entity$OperationEnum[OperationEnum.SUCCESS_DOWNLOAD_APP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$fendasz$moku$planet$entity$OperationEnum[OperationEnum.SUCCESS_DOWNLOAD_LOADING.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$fendasz$moku$planet$entity$OperationEnum[OperationEnum.SUCCESS_CONTINUE_DOWNLOAD.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$fendasz$moku$planet$entity$OperationEnum[OperationEnum.ERROR_DOWNLOAD.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$fendasz$moku$planet$entity$OperationEnum[OperationEnum.SUCCESS_OPEN.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$fendasz$moku$planet$entity$OperationEnum[OperationEnum.SUCCESS_APPMARKET_INSTALLED.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$fendasz$moku$planet$entity$OperationEnum[OperationEnum.SUCCESS_OPEN_APP.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$fendasz$moku$planet$entity$OperationEnum[OperationEnum.SUCCESS_INSTALL.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$fendasz$moku$planet$entity$OperationEnum[OperationEnum.SUCCESS_INSTALL_APP.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$fendasz$moku$planet$entity$OperationEnum[OperationEnum.SUCCESS_AUTO_INSTALL_APP.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$fendasz$moku$planet$entity$OperationEnum[OperationEnum.SUCCESS_CONTINUE_DEMO.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$fendasz$moku$planet$entity$OperationEnum[OperationEnum.ERROR_OVERTIME.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$com$fendasz$moku$planet$entity$OperationEnum[OperationEnum.ERROR_TAKEUP.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$com$fendasz$moku$planet$entity$OperationEnum[OperationEnum.SUCCESS_OPEN_MARKETDOWNLOAD.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initDynamicViewListener() {
        TextView textView = this.mTvBtnCommentCopy;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.fendasz.moku.diandian.model.detail.DianCpaDetailActivity.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (DianCpaDetailActivity.this.mTvCommentContent == null || !DianCpaDetailActivity.this.mTvCommentContent.isEnabled()) {
                        return;
                    }
                    try {
                        SystemUtils.copyToClipboard(DianCpaDetailActivity.this.mContext, "comment", DianCpaDetailActivity.this.mTvCommentContent.getText().toString());
                        Toast.makeText(DianCpaDetailActivity.this.mContext, "评论已复制到剪贴板", 0).show();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        LinearLayout linearLayout = this.mllSearchTerms;
        if (linearLayout != null) {
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.fendasz.moku.diandian.model.detail.DianCpaDetailActivity.15
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (DianCpaDetailActivity.this.mTvSearchTerms != null) {
                        try {
                            SystemUtils.copyToClipboard(DianCpaDetailActivity.this.mContext, "keyword", DianCpaDetailActivity.this.mTvSearchTerms.getText().toString());
                            Toast.makeText(DianCpaDetailActivity.this.mContext, "已复制搜索词", 0).show();
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
                this.ivUploadImageList.get(i).setOnClickListener(new View.OnClickListener() { // from class: com.fendasz.moku.diandian.model.detail.DianCpaDetailActivity.16
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                        if (DianCpaDetailActivity.this.mApiTaskOperationHelper.getOperationEnum() != OperationEnum.SUCCESS_SUBMIT) {
                            DianCpaDetailActivity.this.showUiTips(1);
                            return;
                        }
                        Intent intent = new Intent();
                        if (Build.VERSION.SDK_INT < 19) {
                            intent.setAction("android.intent.action.GET_CONTENT");
                        } else {
                            intent.setAction("android.intent.action.OPEN_DOCUMENT");
                        }
                        intent.setType(SelectMimeType.SYSTEM_IMAGE);
                        intent.addCategory("android.intent.category.OPENABLE");
                        try {
                            ((DianCpaDetailActivity) DianCpaDetailActivity.this.mContext).startActivityForResult(intent, i);
                        } catch (Exception unused) {
                            Log.d(DianCpaDetailActivity.TAG, "no activity found");
                        }
                    }
                });
            }
        }
        List<LinearLayout> list2 = this.mllAnswerList;
        if (list2 != null && list2.size() > 0) {
            for (final int i2 = 0; i2 < this.mllAnswerList.size(); i2++) {
                final LinearLayout linearLayout2 = this.mllAnswerList.get(i2);
                linearLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.fendasz.moku.diandian.model.detail.DianCpaDetailActivity.17
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                        List<CpaQuestionData> cpaQuestionData;
                        if (DianCpaDetailActivity.this.mApiTaskOperationHelper.getOperationEnum() != OperationEnum.SUCCESS_SUBMIT) {
                            DianCpaDetailActivity.this.showUiTips(5);
                            return;
                        }
                        DianCpaDetailActivity.this.hideTips();
                        linearLayout2.setBackground(DianCpaDetailActivity.this.getResources().getDrawable(R.drawable.moku_blue_circular_rectangle_shape));
                        DianCpaDetailActivity dianCpaDetailActivity = DianCpaDetailActivity.this;
                        dianCpaDetailActivity.mTvAnswerError = (TextView) ((LinearLayout) dianCpaDetailActivity.mllAnswerList.get(i2)).findViewById(R.id.tv_answer_error);
                        Integer numValueOf = null;
                        Object tag = linearLayout2.getTag();
                        if (tag != null) {
                            try {
                                numValueOf = Integer.valueOf(Integer.parseInt(tag.toString()));
                            } catch (Exception unused) {
                            }
                        }
                        if (DianCpaDetailActivity.this.mClientDetailTaskData.getTaskData().getTaskDataDetail().getCpaQuestionData() != null && (cpaQuestionData = DianCpaDetailActivity.this.mClientDetailTaskData.getTaskData().getTaskDataDetail().getCpaQuestionData()) != null) {
                            Iterator<CpaQuestionData> it = cpaQuestionData.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                CpaQuestionData next = it.next();
                                if (next.getQuestionNum().equals(numValueOf)) {
                                    if (next.getQuestionType() != null && 2 == next.getQuestionType().intValue()) {
                                        String answer = next.getAnswerList().get(i2).getAnswer();
                                        DianCpaDetailActivity.this.answerList.set(numValueOf.intValue() - 1, answer);
                                        DianCpaDetailActivity.this.choiceMap.put(numValueOf, answer);
                                    }
                                }
                            }
                        }
                        for (int i3 = 0; i3 < DianCpaDetailActivity.this.mllAnswerList.size(); i3++) {
                            if (i3 != i2) {
                                ((LinearLayout) DianCpaDetailActivity.this.mllAnswerList.get(i3)).setBackground(DianCpaDetailActivity.this.getResources().getDrawable(R.drawable.moku_gray_border_rectangle_shape));
                            }
                        }
                    }
                });
            }
        }
        Button button = this.mBtnSubmit;
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() { // from class: com.fendasz.moku.diandian.model.detail.DianCpaDetailActivity.18
                @Override // android.view.View.OnClickListener
                public void onClick(View view) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                    if (DianCpaDetailActivity.this.mApiTaskOperationHelper.getOperationEnum() != OperationEnum.SUCCESS_SUBMIT) {
                        DianCpaDetailActivity.this.showUiTips(5);
                        return;
                    }
                    if (DianCpaDetailActivity.this.mEtInput != null) {
                        if (TextUtils.isEmpty(DianCpaDetailActivity.this.mEtInput.getText().toString().trim())) {
                            Toast.makeText(DianCpaDetailActivity.this.mContext, "请选择或填写答案", 0).show();
                            return;
                        }
                        DianCpaDetailActivity dianCpaDetailActivity = DianCpaDetailActivity.this;
                        dianCpaDetailActivity.mAnswer = dianCpaDetailActivity.mEtInput.getText().toString();
                        DianCpaDetailActivity.this.checkAndSubmit(new Action() { // from class: com.fendasz.moku.diandian.model.detail.DianCpaDetailActivity.18.1
                            @Override // io.reactivex.functions.Action
                            public void run() throws Exception {
                                DianCpaDetailActivity.this.submitCpaTask();
                            }
                        });
                    }
                }
            });
        }
    }

    protected Long currentTimeMillis() {
        return Long.valueOf(System.currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showErrorDialog(String str) {
        new CustomBuildDialog.DialogBuilder(this).setTitleImage(Integer.valueOf(R.drawable.moku_tips_icon)).setDetailText(str).setRightBtn(getString(R.string.moku_btn_ok), new CustomBuildDialog.DialogButtonOnClickListener() { // from class: com.fendasz.moku.diandian.model.detail.DianCpaDetailActivity.19
            @Override // com.fendasz.moku.planet.ui.dialog.CustomBuildDialog.DialogButtonOnClickListener
            public void onClick(TextView textView, CustomBuildDialog customBuildDialog) {
                customBuildDialog.dismiss();
                DianCpaDetailActivity.this.finish();
            }
        }).setCancelable(false).create().show();
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
        CustomBuildDialog customBuildDialogCreate = dialogBuilder.setCustomView(imageView).setRightBtn(this.mContext.getString(R.string.moku_dialog_btn_text__i_know), new CustomBuildDialog.DialogButtonOnClickListener() { // from class: com.fendasz.moku.diandian.model.detail.DianCpaDetailActivity.20
            @Override // com.fendasz.moku.planet.ui.dialog.CustomBuildDialog.DialogButtonOnClickListener
            public void onClick(TextView textView, CustomBuildDialog customBuildDialog) {
                customBuildDialog.dismiss();
                SharedPreferencesUtils.getInstance(DianCpaDetailActivity.this.mContext).putBoolean(DianCpaDetailActivity.this.mContext.getString(R.string.moku_sp_is_show_dialog_gallery_tip), false);
                Finish finish2 = finish;
                if (finish2 != null) {
                    finish2.finish();
                }
            }
        }).setCancelable(false).create();
        try {
            if (!isFinishing() && (Build.VERSION.SDK_INT < 17 || !isDestroyed())) {
                customBuildDialogCreate.show();
            }
        } catch (Exception unused) {
            LogUtils.logD(TAG, "error msg:customBuildDialog show error");
        }
    }

    /* renamed from: com.fendasz.moku.diandian.model.detail.DianCpaDetailActivity$21, reason: invalid class name */
    class AnonymousClass21 implements io.reactivex.functions.Consumer<ClientDetailTaskData> {
        AnonymousClass21() {
        }

        @Override // io.reactivex.functions.Consumer
        public void accept(final ClientDetailTaskData clientDetailTaskData) throws Exception {
            LinearLayout linearLayout = new LinearLayout(DianCpaDetailActivity.this.mContext);
            linearLayout.setOrientation(0);
            linearLayout.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
            final ImageView imageView = new ImageView(DianCpaDetailActivity.this.mContext);
            linearLayout.addView(imageView);
            ((LinearLayout.LayoutParams) imageView.getLayoutParams()).gravity = 16;
            ScreenAdaptationUtils.setSize(DianCpaDetailActivity.this.mContext, imageView, 120, 120);
            ScreenAdaptationUtils.setMarginRight(DianCpaDetailActivity.this.mContext, imageView, 20);
            ImageUtils.getInstance().setImageView(DianCpaDetailActivity.this.mContext, clientDetailTaskData.getIcon(), new Consumer<Bitmap>() { // from class: com.fendasz.moku.diandian.model.detail.DianCpaDetailActivity.21.1
                @Override // com.fendasz.moku.planet.interf.functions.Consumer
                public void accept(Bitmap bitmap) throws Exception {
                    imageView.setImageBitmap(bitmap);
                }
            }, Float.valueOf(DianCpaDetailActivity.this.mPhoneScreenUtils.getScale(DianCpaDetailActivity.this.mContext, 120.0f)), Float.valueOf(DianCpaDetailActivity.this.mPhoneScreenUtils.getScale(DianCpaDetailActivity.this.mContext, 120.0f)));
            LinearLayout linearLayout2 = new LinearLayout(DianCpaDetailActivity.this.mContext);
            linearLayout2.setLayoutParams(new RelativeLayout.LayoutParams(-2, -1));
            linearLayout2.setOrientation(1);
            linearLayout.addView(linearLayout2);
            TextView textView = new TextView(DianCpaDetailActivity.this.mContext);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, 0);
            layoutParams.weight = 1.0f;
            textView.setLayoutParams(layoutParams);
            textView.setSingleLine(true);
            textView.setEllipsize(TextUtils.TruncateAt.END);
            textView.setTextColor(DianCpaDetailActivity.this.mContext.getResources().getColor(R.color.black));
            linearLayout2.addView(textView);
            textView.setText(clientDetailTaskData.getShowName());
            textView.setTextSize(DianCpaDetailActivity.this.phoneScreenUtils.getNormalTextSize(DianCpaDetailActivity.this.mContext));
            TextView textView2 = new TextView(DianCpaDetailActivity.this.mContext);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, 0);
            layoutParams2.weight = 1.0f;
            textView2.setLayoutParams(layoutParams2);
            textView2.setSingleLine(true);
            textView2.setEllipsize(TextUtils.TruncateAt.END);
            textView2.setTextColor(DianCpaDetailActivity.this.mContext.getResources().getColor(R.color.moku_yellow_golden));
            linearLayout2.addView(textView2);
            textView2.setTextSize(DianCpaDetailActivity.this.phoneScreenUtils.getNormalTextSize(DianCpaDetailActivity.this.mContext));
            textView2.setText(clientDetailTaskData.getShowMoney().toPlainString() + clientDetailTaskData.getCybermoneyName());
            new CustomBuildDialog.DialogBuilder(DianCpaDetailActivity.this.mContext).setTitleImage(Integer.valueOf(R.drawable.moku_tips_icon)).setDetailText("您有一个进行中的任务，是否放弃此任务，开始当前任务？").setCustomView(linearLayout).setCancelable(false).setLeftBtn("返回完成", new CustomBuildDialog.DialogButtonOnClickListener() { // from class: com.fendasz.moku.diandian.model.detail.DianCpaDetailActivity.21.3
                @Override // com.fendasz.moku.planet.ui.dialog.CustomBuildDialog.DialogButtonOnClickListener
                public void onClick(TextView textView3, CustomBuildDialog customBuildDialog) {
                    customBuildDialog.dismiss();
                    DianCpaDetailActivity.this.mTaskDataId = clientDetailTaskData.getTaskDataId().intValue();
                    if (1 != clientDetailTaskData.getTaskType().intValue()) {
                        DianCpaDetailActivity.this.refresh(true, false);
                        return;
                    }
                    Intent intent = new Intent(DianCpaDetailActivity.this.mContext, (Class<?>) RewardTaskDetailActivity.class);
                    intent.putExtra("taskDataId", DianCpaDetailActivity.this.mTaskDataId);
                    intent.putExtra("taskDataUrl", clientDetailTaskData.getUrl());
                    String gateType = clientDetailTaskData.getGateType();
                    if (!TextUtils.isEmpty(gateType)) {
                        intent.putExtra("gateType", gateType);
                    }
                    intent.putExtra("operationType", 100);
                    DianCpaDetailActivity.this.startActivityForResult(intent, 100);
                }
            }).setRightBtn(DianCpaDetailActivity.this.mContext.getString(R.string.moku_btn_confirm), new CustomBuildDialog.DialogButtonOnClickListener() { // from class: com.fendasz.moku.diandian.model.detail.DianCpaDetailActivity.21.2
                @Override // com.fendasz.moku.planet.ui.dialog.CustomBuildDialog.DialogButtonOnClickListener
                public void onClick(TextView textView3, CustomBuildDialog customBuildDialog) {
                    customBuildDialog.dismiss();
                    DianCpaDetailActivity.this.cancelTask(clientDetailTaskData, new Consumer<TaskDataApplyRecord>() { // from class: com.fendasz.moku.diandian.model.detail.DianCpaDetailActivity.21.2.1
                        @Override // com.fendasz.moku.planet.interf.functions.Consumer
                        public void accept(TaskDataApplyRecord taskDataApplyRecord) throws Exception {
                            Toast.makeText(DianCpaDetailActivity.this.mContext, "任务(taskDataId:" + taskDataApplyRecord.getTaskDataId() + ")取消成功", 0).show();
                            DianCpaDetailActivity.this.applyTask(true);
                        }
                    });
                }
            }).setShowClose(true).create().show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showApplyingTask(TaskDataApplyRecord taskDataApplyRecord) {
        LogUtils.log(TAG, "another task is applying while the taskId is " + taskDataApplyRecord.getTaskDataId() + " and applyId is " + taskDataApplyRecord.getId());
        getTaskDetailData(taskDataApplyRecord.getTaskDataId().intValue(), true, new AnonymousClass21());
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

    private void showGoOnTaskDialog() {
        Log.d(TAG, "showGoOnTaskDialog_mTime=>" + this.mTime);
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
            CustomBuildDialog customBuildDialogCreate = titleImage.setRightBtn("继续试玩", new CustomBuildDialog.DialogButtonOnClickListener() { // from class: com.fendasz.moku.diandian.model.detail.DianCpaDetailActivity$$ExternalSyntheticLambda0
                @Override // com.fendasz.moku.planet.ui.dialog.CustomBuildDialog.DialogButtonOnClickListener
                public final void onClick(TextView textView, CustomBuildDialog customBuildDialog2) {
                    this.f$0.m388xfc2ef762(textView, customBuildDialog2);
                }
            }).setCancelable(true).create();
            this.mGoOnTaskDialog = customBuildDialogCreate;
            customBuildDialogCreate.show();
        }
    }

    /* renamed from: lambda$showGoOnTaskDialog$0$com-fendasz-moku-diandian-model-detail-DianCpaDetailActivity, reason: not valid java name */
    /* synthetic */ void m388xfc2ef762(TextView textView, CustomBuildDialog customBuildDialog) {
        customBuildDialog.dismiss();
        executeTask();
    }

    /* renamed from: lambda$showTaskGroupDialog$1$com-fendasz-moku-diandian-model-detail-DianCpaDetailActivity, reason: not valid java name */
    /* synthetic */ void m389x3c339ec7(TextView textView, CustomBuildDialog customBuildDialog) {
        customBuildDialog.dismiss();
        refresh(true, true);
    }

    /* renamed from: lambda$showTaskGroupDialog$2$com-fendasz-moku-diandian-model-detail-DianCpaDetailActivity, reason: not valid java name */
    /* synthetic */ void m390xd0720e66(TextView textView, CustomBuildDialog customBuildDialog) {
        customBuildDialog.dismiss();
        refresh(true, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showTaskGroupDialog(String str, int i) {
        if (i == 0) {
            new CustomBuildDialog.DialogBuilder(this.mContext).setTitleImage(Integer.valueOf(R.drawable.moku_task_finished)).setTitleText("提交成功").setDetailText("预计<font color=\"#ff0000\">" + str + "</font>前审核完成\n是否继续下一个任务？").setRightBtn(getString(R.string.moku_btn_continue_task), new CustomBuildDialog.DialogButtonOnClickListener() { // from class: com.fendasz.moku.diandian.model.detail.DianCpaDetailActivity$$ExternalSyntheticLambda2
                @Override // com.fendasz.moku.planet.ui.dialog.CustomBuildDialog.DialogButtonOnClickListener
                public final void onClick(TextView textView, CustomBuildDialog customBuildDialog) {
                    this.f$0.m389x3c339ec7(textView, customBuildDialog);
                }
            }).setLeftBtn(getString(R.string.moku_btn_no), new CustomBuildDialog.DialogButtonOnClickListener() { // from class: com.fendasz.moku.diandian.model.detail.DianCpaDetailActivity$$ExternalSyntheticLambda3
                @Override // com.fendasz.moku.planet.ui.dialog.CustomBuildDialog.DialogButtonOnClickListener
                public final void onClick(TextView textView, CustomBuildDialog customBuildDialog) {
                    this.f$0.m390xd0720e66(textView, customBuildDialog);
                }
            }).setCancelable(false).create().show();
        } else if (i == 1) {
            new CustomBuildDialog.DialogBuilder(this.mContext).setTitleImage(Integer.valueOf(R.drawable.moku_task_finished)).setTitleText("+" + getTaskDataMoney() + this.mClientDetailTaskData.getCybermoneyName()).setDetailText(getString(R.string.moku_task_reward_arrived)).setRightBtn(getString(R.string.moku_btn_continue_task), new CustomBuildDialog.DialogButtonOnClickListener() { // from class: com.fendasz.moku.diandian.model.detail.DianCpaDetailActivity$$ExternalSyntheticLambda4
                @Override // com.fendasz.moku.planet.ui.dialog.CustomBuildDialog.DialogButtonOnClickListener
                public final void onClick(TextView textView, CustomBuildDialog customBuildDialog) {
                    this.f$0.m391x64b07e05(textView, customBuildDialog);
                }
            }).setLeftBtn(getString(R.string.moku_btn_no), new CustomBuildDialog.DialogButtonOnClickListener() { // from class: com.fendasz.moku.diandian.model.detail.DianCpaDetailActivity$$ExternalSyntheticLambda5
                @Override // com.fendasz.moku.planet.ui.dialog.CustomBuildDialog.DialogButtonOnClickListener
                public final void onClick(TextView textView, CustomBuildDialog customBuildDialog) {
                    this.f$0.m392xf8eeeda4(textView, customBuildDialog);
                }
            }).setCancelable(false).create().show();
        } else if (i == 2) {
            new CustomBuildDialog.DialogBuilder(this.mContext).setTitleImage(Integer.valueOf(R.drawable.moku_answer_incorrect)).setTitleText(getString(R.string.moku_answer_incorrect_title)).setDetailText(getString(R.string.moku_answer_incorrect_content_for_task_group)).setRightBtn(getString(R.string.moku_btn_continue_task), new CustomBuildDialog.DialogButtonOnClickListener() { // from class: com.fendasz.moku.diandian.model.detail.DianCpaDetailActivity$$ExternalSyntheticLambda6
                @Override // com.fendasz.moku.planet.ui.dialog.CustomBuildDialog.DialogButtonOnClickListener
                public final void onClick(TextView textView, CustomBuildDialog customBuildDialog) {
                    this.f$0.m393x8d2d5d43(textView, customBuildDialog);
                }
            }).setLeftBtn(getString(R.string.moku_btn_no), new CustomBuildDialog.DialogButtonOnClickListener() { // from class: com.fendasz.moku.diandian.model.detail.DianCpaDetailActivity$$ExternalSyntheticLambda7
                @Override // com.fendasz.moku.planet.ui.dialog.CustomBuildDialog.DialogButtonOnClickListener
                public final void onClick(TextView textView, CustomBuildDialog customBuildDialog) {
                    this.f$0.m394x216bcce2(textView, customBuildDialog);
                }
            }).setCancelable(false).create().show();
        }
    }

    /* renamed from: lambda$showTaskGroupDialog$3$com-fendasz-moku-diandian-model-detail-DianCpaDetailActivity, reason: not valid java name */
    /* synthetic */ void m391x64b07e05(TextView textView, CustomBuildDialog customBuildDialog) {
        customBuildDialog.dismiss();
        refresh(true, true);
    }

    /* renamed from: lambda$showTaskGroupDialog$4$com-fendasz-moku-diandian-model-detail-DianCpaDetailActivity, reason: not valid java name */
    /* synthetic */ void m392xf8eeeda4(TextView textView, CustomBuildDialog customBuildDialog) {
        customBuildDialog.dismiss();
        refresh(true, false);
    }

    /* renamed from: lambda$showTaskGroupDialog$5$com-fendasz-moku-diandian-model-detail-DianCpaDetailActivity, reason: not valid java name */
    /* synthetic */ void m393x8d2d5d43(TextView textView, CustomBuildDialog customBuildDialog) {
        customBuildDialog.dismiss();
        refresh(true, true);
    }

    /* renamed from: lambda$showTaskGroupDialog$6$com-fendasz-moku-diandian-model-detail-DianCpaDetailActivity, reason: not valid java name */
    /* synthetic */ void m394x216bcce2(TextView textView, CustomBuildDialog customBuildDialog) {
        customBuildDialog.dismiss();
        refresh(true, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showEmptyTaskGroupDialog(String str, int i) {
        if (this.mTaskDetailView.getFollowUpOpenGroupTaskDataList().size() > 0) {
            this.mTaskDataId = this.mTaskDetailView.getFollowUpOpenGroupTaskDataList().get(0).getTaskDataId().intValue();
            showFollowUpOpenGroupTaskDataDialog(str, i);
            refresh(true, false);
            return;
        }
        CustomBuildDialog.DialogBuilder dialogBuilder = new CustomBuildDialog.DialogBuilder(this.mContext);
        if (i == 2) {
            dialogBuilder.setTitleImage(Integer.valueOf(R.drawable.moku_answer_incorrect));
            dialogBuilder.setTitleText(getString(R.string.moku_answer_incorrect_title));
            dialogBuilder.setDetailText("任务已全部完成，继续赚更多吧！");
        } else {
            dialogBuilder.setTitleImage(Integer.valueOf(R.drawable.moku_task_finished));
            if (!TextUtils.isEmpty(str)) {
                dialogBuilder.setTitleText("提交成功");
                dialogBuilder.setDetailText("预计<font color=\"#ff0000\">" + str + "</font>前审核完成，任务已全部完成，继续赚更多吧！");
            } else {
                dialogBuilder.setTitleText("+" + getTaskDataMoney() + this.mClientDetailTaskData.getCybermoneyName());
                dialogBuilder.setDetailText("任务已全部完成，继续赚更多吧！");
            }
        }
        dialogBuilder.setRightBtn(getString(R.string.moku_btn_continue), new CustomBuildDialog.DialogButtonOnClickListener() { // from class: com.fendasz.moku.diandian.model.detail.DianCpaDetailActivity$$ExternalSyntheticLambda1
            @Override // com.fendasz.moku.planet.ui.dialog.CustomBuildDialog.DialogButtonOnClickListener
            public final void onClick(TextView textView, CustomBuildDialog customBuildDialog) {
                this.f$0.m387x7e25f2ba(textView, customBuildDialog);
            }
        }).setCancelable(false);
        dialogBuilder.create().show();
    }

    /* renamed from: lambda$showEmptyTaskGroupDialog$7$com-fendasz-moku-diandian-model-detail-DianCpaDetailActivity, reason: not valid java name */
    /* synthetic */ void m387x7e25f2ba(TextView textView, CustomBuildDialog customBuildDialog) {
        customBuildDialog.dismiss();
        setResult(2);
        putSpIsShowGuideMyParticipateInTip();
        finish();
    }

    private void showFollowUpOpenGroupTaskDataDialog(String str, int i) {
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.mContext).inflate(R.layout.moku_follow_up_view, (ViewGroup) null);
        ScreenAdaptationUtils.setHeight(this.mContext, (ImageView) relativeLayout.findViewById(R.id.iv_follow_up_bg), 558);
        ScreenAdaptationUtils.setPaddingTop(this.mContext, (LinearLayout) relativeLayout.findViewById(R.id.ll_container), 100);
        LinearLayout linearLayout = (LinearLayout) relativeLayout.findViewById(R.id.ll_day0);
        LinearLayout linearLayout2 = (LinearLayout) relativeLayout.findViewById(R.id.ll_day1);
        LinearLayout linearLayout3 = (LinearLayout) relativeLayout.findViewById(R.id.ll_day2);
        LinearLayout linearLayout4 = (LinearLayout) relativeLayout.findViewById(R.id.ll_day3);
        LinearLayout linearLayout5 = (LinearLayout) relativeLayout.findViewById(R.id.ll_divider1);
        LinearLayout linearLayout6 = (LinearLayout) relativeLayout.findViewById(R.id.ll_divider2);
        LinearLayout linearLayout7 = (LinearLayout) relativeLayout.findViewById(R.id.ll_divider3);
        ScreenAdaptationUtils.setHeight(this.mContext, linearLayout, 120);
        ScreenAdaptationUtils.setHeight(this.mContext, linearLayout2, 120);
        ScreenAdaptationUtils.setHeight(this.mContext, linearLayout3, 120);
        ScreenAdaptationUtils.setHeight(this.mContext, linearLayout4, 120);
        ScreenAdaptationUtils.setHeight(this.mContext, linearLayout5, 120);
        ScreenAdaptationUtils.setHeight(this.mContext, linearLayout6, 120);
        ScreenAdaptationUtils.setHeight(this.mContext, linearLayout7, 120);
        TextView textView = (TextView) relativeLayout.findViewById(R.id.tv_be_completed);
        TextView textView2 = (TextView) relativeLayout.findViewById(R.id.tv_day1);
        TextView textView3 = (TextView) relativeLayout.findViewById(R.id.tv_day2);
        TextView textView4 = (TextView) relativeLayout.findViewById(R.id.tv_day3);
        TextView textView5 = (TextView) relativeLayout.findViewById(R.id.tv_money1);
        TextView textView6 = (TextView) relativeLayout.findViewById(R.id.tv_money2);
        TextView textView7 = (TextView) relativeLayout.findViewById(R.id.tv_money3);
        textView2.setTextSize(this.phoneScreenUtils.getTipsTextSize(this.mContext));
        textView3.setTextSize(this.phoneScreenUtils.getTipsTextSize(this.mContext));
        textView4.setTextSize(this.phoneScreenUtils.getTipsTextSize(this.mContext));
        textView5.setTextSize(this.phoneScreenUtils.getSmall35TextSize(this.mContext));
        textView6.setTextSize(this.phoneScreenUtils.getSmall35TextSize(this.mContext));
        textView7.setTextSize(this.phoneScreenUtils.getSmall35TextSize(this.mContext));
        ScreenAdaptationUtils.setSize(this.mContext, textView, 100, 100);
        ScreenAdaptationUtils.setSize(this.mContext, textView2, 100, 100);
        ScreenAdaptationUtils.setSize(this.mContext, textView3, 100, 100);
        textView5.setText("+" + getTaskDataMoney() + "");
        if (this.mTaskDetailView.getFollowUpOpenGroupTaskDataList().size() >= 1) {
            ClientGroupTaskData clientGroupTaskData = this.mTaskDetailView.getFollowUpOpenGroupTaskDataList().get(0);
            textView2.setText(getLongDay(clientGroupTaskData.getOpenDateTime()) + "");
            textView6.setText("+" + clientGroupTaskData.getShowMoney() + "");
        }
        if (this.mTaskDetailView.getFollowUpOpenGroupTaskDataList().size() >= 2) {
            ClientGroupTaskData clientGroupTaskData2 = this.mTaskDetailView.getFollowUpOpenGroupTaskDataList().get(1);
            textView3.setText(getLongDay(clientGroupTaskData2.getOpenDateTime()) + "");
            textView7.setText("+" + clientGroupTaskData2.getShowMoney() + "");
        }
        CustomBuildDialog.DialogBuilder dialogBuilder = new CustomBuildDialog.DialogBuilder(this.mContext);
        if (i == 2) {
            dialogBuilder.setTitleImage(Integer.valueOf(R.drawable.moku_answer_incorrect));
            dialogBuilder.setTitleText(getString(R.string.moku_answer_incorrect_title));
            dialogBuilder.setDetailText(getString(R.string.moku_answer_incorrect_content_for_follow_up_task_group));
        } else {
            dialogBuilder.setTitleImage(Integer.valueOf(R.drawable.moku_task_finished));
            if (!TextUtils.isEmpty(str)) {
                dialogBuilder.setTitleText("提交成功");
                dialogBuilder.setDetailText("预计<font color=\"#ff0000\">" + str + "</font>前审核完成");
            } else {
                dialogBuilder.setTitleText("+" + getTaskDataMoney() + this.mClientDetailTaskData.getCybermoneyName());
            }
        }
        dialogBuilder.setCustomView(relativeLayout).setShowClose(true).setDialogWidth(980).setCancelable(false);
        dialogBuilder.create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onInitStatusComplete() {
        Button button;
        Log.d(TAG, "onInitStatusComplete invoke," + currentTimeMillis());
        ClientDetailTaskData clientDetailTaskData = this.mClientDetailTaskData;
        if (clientDetailTaskData != null && clientDetailTaskData.isCheckUsage() && this.mClientDetailTaskData.isApplyRecordNullOrCanceled() && this.mClientDetailTaskData.isNewTaskGroup() && MokuUtils.isAppExistEver(this.mContext, this.mClientDetailTaskData.getPackageName()) && (button = this.mBtnStartTask) != null) {
            button.setText(this.mContext.getString(R.string.moku_start_task_btn_text_pkg_exist));
            this.mBtnStartTask.setEnabled(false);
        }
        ApiTaskOperationHelper apiTaskOperationHelper = this.mApiTaskOperationHelper;
        if (apiTaskOperationHelper != null && apiTaskOperationHelper.getOperationEnum() != null) {
            if (this.mApiTaskOperationHelper.getOperationEnum().equals(OperationEnum.SUCCESS_SUBMIT) && this.mClientDetailTaskData.getClassify().equals("cpa") && this.mClientDetailTaskData.getTaskData().getCpaType().equals(MokuConstants.CPA_TYPE_NORMAL) && !this.isStartSubmitCpaNormalTask) {
                this.isStartSubmitCpaNormalTask = true;
                checkAndSubmit(new Action() { // from class: com.fendasz.moku.diandian.model.detail.DianCpaDetailActivity.22
                    @Override // io.reactivex.functions.Action
                    public void run() throws Exception {
                        DianCpaDetailActivity.this.submitNormalTask();
                    }
                });
                return;
            }
            return;
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void applyTask(final boolean z) {
        Log.d(TAG, "apply task invoke,time:" + currentTimeMillis());
        Integer num = this.locationStatus;
        if (num != null && 1 == num.intValue()) {
            Integer numQueryLocationInfo = queryLocationInfo();
            LogUtils.logD(TAG, "applyTask queryLocationInfo:" + numQueryLocationInfo);
            if (numQueryLocationInfo == null || numQueryLocationInfo.intValue() != 1) {
                LoadingDialog.dismiss();
                return;
            }
        }
        Log.d(TAG, "apply task show loading dialog");
        LoadingDialog.show(this.mContext);
        if (PermissionUtils.hasLocationPermissions(this)) {
            Log.d(TAG, "apply task getSimCardInfo");
            GetInfoUtil.getSimCardInfo(this, this);
        }
        final Integer numCheckIsCanStartTask = this.mApiTaskOperationHelper.checkIsCanStartTask(this.mContext);
        if (numCheckIsCanStartTask.equals(MokuConstants.CHECK_CAN_START_TASK)) {
            Log.d(TAG, "apply task start request apply task:" + currentTimeMillis());
            ApiDataHelper.getApiDataHelper().dianApplyTask(this.mContext, this.mClientDetailTaskData.getTaskDataId(), new ApiDataCallBack<TaskDataApplyRecord>() { // from class: com.fendasz.moku.diandian.model.detail.DianCpaDetailActivity.23
                @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
                public void success(int i, TaskDataApplyRecord taskDataApplyRecord) throws Exception {
                    Log.d(DianCpaDetailActivity.TAG, "apply task request success,dismiss loading dialog");
                    Toast.makeText(DianCpaDetailActivity.this.mContext, "任务开始了，按任务要求完成吧~", 0).show();
                    DianCpaDetailActivity.this.mClientDetailTaskData.setTaskDataApplyRecord(taskDataApplyRecord);
                    DianCpaDetailActivity.this.mExpirationTime = taskDataApplyRecord.getExpirationTime();
                    DianCpaDetailActivity.this.startCountDown();
                    DianCpaDetailActivity.this.setResult(300);
                    for (int i2 = 0; i2 < DianCpaDetailActivity.this.etFormList.size(); i2++) {
                        ((EditText) DianCpaDetailActivity.this.etFormList.get(i2)).setEnabled(true);
                    }
                    if (DianCpaDetailActivity.this.mClientDetailTaskData.getClassify().equals("comment")) {
                        if (taskDataApplyRecord.getStatus().equals(TaskDataApplyRecord.STATUS_OF_APPLYING)) {
                            if (DianCpaDetailActivity.this.mTvCommentContent != null) {
                                DianCpaDetailActivity.this.mTvCommentContent.setEnabled(true);
                                DianCpaDetailActivity.this.mTvCommentContent.setText(!TextUtils.isEmpty(taskDataApplyRecord.getTaskDataCommentData().getTaskDataCommentData()) ? taskDataApplyRecord.getTaskDataCommentData().getTaskDataCommentData() : "");
                            }
                            if (DianCpaDetailActivity.this.mTvBtnCommentCopy != null) {
                                DianCpaDetailActivity.this.mTvBtnCommentCopy.setEnabled(true);
                            }
                        }
                        if (DianCpaDetailActivity.this.mTvCommentContent != null && DianCpaDetailActivity.this.mTvCommentContent.isEnabled()) {
                            try {
                                SystemUtils.copyToClipboard(DianCpaDetailActivity.this.mContext, "comment", DianCpaDetailActivity.this.mTvCommentContent.getText().toString());
                                Toast.makeText(DianCpaDetailActivity.this.mContext, "评论已复制到剪贴板", 0).show();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    Log.d(DianCpaDetailActivity.TAG, "apply task success,init mApiTaskOperationHelper," + DianCpaDetailActivity.this.currentTimeMillis());
                    DianCpaDetailActivity.this.mApiTaskOperationHelper.init(DianCpaDetailActivity.this.mContext);
                    if (z) {
                        Log.d(DianCpaDetailActivity.TAG, "apply task isAutoStartTask,executeTask," + DianCpaDetailActivity.this.currentTimeMillis());
                        DianCpaDetailActivity.this.executeTask();
                    }
                    DianCpaDetailActivity.this.onInitStatusComplete();
                    Integer checkTheState = taskDataApplyRecord.getCheckTheState();
                    Log.d(DianCpaDetailActivity.TAG, "apply task checkTheState:" + numCheckIsCanStartTask + ":" + DianCpaDetailActivity.this.currentTimeMillis());
                    if (checkTheState == null || 1 != checkTheState.intValue()) {
                        return;
                    }
                    DianCpaDetailActivity.this.uplodatePackage();
                }

                @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
                public void error(int i, String str) throws Exception {
                    LoadingDialog.dismiss();
                    LogUtils.log(DianCpaDetailActivity.TAG, "code:" + i + " message:" + str);
                    if (i == 5007) {
                        DianCpaDetailActivity.this.showErrorDialog(str);
                    } else if ("系统异常".equals(str)) {
                        Toast.makeText(DianCpaDetailActivity.this.mContext, "申请失败，设备/账号已申请该任务" + i, 1).show();
                    } else {
                        Toast.makeText(DianCpaDetailActivity.this.mContext, str + i, 1).show();
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
                dialogBuilder.setLeftBtn(this.mContext.getString(R.string.moku_btn_no), new CustomBuildDialog.DialogButtonOnClickListener() { // from class: com.fendasz.moku.diandian.model.detail.DianCpaDetailActivity.25
                    @Override // com.fendasz.moku.planet.ui.dialog.CustomBuildDialog.DialogButtonOnClickListener
                    public void onClick(TextView textView, CustomBuildDialog customBuildDialog) {
                        customBuildDialog.dismiss();
                    }
                }).setRightBtn(this.mContext.getString(R.string.moku_uninstall), new CustomBuildDialog.DialogButtonOnClickListener() { // from class: com.fendasz.moku.diandian.model.detail.DianCpaDetailActivity.24
                    @Override // com.fendasz.moku.planet.ui.dialog.CustomBuildDialog.DialogButtonOnClickListener
                    public void onClick(TextView textView, CustomBuildDialog customBuildDialog) {
                        customBuildDialog.dismiss();
                        SystemUtils.uninstallApp(DianCpaDetailActivity.this.mContext, DianCpaDetailActivity.this.mClientDetailTaskData.getPackageName());
                    }
                });
            } else {
                dialogBuilder.setRightBtn(this.mContext.getString(R.string.moku_btn_ok), new CustomBuildDialog.DialogButtonOnClickListener() { // from class: com.fendasz.moku.diandian.model.detail.DianCpaDetailActivity.26
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
    public void cancelTask(ClientDetailTaskData clientDetailTaskData, final Consumer<TaskDataApplyRecord> consumer) {
        LoadingDialog.show(this.mContext);
        ApiDataHelper.getApiDataHelper().dianCancelTask(this.mContext, clientDetailTaskData, new ApiDataCallBack<TaskDataApplyRecord>() { // from class: com.fendasz.moku.diandian.model.detail.DianCpaDetailActivity.27
            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void success(int i, TaskDataApplyRecord taskDataApplyRecord) throws Exception {
                LoadingDialog.dismiss();
                DianCpaDetailActivity.this.setResult(300);
                Consumer consumer2 = consumer;
                if (consumer2 != null) {
                    consumer2.accept(taskDataApplyRecord);
                }
            }

            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void error(int i, String str) throws Exception {
                LoadingDialog.dismiss();
                LogUtils.log(DianCpaDetailActivity.TAG, "code:" + i + " message:" + str);
                Toast.makeText(DianCpaDetailActivity.this.mContext, str + i, 1).show();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void submitCpaTask() throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, ClassNotFoundException, SecurityException, IllegalArgumentException, InvocationTargetException {
        LoadingDialog.show(this.mContext);
        AliyunHelper.getInstance().uploadDeviceToken(this.mContext, null);
        MokuConfigure.getInstance().updateUserType(this.mContext, 2);
        MokuConfigure.getInstance().updateSubmitTaskDataId(this.mContext, this.mClientDetailTaskData.getTaskDataId());
        ApiDataHelper.getApiDataHelper().uploadDeviceInfo(this, new ApiDataCallBack<Object>() { // from class: com.fendasz.moku.diandian.model.detail.DianCpaDetailActivity.28
            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void success(int i, Object obj) throws Exception {
                Log.d(DianCpaDetailActivity.TAG, "upload device info success");
                DianCpaDetailActivity.this.doSubmitCpaTask();
            }

            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void error(int i, String str) throws Exception {
                LogUtils.logE(DianCpaDetailActivity.TAG, "upload device info error,code=>" + i + ",message" + str);
                DianCpaDetailActivity.this.doSubmitCpaTask();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doSubmitCpaTask() {
        String json;
        List<String> list = this.answerList;
        if (list != null && !list.isEmpty()) {
            json = this.gson.toJson(this.answerList);
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.mAnswer);
            json = this.gson.toJson(arrayList);
        }
        ApiDataHelper.getApiDataHelper().dianSubmitTask(this.mContext, this.mClientDetailTaskData, json, this.formDatas, this.mAdditionalData, new AnonymousClass29());
    }

    /* renamed from: com.fendasz.moku.diandian.model.detail.DianCpaDetailActivity$29, reason: invalid class name */
    class AnonymousClass29 implements ApiDataCallBack<String> {
        AnonymousClass29() {
        }

        @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
        public void success(int i, String str) throws Exception {
            CpaData cpaData;
            LoadingDialog.dismiss();
            DianCpaDetailActivity.this.submitSuccessResult();
            DianCpaDetailActivity.this.setResult(300);
            if (DianCpaDetailActivity.this.mllAnswerList != null) {
                for (int i2 = 0; i2 < DianCpaDetailActivity.this.mllAnswerList.size(); i2++) {
                    ((LinearLayout) DianCpaDetailActivity.this.mllAnswerList.get(i2)).setBackground(DianCpaDetailActivity.this.getResources().getDrawable(R.drawable.moku_gray_border_rectangle_shape));
                }
            }
            if (TextUtils.isEmpty(str) || (cpaData = (CpaData) DianCpaDetailActivity.this.gson.fromJson(str, CpaData.class)) == null) {
                return;
            }
            if (!cpaData.isFlag()) {
                if (cpaData.getCount().intValue() == 1) {
                    LogUtils.log(DianCpaDetailActivity.TAG, "answer incorrect firstly");
                    if (cpaData.getFlags() == null || cpaData.getFlags().isEmpty()) {
                        DianCpaDetailActivity.this.showAnswerTips();
                        return;
                    } else {
                        DianCpaDetailActivity.this.showAnswerTips(cpaData.getFlags());
                        return;
                    }
                }
                if (cpaData.getCount().intValue() == 2) {
                    LogUtils.log(DianCpaDetailActivity.TAG, "answer incorrect secondly");
                    if (DianCpaDetailActivity.this.isTaskGroup) {
                        DianCpaDetailActivity.this.submitTaskGroupInitSpAndDialog(null, 2);
                    } else {
                        new CustomBuildDialog.DialogBuilder(DianCpaDetailActivity.this.mContext).setTitleImage(Integer.valueOf(R.drawable.moku_answer_incorrect)).setTitleText(DianCpaDetailActivity.this.getString(R.string.moku_answer_incorrect_title)).setDetailText(DianCpaDetailActivity.this.getString(R.string.moku_answer_incorrect_content)).setRightBtn(DianCpaDetailActivity.this.getString(R.string.moku_btn_ok), new CustomBuildDialog.DialogButtonOnClickListener() { // from class: com.fendasz.moku.diandian.model.detail.DianCpaDetailActivity$29$$ExternalSyntheticLambda0
                            @Override // com.fendasz.moku.planet.ui.dialog.CustomBuildDialog.DialogButtonOnClickListener
                            public final void onClick(TextView textView, CustomBuildDialog customBuildDialog) {
                                this.f$0.m395xc6a25521(textView, customBuildDialog);
                            }
                        }).setCancelable(false).create().show();
                    }
                    DianCpaDetailActivity.this.sendTaskSubmitBroadcast();
                    return;
                }
                return;
            }
            LogUtils.log(DianCpaDetailActivity.TAG, "answer right");
            DianCpaDetailActivity.this.hideTips();
            if (DianCpaDetailActivity.this.isTaskGroup) {
                DianCpaDetailActivity.this.submitTaskGroupInitSpAndDialog(null, 1);
            } else {
                new CustomBuildDialog.DialogBuilder(DianCpaDetailActivity.this.mContext).setTitleImage(Integer.valueOf(R.drawable.moku_task_finished)).setTitleText("+" + DianCpaDetailActivity.this.mClientDetailTaskData.getShowMoney() + DianCpaDetailActivity.this.mClientDetailTaskData.getCybermoneyName()).setDetailText(DianCpaDetailActivity.this.getString(R.string.moku_task_continue_content)).setRightBtn(DianCpaDetailActivity.this.getString(R.string.moku_btn_continue), new CustomBuildDialog.DialogButtonOnClickListener() { // from class: com.fendasz.moku.diandian.model.detail.DianCpaDetailActivity$29$$ExternalSyntheticLambda1
                    @Override // com.fendasz.moku.planet.ui.dialog.CustomBuildDialog.DialogButtonOnClickListener
                    public final void onClick(TextView textView, CustomBuildDialog customBuildDialog) {
                        this.f$0.m396x1461cd22(textView, customBuildDialog);
                    }
                }).setCancelable(false).create().show();
            }
            DianCpaDetailActivity.this.sendTaskSubmitBroadcast();
        }

        /* renamed from: lambda$success$0$com-fendasz-moku-diandian-model-detail-DianCpaDetailActivity$29, reason: not valid java name */
        /* synthetic */ void m395xc6a25521(TextView textView, CustomBuildDialog customBuildDialog) {
            customBuildDialog.dismiss();
            DianCpaDetailActivity.this.finish();
        }

        /* renamed from: lambda$success$1$com-fendasz-moku-diandian-model-detail-DianCpaDetailActivity$29, reason: not valid java name */
        /* synthetic */ void m396x1461cd22(TextView textView, CustomBuildDialog customBuildDialog) {
            customBuildDialog.dismiss();
            DianCpaDetailActivity.this.putSpIsShowGuideMyParticipateInTip();
            DianCpaDetailActivity.this.finish();
        }

        @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
        public void error(int i, String str) throws Exception {
            LoadingDialog.dismiss();
            if (DianCpaDetailActivity.this.mllAnswerList != null) {
                for (int i2 = 0; i2 < DianCpaDetailActivity.this.mllAnswerList.size(); i2++) {
                    ((LinearLayout) DianCpaDetailActivity.this.mllAnswerList.get(i2)).setBackground(DianCpaDetailActivity.this.getResources().getDrawable(R.drawable.moku_gray_border_rectangle_shape));
                }
            }
            LogUtils.log(DianCpaDetailActivity.TAG, "code:" + i + " message:" + str);
            Toast.makeText(DianCpaDetailActivity.this.mContext, str + i, 1).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendTaskSubmitBroadcast() {
        Intent intent = new Intent(this.mContext.getString(R.string.moku_broadcast_name_action_task_submit));
        intent.putExtra(this.mContext.getString(R.string.moku_intent_extra__submit_task), this.gson.toJson(this.mClientDetailTaskData.getTaskData()));
        intent.setPackage(getPackageName());
        sendBroadcast(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void submitNormalTask() throws NoSuchMethodException, SecurityException {
        Log.d(TAG, "submitNormalTask invoke:" + currentTimeMillis());
        System.currentTimeMillis();
        MokuConfigure.getInstance().updateUserType(this.mContext, 2);
        MokuConfigure.getInstance().updateSubmitTaskDataId(this.mContext, this.mClientDetailTaskData.getTaskDataId());
        MokuConfigure.getInstance().updateApkFileInfo(this.mContext, this.isQQPackageExists, this.isWechatPackageExists, this.isAPPShopFileCreate, this.isAPPShopFileVisit);
        Log.d(TAG, "submitNormalTask isQQPackageExists=>" + this.isQQPackageExists + ",isWechatPackageExists=>" + this.isWechatPackageExists + ",isAPPShopFileCreate=>" + this.isAPPShopFileCreate + ",isAPPShopFileVisit=>" + this.isAPPShopFileVisit);
        Log.d(TAG, "submitNormalTask start upload device");
        ApiDataHelper.getApiDataHelper().uploadDeviceInfo(this, new ApiDataCallBack<Object>() { // from class: com.fendasz.moku.diandian.model.detail.DianCpaDetailActivity.30
            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void success(int i, Object obj) throws Exception {
                Log.d(DianCpaDetailActivity.TAG, "submitNormalTask upload device info success");
                DianCpaDetailActivity.this.doSubmitNormalTask();
            }

            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void error(int i, String str) throws Exception {
                LogUtils.logE(DianCpaDetailActivity.TAG, "submitNormalTask upload device info error,code=>" + i + ",message" + str);
                DianCpaDetailActivity.this.doSubmitNormalTask();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doSubmitNormalTask() throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        Log.d(TAG, "doSubmitNormalTask start");
        AliyunHelper.getInstance().uploadDeviceToken(this.mContext, new AliyunHelper.SessionCallBack() { // from class: com.fendasz.moku.diandian.model.detail.DianCpaDetailActivity.31
            @Override // com.fendasz.moku.planet.helper.AliyunHelper.SessionCallBack
            public void onSession(Integer num, String str, String str2) {
                if (7700 == num.intValue()) {
                    DianCpaDetailActivity.this.showToast(str);
                }
            }
        });
        ApiDataHelper.getApiDataHelper().dianSubmitTask(this.mContext, this.mClientDetailTaskData, this.fileUploadImageList, this.formDatas, this.mAdditionalData, new AnonymousClass32());
    }

    /* renamed from: com.fendasz.moku.diandian.model.detail.DianCpaDetailActivity$32, reason: invalid class name */
    class AnonymousClass32 implements ApiDataCallBack<String> {
        AnonymousClass32() {
        }

        @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
        public void success(int i, String str) throws Exception {
            Log.d(DianCpaDetailActivity.TAG, "doSubmitNormalTask success");
            MokuConfigure.getInstance().updateApkFileInfo(DianCpaDetailActivity.this.mContext, DianCpaDetailActivity.this.isQQPackageExists, DianCpaDetailActivity.this.isWechatPackageExists, DianCpaDetailActivity.this.isAPPShopFileCreate, DianCpaDetailActivity.this.isAPPShopFileVisit);
            DianCpaDetailActivity.this.submitSuccessResult();
            LoadingDialog.dismiss();
            if (DianCpaDetailActivity.this.isTaskGroup) {
                if (DianCpaDetailActivity.this.mClientDetailTaskData.getClassify().equals("cpa")) {
                    DianCpaDetailActivity.this.submitTaskGroupInitSpAndDialog(null, 1);
                } else {
                    DianCpaDetailActivity.this.submitTaskGroupInitSpAndDialog(str, 0);
                }
            } else {
                new CustomBuildDialog.DialogBuilder(DianCpaDetailActivity.this.mContext).setTitleImage(Integer.valueOf(R.drawable.moku_task_finished)).setTitleText("提交成功").setDetailText("预计<font color=\"#ff0000\">" + str + "</font>前审核完成").setRightBtn(DianCpaDetailActivity.this.getString(R.string.moku_btn_continue), new CustomBuildDialog.DialogButtonOnClickListener() { // from class: com.fendasz.moku.diandian.model.detail.DianCpaDetailActivity$32$$ExternalSyntheticLambda0
                    @Override // com.fendasz.moku.planet.ui.dialog.CustomBuildDialog.DialogButtonOnClickListener
                    public final void onClick(TextView textView, CustomBuildDialog customBuildDialog) {
                        this.f$0.m397xc6a25539(textView, customBuildDialog);
                    }
                }).setCancelable(false).create().show();
            }
            DianCpaDetailActivity.this.sendTaskSubmitBroadcast();
        }

        /* renamed from: lambda$success$0$com-fendasz-moku-diandian-model-detail-DianCpaDetailActivity$32, reason: not valid java name */
        /* synthetic */ void m397xc6a25539(TextView textView, CustomBuildDialog customBuildDialog) {
            customBuildDialog.dismiss();
            DianCpaDetailActivity.this.putSpIsShowGuideMyParticipateInTip();
            DianCpaDetailActivity.this.removeSuspendLayout();
            DianCpaDetailActivity.this.showToast("任务提交成功");
            DianCpaDetailActivity.this.setResult(300);
            DianCpaDetailActivity.this.finish();
        }

        @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
        public void error(int i, String str) throws Exception {
            LogUtils.log(DianCpaDetailActivity.TAG, "code:" + i + " message:" + str);
            MokuConfigure.getInstance().updateApkFileInfo(DianCpaDetailActivity.this.mContext, DianCpaDetailActivity.this.isQQPackageExists, DianCpaDetailActivity.this.isWechatPackageExists, DianCpaDetailActivity.this.isAPPShopFileCreate, DianCpaDetailActivity.this.isAPPShopFileVisit);
            DianCpaDetailActivity.this.setSubmitState(false);
            LoadingDialog.dismiss();
            Toast.makeText(DianCpaDetailActivity.this.mContext, str + i, 1).show();
        }
    }

    private void submitTask(final Action action) {
        List<EditText> list;
        List<ImageView> list2 = this.ivUploadImageList;
        if ((list2 != null && list2.size() > 0) || ((list = this.etFormList) != null && list.size() > 0)) {
            if (!SharedPreferencesUtils.getInstance(this.mContext).getBoolean("isNotShowSubmitTaskTip", false)) {
                final CheckBox checkBox = (CheckBox) LayoutInflater.from(this.mContext).inflate(R.layout.moku_checkbox_is_not_show_submit_task_tip, (ViewGroup) null);
                checkBox.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
                checkBox.setText("以后不再提示");
                checkBox.setTextSize(this.mPhoneScreenUtils.getSmallTextSize(this.mContext));
                new CustomBuildDialog.DialogBuilder(this.mContext).setTitleImage(Integer.valueOf(R.drawable.moku_tips_icon)).setDetailText("截图禁止修改，请勿涂鸦、裁剪。搜索任务必须使用指定搜索词，否则无奖励。").setCustomView(checkBox).setCancelable(false).setLeftBtn("我再想想", new CustomBuildDialog.DialogButtonOnClickListener() { // from class: com.fendasz.moku.diandian.model.detail.DianCpaDetailActivity.34
                    @Override // com.fendasz.moku.planet.ui.dialog.CustomBuildDialog.DialogButtonOnClickListener
                    public void onClick(TextView textView, CustomBuildDialog customBuildDialog) {
                        if (checkBox.isChecked()) {
                            SharedPreferencesUtils.getInstance(DianCpaDetailActivity.this.mContext).putBoolean("isNotShowSubmitTaskTip", true);
                        }
                        DianCpaDetailActivity.this.setSubmitState(false);
                        if (LoadingDialog.isShowing()) {
                            LoadingDialog.dismiss();
                        }
                        customBuildDialog.dismiss();
                    }
                }).setRightBtn("确认提交", new CustomBuildDialog.DialogButtonOnClickListener() { // from class: com.fendasz.moku.diandian.model.detail.DianCpaDetailActivity.33
                    @Override // com.fendasz.moku.planet.ui.dialog.CustomBuildDialog.DialogButtonOnClickListener
                    public void onClick(TextView textView, CustomBuildDialog customBuildDialog) {
                        customBuildDialog.dismiss();
                        if (checkBox.isChecked()) {
                            SharedPreferencesUtils.getInstance(DianCpaDetailActivity.this.mContext).putBoolean("isNotShowSubmitTaskTip", true);
                        }
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

    /* JADX INFO: Access modifiers changed from: private */
    public void submitSuccessResult() {
        Log.d(TAG, "submitSuccessResult");
        List<File> list = this.fileUploadImageList;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (File file : this.fileUploadImageList) {
            if (file != null && file.exists() && file.length() > 0) {
                file.delete();
            }
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
            LogUtils.logD(TAG, "listenedTag:" + listenedTag);
            if (listenedTag != null && !StringUtils.isEmpty(listenedTag)) {
                ApiDataHelper.getApiDataHelper().dianCancelWithoutMonitor(this.mContext, this.mClientDetailTaskData.getTaskDataId(), Integer.valueOf(iIntValue), new ApiDataCallBack<Object>() { // from class: com.fendasz.moku.diandian.model.detail.DianCpaDetailActivity.35
                    @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
                    public void success(int i2, Object obj) throws Exception {
                        DianCpaDetailActivity.this.mApiTaskOperationHelper.cancelTask(DianCpaDetailActivity.this.mContext);
                        DianCpaDetailActivity.this.finish();
                    }

                    @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
                    public void error(int i2, String str) throws Exception {
                        DianCpaDetailActivity.this.mApiTaskOperationHelper.cancelTask(DianCpaDetailActivity.this.mContext);
                        DianCpaDetailActivity.this.finish();
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

    /* JADX INFO: Access modifiers changed from: private */
    public void uplodatePackage() {
        Log.d(TAG, "uplodatePackage:" + currentTimeMillis());
        ApiDataHelper.getApiDataHelper().postPackages(this.mContext, new ApiDataCallBack<String>() { // from class: com.fendasz.moku.diandian.model.detail.DianCpaDetailActivity.36
            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void success(int i, String str) throws Exception {
                Log.d(DianCpaDetailActivity.TAG, "upload postPackages success:" + DianCpaDetailActivity.this.currentTimeMillis());
            }

            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void error(int i, String str) throws Exception {
                LogUtils.logE(DianCpaDetailActivity.TAG, "upload postPackages error:" + DianCpaDetailActivity.this.currentTimeMillis() + ",message=>" + str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getTaskDataStatus(final boolean z) {
        if (!LoadingDialog.isShowing()) {
            LoadingDialog.show(this.mContext);
        }
        ApiDataHelper.getApiDataHelper().dianGetTaskDataStatus(this.mContext, new ApiDataCallBack<TaskDataApplyRecord>() { // from class: com.fendasz.moku.diandian.model.detail.DianCpaDetailActivity.37
            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void success(int i, TaskDataApplyRecord taskDataApplyRecord) throws Exception {
                if (taskDataApplyRecord == null || taskDataApplyRecord.getTaskDataId().intValue() == DianCpaDetailActivity.this.mTaskDataId) {
                    DianCpaDetailActivity.this.applyTask(!z);
                } else {
                    DianCpaDetailActivity.this.showApplyingTask(taskDataApplyRecord);
                }
            }

            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void error(int i, String str) throws Exception {
                LoadingDialog.dismiss();
                LogUtils.log(DianCpaDetailActivity.TAG, "code:" + i + " message:" + str);
                Toast.makeText(DianCpaDetailActivity.this.mContext, str + i, 1).show();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void executeTask() {
        Log.d(TAG, "executeTask invoke");
        OperationEnum operationEnum = this.mApiTaskOperationHelper.getOperationEnum();
        Log.d(TAG, "executeTask operationEnum:" + operationEnum.getCode());
        if (operationEnum.equals(OperationEnum.SUCCESS_AUTO_INSTALL_APP) || operationEnum.equals(OperationEnum.SUCCESS_INSTALL_APP)) {
            showGalleryTipDialog(new Finish() { // from class: com.fendasz.moku.diandian.model.detail.DianCpaDetailActivity.38
                @Override // com.fendasz.moku.planet.interf.Finish
                public void finish() {
                    if (DianCpaDetailActivity.this.mApiTaskOperationHelper != null) {
                        DianCpaDetailActivity.this.mApiTaskOperationHelper.executeTask(DianCpaDetailActivity.this.mContext);
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

    private boolean getIsFirstCpaTask() {
        if (!this.mClientDetailTaskData.getClassify().equals("cpa")) {
            return false;
        }
        if (!this.mClientDetailTaskData.getTaskData().getCpaType().equals(MokuConstants.CPA_TYPE_NORMAL)) {
            return SharedPreferencesUtils.getInstance(this.mContext).getBoolean("dian_moku_first_cpa_answer_task", true);
        }
        return SharedPreferencesUtils.getInstance(this.mContext).getBoolean("dian_moku_first_cpa_normal_task", true);
    }

    private String getRemainTime() {
        String str = this.mExpirationTime;
        if (str == null || this.currentTime == null) {
            return "";
        }
        long time = DateUtils.getDate(str, "yyyy-MM-dd HH:mm:ss").getTime() - this.currentTime.longValue();
        return time > 0 ? DateUtils.getFormatDate(time, "小时", "分钟", "秒") : "00小时00分钟00秒";
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
    public void showAnswerTips(List<Boolean> list) {
        List<TextView> list2 = this.mTvAnswerErrorList;
        if (list2 != null) {
            if (list2.size() == list.size()) {
                for (int i = 0; i < list.size(); i++) {
                    Boolean bool = list.get(i);
                    if (bool != null && !bool.booleanValue()) {
                        this.mTvAnswerErrorList.get(i).setVisibility(0);
                    }
                }
            }
            if (this.mTvAnswerErrorTipList.size() == list.size()) {
                for (int i2 = 0; i2 < list.size(); i2++) {
                    Boolean bool2 = list.get(i2);
                    if (bool2 != null && !bool2.booleanValue()) {
                        this.mTvAnswerErrorTipList.get(i2).setVisibility(0);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void submitTaskGroupInitSpAndDialog(final String str, final int i) {
        if (SharedPreferencesUtils.getInstance(this.mContext).getInt(MokuMainActivity.TASK_GROUP_TIPS_IMAGE_VIEW_SP, 0) == 0) {
            SharedPreferencesUtils.getInstance(this.mContext).putInt(MokuMainActivity.TASK_GROUP_TIPS_IMAGE_VIEW_SP, 1);
            SharedPreferencesUtils.getInstance(this.mContext).putString(MokuMainActivity.TASK_GROUP_TIPS_DATE_SP, DateUtils.getFormatDate(SharedPreferencesUtils.getInstance(this.mContext).getLong("mokuTime", System.currentTimeMillis()), Times.YYYY_MM_DD) + " 00:00:00");
        }
        if (this.mTaskDetailView.getStayOpenGroupTaskDataList().size() > 0) {
            this.mNumberOfAttempts = 0;
            getTaskGroupDataList(this.mTaskDetailView.getStayOpenGroupTaskDataList(), new io.reactivex.functions.Consumer<List<ClientGroupTaskData>>() { // from class: com.fendasz.moku.diandian.model.detail.DianCpaDetailActivity.39
                @Override // io.reactivex.functions.Consumer
                public void accept(List<ClientGroupTaskData> list) throws Exception {
                    Integer taskDataId;
                    if (list == null || list.size() <= 0) {
                        taskDataId = null;
                    } else {
                        for (int i2 = 0; i2 < list.size(); i2++) {
                            ClientGroupTaskData clientGroupTaskData = list.get(i2);
                            if (clientGroupTaskData.getStatus().equals(ClientGroupTaskDataStatusEnum.STATUS_OF_OPENING)) {
                                taskDataId = clientGroupTaskData.getTaskDataId();
                                break;
                            }
                        }
                        taskDataId = null;
                    }
                    if (taskDataId == null) {
                        DianCpaDetailActivity.this.showEmptyTaskGroupDialog(str, i);
                        return;
                    }
                    DianCpaDetailActivity.this.mTaskDataId = taskDataId.intValue();
                    DianCpaDetailActivity.this.showTaskGroupDialog(str, i);
                }
            });
        } else {
            showEmptyTaskGroupDialog(str, i);
        }
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
            scheduledThreadPoolExecutor.scheduleAtFixedRate(new Runnable() { // from class: com.fendasz.moku.diandian.model.detail.DianCpaDetailActivity.40
                @Override // java.lang.Runnable
                public void run() {
                    ((Activity) DianCpaDetailActivity.this.mContext).runOnUiThread(new Runnable() { // from class: com.fendasz.moku.diandian.model.detail.DianCpaDetailActivity.40.1
                        @Override // java.lang.Runnable
                        public void run() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                            TaskDataApplyRecord taskDataApplyRecord;
                            if (DianCpaDetailActivity.this.currentTime != null) {
                                DianCpaDetailActivity.this.currentTime = Long.valueOf(DianCpaDetailActivity.this.currentTime.longValue() + 1000);
                                if (DianCpaDetailActivity.this.mExpirationTime != null) {
                                    if (DateUtils.getDate(DianCpaDetailActivity.this.mExpirationTime, "yyyy-MM-dd HH:mm:ss").getTime() - DianCpaDetailActivity.this.currentTime.longValue() > 0) {
                                        DianCpaDetailActivity.this.showUiTips(3);
                                        return;
                                    }
                                    LogUtils.log(DianCpaDetailActivity.TAG, "任务已超时");
                                    if (DianCpaDetailActivity.this.mClientDetailTaskData != null && (taskDataApplyRecord = DianCpaDetailActivity.this.mClientDetailTaskData.getTaskDataApplyRecord()) != null) {
                                        taskDataApplyRecord.setStatus(MokuConstants.STATUS_OF_OVERTIME);
                                    }
                                    DianCpaDetailActivity.this.mApiTaskOperationHelper.init(DianCpaDetailActivity.this.mContext);
                                    DianCpaDetailActivity.this.showUiTips(3);
                                    DianCpaDetailActivity.this.initCountDown();
                                }
                            }
                        }
                    });
                }
            }, 0L, 1L, TimeUnit.SECONDS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void putSpIsShowGuideMyParticipateInTip() {
        if (SharedPreferencesUtils.getInstance(this.mContext).getInt(this.mContext.getString(R.string.moku_sp_is_show_guide_my_participate_in_tip), 0) == 0) {
            SharedPreferencesUtils.getInstance(this.mContext).putInt(this.mContext.getString(R.string.moku_sp_is_show_guide_my_participate_in_tip), 1);
        }
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

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        String uriPath;
        super.onActivityResult(i, i2, intent);
        if (100 == i) {
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
        if (uriPath == null || TextUtils.isEmpty(uriPath) || this.fileUploadImageList.size() <= i) {
            return;
        }
        try {
            File fileCompressSize = ImageUtils.compressSize(getExternalCacheDir().getPath(), uriPath);
            if (fileCompressSize != null) {
                this.fileUploadImageList.set(i, fileCompressSize);
                this.ivUploadImageList.get(i).setImageBitmap(ImageUtils.getDecodeBitmapFromFile(this.mContext, uriPath, null, null));
                sendImageCropressBroadcast(true, null);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            sendImageCropressBroadcast(false, e2.getMessage());
        }
    }

    @Override // com.fendasz.moku.planet.ui.base.activity.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (this.suspendLayout == null || !this.isAddsuspendLayout) {
            return;
        }
        this.isAddsuspendLayout = false;
        ((WindowManager) getSystemService("window")).removeView(this.suspendLayout);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        removeSuspendLayout();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
        if (this.suspendLayout != null && this.isAddsuspendLayout) {
            this.isAddsuspendLayout = false;
            ((WindowManager) getSystemService("window")).removeView(this.suspendLayout);
        }
        LogUtils.logD(TAG, "onStart_locationStatus:" + this.locationStatus);
    }

    @Override // com.fendasz.moku.planet.ui.base.activity.BaseBackActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
        CustomBuildDialog customBuildDialog = this.mGoOnTaskDialog;
        if (customBuildDialog != null && customBuildDialog.isShowing()) {
            this.mGoOnTaskDialog.dismiss();
        }
        initSuspend();
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
    protected void onRestart() {
        super.onRestart();
        ApiTaskOperationHelper apiTaskOperationHelper = this.mApiTaskOperationHelper;
        if (apiTaskOperationHelper != null) {
            apiTaskOperationHelper.onRestart(this.mContext);
        }
        onInitStatusComplete();
    }

    @Override // com.fendasz.moku.planet.ui.base.activity.BaseBackActivity, com.fendasz.moku.planet.ui.base.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (this.suspendLayout == null || !this.isAddsuspendLayout) {
            return;
        }
        this.isAddsuspendLayout = false;
        ((WindowManager) getSystemService("window")).removeView(this.suspendLayout);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void setSubmitState(boolean z) {
        Log.d(TAG, "setSubmitState:" + z);
        this.isSubmiting = z;
    }

    private void initSuspend() {
        if (this.mClientDetailTaskData == null || !FloatingUtil.canDrawOverlays(this)) {
            return;
        }
        if ((this.mClientDetailTaskData.getTaskDataApplyRecord() != null ? this.mClientDetailTaskData.getTaskDataApplyRecord().getStatus().intValue() : 66) == 0) {
            this.isAddsuspendLayout = true;
            this.suspendLayout = FloatingUtil.getInstance().addBaseView(this, this.mClientDetailTaskData, new FloatingUtil.OnFloatingListener() { // from class: com.fendasz.moku.diandian.model.detail.DianCpaDetailActivity.41
                @Override // com.fendasz.moku.planet.utils.FloatingUtil.OnFloatingListener
                public void onFloating() {
                    if (Build.VERSION.SDK_INT < 29) {
                        FloatingUtil.getInstance().moveAppToFront(DianCpaDetailActivity.this.getApplication());
                    } else {
                        DianCpaDetailActivity.this.startActivity(new Intent(DianCpaDetailActivity.this.mContext, (Class<?>) DianCpaDetailActivity.class));
                    }
                }
            });
        }
    }

    private String getLongDay(String str) {
        String formatDate = DateUtils.getFormatDate(SharedPreferencesUtils.getInstance(this.mContext).getLong("mokuTime", System.currentTimeMillis()), "yyyy-MM-dd HH:mm:ss");
        Date date = DateUtils.getDate(str, Times.YYYY_MM_DD);
        long time = (date.getTime() - DateUtils.getDate(formatDate, Times.YYYY_MM_DD).getTime()) / 86400000;
        return time == 0 ? "今天" : time == 1 ? "明天" : DateUtils.getFormatDate(date.getTime(), "MM.dd");
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
    public void removeSuspendLayout() {
        if (this.suspendLayout == null || !this.isAddsuspendLayout) {
            return;
        }
        this.isAddsuspendLayout = false;
        ((WindowManager) getSystemService("window")).removeView(this.suspendLayout);
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
}
