package com.bytedance.sdk.component.mq.d;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.bykv.vk.component.ttvideo.ILiveListener;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bykv.vk.component.ttvideo.ILiveSettingBundle;
import com.bykv.vk.component.ttvideo.INetworkClient;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.bykv.vk.component.ttvideo.VideoLiveManager;
import com.bykv.vk.component.ttvideo.log.LiveError;
import com.bykv.vk.openvk.component.video.api.b;
import com.bykv.vk.openvk.component.video.api.b.c;
import com.bykv.vk.openvk.component.video.api.b.hc;
import com.bykv.vk.openvk.component.video.api.d;
import com.bytedance.sdk.component.hc.d.cb;
import com.bytedance.sdk.component.hc.d.k;
import com.bytedance.sdk.component.utils.mq;
import com.bytedance.sdk.component.utils.zw;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d implements com.bykv.vk.openvk.component.video.api.d, zw.d {
    private zw an;
    private final Context b;
    private boolean ba;
    private int c;
    private ILivePlayer d;
    private JSONObject fs;
    private volatile boolean h;
    private SurfaceHolder he;
    private volatile c j;
    private boolean mt;
    private int u;
    private long v;
    private SurfaceTexture vv;
    private long w;
    private final List<WeakReference<d.InterfaceC0158d>> hc = Collections.synchronizedList(new ArrayList());
    private AtomicBoolean gb = new AtomicBoolean(false);
    private AtomicBoolean tt = new AtomicBoolean(false);
    private volatile boolean tc = false;
    private volatile boolean mk = false;
    private volatile boolean mq = false;
    private volatile boolean uo = false;
    private volatile boolean k = false;
    private volatile boolean e = false;
    private volatile boolean cb = true;
    private long yo = 0;
    private long rf = 0;
    private final int jh = 0;
    private int sy = 0;
    private long de = 0;
    private long np = 0;
    private volatile boolean yi = false;
    private volatile int zw = 200;
    private long s = 0;
    private final ArrayList<Runnable> us = new ArrayList<>();
    private final Runnable z = new Runnable() { // from class: com.bytedance.sdk.component.mq.d.d.1
        @Override // java.lang.Runnable
        public void run() {
            long jRf = d.this.rf();
            d.this.np += d.this.zw;
            if (d.this.yo() > 0 && d.this.s != jRf) {
                if (b.c()) {
                    com.bykv.vk.openvk.component.video.api.an.b.d("TTLiveVideoPlayer", "run: lastCur = " + d.this.s + "  currentPosition=" + jRf);
                }
                d dVar = d.this;
                dVar.d(jRf, dVar.yo());
            }
            d.this.s = jRf;
            if (d.this.rf() >= d.this.v) {
                d.this.uo = true;
                d.this.u();
                for (WeakReference weakReference : d.this.hc) {
                    if (weakReference != null && weakReference.get() != null) {
                        ((d.InterfaceC0158d) weakReference.get()).d(d.this);
                    }
                }
            }
            if (!d.this.uo) {
                if (d.this.an != null) {
                    d.this.an.postDelayed(this, d.this.zw);
                }
            } else {
                d dVar2 = d.this;
                dVar2.d(dVar2.yo(), d.this.yo());
            }
        }
    };
    private final ILiveListener r = new ILiveListener() { // from class: com.bytedance.sdk.component.mq.d.d.7
        private boolean hc = false;

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onAbrSwitch(String str) {
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onAudioRenderStall(int i) {
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onCacheFileCompletion() {
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onReportALog(int i, String str) {
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onResolutionDegrade(String str) {
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onSeiUpdate(String str) {
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onVideoRenderStall(int i) {
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onError(LiveError liveError) {
            if (liveError != null) {
                if (this.hc) {
                    return;
                }
                this.hc = true;
                hc hcVar = new hc(liveError.code, 0, liveError.getInfoJSON());
                for (WeakReference weakReference : d.this.hc) {
                    if (weakReference != null && weakReference.get() != null) {
                        ((d.InterfaceC0158d) weakReference.get()).d(d.this, hcVar);
                    }
                }
            }
            d.this.cb = true;
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onFirstFrame(boolean z) {
            if (d.this.an == null) {
                return;
            }
            d.this.yi = true;
            d.this.an.removeCallbacks(d.this.z);
            if (d.this.v > 0) {
                d.this.an.postDelayed(d.this.z, d.this.zw);
            }
            d.this.cb = false;
            if (z) {
                d.this.yo = System.currentTimeMillis() - d.this.w;
                for (WeakReference weakReference : d.this.hc) {
                    if (weakReference != null && weakReference.get() != null) {
                        d.InterfaceC0158d interfaceC0158d = (d.InterfaceC0158d) weakReference.get();
                        d dVar = d.this;
                        interfaceC0158d.d(dVar, dVar.yo);
                    }
                }
                return;
            }
            com.bykv.vk.openvk.component.video.api.an.b.hc("TTLiveVideoPlayer", "onFirstFrame-> not first frame , isFirstFrame=".concat(String.valueOf(z)));
            for (WeakReference weakReference2 : d.this.hc) {
                if (weakReference2 != null && weakReference2.get() != null) {
                    ((d.InterfaceC0158d) weakReference2.get()).d((com.bykv.vk.openvk.component.video.api.d) d.this, -1);
                }
            }
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onStallStart() {
            if (d.this.an == null) {
                return;
            }
            d.w(d.this);
            d.this.de = System.currentTimeMillis();
            d.this.an.removeCallbacks(d.this.z);
            for (WeakReference weakReference : d.this.hc) {
                if (weakReference != null && weakReference.get() != null) {
                    ((d.InterfaceC0158d) weakReference.get()).d(d.this, -1, -1, -1);
                }
            }
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onStallEnd() {
            if (d.this.an == null) {
                return;
            }
            if (d.this.v > 0) {
                d.this.an.postDelayed(d.this.z, d.this.zw);
            }
            d.this.rf += System.currentTimeMillis() - d.this.de;
            for (WeakReference weakReference : d.this.hc) {
                if (weakReference != null && weakReference.get() != null) {
                    ((d.InterfaceC0158d) weakReference.get()).d((com.bykv.vk.openvk.component.video.api.d) d.this, -1);
                }
            }
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onCompletion() {
            if (d.this.an == null) {
                return;
            }
            d.this.an.removeCallbacks(d.this.z);
            for (WeakReference weakReference : d.this.hc) {
                if (weakReference != null && weakReference.get() != null) {
                    ((d.InterfaceC0158d) weakReference.get()).d(d.this, -1, -1, -1);
                }
            }
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onPrepared() {
            com.bykv.vk.openvk.component.video.api.an.b.d("TTLiveVideoPlayer", "onPrepared.....");
            d.this.k = true;
            for (WeakReference weakReference : d.this.hc) {
                if (weakReference != null && weakReference.get() != null) {
                    ((d.InterfaceC0158d) weakReference.get()).hc(d.this);
                }
            }
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onVideoSizeChanged(int i, int i2) {
            d.this.c = i;
            d.this.u = i2;
            for (WeakReference weakReference : d.this.hc) {
                if (weakReference != null && weakReference.get() != null) {
                    ((d.InterfaceC0158d) weakReference.get()).d((com.bykv.vk.openvk.component.video.api.d) d.this, i, i2);
                }
            }
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onMonitorLog(JSONObject jSONObject, String str) {
            for (WeakReference weakReference : d.this.hc) {
                if (weakReference != null && weakReference.get() != null) {
                    ((d.InterfaceC0158d) weakReference.get()).d(d.this, jSONObject, str);
                }
            }
        }
    };

    @Override // com.bykv.vk.openvk.component.video.api.d
    public void d(float f) {
    }

    @Override // com.bykv.vk.openvk.component.video.api.d
    public void d(int i) {
    }

    @Override // com.bykv.vk.openvk.component.video.api.d
    public void d(long j) {
    }

    static /* synthetic */ int w(d dVar) {
        int i = dVar.sy;
        dVar.sy = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(long j, long j2) {
        for (WeakReference<d.InterfaceC0158d> weakReference : this.hc) {
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().d(this, j, j2);
            }
        }
    }

    public d(Context context, boolean z, long j, JSONObject jSONObject, Looper looper) {
        this.an = null;
        this.h = false;
        this.v = 0L;
        this.b = context;
        this.fs = jSONObject;
        this.v = j > 0 ? j * 1000 : -1L;
        if (looper != null) {
            this.an = new zw(looper, this);
            this.h = true;
        } else if (this.an == null) {
            this.an = com.bytedance.sdk.component.tc.hc.d.d().d(this, "tt-live-video-player");
        }
        c(z);
    }

    private void c(final boolean z) {
        zw zwVar = this.an;
        if (zwVar != null) {
            zwVar.post(new Runnable() { // from class: com.bytedance.sdk.component.mq.d.d.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        ILiveSettingBundle iLiveSettingBundle = new ILiveSettingBundle() { // from class: com.bytedance.sdk.component.mq.d.d.2.1
                            /* JADX WARN: Multi-variable type inference failed */
                            /* JADX WARN: Removed duplicated region for block: B:13:0x002c  */
                            /* JADX WARN: Removed duplicated region for block: B:14:0x002f  */
                            /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Integer] */
                            @Override // com.bykv.vk.component.ttvideo.ILiveSettingBundle
                            /*
                                Code decompiled incorrectly, please refer to instructions dump.
                                To view partially-correct code enable 'Show inconsistent code' option in preferences
                            */
                            public <T> T getSettingsValueForKey(java.lang.String r2, T r3) throws java.lang.NumberFormatException {
                                /*
                                    r1 = this;
                                    r2.hashCode()
                                    java.lang.String r0 = "live_enable_close_play_retry"
                                    boolean r0 = r2.equals(r0)
                                    if (r0 != 0) goto L14
                                    java.lang.String r0 = "live_sdk_cancel_sdk_dns_fail_retry"
                                    boolean r2 = r2.equals(r0)
                                    if (r2 != 0) goto L23
                                    goto L30
                                L14:
                                    java.lang.Class r2 = r3.getClass()
                                    java.lang.Class<java.lang.Integer> r0 = java.lang.Integer.class
                                    if (r2 != r0) goto L23
                                    java.lang.String r2 = "1"
                                    java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
                                    goto L24
                                L23:
                                    r2 = r3
                                L24:
                                    java.lang.Class r3 = r3.getClass()
                                    java.lang.Class<java.lang.Boolean> r0 = java.lang.Boolean.class
                                    if (r3 != r0) goto L2f
                                    java.lang.Boolean r3 = java.lang.Boolean.TRUE
                                    goto L30
                                L2f:
                                    r3 = r2
                                L30:
                                    return r3
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.mq.d.d.AnonymousClass2.AnonymousClass1.getSettingsValueForKey(java.lang.String, java.lang.Object):java.lang.Object");
                            }
                        };
                        d dVar = d.this;
                        dVar.d = VideoLiveManager.newBuilder(dVar.b).setProjectKey("pangle_ad_live").setNetworkClient(new C0282d()).setForceHttpDns(false).setForceTTNetHttpDns(false).setSettingsBundle(iLiveSettingBundle).setPlayerType(1).setListener(d.this.r).build();
                        d.this.d.setIntOption(69, z ? 1 : 0);
                        d.this.d.setStringOption(72, com.bytedance.sdk.openadsdk.api.plugin.hc.d(d.this.b, (String) null).getAbsolutePath() + "/pangle_live/");
                    } catch (Exception e) {
                        com.bykv.vk.openvk.component.video.api.an.b.b("TTLiveVideoPlayer", e.getMessage());
                    }
                }
            });
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.d
    public void d(c cVar) {
        if (cVar == null) {
            return;
        }
        this.j = cVar;
        com.bykv.vk.openvk.component.video.api.an.b.d("TTLiveVideoPlayer", "setDataSource: model = " + cVar.cb());
        zw zwVar = this.an;
        if (zwVar != null) {
            zwVar.sendEmptyMessage(107);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.d
    public void d() {
        this.sy = 0;
        this.rf = 0L;
        this.de = 0L;
        d(true, 0L, false);
    }

    @Override // com.bykv.vk.openvk.component.video.api.d
    public void d(boolean z, final long j, final boolean z2) {
        zw zwVar;
        if (this.tt.get() && this.tc && this.d != null) {
            this.np = j;
            this.w = System.currentTimeMillis();
            d(z2);
            zw zwVar2 = this.an;
            if (zwVar2 != null) {
                zwVar2.sendEmptyMessage(100);
            }
            mq.hc("TTLiveVideoPlayer", "TTLiveVideoPlayer...play......");
        } else {
            d(new Runnable() { // from class: com.bytedance.sdk.component.mq.d.d.3
                @Override // java.lang.Runnable
                public void run() {
                    d.this.np = j;
                    d.this.w = System.currentTimeMillis();
                    d.this.d(z2);
                    if (d.this.an != null) {
                        d.this.an.sendEmptyMessage(100);
                    }
                }
            });
        }
        this.gb.set(true);
        if (!this.tt.get() || (zwVar = this.an) == null) {
            return;
        }
        zwVar.post(new Runnable() { // from class: com.bytedance.sdk.component.mq.d.d.4
            @Override // java.lang.Runnable
            public void run() {
                d.this.jh();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void jh() {
        ArrayList<Runnable> arrayList = this.us;
        if (arrayList != null && !arrayList.isEmpty()) {
            sy();
        }
    }

    private synchronized void d(Runnable runnable) {
        this.us.add(runnable);
    }

    private synchronized void sy() {
        if (this.ba) {
            return;
        }
        this.ba = true;
        Iterator it = new ArrayList(this.us).iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        this.us.clear();
        this.ba = false;
    }

    @Override // com.bykv.vk.openvk.component.video.api.d
    public void hc() {
        zw zwVar = this.an;
        if (zwVar != null) {
            zwVar.post(new Runnable() { // from class: com.bytedance.sdk.component.mq.d.d.5
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.d == null || d.this.uo()) {
                        return;
                    }
                    try {
                        d.this.d.play();
                        d dVar = d.this;
                        dVar.d(dVar.mt);
                        for (WeakReference weakReference : d.this.hc) {
                            if (weakReference != null && weakReference.get() != null) {
                                weakReference.get();
                            }
                        }
                    } catch (Throwable th) {
                        com.bykv.vk.openvk.component.video.api.an.b.d("TTLiveVideoPlayer", "play: catch exception", th);
                    }
                    d.this.cb = false;
                }
            });
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.d
    public void d(boolean z) {
        this.mt = z;
        if (this.d != null) {
            com.bykv.vk.openvk.component.video.api.an.b.hc("TTLiveVideoPlayer", "TTLiveVideoPlayer...setQuietPlay......isMute=".concat(String.valueOf(z)));
            try {
                this.d.setMute(Boolean.valueOf(z));
            } catch (Throwable th) {
                com.bykv.vk.openvk.component.video.api.an.b.d("TTLiveVideoPlayer", "setMute: catch exception:", th);
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.d
    public void b() {
        com.bykv.vk.openvk.component.video.api.an.b.hc("TTLiveVideoPlayer", "TTLiveVideoPlayer...pause......pause....currentPosition=" + rf());
        zw zwVar = this.an;
        if (zwVar != null) {
            zwVar.removeCallbacks(this.z);
            zwVar.sendEmptyMessage(101);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.d
    public void c() {
        com.bykv.vk.openvk.component.video.api.an.b.hc("TTLiveVideoPlayer", "TTLiveVideoPlayer...stop......stop....currentPosition=" + rf());
        zw zwVar = this.an;
        if (zwVar != null) {
            zwVar.removeCallbacks(this.z);
            zwVar.sendEmptyMessage(105);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.d
    public void u() {
        zw zwVar = this.an;
        if (zwVar != null) {
            zwVar.removeCallbacks(this.z);
            zwVar.sendEmptyMessage(103);
            de();
        }
        com.bykv.vk.openvk.component.video.api.an.b.hc("TTLiveVideoPlayer", "TTLiveVideoPlayer...release......release....");
    }

    private void de() {
        zw zwVar = this.an;
        if (zwVar == null || zwVar.getLooper() == null) {
            return;
        }
        this.an.post(new Runnable() { // from class: com.bytedance.sdk.component.mq.d.d.6
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.an == null || d.this.an.getLooper() == null) {
                    return;
                }
                try {
                    d.this.vv = null;
                    d.this.he = null;
                    if (d.this.h) {
                        d.this.an.removeCallbacksAndMessages(null);
                    } else {
                        com.bytedance.sdk.component.tc.hc.d.d().d(d.this.an);
                    }
                    d.this.an = null;
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.bykv.vk.openvk.component.video.api.d
    public boolean an() {
        return this.yi;
    }

    @Override // com.bykv.vk.openvk.component.video.api.d
    public void hc(boolean z) {
        this.mq = z;
    }

    @Override // com.bykv.vk.openvk.component.video.api.d
    public void d(SurfaceHolder surfaceHolder) {
        this.he = surfaceHolder;
        com.bykv.vk.openvk.component.video.api.an.b.hc("TTLiveVideoPlayer", "TTLiveVideoPlayer...SurfaceHolder......".concat(String.valueOf(surfaceHolder)));
        zw zwVar = this.an;
        if (zwVar != null) {
            zwVar.obtainMessage(110, surfaceHolder).sendToTarget();
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.d
    public void d(SurfaceTexture surfaceTexture) {
        this.vv = surfaceTexture;
        zw zwVar = this.an;
        if (zwVar != null) {
            zwVar.obtainMessage(111, surfaceTexture).sendToTarget();
        }
        com.bykv.vk.openvk.component.video.api.an.b.hc("TTLiveVideoPlayer", "setSurface...surface=");
    }

    @Override // com.bykv.vk.openvk.component.video.api.d
    public boolean tt() {
        com.bykv.vk.openvk.component.video.api.an.b.hc("TTLiveVideoPlayer", "TTLiveVideoPlayer...isCompleted......isComplete....=" + this.uo);
        return this.uo;
    }

    @Override // com.bykv.vk.openvk.component.video.api.d
    public boolean tc() {
        return this.e;
    }

    @Override // com.bykv.vk.openvk.component.video.api.d
    public int mk() {
        return this.c;
    }

    @Override // com.bykv.vk.openvk.component.video.api.d
    public int mq() {
        return this.u;
    }

    @Override // com.bykv.vk.openvk.component.video.api.d
    public boolean uo() {
        ILivePlayer iLivePlayer = this.d;
        if (iLivePlayer == null) {
            return false;
        }
        try {
            return iLivePlayer.isPlaying();
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.an.b.d("TTLiveVideoPlayer", "isPlaying: catch exception:", th);
            return false;
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.d
    public boolean k() {
        return this.cb;
    }

    @Override // com.bykv.vk.openvk.component.video.api.d
    public boolean e() {
        return this.mk;
    }

    @Override // com.bykv.vk.openvk.component.video.api.d
    public long cb() {
        return this.rf;
    }

    @Override // com.bykv.vk.openvk.component.video.api.d
    public int w() {
        return this.sy;
    }

    @Override // com.bykv.vk.openvk.component.video.api.d
    public long yo() {
        return this.v;
    }

    @Override // com.bykv.vk.openvk.component.video.api.d
    public long rf() {
        return this.np;
    }

    @Override // com.bykv.vk.openvk.component.video.api.d
    public void b(boolean z) {
        com.bykv.vk.openvk.component.video.api.an.b.d("TTLiveVideoPlayer", "setLoop: live is invalid ");
    }

    @Override // com.bykv.vk.openvk.component.video.api.d
    public void d(d.InterfaceC0158d interfaceC0158d) {
        if (interfaceC0158d == null) {
            return;
        }
        for (WeakReference<d.InterfaceC0158d> weakReference : this.hc) {
            if (weakReference != null && weakReference.get() == interfaceC0158d) {
                return;
            }
        }
        this.hc.add(new WeakReference<>(interfaceC0158d));
    }

    @Override // com.bykv.vk.openvk.component.video.api.d
    public void hc(int i) {
        this.zw = i;
    }

    @Override // com.bytedance.sdk.component.utils.zw.d
    public void d(Message message) {
        try {
            switch (message.what) {
                case 100:
                    hc();
                    this.e = true;
                    return;
                case 101:
                    ILivePlayer iLivePlayer = this.d;
                    if (iLivePlayer != null) {
                        try {
                            iLivePlayer.stop();
                            for (WeakReference<d.InterfaceC0158d> weakReference : this.hc) {
                                if (weakReference != null && weakReference.get() != null) {
                                    weakReference.get();
                                }
                            }
                        } catch (Throwable th) {
                            com.bykv.vk.openvk.component.video.api.an.b.d("TTLiveVideoPlayer", "pause: catch exception:", th);
                        }
                        this.cb = true;
                        return;
                    }
                    return;
                case 102:
                    ILivePlayer iLivePlayer2 = this.d;
                    if (iLivePlayer2 != null) {
                        try {
                            iLivePlayer2.reset();
                        } catch (Throwable th2) {
                            com.bykv.vk.openvk.component.video.api.an.b.d("TTLiveVideoPlayer", "reset: catch exception:", th2);
                        }
                        this.cb = true;
                        return;
                    }
                    return;
                case 103:
                    ILivePlayer iLivePlayer3 = this.d;
                    if (iLivePlayer3 != null) {
                        try {
                            iLivePlayer3.release();
                        } catch (Throwable th3) {
                            com.bykv.vk.openvk.component.video.api.an.b.d("TTLiveVideoPlayer", "release: catch exception:", th3);
                        }
                        this.mk = true;
                        this.cb = true;
                        return;
                    }
                    return;
                case 104:
                case 106:
                case 108:
                case 109:
                default:
                    return;
                case 105:
                    ILivePlayer iLivePlayer4 = this.d;
                    if (iLivePlayer4 != null) {
                        try {
                            iLivePlayer4.stop();
                        } catch (Throwable th4) {
                            com.bykv.vk.openvk.component.video.api.an.b.d("TTLiveVideoPlayer", "stop: catch exception:", th4);
                        }
                        this.cb = true;
                        return;
                    }
                    return;
                case 107:
                    if (this.d == null || this.j == null) {
                        return;
                    }
                    String strCb = this.j.cb();
                    d(strCb);
                    this.d.setStreamInfo(strCb);
                    this.tc = true;
                    com.bykv.vk.openvk.component.video.api.an.b.d("TTLiveVideoPlayer", "set Datasource:" + this.tc);
                    this.sy = 0;
                    return;
                case 110:
                    if (this.d != null) {
                        SurfaceHolder surfaceHolder = (SurfaceHolder) message.obj;
                        this.d.setSurfaceHolder(surfaceHolder);
                        this.d.setSurface(surfaceHolder.getSurface());
                        this.tt.set(true);
                        if (this.gb.get()) {
                            jh();
                            return;
                        }
                        return;
                    }
                    return;
                case 111:
                    ILivePlayer iLivePlayer5 = this.d;
                    if (iLivePlayer5 != null) {
                        iLivePlayer5.setSurface(new Surface(this.vv));
                        this.tt.set(true);
                        if (this.gb.get()) {
                            jh();
                            return;
                        }
                        return;
                    }
                    return;
            }
        } catch (Exception e) {
            e.getMessage();
        }
        e.getMessage();
    }

    private void d(String str) {
        String str2 = LiveConfigKey.UHD;
        try {
            JSONObject jSONObject = this.fs;
            if (jSONObject == null) {
                return;
            }
            com.bykv.vk.openvk.component.video.api.an.b.d("TTLiveVideoPlayer", "live ".concat(String.valueOf(jSONObject)));
            int iOptInt = jSONObject.optInt("enable");
            String strOptString = jSONObject.optString("appids");
            if (iOptInt == 1 && !TextUtils.isEmpty(strOptString)) {
                JSONObject jSONObject2 = new JSONObject(str);
                JSONObject jSONObjectOptJSONObject = jSONObject2.optJSONObject("common");
                JSONObject jSONObjectOptJSONObject2 = jSONObject2.optJSONObject("data");
                if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject2 != null) {
                    String strOptString2 = jSONObjectOptJSONObject.optString(com.alipay.sdk.m.k.b.D0);
                    com.bykv.vk.openvk.component.video.api.an.b.d("TTLiveVideoPlayer", "api ".concat(String.valueOf(strOptString2)));
                    if (strOptString.contains(strOptString2)) {
                        if (jSONObjectOptJSONObject2.optJSONObject(LiveConfigKey.UHD) == null) {
                            if (jSONObjectOptJSONObject2.optJSONObject(LiveConfigKey.HIGH) != null) {
                                str2 = LiveConfigKey.HIGH;
                            } else if (jSONObjectOptJSONObject2.optJSONObject("sd") != null) {
                                str2 = "sd";
                            } else {
                                str2 = jSONObjectOptJSONObject2.optJSONObject(LiveConfigKey.LOW) != null ? LiveConfigKey.LOW : null;
                            }
                        }
                        if (TextUtils.isEmpty(str2)) {
                            return;
                        }
                        com.bykv.vk.openvk.component.video.api.an.b.d("TTLiveVideoPlayer", "update reso:".concat(String.valueOf(str2)));
                        this.d.setStringOption(43, str2);
                    }
                }
            }
        } catch (Exception e) {
            com.bykv.vk.openvk.component.video.api.an.b.d("TTLiveVideoPlayer", "updateStream: catch exception:", e.getMessage());
        }
    }

    /* renamed from: com.bytedance.sdk.component.mq.d.d$d, reason: collision with other inner class name */
    public static class C0282d implements INetworkClient {
        private final com.bytedance.sdk.component.hc.d.mq d = b.b().hc().d(10, TimeUnit.SECONDS).hc(10, TimeUnit.SECONDS).b(10, TimeUnit.SECONDS).d();

        @Override // com.bykv.vk.component.ttvideo.INetworkClient
        public INetworkClient.Result doPost(String str, String str2) {
            return null;
        }

        @Override // com.bykv.vk.component.ttvideo.INetworkClient
        public INetworkClient.Result doRequest(String str, String str2) {
            String str3;
            String strHc;
            String str4 = null;
            String string = null;
            JSONObject jSONObject = null;
            try {
                try {
                    cb cbVarD = this.d.d(new k.d().d(str).hc("host", str2).hc()).d();
                    if (cbVarD.c()) {
                        strHc = cbVarD.an().hc();
                        try {
                            string = cbVarD.h().toString();
                            jSONObject = new JSONObject(strHc);
                        } catch (JSONException e) {
                            e = e;
                            String str5 = string;
                            str4 = strHc;
                            str3 = str5;
                            return INetworkClient.Result.newBuilder().setBody(str4).setHeader(str3).setException(e).build();
                        }
                    } else {
                        strHc = null;
                    }
                    return INetworkClient.Result.newBuilder().setResponse(jSONObject).setBody(strHc).build();
                } catch (IOException e2) {
                    return INetworkClient.Result.newBuilder().setException(e2).build();
                } catch (Exception e3) {
                    return INetworkClient.Result.newBuilder().setException(e3).build();
                }
            } catch (JSONException e4) {
                e = e4;
                str3 = null;
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.d
    public SurfaceTexture gb() {
        return this.vv;
    }

    @Override // com.bykv.vk.openvk.component.video.api.d
    public SurfaceHolder h() {
        return this.he;
    }
}
