package com.qq.e.comm.plugin;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.GravityCompat;
import com.google.android.material.badge.BadgeDrawable;
import org.json.JSONException;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class k00 {
    private volatile int a;
    private final ViewGroup b;
    private final mh c;
    private final Context d;
    private ImageView e;
    private ImageView f;
    private ImageView g;
    private TextView h;
    private final String i;
    private final f5 j;
    private final d k;

    /* compiled from: A */
    public interface d {
        void m();

        void s();
    }

    public k00(ViewGroup viewGroup, mh mhVar, String str, f5 f5Var, d dVar) {
        this.a = 1;
        this.d = viewGroup.getContext();
        this.b = viewGroup;
        this.i = str;
        this.c = mhVar;
        this.a = 2;
        this.j = f5Var;
        this.k = dVar;
    }

    void i() {
        this.a = 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        ImageView imageView = this.g;
        if (imageView == null) {
            ImageView imageView2 = new ImageView(this.d);
            this.g = imageView2;
            imageView2.setId(4);
            q1.a(this.g);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(pz.b, pz.a);
            layoutParams.gravity = BadgeDrawable.BOTTOM_END;
            this.b.addView(this.g, layoutParams);
            return;
        }
        imageView.bringToFront();
    }

    boolean d() {
        return this.a == 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b() {
        mh mhVar = this.c;
        if (mhVar == null) {
            return false;
        }
        mhVar.r().bringToFront();
        this.c.play();
        return true;
    }

    /* compiled from: A */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (k00.this.k != null) {
                k00.this.k.m();
            }
        }
    }

    public void e() throws JSONException {
        a();
        g();
        f();
        h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() throws JSONException {
        ImageView imageView = this.f;
        if (imageView == null) {
            ImageView imageViewA = j00.a(this.d);
            this.f = imageViewA;
            imageViewA.setOnClickListener(new a());
            this.b.getWidth();
            f00.a(this.j, this.b.getWidth(), this.b.getHeight());
            int iRound = this.b.isShown() ? Math.round(this.b.getWidth() * 0.3f) : yu.a(this.d, 30);
            int iA = (iRound - yu.a(this.d, 18)) / 2;
            if (iA < 0) {
                iA = 0;
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iRound, iRound);
            this.f.setPadding(iA, iA, iA, iA);
            layoutParams.gravity = GravityCompat.END;
            this.b.addView(this.f, layoutParams);
            return;
        }
        imageView.bringToFront();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        TextView textView = this.h;
        if (textView == null) {
            TextView textView2 = new TextView(this.d);
            this.h = textView2;
            textView2.setText("了解详情");
            this.h.setEllipsize(TextUtils.TruncateAt.END);
            this.h.setMaxLines(1);
            this.h.setTextColor(-1);
            this.h.setTextSize(2, 16.0f);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
            this.h.setGravity(17);
            this.h.setBackgroundColor(Integer.MIN_VALUE);
            this.h.setAlpha(0.0f);
            this.b.addView(this.h, layoutParams);
        } else {
            textView.bringToFront();
        }
        this.h.animate().alpha(1.0f).setDuration(200L).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() throws JSONException {
        ImageView imageView = new ImageView(this.d);
        this.e = imageView;
        this.b.addView(imageView, new FrameLayout.LayoutParams(-1, -1));
        mm.a().a(this.i, this.e);
    }

    /* compiled from: A */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (k00.this.k != null) {
                k00.this.k.s();
            }
        }
    }

    public void j() {
        this.b.setOnClickListener(new b());
        this.b.post(new c());
        this.a = 4;
    }

    /* compiled from: A */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() throws JSONException {
            if (!k00.this.b()) {
                k00.this.a();
                k00.this.g();
            }
            k00.this.h();
            k00.this.f();
        }
    }

    public Bitmap c() {
        ImageView imageView = this.e;
        if (imageView != null) {
            return imageView.getDrawingCache();
        }
        return null;
    }
}
