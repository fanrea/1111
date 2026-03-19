package com.qq.e.comm.plugin;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class u50 extends RelativeLayout implements View.OnClickListener {
    private int a;
    private final int b;
    private final km c;
    private ViewGroup d;
    private ImageView e;
    private ImageView f;
    private b g;
    private boolean h;
    private final Runnable i;

    /* compiled from: A */
    public interface b {
        void i();

        void j();

        void k();

        void l();
    }

    private void c() {
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.d = frameLayout;
        frameLayout.setBackgroundColor(-1);
        this.d.setOnClickListener(this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, yu.a(getContext(), 44));
        layoutParams.addRule(12, -1);
        this.d.setLayoutParams(layoutParams);
        addView(this.d, layoutParams);
        View view = new View(getContext());
        view.setBackgroundColor(Color.parseColor("#D5D5D6"));
        this.d.addView(view, new FrameLayout.LayoutParams(-1, 1));
        int iA = yu.a(getContext(), 4);
        ImageView imageView = new ImageView(getContext());
        this.e = imageView;
        imageView.setImageBitmap(gw.a("iVBORw0KGgoAAAANSUhEUgAAACQAAAA+CAYAAABDTbllAAAAAXNSR0IArs4c6QAAAERlWElmTU0AKgAAAAgAAYdpAAQAAAABAAAAGgAAAAAAA6ABAAMAAAABAAEAAKACAAQAAAABAAAAJKADAAQAAAABAAAAPgAAAAAAXmzfAAACf0lEQVRoBc3ZT2sTQRQA8JlGD9sqaME2tceexKSN9g8oHoroJ/AbSKkofgDxlG8hFM+9WL3mkB4CbfBiBVn1A4itGAUPCq00m+ebhSlZs5Pd7Lw3k4HJLLOT9347ySFvIsSYNenDU6mt3u5F8FhKMSkAXn8KD7a1o6QvXI3XF5c3oAdvMN8S9mvYH8yW508734/2lGFCvbhqMQbEFuZL5AUBz+v1ejyXuMEJ68MMfE0AxFSz2ZxS+Z2AhmEUQgr5tt1u/1bX59QLZ8vCoObnxHl4qA0D26dvUIx5MCUQd8PwINT52EBFMArFAiqKYQHZYMhBthhSEAWGDESFIQFRYqxB1BgrEAemMIgLUwjEiRkZxI0ZCeQCkxvkCpML5BKTCXKNGQrygTGCfGFSQT4xAyDfmARoHDBnoOqNtVtRN9rHifQ6DUuV/6sD9WaOFgOibu8JBveOUQ8YI6SAuIxNe2IJ4lCI4GvaPY45vSs7puCApxSRPN6tVu9cNq2hnI+PY350voUz5avzGHjZEHwOZPd+eWbhVafz5cSwhmRa75D4+OHdIzxAemmMCuKmi51KVK4AICtLK1t4PLJhhEnxvgTBvTDc/2VcY3EjAVJxfKMGQL5RqSCfKCPIF2ooyAcqE+QalQvkEpUb5Ao1EsgFamQQN6oQiBNVGMSFsgJxoKxB1CgSECWKDESFIgVRoMhBtigWkA3q7Ee+CkLZpJSAhcNmnsKhVlu/pHOzgVSCvKjT3p8XGsT2kekEaswqHBDevTJ94WKr1Tph3SGNyrNTQRBgkWw6YNCRCMcM1Haj0fir0rH/K93/TAqFbbOyuPoZ559in8S+UxLTz/rXjdX1PzhESMVXt6s7AAAAAElFTkSuQmCC"));
        this.e.setPadding(iA, iA, iA, iA);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(yu.a(getContext(), 24), yu.a(getContext(), 24));
        layoutParams2.gravity = 17;
        layoutParams2.rightMargin = yu.a(getContext(), 48);
        this.d.addView(this.e, layoutParams2);
        this.e.setOnClickListener(this);
        ImageView imageView2 = new ImageView(getContext());
        this.f = imageView2;
        imageView2.setImageBitmap(gw.a("iVBORw0KGgoAAAANSUhEUgAAACQAAAA+CAYAAABDTbllAAAAAXNSR0IArs4c6QAAAERlWElmTU0AKgAAAAgAAYdpAAQAAAABAAAAGgAAAAAAA6ABAAMAAAABAAEAAKACAAQAAAABAAAAJKADAAQAAAABAAAAPgAAAAAAXmzfAAACY0lEQVRoBeXZvW/TQBQA8Hd2hEjFAkIpatWNrbhIhLFDxMLE1I0RVa3UP6ELWdgZUIe2Mxv/AWJFAgIqbrdsoUKoVZdW/SC1j3tuazmpnfjjvXeVeJIl31m+9/PdWfJLAG5YqKRn1mu+BKUWtIZjt+as+T++fE5elziPQY/mnq6GWr9JJA2VguWdn53NRB/7qYMZ2u22o0GvDmVzzEytz841F4f6WZsujt7v9++cnJ2/TsmEM/ii8WBqd+/P7+8p18m7IlCv1/vbmJx+bkafSckgioqWDBHOLf0KFOyngLBLSS1fvKkxq+c1vUDBJ9BwH9spoc1GX+Lc6AMgBNhGXQPZRqWCbKIyQbZQI0E2UGNB0qhcIElUbpAUqhBIAlUYxI0qBeJElQZxoSqBOFCVQdQoEhAligxEhSIFUaDIQVVRLKAqKDZQWRQrqAyKHZQTFbo1dx5/S4jrMryRK3y/47sano2o+5zgPFzB/CKgiwet/1IadrMe2tR7E2Igz5u/G6iTjxrgcRYItP4gArrCmGr4SRbGzM7Gjt95zw7Kidnc3vq2fIVle8sKYJaUMrvrMlhAZTFoIgdVwZCDqmJIQRQYMhAVhgREiakMosZUAnFgSoO4MKVAnJjCIG5MIZAEJjdICpMLJIkZC5LGjATZwGSCbGFSQTYx10C2MQOgm4BBUFwohup0bUypgtXBwAc5DkAd0Td1q9W6vXdwdKi1rqUlMHWTCAZzRzNUr9fjMmQYJInB3NG/0t1uN2hMTj007YFSVxqDoHiJXLi3EjgHhxDCguk/Nse77a2vb5NFHN7w38U/+VL4Ter/OVkAAAAASUVORK5CYII="));
        this.f.setPadding(iA, iA, iA, iA);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(yu.a(getContext(), 24), yu.a(getContext(), 24));
        layoutParams3.gravity = 17;
        layoutParams3.leftMargin = yu.a(getContext(), 48);
        this.d.addView(this.f, layoutParams3);
        this.f.setOnClickListener(this);
    }

    /* compiled from: A */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (u50.this.h) {
                if (u50.this.g != null) {
                    u50.this.g.i();
                }
                u50.this.b();
            }
        }
    }

    public u50(Context context, km kmVar) {
        super(context);
        this.a = 3000;
        this.b = 200;
        this.i = new a();
        this.c = kmVar;
        setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        setBackgroundColor(0);
        setVisibility(8);
        c();
    }

    public void d() {
        a();
        if (this.h) {
            return;
        }
        km kmVar = this.c;
        if (kmVar == null || kmVar.canGoBack() || this.c.canGoForward()) {
            if (getVisibility() != 0) {
                setVisibility(0);
            }
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.d, "translationY", yu.a(getContext(), 44), 0.0f);
            objectAnimatorOfFloat.setDuration(200L);
            objectAnimatorOfFloat.start();
            b bVar = this.g;
            if (bVar != null) {
                bVar.j();
            }
            this.h = true;
            e();
        }
    }

    public void e() {
        km kmVar = this.c;
        if (kmVar == null) {
            return;
        }
        this.e.setAlpha(kmVar.canGoBack() ? 1.0f : 0.5f);
        this.f.setAlpha(this.c.canGoForward() ? 1.0f : 0.5f);
        a();
    }

    public void b() {
        if (this.h) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.d, "translationY", 0.0f, yu.a(getContext(), 44));
            objectAnimatorOfFloat.setDuration(200L);
            objectAnimatorOfFloat.start();
            b bVar = this.g;
            if (bVar != null) {
                bVar.i();
            }
            this.h = false;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.e) {
            b bVar = this.g;
            if (bVar != null) {
                bVar.k();
            }
            km kmVar = this.c;
            if (kmVar != null && kmVar.canGoBack()) {
                this.c.goBack();
            }
        } else if (view == this.f) {
            b bVar2 = this.g;
            if (bVar2 != null) {
                bVar2.l();
            }
            km kmVar2 = this.c;
            if (kmVar2 != null && kmVar2.canGoForward()) {
                this.c.goForward();
            }
        }
        e();
    }

    private void a() {
        xo.e(this.i);
        xo.a(this.i, this.a);
    }

    public void a(b bVar) {
        this.g = bVar;
    }
}
