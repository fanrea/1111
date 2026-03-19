package com.kwad.components.ct.tube.channel.detail.a.b;

import android.graphics.Bitmap;
import android.widget.TextView;
import com.kwad.components.ct.f.d;
import com.kwad.components.ct.f.f;
import com.kwad.components.ct.f.g;
import com.kwad.components.ct.response.model.tube.TubeInfo;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.imageloader.core.DisplayImageOptionsCompat;
import com.kwad.sdk.core.page.widget.RoundAngleImageView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b extends com.kwad.components.ct.tube.channel.detail.a.a.a implements com.kwad.components.ct.f.b {
    public static DisplayImageOptionsCompat aWd = new DisplayImageOptionsCompat.Builder().bitmapConfig(Bitmap.Config.RGB_565).cacheOnDisk(true).cacheInMemory(true).showImageOnLoading(R.drawable.ksad_tube_cover_bg).showImageForEmptyUri(R.drawable.ksad_tube_cover_bg).showImageOnFail(R.drawable.ksad_tube_cover_bg).build();
    private f<b> aDL;
    private TextView aVZ;
    private TextView aWa;
    private RoundAngleImageView aWb;
    private TextView aWc;

    @Override // com.kwad.components.ct.f.b
    public final void cg(int i) {
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.aVZ = (TextView) findViewById(R.id.ksad_tube_name);
        this.aWa = (TextView) findViewById(R.id.ksad_tube_desc);
        this.aWb = (RoundAngleImageView) findViewById(R.id.ksad_tube_cover);
        this.aWc = (TextView) findViewById(R.id.ksad_tube_play_count);
        this.aDL = new f<>(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.kwad.sdk.lib.widget.a.b.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        d.Kb().a(this.aDL);
        Ke();
        TubeInfo tubeInfo = (TubeInfo) ((com.kwad.components.ct.tube.channel.detail.a.a.b) this.cdN).cdM;
        com.kwad.sdk.c.a.a.s(getRootView(), (com.kwad.sdk.c.a.a.o(getActivity()) - com.kwad.sdk.c.a.a.a(getActivity(), 48.0f)) / 3);
        this.aWb.setRadius(com.kwad.sdk.c.a.a.a(getContext(), 4.0f));
        this.aVZ.setText(tubeInfo.name);
        this.aWa.setText(com.kwad.components.ct.tube.d.b.c(tubeInfo));
        this.aWc.setText(com.kwad.components.ct.tube.d.b.aq(tubeInfo.viewCount));
        KSImageLoader.loadImage(this.aWb, tubeInfo.coverUrl, aWd);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        d.Kb().b(this.aDL);
        super.onUnbind();
    }

    private void Ke() {
        g.a(this.aVZ, Kj().aZq);
        g.a(this.aWa, Kj().aZr);
    }

    private static com.kwad.components.ct.tube.c.a Kj() {
        return ((com.kwad.components.ct.tube.c.b) d.Kb().a(com.kwad.components.ct.tube.c.b.class)).Lc();
    }
}
