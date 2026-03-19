package com.kwad.components.core.video.a;

import android.os.SystemClock;
import com.kwad.components.core.video.l;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.utils.h;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class d extends com.kwad.components.core.video.a.a {
    private String CZ;
    private long adc;
    private long add;
    private String ade;
    private boolean adf;
    private boolean adg;
    private long adh;
    private long adi;
    private long adj;
    private long adk;
    private int adl;
    private boolean adm;
    private long mAuthorId;
    private int mMediaPlayerType;
    private boolean mStarted;
    private l zg;

    public static class a extends com.kwad.sdk.commercial.c.a {
        public int adr;
        public long authorId;
        public String authorName;
        public int code;
        public long creativeId;
        public long llsid;
        public String msg;
        public String videoUrl;
    }

    private d(AdTemplate adTemplate, int i, boolean z) {
        this.mStarted = false;
        this.adf = false;
        this.adg = false;
        this.mMediaPlayerType = 0;
        this.adm = false;
        try {
            AdInfo adInfoEP = com.kwad.sdk.core.response.b.e.eP(adTemplate);
            this.CZ = com.kwad.sdk.core.response.b.a.L(adInfoEP);
            this.adc = com.kwad.sdk.core.response.b.e.eM(adTemplate);
            this.add = com.kwad.sdk.core.response.b.e.eV(adTemplate);
            this.mAuthorId = com.kwad.sdk.core.response.b.a.cD(adInfoEP);
            this.ade = com.kwad.sdk.core.response.b.a.cz(adInfoEP);
            this.adl = com.kwad.sdk.core.response.b.e.eJ(adTemplate);
            this.mMediaPlayerType = i;
            this.adm = z;
            this.zg = new l();
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
        }
    }

    private d(String str, int i) {
        this.mStarted = false;
        this.adf = false;
        this.adg = false;
        this.adm = false;
        this.CZ = str;
        this.mMediaPlayerType = i;
        this.zg = new l();
    }

    @Override // com.kwad.components.core.video.a.c
    public final void onStart() {
        if (this.mStarted) {
            return;
        }
        this.adh = SystemClock.elapsedRealtime();
        this.mStarted = true;
    }

    @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
    public final void onMediaPlayStart() {
        super.onMediaPlayStart();
        if (this.adf) {
            return;
        }
        this.adi = SystemClock.elapsedRealtime();
        this.adf = true;
    }

    @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
    public final void onMediaPlaying() {
        super.onMediaPlaying();
        qv();
        this.zg.uC();
    }

    @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
    public final void onMediaPlayPaused() {
        super.onMediaPlayPaused();
        this.zg.uC();
    }

    @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
    public final void onMediaPlayError(int i, int i2) {
        super.onMediaPlayError(i, i2);
        this.zg.uC();
        b(false, i, i2);
    }

    @Override // com.kwad.components.core.video.a.c
    public final void onRelease() {
        b(true, 0, 0);
    }

    @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.n
    public final void onVideoPlayBufferingPlaying() {
        super.onVideoPlayBufferingPlaying();
        this.zg.uB();
    }

    @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.n
    public final void onVideoPlayBufferingPaused() {
        super.onVideoPlayBufferingPaused();
        this.zg.uB();
    }

    @Override // com.kwad.components.core.video.a.a
    public final void qv() {
        if (this.adg) {
            return;
        }
        this.adj = SystemClock.elapsedRealtime();
        this.adg = true;
    }

    @Override // com.kwad.components.core.video.a.c
    public final void onReset() {
        b(false, 0, 0);
    }

    private void reset() {
        this.zg.reset();
        this.adh = 0L;
        this.adi = 0L;
        this.adk = 0L;
        this.adj = 0L;
        this.mStarted = false;
        this.adf = false;
        this.adg = false;
    }

    private void a(final boolean z, final int i, final int i2) {
        final b bVarClone = uI().clone();
        h.execute(new bh() { // from class: com.kwad.components.core.video.a.d.1
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                if (!z) {
                    com.kwad.sdk.commercial.b.s(d.this.q(i, i2));
                } else {
                    com.kwad.sdk.commercial.b.r(bVarClone);
                }
            }
        });
    }

    private void b(boolean z, int i, int i2) {
        if (this.adg) {
            this.zg.uC();
            this.adk = SystemClock.elapsedRealtime();
            a(z, i, i2);
            reset();
        }
    }

    private b uI() {
        b bVar = new b();
        bVar.ads = this.adi - this.adh;
        bVar.adt = this.adj - this.adh;
        bVar.adu = this.zg.uE().uH();
        bVar.videoDuration = this.adk - this.adh;
        bVar.ada = this.zg.uE().uG();
        bVar.videoUrl = this.CZ;
        bVar.llsid = this.adc;
        bVar.creativeId = this.add;
        bVar.authorId = this.mAuthorId;
        bVar.authorName = this.ade;
        bVar.adStyle = this.adl;
        bVar.adr = this.mMediaPlayerType;
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public a q(int i, int i2) {
        a aVar = new a();
        aVar.code = i;
        aVar.msg = String.valueOf(i2);
        aVar.videoUrl = this.CZ;
        aVar.llsid = this.adc;
        aVar.creativeId = this.add;
        aVar.authorId = this.mAuthorId;
        aVar.authorName = this.ade;
        aVar.adr = this.mMediaPlayerType;
        return aVar;
    }

    public static class b extends com.kwad.sdk.commercial.c.a implements Cloneable {
        public int adStyle;
        public int ada;
        public int adr;
        public long ads;
        public long adt;
        public long adu;
        public long authorId;
        public String authorName;
        public long creativeId;
        public long llsid;
        public long videoDuration;
        public String videoUrl;

        /* renamed from: uJ, reason: merged with bridge method [inline-methods] */
        public final b clone() {
            try {
                return (b) super.clone();
            } catch (CloneNotSupportedException unused) {
                return new b();
            }
        }
    }

    public static com.kwad.components.core.video.a.a a(AdTemplate adTemplate, int i, boolean z) {
        return com.kwad.sdk.core.config.e.a(com.kwad.sdk.core.config.c.bzA) ? new d(adTemplate, i, false) : new com.kwad.components.core.video.a.b();
    }

    public static com.kwad.components.core.video.a.a a(AdTemplate adTemplate, AdTemplate adTemplate2, String str, int i, boolean z) {
        if (!com.kwad.sdk.core.config.e.a(com.kwad.sdk.core.config.c.bzA)) {
            return new com.kwad.components.core.video.a.b();
        }
        if (adTemplate != null) {
            return new d(adTemplate, i, z);
        }
        if (adTemplate2 == null) {
            return new d(str, i);
        }
        return new d(adTemplate2, i, z);
    }
}
