package com.fc.tjcpl.sdk.view;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.fc.tjcpl.sdk.n.i0;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class ViewWebLoading extends RelativeLayout {
    public Context a;
    public RelativeLayout b;
    public GifView c;
    public LinearLayout d;
    public LinearLayout e;
    public i0 f;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ViewWebLoading.this.b();
            i0 i0Var = ViewWebLoading.this.f;
            if (i0Var != null) {
                ((CustomViewContent) i0Var).b.reload();
            }
        }
    }

    public ViewWebLoading(Context context) {
        super(context);
        this.a = context;
        a();
    }

    public final void a() {
        int iA = com.fc.tjcpl.sdk.b.a.a(this.a.getApplicationContext(), 20.0f);
        this.b = new RelativeLayout(this.a);
        LinearLayout linearLayout = new LinearLayout(this.a);
        this.d = linearLayout;
        linearLayout.setGravity(1);
        this.d.setOrientation(1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.setMargins(0, (int) (this.a.getResources().getDisplayMetrics().heightPixels * 0.333d), 0, 0);
        this.b.addView(this.d, layoutParams);
        GifView gifView = new GifView(this.a);
        this.c = gifView;
        this.d.addView(gifView, new LinearLayout.LayoutParams(-2, -2));
        this.c.setMovieResource(com.fc.tjcpl.sdk.b.a.a(this.a.getApplicationContext(), "raw", "tj_loading"));
        LinearLayout linearLayout2 = new LinearLayout(this.a);
        this.e = linearLayout2;
        linearLayout2.setGravity(1);
        this.e.setOrientation(1);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(14);
        layoutParams2.setMargins(0, com.fc.tjcpl.sdk.b.a.a(this.a.getApplicationContext(), 175.0f), 0, 0);
        this.b.addView(this.e, layoutParams2);
        ImageView imageView = new ImageView(this.a);
        imageView.setImageResource(com.fc.tjcpl.sdk.b.a.a(this.a.getApplicationContext(), "drawable", "tj_web_error"));
        this.e.addView(imageView, new LinearLayout.LayoutParams(-2, -2));
        TextView textView = new TextView(this.a);
        textView.setText("断网了~请检查网络状态！");
        textView.setTextSize(13.0f);
        textView.setTextColor(Color.rgb(153, 153, 153));
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.setMargins(0, iA, 0, 0);
        this.e.addView(textView, layoutParams3);
        int iA2 = com.fc.tjcpl.sdk.b.a.a(this.a.getApplicationContext(), 30.0f);
        int iA3 = com.fc.tjcpl.sdk.b.a.a(this.a.getApplicationContext(), 120.0f);
        TextView textView2 = new TextView(this.a);
        textView2.setText("立即刷新");
        textView2.setTextSize(12.0f);
        textView2.setTextColor(-1);
        textView2.setGravity(17);
        textView2.setBackgroundResource(com.fc.tjcpl.sdk.b.a.a(this.a.getApplicationContext(), "drawable", "tj_web_refresh_bg"));
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(iA3, iA2);
        layoutParams4.setMargins(0, iA, 0, 0);
        this.e.addView(textView2, layoutParams4);
        textView2.setOnClickListener(new a());
        addView(this.b, new RelativeLayout.LayoutParams(-1, -1));
    }

    public void b() {
        setVisibility(0);
        this.b.setBackgroundColor(0);
        this.d.setVisibility(0);
        this.c.setVisibility(0);
        this.e.setVisibility(8);
    }

    public void setWebListener(i0 i0Var) {
        this.f = i0Var;
    }
}
