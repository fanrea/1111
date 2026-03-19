package com.bytedance.pangle;

import com.bytedance.pangle.log.IZeusLogger;
import com.bytedance.pangle.log.IZeusReporter;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class GlobalParam {
    private static GlobalParam mInstance;
    private boolean mCheckPermission;
    private boolean mCloseCrashMonitor;
    private boolean mCloseFlipped;
    private boolean mCloseHookHuaweiOnInit;
    private String mDid;
    private File mDownloadDir;
    private boolean mFastDex2oat;
    private String mHostUrl;
    private IZeusLogger mLogger;
    private boolean hasInit = false;
    private boolean mDebug = true;
    private IZeusReporter mReporter = new IZeusReporter() { // from class: com.bytedance.pangle.GlobalParam.1
        @Override // com.bytedance.pangle.log.IZeusReporter
        public void report(String str, JSONObject jSONObject) {
        }

        @Override // com.bytedance.pangle.log.IZeusReporter
        public void saveRecord(String str, String str2) {
        }
    };
    private int mInstallThreads = 1;
    private boolean mCheckMatchHostAbi = true;
    private final Map<String, String> mRequestHeader = new HashMap();
    private final Map<String, Boolean> unInstallPluginWhenHostChange = new HashMap();
    private final Map<String, Map<String, String>> mCustomTag = new HashMap();
    private final Map<String, String> mSignature = new HashMap();
    private long mDexOptDelayTime = 15000;
    private boolean mPostBgDexOptByInit = true;
    private boolean mAutoFetch = true;
    private final Map<String, Integer> mRemoveApkEntry = new HashMap();
    private boolean mCloseBgDex2oat = false;

    public static GlobalParam getInstance() {
        if (mInstance == null) {
            synchronized (GlobalParam.class) {
                if (mInstance == null) {
                    mInstance = new GlobalParam();
                }
            }
        }
        return mInstance;
    }

    public void setDebug(boolean z) {
        ensureInit();
        this.mDebug = z;
    }

    public void postBgDexOptByInit(boolean z) {
        ensureInit();
        this.mPostBgDexOptByInit = this.mPostBgDexOptByInit;
    }

    public boolean isPostBgDexOptByInit() {
        return this.mPostBgDexOptByInit;
    }

    public void setHostUrl(String str) {
        ensureInit();
        this.mHostUrl = str;
    }

    public void closeCrashMonitor(boolean z) {
        ensureInit();
        this.mCloseCrashMonitor = z;
    }

    public void closeHookHuaweiOnInit(boolean z) {
        ensureInit();
        this.mCloseHookHuaweiOnInit = z;
    }

    public boolean isCloseCrashMonitor() {
        return this.mCloseCrashMonitor;
    }

    public boolean closeHookHuaweiOnInit() {
        return this.mCloseHookHuaweiOnInit;
    }

    public void setReporter(IZeusReporter iZeusReporter) {
        ensureInit();
        if (iZeusReporter != null) {
            this.mReporter = iZeusReporter;
        }
    }

    public void setLogger(IZeusLogger iZeusLogger) {
        ensureInit();
        this.mLogger = iZeusLogger;
    }

    public void setDownloadDir(File file) {
        ensureInit();
        this.mDownloadDir = file;
    }

    public void setInstallThreads(int i) {
        ensureInit();
        this.mInstallThreads = i;
    }

    public void addRequestHeader(String str, String str2) {
        ensureInit();
        this.mRequestHeader.put(str, str2);
    }

    public void setUnInstallPluginWhenHostChange(String str, boolean z) {
        ensureInit();
        this.unInstallPluginWhenHostChange.put(str, Boolean.valueOf(z));
    }

    public boolean unInstallPluginWhenHostChange(String str) {
        Boolean bool = this.unInstallPluginWhenHostChange.get(str);
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public void setDexOptDelayTime(long j) {
        ensureInit();
        this.mDexOptDelayTime = j;
    }

    public void setCloseFlipped(boolean z) {
        ensureInit();
        this.mCloseFlipped = z;
    }

    public void setDid(String str) {
        this.mDid = str;
    }

    public boolean isCloseFlipped() {
        return this.mCloseFlipped;
    }

    public boolean checkMatchHostAbi() {
        return this.mCheckMatchHostAbi;
    }

    public void setCheckMatchHostAbi(boolean z) {
        this.mCheckMatchHostAbi = z;
    }

    public boolean checkPermission() {
        return this.mCheckPermission;
    }

    public void setCheckPermission(boolean z) {
        this.mCheckPermission = z;
    }

    public void setCustomTag(String str, Map<String, String> map) {
        this.mCustomTag.put(str, map);
    }

    public boolean isDebug() {
        return this.mDebug;
    }

    public boolean isFastDex2oat() {
        return this.mFastDex2oat;
    }

    public void setFastDex2oat(boolean z) {
        this.mFastDex2oat = z;
    }

    public void setSignature(String str, String str2) {
        ensureInit();
        this.mSignature.put(str, str2);
    }

    public void closeBgDex2oat(boolean z) {
        ensureInit();
        this.mCloseBgDex2oat = z;
    }

    public boolean isCloseBgDex2oat() {
        return this.mCloseBgDex2oat;
    }

    public int getInstallThreads() {
        return this.mInstallThreads;
    }

    public String getHostUrl() {
        return this.mHostUrl;
    }

    public IZeusReporter getReporter() {
        return this.mReporter;
    }

    public File getDownloadDir() {
        return this.mDownloadDir;
    }

    public IZeusLogger getLogger() {
        return this.mLogger;
    }

    public Map<String, String> getRequestHeader() {
        return this.mRequestHeader;
    }

    public String getDid() {
        return this.mDid;
    }

    public long getDexOptDelayTime() {
        return this.mDexOptDelayTime;
    }

    public Map<String, String> getCustomTag(String str) {
        return this.mCustomTag.get(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void removeApkEntry(String str, boolean z, boolean z2) {
        ensureInit();
        int i = z;
        if (z2) {
            i = (z ? 1 : 0) | 2;
        }
        this.mRemoveApkEntry.put(str, Integer.valueOf(i));
    }

    public int getRemoveApkEntryFlag(String str) {
        Integer num = this.mRemoveApkEntry.get(str);
        if (num == null) {
            num = 0;
        }
        return num.intValue();
    }

    public void init() {
        this.hasInit = true;
    }

    private void ensureInit() {
        if (this.hasInit) {
            throw new RuntimeException();
        }
    }

    public String getSignature(String str) {
        return this.mSignature.get(str);
    }

    public void setAutoFetch(boolean z) {
        ensureInit();
        this.mAutoFetch = z;
    }

    public boolean autoFetch() {
        return this.mAutoFetch;
    }
}
