package com.kwad.sdk.lib.widget.a;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.lib.b.f;
import com.kwad.sdk.lib.widget.a.a.b;
import com.kwad.sdk.lib.widget.a.b.a;
import com.kwad.sdk.lib.widget.a.b.a.C0623a;
import com.kwad.sdk.mvp.Presenter;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public abstract class c<Model, CallerContext extends a.C0623a<Model>> extends a<Model, com.kwad.sdk.lib.widget.a.b.a<Model, CallerContext>> {
    private static final ExecutorService ccS = new ThreadPoolExecutor(1, 1, 1, TimeUnit.MINUTES, new LinkedBlockingQueue(), new GlobalThreadPools.e(5, "recyclerAdapter"));
    private RecyclerView Wj;
    private KsFragment alG;
    private com.kwad.sdk.lib.b.c<?, Model> avY;
    private f awa;
    private final Set<Presenter> ccT;
    private com.kwad.sdk.lib.widget.a.a.d<Model> ccU;
    private final com.kwad.sdk.lib.widget.a.a.e<Model> ccV;

    protected abstract CallerContext Bm();

    protected abstract Presenter bK(int i);

    protected abstract View f(ViewGroup viewGroup, int i);

    protected boolean l(boolean z, boolean z2) {
        return z;
    }

    public c(KsFragment ksFragment, RecyclerView recyclerView) {
        this.awa = new f() { // from class: com.kwad.sdk.lib.widget.a.c.1
            @Override // com.kwad.sdk.lib.b.f
            public final void a(boolean z, int i, String str) {
            }

            @Override // com.kwad.sdk.lib.b.f
            public final void m(boolean z, boolean z2) {
            }

            @Override // com.kwad.sdk.lib.b.f
            public final void n(boolean z, boolean z2) {
                if (c.this.avY.isEmpty()) {
                    return;
                }
                if (c.this.ccU != null) {
                    c cVar = c.this;
                    cVar.dg(cVar.l(z, z2));
                } else {
                    c cVar2 = c.this;
                    cVar2.aC(cVar2.avY.getItems());
                    c.this.notifyDataSetChanged();
                }
            }

            @Override // com.kwad.sdk.lib.b.f
            public final void df(boolean z) {
                if (c.this.ccU != null) {
                    c.this.dg(z);
                } else {
                    c.this.notifyDataSetChanged();
                }
            }
        };
        this.ccT = new LinkedHashSet();
        this.alG = ksFragment;
        this.Wj = recyclerView;
        this.ccV = null;
    }

    public c(KsFragment ksFragment, RecyclerView recyclerView, com.kwad.sdk.lib.widget.a.a.e<Model> eVar) {
        super(false);
        this.awa = new f() { // from class: com.kwad.sdk.lib.widget.a.c.1
            @Override // com.kwad.sdk.lib.b.f
            public final void a(boolean z, int i, String str) {
            }

            @Override // com.kwad.sdk.lib.b.f
            public final void m(boolean z, boolean z2) {
            }

            @Override // com.kwad.sdk.lib.b.f
            public final void n(boolean z, boolean z2) {
                if (c.this.avY.isEmpty()) {
                    return;
                }
                if (c.this.ccU != null) {
                    c cVar = c.this;
                    cVar.dg(cVar.l(z, z2));
                } else {
                    c cVar2 = c.this;
                    cVar2.aC(cVar2.avY.getItems());
                    c.this.notifyDataSetChanged();
                }
            }

            @Override // com.kwad.sdk.lib.b.f
            public final void df(boolean z) {
                if (c.this.ccU != null) {
                    c.this.dg(z);
                } else {
                    c.this.notifyDataSetChanged();
                }
            }
        };
        this.ccT = new LinkedHashSet();
        this.alG = ksFragment;
        this.Wj = recyclerView;
        this.ccV = eVar;
        this.ccN = new com.kwad.sdk.lib.widget.b(akT());
    }

    public c(KsFragment ksFragment, RecyclerView recyclerView, List<Model> list) {
        super(false);
        this.awa = new f() { // from class: com.kwad.sdk.lib.widget.a.c.1
            @Override // com.kwad.sdk.lib.b.f
            public final void a(boolean z, int i, String str) {
            }

            @Override // com.kwad.sdk.lib.b.f
            public final void m(boolean z, boolean z2) {
            }

            @Override // com.kwad.sdk.lib.b.f
            public final void n(boolean z, boolean z2) {
                if (c.this.avY.isEmpty()) {
                    return;
                }
                if (c.this.ccU != null) {
                    c cVar = c.this;
                    cVar.dg(cVar.l(z, z2));
                } else {
                    c cVar2 = c.this;
                    cVar2.aC(cVar2.avY.getItems());
                    c.this.notifyDataSetChanged();
                }
            }

            @Override // com.kwad.sdk.lib.b.f
            public final void df(boolean z) {
                if (c.this.ccU != null) {
                    c.this.dg(z);
                } else {
                    c.this.notifyDataSetChanged();
                }
            }
        };
        this.ccT = new LinkedHashSet();
        this.alG = ksFragment;
        this.Wj = recyclerView;
        this.ccN = new com.kwad.sdk.lib.widget.b(list);
        this.ccV = null;
    }

    private List<Model> akT() {
        this.ccU = new com.kwad.sdk.lib.widget.a.a.d<>(new com.kwad.sdk.lib.widget.a.a.a(this), new b.a(this.ccV).a(ccS).ald(), this);
        return new com.kwad.sdk.lib.widget.a.a.c(this.ccU);
    }

    public final void a(com.kwad.sdk.lib.b.c<?, Model> cVar) {
        com.kwad.sdk.lib.b.c<?, Model> cVar2 = this.avY;
        if (cVar2 != null) {
            cVar2.b(this.awa);
        }
        this.avY = cVar;
        cVar.a(this.awa);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dg(boolean z) {
        if (z) {
            this.ccU.aD(this.avY.getItems());
        } else {
            this.ccU.submitList(this.avY.getItems());
        }
    }

    public final boolean akU() {
        com.kwad.sdk.lib.widget.a.a.d<Model> dVar = this.ccU;
        return dVar != null && dVar.cdB;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public com.kwad.sdk.lib.widget.a.b.a<Model, CallerContext> onCreateViewHolder(ViewGroup viewGroup, int i) {
        com.kwad.sdk.lib.widget.a.b.a<Model, CallerContext> aVar = new com.kwad.sdk.lib.widget.a.b.a<>(f(viewGroup, i), bK(i), Bm());
        this.ccT.add(aVar.mPresenter);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(com.kwad.sdk.lib.widget.a.b.a<Model, CallerContext> aVar, int i) {
        com.kwad.sdk.core.d.c.d("RecyclerAdapter", "onBindViewHolder position" + i);
        a((c<Model, CallerContext>) aVar.cdK, i);
        aVar.mPresenter.K(aVar.cdK);
    }

    protected void a(CallerContext callercontext, int i) {
        Model item = getItem(i);
        callercontext.alG = this.alG;
        callercontext.Wj = this.Wj;
        callercontext.avY = this.avY;
        callercontext.mCurrentPosition = i;
        callercontext.cdM = item;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onViewRecycled(com.kwad.sdk.lib.widget.a.b.a<Model, CallerContext> aVar) {
        super.onViewRecycled(aVar);
        if (aVar != null) {
            View view = aVar.itemView;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        rT();
    }

    public final void rT() {
        com.kwad.sdk.core.d.c.d("[ThemeMode]", ">> RecyclerAdapter destroyDetachedPresenter");
        for (Presenter presenter : this.ccT) {
            if (presenter != null) {
                presenter.destroy();
            }
        }
        this.ccT.clear();
        com.kwad.sdk.lib.b.c<?, Model> cVar = this.avY;
        if (cVar != null) {
            cVar.b(this.awa);
        }
    }
}
