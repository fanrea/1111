package com.alliance.ssp.ad.video;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.alliance.ssp.ad.R;
import com.alliance.ssp.ad.o0.l;
import com.alliance.ssp.ad.video.f;
import java.io.IOException;
import java.util.HashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class VideoController {
    public final Object A;
    public float B;
    public boolean C;
    public boolean D;
    public boolean E;
    public Handler F;
    public ImageView G;
    public Handler H;
    public VIDEO_STATE a;
    public VIDEO_STATE b;
    public Context c;
    public String d;
    public boolean e;
    public boolean f;
    public SurfaceHolder.Callback g;
    public com.alliance.ssp.ad.video.f h;
    public f.a i;
    public Handler j;
    public Handler k;
    public HandlerThread l;
    public boolean m;
    public boolean n;
    public boolean o;
    public boolean p;
    public boolean q;
    public com.alliance.ssp.ad.video.e r;
    public View s;
    public FrameLayout t;
    public SurfaceView u;
    public SurfaceHolder v;
    public MediaPlayer w;
    public SeekBar x;
    public int[] y;
    public int[] z;

    public enum VIDEO_STATE {
        IDLE,
        INITALIZED,
        PREPARING,
        PREPARED,
        PLAYING,
        COMPLETED,
        NONE,
        ERROR,
        STOPED,
        PAUSED
    }

    public class a implements SurfaceHolder.Callback {
        public a() {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            MediaPlayer mediaPlayer = VideoController.this.w;
            if (mediaPlayer != null) {
                mediaPlayer.setDisplay(surfaceHolder);
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            MediaPlayer mediaPlayer = VideoController.this.w;
            if (mediaPlayer != null) {
                mediaPlayer.setDisplay(null);
            }
        }
    }

    public class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            try {
                VideoController videoController = VideoController.this;
                int[] iArr = videoController.y;
                int i = iArr[0];
                int i2 = iArr[1];
                int[] iArr2 = videoController.z;
                float f = i / i2;
                float f2 = iArr2[0];
                float f3 = iArr2[1];
                float f4 = f2 / f3;
                ViewGroup.LayoutParams layoutParams = videoController.u.getLayoutParams();
                VideoController videoController2 = VideoController.this;
                if (videoController2.D) {
                    if (f >= f4) {
                        float f5 = f3 * f;
                        if (f5 >= 0.0f) {
                            layoutParams.width = (int) f5;
                        }
                    } else {
                        float f6 = f2 / f;
                        if (f6 >= 0.0f) {
                            layoutParams.height = (int) f6;
                        }
                    }
                } else if (f >= f4) {
                    float f7 = f2 / f;
                    if (f7 >= 0.0f) {
                        layoutParams.height = (int) f7;
                    }
                } else {
                    float f8 = f3 * f;
                    if (f8 >= 0.0f) {
                        layoutParams.width = (int) f8;
                    }
                }
                videoController2.u.setLayoutParams(layoutParams);
                VideoController.this.o = true;
            } catch (Exception e) {
                e.getMessage();
                int i3 = l.a;
            }
        }
    }

    public class c extends Handler {
        public c(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            ImageView imageView;
            if (Looper.myLooper() == null) {
                Looper.prepare();
            }
            super.handleMessage(message);
            int i = l.a;
            VideoController.this.u.setBackgroundColor(Color.parseColor("#00000000"));
            VideoController videoController = VideoController.this;
            if (videoController.E && (imageView = videoController.G) != null) {
                videoController.t.removeView(imageView);
            }
            VideoController.this.n = false;
        }
    }

    public class d extends Handler {
        public d(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Bitmap bitmapA;
            if (Looper.myLooper() == null) {
                Looper.prepare();
            }
            super.handleMessage(message);
            VideoController videoController = VideoController.this;
            if (videoController.w == null || (bitmapA = videoController.a(r0.getDuration())) == null) {
                return;
            }
            VideoController videoController2 = VideoController.this;
            if (videoController2.E) {
                videoController2.G = new ImageView(VideoController.this.c);
                VideoController.this.G.setScaleType(ImageView.ScaleType.CENTER_CROP);
                VideoController.this.G.setImageBitmap(bitmapA);
                VideoController videoController3 = VideoController.this;
                videoController3.t.addView(videoController3.G);
            } else {
                videoController2.u.setBackground(new BitmapDrawable(bitmapA));
            }
            int i = l.a;
            VideoController.this.n = true;
        }
    }

    public interface e {
    }

    public interface f {
        void a();
    }

    public interface g {
    }

    public interface h {
        void a(boolean z);
    }

    public VideoController(Context context, String str, View view, boolean z, boolean z2, boolean z3, f.a aVar) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        VIDEO_STATE video_state = VIDEO_STATE.NONE;
        this.a = video_state;
        this.b = video_state;
        this.e = true;
        this.f = true;
        this.m = false;
        this.n = false;
        this.o = false;
        this.p = false;
        this.q = false;
        this.s = null;
        this.y = new int[2];
        this.z = new int[2];
        this.A = new Object();
        this.B = 0.0f;
        this.C = false;
        this.D = false;
        this.E = false;
        this.F = new c(Looper.getMainLooper());
        this.H = new d(Looper.getMainLooper());
        this.c = context;
        this.d = str;
        this.s = view;
        this.p = z;
        this.q = z2;
        this.e = z3;
        this.i = aVar;
        a(context);
        d();
    }

    public final void d() throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        String str;
        int i = l.a;
        if (this.v == null || (str = this.d) == null || str.isEmpty() || this.m) {
            return;
        }
        try {
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.w = mediaPlayer;
            this.a = VIDEO_STATE.IDLE;
            mediaPlayer.setDataSource(this.d);
            this.a = VIDEO_STATE.INITALIZED;
            if (this.g == null) {
                this.g = new a();
            }
            this.v.addCallback(this.g);
            if (this.i != null) {
                if (this.l == null) {
                    this.l = new HandlerThread("videoControllerThread");
                }
                if (!this.C) {
                    this.l.start();
                    this.C = true;
                }
                com.alliance.ssp.ad.video.a aVar = new com.alliance.ssp.ad.video.a(this, this.l.getLooper());
                this.j = aVar;
                com.alliance.ssp.ad.video.f fVar = new com.alliance.ssp.ad.video.f(this.i, this, aVar);
                this.h = fVar;
                fVar.b();
            }
            this.w.prepareAsync();
            this.a = VIDEO_STATE.PREPARING;
            if (this.q) {
                this.b = VIDEO_STATE.PLAYING;
            }
            if (this.r == null) {
                this.r = new com.alliance.ssp.ad.video.e(this.c, this.w);
            }
        } catch (IOException e2) {
            this.a.name();
            e2.getMessage();
            int i2 = l.a;
            this.a = VIDEO_STATE.ERROR;
        }
    }

    public final boolean e() {
        VIDEO_STATE video_state;
        return (this.w == null || (video_state = this.a) == VIDEO_STATE.IDLE || video_state == VIDEO_STATE.INITALIZED || video_state == VIDEO_STATE.PREPARING || video_state == VIDEO_STATE.NONE || video_state == VIDEO_STATE.ERROR || video_state == VIDEO_STATE.STOPED) ? false : true;
    }

    public boolean f() throws IllegalStateException {
        VIDEO_STATE video_state;
        VIDEO_STATE video_state2;
        MediaPlayer mediaPlayer;
        if (e() && (video_state = this.a) != (video_state2 = VIDEO_STATE.PAUSED) && video_state != VIDEO_STATE.COMPLETED && video_state != VIDEO_STATE.PREPARED && (mediaPlayer = this.w) != null) {
            int i = l.a;
            try {
                mediaPlayer.pause();
                this.a = video_state2;
                a(65540);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public void g() {
        int i = l.a;
        try {
            MediaPlayer mediaPlayer = this.w;
            if (mediaPlayer != null) {
                mediaPlayer.reset();
                this.w.release();
                this.w = null;
            }
            if (this.F != null) {
                this.F = null;
            }
            com.alliance.ssp.ad.video.f fVar = this.h;
            if (fVar != null) {
                fVar.a();
                this.h = null;
            }
            if (this.k != null) {
                this.k = null;
            }
            if (this.j != null) {
                this.j = null;
            }
            if (this.l != null) {
                this.l = null;
                this.C = false;
            }
            SurfaceHolder surfaceHolder = this.v;
            if (surfaceHolder != null) {
                surfaceHolder.removeCallback(this.g);
                this.g = null;
                this.v = null;
            }
            VIDEO_STATE video_state = VIDEO_STATE.NONE;
            this.a = video_state;
            this.b = video_state;
            this.m = true;
        } catch (Exception unused) {
        }
    }

    public boolean h() {
        if (e() && this.w != null) {
            int i = l.a;
            if (this.n) {
                b(true);
            }
            try {
                this.w.seekTo(0);
                this.w.start();
                this.a = VIDEO_STATE.PLAYING;
                a(65544);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public boolean i() throws IllegalStateException {
        VIDEO_STATE video_state;
        VIDEO_STATE video_state2;
        VIDEO_STATE video_state3;
        if (this.w == null) {
            return false;
        }
        if (!this.o) {
            View view = this.s;
            if (view != null) {
                this.z[0] = view.getWidth();
                this.z[1] = this.s.getHeight();
            }
            int[] iArr = this.y;
            int i = iArr[0];
            int i2 = iArr[1];
            int[] iArr2 = this.z;
            int i3 = iArr2[0];
            int i4 = iArr2[1];
            int i5 = l.a;
            if (a(iArr2) && a(this.y)) {
                a();
            }
        }
        if (!e() || (video_state = this.a) == (video_state2 = VIDEO_STATE.PLAYING) || video_state == (video_state3 = VIDEO_STATE.COMPLETED) || this.w == null) {
            this.b = VIDEO_STATE.PLAYING;
            return false;
        }
        int i6 = l.a;
        if (this.n && video_state != video_state3) {
            b(true);
        }
        try {
            this.w.start();
            this.a = video_state2;
            a(65539);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public void j() throws IllegalStateException {
        MediaPlayer mediaPlayer;
        if (e() && (mediaPlayer = this.w) != null) {
            int i = l.a;
            try {
                mediaPlayer.stop();
                this.a = VIDEO_STATE.STOPED;
                a(65541);
            } catch (Exception unused) {
                return;
            }
        }
        g();
    }

    public final void a(Context context) {
        int i = l.a;
        this.t = new FrameLayout(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        SurfaceView surfaceView = new SurfaceView(context);
        this.u = surfaceView;
        this.t.addView(surfaceView, layoutParams);
        this.v = this.u.getHolder();
        View view = this.s;
        if (view == null || Build.VERSION.SDK_INT < 18) {
            return;
        }
        view.getViewTreeObserver().addOnWindowFocusChangeListener(new ViewTreeObserver.OnWindowFocusChangeListener() { // from class: com.alliance.ssp.ad.video.VideoController$$ExternalSyntheticLambda0
            @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
            public final void onWindowFocusChanged(boolean z) {
                this.f$0.a(z);
            }
        });
    }

    public MediaPlayer b() {
        MediaPlayer mediaPlayer = this.w;
        if (mediaPlayer != null) {
            return mediaPlayer;
        }
        int i = l.a;
        return null;
    }

    public void c() {
        com.alliance.ssp.ad.video.e eVar = this.r;
        if (eVar != null) {
            if (this.e) {
                eVar.a(0);
            } else {
                eVar.a(1);
            }
        }
    }

    public boolean b(float f2) {
        MediaPlayer mediaPlayer = this.w;
        if (mediaPlayer == null) {
            return false;
        }
        try {
            mediaPlayer.setVolume(f2, f2);
            this.B = f2;
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public void b(boolean z) {
        ImageView imageView;
        Handler handler = this.F;
        if (handler != null && z) {
            handler.sendEmptyMessageDelayed(0, 20L);
            return;
        }
        this.u.setBackgroundColor(Color.parseColor("#00000000"));
        if (this.E && (imageView = this.G) != null) {
            this.t.removeView(imageView);
        }
        this.n = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(boolean z) {
        if (z) {
            this.z[0] = this.s.getWidth();
            this.z[1] = this.s.getHeight();
            int[] iArr = this.y;
            int i = iArr[0];
            int i2 = iArr[1];
            int[] iArr2 = this.z;
            int i3 = iArr2[0];
            int i4 = iArr2[1];
            int i5 = l.a;
            if (!this.o && a(iArr2) && a(this.y)) {
                a();
            }
        }
    }

    public View a(float f2) {
        com.alliance.ssp.ad.video.e eVar = this.r;
        if (eVar.a != null && eVar.b != null) {
            FrameLayout frameLayout = new FrameLayout(eVar.a);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            frameLayout.setLayoutParams(layoutParams);
            eVar.a(frameLayout, "#BB7C7C7C", 7.0f, 7.0f, 7.0f, 7.0f);
            eVar.e = new TextView(eVar.a);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 17;
            eVar.e.setText("00:00");
            eVar.e.setTextSize(f2);
            eVar.e.setTextColor(Color.parseColor("#FFFFFFFF"));
            eVar.e.setGravity(17);
            frameLayout.addView(eVar.e, layoutParams2);
            com.alliance.ssp.ad.p0.a aVar = new com.alliance.ssp.ad.p0.a(eVar, Looper.getMainLooper());
            eVar.d = aVar;
            aVar.sendEmptyMessage(0);
            return frameLayout;
        }
        int i = l.a;
        return null;
    }

    public View a(f fVar) {
        com.alliance.ssp.ad.video.e eVar = this.r;
        com.alliance.ssp.ad.video.c cVar = new com.alliance.ssp.ad.video.c(this, fVar);
        if (eVar.a == null) {
            int i = l.a;
            return null;
        }
        FrameLayout frameLayout = new FrameLayout(eVar.a);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(eVar.a(47.0f), eVar.a(18.0f));
        layoutParams.gravity = 17;
        frameLayout.setLayoutParams(layoutParams);
        LinearLayout linearLayout = new LinearLayout(eVar.a);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -1);
        layoutParams2.gravity = 17;
        linearLayout.setGravity(16);
        linearLayout.setOrientation(0);
        linearLayout.setLayoutParams(layoutParams2);
        eVar.a(linearLayout, "#80000000", 4.0f, 4.0f, 4.0f, 4.0f);
        ImageView imageView = new ImageView(eVar.a);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, eVar.a(12.0f), 14.0f);
        layoutParams3.gravity = 17;
        imageView.setImageBitmap(BitmapFactory.decodeResource(eVar.a.getResources(), R.drawable.nmadssp_icon_replay));
        TextView textView = new TextView(eVar.a);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(0, -2, 22.0f);
        textView.setText("重播");
        textView.setTextSize(10.0f);
        textView.setTextColor(Color.parseColor("#FFFFFFFF"));
        linearLayout.addView(imageView, layoutParams3);
        linearLayout.addView(textView, layoutParams4);
        frameLayout.addView(linearLayout);
        frameLayout.setOnClickListener(new com.alliance.ssp.ad.video.d(eVar, cVar));
        return frameLayout;
    }

    public final boolean a(int[] iArr) {
        return (iArr[0] == 0 || iArr[1] == 0) ? false : true;
    }

    public final void a() {
        int i = l.a;
        new b(Looper.getMainLooper()).sendEmptyMessage(0);
    }

    public void a(int i, int i2) {
        int[] iArr = this.z;
        iArr[0] = i;
        iArr[1] = i2;
        int[] iArr2 = this.y;
        int i3 = iArr2[0];
        int i4 = iArr2[1];
        int i5 = l.a;
        if (a(iArr) && a(this.y)) {
            a();
        }
    }

    public Bitmap a(long j) throws IOException {
        Bitmap frameAtTime;
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            mediaMetadataRetriever.setDataSource(this.d, new HashMap());
            if (Build.VERSION.SDK_INT >= 27) {
                frameAtTime = mediaMetadataRetriever.getFrameAtTime(j * 1000, 2);
            } else {
                frameAtTime = mediaMetadataRetriever.getFrameAtTime(j * 1000);
            }
            mediaMetadataRetriever.release();
            return frameAtTime;
        } catch (Exception unused) {
            mediaMetadataRetriever.release();
            return null;
        } catch (Throwable th) {
            mediaMetadataRetriever.release();
            throw th;
        }
    }

    public final void a(int i) {
        Handler handler = this.k;
        if (handler != null) {
            Message messageObtainMessage = handler.obtainMessage();
            messageObtainMessage.what = i;
            this.k.sendMessage(messageObtainMessage);
        }
    }
}
