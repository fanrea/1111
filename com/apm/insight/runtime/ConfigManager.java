package com.apm.insight.runtime;

import android.content.Context;
import android.text.TextUtils;
import com.apm.insight.ICommonParams;
import com.bytedance.apm.common.utility.NetworkUtils;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import java.util.Set;
import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class ConfigManager {
    private static final String ALOG_UPLOAD_URL = "https://apmplus.volces.com/monitor/collect/c/cloudcontrol/file";
    public static final String ALOG_URL_SUFFIX = "/monitor/collect/c/cloudcontrol/file";
    private static final String ASAN_REPORT_URL = "https://apmplus.volces.com/monitor/collect/c/native_bin_crash";
    public static final long BLOCK_MONITOR_INTERVAL = 1000;
    private static final long BLOCK_MONITOR_MIN_INTERVAL = 10;
    private static final String CONFIG_URL = "https://apmplus.volces.com/settings/get";
    public static final String CONFIG_URL_SUFFIX = "/settings/get";
    private static final String CORE_DUMP_URL = "https://apmplus.volces.com/monitor/collect/c/core_dump_collect";
    private static final String CRASH_PORTRAIT_URL = "https://apmplus.volces.com/monitor/collect/c/crash_portrait";
    private static final String EXCEPTION_URL = "https://apmplus.volces.com/monitor/collect/c/exception";
    public static final String EXCEPTION_URL_SUFFIX = "/monitor/collect/c/exception";
    private static final String FILE_UPLOAD_URL = "https://apmplus.volces.com/monitor/collect/c/logcollect";
    public static final String FILE_UPLOAD_URL_SUFFIX = "/monitor/collect/c/logcollect";
    private static final String JAVA_CRASH_URL = "https://apmplus.volces.com/monitor/collect/c/crash";
    public static final String JAVA_URL_SUFFIX = "/monitor/collect/c/crash";
    private static final long LAUNCH_CRASH_INTERVAL = 8000;
    private static final String LAUNCH_CRASH_URL = "https://apmplus.volces.com/monitor/collect/c/exception/dump_collection";
    public static final String LAUNCH_URL_SUFFIX = "/monitor/collect/c/exception/dump_collection";
    public static final String LOG_TYPE_ALL_STACK = "npth_enable_all_thread_stack";
    private static final String NATIVE_CRASH_URL = "https://apmplus.volces.com/monitor/collect/c/native_bin_crash";
    private static final String NATIVE_MEM_URL = "https://apmplus.volces.com/monitor/collect/c/rapheal_file_collect";
    public static final String NATIVE_URL_SUFFIX = "/monitor/collect/c/native_bin_crash";
    public static final String PORTRAIT_UPLOAD_URL_SUFFIX = "/monitor/collect/c/crash_portrait";
    private ThreadPoolExecutor mThreadPoolExecutor;
    private boolean reportErrorEnable = true;
    private String mNativeMemUrl = NATIVE_MEM_URL;
    private String mCoreDumpUrl = CORE_DUMP_URL;
    private String mJavaCrashUploadUrl = JAVA_CRASH_URL;
    private String mLaunchCrashUploadUrl = LAUNCH_CRASH_URL;
    private String mExceptionUploadUrl = EXCEPTION_URL;
    private String mConfigUrl = CONFIG_URL;
    private String mNativeCrashUploadUrl = "https://apmplus.volces.com/monitor/collect/c/native_bin_crash";
    private String mAlogUploadUrl = ALOG_UPLOAD_URL;
    private String mAsanReportUploadUrl = "https://apmplus.volces.com/monitor/collect/c/native_bin_crash";
    private String mFileUploadUrl = FILE_UPLOAD_URL;
    private String mCrashPortraitUploadUrl = CRASH_PORTRAIT_URL;
    private long mLaunchCrashInterval = LAUNCH_CRASH_INTERVAL;
    private com.apm.insight.d mEncryptImpl = new com.apm.insight.d() { // from class: com.apm.insight.runtime.ConfigManager.1
        @Override // com.apm.insight.d
        public byte[] a(byte[] bArr) {
            return com.apm.insight.o.h.a(bArr);
        }
    };
    private int mLogcatDumpCount = 512;
    private int mLogcatLevel = 1;
    private boolean mNativeCrashMiniDump = true;
    private boolean mEnsureEnable = true;
    private boolean mEnsureWithLogcat = false;
    private long mBlockMonitorInterval = 1000;
    private boolean mBlockMonitorEnable = false;
    private boolean mIsDebugMode = false;
    private boolean mEnableApmPlusLog = false;
    private boolean mRegisterJavaCrash = false;
    private boolean mJavaCrashEnable = true;
    private boolean mNativeCrashEnable = true;
    private boolean mANREnable = true;

    public static void setDefaultCommonParams(ICommonParams iCommonParams, Context context) {
        com.apm.insight.g.a(new d(context, iCommonParams));
    }

    public static void updateDid(final String str) {
        q.b().a(new Runnable() { // from class: com.apm.insight.runtime.ConfigManager.2
            @Override // java.lang.Runnable
            public void run() {
                com.apm.insight.g.c().a(str);
                com.apm.insight.m.b.d();
            }
        });
    }

    public String getAlogUploadUrl() {
        return this.mAlogUploadUrl;
    }

    public String getAsanReportUploadUrl() {
        return this.mAsanReportUploadUrl;
    }

    public long getBlockInterval() {
        return this.mBlockMonitorInterval;
    }

    public String getConfigUrl() {
        return this.mConfigUrl;
    }

    public String getCoreDumpUrl() {
        return this.mCoreDumpUrl;
    }

    public String getCrashPortraitUploadUrl() {
        return this.mCrashPortraitUploadUrl;
    }

    public com.apm.insight.d getEncryptImpl() {
        return this.mEncryptImpl;
    }

    public String getExceptionUploadUrl() {
        return this.mExceptionUploadUrl;
    }

    public String getFileUploadUrl() {
        return this.mFileUploadUrl;
    }

    public Set<String> getFilterThreadSet() {
        return com.apm.insight.o.k.a();
    }

    public String getJavaCrashUploadUrl() {
        return this.mJavaCrashUploadUrl;
    }

    public long getLaunchCrashInterval() {
        return this.mLaunchCrashInterval;
    }

    public String getLaunchCrashUploadUrl() {
        return this.mLaunchCrashUploadUrl;
    }

    public int getLogcatDumpCount() {
        return this.mLogcatDumpCount;
    }

    public int getLogcatLevel() {
        return this.mLogcatLevel;
    }

    public String getNativeCrashUploadUrl() {
        return this.mNativeCrashUploadUrl;
    }

    public String getNativeMemUrl() {
        return this.mNativeMemUrl;
    }

    public ThreadPoolExecutor getThreadPoolExecutor() {
        return this.mThreadPoolExecutor;
    }

    public boolean isAnrEnable() {
        return this.mANREnable;
    }

    public boolean isApmExists() {
        return com.apm.insight.n.a.c();
    }

    public boolean isApmPLusLogEnable() {
        return this.mEnableApmPlusLog;
    }

    public boolean isBlockMonitorEnable() {
        return this.mBlockMonitorEnable;
    }

    public boolean isCrashIgnored(final String str) {
        try {
            f fVar = new f() { // from class: com.apm.insight.runtime.ConfigManager.3
                @Override // com.apm.insight.runtime.f
                public Object a(String str2) {
                    return str2.equals(TKDownloadReason.KSAD_TK_MD5) ? str : super.a(str2);
                }
            };
            if (o.a("java_crash_ignore", fVar)) {
                return true;
            }
            if (!NetworkUtils.isNetworkAvailable(com.apm.insight.g.f())) {
                return false;
            }
            com.apm.insight.n.a.d();
            return o.a("java_crash_ignore", fVar);
        } catch (Throwable unused) {
            return false;
        }
    }

    public boolean isDebugMode() {
        return this.mIsDebugMode;
    }

    public boolean isEnsureEnable() {
        return this.mEnsureEnable;
    }

    public boolean isEnsureWithLogcat() {
        return this.mEnsureWithLogcat;
    }

    public boolean isJavaCrashEnable() {
        return this.mJavaCrashEnable;
    }

    public boolean isNativeCrashEnable() {
        return this.mNativeCrashEnable;
    }

    public boolean isNativeCrashMiniDump() {
        return this.mNativeCrashMiniDump;
    }

    public boolean isRegisterJavaCrashEnable() {
        return this.mRegisterJavaCrash;
    }

    public boolean isReportErrorEnable() {
        return this.reportErrorEnable;
    }

    public void setAlogUploadUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mAlogUploadUrl = str;
    }

    public void setAnrEnable(boolean z) {
        this.mANREnable = z;
    }

    public void setApmPLusLogEnable(boolean z) {
        this.mEnableApmPlusLog = z;
    }

    public void setBlockMonitorEnable(boolean z) {
        this.mBlockMonitorEnable = z;
    }

    public void setBlockMonitorInterval(long j) {
        this.mBlockMonitorInterval = j;
    }

    public void setConfigUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mConfigUrl = str;
    }

    public void setCrashPortraitUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mCrashPortraitUploadUrl = str;
    }

    public void setCurrentProcessName(String str) {
        com.apm.insight.o.a.a(str);
    }

    public void setDebugMode(boolean z) {
        this.mIsDebugMode = z;
    }

    public void setEncryptImpl(com.apm.insight.d dVar) {
        if (dVar != null) {
            this.mEncryptImpl = dVar;
        }
    }

    public void setEnsureEnable(boolean z) {
        this.mEnsureEnable = z;
    }

    public void setEnsureWithLogcat(boolean z) {
        this.mEnsureWithLogcat = z;
    }

    public void setFileUploadUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mCrashPortraitUploadUrl = str;
    }

    public void setJavaCrashEnable(boolean z) {
        this.mJavaCrashEnable = z;
    }

    public void setJavaCrashUploadUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mJavaCrashUploadUrl = str;
    }

    public void setLaunchCrashInterval(long j) {
        if (j > 0) {
            this.mLaunchCrashInterval = j;
        }
    }

    public void setLaunchCrashUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mExceptionUploadUrl = str;
        int iIndexOf = str.indexOf("//");
        this.mLaunchCrashUploadUrl = (iIndexOf == -1 ? new StringBuilder().append(str.substring(0, str.indexOf("/") + 1)) : new StringBuilder().append(str.substring(0, str.indexOf("/", iIndexOf + 2) + 1))).append("monitor/collect/c/exception/dump_collection").toString();
    }

    public void setLaunchCrashUrl2(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mLaunchCrashUploadUrl = str;
    }

    public void setLogcatDumpCount(int i) {
        if (i > 0) {
            this.mLogcatDumpCount = i;
        }
    }

    public void setLogcatLevel(int i) {
        if (i < 0 || i > 4) {
            return;
        }
        this.mLogcatLevel = i;
    }

    public void setNativeCrashEnable(boolean z) {
        this.mNativeCrashEnable = z;
    }

    public void setNativeCrashUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mNativeCrashUploadUrl = str;
    }

    public void setRegisterJavaCrashEnable(boolean z) {
        this.mRegisterJavaCrash = z;
    }

    public void setReportErrorEnable(boolean z) {
        this.reportErrorEnable = z;
    }

    public void setThreadPoolExecutor(ThreadPoolExecutor threadPoolExecutor) {
        this.mThreadPoolExecutor = threadPoolExecutor;
    }
}
