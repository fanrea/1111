package com.tk.core.component.d;

import android.R;
import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.text.TextUtils;
import android.widget.ProgressBar;
import com.kuaishou.tk.export.NativeModuleInitParams;
import com.tk.core.component.e;
import com.tk.core.o.o;
import com.tk.core.o.r;

@Deprecated
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class a extends e<ProgressBar> {
    private int aeg;
    private String aeh;
    public String aei;
    String aej;
    float aek;
    public double ael;
    public boolean aem;

    @Override // com.tk.core.component.e
    public final boolean mJ() {
        return false;
    }

    public a(NativeModuleInitParams nativeModuleInitParams) {
        super(nativeModuleInitParams);
        this.aeg = 0;
        this.aeh = null;
        this.aek = 0.0f;
        try {
            Object[] objArr = nativeModuleInitParams.args;
            if (objArr == null || objArr.length <= 0 || !(objArr[0] instanceof String)) {
                return;
            }
            String str = (String) objArr[0];
            this.aeh = str;
            this.aeg = cj(str);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private Drawable ci(String str) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(this.aek);
        ClipDrawable clipDrawable = new ClipDrawable(gradientDrawable, 3, 1);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setCornerRadius(this.aek);
        if (!TextUtils.isEmpty(str)) {
            gradientDrawable2.setColor(r.a(str, pP()));
        }
        return new LayerDrawable(new Drawable[]{gradientDrawable2, clipDrawable});
    }

    public final void aj(String str) {
        this.aei = str;
        a(getView(), this.aei);
    }

    public final void setIndeterminate(boolean z) {
        getView().setIndeterminate(z);
        a(z, ci(this.aej));
    }

    @Override // com.tk.core.component.e
    public final void A(Object obj) {
        if (obj instanceof String) {
            this.aej = (String) obj;
            a(getView().isIndeterminate(), ci(this.aej));
        }
    }

    public final void setCornerRadius(float f) {
        this.aek = o.P(f);
        a(getView().isIndeterminate(), ci(this.aej));
    }

    private void a(boolean z, Drawable drawable) {
        if (z) {
            getView().setIndeterminateDrawable(drawable);
        } else {
            getView().setProgressDrawable(drawable);
        }
    }

    public final void i(double d) {
        getView().setProgress((int) (d * 1000.0d));
    }

    public final void as(boolean z) {
        if (z) {
            getView().setVisibility(0);
        } else {
            getView().setVisibility(8);
        }
    }

    private void a(ProgressBar progressBar, String str) {
        Drawable progressDrawable;
        if (progressBar.isIndeterminate()) {
            progressDrawable = progressBar.getIndeterminateDrawable();
        } else {
            progressDrawable = progressBar.getProgressDrawable();
        }
        if (progressDrawable == null) {
            progressDrawable = ci(this.aej);
            a(getView().isIndeterminate(), progressDrawable);
        }
        if (progressDrawable instanceof LayerDrawable) {
            Drawable drawable = ((LayerDrawable) progressDrawable).getDrawable(r2.getNumberOfLayers() - 1);
            int iA = r.a(str, pP());
            if (iA != 0) {
                drawable.setColorFilter(iA, PorterDuff.Mode.SRC_IN);
            } else {
                drawable.clearColorFilter();
            }
        }
    }

    private static int cj(String str) throws Exception {
        if (str == null) {
            throw new Exception("ProgressBar needs to have a style, null received");
        }
        if (str.equals("Horizontal")) {
            return R.attr.progressBarStyleHorizontal;
        }
        if (str.equals("Small")) {
            return R.attr.progressBarStyleSmall;
        }
        if (str.equals("Large")) {
            return R.attr.progressBarStyleLarge;
        }
        if (str.equals("Inverse")) {
            return R.attr.progressBarStyleInverse;
        }
        if (str.equals("SmallInverse")) {
            return R.attr.progressBarStyleSmallInverse;
        }
        if (str.equals("LargeInverse")) {
            return R.attr.progressBarStyleLargeInverse;
        }
        if (str.equals("Normal")) {
            return R.attr.progressBarStyle;
        }
        throw new Exception("Unknown ProgressBar style: " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.tk.core.component.e
    /* renamed from: L, reason: merged with bridge method [inline-methods] */
    public ProgressBar n(Context context) {
        ProgressBar progressBar = new ProgressBar(context, null, this.aeg);
        progressBar.setMax(1000);
        return progressBar;
    }
}
