package com.kwad.components.ct.tube.panel.choose.c;

import android.view.ViewTreeObserver;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.components.ct.response.model.CtPhotoInfo;
import com.kwad.sdk.lib.b.c;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b extends com.kwad.components.ct.tube.panel.choose.b.a {
    private RecyclerView Wj;
    private c<?, CtAdTemplate> avY;

    @Override // com.kwad.components.ct.tube.panel.choose.b.a, com.kwad.sdk.lib.a.a.a, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.Wj = this.aXn.Wj;
        this.avY = this.aXn.avY;
        final int i = this.aXn.aXr.mPlayingTubeEpisode.episodeNumber;
        this.Wj.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.kwad.components.ct.tube.panel.choose.c.b.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                int size = b.this.avY.getItems().size();
                if (size > 0) {
                    for (int i2 = 0; i2 < size; i2++) {
                        CtPhotoInfo ctPhotoInfoAy = com.kwad.components.ct.response.a.a.ay((CtAdTemplate) b.this.avY.getItems().get(i2));
                        if (com.kwad.components.ct.response.a.c.o(ctPhotoInfoAy) && i == com.kwad.components.ct.response.a.c.z(ctPhotoInfoAy)) {
                            ((LinearLayoutManager) b.this.Wj.getLayoutManager()).scrollToPositionWithOffset(i2, com.kwad.sdk.c.a.a.a(b.this.getContext(), 176.0f));
                            b.this.Wj.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                        }
                    }
                }
            }
        });
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
    }
}
