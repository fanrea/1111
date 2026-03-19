package com.kwad.components.ct.detail.photo.related;

import com.kwad.components.ct.response.model.CtAdTemplate;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class a {
    private static volatile a avS;
    private List<CtAdTemplate> avQ;
    private List<CtAdTemplate> avR;

    private a() {
    }

    public static a Bg() {
        if (avS == null) {
            synchronized (a.class) {
                if (avS == null) {
                    avS = new a();
                }
            }
        }
        return avS;
    }

    public final List<CtAdTemplate> Bh() {
        return this.avQ;
    }

    public final void w(List<CtAdTemplate> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        if (this.avQ == null) {
            this.avQ = new ArrayList();
        }
        this.avQ.clear();
        this.avQ.addAll(list);
    }

    public final void Bi() {
        List<CtAdTemplate> list = this.avQ;
        if (list != null) {
            list.clear();
        }
        this.avQ = null;
    }

    public final List<CtAdTemplate> Bj() {
        return this.avR;
    }

    public final void x(List<CtAdTemplate> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        if (this.avR == null) {
            this.avR = new ArrayList();
        }
        this.avR.clear();
        this.avR.addAll(list);
    }

    public final void Bk() {
        List<CtAdTemplate> list = this.avR;
        if (list != null) {
            list.clear();
        }
        this.avR = null;
    }
}
