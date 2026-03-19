package com.baidu.mobads.container.nativecpu;

import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.TextView;
import androidx.core.internal.view.SupportMenu;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class ae implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ t b;

    ae(t tVar, int i) {
        this.b = tVar;
        this.a = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.b.b == null) {
            return;
        }
        if (this.b.c != null && (this.b.c.getTag() instanceof a)) {
            ((a) this.b.c.getTag()).onImpression(this.b.c);
        }
        View viewFindViewById = this.b.b.findViewById(this.b.j);
        if (viewFindViewById instanceof TextView) {
            TextView textView = (TextView) viewFindViewById;
            textView.setVisibility(0);
            int[] iArr = {3};
            textView.setTextColor(SupportMenu.CATEGORY_MASK);
            UnderlineSpan underlineSpan = new UnderlineSpan();
            af afVar = new af(this, iArr, underlineSpan, textView);
            if (this.a <= 0) {
                SpannableString spannableString = new SpannableString("已为你解锁下一章");
                spannableString.setSpan(underlineSpan, 0, spannableString.length(), 17);
                textView.setText(spannableString);
            } else {
                SpannableString spannableString2 = new SpannableString(iArr[0] + "秒后自动解锁下一章");
                spannableString2.setSpan(underlineSpan, 0, spannableString2.length(), 17);
                textView.setText(spannableString2);
                textView.postDelayed(afVar, 1000L);
            }
        }
    }
}
