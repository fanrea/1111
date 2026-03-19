package com.kwad.components.ct.detail.photo.comment;

import android.content.Context;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.kwad.components.core.widget.support.KsRecyclerView;
import com.kwad.components.ct.detail.ad.presenter.comment.CommentAdItemView;
import com.kwad.components.ct.request.j;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.components.ct.response.model.home.CommentResponse;
import com.kwad.components.ct.widget.KSHalfPageLoadingView;
import com.kwad.components.ct.widget.KSPageLoadingView;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.ae;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class CommentListPanel extends LinearLayout {
    private List<f> apI;
    private h apJ;
    private List<b> apV;
    private View.OnClickListener apW;
    private e arS;
    private KsRecyclerView arT;
    private d arU;
    private com.kwad.sdk.lib.widget.a.d arV;
    private View arW;
    private View arX;
    private ImageButton arY;
    private KSHalfPageLoadingView arZ;
    private List<c> asa;
    private boolean asb;
    private CommentResponse asc;
    private a asd;
    private View.OnClickListener ase;
    private KSPageLoadingView.a asf;
    RecyclerView.OnScrollListener asg;
    private CtAdTemplate mAdTemplate;

    public interface b {
        void onClose();
    }

    public interface c {
        void bs(boolean z);
    }

    static /* synthetic */ boolean a(CommentListPanel commentListPanel, boolean z) {
        commentListPanel.asb = false;
        return false;
    }

    public static class a {
        long asi = -1;

        a() {
        }

        final void start() {
            this.asi = SystemClock.elapsedRealtime();
        }

        final long zQ() {
            long jElapsedRealtime = this.asi > 0 ? SystemClock.elapsedRealtime() - this.asi : 0L;
            this.asi = -1L;
            return jElapsedRealtime;
        }
    }

    public CommentListPanel(Context context) {
        super(context);
        this.arS = null;
        this.apV = new ArrayList();
        this.asa = new ArrayList();
        this.apI = new ArrayList();
        this.asd = new a();
        this.apW = new View.OnClickListener() { // from class: com.kwad.components.ct.detail.photo.comment.CommentListPanel.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CommentListPanel.this.eQ();
            }
        };
        this.ase = new View.OnClickListener() { // from class: com.kwad.components.ct.detail.photo.comment.CommentListPanel.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
            }
        };
        this.asf = new KSPageLoadingView.a() { // from class: com.kwad.components.ct.detail.photo.comment.CommentListPanel.3
            @Override // com.kwad.components.ct.widget.KSPageLoadingView.a
            public final void zP() {
                CommentListPanel.this.zM();
            }
        };
        this.asg = new RecyclerView.OnScrollListener() { // from class: com.kwad.components.ct.detail.photo.comment.CommentListPanel.4
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public final void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                int iE = com.kwad.sdk.lib.widget.a.e.e(recyclerView);
                Iterator it = CommentListPanel.this.asa.iterator();
                while (it.hasNext()) {
                    ((c) it.next()).bs(iE > 0);
                }
            }
        };
        initView();
    }

    public CommentListPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.arS = null;
        this.apV = new ArrayList();
        this.asa = new ArrayList();
        this.apI = new ArrayList();
        this.asd = new a();
        this.apW = new View.OnClickListener() { // from class: com.kwad.components.ct.detail.photo.comment.CommentListPanel.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CommentListPanel.this.eQ();
            }
        };
        this.ase = new View.OnClickListener() { // from class: com.kwad.components.ct.detail.photo.comment.CommentListPanel.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
            }
        };
        this.asf = new KSPageLoadingView.a() { // from class: com.kwad.components.ct.detail.photo.comment.CommentListPanel.3
            @Override // com.kwad.components.ct.widget.KSPageLoadingView.a
            public final void zP() {
                CommentListPanel.this.zM();
            }
        };
        this.asg = new RecyclerView.OnScrollListener() { // from class: com.kwad.components.ct.detail.photo.comment.CommentListPanel.4
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public final void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                int iE = com.kwad.sdk.lib.widget.a.e.e(recyclerView);
                Iterator it = CommentListPanel.this.asa.iterator();
                while (it.hasNext()) {
                    ((c) it.next()).bs(iE > 0);
                }
            }
        };
        initView();
    }

    private void initView() {
        com.kwad.sdk.c.a.a.a((ViewGroup) this, R.layout.ksad_content_alliance_comment_list_panel_2, true);
        this.apJ = ((i) com.kwad.components.ct.f.d.Kb().a(i.class)).zV();
        com.kwad.components.ct.f.g.r((RelativeLayout) findViewById(R.id.ksad_photo_comment_list_panel_layout), this.apJ.aqv);
        com.kwad.components.ct.f.g.a((TextView) findViewById(R.id.ksad_photo_comment_list_panel_title), this.apJ.aqy);
        ((LinearLayout) findViewById(R.id.ksad_photo_comment_list_space)).setOnClickListener(this.apW);
        ImageButton imageButton = (ImageButton) findViewById(R.id.ksad_photo_comment_list_panel_close);
        this.arY = imageButton;
        com.kwad.components.ct.f.g.a(imageButton, this.apJ.asu);
        this.arY.setOnClickListener(this.apW);
        KsRecyclerView ksRecyclerView = (KsRecyclerView) findViewById(R.id.ksad_photo_comment_list_content);
        this.arT = ksRecyclerView;
        ksRecyclerView.setVisibility(8);
        KSHalfPageLoadingView kSHalfPageLoadingView = (KSHalfPageLoadingView) findViewById(R.id.ksad_comment_page_loading);
        this.arZ = kSHalfPageLoadingView;
        kSHalfPageLoadingView.setRetryClickListener(this.asf);
        this.arZ.hide();
        setOnClickListener(this.ase);
    }

    public final void zM() {
        this.arT.setVisibility(8);
        this.arZ.Cu();
        e eVar = this.arS;
        if (eVar == null) {
            this.arZ.Ly();
            return;
        }
        CommentResponse commentResponse = this.asc;
        if (commentResponse != null) {
            a(commentResponse);
            this.arZ.hide();
        } else {
            if (this.asb) {
                return;
            }
            this.asb = true;
            new com.kwad.components.ct.request.j().a(eVar.zS(), new j.a() { // from class: com.kwad.components.ct.detail.photo.comment.CommentListPanel.5
                @Override // com.kwad.components.ct.request.j.a
                public final void by(int i) {
                    if (com.kwad.sdk.core.network.e.bCy.errorCode == i) {
                        if (com.kwad.components.ct.detail.a.b.yP()) {
                            CommentListPanel.this.arZ.hide();
                            CommentListPanel.this.a(new CommentResponse());
                        } else {
                            CommentListPanel.this.arZ.Ly();
                        }
                        CommentListPanel.this.asd.start();
                        com.kwad.components.ct.e.b.JK().Q(CommentListPanel.this.arS.zR());
                    } else if (com.kwad.sdk.core.network.e.bCw.errorCode == i) {
                        CommentListPanel.this.arZ.Jt();
                    } else {
                        CommentListPanel.this.arZ.Ju();
                    }
                    CommentListPanel.a(CommentListPanel.this, false);
                }

                @Override // com.kwad.components.ct.request.j.a
                public final void c(CommentResponse commentResponse2) {
                    CommentListPanel.this.arZ.hide();
                    CommentListPanel.this.asc = commentResponse2;
                    CommentListPanel.this.a(commentResponse2);
                    CommentListPanel.a(CommentListPanel.this, false);
                }
            });
        }
    }

    protected final void a(CommentResponse commentResponse) {
        this.arT.setItemAnimator(null);
        this.arT.setLayoutManager(rM());
        this.arV = b(commentResponse);
        zN();
        this.arT.setAdapter(this.arV);
        this.arT.setVisibility(0);
        if (com.kwad.components.ct.detail.a.b.yP() && com.kwad.components.ct.response.a.a.eH(this.mAdTemplate)) {
            this.arT.setOnScrollListener(this.asg);
            zO();
        }
        this.asd.start();
        com.kwad.components.ct.e.b.JK().Q(this.arS.zR());
    }

    private com.kwad.sdk.lib.widget.a.d b(CommentResponse commentResponse) {
        this.arS.v(commentResponse.rootComments);
        this.arU = new d(getContext(), this.arS);
        return new com.kwad.sdk.lib.widget.a.d(this.arU);
    }

    private void zN() {
        if (this.arW == null) {
            this.arW = LayoutInflater.from(getContext()).inflate(R.layout.ksad_photo_comment_list_footer_2, (ViewGroup) this.arT, false);
        }
        TextView textView = (TextView) this.arW.findViewById(R.id.ksad_comment_list_footer_tip);
        if (com.kwad.sdk.core.config.e.isShowTips()) {
            if (!this.arV.ad(this.arW)) {
                this.arV.addFooterView(this.arW);
            }
            this.arW.setVisibility(0);
            textView.setText(ae.dr(getContext()));
            return;
        }
        this.arW.setVisibility(8);
    }

    private void zO() {
        if (this.arX == null) {
            this.arX = LayoutInflater.from(getContext()).inflate(R.layout.ksad_photo_comment_list_header, (ViewGroup) this.arT, false);
        }
        CommentAdItemView commentAdItemView = (CommentAdItemView) this.arX.findViewById(R.id.ksad_comment_list_header_ad_item);
        if (this.arV.ae(this.arX)) {
            return;
        }
        commentAdItemView.a(this.mAdTemplate, this.apI);
        this.arV.addHeaderView(this.arX);
    }

    private RecyclerView.LayoutManager rM() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(1);
        return linearLayoutManager;
    }

    public final void a(CtAdTemplate ctAdTemplate, long j) {
        this.mAdTemplate = ctAdTemplate;
        this.arS = new e(ctAdTemplate, j);
    }

    public final void close() {
        d dVar = this.arU;
        long jZL = dVar != null ? dVar.zL() : 0L;
        if (this.arS != null) {
            com.kwad.components.ct.e.b.JK().a(this.arS.zR(), jZL, this.asd.zQ());
        }
    }

    public final void a(b bVar) {
        this.apV.add(bVar);
    }

    public final void b(b bVar) {
        if (this.apV.contains(bVar)) {
            this.apV.remove(bVar);
        }
    }

    public final void a(c cVar) {
        this.asa.add(cVar);
    }

    public final void b(c cVar) {
        this.asa.remove(cVar);
    }

    public final void a(f fVar) {
        this.apI.add(fVar);
    }

    public final void b(f fVar) {
        this.apI.remove(fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eQ() {
        Iterator<b> it = this.apV.iterator();
        while (it.hasNext()) {
            it.next().onClose();
        }
    }

    public final void yN() {
        this.asc = null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            getParent().requestDisallowInterceptTouchEvent(true);
        } else if (action == 1) {
            getParent().requestDisallowInterceptTouchEvent(false);
        } else if (action == 2) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
