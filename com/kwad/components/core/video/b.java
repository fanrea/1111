package com.kwad.components.core.video;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Surface;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.video.a.c;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.utils.bx;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b {
    private static boolean abE = false;
    private static final AtomicInteger abF = new AtomicInteger(0);
    private final String TAG;
    private volatile int abG;
    private com.kwad.sdk.core.video.a.c abH;
    private int abI;
    private long abJ;
    private Runnable abK;
    private com.kwad.sdk.contentalliance.a.a.b abL;
    private int abM;
    private List<c.d> abN;
    private final AtomicBoolean abO;
    private boolean abP;
    private boolean abQ;
    private final int abR;
    private boolean abS;
    private volatile List<n> abT;
    private volatile List<com.kwad.components.core.video.a.c> abU;
    private volatile List<c.e> abV;
    private final c.f abW;
    private c.e abX;
    private c.i abY;
    private c.b abZ;
    private int abm;
    private int abn;
    private c.InterfaceC0592c aca;
    private c.d acb;
    private c.a acc;
    private AdTemplate mAdTemplate;
    private Context mContext;
    private DetailVideoView mDetailVideoView;
    private Handler mHandler;
    private float mSpeed;
    private long mStartTime;

    public interface a {
        void onReleaseSuccess();
    }

    public static String getStateString(int i) {
        switch (i) {
            case -1:
                return "STATE_ERROR";
            case 0:
                return "STATE_IDLE";
            case 1:
                return "STATE_PREPARING";
            case 2:
                return "STATE_PREPARED";
            case 3:
                return "STATE_STARTED";
            case 4:
                return "STATE_PLAYING";
            case 5:
                return "STATE_PAUSED";
            case 6:
                return "STATE_BUFFERING_PLAYING";
            case 7:
                return "STATE_BUFFERING_PAUSED";
            case 8:
                return "PLAYER_STATE_STOPPED";
            case 9:
                return "STATE_COMPLETED";
            default:
                return "STATE_UNKNOWN";
        }
    }

    public b(DetailVideoView detailVideoView) {
        this(detailVideoView, 0);
    }

    public b(DetailVideoView detailVideoView, int i) {
        this.abG = 0;
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mStartTime = 0L;
        this.abM = 0;
        this.abN = new CopyOnWriteArrayList();
        this.abO = new AtomicBoolean(false);
        this.abP = false;
        this.abQ = false;
        this.abS = false;
        this.mSpeed = 1.0f;
        this.abT = new CopyOnWriteArrayList();
        this.abU = new CopyOnWriteArrayList();
        this.abV = new CopyOnWriteArrayList();
        this.abW = new c.f() { // from class: com.kwad.components.core.video.b.1
            @Override // com.kwad.sdk.core.video.a.c.f
            public final void ua() {
                b.this.abG = 1;
                b bVar = b.this;
                bVar.onPlayStateChanged(bVar.abG);
            }
        };
        this.abX = new c.e() { // from class: com.kwad.components.core.video.b.4
            @Override // com.kwad.sdk.core.video.a.c.e
            public final void a(com.kwad.sdk.core.video.a.c cVar) {
                try {
                    com.kwad.sdk.core.d.c.i(b.this.TAG, "onPrepared:" + b.getStateString(b.this.abG) + "->STATE_PREPARED");
                    b.this.abG = 2;
                    b bVar = b.this;
                    bVar.onPlayStateChanged(bVar.abG);
                    Iterator it = b.this.abV.iterator();
                    while (it.hasNext()) {
                        ((c.e) it.next()).a(b.this.abH);
                    }
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        };
        this.abY = new c.i() { // from class: com.kwad.components.core.video.b.5
            @Override // com.kwad.sdk.core.video.a.c.i
            public final void m(int i2, int i3) {
                if (b.this.mDetailVideoView != null) {
                    b.this.mDetailVideoView.adaptVideoSize(i2, i3);
                }
                com.kwad.sdk.core.d.c.i(b.this.TAG, "onVideoSizeChanged ——> width：" + i2 + "， height：" + i3);
            }
        };
        this.abZ = new c.b() { // from class: com.kwad.components.core.video.b.6
            @Override // com.kwad.sdk.core.video.a.c.b
            public final void qY() {
                b.this.abG = 9;
                b bVar = b.this;
                bVar.onPlayStateChanged(bVar.abG);
                com.kwad.sdk.core.video.a.b.a.fV("videoFinishPlay");
            }
        };
        this.aca = new c.InterfaceC0592c() { // from class: com.kwad.components.core.video.b.7
            @Override // com.kwad.sdk.core.video.a.c.InterfaceC0592c
            public final boolean n(int i2, int i3) {
                if (i2 == -38) {
                    return true;
                }
                b.this.abG = -1;
                b.this.abm = i2;
                b.this.abn = i3;
                b bVar = b.this;
                bVar.onPlayStateChanged(bVar.abG);
                com.kwad.sdk.core.d.c.i(b.this.TAG, "onError ——> STATE_ERROR ———— what：" + i2 + ", extra: " + i3);
                return true;
            }
        };
        this.acb = new c.d() { // from class: com.kwad.components.core.video.b.8
            @Override // com.kwad.sdk.core.video.a.c.d
            public final boolean o(int i2, int i3) {
                if (i2 == 3) {
                    b.this.abG = 4;
                    b bVar = b.this;
                    bVar.onPlayStateChanged(bVar.abG);
                    com.kwad.sdk.core.d.c.i(b.this.TAG, "onInfo:" + b.getStateString(b.this.abG) + "->STATE_PLAYING, time: " + (System.currentTimeMillis() - b.this.mStartTime));
                } else if (i2 == 701) {
                    if (b.this.abG == 5 || b.this.abG == 7) {
                        b.this.abG = 7;
                        com.kwad.sdk.core.d.c.i(b.this.TAG, "onInfo ——> MEDIA_INFO_BUFFERING_START：STATE_BUFFERING_PAUSED");
                    } else {
                        b.this.abG = 6;
                        com.kwad.sdk.core.d.c.i(b.this.TAG, "onInfo ——> MEDIA_INFO_BUFFERING_START：STATE_BUFFERING_PLAYING");
                    }
                    b bVar2 = b.this;
                    bVar2.onPlayStateChanged(bVar2.abG);
                } else if (i2 == 702) {
                    if (b.this.abG == 6) {
                        b.this.abG = 4;
                        b bVar3 = b.this;
                        bVar3.onPlayStateChanged(bVar3.abG);
                        com.kwad.sdk.core.d.c.i(b.this.TAG, "onInfo ——> MEDIA_INFO_BUFFERING_END： STATE_PLAYING");
                    }
                    if (b.this.abG == 7) {
                        b.this.abG = 5;
                        b bVar4 = b.this;
                        bVar4.onPlayStateChanged(bVar4.abG);
                        com.kwad.sdk.core.d.c.i(b.this.TAG, "onInfo ——> MEDIA_INFO_BUFFERING_END： STATE_PAUSED");
                    }
                } else if (i2 != 10001) {
                    if (i2 == 801) {
                        com.kwad.sdk.core.d.c.i(b.this.TAG, "视频不能seekTo，为直播视频");
                    } else {
                        com.kwad.sdk.core.d.c.i(b.this.TAG, "onInfo ——> what：" + i2);
                    }
                }
                b bVar5 = b.this;
                bVar5.a(bVar5.abH, i2, i3);
                return true;
            }
        };
        this.acc = new c.a() { // from class: com.kwad.components.core.video.b.9
            @Override // com.kwad.sdk.core.video.a.c.a
            public final void aQ(int i2) {
                b.this.abI = i2;
            }
        };
        this.mDetailVideoView = detailVideoView;
        if (detailVideoView != null) {
            this.mContext = detailVideoView.getContext().getApplicationContext();
        }
        this.abR = i;
        String str = "DetailMediaPlayerImpl[" + i + "]";
        this.TAG = str;
        com.kwad.sdk.core.d.c.i(str, "create DetailMediaPlayerImpl");
    }

    public b(DetailVideoView detailVideoView, AdTemplate adTemplate) {
        this(detailVideoView);
        this.mAdTemplate = adTemplate;
    }

    public final void setRadius(float f, float f2, float f3, float f4) {
        this.mDetailVideoView.setRadius(f, f2, f3, f4);
    }

    public final com.kwad.sdk.core.video.a.c tT() {
        return this.abH;
    }

    public final void setSurface(Surface surface) {
        com.kwad.sdk.core.video.a.c cVar = this.abH;
        if (cVar != null) {
            cVar.setSurface(surface);
        }
    }

    public final void a(com.kwad.sdk.contentalliance.a.a.b bVar, DetailVideoView detailVideoView) {
        a(bVar, true, false, detailVideoView);
    }

    public final void a(com.kwad.sdk.contentalliance.a.a.b bVar, boolean z, boolean z2, DetailVideoView detailVideoView) {
        com.kwad.sdk.core.d.c.i(this.TAG, "initMediaPlayer enablePreLoad:" + z);
        if (bVar == null || detailVideoView == null) {
            return;
        }
        com.kwad.sdk.core.video.a.c cVarA = null;
        if (com.kwad.sdk.core.config.e.TN() && com.kwad.sdk.core.video.a.e.Wo() && com.kwad.sdk.core.video.a.e.acI()) {
            cVarA = com.kwad.sdk.core.video.a.e.a(this.mContext, z, true, com.kwad.sdk.core.config.e.TO(), this.abR);
        } else {
            tZ();
        }
        if (cVarA == null) {
            cVarA = com.kwad.sdk.core.video.a.e.a(this.mContext, z, com.kwad.sdk.core.config.e.TN(), com.kwad.sdk.core.config.e.TO(), this.abR);
        }
        try {
            DetailVideoView detailVideoView2 = this.mDetailVideoView;
            if (detailVideoView2 != null) {
                detailVideoView2.bi(cVarA.getMediaPlayerType());
            }
            com.kwad.sdk.core.d.c.i(this.TAG, "initMediaPlayer " + cVarA.getClass().getName());
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
        }
        cVarA.setLooping(false);
        a(bVar, z2, detailVideoView, cVarA);
    }

    private void a(com.kwad.sdk.contentalliance.a.a.b bVar, boolean z, DetailVideoView detailVideoView, com.kwad.sdk.core.video.a.c cVar) {
        com.kwad.sdk.core.d.c.i(this.TAG, "initMediaPlayer " + this.abH);
        if (bVar == null || detailVideoView == null || cVar == null) {
            return;
        }
        if (this.mContext == null) {
            this.mContext = detailVideoView.getContext().getApplicationContext();
        }
        this.abP = z;
        this.abL = bVar;
        com.kwad.components.core.video.a.a aVarA = com.kwad.components.core.video.a.d.a(bVar.adTemplate, this.mAdTemplate, bVar.videoUrl, cVar.getMediaPlayerType(), this.abS);
        c(aVarA);
        a(aVarA);
        DetailVideoView detailVideoView2 = this.mDetailVideoView;
        if (detailVideoView2 != detailVideoView) {
            com.kwad.sdk.core.d.c.i(this.TAG, "initMediaPlayer videoView changed");
            if (detailVideoView2 != null) {
                detailVideoView2.setMediaPlayer(null);
                detailVideoView.setKeepScreenOn(detailVideoView2.getKeepScreenOn());
                detailVideoView2.setKeepScreenOn(false);
            }
            this.mDetailVideoView = detailVideoView;
        }
        detailVideoView.setMediaPlayer(this);
        if (this.abH != cVar) {
            com.kwad.sdk.core.d.c.i(this.TAG, "initMediaPlayer mediaPlayer changed");
            com.kwad.sdk.core.video.a.c cVar2 = this.abH;
            if (cVar2 != null) {
                cVar.setLooping(cVar2.isLooping());
                tV();
                this.abH.release();
            }
            this.abH = cVar;
            reset();
            tU();
            cVar.setAudioStreamType(3);
        } else {
            com.kwad.sdk.core.d.c.i(this.TAG, "initMediaPlayer mediaPlayer not changed");
            reset();
            tV();
            tU();
        }
        this.abH.setSurface(detailVideoView.mSurface);
    }

    public final int getMediaPlayerType() {
        com.kwad.sdk.core.video.a.c cVar = this.abH;
        if (cVar != null) {
            return cVar.getMediaPlayerType();
        }
        return 0;
    }

    private void tU() {
        this.abH.a(this.abW);
        this.abH.b(this.abX);
        this.abH.a(this.abY);
        this.abH.a(this.abZ);
        this.abH.a(this.aca);
        this.abH.c(this.acb);
        this.abH.a(this.acc);
    }

    private void tV() {
        com.kwad.sdk.core.video.a.c cVar = this.abH;
        if (cVar == null) {
            return;
        }
        cVar.a((c.InterfaceC0592c) null);
        this.abH.a((c.b) null);
        this.abH.b(null);
        this.abH.a((c.i) null);
        this.abH.c(null);
        this.abH.a((c.g) null);
        this.abH.a((c.a) null);
    }

    public final void a(c.e eVar) {
        this.abV.add(eVar);
    }

    public final void a(c.d dVar) {
        if (dVar == null) {
            return;
        }
        this.abN.add(dVar);
    }

    public final void b(c.d dVar) {
        if (dVar == null) {
            return;
        }
        this.abN.remove(dVar);
    }

    public final void a(com.kwad.sdk.core.video.a.c cVar, int i, int i2) {
        Iterator<c.d> it = this.abN.iterator();
        while (it.hasNext()) {
            c.d next = it.next();
            if (next == null) {
                it.remove();
            } else {
                next.o(i, i2);
            }
        }
    }

    @Deprecated
    public final boolean isPreparing() {
        return this.abG == 1;
    }

    @Deprecated
    public final boolean isPrepared() {
        return this.abG == 2 || this.abG == 3 || this.abG == 5 || this.abG == 8 || this.abG == 9;
    }

    public final void a(com.kwad.sdk.contentalliance.a.a.b bVar) {
        try {
            if (!TextUtils.isEmpty(bVar.videoUrl)) {
                com.kwad.sdk.core.d.c.d(this.TAG, "videoUrl=" + bVar.videoUrl);
                this.abH.a(bVar);
            } else {
                com.kwad.sdk.core.d.c.e(this.TAG, "videoUrl is null");
            }
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
        }
    }

    public final void prepareAsync() {
        aV(false);
    }

    private void aV(final boolean z) {
        if (this.abH == null) {
            return;
        }
        com.kwad.sdk.core.d.c.i(this.TAG, "start prepareAsync");
        if (this.abP) {
            if (this.abO.compareAndSet(false, true)) {
                com.kwad.sdk.utils.h.execute(new bh() { // from class: com.kwad.components.core.video.b.10
                    @Override // com.kwad.sdk.utils.bh
                    public final void doTask() {
                        com.kwad.sdk.core.d.c.i(b.this.TAG, "prepareAsync now:" + b.getStateString(b.this.abG));
                        if (b.this.abH == null) {
                            return;
                        }
                        try {
                            synchronized (b.this.abH) {
                                b.this.aW(z);
                            }
                        } finally {
                            try {
                            } finally {
                            }
                        }
                        try {
                            synchronized (b.this.abO) {
                                b.this.abO.notifyAll();
                            }
                        } catch (Exception e) {
                            com.kwad.sdk.core.d.c.printStackTrace(e);
                        }
                    }
                });
                return;
            }
            return;
        }
        try {
            aW(z);
        } catch (Throwable th) {
            if (getMediaPlayerType() != 2) {
                int i = this.abM;
                this.abM = i + 1;
                if (i <= 4) {
                    tW();
                }
            }
            com.kwad.sdk.core.d.c.i(this.TAG, "prepareAsync Exception:" + getStateString(this.abG));
            com.kwad.sdk.core.d.c.printStackTrace(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aW(boolean z) {
        boolean zPrepareAsync;
        a(this.abL);
        if (z) {
            zPrepareAsync = this.abH.uv();
        } else {
            zPrepareAsync = this.abH.prepareAsync();
        }
        com.kwad.sdk.core.d.c.i(this.TAG, "prepareAsync forcePrepare: " + z + ", result: " + zPrepareAsync);
    }

    public final void start() {
        try {
            if (this.abH == null) {
                return;
            }
            com.kwad.sdk.core.d.c.i(this.TAG, "start state: " + getStateString(this.abG));
            bh(0);
            if (this.abG == 0) {
                com.kwad.sdk.core.d.c.i(this.TAG, "start still not prepared well forcePrepare");
                aV(true);
                return;
            }
            if (this.abG != 2 && this.abG != 9) {
                if (this.abG == 3) {
                    this.abH.start();
                    return;
                } else {
                    if (this.abG == 5) {
                        resume();
                        return;
                    }
                    return;
                }
            }
            this.mStartTime = System.currentTimeMillis();
            if (this.abJ != 0) {
                this.abH.seekTo((int) r5);
            }
            this.abH.start();
            com.kwad.sdk.core.video.a.b.a.fV("videoStartPlay");
            com.kwad.sdk.core.d.c.i(this.TAG, "start:" + getStateString(this.abG) + "->STATE_STARTED");
            com.kwad.sdk.contentalliance.a.a.b bVar = this.abL;
            if (bVar != null && bVar.videoPlayerStatus != null) {
                if (this.abG == 2) {
                    if (this.abL.videoPlayerStatus.mVideoPlayerType == 0) {
                        setPlayType(1);
                    } else {
                        setPlayType(3);
                    }
                } else if (this.abG == 9) {
                    setPlayType(3);
                }
            }
            this.abG = 3;
            onPlayStateChanged(this.abG);
            tX();
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public final void start(long j) {
        this.abJ = j;
        start();
    }

    private void setPlayType(int i) {
        com.kwad.sdk.contentalliance.a.a.b bVar = this.abL;
        if (bVar == null || bVar.videoPlayerStatus == null) {
            return;
        }
        this.abL.videoPlayerStatus.mVideoPlayerType = i;
    }

    public final void restart() {
        if (this.abH != null && this.abG == 9) {
            start();
        }
        setPlayType(3);
    }

    public final void complete() {
        com.kwad.sdk.core.video.a.c cVar = this.abH;
        if (cVar != null) {
            cVar.pause();
            this.abH.seekTo(0L);
        }
        this.abG = 9;
        onPlayStateChanged(this.abG);
        com.kwad.sdk.core.video.a.b.a.fV("videoFinishPlay");
    }

    public final void tW() {
        if (this.abH == null) {
            com.kwad.sdk.core.d.c.w("resetAndPlay", "mMediaPlayer is null");
            return;
        }
        if (this.abG == 2 || this.abG == 3 || this.abG == 4 || this.abG == 5) {
            com.kwad.sdk.core.d.c.w("resetAndPlay", "can not resetAndPlay in state:");
            return;
        }
        reset();
        tV();
        tU();
        prepareAsync();
    }

    public final void resume() {
        try {
            if (this.abH == null) {
                com.kwad.sdk.core.d.c.e(this.TAG, "resume but mMediaPlayer is null");
                return;
            }
            com.kwad.sdk.core.d.c.i(this.TAG, "resume state: " + getStateString(this.abG));
            if (this.abG != 2 && this.abG != 3 && this.abG != 0) {
                if (this.abG == 5) {
                    this.abH.start();
                    com.kwad.sdk.core.d.c.i(this.TAG, "resume:" + getStateString(this.abG) + "->STATE_PLAYING");
                    this.abG = 4;
                    onPlayStateChanged(this.abG);
                    setPlayType(2);
                    com.kwad.sdk.core.video.a.b.a.fV("videoResumePlay");
                    return;
                }
                if (this.abG == 7) {
                    this.abH.start();
                    com.kwad.sdk.core.d.c.i(this.TAG, "resume:" + getStateString(this.abG) + "->STATE_BUFFERING_PLAYING");
                    this.abG = 6;
                    onPlayStateChanged(this.abG);
                    return;
                }
                if (this.abG == 9) {
                    start();
                    return;
                } else {
                    if (this.abG != 1) {
                        com.kwad.sdk.core.d.c.w(this.TAG, "resume: " + getStateString(this.abG) + " 此时不能调用resume()方法.");
                        return;
                    }
                    return;
                }
            }
            com.kwad.sdk.core.d.c.i(this.TAG, "resume:" + getStateString(this.abG) + "->start()");
            start();
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public final void stopAndPrepareAsync() {
        com.kwad.sdk.core.d.c.i(this.TAG, "stopAndPrepareAsync state: " + getStateString(this.abG));
        if (this.abG == 1 || this.abG == 2) {
            return;
        }
        if (this.abG == 3 || this.abG == 4 || this.abG == 5 || this.abG == 6 || this.abG == 7 || this.abG == 8 || this.abG == 9) {
            try {
                this.abH.stop();
                this.abG = 8;
                onPlayStateChanged(this.abG);
                prepareAsync();
                return;
            } catch (Exception unused) {
            }
        }
        release();
    }

    private void reset() {
        com.kwad.sdk.core.d.c.i(this.TAG, "reset:" + getStateString(this.abG) + "->STATE_IDLE");
        bh(1);
        this.abH.reset();
        this.abG = 0;
    }

    public final boolean isPlaying() {
        com.kwad.sdk.core.video.a.c cVar = this.abH;
        if (cVar != null) {
            return cVar.isPlaying();
        }
        return false;
    }

    public final boolean pause() {
        boolean z;
        com.kwad.sdk.core.d.c.i(this.TAG, "pause mCurrentState: " + getStateString(this.abG));
        if (this.abG == 4) {
            this.abH.pause();
            com.kwad.sdk.core.d.c.i(this.TAG, "pause STATE_PLAYING->STATE_PAUSED");
            this.abG = 5;
            onPlayStateChanged(this.abG);
            com.kwad.sdk.core.video.a.b.a.fV("videoPausePlay");
            z = true;
        } else {
            z = false;
        }
        if (this.abG == 6) {
            this.abH.pause();
            com.kwad.sdk.core.d.c.i(this.TAG, "pause STATE_BUFFERING_PLAYING->STATE_PAUSED");
            this.abG = 7;
            onPlayStateChanged(this.abG);
            z = true;
        }
        if (this.abG == 3) {
            this.abH.pause();
            com.kwad.sdk.core.d.c.i(this.TAG, "pause STATE_STARTED->STATE_PAUSED");
            this.abG = 5;
            onPlayStateChanged(this.abG);
            com.kwad.sdk.core.video.a.b.a.fV("videoPausePlay");
            z = true;
        }
        if (this.abG != 9 || !this.abH.isLooping()) {
            return z;
        }
        this.abH.pause();
        com.kwad.sdk.core.d.c.i(this.TAG, "pause " + getStateString(this.abG) + "->STATE_PAUSED");
        this.abG = 5;
        onPlayStateChanged(this.abG);
        return true;
    }

    public final void a(final a aVar, boolean z) {
        if (this.abH == null) {
            return;
        }
        com.kwad.sdk.core.d.c.i(this.TAG, "release:" + getStateString(this.abG) + "->STATE_IDLE");
        setKeepScreenOn(false);
        this.mHandler.removeCallbacksAndMessages(null);
        tY();
        tV();
        this.mDetailVideoView = null;
        final com.kwad.sdk.core.video.a.c cVar = this.abH;
        if (cVar != null) {
            if (z) {
                com.kwad.sdk.utils.h.execute(new bh() { // from class: com.kwad.components.core.video.b.11
                    @Override // com.kwad.sdk.utils.bh
                    public final void doTask() {
                        b.this.a(cVar, aVar);
                    }
                });
            } else {
                a(cVar, aVar);
            }
            this.abH = null;
        }
        this.abG = 0;
        this.abM = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.kwad.sdk.core.video.a.c cVar, a aVar) {
        if (cVar == null) {
            return;
        }
        com.kwad.sdk.core.d.c.i(this.TAG, "releaseMediaPlayer:" + getStateString(this.abG) + "->STATE_IDLE");
        try {
            bh(2);
            cVar.release();
            if (aVar != null) {
                aVar.onReleaseSuccess();
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTrace(th);
        }
    }

    public final void a(a aVar) {
        a(aVar, true);
    }

    public final void release() {
        a((a) null);
    }

    public final void releaseAsync() {
        a((a) null, true);
    }

    public final void seekTo(long j) {
        com.kwad.sdk.core.video.a.c cVar = this.abH;
        if (cVar != null) {
            cVar.seekTo(j);
        }
    }

    public final void setVolume(float f, float f2) {
        com.kwad.sdk.core.video.a.c cVar = this.abH;
        if (cVar == null) {
            return;
        }
        try {
            cVar.setVolume(f, f2);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
        }
    }

    public final void setAudioEnabled(boolean z) {
        if (z) {
            setVolume(1.0f, 1.0f);
        } else {
            setVolume(0.0f, 0.0f);
        }
    }

    public final void setSpeed(float f) {
        com.kwad.sdk.core.video.a.c cVar = this.abH;
        if (cVar == null) {
            return;
        }
        if (f > 0.0f) {
            this.mSpeed = f;
        }
        cVar.setSpeed(f);
    }

    public final int getVideoWidth() {
        com.kwad.sdk.core.video.a.c cVar = this.abH;
        if (cVar != null) {
            return cVar.getVideoWidth();
        }
        return 0;
    }

    public final int getVideoHeight() {
        com.kwad.sdk.core.video.a.c cVar = this.abH;
        if (cVar != null) {
            return cVar.getVideoHeight();
        }
        return 0;
    }

    public final long getDuration() {
        com.kwad.sdk.core.video.a.c cVar = this.abH;
        if (cVar != null) {
            return cVar.getDuration();
        }
        return 0L;
    }

    public final long getPlayDuration() {
        com.kwad.sdk.core.video.a.c cVar = this.abH;
        if (cVar != null) {
            return cVar.getCurrentPosition();
        }
        return 0L;
    }

    public final long getCurrentPosition() {
        com.kwad.sdk.core.video.a.c cVar = this.abH;
        if (cVar != null) {
            return cVar.getCurrentPosition();
        }
        return 0L;
    }

    public final int getBufferPercentage() {
        return this.abI;
    }

    public final void c(n nVar) {
        this.abT.add(nVar);
    }

    private void a(com.kwad.components.core.video.a.c cVar) {
        this.abU.add(cVar);
    }

    public final void d(n nVar) {
        this.abT.remove(nVar);
    }

    public final void clear() {
        this.abT.clear();
        this.abU.clear();
    }

    public final void onPlayStateChanged(final int i) {
        if (this.abT == null) {
            return;
        }
        bx.runOnUiThread(new bh() { // from class: com.kwad.components.core.video.b.2
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                for (n nVar : b.this.abT) {
                    switch (i) {
                        case -1:
                            b.this.setKeepScreenOn(false);
                            b.this.tY();
                            nVar.onMediaPlayError(b.this.abm, b.this.abn);
                            break;
                        case 1:
                            nVar.onMediaPreparing();
                            break;
                        case 2:
                            nVar.onMediaPrepared();
                            break;
                        case 3:
                            b.this.setKeepScreenOn(true);
                            nVar.onMediaPlayStart();
                            break;
                        case 4:
                            b.this.setKeepScreenOn(true);
                            nVar.onMediaPlaying();
                            break;
                        case 5:
                            b.this.setKeepScreenOn(false);
                            nVar.onMediaPlayPaused();
                            break;
                        case 6:
                            nVar.onVideoPlayBufferingPlaying();
                            break;
                        case 7:
                            nVar.onVideoPlayBufferingPaused();
                            break;
                        case 9:
                            if (b.this.abH != null && !b.this.abH.isLooping()) {
                                b.this.setKeepScreenOn(false);
                                b.this.tY();
                            }
                            nVar.onMediaPlayCompleted();
                            break;
                    }
                }
            }
        });
    }

    private void bh(int i) {
        for (com.kwad.components.core.video.a.c cVar : this.abU) {
            if (i == 0) {
                cVar.onStart();
            } else if (i == 1) {
                cVar.onReset();
            } else if (i == 2) {
                try {
                    cVar.onRelease();
                } catch (Exception e) {
                    com.kwad.sdk.core.d.c.printStackTrace(e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setKeepScreenOn(boolean z) {
        DetailVideoView detailVideoView = this.mDetailVideoView;
        if (detailVideoView != null) {
            detailVideoView.setKeepScreenOn(z);
        }
    }

    private void tX() {
        tY();
        if (this.abK == null) {
            this.abK = new bh() { // from class: com.kwad.components.core.video.b.3
                @Override // com.kwad.sdk.utils.bh
                public final void doTask() {
                    b.this.tR();
                    if (b.this.abK != null) {
                        b.this.mHandler.postDelayed(b.this.abK, (long) (500.0f / b.this.mSpeed));
                    }
                }
            };
        }
        this.mHandler.post(this.abK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tY() {
        Runnable runnable = this.abK;
        if (runnable != null) {
            this.mHandler.removeCallbacks(runnable);
            this.abK = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tR() {
        long currentPosition = getCurrentPosition();
        long duration = getDuration();
        if (this.abT != null) {
            Iterator<n> it = this.abT.iterator();
            while (it.hasNext()) {
                it.next().onMediaPlayProgress(duration, currentPosition);
            }
        }
    }

    public final void a(com.kwad.sdk.contentalliance.a.a.a aVar) {
        com.kwad.sdk.core.video.a.c cVar = this.abH;
        if (cVar instanceof com.kwad.sdk.core.video.a.d) {
            ((com.kwad.sdk.core.video.a.d) cVar).a(aVar);
        }
    }

    public final String getCurrentPlayingUrl() {
        com.kwad.sdk.core.video.a.c cVar = this.abH;
        return cVar == null ? "" : cVar.getCurrentPlayingUrl();
    }

    public final void setIsAlphaVideoPlayer(boolean z) {
        DetailVideoView detailVideoView = this.mDetailVideoView;
        if (detailVideoView != null) {
            detailVideoView.setIsAlphaVideoView(z);
        }
        this.abQ = z;
    }

    public final boolean getAlphaVideoValid() {
        com.kwad.sdk.core.video.a.c cVar = this.abH;
        if (cVar != null) {
            return cVar instanceof i;
        }
        return false;
    }

    private boolean tZ() {
        if (Build.VERSION.SDK_INT < 18) {
            return false;
        }
        if (this.abQ && ((Boolean) com.kwad.sdk.core.config.e.b(com.kwad.sdk.core.config.c.bAf)).booleanValue()) {
            return true;
        }
        return ((Boolean) com.kwad.sdk.core.config.e.b(com.kwad.sdk.core.config.c.bAf)).booleanValue() && ((Boolean) com.kwad.sdk.core.config.e.b(com.kwad.sdk.core.config.c.bAg)).booleanValue();
    }

    public final void setTKPlayer() {
        this.abS = true;
    }
}
