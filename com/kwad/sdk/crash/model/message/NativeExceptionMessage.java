package com.kwad.sdk.crash.model.message;

import com.kwad.sdk.utils.aa;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class NativeExceptionMessage extends ExceptionMessage {
    private static final long serialVersionUID = -7790706181005700630L;
    public String mFingerprint = "Unknown";
    public String mRevision = "Unknown";
    public String mRegister = "Unknown";
    public String mSignal = "Unknown";
    public String mCode = "Unknown";
    public String mManuallyKill = "Unknown";
    public String mFaultAddr = "Unknown";
    public String mAbortMsg = "";
    public String mNativeBacktrace = "";
    public String mJavaBacktrace = "";
    public String mScudoAbortMsg = "";
    public String mGwpAsanCause = "";
    public String mGwpAsanAllocationThread = "";
    public String mGwpAsanAllocationBacktrace = "";
    public String mGwpAsanDeallocationThread = "";
    public String mGwpAsanDeallocationBacktrace = "";

    @Override // com.kwad.sdk.crash.model.message.ExceptionMessage
    protected final String getTypePrefix() {
        return "NATIVE_";
    }

    public final String getGwpAsanAllocationThread() {
        return this.mGwpAsanAllocationThread;
    }

    public final void setGwpAsanAllocationThread(String str) {
        this.mGwpAsanAllocationThread = str;
    }

    public final String getGwpAsanAllocationBacktrace() {
        return this.mGwpAsanAllocationBacktrace;
    }

    public final void setGwpAsanAllocationBacktrace(String str) {
        this.mGwpAsanAllocationBacktrace = str;
    }

    public final String getGwpAsanDeallocationThread() {
        return this.mGwpAsanDeallocationThread;
    }

    public final void setGwpAsanDeallocationThread(String str) {
        this.mGwpAsanDeallocationThread = str;
    }

    public final String getGwpAsanDeallocationBacktrace() {
        return this.mGwpAsanDeallocationBacktrace;
    }

    public final void setGwpAsanDeallocationBacktrace(String str) {
        this.mGwpAsanDeallocationBacktrace = str;
    }

    public NativeExceptionMessage() {
        this.mExceptionType = 4;
    }

    @Override // com.kwad.sdk.crash.model.message.ExceptionMessage, com.kwad.sdk.core.b
    public final void parseJson(JSONObject jSONObject) {
        super.parseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        this.mFingerprint = jSONObject.optString("mFingerprint");
        this.mRevision = jSONObject.optString("mRevision");
        this.mRegister = jSONObject.optString("mRegister");
        this.mSignal = jSONObject.optString("mSignal");
        this.mCode = jSONObject.optString("mCode");
        this.mManuallyKill = jSONObject.optString("mManuallyKill");
        this.mFaultAddr = jSONObject.optString("mFaultAddr");
        this.mAbortMsg = jSONObject.optString("mAbortMsg");
        this.mJavaBacktrace = jSONObject.optString("mJavaBacktrace");
        this.mNativeBacktrace = jSONObject.optString("mNativeBacktrace");
        this.mGwpAsanAllocationThread = jSONObject.optString("mGwpAsanAllocationThread");
        this.mGwpAsanAllocationBacktrace = jSONObject.optString("mGwpAsanAllocationBacktrace");
        this.mGwpAsanDeallocationThread = jSONObject.optString("mGwpAsanDeallocationThread");
        this.mGwpAsanDeallocationBacktrace = jSONObject.optString("mGwpAsanDeallocationBacktrace");
    }

    @Override // com.kwad.sdk.crash.model.message.ExceptionMessage, com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject json = super.toJson();
        aa.putValue(json, "mFingerprint", this.mFingerprint);
        aa.putValue(json, "mRevision", this.mRevision);
        aa.putValue(json, "mRegister", this.mRegister);
        aa.putValue(json, "mSignal", this.mSignal);
        aa.putValue(json, "mCode", this.mCode);
        aa.putValue(json, "mManuallyKill", this.mManuallyKill);
        aa.putValue(json, "mFaultAddr", this.mFaultAddr);
        aa.putValue(json, "mAbortMsg", this.mAbortMsg);
        aa.putValue(json, "mNativeBacktrace", this.mNativeBacktrace);
        aa.putValue(json, "mJavaBacktrace", this.mJavaBacktrace);
        aa.putValue(json, "mGwpAsanAllocationThread", this.mGwpAsanAllocationThread);
        aa.putValue(json, "mGwpAsanAllocationBacktrace", this.mGwpAsanAllocationBacktrace);
        aa.putValue(json, "mGwpAsanDeallocationThread", this.mGwpAsanDeallocationThread);
        aa.putValue(json, "mGwpAsanDeallocationBacktrace", this.mGwpAsanDeallocationBacktrace);
        return json;
    }

    public final String getFingerprint() {
        return this.mFingerprint;
    }

    public final void setFingerprint(String str) {
        this.mFingerprint = str;
    }

    public final String getRevision() {
        return this.mRevision;
    }

    public final void setRevision(String str) {
        this.mRevision = str;
    }

    public final String getRegister() {
        return this.mRegister;
    }

    public final void setRegister(String str) {
        this.mRegister = str;
    }

    public final String getSignal() {
        return this.mSignal;
    }

    public final void setSignal(String str) {
        this.mSignal = str;
    }

    public final String getCode() {
        return this.mCode;
    }

    public final void setCode(String str) {
        this.mCode = str;
    }

    public final String getManuallyKill() {
        return this.mManuallyKill;
    }

    public final void setManuallyKill(String str) {
        this.mManuallyKill = str;
    }

    public final String getFaultAddr() {
        return this.mFaultAddr;
    }

    public final void setFaultAddr(String str) {
        this.mFaultAddr = str;
    }

    public final String getAbortMsg() {
        return this.mAbortMsg;
    }

    public final void setAbortMsg(String str) {
        this.mAbortMsg = str;
    }

    public final String getNativeBacktrace() {
        return this.mNativeBacktrace;
    }

    public final void setNativeBacktrace(String str) {
        this.mNativeBacktrace = str;
    }

    public final String getJavaBacktrace() {
        return this.mJavaBacktrace;
    }

    public final void setJavaBacktrace(String str) {
        this.mJavaBacktrace = str;
    }
}
