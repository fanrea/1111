package com.kwad.components.ct.entry.view;

import android.content.Context;
import android.util.AttributeSet;
import com.kwad.sdk.R;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class EntryScrollGifView extends EntryScrollView {
    @Override // com.kwad.components.ct.entry.view.EntryScrollView
    protected int getAdShowStyle() {
        return 2;
    }

    @Override // com.kwad.components.ct.entry.view.EntryScrollView
    protected boolean getEnableWebp() {
        return true;
    }

    @Override // com.kwad.components.ct.entry.view.EntryScrollView
    protected final float getPageItemWidth$255f285() {
        return 0.65f;
    }

    @Override // com.kwad.components.ct.entry.view.EntryScrollView
    protected float getRatio() {
        return 1.0f;
    }

    public EntryScrollGifView(Context context) {
        super(context);
    }

    public EntryScrollGifView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.kwad.components.ct.entry.view.EntryScrollView
    protected int getItemPlayRes() {
        return R.drawable.ksad_entrybig_play_selector;
    }
}
