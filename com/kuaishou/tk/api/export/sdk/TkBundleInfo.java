package com.kuaishou.tk.api.export.sdk;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public class TkBundleInfo {
    public static final String BUNDLE_CACHE_DISK = "DISK";
    public static final String BUNDLE_CACHE_MEMORY = "MEMORY";
    public static final String BUNDLE_CACHE_MEMORY_WITH_JS_STRING = "TKMEMORY";
    public static final String BUNDLE_CACHE_NETWORK = "NETWORK";
    public static final String BUNDLE_CACHE_UNKNOWN = "UNKNOWN";
    public static final String BUNDLE_SOURCE_PRESET = "PRESET";
    public static final String BUNDLE_SOURCE_REMOTE = "REMOTE";
    public static final String BUNDLE_SOURCE_UNKNOWN = "UNKNOWN";
    public String mBundleCacheType;
    public String mBundleId;
    public String mBundleSource;
    public String mFilePath;
    public String mScript;
    public long mTaskId;
    public String mVersion;
    public int mVersionCode;

    public TkBundleInfo(String str, String str2, String str3, int i, String str4, long j, String str5, String str6) {
        this.mBundleCacheType = "UNKNOWN";
        this.mBundleSource = "UNKNOWN";
        this.mScript = str;
        this.mBundleId = str2;
        this.mVersion = str3;
        this.mVersionCode = i;
        this.mFilePath = str4;
        this.mTaskId = j;
        this.mBundleCacheType = str5;
        this.mBundleSource = str6;
    }
}
