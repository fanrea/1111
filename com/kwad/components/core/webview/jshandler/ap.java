package com.kwad.components.core.webview.jshandler;

import com.kwad.components.core.webview.jshandler.bd;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class ap implements com.kwad.sdk.core.webview.c.a {
    private List<c> mHolders = new ArrayList();

    public static class b extends com.kwad.sdk.core.response.a.a {
        public long creativeId = -1;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "registerMultiProgressListener";
    }

    public ap(List<AdTemplate> list, List<com.kwad.components.core.e.d.c> list2) {
        if (list == null || list2 == null) {
            return;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            this.mHolders.add(new c(list2.get(i), list.get(i)));
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                b bVar = new b();
                bVar.parseJson(jSONObject);
                c cVarR = R(bVar.creativeId);
                if (cVarR != null) {
                    cVarR.sd = cVar;
                    cVarR.a(new a(cVarR));
                }
            } catch (Exception unused) {
            }
        }
    }

    private c R(long j) {
        if (j == -1) {
            return null;
        }
        for (c cVar : this.mHolders) {
            if (cVar.getCreativeId() == j) {
                return cVar;
            }
        }
        return null;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        Iterator<c> it = this.mHolders.iterator();
        while (it.hasNext()) {
            it.next().destroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(c cVar, int i, float f) {
        if (cVar == null || cVar.sd == null) {
            return;
        }
        com.kwad.sdk.core.d.c.d("MultiProgressListener", "notifyDownloadProgress: " + cVar.sd + f);
        com.kwad.sdk.core.webview.c.c cVar2 = cVar.sd;
        bd.a aVar = new bd.a();
        aVar.agh = f;
        aVar.status = i;
        aVar.creativeId = cVar.getCreativeId();
        aVar.totalBytes = com.kwad.sdk.core.response.b.e.eP(cVar.mAdTemplate).totalBytes;
        aVar.soFarBytes = com.kwad.sdk.core.response.b.e.eP(cVar.mAdTemplate).soFarBytes;
        if (aVar.totalBytes > 0) {
            aVar.agi = (aVar.soFarBytes * 1.0f) / aVar.totalBytes;
        } else {
            aVar.agi = 0.0f;
        }
        cVar2.a(aVar);
    }

    static class c {
        private com.kwad.components.core.e.d.c afI;
        private a afJ;
        private AdTemplate mAdTemplate;
        private com.kwad.sdk.core.webview.c.c sd;

        public c(com.kwad.components.core.e.d.c cVar, AdTemplate adTemplate) {
            this.afI = cVar;
            this.mAdTemplate = adTemplate;
        }

        public final void a(a aVar) {
            this.afI.b(aVar);
            this.afJ = aVar;
        }

        public final void destroy() {
            a aVar;
            com.kwad.components.core.e.d.c cVar = this.afI;
            if (cVar == null || (aVar = this.afJ) == null) {
                return;
            }
            cVar.c(aVar);
        }

        public final long getCreativeId() {
            AdTemplate adTemplate = this.mAdTemplate;
            if (adTemplate == null) {
                return -1L;
            }
            return com.kwad.sdk.core.response.b.e.eV(adTemplate);
        }
    }

    static class a extends com.kwad.sdk.core.download.a.a {
        private c afH;

        public a(c cVar) {
            this.afH = cVar;
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onIdle() {
            ap.a(this.afH, 1, 0.0f);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onProgressUpdate(int i) {
            ap.a(this.afH, 2, (i * 1.0f) / 100.0f);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFinished() {
            ap.a(this.afH, 5, 1.0f);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFailed() {
            ap.a(this.afH, 1, 0.0f);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onInstalled() {
            ap.a(this.afH, 6, 1.0f);
        }

        @Override // com.kwad.sdk.core.download.a.a
        public final void onPaused(int i) {
            ap.a(this.afH, 3, (i * 1.0f) / 100.0f);
        }
    }
}
