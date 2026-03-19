package com.kwad.components.ct.home.b;

import android.os.Handler;
import android.os.Looper;
import com.kwad.components.ct.response.model.CtAdTemplate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public abstract class a implements com.kwad.components.ct.api.a.a.a<CtAdTemplate> {
    public final List<CtAdTemplate> aIT = new ArrayList();
    public Handler mHandler = new Handler(Looper.getMainLooper());
    private List<com.kwad.components.ct.api.a.a.b> aIU = new LinkedList();

    public abstract void a(boolean z, boolean z2, int i);

    @Override // com.kwad.components.ct.api.a.a.a
    public final void refresh(int i) {
        if (i == 0) {
            a(false, false, i);
            return;
        }
        if (i == 1 || i == 2 || i == 3 || i == 4) {
            a(true, false, i);
        } else {
            a(false, true, i);
        }
    }

    @Override // com.kwad.components.ct.api.a.a.a
    public final void bk(boolean z) {
        a(false, true, z ? 6 : 5);
    }

    @Override // com.kwad.components.ct.api.a.a.a
    public final void a(com.kwad.components.ct.api.a.a.b bVar) {
        this.aIU.add(bVar);
    }

    @Override // com.kwad.components.ct.api.a.a.a
    public final void b(com.kwad.components.ct.api.a.a.b bVar) {
        this.aIU.remove(bVar);
    }

    @Override // com.kwad.components.ct.api.a.a.a
    public final List<CtAdTemplate> xc() {
        return this.aIT;
    }

    public final boolean isEmpty() {
        List<CtAdTemplate> list = this.aIT;
        return list == null || list.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.components.ct.api.a.a.a
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public int aW(CtAdTemplate ctAdTemplate) {
        return this.aIT.indexOf(ctAdTemplate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.components.ct.api.a.a.a
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public void a(int i, CtAdTemplate ctAdTemplate) {
        if (i < 0 || this.aIT.size() <= i) {
            return;
        }
        this.aIT.set(i, ctAdTemplate);
    }

    @Override // com.kwad.components.ct.api.a.a.a
    public void t(List<CtAdTemplate> list) {
        this.aIT.clear();
        this.aIT.addAll(list);
    }

    @Override // com.kwad.components.ct.api.a.a.a
    public void release() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    protected final void b(boolean z, boolean z2, int i, int i2) {
        Iterator<com.kwad.components.ct.api.a.a.b> it = this.aIU.iterator();
        while (it.hasNext()) {
            it.next().a(z, z2, i, i2);
        }
    }

    public final void d(boolean z, int i, int i2) {
        for (int i3 = 0; i3 < this.aIT.size(); i3++) {
            this.aIT.get(i3).setServerPosition(i3);
        }
        Iterator<com.kwad.components.ct.api.a.a.b> it = this.aIU.iterator();
        while (it.hasNext()) {
            it.next().c(z, i, i2);
        }
    }

    public final void u(int i, String str) {
        Iterator<com.kwad.components.ct.api.a.a.b> it = this.aIU.iterator();
        while (it.hasNext()) {
            it.next().onError(i, str);
        }
    }
}
