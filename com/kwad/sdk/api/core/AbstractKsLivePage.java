package com.kwad.sdk.api.core;

import androidx.fragment.app.Fragment;
import com.kwad.sdk.api.KsContentPage;
import com.kwad.sdk.api.core.fragment.KsFragment;

@KsAdSdkDynamicApi
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public abstract class AbstractKsLivePage implements KsContentPage {
    @KsAdSdkDynamicApi
    protected abstract KsFragment getFragment2();

    @Override // com.kwad.sdk.api.KsContentPage
    @KsAdSdkDynamicApi
    public Fragment getFragment() {
        return getFragment2().getBase();
    }
}
