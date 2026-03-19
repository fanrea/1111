package com.kwad.components.ad.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.kwad.sdk.R;
import com.kwad.sdk.p.m;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class KsAppTagsView extends LinearLayout {
    private int Oy;

    public KsAppTagsView(Context context) {
        super(context);
        this.Oy = 3;
    }

    public KsAppTagsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Oy = 3;
    }

    public KsAppTagsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Oy = 3;
    }

    public KsAppTagsView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.Oy = 3;
    }

    public void setMaxCount(int i) {
        this.Oy = i;
    }

    public void setAppTags(List<String> list) {
        a(list, R.layout.ksad_reward_apk_info_card_tag_item);
    }

    public final void a(List<String> list, int i) {
        if (list == null) {
            return;
        }
        int i2 = 0;
        for (String str : list) {
            i2++;
            if (i2 > this.Oy) {
                return;
            } else {
                a(this, str, i);
            }
        }
    }

    private static void a(LinearLayout linearLayout, String str, int i) {
        TextView textView = (TextView) m.a(linearLayout.getContext(), i, linearLayout, false);
        textView.setText(str);
        linearLayout.addView(textView);
    }
}
