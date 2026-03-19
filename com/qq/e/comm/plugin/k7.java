package com.qq.e.comm.plugin;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class k7 extends LinearLayout {
    private TextView a;
    private TextView b;
    private TextView c;

    public k7(Context context) {
        this(context, -1);
    }

    public k7(Context context, int i) {
        super(context);
        a(context, i);
    }

    public TextView a() {
        return this.a;
    }

    private void a(Context context, int i) {
        setGravity(17);
        TextView textView = new TextView(context);
        this.a = textView;
        textView.setIncludeFontPadding(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 5, 0);
        this.a.setLayoutParams(layoutParams);
        this.a.setTextSize(1, 14.0f);
        this.a.setTextColor(i);
        this.a.setSingleLine();
        TextView textView2 = this.a;
        TextUtils.TruncateAt truncateAt = TextUtils.TruncateAt.END;
        textView2.setEllipsize(truncateAt);
        TextView textView3 = new TextView(context);
        this.c = textView3;
        textView3.setIncludeFontPadding(false);
        this.c.setLayoutParams(new LinearLayout.LayoutParams(yu.a(context, 16), -2));
        this.c.setTextSize(1, 14.0f);
        this.c.setTextColor(i);
        this.c.setSingleLine();
        this.c.setGravity(17);
        TextView textView4 = new TextView(context);
        this.b = textView4;
        textView4.setIncludeFontPadding(false);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(5, 0, 0, 0);
        this.b.setLayoutParams(layoutParams2);
        this.b.setTextSize(1, 14.0f);
        this.b.setTextColor(i);
        this.b.setSingleLine();
        this.b.setEllipsize(truncateAt);
        addView(this.a);
        addView(this.c);
        addView(this.b);
    }

    public void a(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3) {
        this.a.setVisibility(charSequence == null ? 8 : 0);
        this.c.setVisibility(charSequence2 == null ? 8 : 0);
        this.b.setVisibility(charSequence3 != null ? 0 : 8);
        this.a.setText(charSequence);
        if (charSequence2 == null) {
            charSequence2 = "";
        }
        int iA = yu.a(getContext(), charSequence2.length() * 9);
        ViewGroup.LayoutParams layoutParams = this.c.getLayoutParams();
        layoutParams.width = iA;
        this.c.setLayoutParams(layoutParams);
        this.c.setText(charSequence2);
        this.b.setText(charSequence3);
    }

    public void a(String str) {
        this.a.setVisibility(8);
        this.b.setVisibility(8);
        this.c.setText(str);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.c.getLayoutParams();
        layoutParams.width = -2;
        this.c.setLayoutParams(layoutParams);
    }

    public void a(int i) {
        this.a.setTextColor(i);
        this.c.setTextColor(i);
        this.b.setTextColor(i);
    }

    public void a(int i, int i2) {
        float f = i2;
        this.a.setTextSize(i, f);
        this.c.setTextSize(i, f);
        this.b.setTextSize(i, f);
    }

    public void a(CharSequence charSequence) {
        this.c.setText(charSequence);
    }
}
