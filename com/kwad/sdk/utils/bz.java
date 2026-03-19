package com.kwad.sdk.utils;

import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class bz {
    private View coj;
    public Point coi = new Point();
    public Rect cog = new Rect();
    public Rect coh = new Rect();

    public bz(View view) {
        this.coj = view;
    }

    public final boolean aqr() {
        boolean globalVisibleRect = this.coj.getGlobalVisibleRect(this.cog, this.coi);
        if (this.coi.x == 0 && this.coi.y == 0 && this.cog.height() == this.coj.getHeight() && this.coh.height() != 0 && Math.abs(this.cog.top - this.coh.top) > this.coj.getHeight() / 2) {
            this.cog.set(this.coh);
        }
        this.coh.set(this.cog);
        return globalVisibleRect;
    }
}
