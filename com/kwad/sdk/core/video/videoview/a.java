package com.kwad.sdk.core.video.videoview;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.internal.view.SupportMenu;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.video.a.c;
import com.kwad.sdk.core.video.a.f;
import com.kwad.sdk.core.view.AdBasePvFrameLayout;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.i;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.utils.bx;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

@Deprecated
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class a extends AdBasePvFrameLayout implements TextureView.SurfaceTextureListener, c {
    private static AtomicBoolean bIM = new AtomicBoolean(false);
    private int abG;
    private com.kwad.sdk.core.video.a.c abH;
    private int abI;
    private long abJ;
    private com.kwad.sdk.contentalliance.a.a.b abL;
    private c.e abX;
    private c.i abY;
    private c.b abZ;
    private c.InterfaceC0592c aca;
    private c.d acb;
    private c.a acc;
    private TextView acn;
    private AudioManager bII;
    private com.kwad.sdk.core.video.a bIJ;
    private b bIK;
    private boolean bIL;
    private boolean bIN;
    private boolean bIO;
    private ImageView bIP;
    private FrameLayout eZ;
    private InterfaceC0593a em;
    private com.kwad.sdk.contentalliance.a.a.a gS;
    private Context mContext;
    private Map<String, String> mHeaders;
    private Surface mSurface;
    private SurfaceTexture mSurfaceTexture;
    private String mUrl;

    /* renamed from: com.kwad.sdk.core.video.videoview.a$a, reason: collision with other inner class name */
    public interface InterfaceC0593a {
        com.kwad.sdk.core.video.a.c aw();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public a(Context context) {
        this(context, null);
    }

    private a(Context context, AttributeSet attributeSet) {
        super(context, null);
        this.abG = 0;
        this.bIL = false;
        this.bIN = false;
        this.bIO = false;
        this.abX = new c.e() { // from class: com.kwad.sdk.core.video.videoview.a.1
            @Override // com.kwad.sdk.core.video.a.c.e
            public final void a(com.kwad.sdk.core.video.a.c cVar) {
                try {
                    a.this.abG = 2;
                    a.this.bIK.onPlayStateChanged(a.this.abG);
                    com.kwad.sdk.core.d.c.i("KSVideoPlayerViewView", "onPrepared ——> STATE_PREPARED");
                    cVar.start();
                    if (a.this.bIL) {
                        cVar.seekTo((int) ag.aj(a.this.mContext, a.this.mUrl));
                    }
                    if (a.this.abJ != 0) {
                        cVar.seekTo((int) a.this.abJ);
                    }
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        };
        this.abY = new c.i() { // from class: com.kwad.sdk.core.video.videoview.a.2
            @Override // com.kwad.sdk.core.video.a.c.i
            public final void m(int i, int i2) {
                if (!a.this.bIO || i2 <= i) {
                    a.this.bIJ.adaptVideoSize(i, i2);
                    com.kwad.sdk.core.d.c.i("KSVideoPlayerViewView", "onVideoSizeChanged ——> width：" + i + "， height：" + i2);
                }
            }
        };
        this.abZ = new c.b() { // from class: com.kwad.sdk.core.video.videoview.a.3
            @Override // com.kwad.sdk.core.video.a.c.b
            public final void qY() {
                if (a.this.abG != 9) {
                    a.this.abG = 9;
                    a.this.bIK.onPlayStateChanged(a.this.abG);
                    com.kwad.sdk.core.d.c.i("KSVideoPlayerViewView", "onCompletion ——> STATE_COMPLETED");
                    a.this.eZ.setKeepScreenOn(false);
                }
            }
        };
        this.aca = new c.InterfaceC0592c() { // from class: com.kwad.sdk.core.video.videoview.a.4
            @Override // com.kwad.sdk.core.video.a.c.InterfaceC0592c
            public final boolean n(int i, int i2) {
                if (i == -38) {
                    return true;
                }
                a.this.abG = -1;
                a.this.bIK.p(i, i2);
                a.this.bIK.onPlayStateChanged(a.this.abG);
                com.kwad.sdk.core.d.c.i("KSVideoPlayerViewView", "onError ——> STATE_ERROR ———— what：" + i + ", extra: " + i2);
                return true;
            }
        };
        this.acb = new c.d() { // from class: com.kwad.sdk.core.video.videoview.a.5
            @Override // com.kwad.sdk.core.video.a.c.d
            public final boolean o(int i, int i2) {
                if (i == 3) {
                    a.this.abG = 4;
                    a.this.bIK.onPlayStateChanged(a.this.abG);
                    com.kwad.sdk.core.d.c.i("KSVideoPlayerViewView", "onInfo ——> MEDIA_INFO_VIDEO_RENDERING_START：STATE_PLAYING");
                    return true;
                }
                if (i == 701) {
                    if (a.this.abG == 5 || a.this.abG == 7) {
                        a.this.abG = 7;
                        com.kwad.sdk.core.d.c.i("KSVideoPlayerViewView", "onInfo ——> MEDIA_INFO_BUFFERING_START：STATE_BUFFERING_PAUSED");
                    } else {
                        a.this.abG = 6;
                        com.kwad.sdk.core.d.c.i("KSVideoPlayerViewView", "onInfo ——> MEDIA_INFO_BUFFERING_START：STATE_BUFFERING_PLAYING");
                    }
                    a.this.bIK.onPlayStateChanged(a.this.abG);
                    return true;
                }
                if (i == 702) {
                    if (a.this.abG == 6) {
                        a.this.abG = 4;
                        a.this.bIK.onPlayStateChanged(a.this.abG);
                        com.kwad.sdk.core.d.c.i("KSVideoPlayerViewView", "onInfo ——> MEDIA_INFO_BUFFERING_END： STATE_PLAYING");
                    }
                    if (a.this.abG != 7) {
                        return true;
                    }
                    a.this.abG = 5;
                    a.this.bIK.onPlayStateChanged(a.this.abG);
                    com.kwad.sdk.core.d.c.i("KSVideoPlayerViewView", "onInfo ——> MEDIA_INFO_BUFFERING_END： STATE_PAUSED");
                    return true;
                }
                if (i == 10001) {
                    if (a.this.bIJ == null) {
                        return true;
                    }
                    a.this.bIJ.setRotation(i2);
                    com.kwad.sdk.core.d.c.i("KSVideoPlayerViewView", "视频旋转角度：" + i2);
                    return true;
                }
                if (i == 801) {
                    com.kwad.sdk.core.d.c.i("KSVideoPlayerViewView", "视频不能seekTo，为直播视频");
                    return true;
                }
                com.kwad.sdk.core.d.c.i("KSVideoPlayerViewView", "onInfo ——> what：" + i);
                return true;
            }
        };
        this.acc = new c.a() { // from class: com.kwad.sdk.core.video.videoview.a.6
            @Override // com.kwad.sdk.core.video.a.c.a
            public final void aQ(int i) {
                a.this.abI = i;
            }
        };
        this.mContext = context;
        init();
    }

    private void init() {
        this.bIP = acM();
        this.eZ = new FrameLayout(this.mContext);
        addView(this.eZ, new FrameLayout.LayoutParams(-1, -1));
    }

    public final void setExternalPlayerListener(InterfaceC0593a interfaceC0593a) {
        this.em = interfaceC0593a;
    }

    private ImageView acM() {
        ImageView imageView = new ImageView(this.mContext);
        addView(imageView, new FrameLayout.LayoutParams(-1, -1));
        return imageView;
    }

    public final void a(com.kwad.sdk.contentalliance.a.a.b bVar, Map<String, String> map) {
        this.abL = bVar;
        this.mUrl = bVar.videoUrl;
        this.mHeaders = null;
        fi(bVar.adTemplate);
    }

    private void fi(AdTemplate adTemplate) {
        i iVar = (i) ServiceProvider.get(i.class);
        if (iVar != null) {
            iVar.load(this.bIP, e.be(adTemplate), adTemplate);
        }
    }

    public final void setVideoSoundEnable(boolean z) {
        this.bIN = z;
        com.kwad.sdk.core.video.a.c cVar = this.abH;
        if (cVar != null) {
            if (z) {
                cVar.setVolume(1.0f, 1.0f);
            } else {
                cVar.setVolume(0.0f, 0.0f);
            }
        }
    }

    public final void setPortraitFullscreen(boolean z) {
        this.bIO = z;
    }

    public final b getController() {
        return this.bIK;
    }

    public final void setController(b bVar) {
        this.eZ.removeView(this.bIK);
        this.bIK = bVar;
        bVar.reset();
        this.eZ.addView(this.bIK, new FrameLayout.LayoutParams(-1, -1));
    }

    public final b getVideoController() {
        return this.bIK;
    }

    private void setPlayType(int i) {
        com.kwad.sdk.contentalliance.a.a.b bVar = this.abL;
        if (bVar == null || bVar.videoPlayerStatus == null) {
            return;
        }
        this.abL.videoPlayerStatus.mVideoPlayerType = i;
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public final void start() {
        if (this.abG == 0) {
            acP();
            uf();
            acQ();
            acR();
            com.kwad.sdk.contentalliance.a.a.b bVar = this.abL;
            if (bVar != null && bVar.videoPlayerStatus != null) {
                if (this.abL.videoPlayerStatus.mVideoPlayerType == 0) {
                    setPlayType(1);
                } else {
                    setPlayType(3);
                }
            }
            com.kwad.sdk.core.video.a.b.a.fV("videoStartPlay");
            return;
        }
        com.kwad.sdk.core.d.c.i("KSVideoPlayerViewView", "KSVideoPlayer只有在状态为STATE_IDLE时才能调用start方法.");
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public final void restart() {
        int i = this.abG;
        if (i == 5) {
            this.abH.start();
            com.kwad.sdk.core.video.a.b.a.fV("videoResumePlay");
            this.abG = 4;
            this.bIK.onPlayStateChanged(4);
            setPlayType(2);
            com.kwad.sdk.core.d.c.i("KSVideoPlayerViewView", "STATE_PLAYING");
            return;
        }
        if (i == 7) {
            this.abH.start();
            com.kwad.sdk.core.video.a.b.a.fV("videoResumePlay");
            this.abG = 6;
            this.bIK.onPlayStateChanged(6);
            com.kwad.sdk.core.d.c.i("KSVideoPlayerViewView", "STATE_BUFFERING_PLAYING");
            return;
        }
        if (i == 9 || i == -1) {
            this.abH.reset();
            acS();
            setPlayType(3);
            return;
        }
        com.kwad.sdk.core.d.c.i("KSVideoPlayerViewView", "KSVideoPlayer在状态为 " + this.abG + " 时不能调用restart()方法.");
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public final void pause() {
        com.kwad.sdk.core.video.a.c cVar = this.abH;
        if (cVar == null) {
            return;
        }
        int i = this.abG;
        if (i == 4) {
            cVar.pause();
            com.kwad.sdk.core.video.a.b.a.fV("videoPausePlay");
            this.abG = 5;
            this.bIK.onPlayStateChanged(5);
            com.kwad.sdk.core.d.c.i("KSVideoPlayerViewView", "STATE_PAUSED");
            return;
        }
        if (i == 6) {
            cVar.pause();
            com.kwad.sdk.core.video.a.b.a.fV("videoPausePlay");
            this.abG = 7;
            this.bIK.onPlayStateChanged(7);
            com.kwad.sdk.core.d.c.i("KSVideoPlayerViewView", "STATE_BUFFERING_PAUSED");
        }
    }

    public final void seekTo(int i) {
        com.kwad.sdk.core.video.a.c cVar = this.abH;
        if (cVar != null) {
            cVar.seekTo(i);
        }
    }

    public final void setVolume(int i) {
        AudioManager audioManager = this.bII;
        if (audioManager != null) {
            audioManager.setStreamVolume(3, i, 0);
        }
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public final boolean isIdle() {
        return this.abG == 0;
    }

    private boolean acN() {
        return this.abG == 6;
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public final boolean acO() {
        return this.abG == 7;
    }

    public final boolean isPlaying() {
        return this.abG == 4;
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public final boolean isPaused() {
        return this.abG == 5;
    }

    public final boolean isCompleted() {
        return this.abG == 9;
    }

    public final void setLooping(boolean z) {
        com.kwad.sdk.core.video.a.c cVar = this.abH;
        if (cVar != null) {
            cVar.setLooping(z);
        }
    }

    public final int getMaxVolume() {
        AudioManager audioManager = this.bII;
        if (audioManager != null) {
            return audioManager.getStreamMaxVolume(3);
        }
        return 0;
    }

    public final int getVolume() {
        AudioManager audioManager = this.bII;
        if (audioManager != null) {
            return audioManager.getStreamVolume(3);
        }
        return 0;
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public final long getDuration() {
        com.kwad.sdk.core.video.a.c cVar = this.abH;
        if (cVar != null) {
            return cVar.getDuration();
        }
        return 0L;
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public final long getCurrentPosition() {
        com.kwad.sdk.core.video.a.c cVar = this.abH;
        if (cVar != null) {
            return cVar.getCurrentPosition();
        }
        return 0L;
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public final int getBufferPercentage() {
        return this.abI;
    }

    private void acP() {
        if (this.abH == null) {
            f fVar = (f) ServiceProvider.get(f.class);
            boolean z = fVar != null && fVar.TN();
            boolean z2 = fVar != null && fVar.TO();
            InterfaceC0593a interfaceC0593a = this.em;
            if (interfaceC0593a != null) {
                interfaceC0593a.aw();
            }
            if (z && com.kwad.sdk.core.video.a.e.Wo()) {
                com.kwad.sdk.core.video.a.e.acI();
            }
            com.kwad.sdk.core.video.a.c cVarA = com.kwad.sdk.core.video.a.e.a(this.mContext, false, z, z2, 0);
            this.abH = cVarA;
            cVarA.setAudioStreamType(3);
            if (this.bIN) {
                return;
            }
            this.abH.setVolume(0.0f, 0.0f);
        }
    }

    private void uf() {
        if (this.bIJ == null) {
            com.kwad.sdk.core.video.a aVar = new com.kwad.sdk.core.video.a(this.mContext);
            this.bIJ = aVar;
            aVar.setSurfaceTextureListener(this);
        }
    }

    private void acQ() {
        this.eZ.removeView(this.bIJ);
        this.eZ.addView(this.bIJ, 0, new FrameLayout.LayoutParams(-1, -1, 17));
    }

    private void acR() {
        if (!com.kwad.framework.c.a.qr.booleanValue() || this.abH == null || this.eZ == null) {
            return;
        }
        if (this.acn == null) {
            this.acn = new TextView(this.mContext);
        }
        this.eZ.removeView(this.acn);
        this.acn.setText(String.valueOf(this.abH.getMediaPlayerType()));
        this.acn.setTextColor(SupportMenu.CATEGORY_MASK);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 53;
        this.eZ.addView(this.acn, r1.getChildCount() - 1, layoutParams);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        SurfaceTexture surfaceTexture2 = this.mSurfaceTexture;
        if (surfaceTexture2 == null) {
            this.mSurfaceTexture = surfaceTexture;
            acS();
        } else {
            this.bIJ.setSurfaceTexture(surfaceTexture2);
        }
    }

    private void acS() {
        com.kwad.sdk.contentalliance.a.a.a aVar;
        this.eZ.setKeepScreenOn(true);
        com.kwad.sdk.core.video.a.c cVar = this.abH;
        if (cVar == null) {
            com.kwad.sdk.core.d.c.w("KSVideoPlayerViewView", "mMediaPlayer is null");
            return;
        }
        cVar.b(this.abX);
        this.abH.a(this.abY);
        this.abH.a(this.abZ);
        this.abH.a(this.aca);
        this.abH.c(this.acb);
        this.abH.a(this.acc);
        try {
            com.kwad.sdk.contentalliance.a.a.b bVar = this.abL;
            if (bVar != null && (aVar = this.gS) != null) {
                bVar.buO = aVar;
            }
            this.abH.a(this.abL);
            if (this.mSurface == null) {
                this.mSurface = new Surface(this.mSurfaceTexture);
            }
            this.abH.setSurface(this.mSurface);
            if (this.abH.prepareAsync()) {
                this.abG = 1;
                this.bIK.onPlayStateChanged(1);
                com.kwad.sdk.core.d.c.i("KSVideoPlayerViewView", "STATE_PREPARING");
            }
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
            com.kwad.sdk.core.d.c.e("KSVideoPlayerViewView", "打开播放器发生错误", e);
        }
    }

    private void acT() {
        AudioManager audioManager = this.bII;
        if (audioManager != null) {
            audioManager.abandonAudioFocus(null);
            this.bII = null;
        }
        com.kwad.sdk.core.video.a.c cVar = this.abH;
        if (cVar != null) {
            cVar.release();
            this.abH = null;
            com.kwad.sdk.core.video.a.b.a.fV("videoFinishPlay");
        }
        bx.runOnUiThread(new bh() { // from class: com.kwad.sdk.core.video.videoview.a.7
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                a.this.eZ.removeView(a.this.bIJ);
            }
        });
        Surface surface = this.mSurface;
        if (surface != null) {
            surface.release();
            this.mSurface = null;
        }
        SurfaceTexture surfaceTexture = this.mSurfaceTexture;
        if (surfaceTexture != null) {
            surfaceTexture.release();
            this.mSurfaceTexture = null;
        }
        this.abG = 0;
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public final void release() {
        if (this.bIL) {
            if (isPlaying() || acN() || acO() || isPaused()) {
                ag.e(this.mContext, this.mUrl, getCurrentPosition());
            } else if (isCompleted()) {
                ag.e(this.mContext, this.mUrl, 0L);
            }
        }
        acT();
        b bVar = this.bIK;
        if (bVar != null) {
            bVar.reset();
        }
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public final void setKsPlayLogParam(com.kwad.sdk.contentalliance.a.a.a aVar) {
        this.gS = aVar;
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public final int getMediaPlayerType() {
        com.kwad.sdk.core.video.a.c cVar = this.abH;
        if (cVar != null) {
            return cVar.getMediaPlayerType();
        }
        return 0;
    }
}
