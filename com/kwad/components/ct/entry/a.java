package com.kwad.components.ct.entry;

import android.content.Context;
import android.content.Intent;
import com.kwad.sdk.api.KsEntryElement;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.components.e;
import com.kwad.sdk.utils.ad;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a extends e implements com.kwad.components.ct.api.b {
    @Override // com.kwad.sdk.components.b
    public final void init(Context context) {
    }

    @Override // com.kwad.sdk.components.b
    public final Class getComponentsType() {
        return com.kwad.components.ct.api.b.class;
    }

    @Override // com.kwad.components.ct.api.b
    public final void loadEntryElement(KsScene ksScene, KsLoadManager.EntryElementListener<KsEntryElement> entryElementListener, boolean z) {
        c.loadEntryElement(ksScene, entryElementListener, z);
    }

    @Override // com.kwad.components.ct.api.b
    public final void aF(Context context) {
        ad.dq(context).i(new Intent("action_refresh_entry"));
    }

    @Override // com.kwad.components.ct.api.b
    public final void wZ() {
        b.DV();
    }

    @Override // com.kwad.components.ct.api.b
    public final com.kwad.components.ct.response.model.cached.a wY() {
        return b.wY();
    }
}
