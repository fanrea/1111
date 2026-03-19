package com.kwad.components.ct.horizontal.news.c;

import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.ct.detail.photo.d.h;
import com.kwad.components.ct.detail.photo.d.i;
import com.kwad.components.ct.detail.photo.d.j;
import com.kwad.components.ct.detail.photo.d.l;
import com.kwad.components.ct.detail.photo.d.m;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.R;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a extends com.kwad.components.ct.horizontal.news.b.a implements View.OnClickListener {
    private View aNM;
    private View aNN;
    private View aNO;
    private ImageView aNP;
    private TextView aNQ;
    private Drawable aNR;
    private final com.kwad.components.ct.horizontal.news.f aNS = new com.kwad.components.ct.horizontal.news.g() { // from class: com.kwad.components.ct.horizontal.news.c.a.1
        @Override // com.kwad.components.ct.horizontal.news.g, com.kwad.components.ct.horizontal.news.f
        public final void aN() {
            a.this.aNO.setClickable(true);
        }
    };
    private i awN;
    private m awO;
    private CtAdTemplate mAdTemplate;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.aNM = findViewById(R.id.ksad_actionbar_container);
        View viewFindViewById = findViewById(R.id.ksad_back_btn);
        this.aNN = viewFindViewById;
        viewFindViewById.setOnClickListener(this);
        View viewFindViewById2 = findViewById(R.id.ksad_more_btn);
        this.aNO = viewFindViewById2;
        viewFindViewById2.setOnClickListener(this);
        this.aNO.setClickable(false);
        this.aNP = (ImageView) findViewById(R.id.ksad_actionbar_author_icon);
        this.aNQ = (TextView) findViewById(R.id.ksad_actionbar_author_name);
        this.aNR = getContext().getResources().getDrawable(R.drawable.ksad_photo_default_author_icon);
    }

    @Override // com.kwad.components.ct.horizontal.news.b.a, com.kwad.sdk.lib.a.a.a, com.kwad.sdk.mvp.Presenter
    public final void ay() throws Resources.NotFoundException {
        super.ay();
        Ib();
        this.mAdTemplate = this.aNz.mEntryAdTemplate;
        com.kwad.sdk.glide.c.h(this.aNz.aGE).hh(com.kwad.components.ct.response.a.a.bf(this.mAdTemplate)).d(this.aNR).f(this.aNR).a(new com.kwad.components.ct.widget.b.a()).b(this.aNP);
        this.aNQ.setText(com.kwad.components.ct.response.a.a.aL(this.mAdTemplate));
        this.aNz.aNK.add(this.aNS);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.aNz.aNK.remove(this.aNS);
    }

    private void Ib() throws Resources.NotFoundException {
        if (com.kwad.components.core.u.e.e(this.aNz.aGE.getActivity())) {
            int statusBarHeight = com.kwad.sdk.c.a.a.getStatusBarHeight(getContext());
            int dimensionPixelOffset = getContext().getResources().getDimensionPixelOffset(R.dimen.ksad_content_actionbar_height);
            ViewGroup.LayoutParams layoutParams = this.aNM.getLayoutParams();
            layoutParams.height = dimensionPixelOffset + statusBarHeight;
            this.aNM.setLayoutParams(layoutParams);
            View view = this.aNM;
            view.setPadding(view.getPaddingLeft(), statusBarHeight, this.aNM.getPaddingRight(), this.aNM.getPaddingBottom());
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.aNN) {
            getActivity().onBackPressed();
        } else if (view == this.aNO) {
            BN();
            com.kwad.components.ct.e.b.JK().L(this.mAdTemplate);
        }
    }

    private void BN() {
        com.kwad.components.ct.detail.photo.d.h hVarAk = new h.a().bv(true).bu(true).bw(true).bx(false).f(this.mAdTemplate).Ak();
        i iVar = this.awN;
        if (iVar == null || !iVar.isShowing()) {
            i iVar2 = new i(getContext(), hVarAk);
            this.awN = iVar2;
            iVar2.a(new i.a() { // from class: com.kwad.components.ct.horizontal.news.c.a.2
                @Override // com.kwad.components.ct.detail.photo.d.i.a
                public final void Al() {
                    com.kwad.components.ct.e.b.JK().ad(a.this.mAdTemplate);
                }

                @Override // com.kwad.components.ct.detail.photo.d.i.a
                public final void d(com.kwad.components.ct.detail.photo.e.d dVar) {
                    if (dVar instanceof j) {
                        a.this.BO();
                    }
                }
            });
            this.awN.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BO() {
        l lVar = new l(this.mAdTemplate);
        m mVar = this.awO;
        if (mVar == null || !mVar.isShowing()) {
            m mVar2 = new m(getContext(), lVar);
            this.awO = mVar2;
            mVar2.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.kwad.components.ct.horizontal.news.c.a.3
                @Override // android.content.DialogInterface.OnShowListener
                public final void onShow(DialogInterface dialogInterface) {
                    com.kwad.components.ct.e.b.JK().ae(a.this.mAdTemplate);
                }
            });
            this.awO.show();
        }
    }
}
