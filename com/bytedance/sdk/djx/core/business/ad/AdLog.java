package com.bytedance.sdk.djx.core.business.ad;

import com.baidu.mobads.container.adrequest.g;
import com.baidu.mobstat.forbes.Config;
import com.bytedance.sdk.djx.core.log.BLogAgent;
import com.bytedance.sdk.djx.core.log.ILogConst;
import com.bytedance.sdk.djx.model.Feed;
import com.bytedance.sdk.djx.utils.LG;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class AdLog {
    private static volatile AdLog sInstance;
    private boolean mIsFirstAdRequest = true;

    private AdLog() {
    }

    public static AdLog getInstance() {
        if (sInstance == null) {
            synchronized (AdLog.class) {
                if (sInstance == null) {
                    sInstance = new AdLog();
                }
            }
        }
        return sInstance;
    }

    public void sendAdFailed(AdKey adKey, int i, String str, String str2, boolean z) {
        if (AdUtils.isAdSdkExist()) {
            BLogAgent.build(getCategory(adKey), ILogConst.E_AD_LISTENER_FAIL, adKey == null ? null : adKey.getCommonParams()).putString(IDJXAd.AD_CODE_ID, getCodeId(adKey)).putLong("err_code", i).putString("err_msg", str).putString("ad_type", adKey == null ? null : adKey.getAdType()).putString(g.af, adKey == null ? null : adKey.getAdSource()).putString("ad_category", adKey != null ? adKey.getAdCategory() : null).putString(g.o, str2).putString("is_mix_ad", z ? "1" : "0").send();
            LG.d("sendAdFailed category = " + getCategory(adKey) + ", ad id = " + getCodeId(adKey));
        }
    }

    public void sendAdRequest(AdKey adKey, String str, boolean z) {
        if (AdUtils.isAdSdkExist()) {
            BLogAgent.build(getCategory(adKey), ILogConst.E_AD_REQUEST, adKey == null ? null : adKey.getCommonParams()).putString(IDJXAd.AD_CODE_ID, getCodeId(adKey)).putString(g.o, str).putString("is_mix_ad", z ? "1" : "0").putString("ad_type", adKey == null ? null : adKey.getAdType()).putString("ad_category", adKey == null ? null : adKey.getAdCategory()).putString(g.af, adKey != null ? adKey.getAdSource() : null).putInt("is_first", this.mIsFirstAdRequest ? 1 : 0).send();
            if (this.mIsFirstAdRequest) {
                this.mIsFirstAdRequest = false;
            }
            LG.d("sendAdRequest category = " + getCategory(adKey) + ", ad id = " + getCodeId(adKey));
        }
    }

    public void sendAdSuccess(AdKey adKey, int i, String str, boolean z) {
        if (AdUtils.isAdSdkExist()) {
            BLogAgent.build(getCategory(adKey), ILogConst.E_AD_LISTENER_SUCCESS, adKey == null ? null : adKey.getCommonParams()).putString(IDJXAd.AD_CODE_ID, getCodeId(adKey)).putString(g.o, str).putInt("num", i).putString("is_mix_ad", z ? "1" : "0").putString("ad_type", adKey == null ? null : adKey.getAdType()).putString(g.af, adKey == null ? null : adKey.getAdSource()).putString("ad_category", adKey != null ? adKey.getAdCategory() : null).send();
            LG.d("sendAdSuccess category = " + getCategory(adKey) + ", ad id = " + getCodeId(adKey));
        }
    }

    public void sendAdFillFail(AdKey adKey, int i, int i2, int i3, int i4) {
        if (AdUtils.isAdSdkExist()) {
            BLogAgent.build(getCategory(adKey), ILogConst.E_AD_FILL_FAIL, adKey == null ? null : adKey.getCommonParams()).putString(IDJXAd.AD_CODE_ID, getCodeId(adKey)).putInt(Config.TRACE_VISIT_FIRST, i).putInt("step", i2).putInt("step_pos", i3).putInt("index", i4).putString("ad_type", adKey == null ? null : adKey.getAdType()).putString(g.af, adKey != null ? adKey.getAdSource() : null).send();
            LG.d("sendAdFillFail category = " + getCategory(adKey) + ", ad id = " + getCodeId(adKey));
        }
    }

    public void sendAdShow(AdKey adKey, String str, boolean z, int i) {
        if (AdUtils.isAdSdkExist()) {
            BLogAgent bLogAgentPutString = BLogAgent.build(getCategory(adKey), "ad_show", adKey == null ? null : adKey.getCommonParams()).putString(IDJXAd.AD_CODE_ID, getCodeId(adKey)).putString(g.o, str).putString("ad_type", adKey == null ? null : adKey.getAdType()).putString(g.af, adKey == null ? null : adKey.getAdSource()).putString("ad_category", adKey != null ? adKey.getAdCategory() : null).putString("is_mix_ad", z ? "1" : "0");
            if (i >= 0) {
                bLogAgentPutString.putInt("ad_player", i);
            }
            bLogAgentPutString.send();
            LG.d("sendAdShow ad id = " + getCodeId(adKey));
        }
    }

    public void sendAdPlay(AdKey adKey, String str, boolean z, int i) {
        if (AdUtils.isAdSdkExist()) {
            BLogAgent bLogAgentPutString = BLogAgent.build(getCategory(adKey), ILogConst.E_AD_LISTENER_PLAY, adKey == null ? null : adKey.getCommonParams()).putString(IDJXAd.AD_CODE_ID, getCodeId(adKey)).putString("ad_type", adKey == null ? null : adKey.getAdType()).putString(g.af, adKey == null ? null : adKey.getAdSource()).putString("ad_category", adKey != null ? adKey.getAdCategory() : null).putString(g.o, str).putString("is_mix_ad", z ? "1" : "0");
            if (i >= 0) {
                bLogAgentPutString.putInt("ad_player", i);
            }
            bLogAgentPutString.send();
            LG.d("sendAdPlay ad id = " + getCodeId(adKey));
        }
    }

    public void sendAdPlayFail(AdKey adKey, String str, boolean z, int i) {
        if (AdUtils.isAdSdkExist()) {
            BLogAgent bLogAgentPutString = BLogAgent.build(getCategory(adKey), ILogConst.E_AD_LISTENER_PLAY_FAIL, adKey == null ? null : adKey.getCommonParams()).putString(IDJXAd.AD_CODE_ID, getCodeId(adKey)).putString(g.o, str).putString(g.af, adKey == null ? null : adKey.getAdSource()).putString("ad_type", adKey != null ? adKey.getAdType() : null).putString("is_mix_ad", z ? "1" : "0");
            if (i >= 0) {
                bLogAgentPutString.putInt("ad_player", i);
            }
            bLogAgentPutString.send();
            LG.d("sendAdPlay ad id = " + getCodeId(adKey));
        }
    }

    public void sendAdPause(AdKey adKey, String str, boolean z, int i) {
        if (AdUtils.isAdSdkExist()) {
            BLogAgent bLogAgentPutString = BLogAgent.build(getCategory(adKey), ILogConst.E_AD_LISTENER_PAUSE, adKey == null ? null : adKey.getCommonParams()).putString(IDJXAd.AD_CODE_ID, getCodeId(adKey)).putString(g.o, str).putString("ad_type", adKey == null ? null : adKey.getAdType()).putString(g.af, adKey == null ? null : adKey.getAdSource()).putString("ad_category", adKey != null ? adKey.getAdCategory() : null).putString("is_mix_ad", z ? "1" : "0");
            if (i >= 0) {
                bLogAgentPutString.putInt("ad_player", i);
            }
            bLogAgentPutString.send();
            LG.d("sendAdPause ad id = " + getCodeId(adKey));
        }
    }

    public void sendAdContinue(AdKey adKey, String str, boolean z, int i) {
        if (AdUtils.isAdSdkExist()) {
            BLogAgent bLogAgentPutString = BLogAgent.build(getCategory(adKey), ILogConst.E_AD_LISTENER_CONTINUE, adKey == null ? null : adKey.getCommonParams()).putString(IDJXAd.AD_CODE_ID, getCodeId(adKey)).putString("ad_type", adKey == null ? null : adKey.getAdType()).putString(g.af, adKey == null ? null : adKey.getAdSource()).putString("ad_category", adKey != null ? adKey.getAdCategory() : null).putString(g.o, str).putString("is_mix_ad", z ? "1" : "0");
            if (i >= 0) {
                bLogAgentPutString.putInt("ad_player", i);
            }
            bLogAgentPutString.send();
            LG.d("sendAdContinue ad id = " + getCodeId(adKey));
        }
    }

    public void sendAdComplete(AdKey adKey, String str, boolean z, int i) {
        if (AdUtils.isAdSdkExist()) {
            BLogAgent bLogAgentPutString = BLogAgent.build(getCategory(adKey), ILogConst.E_AD_LISTENER_COMPLETE, adKey == null ? null : adKey.getCommonParams()).putString(IDJXAd.AD_CODE_ID, getCodeId(adKey)).putString("ad_type", adKey == null ? null : adKey.getAdType()).putString(g.af, adKey == null ? null : adKey.getAdSource()).putString("ad_category", adKey != null ? adKey.getAdCategory() : null).putString(g.o, str).putString("is_mix_ad", z ? "1" : "0");
            if (i >= 0) {
                bLogAgentPutString.putInt("ad_player", i);
            }
            bLogAgentPutString.send();
            LG.d("sendAdComplete ad id = " + getCodeId(adKey));
        }
    }

    public void sendAdClick(AdKey adKey, String str, boolean z, int i, String str2) {
        if (AdUtils.isAdSdkExist()) {
            BLogAgent bLogAgentPutString = BLogAgent.build(getCategory(adKey), "ad_click", adKey == null ? null : adKey.getCommonParams()).putString(IDJXAd.AD_CODE_ID, getCodeId(adKey)).putString(g.o, str).putString("ad_type", adKey == null ? null : adKey.getAdType()).putString(g.af, adKey == null ? null : adKey.getAdSource()).putString("ad_category", adKey != null ? adKey.getAdCategory() : null).putString("is_mix_ad", z ? "1" : "0").putString("click_area", str2);
            if (i >= 0) {
                bLogAgentPutString.putInt("ad_player", i);
            }
            bLogAgentPutString.send();
            LG.d("sendAdClick ad id = " + getCodeId(adKey) + " click area = " + str2);
        }
    }

    public void sendEndcardShow(AdKey adKey, Feed feed) {
        BLogAgent.build(getCategory(adKey), ILogConst.E_AD_ENDCARD_SHOW, adKey == null ? null : adKey.getCommonParams()).putString(IDJXAd.AD_CODE_ID, getCodeId(adKey)).putString("request_id", feed != null ? feed.getReqId() : "").putString("ad_ad_id", feed != null ? feed.getAdId() : "").putString("ad_cid", feed != null ? feed.getCid() : "").send();
        LG.d("sendEndcardShow ad id = " + getCodeId(adKey));
    }

    public void sendEndcardBtn(AdKey adKey, Feed feed) {
        BLogAgent.build(getCategory(adKey), ILogConst.E_AD_ENDCARD_BTN_CLICK, adKey == null ? null : adKey.getCommonParams()).putString(IDJXAd.AD_CODE_ID, getCodeId(adKey)).putString("request_id", feed != null ? feed.getReqId() : "").putString("ad_ad_id", feed != null ? feed.getAdId() : "").putString("ad_cid", feed != null ? feed.getCid() : "").send();
        LG.d("sendEndcardBtn ad id = " + getCodeId(adKey));
    }

    public void sendEndcardReplay(AdKey adKey, Feed feed) {
        BLogAgent.build(getCategory(adKey), ILogConst.E_AD_ENDCARD_CLICK_REPLAY, adKey == null ? null : adKey.getCommonParams()).putString(IDJXAd.AD_CODE_ID, getCodeId(adKey)).putString("request_id", feed != null ? feed.getReqId() : "").putString("ad_ad_id", feed != null ? feed.getAdId() : "").putString("ad_cid", feed != null ? feed.getCid() : "").send();
        LG.d("sendEndcardReplay ad id = " + getCodeId(adKey));
    }

    public void sendEndcardSlideDown(AdKey adKey, Feed feed, boolean z) {
        BLogAgent.build(getCategory(adKey), ILogConst.E_AD_ENDCARD_SLIDE_DOWN, adKey == null ? null : adKey.getCommonParams()).putString(IDJXAd.AD_CODE_ID, getCodeId(adKey)).putString("request_id", feed != null ? feed.getReqId() : "").putString("ad_ad_id", feed != null ? feed.getAdId() : "").putString("ad_cid", feed != null ? feed.getCid() : "").putInt("ad_slidedown", z ? 1 : 0).send();
        LG.d("sendEndcardSlideDown ad id = " + getCodeId(adKey));
    }

    public void sendEndcardRefresh(AdKey adKey, Feed feed) {
        BLogAgent.build(getCategory(adKey), ILogConst.E_AD_ENDCARD_REFRESH, adKey == null ? null : adKey.getCommonParams()).putString(IDJXAd.AD_CODE_ID, getCodeId(adKey)).putString("request_id", feed != null ? feed.getReqId() : "").putString("ad_ad_id", feed != null ? feed.getAdId() : "").putString("ad_cid", feed != null ? feed.getCid() : "").send();
        LG.d("sendEndcardRefresh ad id = " + getCodeId(adKey));
    }

    public void sendShake(AdKey adKey, Feed feed, boolean z) {
        BLogAgent.build(getCategory(adKey), ILogConst.E_AD_SHAKE, adKey == null ? null : adKey.getCommonParams()).putString(IDJXAd.AD_CODE_ID, getCodeId(adKey)).putString("request_id", feed != null ? feed.getReqId() : "").putString("ad_ad_id", feed != null ? feed.getAdId() : "").putString("ad_cid", feed != null ? feed.getCid() : "").putString("action", z ? "shake" : "click").send();
        LG.d("sendShake ad id = " + getCodeId(adKey));
    }

    public void sendShakeShow(AdKey adKey, Feed feed) {
        BLogAgent.build(getCategory(adKey), ILogConst.E_AD_SHAKE_SHOW, adKey == null ? null : adKey.getCommonParams()).putString(IDJXAd.AD_CODE_ID, getCodeId(adKey)).putString("request_id", feed != null ? feed.getReqId() : "").putString("ad_ad_id", feed != null ? feed.getAdId() : "").putString("ad_cid", feed != null ? feed.getCid() : "").send();
        LG.d("sendShakeShow ad id = " + getCodeId(adKey));
    }

    private String getCategory(AdKey adKey) {
        return adKey == null ? "" : adKey.getCategory();
    }

    private String getCodeId(AdKey adKey) {
        return adKey == null ? "" : adKey.getCodeId();
    }
}
