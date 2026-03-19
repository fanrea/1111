package com.kwad.components.ct.tube.panel.c;

import android.view.View;
import android.widget.ImageView;
import com.kwad.sdk.R;
import com.kwad.sdk.api.core.fragment.KsFragment;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a extends com.kwad.components.ct.tube.panel.b.a {
    private ImageView aXS;
    private View mRootView;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.aXS = (ImageView) findViewById(R.id.ksad_tube_pannel_collapse_arrow);
        this.mRootView = findViewById(R.id.ksad_tube_pannel_root_view);
    }

    @Override // com.kwad.components.ct.tube.panel.b.a, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.aXS.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ct.tube.panel.c.a.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                com.kwad.components.ct.tube.panel.a.c.KJ().g(a.this.aXj.alG);
                com.kwad.components.ct.e.b.JK().i(a.this.aXj.mSceneImpl);
            }
        });
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ct.tube.panel.c.a.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                KsFragment parentFragment = a.this.aXj.alG.getParentFragment();
                if (parentFragment != null) {
                    parentFragment.getChildFragmentManager().beginTransaction().remove(a.this.aXj.alG).commitAllowingStateLoss();
                }
            }
        });
    }
}
