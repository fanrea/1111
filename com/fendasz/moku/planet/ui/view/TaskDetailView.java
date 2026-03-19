package com.fendasz.moku.planet.ui.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.net.Uri;
import android.os.Build;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.URLSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.internal.view.SupportMenu;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.fendasz.moku.diandian.model.detail.DianCpaDetailActivity;
import com.fendasz.moku.planet.R;
import com.fendasz.moku.planet.constants.MokuConstants;
import com.fendasz.moku.planet.helper.MokuConfigure;
import com.fendasz.moku.planet.interf.Finish;
import com.fendasz.moku.planet.interf.TaskGroupRvInterface;
import com.fendasz.moku.planet.interf.TaskGroupUpdateDetailInterface;
import com.fendasz.moku.planet.interf.functions.Action;
import com.fendasz.moku.planet.interf.functions.Consumer;
import com.fendasz.moku.planet.source.bean.AnserDataEntity;
import com.fendasz.moku.planet.source.bean.ClientDetailTaskData;
import com.fendasz.moku.planet.source.bean.ClientTaskDataSubmitFormModel;
import com.fendasz.moku.planet.source.bean.CpaQuestionData;
import com.fendasz.moku.planet.source.bean.TaskDataApplyRecord;
import com.fendasz.moku.planet.source.bean.TaskDataStep;
import com.fendasz.moku.planet.source.bean.taskdatagroup.ClientGroupTaskData;
import com.fendasz.moku.planet.source.bean.taskdatagroup.ClientGroupTaskDataStatusEnum;
import com.fendasz.moku.planet.ui.activity.TaskDetailActivity;
import com.fendasz.moku.planet.ui.adapter.TaskGroupRvAdapter;
import com.fendasz.moku.planet.ui.dialog.CustomBuildDialog;
import com.fendasz.moku.planet.ui.dialog.ViewImageDialog;
import com.fendasz.moku.planet.utils.ImageUtils;
import com.fendasz.moku.planet.utils.LogUtils;
import com.fendasz.moku.planet.utils.MokuUtils;
import com.fendasz.moku.planet.utils.PhoneScreenUtils;
import com.fendasz.moku.planet.utils.QrCodeUtils;
import com.fendasz.moku.planet.utils.ScreenAdaptationUtils;
import com.fendasz.moku.planet.utils.SharedPreferencesUtils;
import com.fendasz.moku.planet.utils.StorageUtils;
import com.fendasz.moku.planet.utils.StringUtils;
import com.fendasz.moku.planet.utils.StyleUtils;
import com.fendasz.moku.planet.utils.WeChatUtils;
import com.fendasz.moku.planet.utils.system.utils.SystemUtils;
import com.luck.picture.lib.config.PictureMimeType;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class TaskDetailView {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String TAG = "TaskDetailView";
    private Button btnStartTask;
    private Bitmap currentBitmap;
    private String currentUrl;
    private List<EditText> etAnswerList;
    private List<EditText> etFormList;
    private List<File> fileUploadImageList;
    private List<ClientGroupTaskData> followUpOpenGroupTaskDataList;
    private List<ClientTaskDataSubmitFormModel> formDatas;
    private List<ImageView> ivUploadImageList;
    private List<LinearLayout> llAnswerList;
    private LinearLayout llTaskDescModule;
    private Button mBtnSubmit;
    private ClientDetailTaskData mClientDetailTaskData;
    private LinearLayout mContentView;
    private Context mContext;
    private LinearLayout mCpaTaskGroupTabView;
    private EditText mEtInput;
    private boolean mIsUpdateGroupTab;
    private LinearLayout mLlBrowser;
    private LinearLayout mLlOptions;
    private LinearLayout mLlTaskContainer;
    private LinearLayout mLlWeChat;
    private PhoneScreenUtils mPhoneScreenUtils;
    private RelativeLayout mRlOptionsContainer;
    private TextView mTvAnswerError;
    private TextView mTvAnswerErrorTip;
    private TextView mTvAnswerTips;
    private TextView mTvBtnCommentCopy;
    private TextView mTvCommentContent;
    private TextView mTvSearchTerms;
    private int mainThemeColor;
    private LinearLayout mllSearchTerms;
    private List<ClientGroupTaskData> openGroupTaskDataList;
    private List<ClientGroupTaskData> stayOpenGroupTaskDataList;
    private TaskGroupRvAdapter taskGroupRvAdapter;
    private TaskGroupUpdateDetailInterface taskGroupUpdateDetailInterface;

    public TaskDetailView(Context context, LinearLayout linearLayout, PhoneScreenUtils phoneScreenUtils) {
        this.mContext = context;
        this.mContentView = linearLayout;
        this.mPhoneScreenUtils = phoneScreenUtils;
        this.mainThemeColor = Color.parseColor(MokuConfigure.getInstance().getMokuOptions(this.mContext).getString("tabIndicatorColor", "#AEC7B1"));
    }

    public void setOnUpdateDetailView(TaskGroupUpdateDetailInterface taskGroupUpdateDetailInterface) {
        this.taskGroupUpdateDetailInterface = taskGroupUpdateDetailInterface;
    }

    public void initStaticView() {
        RelativeLayout rlContentBottom;
        ScreenAdaptationUtils.setHeight(this.mContext, (LinearLayout) this.mContentView.findViewById(R.id.ll_background), 200);
        ScreenAdaptationUtils.setHeight(this.mContext, (LinearLayout) this.mContentView.findViewById(R.id.ll_bottom), 150);
        LinearLayout linearLayout = (LinearLayout) this.mContentView.findViewById(R.id.ll_on_task);
        this.btnStartTask = (Button) this.mContentView.findViewById(R.id.btn_start_task);
        RelativeLayout relativeLayout = (RelativeLayout) this.mContentView.findViewById(R.id.rl_download);
        TextView textView = (TextView) this.mContentView.findViewById(R.id.tv_cancel_task);
        textView.setTextSize(this.mPhoneScreenUtils.getBigTextSize(this.mContext));
        TextView textView2 = (TextView) this.mContentView.findViewById(R.id.tv_download);
        textView2.setTextSize(this.mPhoneScreenUtils.getMiddleTextSize(this.mContext));
        ProgressBar progressBar = (ProgressBar) this.mContentView.findViewById(R.id.pb_download);
        this.mLlTaskContainer = (LinearLayout) this.mContentView.findViewById(R.id.ll_task_container);
        Context context = this.mContext;
        if (context instanceof TaskDetailActivity) {
            rlContentBottom = ((TaskDetailActivity) context).getRlContentBottom();
        } else {
            rlContentBottom = context instanceof DianCpaDetailActivity ? ((DianCpaDetailActivity) context).getRlContentBottom() : null;
        }
        if (rlContentBottom != null) {
            rlContentBottom.setVisibility(0);
            initLlOptionsView(rlContentBottom);
        }
        Context context2 = this.mContext;
        if (context2 instanceof TaskDetailActivity) {
            ((TaskDetailActivity) context2).initStaticView(linearLayout, relativeLayout, textView2, this.btnStartTask, textView, progressBar);
        } else if (context2 instanceof DianCpaDetailActivity) {
            ((DianCpaDetailActivity) context2).initStaticView(linearLayout, relativeLayout, textView2, this.btnStartTask, textView, progressBar);
        }
    }

    private void initLlOptionsView(RelativeLayout relativeLayout) {
        RelativeLayout relativeLayout2 = new RelativeLayout(this.mContext);
        this.mRlOptionsContainer = relativeLayout2;
        relativeLayout.addView(relativeLayout2);
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
            relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.fendasz.moku.planet.ui.view.TaskDetailView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TaskDetailView.this.mRlOptionsContainer.setVisibility(8);
                }
            });
        }
        LinearLayout linearLayout4 = this.mLlOptions;
        if (linearLayout4 != null) {
            linearLayout4.setOnTouchListener(new View.OnTouchListener() { // from class: com.fendasz.moku.planet.ui.view.TaskDetailView.2
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    return true;
                }
            });
        }
        if (linearLayout != null) {
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.fendasz.moku.planet.ui.view.TaskDetailView.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TaskDetailView.this.saveBitmap("保存成功", "保存失败");
                    if (TaskDetailView.this.mRlOptionsContainer != null) {
                        TaskDetailView.this.mRlOptionsContainer.setVisibility(8);
                    }
                }
            });
        }
        if (linearLayout2 != null) {
            linearLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.fendasz.moku.planet.ui.view.TaskDetailView.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (TaskDetailView.this.mRlOptionsContainer != null) {
                        TaskDetailView.this.mRlOptionsContainer.setVisibility(8);
                    }
                    TaskDetailView.this.showQrCodeScanTipDialog(new Action() { // from class: com.fendasz.moku.planet.ui.view.TaskDetailView.4.1
                        @Override // com.fendasz.moku.planet.interf.functions.Action
                        public void run() throws Exception {
                            TaskDetailView.this.saveBitmap("图片已保存", "图片保存失败");
                            if (WeChatUtils.openWeChatQrCode(TaskDetailView.this.mContext)) {
                                return;
                            }
                            Toast.makeText(TaskDetailView.this.mContext, "请先安装微信", 0).show();
                        }
                    });
                }
            });
        }
        if (linearLayout3 != null) {
            linearLayout3.setOnClickListener(new View.OnClickListener() { // from class: com.fendasz.moku.planet.ui.view.TaskDetailView.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (TaskDetailView.this.mRlOptionsContainer != null) {
                        TaskDetailView.this.mRlOptionsContainer.setVisibility(8);
                    }
                    TaskDetailView.this.showQrCodeScanTipDialog(new Action() { // from class: com.fendasz.moku.planet.ui.view.TaskDetailView.5.1
                        @Override // com.fendasz.moku.planet.interf.functions.Action
                        public void run() throws Exception {
                            TaskDetailView.this.saveBitmap("图片已保存", "图片保存失败");
                            if (TextUtils.isEmpty(TaskDetailView.this.currentUrl)) {
                                return;
                            }
                            LogUtils.log(TaskDetailView.TAG, "开始打开浏览器，链接：" + TaskDetailView.this.currentUrl);
                            SystemUtils.openBrowser(TaskDetailView.this.mContext, TaskDetailView.this.currentUrl);
                        }
                    });
                }
            });
        }
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.fendasz.moku.planet.ui.view.TaskDetailView.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (TaskDetailView.this.mRlOptionsContainer != null) {
                        TaskDetailView.this.mRlOptionsContainer.setVisibility(8);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showQrCodeScanTipDialog(final Action action) {
        final SharedPreferencesUtils sharedPreferencesUtils = SharedPreferencesUtils.getInstance(this.mContext);
        if (sharedPreferencesUtils.getBoolean(this.mContext.getString(R.string.moku_sp_is_show_qr_code_scan_tip), true)) {
            new CustomBuildDialog.DialogBuilder(this.mContext).setCancelable(false).setTitleImage(Integer.valueOf(R.drawable.moku_tips_icon)).setDetailText(this.mContext.getString(R.string.moku_dialog_detail_text_qr_code_scan_tip)).setRightBtn(this.mContext.getString(R.string.moku_dialog_btn_text__i_know), new CustomBuildDialog.DialogButtonOnClickListener() { // from class: com.fendasz.moku.planet.ui.view.TaskDetailView.7
                @Override // com.fendasz.moku.planet.ui.dialog.CustomBuildDialog.DialogButtonOnClickListener
                public void onClick(TextView textView, CustomBuildDialog customBuildDialog) {
                    sharedPreferencesUtils.putBoolean(TaskDetailView.this.mContext.getString(R.string.moku_sp_is_show_qr_code_scan_tip), false);
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

    public void initDynamicData(ClientDetailTaskData clientDetailTaskData, List<File> list, List<ImageView> list2, List<EditText> list3, List<ClientTaskDataSubmitFormModel> list4, List<LinearLayout> list5, boolean z) {
        this.mClientDetailTaskData = clientDetailTaskData;
        this.fileUploadImageList = list;
        this.ivUploadImageList = list2;
        this.etFormList = list3;
        this.formDatas = list4;
        this.llAnswerList = list5;
        this.mIsUpdateGroupTab = z;
    }

    public List<ClientGroupTaskData> getOpenGroupTaskDataList() {
        List<ClientGroupTaskData> list = this.openGroupTaskDataList;
        return list == null ? new ArrayList() : list;
    }

    public List<ClientGroupTaskData> getStayOpenGroupTaskDataList() {
        List<ClientGroupTaskData> list = this.stayOpenGroupTaskDataList;
        return list == null ? new ArrayList() : list;
    }

    public List<ClientGroupTaskData> getFollowUpOpenGroupTaskDataList() {
        List<ClientGroupTaskData> list = this.followUpOpenGroupTaskDataList;
        return list == null ? new ArrayList() : list;
    }

    public void initDynamicView() {
        this.mLlTaskContainer.removeAllViews();
        initBasicInfoView();
        if (this.mClientDetailTaskData.getClientGroupTaskDataList() != null && this.mClientDetailTaskData.getClientGroupTaskDataList().size() > 0) {
            initTaskGroupView();
            this.openGroupTaskDataList = new ArrayList();
            this.stayOpenGroupTaskDataList = new ArrayList();
            this.followUpOpenGroupTaskDataList = new ArrayList();
            for (ClientGroupTaskData clientGroupTaskData : this.mClientDetailTaskData.getClientGroupTaskDataList()) {
                if (clientGroupTaskData.getStatus().equals(ClientGroupTaskDataStatusEnum.STATUS_OF_OPENING)) {
                    this.openGroupTaskDataList.add(clientGroupTaskData);
                    if (!clientGroupTaskData.getTaskDataId().equals(this.mClientDetailTaskData.getTaskDataId())) {
                        this.stayOpenGroupTaskDataList.add(clientGroupTaskData);
                    }
                }
                if (clientGroupTaskData.getStatus().equals(ClientGroupTaskDataStatusEnum.STATUS_OF_WAITING_OPENED)) {
                    this.stayOpenGroupTaskDataList.add(clientGroupTaskData);
                }
                if (clientGroupTaskData.getStatus().equals(ClientGroupTaskDataStatusEnum.STATUS_OF_SUBSEQUENT_OPENING)) {
                    this.followUpOpenGroupTaskDataList.add(clientGroupTaskData);
                }
            }
            if (this.openGroupTaskDataList.size() == 0) {
                initTaskGroupEmptyView();
                this.btnStartTask.setText("暂无任务开启");
                this.btnStartTask.setEnabled(false);
                return;
            }
        }
        initTaskDescView();
        if (this.mClientDetailTaskData.getClassify().equals("cpa") && !this.mClientDetailTaskData.getTaskData().getCpaType().equals(MokuConstants.CPA_TYPE_NORMAL)) {
            if (this.mClientDetailTaskData.getTaskType() != null && this.mClientDetailTaskData.getTaskType().intValue() == 0) {
                initBTaskAnswerView();
                return;
            } else {
                initTaskAnswerView();
                return;
            }
        }
        Integer customRange = this.mClientDetailTaskData.getTaskData().getTaskDataDetail().getCustomRange();
        Integer isCustomDesc = this.mClientDetailTaskData.getTaskData().getTaskDataDetail().getIsCustomDesc();
        if (this.mClientDetailTaskData.getTaskType() != null && this.mClientDetailTaskData.getTaskType().intValue() == 0) {
            if (this.mClientDetailTaskData.getClassify().equals("cpa")) {
                initBTaskAnswerView();
            } else if (isCustomDesc != null && 1 == isCustomDesc.intValue()) {
                if (customRange != null && 1 != customRange.intValue()) {
                    initTaskFlowView();
                }
            } else {
                initTaskFlowView();
            }
        } else {
            initTaskFlowView();
        }
        initTaskSubmitView();
    }

    private void updateTaskGroupDetailInfo(ClientGroupTaskData clientGroupTaskData) {
        if (this.taskGroupUpdateDetailInterface != null) {
            if (clientGroupTaskData.getTaskDataId() != null) {
                this.taskGroupUpdateDetailInterface.updateDetail(clientGroupTaskData.getTaskDataId().intValue());
            } else {
                this.taskGroupUpdateDetailInterface.updateDetail(0);
            }
        }
    }

    private void initTaskGroupView() {
        if (this.mIsUpdateGroupTab) {
            this.mCpaTaskGroupTabView = null;
        }
        LinearLayout linearLayout = this.mCpaTaskGroupTabView;
        if (linearLayout != null) {
            this.mLlTaskContainer.addView(linearLayout);
            return;
        }
        LinearLayout linearLayout2 = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.moku_task_cpa_group_view, (ViewGroup) this.mLlTaskContainer, false);
        this.mCpaTaskGroupTabView = linearLayout2;
        this.mLlTaskContainer.addView(linearLayout2);
        RecyclerView recyclerView = (RecyclerView) this.mCpaTaskGroupTabView.findViewById(R.id.rv_task_group);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.mContext);
        linearLayoutManager.setOrientation(0);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setOverScrollMode(2);
        List<ClientGroupTaskData> clientGroupTaskDataList = this.mClientDetailTaskData.getClientGroupTaskDataList();
        if (clientGroupTaskDataList != null && clientGroupTaskDataList.size() > 0) {
            for (int i = 0; i < clientGroupTaskDataList.size(); i++) {
                ClientGroupTaskData clientGroupTaskData = clientGroupTaskDataList.get(i);
                if (clientGroupTaskData.getTaskDataId() != null && clientGroupTaskData.getTaskDataId().equals(this.mClientDetailTaskData.getTaskDataId())) {
                    clientGroupTaskDataList.get(i).setSelected(true);
                }
            }
        }
        TaskGroupRvAdapter taskGroupRvAdapter = new TaskGroupRvAdapter(this.mContext);
        this.taskGroupRvAdapter = taskGroupRvAdapter;
        taskGroupRvAdapter.setClientGroupTaskDataList(this.mClientDetailTaskData.getClientGroupTaskDataList());
        recyclerView.setAdapter(this.taskGroupRvAdapter);
        this.taskGroupRvAdapter.setOnItemClickListener(new TaskGroupRvInterface() { // from class: com.fendasz.moku.planet.ui.view.TaskDetailView$$ExternalSyntheticLambda1
            @Override // com.fendasz.moku.planet.interf.TaskGroupRvInterface
            public final void onItemClickListener(int i2) {
                this.f$0.m444xa1f0706a(i2);
            }
        });
    }

    /* renamed from: lambda$initTaskGroupView$0$com-fendasz-moku-planet-ui-view-TaskDetailView, reason: not valid java name */
    /* synthetic */ void m444xa1f0706a(int i) {
        if (this.mClientDetailTaskData.getTaskDataApplyRecord() != null && this.mClientDetailTaskData.getTaskDataApplyRecord().getStatus().intValue() == 0) {
            Toast.makeText(this.mContext, "请先完成当前任务", 0).show();
            return;
        }
        List<ClientGroupTaskData> clientGroupTaskDataList = this.taskGroupRvAdapter.getClientGroupTaskDataList();
        if (clientGroupTaskDataList != null) {
            for (int i2 = 0; i2 < clientGroupTaskDataList.size(); i2++) {
                if (i2 == i) {
                    clientGroupTaskDataList.get(i2).setSelected(true);
                } else {
                    clientGroupTaskDataList.get(i2).setSelected(false);
                }
            }
            this.taskGroupRvAdapter.notifyDataSetChanged();
            updateTaskGroupDetailInfo(clientGroupTaskDataList.get(i));
        }
    }

    private void initTaskAnswerView() {
        List<TaskDataStep> list;
        int i;
        List<HashMap> list2;
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.mContext).inflate(R.layout.moku_process_module, (ViewGroup) null);
        this.mLlTaskContainer.addView(relativeLayout);
        ScreenAdaptationUtils.setMarginBottom(this.mContext, relativeLayout, 30);
        ((TextView) relativeLayout.findViewById(R.id.tv_process_label)).setText("答题");
        Map<Integer, List<TaskDataStep>> integerListMap = this.mClientDetailTaskData.getIntegerListMap();
        LinearLayout linearLayout = (LinearLayout) relativeLayout.findViewById(R.id.ll_child_process);
        if (integerListMap != null && (list = integerListMap.get(1)) != null && list.size() > 0) {
            String taskDataCustomDesc = list.get(0).getTaskDataCustomDesc();
            int iIntValue = list.get(0).getTaskDataStepConfigType().intValue();
            setChildProcessDesc(linearLayout, 1, taskDataCustomDesc);
            List<HashMap> answerList = this.mClientDetailTaskData.getTaskData().getTaskDataDetail().getAnswerList();
            int i2 = 0;
            while (i2 < list.size()) {
                TaskDataStep taskDataStep = list.get(i2);
                if (TextUtils.isEmpty(taskDataStep.getTaskDataSampleScreenshotUrl())) {
                    i = i2;
                    list2 = answerList;
                } else {
                    LinearLayout linearLayout2 = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.moku_child_process_content, (ViewGroup) null);
                    linearLayout.addView(linearLayout2);
                    ImageView imageView = new ImageView(this.mContext);
                    linearLayout2.addView(imageView);
                    ScreenAdaptationUtils.setMarginTop(this.mContext, imageView, 30);
                    imageView.setBackgroundResource(R.color.moku_transparent);
                    imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    i = i2;
                    list2 = answerList;
                    setImageView(taskDataStep.getTaskDataSampleScreenshotUrl(), imageView, 450, isMiniProgrammer(iIntValue, taskDataCustomDesc), isReward(Integer.valueOf(iIntValue)), iIntValue);
                }
                i2 = i + 1;
                answerList = list2;
            }
            List<HashMap> list3 = answerList;
            if (this.mClientDetailTaskData.getTaskData().getCpaType().equals(MokuConstants.CPA_TYPE_NORMAL_CHOICE_QUESTION)) {
                this.mTvAnswerErrorTip = new TextView(this.mContext);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 1;
                this.mTvAnswerErrorTip.setLayoutParams(layoutParams);
                linearLayout.addView(this.mTvAnswerErrorTip);
                this.mTvAnswerErrorTip.setTextSize(this.mPhoneScreenUtils.getMiddleTextSize(this.mContext));
                this.mTvAnswerErrorTip.setTextColor(this.mContext.getResources().getColor(R.color.moku_red));
                this.mTvAnswerErrorTip.setText("答错啦，还剩1次答题机会~");
                this.mTvAnswerErrorTip.setVisibility(8);
                ScreenAdaptationUtils.setMarginTop(this.mContext, this.mTvAnswerErrorTip, 30);
                for (int i3 = 0; i3 < list3.size(); i3++) {
                    setAnswerView(linearLayout, i3, (String) list3.get(i3).get("answer"), null);
                }
            }
            if (MokuConstants.CPA_TYPE_NORMAL_GAP_FILLING.equals(this.mClientDetailTaskData.getTaskData().getCpaType()) || MokuConstants.CPA_TYPE_NORMAL_FORM.equals(this.mClientDetailTaskData.getTaskData().getCpaType())) {
                String str = "请输入答案 (<font color=\"#ff0000\">" + ((list3 == null || list3.size() <= 0) ? "" : (String) list3.get(0).get("answer")).length() + "个字</font>)";
                TextView textView = new TextView(this.mContext);
                this.mTvAnswerTips = textView;
                textView.setTextColor(this.mContext.getResources().getColor(R.color.moku_gray_deep));
                if (Build.VERSION.SDK_INT >= 24) {
                    this.mTvAnswerTips.setText(Html.fromHtml(str, 63));
                } else {
                    this.mTvAnswerTips.setText(Html.fromHtml(str));
                }
                this.mTvAnswerTips.setTextSize(this.mPhoneScreenUtils.getMiddleTextSize(this.mContext));
                linearLayout.addView(this.mTvAnswerTips);
                ScreenAdaptationUtils.setMarginTop(this.mContext, this.mTvAnswerTips, 30);
                LinearLayout linearLayout3 = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.moku_gap_filling_input_item, (ViewGroup) linearLayout, false);
                LinearLayout linearLayout4 = (LinearLayout) linearLayout3.findViewById(R.id.ll_input_container);
                ScreenAdaptationUtils.setHeight(this.mContext, linearLayout4, 120);
                ScreenAdaptationUtils.setMarginTop(this.mContext, linearLayout4, 10);
                linearLayout.addView(linearLayout3);
                EditText editText = (EditText) linearLayout3.findViewById(R.id.et_input);
                this.mEtInput = editText;
                editText.setPadding(this.mPhoneScreenUtils.getScale(this.mContext, 20.0f), 0, 0, 0);
                this.mEtInput.setTextSize(this.mPhoneScreenUtils.getMiddleTextSize(this.mContext));
                this.mBtnSubmit = (Button) linearLayout3.findViewById(R.id.btn_submit);
                if (MokuConstants.CPA_TYPE_NORMAL_FORM.equals(this.mClientDetailTaskData.getTaskData().getCpaType())) {
                    this.mBtnSubmit.setVisibility(8);
                } else {
                    this.mBtnSubmit.setVisibility(0);
                    this.mBtnSubmit.setTextSize(this.mPhoneScreenUtils.getMiddleTextSize(this.mContext));
                }
                TextView textView2 = (TextView) linearLayout3.findViewById(R.id.tv_answer_error_icon);
                this.mTvAnswerError = textView2;
                textView2.setTextSize(this.mPhoneScreenUtils.getSmallTextSize(this.mContext));
                ScreenAdaptationUtils.setSize(this.mContext, this.mTvAnswerError, 55, 55);
                TextView textView3 = (TextView) linearLayout3.findViewById(R.id.tv_answer_error_tip);
                this.mTvAnswerErrorTip = textView3;
                textView3.setTextSize(this.mPhoneScreenUtils.getMiddleTextSize(this.mContext));
            }
            List<String> formList = this.mClientDetailTaskData.getFormList();
            if (formList != null && !formList.isEmpty()) {
                int i4 = 0;
                for (int i5 = 0; i5 < formList.size(); i5++) {
                    String str2 = formList.get(i5);
                    if (!TextUtils.isEmpty(str2)) {
                        i4++;
                        setChildProcessDesc(linearLayout, i4, "请提交 <font color=\"#ff0000\">" + str2 + "</font>", false);
                        LinearLayout linearLayout5 = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.moku_input_item, (ViewGroup) null);
                        linearLayout.addView(linearLayout5);
                        ScreenAdaptationUtils.setMarginTop(this.mContext, linearLayout5, 30);
                        ScreenAdaptationUtils.setHeight(this.mContext, linearLayout5, 130);
                        EditText editText2 = (EditText) linearLayout5.findViewById(R.id.et_input);
                        editText2.setHint(str2);
                        editText2.setTextSize(this.mPhoneScreenUtils.getNormalTextSize(this.mContext));
                        editText2.setEnabled(false);
                        this.etFormList.add(editText2);
                        ClientTaskDataSubmitFormModel clientTaskDataSubmitFormModel = new ClientTaskDataSubmitFormModel();
                        clientTaskDataSubmitFormModel.setKey(str2);
                        this.formDatas.add(clientTaskDataSubmitFormModel);
                    }
                }
            }
            if (this.mClientDetailTaskData.isTaskGroup()) {
                setChildProcessDesc(linearLayout, 2, "获得奖励");
                TextView textView4 = new TextView(this.mContext);
                linearLayout.addView(textView4);
                ScreenAdaptationUtils.setMarginTop(this.mContext, textView4, 20);
                ScreenAdaptationUtils.setMarginLeftAndRight(this.mContext, textView4, 70);
                textView4.setTextColor(this.mContext.getResources().getColor(R.color.moku_gray_deep));
                String str3 = getTaskDataMoney() + this.mClientDetailTaskData.getCybermoneyName();
                if (isLastDayTask()) {
                    textView4.setText("有志者事竟成！恭喜您，" + str3 + "即将到账");
                } else {
                    textView4.setText("该任务奖励为" + str3 + "，明天还有奖励哦~不要卸载，明天见！");
                }
                textView4.setTextSize(this.mPhoneScreenUtils.getSmallTextSize(this.mContext));
            }
        }
        Context context = this.mContext;
        if (context instanceof TaskDetailActivity) {
            ((TaskDetailActivity) context).initTaskAnswerView(this.mEtInput, this.mBtnSubmit, this.mTvAnswerError, this.mTvAnswerErrorTip, this.mTvAnswerTips);
        } else if (context instanceof DianCpaDetailActivity) {
            ((DianCpaDetailActivity) context).initTaskAnswerView(this.mEtInput, this.mBtnSubmit, this.mTvAnswerError, this.mTvAnswerErrorTip, this.mTvAnswerTips);
        }
    }

    private void initBTaskAnswerView() {
        int i;
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        ArrayList arrayList5;
        int i2;
        ArrayList arrayList6;
        int i3;
        ArrayList arrayList7;
        List<String> list;
        AnserDataEntity anserDataEntity;
        Integer num;
        String str;
        int i4;
        int i5;
        ArrayList arrayList8;
        ViewGroup viewGroup = null;
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.mContext).inflate(R.layout.moku_process_module, (ViewGroup) null);
        this.mLlTaskContainer.addView(relativeLayout);
        ScreenAdaptationUtils.setMarginBottom(this.mContext, relativeLayout, 30);
        ((TextView) relativeLayout.findViewById(R.id.tv_process_label)).setText("任务步骤");
        LinearLayout linearLayout = (LinearLayout) relativeLayout.findViewById(R.id.ll_child_process);
        int i6 = 0;
        if (this.mClientDetailTaskData.getTaskData() == null || this.mClientDetailTaskData.getTaskData().getTaskDataDetail() == null) {
            i = 0;
            arrayList = null;
            arrayList2 = null;
            arrayList3 = null;
            arrayList4 = null;
            arrayList5 = null;
        } else {
            ArrayList arrayList9 = new ArrayList();
            ArrayList arrayList10 = new ArrayList();
            ArrayList arrayList11 = new ArrayList();
            ArrayList arrayList12 = new ArrayList();
            ArrayList arrayList13 = new ArrayList();
            List<CpaQuestionData> cpaQuestionData = this.mClientDetailTaskData.getTaskData().getTaskDataDetail().getCpaQuestionData();
            if (cpaQuestionData == null) {
                return;
            }
            int size = cpaQuestionData.size();
            int i7 = 0;
            int i8 = 1;
            for (CpaQuestionData cpaQuestionData2 : cpaQuestionData) {
                List<List<TaskDataStep>> steps = cpaQuestionData2.getSteps();
                if (steps == null || steps.isEmpty()) {
                    i2 = i7;
                    arrayList6 = arrayList13;
                    i3 = 1;
                } else {
                    int i9 = i8;
                    for (List<TaskDataStep> list2 : steps) {
                        String taskDataCustomDesc = list2.get(i6).getTaskDataCustomDesc();
                        Integer taskDataStepConfigType = list2.get(i6).getTaskDataStepConfigType();
                        if (taskDataCustomDesc != null && !TextUtils.isEmpty(taskDataCustomDesc) && taskDataStepConfigType != null) {
                            setChildProcessDesc(linearLayout, i9, taskDataCustomDesc);
                        }
                        for (TaskDataStep taskDataStep : list2) {
                            if (TextUtils.isEmpty(taskDataStep.getTaskDataSampleScreenshotUrl())) {
                                num = taskDataStepConfigType;
                                str = taskDataCustomDesc;
                                i4 = i9;
                                i5 = i7;
                                arrayList8 = arrayList13;
                            } else {
                                LinearLayout linearLayout2 = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.moku_child_process_content, viewGroup);
                                linearLayout.addView(linearLayout2);
                                ImageView imageView = new ImageView(this.mContext);
                                linearLayout2.addView(imageView);
                                ScreenAdaptationUtils.setMarginTop(this.mContext, imageView, 30);
                                imageView.setBackgroundResource(R.color.moku_transparent);
                                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                                num = taskDataStepConfigType;
                                str = taskDataCustomDesc;
                                i4 = i9;
                                i5 = i7;
                                arrayList8 = arrayList13;
                                setImageView(taskDataStep.getTaskDataSampleScreenshotUrl(), imageView, 450, isMiniProgrammer(taskDataStepConfigType.intValue(), taskDataCustomDesc), isReward(taskDataStepConfigType), taskDataStepConfigType.intValue());
                            }
                            i9 = i4;
                            i7 = i5;
                            taskDataStepConfigType = num;
                            taskDataCustomDesc = str;
                            arrayList13 = arrayList8;
                            viewGroup = null;
                        }
                        i9++;
                        viewGroup = null;
                        i6 = 0;
                    }
                    i2 = i7;
                    arrayList6 = arrayList13;
                    i3 = 1;
                    i8 = i9;
                }
                List<AnserDataEntity> answerList = cpaQuestionData2.getAnswerList();
                Integer questionType = cpaQuestionData2.getQuestionType();
                if (questionType == null) {
                    arrayList7 = arrayList6;
                } else {
                    if (questionType.intValue() == 0) {
                        LinearLayout linearLayout3 = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.moku_child_process_content, (ViewGroup) null);
                        linearLayout.addView(linearLayout3);
                        ImageView imageView2 = new ImageView(this.mContext);
                        linearLayout3.addView(imageView2);
                        ScreenAdaptationUtils.setMarginTop(this.mContext, imageView2, 30);
                        final Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(this.mContext.getResources(), R.drawable.gallery_tip);
                        if (bitmapDecodeResource != null) {
                            ScreenAdaptationUtils.setSize(this.mContext, imageView2, Integer.valueOf((int) 600.0f), Integer.valueOf((int) ((bitmapDecodeResource.getHeight() * 600.0f) / bitmapDecodeResource.getWidth())));
                            imageView2.setBackgroundResource(R.color.moku_transparent);
                            imageView2.setScaleType(ImageView.ScaleType.FIT_XY);
                            imageView2.setImageBitmap(bitmapDecodeResource);
                            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.fendasz.moku.planet.ui.view.TaskDetailView.8
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view) {
                                    new ViewImageDialog.Builder(TaskDetailView.this.mContext).setBitmap(bitmapDecodeResource).create().show();
                                }
                            });
                        }
                    } else if (i3 == questionType.intValue() || 3 == questionType.intValue()) {
                        String str2 = "请输入答案 (<font color=\"#ff0000\">" + ((answerList == null || answerList.size() <= 0 || (anserDataEntity = answerList.get(0)) == null || anserDataEntity.getAnswer() == null) ? "" : anserDataEntity.getAnswer()).length() + "个字</font>)";
                        TextView textView = new TextView(this.mContext);
                        this.mTvAnswerTips = textView;
                        arrayList12.add(textView);
                        this.mTvAnswerTips.setTextColor(this.mContext.getResources().getColor(R.color.moku_gray_deep));
                        if (Build.VERSION.SDK_INT >= 24) {
                            this.mTvAnswerTips.setText(Html.fromHtml(str2, 63));
                        } else {
                            this.mTvAnswerTips.setText(Html.fromHtml(str2));
                        }
                        this.mTvAnswerTips.setTextSize(this.mPhoneScreenUtils.getMiddleTextSize(this.mContext));
                        linearLayout.addView(this.mTvAnswerTips);
                        ScreenAdaptationUtils.setMarginTop(this.mContext, this.mTvAnswerTips, 30);
                        LinearLayout linearLayout4 = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.moku_gap_filling_input_item, (ViewGroup) linearLayout, false);
                        LinearLayout linearLayout5 = (LinearLayout) linearLayout4.findViewById(R.id.ll_input_container);
                        ScreenAdaptationUtils.setHeight(this.mContext, linearLayout5, 120);
                        ScreenAdaptationUtils.setMarginTop(this.mContext, linearLayout5, 10);
                        linearLayout.addView(linearLayout4);
                        EditText editText = (EditText) linearLayout4.findViewById(R.id.et_input);
                        this.mEtInput = editText;
                        editText.setTag(cpaQuestionData2.getQuestionNum());
                        arrayList9.add(this.mEtInput);
                        arrayList7 = arrayList6;
                        arrayList7.add(this.mEtInput);
                        this.mEtInput.setPadding(this.mPhoneScreenUtils.getScale(this.mContext, 20.0f), 0, 0, 0);
                        this.mEtInput.setTextSize(this.mPhoneScreenUtils.getMiddleTextSize(this.mContext));
                        Button button = (Button) linearLayout4.findViewById(R.id.btn_submit);
                        this.mBtnSubmit = button;
                        button.setVisibility(8);
                        TextView textView2 = (TextView) linearLayout4.findViewById(R.id.tv_answer_error_icon);
                        this.mTvAnswerError = textView2;
                        arrayList10.add(textView2);
                        this.mTvAnswerError.setTextSize(this.mPhoneScreenUtils.getSmallTextSize(this.mContext));
                        ScreenAdaptationUtils.setSize(this.mContext, this.mTvAnswerError, 55, 55);
                        TextView textView3 = (TextView) linearLayout4.findViewById(R.id.tv_answer_error_tip);
                        this.mTvAnswerErrorTip = textView3;
                        arrayList11.add(textView3);
                        this.mTvAnswerErrorTip.setTextSize(this.mPhoneScreenUtils.getMiddleTextSize(this.mContext));
                    } else if (2 == questionType.intValue()) {
                        TextView textView4 = new TextView(this.mContext);
                        this.mTvAnswerErrorTip = textView4;
                        arrayList11.add(textView4);
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                        layoutParams.gravity = i3;
                        this.mTvAnswerErrorTip.setLayoutParams(layoutParams);
                        linearLayout.addView(this.mTvAnswerErrorTip);
                        this.mTvAnswerErrorTip.setTextSize(this.mPhoneScreenUtils.getMiddleTextSize(this.mContext));
                        this.mTvAnswerErrorTip.setTextColor(this.mContext.getResources().getColor(R.color.moku_red));
                        this.mTvAnswerErrorTip.setText("答错啦，还剩1次答题机会~");
                        this.mTvAnswerErrorTip.setVisibility(8);
                        ScreenAdaptationUtils.setMarginTop(this.mContext, this.mTvAnswerErrorTip, 30);
                        for (int i10 = 0; i10 < answerList.size(); i10++) {
                            setAnswerView(linearLayout, i10, answerList.get(i10).getAnswer(), cpaQuestionData2.getQuestionNum());
                        }
                    }
                    arrayList7 = arrayList6;
                }
                List<String> formList = cpaQuestionData2.getFormList();
                cpaQuestionData2.getAnswerList();
                if (formList != null && !formList.isEmpty()) {
                    int i11 = 0;
                    int i12 = 0;
                    while (i11 < formList.size()) {
                        String str3 = formList.get(i11);
                        Integer questionNum = cpaQuestionData2.getQuestionNum();
                        if (TextUtils.isEmpty(str3)) {
                            list = formList;
                        } else {
                            i12++;
                            setChildProcessDesc(linearLayout, i12, "请提交 <font color=\"#ff0000\">" + str3 + "</font>", false);
                            list = formList;
                            LinearLayout linearLayout6 = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.moku_input_item, (ViewGroup) null);
                            linearLayout.addView(linearLayout6);
                            ScreenAdaptationUtils.setMarginTop(this.mContext, linearLayout6, 30);
                            ScreenAdaptationUtils.setHeight(this.mContext, linearLayout6, 130);
                            EditText editText2 = (EditText) linearLayout6.findViewById(R.id.et_input);
                            editText2.setHint(str3);
                            editText2.setTextSize(this.mPhoneScreenUtils.getNormalTextSize(this.mContext));
                            editText2.setEnabled(false);
                            this.etFormList.add(editText2);
                            ClientTaskDataSubmitFormModel clientTaskDataSubmitFormModel = new ClientTaskDataSubmitFormModel();
                            clientTaskDataSubmitFormModel.setKey(str3);
                            clientTaskDataSubmitFormModel.setQuestionNum(questionNum);
                            this.formDatas.add(clientTaskDataSubmitFormModel);
                        }
                        i11++;
                        formList = list;
                    }
                }
                int i13 = i2;
                if (i13 == size - 1 && this.mClientDetailTaskData.isTaskGroup()) {
                    setChildProcessDesc(linearLayout, i8, "获得奖励");
                    TextView textView5 = new TextView(this.mContext);
                    linearLayout.addView(textView5);
                    ScreenAdaptationUtils.setMarginTop(this.mContext, textView5, 20);
                    ScreenAdaptationUtils.setMarginLeftAndRight(this.mContext, textView5, 70);
                    textView5.setTextColor(this.mContext.getResources().getColor(R.color.moku_gray_deep));
                    String str4 = getTaskDataMoney() + this.mClientDetailTaskData.getCybermoneyName();
                    if (isLastDayTask()) {
                        textView5.setText("有志者事竟成！恭喜您，" + str4 + "即将到账");
                    } else {
                        textView5.setText("该任务奖励为" + str4 + "，明天还有奖励哦~不要卸载，明天见！");
                    }
                    textView5.setTextSize(this.mPhoneScreenUtils.getSmallTextSize(this.mContext));
                }
                i7 = i13 + 1;
                arrayList13 = arrayList7;
                i6 = 0;
                viewGroup = null;
            }
            arrayList5 = arrayList13;
            arrayList = arrayList9;
            arrayList2 = arrayList10;
            arrayList3 = arrayList11;
            arrayList4 = arrayList12;
            i = size;
        }
        Context context = this.mContext;
        if (context instanceof TaskDetailActivity) {
            ((TaskDetailActivity) context).initBTaskAnswerView(arrayList, arrayList2, arrayList3, arrayList4, arrayList5, i);
        } else if (context instanceof DianCpaDetailActivity) {
            ((DianCpaDetailActivity) context).initBTaskAnswerView(arrayList, arrayList2, arrayList3, arrayList4, arrayList5, i);
        }
    }

    private boolean isMiniProgrammer(int i, String str) {
        if (i == 0) {
            return true;
        }
        return str != null && str.contains("小程序");
    }

    private boolean isReward(Integer num) {
        Log.d(TAG, "taskDataStepConfigType==>" + num);
        if (num == null) {
            return false;
        }
        return num.intValue() == 0 || num.intValue() == 1 || num.intValue() == 2 || num.intValue() == 3;
    }

    private void initBasicInfoView() {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.moku_basic_infomation, (ViewGroup) null);
        this.mLlTaskContainer.addView(linearLayout);
        ScreenAdaptationUtils.setMarginBottom(this.mContext, linearLayout, 30);
        final ImageView imageView = (ImageView) linearLayout.findViewById(R.id.iv_icon);
        ScreenAdaptationUtils.setSize(this.mContext, imageView, 120, 120);
        ImageUtils.getInstance().setImageView(this.mContext, this.mClientDetailTaskData.getIcon(), new Consumer<Bitmap>() { // from class: com.fendasz.moku.planet.ui.view.TaskDetailView.9
            @Override // com.fendasz.moku.planet.interf.functions.Consumer
            public void accept(Bitmap bitmap) {
                imageView.setImageBitmap(bitmap);
            }
        }, Float.valueOf(this.mPhoneScreenUtils.getScale(this.mContext, 120.0f)), Float.valueOf(this.mPhoneScreenUtils.getScale(this.mContext, 120.0f)));
        TextView textView = (TextView) linearLayout.findViewById(R.id.tv_task_name);
        textView.setText(this.mClientDetailTaskData.getShowName());
        textView.setTextSize(this.mPhoneScreenUtils.getNormalTextSize(this.mContext));
        textView.setTextColor(this.mContext.getResources().getColor(R.color.moku_gray_very_deep));
        ((TextView) linearLayout.findViewById(R.id.tv_safe_certificate)).setTextSize(this.mPhoneScreenUtils.getTipsTextSize(this.mContext));
        ((TextView) linearLayout.findViewById(R.id.tv_official_certificate)).setTextSize(this.mPhoneScreenUtils.getTipsTextSize(this.mContext));
        TextView textView2 = (TextView) linearLayout.findViewById(R.id.tv_award);
        textView2.setText("+" + StringUtils.formatMoney(this.mClientDetailTaskData.getShowMoney().toPlainString()) + this.mClientDetailTaskData.getCybermoneyName());
        textView2.setTextSize(this.mPhoneScreenUtils.getNormalTextSize(this.mContext));
        TextView textView3 = (TextView) linearLayout.findViewById(R.id.tv_flow);
        if (this.mClientDetailTaskData.getClassify().equals("cpa") && !this.mClientDetailTaskData.getTaskData().getCpaType().equals(MokuConstants.CPA_TYPE_NORMAL)) {
            textView3.setText(this.mContext.getString(R.string.moku_cpa_answer_basic_info_tip));
        } else if (this.mClientDetailTaskData.getClassify().equals("cpa") && this.mClientDetailTaskData.getTaskData().getCpaType().equals(MokuConstants.CPA_TYPE_NORMAL)) {
            textView3.setText(this.mContext.getString(R.string.moku_cpa_normal_basic_info_tip));
        } else {
            textView3.setText(this.mContext.getString(R.string.moku_basic_info_tip));
        }
        textView3.setTextSize(this.mPhoneScreenUtils.getMiddleTextSize(this.mContext));
        Context context = this.mContext;
        if (context instanceof TaskDetailActivity) {
            ((TaskDetailActivity) context).initBasicInfoView(textView3);
        } else if (context instanceof DianCpaDetailActivity) {
            ((DianCpaDetailActivity) context).initBasicInfoView(textView3);
        }
    }

    public void initTaskDescView() {
        String keyPoint = this.mClientDetailTaskData.getKeyPoint();
        if (TextUtils.isEmpty(keyPoint)) {
            return;
        }
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.moku_task_desc_module, (ViewGroup) this.mLlTaskContainer, false);
        this.llTaskDescModule = linearLayout;
        this.mLlTaskContainer.addView(linearLayout);
        ScreenAdaptationUtils.setMarginBottom(this.mContext, this.llTaskDescModule, 30);
        TextView textView = (TextView) this.llTaskDescModule.findViewById(R.id.tv_task_desc_icon);
        ScreenAdaptationUtils.setSize(this.mContext, textView, 55, 55);
        textView.setTextSize(this.mPhoneScreenUtils.getSmallTextSize(this.mContext));
        TextView textView2 = (TextView) this.llTaskDescModule.findViewById(R.id.tv_task_desc);
        textView2.setText(keyPoint);
        textView2.setTextSize(this.mPhoneScreenUtils.getNormalTextSize(this.mContext));
        this.llTaskDescModule.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.fendasz.moku.planet.ui.view.TaskDetailView$$ExternalSyntheticLambda0
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                this.f$0.m443xfc410613();
            }
        });
    }

    /* renamed from: lambda$initTaskDescView$1$com-fendasz-moku-planet-ui-view-TaskDetailView, reason: not valid java name */
    /* synthetic */ void m443xfc410613() {
        float height = this.llTaskDescModule.getHeight() / 2;
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{height, height, height, height, height, height, height, height}, null, null));
        shapeDrawable.getPaint().setColor(this.mContext.getResources().getColor(R.color.moku_red_light));
        shapeDrawable.getPaint().setStyle(Paint.Style.FILL);
        this.llTaskDescModule.setBackground(shapeDrawable);
    }

    public void initTaskGroupEmptyView() {
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.mContext).inflate(R.layout.moku_process_module, (ViewGroup) this.mLlTaskContainer, false);
        this.mLlTaskContainer.addView(relativeLayout);
        ScreenAdaptationUtils.setMarginBottom(this.mContext, relativeLayout, 30);
        ((TextView) relativeLayout.findViewById(R.id.tv_process_label)).setText("任务步骤");
        LinearLayout linearLayout = (LinearLayout) relativeLayout.findViewById(R.id.ll_child_process);
        linearLayout.removeAllViews();
        TextView textView = new TextView(this.mContext);
        linearLayout.addView(textView);
        textView.setGravity(17);
        textView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        ScreenAdaptationUtils.setMarginTop(this.mContext, textView, 30);
        textView.setTextSize(this.mPhoneScreenUtils.getNormalTextSize(this.mContext));
        textView.setText("不要卸载\n后续还有很多任务待开启哦");
        textView.setTextColor(-7829368);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v1 */
    /* JADX WARN: Type inference failed for: r14v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r14v4 */
    /* JADX WARN: Type inference failed for: r14v5 */
    /* JADX WARN: Type inference failed for: r14v6 */
    /* JADX WARN: Type inference failed for: r14v7 */
    /* JADX WARN: Type inference failed for: r14v8 */
    /* JADX WARN: Type inference failed for: r14v9 */
    public void initTaskFlowView() {
        Integer num;
        String str;
        String str2;
        String str3;
        boolean z;
        Integer num2;
        int i;
        char c;
        ?? r14;
        int i2;
        List<String> formList;
        boolean z2;
        int i3;
        int i4;
        List<TaskDataStep> list;
        int i5;
        String str4;
        int i6;
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.mContext).inflate(R.layout.moku_process_module, (ViewGroup) null);
        this.mLlTaskContainer.addView(relativeLayout);
        ScreenAdaptationUtils.setMarginBottom(this.mContext, relativeLayout, 30);
        ((TextView) relativeLayout.findViewById(R.id.tv_process_label)).setText("任务步骤");
        if (this.mClientDetailTaskData.getClassify().equals("keyword")) {
            LinearLayout linearLayout = (LinearLayout) relativeLayout.findViewById(R.id.ll_child_process);
            linearLayout.removeAllViews();
            setChildProcessDesc(linearLayout, 1, "打开 <font color=\"#ff0000\">" + this.mClientDetailTaskData.getAppGalleryName() + "</font> 搜索 <font color=\"#ff0000\">" + this.mClientDetailTaskData.getKeyword() + "</font> 找到该图标软件");
            LinearLayout linearLayout2 = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.moku_child_process_content, (ViewGroup) null);
            linearLayout.addView(linearLayout2);
            ImageView imageView = new ImageView(this.mContext);
            linearLayout2.addView(imageView);
            ScreenAdaptationUtils.setMarginTop(this.mContext, imageView, 30);
            ScreenAdaptationUtils.setSize(this.mContext, imageView, 200, 200);
            num = 200;
            setImageView(this.mClientDetailTaskData.getIconUrl(), imageView, null, false, -1);
            TextView textView = new TextView(this.mContext);
            linearLayout2.addView(textView);
            textView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            ScreenAdaptationUtils.setMarginTop(this.mContext, textView, 30);
            textView.setTextSize(this.mPhoneScreenUtils.getNormalTextSize(this.mContext));
            textView.setText(Html.fromHtml("【软件排在第 <font color=\"#ff0000\">" + this.mClientDetailTaskData.getRank() + "</font> 位】"));
            i = -7829368;
            textView.setTextColor(-7829368);
            setChildProcessDesc(linearLayout, 2, "部分机型使用指定搜索词无法搜到对应软件，<font color=\"#ff0000\">请勿使用其他词搜索！</font>更换别的任务做哦！");
            LinearLayout linearLayout3 = new LinearLayout(this.mContext);
            this.mllSearchTerms = linearLayout3;
            linearLayout3.setOrientation(0);
            linearLayout.addView(this.mllSearchTerms);
            c = 0;
            str = "打开 <font color=\"#ff0000\">";
            str2 = "</font> 搜索 <font color=\"#ff0000\">";
            str3 = "</font> 找到该图标软件";
            z = true;
            num2 = 110;
            ScreenAdaptationUtils.setMargin(this.mContext, this.mllSearchTerms, 30, 30, null, 30);
            ScreenAdaptationUtils.setHeight(this.mContext, this.mllSearchTerms, 110);
            TextView textView2 = new TextView(this.mContext);
            this.mTvSearchTerms = textView2;
            this.mllSearchTerms.addView(textView2);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mTvSearchTerms.getLayoutParams();
            layoutParams.gravity = 17;
            layoutParams.weight = 6.0f;
            layoutParams.height = -1;
            this.mTvSearchTerms.setText(this.mClientDetailTaskData.getKeyword());
            this.mTvSearchTerms.setTextSize(this.mPhoneScreenUtils.getBigTextSize(this.mContext));
            this.mTvSearchTerms.setTextColor(SupportMenu.CATEGORY_MASK);
            this.mTvSearchTerms.setGravity(17);
            this.mTvSearchTerms.setBackgroundResource(R.drawable.moku_gray_dash_border_rectangle_shape);
            TextView textView3 = new TextView(this.mContext);
            this.mllSearchTerms.addView(textView3);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) textView3.getLayoutParams();
            layoutParams2.gravity = 17;
            layoutParams2.weight = 1.0f;
            layoutParams2.height = -1;
            textView3.setGravity(17);
            textView3.setText("点击复制");
            textView3.setTextColor(-1);
            textView3.setTextSize(this.mPhoneScreenUtils.getBigTextSize(this.mContext));
            textView3.setBackgroundResource(R.drawable.moku_gray_rectangle_shape);
        } else {
            num = 200;
            str = "打开 <font color=\"#ff0000\">";
            str2 = "</font> 搜索 <font color=\"#ff0000\">";
            str3 = "</font> 找到该图标软件";
            z = true;
            num2 = 110;
            i = -7829368;
            c = 0;
        }
        int i7 = 3;
        if (this.mClientDetailTaskData.getClassify().equals("comment")) {
            LinearLayout linearLayout4 = (LinearLayout) relativeLayout.findViewById(R.id.ll_child_process);
            setChildProcessDesc(linearLayout4, z ? 1 : 0, str + this.mClientDetailTaskData.getAppGalleryName() + str2 + this.mClientDetailTaskData.getKeyword() + str3);
            LinearLayout linearLayout5 = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.moku_child_process_content, (ViewGroup) null);
            linearLayout4.addView(linearLayout5);
            ImageView imageView2 = new ImageView(this.mContext);
            linearLayout5.addView(imageView2);
            ScreenAdaptationUtils.setMarginTop(this.mContext, imageView2, 30);
            Integer num3 = num;
            ScreenAdaptationUtils.setSize(this.mContext, imageView2, num3, num3);
            Integer num4 = num2;
            r14 = 0;
            r14 = 0;
            r14 = 0;
            r14 = 0;
            r14 = 0;
            r14 = 0;
            setImageView(this.mClientDetailTaskData.getIconUrl(), imageView2, null, false, -1);
            TextView textView4 = new TextView(this.mContext);
            linearLayout5.addView(textView4);
            textView4.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            ScreenAdaptationUtils.setMarginTop(this.mContext, textView4, 30);
            textView4.setTextSize(this.mPhoneScreenUtils.getNormalTextSize(this.mContext));
            textView4.setText("【请下载对应软件，否则无法提交】");
            textView4.setTextColor(i);
            if (this.mClientDetailTaskData.isRatingTemplate()) {
                setChildProcessDesc(linearLayout4, 2, "下载完成后， <font color=\"#ff0000\">" + this.mClientDetailTaskData.getCommentStar() + "星</font> 评分");
            } else {
                setChildProcessDesc(linearLayout4, 2, "下载完成后， <font color=\"#ff0000\">" + this.mClientDetailTaskData.getCommentStar() + "星</font> 评论");
            }
            Integer commentType = this.mClientDetailTaskData.getCommentType();
            if (commentType.equals(MokuConstants.COMMENTTYPE_SPECIFIED)) {
                setChildProcessDesc(linearLayout4, 3, "下载安装软件后，使用下方评论内容 评论");
                LinearLayout linearLayout6 = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.moku_comment_copy_item, (ViewGroup) null);
                linearLayout4.addView(linearLayout6);
                ScreenAdaptationUtils.setMarginTop(this.mContext, linearLayout6, 30);
                TextView textView5 = (TextView) linearLayout6.findViewById(R.id.tv_comment_content);
                this.mTvCommentContent = textView5;
                textView5.setMinHeight(this.mPhoneScreenUtils.getScale(this.mContext, 130.0f));
                TextView textView6 = (TextView) linearLayout6.findViewById(R.id.tv_comment_copy);
                this.mTvBtnCommentCopy = textView6;
                ScreenAdaptationUtils.setHeight(this.mContext, textView6, num4);
                ClientDetailTaskData clientDetailTaskData = this.mClientDetailTaskData;
                if (clientDetailTaskData != null && clientDetailTaskData.getTaskDataApplyRecord() != null && this.mClientDetailTaskData.getTaskDataApplyRecord().getStatus().equals(TaskDataApplyRecord.STATUS_OF_APPLYING)) {
                    this.mTvCommentContent.setEnabled(z);
                    this.mTvCommentContent.setText(!TextUtils.isEmpty(this.mClientDetailTaskData.getTaskDataApplyRecord().getTaskDataCommentData().getTaskDataCommentData()) ? this.mClientDetailTaskData.getTaskDataApplyRecord().getTaskDataCommentData().getTaskDataCommentData() : "");
                    this.mTvCommentContent.setTextSize(this.mPhoneScreenUtils.getNormalTextSize(this.mContext));
                    this.mTvBtnCommentCopy.setEnabled(z);
                    this.mTvBtnCommentCopy.setTextSize(this.mPhoneScreenUtils.getNormalTextSize(this.mContext));
                } else {
                    this.mTvCommentContent.setEnabled(false);
                    this.mTvCommentContent.setText("请先开始任务");
                    this.mTvCommentContent.setTextSize(this.mPhoneScreenUtils.getNormalTextSize(this.mContext));
                    this.mTvBtnCommentCopy.setEnabled(false);
                    this.mTvBtnCommentCopy.setTextSize(this.mPhoneScreenUtils.getNormalTextSize(this.mContext));
                }
            } else if (commentType.equals(MokuConstants.COMMENTTYPE_FREE)) {
                String thirdStep = this.mClientDetailTaskData.getTaskData().getTaskDataDetail().getThirdStep();
                if (TextUtils.isEmpty(thirdStep) && !this.mClientDetailTaskData.isRatingTemplate()) {
                    thirdStep = "评论内容自由发挥 （字数10-15字左右）";
                }
                if (!TextUtils.isEmpty(thirdStep)) {
                    setChildProcessDesc(linearLayout4, 3, thirdStep);
                }
            } else if (commentType.equals(MokuConstants.COMMENTTYPE_KEYWORD)) {
                String thirdStep2 = this.mClientDetailTaskData.getTaskData().getTaskDataDetail().getThirdStep();
                if (TextUtils.isEmpty(thirdStep2)) {
                    thirdStep2 = "评论内容必须包括 <font color=\"#ff0000\">" + this.mClientDetailTaskData.getCommentKeyword() + "</font> 这些关键字 （字数10-15字左右）";
                }
                setChildProcessDesc(linearLayout4, 3, thirdStep2);
            }
        } else {
            r14 = 0;
        }
        if (this.mClientDetailTaskData.getClassify().equals("hp") || this.mClientDetailTaskData.getClassify().equals("cpa")) {
            Map<Integer, List<TaskDataStep>> integerListMap = this.mClientDetailTaskData.getIntegerListMap();
            LinearLayout linearLayout7 = (LinearLayout) relativeLayout.findViewById(R.id.ll_child_process);
            if (integerListMap != null) {
                int i8 = r14;
                int i9 = i8;
                int i10 = i9;
                while (i10 < integerListMap.size()) {
                    int i11 = i10 + 1;
                    List<TaskDataStep> list2 = integerListMap.get(Integer.valueOf(i11));
                    if (list2 == null || list2.size() <= 0) {
                        z2 = z;
                    } else {
                        int i12 = i8 + 1;
                        String taskDataCustomDesc = list2.get(r14).getTaskDataCustomDesc();
                        int iIntValue = list2.get(r14).getTaskDataStepConfigType().intValue();
                        setChildProcessDesc(linearLayout7, i12, taskDataCustomDesc);
                        int i13 = i9;
                        int i14 = r14;
                        while (i14 < list2.size()) {
                            final TaskDataStep taskDataStep = list2.get(i14);
                            if (taskDataStep.isExamplePicStep()) {
                                if (TextUtils.isEmpty(taskDataStep.getTaskDataSampleScreenshotUrl())) {
                                    i3 = i14;
                                    i4 = i12;
                                    list = list2;
                                    i6 = iIntValue;
                                    str4 = taskDataCustomDesc;
                                    i5 = i10;
                                } else {
                                    i13++;
                                    int i15 = iIntValue;
                                    i3 = i14;
                                    i4 = i12;
                                    list = list2;
                                    setImageCommitView(linearLayout7, taskDataStep.getTaskDataSampleScreenshotUrl(), i13, isReward(Integer.valueOf(iIntValue)), i15);
                                    i5 = i10;
                                    str4 = taskDataCustomDesc;
                                    i6 = i15;
                                }
                            } else {
                                int i16 = iIntValue;
                                i3 = i14;
                                String str5 = taskDataCustomDesc;
                                i4 = i12;
                                list = list2;
                                int i17 = i10;
                                if (taskDataStep.getType().intValue() == 2) {
                                    if (taskDataStep.getTaskDataStepConfigType() != null && taskDataStep.getTaskDataStepConfigType().intValue() == i7 && i3 == 0) {
                                        Log.d(TAG, "the type is copy type");
                                        LinearLayout linearLayout8 = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.moku_child_process_content, (ViewGroup) null);
                                        linearLayout7.addView(linearLayout8);
                                        RelativeLayout relativeLayout2 = new RelativeLayout(this.mContext);
                                        int scale = PhoneScreenUtils.getInstance().getScale(this.mContext, 100.0f);
                                        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, scale);
                                        layoutParams3.setMargins(r14, PhoneScreenUtils.getInstance().getScale(this.mContext, 10.0f), r14, r14);
                                        relativeLayout2.setLayoutParams(layoutParams3);
                                        int scale2 = PhoneScreenUtils.getInstance().getScale(this.mContext, 100.0f);
                                        relativeLayout2.setPadding(scale2, r14, scale2, r14);
                                        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(PhoneScreenUtils.getInstance().getScale(this.mContext, 150.0f), scale);
                                        layoutParams4.addRule(11);
                                        TextView textView7 = new TextView(this.mContext);
                                        textView7.setGravity(17);
                                        textView7.setText("复制");
                                        textView7.setLayoutParams(layoutParams4);
                                        StyleUtils.setGradientDrawable(textView7, 20, this.mainThemeColor);
                                        relativeLayout2.addView(textView7);
                                        textView7.setOnClickListener(new View.OnClickListener() { // from class: com.fendasz.moku.planet.ui.view.TaskDetailView.10
                                            @Override // android.view.View.OnClickListener
                                            public void onClick(View view) {
                                                if (TaskDetailView.this.mClientDetailTaskData == null || TaskDetailView.this.mClientDetailTaskData.getTaskDataApplyRecord() == null || !TaskDetailView.this.mClientDetailTaskData.getTaskDataApplyRecord().getStatus().equals(TaskDataApplyRecord.STATUS_OF_APPLYING)) {
                                                    Toast.makeText(TaskDetailView.this.mContext, "请先【开始任务】", 0).show();
                                                } else if (StringUtils.isEmpty(taskDataStep.getAdditionalContent())) {
                                                    Toast.makeText(TaskDetailView.this.mContext, "复制失败", 0).show();
                                                } else {
                                                    SystemUtils.copyToClipboard(TaskDetailView.this.mContext, taskDataStep.getAdditionalContent(), taskDataStep.getAdditionalContent());
                                                    Toast.makeText(TaskDetailView.this.mContext, "复制成功", 0).show();
                                                }
                                            }
                                        });
                                        int scale3 = PhoneScreenUtils.getInstance().getScale(this.mContext, 200.0f);
                                        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, scale);
                                        layoutParams5.setMargins(r14, r14, scale3, r14);
                                        TextView textView8 = new TextView(this.mContext);
                                        textView8.setLayoutParams(layoutParams5);
                                        textView8.setText(taskDataStep.getAdditionalContent());
                                        textView8.setGravity(17);
                                        textView8.setBackgroundColor(this.mContext.getResources().getColor(R.color.moku_gray_dark));
                                        textView8.setTextColor(this.mContext.getResources().getColor(R.color.moku_gray_deep));
                                        layoutParams5.addRule(15);
                                        layoutParams5.addRule(9);
                                        relativeLayout2.addView(textView8);
                                        linearLayout8.addView(relativeLayout2);
                                        ImageView imageView3 = new ImageView(this.mContext);
                                        linearLayout8.addView(imageView3);
                                        ScreenAdaptationUtils.setMarginTop(this.mContext, imageView3, 30);
                                        ScreenAdaptationUtils.setSize(this.mContext, imageView3, 300, 300);
                                        imageView3.setBackgroundResource(R.color.moku_transparent);
                                        imageView3.setScaleType(ImageView.ScaleType.FIT_XY);
                                        i5 = i17;
                                        setImageView(taskDataStep.getTaskDataSampleScreenshotUrl(), imageView3, null, isMiniProgrammer(i16, str5), isReward(Integer.valueOf(i16)), i16);
                                        str4 = str5;
                                    } else {
                                        i5 = i17;
                                        if (taskDataStep.getTaskDataStepConfigType() != null && taskDataStep.getTaskDataStepConfigType().intValue() == 1 && taskDataStep.getTaskDataStepOpeningMode() != null && taskDataStep.getTaskDataStepOpeningMode().intValue() == 2) {
                                            LinearLayout linearLayout9 = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.moku_child_process_content, (ViewGroup) null);
                                            linearLayout7.addView(linearLayout9);
                                            LinearLayout linearLayout10 = new LinearLayout(this.mContext);
                                            linearLayout10.setOrientation(r14);
                                            linearLayout10.setLayoutParams(new LinearLayout.LayoutParams(-1, PhoneScreenUtils.getInstance().getScale(this.mContext, 100.0f)));
                                            int scale4 = PhoneScreenUtils.getInstance().getScale(this.mContext, 100.0f);
                                            linearLayout10.setPadding(scale4, r14, scale4, r14);
                                            ScreenAdaptationUtils.setMarginTop(this.mContext, linearLayout10, 50);
                                            LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams((int) r14, -1);
                                            layoutParams6.weight = 1.0f;
                                            layoutParams6.gravity = 16;
                                            TextView textView9 = new TextView(this.mContext);
                                            textView9.setText("打开链接");
                                            textView9.setLayoutParams(layoutParams6);
                                            textView9.setTextSize(this.mPhoneScreenUtils.getNormalTextSize(this.mContext));
                                            textView9.setGravity(17);
                                            ScreenAdaptationUtils.setMarginLeft(this.mContext, textView9, 20);
                                            StyleUtils.setGradientDrawable(textView9, 20, this.mainThemeColor);
                                            linearLayout10.addView(textView9);
                                            linearLayout9.addView(linearLayout10);
                                            textView9.setOnClickListener(new View.OnClickListener() { // from class: com.fendasz.moku.planet.ui.view.TaskDetailView.11
                                                @Override // android.view.View.OnClickListener
                                                public void onClick(View view) {
                                                    if (TaskDetailView.this.mClientDetailTaskData == null || TaskDetailView.this.mClientDetailTaskData.getTaskDataApplyRecord() == null || !TaskDetailView.this.mClientDetailTaskData.getTaskDataApplyRecord().getStatus().equals(TaskDataApplyRecord.STATUS_OF_APPLYING)) {
                                                        Toast.makeText(TaskDetailView.this.mContext, "请先【开始任务】", 0).show();
                                                    } else if (StringUtils.isEmpty(taskDataStep.getAdditionalContent())) {
                                                        Toast.makeText(TaskDetailView.this.mContext, "打开失败", 0).show();
                                                    } else {
                                                        TaskDetailView.this.mContext.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(taskDataStep.getAdditionalContent())));
                                                    }
                                                }
                                            });
                                            TextView textView10 = new TextView(this.mContext);
                                            textView10.setText("复制链接");
                                            textView10.setLayoutParams(layoutParams6);
                                            textView10.setTextSize(this.mPhoneScreenUtils.getNormalTextSize(this.mContext));
                                            textView10.setGravity(17);
                                            ScreenAdaptationUtils.setMarginRight(this.mContext, textView10, 20);
                                            StyleUtils.setGradientDrawable(textView10, 20, this.mainThemeColor);
                                            linearLayout10.addView(textView10);
                                            textView10.setOnClickListener(new View.OnClickListener() { // from class: com.fendasz.moku.planet.ui.view.TaskDetailView.12
                                                @Override // android.view.View.OnClickListener
                                                public void onClick(View view) {
                                                    if (TaskDetailView.this.mClientDetailTaskData == null || TaskDetailView.this.mClientDetailTaskData.getTaskDataApplyRecord() == null || !TaskDetailView.this.mClientDetailTaskData.getTaskDataApplyRecord().getStatus().equals(TaskDataApplyRecord.STATUS_OF_APPLYING)) {
                                                        Toast.makeText(TaskDetailView.this.mContext, "请先【开始任务】", 0).show();
                                                    } else {
                                                        SystemUtils.copyToClipboard(TaskDetailView.this.mContext, taskDataStep.getAdditionalContent(), taskDataStep.getAdditionalContent());
                                                        Toast.makeText(TaskDetailView.this.mContext, "复制成功", 0).show();
                                                    }
                                                }
                                            });
                                        } else {
                                            Log.d(TAG, "the type is not copy type");
                                            if (!TextUtils.isEmpty(taskDataStep.getTaskDataSampleScreenshotUrl())) {
                                                LinearLayout linearLayout11 = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.moku_child_process_content, (ViewGroup) null);
                                                linearLayout7.addView(linearLayout11);
                                                ImageView imageView4 = new ImageView(this.mContext);
                                                linearLayout11.addView(imageView4);
                                                ScreenAdaptationUtils.setMarginTop(this.mContext, imageView4, 30);
                                                ScreenAdaptationUtils.setSize(this.mContext, imageView4, 300, 300);
                                                imageView4.setBackgroundResource(R.color.moku_transparent);
                                                imageView4.setScaleType(ImageView.ScaleType.FIT_XY);
                                                str4 = str5;
                                                setImageView(taskDataStep.getTaskDataSampleScreenshotUrl(), imageView4, null, isMiniProgrammer(i16, str5), isReward(Integer.valueOf(i16)), i16);
                                                i6 = i16;
                                            }
                                        }
                                        str4 = str5;
                                    }
                                    i6 = i16;
                                } else {
                                    i5 = i17;
                                    str4 = str5;
                                    if (taskDataStep.getTaskDataStepConfigType() != null && taskDataStep.getTaskDataStepOpeningMode() != null && taskDataStep.getTaskDataStepConfigType().intValue() == 1 && taskDataStep.getTaskDataStepOpeningMode().intValue() == 2) {
                                        LinearLayout linearLayout12 = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.moku_child_process_content, (ViewGroup) null);
                                        linearLayout7.addView(linearLayout12);
                                        LinearLayout linearLayout13 = new LinearLayout(this.mContext);
                                        linearLayout13.setOrientation(r14);
                                        linearLayout13.setLayoutParams(new LinearLayout.LayoutParams(-1, PhoneScreenUtils.getInstance().getScale(this.mContext, 100.0f)));
                                        int scale5 = PhoneScreenUtils.getInstance().getScale(this.mContext, 100.0f);
                                        linearLayout13.setPadding(scale5, r14, scale5, r14);
                                        ScreenAdaptationUtils.setMarginTop(this.mContext, linearLayout13, 50);
                                        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams((int) r14, -1);
                                        layoutParams7.weight = 1.0f;
                                        layoutParams7.gravity = 16;
                                        TextView textView11 = new TextView(this.mContext);
                                        textView11.setText("打开链接");
                                        textView11.setLayoutParams(layoutParams7);
                                        textView11.setTextSize(this.mPhoneScreenUtils.getNormalTextSize(this.mContext));
                                        textView11.setGravity(17);
                                        ScreenAdaptationUtils.setMarginLeft(this.mContext, textView11, 20);
                                        StyleUtils.setGradientDrawable(textView11, 20, this.mainThemeColor);
                                        linearLayout13.addView(textView11);
                                        linearLayout12.addView(linearLayout13);
                                        textView11.setOnClickListener(new View.OnClickListener() { // from class: com.fendasz.moku.planet.ui.view.TaskDetailView.13
                                            @Override // android.view.View.OnClickListener
                                            public void onClick(View view) {
                                                if (TaskDetailView.this.mClientDetailTaskData == null || TaskDetailView.this.mClientDetailTaskData.getTaskDataApplyRecord() == null || !TaskDetailView.this.mClientDetailTaskData.getTaskDataApplyRecord().getStatus().equals(TaskDataApplyRecord.STATUS_OF_APPLYING)) {
                                                    Toast.makeText(TaskDetailView.this.mContext, "请先【开始任务】", 0).show();
                                                } else if (StringUtils.isEmpty(taskDataStep.getAdditionalContent())) {
                                                    Toast.makeText(TaskDetailView.this.mContext, "打开失败", 0).show();
                                                } else {
                                                    TaskDetailView.this.mContext.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(taskDataStep.getAdditionalContent())));
                                                }
                                            }
                                        });
                                        TextView textView12 = new TextView(this.mContext);
                                        textView12.setText("复制链接");
                                        textView12.setLayoutParams(layoutParams7);
                                        textView12.setTextSize(this.mPhoneScreenUtils.getNormalTextSize(this.mContext));
                                        textView12.setGravity(17);
                                        ScreenAdaptationUtils.setMarginRight(this.mContext, textView12, 20);
                                        StyleUtils.setGradientDrawable(textView12, 20, this.mainThemeColor);
                                        linearLayout13.addView(textView12);
                                        textView12.setOnClickListener(new View.OnClickListener() { // from class: com.fendasz.moku.planet.ui.view.TaskDetailView.14
                                            @Override // android.view.View.OnClickListener
                                            public void onClick(View view) {
                                                if (TaskDetailView.this.mClientDetailTaskData == null || TaskDetailView.this.mClientDetailTaskData.getTaskDataApplyRecord() == null || !TaskDetailView.this.mClientDetailTaskData.getTaskDataApplyRecord().getStatus().equals(TaskDataApplyRecord.STATUS_OF_APPLYING)) {
                                                    Toast.makeText(TaskDetailView.this.mContext, "请先【开始任务】", 0).show();
                                                } else {
                                                    SystemUtils.copyToClipboard(TaskDetailView.this.mContext, taskDataStep.getAdditionalContent(), taskDataStep.getAdditionalContent());
                                                    Toast.makeText(TaskDetailView.this.mContext, "复制成功", 0).show();
                                                }
                                            }
                                        });
                                    } else if (taskDataStep.getTaskDataStepConfigType() != null && taskDataStep.getTaskDataStepOpeningMode() != null && taskDataStep.getTaskDataStepConfigType().intValue() == 3 && i3 == 0) {
                                        LinearLayout linearLayout14 = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.moku_child_process_content, (ViewGroup) null);
                                        linearLayout7.addView(linearLayout14);
                                        RelativeLayout relativeLayout3 = new RelativeLayout(this.mContext);
                                        int scale6 = PhoneScreenUtils.getInstance().getScale(this.mContext, 100.0f);
                                        LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(-1, scale6);
                                        i6 = i16;
                                        layoutParams8.setMargins(r14, PhoneScreenUtils.getInstance().getScale(this.mContext, 10.0f), r14, r14);
                                        relativeLayout3.setLayoutParams(layoutParams8);
                                        int scale7 = PhoneScreenUtils.getInstance().getScale(this.mContext, 100.0f);
                                        relativeLayout3.setPadding(scale7, r14, scale7, r14);
                                        RelativeLayout.LayoutParams layoutParams9 = new RelativeLayout.LayoutParams(PhoneScreenUtils.getInstance().getScale(this.mContext, 150.0f), scale6);
                                        layoutParams9.addRule(11);
                                        TextView textView13 = new TextView(this.mContext);
                                        textView13.setGravity(17);
                                        textView13.setText("复制");
                                        textView13.setLayoutParams(layoutParams9);
                                        StyleUtils.setGradientDrawable(textView13, 20, this.mainThemeColor);
                                        relativeLayout3.addView(textView13);
                                        textView13.setOnClickListener(new View.OnClickListener() { // from class: com.fendasz.moku.planet.ui.view.TaskDetailView.15
                                            @Override // android.view.View.OnClickListener
                                            public void onClick(View view) {
                                                if (TaskDetailView.this.mClientDetailTaskData == null || TaskDetailView.this.mClientDetailTaskData.getTaskDataApplyRecord() == null || !TaskDetailView.this.mClientDetailTaskData.getTaskDataApplyRecord().getStatus().equals(TaskDataApplyRecord.STATUS_OF_APPLYING)) {
                                                    Toast.makeText(TaskDetailView.this.mContext, "请先【开始任务】", 0).show();
                                                } else if (StringUtils.isEmpty(taskDataStep.getAdditionalContent())) {
                                                    Toast.makeText(TaskDetailView.this.mContext, "复制失败", 0).show();
                                                } else {
                                                    SystemUtils.copyToClipboard(TaskDetailView.this.mContext, taskDataStep.getAdditionalContent(), taskDataStep.getAdditionalContent());
                                                    Toast.makeText(TaskDetailView.this.mContext, "复制成功", 0).show();
                                                }
                                            }
                                        });
                                        int scale8 = PhoneScreenUtils.getInstance().getScale(this.mContext, 200.0f);
                                        RelativeLayout.LayoutParams layoutParams10 = new RelativeLayout.LayoutParams(-1, scale6);
                                        layoutParams10.setMargins(r14, r14, scale8, r14);
                                        TextView textView14 = new TextView(this.mContext);
                                        textView14.setLayoutParams(layoutParams10);
                                        textView14.setText(taskDataStep.getAdditionalContent());
                                        textView14.setGravity(17);
                                        textView14.setBackgroundColor(this.mContext.getResources().getColor(R.color.moku_gray_dark));
                                        textView14.setTextColor(this.mContext.getResources().getColor(R.color.moku_gray_deep));
                                        layoutParams10.addRule(15);
                                        layoutParams10.addRule(9);
                                        relativeLayout3.addView(textView14);
                                        linearLayout14.addView(relativeLayout3);
                                    }
                                    i6 = i16;
                                }
                            }
                            i14 = i3 + 1;
                            i10 = i5;
                            taskDataCustomDesc = str4;
                            i12 = i4;
                            list2 = list;
                            iIntValue = i6;
                            i7 = 3;
                        }
                        int i18 = i12;
                        int i19 = i10;
                        if (this.mClientDetailTaskData.getClassify().equals("cpa")) {
                            z2 = true;
                            if (i19 == integerListMap.size() - 1) {
                                LinearLayout linearLayout15 = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.moku_child_process_content, (ViewGroup) null);
                                linearLayout7.addView(linearLayout15);
                                ImageView imageView5 = new ImageView(this.mContext);
                                linearLayout15.addView(imageView5);
                                ScreenAdaptationUtils.setMarginTop(this.mContext, imageView5, 30);
                                final Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(this.mContext.getResources(), R.drawable.gallery_tip);
                                if (bitmapDecodeResource != null) {
                                    ScreenAdaptationUtils.setSize(this.mContext, imageView5, Integer.valueOf((int) 600.0f), Integer.valueOf((int) ((bitmapDecodeResource.getHeight() * 600.0f) / bitmapDecodeResource.getWidth())));
                                    imageView5.setBackgroundResource(R.color.moku_transparent);
                                    imageView5.setScaleType(ImageView.ScaleType.FIT_XY);
                                    imageView5.setImageBitmap(bitmapDecodeResource);
                                    imageView5.setOnClickListener(new View.OnClickListener() { // from class: com.fendasz.moku.planet.ui.view.TaskDetailView.16
                                        @Override // android.view.View.OnClickListener
                                        public void onClick(View view) {
                                            new ViewImageDialog.Builder(TaskDetailView.this.mContext).setBitmap(bitmapDecodeResource).create().show();
                                        }
                                    });
                                }
                            }
                        } else {
                            z2 = true;
                        }
                        i9 = i13;
                        i8 = i18;
                    }
                    z = z2;
                    i10 = i11;
                    i7 = 3;
                }
                i2 = i8;
            } else {
                i2 = r14;
            }
            if (this.mClientDetailTaskData.getClassify().equals("cpa") && this.mClientDetailTaskData.isTaskGroup()) {
                i2++;
                setChildProcessDesc(linearLayout7, i2, "获得奖励");
                TextView textView15 = new TextView(this.mContext);
                linearLayout7.addView(textView15);
                ScreenAdaptationUtils.setMarginTop(this.mContext, textView15, 20);
                ScreenAdaptationUtils.setMarginLeftAndRight(this.mContext, textView15, 70);
                textView15.setTextColor(this.mContext.getResources().getColor(R.color.moku_gray_deep));
                String str6 = getTaskDataMoney() + this.mClientDetailTaskData.getCybermoneyName();
                if (isLastDayTask()) {
                    textView15.setText("有志者事竟成！恭喜您，" + str6 + "即将到账");
                } else {
                    textView15.setText("该任务奖励为" + str6 + "，明天还有奖励哦~不要卸载，明天见！");
                }
                textView15.setTextSize(this.mPhoneScreenUtils.getSmallTextSize(this.mContext));
            }
            Integer cpaType = this.mClientDetailTaskData.getTaskData().getCpaType();
            if (("hp".equals(this.mClientDetailTaskData.getClassify()) || MokuConstants.CPA_TYPE_NORMAL_FORM.equals(cpaType)) && (formList = this.mClientDetailTaskData.getFormList()) != null) {
                int i20 = i2;
                for (int i21 = r14; i21 < formList.size(); i21++) {
                    String str7 = formList.get(i21);
                    if (!TextUtils.isEmpty(str7)) {
                        i20++;
                        setChildProcessDesc(linearLayout7, i20, "请提交 <font color=\"#ff0000\">" + str7 + "</font>");
                        LinearLayout linearLayout16 = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.moku_input_item, (ViewGroup) null);
                        linearLayout7.addView(linearLayout16);
                        ScreenAdaptationUtils.setMarginTop(this.mContext, linearLayout16, 30);
                        ScreenAdaptationUtils.setHeight(this.mContext, linearLayout16, 130);
                        EditText editText = (EditText) linearLayout16.findViewById(R.id.et_input);
                        editText.setHint(str7);
                        editText.setTextSize(this.mPhoneScreenUtils.getNormalTextSize(this.mContext));
                        editText.setEnabled(r14);
                        this.etFormList.add(editText);
                        ClientTaskDataSubmitFormModel clientTaskDataSubmitFormModel = new ClientTaskDataSubmitFormModel();
                        clientTaskDataSubmitFormModel.setKey(str7);
                        this.formDatas.add(clientTaskDataSubmitFormModel);
                    }
                }
            }
        }
        Context context = this.mContext;
        if (context instanceof TaskDetailActivity) {
            ((TaskDetailActivity) context).initTaskFlowView(this.mTvCommentContent, this.mTvBtnCommentCopy, this.mllSearchTerms, this.mTvSearchTerms);
        } else if (context instanceof DianCpaDetailActivity) {
            ((DianCpaDetailActivity) context).initTaskFlowView(this.mTvCommentContent, this.mTvBtnCommentCopy, this.mllSearchTerms, this.mTvSearchTerms);
        }
    }

    private boolean isLastDayTask() {
        List<ClientGroupTaskData> list = this.followUpOpenGroupTaskDataList;
        return list == null || list.size() <= 0;
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
        return this.mClientDetailTaskData.getShowMoney().toPlainString();
    }

    private void initTaskSubmitView() {
        int i;
        int i2;
        int i3;
        String str;
        int i4;
        int i5;
        if (this.mClientDetailTaskData.getClassify().equals("hp") || this.mClientDetailTaskData.getClassify().equals("cpa")) {
            return;
        }
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.mContext).inflate(R.layout.moku_process_module, (ViewGroup) null);
        this.mLlTaskContainer.addView(relativeLayout);
        ScreenAdaptationUtils.setMarginBottom(this.mContext, relativeLayout, 30);
        ((TextView) relativeLayout.findViewById(R.id.tv_process_label)).setText("任务提交");
        if (this.mClientDetailTaskData.getClassify().equals("keyword") || this.mClientDetailTaskData.getClassify().equals("comment")) {
            Map<Integer, List<TaskDataStep>> integerListMap = this.mClientDetailTaskData.getIntegerListMap();
            LinearLayout linearLayout = (LinearLayout) relativeLayout.findViewById(R.id.ll_child_process);
            linearLayout.removeAllViews();
            int i6 = 0;
            if (integerListMap == null) {
                i = 0;
            } else if (this.mClientDetailTaskData.getIsCustomDesc().equals(MokuConstants.CUSTOM_DESC)) {
                int i7 = 0;
                i = 0;
                int i8 = 0;
                while (i7 < integerListMap.size()) {
                    int i9 = i7 + 1;
                    List<TaskDataStep> list = integerListMap.get(Integer.valueOf(i9));
                    if (list != null && list.size() > 0) {
                        int i10 = i + 1;
                        String taskDataCustomDesc = list.get(i6).getTaskDataCustomDesc();
                        int iIntValue = list.get(i6).getTaskDataStepConfigType().intValue();
                        setChildProcessDesc(linearLayout, i10, taskDataCustomDesc);
                        int i11 = i8;
                        int i12 = i6;
                        while (i12 < list.size()) {
                            TaskDataStep taskDataStep = list.get(i12);
                            if (taskDataStep.isExamplePicStep()) {
                                if (TextUtils.isEmpty(taskDataStep.getTaskDataSampleScreenshotUrl())) {
                                    i2 = i12;
                                    str = taskDataCustomDesc;
                                    i4 = iIntValue;
                                    i5 = i10;
                                    i12 = i2 + 1;
                                    taskDataCustomDesc = str;
                                    i10 = i5;
                                    iIntValue = i4;
                                } else {
                                    i11++;
                                    i2 = i12;
                                    i3 = iIntValue;
                                    str = taskDataCustomDesc;
                                    setImageCommitView(linearLayout, taskDataStep.getTaskDataSampleScreenshotUrl(), i11, isReward(Integer.valueOf(iIntValue)), i3);
                                }
                            } else {
                                i2 = i12;
                                i3 = iIntValue;
                                str = taskDataCustomDesc;
                                if (taskDataStep.getType().intValue() == 2 && !TextUtils.isEmpty(taskDataStep.getTaskDataSampleScreenshotUrl())) {
                                    LinearLayout linearLayout2 = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.moku_child_process_content, (ViewGroup) null);
                                    linearLayout.addView(linearLayout2);
                                    ImageView imageView = new ImageView(this.mContext);
                                    linearLayout2.addView(imageView);
                                    ScreenAdaptationUtils.setMarginTop(this.mContext, imageView, 30);
                                    ScreenAdaptationUtils.setSize(this.mContext, imageView, 300, 300);
                                    imageView.setBackgroundResource(R.color.moku_transparent);
                                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                                    String taskDataSampleScreenshotUrl = taskDataStep.getTaskDataSampleScreenshotUrl();
                                    boolean zIsMiniProgrammer = isMiniProgrammer(i3, str);
                                    boolean zIsReward = isReward(Integer.valueOf(i3));
                                    i4 = i3;
                                    i5 = i10;
                                    setImageView(taskDataSampleScreenshotUrl, imageView, null, zIsMiniProgrammer, zIsReward, i4);
                                    i12 = i2 + 1;
                                    taskDataCustomDesc = str;
                                    i10 = i5;
                                    iIntValue = i4;
                                }
                            }
                            i4 = i3;
                            i5 = i10;
                            i12 = i2 + 1;
                            taskDataCustomDesc = str;
                            i10 = i5;
                            iIntValue = i4;
                        }
                        i8 = i11;
                        i = i10;
                    }
                    i7 = i9;
                    i6 = 0;
                }
            } else {
                int i13 = 0;
                i = 0;
                int i14 = 0;
                while (i13 < integerListMap.size()) {
                    int i15 = i13 + 1;
                    List<TaskDataStep> list2 = integerListMap.get(Integer.valueOf(i15));
                    if (list2 != null && list2.size() > 0) {
                        TaskDataStep taskDataStep2 = list2.get(0);
                        int i16 = i + 1;
                        if (i16 == 1) {
                            setChildProcessDesc(linearLayout, i16, "使用指定搜索词搜索并下载软件，截取 <font color=\"#ff0000\">下载中</font> 截图（软件状态必须正在下载或已下完）");
                        }
                        if (this.mClientDetailTaskData.getClassify().equals("keyword") && i16 == 2) {
                            setChildProcessDesc(linearLayout, i16, "打开软件 <font color=\"#ff0000\">试玩" + this.mClientDetailTaskData.getListenerTime() + "秒</font> 以上，试玩过程中截图");
                        }
                        if (this.mClientDetailTaskData.getClassify().equals("comment")) {
                            if (i16 == 2) {
                                setChildProcessDesc(linearLayout, i16, "评论编辑截图");
                            }
                            if (i16 == 3) {
                                setChildProcessDesc(linearLayout, i16, "评论成功截图");
                            }
                            if (i16 == 4) {
                                setChildProcessDesc(linearLayout, i16, "打开软件 <font color=\"#ff0000\">试玩" + (this.mClientDetailTaskData.getListenerTime() != null ? this.mClientDetailTaskData.getListenerTime().intValue() : 20) + "秒</font> 以上，试玩过程中截图");
                            }
                        }
                        if (!taskDataStep2.isExamplePicStep() || TextUtils.isEmpty(taskDataStep2.getTaskDataSampleScreenshotUrl())) {
                            i = i16;
                        } else {
                            int i17 = i14 + 1;
                            setImageCommitView(linearLayout, taskDataStep2.getTaskDataSampleScreenshotUrl(), i17, false, -1);
                            i = i16;
                            i14 = i17;
                        }
                    }
                    i13 = i15;
                }
            }
            List<String> formList = this.mClientDetailTaskData.getFormList();
            if (formList != null) {
                for (int i18 = 0; i18 < formList.size(); i18++) {
                    String str2 = formList.get(i18);
                    if (!TextUtils.isEmpty(str2)) {
                        i++;
                        setChildProcessDesc(linearLayout, i, "请提交 <font color=\"#ff0000\">" + str2 + "</font>");
                        LinearLayout linearLayout3 = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.moku_input_item, (ViewGroup) null);
                        linearLayout.addView(linearLayout3);
                        ScreenAdaptationUtils.setMarginTop(this.mContext, linearLayout3, 30);
                        ScreenAdaptationUtils.setHeight(this.mContext, linearLayout3, 130);
                        EditText editText = (EditText) linearLayout3.findViewById(R.id.et_input);
                        editText.setHint(str2);
                        editText.setTextSize(this.mPhoneScreenUtils.getNormalTextSize(this.mContext));
                        editText.setEnabled(false);
                        this.etFormList.add(editText);
                        ClientTaskDataSubmitFormModel clientTaskDataSubmitFormModel = new ClientTaskDataSubmitFormModel();
                        clientTaskDataSubmitFormModel.setKey(str2);
                        this.formDatas.add(clientTaskDataSubmitFormModel);
                    }
                }
            }
        }
    }

    private void setChildProcessDesc(LinearLayout linearLayout, int i, String str) {
        setChildProcessDesc(linearLayout, i, str, true);
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
        textView2.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.fendasz.moku.planet.ui.view.TaskDetailView.17
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                textView2.setSelected(true);
                try {
                    SystemUtils.copyToClipboard(TaskDetailView.this.mContext, textView2.getText().toString(), textView2.getText().toString());
                    Toast.makeText(TaskDetailView.this.mContext, "内容复制到剪贴板", 0).show();
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
        spannableStringBuilder.setSpan(new ClickableSpan() { // from class: com.fendasz.moku.planet.ui.view.TaskDetailView.18
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                LogUtils.log(TaskDetailView.TAG, "截取到超链接点击事件");
                ((TaskDetailActivity) TaskDetailView.this.mContext).showGalleryTipDialog(new Finish() { // from class: com.fendasz.moku.planet.ui.view.TaskDetailView.18.1
                    @Override // com.fendasz.moku.planet.interf.Finish
                    public void finish() {
                        SystemUtils.openBrowser(TaskDetailView.this.mContext, url);
                    }
                });
            }
        }, spanStart, spanEnd, spanFlags);
        spannableStringBuilder.removeSpan(uRLSpan);
    }

    private void setAnswerView(LinearLayout linearLayout, int i, String str, Integer num) {
        String[] strArr = {ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C", "D", ExifInterface.LONGITUDE_EAST, "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", ExifInterface.LATITUDE_SOUTH, ExifInterface.GPS_DIRECTION_TRUE, "U", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ExifInterface.LONGITUDE_WEST, "X", "Y", "Z"};
        LinearLayout linearLayout2 = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.moku_answer_item, (ViewGroup) linearLayout, false);
        ScreenAdaptationUtils.setMarginLeftAndRight(this.mContext, linearLayout2, 20);
        linearLayout.addView(linearLayout2);
        TextView textView = (TextView) linearLayout2.findViewById(R.id.tv_answer_index);
        if (i == 0) {
            ScreenAdaptationUtils.setMarginTop(this.mContext, linearLayout2, 50);
        } else {
            ScreenAdaptationUtils.setMarginTop(this.mContext, linearLayout2, 30);
        }
        textView.setText(strArr[i]);
        ScreenAdaptationUtils.setSize(this.mContext, textView, 55, 55);
        textView.setTextSize(this.mPhoneScreenUtils.getSmallTextSize(this.mContext));
        TextView textView2 = (TextView) linearLayout2.findViewById(R.id.tv_answer);
        if (Build.VERSION.SDK_INT >= 24) {
            textView2.setText(Html.fromHtml(str, 63));
        } else {
            textView2.setText(Html.fromHtml(str));
        }
        textView2.setTextSize(this.mPhoneScreenUtils.getMiddleTextSize(this.mContext));
        TextView textView3 = (TextView) linearLayout2.findViewById(R.id.tv_answer_error);
        textView3.setTextSize(this.mPhoneScreenUtils.getSmallTextSize(this.mContext));
        ScreenAdaptationUtils.setSize(this.mContext, textView3, 55, 55);
        linearLayout2.setTag(num);
        this.llAnswerList.add(linearLayout2);
    }

    private void setImageCommitView(LinearLayout linearLayout, String str, int i, boolean z, int i2) {
        LinearLayout linearLayout2 = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.moku_screenshot_submit, (ViewGroup) null);
        linearLayout.addView(linearLayout2);
        ScreenAdaptationUtils.setMarginTop(this.mContext, linearLayout2, 30);
        ((TextView) linearLayout2.findViewById(R.id.tv_screenshot_label)).setText("截图" + i);
        if (!TextUtils.isEmpty(str)) {
            setImageView(str, (ImageView) linearLayout2.findViewById(R.id.iv_sample), null, z, i2);
        }
        this.ivUploadImageList.add((ImageView) linearLayout2.findViewById(R.id.iv_upload_image));
        this.fileUploadImageList.add(null);
    }

    private void setImageView(String str, ImageView imageView, Integer num, boolean z, int i) {
        setImageView(str, imageView, num, false, z, i);
    }

    /* renamed from: com.fendasz.moku.planet.ui.view.TaskDetailView$19, reason: invalid class name */
    class AnonymousClass19 implements Consumer<Bitmap> {
        final /* synthetic */ ImageView val$imageView;
        final /* synthetic */ boolean val$isMiniProgrammer;
        final /* synthetic */ boolean val$isReward;
        final /* synthetic */ int val$taskDataStepConfigType;
        final /* synthetic */ Integer val$width;

        AnonymousClass19(Integer num, ImageView imageView, boolean z, boolean z2, int i) {
            this.val$width = num;
            this.val$imageView = imageView;
            this.val$isMiniProgrammer = z;
            this.val$isReward = z2;
            this.val$taskDataStepConfigType = i;
        }

        @Override // com.fendasz.moku.planet.interf.functions.Consumer
        public void accept(final Bitmap bitmap) {
            if (this.val$width != null) {
                ScreenAdaptationUtils.setSize(TaskDetailView.this.mContext, this.val$imageView, this.val$width, Integer.valueOf(TaskDetailView.this.getScaleHeightByWidth(r0.intValue(), bitmap)));
            }
            this.val$imageView.setImageBitmap(bitmap);
            this.val$imageView.setOnClickListener(new View.OnClickListener() { // from class: com.fendasz.moku.planet.ui.view.TaskDetailView.19.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    new ViewImageDialog.Builder(TaskDetailView.this.mContext).setBitmap(bitmap).setIsMiniProgrammer(AnonymousClass19.this.val$isMiniProgrammer).create().show();
                }
            });
            this.val$imageView.setOnLongClickListener(new AnonymousClass2(bitmap));
        }

        /* renamed from: com.fendasz.moku.planet.ui.view.TaskDetailView$19$2, reason: invalid class name */
        class AnonymousClass2 implements View.OnLongClickListener {
            final /* synthetic */ Bitmap val$bitmap;

            AnonymousClass2(Bitmap bitmap) {
                this.val$bitmap = bitmap;
            }

            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                TaskDetailView.this.mRlOptionsContainer.setVisibility(0);
                TaskDetailView.this.mLlWeChat.setVisibility(4);
                TaskDetailView.this.mLlBrowser.setVisibility(4);
                TaskDetailView.this.currentBitmap = this.val$bitmap;
                if (AnonymousClass19.this.val$isMiniProgrammer) {
                    LogUtils.log(TaskDetailView.TAG, "is mini programmer");
                    TaskDetailView.this.mLlWeChat.setVisibility(0);
                    TaskDetailView.this.mLlBrowser.setVisibility(0);
                }
                new Thread(new Runnable() { // from class: com.fendasz.moku.planet.ui.view.TaskDetailView.19.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        TaskDetailView.this.currentUrl = QrCodeUtils.parseQrCode(AnonymousClass2.this.val$bitmap);
                        ((Activity) TaskDetailView.this.mContext).runOnUiThread(new Runnable() { // from class: com.fendasz.moku.planet.ui.view.TaskDetailView.19.2.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (AnonymousClass19.this.val$isReward) {
                                    int i = AnonymousClass19.this.val$taskDataStepConfigType;
                                    if (i == 0 || i == 1) {
                                        TaskDetailView.this.mLlWeChat.setVisibility(0);
                                        TaskDetailView.this.mLlBrowser.setVisibility(0);
                                        return;
                                    }
                                    if (i != 2) {
                                        if (i != 3) {
                                            return;
                                        }
                                        TaskDetailView.this.mLlWeChat.setVisibility(4);
                                        TaskDetailView.this.mLlBrowser.setVisibility(4);
                                        return;
                                    }
                                    if (TextUtils.isEmpty(TaskDetailView.this.currentUrl)) {
                                        LogUtils.log(TaskDetailView.TAG, "is not qr code");
                                        TaskDetailView.this.mLlWeChat.setVisibility(4);
                                        TaskDetailView.this.mLlBrowser.setVisibility(4);
                                        return;
                                    } else {
                                        LogUtils.log(TaskDetailView.TAG, "is qr code");
                                        TaskDetailView.this.mLlWeChat.setVisibility(0);
                                        TaskDetailView.this.mLlBrowser.setVisibility(0);
                                        return;
                                    }
                                }
                                if (AnonymousClass19.this.val$isMiniProgrammer) {
                                    TaskDetailView.this.mLlWeChat.setVisibility(0);
                                    TaskDetailView.this.mLlBrowser.setVisibility(0);
                                } else if (TextUtils.isEmpty(TaskDetailView.this.currentUrl)) {
                                    LogUtils.log(TaskDetailView.TAG, "is not qr code");
                                    TaskDetailView.this.mLlWeChat.setVisibility(4);
                                    TaskDetailView.this.mLlBrowser.setVisibility(4);
                                } else {
                                    LogUtils.log(TaskDetailView.TAG, "is qr code");
                                    TaskDetailView.this.mLlWeChat.setVisibility(0);
                                    TaskDetailView.this.mLlBrowser.setVisibility(0);
                                }
                            }
                        });
                    }
                }).start();
                return true;
            }
        }
    }

    private void setImageView(String str, ImageView imageView, Integer num, boolean z, boolean z2, int i) {
        ImageUtils.getInstance().setImageView(this.mContext, str, new AnonymousClass19(num, imageView, z, z2, i), null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getScaleHeightByWidth(double d, Bitmap bitmap) {
        return (int) ((d / bitmap.getWidth()) * bitmap.getHeight());
    }
}
