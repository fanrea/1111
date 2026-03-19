package com.kwad.components.ct.detail.photo.related;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.kwad.components.ct.response.model.CtAdResultData;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.components.ct.widget.KSHalfPageLoadingView;
import com.kwad.components.ct.widget.KSPageLoadingView;
import com.kwad.sdk.R;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.core.network.e;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.lib.b.f;
import com.kwad.sdk.lib.b.g;
import com.kwad.sdk.utils.ac;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class RelatedVideoPanel extends LinearLayout implements View.OnClickListener, com.kwad.components.core.k.c {
    private boolean JA;
    private RecyclerView Wj;
    private View apQ;
    private com.kwad.sdk.lib.widget.a.d arV;
    private KSHalfPageLoadingView arZ;
    private KSPageLoadingView.a asf;
    private RecyclerView.OnScrollListener asg;
    private View avV;
    private com.kwad.components.ct.widget.b avW;
    private b avX;
    private com.kwad.sdk.lib.b.c<CtAdResultData, CtAdTemplate> avY;
    private a avZ;
    private f awa;
    private CtAdTemplate mAdTemplate;
    private Handler mHandler;
    private SceneImpl mSceneImpl;

    public interface a {
        void Bv();

        void Bw();
    }

    @Override // com.kwad.components.core.k.c
    public final void onDestroy() {
    }

    @Override // com.kwad.components.core.k.c
    public final void onDestroyView() {
    }

    @Override // com.kwad.components.core.k.c
    public final void onPause() {
    }

    @Override // com.kwad.components.core.k.c
    public final void onResume() {
    }

    @Override // com.kwad.components.core.k.c
    public final void qC() {
    }

    public RelatedVideoPanel(Context context) {
        super(context);
        this.mHandler = new Handler();
        this.asf = new KSPageLoadingView.a() { // from class: com.kwad.components.ct.detail.photo.related.RelatedVideoPanel.2
            @Override // com.kwad.components.ct.widget.KSPageLoadingView.a
            public final void zP() {
                if (RelatedVideoPanel.this.avY != null) {
                    RelatedVideoPanel.this.avY.refresh();
                }
            }
        };
        this.awa = new g() { // from class: com.kwad.components.ct.detail.photo.related.RelatedVideoPanel.3
            @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
            public final void m(boolean z, boolean z2) {
                if (z) {
                    if (RelatedVideoPanel.this.avX.isEmpty()) {
                        RelatedVideoPanel.this.arZ.Cu();
                        return;
                    }
                    return;
                }
                RelatedVideoPanel.this.avW.Cu();
            }

            @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
            public final void n(boolean z, boolean z2) {
                RelatedVideoPanel.this.iM();
                RelatedVideoPanel.this.arZ.hide();
                if (z) {
                    if (RelatedVideoPanel.this.avX.isEmpty()) {
                        RelatedVideoPanel.this.arZ.Ju();
                    } else if (!RelatedVideoPanel.this.arV.ad(RelatedVideoPanel.this.avW)) {
                        RelatedVideoPanel.this.arV.addFooterView(RelatedVideoPanel.this.avW);
                    }
                }
                RelatedVideoPanel.this.avW.ce(RelatedVideoPanel.this.avY.Gx());
            }

            @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
            public final void a(boolean z, int i, String str) {
                RelatedVideoPanel.this.arZ.hide();
                if (z) {
                    if (RelatedVideoPanel.this.avX.isEmpty()) {
                        if (e.bCI.errorCode == i) {
                            RelatedVideoPanel.this.arZ.Lx();
                        } else if (e.bCw.errorCode == i) {
                            RelatedVideoPanel.this.arZ.Jt();
                        } else {
                            RelatedVideoPanel.this.arZ.Ju();
                        }
                    }
                } else if (e.bCw.errorCode == i) {
                    ac.dm(RelatedVideoPanel.this.getContext());
                } else if (e.bCI.errorCode != i) {
                    ac.dn(RelatedVideoPanel.this.getContext());
                }
                RelatedVideoPanel.this.avW.ce(RelatedVideoPanel.this.avY.Gx());
            }
        };
        this.asg = new RecyclerView.OnScrollListener() { // from class: com.kwad.components.ct.detail.photo.related.RelatedVideoPanel.4
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public final void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                if (i == 1) {
                    RelatedVideoPanel.this.Bt();
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public final void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                if (i > 0 || i2 > 0) {
                    RelatedVideoPanel.this.Bt();
                }
            }
        };
    }

    public RelatedVideoPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mHandler = new Handler();
        this.asf = new KSPageLoadingView.a() { // from class: com.kwad.components.ct.detail.photo.related.RelatedVideoPanel.2
            @Override // com.kwad.components.ct.widget.KSPageLoadingView.a
            public final void zP() {
                if (RelatedVideoPanel.this.avY != null) {
                    RelatedVideoPanel.this.avY.refresh();
                }
            }
        };
        this.awa = new g() { // from class: com.kwad.components.ct.detail.photo.related.RelatedVideoPanel.3
            @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
            public final void m(boolean z, boolean z2) {
                if (z) {
                    if (RelatedVideoPanel.this.avX.isEmpty()) {
                        RelatedVideoPanel.this.arZ.Cu();
                        return;
                    }
                    return;
                }
                RelatedVideoPanel.this.avW.Cu();
            }

            @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
            public final void n(boolean z, boolean z2) {
                RelatedVideoPanel.this.iM();
                RelatedVideoPanel.this.arZ.hide();
                if (z) {
                    if (RelatedVideoPanel.this.avX.isEmpty()) {
                        RelatedVideoPanel.this.arZ.Ju();
                    } else if (!RelatedVideoPanel.this.arV.ad(RelatedVideoPanel.this.avW)) {
                        RelatedVideoPanel.this.arV.addFooterView(RelatedVideoPanel.this.avW);
                    }
                }
                RelatedVideoPanel.this.avW.ce(RelatedVideoPanel.this.avY.Gx());
            }

            @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
            public final void a(boolean z, int i, String str) {
                RelatedVideoPanel.this.arZ.hide();
                if (z) {
                    if (RelatedVideoPanel.this.avX.isEmpty()) {
                        if (e.bCI.errorCode == i) {
                            RelatedVideoPanel.this.arZ.Lx();
                        } else if (e.bCw.errorCode == i) {
                            RelatedVideoPanel.this.arZ.Jt();
                        } else {
                            RelatedVideoPanel.this.arZ.Ju();
                        }
                    }
                } else if (e.bCw.errorCode == i) {
                    ac.dm(RelatedVideoPanel.this.getContext());
                } else if (e.bCI.errorCode != i) {
                    ac.dn(RelatedVideoPanel.this.getContext());
                }
                RelatedVideoPanel.this.avW.ce(RelatedVideoPanel.this.avY.Gx());
            }
        };
        this.asg = new RecyclerView.OnScrollListener() { // from class: com.kwad.components.ct.detail.photo.related.RelatedVideoPanel.4
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public final void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                if (i == 1) {
                    RelatedVideoPanel.this.Bt();
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public final void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                if (i > 0 || i2 > 0) {
                    RelatedVideoPanel.this.Bt();
                }
            }
        };
    }

    public RelatedVideoPanel(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHandler = new Handler();
        this.asf = new KSPageLoadingView.a() { // from class: com.kwad.components.ct.detail.photo.related.RelatedVideoPanel.2
            @Override // com.kwad.components.ct.widget.KSPageLoadingView.a
            public final void zP() {
                if (RelatedVideoPanel.this.avY != null) {
                    RelatedVideoPanel.this.avY.refresh();
                }
            }
        };
        this.awa = new g() { // from class: com.kwad.components.ct.detail.photo.related.RelatedVideoPanel.3
            @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
            public final void m(boolean z, boolean z2) {
                if (z) {
                    if (RelatedVideoPanel.this.avX.isEmpty()) {
                        RelatedVideoPanel.this.arZ.Cu();
                        return;
                    }
                    return;
                }
                RelatedVideoPanel.this.avW.Cu();
            }

            @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
            public final void n(boolean z, boolean z2) {
                RelatedVideoPanel.this.iM();
                RelatedVideoPanel.this.arZ.hide();
                if (z) {
                    if (RelatedVideoPanel.this.avX.isEmpty()) {
                        RelatedVideoPanel.this.arZ.Ju();
                    } else if (!RelatedVideoPanel.this.arV.ad(RelatedVideoPanel.this.avW)) {
                        RelatedVideoPanel.this.arV.addFooterView(RelatedVideoPanel.this.avW);
                    }
                }
                RelatedVideoPanel.this.avW.ce(RelatedVideoPanel.this.avY.Gx());
            }

            @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
            public final void a(boolean z, int i2, String str) {
                RelatedVideoPanel.this.arZ.hide();
                if (z) {
                    if (RelatedVideoPanel.this.avX.isEmpty()) {
                        if (e.bCI.errorCode == i2) {
                            RelatedVideoPanel.this.arZ.Lx();
                        } else if (e.bCw.errorCode == i2) {
                            RelatedVideoPanel.this.arZ.Jt();
                        } else {
                            RelatedVideoPanel.this.arZ.Ju();
                        }
                    }
                } else if (e.bCw.errorCode == i2) {
                    ac.dm(RelatedVideoPanel.this.getContext());
                } else if (e.bCI.errorCode != i2) {
                    ac.dn(RelatedVideoPanel.this.getContext());
                }
                RelatedVideoPanel.this.avW.ce(RelatedVideoPanel.this.avY.Gx());
            }
        };
        this.asg = new RecyclerView.OnScrollListener() { // from class: com.kwad.components.ct.detail.photo.related.RelatedVideoPanel.4
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                super.onScrollStateChanged(recyclerView, i2);
                if (i2 == 1) {
                    RelatedVideoPanel.this.Bt();
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public final void onScrolled(RecyclerView recyclerView, int i2, int i22) {
                super.onScrolled(recyclerView, i2, i22);
                if (i2 > 0 || i22 > 0) {
                    RelatedVideoPanel.this.Bt();
                }
            }
        };
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        initView();
    }

    private void initView() {
        View viewFindViewById = findViewById(R.id.ksad_related_space);
        this.avV = viewFindViewById;
        viewFindViewById.setOnClickListener(this);
        View viewFindViewById2 = findViewById(R.id.ksad_related_close_button);
        this.apQ = viewFindViewById2;
        viewFindViewById2.setOnClickListener(this);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.ksad_related_recycler_view);
        this.Wj = recyclerView;
        recyclerView.setItemAnimator(null);
        this.Wj.addItemDecoration(new d(2, com.kwad.sdk.c.a.a.j(getContext(), R.dimen.ksad_content_related_video_item_padding)));
        this.arZ = (KSHalfPageLoadingView) findViewById(R.id.ksad_page_loading);
        this.avW = new com.kwad.components.ct.widget.b(getContext());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.avV) {
            Bs();
            bM(3);
        } else if (view == this.apQ) {
            Bs();
            bM(1);
        }
    }

    public void setRelatedPanelListener(a aVar) {
        this.avZ = aVar;
    }

    public final void a(KsFragment ksFragment, CtAdTemplate ctAdTemplate) {
        this.mAdTemplate = ctAdTemplate;
        this.mSceneImpl = ctAdTemplate.mAdScene;
        this.avY = new c(ctAdTemplate);
        this.Wj.setLayoutManager(new StaggeredGridLayoutManager(2, 1));
        b bVar = new b(ksFragment, this.Wj, this.mAdTemplate);
        this.avX = bVar;
        bVar.aC(this.avY.getItems());
        this.avX.a(this.avY);
        com.kwad.sdk.lib.widget.a.d dVar = new com.kwad.sdk.lib.widget.a.d(this.avX);
        this.arV = dVar;
        dVar.d(this.Wj);
        this.Wj.setAdapter(this.arV);
        this.Wj.addOnScrollListener(this.asg);
        this.avY.a(this.awa);
        this.avY.refresh();
        this.arZ.setRetryClickListener(this.asf);
        setVisibility(0);
        setFocusableInTouchMode(true);
        requestFocus();
        setOnKeyListener(new View.OnKeyListener() { // from class: com.kwad.components.ct.detail.photo.related.RelatedVideoPanel.1
            @Override // android.view.View.OnKeyListener
            public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() != 1 || i != 4) {
                    return false;
                }
                RelatedVideoPanel.this.Bs();
                RelatedVideoPanel.this.bM(5);
                return true;
            }
        });
        a aVar = this.avZ;
        if (aVar != null) {
            aVar.Bv();
        }
    }

    public final void Bs() {
        setFocusableInTouchMode(false);
        clearFocus();
        setOnKeyListener(null);
        setVisibility(8);
        a aVar = this.avZ;
        if (aVar != null) {
            aVar.Bw();
        }
        this.arZ.hide();
        this.arZ.setRetryClickListener(null);
        release();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bM(int i) {
        com.kwad.components.ct.e.b.JK().b(this.mSceneImpl, i);
    }

    public final void release() {
        this.JA = false;
        this.mHandler.removeCallbacksAndMessages(null);
        this.Wj.setLayoutManager(null);
        this.Wj.setAdapter(null);
        b bVar = this.avX;
        if (bVar != null) {
            bVar.rT();
            this.avX = null;
        }
        com.kwad.sdk.lib.b.c<CtAdResultData, CtAdTemplate> cVar = this.avY;
        if (cVar != null) {
            cVar.release();
        }
        this.avZ = null;
        com.kwad.components.ct.detail.photo.related.a.Bg().Bk();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iM() {
        if (this.JA) {
            return;
        }
        this.JA = true;
        com.kwad.components.ct.e.b.JK().Z(this.mAdTemplate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bt() {
        RecyclerView.LayoutManager layoutManager = this.Wj.getLayoutManager();
        if (layoutManager.getChildCount() <= 0 || !Bu()) {
            return;
        }
        if (((RecyclerView.LayoutParams) layoutManager.getChildAt(layoutManager.getChildCount() - 1).getLayoutParams()).getViewAdapterPosition() < this.avX.getItemCount() - 6 || this.avX.akU()) {
            return;
        }
        this.avY.akN();
    }

    private boolean Bu() {
        com.kwad.sdk.lib.b.c<CtAdResultData, CtAdTemplate> cVar = this.avY;
        return (cVar == null || cVar.KE() == null || this.avY.KE().isEmpty()) ? false : true;
    }

    @Override // com.kwad.components.core.k.c
    public final void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1000 && i2 == -1) {
            final int intExtra = intent.getIntExtra("KEY_RELATED_VIDEO_DETAIL_POSITION", 0);
            com.kwad.sdk.lib.b.c<CtAdResultData, CtAdTemplate> cVar = this.avY;
            if (cVar != null) {
                cVar.refresh();
                this.mHandler.postDelayed(new Runnable() { // from class: com.kwad.components.ct.detail.photo.related.RelatedVideoPanel.5
                    @Override // java.lang.Runnable
                    public final void run() {
                        RelatedVideoPanel.this.Wj.scrollToPosition(intExtra);
                    }
                }, 100L);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            getParent().requestDisallowInterceptTouchEvent(true);
        } else if (action == 1 || action == 3) {
            getParent().requestDisallowInterceptTouchEvent(false);
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
