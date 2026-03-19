package com.kwad.components.ct.profile.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.kwad.components.core.proxy.i;
import com.kwad.components.core.u.e;
import com.kwad.sdk.R;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.api.proxy.app.BaseFragmentActivity;
import com.kwad.sdk.service.ServiceProvider;
import java.io.Serializable;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class a extends i {
    private ProfileHomeParam aRb;

    @Override // com.kwad.components.core.proxy.i
    public String getPageName() {
        return "ProfileHomeActivityImpl";
    }

    public static void init() {
        com.kwad.sdk.service.c.g(BaseFragmentActivity.ProfileHomeActivity.class, a.class);
    }

    public static void a(Context context, ProfileHomeParam profileHomeParam) {
        if (profileHomeParam.isValid()) {
            Intent intent = new Intent(context, (Class<?>) BaseFragmentActivity.ProfileHomeActivity.class);
            intent.addFlags(603979776);
            intent.putExtra("KEY_PROFILE_HOME_PARAM", profileHomeParam);
            context.startActivity(intent);
        }
    }

    public static void a(KsFragment ksFragment, int i, ProfileHomeParam profileHomeParam) {
        if (profileHomeParam.isValid()) {
            Intent intent = new Intent(ksFragment.getContext(), (Class<?>) BaseFragmentActivity.ProfileHomeActivity.class);
            intent.addFlags(603979776);
            intent.putExtra("KEY_PROFILE_HOME_PARAM", profileHomeParam);
            ksFragment.startActivityForResult(intent, 1001);
        }
    }

    @Override // com.kwad.components.core.proxy.i, com.kwad.sdk.api.proxy.IActivityProxy
    public void onCreate(Bundle bundle) {
        try {
            super.onCreate(bundle);
            com.kwad.sdk.core.d.c.d("ProfileHomeActivity", "onCreate");
            if (!xn()) {
                finish();
                return;
            }
            getActivity().setTheme(R.style.Theme_AppCompat_Light_NoActionBar);
            setContentView(R.layout.ksad_activity_profile_home);
            e.a(getActivity(), 0, false);
            EP();
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        com.kwad.sdk.core.d.c.d("ProfileHomeActivity", "onNewIntent");
    }

    private void EP() {
        getSupportFragmentManager().beginTransaction().replace(R.id.ksad_fragment_container, c.a(this.aRb)).commitAllowingStateLoss();
    }

    private boolean xn() {
        Serializable serializableExtra = getIntent().getSerializableExtra("KEY_PROFILE_HOME_PARAM");
        if (serializableExtra instanceof ProfileHomeParam) {
            this.aRb = (ProfileHomeParam) serializableExtra;
        }
        return this.aRb != null;
    }

    @Override // com.kwad.components.core.proxy.i, com.kwad.sdk.api.proxy.IActivityProxy
    public void onBackPressed() {
        Jf();
        super.onBackPressed();
    }

    private void Jf() {
        Intent intent = new Intent();
        intent.putExtra("key_shield_state", com.kwad.components.ct.response.a.c.f(this.aRb.mAdTemplate.photoInfo));
        getActivity().setResult(-1, intent);
    }
}
