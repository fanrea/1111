package com.kwad.components.ct.entry.view;

import android.view.View;
import com.kwad.sdk.api.KsEntryElement;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public interface d extends com.kwad.components.ct.f.b {

    public interface a {
        void q(View view, int i);
    }

    public interface b {
        void onDetachedFromWindow();
    }

    boolean b(com.kwad.components.ct.response.model.a.a aVar);

    void setOnDetachListener(b bVar);

    void setOnFeedClickListener(KsEntryElement.OnFeedClickListener onFeedClickListener);
}
