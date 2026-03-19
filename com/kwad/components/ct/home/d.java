package com.kwad.components.ct.home;

import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.components.ct.response.model.hotspot.HotspotInfo;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public abstract class d extends com.kwad.sdk.mvp.a {
    public boolean aAc;
    public boolean aBu;
    public com.kwad.components.core.proxy.h aGE;
    public com.kwad.components.ct.g.a aGF;
    public List<HotspotInfo> aGG;
    public boolean aGH;
    public int aGI;
    public boolean aGJ;
    public boolean aGK;
    public int aGL;
    public com.kwad.components.ct.api.a.a.c<CtAdTemplate> ayi;
    public boolean azS;
    public HotspotInfo mEntryHotspotInfo;
    public SceneImpl mSceneImpl;
    public com.kwad.sdk.g.b<List<CtAdTemplate>, Integer> aBv = new com.kwad.sdk.g.b<List<CtAdTemplate>, Integer>() { // from class: com.kwad.components.ct.home.d.1
        @Override // com.kwad.sdk.g.b
        public final /* synthetic */ Integer apply(List<CtAdTemplate> list) {
            return Fl();
        }

        private Integer Fl() {
            return Integer.valueOf(d.this.aGI);
        }
    };
    public List<com.kwad.components.ct.hotspot.j> aGM = new ArrayList();
    public List<com.kwad.components.ct.hotspot.e> aGN = new ArrayList();
}
