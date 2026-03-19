package com.qq.e.comm.plugin;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.qq.e.comm.plugin.w3;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class nf implements MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, Handler.Callback {
    private static final String s = "nf";
    private AudioManager b;
    private final Context c;
    private volatile int d;
    private String e;
    private final Handler m;
    private final Handler n;
    private HandlerThread o;
    private i p;
    private h4 q;
    private volatile MediaPlayer a = null;
    private final AtomicBoolean f = new AtomicBoolean(false);
    private final AtomicBoolean g = new AtomicBoolean(false);
    private final AtomicBoolean h = new AtomicBoolean(false);
    private final AtomicBoolean i = new AtomicBoolean(false);
    private int j = 1;
    private int r = 0;

    /* compiled from: A */
    public interface i {
        void a();

        void a(Throwable th);

        void b();

        void c();

        void d();

        void e();

        void f();
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
        return false;
    }

    @Override // android.media.MediaPlayer.OnInfoListener
    public boolean onInfo(MediaPlayer mediaPlayer, int i2, int i3) {
        return false;
    }

    public nf(Context context) {
        this.c = context;
        HandlerThread handlerThread = new HandlerThread("nf");
        this.o = handlerThread;
        handlerThread.start();
        this.m = new m50(this, this.o.getLooper());
        this.n = new Handler(Looper.getMainLooper());
    }

    private void h() {
        this.f.set(false);
        if (this.a == null) {
            this.a = new MediaPlayer();
        } else {
            try {
                this.a.reset();
            } catch (Throwable unused) {
                this.a = new MediaPlayer();
            }
        }
        this.h.set(false);
        this.d = 0;
        this.j = 1;
        this.b = (AudioManager) this.c.getSystemService("audio");
        this.a.setOnPreparedListener(this);
        this.a.setOnCompletionListener(this);
        this.a.setOnErrorListener(this);
        this.a.setOnInfoListener(this);
    }

    private void t() {
        AudioManager audioManager;
        if (this.i.get() || this.j != 3 || (audioManager = this.b) == null) {
            return;
        }
        audioManager.requestAudioFocus(null, 3, 2);
    }

    private void s() {
        AudioManager audioManager = this.b;
        if (audioManager != null) {
            audioManager.abandonAudioFocus(null);
        }
    }

    /* compiled from: A */
    class a implements w3.b {
        final /* synthetic */ String a;

        a(String str) {
            this.a = str;
        }

        @Override // com.qq.e.comm.plugin.w3.b
        public void a(String str) {
            String unused = nf.s;
            nf.this.d(str);
        }

        @Override // com.qq.e.comm.plugin.w3.b
        public void a(String str, int i) {
            String unused = nf.s;
        }
    }

    /* compiled from: A */
    class b implements Runnable {
        final /* synthetic */ Throwable a;

        b(Throwable th) {
            this.a = th;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (nf.this.p != null) {
                nf.this.p.a(this.a);
            }
        }
    }

    public void j() {
        this.m.sendEmptyMessage(2);
    }

    private void k() throws IllegalStateException {
        this.h.set(true);
        if (this.f.get() && this.g.get() && this.j != 3 && this.a != null) {
            int i2 = this.j;
            if (i2 != 6 && i2 != 4) {
                t();
                this.a.start();
                this.j = 3;
                this.n.post(new c());
                return;
            }
            c(this.e);
            this.h.set(true);
        }
    }

    private void a(String str) {
        w3.a(this.q, str, new a(str));
    }

    /* compiled from: A */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (nf.this.p != null) {
                nf.this.p.c();
                float f = nf.this.i.get() ? 0.0f : 0.8f;
                if (nf.this.a == null || nf.this.j == 0) {
                    return;
                }
                try {
                    nf.this.a.setVolume(f, f);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void r() {
        this.m.sendEmptyMessage(3);
    }

    private boolean i() {
        int i2;
        return (this.a == null || (i2 = this.j) == 0 || i2 == 1) ? false : true;
    }

    public int g() {
        if (this.d == 0) {
            try {
                if (i() && this.g.get()) {
                    this.d = this.a.getDuration();
                }
            } catch (Exception unused) {
            }
        }
        return this.d;
    }

    public void a(i iVar) {
        this.p = iVar;
    }

    public int f() {
        try {
            if (!i()) {
                return 0;
            }
            if (this.j == 6) {
                return g();
            }
            return this.a.getCurrentPosition();
        } catch (Exception unused) {
            return 0;
        }
    }

    public int e() {
        return this.j;
    }

    public void n() {
        this.m.sendEmptyMessage(5);
    }

    private void o() {
        try {
            if (this.a == null || this.j == 0 || this.i.get()) {
                return;
            }
            this.a.setVolume(0.0f, 0.0f);
            this.i.set(true);
            this.n.post(new d());
            s();
        } catch (Exception unused) {
        }
    }

    /* compiled from: A */
    class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (nf.this.p != null) {
                nf.this.p.b();
            }
        }
    }

    public void p() {
        this.m.sendEmptyMessage(6);
    }

    private void q() {
        try {
            if (this.a == null || this.j == 0 || !this.i.get()) {
                return;
            }
            this.a.setVolume(0.8f, 0.8f);
            this.i.set(false);
            this.n.post(new e());
            t();
        } catch (Exception unused) {
        }
    }

    /* compiled from: A */
    class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (nf.this.p != null) {
                nf.this.p.f();
            }
        }
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        this.j = 2;
        this.g.set(true);
        this.n.post(new f());
        if (this.h.get()) {
            j();
        }
    }

    /* compiled from: A */
    class f implements Runnable {
        f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (nf.this.p != null) {
                nf.this.p.e();
            }
        }
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        if (this.j != 6) {
            this.j = 6;
            s();
            this.n.post(new g());
        }
        int i2 = this.r;
        if (i2 > 0) {
            this.r = i2 - 1;
            j();
        }
    }

    public void c() {
        this.m.sendEmptyMessage(7);
    }

    /* compiled from: A */
    class g implements Runnable {
        g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (nf.this.p != null) {
                nf.this.p.d();
            }
        }
    }

    private void b() throws IllegalStateException {
        int i2 = this.j;
        if (i2 == 1 || i2 == 2 || i2 == 4 || i2 == 6 || i2 == 0 || this.a == null) {
            return;
        }
        this.j = 4;
        s();
        this.a.stop();
        this.n.post(new h());
    }

    /* compiled from: A */
    class h implements Runnable {
        h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (nf.this.p != null) {
                nf.this.p.a();
            }
        }
    }

    private void m() {
        try {
            this.a.reset();
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    private synchronized void l() {
        HandlerThread handlerThread = this.o;
        if (handlerThread != null) {
            handlerThread.quit();
            this.o = null;
        }
    }

    private void d() {
        if (this.a != null) {
            m();
            this.a.release();
            this.a = null;
            this.j = 1;
        }
        l();
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) throws IllegalStateException {
        int i2 = message.what;
        if (i2 == 1) {
            c(String.valueOf(message.obj));
            return false;
        }
        if (i2 == 2) {
            k();
            return false;
        }
        if (i2 == 3) {
            b();
            return false;
        }
        if (i2 == 5) {
            o();
            return false;
        }
        if (i2 == 6) {
            q();
            return false;
        }
        if (i2 != 7) {
            return false;
        }
        d();
        return false;
    }

    public void a(int i2) {
        this.r = i2;
        this.a.setLooping(this.r == -1);
    }

    public void b(String str) {
        Message message = new Message();
        message.what = 1;
        message.obj = str;
        this.m.sendMessage(message);
    }

    private void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.e = str;
        h();
        String strA = w3.a(str);
        if (!TextUtils.isEmpty(strA)) {
            d(strA);
        } else {
            a(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str) {
        try {
            this.h.set(false);
            this.f.set(true);
            this.a.setDataSource(str);
            this.a.prepareAsync();
        } catch (Throwable th) {
            this.j = 0;
            this.n.post(new b(th));
        }
    }
}
