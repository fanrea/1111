package com.kwad.components.ct.horizontal.feed.item.presenter.a;

import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.core.u.k;
import com.kwad.components.ct.detail.photo.d.h;
import com.kwad.components.ct.detail.photo.d.i;
import com.kwad.components.ct.detail.photo.d.j;
import com.kwad.components.ct.detail.photo.d.l;
import com.kwad.components.ct.detail.photo.d.m;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.bq;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b extends com.kwad.components.ct.horizontal.feed.item.a.b implements View.OnClickListener {
    private TextView Fa;
    private TextView Pc;
    private ImageView Pe;
    private TextView aMe;
    private i awN;
    private m awO;
    private CtAdTemplate mAdTemplate;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.Pc = (TextView) findViewById(R.id.ksad_horizontal_feed_item_title);
        this.Fa = (TextView) findViewById(R.id.ksad_horizontal_feed_item_author_name);
        this.aMe = (TextView) findViewById(R.id.ksad_horizontal_feed_item_publish_date);
        ImageView imageView = (ImageView) findViewById(R.id.ksad_horizontal_feed_item_close);
        this.Pe = imageView;
        imageView.setOnClickListener(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.kwad.sdk.lib.widget.a.b.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        CtAdTemplate ctAdTemplate = (CtAdTemplate) ((com.kwad.components.ct.horizontal.feed.item.a.a) this.cdN).cdM;
        this.mAdTemplate = ctAdTemplate;
        String strAN = com.kwad.components.ct.response.a.a.aN(ctAdTemplate);
        if (!TextUtils.isEmpty(strAN)) {
            this.Pc.setText(strAN);
            this.Pc.setTextSize(2, k.tG());
            this.Pc.setVisibility(0);
        } else {
            this.Pc.setVisibility(8);
        }
        String strAL = com.kwad.components.ct.response.a.a.aL(this.mAdTemplate);
        if (!TextUtils.isEmpty(strAL)) {
            this.Fa.setText(strAL);
            this.Fa.setVisibility(0);
        } else {
            this.Fa.setVisibility(8);
        }
        this.aMe.setText(bq.bL(com.kwad.components.ct.response.a.a.aP(this.mAdTemplate)));
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.Pe == view) {
            if (com.kwad.components.ct.response.a.a.eH(this.mAdTemplate)) {
                ac.ae(getContext(), "操作成功，将减少此类推荐");
            } else {
                BN();
            }
        }
    }

    private void BN() {
        h hVarAk = new h.a().bv(true).bu(true).bw(true).bx(false).f(this.mAdTemplate).Ak();
        i iVar = this.awN;
        if (iVar == null || !iVar.isShowing()) {
            i iVar2 = new i(getContext(), hVarAk);
            this.awN = iVar2;
            iVar2.a(new i.a() { // from class: com.kwad.components.ct.horizontal.feed.item.presenter.a.b.1
                @Override // com.kwad.components.ct.detail.photo.d.i.a
                public final void Al() {
                    com.kwad.components.ct.e.b.JK().ad(b.this.mAdTemplate);
                }

                @Override // com.kwad.components.ct.detail.photo.d.i.a
                public final void d(com.kwad.components.ct.detail.photo.e.d dVar) {
                    if (dVar instanceof j) {
                        b.this.BO();
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
            mVar2.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.kwad.components.ct.horizontal.feed.item.presenter.a.b.2
                @Override // android.content.DialogInterface.OnShowListener
                public final void onShow(DialogInterface dialogInterface) {
                    com.kwad.components.ct.e.b.JK().ae(b.this.mAdTemplate);
                }
            });
            this.awO.show();
        }
    }
}
