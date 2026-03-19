package com.sigmob.windad;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public enum WindAdBiddingLossReason {
    LOSS_REASON_LOW_PRICE(2, "出价过低"),
    LOSS_REASON_RETURN_TIMEOUT(2000, "返回超时"),
    LOSS_REASON_RETURN_ERROR(2001, "广告素材格式错误");

    private final int a;
    private final String message;

    WindAdBiddingLossReason(int code, String message) {
        this.a = code;
        this.message = message;
    }

    public int getCode() {
        return this.a;
    }

    public String getMessage() {
        return this.message;
    }
}
