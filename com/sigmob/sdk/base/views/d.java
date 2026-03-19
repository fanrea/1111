package com.sigmob.sdk.base.views;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.czhj.sdk.common.utils.Dips;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class d extends RelativeLayout {
    private final int a;
    private final int b;
    private final int c;
    private final int d;
    private final int e;
    private final int f;
    private final int g;
    private final int h;
    private Button i;
    private Button j;
    private int k;
    private TextView l;
    private com.sigmob.sdk.videoAd.c m;

    public interface a {
        void a();

        void b();
    }

    public d(final Context context, com.sigmob.sdk.videoAd.c dialogConfig) {
        super(context);
        this.m = dialogConfig;
        this.a = Dips.dipsToIntPixels(10.0f, context);
        int iDipsToIntPixels = Dips.dipsToIntPixels(16.0f, context);
        this.b = iDipsToIntPixels;
        this.c = Dips.dipsToIntPixels(227.0f, context);
        this.f = (int) ((r1 * 16.0f) / 9.0d);
        int iDipsToIntPixels2 = Dips.dipsToIntPixels(25.0f, context);
        this.d = iDipsToIntPixels2;
        this.h = Dips.dipsToIntPixels(25.0f, context);
        this.e = Dips.dipsToIntPixels(100.0f, context);
        this.g = iDipsToIntPixels2 + iDipsToIntPixels;
        setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        e(context);
    }

    private TextView a(Context context) {
        TextView textView = new TextView(context);
        textView.setText(this.m.a());
        textView.setTextColor(-16777216);
        textView.setTextSize(2, 18.0f);
        textView.setGravity(17);
        return textView;
    }

    private TextView b(Context context) {
        TextView textView = new TextView(context);
        this.l = textView;
        textView.setTextColor(-16777216);
        this.l.setTextSize(2, 14.0f);
        this.l.setGravity(17);
        return this.l;
    }

    private Button c(Context context) {
        Button button = new Button(context);
        button.setText(this.m.c());
        button.setTextColor(Color.parseColor("#ff999999"));
        button.setBackgroundColor(0);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, this.b / 2, 0, 0);
        button.setGravity(17);
        button.setTextSize(2, 14.0f);
        button.setLayoutParams(layoutParams);
        return button;
    }

    private Button d(Context context) {
        Button button = new Button(context);
        button.setText(this.m.d());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, this.g);
        int i = this.a;
        layoutParams.setMargins(i * 5, i * 2, i * 5, 0);
        button.setLayoutParams(layoutParams);
        button.setTextColor(-1);
        button.setBackgroundColor(0);
        button.setTextSize(2, 16.0f);
        ab.a(button, r.a, this.g / 2, Color.parseColor("#66000000"), 0, 0, 0);
        return button;
    }

    private void e(Context context) {
        RelativeLayout relativeLayout = new RelativeLayout(context);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.d);
        int i = this.b;
        layoutParams.setMargins(i, this.a * 2, i, 0);
        linearLayout.addView(a(context), layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, this.h);
        int i2 = this.b;
        layoutParams2.setMargins(i2, this.a, i2, 0);
        linearLayout.addView(b(context), layoutParams2);
        ab.a(linearLayout, Color.parseColor("#FFFFFF"), this.a, Color.parseColor("#66000000"), 0, 0, 0);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(this.f, this.c);
        int i3 = this.b;
        layoutParams3.setMargins(i3, 0, i3, 0);
        layoutParams3.addRule(13);
        relativeLayout.setLayoutParams(layoutParams3);
        relativeLayout.addView(linearLayout, new RelativeLayout.LayoutParams(-1, -1));
        Button buttonD = d(context);
        this.j = buttonD;
        linearLayout.addView(buttonD);
        Button buttonC = c(context);
        this.i = buttonC;
        linearLayout.addView(buttonC);
        linearLayout.setGravity(17);
        addView(relativeLayout);
    }

    public void setDialogListener(final a listener) {
        Button button = this.i;
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() { // from class: com.sigmob.sdk.base.views.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    listener.a();
                }
            });
        }
        Button button2 = this.j;
        if (button2 != null) {
            button2.setOnClickListener(new View.OnClickListener() { // from class: com.sigmob.sdk.base.views.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    listener.b();
                }
            });
        }
    }

    @Override // android.view.View
    public void setVisibility(int visibility) {
        super.setVisibility(visibility);
    }

    public void setduration(int time) {
        this.k = time;
        TextView textView = this.l;
        if (textView != null) {
            textView.setText(this.m.b().replace("_SEC_", String.valueOf(this.k)));
        }
    }
}
