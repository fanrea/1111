package com.kwad.sdk.i;

import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class g {
    private String NJ;
    private String appId;
    private String bAx;
    private String bAy;
    private String bFu;
    private String bGp;
    private Map<String, String> beJ;
    private JSONObject bvE;
    private JSONObject cfD;
    private boolean cfE;
    private String sdkVersion;

    private g() {
    }

    public static g alq() {
        return new g();
    }

    public final g hy(String str) {
        this.appId = str;
        return this;
    }

    public final g hz(String str) {
        this.sdkVersion = str;
        return this;
    }

    public final g hA(String str) {
        this.bAy = str;
        return this;
    }

    public final g hB(String str) {
        this.NJ = str;
        return this;
    }

    public final g hC(String str) {
        this.bGp = str;
        return this;
    }

    public final g hD(String str) {
        this.bAx = str;
        return this;
    }

    public final g p(JSONObject jSONObject) {
        this.cfD = jSONObject;
        return this;
    }

    public final g di(boolean z) {
        this.cfE = z;
        return this;
    }

    public final g hE(String str) {
        this.bFu = str;
        return this;
    }

    public final g k(Map<String, String> map) {
        this.beJ = map;
        return this;
    }

    public final g q(JSONObject jSONObject) {
        this.bvE = jSONObject;
        return this;
    }

    public final String getAppId() {
        return this.appId;
    }

    public final String getSdkVersion() {
        return this.sdkVersion;
    }

    public final String getOaid() {
        return this.bAy;
    }

    public final String getDeviceId() {
        return this.NJ;
    }

    public final String getAndroidId() {
        return this.bGp;
    }

    public final String getImei() {
        return this.bAx;
    }

    public final JSONObject alr() {
        return this.cfD;
    }

    public final boolean als() {
        return this.cfE;
    }

    public final String alt() {
        return this.bFu;
    }

    public final Map<String, String> getRequestHeader() {
        return this.beJ;
    }

    public final JSONObject alu() {
        return this.bvE;
    }
}
