package com.kwad.components.ct.tube.slide;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import com.kwad.components.core.proxy.i;
import com.kwad.components.core.u.e;
import com.kwad.components.core.u.q;
import com.kwad.components.ct.api.tube.TubeEpisodeHomeParam;
import com.kwad.sdk.R;
import com.kwad.sdk.api.proxy.app.BaseFragmentActivity;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.c;
import java.io.Serializable;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class a extends i {
    private TubeEpisodeHomeParam aYk;

    @Override // com.kwad.components.core.proxy.i
    public String getPageName() {
        return "EpisodeDetailActivityImpl";
    }

    public static void init() {
        c.g(BaseFragmentActivity.EpisodeDetailActivity.class, a.class);
    }

    public static void a(Activity activity, TubeEpisodeHomeParam tubeEpisodeHomeParam) {
        if (tubeEpisodeHomeParam == null) {
            return;
        }
        Intent intent = new Intent(activity, (Class<?>) BaseFragmentActivity.EpisodeDetailActivity.class);
        intent.putExtra("KEY_TUBE_EPISODE_DETAIL_PARAM", tubeEpisodeHomeParam);
        activity.startActivity(intent);
    }

    @Override // com.kwad.components.core.proxy.i, com.kwad.sdk.api.proxy.IActivityProxy
    public void onCreate(Bundle bundle) {
        try {
            super.onCreate(bundle);
            if (!xn()) {
                finish();
                return;
            }
            if (Build.VERSION.SDK_INT >= 21) {
                getWindow().setNavigationBarColor(-16777216);
            }
            getActivity().setTheme(R.style.Theme_AppCompat_Light_NoActionBar);
            setContentView(R.layout.ksad_activity_tube);
            q.f(getActivity());
            e.a(getActivity(), 0, false);
            EP();
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private boolean xn() {
        Serializable serializableExtra = getIntent().getSerializableExtra("KEY_TUBE_EPISODE_DETAIL_PARAM");
        if (serializableExtra instanceof TubeEpisodeHomeParam) {
            TubeEpisodeHomeParam tubeEpisodeHomeParam = (TubeEpisodeHomeParam) serializableExtra;
            this.aYk = tubeEpisodeHomeParam;
            if (tubeEpisodeHomeParam.mEntryScene != 0) {
                return true;
            }
        }
        return false;
    }

    private void EP() {
        getSupportFragmentManager().beginTransaction().replace(R.id.ksad_fragment_container, b.a(this.aYk)).commitAllowingStateLoss();
    }
}
