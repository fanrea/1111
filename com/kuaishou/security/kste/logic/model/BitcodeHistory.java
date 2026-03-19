package com.kuaishou.security.kste.logic.model;

import android.os.ConditionVariable;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class BitcodeHistory {
    private int bits;
    private String fileMd5;
    private boolean isDoLoaded;
    private boolean loadFinishStatus;
    private boolean singleBCUpdateRetry;
    private ConditionVariable singleConditionVariable;
    private int version;
    private String vmBcPath;
    private String vmBizId;

    public BitcodeHistory(String str, int i, int i2, String str2, String str3, boolean z, boolean z2, ConditionVariable conditionVariable, boolean z3) {
        this.vmBizId = str;
        this.version = i;
        this.bits = i2;
        this.fileMd5 = str2;
        this.vmBcPath = str3;
        this.loadFinishStatus = z;
        this.isDoLoaded = z2;
        this.singleConditionVariable = conditionVariable;
        this.singleBCUpdateRetry = z3;
    }

    public final String component1() {
        return this.vmBizId;
    }

    public final int component2() {
        return this.version;
    }

    public final int component3() {
        return this.bits;
    }

    public final String component4() {
        return this.fileMd5;
    }

    public final String component5() {
        return this.vmBcPath;
    }

    public final boolean component6() {
        return this.loadFinishStatus;
    }

    public final boolean component7() {
        return this.isDoLoaded;
    }

    public final ConditionVariable component8() {
        return this.singleConditionVariable;
    }

    public final boolean component9() {
        return this.singleBCUpdateRetry;
    }

    public final BitcodeHistory copy(String str, int i, int i2, String str2, String str3, boolean z, boolean z2, ConditionVariable conditionVariable, boolean z3) {
        return new BitcodeHistory(str, i, i2, str2, str3, z, z2, conditionVariable, z3);
    }

    public final int getBits() {
        return this.bits;
    }

    public final String getFileMd5() {
        return this.fileMd5;
    }

    public final boolean getLoadFinishStatus() {
        return this.loadFinishStatus;
    }

    public final boolean getSingleBCUpdateRetry() {
        return this.singleBCUpdateRetry;
    }

    public final ConditionVariable getSingleConditionVariable() {
        return this.singleConditionVariable;
    }

    public final int getVersion() {
        return this.version;
    }

    public final String getVmBcPath() {
        return this.vmBcPath;
    }

    public final String getVmBizId() {
        return this.vmBizId;
    }

    public final boolean isDoLoaded() {
        return this.isDoLoaded;
    }

    public final void setBits(int i) {
        this.bits = i;
    }

    public final void setDoLoaded(boolean z) {
        this.isDoLoaded = z;
    }

    public final void setFileMd5(String str) {
        this.fileMd5 = str;
    }

    public final void setLoadFinishStatus(boolean z) {
        this.loadFinishStatus = z;
    }

    public final void setSingleBCUpdateRetry(boolean z) {
        this.singleBCUpdateRetry = z;
    }

    public final void setSingleConditionVariable(ConditionVariable conditionVariable) {
        this.singleConditionVariable = conditionVariable;
    }

    public final void setVersion(int i) {
        this.version = i;
    }

    public final void setVmBcPath(String str) {
        this.vmBcPath = str;
    }

    public final void setVmBizId(String str) {
        this.vmBizId = str;
    }

    public final String toString() {
        return "BitcodeHistory(vmBizId=" + this.vmBizId + ", version=" + this.version + ", bits=" + this.bits + ", fileMd5=" + this.fileMd5 + ", vmBcPath=" + this.vmBcPath + ", loadFinishStatus=" + this.loadFinishStatus + ", isDoLoaded=" + this.isDoLoaded + ", singleConditionVariable=" + this.singleConditionVariable + ", singleBCUpdateRetry=" + this.singleBCUpdateRetry + ")";
    }
}
