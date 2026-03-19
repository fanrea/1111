package com.qq.e.comm.plugin;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class a4 extends LinearLayout implements y3 {
    private static final String d = "a4";
    private TextView a;
    private final x3 b;
    private boolean c;

    private void d() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, yu.a(getContext(), 80));
        layoutParams.leftMargin = yu.a(getContext(), 16);
        layoutParams.topMargin = yu.a(getContext(), 10);
        layoutParams.bottomMargin = yu.a(getContext(), 4);
        layoutParams.weight = 1.0f;
        addView(linearLayout, layoutParams);
        TextView textView = new TextView(getContext());
        this.a = textView;
        textView.setTextColor(-1);
        this.a.setTextSize(2, 14.0f);
        this.a.setMaxLines(1);
        TextView textView2 = this.a;
        TextUtils.TruncateAt truncateAt = TextUtils.TruncateAt.END;
        textView2.setEllipsize(truncateAt);
        linearLayout.addView(this.a);
        TextView textView3 = new TextView(getContext());
        textView3.setTextColor(Color.parseColor("#99FFFFFF"));
        textView3.setTextSize(2, 12.0f);
        textView3.setText("可获取更多精彩内容");
        textView3.setMaxLines(1);
        textView3.setEllipsize(truncateAt);
        linearLayout.addView(textView3);
    }

    public a4(Context context) {
        super(context);
        setVisibility(8);
        setOnClickListener(new a());
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(yu.a(context, 20));
        gradientDrawable.setColor(Color.parseColor("#9A000000"));
        setBackgroundDrawable(gradientDrawable);
        d();
        c();
        this.b = new z3(this);
    }

    /* compiled from: A */
    class a implements View.OnClickListener {
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String unused = a4.d;
        }

        a() {
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        if (i != 0 || this.c) {
            super.setVisibility(i);
            x3 x3Var = this.b;
            if (x3Var == null || i != 0) {
                return;
            }
            x3Var.a(i == 0);
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (getVisibility() != 0) {
            return;
        }
        this.b.a(i == 0);
    }

    private void c() {
        TextView textView = new TextView(getContext());
        textView.setText("不用了");
        textView.setTextSize(2, 12.0f);
        textView.setGravity(17);
        textView.setTextColor(Color.parseColor("#CCFFFFFF"));
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setStroke(1, Color.parseColor("#80FFFFFF"));
        gradientDrawable.setCornerRadius(yu.a(getContext(), 20));
        textView.setBackgroundDrawable(gradientDrawable);
        textView.setOnClickListener(new b());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(yu.a(getContext(), 60), yu.a(getContext(), 25));
        layoutParams.topMargin = yu.a(getContext(), 15);
        layoutParams.rightMargin = yu.a(getContext(), 12);
        layoutParams.leftMargin = yu.a(getContext(), 12);
        addView(textView, layoutParams);
    }

    /* compiled from: A */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a4.this.e();
        }
    }

    /* compiled from: A */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b50.a(a4.this);
        }
    }

    @Override // com.qq.e.comm.plugin.y3
    public void destroy() {
        post(new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.b.a();
    }

    public void a(h4 h4Var) {
        this.b.a(h4Var);
    }

    @Override // com.qq.e.comm.plugin.y3
    public void a() {
        this.c = true;
    }

    @Override // com.qq.e.comm.plugin.y3
    public void a(String str) {
        this.a.setText(str);
    }
}
