package com.kwad.components.ct.horizontal.feed.a;

import com.kwad.components.ct.response.model.CtAdResultData;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.api.KsContentPage;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.lib.widget.a.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b extends com.kwad.sdk.lib.a.a.b<CtAdResultData, CtAdTemplate> {
    public com.kwad.components.core.widget.a.b aFs;
    public boolean aLP;
    public com.kwad.components.ct.horizontal.feed.item.presenter.play.a aMY;
    public SceneImpl mSceneImpl;
    public Map<String, e.a> aFK = new LinkedHashMap();
    public Map<Integer, com.kwad.components.ct.horizontal.feed.item.a.a> aMX = new HashMap();
    private List<KsContentPage.VideoListener> aqs = new ArrayList();
    public boolean aMZ = false;
    public boolean ant = false;
    public boolean aNa = false;

    public final void release() {
        Map<Integer, com.kwad.components.ct.horizontal.feed.item.a.a> map = this.aMX;
        if (map != null) {
            map.clear();
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
