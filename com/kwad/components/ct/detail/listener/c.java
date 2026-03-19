package com.kwad.components.ct.detail.listener;

import com.kwad.components.ct.response.model.CtAdTemplate;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class c {
    private final List<com.kwad.components.ct.detail.listener.a> aqs;
    private final List<DetailPageListener> aqt;

    /* synthetic */ c(byte b) {
        this();
    }

    static class a {
        private static final c aqu = new c(0);
    }

    public static c zh() {
        return a.aqu;
    }

    private c() {
        this.aqs = new CopyOnWriteArrayList();
        this.aqt = new CopyOnWriteArrayList();
    }

    public final void a(com.kwad.components.ct.detail.listener.a aVar) {
        if (aVar == null) {
            return;
        }
        this.aqs.add(aVar);
    }

    public final void b(com.kwad.components.ct.detail.listener.a aVar) {
        if (aVar == null) {
            return;
        }
        this.aqs.remove(aVar);
    }

    public final void a(DetailPageListener detailPageListener) {
        if (detailPageListener == null) {
            return;
        }
        this.aqt.add(detailPageListener);
    }

    public final void b(DetailPageListener detailPageListener) {
        if (detailPageListener == null) {
            return;
        }
        this.aqt.remove(detailPageListener);
    }

    public final void e(int i, CtAdTemplate ctAdTemplate) {
        for (com.kwad.components.ct.detail.listener.a aVar : this.aqs) {
            if (aVar != null) {
                aVar.a(i, ctAdTemplate);
            }
        }
    }

    public final void f(int i, CtAdTemplate ctAdTemplate) {
        for (com.kwad.components.ct.detail.listener.a aVar : this.aqs) {
            if (aVar != null) {
                aVar.b(i, ctAdTemplate);
            }
        }
    }

    public final void g(int i, CtAdTemplate ctAdTemplate) {
        for (com.kwad.components.ct.detail.listener.a aVar : this.aqs) {
            if (aVar != null) {
                aVar.c(i, ctAdTemplate);
            }
        }
    }

    public final void h(int i, CtAdTemplate ctAdTemplate) {
        for (com.kwad.components.ct.detail.listener.a aVar : this.aqs) {
            if (aVar != null) {
                aVar.d(i, ctAdTemplate);
            }
        }
    }

    public final void b(int i, CtAdTemplate ctAdTemplate, int i2, int i3) {
        for (com.kwad.components.ct.detail.listener.a aVar : this.aqs) {
            if (aVar != null) {
                aVar.a(i, ctAdTemplate, i2, i3);
            }
        }
    }

    public final void i(int i, CtAdTemplate ctAdTemplate) {
        for (DetailPageListener detailPageListener : this.aqt) {
            if (detailPageListener != null) {
                detailPageListener.onPageEnter(i, ctAdTemplate);
            }
        }
    }

    public final void j(int i, CtAdTemplate ctAdTemplate) {
        for (DetailPageListener detailPageListener : this.aqt) {
            if (detailPageListener != null) {
                detailPageListener.onPageResume(i, ctAdTemplate);
            }
        }
    }

    public final void k(int i, CtAdTemplate ctAdTemplate) {
        for (DetailPageListener detailPageListener : this.aqt) {
            if (detailPageListener != null) {
                detailPageListener.onPagePause(i, ctAdTemplate);
            }
        }
    }

    public final void l(int i, CtAdTemplate ctAdTemplate) {
        for (DetailPageListener detailPageListener : this.aqt) {
            if (detailPageListener != null) {
                detailPageListener.onPageLeave(i, ctAdTemplate);
            }
        }
    }
}
