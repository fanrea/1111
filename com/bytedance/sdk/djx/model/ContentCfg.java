package com.bytedance.sdk.djx.model;

import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class ContentCfg {
    private int closeCacheUp;
    private int mArticleDetailRelatedNum;
    private int mClosePreload = 0;
    private CustomCateCfg mCustomCateCfg;
    private int mMinFlingDistance;
    private int mMinFlingVelocity;
    private double mMinScrollDistance;
    private int mPreloadExpire;
    private int mPreloadSize2G;
    private int mPreloadSize3G;
    private int mPreloadSize4G;
    private int mPreloadSizeOther;
    private int mPreloadSizeWifi;
    private int mSmallVideoCardSubNum;
    private int mVideoDetailRelatedNum;
    private int mVideoDetailRelatedTotal;

    public int getSmallVideoCardSubNum() {
        return this.mSmallVideoCardSubNum;
    }

    public void setSmallVideoCardSubNum(int i) {
        this.mSmallVideoCardSubNum = i;
    }

    public int getArticleDetailRelatedNum() {
        return this.mArticleDetailRelatedNum;
    }

    public void setArticleDetailRelatedNum(int i) {
        this.mArticleDetailRelatedNum = i;
    }

    public int getVideoDetailRelatedNum() {
        return this.mVideoDetailRelatedNum;
    }

    public void setVideoDetailRelatedNum(int i) {
        this.mVideoDetailRelatedNum = i;
    }

    public int getVideoDetailRelatedTotal() {
        return this.mVideoDetailRelatedTotal;
    }

    public void setVideoDetailRelatedTotal(int i) {
        this.mVideoDetailRelatedTotal = i;
    }

    public int getPreloadSizeWifi() {
        return this.mPreloadSizeWifi;
    }

    public void setPreloadSizeWifi(int i) {
        this.mPreloadSizeWifi = i;
    }

    public int getPreloadSize4G() {
        return this.mPreloadSize4G;
    }

    public void setPreloadSize4G(int i) {
        this.mPreloadSize4G = i;
    }

    public int getPreloadSize3G() {
        return this.mPreloadSize3G;
    }

    public void setPreloadSize3G(int i) {
        this.mPreloadSize3G = i;
    }

    public int getPreloadSize2G() {
        return this.mPreloadSize2G;
    }

    public void setPreloadSize2G(int i) {
        this.mPreloadSize2G = i;
    }

    public int getPreloadSizeOther() {
        return this.mPreloadSizeOther;
    }

    public void setPreloadSizeOther(int i) {
        this.mPreloadSizeOther = i;
    }

    public int getPreloadExpire() {
        return this.mPreloadExpire;
    }

    public void setPreloadExpire(int i) {
        this.mPreloadExpire = i;
    }

    public CustomCateCfg getCustomCateCfg() {
        return this.mCustomCateCfg;
    }

    public void setCustomCateCfg(CustomCateCfg customCateCfg) {
        this.mCustomCateCfg = customCateCfg;
    }

    public int getMinFlingDistance() {
        return this.mMinFlingDistance;
    }

    public void setMinFlingDistance(int i) {
        this.mMinFlingDistance = i;
    }

    public int getMinFlingVelocity() {
        return this.mMinFlingVelocity;
    }

    public void setMinFlingVelocity(int i) {
        this.mMinFlingVelocity = i;
    }

    public double getMinScrollDistance() {
        return this.mMinScrollDistance;
    }

    public void setMinScrollDistance(double d) {
        this.mMinScrollDistance = d;
    }

    public int getClosePreload() {
        return this.mClosePreload;
    }

    public void setClosePreload(int i) {
        this.mClosePreload = i;
    }

    public void setCloseCacheUp(int i) {
        this.closeCacheUp = i;
    }

    public int getCloseCacheUp() {
        return this.closeCacheUp;
    }

    public static class CustomCateCfg {
        private Map<String, Object> mSceneMap = new HashMap();

        public Map<String, Object> getSceneMap() {
            return this.mSceneMap;
        }

        public void setSceneMap(Map<String, Object> map) {
            this.mSceneMap = map;
        }
    }
}
