package com.alliance.ssp.ad.video;

import android.media.MediaPlayer;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.alliance.ssp.ad.o0.l;
import com.alliance.ssp.ad.video.VideoController;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: VideoEventListener.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class f {
    public MediaPlayer a;
    public a b;
    public VideoController c;
    public b d;
    public ScheduledExecutorService e;
    public ScheduledFuture f;
    public ScheduledExecutorService g;
    public ScheduledFuture h;
    public Handler i;
    public Handler j;
    public HandlerThread k;
    public boolean l = false;
    public final Object m = new Object();

    /* compiled from: VideoEventListener.java */
    public interface a {
        void a();

        void a(int i);

        void a(MediaPlayer mediaPlayer);

        void b(int i);

        void b(MediaPlayer mediaPlayer);

        void onError(MediaPlayer mediaPlayer, int i, int i2);

        void onInfo(MediaPlayer mediaPlayer, int i, int i2);
    }

    /* compiled from: VideoEventListener.java */
    public class b implements MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener {
        public int a;
        public Runnable d;
        public Runnable e;
        public int b = 0;
        public int c = 0;
        public boolean f = false;

        /* compiled from: VideoEventListener.java */
        public class a extends Handler {
            public a(Looper looper) {
                super(looper);
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                synchronized (f.this.m) {
                    int i = message.what;
                    int i2 = l.a;
                    if (i == 65539) {
                        b bVar = b.this;
                        bVar.a = f.this.a.getDuration();
                        f fVar = f.this;
                        if (fVar.e == null) {
                            fVar.e = Executors.newSingleThreadScheduledExecutor();
                        }
                        b bVar2 = b.this;
                        f fVar2 = f.this;
                        ScheduledExecutorService scheduledExecutorService = fVar2.e;
                        Runnable runnable = bVar2.d;
                        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                        fVar2.f = scheduledExecutorService.scheduleAtFixedRate(runnable, 0L, 100L, timeUnit);
                        f fVar3 = f.this;
                        if (fVar3.g == null) {
                            fVar3.g = Executors.newSingleThreadScheduledExecutor();
                        }
                        b bVar3 = b.this;
                        f fVar4 = f.this;
                        fVar4.h = fVar4.g.scheduleAtFixedRate(bVar3.e, 0L, 20L, timeUnit);
                    } else if (i == 65541) {
                        ScheduledFuture scheduledFuture = f.this.f;
                        if (scheduledFuture != null) {
                            scheduledFuture.cancel(true);
                        }
                        b bVar4 = b.this;
                        bVar4.b = 0;
                        bVar4.c = 0;
                    } else if (i == 65544) {
                        b bVar5 = b.this;
                        f fVar5 = f.this;
                        if (fVar5.f != null) {
                            fVar5.f = fVar5.e.scheduleAtFixedRate(bVar5.d, 0L, 100L, TimeUnit.MILLISECONDS);
                        }
                    }
                }
            }
        }

        public b() {
            c();
        }

        public final void a() {
            MediaPlayer mediaPlayer;
            if (this.f || (mediaPlayer = f.this.a) == null || mediaPlayer.getCurrentPosition() < 1) {
                return;
            }
            f.this.a(65543, (Object) null);
            this.f = true;
            ScheduledFuture scheduledFuture = f.this.h;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(true);
            }
        }

        public final void b() {
            int currentPosition;
            int currentPosition2;
            int i;
            if (this.a <= 0) {
                int i2 = l.a;
                this.a = f.this.a.getDuration();
                return;
            }
            MediaPlayer mediaPlayer = f.this.a;
            int i3 = 0;
            if (mediaPlayer != null) {
                currentPosition = mediaPlayer.getCurrentPosition();
                f.this.a(65542, Integer.valueOf(currentPosition));
                if (currentPosition > 0) {
                    currentPosition /= 1000;
                }
            } else {
                currentPosition = 0;
            }
            if (this.b != currentPosition) {
                this.b = currentPosition;
                a aVar = f.this.b;
                if (aVar != null) {
                    aVar.b(currentPosition);
                }
            }
            MediaPlayer mediaPlayer2 = f.this.a;
            if (mediaPlayer2 != null && (currentPosition2 = mediaPlayer2.getCurrentPosition()) > 0 && (i = this.a) > 0) {
                i3 = (int) ((currentPosition2 / i) * 100.0d);
            }
            if (this.c != i3) {
                this.c = i3;
                a aVar2 = f.this.b;
                if (aVar2 != null) {
                    aVar2.a(i3);
                }
            }
        }

        public final void c() {
            f fVar = f.this;
            if (fVar.k == null) {
                fVar.k = new HandlerThread("VideoEventListener");
            }
            f fVar2 = f.this;
            if (!fVar2.l) {
                fVar2.k.start();
                f.this.l = true;
            }
            f.this.i = new a(f.this.k.getLooper());
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            int i = l.a;
            f fVar = f.this;
            VideoController videoController = fVar.c;
            if (videoController == null || videoController.a != VideoController.VIDEO_STATE.ERROR) {
                a aVar = fVar.b;
                if (aVar != null) {
                    aVar.a(mediaPlayer);
                }
                ScheduledFuture scheduledFuture = f.this.f;
                if (scheduledFuture != null) {
                    scheduledFuture.cancel(true);
                }
                f.this.a(65538, (Object) null);
            }
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            int i3 = l.a;
            a aVar = f.this.b;
            if (aVar != null) {
                aVar.onError(mediaPlayer, i, i2);
            }
            f.this.a(65545, (Object) null);
            ScheduledFuture scheduledFuture = f.this.f;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(true);
            }
            ScheduledFuture scheduledFuture2 = f.this.h;
            if (scheduledFuture2 == null) {
                return false;
            }
            scheduledFuture2.cancel(true);
            return false;
        }

        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            int i3 = l.a;
            a aVar = f.this.b;
            if (aVar == null) {
                return false;
            }
            aVar.onInfo(mediaPlayer, i, i2);
            return false;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            int i = l.a;
            a aVar = f.this.b;
            if (aVar != null) {
                aVar.b(mediaPlayer);
            }
            f fVar = f.this;
            fVar.a(65537, fVar.i);
            this.d = new Runnable() { // from class: com.alliance.ssp.ad.video.f$b$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.b();
                }
            };
            this.e = new Runnable() { // from class: com.alliance.ssp.ad.video.f$b$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.a();
                }
            };
        }
    }

    public f(a aVar, VideoController videoController, Handler handler) {
        this.b = aVar;
        this.c = videoController;
        this.j = handler;
    }

    public void b() {
        MediaPlayer mediaPlayer;
        b bVar;
        int i = l.a;
        this.a = this.c.b();
        this.d = new b();
        this.e = Executors.newSingleThreadScheduledExecutor();
        if (this.b == null || (mediaPlayer = this.a) == null || (bVar = this.d) == null) {
            return;
        }
        mediaPlayer.setOnPreparedListener(bVar);
        this.a.setOnCompletionListener(this.d);
        this.a.setOnErrorListener(this.d);
        this.a.setOnInfoListener(this.d);
    }

    public void a() {
        int i = l.a;
        MediaPlayer mediaPlayer = this.a;
        if (mediaPlayer == null) {
            return;
        }
        mediaPlayer.setOnPreparedListener(null);
        this.a.setOnCompletionListener(null);
        this.a.setOnErrorListener(null);
        this.a.setOnInfoListener(null);
        ScheduledFuture scheduledFuture = this.f;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
        }
        ScheduledFuture scheduledFuture2 = this.h;
        if (scheduledFuture2 != null) {
            scheduledFuture2.cancel(true);
        }
        if (this.i != null) {
            this.i = null;
        }
        if (this.k != null) {
            this.k = null;
            this.l = false;
        }
    }

    public final void a(int i, Object obj) {
        Handler handler = this.j;
        if (handler == null) {
            int i2 = l.a;
            return;
        }
        Message messageObtainMessage = handler.obtainMessage();
        messageObtainMessage.what = i;
        if (obj != null) {
            messageObtainMessage.obj = obj;
        }
        this.j.sendMessage(messageObtainMessage);
    }
}
