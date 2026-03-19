package com.kwad.components.ct.tube.channel.home;

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
    private TubeChannelParam aWo;
    private SceneImpl mSceneImpl;

    @Override // com.kwad.components.core.proxy.i
    public String getPageName() {
        return "TubeProfileActivityImpl";
    }

    public static void init() {
        com.kwad.sdk.service.c.g(BaseFragmentActivity.TubeProfileActivity.class, a.class);
    }

    @Override // com.kwad.components.core.proxy.i, com.kwad.sdk.api.proxy.IActivityProxy
    public void onCreate(Bundle bundle) {
        try {
            super.onCreate(bundle);
            if (!xn()) {
                finish();
                return;
            }
            getActivity().setTheme(R.style.Theme_AppCompat_Light_NoActionBar);
            setContentView(R.layout.ksad_activity_tube);
            EP();
            Ke();
            this.aDL = new f<>(this);
            d.Kb().a(this.aDL);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private void Ke() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        e.a(getActivity(), 0, d.Kb().wR() != 1);
    }

    @Override // com.kwad.components.core.proxy.i, com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        try {
            d.Kb().b(this.aDL);
            super.onDestroy();
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private void EP() {
        getSupportFragmentManager().beginTransaction().replace(R.id.ksad_fragment_container, c.a(this.aWo)).commitAllowingStateLoss();
    }

    private boolean xn() {
        Serializable serializableExtra = getIntent().getSerializableExtra("KEY_TUBE_PROFILE_PARAM");
        if (serializableExtra instanceof TubeChannelParam) {
            this.aWo = (TubeChannelParam) serializableExtra;
            this.mSceneImpl = new SceneImpl(this.aWo.mEntryScene);
            this.mSceneImpl.setUrlPackage(new URLPackage(String.valueOf(hashCode()), this.aWo.mPageScene));
        }
        return this.aWo != null;
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
