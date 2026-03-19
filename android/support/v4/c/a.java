package android.support.v4.c;

import android.os.Build;
import android.support.v4.d.h;
import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.MetricAffectingSpan;
import com.alipay.sdk.m.u.i;
import java.util.concurrent.Executor;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class a implements Spannable {
    private final Spannable bs;
    private final C0005a bt;
    private final PrecomputedText bu;
    private static final Object sLock = new Object();
    private static Executor br = null;

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
    /* renamed from: android.support.v4.c.a$a, reason: collision with other inner class name */
    public static final class C0005a {
        private final TextPaint bv;
        private final TextDirectionHeuristic bw;
        private final int bx;
        private final int by;
        final PrecomputedText.Params bz;

        /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
        /* renamed from: android.support.v4.c.a$a$a, reason: collision with other inner class name */
        public static class C0006a {
            private final TextPaint bv;
            private TextDirectionHeuristic bw;
            private int bx;
            private int by;

            public C0006a(TextPaint textPaint) {
                this.bv = textPaint;
                if (Build.VERSION.SDK_INT >= 23) {
                    this.bx = 1;
                    this.by = 1;
                } else {
                    this.by = 0;
                    this.bx = 0;
                }
                if (Build.VERSION.SDK_INT >= 18) {
                    this.bw = TextDirectionHeuristics.FIRSTSTRONG_LTR;
                } else {
                    this.bw = null;
                }
            }

            public final C0006a f(int i) {
                this.bx = i;
                return this;
            }

            public final C0006a g(int i) {
                this.by = i;
                return this;
            }

            public final C0006a a(TextDirectionHeuristic textDirectionHeuristic) {
                this.bw = textDirectionHeuristic;
                return this;
            }

            public final C0005a K() {
                return new C0005a(this.bv, this.bw, this.bx, this.by);
            }
        }

        C0005a(TextPaint textPaint, TextDirectionHeuristic textDirectionHeuristic, int i, int i2) {
            if (Build.VERSION.SDK_INT >= 28) {
                this.bz = new PrecomputedText.Params.Builder(textPaint).setBreakStrategy(i).setHyphenationFrequency(i2).setTextDirection(textDirectionHeuristic).build();
            } else {
                this.bz = null;
            }
            this.bv = textPaint;
            this.bw = textDirectionHeuristic;
            this.bx = i;
            this.by = i2;
        }

        public C0005a(PrecomputedText.Params params) {
            this.bv = params.getTextPaint();
            this.bw = params.getTextDirection();
            this.bx = params.getBreakStrategy();
            this.by = params.getHyphenationFrequency();
            this.bz = params;
        }

        public final TextPaint getTextPaint() {
            return this.bv;
        }

        public final TextDirectionHeuristic getTextDirection() {
            return this.bw;
        }

        public final int getBreakStrategy() {
            return this.bx;
        }

        public final int getHyphenationFrequency() {
            return this.by;
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj == null || !(obj instanceof C0005a)) {
                return false;
            }
            C0005a c0005a = (C0005a) obj;
            PrecomputedText.Params params = this.bz;
            if (params != null) {
                return params.equals(c0005a.bz);
            }
            if (Build.VERSION.SDK_INT >= 23 && (this.bx != c0005a.getBreakStrategy() || this.by != c0005a.getHyphenationFrequency())) {
                return false;
            }
            if ((Build.VERSION.SDK_INT >= 18 && this.bw != c0005a.getTextDirection()) || this.bv.getTextSize() != c0005a.getTextPaint().getTextSize() || this.bv.getTextScaleX() != c0005a.getTextPaint().getTextScaleX() || this.bv.getTextSkewX() != c0005a.getTextPaint().getTextSkewX()) {
                return false;
            }
            if ((Build.VERSION.SDK_INT >= 21 && (this.bv.getLetterSpacing() != c0005a.getTextPaint().getLetterSpacing() || !TextUtils.equals(this.bv.getFontFeatureSettings(), c0005a.getTextPaint().getFontFeatureSettings()))) || this.bv.getFlags() != c0005a.getTextPaint().getFlags()) {
                return false;
            }
            if (Build.VERSION.SDK_INT >= 24) {
                if (!this.bv.getTextLocales().equals(c0005a.getTextPaint().getTextLocales())) {
                    return false;
                }
            } else if (Build.VERSION.SDK_INT >= 17 && !this.bv.getTextLocale().equals(c0005a.getTextPaint().getTextLocale())) {
                return false;
            }
            if (this.bv.getTypeface() == null) {
                if (c0005a.getTextPaint().getTypeface() != null) {
                    return false;
                }
            } else if (!this.bv.getTypeface().equals(c0005a.getTextPaint().getTypeface())) {
                return false;
            }
            return true;
        }

        public final int hashCode() {
            if (Build.VERSION.SDK_INT >= 24) {
                return h.hash(Float.valueOf(this.bv.getTextSize()), Float.valueOf(this.bv.getTextScaleX()), Float.valueOf(this.bv.getTextSkewX()), Float.valueOf(this.bv.getLetterSpacing()), Integer.valueOf(this.bv.getFlags()), this.bv.getTextLocales(), this.bv.getTypeface(), Boolean.valueOf(this.bv.isElegantTextHeight()), this.bw, Integer.valueOf(this.bx), Integer.valueOf(this.by));
            }
            if (Build.VERSION.SDK_INT >= 21) {
                return h.hash(Float.valueOf(this.bv.getTextSize()), Float.valueOf(this.bv.getTextScaleX()), Float.valueOf(this.bv.getTextSkewX()), Float.valueOf(this.bv.getLetterSpacing()), Integer.valueOf(this.bv.getFlags()), this.bv.getTextLocale(), this.bv.getTypeface(), Boolean.valueOf(this.bv.isElegantTextHeight()), this.bw, Integer.valueOf(this.bx), Integer.valueOf(this.by));
            }
            if (Build.VERSION.SDK_INT >= 18) {
                return h.hash(Float.valueOf(this.bv.getTextSize()), Float.valueOf(this.bv.getTextScaleX()), Float.valueOf(this.bv.getTextSkewX()), Integer.valueOf(this.bv.getFlags()), this.bv.getTextLocale(), this.bv.getTypeface(), this.bw, Integer.valueOf(this.bx), Integer.valueOf(this.by));
            }
            if (Build.VERSION.SDK_INT >= 17) {
                return h.hash(Float.valueOf(this.bv.getTextSize()), Float.valueOf(this.bv.getTextScaleX()), Float.valueOf(this.bv.getTextSkewX()), Integer.valueOf(this.bv.getFlags()), this.bv.getTextLocale(), this.bv.getTypeface(), this.bw, Integer.valueOf(this.bx), Integer.valueOf(this.by));
            }
            return h.hash(Float.valueOf(this.bv.getTextSize()), Float.valueOf(this.bv.getTextScaleX()), Float.valueOf(this.bv.getTextSkewX()), Integer.valueOf(this.bv.getFlags()), this.bv.getTypeface(), this.bw, Integer.valueOf(this.bx), Integer.valueOf(this.by));
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("{");
            sb.append("textSize=" + this.bv.getTextSize());
            sb.append(", textScaleX=" + this.bv.getTextScaleX());
            sb.append(", textSkewX=" + this.bv.getTextSkewX());
            if (Build.VERSION.SDK_INT >= 21) {
                sb.append(", letterSpacing=" + this.bv.getLetterSpacing());
                sb.append(", elegantTextHeight=" + this.bv.isElegantTextHeight());
            }
            if (Build.VERSION.SDK_INT >= 24) {
                sb.append(", textLocale=" + this.bv.getTextLocales());
            } else if (Build.VERSION.SDK_INT >= 17) {
                sb.append(", textLocale=" + this.bv.getTextLocale());
            }
            sb.append(", typeface=" + this.bv.getTypeface());
            if (Build.VERSION.SDK_INT >= 26) {
                sb.append(", variationSettings=" + this.bv.getFontVariationSettings());
            }
            sb.append(", textDir=" + this.bw);
            sb.append(", breakStrategy=" + this.bx);
            sb.append(", hyphenationFrequency=" + this.by);
            sb.append(i.d);
            return sb.toString();
        }
    }

    public final PrecomputedText I() {
        Spannable spannable = this.bs;
        if (spannable instanceof PrecomputedText) {
            return (PrecomputedText) spannable;
        }
        return null;
    }

    public final C0005a J() {
        return this.bt;
    }

    @Override // android.text.Spannable
    public final void setSpan(Object obj, int i, int i2, int i3) {
        if (obj instanceof MetricAffectingSpan) {
            throw new IllegalArgumentException("MetricAffectingSpan can not be set to PrecomputedText.");
        }
        if (Build.VERSION.SDK_INT >= 28) {
            this.bu.setSpan(obj, i, i2, i3);
        } else {
            this.bs.setSpan(obj, i, i2, i3);
        }
    }

    @Override // android.text.Spannable
    public final void removeSpan(Object obj) {
        if (obj instanceof MetricAffectingSpan) {
            throw new IllegalArgumentException("MetricAffectingSpan can not be removed from PrecomputedText.");
        }
        if (Build.VERSION.SDK_INT >= 28) {
            this.bu.removeSpan(obj);
        } else {
            this.bs.removeSpan(obj);
        }
    }

    @Override // android.text.Spanned
    public final <T> T[] getSpans(int i, int i2, Class<T> cls) {
        if (Build.VERSION.SDK_INT >= 28) {
            return (T[]) this.bu.getSpans(i, i2, cls);
        }
        return (T[]) this.bs.getSpans(i, i2, cls);
    }

    @Override // android.text.Spanned
    public final int getSpanStart(Object obj) {
        return this.bs.getSpanStart(obj);
    }

    @Override // android.text.Spanned
    public final int getSpanEnd(Object obj) {
        return this.bs.getSpanEnd(obj);
    }

    @Override // android.text.Spanned
    public final int getSpanFlags(Object obj) {
        return this.bs.getSpanFlags(obj);
    }

    @Override // android.text.Spanned
    public final int nextSpanTransition(int i, int i2, Class cls) {
        return this.bs.nextSpanTransition(i, i2, cls);
    }

    @Override // java.lang.CharSequence
    public final int length() {
        return this.bs.length();
    }

    @Override // java.lang.CharSequence
    public final char charAt(int i) {
        return this.bs.charAt(i);
    }

    @Override // java.lang.CharSequence
    public final CharSequence subSequence(int i, int i2) {
        return this.bs.subSequence(i, i2);
    }

    @Override // java.lang.CharSequence
    public final String toString() {
        return this.bs.toString();
    }
}
