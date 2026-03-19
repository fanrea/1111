package com.kwad.components.ad.k;

import com.kwad.components.core.video.k;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public abstract class a<L extends k> {
    public AdTemplate mAdTemplate;

    public abstract void a(L l);

    public abstract void b(L l);

    public long getPlayDuration() {
        return 0L;
    }

    public boolean kV() {
        return false;
    }

    public abstract void pause();

    public void release() {
    }

    public abstract void resume();

    public void setAudioEnabled(boolean z, boolean z2) {
    }

    public void skipToEnd() {
    }

    public a(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
    }
}
