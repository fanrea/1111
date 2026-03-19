package com.qq.e.comm.plugin;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class up extends LinearLayout {
    private TextView a;
    private View b;
    private String c;
    private boolean d;

    public up(Context context, String str) {
        super(context);
        setOrientation(1);
        setGravity(17);
        this.c = str;
        this.d = false;
        a();
        b();
    }

    private void a() {
        Context context = getContext();
        TextView textView = new TextView(context);
        this.a = textView;
        textView.setText(this.c);
        this.a.setTextSize(2, 16.0f);
        this.a.setTypeface(Typeface.defaultFromStyle(1));
        addView(this.a, new LinearLayout.LayoutParams(-2, -2));
        this.b = new View(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(yu.a(context, 20), yu.a(context, 2));
        layoutParams.topMargin = yu.a(context, 4);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-13531652);
        gradientDrawable.setCornerRadius(50.0f);
        this.b.setBackgroundDrawable(gradientDrawable);
        addView(this.b, layoutParams);
    }

    public void b() {
        if (this.d) {
            this.b.setVisibility(0);
            this.a.setTextColor(-13531652);
        } else {
            this.b.setVisibility(8);
            this.a.setTextColor(-6710887);
        }
    }

    public void a(boolean z) {
        this.d = z;
        b();
    }
}
