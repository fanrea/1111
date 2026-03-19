package com.kwad.components.ct.home;

import android.content.Context;
import com.kwad.sdk.api.KsContentAllianceAd;
import com.kwad.sdk.api.KsContentPage;
import com.kwad.sdk.api.KsScene;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b extends com.kwad.sdk.components.e implements com.kwad.components.ct.api.d {
    private com.kwad.components.ct.api.a.a aGz;

    @Override // com.kwad.sdk.components.b
    public final void init(Context context) {
    }

    @Override // com.kwad.sdk.components.b
    public final Class getComponentsType() {
        return com.kwad.components.ct.api.d.class;
    }

    @Override // com.kwad.components.ct.api.d
    public final KsContentAllianceAd loadContentAllianceAd(KsScene ksScene) {
        return k.loadContentAllianceAd(ksScene);
    }

    @Override // com.kwad.components.ct.api.d
    public final KsContentPage loadContentPage(KsScene ksScene) {
        return k.loadContentPage(ksScene);
    }

    @Override // com.kwad.components.ct.api.d
    public final KsContentPage loadContentPageByPush(KsScene ksScene, String str) {
        return k.loadContentPageByPush(ksScene, str);
    }

    @Override // com.kwad.components.ct.api.d
    public final KsContentPage loadContentPageBySchema(KsScene ksScene, String str) {
        return k.loadContentPageBySchema(ksScene, str);
    }

    @Override // com.kwad.components.ct.api.d
    public final com.kwad.components.ct.api.a.a xa() {
        if (this.aGz == null) {
            this.aGz = new com.kwad.components.ct.api.a.a() { // from class: com.kwad.components.ct.home.b.1
                @Override // com.kwad.components.ct.api.a.a
                public final void a(KsContentPage.KsShareListener ksShareListener) {
                    i.a(ksShareListener);
                }
            };
        }
        return this.aGz;
    }
}
