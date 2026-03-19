package com.alliance.ssp.ad.a0;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.alliance.ssp.ad.R;
import com.alliance.ssp.ad.api.SAAllianceAdParams;
import com.alliance.ssp.ad.api.stream.SAStreamAdLoadListener;
import com.alliance.ssp.ad.bean.Material;
import com.alliance.ssp.ad.bean.SAAllianceAdData;
import com.alliance.ssp.ad.bean.SAAllianceEngineData;
import com.alliance.ssp.ad.http.action.BaseNetAction;
import com.alliance.ssp.ad.o0.l;
import com.alliance.ssp.ad.o0.n;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: NMStreamAdImpl.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class b extends com.alliance.ssp.ad.a0.a {
    public SurfaceView D0;
    public CheckBox E0;
    public TextView F0;
    public ImageView G0;
    public ImageView H0;
    public FrameLayout.LayoutParams I0;
    public i J0;
    public MediaPlayer K0;
    public SurfaceHolder L0;
    public AtomicBoolean M0;
    public AtomicBoolean N0;
    public SAAllianceAdData O0;
    public volatile AtomicInteger P0;
    public Handler Q0;

    /* compiled from: NMStreamAdImpl.java */
    public class a implements MediaPlayer.OnCompletionListener {
        public a() {
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            b.this.E0.setChecked(false);
        }
    }

    /* compiled from: NMStreamAdImpl.java */
    /* renamed from: com.alliance.ssp.ad.a0.b$b, reason: collision with other inner class name */
    public class C0067b implements MediaPlayer.OnErrorListener {
        public C0067b() {
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            b.this.N0.set(false);
            return false;
        }
    }

    /* compiled from: NMStreamAdImpl.java */
    public class c extends Handler {
        public c() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            Context contextA = com.alliance.ssp.ad.o0.b.a(b.this.f);
            TextView textView = b.this.F0;
            if (textView != null) {
                textView.setText(String.format(contextA.getResources().getString(R.string.nm_stream_count_down_tip), Integer.valueOf(b.this.P0.get())));
            }
            if (b.this.P0.get() == 0) {
                return;
            }
            b.this.P0.decrementAndGet();
            b.this.Q0.sendEmptyMessageDelayed(0, 1000L);
        }
    }

    /* compiled from: NMStreamAdImpl.java */
    public class e implements MediaPlayer.OnPreparedListener {
        public final /* synthetic */ String a;

        public e(String str) {
            this.a = str;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            b.this.N0.set(true);
            b.a(b.this, this.a);
            b.this.Q0.sendEmptyMessageAtTime(0, 1000L);
        }
    }

    public b(int i, WeakReference<Activity> weakReference, SAAllianceAdParams sAAllianceAdParams, SAStreamAdLoadListener sAStreamAdLoadListener, com.alliance.ssp.ad.d0.g gVar) {
        super(i, weakReference, "", "", sAAllianceAdParams, sAStreamAdLoadListener, null, gVar);
        this.D0 = null;
        this.E0 = null;
        this.F0 = null;
        this.G0 = null;
        this.H0 = null;
        this.I0 = null;
        this.J0 = null;
        this.K0 = null;
        this.L0 = null;
        this.M0 = new AtomicBoolean(false);
        this.N0 = new AtomicBoolean(false);
        this.O0 = null;
        this.P0 = new AtomicInteger(5);
        this.Q0 = new c();
        gVar.g = this;
        a(sAAllianceAdParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E() {
        this.J0.c.onAdError(200005, "贴片链接为空");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F() {
        this.J0.c.onAdError(200006, "贴片初始化失败");
    }

    public static void a(b bVar, SAAllianceAdParams sAAllianceAdParams) {
        SAAllianceAdData sAAllianceAdData;
        View viewInflate;
        bVar.getClass();
        Objects.toString(sAAllianceAdParams);
        int i = l.a;
        if (sAAllianceAdParams == null || (sAAllianceAdData = bVar.O0) == null) {
            bVar.a(100005, "001", "无填充");
            return;
        }
        sAAllianceAdData.getRestype();
        Material material = bVar.O0.getMaterial();
        String tempid = material.getTempid();
        String videourl = material.getVideourl();
        Context contextA = com.alliance.ssp.ad.o0.b.a(bVar.f);
        View view = null;
        try {
            viewInflate = "5".equalsIgnoreCase(tempid) ? LayoutInflater.from(contextA).inflate(R.layout.layout_nmssp_stream, (ViewGroup) null, false) : LayoutInflater.from(contextA).inflate(R.layout.layout_nmssp_stream, (ViewGroup) null, false);
        } catch (Exception e2) {
            e2.printStackTrace();
            viewInflate = null;
        }
        if (viewInflate != null && contextA != null) {
            bVar.D0 = (SurfaceView) viewInflate.findViewById(R.id.sv_nm_stream_ad);
            bVar.E0 = (CheckBox) viewInflate.findViewById(R.id.cb_nm_stream_audio_switch);
            bVar.F0 = (TextView) viewInflate.findViewById(R.id.tv_nm_stream_count_down);
            bVar.G0 = (ImageView) viewInflate.findViewById(R.id.iv_nm_stream_screen_orientation);
            bVar.H0 = (ImageView) viewInflate.findViewById(R.id.iv_nm_stream_back);
            bVar.P0.set(material.getDuration());
            if (bVar.F0 != null && bVar.P0.get() > 0) {
                bVar.F0.setText(String.format(contextA.getResources().getString(R.string.nm_stream_count_down_tip), Integer.valueOf(bVar.P0.get())));
            }
            TextView textView = bVar.F0;
            if (textView != null) {
                textView.setOnClickListener(new f(bVar));
            }
            ImageView imageView = bVar.G0;
            if (imageView != null) {
                imageView.setOnClickListener(new g(bVar));
            }
            ImageView imageView2 = bVar.H0;
            if (imageView2 != null) {
                imageView2.setOnClickListener(new h(bVar));
            }
            view = viewInflate;
        }
        if (view == null) {
            bVar.a(100005, "001", "无填充");
            return;
        }
        bVar.J0 = new i();
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) bVar.D0.getLayoutParams();
        bVar.I0 = layoutParams;
        layoutParams.width = sAAllianceAdParams.getExpressViewAcceptedWidth();
        bVar.I0.height = sAAllianceAdParams.getExpressViewAcceptedHeight();
        bVar.D0.setLayoutParams(bVar.I0);
        bVar.J0.d = view;
        view.addOnAttachStateChangeListener(new com.alliance.ssp.ad.a0.c(bVar, videourl));
        bVar.a(bVar.J0);
        SurfaceView surfaceView = bVar.D0;
        if (surfaceView != null) {
            SurfaceHolder holder = surfaceView.getHolder();
            bVar.L0 = holder;
            if (holder != null) {
                holder.addCallback(new com.alliance.ssp.ad.a0.d(bVar, videourl));
            }
        }
        view.setOnClickListener(new com.alliance.ssp.ad.a0.e(bVar, material));
    }

    public final void c(String str) {
        if (TextUtils.isEmpty(str)) {
            i iVar = this.J0;
            if (iVar == null || iVar.c == null) {
                return;
            }
            n.d.c.post(new Runnable() { // from class: com.alliance.ssp.ad.a0.b$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.E();
                }
            });
            return;
        }
        MediaPlayer mediaPlayer = this.K0;
        if (mediaPlayer == null) {
            this.K0 = new MediaPlayer();
        } else {
            mediaPlayer.reset();
        }
        try {
            this.N0.set(false);
            if (this.M0.get()) {
                this.K0.setDisplay(this.L0);
            }
            this.K0.setVolume(0.0f, 0.0f);
            this.K0.setAudioStreamType(3);
            this.K0.setDataSource(str);
            this.K0.prepareAsync();
        } catch (Exception e2) {
            e2.printStackTrace();
            i iVar2 = this.J0;
            if (iVar2 != null && iVar2.c != null) {
                n.d.c.post(new Runnable() { // from class: com.alliance.ssp.ad.a0.b$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.F();
                    }
                });
            }
        }
        MediaPlayer mediaPlayer2 = this.K0;
        if (mediaPlayer2 != null) {
            mediaPlayer2.setOnPreparedListener(new e(str));
            this.K0.setOnCompletionListener(new a());
            this.K0.setOnErrorListener(new C0067b());
        }
    }

    /* compiled from: NMStreamAdImpl.java */
    public class d implements com.alliance.ssp.ad.p.a<SAAllianceEngineData> {
        public final /* synthetic */ SAAllianceAdParams a;

        public d(SAAllianceAdParams sAAllianceAdParams) {
            this.a = sAAllianceAdParams;
        }

        @Override // com.alliance.ssp.ad.p.a
        public void a(SAAllianceEngineData sAAllianceEngineData) {
            SAAllianceEngineData sAAllianceEngineData2 = sAAllianceEngineData;
            try {
                List<SAAllianceAdData> data = sAAllianceEngineData2.getData();
                if (data.size() > 0 && !sAAllianceEngineData2.getData().isEmpty() && sAAllianceEngineData2.getData() != null) {
                    for (SAAllianceAdData sAAllianceAdData : data) {
                        b.this.O0 = sAAllianceAdData;
                        sAAllianceAdData.getPrice();
                        b.a(b.this, this.a);
                    }
                    return;
                }
                b.this.a(100005, "002", "无填充");
            } catch (Exception unused) {
                b.this.a(100005, "001", "无填充");
            }
        }

        @Override // com.alliance.ssp.ad.p.a
        public void a(int i, String str) {
            b.this.a(100005, "001", str);
        }
    }

    public static void a(b bVar, String str) {
        bVar.getClass();
        try {
            if (bVar.K0 == null) {
                bVar.c(str);
            } else if (bVar.N0.get()) {
                bVar.K0.setVolume(0.0f, 0.0f);
                bVar.K0.seekTo(0);
                bVar.K0.start();
                bVar.D0.setVisibility(0);
                bVar.E0.setChecked(false);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void a(SAAllianceAdParams sAAllianceAdParams) {
        new com.alliance.ssp.ad.http.action.b(sAAllianceAdParams, this.w, this.C0, 0, new d(sAAllianceAdParams), BaseNetAction.Method.POST).a();
    }

    public static void a(b bVar) {
        bVar.N0.set(false);
        MediaPlayer mediaPlayer = bVar.K0;
        if (mediaPlayer != null) {
            if (mediaPlayer.isPlaying()) {
                bVar.K0.stop();
            }
            bVar.K0.release();
            bVar.K0 = null;
        }
    }
}
