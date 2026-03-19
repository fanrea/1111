package com.kwad.sdk.kgeo;

import com.kwad.components.core.request.b;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.kgeo.c;
import com.kwad.sdk.service.ServiceProvider;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class a {
    private static String ccc;
    private static KGeoInfo ccd;
    private static final AtomicBoolean cce = new AtomicBoolean();

    public static void gy(int i) {
        if (i == 0) {
            return;
        }
        if (i == 1) {
            akF();
        } else if (i == 2) {
            com.kwad.components.core.request.b.sx().a(new b.a() { // from class: com.kwad.sdk.kgeo.a.1
                @Override // com.kwad.components.core.request.b.a
                public final void sz() {
                    com.kwad.components.core.request.b.sx().b(this);
                    a.akF();
                }
            });
        }
    }

    public static String TU() {
        return ccc;
    }

    public static KGeoInfo akE() {
        return ccd;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void akF() {
        try {
            if (cce.getAndSet(true)) {
                return;
            }
            c.a(ServiceProvider.anu(), new c.a() { // from class: com.kwad.sdk.kgeo.a.2
                @Override // com.kwad.sdk.kgeo.c.a
                public final void onSuccess(String str) {
                    String unused = a.ccc = str;
                    a.akG();
                }

                @Override // com.kwad.sdk.kgeo.c.a
                public final void adZ() {
                    a.akG();
                }
            });
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void akG() {
        try {
            new l<f, KGeoResultData>() { // from class: com.kwad.sdk.kgeo.a.3
                @Override // com.kwad.sdk.core.network.l
                public final /* synthetic */ BaseResultData parseData(String str) {
                    return hv(str);
                }

                private static KGeoResultData hv(String str) {
                    KGeoResultData kGeoResultData = new KGeoResultData();
                    kGeoResultData.parseJson(new JSONObject(str));
                    return kGeoResultData;
                }

                @Override // com.kwad.sdk.core.network.a
                public final f createRequest() {
                    return new b();
                }
            }.request(new o<f, KGeoResultData>() { // from class: com.kwad.sdk.kgeo.a.4
                @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
                public final /* synthetic */ void onSuccess(f fVar, BaseResultData baseResultData) {
                    a((KGeoResultData) baseResultData);
                }

                private static void a(KGeoResultData kGeoResultData) {
                    KGeoInfo unused = a.ccd = kGeoResultData.kGeoInfo;
                }
            });
        } catch (Throwable unused) {
        }
    }
}
