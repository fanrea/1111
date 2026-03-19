package com.kwad.sdk.api.core;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import com.kwad.sdk.api.loader.Wrapper;

@KsAdSdkDynamicApi
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class BaseSystemFragment extends Fragment {
    @Override // android.app.Fragment
    @KsAdSdkDynamicApi
    public void onAttach(Context context) {
        super.onAttach(Wrapper.wrapContextIfNeed(context));
    }

    @Override // android.app.Fragment
    @KsAdSdkDynamicApi
    public Context getContext() {
        return Wrapper.wrapContextIfNeed(super.getContext());
    }

    @KsAdSdkDynamicApi
    public final Activity getActivity2() {
        return super.getActivity();
    }

    @Override // android.app.Fragment
    @KsAdSdkDynamicApi
    public LayoutInflater onGetLayoutInflater(Bundle bundle) {
        return Wrapper.wrapInflaterIfNeed(super.onGetLayoutInflater(bundle));
    }
}
