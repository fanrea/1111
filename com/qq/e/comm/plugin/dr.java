package com.qq.e.comm.plugin;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.MetricAffectingSpan;
import android.util.Pair;
import android.view.View;
import android.widget.TextView;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class dr extends TextView implements dl {
    private w40 a;
    private boolean b;

    public dr(Context context) {
        super(context);
        getPaint().setAntiAlias(true);
        setIncludeFontPadding(false);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        v40 v40VarV = this.a.v();
        if (v40VarV == null) {
            super.onMeasure(i, i2);
            return;
        }
        if (this.b) {
            i = 0;
        }
        Pair<Integer, Integer> pairB = v40VarV.b(i, i2);
        super.onMeasure(((Integer) pairB.first).intValue(), ((Integer) pairB.second).intValue());
        Pair<Integer, Integer> pairA = v40VarV.a(i, i2);
        if (pairA != null) {
            super.setMeasuredDimension(View.MeasureSpec.getSize(((Integer) pairA.first).intValue()), View.MeasureSpec.getSize(((Integer) pairA.second).intValue()));
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        int width;
        int height;
        w40 w40Var = this.a;
        xj xjVarS = w40Var == null ? null : w40Var.s();
        if (xjVarS != null) {
            width = getWidth();
            height = getHeight();
            xjVarS.a(canvas, width, height);
        } else {
            width = 0;
            height = 0;
        }
        super.draw(canvas);
        if (xjVarS != null) {
            xjVarS.b(canvas, width, height);
        }
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        try {
            super.setText(charSequence, bufferType);
        } catch (IndexOutOfBoundsException unused) {
            a(charSequence, bufferType);
        }
    }

    @Override // android.widget.TextView
    public void setTypeface(Typeface typeface) {
        try {
            super.setTypeface(typeface);
        } catch (IndexOutOfBoundsException unused) {
        }
    }

    private void a(CharSequence charSequence, TextView.BufferType bufferType) {
        if (charSequence instanceof Spanned) {
            Spanned spanned = (Spanned) charSequence;
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(spanned);
            MetricAffectingSpan[] metricAffectingSpanArr = (MetricAffectingSpan[]) spanned.getSpans(0, spanned.length(), MetricAffectingSpan.class);
            if (metricAffectingSpanArr != null && metricAffectingSpanArr.length > 0) {
                for (MetricAffectingSpan metricAffectingSpan : metricAffectingSpanArr) {
                    int spanStart = spannableStringBuilder.getSpanStart(metricAffectingSpan);
                    if (a(spannableStringBuilder, spanStart - 1)) {
                        spannableStringBuilder.insert(spanStart, (CharSequence) " ");
                    }
                    int spanEnd = spannableStringBuilder.getSpanEnd(metricAffectingSpan);
                    if (a(spannableStringBuilder, spanEnd)) {
                        spannableStringBuilder.insert(spanEnd, (CharSequence) " ");
                    }
                }
            }
            super.setText(spannableStringBuilder, bufferType);
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.a.f(i);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onVisibilityChanged(View view, int i) {
        w40 w40Var = this.a;
        if (w40Var != null) {
            w40Var.a(view, i);
        }
    }

    private boolean a(CharSequence charSequence, int i) {
        return i < 0 || i >= charSequence.length() || charSequence.charAt(i) != ' ';
    }

    public void a(boolean z) {
        this.b = z;
    }

    @Override // com.qq.e.comm.plugin.dl
    public void a(w40 w40Var) {
        this.a = w40Var;
    }
}
