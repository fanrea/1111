package com.bytedance.android.metrics;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class LiveMetricsBuilder {
    private long roomId = 0;
    private String anchorId = "";
    private String requestId = "";
    private EnterFromMerge enterFromMerge = EnterFromMerge.NO_VALUE;
    private EnterMethod enterMethod = EnterMethod.NO_VALUE;
    private ActionType actionType = ActionType.CLICK;
    private long duration = 0;

    public LiveMetricsBuilder roomId(long j) {
        this.roomId = j;
        return this;
    }

    public LiveMetricsBuilder anchorId(String str) {
        this.anchorId = str;
        return this;
    }

    public LiveMetricsBuilder requestId(String str) {
        this.requestId = str;
        return this;
    }

    public LiveMetricsBuilder enterFromMerge(EnterFromMerge enterFromMerge) {
        this.enterFromMerge = enterFromMerge;
        return this;
    }

    public LiveMetricsBuilder enterMethod(EnterMethod enterMethod) {
        this.enterMethod = enterMethod;
        return this;
    }

    public LiveMetricsBuilder actionType(ActionType actionType) {
        this.actionType = actionType;
        return this;
    }

    public LiveMetricsBuilder duration(long j) {
        this.duration = j;
        return this;
    }

    public Params build() {
        return new Params(this.roomId, this.anchorId, this.requestId, this.enterFromMerge, this.enterMethod, this.actionType, this.duration);
    }
}
