package com.style.widget;

import android.content.Context;
import android.util.DisplayMetrics;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class v extends LinearLayout {
    public static final String a = "lp_close";
    private static final String b = "权限";
    private static final String c = "隐私";
    private static final String d = "功能";
    private double e;
    private double f;
    private int g;
    private boolean h;
    private String i;
    private String j;
    private String k;
    private String l;
    private String m;
    private int n;
    private final Context o;
    private c p;
    private IOAdEventListener q;

    public interface c {
        void a(boolean z);

        void b(boolean z);
    }

    /* synthetic */ v(Context context, w wVar) {
        this(context);
    }

    private v(Context context) {
        super(context);
        this.e = 0.027777777777777776d;
        this.f = 0.0196078431372549d;
        this.g = com.sigmob.sdk.base.utils.l.a;
        this.h = false;
        this.n = 1;
        this.o = context;
    }

    private class b implements IOAdEventListener {
        private b() {
        }

        /* synthetic */ b(v vVar, w wVar) {
            this();
        }

        @Override // com.baidu.mobads.sdk.api.IOAdEventListener
        public void run(IOAdEvent iOAdEvent) {
            if (com.baidu.mobads.container.components.k.b.F.equals(iOAdEvent.getType())) {
                if (v.this.p != null) {
                    v.this.p.b(false);
                }
                if (v.this.q != null) {
                    v.this.q = null;
                }
            }
        }
    }

    public static class a {
        private final v a;

        public a(Context context) {
            this.a = new v(context, null);
        }

        public v a() {
            this.a.a();
            return this.a;
        }

        public a a(String str, String str2, String str3, String str4, String str5) {
            String str6 = "版本 " + str;
            if (str.indexOf("版本") == -1) {
                str = str6;
            }
            this.a.j = str;
            this.a.i = str2;
            this.a.l = str3;
            this.a.k = str4;
            this.a.m = str5;
            return this;
        }

        public a a(double d) {
            this.a.e = d;
            return this;
        }

        public a b(double d) {
            this.a.f = d;
            return this;
        }

        public a a(int i) {
            this.a.g = i;
            return this;
        }

        public a a(boolean z) {
            this.a.h = z;
            return this;
        }

        public a a(c cVar) {
            this.a.p = cVar;
            return this;
        }

        public a b(int i) {
            this.a.n = i;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        TextView textViewA;
        TextView textViewA2;
        TextView textViewA3;
        if (this.n == 1) {
            setOrientation(0);
            textViewA3 = a((LinearLayout) this, d);
            a((LinearLayout) this, this.j);
            a((LinearLayout) this, this.i);
            textViewA = a((LinearLayout) this, c);
            textViewA2 = a((LinearLayout) this, b);
        } else {
            setOrientation(1);
            LinearLayout linearLayout = new LinearLayout(this.o);
            linearLayout.setOrientation(0);
            TextView textViewA4 = a(linearLayout, d);
            a(linearLayout, this.j);
            textViewA = a(linearLayout, c);
            textViewA2 = a(linearLayout, b);
            addView(linearLayout, new LinearLayout.LayoutParams(-2, -2));
            a(this, this.i, a(this.f, this.f * 0.5d));
            textViewA3 = textViewA4;
        }
        textViewA3.setOnClickListener(new w(this));
        textViewA.setOnClickListener(new x(this));
        textViewA2.setOnClickListener(new y(this));
    }

    private TextView a(LinearLayout linearLayout, String str) {
        return a(linearLayout, str, a(this.f));
    }

    private TextView a(LinearLayout linearLayout, String str, LinearLayout.LayoutParams layoutParams) {
        TextView textView = new TextView(this.o);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        double d2 = this.e;
        double d3 = displayMetrics.widthPixels;
        Double.isNaN(d3);
        double d4 = d2 * d3;
        Double.isNaN(displayMetrics.density);
        textView.setText(str);
        textView.setTextColor(this.g);
        textView.setTextSize(1, (int) (d4 / r4));
        linearLayout.addView(textView, layoutParams);
        return textView;
    }

    private LinearLayout.LayoutParams a(double d2) {
        return a(d2, 0.0d);
    }

    private LinearLayout.LayoutParams a(double d2, double d3) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        double d4 = displayMetrics.widthPixels;
        Double.isNaN(d4);
        int i = (int) (d2 * d4);
        double d5 = displayMetrics.widthPixels;
        Double.isNaN(d5);
        int i2 = (int) (d3 * d5);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(i, i2, i, 0);
        layoutParams.gravity = 17;
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context) {
        if (this.p == null) {
            return;
        }
        this.q = new b(this, null);
        com.baidu.mobads.container.landingpage.ad.a(context).a();
        com.baidu.mobads.container.landingpage.ad.a(context).addEventListener(com.baidu.mobads.container.components.k.b.F, this.q);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.o != null && this.q != null) {
            com.baidu.mobads.container.landingpage.ad.a(this.o).b();
            this.q = null;
            this.p = null;
        }
    }
}
