package com.sigmob.sdk.base.models;

import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.j;
import com.sigmob.windad.Splash.WindSplashAdRequest;
import com.sigmob.windad.WindAdRequest;
import com.sigmob.windad.newInterstitial.WindNewInterstitialAdRequest;
import com.sigmob.windad.rewardVideo.WindRewardAdRequest;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class LoadAdRequest implements Serializable {
    private String ad_scene;
    private String ad_scene_desc;
    private String ad_scene_id;
    private String adx_id;
    private int bidFloor;
    private String bidToken;
    private String currency;
    private boolean disableAutoHideAd;
    private boolean enable_keep_on;
    private boolean enable_screen_lock_displayad;
    private boolean isExpired;
    private boolean isHalfInterstitial;
    private String last_campid;
    private String last_crid;
    private final int mAdtype;
    private String mLoadId;
    private Map<String, String> mOptions;
    private final String mPlacementId;
    private final String mUserId;
    private String originPrice;
    private String originVid;
    private String requestId;
    private String traceId;
    private int request_scene_type = j.NormalRequest.a();
    private int ad_count = 1;

    public LoadAdRequest(WindAdRequest adRequest) {
        boolean zIsEnableScreenLockDisPlayAd;
        this.mUserId = adRequest.getUserId();
        this.mLoadId = adRequest.getLoadId();
        this.adx_id = adRequest.getAdxId();
        SigmobLog.i("adx_id:" + adRequest.getAdxId());
        this.mAdtype = adRequest.getAdType();
        this.isHalfInterstitial = adRequest.isHalfInterstitial();
        this.mPlacementId = adRequest.getPlacementId();
        if (adRequest instanceof WindSplashAdRequest) {
            this.disableAutoHideAd = ((WindSplashAdRequest) adRequest).isDisableAutoHideAd();
        } else {
            if (adRequest instanceof WindRewardAdRequest) {
                WindRewardAdRequest windRewardAdRequest = (WindRewardAdRequest) adRequest;
                this.enable_keep_on = windRewardAdRequest.isEnableKeepOn();
                zIsEnableScreenLockDisPlayAd = windRewardAdRequest.isEnableScreenLockDisPlayAd();
            } else if (adRequest instanceof WindNewInterstitialAdRequest) {
                WindNewInterstitialAdRequest windNewInterstitialAdRequest = (WindNewInterstitialAdRequest) adRequest;
                this.enable_keep_on = windNewInterstitialAdRequest.isEnableKeepOn();
                zIsEnableScreenLockDisPlayAd = windNewInterstitialAdRequest.isEnableScreenLockDisPlayAd();
            }
            this.enable_screen_lock_displayad = zIsEnableScreenLockDisPlayAd;
        }
        if (adRequest.hasOptions()) {
            this.mOptions = new HashMap();
            for (String str : adRequest.getOptions().keySet()) {
                Object obj = adRequest.getOptions().get(str);
                this.mOptions.put(str, obj instanceof String ? (String) obj : obj == null ? "" : obj.toString());
            }
        }
    }

    public int getAdCount() {
        return this.ad_count;
    }

    public String getAdSceneDesc() {
        return this.ad_scene_desc;
    }

    public String getAdSceneId() {
        return this.ad_scene_id;
    }

    public int getAdType() {
        return this.mAdtype;
    }

    public String getAdx_id() {
        return this.adx_id;
    }

    public int getBidFloor() {
        return this.bidFloor;
    }

    public String getBidToken() {
        return this.bidToken;
    }

    public String getCurrency() {
        return this.currency;
    }

    public String getLastCampid() {
        return this.last_campid;
    }

    public String getLastCrid() {
        return this.last_crid;
    }

    public String getLoadId() {
        return this.mLoadId;
    }

    public Map<String, String> getOptions() {
        return this.mOptions;
    }

    public String getOriginPrice() {
        return this.originPrice;
    }

    public String getOriginVid() {
        return this.originVid;
    }

    public String getPlacementId() {
        return this.mPlacementId;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public int getRequest_scene_type() {
        return this.request_scene_type;
    }

    public String getTraceId() {
        return this.traceId;
    }

    public String getUserId() {
        return this.mUserId;
    }

    public boolean isDisableAutoHideAd() {
        return this.disableAutoHideAd;
    }

    public boolean isEnable_keep_on() {
        return this.enable_keep_on;
    }

    public boolean isEnable_screen_lock_displayad() {
        return this.enable_screen_lock_displayad;
    }

    public boolean isExpired() {
        return this.isExpired;
    }

    public boolean isHalfInterstitial() {
        return this.isHalfInterstitial;
    }

    public void setAd_count(int ad_count) {
        this.ad_count = ad_count;
    }

    public void setAd_scene_desc(String ad_scene_desc) {
        this.ad_scene_desc = ad_scene_desc;
    }

    public void setAd_scene_id(String ad_scene_id) {
        this.ad_scene_id = ad_scene_id;
    }

    public void setAdx_id(String adxId) {
        this.adx_id = adxId;
        SigmobLog.i("new adx_id: " + this.adx_id);
    }

    public void setBidFloor(int bidFloor) {
        this.bidFloor = bidFloor;
    }

    public LoadAdRequest setBidToken(String bidToken) {
        this.bidToken = bidToken;
        return this;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setDisableAutoHideAd(boolean disableAutoHideAd) {
        this.disableAutoHideAd = disableAutoHideAd;
    }

    public LoadAdRequest setExpired(boolean expired) {
        this.isExpired = expired;
        return this;
    }

    public void setHalfInterstitial(boolean halfInterstitial) {
        this.isHalfInterstitial = halfInterstitial;
    }

    public LoadAdRequest setLastCampid(String last_campid) {
        this.last_campid = last_campid;
        return this;
    }

    public LoadAdRequest setLastCrid(String last_crid) {
        this.last_crid = last_crid;
        return this;
    }

    public LoadAdRequest setLoadId(String load_id) {
        this.mLoadId = load_id;
        return this;
    }

    public void setOptions(Map<String, String> map) {
        if (this.mOptions == null) {
            this.mOptions = new HashMap();
        }
        this.mOptions.putAll(map);
    }

    public void setOriginPrice(String originPrice) {
        this.originPrice = originPrice;
    }

    public void setOriginVid(String originVid) {
        this.originVid = originVid;
    }

    public LoadAdRequest setRequestId(String request_id) {
        this.requestId = request_id;
        return this;
    }

    public LoadAdRequest setRequest_scene_type(int request_scene_type) {
        this.request_scene_type = request_scene_type;
        return this;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }
}
