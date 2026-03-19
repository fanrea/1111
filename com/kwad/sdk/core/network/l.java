package com.kwad.sdk.core.network;

import android.text.TextUtils;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.network.idc.DomainException;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.export.proxy.AdHttpProxy;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.bx;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public abstract class l<R extends f, T extends BaseResultData> extends a<R> {
    private static final String TAG = "Networking";
    private g<R, T> mListener = null;
    private final com.kwad.sdk.core.network.b.b mMonitorRecorder = com.kwad.sdk.core.network.b.c.aaL();

    protected void afterParseData(T t) {
    }

    protected boolean enableCrashReport() {
        return true;
    }

    protected boolean enableMonitorReport() {
        return true;
    }

    protected boolean isPostByJson() {
        return true;
    }

    protected abstract T parseData(String str);

    public void request(g<R, T> gVar) {
        try {
            onRequest(gVar);
            fetch();
        } catch (Throwable th) {
            notifyOnErrorListener((l<R, T>) null, e.bCD.errorCode, bx.A(th));
            reportSdkCaughtException(th);
        }
    }

    private void onRequest(g<R, T> gVar) {
        this.mMonitorRecorder.aaE();
        this.mListener = gVar;
    }

    @Override // com.kwad.sdk.core.network.a
    public void cancel() {
        super.cancel();
        this.mListener = null;
    }

    private void setMonitorRequestId(f fVar) {
        Map<String, String> header = fVar.getHeader();
        if (header != null) {
            String str = header.get(d.TRACK_ID_KEY);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.mMonitorRecorder.fB(str);
        }
    }

    @Override // com.kwad.sdk.core.network.a
    protected void fetchImpl() {
        R rCreateRequest;
        Throwable th;
        c cVarDoPost = null;
        try {
            this.mMonitorRecorder.aaI();
            rCreateRequest = createRequest();
        } catch (Throwable th2) {
            rCreateRequest = null;
            th = th2;
        }
        try {
            notifyOnStartRequest(rCreateRequest);
            this.mMonitorRecorder.fx(rCreateRequest.getUrl()).fy(rCreateRequest.getUrl());
            setMonitorRequestId(rCreateRequest);
            if (!ao.isNetworkConnected(((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext())) {
                notifyOnErrorListener((l<R, T>) rCreateRequest, e.bCw.errorCode, e.bCw.msg);
                this.mMonitorRecorder.fj(e.bCw.errorCode).fz(e.bCw.msg);
            } else {
                try {
                    String url = rCreateRequest.getUrl();
                    AdHttpProxy adHttpProxyST = com.kwad.sdk.g.ST();
                    if (adHttpProxyST instanceof com.kwad.sdk.core.network.c.b) {
                        this.mMonitorRecorder.fA("ok_http").aaH();
                    } else {
                        this.mMonitorRecorder.fA(com.alipay.sdk.m.l.a.r).aaH();
                    }
                    if (isPostByJson()) {
                        cVarDoPost = adHttpProxyST.doPost(url, rCreateRequest.getHeader(), rCreateRequest.getBody());
                    } else {
                        cVarDoPost = adHttpProxyST.doPost(url, rCreateRequest.getHeader(), rCreateRequest.getBodyMap());
                    }
                    com.kwad.sdk.core.d.c.i(TAG, "url: " + url + ", response: " + cVarDoPost);
                } catch (Exception e) {
                    notifyOnErrorListener((l<R, T>) rCreateRequest, e.bCD.errorCode, bx.A(e));
                    com.kwad.sdk.core.d.c.printStackTraceOnly(e);
                    this.mMonitorRecorder.fz("requestError:" + e.getMessage());
                }
                this.mMonitorRecorder.aaF().aaG().fm(com.kwad.sdk.ip.direct.a.getType());
                try {
                    onResponse(rCreateRequest, cVarDoPost);
                } catch (Exception e2) {
                    notifyOnErrorListener((l<R, T>) rCreateRequest, e.bCD.errorCode, bx.A(e2));
                    this.mMonitorRecorder.fz("onResponseError:" + e2.getMessage());
                    com.kwad.sdk.core.d.c.printStackTraceOnly(e2);
                }
            }
        } catch (Throwable th3) {
            th = th3;
            try {
                try {
                    this.mMonitorRecorder.fz("requestError:" + th.getMessage());
                } finally {
                    try {
                        if (enableMonitorReport()) {
                            this.mMonitorRecorder.report();
                        }
                    } catch (Exception unused) {
                    }
                }
            } catch (Exception unused2) {
            }
            notifyOnErrorListener((l<R, T>) rCreateRequest, e.bCD.errorCode, bx.A(th));
            com.kwad.sdk.core.d.c.printStackTrace(th);
            try {
                if (enableMonitorReport()) {
                    this.mMonitorRecorder.report();
                }
            } catch (Exception unused3) {
            }
        }
    }

    @Override // com.kwad.sdk.core.network.a
    protected void onResponse(R r, c cVar) {
        if (cVar == null) {
            notifyOnErrorListener((l<R, T>) r, e.bCw.errorCode, e.bCw.msg);
            this.mMonitorRecorder.fz("responseBase is null");
            com.kwad.sdk.core.d.c.e(TAG, "request responseBase is null");
            return;
        }
        this.mMonitorRecorder.fj(cVar.code);
        checkIpDirect(cVar);
        if (TextUtils.isEmpty(cVar.bCs) || !cVar.aao()) {
            notifyOnErrorListener((l<R, T>) r, cVar, "网络错误");
            this.mMonitorRecorder.fz("httpCodeError:" + cVar.code + ":" + cVar.bCs);
            com.kwad.sdk.core.d.c.w(TAG, "request responseBase httpCodeError:" + cVar.code);
            return;
        }
        try {
            parseCommonData(r.getUrl(), cVar.bCs);
            BaseResultData data = parseData(cVar.bCs);
            afterParseData(data);
            if (cVar.bCs != null) {
                this.mMonitorRecorder.aY(cVar.bCs.length()).aaJ().fl(data.result);
            }
            if (!data.isResultOk()) {
                this.mMonitorRecorder.fz("serverCodeError:" + data.result + ":" + data.errorMsg);
                if (data.notifyFailOnResultError()) {
                    notifyOnErrorListener((l<R, T>) r, data.result, data.errorMsg);
                    return;
                }
            }
            if (data.isDataEmpty()) {
                notifyOnErrorListener((l<R, T>) r, e.bCy.errorCode, !TextUtils.isEmpty(data.testErrorMsg) ? data.testErrorMsg : e.bCy.msg);
            } else {
                checkAndSetHasData(data);
                notifyOnSuccess(r, data);
            }
        } catch (Exception e) {
            notifyOnErrorListener((l<R, T>) r, e.bCx.errorCode, e.bCx.msg);
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            this.mMonitorRecorder.fz("parseDataError:" + e.getMessage());
        }
    }

    private void checkIpDirect(c cVar) {
        com.kwad.sdk.service.a.f fVar;
        if (cVar == null || cVar.aao() || (fVar = (com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)) == null || !ao.isNetworkConnected(fVar.getContext())) {
            return;
        }
        com.kwad.sdk.ip.direct.a.aku();
    }

    private void checkAndSetHasData(BaseResultData baseResultData) {
        if (baseResultData.hasData()) {
            this.mMonitorRecorder.fk(1);
        }
    }

    private void parseCommonData(String str, String str2) {
        try {
            q.aas().ab(str, new JSONObject(str2).optString("requestSessionData"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void notifyOnStartRequest(R r) {
        g<R, T> gVar = this.mListener;
        if (gVar == null) {
            return;
        }
        gVar.onStartRequest(r);
    }

    private void notifyOnErrorListener(R r, c cVar, String str) {
        String url = r.getUrl();
        DomainException domainException = new DomainException(cVar.bCq, cVar.bCr);
        com.kwad.sdk.core.network.idc.a.aaw().a(url, getHostTypeByUrl(url), domainException);
        notifyOnErrorListener((l<R, T>) r, cVar.code, str);
    }

    private String getHostTypeByUrl(String str) {
        return str.contains("/rest/zt/emoticon/package/list") ? "zt" : "api";
    }

    private void notifyOnErrorListener(R r, int i, String str) {
        try {
            h.aap().b(r, i);
        } catch (Throwable th) {
            reportSdkCaughtException(th);
        }
        g<R, T> gVar = this.mListener;
        if (gVar == null) {
            return;
        }
        gVar.onError(r, i, str);
        this.mMonitorRecorder.aaK();
    }

    private void reportSdkCaughtException(Throwable th) {
        if (enableCrashReport()) {
            ServiceProvider.reportSdkCaughtException(th);
        } else {
            com.kwad.sdk.core.d.c.printStackTrace(th);
        }
    }

    private void notifyOnSuccess(R r, T t) {
        if (com.kwad.sdk.core.network.idc.a.aaw().aay()) {
            String hostTypeByUrl = getHostTypeByUrl(r.getUrl());
            if ("api".equals(hostTypeByUrl)) {
                com.kwad.sdk.core.network.idc.a.aaw().fr(hostTypeByUrl);
            }
        }
        g<R, T> gVar = this.mListener;
        if (gVar == null) {
            return;
        }
        gVar.onSuccess(r, t);
        this.mMonitorRecorder.aaK();
    }
}
