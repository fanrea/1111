package com.bytedance.android.metrics;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class Params {
    private ActionType actionType;
    private String anchorId;
    private long duration;
    private EnterFromMerge enterFromMerge;
    private EnterMethod enterMethod;
    private String requestId;
    private long roomId;

    public Params(long j, String str, String str2, EnterFromMerge enterFromMerge, EnterMethod enterMethod, ActionType actionType, long j2) {
        this.roomId = j;
        this.anchorId = str;
        this.requestId = str2;
        this.enterFromMerge = enterFromMerge;
        this.enterMethod = enterMethod;
        this.actionType = actionType;
        this.duration = j2;
    }

    public long getRoomId() {
        return this.roomId;
    }

    public void setRoomId(long j) {
        this.roomId = j;
    }

    public String getAnchorId() {
        return this.anchorId;
    }

    public void setAnchorId(String str) {
        this.anchorId = str;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public void setRequestId(String str) {
        this.requestId = str;
    }

    public EnterFromMerge getEnterFromMerge() {
        return this.enterFromMerge;
    }

    public void setEnterFromMerge(EnterFromMerge enterFromMerge) {
        this.enterFromMerge = enterFromMerge;
    }

    public EnterMethod getEnterMethod() {
        return this.enterMethod;
    }

    public void setEnterMethod(EnterMethod enterMethod) {
        this.enterMethod = enterMethod;
    }

    public ActionType getActionType() {
        return this.actionType;
    }

    public void setActionType(ActionType actionType) {
        this.actionType = actionType;
    }

    public long getDuration() {
        return this.duration;
    }

    public void setDuration(long j) {
        this.duration = j;
    }
}
