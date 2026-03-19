package com.sigmob.sdk.videoplayer;

import android.R;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import com.czhj.sdk.common.utils.IntentUtil;
import com.czhj.sdk.common.utils.ResourceUtil;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.n;
import com.sigmob.windad.WindAdError;
import com.sigmob.windad.WindAds;
import java.lang.reflect.InvocationTargetException;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class f extends RelativeLayout implements View.OnClickListener, View.OnTouchListener, SeekBar.OnSeekBarChangeListener, h {
    private static final String V = "android.media.VOLUME_CHANGED_ACTION";
    private static final String W = "android.media.EXTRA_VOLUME_STREAM_TYPE";
    public static final String a = "VideoPlayerView";
    public static final int b = -1;
    public static final int c = 0;
    public static final int d = 1;
    public static final int e = 2;
    public static final int f = 3;
    public static final int g = 4;
    public static final int h = 5;
    public static final int i = 6;
    public static final int j = 7;
    public static final int k = 1;
    public static final int l = 2;
    public static final int m = 3;
    public static final int n = 0;
    public static final int o = 80;
    public static boolean p = true;
    public static int q = 6;
    public static int r = 1;
    public static boolean s = false;
    public static boolean t = true;
    public static int u;
    public int A;
    public Class B;
    public boolean C;
    public i D;
    public int E;
    public int F;
    public int G;
    public long H;
    public ImageView I;
    public ImageView J;

    /* renamed from: K, reason: collision with root package name */
    public ImageView f796K;
    public boolean L;
    protected long M;
    protected Timer N;
    protected int O;
    protected int P;
    protected AudioManager Q;
    protected a R;
    protected boolean S;
    l T;
    public AudioManager.OnAudioFocusChangeListener U;
    private ViewGroup aa;
    private ViewGroup ab;
    private ViewGroup ac;
    private ViewGroup ad;
    private ViewGroup ae;
    private ViewGroup af;
    private ViewGroup ag;
    private ViewGroup ah;
    private ProgressBar ai;
    private ImageView aj;
    private com.sigmob.sdk.nativead.j ak;
    private boolean al;
    private com.sigmob.sdk.videoplayer.b am;
    private ImageView an;
    private int ao;
    private int ap;
    private c aq;
    private boolean ar;
    private View as;
    private boolean at;
    private View au;
    public f v;
    public int w;
    public int x;
    public g y;
    public int z;

    /* renamed from: com.sigmob.sdk.videoplayer.f$3, reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[e.values().length];
            a = iArr;
            try {
                iArr[e.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[e.RETRY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[e.VOLUME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[e.FULLSCREEN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[e.BIGRETRY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[e.BACK.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public class a extends TimerTask {
        public a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a() {
            long currentPositionWhenPlaying = f.this.getCurrentPositionWhenPlaying();
            long duration = f.this.getDuration();
            f.this.a((int) ((100 * currentPositionWhenPlaying) / (duration == 0 ? 1L : duration)), currentPositionWhenPlaying, duration);
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (f.this.w == 4 || f.this.w == 5) {
                WindAds.sharedAds().getHandler().post(new Runnable() { // from class: com.sigmob.sdk.videoplayer.f$a$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.a();
                    }
                });
            }
        }
    }

    private interface b {
        void a(int volume);
    }

    private class c extends BroadcastReceiver {
        b a;

        public c(b listener) {
            this.a = listener;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            int streamVolume;
            if (!f.V.equals(intent.getAction()) || intent.getIntExtra(f.W, -1) != 3 || this.a == null || (streamVolume = ((AudioManager) f.this.getApplicationContext().getSystemService("audio")).getStreamVolume(3)) < 0) {
                return;
            }
            this.a.a(streamVolume);
        }
    }

    public f(Context context) {
        super(context.getApplicationContext());
        this.w = -1;
        this.x = -1;
        this.z = 0;
        this.A = 0;
        this.C = true;
        this.E = -1;
        this.F = 0;
        this.G = -1;
        this.H = 0L;
        this.L = false;
        this.M = 0L;
        this.U = new AudioManager.OnAudioFocusChangeListener() { // from class: com.sigmob.sdk.videoplayer.f.1
            @Override // android.media.AudioManager.OnAudioFocusChangeListener
            public void onAudioFocusChange(int focusChange) {
                StringBuilder sb;
                String str;
                if (focusChange == -2) {
                    sb = new StringBuilder();
                    str = "AUDIOFOCUS_LOSS_TRANSIENT [";
                } else {
                    if (focusChange != -1) {
                        return;
                    }
                    f.this.E();
                    sb = new StringBuilder();
                    str = "AUDIOFOCUS_LOSS [";
                }
                SigmobLog.i(sb.append(str).append(hashCode()).append("]").toString());
            }
        };
        this.al = true;
        this.ar = false;
        a(context.getApplicationContext());
    }

    public f(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.w = -1;
        this.x = -1;
        this.z = 0;
        this.A = 0;
        this.C = true;
        this.E = -1;
        this.F = 0;
        this.G = -1;
        this.H = 0L;
        this.L = false;
        this.M = 0L;
        this.U = new AudioManager.OnAudioFocusChangeListener() { // from class: com.sigmob.sdk.videoplayer.f.1
            @Override // android.media.AudioManager.OnAudioFocusChangeListener
            public void onAudioFocusChange(int focusChange) {
                StringBuilder sb;
                String str;
                if (focusChange == -2) {
                    sb = new StringBuilder();
                    str = "AUDIOFOCUS_LOSS_TRANSIENT [";
                } else {
                    if (focusChange != -1) {
                        return;
                    }
                    f.this.E();
                    sb = new StringBuilder();
                    str = "AUDIOFOCUS_LOSS [";
                }
                SigmobLog.i(sb.append(str).append(hashCode()).append("]").toString());
            }
        };
        this.al = true;
        this.ar = false;
        a(context);
    }

    private void F() {
        try {
            i iVar = this.D;
            if (iVar != null) {
                iVar.f();
            }
            Class cls = this.B;
            this.D = cls == null ? new j(this) : (i) cls.getConstructor(f.class).newInstance(this);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void a(View view, int visibility) {
        if (view != null) {
            view.setVisibility(visibility);
        }
    }

    public void A() {
    }

    public void B() {
    }

    public void C() {
        int i2;
        f fVar = this.v;
        if (fVar == null || (i2 = fVar.w) == 0) {
            k();
            return;
        }
        if (i2 == 5) {
            com.sigmob.sdk.nativead.j jVar = this.ak;
            if (jVar != null) {
                jVar.onVideoResume();
            }
            this.v.f();
            this.v.D.a();
            return;
        }
        if (i2 == 3) {
            com.sigmob.sdk.nativead.j jVar2 = this.ak;
            if (jVar2 != null) {
                jVar2.onVideoStart();
            }
            this.v.D.a();
            this.v.f();
        }
    }

    public void D() {
        f fVar = this.v;
        if (fVar == null) {
            return;
        }
        int i2 = fVar.w;
        if (i2 == 6 || i2 == 0 || i2 == 1 || i2 == 7) {
            E();
        } else if (i2 != 5) {
            fVar.g();
            this.v.D.d();
        }
    }

    public void E() {
        SigmobLog.i("releaseAllVideos");
        f fVar = this.v;
        if (fVar != null) {
            fVar.j();
            this.v = null;
        }
    }

    public void a() {
        E();
        r();
        if (this.aq != null) {
            getContext().unregisterReceiver(this.aq);
            this.aq = null;
        }
    }

    public void a(float x) {
        int i2;
        if (this.v != null) {
            int i3 = this.w;
            if ((i3 != 4 && i3 != 5) || (i2 = this.x) == 1 || i2 == 2) {
                return;
            }
            t();
        }
    }

    public void a(float deltaY, int volumePercent) {
    }

    public void a(float deltaX, String seekTime, long seekTimePosition, String totalTime, long totalTimeDuration) {
    }

    public void a(int brightnessPercent) {
    }

    @Override // com.sigmob.sdk.videoplayer.h
    public void a(int what, int extra) {
        SigmobLog.e("onError " + what + " - " + extra + " [" + hashCode() + "] ");
        com.sigmob.sdk.nativead.j jVar = this.ak;
        if (jVar != null) {
            jVar.onVideoError(WindAdError.ERROR_SIGMOB_PLAY_VIDEO);
        }
        if (what == 38 || extra == -38 || what == -38 || extra == 38 || extra == -19) {
            return;
        }
        h();
        this.D.f();
    }

    public void a(int state, int urlMapIndex, int seekToInAdvance) {
        if (state == 0) {
            b();
            return;
        }
        if (state == 1) {
            c();
            return;
        }
        if (state == 2) {
            a(urlMapIndex, seekToInAdvance);
            return;
        }
        if (state == 4) {
            f();
            return;
        }
        if (state == 5) {
            g();
        } else if (state == 6) {
            i();
        } else {
            if (state != 7) {
                return;
            }
            h();
        }
    }

    public void a(int urlMapIndex, long seekToInAdvance) {
        this.w = 2;
        this.H = seekToInAdvance;
        this.y.b = urlMapIndex;
        this.D.a((Surface) null);
        this.D.f();
        this.D.c();
    }

    public void a(int progress, long position, long duration) {
        ProgressBar progressBar;
        if (!this.S) {
            int i2 = this.G;
            if (i2 != -1) {
                if (i2 > progress) {
                    return;
                } else {
                    this.G = -1;
                }
            } else if (progress != 0 && (progressBar = this.ai) != null) {
                progressBar.setProgress(progress);
            }
        }
        com.sigmob.sdk.nativead.j jVar = this.ak;
        if (jVar != null) {
            jVar.a(position, duration);
        }
    }

    public void a(Context context) {
        View.inflate(context, getLayoutId(), this);
        this.ae = (ViewGroup) findViewById(ResourceUtil.getId(getContext(), "sig_native_video_sound_rl"));
        this.ab = (ViewGroup) findViewById(ResourceUtil.getId(getContext(), "sig_native_video_start_rl"));
        this.ac = (ViewGroup) findViewById(ResourceUtil.getId(getContext(), "sig_native_video_fullscreen_rl"));
        this.ad = (ViewGroup) findViewById(ResourceUtil.getId(getContext(), "sig_native_video_replay_rl"));
        this.f796K = (ImageView) findViewById(ResourceUtil.getId(getContext(), "sig_native_video_sound_btn"));
        this.I = (ImageView) findViewById(ResourceUtil.getId(getContext(), "sig_native_video_start_btn"));
        this.J = (ImageView) findViewById(ResourceUtil.getId(getContext(), "sig_native_video_fullscreen_btn"));
        this.aa = (ViewGroup) findViewById(ResourceUtil.getId(getContext(), "sig_native_video_surface_container"));
        this.ah = (ViewGroup) findViewById(ResourceUtil.getId(getContext(), "sig_native_video_app_container"));
        this.ai = (ProgressBar) findViewById(ResourceUtil.getId(getContext(), "sig_native_video_bottom_progress"));
        this.af = (ViewGroup) findViewById(ResourceUtil.getId(getContext(), "sig_native_video_big_replay"));
        this.aj = (ImageView) findViewById(ResourceUtil.getId(getContext(), "sig_native_video_thumb"));
        this.an = (ImageView) findViewById(ResourceUtil.getId(getContext(), "sig_native_video_blurImageView"));
        this.ag = (ViewGroup) findViewById(ResourceUtil.getId(getContext(), "sig_native_video_back_rl"));
        this.as = findViewById(ResourceUtil.getId(getContext(), "sig_native_video_layout_top"));
        this.au = findViewById(ResourceUtil.getId(getContext(), "sig_native_video_layout_bottom"));
        this.ad.setOnClickListener(this);
        this.ae.setOnClickListener(this);
        this.ab.setOnClickListener(this);
        this.ac.setOnClickListener(this);
        this.af.setOnClickListener(this);
        this.O = getContext().getResources().getDisplayMetrics().widthPixels;
        this.P = getContext().getResources().getDisplayMetrics().heightPixels;
        this.aq = new c(new b() { // from class: com.sigmob.sdk.videoplayer.f.2
            @Override // com.sigmob.sdk.videoplayer.f.b
            public void a(int volume) {
                ImageView imageView;
                int drawableId;
                if (volume == 0 || f.this.al) {
                    imageView = f.this.f796K;
                    drawableId = ResourceUtil.getDrawableId(f.this.getContext(), "sig_image_video_mute");
                } else {
                    imageView = f.this.f796K;
                    drawableId = ResourceUtil.getDrawableId(f.this.getContext(), "sig_image_video_unmute");
                }
                imageView.setImageResource(drawableId);
            }
        });
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(V);
        IntentUtil.registerReceiver(context, this.aq, intentFilter);
        this.w = -1;
    }

    public void a(ViewGroup vg) {
        try {
            f fVar = (f) getClass().getConstructor(Context.class).newInstance(getContext());
            fVar.setId(getId());
            vg.addView(fVar);
            fVar.a(this.y.c(), 0, this.B);
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (InstantiationException e3) {
            e3.printStackTrace();
        } catch (NoSuchMethodException e4) {
            e4.printStackTrace();
        } catch (InvocationTargetException e5) {
            e5.printStackTrace();
        }
    }

    public void a(e button, boolean isShow) {
        ViewGroup viewGroup;
        int i2 = 0;
        switch (AnonymousClass3.a[button.ordinal()]) {
            case 1:
                viewGroup = this.ab;
                if (!isShow) {
                }
                a(viewGroup, i2);
            case 2:
                viewGroup = this.ad;
                if (!isShow) {
                }
                a(viewGroup, i2);
            case 3:
                viewGroup = this.ae;
                if (!isShow) {
                }
                a(viewGroup, i2);
            case 4:
                viewGroup = this.ac;
                if (!isShow) {
                }
                a(viewGroup, i2);
            case 5:
                viewGroup = this.af;
                if (!isShow) {
                }
                a(viewGroup, i2);
            case 6:
                viewGroup = this.ag;
                if (!isShow) {
                }
                a(viewGroup, i2);
            default:
                return;
        }
        i2 = 4;
        a(viewGroup, i2);
    }

    public void a(g videoPlayerDataSource, int screen) {
        a(videoPlayerDataSource, screen, (Class) null);
    }

    public void a(g videoPlayerDataSource, int screen, Class mediaInterfaceClass) {
        if (System.currentTimeMillis() - this.M < 200) {
            return;
        }
        this.y = videoPlayerDataSource;
        this.x = screen;
        b();
        this.B = mediaInterfaceClass;
    }

    public void a(g videoPlayerDataSource, long seekToInAdvance) {
        this.w = 2;
        this.H = seekToInAdvance;
        this.y = videoPlayerDataSource;
        this.D.a((Surface) null);
        this.D.f();
        this.D.c();
    }

    public void a(String url, String title) {
        a(new g(url, title), 0);
    }

    public void a(String url, String title, int screen) {
        a(new g(url, title), screen);
    }

    public void a(String url, String title, int screen, Class mediaInterfaceClass) {
        a(new g(url, title), screen, mediaInterfaceClass);
    }

    public void a(String url, String title, long seekToInAdvance) {
        a(new g(url, title), seekToInAdvance);
    }

    public void a(boolean show) {
        ViewGroup viewGroup;
        int i2;
        if (show) {
            viewGroup = this.ac;
            i2 = 0;
        } else {
            viewGroup = this.ac;
            i2 = 4;
        }
        a(viewGroup, i2);
    }

    public void b() {
        SigmobLog.d("onStateNormal stat" + this.w + " [" + hashCode() + "] ");
        this.w = 0;
        a(this.aj, 0);
        a(this.ab, 0);
        r();
        i iVar = this.D;
        if (iVar != null) {
            iVar.f();
        }
    }

    @Override // com.sigmob.sdk.videoplayer.h
    public void b(int what, int extra) {
        String str;
        SigmobLog.d("onInfo what - " + what + " extra - " + extra);
        if (what == 3) {
            int i2 = this.w;
            if (i2 == 3 || i2 == 2) {
                f();
                return;
            }
            return;
        }
        if (what == 701) {
            if (this.w == 4) {
                this.at = true;
                this.D.d();
                g();
            }
            str = "MEDIA_INFO_BUFFERING_START";
        } else {
            if (what != 702) {
                return;
            }
            if (this.at) {
                this.at = false;
                this.D.a();
                f();
            }
            str = "MEDIA_INFO_BUFFERING_END";
        }
        SigmobLog.d(str);
    }

    public void b(boolean enable) {
        this.ar = enable;
    }

    public void c() {
        SigmobLog.d("onStatePreparing  [" + hashCode() + "] ");
        this.w = 1;
        s();
    }

    @Override // com.sigmob.sdk.videoplayer.h
    public void c(int width, int height) {
        this.ao = height;
        this.ap = width;
        l lVar = this.T;
        if (lVar != null) {
            int i2 = this.F;
            if (i2 != 0) {
                lVar.setRotation(i2);
            }
            this.T.a(width, height);
        }
    }

    public void d() {
        this.L = true;
        k();
    }

    public void e() {
        if (this.w == 3) {
            this.D.a();
        } else {
            this.L = false;
            k();
        }
    }

    public void f() {
        SigmobLog.d("onStatePlaying  [" + hashCode() + "] ");
        a(this.aj, 4);
        a(this.ab, 4);
        if (this.w == 3) {
            long j2 = this.H;
            if (j2 != 0) {
                this.D.a(j2);
                this.H = 0L;
            }
        }
        this.w = 4;
        n();
    }

    public void g() {
        SigmobLog.i("onStatePause  [" + hashCode() + "] ");
        this.w = 5;
        a(this.ab, 0);
        com.sigmob.sdk.nativead.j jVar = this.ak;
        if (jVar != null) {
            jVar.onVideoPause();
        }
        r();
    }

    public ViewGroup getAppContainer() {
        return this.ah;
    }

    public Context getApplicationContext() {
        Context applicationContext;
        Context context = getContext();
        return (context == null || (applicationContext = context.getApplicationContext()) == null) ? context : applicationContext;
    }

    public ImageView getBlurImageView() {
        return this.an;
    }

    public View getBottomLayoutView() {
        return this.au;
    }

    public long getCurrentPositionWhenPlaying() {
        int i2 = this.w;
        if (i2 != 4 && i2 != 5) {
            return 0L;
        }
        try {
            return this.D.g();
        } catch (IllegalStateException e2) {
            e2.printStackTrace();
            return 0L;
        }
    }

    public long getDuration() {
        try {
            i iVar = this.D;
            if (iVar != null) {
                return iVar.j();
            }
            return 0L;
        } catch (Throwable th) {
            th.printStackTrace();
            return 0L;
        }
    }

    public int getLayoutId() {
        return ResourceUtil.getLayoutId(getContext(), "sig_video_player_layout");
    }

    public ViewGroup getSigAdView() {
        ViewGroup viewGroup = (ViewGroup) getParent();
        while (!(viewGroup instanceof com.sigmob.sdk.nativead.k) && (viewGroup = (ViewGroup) getParent()) != null) {
        }
        return viewGroup;
    }

    public Bitmap getTextureBitmap() {
        l lVar = this.T;
        if (lVar != null) {
            return lVar.getBitmap();
        }
        return null;
    }

    public ImageView getThumbView() {
        return this.aj;
    }

    public View getTopLayoutView() {
        return this.as;
    }

    public int getVideoHeight() {
        return this.ao;
    }

    @Override // com.sigmob.sdk.videoplayer.h
    public g getVideoPlayerDataSource() {
        return this.y;
    }

    public int getVideoSurferViewHeight() {
        l lVar = this.T;
        if (lVar != null) {
            return lVar.getHeight();
        }
        return 0;
    }

    public int getVideoWidth() {
        return this.ap;
    }

    public void h() {
        SigmobLog.d("onStateError  [" + hashCode() + "] ");
        this.w = 7;
        r();
        a(this.x == 1 ? this.ab : this.ad, 0);
    }

    public void i() {
        SigmobLog.i("onStateAutoComplete  [" + hashCode() + "] ");
        this.w = 6;
        r();
        ProgressBar progressBar = this.ai;
        if (progressBar != null) {
            progressBar.setProgress(100);
        }
    }

    public void j() {
        SigmobLog.d("reset  [" + hashCode() + "] ");
        r();
        s();
        B();
        z();
        A();
        b();
        this.aa.removeAllViews();
        Window windowC = com.sigmob.sdk.videoplayer.c.c(getContext());
        if (windowC != null) {
            windowC.clearFlags(128);
        }
        i iVar = this.D;
        if (iVar != null) {
            iVar.f();
        }
    }

    public void k() {
        SigmobLog.d("startVideo [" + hashCode() + "] ");
        setCurrentVideoAdView(this);
        try {
            F();
            a(this.ad, 4);
            a(this.af, 4);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        Window windowC = com.sigmob.sdk.videoplayer.c.c(getContext());
        if (windowC != null) {
            windowC.setFlags(16777216, 16777216);
            windowC.addFlags(128);
        }
        l();
        c();
    }

    public void l() {
        l lVar = this.T;
        if (lVar != null) {
            this.aa.removeView(lVar);
        }
        l lVar2 = new l(getContext().getApplicationContext());
        this.T = lVar2;
        lVar2.setSurfaceTextureListener(this.D);
        this.aa.addView(this.T, new FrameLayout.LayoutParams(-1, -1, 17));
    }

    public void m() {
        Window windowC = com.sigmob.sdk.videoplayer.c.c(getContext());
        if (windowC != null) {
            ((ViewGroup) windowC.findViewById(R.id.content)).removeView(this);
        }
    }

    public void n() {
        r();
        this.N = new Timer();
        a aVar = new a();
        this.R = aVar;
        this.N.schedule(aVar, 0L, 300L);
        com.sigmob.sdk.videoplayer.c.f(com.sigmob.sdk.b.e());
    }

    @Override // com.sigmob.sdk.videoplayer.h
    public void o() {
        SigmobLog.d("onPrepared  [" + hashCode() + "] ");
        this.w = 3;
        setSoundChange(this.al);
        com.sigmob.sdk.nativead.j jVar = this.ak;
        if (jVar != null) {
            jVar.onVideoLoad();
        }
        if (!this.L) {
            com.sigmob.sdk.nativead.j jVar2 = this.ak;
            if (jVar2 != null) {
                jVar2.onVideoStart();
            }
            SigmobLog.d("mediaInterface start");
            f();
            this.D.a();
            this.L = false;
        } else if (this.ar) {
            this.aj.setImageBitmap(this.T.getBitmap());
        }
        if (this.y.a().toString().toLowerCase().contains("mp3") || this.y.a().toString().toLowerCase().contains("wma") || this.y.a().toString().toLowerCase().contains("aac") || this.y.a().toString().toLowerCase().contains("m4a") || this.y.a().toString().toLowerCase().contains("wav")) {
            f();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        onTouch(v, null);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int i2 = this.x;
        if (i2 == 1 || i2 == 2) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            return;
        }
        if (this.z == 0 || this.A == 0) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            return;
        }
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        int i3 = (int) ((size * this.A) / this.z);
        setMeasuredDimension(size, i3);
        getChildAt(0).measure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(i3, 1073741824));
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        if (fromUser) {
            getDuration();
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
        r();
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
        SigmobLog.d("bottomProgress onStopTrackingTouch [" + hashCode() + "] ");
        n();
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            parent.requestDisallowInterceptTouchEvent(false);
        }
        int i2 = this.w;
        if (i2 == 4 || i2 == 5) {
            long progress = (seekBar.getProgress() * getDuration()) / 100;
            this.G = seekBar.getProgress();
            this.D.a(progress);
            SigmobLog.d("seekTo " + progress + " [" + hashCode() + "] ");
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        if (event != null && event.getAction() != 1) {
            return false;
        }
        if (v == this.ac) {
            int i2 = this.x;
            if (i2 == 0) {
                t();
                return false;
            }
            if (i2 != 1) {
                return false;
            }
            u();
            return false;
        }
        if (v == this.ae) {
            setSoundChange(!this.al);
            return false;
        }
        if (v == this.ad || v == this.af) {
            com.sigmob.sdk.nativead.j jVar = this.ak;
            if (jVar != null) {
                jVar.a();
            }
            k();
            return false;
        }
        if (v != this.ab) {
            return false;
        }
        int i3 = this.w;
        if (i3 != 0) {
            if (i3 == 4) {
                SigmobLog.d("pauseVideo [" + hashCode() + "] ");
                this.D.d();
                g();
            } else if (i3 == 5) {
                com.sigmob.sdk.nativead.j jVar2 = this.ak;
                if (jVar2 != null) {
                    jVar2.onVideoResume();
                }
                this.D.a();
                f();
            } else if (i3 != 6) {
                if (i3 == 3) {
                    this.D.a();
                    f();
                    com.sigmob.sdk.nativead.j jVar3 = this.ak;
                    if (jVar3 != null) {
                        jVar3.onVideoStart();
                    }
                }
            }
            return true;
        }
        if (!t && !this.y.a().toString().startsWith(n.z) && !this.y.a().toString().startsWith("/") && !com.sigmob.sdk.videoplayer.c.a(getContext())) {
            y();
            return true;
        }
        k();
        return true;
    }

    @Override // com.sigmob.sdk.videoplayer.h
    public void p() {
        Runtime.getRuntime().gc();
        com.sigmob.sdk.nativead.j jVar = this.ak;
        if (jVar != null) {
            jVar.onVideoCompleted();
        }
        SigmobLog.d("onAutoCompletion  [" + hashCode() + "] ");
        r();
        B();
        z();
        A();
        i();
        Window windowC = com.sigmob.sdk.videoplayer.c.c(getContext());
        if (windowC != null) {
            windowC.clearFlags(128);
        }
        s();
        this.v = null;
    }

    @Override // com.sigmob.sdk.videoplayer.h
    public void q() {
    }

    public void r() {
        Timer timer = this.N;
        if (timer != null) {
            timer.cancel();
            this.N = null;
        }
        a aVar = this.R;
        if (aVar != null) {
            aVar.cancel();
            this.R = null;
        }
        com.sigmob.sdk.videoplayer.c.g(com.sigmob.sdk.b.e());
    }

    public void s() {
        ProgressBar progressBar = this.ai;
        if (progressBar != null) {
            progressBar.setProgress(0);
        }
    }

    public void setBackClickListener(View.OnClickListener onClickListener) {
        ViewGroup viewGroup = this.ag;
        if (viewGroup != null) {
            viewGroup.setOnClickListener(onClickListener);
        }
    }

    @Override // com.sigmob.sdk.videoplayer.h
    public void setBufferProgress(int bufferProgress) {
    }

    public void setCurrentVideoAdView(f videoAdView) {
        this.v = videoAdView;
    }

    public void setHolderImageResource(int resId) {
    }

    public void setMediaInterface(Class mediaInterfaceClass) {
        j();
        this.B = mediaInterfaceClass;
    }

    @Override // android.view.View
    public void setRotation(float rotation) {
        this.T.setRotation(rotation);
    }

    public void setScreen(int screen) {
        if (screen == 0) {
            v();
        } else if (screen == 1) {
            w();
        } else {
            if (screen != 2) {
                return;
            }
            x();
        }
    }

    public void setSoundChange(boolean isMute) {
        ImageView imageView;
        Context context;
        String str;
        this.al = isMute;
        if (isMute) {
            com.sigmob.sdk.videoplayer.c.g(com.sigmob.sdk.b.e());
            i iVar = this.D;
            if (iVar != null) {
                iVar.a(0.0f);
            }
            imageView = this.f796K;
            context = getContext();
            str = "sig_image_video_mute";
        } else {
            com.sigmob.sdk.videoplayer.c.f(com.sigmob.sdk.b.e());
            i iVar2 = this.D;
            if (iVar2 != null) {
                iVar2.a(1.0f);
            }
            imageView = this.f796K;
            context = getContext();
            str = "sig_image_video_unmute";
        }
        imageView.setImageResource(ResourceUtil.getDrawableId(context, str));
    }

    public void setState(int state) {
        a(state, 0, 0);
    }

    @Override // com.sigmob.sdk.videoplayer.h
    public void setSurfaceTexture(SurfaceTexture saved_surface) {
        l lVar = this.T;
        if (lVar != null) {
            lVar.setSurfaceTexture(saved_surface);
        }
    }

    public void setTextureViewRotation(int rotation) {
        l lVar;
        f fVar = this.v;
        if (fVar == null || (lVar = fVar.T) == null) {
            return;
        }
        lVar.setRotation(rotation);
    }

    public void setUp(String url) {
        a(new g(url, (String) null), 0);
    }

    public void setVideoAdStatusListener(com.sigmob.sdk.nativead.j adVideoStatusListener) {
        this.ak = adVideoStatusListener;
    }

    public void setVideoAdViewListener(com.sigmob.sdk.videoplayer.b videoAdViewListener) {
        this.am = videoAdViewListener;
    }

    public void setVideoImageDisplayType(int type) {
        l lVar;
        u = type;
        f fVar = this.v;
        if (fVar == null || (lVar = fVar.T) == null) {
            return;
        }
        lVar.requestLayout();
    }

    public void t() {
        com.sigmob.sdk.videoplayer.b bVar = this.am;
        if (bVar != null) {
            bVar.g();
        }
        w();
        this.J.setImageResource(ResourceUtil.getDrawableId(getContext(), "sig_image_video_small"));
    }

    public void u() {
        this.M = System.currentTimeMillis();
        com.sigmob.sdk.videoplayer.b bVar = this.am;
        if (bVar != null) {
            bVar.f();
        }
        v();
        this.J.setImageResource(ResourceUtil.getDrawableId(getContext(), "sig_image_video_fullscreen"));
    }

    public void v() {
        this.x = 0;
    }

    public void w() {
        this.x = 1;
    }

    public void x() {
        this.x = 2;
    }

    public void y() {
    }

    public void z() {
    }
}
