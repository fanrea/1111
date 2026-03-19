package com.fendasz.moku.planet.helper;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.fendasz.moku.liulishuo.okdownload.DownloadTask;
import com.fendasz.moku.liulishuo.okdownload.SpeedCalculator;
import com.fendasz.moku.liulishuo.okdownload.core.Util;
import com.fendasz.moku.liulishuo.okdownload.core.breakpoint.BreakpointInfo;
import com.fendasz.moku.liulishuo.okdownload.core.cause.EndCause;
import com.fendasz.moku.liulishuo.okdownload.core.listener.assist.Listener4SpeedAssistExtend;
import com.fendasz.moku.planet.constants.MokuConstants;
import com.fendasz.moku.planet.entity.MokuDownloadListener;
import com.fendasz.moku.planet.entity.OperationEnum;
import com.fendasz.moku.planet.utils.AppUsageStatsManager;
import com.fendasz.moku.planet.utils.LogUtils;
import com.fendasz.moku.planet.utils.MokuDownloadUtils;
import com.fendasz.moku.planet.utils.SharedPreferencesUtils;
import com.fendasz.moku.planet.utils.system.utils.SystemUtils;
import java.io.File;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
class ApiOperationModel {
    private static final String TAG = "ApiOperationModel";
    private static ApiOperationModel sApiOperationModel;
    private BreakpointInfo mBreakpointInfo;
    private boolean mIsDownloading;
    private boolean mIsOpenTimeAppTask;
    private MokuDownloadUtils mMokuDownloadUtils;
    private AtomicLong mOpenAppTime;
    private String mTaskType;
    private boolean mIs50Down = false;
    private int mApplyRecordId = 0;
    private String mDownloadPkgName = "";
    private String mListenerPkgName = "";
    private long mTaskTime = 60000;
    private long mScaleTaskTime = 60000;

    private ApiOperationModel() {
        initData();
    }

    static ApiOperationModel getInstance() {
        ApiOperationModel apiOperationModel = sApiOperationModel;
        if (apiOperationModel == null) {
            sApiOperationModel = new ApiOperationModel();
        } else {
            apiOperationModel.initData();
        }
        return sApiOperationModel;
    }

    private void initData() {
        this.mIsOpenTimeAppTask = false;
        this.mIsDownloading = false;
    }

    void setTaskDataApplyRecordId(int i) {
        this.mApplyRecordId = i;
    }

    void initDownloadConfig(Context context, String str, String str2, String str3, String str4, ApiTaskOperationHelper apiTaskOperationHelper) {
        this.mTaskType = str;
        this.mDownloadPkgName = str2;
        this.mListenerPkgName = str3;
        initDownloadStatus(context, str4, apiTaskOperationHelper);
    }

    void startTask(Context context, String str, String str2, long j, double d) {
        try {
            if (Build.VERSION.SDK_INT >= 21) {
                startTask4Hapi(context, str, str2, j * 1000, ((long) (j * (d / 100.0d))) * 1000);
            } else {
                startTask4Lapi(context, str, str2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void startTask4Hapi(Context context, String str, String str2, long j, long j2) {
        this.mIsOpenTimeAppTask = true;
        this.mDownloadPkgName = str;
        this.mListenerPkgName = str2;
        this.mTaskTime = j;
        this.mScaleTaskTime = j2;
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        if (getAppTotalTimeInForeground(context, this.mApplyRecordId, this.mListenerPkgName) == 0) {
            long appTotalTimeInForeground = AppUsageStatsManager.getInstance().getAppTotalTimeInForeground(context, this.mListenerPkgName);
            if (appTotalTimeInForeground == 0) {
                appTotalTimeInForeground++;
            }
            setAppTotalTimeInForeground(context, this.mApplyRecordId, this.mListenerPkgName, appTotalTimeInForeground);
        }
        setListenedTag(context, this.mApplyRecordId, this.mDownloadPkgName, this.mListenerPkgName);
        LogUtils.log(TAG, "start listen task experience time");
    }

    private void startTask4Lapi(Context context, String str, String str2) {
        this.mIs50Down = true;
        this.mDownloadPkgName = str;
        this.mListenerPkgName = str2;
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        setListenedTag(context, this.mApplyRecordId, this.mDownloadPkgName, this.mListenerPkgName);
    }

    void goOnTask(String str, long j, double d) {
        try {
            if (Build.VERSION.SDK_INT >= 21) {
                goOnTask4Hapi(str, j * 1000, ((long) (j * (d / 100.0d))) * 1000);
            } else {
                goOnTask4Lapi(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void goOnTask4Hapi(String str, long j, long j2) {
        this.mIsOpenTimeAppTask = true;
        this.mListenerPkgName = str;
        this.mTaskTime = j;
        this.mScaleTaskTime = j2;
    }

    private void goOnTask4Lapi(String str) {
        this.mListenerPkgName = str;
    }

    void downloadOrInstall(Context context, ApiTaskOperationHelper apiTaskOperationHelper) {
        try {
            MokuDownloadUtils mokuDownloadUtils = this.mMokuDownloadUtils;
            if (mokuDownloadUtils == null || mokuDownloadUtils.getDownloadApkPath() == null) {
                apiTaskOperationHelper.getCallBack().taskStatus(OperationEnum.ERROR_DOWNLOAD);
                return;
            }
            if (this.mMokuDownloadUtils.getDownloadApkPath().exists()) {
                if (this.mBreakpointInfo != null) {
                    if (this.mIsDownloading) {
                        return;
                    }
                    if (this.mTaskType.equals("comment") || this.mTaskType.equals("keyword")) {
                        apiTaskOperationHelper.getCallBack().taskStatus(OperationEnum.SUCCESS_DOWNLOAD);
                    } else if (MokuConstants.TASK_TYPE_CPL.equals(this.mTaskType)) {
                        apiTaskOperationHelper.getCallBack().taskStatus(OperationEnum.SUCCESS_DOWNLOAD_APP);
                    } else {
                        apiTaskOperationHelper.getCallBack().taskStatus(OperationEnum.SUCCESS_DOWNLOAD_APP);
                    }
                    this.mMokuDownloadUtils.startDownload();
                    return;
                }
                if (this.mTaskType.equals("comment") || this.mTaskType.equals("keyword")) {
                    apiTaskOperationHelper.getCallBack().taskStatus(OperationEnum.SUCCESS_INSTALL);
                } else {
                    apiTaskOperationHelper.getCallBack().taskStatus(OperationEnum.SUCCESS_INSTALL_APP);
                }
                SystemUtils.installApp(context, this.mMokuDownloadUtils.getDownloadApkPath());
                return;
            }
            if (this.mIsDownloading) {
                apiTaskOperationHelper.getCallBack().taskStatus(OperationEnum.SUCCESS_CONTINUE_DOWNLOAD);
                this.mMokuDownloadUtils.stopDownload();
                return;
            }
            if (this.mTaskType.equals("comment") || this.mTaskType.equals("keyword")) {
                apiTaskOperationHelper.getCallBack().taskStatus(OperationEnum.SUCCESS_DOWNLOAD);
            } else {
                apiTaskOperationHelper.getCallBack().taskStatus(OperationEnum.SUCCESS_DOWNLOAD_APP);
            }
            this.mMokuDownloadUtils.startDownload();
        } catch (Exception unused) {
            LogUtils.logE(TAG, "down load error,because moku down path is null or url is null");
            apiTaskOperationHelper.getCallBack().taskStatus(OperationEnum.ERROR_DOWNLOAD);
        }
    }

    class MyMokuDownloadListener extends MokuDownloadListener {
        ApiTaskOperationHelper apiTaskOperationHelper;
        Context context;
        String downloadUrl;
        AtomicLong totalLength = new AtomicLong();
        String readableTotalLength = "";

        MyMokuDownloadListener(Context context, String str, ApiTaskOperationHelper apiTaskOperationHelper) {
            this.context = context;
            this.downloadUrl = str;
            this.apiTaskOperationHelper = apiTaskOperationHelper;
        }

        @Override // com.fendasz.moku.planet.entity.MokuDownloadListener, com.fendasz.moku.liulishuo.okdownload.DownloadListener
        public void taskStart(DownloadTask downloadTask) {
            super.taskStart(downloadTask);
            ApiOperationModel.this.mIsDownloading = true;
            this.apiTaskOperationHelper.getCallBack().taskStatus(OperationEnum.SUCCESS_DOWNLOAD_LOADING);
            ApiOperationModel apiOperationModel = ApiOperationModel.this;
            apiOperationModel.mBreakpointInfo = apiOperationModel.mMokuDownloadUtils.getDownloadInfo(this.downloadUrl);
        }

        @Override // com.fendasz.moku.planet.entity.MokuDownloadListener, com.fendasz.moku.liulishuo.okdownload.core.listener.assist.Listener4SpeedAssistExtend.Listener4SpeedCallback
        public void infoReady(DownloadTask downloadTask, BreakpointInfo breakpointInfo, boolean z, Listener4SpeedAssistExtend.Listener4SpeedModel listener4SpeedModel) {
            super.infoReady(downloadTask, breakpointInfo, z, listener4SpeedModel);
            this.totalLength.set(breakpointInfo.getTotalLength());
            breakpointInfo.getTotalOffset();
            this.readableTotalLength = Util.humanReadableBytes(this.totalLength.get(), true);
        }

        @Override // com.fendasz.moku.planet.entity.MokuDownloadListener, com.fendasz.moku.liulishuo.okdownload.core.listener.assist.Listener4SpeedAssistExtend.Listener4SpeedCallback
        public void progress(DownloadTask downloadTask, long j, SpeedCalculator speedCalculator) {
            super.progress(downloadTask, j, speedCalculator);
            String str = String.format("%.2f", Float.valueOf((j / this.totalLength.get()) * 100.0f));
            LogUtils.log(ApiOperationModel.TAG, str);
            this.apiTaskOperationHelper.getCallBack().taskStatus(OperationEnum.SUCCESS_DOWNLOAD_LOADING);
            this.apiTaskOperationHelper.getCallBack().downloadProgress(OperationEnum.SUCCESS_DOWNLOAD_LOADING, str);
        }

        @Override // com.fendasz.moku.planet.entity.MokuDownloadListener, com.fendasz.moku.liulishuo.okdownload.core.listener.assist.Listener4SpeedAssistExtend.Listener4SpeedCallback
        public void taskEnd(DownloadTask downloadTask, EndCause endCause, Exception exc, SpeedCalculator speedCalculator) {
            super.taskEnd(downloadTask, endCause, exc, speedCalculator);
            ApiOperationModel.this.mIsDownloading = false;
            ApiOperationModel apiOperationModel = ApiOperationModel.this;
            apiOperationModel.mBreakpointInfo = apiOperationModel.mMokuDownloadUtils.getDownloadInfo(this.downloadUrl);
            int i = AnonymousClass1.$SwitchMap$com$fendasz$moku$liulishuo$okdownload$core$cause$EndCause[endCause.ordinal()];
            if (i == 1) {
                ApiOperationModel.this.mMokuDownloadUtils.stopDownload();
                this.apiTaskOperationHelper.getCallBack().taskStatus(OperationEnum.ERROR_DOWNLOAD);
                return;
            }
            if (i == 2) {
                ApiTaskOperationHelper apiTaskOperationHelper = this.apiTaskOperationHelper;
                if (apiTaskOperationHelper != null) {
                    apiTaskOperationHelper.init(this.context);
                    return;
                }
                return;
            }
            if (i != 3) {
                return;
            }
            if (!TextUtils.isEmpty(ApiOperationModel.this.mTaskType)) {
                if (ApiOperationModel.this.mTaskType.equals("hp") || ApiOperationModel.this.mTaskType.equals("cpa")) {
                    this.apiTaskOperationHelper.getCallBack().taskStatus(OperationEnum.SUCCESS_AUTO_INSTALL_APP);
                    return;
                } else {
                    this.apiTaskOperationHelper.getCallBack().taskStatus(OperationEnum.SUCCESS_INSTALL);
                    SystemUtils.installApp(this.context, ApiOperationModel.this.mMokuDownloadUtils.getDownloadApkPath());
                    return;
                }
            }
            this.apiTaskOperationHelper.getCallBack().taskStatus(OperationEnum.SUCCESS_AUTO_INSTALL_APP);
        }
    }

    /* renamed from: com.fendasz.moku.planet.helper.ApiOperationModel$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$fendasz$moku$liulishuo$okdownload$core$cause$EndCause;

        static {
            int[] iArr = new int[EndCause.values().length];
            $SwitchMap$com$fendasz$moku$liulishuo$okdownload$core$cause$EndCause = iArr;
            try {
                iArr[EndCause.ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$fendasz$moku$liulishuo$okdownload$core$cause$EndCause[EndCause.CANCELED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$fendasz$moku$liulishuo$okdownload$core$cause$EndCause[EndCause.COMPLETED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$fendasz$moku$liulishuo$okdownload$core$cause$EndCause[EndCause.FILE_BUSY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$fendasz$moku$liulishuo$okdownload$core$cause$EndCause[EndCause.SAME_TASK_BUSY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$fendasz$moku$liulishuo$okdownload$core$cause$EndCause[EndCause.PRE_ALLOCATE_FAILED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    private void initDownloadStatus(Context context, String str, ApiTaskOperationHelper apiTaskOperationHelper) {
        if (Build.VERSION.SDK_INT < 29) {
            this.mMokuDownloadUtils = new MokuDownloadUtils.Builder().setDownloadUrl(str).setDownloadListener(new MyMokuDownloadListener(context, str, apiTaskOperationHelper)).setTagTaskId(1).build();
        } else {
            this.mMokuDownloadUtils = new MokuDownloadUtils.Builder(context).setDownloadUrl(str).setDownloadListener(new MyMokuDownloadListener(context, str, apiTaskOperationHelper)).setTagTaskId(1).build();
        }
        BreakpointInfo downloadInfo = this.mMokuDownloadUtils.getDownloadInfo(str);
        this.mBreakpointInfo = downloadInfo;
        if (downloadInfo != null) {
            if (this.mMokuDownloadUtils.getDownloadApkPath().exists()) {
                apiTaskOperationHelper.getCallBack().taskStatus(OperationEnum.SUCCESS_CONTINUE_DOWNLOAD);
                return;
            } else if (this.mTaskType.equals("hp") || this.mTaskType.equals("cpa")) {
                apiTaskOperationHelper.getCallBack().taskStatus(OperationEnum.SUCCESS_DOWNLOAD_APP);
                return;
            } else {
                apiTaskOperationHelper.getCallBack().taskStatus(OperationEnum.SUCCESS_DOWNLOAD);
                return;
            }
        }
        if (this.mTaskType.equals("hp") || this.mTaskType.equals("cpa")) {
            if (SystemUtils.isAppExist(context, this.mDownloadPkgName)) {
                return;
            }
            if (this.mMokuDownloadUtils.getDownloadApkPath().exists()) {
                apiTaskOperationHelper.getCallBack().taskStatus(OperationEnum.SUCCESS_INSTALL_APP);
                return;
            } else {
                apiTaskOperationHelper.getCallBack().taskStatus(OperationEnum.SUCCESS_DOWNLOAD_APP);
                return;
            }
        }
        if (MokuConstants.TASK_TYPE_CPL.equals(this.mTaskType) || SystemUtils.isAppExist(context, this.mDownloadPkgName)) {
            return;
        }
        if (this.mMokuDownloadUtils.getDownloadApkPath().exists()) {
            apiTaskOperationHelper.getCallBack().taskStatus(OperationEnum.SUCCESS_INSTALL);
        } else {
            apiTaskOperationHelper.getCallBack().taskStatus(OperationEnum.SUCCESS_DOWNLOAD);
        }
    }

    void cancelTask(Context context, ApiTaskOperationHelper apiTaskOperationHelper) throws NullPointerException {
        MokuDownloadUtils mokuDownloadUtils = this.mMokuDownloadUtils;
        if (mokuDownloadUtils != null) {
            mokuDownloadUtils.stopDownload();
            File downloadApkPath = this.mMokuDownloadUtils.getDownloadApkPath();
            if (downloadApkPath.exists()) {
                downloadApkPath.delete();
            }
        }
        if (apiTaskOperationHelper != null) {
            apiTaskOperationHelper.init(context);
        }
    }

    void close() {
        String str = TAG;
        LogUtils.logD(str, "close");
        if (this.mIsDownloading) {
            LogUtils.logD(str, "mIsDownloading");
            if (this.mMokuDownloadUtils != null) {
                LogUtils.logD(str, "mMokuDownloadUtils stopDownload");
                this.mMokuDownloadUtils.stopDownload();
            }
        }
    }

    void onRestart(Context context, ApiTaskOperationHelper apiTaskOperationHelper) {
        apiTaskOperationHelper.init(context);
        OperationEnum operationEnum = apiTaskOperationHelper.getOperationEnum();
        if (this.mIsOpenTimeAppTask && !TextUtils.isEmpty(this.mListenerPkgName)) {
            long openAppLong = getOpenAppLong(context);
            LogUtils.logD(TAG, "onRestart_openAppLong:" + openAppLong + ",mScaleTaskTime:" + this.mScaleTaskTime);
            if (operationEnum.equals(OperationEnum.SUCCESS_OPEN_APP) || operationEnum.equals(OperationEnum.SUCCESS_CONTINUE_DEMO)) {
                if (openAppLong >= this.mScaleTaskTime) {
                    apiTaskOperationHelper.getCallBack().taskStatus(OperationEnum.SUCCESS_SUBMIT);
                    setTaskTimeOut(context, this.mApplyRecordId, true);
                } else {
                    if (openAppLong == 0) {
                        apiTaskOperationHelper.getCallBack().taskStatus(OperationEnum.SUCCESS_OPEN_APP);
                    } else {
                        apiTaskOperationHelper.getCallBack().listenerTime(OperationEnum.SUCCESS_CONTINUE_DEMO, Integer.parseInt(((((this.mTaskTime - openAppLong) / 1000) / 60) + 1) + ""));
                        apiTaskOperationHelper.getCallBack().taskStatus(OperationEnum.SUCCESS_CONTINUE_DEMO);
                    }
                    setTaskTimeOut(context, this.mApplyRecordId, false);
                }
                this.mIsOpenTimeAppTask = false;
            }
        }
        if (this.mIs50Down) {
            apiTaskOperationHelper.getCallBack().taskStatus(OperationEnum.SUCCESS_SUBMIT);
        }
    }

    public boolean isShowCpaTips(Context context) {
        return getOpenAppLong(context) >= this.mScaleTaskTime;
    }

    public long getOpenAppLong(Context context) {
        AtomicLong atomicLong;
        if (Build.VERSION.SDK_INT >= 21) {
            atomicLong = new AtomicLong(AppUsageStatsManager.getInstance().getAppTotalTimeInForeground(context, this.mListenerPkgName));
        } else {
            atomicLong = new AtomicLong(this.mOpenAppTime.get() + this.mScaleTaskTime);
        }
        if (atomicLong.get() == 0) {
            atomicLong.set(1L);
        }
        AtomicLong atomicLong2 = new AtomicLong(getAppTotalTimeInForeground(context, this.mApplyRecordId, this.mListenerPkgName));
        this.mOpenAppTime = atomicLong2;
        if (atomicLong2.get() == 0) {
            this.mOpenAppTime = atomicLong;
        }
        return atomicLong.get() - this.mOpenAppTime.get();
    }

    public long getOpenAppLong(Context context, String str) {
        AtomicLong atomicLong;
        if (Build.VERSION.SDK_INT >= 21) {
            atomicLong = new AtomicLong(AppUsageStatsManager.getInstance().getAppTotalTimeInForeground(context, str));
        } else {
            atomicLong = new AtomicLong(this.mOpenAppTime.get() + this.mScaleTaskTime);
        }
        if (atomicLong.get() == 0) {
            atomicLong.set(1L);
        }
        AtomicLong atomicLong2 = new AtomicLong(getAppTotalTimeInForeground(context, this.mApplyRecordId, str));
        this.mOpenAppTime = atomicLong2;
        if (atomicLong2.get() == 0) {
            this.mOpenAppTime = atomicLong;
        }
        return atomicLong.get() - this.mOpenAppTime.get();
    }

    boolean isOpenTimeAppTask() {
        return this.mIsOpenTimeAppTask;
    }

    boolean isTaskTimeOut(Context context, int i) {
        return SharedPreferencesUtils.getInstance(context).getBoolean(i + "", false);
    }

    private void setTaskTimeOut(Context context, int i, boolean z) {
        SharedPreferencesUtils.getInstance(context).putBoolean(i + "", z);
    }

    public void setAppTotalTimeInForeground(Context context, int i, String str, long j) {
        String str2 = i + str;
        LogUtils.logD(TAG, "setAppTotalTimeInForeground_key:" + str2 + ",appTotalTimeInForeground=>" + j);
        SharedPreferencesUtils.getInstance(context).putLong(str2, j);
    }

    public long getAppTotalTimeInForeground(Context context, int i, String str) {
        String str2 = i + str;
        long j = SharedPreferencesUtils.getInstance(context).getLong(str2, 0L);
        LogUtils.logD(TAG, "getAppTotalTimeInForeground_key=>" + str2 + ",appTotalTimeInForeground=>" + j);
        return j;
    }

    public void setListenedTag(Context context, int i, String str, String str2) {
        String str3 = i + str + str2;
        String str4 = i + str + str2;
        LogUtils.logD(TAG, "setListenedTag_key=>" + str3 + ",value=>" + str4);
        SharedPreferencesUtils.getInstance(context).putString(str3, str4);
    }

    public String getListenedTag(Context context, int i, String str, String str2) {
        String str3 = i + str + str2;
        String string = SharedPreferencesUtils.getInstance(context).getString(str3, null);
        LogUtils.logD(TAG, "getListenedTag_key=>" + str3 + ",listenedTag=>" + string);
        return string;
    }
}
