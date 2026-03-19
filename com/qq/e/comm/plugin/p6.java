package com.qq.e.comm.plugin;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class p6 extends AlertDialog {
    private TextView a;
    private TextView b;

    public p6(Context context) {
        super(context);
    }

    public LinearLayout a(Context context, boolean z, String str, String str2, String str3) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, yu.a(context, 137));
        linearLayout.setBackgroundDrawable(gx.a(yu.a(context, 10), -1, 255));
        linearLayout.setLayoutParams(layoutParams);
        TextView textView = new TextView(context);
        textView.setText(str);
        textView.setTextColor(-16777216);
        textView.setTextSize(16.0f);
        textView.setGravity(17);
        int iA = yu.a(context, 1);
        int i = iA * 10;
        textView.setPadding(i, 0, i, 0);
        double dE = ua.e();
        double d = z ? 0.35d : 0.6d;
        Double.isNaN(dE);
        int i2 = iA * 40;
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(((int) (dE * d)) + i2, -2);
        layoutParams2.bottomMargin = i2;
        layoutParams2.topMargin = i2;
        linearLayout.addView(textView, layoutParams2);
        View textView2 = new TextView(context);
        textView2.setBackgroundColor(Color.parseColor("#ececec"));
        linearLayout.addView(textView2, new LinearLayout.LayoutParams(-1, yu.a(context, 1)));
        LinearLayout linearLayout2 = new LinearLayout(context);
        linearLayout2.setOrientation(0);
        linearLayout.addView(linearLayout2, new LinearLayout.LayoutParams(-1, yu.a(context, 44)));
        if (!TextUtils.isEmpty(str3)) {
            TextView textView3 = new TextView(context);
            this.b = textView3;
            textView3.setText(str3);
            this.b.setTextSize(16.0f);
            this.b.setTextColor(-16777216);
            this.b.setGravity(17);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, yu.a(context, 44));
            layoutParams3.weight = 1.0f;
            linearLayout2.addView(this.b, layoutParams3);
            TextView textView4 = new TextView(context);
            textView4.setBackgroundColor(Color.parseColor("#ececec"));
            linearLayout2.addView(textView4, new LinearLayout.LayoutParams(yu.a(context, 1), -1));
        }
        TextView textView5 = new TextView(context);
        this.a = textView5;
        textView5.setText(str2);
        this.a.setTextSize(16.0f);
        this.a.setTextColor(Color.parseColor("#3185FC"));
        this.a.setGravity(17);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(0, yu.a(context, 44));
        layoutParams4.weight = 1.0f;
        linearLayout2.addView(this.a, layoutParams4);
        return linearLayout;
    }

    public TextView b() {
        return this.a;
    }

    public TextView a() {
        return this.b;
    }
}
