package com.kwad.components.ct.hotspot.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.kwad.components.ct.api.model.hotspot.HotspotListParam;
import com.kwad.components.ct.f.b;
import com.kwad.components.ct.f.f;
import com.kwad.components.ct.f.g;
import com.kwad.components.ct.hotspot.d;
import com.kwad.components.ct.hotspot.hometab.HomeTabParam;
import com.kwad.components.ct.response.model.hotspot.HotspotInfo;
import com.kwad.components.ct.response.model.hotspot.HotspotListData;
import com.kwad.sdk.R;
import com.kwad.sdk.c.a.a;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.widget.KSFrameLayout;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class HotspotListView extends KSFrameLayout implements b {
    private f<HotspotListView> aDL;
    private final d aPF;
    private HotspotListRecyclerView aQy;
    public boolean aQz;
    private HotspotListData mHotspotListData;
    private SceneImpl mScene;

    public HotspotListView(Context context) {
        super(context);
        this.aPF = new d() { // from class: com.kwad.components.ct.hotspot.view.HotspotListView.1
            @Override // com.kwad.components.ct.hotspot.d
            public final void a(View view, HotspotInfo hotspotInfo, int i) {
                if (a.Wl()) {
                    return;
                }
                HomeTabParam homeTabParam = new HomeTabParam();
                HotspotListParam hotspotListParam = new HotspotListParam();
                hotspotListParam.mHotspotListData = HotspotListView.this.mHotspotListData;
                hotspotListParam.mEntryHotspotInfo = hotspotInfo;
                homeTabParam.mHotspotListParam = hotspotListParam;
                homeTabParam.mEntryScene = HotspotListView.this.mScene;
                com.kwad.components.ct.hotspot.hometab.a.a(HotspotListView.this.getContext(), homeTabParam);
                com.kwad.components.ct.e.b.JK().d(HotspotListView.this.mScene, hotspotInfo);
            }

            @Override // com.kwad.components.ct.hotspot.d
            public final void c(HotspotInfo hotspotInfo) {
                com.kwad.components.ct.e.b.JK().c(HotspotListView.this.mScene, hotspotInfo);
            }
        };
    }

    public HotspotListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aPF = new d() { // from class: com.kwad.components.ct.hotspot.view.HotspotListView.1
            @Override // com.kwad.components.ct.hotspot.d
            public final void a(View view, HotspotInfo hotspotInfo, int i) {
                if (a.Wl()) {
                    return;
                }
                HomeTabParam homeTabParam = new HomeTabParam();
                HotspotListParam hotspotListParam = new HotspotListParam();
                hotspotListParam.mHotspotListData = HotspotListView.this.mHotspotListData;
                hotspotListParam.mEntryHotspotInfo = hotspotInfo;
                homeTabParam.mHotspotListParam = hotspotListParam;
                homeTabParam.mEntryScene = HotspotListView.this.mScene;
                com.kwad.components.ct.hotspot.hometab.a.a(HotspotListView.this.getContext(), homeTabParam);
                com.kwad.components.ct.e.b.JK().d(HotspotListView.this.mScene, hotspotInfo);
            }

            @Override // com.kwad.components.ct.hotspot.d
            public final void c(HotspotInfo hotspotInfo) {
                com.kwad.components.ct.e.b.JK().c(HotspotListView.this.mScene, hotspotInfo);
            }
        };
    }

    public HotspotListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aPF = new d() { // from class: com.kwad.components.ct.hotspot.view.HotspotListView.1
            @Override // com.kwad.components.ct.hotspot.d
            public final void a(View view, HotspotInfo hotspotInfo, int i2) {
                if (a.Wl()) {
                    return;
                }
                HomeTabParam homeTabParam = new HomeTabParam();
                HotspotListParam hotspotListParam = new HotspotListParam();
                hotspotListParam.mHotspotListData = HotspotListView.this.mHotspotListData;
                hotspotListParam.mEntryHotspotInfo = hotspotInfo;
                homeTabParam.mHotspotListParam = hotspotListParam;
                homeTabParam.mEntryScene = HotspotListView.this.mScene;
                com.kwad.components.ct.hotspot.hometab.a.a(HotspotListView.this.getContext(), homeTabParam);
                com.kwad.components.ct.e.b.JK().d(HotspotListView.this.mScene, hotspotInfo);
            }

            @Override // com.kwad.components.ct.hotspot.d
            public final void c(HotspotInfo hotspotInfo) {
                com.kwad.components.ct.e.b.JK().c(HotspotListView.this.mScene, hotspotInfo);
            }
        };
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void ae() {
        super.ae();
        com.kwad.components.ct.f.d.Kb().a(this.aDL);
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void af() {
        super.af();
        com.kwad.components.ct.f.d.Kb().b(this.aDL);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        initView();
    }

    private void initView() {
        this.aQy = (HotspotListRecyclerView) findViewById(R.id.ksad_host_list);
        this.aDL = new f<>(this);
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, com.kwad.sdk.widget.m
    public final void E(View view) {
        super.E(view);
        if (this.aQz) {
            return;
        }
        this.aQz = true;
        com.kwad.components.ct.e.b.JK().e(this.mScene);
    }

    public final void a(SceneImpl sceneImpl, HotspotListData hotspotListData) {
        this.mScene = sceneImpl;
        this.mHotspotListData = hotspotListData;
        this.aQz = false;
        aqP();
        if (sceneImpl.height > 0) {
            ViewGroup.LayoutParams layoutParams = this.aQy.getLayoutParams();
            layoutParams.height = this.mScene.getHeight();
            this.aQy.setLayoutParams(layoutParams);
        }
        this.aQy.a(hotspotListData.trends, null);
        this.aQy.setItemClickListener(this.aPF);
        IV();
    }

    @Override // com.kwad.components.ct.f.b
    public final void cg(int i) {
        IV();
    }

    private void IV() {
        g.c(this, ((com.kwad.components.ct.hotspot.b.b) com.kwad.components.ct.f.d.Kb().a(com.kwad.components.ct.hotspot.b.b.class)).IS().aDq);
        this.aQy.IG();
    }
}
