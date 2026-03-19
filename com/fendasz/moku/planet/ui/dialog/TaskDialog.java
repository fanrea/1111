package com.fendasz.moku.planet.ui.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.text.Html;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.URLSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.alibaba.fastjson.JSON;
import com.fendasz.moku.diandian.model.detail.DianCPLDetailActivity;
import com.fendasz.moku.planet.R;
import com.fendasz.moku.planet.constants.MokuConstants;
import com.fendasz.moku.planet.entity.ApiDataCallBack;
import com.fendasz.moku.planet.entity.ApiOperationCallBack;
import com.fendasz.moku.planet.entity.EasyCollectionEntity;
import com.fendasz.moku.planet.entity.OperationEnum;
import com.fendasz.moku.planet.helper.ApiDataHelper;
import com.fendasz.moku.planet.helper.ApiTaskOperationHelper;
import com.fendasz.moku.planet.helper.MokuConfigure;
import com.fendasz.moku.planet.interf.Finish;
import com.fendasz.moku.planet.interf.functions.Action;
import com.fendasz.moku.planet.interf.functions.Consumer;
import com.fendasz.moku.planet.source.bean.AnserDataEntity;
import com.fendasz.moku.planet.source.bean.ClientDetailTaskData;
import com.fendasz.moku.planet.source.bean.ClientTaskDataSubmitFormModel;
import com.fendasz.moku.planet.source.bean.CpaData;
import com.fendasz.moku.planet.source.bean.CpaQuestionData;
import com.fendasz.moku.planet.source.bean.TaskDataApplyRecord;
import com.fendasz.moku.planet.source.bean.TaskDataStep;
import com.fendasz.moku.planet.ui.activity.EasyCollectionDetailActivity;
import com.fendasz.moku.planet.ui.activity.GameTaskDetailActivity;
import com.fendasz.moku.planet.ui.activity.MokuMainActivity;
import com.fendasz.moku.planet.ui.customview.ChoiceQuestionRadioGroup;
import com.fendasz.moku.planet.ui.customview.RoundRectLayout;
import com.fendasz.moku.planet.ui.dialog.CustomBuildDialog;
import com.fendasz.moku.planet.ui.dialog.ViewImageDialog;
import com.fendasz.moku.planet.utils.DateUtils;
import com.fendasz.moku.planet.utils.ImageUtils;
import com.fendasz.moku.planet.utils.LogUtils;
import com.fendasz.moku.planet.utils.MokuUtils;
import com.fendasz.moku.planet.utils.PhoneScreenUtils;
import com.fendasz.moku.planet.utils.ScreenAdaptationUtils;
import com.fendasz.moku.planet.utils.SharedPreferencesUtils;
import com.fendasz.moku.planet.utils.StringUtils;
import com.fendasz.moku.planet.utils.StyleUtils;
import com.fendasz.moku.planet.utils.ThreadUtils;
import com.fendasz.moku.planet.utils.canvas.CanvasUtils;
import com.fendasz.moku.planet.utils.system.utils.SystemUtils;
import com.google.gson.Gson;
import com.pandora.common.utils.Times;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class TaskDialog {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int CODE_COUNT_DOWN = 3;
    private static final int CODE_START_TASK = 0;
    private static final int CODE_SUBMIT_ANSWER = 5;
    private static final int CODE_TASK_STATUS = 4;
    private static final int CODE_UPLOAD_SCREENSHOT = 1;
    private static final int CODE_VIEW_INIT = 2;
    private static final String TAG = "TaskDialog";
    private List<EditText> answerEditList;
    private List<String> answerList;
    private long clickTime;
    private boolean cplSort;
    private Long currentTime;
    private List<EditText> etFormList;
    private List<ClientTaskDataSubmitFormModel> formDatas;
    private boolean isDian;
    private boolean isStartSubmitCpaNormalTask;
    private boolean isTaskGroup;
    private String mAdditionalData;
    private ApiTaskOperationHelper mApiTaskOperationHelper;
    private Button mBtnSubmit;
    private ChoiceQuestionRadioGroup mChoiceQuestionRadioGroup;
    private Config mConfig;
    private Context mContext;
    private Dialog mDialog;
    private EditText mEtInput;
    private List<EditText> mEtInputList;
    private String mExpirationTime;
    private boolean mIsNeedRefresh;
    private boolean mIsSubmit;
    private LinearLayout mLlChangeTaskContainer;
    private LinearLayout mLlDialogContainer;
    private OnDialogClosed mOnDialogClosed;
    private ProgressBar mPbDownload;
    private PhoneScreenUtils mPhoneScreenUtils;
    private RelativeLayout mRlProgressBar;
    private TextView mTvAnswerError;
    private List<TextView> mTvAnswerErrorList;
    private TextView mTvAnswerErrorTip;
    private List<TextView> mTvAnswerErrorTipList;
    private TextView mTvDownload;
    private ScheduledThreadPoolExecutor scheduled;

    public static class Config {
        boolean cancelable = false;
        ClientDetailTaskData clientDetailTaskData;
    }

    public interface OnDialogClosed {
        void onClosed(boolean z);
    }

    private void initData() {
    }

    private void initDynamicData() {
    }

    private void initListener() {
    }

    /* synthetic */ TaskDialog(Context context, Config config, AnonymousClass1 anonymousClass1) {
        this(context, config);
    }

    private TaskDialog(Context context, Config config) {
        this.mIsSubmit = false;
        this.currentTime = null;
        this.scheduled = null;
        this.clickTime = 0L;
        this.isStartSubmitCpaNormalTask = false;
        this.mIsNeedRefresh = false;
        this.cplSort = false;
        this.isDian = false;
        initLoad(context, config);
    }

    public void show() throws NoSuchMethodException, SecurityException {
        initLoad();
        initView();
        initData();
        initListener();
        onReady(false);
        this.mDialog.show();
        WindowManager.LayoutParams attributes = this.mDialog.getWindow().getAttributes();
        attributes.width = -1;
        attributes.height = -1;
        this.mDialog.getWindow().setAttributes(attributes);
        cpaLog("4", 1);
    }

    private void initLoad() {
        this.mAdditionalData = MokuConfigure.getInstance().getMokuOptions(this.mContext).getString("additionalData", null);
    }

    public void dismiss() {
        ApiDataHelper.getApiDataHelper().clearPopupTask();
        this.mDialog.dismiss();
        destroy();
        OnDialogClosed onDialogClosed = this.mOnDialogClosed;
        if (onDialogClosed != null) {
            onDialogClosed.onClosed(this.mIsNeedRefresh);
        }
    }

    private void onReady(boolean z) throws NoSuchMethodException, SecurityException {
        initDynamicLoad();
        initDynamicView();
        initDynamicData();
        initDynamicListener();
        onDynamicReady(z);
    }

    private void onDynamicReady(boolean z) throws NoSuchMethodException, SecurityException {
        if (z) {
            this.mApiTaskOperationHelper.init(this.mContext);
        } else {
            this.mApiTaskOperationHelper.onRestart(this.mContext);
        }
        onInitComplete();
    }

    public void setDian(boolean z) {
        this.isDian = z;
    }

    public boolean getDian() {
        return this.isDian;
    }

    /* renamed from: com.fendasz.moku.planet.ui.dialog.TaskDialog$1, reason: invalid class name */
    class AnonymousClass1 implements View.OnClickListener {
        AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) throws NoSuchMethodException, SecurityException {
            boolean z;
            List<String> formList;
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - TaskDialog.this.clickTime > 1000) {
                TaskDialog.this.clickTime = jCurrentTimeMillis;
                if (!TaskDialog.this.mIsSubmit) {
                    if (TaskDialog.this.isCpl()) {
                        if (TaskDialog.this.isDian) {
                            Intent intent = new Intent(TaskDialog.this.mContext, (Class<?>) DianCPLDetailActivity.class);
                            intent.putExtra("taskDataId", TaskDialog.this.mConfig.clientDetailTaskData.getTaskDataId().intValue());
                            String gateType = TaskDialog.this.mConfig.clientDetailTaskData.getGateType();
                            if (!TextUtils.isEmpty(gateType)) {
                                intent.putExtra("gateType", gateType);
                            }
                            intent.putExtra(TaskDialog.this.mContext.getString(R.string.moku_intent_extra_cpl_from_type_key), 1001);
                            TaskDialog.this.mContext.startActivity(intent);
                            TaskDialog.this.dismiss();
                            return;
                        }
                        Intent intent2 = new Intent(TaskDialog.this.mContext, (Class<?>) GameTaskDetailActivity.class);
                        intent2.putExtra("taskDataId", TaskDialog.this.mConfig.clientDetailTaskData.getTaskDataId().intValue());
                        String gateType2 = TaskDialog.this.mConfig.clientDetailTaskData.getGateType();
                        if (!TextUtils.isEmpty(gateType2)) {
                            intent2.putExtra("gateType", gateType2);
                        }
                        intent2.putExtra(TaskDialog.this.mContext.getString(R.string.moku_intent_extra_cpl_from_type_key), 1001);
                        TaskDialog.this.mContext.startActivity(intent2);
                        TaskDialog.this.dismiss();
                        return;
                    }
                    if (!TaskDialog.this.isEasyCollectionTask()) {
                        OperationEnum operationEnum = TaskDialog.this.mApiTaskOperationHelper.getOperationEnum();
                        if (operationEnum.equals(OperationEnum.SUCCESS_START)) {
                            TaskDialog.this.getTaskDataStatus(new Consumer<TaskDataApplyRecord>() { // from class: com.fendasz.moku.planet.ui.dialog.TaskDialog.1.2
                                @Override // com.fendasz.moku.planet.interf.functions.Consumer
                                public void accept(TaskDataApplyRecord taskDataApplyRecord) throws Exception {
                                    if (taskDataApplyRecord == null || taskDataApplyRecord.getTaskDataId().equals(TaskDialog.this.mConfig.clientDetailTaskData.getTaskDataId())) {
                                        TaskDialog.this.applyTask();
                                    } else {
                                        TaskDialog.this.cancelTask(taskDataApplyRecord.getTaskDataId().intValue(), taskDataApplyRecord.getId().intValue(), new Consumer<TaskDataApplyRecord>() { // from class: com.fendasz.moku.planet.ui.dialog.TaskDialog.1.2.1
                                            @Override // com.fendasz.moku.planet.interf.functions.Consumer
                                            public void accept(TaskDataApplyRecord taskDataApplyRecord2) throws Exception {
                                                TaskDialog.this.applyTask();
                                            }
                                        });
                                    }
                                }
                            });
                            return;
                        }
                        if (operationEnum.equals(OperationEnum.SUCCESS_SUBMIT)) {
                            if (TaskDialog.this.mConfig.clientDetailTaskData.getTaskData() == null || TaskDialog.this.mConfig.clientDetailTaskData.getTaskData().getTaskDataDetail() == null) {
                                List<String> formList2 = TaskDialog.this.mConfig.clientDetailTaskData.getFormList();
                                if (formList2 != null && !formList2.isEmpty()) {
                                    z = true;
                                    break;
                                }
                                z = false;
                            } else {
                                List<CpaQuestionData> cpaQuestionData = TaskDialog.this.mConfig.clientDetailTaskData.getTaskData().getTaskDataDetail().getCpaQuestionData();
                                if (cpaQuestionData != null && !cpaQuestionData.isEmpty()) {
                                    Iterator<CpaQuestionData> it = cpaQuestionData.iterator();
                                    while (it.hasNext()) {
                                        Integer questionType = it.next().getQuestionType();
                                        if (questionType != null && (1 == questionType.intValue() || (3 == questionType.intValue() && (formList = TaskDialog.this.mConfig.clientDetailTaskData.getFormList()) != null && !formList.isEmpty()))) {
                                            z = true;
                                            break;
                                        }
                                    }
                                }
                                z = false;
                            }
                            if (z) {
                                if (TaskDialog.this.isCpaFrom()) {
                                    if (TaskDialog.this.mApiTaskOperationHelper.getOperationEnum() != OperationEnum.SUCCESS_SUBMIT) {
                                        TaskDialog.this.showUiTips(5);
                                        return;
                                    }
                                    if (TaskDialog.this.mEtInputList != null) {
                                        try {
                                            for (EditText editText : TaskDialog.this.mEtInputList) {
                                                if (TextUtils.isEmpty(editText.getText().toString().trim())) {
                                                    Toast.makeText(TaskDialog.this.mContext, "请选择或填写答案", 0).show();
                                                    return;
                                                } else {
                                                    Object tag = editText.getTag();
                                                    if (tag != null) {
                                                        TaskDialog.this.answerList.set(Integer.valueOf(Integer.parseInt(tag.toString())).intValue() - 1, editText.getText().toString());
                                                    }
                                                }
                                            }
                                        } catch (Exception unused) {
                                        }
                                    }
                                    if (TaskDialog.this.etFormList != null && !TaskDialog.this.etFormList.isEmpty()) {
                                        for (int i = 0; i < TaskDialog.this.etFormList.size(); i++) {
                                            String string = ((EditText) TaskDialog.this.etFormList.get(i)).getText().toString();
                                            if (TextUtils.isEmpty(string)) {
                                                Toast.makeText(TaskDialog.this.mContext, "请输入" + ((ClientTaskDataSubmitFormModel) TaskDialog.this.formDatas.get(i)).getKey(), 0).show();
                                                return;
                                            } else if (!((ClientTaskDataSubmitFormModel) TaskDialog.this.formDatas.get(i)).getKey().contains("手机") || (string.length() == 11 && StringUtils.isNumber(string))) {
                                                ((ClientTaskDataSubmitFormModel) TaskDialog.this.formDatas.get(i)).setValue(string);
                                            } else {
                                                Toast.makeText(TaskDialog.this.mContext, "手机格式错误", 0).show();
                                                return;
                                            }
                                        }
                                    }
                                    if (TaskDialog.this.mChoiceQuestionRadioGroup == null || TaskDialog.this.mChoiceQuestionRadioGroup.isAllTrue()) {
                                        LoadingDialog.show(TaskDialog.this.mContext);
                                        ThreadUtils.runOnChildThread(new Runnable() { // from class: com.fendasz.moku.planet.ui.dialog.TaskDialog.1.3
                                            @Override // java.lang.Runnable
                                            public void run() throws NoSuchMethodException, SecurityException {
                                                TaskDialog.this.submitCpaTask(new Gson().toJson(TaskDialog.this.answerList), null);
                                            }
                                        });
                                        return;
                                    } else {
                                        Toast.makeText(TaskDialog.this.mContext, "请选择选择题选项", 0).show();
                                        return;
                                    }
                                }
                                SystemUtils.openPackage(TaskDialog.this.mContext, TaskDialog.this.mConfig.clientDetailTaskData.getPackageName());
                                return;
                            }
                            TaskDialog.this.submitNormalTask();
                            return;
                        }
                        TaskDialog.this.showUiTips(0);
                        TaskDialog.this.executeTask();
                        return;
                    }
                    ApiDataHelper.getApiDataHelper().beginEasyCollection(TaskDialog.this.mConfig.clientDetailTaskData.getCollectionDataId(), TaskDialog.this.mContext, new ApiDataCallBack<EasyCollectionEntity>() { // from class: com.fendasz.moku.planet.ui.dialog.TaskDialog.1.1
                        @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
                        public void success(int i2, EasyCollectionEntity easyCollectionEntity) throws Exception {
                            Intent intent3 = new Intent(TaskDialog.this.mContext, (Class<?>) EasyCollectionDetailActivity.class);
                            intent3.putExtra("taskInfo", JSON.toJSONString(easyCollectionEntity));
                            TaskDialog.this.mContext.startActivity(intent3);
                            TaskDialog.this.dismiss();
                        }

                        @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
                        public void error(int i2, String str) throws Exception {
                            Toast.makeText(TaskDialog.this.mContext, str + i2, 1).show();
                            TaskDialog.this.changeTask(true);
                        }
                    });
                    return;
                }
                TaskDialog.this.changeTask(true);
                return;
            }
            LogUtils.log(TaskDialog.TAG, "repeat click");
            Toast.makeText(TaskDialog.this.mContext, "不要重复点击", 1).show();
        }
    }

    private void initDynamicListener() {
        RelativeLayout relativeLayout = this.mRlProgressBar;
        if (relativeLayout != null) {
            relativeLayout.setOnClickListener(new AnonymousClass1());
        }
        ChoiceQuestionRadioGroup choiceQuestionRadioGroup = this.mChoiceQuestionRadioGroup;
        if (choiceQuestionRadioGroup != null) {
            choiceQuestionRadioGroup.setOnSelectedListener(new ChoiceQuestionRadioGroup.OnSelectedListener() { // from class: com.fendasz.moku.planet.ui.dialog.TaskDialog.2
                @Override // com.fendasz.moku.planet.ui.customview.ChoiceQuestionRadioGroup.OnSelectedListener
                public boolean onSelect(int i, final String str, Integer num, final ChoiceQuestionRadioGroup.OnAnswerCallback onAnswerCallback) {
                    List<CpaQuestionData> cpaQuestionData;
                    LogUtils.log(TaskDialog.TAG, "onSelect");
                    if (TaskDialog.this.mApiTaskOperationHelper.getOperationEnum() != OperationEnum.SUCCESS_SUBMIT) {
                        TaskDialog.this.showUiTips(5);
                        return false;
                    }
                    if (TaskDialog.this.mConfig.clientDetailTaskData.getTaskData() == null || TaskDialog.this.mConfig.clientDetailTaskData.getTaskData().getTaskDataDetail() == null || (cpaQuestionData = TaskDialog.this.mConfig.clientDetailTaskData.getTaskData().getTaskDataDetail().getCpaQuestionData()) == null || cpaQuestionData.isEmpty()) {
                        TaskDialog.this.hideTips();
                        LoadingDialog.show(TaskDialog.this.mContext);
                        ThreadUtils.runOnChildThread(new Runnable() { // from class: com.fendasz.moku.planet.ui.dialog.TaskDialog.2.1
                            @Override // java.lang.Runnable
                            public void run() throws NoSuchMethodException, SecurityException {
                                TaskDialog.this.submitCpaTask(str, new Action() { // from class: com.fendasz.moku.planet.ui.dialog.TaskDialog.2.1.1
                                    @Override // com.fendasz.moku.planet.interf.functions.Action
                                    public void run() throws Exception {
                                        if (onAnswerCallback != null) {
                                            onAnswerCallback.callback(false);
                                        }
                                    }
                                });
                            }
                        });
                        return true;
                    }
                    if (num != null) {
                        TaskDialog.this.answerList.set(num.intValue() - 1, str);
                    } else {
                        TaskDialog.this.answerList.add(str);
                    }
                    return true;
                }
            });
        }
        Button button = this.mBtnSubmit;
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() { // from class: com.fendasz.moku.planet.ui.dialog.TaskDialog.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (TaskDialog.this.isCpl()) {
                        if (TaskDialog.this.isDian) {
                            Intent intent = new Intent(TaskDialog.this.mContext, (Class<?>) DianCPLDetailActivity.class);
                            intent.putExtra("taskDataId", TaskDialog.this.mConfig.clientDetailTaskData.getTaskDataId().intValue());
                            String gateType = TaskDialog.this.mConfig.clientDetailTaskData.getGateType();
                            if (!TextUtils.isEmpty(gateType)) {
                                intent.putExtra("gateType", gateType);
                            }
                            TaskDialog.this.mContext.startActivity(intent);
                            TaskDialog.this.dismiss();
                            return;
                        }
                        Intent intent2 = new Intent(TaskDialog.this.mContext, (Class<?>) GameTaskDetailActivity.class);
                        intent2.putExtra("taskDataId", TaskDialog.this.mConfig.clientDetailTaskData.getTaskDataId().intValue());
                        String gateType2 = TaskDialog.this.mConfig.clientDetailTaskData.getGateType();
                        if (!TextUtils.isEmpty(gateType2)) {
                            intent2.putExtra("gateType", gateType2);
                        }
                        TaskDialog.this.mContext.startActivity(intent2);
                        TaskDialog.this.dismiss();
                        return;
                    }
                    if (TaskDialog.this.mApiTaskOperationHelper.getOperationEnum() != OperationEnum.SUCCESS_SUBMIT) {
                        TaskDialog.this.showUiTips(5);
                        return;
                    }
                    if (TaskDialog.this.mEtInput != null) {
                        if (TextUtils.isEmpty(TaskDialog.this.mEtInput.getText().toString().trim())) {
                            Toast.makeText(TaskDialog.this.mContext, "请选择或填写答案", 0).show();
                            return;
                        }
                        final String string = TaskDialog.this.mEtInput.getText().toString();
                        LoadingDialog.show(TaskDialog.this.mContext);
                        ThreadUtils.runOnChildThread(new Runnable() { // from class: com.fendasz.moku.planet.ui.dialog.TaskDialog.3.1
                            @Override // java.lang.Runnable
                            public void run() throws NoSuchMethodException, SecurityException {
                                TaskDialog.this.submitCpaTask(string, null);
                            }
                        });
                    }
                }
            });
        }
        LinearLayout linearLayout = this.mLlChangeTaskContainer;
        if (linearLayout != null) {
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.fendasz.moku.planet.ui.dialog.TaskDialog.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TaskDialog.this.changeTask(true);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void submitCpaTask(String str, Action action) throws NoSuchMethodException, SecurityException {
        LogUtils.log(TAG, "submitCpaTask");
        MokuConfigure.getInstance().updateUserType(this.mContext, 2);
        MokuConfigure.getInstance().updateSubmitTaskDataId(this.mContext, this.mConfig.clientDetailTaskData.getTaskDataId());
        ApiDataHelper.getApiDataHelper().uploadDeviceInfo(this.mContext, new ApiDataCallBack<Object>() { // from class: com.fendasz.moku.planet.ui.dialog.TaskDialog.5
            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void success(int i, Object obj) throws Exception {
                Log.d(TaskDialog.TAG, "upload device info success");
            }

            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void error(int i, String str2) throws Exception {
                LogUtils.logE(TaskDialog.TAG, "upload device info error,code=>" + i + ",message" + str2);
            }
        });
        if (this.isDian) {
            dianSubmitTask(str, action);
        } else {
            submitTask(str, action);
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
    public void getTaskDataStatus(final Consumer<TaskDataApplyRecord> consumer) {
        LoadingDialog.show(this.mContext);
        if (this.isDian) {
            ApiDataHelper.getApiDataHelper().dianGetTaskDataStatus(this.mContext, new ApiDataCallBack<TaskDataApplyRecord>() { // from class: com.fendasz.moku.planet.ui.dialog.TaskDialog.6
                @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
                public void success(int i, TaskDataApplyRecord taskDataApplyRecord) throws Exception {
                    LoadingDialog.dismiss();
                    consumer.accept(taskDataApplyRecord);
                }

                @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
                public void error(int i, String str) throws Exception {
                    LoadingDialog.dismiss();
                    LogUtils.log(TaskDialog.TAG, "code:" + i + " message:" + str);
                    Toast.makeText(TaskDialog.this.mContext, str + i, 1).show();
                }
            });
        } else {
            ApiDataHelper.getApiDataHelper().getTaskDataStatus(this.mContext, new ApiDataCallBack<TaskDataApplyRecord>() { // from class: com.fendasz.moku.planet.ui.dialog.TaskDialog.7
                @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
                public void success(int i, TaskDataApplyRecord taskDataApplyRecord) throws Exception {
                    LoadingDialog.dismiss();
                    consumer.accept(taskDataApplyRecord);
                }

                @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
                public void error(int i, String str) throws Exception {
                    LoadingDialog.dismiss();
                    LogUtils.log(TaskDialog.TAG, "code:" + i + " message:" + str);
                    Toast.makeText(TaskDialog.this.mContext, str + i, 1).show();
                }
            });
        }
    }

    /* renamed from: com.fendasz.moku.planet.ui.dialog.TaskDialog$8, reason: invalid class name */
    class AnonymousClass8 implements Consumer<TaskDataApplyRecord> {
        AnonymousClass8() {
        }

        @Override // com.fendasz.moku.planet.interf.functions.Consumer
        public void accept(final TaskDataApplyRecord taskDataApplyRecord) throws Exception {
            if (taskDataApplyRecord == null) {
                TaskDialog.this.changeTask(false);
            } else {
                new CustomBuildDialog.DialogBuilder(TaskDialog.this.mContext).setTitleImage(Integer.valueOf(R.drawable.moku_tips_icon)).setDetailText("当前有任务正在进行，确认更换吗?").setCancelable(false).setLeftBtn("确认", new CustomBuildDialog.DialogButtonOnClickListener() { // from class: com.fendasz.moku.planet.ui.dialog.TaskDialog.8.2
                    @Override // com.fendasz.moku.planet.ui.dialog.CustomBuildDialog.DialogButtonOnClickListener
                    public void onClick(TextView textView, CustomBuildDialog customBuildDialog) {
                        customBuildDialog.dismiss();
                        TaskDialog.this.cancelTask(taskDataApplyRecord.getTaskDataId().intValue(), taskDataApplyRecord.getId().intValue(), new Consumer<TaskDataApplyRecord>() { // from class: com.fendasz.moku.planet.ui.dialog.TaskDialog.8.2.1
                            @Override // com.fendasz.moku.planet.interf.functions.Consumer
                            public void accept(TaskDataApplyRecord taskDataApplyRecord2) throws Exception {
                                TaskDialog.this.changeTask(false);
                            }
                        });
                    }
                }).setRightBtn("再等等", new CustomBuildDialog.DialogButtonOnClickListener() { // from class: com.fendasz.moku.planet.ui.dialog.TaskDialog.8.1
                    @Override // com.fendasz.moku.planet.ui.dialog.CustomBuildDialog.DialogButtonOnClickListener
                    public void onClick(TextView textView, CustomBuildDialog customBuildDialog) {
                        customBuildDialog.dismiss();
                    }
                }).create().show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeTask(boolean z) {
        if (z) {
            getTaskDataStatus(new AnonymousClass8());
            return;
        }
        LoadingDialog.show(this.mContext);
        try {
            ApiDataHelper.getApiDataHelper().changeTask(this.mContext, this.cplSort, this.isDian, new ApiDataCallBack<ClientDetailTaskData>() { // from class: com.fendasz.moku.planet.ui.dialog.TaskDialog.9
                @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
                public void success(int i, ClientDetailTaskData clientDetailTaskData) throws Exception {
                    if (clientDetailTaskData != null) {
                        TaskDialog.this.mConfig.clientDetailTaskData = clientDetailTaskData;
                        TaskDialog.this.mIsSubmit = false;
                        TaskDialog.this.refresh();
                        if (i != 1) {
                            TaskDialog.this.cpaLog("4", 3);
                            return;
                        } else {
                            LoadingDialog.dismiss();
                            Toast.makeText(TaskDialog.this.mContext, "只剩1个任务啦，看看其他任务吧~", 0).show();
                            return;
                        }
                    }
                    LoadingDialog.dismiss();
                    Toast.makeText(TaskDialog.this.mContext, "精选任务已抢完,看看其他任务吧!", 0).show();
                }

                @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
                public void error(int i, String str) throws Exception {
                    LoadingDialog.dismiss();
                    if (i == 6001 || i == 6002) {
                        Toast.makeText(TaskDialog.this.mContext, "精选任务已抢完,看看其他任务吧!", 0).show();
                    } else {
                        Toast.makeText(TaskDialog.this.mContext, "切换任务失败:" + str, 0).show();
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this.mContext, "切换任务失败", 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void applyTask() {
        LoadingDialog.show(this.mContext);
        if (this.mApiTaskOperationHelper.checkIsCanStartTask(this.mContext).equals(MokuConstants.CHECK_CAN_START_TASK)) {
            if (this.isDian) {
                ApiDataHelper.getApiDataHelper().dianApplyTask(this.mContext, this.mConfig.clientDetailTaskData.getTaskDataId(), new ApiDataCallBack<TaskDataApplyRecord>() { // from class: com.fendasz.moku.planet.ui.dialog.TaskDialog.10
                    @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
                    public void success(int i, TaskDataApplyRecord taskDataApplyRecord) throws Exception {
                        LogUtils.log(TaskDialog.TAG, "TaskDataApplyRecord >> " + JSON.toJSONString(taskDataApplyRecord));
                        Toast.makeText(TaskDialog.this.mContext, "任务开始了，按任务要求完成吧~", 0).show();
                        TaskDialog.this.mConfig.clientDetailTaskData.setTaskDataApplyRecord(taskDataApplyRecord);
                        TaskDialog.this.mExpirationTime = taskDataApplyRecord.getExpirationTime();
                        TaskDialog.this.startCountDown();
                        TaskDialog.this.mIsNeedRefresh = true;
                        TaskDialog.this.mApiTaskOperationHelper.init(TaskDialog.this.mContext);
                        TaskDialog.this.executeTask();
                        TaskDialog.this.cpaLog("5", 3);
                    }

                    @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
                    public void error(int i, String str) throws Exception {
                        LoadingDialog.dismiss();
                        LogUtils.log(TaskDialog.TAG, "code:" + i + " message:" + str);
                        if ("系统异常".equals(str)) {
                            Toast.makeText(TaskDialog.this.mContext, "申请失败，设备/账号已申请该任务" + i, 1).show();
                        } else {
                            Toast.makeText(TaskDialog.this.mContext, str + i, 1).show();
                        }
                        TaskDialog.this.cpaLog("5", 3);
                    }
                });
                return;
            } else {
                ApiDataHelper.getApiDataHelper().applyTask(this.mContext, this.mConfig.clientDetailTaskData.getTaskDataId(), new ApiDataCallBack<TaskDataApplyRecord>() { // from class: com.fendasz.moku.planet.ui.dialog.TaskDialog.11
                    @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
                    public void success(int i, TaskDataApplyRecord taskDataApplyRecord) throws Exception {
                        LogUtils.log(TaskDialog.TAG, "TaskDataApplyRecord >> " + JSON.toJSONString(taskDataApplyRecord));
                        Toast.makeText(TaskDialog.this.mContext, "任务开始了，按任务要求完成吧~", 0).show();
                        TaskDialog.this.mConfig.clientDetailTaskData.setTaskDataApplyRecord(taskDataApplyRecord);
                        TaskDialog.this.mExpirationTime = taskDataApplyRecord.getExpirationTime();
                        TaskDialog.this.startCountDown();
                        TaskDialog.this.mIsNeedRefresh = true;
                        TaskDialog.this.mApiTaskOperationHelper.init(TaskDialog.this.mContext);
                        TaskDialog.this.executeTask();
                        TaskDialog.this.cpaLog("5", 3);
                    }

                    @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
                    public void error(int i, String str) throws Exception {
                        LoadingDialog.dismiss();
                        LogUtils.log(TaskDialog.TAG, "code:" + i + " message:" + str);
                        if ("系统异常".equals(str)) {
                            Toast.makeText(TaskDialog.this.mContext, "申请失败，设备/账号已申请该任务" + i, 1).show();
                        } else {
                            Toast.makeText(TaskDialog.this.mContext, str + i, 1).show();
                        }
                        TaskDialog.this.cpaLog("5", 3);
                    }
                });
                return;
            }
        }
        LoadingDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelTask(ClientDetailTaskData clientDetailTaskData, Consumer<TaskDataApplyRecord> consumer) {
        TaskDataApplyRecord taskDataApplyRecord = clientDetailTaskData.getTaskDataApplyRecord();
        cancelTask(clientDetailTaskData.getTaskDataId().intValue(), taskDataApplyRecord != null ? taskDataApplyRecord.getId().intValue() : 0, consumer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelTask(int i, int i2, final Consumer<TaskDataApplyRecord> consumer) {
        LoadingDialog.show(this.mContext);
        if (this.isDian) {
            ApiDataHelper.getApiDataHelper().dianCancelTask(this.mContext, Integer.valueOf(i), Integer.valueOf(i2), new ApiDataCallBack<TaskDataApplyRecord>() { // from class: com.fendasz.moku.planet.ui.dialog.TaskDialog.12
                @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
                public void success(int i3, TaskDataApplyRecord taskDataApplyRecord) throws Exception {
                    LoadingDialog.dismiss();
                    TaskDialog.this.mIsNeedRefresh = true;
                    Consumer consumer2 = consumer;
                    if (consumer2 != null) {
                        consumer2.accept(taskDataApplyRecord);
                    }
                }

                @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
                public void error(int i3, String str) throws Exception {
                    LoadingDialog.dismiss();
                    LogUtils.log(TaskDialog.TAG, "code:" + i3 + " message:" + str);
                    Toast.makeText(TaskDialog.this.mContext, str + i3, 1).show();
                }
            });
        } else {
            ApiDataHelper.getApiDataHelper().cancelTask(this.mContext, Integer.valueOf(i), Integer.valueOf(i2), new ApiDataCallBack<TaskDataApplyRecord>() { // from class: com.fendasz.moku.planet.ui.dialog.TaskDialog.13
                @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
                public void success(int i3, TaskDataApplyRecord taskDataApplyRecord) throws Exception {
                    LoadingDialog.dismiss();
                    TaskDialog.this.mIsNeedRefresh = true;
                    Consumer consumer2 = consumer;
                    if (consumer2 != null) {
                        consumer2.accept(taskDataApplyRecord);
                    }
                }

                @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
                public void error(int i3, String str) throws Exception {
                    LoadingDialog.dismiss();
                    LogUtils.log(TaskDialog.TAG, "code:" + i3 + " message:" + str);
                    Toast.makeText(TaskDialog.this.mContext, str + i3, 1).show();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpaLog(String str, final int i) {
        if (i == 1 || i == 2) {
            LoadingDialog.show(this.mContext);
        }
        int iIntValue = this.mConfig.clientDetailTaskData.getTaskDataId().intValue();
        if (this.isDian) {
            ApiDataHelper.getApiDataHelper().dianCpaLog(this.mContext, str, Integer.valueOf(iIntValue), new ApiDataCallBack<Object>() { // from class: com.fendasz.moku.planet.ui.dialog.TaskDialog.14
                @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
                public void success(int i2, Object obj) throws Exception {
                    Log.d(TaskDialog.TAG, "cpaLog success");
                    int i3 = i;
                    if (i3 == 1 || i3 == 3) {
                        LoadingDialog.dismiss();
                    } else if (i3 == 4) {
                        TaskDialog.this.dismiss();
                    }
                }

                @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
                public void error(int i2, String str2) throws Exception {
                    Log.d(TaskDialog.TAG, "cpaLog error,message:" + str2);
                    int i3 = i;
                    if (i3 == 1 || i3 == 3) {
                        LoadingDialog.dismiss();
                    } else if (i3 == 4) {
                        TaskDialog.this.dismiss();
                    }
                }
            });
        } else {
            ApiDataHelper.getApiDataHelper().cpaLog(this.mContext, str, Integer.valueOf(iIntValue), new ApiDataCallBack<Object>() { // from class: com.fendasz.moku.planet.ui.dialog.TaskDialog.15
                @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
                public void success(int i2, Object obj) throws Exception {
                    Log.d(TaskDialog.TAG, "cpaLog success");
                    int i3 = i;
                    if (i3 == 1 || i3 == 3) {
                        LoadingDialog.dismiss();
                    } else if (i3 == 4) {
                        TaskDialog.this.dismiss();
                    }
                }

                @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
                public void error(int i2, String str2) throws Exception {
                    Log.d(TaskDialog.TAG, "cpaLog error,message:" + str2);
                    int i3 = i;
                    if (i3 == 1 || i3 == 3) {
                        LoadingDialog.dismiss();
                    } else if (i3 == 4) {
                        TaskDialog.this.dismiss();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void submitNormalTask() throws NoSuchMethodException, SecurityException {
        LoadingDialog.show(this.mContext);
        MokuConfigure.getInstance().updateUserType(this.mContext, 2);
        MokuConfigure.getInstance().updateSubmitTaskDataId(this.mContext, this.mConfig.clientDetailTaskData.getTaskDataId());
        ApiDataHelper.getApiDataHelper().uploadDeviceInfo(this.mContext, new ApiDataCallBack<Object>() { // from class: com.fendasz.moku.planet.ui.dialog.TaskDialog.16
            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void success(int i, Object obj) throws Exception {
                Log.d(TaskDialog.TAG, "upload device info success");
            }

            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void error(int i, String str) throws Exception {
                LogUtils.logE(TaskDialog.TAG, "upload device info error,code=>" + i + ",message" + str);
            }
        });
        if (this.isDian) {
            ApiDataHelper.getApiDataHelper().dianSubmitTask(this.mContext, this.mConfig.clientDetailTaskData, new ArrayList(), new ArrayList(), this.mAdditionalData, new ApiDataCallBack<String>() { // from class: com.fendasz.moku.planet.ui.dialog.TaskDialog.17
                @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
                public void success(int i, String str) throws Exception {
                    TaskDialog.this.cpaLog("6", 3);
                    LogUtils.log(TaskDialog.TAG, JSON.toJSONString(str));
                    TaskDialog.this.mIsNeedRefresh = true;
                    if (TaskDialog.this.isTaskGroup) {
                        TaskDialog.this.submitTaskGroupInitSp();
                    }
                    TaskDialog.this.putSpIsShowGuideMyParticipateInTip();
                    TaskDialog.this.mIsSubmit = true;
                    TaskDialog.this.refresh();
                    ApiDataHelper.getApiDataHelper().removePopuTask(TaskDialog.this.mContext);
                    TaskDialog.this.sendTaskSubmitBroadcast();
                }

                @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
                public void error(int i, String str) throws Exception {
                    LogUtils.log(TaskDialog.TAG, "code:" + i + " message:" + str);
                    TaskDialog.this.cpaLog("6", 3);
                    Toast.makeText(TaskDialog.this.mContext, str + i, 1).show();
                }
            });
        } else {
            ApiDataHelper.getApiDataHelper().submitTask(this.mContext, this.mConfig.clientDetailTaskData, new ArrayList(), new ArrayList(), this.mAdditionalData, new ApiDataCallBack<String>() { // from class: com.fendasz.moku.planet.ui.dialog.TaskDialog.18
                @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
                public void success(int i, String str) throws Exception {
                    TaskDialog.this.cpaLog("6", 3);
                    LogUtils.log(TaskDialog.TAG, JSON.toJSONString(str));
                    TaskDialog.this.mIsNeedRefresh = true;
                    if (TaskDialog.this.isTaskGroup) {
                        TaskDialog.this.submitTaskGroupInitSp();
                    }
                    TaskDialog.this.putSpIsShowGuideMyParticipateInTip();
                    TaskDialog.this.mIsSubmit = true;
                    TaskDialog.this.refresh();
                    ApiDataHelper.getApiDataHelper().removePopuTask(TaskDialog.this.mContext);
                    TaskDialog.this.sendTaskSubmitBroadcast();
                }

                @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
                public void error(int i, String str) throws Exception {
                    LogUtils.log(TaskDialog.TAG, "code:" + i + " message:" + str);
                    TaskDialog.this.cpaLog("6", 3);
                    Toast.makeText(TaskDialog.this.mContext, str + i, 1).show();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendTaskSubmitBroadcast() {
        try {
            Intent intent = new Intent(this.mContext.getString(R.string.moku_broadcast_name_action_task_submit));
            intent.putExtra(this.mContext.getString(R.string.moku_intent_extra__submit_task), new Gson().toJson(this.mConfig.clientDetailTaskData.getTaskData()));
            intent.setPackage(this.mContext.getPackageName());
            this.mContext.sendBroadcast(intent);
        } catch (Exception unused) {
            LogUtils.logE(TAG, "dialog send broad cast error");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() throws NoSuchMethodException, SecurityException {
        this.isStartSubmitCpaNormalTask = false;
        destroy();
        if (this.mIsSubmit) {
            initView();
            initDynamicView();
            initDynamicData();
            initDynamicListener();
            ChoiceQuestionRadioGroup choiceQuestionRadioGroup = this.mChoiceQuestionRadioGroup;
            if (choiceQuestionRadioGroup != null) {
                choiceQuestionRadioGroup.cleanClickMap();
                return;
            }
            return;
        }
        this.etFormList = new ArrayList();
        this.formDatas = new ArrayList();
        ChoiceQuestionRadioGroup choiceQuestionRadioGroup2 = this.mChoiceQuestionRadioGroup;
        if (choiceQuestionRadioGroup2 != null) {
            choiceQuestionRadioGroup2.cleanClickMap();
        }
        onReady(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void putSpIsShowGuideMyParticipateInTip() {
        if (SharedPreferencesUtils.getInstance(this.mContext).getInt(this.mContext.getString(R.string.moku_sp_is_show_guide_my_participate_in_tip), 0) == 0) {
            SharedPreferencesUtils.getInstance(this.mContext).putInt(this.mContext.getString(R.string.moku_sp_is_show_guide_my_participate_in_tip), 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void submitTaskGroupInitSp() {
        if (SharedPreferencesUtils.getInstance(this.mContext).getInt(MokuMainActivity.TASK_GROUP_TIPS_IMAGE_VIEW_SP, 0) == 0) {
            SharedPreferencesUtils.getInstance(this.mContext).putInt(MokuMainActivity.TASK_GROUP_TIPS_IMAGE_VIEW_SP, 1);
            SharedPreferencesUtils.getInstance(this.mContext).putString(MokuMainActivity.TASK_GROUP_TIPS_DATE_SP, DateUtils.getFormatDate(SharedPreferencesUtils.getInstance(this.mContext).getLong("mokuTime", System.currentTimeMillis()), Times.YYYY_MM_DD) + " 00:00:00");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void executeTask() {
        OperationEnum operationEnum = this.mApiTaskOperationHelper.getOperationEnum();
        if (operationEnum.equals(OperationEnum.SUCCESS_AUTO_INSTALL_APP) || operationEnum.equals(OperationEnum.SUCCESS_INSTALL_APP)) {
            showGalleryTipDialog(new Finish() { // from class: com.fendasz.moku.planet.ui.dialog.TaskDialog.19
                @Override // com.fendasz.moku.planet.interf.Finish
                public void finish() {
                    if (TaskDialog.this.mApiTaskOperationHelper != null) {
                        TaskDialog.this.mApiTaskOperationHelper.executeTask(TaskDialog.this.mContext);
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
        dialogBuilder.setCustomView(imageView).setRightBtn(this.mContext.getString(R.string.moku_dialog_btn_text__i_know), new CustomBuildDialog.DialogButtonOnClickListener() { // from class: com.fendasz.moku.planet.ui.dialog.TaskDialog.20
            @Override // com.fendasz.moku.planet.ui.dialog.CustomBuildDialog.DialogButtonOnClickListener
            public void onClick(TextView textView, CustomBuildDialog customBuildDialog) {
                customBuildDialog.dismiss();
                SharedPreferencesUtils.getInstance(TaskDialog.this.mContext).putBoolean(TaskDialog.this.mContext.getString(R.string.moku_sp_is_show_dialog_gallery_tip), false);
                Finish finish2 = finish;
                if (finish2 != null) {
                    finish2.finish();
                }
            }
        }).setCancelable(false).create().show();
    }

    private void initDynamicLoad() {
        boolean z = false;
        this.mIsSubmit = false;
        if (this.mConfig.clientDetailTaskData.getClientGroupTaskDataList() != null && this.mConfig.clientDetailTaskData.getClientGroupTaskDataList().size() > 0) {
            z = true;
        }
        this.isTaskGroup = z;
        if (this.mConfig.clientDetailTaskData.getTaskDataApplyRecord() != null && this.mConfig.clientDetailTaskData.getTaskDataApplyRecord().getStatus().equals(TaskDataApplyRecord.STATUS_OF_APPLYING)) {
            this.mExpirationTime = this.mConfig.clientDetailTaskData.getTaskDataApplyRecord().getExpirationTime();
        }
        this.mApiTaskOperationHelper = new ApiTaskOperationHelper.HelperBuilder(this.mConfig.clientDetailTaskData).setCallBack(new ApiOperationCallBack() { // from class: com.fendasz.moku.planet.ui.dialog.TaskDialog.21
            @Override // com.fendasz.moku.planet.entity.ApiOperationCallBack
            public void copyContent(OperationEnum operationEnum, String str) {
            }

            @Override // com.fendasz.moku.planet.entity.ApiOperationCallBack
            public void taskStatus(OperationEnum operationEnum) {
                LogUtils.log(TaskDialog.TAG, "operationEnum >> code:" + operationEnum.getCode() + " message:" + operationEnum.getMessage());
                TaskDialog.this.showUiTips(4);
            }

            @Override // com.fendasz.moku.planet.entity.ApiOperationCallBack
            public void downloadProgress(OperationEnum operationEnum, String str) {
                LogUtils.log(TaskDialog.TAG, "operationEnum >> " + operationEnum.getCode() + ":" + operationEnum.getMessage() + " progress >> " + str);
                int i = (int) Double.parseDouble(str);
                TaskDialog.this.mTvDownload.setText("正在下载");
                LogUtils.log(TaskDialog.TAG, "strProgress:" + (i + "%"));
                TaskDialog.this.mPbDownload.setProgress(i);
                LogUtils.log(TaskDialog.TAG, "progressValue:" + i);
            }

            @Override // com.fendasz.moku.planet.entity.ApiOperationCallBack
            public void listenerTime(OperationEnum operationEnum, int i) {
                LogUtils.log(TaskDialog.TAG, "operationEnum >> " + operationEnum.getCode() + ":" + operationEnum.getMessage() + " time >> " + i + " 分钟");
            }
        }).create();
    }

    private void onInitComplete() throws NoSuchMethodException, SecurityException {
        OperationEnum operationEnum = this.mApiTaskOperationHelper.getOperationEnum();
        if (!operationEnum.equals(OperationEnum.SUCCESS_START) && !operationEnum.equals(OperationEnum.ERROR_OVERTIME) && !operationEnum.equals(OperationEnum.ERROR_TAKEUP)) {
            startCountDown();
        }
        showUiTips(2);
        onInitStatusComplete();
    }

    private void onInitStatusComplete() throws NoSuchMethodException, SecurityException {
        if (this.mConfig.clientDetailTaskData != null && this.mConfig.clientDetailTaskData.isCheckUsage() && this.mConfig.clientDetailTaskData.isApplyRecordNullOrCanceled() && this.mConfig.clientDetailTaskData.isNewTaskGroup() && MokuUtils.isAppExistEver(this.mContext, this.mConfig.clientDetailTaskData.getPackageName())) {
            this.mRlProgressBar.setEnabled(false);
            this.mPbDownload.setProgress(0);
            Toast.makeText(this.mContext, "您已注册过该软件，换个任务试试吧", 0).show();
        }
        ApiTaskOperationHelper apiTaskOperationHelper = this.mApiTaskOperationHelper;
        if (apiTaskOperationHelper == null || apiTaskOperationHelper.getOperationEnum() == null || !this.mApiTaskOperationHelper.getOperationEnum().equals(OperationEnum.SUCCESS_SUBMIT) || !this.mConfig.clientDetailTaskData.getClassify().equals("cpa") || !this.mConfig.clientDetailTaskData.getTaskData().getCpaType().equals(MokuConstants.CPA_TYPE_NORMAL) || this.isStartSubmitCpaNormalTask) {
            return;
        }
        this.isStartSubmitCpaNormalTask = true;
        submitNormalTask();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isCpl() {
        return this.mConfig.clientDetailTaskData.getCpl() != null && this.mConfig.clientDetailTaskData.getCpl().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isEasyCollectionTask() {
        return this.mConfig.clientDetailTaskData.getEasyTaskType() != null && 3 == this.mConfig.clientDetailTaskData.getEasyTaskType().intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showUiTips(int i) {
        OperationEnum operationEnum = this.mApiTaskOperationHelper.getOperationEnum();
        if (i == 4) {
            this.mPbDownload.setProgress(100);
        }
        int i2 = AnonymousClass35.$SwitchMap$com$fendasz$moku$planet$entity$OperationEnum[operationEnum.ordinal()];
        if (i2 == 1) {
            if (i == 4) {
                if (this.isDian) {
                    this.mTvDownload.setText("立刻领奖");
                } else if (isCpl()) {
                    this.mTvDownload.setText("立即开始");
                } else if (isEasyCollectionTask()) {
                    String keyPoint = this.mConfig.clientDetailTaskData.getKeyPoint();
                    if (keyPoint != null && !StringUtils.isEmpty(keyPoint)) {
                        this.mTvDownload.setText(this.mConfig.clientDetailTaskData.getKeyPoint());
                    } else {
                        this.mTvDownload.setText("立即打开");
                    }
                } else {
                    this.mTvDownload.setText("立即安装");
                }
            }
            if (i == 5) {
                Toast.makeText(this.mContext, "答案在应用中,请先安装应用获取答案哦!", 0).show();
            }
            return;
        }
        if (i2 == 4) {
            if (i == 4 || i == 3) {
                this.mTvDownload.setText("正在下载");
            }
            if (i == 0) {
                Toast.makeText(this.mContext, "请先下载安装指定应用", 0).show();
                return;
            }
            return;
        }
        if (i2 == 9) {
            if (i == 4 || i == 3) {
                this.mTvDownload.setText("打开试玩");
            }
            if (i == 0 && this.mConfig.clientDetailTaskData.getListenerTime() != null && this.mConfig.clientDetailTaskData.getListenerTime().intValue() > 0) {
                if (this.mConfig.clientDetailTaskData.getClassify().equals("cpa") && !this.mConfig.clientDetailTaskData.getTaskData().getCpaType().equals(MokuConstants.CPA_TYPE_NORMAL)) {
                    Toast.makeText(this.mContext, "请先打开软件试玩" + this.mConfig.clientDetailTaskData.getListenerTime() + "s，即可答题", 0).show();
                } else if (this.mConfig.clientDetailTaskData.getClassify().equals("cpa") && this.mConfig.clientDetailTaskData.getTaskData().getCpaType().equals(MokuConstants.CPA_TYPE_NORMAL)) {
                    Toast.makeText(this.mContext, "请先打开软件试玩" + this.mConfig.clientDetailTaskData.getListenerTime() + "s，即可获得奖励", 0).show();
                }
            }
            if (i == 5) {
                Toast.makeText(this.mContext, "答案在应用中,请先安装应用获取答案哦!", 0).show();
                return;
            }
            return;
        }
        if (i2 == 6) {
            if (i == 4 || i == 3) {
                this.mTvDownload.setText("继续下载");
                return;
            }
            return;
        }
        if (i2 == 7) {
            if (i == 3) {
                this.mTvDownload.setText("继续下载");
            }
            if (i == 4) {
                this.mTvDownload.setText("继续下载");
                new CustomBuildDialog.DialogBuilder(this.mContext).setTitleImage(Integer.valueOf(R.drawable.moku_answer_incorrect)).setTitleText("网络异常").setRightBtn("确定", new CustomBuildDialog.DialogButtonOnClickListener() { // from class: com.fendasz.moku.planet.ui.dialog.TaskDialog.22
                    @Override // com.fendasz.moku.planet.ui.dialog.CustomBuildDialog.DialogButtonOnClickListener
                    public void onClick(TextView textView, CustomBuildDialog customBuildDialog) {
                        customBuildDialog.dismiss();
                    }
                }).setCancelable(false).create().show();
                return;
            }
            return;
        }
        switch (i2) {
            case 11:
                if (i == 4 || i == 3) {
                    this.mTvDownload.setText("立即安装");
                }
                if (i == 0) {
                    Toast.makeText(this.mContext, "请先下载安装指定应用", 0).show();
                }
                if (i == 5) {
                    Toast.makeText(this.mContext, "答案在应用中,请先安装应用获取答案哦!", 0).show();
                    break;
                }
                break;
            case 12:
                if (i == 4) {
                    this.mTvDownload.setText("立即安装");
                    executeTask();
                }
                if (i == 3) {
                    this.mTvDownload.setText("立即安装");
                    break;
                }
                break;
            case 13:
                if (i == 4) {
                    this.mTvDownload.setText("打开试玩");
                    Toast.makeText(this.mContext, "未满足时长要求，请再体验一会哦~", 0).show();
                }
                if (i == 3) {
                    this.mTvDownload.setText("打开试玩");
                }
                if (i == 5) {
                    Toast.makeText(this.mContext, "未满足时长要求，请再体验一会哦~", 0).show();
                    break;
                }
                break;
            case 14:
                if (i == 4) {
                    if (this.mConfig.clientDetailTaskData.getClassify().equals("cpa")) {
                        if (isCpaFrom()) {
                            this.mTvDownload.setText("提交答案");
                        } else {
                            this.mTvDownload.setText("打开试玩");
                        }
                    } else {
                        this.mTvDownload.setText("提交任务");
                    }
                }
                if (i == 3) {
                    if (this.mConfig.clientDetailTaskData.getClassify().equals("cpa")) {
                        if (isCpaFrom()) {
                            this.mTvDownload.setText("提交答案");
                            break;
                        } else {
                            this.mTvDownload.setText("打开试玩");
                            break;
                        }
                    } else {
                        this.mTvDownload.setText("提交任务");
                        break;
                    }
                }
                break;
            case 15:
                if (i == 4) {
                    this.mTvDownload.setText("任务超时");
                    this.mPbDownload.setProgress(0);
                }
                if (i == 2 || i == 3) {
                    new CustomBuildDialog.DialogBuilder(this.mContext).setTitleImage(Integer.valueOf(R.drawable.moku_tips_icon)).setDetailText("您的任务已经超时啦~\n需要帮您重新开始么").setCancelable(false).setLeftBtn("不了", new CustomBuildDialog.DialogButtonOnClickListener() { // from class: com.fendasz.moku.planet.ui.dialog.TaskDialog.24
                        @Override // com.fendasz.moku.planet.ui.dialog.CustomBuildDialog.DialogButtonOnClickListener
                        public void onClick(TextView textView, CustomBuildDialog customBuildDialog) {
                            customBuildDialog.dismiss();
                            TaskDialog taskDialog = TaskDialog.this;
                            taskDialog.cancelTask(taskDialog.mConfig.clientDetailTaskData, new Consumer<TaskDataApplyRecord>() { // from class: com.fendasz.moku.planet.ui.dialog.TaskDialog.24.1
                                @Override // com.fendasz.moku.planet.interf.functions.Consumer
                                public void accept(TaskDataApplyRecord taskDataApplyRecord) throws Exception {
                                    TaskDialog.this.cancelTaskCallBack(taskDataApplyRecord);
                                }
                            });
                        }
                    }).setRightBtn("重新开始", new AnonymousClass23()).create().show();
                    break;
                }
            case 16:
                if (i == 2) {
                    this.mTvDownload.setText(this.mContext.getString(R.string.moku_start_task_btn_text__take_up));
                    this.mRlProgressBar.setEnabled(false);
                    Toast.makeText(this.mContext, "这个任务已经被抢完啦~", 0).show();
                    break;
                }
                break;
            case 17:
                if (i == 4 || i == 3) {
                    this.mTvDownload.setText("跳转应用市场");
                    break;
                }
        }
    }

    /* renamed from: com.fendasz.moku.planet.ui.dialog.TaskDialog$35, reason: invalid class name */
    static /* synthetic */ class AnonymousClass35 {
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
            try {
                $SwitchMap$com$fendasz$moku$planet$entity$OperationEnum[OperationEnum.SUCCESS_OPEN_MARKETDOWNLOAD.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }

    /* renamed from: com.fendasz.moku.planet.ui.dialog.TaskDialog$23, reason: invalid class name */
    class AnonymousClass23 implements CustomBuildDialog.DialogButtonOnClickListener {
        AnonymousClass23() {
        }

        @Override // com.fendasz.moku.planet.ui.dialog.CustomBuildDialog.DialogButtonOnClickListener
        public void onClick(TextView textView, CustomBuildDialog customBuildDialog) {
            customBuildDialog.dismiss();
            TaskDialog.this.getTaskDataStatus(new Consumer<TaskDataApplyRecord>() { // from class: com.fendasz.moku.planet.ui.dialog.TaskDialog.23.1
                @Override // com.fendasz.moku.planet.interf.functions.Consumer
                public void accept(TaskDataApplyRecord taskDataApplyRecord) throws Exception {
                    if (taskDataApplyRecord == null || taskDataApplyRecord.getTaskDataId().equals(TaskDialog.this.mConfig.clientDetailTaskData.getTaskDataId())) {
                        TaskDialog.this.applyTask();
                    } else {
                        TaskDialog.this.cancelTask(taskDataApplyRecord.getTaskDataId().intValue(), taskDataApplyRecord.getId().intValue(), new Consumer<TaskDataApplyRecord>() { // from class: com.fendasz.moku.planet.ui.dialog.TaskDialog.23.1.1
                            @Override // com.fendasz.moku.planet.interf.functions.Consumer
                            public void accept(TaskDataApplyRecord taskDataApplyRecord2) throws Exception {
                                TaskDialog.this.applyTask();
                            }
                        });
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelTaskCallBack(TaskDataApplyRecord taskDataApplyRecord) {
        this.mConfig.clientDetailTaskData.setTaskDataApplyRecord(taskDataApplyRecord);
        this.mApiTaskOperationHelper.cancelTask(this.mContext);
        dismiss();
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
            scheduledThreadPoolExecutor.scheduleAtFixedRate(new Runnable() { // from class: com.fendasz.moku.planet.ui.dialog.TaskDialog.25
                @Override // java.lang.Runnable
                public void run() {
                    ((Activity) TaskDialog.this.mContext).runOnUiThread(new Runnable() { // from class: com.fendasz.moku.planet.ui.dialog.TaskDialog.25.1
                        @Override // java.lang.Runnable
                        public void run() {
                            TaskDataApplyRecord taskDataApplyRecord;
                            if (TaskDialog.this.currentTime != null) {
                                TaskDialog.this.currentTime = Long.valueOf(TaskDialog.this.currentTime.longValue() + 1000);
                                if (TaskDialog.this.mExpirationTime != null) {
                                    if (DateUtils.getDate(TaskDialog.this.mExpirationTime, "yyyy-MM-dd HH:mm:ss").getTime() - TaskDialog.this.currentTime.longValue() > 0) {
                                        TaskDialog.this.showUiTips(3);
                                        return;
                                    }
                                    LogUtils.log(TaskDialog.TAG, "任务已超时");
                                    if (TaskDialog.this.mConfig.clientDetailTaskData != null && (taskDataApplyRecord = TaskDialog.this.mConfig.clientDetailTaskData.getTaskDataApplyRecord()) != null) {
                                        taskDataApplyRecord.setStatus(MokuConstants.STATUS_OF_OVERTIME);
                                    }
                                    TaskDialog.this.mApiTaskOperationHelper.init(TaskDialog.this.mContext);
                                    TaskDialog.this.showUiTips(3);
                                    TaskDialog.this.initCountDown();
                                }
                            }
                        }
                    });
                }
            }, 0L, 1L, TimeUnit.SECONDS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initCountDown() {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = this.scheduled;
        if (scheduledThreadPoolExecutor != null) {
            if (!scheduledThreadPoolExecutor.isShutdown()) {
                this.scheduled.shutdownNow();
            }
            this.scheduled = null;
        }
        this.currentTime = null;
    }

    private void initDynamicView() {
        this.mLlDialogContainer.removeAllViews();
        initDynamicTopView();
        initDynamicMainView();
    }

    private void initDynamicMainView() {
        List<CpaQuestionData> cpaQuestionData;
        String str;
        TextView textView;
        List<TaskDataStep> list;
        int i;
        ViewGroup.LayoutParams layoutParams;
        int i2;
        List<String> formList;
        List<String> formList2;
        List<String> list2;
        AnserDataEntity anserDataEntity;
        int i3 = 0;
        boolean zBooleanValue = this.mConfig.clientDetailTaskData.getCpl() != null ? this.mConfig.clientDetailTaskData.getCpl().booleanValue() : false;
        Integer easyTaskType = this.mConfig.clientDetailTaskData.getEasyTaskType();
        boolean z = easyTaskType != null && 3 == easyTaskType.intValue();
        String str2 = "";
        if (!this.mIsSubmit) {
            RelativeLayout relativeLayout = new RelativeLayout(this.mContext);
            relativeLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            this.mLlDialogContainer.addView(relativeLayout);
            this.mLlChangeTaskContainer = new LinearLayout(this.mContext);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            ScreenAdaptationUtils.setPadding(this.mContext, this.mLlChangeTaskContainer, 18);
            layoutParams2.addRule(11);
            this.mLlChangeTaskContainer.setLayoutParams(layoutParams2);
            relativeLayout.addView(this.mLlChangeTaskContainer);
            this.mLlChangeTaskContainer.setOrientation(0);
            this.mLlChangeTaskContainer.setGravity(16);
            TextView textView2 = StyleUtils.getTextView(this.mContext, 40, R.color.moku_gray_very_deep, "换一换");
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams3.rightMargin = this.mPhoneScreenUtils.getScale(this.mContext, 15.0f);
            textView2.setLayoutParams(layoutParams3);
            this.mLlChangeTaskContainer.addView(textView2);
            ImageView imageView = new ImageView(this.mContext);
            imageView.setLayoutParams(new LinearLayout.LayoutParams(this.mPhoneScreenUtils.getScale(this.mContext, 30.0f), this.mPhoneScreenUtils.getScale(this.mContext, 30.0f)));
            this.mLlChangeTaskContainer.addView(imageView);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setImageResource(R.drawable.moku_change_task);
            if (zBooleanValue || z || this.mConfig.clientDetailTaskData.getClassify().equals("cpa")) {
                if (zBooleanValue || z || this.mConfig.clientDetailTaskData.getTaskData().getCpaType().equals(MokuConstants.CPA_TYPE_NORMAL)) {
                    LinearLayout linearLayout = new LinearLayout(this.mContext);
                    LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams4.topMargin = this.mPhoneScreenUtils.getScale(this.mContext, 30.0f);
                    linearLayout.setLayoutParams(layoutParams4);
                    this.mLlDialogContainer.addView(linearLayout);
                    linearLayout.setGravity(17);
                    linearLayout.setOrientation(1);
                    final ImageView imageView2 = new ImageView(this.mContext);
                    imageView2.setLayoutParams(new LinearLayout.LayoutParams(this.mPhoneScreenUtils.getScale(this.mContext, 250.0f), this.mPhoneScreenUtils.getScale(this.mContext, 250.0f)));
                    linearLayout.addView(imageView2);
                    imageView2.setScaleType(ImageView.ScaleType.FIT_XY);
                    ImageUtils.getInstance().setImageView(this.mContext, this.mConfig.clientDetailTaskData.getIcon(), new Consumer<Bitmap>() { // from class: com.fendasz.moku.planet.ui.dialog.TaskDialog.26
                        @Override // com.fendasz.moku.planet.interf.functions.Consumer
                        public void accept(Bitmap bitmap) {
                            imageView2.setImageBitmap(bitmap);
                        }
                    }, Float.valueOf(this.mPhoneScreenUtils.getScale(this.mContext, 250.0f)), Float.valueOf(this.mPhoneScreenUtils.getScale(this.mContext, 250.0f)));
                    this.mConfig.clientDetailTaskData.getMonitorMethod();
                    if (z) {
                        textView = StyleUtils.getTextView(this.mContext, 50, R.color.black, this.mConfig.clientDetailTaskData.getCollectionDataName());
                    } else {
                        textView = StyleUtils.getTextView(this.mContext, 50, R.color.black, this.mConfig.clientDetailTaskData.getShowName());
                    }
                    LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams5.topMargin = this.mPhoneScreenUtils.getScale(this.mContext, 30.0f);
                    layoutParams5.bottomMargin = this.mPhoneScreenUtils.getScale(this.mContext, 30.0f);
                    textView.setLayoutParams(layoutParams5);
                    linearLayout.addView(textView);
                } else {
                    List<CpaQuestionData> cpaQuestionData2 = this.mConfig.clientDetailTaskData.getTaskData().getTaskDataDetail().getCpaQuestionData();
                    if (cpaQuestionData2 != null && !cpaQuestionData2.isEmpty()) {
                        this.answerList = new ArrayList(Arrays.asList(new String[cpaQuestionData2.size()]));
                        this.mEtInputList = new ArrayList();
                        this.mTvAnswerErrorList = new ArrayList();
                        this.mTvAnswerErrorTipList = new ArrayList();
                        this.answerEditList = new ArrayList();
                        ScrollView scrollView = new ScrollView(this.mContext);
                        this.mLlDialogContainer.addView(scrollView);
                        scrollView.setLayoutParams(new LinearLayout.LayoutParams(-1, this.mPhoneScreenUtils.getScale(this.mContext, 1024.0f)));
                        LinearLayout linearLayout2 = new LinearLayout(this.mContext);
                        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-1, -2);
                        layoutParams6.leftMargin = this.mPhoneScreenUtils.getScale(this.mContext, 50.0f);
                        layoutParams6.rightMargin = this.mPhoneScreenUtils.getScale(this.mContext, 50.0f);
                        linearLayout2.setLayoutParams(layoutParams6);
                        scrollView.addView(linearLayout2);
                        linearLayout2.setGravity(17);
                        linearLayout2.setOrientation(1);
                        int i4 = 1;
                        for (CpaQuestionData cpaQuestionData3 : cpaQuestionData2) {
                            List<List<TaskDataStep>> steps = cpaQuestionData3.getSteps();
                            if (steps != null && !steps.isEmpty()) {
                                for (List<TaskDataStep> list3 : steps) {
                                    String taskDataCustomDesc = list3.get(i3).getTaskDataCustomDesc();
                                    Integer taskDataStepConfigType = list3.get(i3).getTaskDataStepConfigType();
                                    if (taskDataCustomDesc != null && !TextUtils.isEmpty(taskDataCustomDesc) && taskDataStepConfigType != null) {
                                        setChildProcessDesc(linearLayout2, i4, taskDataCustomDesc);
                                    }
                                    for (TaskDataStep taskDataStep : list3) {
                                        String taskDataSampleScreenshotUrl = taskDataStep.getTaskDataSampleScreenshotUrl();
                                        if (!TextUtils.isEmpty(taskDataStep.getTaskDataSampleScreenshotUrl())) {
                                            final ImageView imageView3 = new ImageView(this.mContext);
                                            linearLayout2.addView(imageView3);
                                            ScreenAdaptationUtils.setMarginTop(this.mContext, imageView3, 25);
                                            imageView3.setBackgroundResource(R.color.moku_transparent);
                                            imageView3.setScaleType(ImageView.ScaleType.CENTER_CROP);
                                            ScreenAdaptationUtils.setSize(this.mContext, imageView3, 250, 250);
                                            ImageUtils.getInstance().setImageView(this.mContext, taskDataSampleScreenshotUrl, new Consumer<Bitmap>() { // from class: com.fendasz.moku.planet.ui.dialog.TaskDialog.27
                                                @Override // com.fendasz.moku.planet.interf.functions.Consumer
                                                public void accept(final Bitmap bitmap) {
                                                    imageView3.setImageBitmap(bitmap);
                                                    imageView3.setOnClickListener(new View.OnClickListener() { // from class: com.fendasz.moku.planet.ui.dialog.TaskDialog.27.1
                                                        @Override // android.view.View.OnClickListener
                                                        public void onClick(View view) {
                                                            new ViewImageDialog.Builder(TaskDialog.this.mContext).setBitmap(bitmap).create().show();
                                                        }
                                                    });
                                                }
                                            }, null, null);
                                        }
                                        i4++;
                                        i3 = 0;
                                    }
                                }
                            }
                            List<AnserDataEntity> answerList = cpaQuestionData3.getAnswerList();
                            Integer questionType = cpaQuestionData3.getQuestionType();
                            if (questionType != null && questionType.intValue() != 0) {
                                if (1 == questionType.intValue() || 3 == questionType.intValue()) {
                                    String str3 = "请输入答案 (<font color=\"#ff0000\">" + ((answerList == null || answerList.size() <= 0 || (anserDataEntity = answerList.get(0)) == null || anserDataEntity.getAnswer() == null) ? "" : anserDataEntity.getAnswer()).length() + "个字</font>)";
                                    TextView textView3 = new TextView(this.mContext);
                                    textView3.setTextColor(this.mContext.getResources().getColor(R.color.moku_gray_deep));
                                    if (Build.VERSION.SDK_INT >= 24) {
                                        textView3.setText(Html.fromHtml(str3, 63));
                                    } else {
                                        textView3.setText(Html.fromHtml(str3));
                                    }
                                    textView3.setTextSize(this.mPhoneScreenUtils.getSmallTextSize(this.mContext));
                                    linearLayout2.addView(textView3);
                                    ScreenAdaptationUtils.setMarginTop(this.mContext, textView3, 30);
                                    LinearLayout linearLayout3 = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.moku_gap_filling_input_item, (ViewGroup) linearLayout2, false);
                                    LinearLayout linearLayout4 = (LinearLayout) linearLayout3.findViewById(R.id.ll_input_container);
                                    ScreenAdaptationUtils.setHeight(this.mContext, linearLayout4, 90);
                                    ScreenAdaptationUtils.setMarginTop(this.mContext, linearLayout4, 10);
                                    linearLayout2.addView(linearLayout3);
                                    EditText editText = (EditText) linearLayout3.findViewById(R.id.et_input);
                                    this.mEtInput = editText;
                                    editText.setTag(cpaQuestionData3.getQuestionNum());
                                    this.mEtInputList.add(this.mEtInput);
                                    this.answerEditList.add(this.mEtInput);
                                    this.mEtInput.setPadding(this.mPhoneScreenUtils.getScale(this.mContext, 20.0f), 0, 0, 0);
                                    this.mEtInput.setTextSize(this.mPhoneScreenUtils.getSmallTextSize(this.mContext));
                                    ((LinearLayout.LayoutParams) this.mEtInput.getLayoutParams()).rightMargin = this.mPhoneScreenUtils.getScale(this.mContext, 30.0f);
                                    this.mBtnSubmit = (Button) linearLayout3.findViewById(R.id.btn_submit);
                                    this.mConfig.clientDetailTaskData.getTaskData();
                                    this.mBtnSubmit.setVisibility(8);
                                    TextView textView4 = (TextView) linearLayout3.findViewById(R.id.tv_answer_error_icon);
                                    this.mTvAnswerError = textView4;
                                    this.mTvAnswerErrorList.add(textView4);
                                    this.mTvAnswerError.setTextSize(this.mPhoneScreenUtils.getSmall35TextSize(this.mContext));
                                    ScreenAdaptationUtils.setSize(this.mContext, this.mTvAnswerError, 55, 55);
                                    TextView textView5 = (TextView) linearLayout3.findViewById(R.id.tv_answer_error_tip);
                                    this.mTvAnswerErrorTip = textView5;
                                    this.mTvAnswerErrorTipList.add(textView5);
                                    this.mTvAnswerErrorTip.setTextSize(this.mPhoneScreenUtils.getSmallTextSize(this.mContext));
                                } else if (2 == questionType.intValue()) {
                                    if (answerList == null) {
                                        return;
                                    }
                                    ArrayList arrayList = new ArrayList(answerList.size());
                                    Iterator<AnserDataEntity> it = answerList.iterator();
                                    while (it.hasNext()) {
                                        arrayList.add(it.next().getAnswer());
                                    }
                                    this.mChoiceQuestionRadioGroup = new ChoiceQuestionRadioGroup.Builder(this.mContext, arrayList, cpaQuestionData3.getQuestionNum()).build();
                                    LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-1, -2);
                                    layoutParams7.topMargin = this.mPhoneScreenUtils.getScale(this.mContext, 30.0f);
                                    this.mChoiceQuestionRadioGroup.setLayoutParams(layoutParams7);
                                    linearLayout2.addView(this.mChoiceQuestionRadioGroup);
                                    TextView textView6 = new TextView(this.mContext);
                                    this.mTvAnswerErrorTip = textView6;
                                    this.mTvAnswerErrorTipList.add(textView6);
                                    this.mTvAnswerErrorTip.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                                    linearLayout2.addView(this.mTvAnswerErrorTip);
                                    this.mTvAnswerErrorTip.setTextSize(this.mPhoneScreenUtils.getSmallTextSize(this.mContext));
                                    this.mTvAnswerErrorTip.setTextColor(this.mContext.getResources().getColor(R.color.moku_red));
                                    this.mTvAnswerErrorTip.setText("答错啦，还剩1次答题机会~");
                                    this.mTvAnswerErrorTip.setVisibility(8);
                                    ScreenAdaptationUtils.setMarginTop(this.mContext, this.mTvAnswerErrorTip, 30);
                                }
                            }
                            if (this.mConfig.clientDetailTaskData != null && (formList2 = cpaQuestionData3.getFormList()) != null && !formList2.isEmpty()) {
                                int i5 = 1;
                                int i6 = 0;
                                while (i6 < formList2.size()) {
                                    String str4 = formList2.get(i6);
                                    if (TextUtils.isEmpty(str4)) {
                                        list2 = formList2;
                                    } else {
                                        i5++;
                                        setChildProcessDesc(linearLayout2, i5, "请提交 <font color=\"#ff0000\">" + str4 + "</font>");
                                        list2 = formList2;
                                        LinearLayout linearLayout5 = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.moku_input_item, (ViewGroup) null);
                                        linearLayout2.addView(linearLayout5);
                                        ScreenAdaptationUtils.setMarginTop(this.mContext, linearLayout5, 30);
                                        ScreenAdaptationUtils.setHeight(this.mContext, linearLayout5, 130);
                                        EditText editText2 = (EditText) linearLayout5.findViewById(R.id.et_input);
                                        editText2.setHint(str4);
                                        editText2.setTextSize(this.mPhoneScreenUtils.getNormalTextSize(this.mContext));
                                        this.etFormList.add(editText2);
                                        ClientTaskDataSubmitFormModel clientTaskDataSubmitFormModel = new ClientTaskDataSubmitFormModel();
                                        clientTaskDataSubmitFormModel.setKey(str4);
                                        clientTaskDataSubmitFormModel.setQuestionNum(cpaQuestionData3.getQuestionNum());
                                        this.formDatas.add(clientTaskDataSubmitFormModel);
                                    }
                                    i6++;
                                    formList2 = list2;
                                }
                            }
                            i3 = 0;
                        }
                    } else {
                        Map<Integer, List<TaskDataStep>> integerListMap = this.mConfig.clientDetailTaskData.getIntegerListMap();
                        if (integerListMap != null && (list = integerListMap.get(1)) != null && list.size() > 0) {
                            ScrollView scrollView2 = new ScrollView(this.mContext);
                            this.mLlDialogContainer.addView(scrollView2);
                            if (list.size() > 1) {
                                i = -1;
                                layoutParams = new LinearLayout.LayoutParams(-1, this.mPhoneScreenUtils.getScale(this.mContext, 1024.0f));
                                i2 = -2;
                            } else {
                                i = -1;
                                i2 = -2;
                                layoutParams = new LinearLayout.LayoutParams(-1, -2);
                            }
                            scrollView2.setLayoutParams(layoutParams);
                            LinearLayout linearLayout6 = new LinearLayout(this.mContext);
                            LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(i, i2);
                            layoutParams8.leftMargin = this.mPhoneScreenUtils.getScale(this.mContext, 50.0f);
                            layoutParams8.rightMargin = this.mPhoneScreenUtils.getScale(this.mContext, 50.0f);
                            linearLayout6.setLayoutParams(layoutParams8);
                            scrollView2.addView(linearLayout6);
                            linearLayout6.setGravity(17);
                            linearLayout6.setOrientation(1);
                            final TextView textView7 = StyleUtils.getTextView(this.mContext, 40, R.color.moku_gray_deep, MokuUtils.parserXml(list.get(0).getTaskDataCustomDesc()));
                            linearLayout6.addView(textView7);
                            textView7.getLayoutParams().width = -1;
                            textView7.setLinksClickable(true);
                            textView7.setMovementMethod(LinkMovementMethod.getInstance());
                            textView7.setTextSize(this.mPhoneScreenUtils.getSmallTextSize(this.mContext));
                            textView7.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.fendasz.moku.planet.ui.dialog.TaskDialog.28
                                @Override // android.view.View.OnLongClickListener
                                public boolean onLongClick(View view) {
                                    textView7.setSelected(true);
                                    try {
                                        SystemUtils.copyToClipboard(TaskDialog.this.mContext, textView7.getText().toString(), textView7.getText().toString());
                                        Toast.makeText(TaskDialog.this.mContext, "内容复制到剪贴板", 0).show();
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                    return false;
                                }
                            });
                            for (int i7 = 0; i7 < list.size(); i7++) {
                                String taskDataSampleScreenshotUrl2 = list.get(i7).getTaskDataSampleScreenshotUrl();
                                if (!TextUtils.isEmpty(taskDataSampleScreenshotUrl2)) {
                                    final ImageView imageView4 = new ImageView(this.mContext);
                                    linearLayout6.addView(imageView4);
                                    ScreenAdaptationUtils.setMarginTop(this.mContext, imageView4, 25);
                                    imageView4.setBackgroundResource(R.color.moku_transparent);
                                    imageView4.setScaleType(ImageView.ScaleType.CENTER_CROP);
                                    ScreenAdaptationUtils.setSize(this.mContext, imageView4, 250, 250);
                                    ImageUtils.getInstance().setImageView(this.mContext, taskDataSampleScreenshotUrl2, new Consumer<Bitmap>() { // from class: com.fendasz.moku.planet.ui.dialog.TaskDialog.29
                                        @Override // com.fendasz.moku.planet.interf.functions.Consumer
                                        public void accept(final Bitmap bitmap) {
                                            imageView4.setImageBitmap(bitmap);
                                            imageView4.setOnClickListener(new View.OnClickListener() { // from class: com.fendasz.moku.planet.ui.dialog.TaskDialog.29.1
                                                @Override // android.view.View.OnClickListener
                                                public void onClick(View view) {
                                                    new ViewImageDialog.Builder(TaskDialog.this.mContext).setBitmap(bitmap).create().show();
                                                }
                                            });
                                        }
                                    }, null, null);
                                }
                            }
                            List<HashMap> answerList2 = this.mConfig.clientDetailTaskData.getTaskData().getTaskDataDetail().getAnswerList();
                            int cpaType = -1;
                            if (this.mConfig.clientDetailTaskData.getTaskData() != null) {
                                cpaType = this.mConfig.clientDetailTaskData.getTaskData().getCpaType();
                            }
                            if (MokuConstants.CPA_TYPE_NORMAL_CHOICE_QUESTION.equals(cpaType)) {
                                ArrayList arrayList2 = new ArrayList();
                                for (int i8 = 0; i8 < answerList2.size(); i8++) {
                                    arrayList2.add((String) answerList2.get(i8).get("answer"));
                                }
                                this.mChoiceQuestionRadioGroup = new ChoiceQuestionRadioGroup.Builder(this.mContext, arrayList2, null).build();
                                LinearLayout.LayoutParams layoutParams9 = new LinearLayout.LayoutParams(-1, -2);
                                layoutParams9.topMargin = this.mPhoneScreenUtils.getScale(this.mContext, 30.0f);
                                this.mChoiceQuestionRadioGroup.setLayoutParams(layoutParams9);
                                linearLayout6.addView(this.mChoiceQuestionRadioGroup);
                                this.mTvAnswerErrorTip = new TextView(this.mContext);
                                this.mTvAnswerErrorTip.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                                linearLayout6.addView(this.mTvAnswerErrorTip);
                                this.mTvAnswerErrorTip.setTextSize(this.mPhoneScreenUtils.getSmallTextSize(this.mContext));
                                this.mTvAnswerErrorTip.setTextColor(this.mContext.getResources().getColor(R.color.moku_red));
                                this.mTvAnswerErrorTip.setText("答错啦，还剩1次答题机会~");
                                this.mTvAnswerErrorTip.setVisibility(8);
                                ScreenAdaptationUtils.setMarginTop(this.mContext, this.mTvAnswerErrorTip, 30);
                            }
                            if (MokuConstants.CPA_TYPE_NORMAL_GAP_FILLING.equals(cpaType) || MokuConstants.CPA_TYPE_NORMAL_FORM.equals(cpaType)) {
                                String str5 = "请输入答案 (<font color=\"#ff0000\">" + ((answerList2 == null || answerList2.size() <= 0) ? "" : (String) answerList2.get(0).get("answer")).length() + "个字</font>)";
                                TextView textView8 = new TextView(this.mContext);
                                textView8.setTextColor(this.mContext.getResources().getColor(R.color.moku_gray_deep));
                                if (Build.VERSION.SDK_INT >= 24) {
                                    textView8.setText(Html.fromHtml(str5, 63));
                                } else {
                                    textView8.setText(Html.fromHtml(str5));
                                }
                                textView8.setTextSize(this.mPhoneScreenUtils.getSmallTextSize(this.mContext));
                                linearLayout6.addView(textView8);
                                ScreenAdaptationUtils.setMarginTop(this.mContext, textView8, 30);
                                LinearLayout linearLayout7 = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.moku_gap_filling_input_item, (ViewGroup) linearLayout6, false);
                                LinearLayout linearLayout8 = (LinearLayout) linearLayout7.findViewById(R.id.ll_input_container);
                                ScreenAdaptationUtils.setHeight(this.mContext, linearLayout8, 90);
                                ScreenAdaptationUtils.setMarginTop(this.mContext, linearLayout8, 10);
                                linearLayout6.addView(linearLayout7);
                                EditText editText3 = (EditText) linearLayout7.findViewById(R.id.et_input);
                                this.mEtInput = editText3;
                                editText3.setPadding(this.mPhoneScreenUtils.getScale(this.mContext, 20.0f), 0, 0, 0);
                                this.mEtInput.setTextSize(this.mPhoneScreenUtils.getSmallTextSize(this.mContext));
                                ((LinearLayout.LayoutParams) this.mEtInput.getLayoutParams()).rightMargin = this.mPhoneScreenUtils.getScale(this.mContext, 30.0f);
                                this.mBtnSubmit = (Button) linearLayout7.findViewById(R.id.btn_submit);
                                if (this.mConfig.clientDetailTaskData.getTaskData() != null && cpaType != null && MokuConstants.CPA_TYPE_NORMAL_FORM == cpaType) {
                                    this.mBtnSubmit.setVisibility(8);
                                } else {
                                    this.mBtnSubmit.setVisibility(0);
                                    this.mBtnSubmit.setTextSize(this.mPhoneScreenUtils.getSmall35TextSize(this.mContext));
                                }
                                TextView textView9 = (TextView) linearLayout7.findViewById(R.id.tv_answer_error_icon);
                                this.mTvAnswerError = textView9;
                                textView9.setTextSize(this.mPhoneScreenUtils.getSmall35TextSize(this.mContext));
                                ScreenAdaptationUtils.setSize(this.mContext, this.mTvAnswerError, 55, 55);
                                TextView textView10 = (TextView) linearLayout7.findViewById(R.id.tv_answer_error_tip);
                                this.mTvAnswerErrorTip = textView10;
                                textView10.setTextSize(this.mPhoneScreenUtils.getSmallTextSize(this.mContext));
                            }
                            ClientDetailTaskData clientDetailTaskData = this.mConfig.clientDetailTaskData;
                            if (clientDetailTaskData != null && (formList = clientDetailTaskData.getFormList()) != null && !formList.isEmpty()) {
                                int i9 = 1;
                                for (int i10 = 0; i10 < formList.size(); i10++) {
                                    String str6 = formList.get(i10);
                                    if (!TextUtils.isEmpty(str6)) {
                                        i9++;
                                        setChildProcessDesc(linearLayout6, i9, "请提交 <font color=\"#ff0000\">" + str6 + "</font>");
                                        LinearLayout linearLayout9 = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.moku_input_item, (ViewGroup) null);
                                        linearLayout6.addView(linearLayout9);
                                        ScreenAdaptationUtils.setMarginTop(this.mContext, linearLayout9, 30);
                                        ScreenAdaptationUtils.setHeight(this.mContext, linearLayout9, 130);
                                        EditText editText4 = (EditText) linearLayout9.findViewById(R.id.et_input);
                                        editText4.setHint(str6);
                                        editText4.setTextSize(this.mPhoneScreenUtils.getNormalTextSize(this.mContext));
                                        this.etFormList.add(editText4);
                                        ClientTaskDataSubmitFormModel clientTaskDataSubmitFormModel2 = new ClientTaskDataSubmitFormModel();
                                        clientTaskDataSubmitFormModel2.setKey(str6);
                                        this.formDatas.add(clientTaskDataSubmitFormModel2);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } else {
            if (this.mConfig.clientDetailTaskData.getTaskData() != null && this.mConfig.clientDetailTaskData.getTaskData().getTaskDataDetail() != null && (cpaQuestionData = this.mConfig.clientDetailTaskData.getTaskData().getTaskDataDetail().getCpaQuestionData()) != null) {
                cpaQuestionData.isEmpty();
            }
            LinearLayout linearLayout10 = new LinearLayout(this.mContext);
            LinearLayout.LayoutParams layoutParams10 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams10.topMargin = this.mPhoneScreenUtils.getScale(this.mContext, 140.0f);
            layoutParams10.bottomMargin = this.mPhoneScreenUtils.getScale(this.mContext, 140.0f);
            linearLayout10.setLayoutParams(layoutParams10);
            this.mLlDialogContainer.addView(linearLayout10);
            linearLayout10.setGravity(17);
            linearLayout10.setOrientation(1);
            linearLayout10.addView(StyleUtils.getTextView(this.mContext, 60, R.color.black, Html.fromHtml("<font color=\"#ff0000\">" + StringUtils.formatMoney(this.mConfig.clientDetailTaskData.getShowMoney().toPlainString()) + "</font>" + this.mConfig.clientDetailTaskData.getCybermoneyName() + "已入账")));
        }
        LinearLayout linearLayout11 = new LinearLayout(this.mContext);
        LinearLayout.LayoutParams layoutParams11 = new LinearLayout.LayoutParams(-1, -2);
        if (!this.mIsSubmit) {
            layoutParams11.topMargin = this.mPhoneScreenUtils.getScale(this.mContext, 40.0f);
        } else {
            layoutParams11.bottomMargin = this.mPhoneScreenUtils.getScale(this.mContext, 80.0f);
        }
        linearLayout11.setLayoutParams(layoutParams11);
        this.mLlDialogContainer.addView(linearLayout11);
        linearLayout11.setGravity(17);
        RelativeLayout relativeLayout2 = (RelativeLayout) LayoutInflater.from(this.mContext).inflate(R.layout.moku_progressbar, (ViewGroup) this.mLlDialogContainer, false);
        this.mRlProgressBar = relativeLayout2;
        linearLayout11.addView(relativeLayout2);
        ((LinearLayout.LayoutParams) this.mRlProgressBar.getLayoutParams()).width = this.mPhoneScreenUtils.getScale(this.mContext, 621.0f);
        ProgressBar progressBar = (ProgressBar) this.mRlProgressBar.findViewById(R.id.pb_download);
        this.mPbDownload = progressBar;
        progressBar.setProgress(progressBar.getMax());
        TextView textView11 = (TextView) this.mRlProgressBar.findViewById(R.id.tv_download);
        this.mTvDownload = textView11;
        textView11.getPaint().setTextSize(CanvasUtils.getTextSize(this.mPhoneScreenUtils.getScale(this.mContext, 50.0f)));
        if (this.mIsSubmit) {
            this.mTvDownload.setText("再赚更多");
        } else if (zBooleanValue) {
            this.mTvDownload.setText("立即开始");
        } else if (z) {
            String keyPoint = this.mConfig.clientDetailTaskData.getKeyPoint();
            if (keyPoint != null && !StringUtils.isEmpty(keyPoint)) {
                this.mTvDownload.setText(this.mConfig.clientDetailTaskData.getKeyPoint());
            } else {
                this.mTvDownload.setText("立即打开");
            }
        } else {
            this.mTvDownload.setText("立即安装");
        }
        if (this.mIsSubmit) {
            return;
        }
        LinearLayout linearLayout12 = new LinearLayout(this.mContext);
        LinearLayout.LayoutParams layoutParams12 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams12.topMargin = this.mPhoneScreenUtils.getScale(this.mContext, 50.0f);
        layoutParams12.bottomMargin = this.mPhoneScreenUtils.getScale(this.mContext, 50.0f);
        linearLayout12.setLayoutParams(layoutParams12);
        this.mLlDialogContainer.addView(linearLayout12);
        linearLayout12.setGravity(17);
        if (zBooleanValue || this.mConfig.clientDetailTaskData.getClassify().equals("cpa")) {
            if (zBooleanValue) {
                str2 = "安装软件完成第一步";
            } else {
                Integer monitorMethod = this.mConfig.clientDetailTaskData.getMonitorMethod();
                if (this.mConfig.clientDetailTaskData.getTaskData().getCpaType().equals(MokuConstants.CPA_TYPE_NORMAL)) {
                    Integer listenerTime = this.mConfig.clientDetailTaskData.getListenerTime();
                    if (listenerTime.intValue() <= 60) {
                        str = "安装应用试玩" + listenerTime + "秒";
                    } else {
                        int iIntValue = listenerTime.intValue() / 60;
                        if ((listenerTime.intValue() / 60.0d) - iIntValue >= 0.5d) {
                            iIntValue++;
                        }
                        str = "安装应用试玩" + iIntValue + "分钟";
                    }
                    str2 = str;
                } else {
                    str2 = (monitorMethod == null || 2 != monitorMethod.intValue()) ? "安装应用获取答案" : "体验软件" + this.mConfig.clientDetailTaskData.getBrowseTime() + "秒";
                }
            }
        }
        if (!z) {
            linearLayout12.addView(StyleUtils.getTextView(this.mContext, 40, R.color.black, Html.fromHtml(str2 + ",可得奖励<font color=\"#ff0000\">" + StringUtils.formatMoney(this.mConfig.clientDetailTaskData.getShowMoney().toPlainString()) + "</font>" + this.mConfig.clientDetailTaskData.getCybermoneyName())));
        } else {
            linearLayout12.addView(StyleUtils.getTextView(this.mContext, 40, R.color.black, Html.fromHtml("奖励立即到账")));
        }
    }

    private int getScaleHeightByWidth(double d, Bitmap bitmap) {
        return (int) ((d / bitmap.getWidth()) * bitmap.getHeight());
    }

    private void setChildProcessDesc(LinearLayout linearLayout, int i, String str) {
        setChildProcessDesc(linearLayout, i, str, false);
    }

    private void setChildProcessDesc(LinearLayout linearLayout, int i, String str, boolean z) {
        LogUtils.log(TAG, "task process desc before parse >> " + str);
        LinearLayout linearLayout2 = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.moku_child_process_desc, (ViewGroup) linearLayout, false);
        linearLayout.addView(linearLayout2);
        TextView textView = (TextView) linearLayout2.findViewById(R.id.tv_child_process_index);
        if (i > 1) {
            ScreenAdaptationUtils.setMarginTop(this.mContext, linearLayout2, 30);
        }
        textView.setText(String.valueOf(i));
        ScreenAdaptationUtils.setSize(this.mContext, textView, 55, 55);
        textView.setTextSize(this.mPhoneScreenUtils.getSmallTextSize(this.mContext));
        if (!z) {
            textView.setVisibility(8);
        }
        final TextView textView2 = (TextView) linearLayout2.findViewById(R.id.tv_child_process_desc);
        textView2.setTextColor(this.mContext.getResources().getColor(R.color.moku_gray_deep));
        textView2.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.fendasz.moku.planet.ui.dialog.TaskDialog.30
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                textView2.setSelected(true);
                try {
                    SystemUtils.copyToClipboard(TaskDialog.this.mContext, textView2.getText().toString(), textView2.getText().toString());
                    Toast.makeText(TaskDialog.this.mContext, "内容复制到剪贴板", 0).show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return false;
            }
        });
        Spanned spanned = MokuUtils.parserXml(str);
        textView2.setLinksClickable(true);
        textView2.setMovementMethod(LinkMovementMethod.getInstance());
        textView2.setText(getClickableHtml(spanned));
        textView2.setTextSize(this.mPhoneScreenUtils.getMiddleTextSize(this.mContext));
    }

    private CharSequence getClickableHtml(Spanned spanned) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(spanned);
        for (URLSpan uRLSpan : (URLSpan[]) spannableStringBuilder.getSpans(0, spanned.length(), URLSpan.class)) {
            setLinkClickable(spannableStringBuilder, uRLSpan);
        }
        return spannableStringBuilder;
    }

    private void setLinkClickable(SpannableStringBuilder spannableStringBuilder, URLSpan uRLSpan) {
        int spanStart = spannableStringBuilder.getSpanStart(uRLSpan);
        int spanEnd = spannableStringBuilder.getSpanEnd(uRLSpan);
        int spanFlags = spannableStringBuilder.getSpanFlags(uRLSpan);
        final String url = uRLSpan.getURL();
        spannableStringBuilder.setSpan(new ClickableSpan() { // from class: com.fendasz.moku.planet.ui.dialog.TaskDialog.31
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                LogUtils.log(TaskDialog.TAG, "截取到超链接点击事件");
                SystemUtils.openBrowser(TaskDialog.this.mContext, url);
            }
        }, spanStart, spanEnd, spanFlags);
        spannableStringBuilder.removeSpan(uRLSpan);
    }

    private void initDynamicTopView() {
        String str;
        FrameLayout frameLayout = new FrameLayout(this.mContext);
        frameLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, this.mPhoneScreenUtils.getScale(this.mContext, 363.0f)));
        this.mLlDialogContainer.addView(frameLayout);
        frameLayout.setBackgroundResource(R.drawable.moku_task_dialog_title);
        RelativeLayout relativeLayout = new RelativeLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mPhoneScreenUtils.getScale(this.mContext, 80.0f), this.mPhoneScreenUtils.getScale(this.mContext, 80.0f));
        layoutParams.gravity = 53;
        relativeLayout.setLayoutParams(layoutParams);
        frameLayout.addView(relativeLayout);
        relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.fendasz.moku.planet.ui.dialog.TaskDialog.32
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TaskDialog.this.dismiss();
            }
        });
        ImageView imageView = new ImageView(this.mContext);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(this.mPhoneScreenUtils.getScale(this.mContext, 30.0f), this.mPhoneScreenUtils.getScale(this.mContext, 30.0f));
        layoutParams2.addRule(13);
        imageView.setLayoutParams(layoutParams2);
        relativeLayout.addView(imageView);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setImageResource(R.drawable.moku_task_dialog_close);
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams3.gravity = 17;
        linearLayout.setLayoutParams(layoutParams3);
        frameLayout.addView(linearLayout);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(17);
        if (!this.mIsSubmit) {
            boolean zBooleanValue = this.mConfig.clientDetailTaskData.getCpl() != null ? this.mConfig.clientDetailTaskData.getCpl().booleanValue() : false;
            Integer easyTaskType = this.mConfig.clientDetailTaskData.getEasyTaskType();
            if (zBooleanValue || this.mConfig.clientDetailTaskData.getClassify().equals("cpa")) {
                if (zBooleanValue) {
                    str = this.isDian ? "下载即领" + StringUtils.formatMoney(this.mConfig.clientDetailTaskData.getShowMoney().toPlainString()) + this.mConfig.clientDetailTaskData.getCybermoneyName() : "安装软件完成第一步";
                } else if (this.mConfig.clientDetailTaskData.getTaskData().getCpaType().equals(MokuConstants.CPA_TYPE_NORMAL)) {
                    if (this.isDian) {
                        str = "下载即领" + StringUtils.formatMoney(this.mConfig.clientDetailTaskData.getShowMoney().toPlainString()) + this.mConfig.clientDetailTaskData.getCybermoneyName();
                    } else {
                        Integer listenerTime = this.mConfig.clientDetailTaskData.getListenerTime();
                        if (listenerTime.intValue() <= 60) {
                            str = "安装应用试玩" + listenerTime + "秒";
                        } else {
                            int iIntValue = listenerTime.intValue() / 60;
                            if ((listenerTime.intValue() / 60.0d) - iIntValue >= 0.5d) {
                                iIntValue++;
                            }
                            str = "安装应用试玩" + iIntValue + "分钟";
                        }
                    }
                } else {
                    str = this.isDian ? "下载即领" + StringUtils.formatMoney(this.mConfig.clientDetailTaskData.getShowMoney().toPlainString()) + this.mConfig.clientDetailTaskData.getCybermoneyName() : "安装应用获取答案";
                }
            } else if (easyTaskType == null || 3 != easyTaskType.intValue()) {
                str = "";
            } else {
                Integer monitorMethod = this.mConfig.clientDetailTaskData.getMonitorMethod();
                if (monitorMethod != null && 2 == monitorMethod.intValue()) {
                    str = "体验软件" + this.mConfig.clientDetailTaskData.getBrowseTime() + "秒";
                } else {
                    str = "浏览页面" + this.mConfig.clientDetailTaskData.getBrowseTime() + "秒";
                }
            }
            if (this.isDian) {
                TextView textView = StyleUtils.getTextView(this.mContext, 70, R.color.white, str);
                String money = StringUtils.formatMoney(this.mConfig.clientDetailTaskData.getShowMoney().toPlainString());
                SpannableString spannableString = new SpannableString("下载即领" + money + this.mConfig.clientDetailTaskData.getCybermoneyName());
                int length = money.length() + 4;
                spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#FFF7CC")), 4, length, 33);
                spannableString.setSpan(new RelativeSizeSpan(1.5f), 4, length, 33);
                textView.setText(spannableString);
                linearLayout.addView(textView);
            } else {
                TextView textView2 = StyleUtils.getTextView(this.mContext, 70, R.color.white, str);
                textView2.getPaint().setFakeBoldText(true);
                linearLayout.addView(textView2);
            }
            LinearLayout linearLayout2 = new LinearLayout(this.mContext);
            linearLayout2.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            linearLayout.addView(linearLayout2);
            linearLayout2.setGravity(80);
            if (this.isDian) {
                TextView textView3 = StyleUtils.getTextView(this.mContext, 50, R.color.white, "奖励秒到账");
                textView3.getPaint().setFakeBoldText(true);
                linearLayout2.addView(textView3);
                return;
            }
            if (easyTaskType != null && 3 == easyTaskType.intValue()) {
                TextView textView4 = StyleUtils.getTextView(this.mContext, 50, R.color.white, "奖励立刻到账");
                textView4.getPaint().setFakeBoldText(true);
                linearLayout2.addView(textView4);
                return;
            }
            TextView textView5 = StyleUtils.getTextView(this.mContext, 50, R.color.white, "即可到账");
            textView5.getPaint().setFakeBoldText(true);
            linearLayout2.addView(textView5);
            TextView textView6 = StyleUtils.getTextView(this.mContext, 90, R.color.moku_yellow_golden_light, StringUtils.formatMoney(this.mConfig.clientDetailTaskData.getShowMoney().toPlainString()));
            textView6.getPaint().setFakeBoldText(true);
            linearLayout2.addView(textView6);
            TextView textView7 = StyleUtils.getTextView(this.mContext, 50, R.color.white, this.mConfig.clientDetailTaskData.getCybermoneyName());
            textView7.getPaint().setFakeBoldText(true);
            linearLayout2.addView(textView7);
            return;
        }
        TextView textView8 = StyleUtils.getTextView(this.mContext, 110, R.color.white, "任务完成");
        textView8.getPaint().setFakeBoldText(true);
        linearLayout.addView(textView8);
    }

    private void initView() {
        RelativeLayout relativeLayout = new RelativeLayout(this.mContext);
        relativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        relativeLayout.setBackgroundColor(StyleUtils.getColor(this.mContext, R.color.moku_gray_transparent));
        this.mDialog.setContentView(relativeLayout);
        RoundRectLayout roundRectLayout = new RoundRectLayout(this.mContext);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.mPhoneScreenUtils.getScale(this.mContext, 806.0f), -2);
        layoutParams.addRule(13);
        roundRectLayout.setLayoutParams(layoutParams);
        relativeLayout.addView(roundRectLayout);
        roundRectLayout.setCornerRadius(this.mPhoneScreenUtils.getScale(this.mContext, 20.0f));
        roundRectLayout.setBackgroundColor(StyleUtils.getColor(this.mContext, R.color.white));
        this.mLlDialogContainer = new LinearLayout(this.mContext);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(13);
        this.mLlDialogContainer.setLayoutParams(layoutParams2);
        roundRectLayout.addView(this.mLlDialogContainer);
        this.mLlDialogContainer.setOrientation(1);
        this.etFormList = new ArrayList();
        this.formDatas = new ArrayList();
    }

    private void initLoad(Context context, Config config) {
        this.mContext = context;
        this.mConfig = config;
        Dialog dialog = new Dialog(this.mContext, R.style.MokuDialogTheme);
        this.mDialog = dialog;
        dialog.setCancelable(this.mConfig.cancelable);
        this.mPhoneScreenUtils = PhoneScreenUtils.getInstance();
    }

    public void setOnDialogClosed(OnDialogClosed onDialogClosed) {
        this.mOnDialogClosed = onDialogClosed;
    }

    public void onRestart() throws NoSuchMethodException, SecurityException {
        if (this.mIsSubmit) {
            return;
        }
        ApiTaskOperationHelper apiTaskOperationHelper = this.mApiTaskOperationHelper;
        if (apiTaskOperationHelper != null) {
            apiTaskOperationHelper.onRestart(this.mContext);
        }
        onInitStatusComplete();
    }

    public void onDestroy() {
        destroy();
    }

    public void destroy() {
        ApiTaskOperationHelper apiTaskOperationHelper = this.mApiTaskOperationHelper;
        if (apiTaskOperationHelper != null) {
            apiTaskOperationHelper.onDestroy();
        }
        initCountDown();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isCpaFrom() {
        List<String> formList;
        Integer.valueOf(-1);
        List<CpaQuestionData> cpaQuestionData = (this.mConfig.clientDetailTaskData.getTaskData() == null || this.mConfig.clientDetailTaskData.getTaskData().getTaskDataDetail() == null) ? null : this.mConfig.clientDetailTaskData.getTaskData().getTaskDataDetail().getCpaQuestionData();
        if (cpaQuestionData == null) {
            return false;
        }
        for (CpaQuestionData cpaQuestionData2 : cpaQuestionData) {
            Integer questionType = cpaQuestionData2.getQuestionType();
            if (questionType != null && (1 == questionType.intValue() || (3 == questionType.intValue() && (formList = cpaQuestionData2.getFormList()) != null && !formList.isEmpty()))) {
                return true;
            }
        }
        return false;
    }

    private void setCplSort(boolean z) {
        this.cplSort = z;
    }

    public void submitTask(String str, final Action action) {
        ApiDataHelper.getApiDataHelper().submitTask(this.mContext, this.mConfig.clientDetailTaskData, str, this.formDatas, this.mAdditionalData, new ApiDataCallBack<String>() { // from class: com.fendasz.moku.planet.ui.dialog.TaskDialog.33
            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void success(int i, String str2) throws Exception {
                CpaData cpaData;
                TaskDialog.this.cpaLog("6", 3);
                TaskDialog.this.mIsNeedRefresh = true;
                if (TextUtils.isEmpty(str2) || (cpaData = (CpaData) JSON.parseObject(str2, CpaData.class)) == null) {
                    return;
                }
                if (cpaData.isFlag()) {
                    LogUtils.log(TaskDialog.TAG, "answer right");
                    TaskDialog.this.hideTips();
                    if (TaskDialog.this.isTaskGroup) {
                        TaskDialog.this.submitTaskGroupInitSp();
                    }
                    ApiDataHelper.getApiDataHelper().removePopuTask(TaskDialog.this.mContext);
                    TaskDialog.this.mIsSubmit = true;
                    TaskDialog.this.refresh();
                    TaskDialog.this.sendTaskSubmitBroadcast();
                    return;
                }
                Action action2 = action;
                if (action2 != null) {
                    action2.run();
                }
                if (cpaData.getCount().intValue() == 1) {
                    LogUtils.log(TaskDialog.TAG, "answer incorrect firstly");
                    if (cpaData.getFlags() == null || cpaData.getFlags().isEmpty()) {
                        TaskDialog.this.showAnswerTips();
                        return;
                    } else {
                        TaskDialog.this.showAnswerTips(cpaData.getFlags());
                        return;
                    }
                }
                if (cpaData.getCount().intValue() == 2) {
                    LogUtils.log(TaskDialog.TAG, "answer incorrect secondly");
                    TaskDialog.this.mIsSubmit = true;
                    if (TaskDialog.this.isTaskGroup) {
                        TaskDialog.this.submitTaskGroupInitSp();
                    }
                    CustomBuildDialog customBuildDialogCreate = new CustomBuildDialog.DialogBuilder(TaskDialog.this.mContext).setTitleImage(Integer.valueOf(R.drawable.moku_answer_incorrect)).setTitleText(TaskDialog.this.mContext.getString(R.string.moku_answer_incorrect_title)).setDetailText(TaskDialog.this.mContext.getString(R.string.moku_answer_incorrect_content_for_cpa_dialog)).setRightBtn("继续下一个", new CustomBuildDialog.DialogButtonOnClickListener() { // from class: com.fendasz.moku.planet.ui.dialog.TaskDialog.33.1
                        @Override // com.fendasz.moku.planet.ui.dialog.CustomBuildDialog.DialogButtonOnClickListener
                        public void onClick(TextView textView, CustomBuildDialog customBuildDialog) {
                            customBuildDialog.dismiss();
                            TaskDialog.this.changeTask(true);
                        }
                    }).setCancelable(false).create();
                    ApiDataHelper.getApiDataHelper().removePopuTask(TaskDialog.this.mContext);
                    customBuildDialogCreate.show();
                    TaskDialog.this.sendTaskSubmitBroadcast();
                }
            }

            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void error(int i, String str2) throws Exception {
                TaskDialog.this.cpaLog("6", 3);
                LogUtils.log(TaskDialog.TAG, "code:" + i + " message:" + str2);
                Toast.makeText(TaskDialog.this.mContext, str2 + i, 1).show();
            }
        });
    }

    public void dianSubmitTask(String str, final Action action) {
        ApiDataHelper.getApiDataHelper().dianSubmitTask(this.mContext, this.mConfig.clientDetailTaskData, str, this.formDatas, this.mAdditionalData, new ApiDataCallBack<String>() { // from class: com.fendasz.moku.planet.ui.dialog.TaskDialog.34
            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void success(int i, String str2) throws Exception {
                CpaData cpaData;
                TaskDialog.this.cpaLog("6", 3);
                TaskDialog.this.mIsNeedRefresh = true;
                if (TextUtils.isEmpty(str2) || (cpaData = (CpaData) JSON.parseObject(str2, CpaData.class)) == null) {
                    return;
                }
                if (cpaData.isFlag()) {
                    LogUtils.log(TaskDialog.TAG, "answer right");
                    TaskDialog.this.hideTips();
                    if (TaskDialog.this.isTaskGroup) {
                        TaskDialog.this.submitTaskGroupInitSp();
                    }
                    ApiDataHelper.getApiDataHelper().removePopuTask(TaskDialog.this.mContext);
                    TaskDialog.this.mIsSubmit = true;
                    TaskDialog.this.refresh();
                    TaskDialog.this.sendTaskSubmitBroadcast();
                    return;
                }
                Action action2 = action;
                if (action2 != null) {
                    action2.run();
                }
                if (cpaData.getCount().intValue() == 1) {
                    LogUtils.log(TaskDialog.TAG, "answer incorrect firstly");
                    if (cpaData.getFlags() == null || cpaData.getFlags().isEmpty()) {
                        TaskDialog.this.showAnswerTips();
                        return;
                    } else {
                        TaskDialog.this.showAnswerTips(cpaData.getFlags());
                        return;
                    }
                }
                if (cpaData.getCount().intValue() == 2) {
                    LogUtils.log(TaskDialog.TAG, "answer incorrect secondly");
                    TaskDialog.this.mIsSubmit = true;
                    if (TaskDialog.this.isTaskGroup) {
                        TaskDialog.this.submitTaskGroupInitSp();
                    }
                    CustomBuildDialog customBuildDialogCreate = new CustomBuildDialog.DialogBuilder(TaskDialog.this.mContext).setTitleImage(Integer.valueOf(R.drawable.moku_answer_incorrect)).setTitleText(TaskDialog.this.mContext.getString(R.string.moku_answer_incorrect_title)).setDetailText(TaskDialog.this.mContext.getString(R.string.moku_answer_incorrect_content_for_cpa_dialog)).setRightBtn("继续下一个", new CustomBuildDialog.DialogButtonOnClickListener() { // from class: com.fendasz.moku.planet.ui.dialog.TaskDialog.34.1
                        @Override // com.fendasz.moku.planet.ui.dialog.CustomBuildDialog.DialogButtonOnClickListener
                        public void onClick(TextView textView, CustomBuildDialog customBuildDialog) {
                            customBuildDialog.dismiss();
                            TaskDialog.this.changeTask(true);
                        }
                    }).setCancelable(false).create();
                    ApiDataHelper.getApiDataHelper().removePopuTask(TaskDialog.this.mContext);
                    customBuildDialogCreate.show();
                    TaskDialog.this.sendTaskSubmitBroadcast();
                }
            }

            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void error(int i, String str2) throws Exception {
                TaskDialog.this.cpaLog("6", 3);
                LogUtils.log(TaskDialog.TAG, "code:" + i + " message:" + str2);
                Toast.makeText(TaskDialog.this.mContext, str2 + i, 1).show();
            }
        });
    }

    public static class Builder {
        private final Config mConfig = new Config();
        private Context mContext;

        public Builder(Context context) {
            this.mContext = context;
        }

        public Builder setCancelable(Boolean bool) {
            this.mConfig.cancelable = bool.booleanValue();
            return this;
        }

        public Builder setTaskDetailData(ClientDetailTaskData clientDetailTaskData) {
            this.mConfig.clientDetailTaskData = clientDetailTaskData;
            return this;
        }

        public TaskDialog build() {
            return new TaskDialog(this.mContext, this.mConfig, null);
        }
    }
}
