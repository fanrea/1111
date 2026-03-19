package com.bytedance.sdk.component.mq.hc;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.bykv.vk.component.ttvideo.SeekCompletionListener;
import com.bykv.vk.component.ttvideo.TTVideoEngine;
import com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback;
import com.bykv.vk.component.ttvideo.log.VideoEventEngineUploader;
import com.bykv.vk.component.ttvideo.player.TTPlayerClient;
import com.bykv.vk.component.ttvideo.playerwrapper.MediaPlayerWrapper;
import com.bykv.vk.component.ttvideo.utils.Error;
import com.bykv.vk.openvk.component.video.api.b;
import com.bykv.vk.openvk.component.video.api.b.c;
import com.bykv.vk.openvk.component.video.api.d;
import com.bytedance.sdk.component.utils.mq;
import com.bytedance.sdk.component.utils.zw;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class hc implements com.bykv.vk.openvk.component.video.api.d, zw.d {
    public static volatile boolean d = false;
    private SurfaceHolder de;
    private TTVideoEngine hc;
    private int jh;
    private volatile zw np;
    private int rf;
    private boolean s;
    private SurfaceTexture sy;
    private long tc;
    private boolean b = false;
    private boolean c = false;
    private boolean u = false;
    private boolean an = false;
    private boolean h = false;
    private boolean gb = false;
    private boolean tt = false;
    private long mk = 0;
    private long mq = 0;
    private long uo = 0;
    private int k = 0;
    private int e = 0;
    private boolean cb = false;
    private AtomicBoolean w = new AtomicBoolean(false);
    private AtomicBoolean yo = new AtomicBoolean(false);
    private final List<WeakReference<d.InterfaceC0158d>> v = Collections.synchronizedList(new ArrayList());
    private volatile boolean yi = false;
    private volatile int he = 200;
    private long vv = 0;
    private Runnable zw = new Runnable() { // from class: com.bytedance.sdk.component.mq.hc.hc.1
        @Override // java.lang.Runnable
        public void run() {
            long jRf = hc.this.rf();
            if (hc.this.yo() > 0) {
                if (hc.this.vv != jRf) {
                    if (b.c()) {
                        com.bykv.vk.openvk.component.video.api.an.b.d("CSJ_VIDEO_TTVideo", "run: lastCur = ", Long.valueOf(hc.this.vv), "  curPosition=", Long.valueOf(jRf));
                    }
                    hc hcVar = hc.this;
                    hcVar.d(jRf, hcVar.yo());
                }
                hc.this.vv = jRf;
            }
            if (!hc.this.an) {
                if (hc.this.np != null) {
                    hc.this.np.postDelayed(this, hc.this.he);
                }
            } else {
                hc hcVar2 = hc.this;
                hcVar2.d(hcVar2.yo(), hc.this.yo());
            }
        }
    };
    private final ArrayList<Runnable> j = new ArrayList<>();

    @Override // com.bykv.vk.openvk.component.video.api.d
    public void d(float f) {
    }

    @Override // com.bykv.vk.openvk.component.video.api.d
    public void d(int i) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(long j, long j2) {
        for (WeakReference<d.InterfaceC0158d> weakReference : this.v) {
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().d(this, j, j2);
            }
        }
    }

    public hc(Context context, String str) {
        d(context, "vd_".concat(String.valueOf(str)), (Looper) null);
    }

    private void d(Context context, String str, Looper looper) {
        this.hc = d.d(context);
        if (looper != null) {
            this.np = new zw(looper, this);
            this.yi = true;
        } else if (this.np == null) {
            this.np = com.bytedance.sdk.component.tc.hc.d.d().d(this, "csj_".concat(String.valueOf(str)));
        }
        yi();
    }

    @Override // com.bykv.vk.openvk.component.video.api.d
    public void d(final SurfaceHolder surfaceHolder) {
        com.bykv.vk.openvk.component.video.api.an.b.d("CSJ_VIDEO_TTVideo", "setDisplay:  SurfaceView");
        hc(true);
        this.de = surfaceHolder;
        hc(new Runnable() { // from class: com.bytedance.sdk.component.mq.hc.hc.3
            @Override // java.lang.Runnable
            public void run() {
                if (hc.this.np != null) {
                    hc.this.np.obtainMessage(110, surfaceHolder).sendToTarget();
                }
            }
        });
    }

    @Override // com.bykv.vk.openvk.component.video.api.d
    public void d(final SurfaceTexture surfaceTexture) {
        hc(true);
        this.sy = surfaceTexture;
        hc(new Runnable() { // from class: com.bytedance.sdk.component.mq.hc.hc.4
            @Override // java.lang.Runnable
            public void run() {
                if (hc.this.np != null) {
                    hc.this.np.obtainMessage(111, surfaceTexture).sendToTarget();
                }
            }
        });
    }

    @Override // com.bykv.vk.openvk.component.video.api.d
    public boolean tt() {
        return this.an;
    }

    @Override // com.bykv.vk.openvk.component.video.api.d
    public boolean tc() {
        return this.gb;
    }

    @Override // com.bykv.vk.openvk.component.video.api.d
    public void d(c cVar) {
        this.hc.setDirectUrlUseDataLoader(cVar.cb(), cVar.w(), (String) null, cVar.u());
        this.b = true;
        this.e = 0;
        com.bykv.vk.openvk.component.video.api.an.b.d("CSJ_VIDEO_TTVideo", "TTVideoPlayer setDirectUrlUseDataLoader:  url =", cVar.cb(), " isH265=", Boolean.valueOf(cVar.k()), " presize=", Integer.valueOf(cVar.an()), " path=", cVar.u(), " fileName =", cVar.w());
    }

    @Override // com.bykv.vk.openvk.component.video.api.d
    public void d() {
        TTVideoEngine tTVideoEngine = this.hc;
        boolean zIsMute = tTVideoEngine != null ? tTVideoEngine.isMute() : false;
        this.e = 0;
        this.mq = 0L;
        this.uo = 0L;
        this.an = false;
        d(true, 0L, zIsMute);
    }

    @Override // com.bykv.vk.openvk.component.video.api.d
    public void d(boolean z, long j, boolean z2) {
        com.bykv.vk.openvk.component.video.api.an.b.d("CSJ_VIDEO_TTVideo", "start: firstSeek:" + j + " first:" + z + " quiet:" + z2);
        if (this.np != null) {
            this.np.postDelayed(this.zw, this.he);
        }
        this.tc = System.currentTimeMillis();
        this.hc.setStartTime((int) j);
        this.hc.setIsMute(z2);
        if (this.yo.get() && this.b) {
            sy();
        } else {
            com.bykv.vk.openvk.component.video.api.an.b.d("CSJ_VIDEO_TTVideo", "seekTo: ", "Can not exec play, please exec setDataSource && setSurface before seek");
            d(new Runnable() { // from class: com.bytedance.sdk.component.mq.hc.hc.5
                @Override // java.lang.Runnable
                public void run() {
                    hc.this.sy();
                }
            });
        }
        com.bykv.vk.openvk.component.video.api.an.b.d("CSJ_VIDEO_TTVideo", "start:end");
        this.w.set(true);
        if (!this.yo.get() || this.np == null) {
            return;
        }
        this.np.post(new Runnable() { // from class: com.bytedance.sdk.component.mq.hc.hc.6
            @Override // java.lang.Runnable
            public void run() {
                hc.this.v();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sy() {
        this.gb = true;
        this.c = true;
        if (this.np != null) {
            this.np.sendEmptyMessage(100);
        }
    }

    private synchronized void d(Runnable runnable) {
        this.j.add(runnable);
    }

    private void de() {
        if (this.s) {
            return;
        }
        this.s = true;
        Iterator it = new ArrayList(this.j).iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        this.j.clear();
        this.s = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        ArrayList<Runnable> arrayList = this.j;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        de();
    }

    @Override // com.bykv.vk.openvk.component.video.api.d
    public void hc() {
        com.bykv.vk.openvk.component.video.api.an.b.d("CSJ_VIDEO_TTVideo", "play: ");
        zw zwVar = this.np;
        if (zwVar != null) {
            zwVar.postDelayed(this.zw, this.he);
            zwVar.post(new Runnable() { // from class: com.bytedance.sdk.component.mq.hc.hc.7
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (hc.this.hc != null) {
                            hc.this.hc.play();
                            for (WeakReference weakReference : hc.this.v) {
                                if (weakReference != null && weakReference.get() != null) {
                                    weakReference.get();
                                }
                            }
                        }
                    } catch (Throwable th) {
                        com.bykv.vk.openvk.component.video.api.an.b.d("CSJ_VIDEO_TTVideo", "play: catch exception:" + th.getMessage());
                    }
                }
            });
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.d
    public void c() {
        com.bykv.vk.openvk.component.video.api.an.b.d("CSJ_VIDEO_TTVideo", "stop: ");
        if (this.np != null) {
            this.np.sendEmptyMessage(105);
        }
    }

    @Override // com.bytedance.sdk.component.utils.zw.d
    public void d(Message message) {
        int i = message.what;
        try {
            if (i == 105) {
                TTVideoEngine tTVideoEngine = this.hc;
                if (tTVideoEngine != null) {
                    tTVideoEngine.stop();
                    return;
                }
                return;
            }
            if (i == 110) {
                if (this.hc != null) {
                    this.hc.setSurfaceHolder((SurfaceHolder) message.obj);
                    this.yo.set(true);
                    if (this.w.get()) {
                        v();
                        return;
                    }
                    return;
                }
                return;
            }
            if (i != 111) {
                switch (i) {
                    case 100:
                        TTVideoEngine tTVideoEngine2 = this.hc;
                        if (tTVideoEngine2 != null) {
                            tTVideoEngine2.play();
                            break;
                        }
                        break;
                    case 101:
                        if (this.hc != null && this.np != null) {
                            this.hc.pause();
                            for (WeakReference<d.InterfaceC0158d> weakReference : this.v) {
                                if (weakReference != null && weakReference.get() != null) {
                                    weakReference.get();
                                }
                            }
                            this.np.removeCallbacks(this.zw);
                            break;
                        }
                        break;
                    case 102:
                        he();
                        break;
                    case 103:
                        TTVideoEngine tTVideoEngine3 = this.hc;
                        if (tTVideoEngine3 != null) {
                            tTVideoEngine3.release();
                        }
                        this.u = true;
                        for (WeakReference<d.InterfaceC0158d> weakReference2 : this.v) {
                            if (weakReference2 != null && weakReference2.get() != null) {
                                weakReference2.get().b(this);
                            }
                        }
                        break;
                }
                return;
            }
            if (this.hc != null) {
                SurfaceTexture surfaceTexture = (SurfaceTexture) message.obj;
                com.bykv.vk.openvk.component.video.api.an.b.d("CSJ_VIDEO_TTVideo", "setSurface: TextureView ");
                this.hc.setSurface(new Surface(surfaceTexture));
                this.yo.set(true);
                if (this.w.get()) {
                    v();
                }
            }
        } catch (Exception e) {
            mq.d(e);
        }
    }

    private void hc(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (!this.u) {
            runnable.run();
        } else {
            d(runnable);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.d
    public void b() {
        com.bykv.vk.openvk.component.video.api.an.b.d("CSJ_VIDEO_TTVideo", "pause: ");
        zw zwVar = this.np;
        if (zwVar != null) {
            zwVar.removeMessages(100);
            zwVar.sendEmptyMessage(101);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.d
    public void d(long j) {
        com.bykv.vk.openvk.component.video.api.an.b.d("CSJ_VIDEO_TTVideo", "seekTo: ");
        if (this.c) {
            this.hc.seekTo((int) j, new SeekCompletionListener() { // from class: com.bytedance.sdk.component.mq.hc.hc.8
                @Override // com.bykv.vk.component.ttvideo.SeekCompletionListener
                public void onCompletion(boolean z) {
                    for (WeakReference weakReference : hc.this.v) {
                        if (weakReference != null && weakReference.get() != null) {
                            ((d.InterfaceC0158d) weakReference.get()).d(hc.this, z);
                        }
                    }
                    com.bykv.vk.openvk.component.video.api.an.b.d("CSJ_VIDEO_TTVideo", "seekTo: ", " isSuccess =", Boolean.valueOf(z));
                }
            });
        } else {
            com.bykv.vk.openvk.component.video.api.an.b.d("CSJ_VIDEO_TTVideo", "seekTo: ", "Can not exec seek, please exec setDataSource before seek");
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.d
    public boolean an() {
        return this.cb;
    }

    @Override // com.bykv.vk.openvk.component.video.api.d
    public void hc(boolean z) {
        this.tt = z;
    }

    @Override // com.bykv.vk.openvk.component.video.api.d
    public long yo() {
        return this.hc.getDuration();
    }

    @Override // com.bykv.vk.openvk.component.video.api.d
    public long rf() {
        try {
            return this.hc.getCurrentPlaybackTime();
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.an.b.hc(th.getMessage());
            return 0L;
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.d
    public void b(boolean z) {
        this.hc.setLooping(z);
    }

    @Override // com.bykv.vk.openvk.component.video.api.d
    public void d(d.InterfaceC0158d interfaceC0158d) {
        if (interfaceC0158d == null) {
            return;
        }
        for (WeakReference<d.InterfaceC0158d> weakReference : this.v) {
            if (weakReference != null && weakReference.get() == interfaceC0158d) {
                return;
            }
        }
        this.v.add(new WeakReference<>(interfaceC0158d));
    }

    @Override // com.bykv.vk.openvk.component.video.api.d
    public void hc(int i) {
        this.he = i;
    }

    private void np() {
        ArrayList<Runnable> arrayList = this.j;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        this.j.clear();
    }

    @Override // com.bykv.vk.openvk.component.video.api.d
    public void u() {
        np();
        zw zwVar = this.np;
        if (zwVar != null) {
            zwVar.removeCallbacksAndMessages(null);
            zwVar.sendEmptyMessage(103);
            if (zwVar.getLooper() != null) {
                zwVar.post(new Runnable() { // from class: com.bytedance.sdk.component.mq.hc.hc.9
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            if (!hc.this.yi) {
                                com.bytedance.sdk.component.tc.hc.d.d().d(hc.this.np);
                            }
                            hc.this.np = null;
                        } catch (Throwable th) {
                            com.bykv.vk.openvk.component.video.api.an.b.b("CSJ_VIDEO_TTVideo", "release error:" + th.getMessage());
                        }
                    }
                });
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.d
    public void d(boolean z) {
        com.bykv.vk.openvk.component.video.api.an.b.d("CSJ_VIDEO_TTVideo", "setIsMute: ");
        this.hc.setIsMute(z);
    }

    @Override // com.bykv.vk.openvk.component.video.api.d
    public int mk() {
        com.bykv.vk.openvk.component.video.api.an.b.d("CSJ_VIDEO_TTVideo", "getVideoWidth: ");
        return this.rf;
    }

    @Override // com.bykv.vk.openvk.component.video.api.d
    public int mq() {
        com.bykv.vk.openvk.component.video.api.an.b.d("CSJ_VIDEO_TTVideo", "getVideoHeight: ");
        return this.jh;
    }

    @Override // com.bykv.vk.openvk.component.video.api.d
    public boolean uo() {
        return this.hc.getPlaybackState() == 1;
    }

    @Override // com.bykv.vk.openvk.component.video.api.d
    public boolean k() {
        return this.hc.getPlaybackState() == 2;
    }

    @Override // com.bykv.vk.openvk.component.video.api.d
    public boolean e() {
        return this.u;
    }

    @Override // com.bykv.vk.openvk.component.video.api.d
    public long cb() {
        if (this.e == 0) {
            return 0L;
        }
        if (this.mq == 0 && this.uo != 0) {
            this.mq = System.currentTimeMillis() - this.uo;
        }
        return this.mq;
    }

    @Override // com.bykv.vk.openvk.component.video.api.d
    public int w() {
        return this.e;
    }

    private void yi() {
        this.hc.setVideoEngineSimpleCallback(new VideoEngineSimpleCallback() { // from class: com.bytedance.sdk.component.mq.hc.hc.2
            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onPlaybackStateChanged(TTVideoEngine tTVideoEngine, int i) {
                com.bykv.vk.openvk.component.video.api.an.b.d("CSJ_VIDEO_TTVideo", "onPlaybackStateChanged: playbackState =", Integer.valueOf(i));
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onLoadStateChanged(TTVideoEngine tTVideoEngine, int i) {
                com.bykv.vk.openvk.component.video.api.an.b.d("CSJ_VIDEO_TTVideo", "onLoadStateChanged: loadState =", Integer.valueOf(i));
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onVideoSizeChanged(TTVideoEngine tTVideoEngine, int i, int i2) {
                com.bykv.vk.openvk.component.video.api.an.b.d("CSJ_VIDEO_TTVideo", "onVideoSizeChanged: width = ", Integer.valueOf(i), " height = ", Integer.valueOf(i2));
                hc.this.rf = i;
                hc.this.jh = i2;
                for (WeakReference weakReference : hc.this.v) {
                    if (weakReference != null && weakReference.get() != null) {
                        ((d.InterfaceC0158d) weakReference.get()).d((com.bykv.vk.openvk.component.video.api.d) hc.this, i, i2);
                    }
                }
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onBufferingUpdate(TTVideoEngine tTVideoEngine, int i) {
                com.bykv.vk.openvk.component.video.api.an.b.d("CSJ_VIDEO_TTVideo", "onBufferingUpdate: percent =", Integer.valueOf(i));
                for (WeakReference weakReference : hc.this.v) {
                    if (weakReference != null && weakReference.get() != null) {
                        ((d.InterfaceC0158d) weakReference.get()).hc(hc.this, i);
                    }
                }
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onPrepare(TTVideoEngine tTVideoEngine) {
                com.bykv.vk.openvk.component.video.api.an.b.d("CSJ_VIDEO_TTVideo", "onPrepare: ");
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onPrepared(TTVideoEngine tTVideoEngine) {
                com.bykv.vk.openvk.component.video.api.an.b.d("CSJ_VIDEO_TTVideo", "onPrepared: ");
                hc.this.h = true;
                for (WeakReference weakReference : hc.this.v) {
                    if (weakReference != null && weakReference.get() != null) {
                        ((d.InterfaceC0158d) weakReference.get()).hc(hc.this);
                    }
                }
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onRenderStart(TTVideoEngine tTVideoEngine) {
                com.bykv.vk.openvk.component.video.api.an.b.d("CSJ_VIDEO_TTVideo", "onRenderStart: ");
                hc.this.mk = System.currentTimeMillis() - hc.this.tc;
                for (WeakReference weakReference : hc.this.v) {
                    if (weakReference != null && weakReference.get() != null) {
                        d.InterfaceC0158d interfaceC0158d = (d.InterfaceC0158d) weakReference.get();
                        hc hcVar = hc.this;
                        interfaceC0158d.d(hcVar, hcVar.mk);
                    }
                }
                hc.this.cb = true;
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onCompletion(TTVideoEngine tTVideoEngine) {
                com.bykv.vk.openvk.component.video.api.an.b.d("CSJ_VIDEO_TTVideo", "onCompletion: ");
                hc.this.an = true;
                if (hc.this.np != null) {
                    hc.this.np.removeCallbacks(hc.this.zw);
                }
                for (WeakReference weakReference : hc.this.v) {
                    if (weakReference != null && weakReference.get() != null) {
                        ((d.InterfaceC0158d) weakReference.get()).d(hc.this);
                    }
                }
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onError(Error error) {
                com.bykv.vk.openvk.component.video.api.an.b.d("CSJ_VIDEO_TTVideo", "onError: ");
                com.bykv.vk.openvk.component.video.api.b.hc hcVar = new com.bykv.vk.openvk.component.video.api.b.hc(error.getCode(), error.getInternalCode());
                for (WeakReference weakReference : hc.this.v) {
                    if (weakReference != null && weakReference.get() != null) {
                        ((d.InterfaceC0158d) weakReference.get()).d(hc.this, hcVar);
                    }
                }
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onBufferStart(int i, int i2, int i3) {
                hc.this.k = i;
                hc.this.e++;
                hc.this.uo = System.currentTimeMillis();
                com.bykv.vk.openvk.component.video.api.an.b.d("CSJ_VIDEO_TTVideo", "onBufferStart: reason =", Integer.valueOf(i), "  afterFirstFrame =", Integer.valueOf(i2), "  action=", Integer.valueOf(i3));
                for (WeakReference weakReference : hc.this.v) {
                    if (weakReference != null && weakReference.get() != null) {
                        ((d.InterfaceC0158d) weakReference.get()).d(hc.this, i, i2, i3);
                    }
                }
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onBufferEnd(int i) {
                if (hc.this.k == i) {
                    hc.this.mq += System.currentTimeMillis() - hc.this.uo;
                }
                com.bykv.vk.openvk.component.video.api.an.b.d("CSJ_VIDEO_TTVideo", "onBufferEnd: code =", Integer.valueOf(i));
                for (WeakReference weakReference : hc.this.v) {
                    if (weakReference != null && weakReference.get() != null) {
                        ((d.InterfaceC0158d) weakReference.get()).d((com.bykv.vk.openvk.component.video.api.d) hc.this, i);
                    }
                }
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onRenderSeekComplete(int i) {
                com.bykv.vk.openvk.component.video.api.an.b.d("CSJ_VIDEO_TTVideo", "onRenderSeekComplete: isSeekInCached = ", Integer.valueOf(i));
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onRetry(int i) {
                com.bykv.vk.openvk.component.video.api.an.b.d("CSJ_VIDEO_TTVideo", "onRetry: playType = ", Integer.valueOf(i));
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onMDLHitCache(String str, long j) {
                com.bykv.vk.openvk.component.video.api.an.b.d("CSJ_VIDEO_TTVideo", "onMDLHitCache: MDLPlayTaskKey =", str, " hitCacheSize = ", Long.valueOf(j));
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onUseMDLCacheEnd() {
                com.bykv.vk.openvk.component.video.api.an.b.d("CSJ_VIDEO_TTVideo", "onUseMDLCacheEnd: ");
            }
        });
    }

    private void he() {
        this.b = false;
        this.c = false;
        this.an = false;
        this.h = false;
        this.gb = false;
    }

    public static boolean jh() {
        return d;
    }

    public static void d(Context context, String str, int i, String[] strArr, long[] jArr, boolean z, VideoEventEngineUploader videoEventEngineUploader) {
        boolean z2;
        try {
            TTPlayerClient.create(new MediaPlayerWrapper(), b.getContext()).release();
            d.d(context, str, i, strArr, jArr, videoEventEngineUploader);
            d.d(z);
            z2 = true;
        } catch (Throwable unused) {
            z2 = false;
        }
        d = z2;
    }

    @Override // com.bykv.vk.openvk.component.video.api.d
    public SurfaceHolder h() {
        return this.de;
    }

    @Override // com.bykv.vk.openvk.component.video.api.d
    public SurfaceTexture gb() {
        return this.sy;
    }
}
