package com.component.player;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.baidu.mobads.container.util.bl;
import com.baidu.mobads.container.util.bq;
import com.baidu.mobads.container.util.cm;
import com.component.player.k;
import java.lang.ref.WeakReference;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class f implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener, k.a, t {
    private static final String c = "BaseMediaPlayer";
    private static final int d = 31;
    private static final int e = 47;
    private static final int f = 63;
    private static final int g = 79;
    private static final int h = 95;
    private static final int i = 111;
    private static final int j = 127;
    private static final int k = 143;
    private static final int l = 159;
    private static final int m = 175;
    private static final int n = 191;
    private static final int o = 207;
    private static final int p = 223;
    private static final int q = 271;
    public volatile a a;
    private volatile boolean r;
    private volatile MediaPlayer s;
    private WeakReference<u> t;
    private k u;
    private HandlerThread v;
    private Context w;
    public bq b = bq.a();
    private boolean x = false;

    public enum a {
        IDLE,
        INITIALIZED,
        PREPARING,
        PREPARED,
        STARTED,
        PAUSED,
        STOPPED,
        PLAYBACKCOMPLETED,
        END,
        ERROR
    }

    public f(Context context) {
        m();
        this.w = context.getApplicationContext();
        this.r = com.baidu.mobads.container.h.a.a().n();
    }

    @Override // com.component.player.t
    public void a(u uVar) {
        this.t = new WeakReference<>(uVar);
    }

    @Override // com.component.player.t
    public String a() {
        return w.b;
    }

    @Override // com.component.player.t
    public void a(String str) {
        if (this.u != null && !this.u.hasMessages(31)) {
            this.u.sendMessage(this.u.obtainMessage(31, str));
        }
    }

    @Override // com.component.player.t
    public void a(float f2) {
        if (this.a != a.ERROR && this.u != null && !this.u.hasMessages(159)) {
            this.u.sendMessage(this.u.obtainMessage(159, new float[]{f2, f2}));
        }
    }

    @Override // com.component.player.t
    public void b(float f2) {
        if (this.a != a.ERROR && this.u != null && !this.u.hasMessages(175)) {
            this.u.sendMessage(this.u.obtainMessage(175, Float.valueOf(f2)));
        }
    }

    @Override // com.component.player.t
    public void a(Object obj) {
        this.b.b(c, "start2=" + this.a);
        if (this.u != null && !this.u.hasMessages(223)) {
            this.u.sendMessage(this.u.obtainMessage(223, obj));
        }
    }

    @Override // com.component.player.t
    public void b() {
        this.b.b(c, "pause=" + this.a);
        if (this.u != null && !this.u.hasMessages(79)) {
            this.u.sendEmptyMessage(79);
        }
    }

    public void c() {
        if (this.u != null && !this.u.hasMessages(95)) {
            this.u.sendEmptyMessage(95);
        }
    }

    @Override // com.component.player.t
    public void a(long j2) {
        if (this.u != null && !this.u.hasMessages(143)) {
            this.u.sendMessage(this.u.obtainMessage(143, Long.valueOf(j2)));
        }
    }

    @Override // com.component.player.t
    public void d() {
        if (this.u != null && !this.u.hasMessages(127)) {
            this.u.removeCallbacksAndMessages(null);
            this.u.sendEmptyMessage(127);
        }
    }

    @Override // com.component.player.t
    public void e() {
        if (this.u != null && !this.u.hasMessages(111)) {
            this.u.sendEmptyMessage(111);
        }
    }

    public void a(boolean z) {
        if (this.s != null) {
            this.s.setScreenOnWhilePlaying(z);
        }
    }

    @Override // com.component.player.t
    public int f() {
        if (this.a == a.ERROR || this.s == null) {
            return 0;
        }
        return this.s.getVideoWidth();
    }

    @Override // com.component.player.t
    public int g() {
        if (this.a == a.ERROR || this.s == null) {
            return 0;
        }
        return this.s.getVideoHeight();
    }

    @Override // com.component.player.t
    public long h() {
        try {
            if ((this.a != a.INITIALIZED && this.a != a.PREPARED && this.a != a.STARTED && this.a != a.PAUSED && this.a != a.STOPPED && this.a != a.PLAYBACKCOMPLETED) || this.s == null) {
                return 0L;
            }
            return this.s.getCurrentPosition();
        } catch (Throwable th) {
            th.printStackTrace();
            return 0L;
        }
    }

    @Override // com.component.player.t
    public long i() {
        if ((this.a == a.PREPARED || this.a == a.STARTED || this.a == a.PAUSED || this.a == a.STOPPED || this.a == a.PLAYBACKCOMPLETED) && this.s != null) {
            return this.s.getDuration();
        }
        return 0L;
    }

    @Override // com.component.player.t
    public boolean j() {
        try {
            if ((this.a == a.IDLE || this.a == a.INITIALIZED || this.a == a.PREPARED || this.a == a.STARTED || this.a == a.PAUSED || this.a == a.STOPPED || this.a == a.PLAYBACKCOMPLETED) && this.s != null) {
                return this.s.isPlaying();
            }
            return false;
        } catch (Exception e2) {
            this.b.b(c, "isPlaying异常" + e2.getMessage());
            return false;
        }
    }

    @Override // com.component.player.t
    public a k() {
        return this.a;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        this.a = a.PREPARED;
        a(new cm("player", 258));
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        this.b.b(c, "onCompletion" + this.a);
        this.a = a.PLAYBACKCOMPLETED;
        a(new cm("player", 256));
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
        StringBuilder sb = new StringBuilder();
        if (i2 == 1) {
            sb.append("未知错误");
        } else if (i2 == 100) {
            sb.append("媒体服务死亡: ");
            if (i3 == -1004) {
                sb.append("IO错误");
            } else if (i3 == -1007) {
                sb.append("媒体文件格式错误");
            } else if (i3 == -1010) {
                sb.append("不支持的文件格式或编码");
            } else if (i3 == -110) {
                sb.append("操作超时，通常是超过3-5秒");
            }
        } else if (i2 == 200) {
            sb.append("媒体或视频不支持快进");
        } else {
            sb.append(i2).append(": ").append(i3);
        }
        sb.append(", what: ").append(i2).append(", extra: ").append(i3);
        com.baidu.mobads.container.util.h.a(new g(this, sb.toString()));
        return true;
    }

    @Override // android.media.MediaPlayer.OnInfoListener
    public boolean onInfo(MediaPlayer mediaPlayer, int i2, int i3) {
        switch (i2) {
            case 3:
                if (!this.x) {
                    a(new cm("player", 260));
                    this.x = true;
                    break;
                }
                break;
            case 701:
                a(new cm("player", 261));
                break;
            case 702:
                a(new cm("player", 262));
                break;
        }
        return false;
    }

    @Override // android.media.MediaPlayer.OnSeekCompleteListener
    public void onSeekComplete(MediaPlayer mediaPlayer) {
        a(new cm("player", 259));
    }

    @Override // com.component.player.k.a
    public void a(Message message) throws IllegalStateException {
        switch (message.what) {
            case 31:
                if (this.s != null) {
                    try {
                        if (this.a != a.IDLE) {
                            this.a = a.IDLE;
                            this.s.reset();
                        }
                        this.s.setDataSource((String) message.obj);
                        this.a = a.INITIALIZED;
                        o();
                        com.baidu.mobads.container.l.g.c(hashCode() + " prepare yes");
                        break;
                    } catch (Throwable th) {
                        this.b.b(c, "setVideoPath异常" + th.getMessage());
                        return;
                    }
                }
                break;
            case 47:
            case 63:
                if (this.s != null) {
                    if (this.a == a.PREPARED || this.a == a.PAUSED || this.a == a.PLAYBACKCOMPLETED) {
                        try {
                            com.baidu.mobads.container.l.g.c(hashCode() + " resume yes");
                            this.s.start();
                            this.a = a.STARTED;
                            break;
                        } catch (Throwable th2) {
                            this.b.b(c, "start异常: " + th2.getMessage());
                            return;
                        }
                    }
                }
                break;
            case 79:
                if (this.s != null && this.a == a.STARTED) {
                    try {
                        com.baidu.mobads.container.l.g.c(hashCode() + " pause yes");
                        this.s.pause();
                        this.a = a.PAUSED;
                        break;
                    } catch (Throwable th3) {
                        this.b.b(c, "start异常: " + th3.getMessage());
                        return;
                    }
                }
                break;
            case 95:
                if (this.s != null) {
                    if (this.a == a.STARTED || this.a == a.PREPARED || this.a == a.PAUSED || this.a == a.PLAYBACKCOMPLETED) {
                        com.baidu.mobads.container.l.g.c(hashCode() + " stop yes");
                        this.s.stop();
                        this.a = a.STOPPED;
                        break;
                    }
                }
                break;
            case 111:
                if (this.s != null) {
                    this.a = a.IDLE;
                    this.s.reset();
                    break;
                }
                break;
            case 127:
                try {
                    if (this.s != null) {
                        com.baidu.mobads.container.l.g.c(hashCode() + " release yes");
                        this.s.release();
                        this.a = a.END;
                        this.s.setOnSeekCompleteListener(null);
                        this.s.setOnInfoListener(null);
                        this.s.setOnErrorListener(null);
                        this.s.setOnPreparedListener(null);
                        this.s.setOnCompletionListener(null);
                        this.s = null;
                    }
                    if (Build.VERSION.SDK_INT >= 18) {
                        this.v.quitSafely();
                        break;
                    } else {
                        this.v.quit();
                        break;
                    }
                } catch (Throwable th4) {
                    this.b.d(c, "release media player error", th4);
                    return;
                }
            case 143:
                if (this.a == a.PREPARED || this.a == a.STARTED || this.a == a.PAUSED || this.a == a.PLAYBACKCOMPLETED) {
                    if (message.obj instanceof Long) {
                        b(((Long) message.obj).longValue());
                        break;
                    }
                } else {
                    this.b.b(c, "seekTo不合法，mCurState=" + this.a);
                    break;
                }
                break;
            case 159:
                if (this.a != a.ERROR && (message.obj instanceof float[])) {
                    a((float[]) message.obj);
                    break;
                }
                break;
            case 175:
                if (this.a != a.ERROR && (message.obj instanceof Float)) {
                    c(((Float) message.obj).floatValue());
                    break;
                }
                break;
            case 191:
                if (message.obj instanceof Surface) {
                    a((Surface) message.obj);
                    break;
                }
                break;
            case 207:
                if (message.obj instanceof SurfaceHolder) {
                    a((SurfaceHolder) message.obj);
                    break;
                }
                break;
            case 223:
                try {
                    if (message.obj instanceof Surface) {
                        a((Surface) message.obj);
                    } else if (message.obj instanceof SurfaceHolder) {
                        a((SurfaceHolder) message.obj);
                    }
                    if (this.s != null) {
                        if (this.a == a.PREPARED || this.a == a.PAUSED || this.a == a.PLAYBACKCOMPLETED) {
                            com.baidu.mobads.container.l.g.c(hashCode() + " start yes");
                            this.s.start();
                            this.a = a.STARTED;
                            break;
                        }
                    }
                } catch (Throwable th5) {
                    this.b.b(c, "start异常: " + th5.getMessage());
                    return;
                }
                break;
            case 271:
                n();
                break;
        }
    }

    public boolean l() {
        return this.a == a.IDLE || this.a == a.PLAYBACKCOMPLETED || this.a == a.ERROR;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(cm cmVar) {
        if (this.t != null) {
            com.baidu.mobads.container.util.h.a(new h(this, cmVar));
        }
    }

    private void m() {
        this.v = new HandlerThread("bd_video_player");
        this.v.start();
        this.u = new k(this.v.getLooper(), this);
        this.u.sendEmptyMessage(271);
    }

    private void n() {
        this.s = new MediaPlayer();
        this.x = false;
        this.a = a.IDLE;
        this.s.setAudioStreamType(3);
        this.s.setOnPreparedListener(this);
        this.s.setOnCompletionListener(this);
        this.s.setOnErrorListener(this);
        this.s.setOnInfoListener(this);
        this.s.setOnSeekCompleteListener(this);
    }

    private void o() throws IllegalStateException {
        this.s.prepareAsync();
        this.a = a.PREPARING;
    }

    private void b(long j2) {
        if (this.s != null) {
            try {
                if (com.baidu.mobads.container.util.x.a(null).a() >= 26) {
                    this.s.seekTo(j2, 3);
                } else {
                    this.s.seekTo((int) j2);
                }
            } catch (Throwable th) {
                this.b.b(c, "seekTo异常" + th.getMessage());
            }
        }
    }

    private void a(Surface surface) {
        if (this.s != null) {
            this.s.setSurface(surface);
            a(this.w, 10);
        }
    }

    private void a(SurfaceHolder surfaceHolder) {
        if (this.s != null) {
            this.s.setDisplay(surfaceHolder);
            this.s.setScreenOnWhilePlaying(true);
        }
    }

    private void a(float[] fArr) {
        try {
            if (this.s != null) {
                this.s.setVolume(fArr[0], fArr[1]);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void c(float f2) {
        if (this.s != null) {
            try {
                if (com.baidu.mobads.container.util.x.a(null).a() >= 23) {
                    this.s.setPlaybackParams(this.s.getPlaybackParams().setSpeed(f2));
                }
            } catch (Exception e2) {
                this.b.b(c, "setPlayBackSpeed异常" + e2.getMessage());
            }
        }
    }

    private void a(Context context, int i2) {
        if (this.s != null && context != null && bl.a(context, "android.permission.WAKE_LOCK")) {
            this.s.setWakeMode(context.getApplicationContext(), i2);
        }
    }
}
