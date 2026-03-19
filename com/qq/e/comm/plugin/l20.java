package com.qq.e.comm.plugin;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class l20 extends LinearLayout {
    private ImageView a;
    private k7 b;
    private int c;
    private int d;
    private final GradientDrawable e;

    public l20(Context context) {
        super(context);
        this.c = yu.a(getContext(), 2);
        this.d = Color.parseColor("#48FFFFFF");
        this.e = new GradientDrawable();
        a(context);
    }

    public ImageView b() {
        return this.a;
    }

    public k7 a() {
        return this.b;
    }

    public void setWidth(int i) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.width = i;
        setLayoutParams(layoutParams);
    }

    public void c(int i) {
        this.c = i;
        this.e.setStroke(i, this.d);
    }

    private void a(Context context) {
        setGravity(16);
        setPadding(yu.a(context, 10), 0, yu.a(context, 10), 0);
        this.e.setColor(Color.parseColor("#80000000"));
        this.e.setCornerRadius(54.0f);
        this.e.setStroke(this.c, this.d);
        setBackgroundDrawable(this.e);
        k7 k7Var = new k7(context);
        this.b = k7Var;
        addView(k7Var);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.e.setColor(i);
    }

    public void d(int i) {
        this.b.a(i);
    }

    public void b(int i) {
        this.e.setCornerRadius(i);
    }

    public void a(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3) {
        this.b.a(charSequence, charSequence2, charSequence3);
    }

    public void a(int i) {
        this.d = i;
        this.e.setStroke(this.c, i);
    }

    public void a(String str) {
        this.b.a(str);
    }

    public void a(int i, int i2) {
        this.b.a(i, i2);
    }

    public void a(Bitmap bitmap) {
        if (bitmap == null) {
            return;
        }
        if (this.a == null) {
            this.a = new ImageView(getContext());
            int iA = yu.a(getContext(), 16);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(iA, iA);
            layoutParams.rightMargin = yu.a(getContext(), 4);
            this.a.setLayoutParams(layoutParams);
            addView(this.a, 0);
        }
        this.a.setImageBitmap(bitmap);
    }

    public void a(CharSequence charSequence) {
        this.b.a(charSequence);
    }
}
