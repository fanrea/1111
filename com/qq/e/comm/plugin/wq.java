package com.qq.e.comm.plugin;

import android.R;
import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qq.e.comm.plugin.s3;
import com.qq.e.comm.plugin.wp;
import java.util.Locale;
import org.json.JSONException;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class wq extends i0 implements wp.b, m {
    private static final String E = "wq";
    static final String F = m10.a("5Y-W5raI6Ieq5Yqo5LiL6L29");
    private boolean A;
    private View.OnClickListener B;
    private final String C;
    private final boolean D;
    private final Context d;
    private final h4 e;
    private final i3 f;
    private final boolean g;
    private final int h;
    private final int i;
    private final int j;
    private final int m;
    private final int n;
    private final int o;
    private final int p;
    private final int q;
    private final int r;
    private final int s;
    private final int t;
    private final int u;
    private final int v;
    private TextView w;
    private TextView x;
    private f20 y;
    private s3.g z;

    private void h() {
        FrameLayout frameLayout = new FrameLayout(this.d);
        Button button = new Button(this.d, null, R.attr.borderlessButtonStyle);
        this.b = button;
        button.setAllCaps(false);
        this.b.setTextSize(1, 14.0f);
        this.b.setTextColor(-1);
        this.b.setTypeface(Typeface.defaultFromStyle(1));
        this.b.setPadding(0, 0, 0, 0);
        this.b.setGravity(17);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(this.q / 2.0f);
        gradientDrawable.setColor(-13531652);
        this.b.setBackgroundDrawable(gradientDrawable);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, this.q);
        layoutParams.gravity = 49;
        frameLayout.addView(this.b, layoutParams);
        if (this.g) {
            TextView textView = new TextView(this.d);
            this.x = textView;
            textView.setText(F);
            this.x.setTextColor(-6710887);
            this.x.setTextSize(1, 14.0f);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, this.p);
            layoutParams2.gravity = 49;
            layoutParams2.setMargins(0, this.r, 0, 0);
            frameLayout.addView(this.x, layoutParams2);
        }
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, this.g ? this.s : this.q);
        layoutParams3.weight = 0.0f;
        addView(frameLayout, layoutParams3);
    }

    private void j() throws JSONException {
        FrameLayout frameLayout = new FrameLayout(this.d);
        fx fxVar = new fx(this.d);
        fxVar.a(this.m);
        int i = this.t;
        frameLayout.addView(fxVar, new FrameLayout.LayoutParams(i, i));
        mm.a().a(this.e.d0(), fxVar);
        LinearLayout linearLayout = new LinearLayout(this.d);
        linearLayout.setOrientation(1);
        TextView textView = new TextView(this.d);
        textView.setText(this.f.a());
        textView.setTextSize(1, 18.0f);
        textView.setMaxLines(2);
        TextUtils.TruncateAt truncateAt = TextUtils.TruncateAt.END;
        textView.setEllipsize(truncateAt);
        textView.setTextColor(-13421773);
        textView.setTypeface(Typeface.defaultFromStyle(1));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        int i2 = this.n;
        layoutParams.setMargins(i2, 0, i2, 0);
        layoutParams.gravity = 51;
        linearLayout.addView(textView, layoutParams);
        TextView textView2 = new TextView(this.d);
        textView2.setText(this.f.b());
        textView2.setTextSize(1, 12.0f);
        textView2.setMaxLines(1);
        textView2.setEllipsize(truncateAt);
        textView2.setTextColor(-6710887);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, this.n);
        int i3 = this.n;
        layoutParams2.setMargins(i3, this.j, i3, 0);
        layoutParams2.gravity = 51;
        linearLayout.addView(textView2, layoutParams2);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams3.setMargins(this.t, 0, this.n, 0);
        layoutParams3.gravity = 51;
        frameLayout.addView(linearLayout, layoutParams3);
        TextView textView3 = new TextView(this.d);
        textView3.setText(String.format(Locale.getDefault(), "版本号  %s", this.f.j()));
        textView3.setTextSize(1, 12.0f);
        textView3.setTextColor(-6710887);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, this.n);
        layoutParams4.setMargins(this.u, 0, this.n, 0);
        layoutParams4.gravity = 83;
        frameLayout.addView(textView3, layoutParams4);
        ImageView imageView = new ImageView(this.d);
        this.a = imageView;
        imageView.setImageBitmap(gw.a("iVBORw0KGgoAAAANSUhEUgAAACAAAAAgCAYAAABzenr0AAAAAXNSR0IArs4c6QAAAWVJREFUWEfN19FtgzAQBmAfC7USmOd2g2zSZgJggmSTqhO0z9hImchXETkIHBvf2ZYojzjy/2FyPgPi4AsOzhf/CzCO42tVVR0A3Oq6Hkqujtb6QwhxMsac27a9PeberIDW+kcI8TYPAkBfCjFNU4eI/TwvIn5LKU9egFLqEwAuy2ABxDrcAgYp5R1zf1B3mZVSPQB0JRCxcC9gvlkCQQkPAnIR1PBdQCqCEx4FcBHccBKAikgJJwNiiNRwFiCEsLW91DUibuo8tpuye4FbousAbjh7BR5hPkRKeDLAfec5vYP9CnzhOds2C+D7t9unT+4dZMBeqeX0DhKAUuepiCiAEh6qDsqhZhfACU9FBAEp4SkILyAnnIt4ApQI5yA2gJLhIQQinqWU12XzWjcTrfXXfHa3HY7V1fa6nlOiv03TvHsB9sPkYs/uizLWUinjFvFijBmCHyaUiUr/JroRlQ505zsc8AdNqnUwkcs5DQAAAABJRU5ErkJggg=="));
        int i4 = this.n;
        FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(i4, i4);
        layoutParams5.gravity = 53;
        frameLayout.addView(this.a, layoutParams5);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-1, this.t);
        layoutParams6.bottomMargin = this.o;
        layoutParams6.weight = 0.0f;
        addView(frameLayout, layoutParams6);
    }

    private void l() {
        FrameLayout frameLayout = new FrameLayout(this.d);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (Build.VERSION.SDK_INT >= 21) {
            spannableStringBuilder.append("隐私协议", new UnderlineSpan(), 33);
            spannableStringBuilder.append((CharSequence) "    ");
            spannableStringBuilder.append("权限详情", new UnderlineSpan(), 33);
            spannableStringBuilder.append((CharSequence) "    ");
            spannableStringBuilder.append("功能介绍", new UnderlineSpan(), 33);
            spannableStringBuilder.append((CharSequence) "    ");
            spannableStringBuilder.append("备案信息", new UnderlineSpan(), 33);
        } else {
            spannableStringBuilder.append((CharSequence) String.format("%s >   %s >   %s >   %s >", "隐私协议", "权限详情", "功能介绍", "备案信息"));
        }
        TextView textViewA = a(spannableStringBuilder);
        this.w = textViewA;
        a(frameLayout, textViewA, 20.0f);
        a(frameLayout, 65.0f);
        a(frameLayout, a(String.format("适用年龄：%s", this.f.i())), 75.0f);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, this.v);
        layoutParams.bottomMargin = this.o;
        layoutParams.weight = 1.0f;
        addView(frameLayout, layoutParams);
    }

    public wq(Context context, sp spVar, h4 h4Var, boolean z, int i, int i2) throws JSONException {
        super(context, spVar);
        this.A = false;
        this.d = context;
        this.e = h4Var;
        this.f = h4Var.o().b();
        String strE = h4Var.o().e();
        this.C = strE;
        this.g = z;
        this.h = i;
        boolean zE = h10.e(i2);
        this.D = zE;
        this.i = (int) yu.a(context, 0.5f);
        this.j = yu.a(context, 4);
        this.m = yu.a(context, 12);
        this.n = yu.a(context, 16);
        this.o = yu.a(context, 20);
        this.p = yu.a(context, 21);
        this.q = yu.a(context, 48);
        this.r = yu.a(context, 64);
        this.s = yu.a(context, 85);
        this.t = yu.a(context, 88);
        this.u = yu.a(context, 104);
        this.v = yu.a(context, 146);
        m();
        if (zE) {
            com.qq.e.comm.plugin.apkmanager.l.e().a(strE, this);
        }
    }

    void m() throws JSONException {
        int i = this.o;
        setPadding(i, i, i, this.n);
        setOrientation(1);
        j();
        l();
        h();
    }

    private void a(FrameLayout frameLayout, float f) {
        View view = new View(this.d);
        view.setBackgroundColor(-1644825);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, this.i);
        layoutParams.gravity = 48;
        layoutParams.setMargins(0, (int) yu.a(this.d, f), 0, 0);
        frameLayout.addView(view, layoutParams);
    }

    @Override // com.qq.e.comm.plugin.i0
    void e() {
        if (this.g) {
            p();
        }
    }

    /* compiled from: A */
    class a implements s3.g {
        a() {
        }

        @Override // com.qq.e.comm.plugin.s3.g
        public boolean d() {
            if (wq.this.y == null || wq.this.A) {
                return false;
            }
            wq.this.y.f();
            return false;
        }

        @Override // com.qq.e.comm.plugin.s3.g
        public boolean h() {
            if (wq.this.y == null) {
                return false;
            }
            wq.this.y.e();
            return false;
        }
    }

    private void p() {
        e(String.format(Locale.getDefault(), sp.n, Integer.valueOf(this.h)));
        this.z = new a();
        s3.b().a(this.z);
        b bVar = new b(this.h * 1000, 1000L);
        this.y = bVar;
        bVar.g();
    }

    /* compiled from: A */
    class b extends f20 {
        b(long j, long j2) {
            super(j, j2);
        }

        @Override // com.qq.e.comm.plugin.f20
        public void a(long j) {
            int iCeil = (int) Math.ceil(j / 1000.0f);
            String unused = wq.E;
            String.format("五要素弹窗倒计时 %ss, %sms", Integer.valueOf(iCeil), Long.valueOf(j));
            wq.this.e(String.format(Locale.getDefault(), sp.n, Integer.valueOf(iCeil)));
        }

        @Override // com.qq.e.comm.plugin.f20
        public void d() {
            String unused = wq.E;
            b10.a(1100927, f5.a(wq.this.e));
            sp spVar = wq.this.c;
            if (spVar == null || !spVar.isShowing()) {
                return;
            }
            wq.this.B.onClick(wq.this.b);
        }
    }

    @Override // com.qq.e.comm.plugin.i0
    void f() {
        f20 f20Var = this.y;
        if (f20Var != null) {
            f20Var.h();
            this.y = null;
        }
        if (this.z != null) {
            s3.b().c(this.z);
            this.z = null;
        }
        if (this.D) {
            com.qq.e.comm.plugin.apkmanager.l.e().b(this.C, this);
        }
    }

    @Override // com.qq.e.comm.plugin.wp.b
    public void k() {
        f20 f20Var = this.y;
        if (f20Var != null) {
            this.A = false;
            f20Var.f();
        }
    }

    @Override // com.qq.e.comm.plugin.wp.b
    public void d() {
        f20 f20Var = this.y;
        if (f20Var != null) {
            this.A = true;
            f20Var.e();
        }
    }

    private void a(FrameLayout frameLayout, TextView textView, float f) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, this.p);
        layoutParams.gravity = 51;
        layoutParams.setMargins(0, (int) yu.a(this.d, f), 0, 0);
        frameLayout.addView(textView, layoutParams);
    }

    @Override // com.qq.e.comm.plugin.m
    public void a(String str, int i, int i2, long j) {
        if (i2 == 100) {
            try {
                if (this.c.isShowing()) {
                    this.c.dismiss();
                    return;
                }
                return;
            } catch (Exception unused) {
                return;
            }
        }
        if (h10.b(i)) {
            e("继续下载");
        } else {
            e(String.format("下载中(%d%%)", Integer.valueOf(i2)));
        }
    }

    @Override // com.qq.e.comm.plugin.i0
    void a(View view) {
        if (view == this.w) {
            vp.a(this.e, this);
        } else if (view == this.x) {
            f();
            this.x.setVisibility(8);
            e("立即下载");
            b10.a(1100928, f5.a(this.e));
        }
    }

    @Override // com.qq.e.comm.plugin.i0
    void a(View.OnClickListener onClickListener) {
        super.a(onClickListener);
        this.B = onClickListener;
        this.w.setOnClickListener(onClickListener);
        if (this.g) {
            this.x.setOnClickListener(onClickListener);
        }
    }

    private TextView a(CharSequence charSequence) {
        TextView textView = new TextView(this.d);
        textView.setText(charSequence);
        textView.setTextColor(-6710887);
        textView.setTextSize(1, 14.0f);
        return textView;
    }
}
