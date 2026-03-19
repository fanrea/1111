package com.kwad.components.ct.tube.channel.home.d;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.kwad.components.core.widget.support.KsRecyclerView;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.components.ct.response.model.CtPhotoInfo;
import com.kwad.components.ct.response.model.tube.TubeEpisode;
import com.kwad.components.ct.response.model.tube.TubeInfo;
import com.kwad.components.ct.tube.channel.home.request.TubeChannelResultData;
import com.kwad.components.ct.tube.history.TubeHistoryDetailParam;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.ap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a extends com.kwad.components.ct.tube.channel.home.c.a implements com.kwad.components.ct.f.b {
    private ViewGroup DU;
    private TextView Pc;
    private com.kwad.components.ct.f.f<a> aDL;
    private ImageView aWA;
    private com.kwad.components.ct.tube.channel.home.a.a aWB;
    private TextView aWz;
    private KsRecyclerView arT;
    private final com.kwad.components.ct.detail.listener.a amS = new com.kwad.components.ct.detail.listener.b() { // from class: com.kwad.components.ct.tube.channel.home.d.a.1
        @Override // com.kwad.components.ct.detail.listener.b, com.kwad.components.ct.detail.listener.a
        public final void a(int i, CtAdTemplate ctAdTemplate) {
            CtPhotoInfo ctPhotoInfoAy = com.kwad.components.ct.response.a.a.ay(ctAdTemplate);
            if (com.kwad.components.ct.response.a.c.o(ctPhotoInfoAy)) {
                TubeEpisode tubeEpisodeP = com.kwad.components.ct.response.a.c.p(ctPhotoInfoAy);
                TubeInfo tubeInfo = tubeEpisodeP.tubeInfo;
                tubeInfo.lastWatchTime = System.currentTimeMillis();
                tubeInfo.watchEpisodeNum = tubeEpisodeP.episodeNumber;
                if (a.this.aWB != null) {
                    a.this.a(new ArrayList(a.this.aWB.akS()), tubeInfo);
                    return;
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(tubeInfo);
                a.this.Q(arrayList);
            }
        }
    };
    private final com.kwad.sdk.lib.b.f awa = new com.kwad.sdk.lib.b.g() { // from class: com.kwad.components.ct.tube.channel.home.d.a.2
        @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
        public final void n(boolean z, boolean z2) {
            super.n(z, z2);
            if (!z || a.this.aWq.aFU.isEmpty()) {
                return;
            }
            a.this.clearHeader();
            TubeChannelResultData tubeChannelResultData = (TubeChannelResultData) a.this.aWq.avY.akR();
            if (tubeChannelResultData != null) {
                List<TubeInfo> list = tubeChannelResultData.lastWatchInfoList;
                if (ap.aF(list)) {
                    return;
                }
                a.this.Q(list);
            }
        }
    };

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.aDL = new com.kwad.components.ct.f.f<>(this);
        this.DU = new FrameLayout(getContext());
    }

    @Override // com.kwad.components.ct.tube.channel.home.c.a, com.kwad.sdk.lib.a.a.a, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.aWq.aFW.addHeaderView(this.DU);
        this.aWq.avY.a(this.awa);
        com.kwad.components.ct.detail.listener.c.zh().a(this.amS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kq() {
        TubeHistoryDetailParam tubeHistoryDetailParam = new TubeHistoryDetailParam();
        tubeHistoryDetailParam.mEntryScene = this.aWq.mSceneImpl.entryScene;
        tubeHistoryDetailParam.mKSTubeParam = this.aWq.aWo.mTubeParam;
        com.kwad.components.ct.tube.history.a.a(getContext(), tubeHistoryDetailParam);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.aWq.avY.b(this.awa);
        com.kwad.components.ct.detail.listener.c.zh().b(this.amS);
        clearHeader();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearHeader() {
        com.kwad.components.ct.tube.channel.home.a.a aVar = this.aWB;
        if (aVar != null) {
            aVar.rT();
            this.DU.removeAllViews();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q(List<TubeInfo> list) {
        if (list.size() > 10) {
            list = list.subList(0, 10);
        }
        View viewA = com.kwad.sdk.c.a.a.a((ViewGroup) getRootView(), R.layout.ksad_tube_channel_header_history_card_layout, false);
        this.DU.addView(viewA);
        FrameLayout frameLayout = (FrameLayout) viewA.findViewById(R.id.ksad_tube_history_item_title_bar);
        this.Pc = (TextView) viewA.findViewById(R.id.ksad_tube_history_item_title);
        this.aWz = (TextView) viewA.findViewById(R.id.ksad_tube_history_item_enter);
        this.aWA = (ImageView) viewA.findViewById(R.id.ksad_tube_history_item_enter_icon);
        this.arT = (KsRecyclerView) viewA.findViewById(R.id.ksad_history_item_rec);
        this.arT.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        com.kwad.components.ct.tube.channel.home.a.a aVar = new com.kwad.components.ct.tube.channel.home.a.a(this.aWq.aGE, this.arT, this.aWq, list);
        this.aWB = aVar;
        this.arT.setAdapter(aVar);
        frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ct.tube.channel.home.d.a.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                a.this.Kq();
            }
        });
        com.kwad.components.ct.f.d.Kb().a(this.aDL);
        Ke();
    }

    private void Ke() {
        com.kwad.components.ct.f.g.a(this.aWz, Kj().aZp);
        com.kwad.components.ct.f.g.a(this.aWA, Kj().aZx);
        com.kwad.components.ct.f.g.a(this.Pc, Kj().aZo);
    }

    private static com.kwad.components.ct.tube.c.a Kj() {
        return ((com.kwad.components.ct.tube.c.b) com.kwad.components.ct.f.d.Kb().a(com.kwad.components.ct.tube.c.b.class)).Lc();
    }

    @Override // com.kwad.components.ct.f.b
    public final void cg(int i) {
        Ke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<TubeInfo> list, TubeInfo tubeInfo) {
        for (TubeInfo tubeInfo2 : list) {
            if (tubeInfo2.tubeId == tubeInfo.tubeId) {
                tubeInfo2.lastWatchTime = System.currentTimeMillis();
                tubeInfo2.watchEpisodeNum = tubeInfo.watchEpisodeNum;
                Collections.sort(list, new Comparator<TubeInfo>() { // from class: com.kwad.components.ct.tube.channel.home.d.a.4
                    @Override // java.util.Comparator
                    public final /* synthetic */ int compare(TubeInfo tubeInfo3, TubeInfo tubeInfo4) {
                        return a(tubeInfo3, tubeInfo4);
                    }

                    private static int a(TubeInfo tubeInfo3, TubeInfo tubeInfo4) {
                        long j = tubeInfo3.lastWatchTime - tubeInfo4.lastWatchTime;
                        if (j < 0) {
                            return 1;
                        }
                        return j > 0 ? -1 : 0;
                    }
                });
                R(list);
                return;
            }
        }
        if (list.size() >= 10) {
            list.remove(list.size() - 1);
        }
        list.add(0, tubeInfo);
        R(list);
    }

    private void R(List<TubeInfo> list) {
        this.aWB.aC(list);
        this.aWB.notifyDataSetChanged();
        this.arT.scrollToPosition(0);
    }
}
