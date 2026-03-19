package com.kwad.components.ct.detail.photo.e;

import android.view.View;
import java.util.HashSet;
import java.util.Set;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class h extends com.kwad.components.ct.detail.photo.e.a<i> {
    private long arK = 0;
    private long aww;
    private i awx;

    @Override // com.kwad.components.ct.detail.photo.e.a, com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.awx = BA();
    }

    @Override // com.kwad.components.ct.detail.photo.e.a, com.kwad.components.ct.detail.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.aop.aoC = true;
        this.aww = com.kwad.components.ct.response.a.a.bg(this.aop.mAdTemplate);
        this.arK = BE();
        this.awx.b(a.Y(this.aww) ? 2 : 1, this.arK);
        this.awx.setOnClickListener(this);
    }

    private long BE() {
        long jAH = com.kwad.components.ct.response.a.a.aH(this.aop.mAdTemplate);
        if (jAH < 0) {
            jAH = 0;
        }
        return a.Y(this.aww) ? jAH + 1 : jAH;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.awx.setOnClickListener(null);
        this.awx.zJ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.components.ct.detail.photo.e.d
    /* renamed from: BF, reason: merged with bridge method [inline-methods] */
    public i Ag() {
        return new i(getContext());
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        boolean z = true;
        if (this.awx.zI()) {
            this.awx.setLikeState(1);
            i iVar = this.awx;
            long j = this.arK - 1;
            this.arK = j;
            iVar.setLikeCount(j);
            a.X(this.aww);
            com.kwad.components.ct.e.b.JK().M(this.aop.mAdTemplate);
            z = false;
        } else {
            this.awx.setLikeState(2);
            i iVar2 = this.awx;
            long j2 = this.arK + 1;
            this.arK = j2;
            iVar2.setLikeCount(j2);
            a.W(this.aww);
            com.kwad.components.ct.e.b.JK().f(this.aop.mAdTemplate, 1, 2);
        }
        if (this.aop.aol.aHd != null) {
            this.aop.aol.aHd.onClickLikeBtn(com.kwad.components.ct.response.a.a.ax(this.aop.mAdTemplate), z);
        }
    }

    public final void BG() {
        if (!this.awx.zI()) {
            this.awx.setLikeState(2);
            i iVar = this.awx;
            long j = this.arK + 1;
            this.arK = j;
            iVar.setLikeCount(j);
            a.W(this.aww);
            com.kwad.components.ct.e.b.JK().f(this.aop.mAdTemplate, 1, 1);
            return;
        }
        com.kwad.components.ct.e.b.JK().f(this.aop.mAdTemplate, 2, 1);
    }

    public static class a {
        private static Set<Long> awy = new HashSet();

        public static void W(long j) {
            awy.add(Long.valueOf(j));
        }

        public static void X(long j) {
            awy.remove(Long.valueOf(j));
        }

        public static boolean Y(long j) {
            return awy.contains(Long.valueOf(j));
        }
    }
}
