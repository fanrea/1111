package com.qq.e.comm.plugin;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qq.e.comm.plugin.fq;
import org.json.JSONException;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class gq extends RelativeLayout implements ek {
    private h4 a;
    private TextView b;
    private View c;
    private ImageView d;
    private int e;
    private View f;
    private boolean g;

    @Override // com.qq.e.comm.plugin.ek
    public View a() {
        return this;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        r5 r5VarD = u2.a().d(this);
        if (r5VarD != null) {
            r5VarD.a(motionEvent, false);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.qq.e.comm.plugin.ek
    public void loadUrl(String str) {
    }

    private ImageView d(Context context) throws JSONException {
        ImageView imageView = new ImageView(context);
        imageView.setId(4);
        int iA = yu.a(context, 50);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(iA, iA));
        mm.a().a(this.a.d0(), imageView);
        return imageView;
    }

    public gq(Context context, h4 h4Var) throws JSONException {
        super(context);
        if (h4Var == null) {
            return;
        }
        this.a = h4Var;
        dismiss();
        a(context);
        LinearLayout linearLayoutC = c(context);
        addView(linearLayoutC);
        linearLayoutC.measure(0, 0);
        this.e = linearLayoutC.getMeasuredHeight();
        addOnLayoutChangeListener(new a(linearLayoutC));
    }

    /* compiled from: A */
    class a implements View.OnLayoutChangeListener {
        final /* synthetic */ LinearLayout a;

        a(LinearLayout linearLayout) {
            this.a = linearLayout;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            if (gq.this.getHeight() < gq.this.e) {
                if (gq.this.g) {
                    return;
                }
                gq.this.g = true;
                this.a.removeAllViews();
                this.a.addView(gq.this.f);
                return;
            }
            if (gq.this.g) {
                gq.this.g = false;
                this.a.addView(gq.this.b);
                this.a.addView(gq.this.d);
                this.a.addView(gq.this.c);
            }
        }
    }

    private LinearLayout c(Context context) throws JSONException {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setId(5);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(17);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        linearLayout.setLayoutParams(layoutParams);
        ImageView imageViewD = d(context);
        this.f = imageViewD;
        linearLayout.addView(imageViewD);
        TextView textViewE = e(context);
        this.b = textViewE;
        linearLayout.addView(textViewE);
        this.d = a(context, linearLayout);
        if (this.a.k1()) {
            linearLayout.addView(this.d);
        }
        View viewB = b(context);
        this.c = viewB;
        linearLayout.addView(viewB);
        return linearLayout;
    }

    private View b(Context context) {
        TextView textView = new TextView(context);
        textView.setId(2);
        String strC = this.a.C();
        if (TextUtils.isEmpty(strC)) {
            strC = this.a.k1() ? "下载应用" : "了解详情";
        }
        textView.setText(strC);
        textView.setTextSize(1, 14.0f);
        textView.setTextColor(-1);
        textView.setGravity(17);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(yu.a(context, 120), yu.a(context, 36));
        layoutParams.topMargin = yu.a(context, 8);
        textView.setLayoutParams(layoutParams);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#3185FC"));
        gradientDrawable.setCornerRadius(yu.a(context, 25));
        textView.setBackgroundDrawable(gradientDrawable);
        return textView;
    }

    private TextView e(Context context) {
        String strR0;
        l3 l3VarO;
        TextView textView = new TextView(context);
        textView.setId(1);
        textView.setTextColor(-1);
        textView.setTextSize(1, 12.0f);
        textView.setSingleLine();
        textView.setEllipsize(TextUtils.TruncateAt.END);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = yu.a(context, 8);
        textView.setLayoutParams(layoutParams);
        if (this.a.k1() && (l3VarO = this.a.o()) != null) {
            strR0 = l3VarO.a();
        } else {
            strR0 = this.a.R0();
        }
        textView.setText(strR0);
        return textView;
    }

    @Override // com.qq.e.comm.plugin.ek
    public boolean show() {
        setVisibility(0);
        return true;
    }

    @Override // com.qq.e.comm.plugin.ek
    public void dismiss() {
        setVisibility(4);
    }

    @Override // com.qq.e.comm.plugin.ek
    public void destroy() {
        removeAllViews();
    }

    /* compiled from: A */
    class b implements View.OnClickListener {
        final /* synthetic */ fq.a a;

        b(fq.a aVar) {
            this.a = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.a != null) {
                gq gqVar = gq.this;
                this.a.a(gqVar, u2.a().a(gqVar));
            }
        }
    }

    private void a(Context context) throws JSONException {
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        mm.a().a(this.a.c0(), imageView);
        addView(imageView);
        View view = new View(context);
        view.setBackgroundColor(Color.parseColor("#C0000000"));
        addView(view);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        u2.a().a(this, this.a);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        u2.a().b(this);
    }

    @Override // com.qq.e.comm.plugin.ek
    public void a(fq.a aVar) {
        b bVar = new b(aVar);
        this.c.setOnClickListener(bVar);
        setOnClickListener(bVar);
    }

    private ImageView a(Context context, LinearLayout linearLayout) {
        ImageView imageView = new ImageView(context);
        imageView.setId(3);
        imageView.setImageBitmap(gw.a("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"));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, yu.a(context, 8));
        layoutParams.topMargin = yu.a(context, 4);
        imageView.setLayoutParams(layoutParams);
        return imageView;
    }
}
