package com.kwad.components.ct.horizontal.detail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.kwad.components.core.u.e;
import com.kwad.sdk.R;
import com.kwad.sdk.api.proxy.IFragmentActivityProxy;
import com.kwad.sdk.api.proxy.app.BaseFragmentActivity;
import com.kwad.sdk.internal.api.SceneImpl;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class a extends IFragmentActivityProxy {
    private HorizontalFeedParam aLB;
    private com.kwad.components.ct.horizontal.video.a aLC;

    public static void init() {
        com.kwad.sdk.service.c.g(BaseFragmentActivity.FragmentActivity7.class, a.class);
    }

    public static void a(Context context, HorizontalFeedParam horizontalFeedParam) {
        if (context == null) {
            return;
        }
        Intent intent = new Intent(context, (Class<?>) BaseFragmentActivity.FragmentActivity7.class);
        intent.putExtra("KEY_HORIZONTAL_PARAM", horizontalFeedParam);
        context.startActivity(intent);
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onCreate(Bundle bundle) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        super.onCreate(bundle);
        if (xn()) {
            getActivity().setTheme(R.style.Theme_AppCompat_Light_NoActionBar);
            setContentView(R.layout.ksad_horizontal_detail_activity);
            e.a(getActivity(), -16777216, false);
            EP();
        }
    }

    private boolean xn() {
        Serializable serializableExtra = getIntent().getSerializableExtra("KEY_HORIZONTAL_PARAM");
        if (serializableExtra instanceof HorizontalFeedParam) {
            this.aLB = (HorizontalFeedParam) serializableExtra;
        }
        return this.aLB != null;
    }

    private void EP() {
        this.aLC = com.kwad.components.ct.horizontal.video.a.a(new SceneImpl(this.aLB.getEntryScene()), this.aLB);
        getSupportFragmentManager().beginTransaction().replace(R.id.ksad_horizontal_fragment_container, this.aLC).commitAllowingStateLoss();
    }
}
