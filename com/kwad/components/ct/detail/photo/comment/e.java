package com.kwad.components.ct.detail.photo.comment;

import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.components.ct.response.model.CtPhotoInfo;
import com.kwad.components.ct.response.model.home.PhotoComment;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class e {
    private CtPhotoInfo asj;
    private long ask;
    private List<PhotoComment> asl;
    private long le;
    private CtAdTemplate mAdTemplate;

    public e(CtAdTemplate ctAdTemplate, long j) {
        this.mAdTemplate = ctAdTemplate;
        this.le = com.kwad.components.ct.response.a.a.aw(ctAdTemplate);
        this.asj = com.kwad.components.ct.response.a.a.ay(ctAdTemplate);
        this.ask = j;
    }

    public final CtAdTemplate zR() {
        return this.mAdTemplate;
    }

    public final long zS() {
        return com.kwad.components.ct.response.a.a.bg(this.mAdTemplate);
    }

    public final long getPosition() {
        return this.ask;
    }

    public final List<PhotoComment> zT() {
        return this.asl;
    }

    public final void v(List<PhotoComment> list) {
        this.asl = list;
    }

    public final int zU() {
        List<PhotoComment> list = this.asl;
        if (list != null) {
            return list.size();
        }
        return 0;
    }
}
