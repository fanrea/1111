package com.bytedance.sdk.djx.net.token;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class Token {
    private long mExpire;
    private boolean mIsSyncHistory;
    private long mMin;
    private String mToken;
    private UserConfig mUserConfig;

    public Token(String str, long j, long j2, UserConfig userConfig, boolean z) {
        this.mToken = str;
        this.mExpire = j;
        this.mMin = j2;
        this.mUserConfig = userConfig;
        this.mIsSyncHistory = z;
    }

    public boolean isSyncHistory() {
        return this.mIsSyncHistory;
    }

    public String getToken() {
        return this.mToken;
    }

    public void setToken(String str) {
        this.mToken = str;
    }

    public long getExpire() {
        return this.mExpire;
    }

    public void setExpire(long j) {
        this.mExpire = j;
    }

    public long getMin() {
        return this.mMin;
    }

    public void setMin(long j) {
        this.mMin = j;
    }

    public UserConfig getUserConfig() {
        return this.mUserConfig;
    }

    public void setUserConfig(UserConfig userConfig) {
        this.mUserConfig = userConfig;
    }
}
