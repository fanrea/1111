package com.kwad.components.ct.hotspot.hometab;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.R;
import com.kwad.components.core.proxy.i;
import com.kwad.components.core.u.e;
import com.kwad.sdk.api.proxy.app.BaseFragmentActivity;
import com.kwad.sdk.service.ServiceProvider;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class a extends i {
    @Override // com.kwad.components.core.proxy.i
    public String getPageName() {
        return "HomeTabActivity";
    }

    public static void init() {
        com.kwad.sdk.service.c.g(BaseFragmentActivity.KsTrendsActivity.class, a.class);
    }

    public static void a(Context context, HomeTabParam homeTabParam) {
        Intent intent = new Intent(context, (Class<?>) BaseFragmentActivity.KsTrendsActivity.class);
        intent.putExtra("KEY_HOME_TAB_PARAM", homeTabParam);
        context.startActivity(intent);
    }

    @Override // com.kwad.components.core.proxy.i, com.kwad.sdk.api.proxy.IActivityProxy
    public void onCreate(Bundle bundle) {
        try {
            super.onCreate(bundle);
            getActivity().setTheme(R.style.Theme_AppCompat_NoActionBar);
            setContentView(com.kwad.sdk.R.layout.ksad_activity_home_tab);
            e.a(getActivity(), 0, false);
            EP();
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private void EP() {
        b bVar = new b();
        bVar.setArguments(getIntent().getExtras());
        getSupportFragmentManager().beginTransaction().replace(com.kwad.sdk.R.id.ksad_fragment_container, bVar).commitAllowingStateLoss();
    }
}
