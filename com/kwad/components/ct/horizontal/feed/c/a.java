package com.kwad.components.ct.horizontal.feed.c;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.components.core.video.a;
import com.kwad.components.ct.response.model.CtAdResultData;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.contentalliance.a.a.b;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.utils.aj;
import com.kwad.sdk.utils.bv;
import com.kwad.sdk.utils.n;
import com.kwad.sdk.widget.KSFrameLayout;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public abstract class a extends b {
    private InterfaceC0524a aMn;
    private View aNk;
    private TextView aNl;
    private ImageView aNm;
    protected boolean abl;
    private final a.c aby;
    private final a.InterfaceC0488a abz;
    private List<Integer> dX;
    private com.kwad.sdk.core.video.videoview.a ed;
    private boolean gq;
    private KSFrameLayout hn;
    private com.kwad.components.core.video.f jG;
    private boolean mIsAudioEnable;

    /* renamed from: com.kwad.components.ct.horizontal.feed.c.a$a, reason: collision with other inner class name */
    public interface InterfaceC0524a {
        void HA();
    }

    public void setFeedVideoPlayerControlListener(InterfaceC0524a interfaceC0524a) {
        this.aMn = interfaceC0524a;
    }

    public void setCanControlPlay(boolean z) {
        this.abl = z;
        com.kwad.components.core.video.f fVar = this.jG;
        if (fVar != null) {
            fVar.setCanControlPlay(z);
        }
    }

    public a(Context context) {
        super(context);
        this.mIsAudioEnable = false;
        this.gq = false;
        this.abl = false;
        this.aby = new a.c() { // from class: com.kwad.components.ct.horizontal.feed.c.a.2
            @Override // com.kwad.components.core.video.a.c
            public final void d(long j) {
                a.this.c(j);
            }

            @Override // com.kwad.components.core.video.a.c
            public final void onVideoPlayStart() {
                a.this.gq = false;
                com.kwad.sdk.core.adlog.c.cm(a.this.mAdTemplate);
                if (a.this.ed == null || a.this.ed.getParent() != a.this.hn) {
                    return;
                }
                a.this.ed.setVideoSoundEnable(a.this.mIsAudioEnable);
            }

            @Override // com.kwad.components.core.video.a.c
            public final void au() {
                a.this.HS();
                if (a.this.gq) {
                    return;
                }
                a.this.gq = true;
                com.kwad.components.ct.e.b.JK().a(a.this.mAdTemplate, System.currentTimeMillis(), 1);
            }

            @Override // com.kwad.components.core.video.a.c
            public final void av() {
                com.kwad.sdk.core.adlog.c.cn(a.this.mAdTemplate);
                if (a.this.aMn != null) {
                    a.this.aMn.HA();
                }
            }
        };
        this.abz = new a.InterfaceC0488a() { // from class: com.kwad.components.ct.horizontal.feed.c.a.3
            @Override // com.kwad.components.core.video.a.InterfaceC0488a
            public final void a(int i, aj.a aVar) {
                int i2;
                int i3 = 2;
                boolean z = false;
                if (i == 1) {
                    i2 = 13;
                } else if (i == 2) {
                    i2 = 82;
                } else if (i != 3) {
                    i2 = 108;
                } else {
                    i2 = 83;
                    i3 = 1;
                    z = true;
                }
                com.kwad.components.core.e.d.a.a(new a.C0469a(a.this.hn.getContext()).aC(a.this.mAdTemplate).b(a.this.mApkDownloadHelper).aG(i3).aq(z).as(true).aF(i2).d(aVar).a(new a.b() { // from class: com.kwad.components.ct.horizontal.feed.c.a.3.1
                    @Override // com.kwad.components.core.e.d.a.b
                    public final void onAdClicked() {
                        a.this.wx();
                    }
                }));
            }
        };
    }

    @Override // com.kwad.components.ct.horizontal.feed.c.b, com.kwad.components.core.widget.b
    public final void bB() {
        super.bB();
        this.hn = (KSFrameLayout) findViewById(R.id.ksad_video_container);
        this.aNk = findViewById(R.id.ksad_video_top_container);
        this.aNm = (ImageView) findViewById(R.id.ksad_video_play_btn);
        this.aNl = (TextView) findViewById(R.id.ksad_video_duration);
    }

    @Override // com.kwad.components.ct.horizontal.feed.c.b, com.kwad.components.core.widget.b, com.kwad.sdk.core.j.c
    public final void by() {
        super.by();
        if (this.mIsAudioEnable) {
            com.kwad.components.core.u.a.aC(this.mContext).aS(false);
            if (com.kwad.components.core.u.a.aC(this.mContext).to()) {
                this.mIsAudioEnable = false;
                this.ed.setVideoSoundEnable(false);
            }
        }
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.widget.KSFrameLayout
    public final void af() {
        super.af();
        n.fk(this.mAdTemplate);
    }

    @Override // com.kwad.components.ct.horizontal.feed.c.b, com.kwad.components.core.widget.b
    /* renamed from: g */
    public final void d(CtAdResultData ctAdResultData) throws Resources.NotFoundException {
        super.d(ctAdResultData);
        this.aNl.setText(bv.aP(com.kwad.sdk.core.response.b.a.M(this.mAdInfo) * 1000));
        this.aNl.setVisibility(0);
    }

    @Override // com.kwad.components.ct.horizontal.feed.c.b, com.kwad.components.core.widget.b
    public final void cv() {
        super.cv();
        this.abl = false;
        this.aMn = null;
    }

    public final void b(KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        HR();
        this.dX = com.kwad.sdk.core.response.b.a.bv(this.mAdInfo);
        com.kwad.sdk.core.video.videoview.a aVar = new com.kwad.sdk.core.video.videoview.a(this.mContext);
        this.ed = aVar;
        aVar.setVisibleListener(new com.kwad.sdk.widget.n() { // from class: com.kwad.components.ct.horizontal.feed.c.a.1
            @Override // com.kwad.sdk.widget.n
            public final void aY() {
                n.fm(a.this.mAdTemplate);
            }
        });
        this.ed.setTag(this.dX);
        String strL = com.kwad.sdk.core.response.b.a.L(this.mAdInfo);
        if (TextUtils.isEmpty(strL)) {
            return;
        }
        this.ed.a(new b.a(this.mAdTemplate).ew(strL).ex(com.kwad.components.ct.response.a.c.e((PhotoInfo) com.kwad.components.ct.response.a.a.ay((CtAdTemplate) this.mAdTemplate))).a(((CtAdTemplate) this.mAdTemplate).mVideoPlayerStatus).b(com.kwad.sdk.contentalliance.a.a.a.cf(this.mAdTemplate)).WR(), null);
        if ((ksAdVideoPlayConfig instanceof KSAdVideoPlayConfigImpl) && ((KSAdVideoPlayConfigImpl) ksAdVideoPlayConfig).getVideoSoundValue() != 0) {
            this.mIsAudioEnable = ksAdVideoPlayConfig.isVideoSoundEnable();
        } else {
            this.mIsAudioEnable = com.kwad.sdk.core.response.b.a.cj(this.mAdInfo);
        }
        this.ed.setVideoSoundEnable(this.mIsAudioEnable);
        com.kwad.components.core.video.f fVar = new com.kwad.components.core.video.f(this.mContext, this.mAdTemplate, this.ed, ksAdVideoPlayConfig);
        this.jG = fVar;
        fVar.setVideoPlayCallback(this.aby);
        this.jG.setAdClickListener(this.abz);
        this.jG.setCanControlPlay(this.abl);
        this.ed.setController(this.jG);
        if (this.hn.getTag() != null) {
            KSFrameLayout kSFrameLayout = this.hn;
            kSFrameLayout.removeView((View) kSFrameLayout.getTag());
            this.hn.setTag(null);
        }
        this.hn.addView(this.ed);
        this.hn.setTag(this.ed);
        this.hn.setClickable(true);
        this.hn.setOnClickListener(this);
    }

    private void HR() {
        View view = this.aNk;
        if (view != null) {
            view.setVisibility(0);
        }
        if (com.kwad.sdk.core.response.b.a.aJ(this.mAdInfo)) {
            this.aNm.setVisibility(0);
        } else {
            this.aNm.setVisibility(8);
            this.aNl.setVisibility(8);
        }
        this.aNp.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HS() {
        View view = this.aNk;
        if (view != null) {
            view.setVisibility(8);
        }
        this.aNp.setVisibility(8);
        this.aNm.setVisibility(8);
        this.aNl.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(long j) {
        int iCeil = (int) Math.ceil(j / 1000.0f);
        List<Integer> list = this.dX;
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<Integer> it = this.dX.iterator();
        while (it.hasNext()) {
            if (iCeil >= it.next().intValue()) {
                com.kwad.sdk.core.adlog.c.a((AdTemplate) this.mAdTemplate, iCeil, (JSONObject) null);
                it.remove();
                return;
            }
        }
    }

    @Override // com.kwad.components.ct.horizontal.feed.c.b, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hn || view == this.aNp) {
            if (this.ed.isIdle()) {
                n.fl(this.mAdTemplate);
                this.ed.setKsPlayLogParam(com.kwad.sdk.contentalliance.a.a.a.cf(this.mAdTemplate));
                this.ed.start();
                return;
            }
            j(false, 121);
            return;
        }
        super.onClick(view);
    }

    public final void uq() {
        com.kwad.components.core.video.f fVar = this.jG;
        if (fVar != null) {
            fVar.uq();
        }
    }

    public final void ur() {
        com.kwad.components.core.video.f fVar = this.jG;
        if (fVar != null) {
            fVar.ur();
        }
    }
}
