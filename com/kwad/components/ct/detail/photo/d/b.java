package com.kwad.components.ct.detail.photo.d;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.kwad.components.ct.request.b;
import com.kwad.components.ct.response.model.CtPhotoInfo;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.ac;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b extends a<LinearLayout> {
    private com.kwad.components.ct.detail.photo.newui.b.a asM;
    private h asN;
    private com.kwad.components.ct.detail.photo.e.c asO;
    private com.kwad.components.ct.request.b asP;
    private long mAuthorId;

    @Override // com.kwad.components.ct.detail.photo.d.a, com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        J(this.asM);
    }

    @Override // com.kwad.components.ct.detail.photo.d.a, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.asO = this.asK.asO;
        h hVar = this.asK.ati;
        this.asN = hVar;
        this.mAuthorId = com.kwad.components.ct.response.a.c.e(hVar.mAdTemplate.photoInfo);
        this.asM.setButtonText(getContext().getString(this.asN.mAdTemplate.photoInfo.authorInfo.isJoinedBlacklist ? R.string.ksad_out_blacklist : R.string.ksad_in_blacklist));
        Ad();
        com.kwad.components.ct.e.b.JK().O(this.asN.mAdTemplate);
        this.asP = new com.kwad.components.ct.request.b();
    }

    private void Ad() {
        com.kwad.components.ct.detail.photo.a.a aVarZj;
        com.kwad.components.ct.detail.photo.a.b bVar = (com.kwad.components.ct.detail.photo.a.b) com.kwad.components.ct.f.d.Kb().a(com.kwad.components.ct.detail.photo.a.b.class);
        if (this.asN.atn) {
            aVarZj = bVar.zk();
        } else {
            aVarZj = bVar.zj();
        }
        this.asM.setButtonImageResource(aVarZj.aqF);
    }

    private static void J(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        if (marginLayoutParams != null) {
            marginLayoutParams.leftMargin += com.kwad.sdk.c.a.a.a(view.getContext(), -6.0f);
            view.setLayoutParams(marginLayoutParams);
        }
    }

    @Override // com.kwad.components.ct.detail.photo.d.a, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.asP.release();
        this.asO = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.components.ct.detail.photo.e.d
    /* renamed from: Ae, reason: merged with bridge method [inline-methods] */
    public LinearLayout Ag() {
        return Af();
    }

    private com.kwad.components.ct.detail.photo.newui.b.a Af() {
        com.kwad.components.ct.detail.photo.newui.b.a aVar = new com.kwad.components.ct.detail.photo.newui.b.a(getContext());
        this.asM = aVar;
        return aVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        final CtPhotoInfo.AuthorInfo authorInfo = this.asN.mAdTemplate.photoInfo.authorInfo;
        this.asP.a(String.valueOf(this.mAuthorId), authorInfo.isJoinedBlacklist ? 2 : 1, new b.a() { // from class: com.kwad.components.ct.detail.photo.d.b.1
            @Override // com.kwad.components.ct.request.b.a
            public final void zH() {
                ac.ae(b.this.getContext(), b.this.getContext().getString(R.string.ksad_operation_failed_tips));
                if (b.this.asO != null) {
                    b.this.asO.b(b.this);
                }
            }

            @Override // com.kwad.components.ct.request.b.a
            public final void Ah() {
                authorInfo.isJoinedBlacklist = !r0.isJoinedBlacklist;
                ac.ae(b.this.getContext(), b.this.getContext().getString(authorInfo.isJoinedBlacklist ? R.string.ksad_has_joined_blacklist : R.string.ksad_has_removed_blacklist));
                if (b.this.asO != null) {
                    b.this.asO.b(b.this);
                }
                com.kwad.components.ct.e.b.JK().d(b.this.asN.mAdTemplate, authorInfo.isJoinedBlacklist);
            }
        });
    }

    @Override // com.kwad.components.ct.detail.photo.d.a, com.kwad.components.ct.detail.photo.e.d
    public final Object getData() {
        return this.asN;
    }
}
