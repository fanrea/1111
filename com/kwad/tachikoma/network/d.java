package com.kwad.tachikoma.network;

import com.kwad.components.offline.api.OfflineHostProvider;
import com.kwad.components.offline.api.core.network.IOfflineCompoNetworking;
import com.kwad.components.offline.api.core.network.IOfflineCompoRequest;
import com.kwad.components.offline.api.core.network.IOfflineCompoRequestListener;
import com.kwad.components.offline.api.core.network.OfflineCompoNetworking;
import com.kwad.components.offline.api.core.network.OfflineCompoNormalNetworking;
import com.kwad.components.offline.api.core.network.model.BaseOfflineCompoResultData;
import com.kwad.components.offline.api.core.network.model.CommonOfflineCompoResultData;
import com.kwad.components.offline.api.core.network.model.NormalOfflineCompoResultData;
import com.kwad.sdk.api.KsScene;
import com.tk.core.a.n;
import com.tk.core.a.o;
import com.tk.core.component.network.TKNetErrorInfo;
import com.tk.core.component.network.TKNetResponse;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class d implements o {
    private IOfflineCompoNetworking DY;
    private String DZ;
    private Map<String, Object> Ea;
    private String Eb;
    private int Ec;
    private String Ed;
    private int Ee;
    private n Ef;
    private Map<String, String> mHeaders;
    private String mUrl;

    @Override // com.tk.core.a.o
    public final void setUrl(String str) {
        this.mUrl = str;
    }

    @Override // com.tk.core.a.o
    public final void setMethod(String str) {
        this.DZ = str;
    }

    @Override // com.tk.core.a.o
    public final void b(Map<String, Object> map) {
        this.Ea = map;
    }

    @Override // com.tk.core.a.o
    public final void v(String str) {
        this.Eb = str;
    }

    @Override // com.tk.core.a.o
    public final void c(Map<String, String> map) {
        this.mHeaders = map;
    }

    @Override // com.tk.core.a.o
    public final void setTimeout(int i) {
        this.Ec = i;
    }

    @Override // com.tk.core.a.o
    public final void setBusinessName(String str) {
        this.Ed = str;
    }

    @Override // com.tk.core.a.o
    public final void ce(int i) {
        this.Ee = i;
    }

    @Override // com.tk.core.a.o
    public final void a(n nVar) {
        this.Ef = nVar;
        final boolean z = this.DZ.equals("POST") && this.Ee == 1;
        IOfflineCompoRequest iOfflineCompoRequest = new IOfflineCompoRequest() { // from class: com.kwad.tachikoma.network.d.1
            @Override // com.kwad.components.offline.api.core.network.IOfflineCompoRequest
            public final Map<String, String> getBodyMap() {
                return null;
            }

            @Override // com.kwad.components.offline.api.core.network.IOfflineCompoRequest
            public final String getRequestHost() {
                return null;
            }

            @Override // com.kwad.components.offline.api.core.network.IOfflineCompoRequest
            public final KsScene getScene() {
                return null;
            }

            @Override // com.kwad.components.offline.api.core.network.IOfflineCompoRequest
            public final String getMethod() {
                return d.this.DZ;
            }

            @Override // com.kwad.components.offline.api.core.network.IOfflineCompoRequest
            public final String getUrl() {
                String strHostForAPI;
                String str = d.this.mUrl;
                if (d.this.mUrl.startsWith(com.alipay.sdk.m.l.a.r)) {
                    return str;
                }
                if (d.this.Ee != 1) {
                    strHostForAPI = OfflineHostProvider.getApi().idc().hostForAPI(d.this.Ed);
                } else {
                    strHostForAPI = OfflineHostProvider.getApi().idc().hostForAPI("api");
                }
                return strHostForAPI + str;
            }

            @Override // com.kwad.components.offline.api.core.network.IOfflineCompoRequest
            public final Map<String, String> getHeader() {
                return d.this.mHeaders != null ? d.this.mHeaders : new HashMap();
            }

            @Override // com.kwad.components.offline.api.core.network.IOfflineCompoRequest
            public final JSONObject getBody() {
                try {
                    if (d.this.Ea != null) {
                        return com.kwad.tachikoma.t.c.d(d.this.Ea);
                    }
                    if (d.this.Eb != null) {
                        return new JSONObject(d.this.Eb);
                    }
                    return new JSONObject();
                } catch (Exception unused) {
                    return null;
                }
            }

            @Override // com.kwad.components.offline.api.core.network.IOfflineCompoRequest
            public final boolean encryptDisable() {
                return !z;
            }
        };
        if (z) {
            a(iOfflineCompoRequest);
        } else {
            b(iOfflineCompoRequest);
        }
    }

    private void a(final IOfflineCompoRequest iOfflineCompoRequest) {
        final c cVar = new c() { // from class: com.kwad.tachikoma.network.d.2
            @Override // com.kwad.tachikoma.network.c
            public final IOfflineCompoRequest iL() {
                return iOfflineCompoRequest;
            }
        };
        OfflineCompoNetworking<IOfflineCompoRequest, CommonOfflineCompoResultData> offlineCompoNetworking = new OfflineCompoNetworking<IOfflineCompoRequest, CommonOfflineCompoResultData>() { // from class: com.kwad.tachikoma.network.d.3
            @Override // com.kwad.components.offline.api.core.network.OfflineCompoNetworking
            protected final CommonOfflineCompoResultData createResponseData() {
                CommonOfflineCompoResultData commonOfflineCompoResultData = new CommonOfflineCompoResultData() { // from class: com.kwad.tachikoma.network.TKNetworkImpl$3$1
                };
                commonOfflineCompoResultData.setKeepOriginResponse(true);
                commonOfflineCompoResultData.setNotifyFailOnResultError(false);
                return commonOfflineCompoResultData;
            }

            @Override // com.kwad.components.offline.api.core.network.IOfflineCompoNetworking
            public final IOfflineCompoRequest createRequest() {
                return cVar;
            }
        };
        offlineCompoNetworking.request(new IOfflineCompoRequestListener<IOfflineCompoRequest, CommonOfflineCompoResultData>() { // from class: com.kwad.tachikoma.network.d.4
            @Override // com.kwad.components.offline.api.core.network.IOfflineCompoRequestListener
            public final void onStartRequest(IOfflineCompoRequest iOfflineCompoRequest2) {
            }

            @Override // com.kwad.components.offline.api.core.network.IOfflineCompoRequestListener
            public final /* synthetic */ void onSuccess(IOfflineCompoRequest iOfflineCompoRequest2, BaseOfflineCompoResultData baseOfflineCompoResultData) {
                a((CommonOfflineCompoResultData) baseOfflineCompoResultData);
            }

            private void a(CommonOfflineCompoResultData commonOfflineCompoResultData) {
                if (d.this.Ef != null) {
                    TKNetResponse tKNetResponse = new TKNetResponse();
                    if (commonOfflineCompoResultData.originResponseData != null) {
                        tKNetResponse.data = commonOfflineCompoResultData.originResponseData.toString();
                    } else {
                        tKNetResponse.data = null;
                    }
                    tKNetResponse.statusCode = 200;
                    d.this.Ef.a(tKNetResponse, null);
                }
            }

            @Override // com.kwad.components.offline.api.core.network.IOfflineCompoRequestListener
            public final void onError(IOfflineCompoRequest iOfflineCompoRequest2, int i, String str) {
                if (d.this.Ef != null) {
                    d.this.Ef.a(null, new TKNetErrorInfo(i, str));
                }
            }
        });
        this.DY = offlineCompoNetworking;
    }

    private void b(final IOfflineCompoRequest iOfflineCompoRequest) {
        OfflineCompoNormalNetworking<IOfflineCompoRequest, NormalOfflineCompoResultData> offlineCompoNormalNetworking = new OfflineCompoNormalNetworking<IOfflineCompoRequest, NormalOfflineCompoResultData>() { // from class: com.kwad.tachikoma.network.d.5
            @Override // com.kwad.components.offline.api.core.network.OfflineCompoNormalNetworking
            public final NormalOfflineCompoResultData createResponseData() {
                return new NormalOfflineCompoResultData();
            }

            @Override // com.kwad.components.offline.api.core.network.IOfflineCompoNetworking
            public final IOfflineCompoRequest createRequest() {
                return iOfflineCompoRequest;
            }
        };
        offlineCompoNormalNetworking.request(new IOfflineCompoRequestListener<IOfflineCompoRequest, NormalOfflineCompoResultData>() { // from class: com.kwad.tachikoma.network.d.6
            @Override // com.kwad.components.offline.api.core.network.IOfflineCompoRequestListener
            public final void onStartRequest(IOfflineCompoRequest iOfflineCompoRequest2) {
            }

            @Override // com.kwad.components.offline.api.core.network.IOfflineCompoRequestListener
            public final /* synthetic */ void onSuccess(IOfflineCompoRequest iOfflineCompoRequest2, BaseOfflineCompoResultData baseOfflineCompoResultData) {
                a((NormalOfflineCompoResultData) baseOfflineCompoResultData);
            }

            private void a(NormalOfflineCompoResultData normalOfflineCompoResultData) {
                if (d.this.Ef != null) {
                    TKNetResponse tKNetResponse = new TKNetResponse();
                    tKNetResponse.data = normalOfflineCompoResultData.data;
                    tKNetResponse.statusCode = normalOfflineCompoResultData.code;
                    tKNetResponse.headers = normalOfflineCompoResultData.header;
                    d.this.Ef.a(tKNetResponse, null);
                }
            }

            @Override // com.kwad.components.offline.api.core.network.IOfflineCompoRequestListener
            public final void onError(IOfflineCompoRequest iOfflineCompoRequest2, int i, String str) {
                if (d.this.Ef != null) {
                    d.this.Ef.a(null, new TKNetErrorInfo(i, str));
                }
            }
        });
        this.DY = offlineCompoNormalNetworking;
    }

    @Override // com.tk.core.a.o
    public final void cancel() {
        IOfflineCompoNetworking iOfflineCompoNetworking = this.DY;
        if (iOfflineCompoNetworking != null) {
            iOfflineCompoNetworking.cancel();
        }
    }
}
