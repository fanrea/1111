package com.kwad.sdk.crash.model.message;

import android.text.TextUtils;
import com.kwad.sdk.core.b;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.crash.utils.i;
import com.kwad.sdk.crash.utils.j;
import com.kwad.sdk.utils.aa;
import java.io.Serializable;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public abstract class ExceptionMessage implements b, Serializable {
    private static final long serialVersionUID = -5338556142957298914L;
    public long mCurrentTimeStamp;
    public int mPid;
    public int mTid;
    public long mUsageTimeMills;
    public String mCrashDetail = "Unknown";
    public String mMemoryInfo = "Unknown";
    public String mDiskInfo = "Unknown";
    public String mProcessName = "Unknown";
    public int mExceptionType = 0;
    public String mCrashType = getTypeCommon();
    public String mThreadName = "Unknown";
    public String mIsAppOnForeground = "Unknown";
    public String mLogUUID = "Unknown";
    public String mVirtualApp = "Unknown";
    public String mCustomMsg = "Unknown";
    public String mThreadOverflow = "Unknown";
    public String mFdOverflow = "Unknown";
    public String mTaskId = "Unknown";
    public String mErrorMessage = "";
    public String mVersionCode = "Unknown";
    public boolean mVersionConflict = false;
    public String mAppVersionBeforeLastUpload = "Unknown";
    public String mJNIError = "";
    public String mGCInfo = "";
    public String mLockInfo = "";
    public String mMonitorInfo = "";
    public String mSlowLooper = "";
    public String mSlowOperation = "";
    public String mBuildConfigInfo = "";
    public String mAbi = "Unknown";
    public String mDumpsys = "";
    public int mCrashSource = 0;

    public static final String getSdkVersionNameSuffix(int i) {
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? "" : "-car" : "-pct" : "-ec" : "-ct" : "-ad";
    }

    protected abstract String getTypePrefix();

    public final String getTypeCommon() {
        return getTypePrefix() + "COMMON";
    }

    public final String getTypeHeapOOM() {
        return getTypePrefix() + "HEAP_OOM";
    }

    public final String getTypeThreadOOM() {
        return getTypePrefix() + "THREAD_OOM";
    }

    public final String getTypeFdOOM() {
        return getTypePrefix() + "FD_OOM";
    }

    @Override // com.kwad.sdk.core.b
    public void parseJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.mCrashDetail = jSONObject.optString("mCrashDetail");
        this.mMemoryInfo = jSONObject.optString("mMemoryInfo");
        this.mDiskInfo = jSONObject.optString("mDiskInfo");
        this.mProcessName = jSONObject.optString("mProcessName");
        this.mCrashType = jSONObject.optString("mCrashType");
        this.mThreadName = jSONObject.optString("mThreadName");
        this.mIsAppOnForeground = jSONObject.optString("mIsAppOnForeground");
        this.mLogUUID = jSONObject.optString("mLogUUID");
        this.mVirtualApp = jSONObject.optString("mVirtualApp");
        this.mCustomMsg = jSONObject.optString("mCustomMsg");
        this.mThreadOverflow = jSONObject.optString("mThreadOverflow");
        this.mFdOverflow = jSONObject.optString("mFdOverflow");
        this.mTaskId = jSONObject.optString("mTaskId");
        this.mErrorMessage = jSONObject.optString("mErrorMessage");
        this.mCurrentTimeStamp = jSONObject.optLong("mCurrentTimeStamp");
        this.mUsageTimeMills = jSONObject.optLong("mUsageTimeMills");
        this.mPid = jSONObject.optInt("mPid");
        this.mTid = jSONObject.optInt("mTid");
        this.mVersionCode = jSONObject.optString("mVersionCode");
        this.mVersionConflict = jSONObject.optBoolean("mVersionConflict");
        this.mAppVersionBeforeLastUpload = jSONObject.optString("mAppVersionBeforeLastUpload");
        this.mJNIError = jSONObject.optString("mJNIError");
        this.mGCInfo = jSONObject.optString("mGCInfo");
        this.mLockInfo = jSONObject.optString("mLockInfo");
        this.mMonitorInfo = jSONObject.optString("mMonitorInfo");
        this.mSlowLooper = jSONObject.optString("mSlowLooper");
        this.mSlowOperation = jSONObject.optString("mSlowOperation");
        this.mBuildConfigInfo = jSONObject.optString("mBuildConfigInfo");
        this.mAbi = jSONObject.optString("mAbi");
        this.mDumpsys = jSONObject.optString("mDumpsys");
        this.mCrashSource = jSONObject.optInt("mCrashSource");
    }

    private void setIsForeground() {
        try {
            com.kwad.sdk.core.c.b.aaf();
            this.mIsAppOnForeground = com.kwad.sdk.core.c.b.isAppOnForeground() ? "Foreground" : "Background";
        } catch (Exception unused) {
        }
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        aa.putValue(jSONObject, "mCrashDetail", this.mCrashDetail);
        aa.putValue(jSONObject, "mMemoryInfo", this.mMemoryInfo);
        aa.putValue(jSONObject, "mDiskInfo", this.mDiskInfo);
        aa.putValue(jSONObject, "mProcessName", this.mProcessName);
        aa.putValue(jSONObject, "mCrashType", this.mCrashType);
        aa.putValue(jSONObject, "mThreadName", this.mThreadName);
        setIsForeground();
        aa.putValue(jSONObject, "mIsAppOnForeground", this.mIsAppOnForeground);
        aa.putValue(jSONObject, "mLogUUID", this.mLogUUID);
        aa.putValue(jSONObject, "mVirtualApp", this.mVirtualApp);
        aa.putValue(jSONObject, "mCustomMsg", this.mCustomMsg);
        aa.putValue(jSONObject, "mThreadOverflow", this.mThreadOverflow);
        aa.putValue(jSONObject, "mFdOverflow", this.mFdOverflow);
        aa.putValue(jSONObject, "mTaskId", this.mTaskId);
        aa.putValue(jSONObject, "mErrorMessage", this.mErrorMessage);
        aa.putValue(jSONObject, "mCurrentTimeStamp", this.mCurrentTimeStamp);
        aa.putValue(jSONObject, "mUsageTimeMills", this.mUsageTimeMills);
        aa.putValue(jSONObject, "mPid", this.mPid);
        aa.putValue(jSONObject, "mTid", this.mTid);
        aa.putValue(jSONObject, "mVersionCode", this.mVersionCode);
        aa.putValue(jSONObject, "mVersionConflict", this.mVersionConflict);
        aa.putValue(jSONObject, "mAppVersionBeforeLastUpload", this.mAppVersionBeforeLastUpload);
        aa.putValue(jSONObject, "mJNIError", this.mJNIError);
        aa.putValue(jSONObject, "mGCInfo", this.mGCInfo);
        aa.putValue(jSONObject, "mLockInfo", this.mLockInfo);
        aa.putValue(jSONObject, "mMonitorInfo", this.mMonitorInfo);
        aa.putValue(jSONObject, "mSlowLooper", this.mSlowLooper);
        aa.putValue(jSONObject, "mSlowOperation", this.mSlowOperation);
        aa.putValue(jSONObject, "mBuildConfigInfo", this.mBuildConfigInfo);
        aa.putValue(jSONObject, "mAbi", this.mAbi);
        aa.putValue(jSONObject, "mDumpsys", this.mDumpsys);
        aa.putValue(jSONObject, "mCrashSource", this.mCrashSource);
        return jSONObject;
    }

    public String getThreadName() {
        return this.mThreadName;
    }

    public void setThreadName(String str) {
        this.mThreadName = str;
    }

    public int getTid() {
        return this.mTid;
    }

    public void setTid(int i) {
        this.mTid = i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        try {
            sb.append("异常状态汇总:\nUUID: ").append(this.mLogUUID).append("\nCPU架构: ").append(this.mAbi).append("\n异常进程: ").append(this.mProcessName).append(" (").append(this.mPid).append(")\n").append("异常线程: ").append(this.mThreadName).append(" (").append(this.mTid).append(")\n").append("异常类型: ").append(this.mCrashType).append("\n应用多开环境: ").append(this.mVirtualApp).append("\nTaskId: ").append(this.mTaskId).append("\nmTid: ").append(this.mTid).append("\n自定义信息: ").append(this.mCustomMsg).append("\n前后台状态: ").append(this.mIsAppOnForeground).append("\n异常发生时间: ").append(i.bn(this.mCurrentTimeStamp)).append("\n版本号: ").append(this.mVersionCode).append("\n升级前版本号: ").append(this.mAppVersionBeforeLastUpload).append("\n使用时长: ").append(j.bo(this.mUsageTimeMills)).append("\n异常详情: \n");
            if (this instanceof JavaExceptionMessage) {
                sb.append(this.mCrashDetail.replace("##", "\n\t").replace("#", "\n"));
            } else {
                sb.append(this.mCrashDetail);
            }
            sb.append("\n磁盘详情: \n").append(this.mDiskInfo).append("\n");
            if (!TextUtils.isEmpty(this.mErrorMessage)) {
                sb.append("异常上报Debug: \n").append(this.mErrorMessage).append("\n");
            }
            if (!TextUtils.isEmpty(this.mBuildConfigInfo)) {
                sb.append("BuildConfig信息: \n").append(this.mBuildConfigInfo).append("\n");
            }
            if (!TextUtils.isEmpty(this.mJNIError)) {
                sb.append("JNI异常: \n").append(this.mJNIError).append("\n");
            }
            if (!TextUtils.isEmpty(this.mGCInfo)) {
                sb.append("GC耗时: \n").append(this.mGCInfo).append("\n");
            }
            if (!TextUtils.isEmpty(this.mLockInfo)) {
                sb.append("锁耗时(dvm_lock_sample): \n").append(this.mLockInfo).append("\n");
            }
            if (!TextUtils.isEmpty(this.mMonitorInfo)) {
                sb.append("锁耗时(monitor): \n").append(this.mMonitorInfo).append("\n");
            }
            if (!TextUtils.isEmpty(this.mSlowLooper)) {
                sb.append("Looper耗时: \n").append(this.mSlowLooper).append("\n");
            }
            if (!TextUtils.isEmpty(this.mSlowOperation)) {
                sb.append("AMS调度耗时: \n").append(this.mSlowOperation).append("\n");
            }
            sb.append("内存详情: \n").append(this.mMemoryInfo).append("\n");
        } catch (Throwable th) {
            c.printStackTraceOnly(th);
        }
        return sb.substring(0);
    }

    public String getReportMsg() {
        StringBuilder sb = new StringBuilder();
        sb.append("UUID=").append(this.mLogUUID).append(",crashTime=").append(i.bn(this.mCurrentTimeStamp)).append(",customMsg=").append(this.mCustomMsg);
        return sb.toString();
    }

    public static final String getSdkCrashVersionName(String str, int i) {
        return str + "-" + i;
    }
}
