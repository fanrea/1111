package com.kwad.components.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.kwad.components.core.u.l;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class KsStyledTextButton extends TextView implements e {
    public KsStyledTextButton(Context context) {
        super(context);
    }

    public KsStyledTextButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public KsStyledTextButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public KsStyledTextButton(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    @Override // com.kwad.components.core.widget.e
    public final void a(f fVar) {
        l.b(fVar, getBackground());
    }
}
