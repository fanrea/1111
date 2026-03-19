package com.kwad.components.ad.widget;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.util.AttributeSet;
import android.widget.TextView;
import com.kwad.components.core.widget.e;
import com.kwad.components.core.widget.f;
import com.kwad.sdk.R;
import com.kwad.sdk.core.d.c;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class KsPriceView extends TextView implements e {
    private static String OA = "¥%s 到手约 ¥%s";
    private static String OB = "¥%s  ¥%s";
    private static String OC = "¥%s";
    private String OD;
    private String OE;
    private boolean OF;
    private a Oz;

    public KsPriceView(Context context) {
        super(context);
        this.Oz = new a();
        A(context);
    }

    public KsPriceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Oz = new a();
        A(context);
    }

    public KsPriceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Oz = new a();
        A(context);
    }

    public KsPriceView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.Oz = new a();
        A(context);
    }

    private void A(Context context) {
        setMaxLines(1);
        this.Oz.OI = context.getResources().getColor(R.color.ksad_reward_main_color);
        this.Oz.OJ = context.getResources().getDimensionPixelSize(R.dimen.ksad_reward_order_price_size);
        this.Oz.OL = context.getResources().getColor(R.color.ksad_reward_original_price);
        this.Oz.OM = context.getResources().getDimensionPixelSize(R.dimen.ksad_reward_order_original_price_size);
        this.Oz.OG = context.getResources().getColor(R.color.ksad_reward_main_color);
        this.Oz.OH = context.getResources().getDimensionPixelSize(R.dimen.ksad_reward_order_price_size);
    }

    public a getConfig() {
        return this.Oz;
    }

    public final void h(String str, String str2) {
        d(str, str2, false);
    }

    public final void d(String str, String str2, boolean z) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return;
        }
        this.OD = str;
        this.OE = str2;
        this.OF = z;
        SpannableString spannableStringA = null;
        if (TextUtils.isEmpty(str2)) {
            this.OE = null;
        }
        if (str != null && str.startsWith("¥")) {
            str = str.replaceFirst("¥", "");
        }
        setTextColor(this.Oz.nU());
        try {
            spannableStringA = a(str, this.OE, z, this.Oz);
        } catch (Exception e) {
            c.printStackTraceOnly(e);
        }
        if (spannableStringA != null) {
            setText(spannableStringA);
        }
    }

    private static SpannableString a(String str, String str2, boolean z, a aVar) {
        String str3;
        if (str2 == null) {
            str3 = String.format(OC, str);
        } else {
            str3 = String.format(z ? OB : OA, str, str2);
        }
        SpannableString spannableString = new SpannableString(str3);
        if (str3.startsWith("¥")) {
            spannableString.setSpan(new ForegroundColorSpan(aVar.nY()), 0, 1, 17);
            spannableString.setSpan(new AbsoluteSizeSpan(aVar.nZ()), 0, 1, 17);
        }
        int iIndexOf = str3.indexOf(str);
        if (iIndexOf < 0) {
            return null;
        }
        int length = str.length() + iIndexOf;
        spannableString.setSpan(new ForegroundColorSpan(aVar.nU()), iIndexOf, length, 18);
        spannableString.setSpan(new AbsoluteSizeSpan(aVar.nW()), iIndexOf, length, 18);
        if (str2 != null) {
            int iLastIndexOf = str3.lastIndexOf(str2) - 1;
            int length2 = str2.length() + 1 + iLastIndexOf;
            spannableString.setSpan(new ForegroundColorSpan(aVar.nV()), iLastIndexOf, length2, 18);
            spannableString.setSpan(new AbsoluteSizeSpan(aVar.nX()), iLastIndexOf, length2, 18);
            spannableString.setSpan(new StrikethroughSpan(), iLastIndexOf, length2, 18);
        }
        return spannableString;
    }

    @Override // com.kwad.components.core.widget.e
    public final void a(f fVar) {
        this.Oz.OI = fVar.wH();
        d(this.OD, this.OE, this.OF);
    }

    public static class a {
        private int OG;
        private int OH;
        private int OI;
        private int OJ;
        private int OL;
        private int OM;

        public final int nU() {
            return this.OI;
        }

        public final int nV() {
            return this.OL;
        }

        public final int nW() {
            return this.OJ;
        }

        public final int nX() {
            return this.OM;
        }

        public final int nY() {
            return this.OG;
        }

        public final int nZ() {
            return this.OH;
        }

        public final a as(int i) {
            this.OH = i;
            return this;
        }

        public final a at(int i) {
            this.OL = i;
            return this;
        }

        public final a au(int i) {
            this.OM = i;
            return this;
        }
    }
}
