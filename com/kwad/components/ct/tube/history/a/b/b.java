package com.kwad.components.ct.tube.history.a.b;

import android.graphics.Bitmap;
import android.view.ViewGroup;
import android.widget.TextView;
import com.kwad.components.ct.f.d;
import com.kwad.components.ct.f.f;
import com.kwad.components.ct.f.g;
import com.kwad.components.ct.response.model.tube.TubeInfo;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.imageloader.core.DisplayImageOptionsCompat;
import com.kwad.sdk.core.page.widget.RoundAngleImageView;
import com.kwad.sdk.widget.KSRelativeLayout;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b extends com.kwad.components.ct.tube.history.a.a.a implements com.kwad.components.ct.f.b {
    public static DisplayImageOptionsCompat aWd = new DisplayImageOptionsCompat.Builder().bitmapConfig(Bitmap.Config.RGB_565).cacheOnDisk(true).cacheInMemory(true).showImageOnLoading(R.drawable.ksad_tube_cover_bg).showImageForEmptyUri(R.drawable.ksad_tube_cover_bg).showImageOnFail(R.drawable.ksad_tube_cover_bg).build();
    private f<b> aDL;
    private TextView aVZ;
    private TextView aWS;
    private KSRelativeLayout aWT;
    private TextView aWU;
    private RoundAngleImageView aWb;
    private TextView aWc;

    @Override // com.kwad.components.ct.f.b
    public final void cg(int i) {
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.aWT = (KSRelativeLayout) findViewById(R.id.ksad_tube_history_item_root);
        this.aWU = (TextView) findViewById(R.id.ksad_tube_history_playing_time);
        this.aVZ = (TextView) findViewById(R.id.ksad_tube_pannel_history_title_new);
        this.aWS = (TextView) findViewById(R.id.ksad_tube_pannel_history_updateInformation_new);
        this.aWb = (RoundAngleImageView) findViewById(R.id.ksad_tube_history_cover);
        this.aWc = (TextView) findViewById(R.id.ksad_tube_pannel_history_playcount_new);
        this.aDL = new f<>(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.kwad.sdk.lib.widget.a.b.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        TubeInfo tubeInfo = (TubeInfo) ((com.kwad.components.ct.tube.history.a.a.b) this.cdN).cdM;
        long j = tubeInfo.lastWatchTime;
        com.kwad.components.ct.tube.history.b.b bVar = ((com.kwad.components.ct.tube.history.a.a.b) this.cdN).aWP;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.aWU.getLayoutParams();
        if ((tubeInfo.mIsShowTitle || bVar.aWX == com.kwad.components.ct.tube.history.a.a.Ku()) && j >= bVar.aWW) {
            this.aWU.setText("今天");
            tubeInfo.mIsShowTitle = true;
            bVar.aWW = j;
            this.aWU.setVisibility(0);
            marginLayoutParams.topMargin = com.kwad.sdk.c.a.a.a(getContext(), 10.0f);
        } else if ((tubeInfo.mIsShowTitle || bVar.aWX == com.kwad.components.ct.tube.history.a.a.Ku()) && j <= bVar.aWX) {
            this.aWU.setText("更早");
            marginLayoutParams.topMargin = com.kwad.sdk.c.a.a.a(getContext(), 10.0f);
            tubeInfo.mIsShowTitle = true;
            marginLayoutParams.topMargin = com.kwad.sdk.c.a.a.a(getContext(), 22.0f);
            bVar.aWX = j;
            this.aWU.setVisibility(0);
        } else {
            marginLayoutParams.topMargin = com.kwad.sdk.c.a.a.a(getContext(), 10.0f);
            this.aWU.setVisibility(8);
            marginLayoutParams.topMargin = com.kwad.sdk.c.a.a.a(getContext(), 10.0f);
        }
        this.aWU.setLayoutParams(marginLayoutParams);
        d.Kb().a(this.aDL);
        Ke();
        com.kwad.sdk.c.a.a.s(getRootView(), com.kwad.sdk.c.a.a.o(getActivity()));
        this.aWb.setRadius(com.kwad.sdk.c.a.a.a(getContext(), 6.0f));
        this.aVZ.setText(tubeInfo.name);
        this.aWS.setText(com.kwad.components.ct.tube.d.b.c(tubeInfo));
        this.aWc.setText(com.kwad.components.ct.tube.d.b.a(tubeInfo, true));
        KSImageLoader.loadImage(this.aWb, tubeInfo.coverUrl, aWd);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        d.Kb().b(this.aDL);
        super.onUnbind();
    }

    private void Ke() {
        g.a(this.aVZ, Kj().aZq);
        g.a(this.aWS, Kj().aZr);
    }

    private static com.kwad.components.ct.tube.c.a Kj() {
        return ((com.kwad.components.ct.tube.c.b) d.Kb().a(com.kwad.components.ct.tube.c.b.class)).Lc();
    }
}
