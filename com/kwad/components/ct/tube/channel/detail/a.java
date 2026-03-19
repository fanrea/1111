package com.kwad.components.ct.tube.channel.detail;

import android.os.Bundle;
import com.kwad.components.core.proxy.i;
import com.kwad.components.core.u.e;
import com.kwad.components.ct.f.d;
import com.kwad.components.ct.f.f;
import com.kwad.sdk.R;
import com.kwad.sdk.api.proxy.app.BaseFragmentActivity;
import com.kwad.sdk.core.scene.URLPackage;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.service.ServiceProvider;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class a extends i implements com.kwad.components.ct.f.b {
    private f<a> aDL;
    private ChannelDetailParam aVU;
    private SceneImpl mSceneImpl;

    @Override // com.kwad.components.core.proxy.i
    public String getPageName() {
        return "ChannelDetailActivityImpl";
    }

    public static void init() {
        try {
            com.kwad.sdk.service.c.g(BaseFragmentActivity.ChannelDetailActivity.class, a.class);
        } catch (Throwable unused) {
        }
    }

    @Override // com.kwad.components.core.proxy.i, com.kwad.sdk.api.proxy.IActivityProxy
    public void onCreate(Bundle bundle) {
        try {
            super.onCreate(bundle);
            if (!xn()) {
                finish();
                return;
            }
            this.aDL = new f<>(this);
            d.Kb().a(this.aDL);
            getActivity().setTheme(R.style.Theme_AppCompat_Light_NoActionBar);
            setContentView(R.layout.ksad_activity_tube);
            EP();
            Ke();
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private void Ke() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        e.a(getActivity(), 0, d.Kb().wR() != 1);
    }

    @Override // com.kwad.components.core.proxy.i, com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        d.Kb().b(this.aDL);
        super.onDestroy();
    }

    private void EP() {
        getSupportFragmentManager().beginTransaction().replace(R.id.ksad_fragment_container, c.a(this.aVU)).commitAllowingStateLoss();
    }

    private boolean xn() {
        Serializable serializableExtra = getIntent().getSerializableExtra("KEY_CHANNEL_DETAIL_PARAM");
        if (serializableExtra instanceof ChannelDetailParam) {
            this.aVU = (ChannelDetailParam) serializableExtra;
            this.mSceneImpl = new SceneImpl(this.aVU.mEntryScene);
            URLPackage uRLPackage = new URLPackage(String.valueOf(hashCode()), 27);
            uRLPackage.putParams("channelId", this.aVU.mChannelInfo.channelId);
            this.mSceneImpl.setUrlPackage(uRLPackage);
        }
        return this.aVU != null;
    }

    @Override // com.kwad.components.core.proxy.i, com.kwad.sdk.api.proxy.IActivityProxy
    public void onBackPressed() {
        super.onBackPressed();
        com.kwad.components.ct.e.b.JK().h(this.mSceneImpl);
    }

    @Override // com.kwad.components.ct.f.b
    public final void cg(int i) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Ke();
    }
}
