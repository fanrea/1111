package com.fc.tjcpl.sdk.n;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class b0 {
    public static b0 r = null;
    public static boolean s = true;
    public WindowManager a;
    public WindowManager.LayoutParams b;
    public WindowManager.LayoutParams c;
    public Context d;
    public View e;
    public float f;
    public c g;
    public Timer h;
    public long i;
    public d j;
    public int k;
    public int l;
    public float m;
    public float n;
    public long p;
    public Handler o = new Handler();
    public Handler q = new b();

    public class a implements View.OnTouchListener {
        public a() {
        }

        /* JADX WARN: Removed duplicated region for block: B:26:0x00a9  */
        @Override // android.view.View.OnTouchListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean onTouch(android.view.View r14, android.view.MotionEvent r15) {
            /*
                Method dump skipped, instructions count: 376
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fc.tjcpl.sdk.n.b0.a.onTouch(android.view.View, android.view.MotionEvent):boolean");
        }
    }

    public class b extends Handler {
        public b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what != 1) {
                return;
            }
            b0 b0Var = b0.this;
            WindowManager.LayoutParams layoutParams = b0Var.b;
            b0Var.c = layoutParams;
            if (b0.s) {
                layoutParams.x = -(b0Var.e.getWidth() / 2);
            } else {
                layoutParams.x += b0Var.e.getWidth() / 2;
                b0Var.f = b0Var.c.x;
            }
            try {
                b0Var.a.updateViewLayout(b0Var.e, b0Var.c);
            } catch (Exception e) {
                Log.d("SyFloatView", "hidePop E :" + e.toString());
            }
        }
    }

    public class c extends TimerTask {
        public int a;
        public int b;

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b0 b0Var = b0.this;
                b0Var.a.updateViewLayout(b0Var.e, b0Var.b);
            }
        }

        public c() {
            boolean unused = b0.s = false;
            this.b = b0.this.k - b0.this.e.getWidth();
            this.a = (b0.this.k - b0.this.b.x) / 10;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (Math.abs(this.b - b0.this.b.x) <= Math.abs(this.a)) {
                b0.this.b.x = this.b;
            } else {
                b0.this.b.x += this.a;
            }
            try {
                b0.this.o.post(new a());
            } catch (Exception e) {
                Log.d("SyFloatView", e.toString());
            }
            b0 b0Var = b0.this;
            if (b0Var.b.x == this.b) {
                b0Var.g.cancel();
                b0.this.h.cancel();
            }
        }
    }

    public interface d {
    }

    public b0(Context context) {
        this.d = context;
        c();
        d();
        b();
        a();
    }

    public static b0 a(Context context) {
        if (r == null) {
            synchronized (b0.class) {
                if (r == null) {
                    r = new b0(context);
                }
            }
        }
        return r;
    }

    public static boolean b(b0 b0Var) {
        b0Var.getClass();
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - b0Var.p < 500) {
            return true;
        }
        b0Var.p = jCurrentTimeMillis;
        return false;
    }

    public final void a() {
        this.e.setOnTouchListener(new a());
    }

    public final void b() {
        this.k = this.d.getResources().getDisplayMetrics().widthPixels;
        this.l = this.d.getResources().getDisplayMetrics().heightPixels;
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-2, -2, 1003, 520, -3);
        this.b = layoutParams;
        layoutParams.gravity = 51;
        layoutParams.x = this.k - com.fc.tjcpl.sdk.b.a.a(56.0f);
        this.b.y = this.l / 2;
    }

    public final void c() {
        View viewInflate = ((LayoutInflater) ((Activity) this.d).getSystemService("layout_inflater")).inflate(com.fc.tjcpl.sdk.b.a.a(this.d, "layout", "tj_floating_view"), (ViewGroup) null);
        this.e = viewInflate;
    }

    public final void d() {
        this.a = (WindowManager) this.d.getSystemService("window");
    }
}
