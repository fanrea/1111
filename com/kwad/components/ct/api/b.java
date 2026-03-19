package com.kwad.components.ct.api;

import android.content.Context;
import com.kwad.sdk.api.KsEntryElement;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public interface b extends com.kwad.sdk.components.b {
    void aF(Context context);

    void loadEntryElement(KsScene ksScene, KsLoadManager.EntryElementListener<KsEntryElement> entryElementListener, boolean z);

    com.kwad.components.ct.response.model.cached.a wY();

    void wZ();
}
