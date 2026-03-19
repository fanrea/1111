package com.kwad.components.core.webview.tachikoma.b;

import com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener;
import com.kwad.sdk.service.ServiceProvider;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class x implements com.kwad.sdk.core.webview.c.a {
    private OfflineOnAudioConflictListener De = new OfflineOnAudioConflictListener() { // from class: com.kwad.components.core.webview.tachikoma.b.x.1
        @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
        public final void onAudioBeOccupied() {
            x.this.br(2);
        }

        @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
        public final void onAudioBeReleased() {
            x.this.br(3);
        }
    };
    private com.kwad.sdk.core.webview.c.c aeJ;

    public static class a extends com.kwad.sdk.core.response.a.a {
        public boolean aiO;
        public int aiP;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "registerAudioFocusListener";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        this.aeJ = cVar;
        com.kwad.components.core.u.a.aC(ServiceProvider.getContext()).a(this.De);
        br(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void br(int i) {
        a aVar = new a();
        aVar.aiO = com.kwad.components.core.u.a.aC(ServiceProvider.getContext()).to();
        aVar.aiP = i;
        com.kwad.sdk.core.webview.c.c cVar = this.aeJ;
        if (cVar != null) {
            cVar.a(aVar);
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        com.kwad.components.core.u.a.aC(ServiceProvider.getContext()).b(this.De);
        this.aeJ = null;
    }
}
