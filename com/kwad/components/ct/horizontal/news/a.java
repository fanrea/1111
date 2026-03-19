package com.kwad.components.ct.horizontal.news;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.kwad.components.core.proxy.i;
import com.kwad.sdk.R;
import com.kwad.sdk.api.proxy.app.BaseFragmentActivity;
import com.kwad.sdk.service.ServiceProvider;
import java.io.Serializable;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class a extends i {
    private NewsDetailParam aNw;

    @Override // com.kwad.components.core.proxy.i
    public String getPageName() {
        return "NewsDetailActivity";
    }

    public static void init() {
        com.kwad.sdk.service.c.g(BaseFragmentActivity.FragmentActivity8.class, a.class);
    }

    public static void a(Context context, NewsDetailParam newsDetailParam) {
        if (context == null) {
            return;
        }
        com.kwad.sdk.service.c.g(BaseFragmentActivity.FragmentActivity8.class, a.class);
        Intent intent = new Intent(context, (Class<?>) BaseFragmentActivity.FragmentActivity8.class);
        intent.putExtra("KEY_NEWS_DETAIL_PARAM", newsDetailParam);
        context.startActivity(intent);
    }

    @Override // com.kwad.components.core.proxy.i, com.kwad.sdk.api.proxy.IActivityProxy
    public void onCreate(Bundle bundle) {
        try {
            super.onCreate(bundle);
            if (xn()) {
                getActivity().setTheme(R.style.Theme_AppCompat_Light_NoActionBar);
                setContentView(R.layout.ksad_horizontal_detail_activity);
                com.kwad.components.core.u.e.a(getActivity(), 0, true);
                EP();
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private boolean xn() {
        Serializable serializableExtra = getIntent().getSerializableExtra("KEY_NEWS_DETAIL_PARAM");
        if (serializableExtra instanceof NewsDetailParam) {
            this.aNw = (NewsDetailParam) serializableExtra;
        }
        return this.aNw != null;
    }

    private void EP() {
        c cVarA = c.a(this.aNw);
        addBackPressable(cVarA, 0);
        getSupportFragmentManager().beginTransaction().replace(R.id.ksad_horizontal_fragment_container, cVarA).commitAllowingStateLoss();
    }
}
