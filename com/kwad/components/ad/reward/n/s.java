package com.kwad.components.ad.reward.n;

import android.view.ViewGroup;
import android.view.ViewStub;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public abstract class s extends d {
    protected ViewGroup xM;

    public final void a(ViewGroup viewGroup, int i, int i2) {
        if (this.xM != null) {
            return;
        }
        ViewStub viewStub = (ViewStub) viewGroup.findViewById(i);
        if (viewStub != null) {
            this.xM = (ViewGroup) viewStub.inflate();
        } else {
            this.xM = (ViewGroup) viewGroup.findViewById(i2);
        }
    }

    @Override // com.kwad.components.ad.reward.n.d
    public ViewGroup hT() {
        return this.xM;
    }
}
