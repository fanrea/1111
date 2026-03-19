package com.kwad.components.ct.horizontal.feed.b;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.lib.b.f;
import com.kwad.sdk.lib.b.g;
import com.kwad.sdk.lib.widget.a.e;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.utils.ca;
import java.util.Iterator;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class c extends com.kwad.components.ct.horizontal.feed.a.a {
    private RecyclerView Wj;
    private com.kwad.sdk.lib.widget.a.c<CtAdTemplate, ?> aFU;
    private com.kwad.sdk.lib.b.c<?, CtAdTemplate> avY;
    private int aNe = -1;
    private int aNf = 0;
    private f awa = new g() { // from class: com.kwad.components.ct.horizontal.feed.b.c.1
        @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
        public final void n(boolean z, boolean z2) {
            if (!z || c.this.aFU.isEmpty() || !c.this.HQ() || ((com.kwad.components.ct.horizontal.feed.a.b) c.this.cck).aMY == null) {
                return;
            }
            ((com.kwad.components.ct.horizontal.feed.a.b) c.this.cck).Wj.post(new bh() { // from class: com.kwad.components.ct.horizontal.feed.b.c.1.1
                @Override // com.kwad.sdk.utils.bh
                public final void doTask() {
                    if (ca.v(((LinearLayoutManager) ((com.kwad.components.ct.horizontal.feed.a.b) c.this.cck).Wj.getLayoutManager()).findViewByPosition(0), 70)) {
                        ((com.kwad.components.ct.horizontal.feed.a.b) c.this.cck).aMY.start(0);
                    }
                }
            });
        }
    };
    private final RecyclerView.OnScrollListener asg = new RecyclerView.OnScrollListener() { // from class: com.kwad.components.ct.horizontal.feed.b.c.2
        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public final void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (i2 == 0) {
                return;
            }
            View viewFindViewByPosition = ((LinearLayoutManager) recyclerView.getLayoutManager()).findViewByPosition(c.this.aNe);
            if (viewFindViewByPosition == null) {
                c.this.aNf = i2 <= 0 ? 1 : 2;
                return;
            }
            if (ca.v(viewFindViewByPosition, 80)) {
                c.this.aNf = 0;
                return;
            }
            int i3 = com.kwad.sdk.c.a.a.Z(c.this.Wj)[1];
            int height = c.this.Wj.getHeight() + i3;
            int height2 = viewFindViewByPosition.getHeight();
            int i4 = com.kwad.sdk.c.a.a.Z(viewFindViewByPosition)[1];
            int i5 = i4 + height2;
            if (i2 <= 0) {
                int iFindFirstVisibleItemPosition = com.kwad.components.core.page.recycle.f.b(c.this.Wj).findFirstVisibleItemPosition();
                if (iFindFirstVisibleItemPosition == 0 && c.this.aNe != iFindFirstVisibleItemPosition) {
                    c.this.aNf = 1;
                    return;
                } else {
                    if (i5 <= height || i5 - height <= (height2 * 2) / 10) {
                        return;
                    }
                    c.this.aNf = 1;
                    return;
                }
            }
            if (i3 <= i4 || i3 - i4 <= (height2 * 2) / 10) {
                return;
            }
            c.this.aNf = 2;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public final void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i != 0 || c.this.aNf == 0) {
                return;
            }
            if (!c.this.HQ()) {
                com.kwad.components.ct.horizontal.feed.item.a.a aVar = ((com.kwad.components.ct.horizontal.feed.a.b) c.this.cck).aMX.get(Integer.valueOf(c.this.aNe));
                if (aVar != null) {
                    aVar.aLT.cA(2);
                }
                for (com.kwad.components.ct.horizontal.feed.item.a.a aVar2 : ((com.kwad.components.ct.horizontal.feed.a.b) c.this.cck).aMX.values()) {
                    if (aVar2 != null) {
                        aVar2.aLT.bW(true);
                    }
                }
                return;
            }
            recyclerView.getLayoutManager();
            com.kwad.components.ct.horizontal.feed.item.a.a aVar3 = ((com.kwad.components.ct.horizontal.feed.a.b) c.this.cck).aMX.get(Integer.valueOf(c.this.aNe));
            if (aVar3 != null) {
                aVar3.aLT.cA(2);
            }
            for (com.kwad.components.ct.horizontal.feed.item.a.a aVar4 : ((com.kwad.components.ct.horizontal.feed.a.b) c.this.cck).aMX.values()) {
                if (aVar4 != null) {
                    aVar4.aLT.bW(true);
                }
            }
            c cVar = c.this;
            cVar.aNe = com.kwad.components.core.page.recycle.f.b(cVar.Wj).findFirstCompletelyVisibleItemPosition();
            com.kwad.components.ct.horizontal.feed.item.a.a aVar5 = ((com.kwad.components.ct.horizontal.feed.a.b) c.this.cck).aMX.get(Integer.valueOf(c.this.aNe));
            if (aVar5 != null) {
                aVar5.aLT.start(false);
            }
            c.this.aNf = 0;
        }
    };
    private com.kwad.components.ct.horizontal.feed.item.presenter.play.a aMY = new com.kwad.components.ct.horizontal.feed.item.presenter.play.a() { // from class: com.kwad.components.ct.horizontal.feed.b.c.3
        @Override // com.kwad.components.ct.horizontal.feed.item.presenter.play.a
        public final void start(int i) {
            Iterator<com.kwad.components.ct.horizontal.feed.item.a.a> it = ((com.kwad.components.ct.horizontal.feed.a.b) c.this.cck).aMX.values().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.kwad.components.ct.horizontal.feed.item.a.a next = it.next();
                if (next != null) {
                    next.aLT.bW(true);
                }
            }
            boolean z = c.this.aNe == i;
            c.this.aNe = i;
            com.kwad.components.ct.horizontal.feed.item.a.a aVar = ((com.kwad.components.ct.horizontal.feed.a.b) c.this.cck).aMX.get(Integer.valueOf(c.this.aNe));
            if (aVar != null) {
                aVar.aLT.start(z);
            }
            ((com.kwad.components.ct.horizontal.feed.a.b) c.this.cck).ant = false;
        }

        @Override // com.kwad.components.ct.horizontal.feed.item.presenter.play.a
        public final void pause(int i) {
            com.kwad.components.ct.horizontal.feed.item.a.a aVar = ((com.kwad.components.ct.horizontal.feed.a.b) c.this.cck).aMX.get(Integer.valueOf(i));
            if (aVar != null) {
                aVar.aLT.bW(false);
            }
            ((com.kwad.components.ct.horizontal.feed.a.b) c.this.cck).ant = true;
        }

        @Override // com.kwad.components.ct.horizontal.feed.item.presenter.play.a
        public final void cy(int i) {
            if (c.this.HK() && i == c.this.aNe) {
                com.kwad.components.ct.horizontal.feed.item.a.a aVar = ((com.kwad.components.ct.horizontal.feed.a.b) c.this.cck).aMX.get(Integer.valueOf(c.this.aNe));
                if (aVar != null) {
                    aVar.aLT.bW(true);
                    aVar.aLT.cA(1);
                }
                c.v(c.this);
                com.kwad.components.ct.horizontal.feed.item.a.a aVar2 = ((com.kwad.components.ct.horizontal.feed.a.b) c.this.cck).aMX.get(Integer.valueOf(c.this.aNe));
                if (aVar2 != null) {
                    aVar2.aLT.start(false);
                }
                e.a(c.this.Wj, c.this.aNe);
            }
            ((com.kwad.components.ct.horizontal.feed.a.b) c.this.cck).ant = false;
        }

        @Override // com.kwad.components.ct.horizontal.feed.item.presenter.play.a
        public final void cz(int i) {
            com.kwad.components.ct.horizontal.feed.item.a.a aVar = ((com.kwad.components.ct.horizontal.feed.a.b) c.this.cck).aMX.get(Integer.valueOf(i));
            if (aVar != null) {
                aVar.aLT.cA(5);
            }
        }
    };

    static /* synthetic */ int v(c cVar) {
        int i = cVar.aNe;
        cVar.aNe = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean HQ() {
        if (this.cck == 0 || !((com.kwad.components.ct.horizontal.feed.a.b) this.cck).aMZ || ((com.kwad.components.ct.horizontal.feed.a.b) this.cck).ant) {
            return false;
        }
        if (ao.isNetworkConnected(getContext()) || ((com.kwad.components.ct.horizontal.feed.a.b) this.cck).aNa) {
            return ao.isWifiConnected(getContext()) || !com.kwad.components.ct.horizontal.b.a.Is();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean HK() {
        if (!com.kwad.components.ct.horizontal.a.b.Hp() || this.cck == 0 || ((com.kwad.components.ct.horizontal.feed.a.b) this.cck).ant) {
            return false;
        }
        return ao.isNetworkConnected(getContext()) || ((com.kwad.components.ct.horizontal.feed.a.b) this.cck).aNa;
    }

    @Override // com.kwad.components.ct.horizontal.feed.a.a, com.kwad.sdk.lib.a.a.a, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.Wj = ((com.kwad.components.ct.horizontal.feed.a.b) this.cck).Wj;
        this.avY = ((com.kwad.components.ct.horizontal.feed.a.b) this.cck).avY;
        this.aFU = ((com.kwad.components.ct.horizontal.feed.a.b) this.cck).aFU;
        this.avY.a(this.awa);
        ((com.kwad.components.ct.horizontal.feed.a.b) this.cck).Wj.addOnScrollListener(this.asg);
        ((com.kwad.components.ct.horizontal.feed.a.b) this.cck).aMY = this.aMY;
        this.aNe = 0;
        this.aNf = 0;
        ((com.kwad.components.ct.horizontal.feed.a.b) this.cck).aMZ = com.kwad.components.ct.horizontal.a.b.Ho();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        ((com.kwad.components.ct.horizontal.feed.a.b) this.cck).Wj.removeOnScrollListener(this.asg);
        this.avY.b(this.awa);
    }
}
