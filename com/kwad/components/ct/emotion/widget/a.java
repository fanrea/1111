package com.kwad.components.ct.emotion.widget;

import android.graphics.Bitmap;
import android.graphics.Paint;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.TextView;
import com.kwad.sdk.R;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a {
    private static final Pattern aCC = Pattern.compile("(\\[[^]]*])");
    private static int aCD = R.drawable.ksad_emotion_loading;

    public interface b {
        int DS();

        int DT();

        CharSequence getText();

        int getTextSize();

        View getView();
    }

    private static Matcher b(CharSequence charSequence) {
        return aCC.matcher(charSequence);
    }

    public static synchronized CharSequence a(TextView textView, int i, int i2, boolean z) {
        return a(new C0513a(textView, i, i2), false);
    }

    private static synchronized CharSequence a(b bVar, boolean z) {
        int iCf;
        Bitmap bitmapB;
        if (bVar.getView() == null) {
            com.kwad.sdk.core.d.c.w("EmojiDisplay", "filterEmoji on NULL!");
            return "";
        }
        CharSequence text = bVar.getText();
        int iDS = bVar.DS();
        int iDT = bVar.DT();
        if (text != null && text.length() > 0 && iDS >= 0 && iDT <= text.length()) {
            SpannableStringBuilder spannableStringBuilderValueOf = SpannableStringBuilder.valueOf(text);
            Matcher matcherB = b(text.subSequence(iDS, iDT + iDS));
            int i = 0;
            while (matcherB.find()) {
                String strGroup = matcherB.group();
                if (com.kwad.components.ct.emotion.a.c.DD().bF(strGroup)) {
                    i++;
                    if (i >= 300) {
                        break;
                    }
                    int iStart = matcherB.start() + iDS;
                    int iEnd = matcherB.end() + iDS;
                    com.kwad.components.ct.emotion.widget.b bVar2 = new com.kwad.components.ct.emotion.widget.b();
                    if (z) {
                        iCf = bVar.getTextSize();
                        bitmapB = com.kwad.components.ct.emotion.a.c.DD().bE(strGroup);
                    } else {
                        iCf = cf(bVar.getTextSize());
                        bitmapB = com.kwad.components.ct.emotion.a.c.DD().b(bVar.getView().getContext(), strGroup, aCD);
                    }
                    bVar2.setBounds(0, 0, iCf, iCf);
                    bVar2.setBitmap(bitmapB);
                    spannableStringBuilderValueOf.setSpan(new c(bVar2, strGroup, bVar.getView()), iStart, iEnd, 17);
                }
            }
            return spannableStringBuilderValueOf;
        }
        return text;
    }

    private static int cf(int i) {
        Paint paint = new Paint();
        paint.setTextSize(i);
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        return (int) Math.ceil(fontMetrics.bottom - fontMetrics.top);
    }

    /* renamed from: com.kwad.components.ct.emotion.widget.a$a, reason: collision with other inner class name */
    public static final class C0513a implements b {
        private final TextView arI;
        private final int end;
        private final int start;

        public C0513a(TextView textView, int i, int i2) {
            this.arI = textView;
            this.start = i;
            this.end = i2;
        }

        @Override // com.kwad.components.ct.emotion.widget.a.b
        public final View getView() {
            return this.arI;
        }

        @Override // com.kwad.components.ct.emotion.widget.a.b
        public final CharSequence getText() {
            return this.arI.getText();
        }

        @Override // com.kwad.components.ct.emotion.widget.a.b
        public final int getTextSize() {
            return (int) this.arI.getTextSize();
        }

        @Override // com.kwad.components.ct.emotion.widget.a.b
        public final int DS() {
            return this.start;
        }

        @Override // com.kwad.components.ct.emotion.widget.a.b
        public final int DT() {
            return this.end;
        }
    }
}
