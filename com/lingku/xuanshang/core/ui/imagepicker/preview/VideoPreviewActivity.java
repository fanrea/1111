package com.lingku.xuanshang.core.ui.imagepicker.preview;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.baidu.mobads.container.util.animation.j;
import com.lingku.xuanshang.core.ui.base.BaseActivity;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import lkxssdk.e.i;
import lkxssdk.h0.c;
import lkxssdk.l0.e;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class VideoPreviewActivity extends BaseActivity implements Handler.Callback, View.OnClickListener, SurfaceHolder.Callback, SeekBar.OnSeekBarChangeListener {
    public long A;
    public int B;
    public boolean C;
    public int D;
    public int E;
    public AudioManager F;
    public boolean G;
    public int H;
    public int I = 1;
    public TextView J;

    /* renamed from: K, reason: collision with root package name */
    public TextView f772K;
    public boolean L;
    public LinearLayout d;
    public LinearLayout e;
    public LinearLayout f;
    public ProgressBar g;
    public ProgressBar h;
    public LinearLayout i;
    public ImageView j;
    public ImageView k;
    public SeekBar l;
    public TextView m;
    public TextView n;
    public SurfaceView o;
    public SurfaceHolder p;
    public ArrayList<String> q;
    public int r;
    public MediaPlayer s;
    public int t;
    public String u;
    public Handler v;
    public b w;
    public GestureDetector x;
    public float y;
    public float z;

    public class a implements GestureDetector.OnGestureListener {
        public a() {
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            c.b("tag", "MyGestureListener onDown");
            VideoPreviewActivity.this.C = true;
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            int progress;
            int progress2;
            VideoPreviewActivity videoPreviewActivity;
            float x = motionEvent.getX();
            if (VideoPreviewActivity.this.C) {
                if (Math.abs(f) >= Math.abs(f2)) {
                    VideoPreviewActivity videoPreviewActivity2 = VideoPreviewActivity.this;
                    videoPreviewActivity2.B = 3;
                    videoPreviewActivity2.i.setVisibility(0);
                    VideoPreviewActivity.this.k.setVisibility(0);
                    VideoPreviewActivity.this.v.removeMessages(1);
                    VideoPreviewActivity.this.G = true;
                } else {
                    if (x < lkxssdk.b.a.a / 2.0f) {
                        VideoPreviewActivity videoPreviewActivity3 = VideoPreviewActivity.this;
                        videoPreviewActivity3.B = 1;
                        videoPreviewActivity3.e.setVisibility(0);
                        VideoPreviewActivity.this.i.setVisibility(4);
                        videoPreviewActivity = VideoPreviewActivity.this;
                    } else {
                        VideoPreviewActivity videoPreviewActivity4 = VideoPreviewActivity.this;
                        videoPreviewActivity4.B = 2;
                        videoPreviewActivity4.f.setVisibility(0);
                        VideoPreviewActivity.this.i.setVisibility(4);
                        videoPreviewActivity = VideoPreviewActivity.this;
                    }
                    videoPreviewActivity.k.setVisibility(4);
                }
            }
            int i = VideoPreviewActivity.this.B;
            if (i == 3) {
                if (Math.abs(f) > 0.0f) {
                    float f3 = f * 50.0f;
                    int progress3 = VideoPreviewActivity.this.l.getProgress();
                    c.b("tag", "playSeekBar pre==" + VideoPreviewActivity.this.l.getProgress() + ",distanceX==" + f3);
                    if ((progress3 != VideoPreviewActivity.this.l.getMax() || f3 >= 0.0f) && (progress3 != 0 || f3 <= 0.0f)) {
                        int max = (int) (progress3 - f3);
                        if (max > VideoPreviewActivity.this.l.getMax()) {
                            max = VideoPreviewActivity.this.l.getMax();
                        }
                        if (max < 0) {
                            max = 0;
                        }
                        VideoPreviewActivity.this.m.setText(lkxssdk.a0.b.a(max));
                        VideoPreviewActivity.this.l.setProgress(max);
                        c.b("tag", "playSeekBar now==" + VideoPreviewActivity.this.l.getProgress());
                    }
                }
            } else if (i == 1) {
                if (Math.abs(f2) > 0.0f && (((progress2 = VideoPreviewActivity.this.g.getProgress()) != VideoPreviewActivity.this.g.getMax() || f2 <= 0.0f) && (progress2 != 0 || f2 >= 0.0f))) {
                    int max2 = (int) (progress2 + f2);
                    if (max2 > VideoPreviewActivity.this.g.getMax()) {
                        max2 = VideoPreviewActivity.this.g.getMax();
                    }
                    if (max2 < 0) {
                        max2 = 0;
                    }
                    VideoPreviewActivity.this.g.setProgress(max2);
                    VideoPreviewActivity videoPreviewActivity5 = VideoPreviewActivity.this;
                    VideoPreviewActivity.this.F.setStreamVolume(3, (max2 * videoPreviewActivity5.D) / videoPreviewActivity5.g.getMax(), 0);
                }
            } else if (i == 2 && Math.abs(f2) > 0.0f && (((progress = VideoPreviewActivity.this.h.getProgress()) != VideoPreviewActivity.this.h.getMax() || f2 <= 0.0f) && (progress != 0 || f2 >= 0.0f))) {
                int max3 = (int) (progress + f2);
                if (max3 > VideoPreviewActivity.this.h.getMax()) {
                    max3 = VideoPreviewActivity.this.h.getMax();
                }
                if (max3 < 0) {
                    max3 = 0;
                }
                VideoPreviewActivity.this.h.setProgress(max3);
                VideoPreviewActivity videoPreviewActivity6 = VideoPreviewActivity.this;
                VideoPreviewActivity.this.a((max3 * videoPreviewActivity6.E) / videoPreviewActivity6.h.getMax());
            }
            VideoPreviewActivity.this.C = false;
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onShowPress(MotionEvent motionEvent) {
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            return false;
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MediaPlayer mediaPlayer = VideoPreviewActivity.this.s;
            if (mediaPlayer == null) {
                return;
            }
            int currentPosition = mediaPlayer.getCurrentPosition();
            c.b("tag", "ProRunnable position==" + currentPosition);
            VideoPreviewActivity videoPreviewActivity = VideoPreviewActivity.this;
            if (!videoPreviewActivity.G) {
                videoPreviewActivity.m.setText(lkxssdk.a0.b.a(currentPosition));
                VideoPreviewActivity.this.l.setProgress(currentPosition);
            }
            if (VideoPreviewActivity.this.s.isPlaying()) {
                VideoPreviewActivity videoPreviewActivity2 = VideoPreviewActivity.this;
                videoPreviewActivity2.v.postDelayed(videoPreviewActivity2.w, 500L);
            } else {
                ImageView imageView = VideoPreviewActivity.this.j;
                e eVarA = e.a();
                imageView.setImageResource(eVarA.b.getResources().getIdentifier("lkxs_pause", "drawable", eVarA.c));
            }
        }
    }

    public static /* synthetic */ boolean b(MediaPlayer mediaPlayer, int i, int i2) {
        c.b("tag", "media onError");
        return false;
    }

    public static /* synthetic */ boolean c(MediaPlayer mediaPlayer, int i, int i2) {
        c.b("tag", "media onInfo");
        return false;
    }

    @Override // lkxssdk.d.b
    public void a() throws IllegalStateException {
        c.b("tag", "player exit");
        this.v.removeCallbacks(this.w);
        this.v.removeMessages(1);
        try {
            MediaPlayer mediaPlayer = this.s;
            if (mediaPlayer != null) {
                if (mediaPlayer.isPlaying()) {
                    this.s.stop();
                }
                this.s.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        i.b().p = null;
        finish();
        overridePendingTransition(0, lkxssdk.a.a.a(1, false));
    }

    public final void a(int i) {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        float f = i / 255.0f;
        attributes.screenBrightness = f;
        c.b("tag", "setBrightness f==" + f);
        window.setAttributes(attributes);
    }

    @Override // lkxssdk.d.b
    public void b() throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        e eVarA = e.a();
        TextView textView = (TextView) findViewById(eVarA.b.getResources().getIdentifier("confirmBtn", "id", eVarA.c));
        this.J = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.lingku.xuanshang.core.ui.imagepicker.preview.VideoPreviewActivity$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws IllegalStateException {
                this.f$0.a(view);
            }
        });
        e eVarA2 = e.a();
        TextView textView2 = (TextView) findViewById(eVarA2.b.getResources().getIdentifier("selectedCount", "id", eVarA2.c));
        this.f772K = textView2;
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.lingku.xuanshang.core.ui.imagepicker.preview.VideoPreviewActivity$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
                this.f$0.b(view);
            }
        });
        e eVarA3 = e.a();
        this.d = (LinearLayout) findViewById(eVarA3.b.getResources().getIdentifier("title", "id", eVarA3.c));
        e eVarA4 = e.a();
        ImageView imageView = (ImageView) findViewById(eVarA4.b.getResources().getIdentifier("backBtn", "id", eVarA4.c));
        e eVarA5 = e.a();
        e eVarA6 = e.a();
        this.e = (LinearLayout) findViewById(eVarA6.b.getResources().getIdentifier("volumeLL", "id", eVarA6.c));
        e eVarA7 = e.a();
        this.g = (ProgressBar) findViewById(eVarA7.b.getResources().getIdentifier("volumePro", "id", eVarA7.c));
        e eVarA8 = e.a();
        this.f = (LinearLayout) findViewById(eVarA8.b.getResources().getIdentifier("brightnessLL", "id", eVarA8.c));
        e eVarA9 = e.a();
        this.h = (ProgressBar) findViewById(eVarA9.b.getResources().getIdentifier("brightnessPro", "id", eVarA9.c));
        e eVarA10 = e.a();
        this.k = (ImageView) findViewById(eVarA10.b.getResources().getIdentifier("rotate", "id", eVarA10.c));
        e eVarA11 = e.a();
        this.i = (LinearLayout) findViewById(eVarA11.b.getResources().getIdentifier(j.g, "id", eVarA11.c));
        e eVarA12 = e.a();
        ImageView imageView2 = (ImageView) findViewById(eVarA12.b.getResources().getIdentifier("play_pre", "id", eVarA12.c));
        e eVarA13 = e.a();
        ImageView imageView3 = (ImageView) findViewById(eVarA13.b.getResources().getIdentifier("play_next", "id", eVarA13.c));
        e eVarA14 = e.a();
        this.j = (ImageView) findViewById(eVarA14.b.getResources().getIdentifier("play_state", "id", eVarA14.c));
        e eVarA15 = e.a();
        this.m = (TextView) findViewById(eVarA15.b.getResources().getIdentifier("playTimes", "id", eVarA15.c));
        e eVarA16 = e.a();
        this.n = (TextView) findViewById(eVarA16.b.getResources().getIdentifier("videoTimes", "id", eVarA16.c));
        e eVarA17 = e.a();
        this.l = (SeekBar) findViewById(eVarA17.b.getResources().getIdentifier("seekBar", "id", eVarA17.c));
        e eVarA18 = e.a();
        this.o = (SurfaceView) findViewById(eVarA18.b.getResources().getIdentifier("surfaceView", "id", eVarA18.c));
        imageView2.setOnClickListener(this);
        imageView3.setOnClickListener(this);
        this.j.setOnClickListener(this);
        imageView.setOnClickListener(this);
        this.k.setOnClickListener(this);
        this.l.setOnSeekBarChangeListener(this);
        this.e.setVisibility(4);
        this.f.setVisibility(4);
        i();
        b(this.r);
        this.v = new Handler(this);
        this.w = new b();
        this.x = new GestureDetector(getApplicationContext(), new a());
    }

    public final void b(int i) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        String str = this.q.get(this.r);
        b(i.b().d(str), str);
        String str2 = this.q.get(i);
        this.u = str2;
        c(str2);
    }

    @Override // lkxssdk.d.b
    public void c() {
        h();
    }

    public final void c(String str) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        this.s.reset();
        this.s.setAudioStreamType(3);
        try {
            this.s.setDataSource(str);
            this.s.prepareAsync();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // lkxssdk.d.b
    public void d() throws IllegalStateException {
        setResult(0, new Intent().putExtra("dataChange", this.L));
        a();
    }

    @Override // lkxssdk.d.b
    public void e() {
    }

    @Override // lkxssdk.d.b
    public int f() {
        e eVarA = e.a();
        return eVarA.b.getResources().getIdentifier("lkxs_aty_preview_video", "layout", eVarA.c);
    }

    public final void h() {
        if (i.b().n.size() > 0) {
            this.J.getBackground().setAlpha(255);
            this.J.setClickable(true);
            this.J.setText(String.format(Locale.getDefault(), "确定 (%d/%d)", Integer.valueOf(i.b().n.size()), Integer.valueOf(i.b().d)));
        } else {
            this.J.setClickable(false);
            this.J.setText("确定");
            this.J.getBackground().setAlpha(125);
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what != 1) {
            return false;
        }
        this.d.setVisibility(4);
        this.i.setVisibility(4);
        this.k.setVisibility(4);
        return false;
    }

    public final void i() {
        MediaPlayer mediaPlayer = new MediaPlayer();
        this.s = mediaPlayer;
        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.lingku.xuanshang.core.ui.imagepicker.preview.VideoPreviewActivity$$ExternalSyntheticLambda0
            @Override // android.media.MediaPlayer.OnPreparedListener
            public final void onPrepared(MediaPlayer mediaPlayer2) throws IllegalStateException {
                this.f$0.a(mediaPlayer2);
            }
        });
        this.s.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.lingku.xuanshang.core.ui.imagepicker.preview.VideoPreviewActivity$$ExternalSyntheticLambda1
            @Override // android.media.MediaPlayer.OnCompletionListener
            public final void onCompletion(MediaPlayer mediaPlayer2) {
                c.b("tag", "media onCompletion");
            }
        });
        this.s.setOnSeekCompleteListener(new MediaPlayer.OnSeekCompleteListener() { // from class: com.lingku.xuanshang.core.ui.imagepicker.preview.VideoPreviewActivity$$ExternalSyntheticLambda2
            @Override // android.media.MediaPlayer.OnSeekCompleteListener
            public final void onSeekComplete(MediaPlayer mediaPlayer2) {
                c.b("tag", "media onSeekComplete");
            }
        });
        this.s.setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener() { // from class: com.lingku.xuanshang.core.ui.imagepicker.preview.VideoPreviewActivity$$ExternalSyntheticLambda3
            @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
            public final void onVideoSizeChanged(MediaPlayer mediaPlayer2, int i, int i2) {
                c.b("tag", "media onVideoSizeChanged");
            }
        });
        this.s.setOnBufferingUpdateListener(new MediaPlayer.OnBufferingUpdateListener() { // from class: com.lingku.xuanshang.core.ui.imagepicker.preview.VideoPreviewActivity$$ExternalSyntheticLambda4
            @Override // android.media.MediaPlayer.OnBufferingUpdateListener
            public final void onBufferingUpdate(MediaPlayer mediaPlayer2, int i) {
                c.b("tag", "media onBufferingUpdate");
            }
        });
        this.s.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.lingku.xuanshang.core.ui.imagepicker.preview.VideoPreviewActivity$$ExternalSyntheticLambda5
            @Override // android.media.MediaPlayer.OnErrorListener
            public final boolean onError(MediaPlayer mediaPlayer2, int i, int i2) {
                return VideoPreviewActivity.b(mediaPlayer2, i, i2);
            }
        });
        this.s.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.lingku.xuanshang.core.ui.imagepicker.preview.VideoPreviewActivity$$ExternalSyntheticLambda6
            @Override // android.media.MediaPlayer.OnInfoListener
            public final boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                return VideoPreviewActivity.c(mediaPlayer2, i, i2);
            }
        });
        SurfaceHolder holder = this.o.getHolder();
        this.p = holder;
        holder.setType(3);
        this.p.setKeepScreenOn(true);
        this.p.addCallback(this);
        j();
        this.E = 255;
        this.h.setProgress((this.g.getMax() * 127) / this.E);
        a(127);
    }

    public final void j() {
        AudioManager audioManager = (AudioManager) getSystemService("audio");
        this.F = audioManager;
        this.D = audioManager.getStreamMaxVolume(3);
        this.g.setProgress((this.F.getStreamVolume(3) * this.g.getMax()) / this.D);
    }

    public final void k() {
        float f = getApplicationContext().getResources().getDisplayMetrics().widthPixels;
        int i = getApplicationContext().getResources().getDisplayMetrics().heightPixels;
        Context applicationContext = getApplicationContext();
        int identifier = applicationContext.getResources().getIdentifier("status_bar_height", "dimen", "android");
        boolean zContains = false;
        int dimensionPixelSize = identifier > 0 ? applicationContext.getResources().getDimensionPixelSize(identifier) : 0;
        if ("4.4.4".equals(Build.VERSION.RELEASE)) {
            String str = Build.VERSION.INCREMENTAL;
            zContains = !TextUtils.isEmpty(str) ? str.contains("Flyme_OS_4") : Build.DISPLAY.contains("Flyme OS 4");
        }
        if (zContains) {
            dimensionPixelSize *= 2;
        }
        float f2 = i - dimensionPixelSize;
        float fMax = Math.max(this.s.getVideoWidth() / f, this.s.getVideoHeight() / f2);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) Math.ceil(r2 / fMax), (int) Math.ceil(r3 / fMax));
        layoutParams.addRule(13);
        this.o.setLayoutParams(layoutParams);
    }

    public final void l() throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        int progress = this.l.getProgress();
        c.b("tag", "videoSeekTo pro==" + progress);
        MediaPlayer mediaPlayer = this.s;
        if (mediaPlayer != null) {
            if (mediaPlayer.isPlaying()) {
                this.s.seekTo(progress);
            } else {
                b(this.r);
                this.H = progress;
                c(this.u);
            }
        }
        this.v.sendEmptyMessageDelayed(1, com.alipay.sdk.m.u.b.a);
        this.G = false;
    }

    @Override // com.lingku.xuanshang.core.ui.base.BaseActivity, android.app.Activity
    public void onBackPressed() throws IllegalStateException {
        if (getResources().getConfiguration().orientation != 2) {
            d();
        } else {
            this.I = 1;
            setRequestedOrientation(1);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0089  */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onClick(android.view.View r7) throws java.lang.IllegalStateException, java.lang.IllegalAccessException, java.lang.NoSuchFieldException, java.io.IOException, java.lang.SecurityException, java.lang.IllegalArgumentException {
        /*
            Method dump skipped, instructions count: 299
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lingku.xuanshang.core.ui.imagepicker.preview.VideoPreviewActivity.onClick(android.view.View):void");
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        c.b("tag", "onConfigurationChanged newConfig.orientation===" + configuration.orientation);
        k();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 24 || i == 25) {
            j();
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        if (z) {
            this.m.setText(lkxssdk.a0.b.a(i));
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
        c.b("tag", "onStartTrackingTouch");
        this.G = true;
        this.v.removeMessages(1);
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        c.b("tag", "onStopTrackingTouch");
        if (this.G) {
            l();
        }
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        LinearLayout linearLayout;
        if (this.x.onTouchEvent(motionEvent)) {
            c.b("tag", "mGestureDetector.onTouchEvent");
            return true;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.y = motionEvent.getX();
            this.z = motionEvent.getY();
            this.A = System.currentTimeMillis();
        } else if (action == 1) {
            int i = this.B;
            if (i == 1) {
                linearLayout = this.e;
            } else if (i == 2) {
                linearLayout = this.f;
            } else {
                if (i == 0) {
                    float x = motionEvent.getX();
                    float y = motionEvent.getY();
                    float f = getApplicationContext().getResources().getDisplayMetrics().density * 2.0f;
                    float fAbs = Math.abs(x - this.y);
                    float fAbs2 = Math.abs(y - this.z);
                    long jCurrentTimeMillis = System.currentTimeMillis() - this.A;
                    c.b("tag", "disX==" + fAbs + ",disY==" + fAbs2 + ",time==" + jCurrentTimeMillis);
                    if (fAbs < f && fAbs2 < f && jCurrentTimeMillis < 1000) {
                        if (this.d.getVisibility() == 0) {
                            this.d.setVisibility(4);
                            this.i.setVisibility(4);
                            this.k.setVisibility(4);
                        } else {
                            this.v.removeMessages(1);
                            this.d.setVisibility(0);
                            this.i.setVisibility(0);
                            this.k.setVisibility(0);
                            this.v.sendEmptyMessageDelayed(1, com.alipay.sdk.m.u.b.a);
                        }
                    }
                } else if (i == 3) {
                    l();
                }
                this.B = 0;
            }
            linearLayout.setVisibility(4);
            this.B = 0;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        c.b("tag", "surfaceChanged");
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        c.b("tag", "surfaceCreated");
        this.s.setDisplay(surfaceHolder);
        this.v.sendEmptyMessageDelayed(1, com.alipay.sdk.m.u.b.a);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        c.b("tag", "surfaceDestroyed");
    }

    @Override // lkxssdk.d.b
    public void a(Bundle bundle) {
        this.r = getIntent().getIntExtra("index", 0);
        this.q = i.b().p;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MediaPlayer mediaPlayer) throws IllegalStateException {
        k();
        c.b("tag", "media onPrepared");
        int duration = this.s.getDuration();
        this.t = duration;
        this.n.setText(lkxssdk.a0.b.a(duration));
        this.l.setMax(this.t);
        this.s.start();
        int i = this.H;
        if (i > 0) {
            this.s.seekTo(i);
            this.H = 0;
        }
        ImageView imageView = this.j;
        e eVarA = e.a();
        imageView.setImageResource(eVarA.b.getResources().getIdentifier("lkxs_play", "drawable", eVarA.c));
        this.v.postDelayed(this.w, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view) throws IllegalStateException {
        setResult(-1);
        a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        this.L = true;
        String str = this.q.get(this.r);
        boolean zD = i.b().d(str);
        if (zD) {
            i.b().n.remove(str);
        } else if (i.b().n.size() >= i.b().d) {
            lkxssdk.m0.b.a().a("最多只能选择" + i.b().d + "个视频", 0);
            return;
        } else {
            if (i.b().i > 0 && this.t / 1000 > i.b().i) {
                lkxssdk.m0.b.a().a("请选择" + i.b().i + "秒内的视频", 0);
                return;
            }
            i.b().a(str);
        }
        h();
        b(true ^ zD, str);
    }

    public final void b(boolean z, String str) {
        if (z) {
            TextView textView = this.f772K;
            e eVarA = e.a();
            textView.setBackgroundResource(eVarA.b.getResources().getIdentifier("lkxs_picker_seleted_more", "drawable", eVarA.c));
            this.f772K.setText(String.valueOf(i.b().n.indexOf(str) + 1));
            return;
        }
        TextView textView2 = this.f772K;
        e eVarA2 = e.a();
        textView2.setBackgroundResource(eVarA2.b.getResources().getIdentifier("lkxs_picker_unselected", "drawable", eVarA2.c));
        this.f772K.setText("");
    }
}
