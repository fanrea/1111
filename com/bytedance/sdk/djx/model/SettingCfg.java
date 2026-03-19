package com.bytedance.sdk.djx.model;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class SettingCfg {
    private Commerce mCommerce;
    private ContentCfg mContentCfg;
    private FeaturesCfg mFeaturesCfg;
    private LogCfg mLogCfg;
    private long mUpdateTime;
    private VideoCfg mVideo;

    public Commerce getCommerce() {
        return this.mCommerce;
    }

    public void setCommerce(Commerce commerce) {
        this.mCommerce = commerce;
    }

    public VideoCfg getVideo() {
        return this.mVideo;
    }

    public void setVideo(VideoCfg videoCfg) {
        this.mVideo = videoCfg;
    }

    public long getUpdateTime() {
        return this.mUpdateTime;
    }

    public void setUpdateTime(long j) {
        this.mUpdateTime = j;
    }

    public FeaturesCfg getFeaturesCfg() {
        return this.mFeaturesCfg;
    }

    public void setFeaturesCfg(FeaturesCfg featuresCfg) {
        this.mFeaturesCfg = featuresCfg;
    }

    public ContentCfg getContentCfg() {
        return this.mContentCfg;
    }

    public void setContentCfg(ContentCfg contentCfg) {
        this.mContentCfg = contentCfg;
    }

    public LogCfg getLogCfg() {
        return this.mLogCfg;
    }

    public void setLogCfg(LogCfg logCfg) {
        this.mLogCfg = logCfg;
    }
}
