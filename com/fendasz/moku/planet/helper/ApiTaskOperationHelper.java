package com.fendasz.moku.planet.helper;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import com.fendasz.moku.planet.constants.MokuConstants;
import com.fendasz.moku.planet.entity.ApiDataCallBack;
import com.fendasz.moku.planet.entity.ApiOperationCallBack;
import com.fendasz.moku.planet.entity.OperationEnum;
import com.fendasz.moku.planet.exception.MokuException;
import com.fendasz.moku.planet.source.bean.ClientDetailTaskData;
import com.fendasz.moku.planet.ui.activity.UsageTipsActivity;
import com.fendasz.moku.planet.utils.AppUsageStatsManager;
import com.fendasz.moku.planet.utils.LogUtils;
import com.fendasz.moku.planet.utils.PermissionUtils;
import com.fendasz.moku.planet.utils.StringUtils;
import com.fendasz.moku.planet.utils.system.utils.SystemUtils;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class ApiTaskOperationHelper implements ApiOperationCallBack {
    private static final String TAG = "ApiTaskOperationHelper";
    private static ApiTaskOperationHelper sApiTaskOperationHelper;
    private int cpaSubmitTips = 0;
    private boolean isDian = false;
    private ApiOperationCallBack mApiOperationCallBack;
    private ApiOperationModel mApiOperationModel;
    private ClientDetailTaskData mClientDetailTaskData;
    private OperationEnum mOperationEnum;

    ApiOperationCallBack getCallBack() {
        return this;
    }

    public static class HelperBuilder {
        private ApiOperationCallBack callBack;
        private ClientDetailTaskData taskData;

        public HelperBuilder(ClientDetailTaskData clientDetailTaskData) {
            if (clientDetailTaskData.getTaskDataId() != null) {
                LogUtils.log(ApiTaskOperationHelper.TAG, "get taskData from activity : taskDataId >> " + clientDetailTaskData.getTaskDataId().toString());
            } else {
                LogUtils.log(ApiTaskOperationHelper.TAG, "get taskData from activity : taskDataId >> is null");
            }
            this.taskData = clientDetailTaskData;
        }

        public HelperBuilder setCallBack(ApiOperationCallBack apiOperationCallBack) {
            this.callBack = apiOperationCallBack;
            return this;
        }

        public ApiTaskOperationHelper create() {
            return ApiTaskOperationHelper.getInstance(this.taskData, this.callBack);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ApiTaskOperationHelper getInstance(ClientDetailTaskData clientDetailTaskData, ApiOperationCallBack apiOperationCallBack) {
        ApiTaskOperationHelper apiTaskOperationHelper = sApiTaskOperationHelper;
        if (apiTaskOperationHelper == null) {
            sApiTaskOperationHelper = new ApiTaskOperationHelper(clientDetailTaskData, apiOperationCallBack);
        } else {
            apiTaskOperationHelper.initData(clientDetailTaskData, apiOperationCallBack);
        }
        return sApiTaskOperationHelper;
    }

    private ApiTaskOperationHelper(ClientDetailTaskData clientDetailTaskData, ApiOperationCallBack apiOperationCallBack) {
        initData(clientDetailTaskData, apiOperationCallBack);
    }

    private void initData(ClientDetailTaskData clientDetailTaskData, ApiOperationCallBack apiOperationCallBack) {
        this.mClientDetailTaskData = clientDetailTaskData;
        this.mApiOperationCallBack = apiOperationCallBack;
        this.mApiOperationModel = ApiOperationModel.getInstance();
    }

    public OperationEnum getOperationEnum() {
        return this.mOperationEnum;
    }

    public void init(Context context) {
        ClientDetailTaskData clientDetailTaskData = this.mClientDetailTaskData;
        if (clientDetailTaskData != null) {
            callBackStatus(OperationEnum.SUCCESS_START);
            if (this.mClientDetailTaskData.getTaskDataApplyRecord() != null) {
                if (MokuConstants.STATUS_OF_APPLYING.equals(this.mClientDetailTaskData.getTaskDataApplyRecord().getStatus())) {
                    Integer id = this.mClientDetailTaskData.getTaskDataApplyRecord().getId();
                    this.mApiOperationModel.setTaskDataApplyRecordId(id.intValue());
                    if (!"comment".equals(this.mClientDetailTaskData.getClassify()) && !MokuConstants.TASK_TYPE_CPL.equals(this.mClientDetailTaskData.getClassify())) {
                        String packageName = this.mClientDetailTaskData.getPackageName();
                        String applicationId = "keyword".equals(this.mClientDetailTaskData.getClassify()) ? this.mClientDetailTaskData.getTaskData().getTaskDataDetail().getProductFlavors().getApplicationId() : packageName;
                        if (!TextUtils.isEmpty(packageName)) {
                            Integer listenerTime = this.mClientDetailTaskData.getTaskData().getTaskDataDetail().getListenerTime();
                            Integer timePercent = this.mClientDetailTaskData.getListeningTimeConfig().getTimePercent();
                            String listenedTag = this.mApiOperationModel.getListenedTag(context, id.intValue(), applicationId, packageName);
                            LogUtils.logD(TAG, "task listened=>taskDataApplyRecordId:" + id + ",listenerTime:" + listenerTime + ",timePercent:" + timePercent);
                            if (!TextUtils.isEmpty(listenedTag)) {
                                if (listenerTime != null && timePercent != null && listenerTime.intValue() > 0) {
                                    this.mApiOperationModel.goOnTask(packageName, listenerTime.intValue(), timePercent.intValue());
                                }
                            } else if (listenerTime != null && timePercent != null && listenerTime.intValue() > 0) {
                                this.mApiOperationModel.startTask(context, applicationId, packageName, listenerTime.intValue(), timePercent.intValue());
                            }
                        }
                    }
                    callBackStatus(OperationEnum.SUCCESS_APPLY);
                    goOnInitStatusWhenApplying(context);
                    return;
                }
                if (MokuConstants.STATUS_OF_OVERTIME.equals(this.mClientDetailTaskData.getTaskDataApplyRecord().getStatus())) {
                    callBackStatus(OperationEnum.ERROR_OVERTIME);
                    return;
                }
                return;
            }
            if (this.mClientDetailTaskData.getSurplusNum() != null && this.mClientDetailTaskData.getSurplusNum().intValue() <= 0) {
                callBackStatus(OperationEnum.ERROR_TAKEUP);
                return;
            }
            if (this.mClientDetailTaskData.getCpl() == null || !this.mClientDetailTaskData.getCpl().booleanValue()) {
                return;
            }
            long appTotalTimeInForeground = this.mApiOperationModel.getAppTotalTimeInForeground(context, 0, this.mClientDetailTaskData.getPackageName());
            if (appTotalTimeInForeground == 0) {
                if (Build.VERSION.SDK_INT >= 21) {
                    appTotalTimeInForeground = AppUsageStatsManager.getInstance().getAppTotalTimeInForeground(context, this.mClientDetailTaskData.getPackageName());
                }
                if (appTotalTimeInForeground == 0) {
                    appTotalTimeInForeground++;
                }
                this.mApiOperationModel.setAppTotalTimeInForeground(context, 0, this.mClientDetailTaskData.getPackageName(), appTotalTimeInForeground);
            }
            callBackStatus(OperationEnum.SUCCESS_START);
            goOnInitStatusWhenApplying(context);
            return;
        }
        if (clientDetailTaskData.getCpl() == null || !this.mClientDetailTaskData.getCpl().booleanValue()) {
            return;
        }
        callBackStatus(OperationEnum.SUCCESS_START);
        goOnInitStatusWhenApplying(context);
    }

    private void goOnInitStatusWhenApplying(Context context) {
        int i;
        if (this.mClientDetailTaskData.getTaskDataApplyRecord() != null) {
            Integer id = this.mClientDetailTaskData.getTaskDataApplyRecord().getId();
            String packageName = this.mClientDetailTaskData.getPackageName();
            if (this.mClientDetailTaskData.getClassify().equals("keyword") || this.mClientDetailTaskData.getClassify().equals("comment")) {
                String applicationId = this.mClientDetailTaskData.getTaskData().getTaskDataDetail().getProductFlavors().getApplicationId();
                if (!TextUtils.isEmpty(applicationId)) {
                    if (SystemUtils.isAppExist(context, applicationId)) {
                        if (!TextUtils.isEmpty(packageName)) {
                            if (SystemUtils.isAppExist(context, packageName)) {
                                if (this.mClientDetailTaskData.getClassify().equals("keyword")) {
                                    if (this.mApiOperationModel.isOpenTimeAppTask()) {
                                        if (this.mApiOperationModel.isTaskTimeOut(context, id.intValue())) {
                                            callBackStatus(OperationEnum.SUCCESS_SUBMIT);
                                            return;
                                        } else if (this.mApiOperationModel.getOpenAppLong(context) == 0) {
                                            callBackStatus(OperationEnum.SUCCESS_OPEN_APP);
                                            return;
                                        } else {
                                            callBackStatus(OperationEnum.SUCCESS_CONTINUE_DEMO);
                                            return;
                                        }
                                    }
                                    callBackStatus(OperationEnum.SUCCESS_SUBMIT);
                                    return;
                                }
                                if (this.mClientDetailTaskData.getClassify().equals("comment")) {
                                    callBackStatus(OperationEnum.SUCCESS_SUBMIT);
                                    return;
                                }
                                return;
                            }
                            callBackStatus(OperationEnum.SUCCESS_OPEN);
                            return;
                        }
                        callBackStatus(OperationEnum.SUCCESS_SUBMIT);
                        return;
                    }
                } else {
                    callBackStatus(OperationEnum.SUCCESS_SUBMIT);
                    return;
                }
            } else if (!TextUtils.isEmpty(packageName)) {
                if (SystemUtils.isAppExist(context, packageName)) {
                    if (this.mApiOperationModel.isOpenTimeAppTask()) {
                        boolean zIsTaskTimeOut = this.mApiOperationModel.isTaskTimeOut(context, this.mClientDetailTaskData.getTaskDataApplyRecord().getId().intValue());
                        boolean zIsShowCpaTips = this.mApiOperationModel.isShowCpaTips(context);
                        Integer cpaType = this.mClientDetailTaskData.getTaskData().getCpaType();
                        if (zIsShowCpaTips && !MokuConstants.CPA_TYPE_NORMAL.equals(cpaType) && (i = this.cpaSubmitTips) == 0) {
                            this.cpaSubmitTips = i + 1;
                            Toast.makeText(context, "已满足试玩时长，快提交/选择答案吧~", 1).show();
                        }
                        if (zIsTaskTimeOut) {
                            int i2 = this.cpaSubmitTips;
                            if (i2 == 0) {
                                this.cpaSubmitTips = i2 + 1;
                                Toast.makeText(context, "已满足试玩时长，快提交/选择答案吧~", 1).show();
                            }
                            callBackStatus(OperationEnum.SUCCESS_SUBMIT);
                            return;
                        }
                        callBackStatus(OperationEnum.SUCCESS_OPEN_APP);
                        return;
                    }
                    callBackStatus(OperationEnum.SUCCESS_SUBMIT);
                    return;
                }
            } else {
                callBackStatus(OperationEnum.SUCCESS_SUBMIT);
                return;
            }
        }
        initDownLoadStatus(context);
    }

    private void initDownLoadStatus(Context context) {
        String hpOrCpaTaskApkDownloadUrl;
        String str;
        String applicationId;
        String durl;
        String packageName = this.mClientDetailTaskData.getPackageName();
        if (this.mClientDetailTaskData.getClassify().equals("hp") || this.mClientDetailTaskData.getClassify().equals("cpa")) {
            String hpOrCpaTaskApkDownloadType = getHpOrCpaTaskApkDownloadType();
            if ("0".equals(hpOrCpaTaskApkDownloadType)) {
                callBackStatus(OperationEnum.SUCCESS_SUBMIT);
                return;
            } else if ("3".equals(hpOrCpaTaskApkDownloadType)) {
                callBackStatus(OperationEnum.SUCCESS_OPEN_MARKETDOWNLOAD);
                return;
            } else {
                hpOrCpaTaskApkDownloadUrl = getHpOrCpaTaskApkDownloadUrl();
                str = packageName;
            }
        } else {
            if (this.mClientDetailTaskData.getClassify().equals("comment") || this.mClientDetailTaskData.getClassify().equals("keyword")) {
                applicationId = this.mClientDetailTaskData.getTaskData().getTaskDataDetail().getProductFlavors().getApplicationId();
                durl = this.mClientDetailTaskData.getTaskData().getTaskDataDetail().getProductFlavors().getDurl();
            } else if (!MokuConstants.TASK_TYPE_CPL.equals(this.mClientDetailTaskData.getClassify()) || this.mClientDetailTaskData.getTaskData() == null) {
                str = "";
                hpOrCpaTaskApkDownloadUrl = str;
            } else {
                applicationId = this.mClientDetailTaskData.getTaskData().getTaskDataApkApplicationId();
                durl = this.mClientDetailTaskData.getTaskData().getTaskDataApkDownloadUrl();
            }
            str = applicationId;
            hpOrCpaTaskApkDownloadUrl = durl;
        }
        if (TextUtils.isEmpty(hpOrCpaTaskApkDownloadUrl)) {
            return;
        }
        this.mApiOperationModel.initDownloadConfig(context, this.mClientDetailTaskData.getClassify(), str, packageName, hpOrCpaTaskApkDownloadUrl, this);
    }

    public Integer checkIsCanStartTask(Context context) {
        if (!"comment".equals(this.mClientDetailTaskData.getClassify()) && !checkUsageStatsPermission(context)) {
            return MokuConstants.CHECK_NO_USAGE_STATS;
        }
        String packageName = this.mClientDetailTaskData.getPackageName();
        if (("keyword".equals(this.mClientDetailTaskData.getClassify()) || "comment".equals(this.mClientDetailTaskData.getClassify())) && SystemUtils.isAppExist(context, packageName)) {
            return MokuConstants.CHECK_APP_EXIST;
        }
        return MokuConstants.CHECK_CAN_START_TASK;
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

    public void executeTask(Context context) {
        String str;
        Log.d(TAG, "executeTask executeTask:" + System.currentTimeMillis());
        String packageName = this.mClientDetailTaskData.getPackageName();
        if ("comment".equals(this.mClientDetailTaskData.getClassify()) || checkUsageStatsPermission(context)) {
            int i = AnonymousClass3.$SwitchMap$com$fendasz$moku$planet$entity$OperationEnum[this.mOperationEnum.ordinal()];
            if (i != 18) {
                switch (i) {
                    case 1:
                        if ("3".equals(this.mClientDetailTaskData.getTaskData().getTaskDataApkDownloadType())) {
                            callBackStatus(OperationEnum.SUCCESS_APPMARKET_INSTALLED);
                            return;
                        }
                        break;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                        break;
                    case 8:
                        callBackCopyContent(OperationEnum.SUCCESS_OPEN, this.mClientDetailTaskData.getTaskData().getTaskDataDetail().getKeyword());
                        SystemUtils.openPackage(context, this.mClientDetailTaskData.getTaskData().getTaskDataDetail().getProductFlavors().getApplicationId());
                        return;
                    case 9:
                    case 10:
                        SystemUtils.openPackage(context, packageName);
                        return;
                    case 11:
                        downloadOrInstall(context);
                        return;
                    case 12:
                        downloadOrInstall(context);
                        return;
                    case 13:
                        downloadOrInstall(context);
                        return;
                    case 14:
                        SystemUtils.openPackage(context, packageName);
                        return;
                    default:
                        return;
                }
                downloadOrInstall(context);
                return;
            }
            Integer taskDataMarket = this.mClientDetailTaskData.getTaskData().getTaskDataMarket();
            Integer taskDataMobilePhoneBrand = null;
            applicationId = null;
            String applicationId = null;
            if (this.mClientDetailTaskData.getTaskData() != null) {
                if (this.mClientDetailTaskData.getTaskData().getTaskDataDetail() != null && this.mClientDetailTaskData.getTaskData().getTaskDataDetail().getProductFlavors() != null) {
                    applicationId = this.mClientDetailTaskData.getTaskData().getTaskDataDetail().getProductFlavors().getApplicationId();
                }
                String str2 = applicationId;
                taskDataMobilePhoneBrand = this.mClientDetailTaskData.getTaskData().getTaskDataMobilePhoneBrand();
                str = str2;
            } else {
                str = null;
            }
            if (taskDataMobilePhoneBrand != null) {
                if (taskDataMarket == null || 2 != taskDataMarket.intValue()) {
                    if (str != null) {
                        SystemUtils.openAppStoreWithInfo(context, str, this.mClientDetailTaskData.getPackageName(), taskDataMobilePhoneBrand.intValue());
                    }
                } else if (str != null) {
                    SystemUtils.openGameCenter(context, str, this.mClientDetailTaskData.getPackageName(), taskDataMobilePhoneBrand.intValue());
                }
            }
        }
    }

    /* renamed from: com.fendasz.moku.planet.helper.ApiTaskOperationHelper$3, reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
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
                $SwitchMap$com$fendasz$moku$planet$entity$OperationEnum[OperationEnum.SUCCESS_APPMARKET_INSTALLED.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$fendasz$moku$planet$entity$OperationEnum[OperationEnum.SUCCESS_OPEN_APP.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$fendasz$moku$planet$entity$OperationEnum[OperationEnum.SUCCESS_INSTALL.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$fendasz$moku$planet$entity$OperationEnum[OperationEnum.SUCCESS_INSTALL_APP.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$fendasz$moku$planet$entity$OperationEnum[OperationEnum.SUCCESS_AUTO_INSTALL_APP.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$fendasz$moku$planet$entity$OperationEnum[OperationEnum.SUCCESS_CONTINUE_DEMO.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$fendasz$moku$planet$entity$OperationEnum[OperationEnum.SUCCESS_SUBMIT.ordinal()] = 15;
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

    private void downloadOrInstall(Context context) {
        if (("hp".equals(this.mClientDetailTaskData.getClassify()) || "cpa".equals(this.mClientDetailTaskData.getClassify())) && getHpOrCpaTaskApkDownloadType().equals("2")) {
            SystemUtils.openBrowser(context, getHpOrCpaTaskApkDownloadUrl());
        } else {
            this.mApiOperationModel.downloadOrInstall(context, this);
        }
    }

    public void cancelTask(Context context) {
        this.mApiOperationModel.cancelTask(context, this);
    }

    public String getListenedTag(Context context, int i, String str, String str2) {
        return this.mApiOperationModel.getListenedTag(context, i, str, str2);
    }

    public long getOpenAppLong(Context context, String str, boolean z) {
        return this.mApiOperationModel.getOpenAppLong(context, str);
    }

    public void onRestart(Context context) {
        LogUtils.log(TAG, "onRestart");
        this.mApiOperationModel.onRestart(context, this);
    }

    public void onDestroy() {
        this.cpaSubmitTips = 0;
        LogUtils.log(TAG, "onDestroy");
        if (this.mApiOperationCallBack != null) {
            this.mApiOperationCallBack = null;
        }
        ApiOperationModel apiOperationModel = this.mApiOperationModel;
        if (apiOperationModel != null) {
            apiOperationModel.close();
        }
    }

    private String getHpOrCpaTaskApkDownloadType() {
        String apkDownloadType = this.mClientDetailTaskData.getTask().getApkDownloadType();
        return (TextUtils.isEmpty(this.mClientDetailTaskData.getTaskData().getTaskDataApkDownloadType()) || this.mClientDetailTaskData.getTaskData().getTaskDataApkDownloadType().equals("0")) ? apkDownloadType : this.mClientDetailTaskData.getTaskData().getTaskDataApkDownloadType();
    }

    private String getHpOrCpaTaskApkDownloadUrl() {
        return !TextUtils.isEmpty(this.mClientDetailTaskData.getTaskData().getTaskDataApkDownloadUrl()) ? this.mClientDetailTaskData.getTaskData().getTaskDataApkDownloadUrl() : this.mClientDetailTaskData.getTask().getApkDownloadUrl();
    }

    private void callBackStatus(OperationEnum operationEnum) {
        taskStatus(operationEnum);
    }

    private void callBackCopyContent(OperationEnum operationEnum, String str) {
        copyContent(operationEnum, str);
    }

    @Override // com.fendasz.moku.planet.entity.ApiOperationCallBack
    public void taskStatus(OperationEnum operationEnum) {
        this.mOperationEnum = operationEnum;
        ApiOperationCallBack apiOperationCallBack = this.mApiOperationCallBack;
        if (apiOperationCallBack != null) {
            apiOperationCallBack.taskStatus(operationEnum);
        }
    }

    @Override // com.fendasz.moku.planet.entity.ApiOperationCallBack
    public void downloadProgress(OperationEnum operationEnum, String str) {
        ApiOperationCallBack apiOperationCallBack = this.mApiOperationCallBack;
        if (apiOperationCallBack != null) {
            apiOperationCallBack.downloadProgress(operationEnum, str);
        }
    }

    @Override // com.fendasz.moku.planet.entity.ApiOperationCallBack
    public void listenerTime(OperationEnum operationEnum, int i) {
        ApiOperationCallBack apiOperationCallBack = this.mApiOperationCallBack;
        if (apiOperationCallBack != null) {
            apiOperationCallBack.listenerTime(operationEnum, i);
        }
    }

    @Override // com.fendasz.moku.planet.entity.ApiOperationCallBack
    public void copyContent(OperationEnum operationEnum, String str) {
        ApiOperationCallBack apiOperationCallBack = this.mApiOperationCallBack;
        if (apiOperationCallBack != null) {
            apiOperationCallBack.copyContent(operationEnum, str);
        }
    }

    public void cplLog(final Context context, final String str, final boolean z) throws MokuException {
        Integer recordId = this.mClientDetailTaskData.getRecordId();
        if (recordId == null) {
            recordId = 0;
        }
        String listenedTag = this.mApiOperationModel.getListenedTag(context, recordId.intValue(), this.mClientDetailTaskData.getPackageName(), str);
        if (listenedTag == null || StringUtils.isEmpty(listenedTag)) {
            LogUtils.logD(TAG, "cplLog no listenedTag,now add it and request service to add cpl log");
            ApiDataHelper.getInstance(context).cplLog(context, this.mClientDetailTaskData.getTaskDataId(), new ApiDataCallBack<Object>() { // from class: com.fendasz.moku.planet.helper.ApiTaskOperationHelper.1
                @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
                public void success(int i, Object obj) throws Exception {
                    LogUtils.logD(ApiTaskOperationHelper.TAG, "service add cpl log success,not add listenedTag on local");
                    Integer recordId2 = ApiTaskOperationHelper.this.mClientDetailTaskData.getRecordId();
                    if (recordId2 == null) {
                        recordId2 = 0;
                    }
                    ApiTaskOperationHelper.this.mApiOperationModel.setListenedTag(context, recordId2.intValue(), ApiTaskOperationHelper.this.mClientDetailTaskData.getPackageName(), str);
                    if (z) {
                        SystemUtils.openPackage(context, str);
                    }
                }

                @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
                public void error(int i, String str2) throws Exception {
                    LogUtils.logD(ApiTaskOperationHelper.TAG, "service add cpl log error,not open app");
                    if (z) {
                        SystemUtils.openPackage(context, str);
                    }
                }
            });
        } else if (z) {
            SystemUtils.openPackage(context, str);
        }
    }

    public void dianCplLog(final Context context, final String str, final boolean z) throws MokuException {
        Integer recordId = this.mClientDetailTaskData.getRecordId();
        if (recordId == null) {
            recordId = 0;
        }
        String listenedTag = this.mApiOperationModel.getListenedTag(context, recordId.intValue(), this.mClientDetailTaskData.getPackageName(), str);
        if (listenedTag == null || StringUtils.isEmpty(listenedTag)) {
            LogUtils.logD(TAG, "cplLog no listenedTag,now add it and request service to add cpl log");
            ApiDataHelper.getInstance(context).dianCplLog(context, this.mClientDetailTaskData.getTaskDataId(), new ApiDataCallBack<Object>() { // from class: com.fendasz.moku.planet.helper.ApiTaskOperationHelper.2
                @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
                public void success(int i, Object obj) throws Exception {
                    LogUtils.logD(ApiTaskOperationHelper.TAG, "service add cpl log success,not add listenedTag on local");
                    Integer recordId2 = ApiTaskOperationHelper.this.mClientDetailTaskData.getRecordId();
                    if (recordId2 == null) {
                        recordId2 = 0;
                    }
                    ApiTaskOperationHelper.this.mApiOperationModel.setListenedTag(context, recordId2.intValue(), ApiTaskOperationHelper.this.mClientDetailTaskData.getPackageName(), str);
                    if (z) {
                        SystemUtils.openPackage(context, str);
                    }
                }

                @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
                public void error(int i, String str2) throws Exception {
                    LogUtils.logD(ApiTaskOperationHelper.TAG, "service add cpl log error,not open app");
                    if (z) {
                        SystemUtils.openPackage(context, str);
                    }
                }
            });
        } else if (z) {
            SystemUtils.openPackage(context, str);
        }
    }
}
