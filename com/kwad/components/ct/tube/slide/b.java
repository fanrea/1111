package com.kwad.components.ct.tube.slide;

import android.os.Bundle;
import com.kwad.components.ct.api.tube.TubeEpisodeHomeParam;
import com.kwad.components.ct.e.c;
import com.kwad.components.ct.home.b.h;
import com.kwad.components.ct.home.f;
import com.kwad.components.ct.home.i;
import com.kwad.components.ct.home.j;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.components.ct.response.model.tube.TubeEpisode;
import com.kwad.components.ct.tube.slide.b.b;
import com.kwad.sdk.R;
import com.kwad.sdk.core.scene.URLPackage;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.ap;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b extends i {
    private TubeEpisodeHomeParam aYl;
    private long mTubeId;

    public static b a(TubeEpisodeHomeParam tubeEpisodeHomeParam) {
        b bVar = new b();
        Bundle bundle = new Bundle();
        bundle.putSerializable("key_AdScene", new SceneImpl(tubeEpisodeHomeParam.mEntryScene));
        bundle.putSerializable("KEY_TUBE_EPISODE_DETAIL_PARAM", tubeEpisodeHomeParam);
        bVar.setArguments(bundle);
        return bVar;
    }

    @Override // com.kwad.components.ct.home.i
    public final boolean a(Bundle bundle) {
        Serializable serializable = bundle.getSerializable("KEY_TUBE_EPISODE_DETAIL_PARAM");
        if (!(serializable instanceof TubeEpisodeHomeParam)) {
            return false;
        }
        TubeEpisodeHomeParam tubeEpisodeHomeParam = (TubeEpisodeHomeParam) serializable;
        this.aYl = tubeEpisodeHomeParam;
        this.mSceneImpl.setUrlPackage(new URLPackage(String.valueOf(hashCode()), tubeEpisodeHomeParam.mKSTubeParam.pageMode == 1 ? 5 : 34));
        this.aGJ = false;
        this.aHg = false;
        this.aGK = false;
        this.mTubeId = this.aYl.mTubeId;
        if (this.aYl.mKSTubeParam.disableShowTubePanelEntry) {
            this.aHi = 0;
        } else {
            this.aHi = com.kwad.sdk.c.a.a.j(this.mContext, R.dimen.ksad_tube_entry_height);
        }
        return true;
    }

    @Override // com.kwad.components.ct.home.i
    public final boolean a(final f fVar) {
        if (this.aYl == null) {
            return false;
        }
        fVar.ayi = new h(new com.kwad.components.ct.tube.slide.b.a(this.mSceneImpl, this.aYl));
        fVar.azS = false;
        fVar.aBu = this.aYl.mKSTubeParam.pageMode == 1;
        fVar.aGH = true;
        fVar.aGS = new com.kwad.sdk.g.a<c>() { // from class: com.kwad.components.ct.tube.slide.b.1
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void accept(c cVar) {
                cVar.tubeId = b.this.aYl.mTubeId;
            }
        };
        fVar.aBv = new com.kwad.sdk.g.b<List<CtAdTemplate>, Integer>() { // from class: com.kwad.components.ct.tube.slide.b.2
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.b
            /* renamed from: U, reason: merged with bridge method [inline-methods] */
            public Integer apply(List<CtAdTemplate> list) {
                if (ap.aM(list)) {
                    fVar.aol.cn(com.kwad.components.ct.response.a.c.r(com.kwad.components.ct.response.a.a.ay(list.get(0))));
                }
                int i = b.this.aYl.watchEpisodeNum;
                for (int i2 = 0; i2 < list.size(); i2++) {
                    if (com.kwad.components.ct.response.a.c.q(com.kwad.components.ct.response.a.a.ay(list.get(i2))) == i) {
                        return Integer.valueOf(i2);
                    }
                }
                return 0;
            }
        };
        return true;
    }

    @Override // com.kwad.components.ct.home.i
    public final void b(j jVar) {
        super.b(jVar);
        jVar.aHq = new com.kwad.sdk.g.c<Boolean>() { // from class: com.kwad.components.ct.tube.slide.b.3
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.c
            /* renamed from: KL, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(b.this.getChildFragmentManager().findFragmentByTag("TubePanelTabFragment") != null);
            }
        };
        jVar.mKSTubeParam = this.aYl.mKSTubeParam;
    }

    @Override // com.kwad.components.ct.home.i
    public final boolean b(Presenter presenter) {
        if (!com.kwad.sdk.core.scene.a.fw(this.mSceneImpl.getPageScene())) {
            return false;
        }
        presenter.d(new com.kwad.components.ct.tube.slide.a.a());
        presenter.d(new com.kwad.components.ct.tube.slide.a.b());
        presenter.d(new com.kwad.components.ct.home.c.i());
        return true;
    }

    public final void playSelectPage(final int i) {
        if (this.aYl.mKSTubeParam.pageMode == 2) {
            return;
        }
        List<CtAdTemplate> data = this.aok.getData();
        if (ap.aF(data)) {
            return;
        }
        ArrayList arrayList = new ArrayList(data);
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            if (i == com.kwad.components.ct.response.a.c.q(com.kwad.components.ct.response.a.a.ay((CtAdTemplate) arrayList.get(i2)))) {
                this.aok.h(i2, true);
                return;
            }
        }
        com.kwad.components.ct.tube.slide.b.b.KX().a(this.mSceneImpl, this.aYl.mKSTubeParam, this.aYl.mTubeId, i, new b.InterfaceC0542b() { // from class: com.kwad.components.ct.tube.slide.b.4
            @Override // com.kwad.components.ct.tube.slide.b.b.InterfaceC0542b
            public final void b(List<CtAdTemplate> list, TubeEpisode tubeEpisode) {
                if (tubeEpisode.episodeNumber == i) {
                    com.kwad.components.ct.tube.panel.a.a.KH().c(list, tubeEpisode);
                }
            }
        });
    }

    @Override // com.kwad.components.ct.home.i, com.kwad.components.core.proxy.h, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public final void onDestroy() {
        super.onDestroy();
        com.kwad.components.ct.tube.slide.b.b.KX().ao(this.mTubeId);
    }
}
