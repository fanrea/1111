package com.kwad.components.ct.detail.photo.e;

import android.view.View;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.ac;
import java.util.Iterator;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class f extends com.kwad.components.ct.detail.photo.e.a<g> {
    private g awu;
    private CtAdTemplate mAdTemplate;

    public interface a {
        void b(CtAdTemplate ctAdTemplate, long j);
    }

    @Override // com.kwad.components.ct.detail.photo.e.a, com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.awu = (g) this.awq;
    }

    @Override // com.kwad.components.ct.detail.photo.e.a, com.kwad.components.ct.detail.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.aop.aoD = true;
        CtAdTemplate ctAdTemplate = this.aop.mAdTemplate;
        this.mAdTemplate = ctAdTemplate;
        long jAI = com.kwad.components.ct.response.a.a.aI(ctAdTemplate);
        if (com.kwad.components.ct.detail.a.b.yP() && com.kwad.components.ct.response.a.a.eH(this.mAdTemplate)) {
            jAI++;
        }
        this.awu.setCommentCount(jAI);
        this.awu.setOnClickListener(this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.awu.setOnClickListener(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.components.ct.detail.photo.e.d
    /* renamed from: BC, reason: merged with bridge method [inline-methods] */
    public g Ag() {
        return new g(getContext());
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (com.kwad.components.ct.response.a.a.eH(this.mAdTemplate) && !com.kwad.components.ct.detail.a.b.yP()) {
            ac.ae(view.getContext(), view.getContext().getString(R.string.ksad_ad_function_disable));
        } else {
            BD();
        }
        if (this.aop.aol.aHd != null) {
            this.aop.aol.aHd.onCommentsClick(com.kwad.components.ct.response.a.a.ax(this.mAdTemplate));
        }
        com.kwad.components.ct.e.b.JK().P(this.aop.mAdTemplate);
        com.kwad.sdk.components.d.g(com.kwad.components.ec.api.a.class);
    }

    private void BD() {
        Iterator<a> it = this.aop.aou.iterator();
        while (it.hasNext()) {
            it.next().b(this.aop.mAdTemplate, this.aop.abR);
        }
    }
}
