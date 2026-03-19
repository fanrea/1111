package com.kwad.components.ct.detail.photo.presenter;

import android.view.KeyEvent;
import android.view.View;
import com.kwad.components.core.e.d.a;
import com.kwad.components.ct.detail.ad.presenter.comment.CommentBottomAdPanel;
import com.kwad.components.ct.detail.photo.comment.CommentListPanel;
import com.kwad.components.ct.detail.photo.comment.g;
import com.kwad.components.ct.detail.photo.e.f;
import com.kwad.components.ct.detail.viewpager.SlidePlayViewPager;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.R;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.service.ServiceProvider;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a extends com.kwad.components.ct.detail.b {
    private SlidePlayViewPager aok;
    private CommentListPanel auQ;
    private CommentBottomAdPanel auR;
    private List<g> auW;

    /* renamed from: if, reason: not valid java name */
    private AdBaseFrameLayout f17if;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;
    private int auS = 0;
    private com.kwad.sdk.core.j.c gZ = new com.kwad.sdk.core.j.d() { // from class: com.kwad.components.ct.detail.photo.presenter.a.1
        @Override // com.kwad.sdk.core.j.d, com.kwad.sdk.core.j.c
        public final void bz() {
            a.this.AK();
        }
    };
    private com.kwad.components.core.k.a aoQ = new com.kwad.components.core.k.b() { // from class: com.kwad.components.ct.detail.photo.presenter.a.2
        @Override // com.kwad.components.core.k.b, com.kwad.components.core.k.a
        public final void qz() {
            a.this.aop.aov = false;
            a.this.AK();
        }
    };
    View.OnKeyListener auT = new View.OnKeyListener() { // from class: com.kwad.components.ct.detail.photo.presenter.a.3
        @Override // android.view.View.OnKeyListener
        public final boolean onKey(View view, int i, KeyEvent keyEvent) {
            if (i != 4 || keyEvent.getAction() != 1) {
                return false;
            }
            a.this.AK();
            return true;
        }
    };
    private CommentBottomAdPanel.b auU = new CommentBottomAdPanel.b() { // from class: com.kwad.components.ct.detail.photo.presenter.a.4
        @Override // com.kwad.components.ct.detail.ad.presenter.comment.CommentBottomAdPanel.b
        public final void onClose() {
            com.kwad.sdk.core.d.c.d("PhotoCommentListPresenter", " mCommentBottomAdPanel PanelCloseListener close");
            a.this.aop.aov = true;
            a.this.by(false);
        }
    };
    private com.kwad.components.ct.detail.photo.comment.f auV = new com.kwad.components.ct.detail.photo.comment.f() { // from class: com.kwad.components.ct.detail.photo.presenter.a.5
        @Override // com.kwad.components.ct.detail.photo.comment.f
        public final void u(int i, int i2) {
            try {
                if ((a.this.aop.aoy instanceof com.kwad.components.ct.detail.ad.a) && com.kwad.components.core.u.d.tu()) {
                    com.kwad.components.ct.e.b.JK().b(a.this.aop.mAdTemplate, 1);
                }
                com.kwad.components.core.e.d.a.a(new a.C0469a(a.this.getContext()).aC(a.this.aop.mAdTemplate).b(a.this.mApkDownloadHelper).aG(i2).aq(true).aF(i).d(a.this.f17if.getTouchCoords()).as(true));
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
            }
        }
    };
    private CommentListPanel.b auX = new CommentListPanel.b() { // from class: com.kwad.components.ct.detail.photo.presenter.a.6
        @Override // com.kwad.components.ct.detail.photo.comment.CommentListPanel.b
        public final void onClose() {
            a.this.AK();
        }
    };
    private CommentListPanel.c auY = new CommentListPanel.c() { // from class: com.kwad.components.ct.detail.photo.presenter.a.7
        @Override // com.kwad.components.ct.detail.photo.comment.CommentListPanel.c
        public final void bs(boolean z) {
            if (!z || a.this.aop.aov) {
                if (a.this.auS == 1) {
                    return;
                } else {
                    a.this.by(false);
                }
            } else {
                if (a.this.auS == 2) {
                    return;
                }
                a.this.auR.a(a.this.aop.mAdTemplate, a.this.mApkDownloadHelper);
                com.kwad.sdk.core.adlog.c.r(a.this.aop.mAdTemplate, 89);
                a.this.auR.a(a.this.auU);
                a.a(a.this, 2);
                a.this.auR.k(true, false);
            }
            com.kwad.sdk.core.d.c.d("PhotoCommentListPresenter", " onShowBottomAdBanner + show:" + z + "  mHasCloseBottomAdBanner: " + a.this.aop.aov);
        }
    };
    private f.a auZ = new f.a() { // from class: com.kwad.components.ct.detail.photo.presenter.a.8
        @Override // com.kwad.components.ct.detail.photo.e.f.a
        public final void b(CtAdTemplate ctAdTemplate, long j) {
            a.this.auQ.a(ctAdTemplate, j);
            a.this.auQ.zM();
            a.this.AL();
        }
    };

    static /* synthetic */ int a(a aVar, int i) {
        aVar.auS = 2;
        return 2;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.auQ = (CommentListPanel) findViewById(R.id.ksad_photo_comment_list_panel);
        this.f17if = (AdBaseFrameLayout) findViewById(R.id.ksad_root_container);
        this.auR = (CommentBottomAdPanel) findViewById(R.id.ksad_photo_comment_bottom_ad_panel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AK() {
        if (this.auQ.getVisibility() == 8) {
            return;
        }
        this.aok.h(true, 4);
        this.aop.aoA = false;
        if (this.auQ.getVisibility() == 0) {
            this.auQ.setVisibility(8);
            this.auQ.setFocusableInTouchMode(false);
            this.auQ.setOnKeyListener(null);
            this.auQ.close();
            AN();
        }
        by(true);
        this.auS = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void by(boolean z) {
        this.auS = 1;
        this.auR.b(this.auU);
        this.auR.yN();
        this.auR.k(false, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AL() {
        this.aok.h(false, 4);
        this.auQ.setVisibility(0);
        this.auQ.setFocusableInTouchMode(true);
        this.auQ.requestFocus();
        this.auQ.setOnKeyListener(this.auT);
        this.aop.aoA = true;
        AM();
    }

    private void AM() {
        List<g> list = this.auW;
        if (list != null) {
            Iterator<g> it = list.iterator();
            while (it.hasNext()) {
                it.next().zp();
            }
        }
    }

    private void AN() {
        List<g> list = this.auW;
        if (list != null) {
            Iterator<g> it = list.iterator();
            while (it.hasNext()) {
                it.next().onClose();
            }
        }
    }

    @Override // com.kwad.components.ct.detail.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.aok = this.aop.aok;
        if (this.aop.aol != null) {
            this.auW = this.aop.aol.auW;
        }
        this.aop.aoq.add(this.aoQ);
        this.mApkDownloadHelper = this.aop.mApkDownloadHelper;
        if (this.aop.aoz != null) {
            this.aop.aoz.c(this.gZ);
        }
        this.aop.aou.add(this.auZ);
        this.auQ.a(this.auX);
        if (com.kwad.components.ct.detail.a.b.yP() && com.kwad.components.ct.response.a.a.eH(this.aop.mAdTemplate)) {
            this.auQ.a(this.auY);
            this.auQ.a(this.auV);
        }
        if ((this.aop.aoy instanceof com.kwad.components.ct.detail.ad.a) && com.kwad.components.core.u.d.tu()) {
            this.auR.setAdClickListener(new CommentBottomAdPanel.a() { // from class: com.kwad.components.ct.detail.photo.presenter.a.9
                @Override // com.kwad.components.ct.detail.ad.presenter.comment.CommentBottomAdPanel.a
                public final void onClick() {
                    com.kwad.components.ct.e.b.JK().b(a.this.aop.mAdTemplate, 1);
                }
            });
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.auW = null;
        this.aop.aoq.remove(this.aoQ);
        this.aop.aou.remove(this.auZ);
        if (this.aop.aoz != null) {
            this.aop.aoz.d(this.gZ);
        }
        AK();
        this.auQ.b(this.auX);
        this.auQ.b(this.auY);
        this.auQ.b(this.auV);
        this.auQ.yN();
        by(true);
        this.auS = 0;
    }
}
