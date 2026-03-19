package com.apm.applog;

import android.accounts.Account;
import android.text.TextUtils;
import android.util.Log;
import ca.da.ca.f;
import ca.da.ca.g;
import ca.da.ca.ja.c;
import ca.da.da.t;
import com.apm.applog.network.INetworkClient;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class InitConfig {
    public Map<String, String> A;
    public Account B;
    public boolean C;
    public INetworkClient D;
    public INetworkClient E;
    public boolean F;
    public boolean G;
    public boolean H;
    public boolean I;
    public boolean J;

    /* renamed from: K, reason: collision with root package name */
    public boolean f717K;
    public boolean L;
    public String M;
    public String N;
    public boolean O;
    public boolean P;
    public boolean Q;
    public boolean R;
    public List<String> S;
    public boolean T;
    public boolean U;
    public String V;
    public boolean W;
    public String X;
    public boolean Y;
    public boolean Z;
    public String a;
    public String b;
    public boolean c;
    public String d;
    public String e;
    public String f;
    public String g;
    public ILogger h;
    public String i;
    public String j;
    public boolean k;
    public boolean l;
    public boolean m;
    public int n;
    public String o;
    public boolean p;
    public String q;
    public UriConfig r;
    public String s;
    public String t;
    public int u;
    public int v;
    public int w;
    public String x;
    public String y;
    public String z;

    public interface a {
    }

    public InitConfig(String str, String str2) {
        this.c = true;
        this.l = false;
        this.n = 0;
        this.D = new c();
        this.F = true;
        this.H = false;
        this.I = false;
        this.J = false;
        this.f717K = true;
        this.L = true;
        this.N = null;
        this.O = false;
        this.P = false;
        this.Q = false;
        this.R = false;
        this.T = false;
        this.U = false;
        this.X = null;
        this.Y = false;
        this.Z = false;
        this.a = str;
        this.d = str2;
        if (TextUtils.isEmpty(str2)) {
            Log.e("InitConfig", "channel is empty, please check!!!");
        }
    }

    public boolean a() {
        return this.f717K;
    }

    public boolean autoStart() {
        return this.c;
    }

    public InitConfig clearABCacheOnUserChange(boolean z) {
        this.U = z;
        return this;
    }

    public void clearDidAndIid(String str) {
        this.C = true;
        this.e = str;
    }

    public InitConfig disableDeferredALink() {
        this.T = false;
        return this;
    }

    public Account getAccount() {
        return this.B;
    }

    public String getAid() {
        return this.a;
    }

    public String getAliyunUdid() {
        return this.j;
    }

    public boolean getAnonymous() {
        return this.k;
    }

    public String getAppImei() {
        return this.V;
    }

    public String getAppName() {
        return this.q;
    }

    public String getChannel() {
        return this.d;
    }

    public String getClearKey() {
        return this.e;
    }

    public Map<String, String> getCommonHeader() {
        return this.A;
    }

    public String getDbName() {
        String str = this.M;
        return str != null ? str : ca.ca.ca.ca.a.a("bd_tea_agent_").append(getAid()).toString();
    }

    public String getDid() {
        return this.X;
    }

    public String getGoogleAid() {
        return this.f;
    }

    public List<String> getH5BridgeAllowlist() {
        return this.S;
    }

    public a getIpcDataChecker() {
        return null;
    }

    public String getLanguage() {
        return this.g;
    }

    public boolean getLocalTest() {
        return this.l;
    }

    public ILogger getLogger() {
        return this.h;
    }

    public String getManifestVersion() {
        return this.x;
    }

    public int getManifestVersionCode() {
        return this.w;
    }

    public INetworkClient getNetworkClient() {
        INetworkClient iNetworkClient = this.E;
        return iNetworkClient != null ? iNetworkClient : this.D;
    }

    public boolean getNotReuqestSender() {
        return this.p;
    }

    public f getPicker() {
        return null;
    }

    public t getPreInstallCallback() {
        return null;
    }

    public int getProcess() {
        return this.n;
    }

    public String getRegion() {
        return this.i;
    }

    public String getReleaseBuild() {
        return this.o;
    }

    public g getSensitiveInfoProvider() {
        return null;
    }

    public String getSpName() {
        String str = this.N;
        return str != null ? str : ca.ca.ca.ca.a.a("applog_stats_").append(this.a).toString();
    }

    public String getToken() {
        return this.b;
    }

    public String getTweakedChannel() {
        return this.t;
    }

    public int getUpdateVersionCode() {
        return this.v;
    }

    public UriConfig getUriConfig() {
        return this.r;
    }

    public String getVersion() {
        return this.s;
    }

    public int getVersionCode() {
        return this.u;
    }

    public String getVersionMinor() {
        return this.y;
    }

    public String getZiJieCloudPkg() {
        return this.z;
    }

    public boolean isAbEnable() {
        return this.H;
    }

    public boolean isAntiCheatingEnable() {
        return this.J;
    }

    public boolean isAutoActive() {
        return this.F;
    }

    public boolean isAutoTrackEnabled() {
        return this.I;
    }

    public boolean isClearABCacheOnUserChange() {
        return this.U;
    }

    public boolean isClearDidAndIid() {
        return this.C;
    }

    public boolean isCongestionControlEnable() {
        return this.L;
    }

    public boolean isCustomLaunch() {
        return this.Y;
    }

    public boolean isDeferredALinkEnabled() {
        return this.T;
    }

    public boolean isEventFilterEnable() {
        return this.W;
    }

    public boolean isFixPageView() {
        return this.Z;
    }

    public boolean isH5BridgeEnable() {
        return this.Q;
    }

    public boolean isH5CollectEnable() {
        return this.R;
    }

    public boolean isImeiEnable() {
        return this.P;
    }

    public boolean isMacEnable() {
        return this.O;
    }

    public boolean isPlayEnable() {
        return this.m;
    }

    public boolean isSilenceInBackground() {
        return this.G;
    }

    public InitConfig putCommonHeader(Map<String, String> map) {
        this.A = map;
        return this;
    }

    public void setAbEnable(boolean z) {
        this.H = z;
    }

    public InitConfig setAccount(Account account) {
        this.B = account;
        return this;
    }

    public InitConfig setAliyunUdid(String str) {
        this.j = str;
        return this;
    }

    public InitConfig setAnonymous(boolean z) {
        this.k = z;
        return this;
    }

    public void setAppImei(String str) {
        this.V = str;
    }

    public InitConfig setAppName(String str) {
        this.q = str;
        return this;
    }

    public void setAutoActive(boolean z) {
        this.F = z;
    }

    public InitConfig setAutoStart(boolean z) {
        this.c = z;
        return this;
    }

    public void setAutoTrackEnabled(boolean z) {
        this.I = z;
    }

    public void setChannel(String str) {
        this.d = str;
    }

    public void setCongestionControlEnable(boolean z) {
        this.L = z;
    }

    public void setCustomLaunch(boolean z) {
        this.Y = z;
    }

    public InitConfig setDbName(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.M = str;
        }
        return this;
    }

    public InitConfig setDid(String str) {
        this.X = str;
        return this;
    }

    public InitConfig setEnablePlay(boolean z) {
        this.m = z;
        return this;
    }

    public void setEventFilterEnable(boolean z) {
        this.W = z;
    }

    public void setFixPageView(boolean z) {
        this.Z = z;
    }

    public InitConfig setGoogleAid(String str) {
        this.f = str;
        return this;
    }

    public InitConfig setH5BridgeAllowlist(List<String> list) {
        this.S = list;
        return this;
    }

    public InitConfig setH5BridgeEnable(boolean z) {
        this.Q = z;
        return this;
    }

    public InitConfig setH5CollectEnable(boolean z) {
        this.R = z;
        return this;
    }

    public void setHandleLifeCycle(boolean z) {
        this.f717K = z;
    }

    public InitConfig setImeiEnable(boolean z) {
        this.P = z;
        return this;
    }

    public InitConfig setIpcDataChecker(a aVar) {
        return this;
    }

    public InitConfig setLanguage(String str) {
        this.g = str;
        return this;
    }

    public InitConfig setLocalTest(boolean z) {
        this.l = z;
        return this;
    }

    public InitConfig setLogger(ILogger iLogger) {
        this.h = iLogger;
        return this;
    }

    public void setMacEnable(boolean z) {
        this.O = z;
    }

    public InitConfig setManifestVersion(String str) {
        this.x = str;
        return this;
    }

    public InitConfig setManifestVersionCode(int i) {
        this.w = i;
        return this;
    }

    public void setNeedAntiCheating(boolean z) {
        this.J = z;
    }

    public InitConfig setNetworkClient(INetworkClient iNetworkClient) {
        this.E = iNetworkClient;
        AppLog.setNetworkClient(iNetworkClient);
        return this;
    }

    public InitConfig setNotRequestSender(boolean z) {
        this.p = z;
        return this;
    }

    public InitConfig setPicker(f fVar) {
        return this;
    }

    public InitConfig setPreInstallChannelCallback(t tVar) {
        return this;
    }

    public InitConfig setProcess(int i) {
        this.n = i;
        return this;
    }

    public InitConfig setRegion(String str) {
        this.i = str;
        return this;
    }

    public InitConfig setReleaseBuild(String str) {
        this.o = str;
        return this;
    }

    public void setSensitiveInfoProvider(g gVar) {
        AppLog.setSensitiveInfoProvider(gVar);
    }

    public void setSilenceInBackground(boolean z) {
        this.G = z;
    }

    public InitConfig setSpName(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.N = str;
        }
        return this;
    }

    public InitConfig setTweakedChannel(String str) {
        this.t = str;
        return this;
    }

    public InitConfig setUpdateVersionCode(int i) {
        this.v = i;
        return this;
    }

    public InitConfig setUriConfig(int i) {
        this.r = UriConfig.createUriConfig(i);
        return this;
    }

    public InitConfig setVersion(String str) {
        this.s = str;
        return this;
    }

    public InitConfig setVersionCode(int i) {
        this.u = i;
        return this;
    }

    public InitConfig setVersionMinor(String str) {
        this.y = str;
        return this;
    }

    public InitConfig setZiJieCloudPkg(String str) {
        this.z = str;
        return this;
    }

    public InitConfig setUriConfig(UriConfig uriConfig) {
        this.r = uriConfig;
        return this;
    }

    public InitConfig(String str, String str2, String str3) {
        this(str, str3);
        this.b = str2;
        if (TextUtils.isEmpty(str2)) {
            Log.e("InitConfig", "token is empty, please check!!!");
        }
    }
}
