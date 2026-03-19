package com.alliance.ssp.ad.bean;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class RewardInfo {
    private int errorCode;
    private String errorMsg;
    private String extraInfo;
    private boolean isValid;
    private String rewardAmount;
    private String rewardName;
    private String transId;
    private String userId;

    public RewardInfo() {
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public String getExtraInfo() {
        return this.extraInfo;
    }

    public String getRewardAmount() {
        return this.rewardAmount;
    }

    public String getRewardName() {
        return this.rewardName;
    }

    public String getTransId() {
        return this.transId;
    }

    public String getUserId() {
        return this.userId;
    }

    public boolean isValid() {
        return this.isValid;
    }

    public void setErrorCode(int i) {
        this.errorCode = i;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public void setExtraInfo(String str) {
        this.extraInfo = str;
    }

    public void setRewardAmount(String str) {
        this.rewardAmount = str;
    }

    public void setRewardName(String str) {
        this.rewardName = str;
    }

    public void setTransId(String str) {
        this.transId = str;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public void setValid(boolean z) {
        this.isValid = z;
    }

    public RewardInfo(boolean z) {
        this.isValid = z;
    }
}
