package com.bytedance.sdk.djx.core.init;

import android.os.SystemClock;
import com.bytedance.sdk.djx.core.log.DJXSdkLazyReporter;
import com.bytedance.sdk.djx.core.util.MainTask;
import com.bytedance.sdk.djx.utils.LG;
import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public abstract class InitTask extends MainTask {
    private static final String TAG = "InitTask";
    protected int mErrorCode;
    protected String mErrorMsg;
    private final boolean mIsLazyLog;
    private long mStartTime;
    protected SdkTInitLog mTLog;
    private final String mTaskName;

    public InitTask(String str, boolean z, boolean z2, ThreadPoolExecutor threadPoolExecutor, MainTask... mainTaskArr) {
        super(z2, threadPoolExecutor, mainTaskArr);
        this.mStartTime = -1L;
        this.mErrorCode = -1;
        this.mErrorMsg = null;
        this.mTLog = new SdkTInitLog();
        this.mTaskName = str;
        this.mIsLazyLog = z;
    }

    public InitTask(String str, boolean z, ThreadPoolExecutor threadPoolExecutor, MainTask... mainTaskArr) {
        this(str, false, z, threadPoolExecutor, mainTaskArr);
    }

    public InitTask(String str, boolean z, MainTask... mainTaskArr) {
        this(str, z, false, null, mainTaskArr);
    }

    public InitTask(String str, MainTask... mainTaskArr) {
        this(str, false, false, null, mainTaskArr);
    }

    @Override // com.bytedance.sdk.djx.core.util.MainTask
    public void onTaskStart() {
        super.onTaskStart();
        this.mStartTime = SystemClock.elapsedRealtime();
        LG.d(TAG, this.mTaskName + " Run, " + this);
    }

    @Override // com.bytedance.sdk.djx.core.util.MainTask
    public void onTaskDone() {
        super.onTaskDone();
        LG.d(TAG, this.mTaskName + " Done, " + this);
        sendInitTaskLog();
        this.mStartTime = -1L;
    }

    public void sendInitTaskLog() {
        if (this.mIsLazyLog) {
            logTaskMonitor();
        } else {
            sendTaskMonitor();
        }
    }

    protected void sendTaskMonitor() {
        long jElapsedRealtime = this.mStartTime > 0 ? SystemClock.elapsedRealtime() - this.mStartTime : -1L;
        this.mTLog.sendSdkLaunchTaskMonitor(this.mTaskName, this.result != null && this.result.booleanValue(), this.mIsAsync, jElapsedRealtime, Integer.valueOf(this.mErrorCode), this.mErrorMsg);
        LG.d(TAG, this.mTaskName + " cost = " + jElapsedRealtime);
    }

    protected void logTaskMonitor() {
        long jElapsedRealtime = this.mStartTime > 0 ? SystemClock.elapsedRealtime() - this.mStartTime : -1L;
        DJXSdkLazyReporter.logEventSdkLaunchTaskMonitor(this.mTaskName, this.result != null && this.result.booleanValue(), this.mIsAsync, jElapsedRealtime, Integer.valueOf(this.mErrorCode), this.mErrorMsg);
        LG.d(TAG, this.mTaskName + " cost = " + jElapsedRealtime);
    }
}
