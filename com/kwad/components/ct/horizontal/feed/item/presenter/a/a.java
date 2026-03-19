package com.kwad.components.ct.horizontal.feed.item.presenter.a;

import android.content.DialogInterface;
import android.view.View;
import android.widget.ImageView;
import com.kwad.components.ct.detail.photo.d.l;
import com.kwad.components.ct.detail.photo.d.m;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.R;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a extends com.kwad.components.ct.horizontal.feed.item.a.b implements View.OnClickListener {
    private ImageView Pe;
    private m awO;
    private CtAdTemplate mAdTemplate;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        ImageView imageView = (ImageView) findViewById(R.id.ksad_horizontal_feed_item_close);
        this.Pe = imageView;
        imageView.setOnClickListener(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.kwad.sdk.lib.widget.a.b.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.mAdTemplate = (CtAdTemplate) ((com.kwad.components.ct.horizontal.feed.item.a.a) this.cdN).cdM;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.Pe == view) {
            BO();
        }
    }

    private void BO() {
        l lVar = new l(this.mAdTemplate);
        m mVar = this.awO;
        if (mVar == null || !mVar.isShowing()) {
            m mVar2 = new m(getContext(), lVar);
            this.awO = mVar2;
            mVar2.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.kwad.components.ct.horizontal.feed.item.presenter.a.a.1
                @Override // android.content.DialogInterface.OnShowListener
                public final void onShow(DialogInterface dialogInterface) {
                    com.kwad.components.ct.e.b.JK().ae(a.this.mAdTemplate);
                }
            });
            this.awO.show();
        }
    }
}
