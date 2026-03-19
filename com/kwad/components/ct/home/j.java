package com.kwad.components.ct.home;

import com.kwad.components.ct.api.model.wallpaper.WallpaperParam;
import com.kwad.components.ct.api.tube.KSTubeParamInner;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.api.KsContentPage;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class j extends g {
    public i aFo;
    public com.kwad.components.core.widget.a.b aFs;
    public h aGQ;
    public KsContentPage.KsVideoBtnClickListener aHd;
    public int aHi;
    public CtAdTemplate aHl;
    public com.kwad.sdk.g.c<Boolean> aHq;
    public WallpaperParam aHr;
    public com.kwad.components.core.k.f aHs;
    public int aHt;
    public KsContentPage.KsShareListener alT;
    public KsContentPage.KsEcBtnClickListener alV;
    public com.kwad.sdk.widget.swipe.c avG;
    public com.kwad.components.ct.api.a.a.c ayi;
    public KSTubeParamInner mKSTubeParam;
    public int mNextTubeLockEpisodeNum;
    public SceneImpl mSceneImpl;
    public List<com.kwad.components.ct.hotspot.e> aHm = new ArrayList();
    public List<com.kwad.components.ct.detail.photo.comment.g> auW = new ArrayList();
    public boolean aGJ = false;
    public boolean aHg = false;
    public boolean aHn = false;
    public boolean aHh = true;
    public boolean aHo = false;
    public boolean aHp = false;
    public int aGL = 0;

    public final void release() {
        com.kwad.components.core.widget.a.b bVar = this.aFs;
        if (bVar != null) {
            bVar.wL();
            this.aFs.release();
        }
        List<com.kwad.components.ct.hotspot.e> list = this.aHm;
        if (list != null) {
            list.clear();
        }
        List<com.kwad.components.ct.detail.photo.comment.g> list2 = this.auW;
        if (list2 != null) {
            list2.clear();
        }
    }

    public final void Ft() {
        this.aHm.clear();
    }

    public final void cn(int i) {
        this.mNextTubeLockEpisodeNum = i;
    }
}
