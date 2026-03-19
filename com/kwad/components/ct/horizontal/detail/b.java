package com.kwad.components.ct.horizontal.detail;

import com.kwad.components.ct.horizontal.video.e;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.api.KsContentPage;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.api.core.lifecycle.KsLifecycle;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b extends com.kwad.sdk.mvp.a {
    public com.kwad.components.core.widget.a.b aFs;
    public e aLD;
    public KsContentPage.ContentItem aLE;
    public KsLifecycle aLF;
    public com.kwad.components.ct.horizontal.video.b aLG;
    public CtAdTemplate aLI;
    public KsContentPage.PageListener alM;
    public KsFragment aoy;
    public CtAdTemplate mAdTemplate;
    public com.kwad.components.core.e.d.c mApkDownloadHelper;
    public long mEnterPlayPosition;
    public SceneImpl mSceneImpl;
    private List<KsContentPage.VideoListener> aqs = new ArrayList();
    public boolean aLH = false;

    @Override // com.kwad.sdk.mvp.a
    public final void release() {
        e eVar = this.aLD;
        if (eVar != null) {
            eVar.release();
        }
        com.kwad.components.ct.horizontal.video.b bVar = this.aLG;
        if (bVar != null) {
            bVar.release();
        }
        this.aqs.clear();
    }

    public final void a(KsContentPage.VideoListener videoListener) {
        if (videoListener == null) {
            return;
        }
        this.aqs.add(videoListener);
    }

    public final List<KsContentPage.VideoListener> Hq() {
        return this.aqs;
    }
}
