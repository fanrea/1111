package com.kwad.components.ct.hotspot.hometab;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.kwad.components.core.u.e;
import com.kwad.components.ct.api.model.hotspot.HotspotListParam;
import com.kwad.components.ct.home.i;
import com.kwad.components.ct.response.model.hotspot.TabInfo;
import com.kwad.sdk.R;
import com.kwad.sdk.lib.a.d;
import com.kwad.sdk.lib.widget.viewpager.tabstrip.PagerSlidingTabStrip;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b extends d {
    private int aGL;
    private HomeTabParam aPR;
    private final List<com.kwad.sdk.lib.widget.viewpager.tabstrip.b> aPS = new ArrayList();

    @Override // com.kwad.components.core.proxy.h, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (ES()) {
            return;
        }
        com.kwad.sdk.core.d.c.d("HomeTabFragment", "handleParam fail");
        iE();
    }

    private boolean ES() {
        Bundle arguments = getArguments();
        if (arguments == null) {
            return false;
        }
        Serializable serializable = arguments.getSerializable("KEY_HOME_TAB_PARAM");
        if (!(serializable instanceof HomeTabParam)) {
            return false;
        }
        this.aGL = com.kwad.sdk.c.a.a.j(this.mContext, R.dimen.ksad_action_bar_height);
        HomeTabParam homeTabParam = (HomeTabParam) serializable;
        this.aPR = homeTabParam;
        if (homeTabParam.mHotspotListParam != null) {
            return a(this.aPR.mHotspotListParam);
        }
        return true;
    }

    private boolean a(HotspotListParam hotspotListParam) {
        List<TabInfo> list;
        if (!HotspotListParam.isValid(hotspotListParam) || (list = hotspotListParam.mHotspotListData.tabList) == null || list.isEmpty()) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            TabInfo tabInfo = list.get(i);
            if (tabInfo != null) {
                int i2 = tabInfo.tabId;
                if (i2 == 1) {
                    this.ccp = String.valueOf(tabInfo.tabId);
                    a(tabInfo, hotspotListParam);
                } else if (i2 == 2) {
                    a(tabInfo);
                }
            }
        }
        return true;
    }

    private void a(TabInfo tabInfo, HotspotListParam hotspotListParam) {
        PagerSlidingTabStrip.c cVar = new PagerSlidingTabStrip.c(String.valueOf(tabInfo.tabId), tabInfo.tabName);
        cVar.a(new View.OnClickListener() { // from class: com.kwad.components.ct.hotspot.hometab.b.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                com.kwad.components.ct.e.b.JK().JO();
            }
        });
        Bundle bundle = new Bundle();
        bundle.putSerializable("key_AdScene", this.aPR.mEntryScene);
        bundle.putSerializable("KEY_HOME_ACTIONBAR_HEIGHT", Integer.valueOf(this.aGL));
        bundle.putSerializable("KEY_HOTSPOT_LIST", hotspotListParam);
        this.aPS.add(new com.kwad.sdk.lib.widget.viewpager.tabstrip.b(cVar, c.class, bundle));
    }

    private void a(TabInfo tabInfo) {
        PagerSlidingTabStrip.c cVar = new PagerSlidingTabStrip.c(String.valueOf(tabInfo.tabId), tabInfo.tabName);
        cVar.a(new View.OnClickListener() { // from class: com.kwad.components.ct.hotspot.hometab.b.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                com.kwad.components.ct.e.b.JK().JP();
            }
        });
        Bundle bundle = new Bundle();
        bundle.putSerializable("key_AdScene", this.aPR.mEntryScene);
        bundle.putSerializable("KEY_HOME_ACTIONBAR_HEIGHT", Integer.valueOf(this.aGL));
        this.aPS.add(new com.kwad.sdk.lib.widget.viewpager.tabstrip.b(cVar, i.class, bundle));
    }

    @Override // com.kwad.sdk.lib.a.d, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public final void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        View viewFindViewById = view.findViewById(R.id.ksad_title_bar);
        if (e.e(getActivity())) {
            int statusBarHeight = com.kwad.sdk.c.a.a.getStatusBarHeight(this.mContext);
            ViewGroup.LayoutParams layoutParams = viewFindViewById.getLayoutParams();
            layoutParams.height += statusBarHeight;
            viewFindViewById.setLayoutParams(layoutParams);
            viewFindViewById.setPadding(viewFindViewById.getPaddingLeft(), statusBarHeight + viewFindViewById.getPaddingTop(), viewFindViewById.getPaddingRight(), viewFindViewById.getPaddingBottom());
        }
        view.findViewById(R.id.ksad_back_btn).setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ct.hotspot.hometab.b.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                b.this.getActivity().onBackPressed();
            }
        });
        if (this.aPS.size() == 1) {
            this.aXR.setVisibility(8);
        } else {
            this.aXR.a(0.0f, 0.0f, 1.0f, Color.parseColor("#80000000"));
        }
    }

    @Override // com.kwad.components.core.proxy.h
    public final int rb() {
        return R.layout.ksad_fragment_home_tab_layout;
    }

    @Override // com.kwad.sdk.lib.a.d
    public final int IJ() {
        return R.id.ksad_tab_strip;
    }

    @Override // com.kwad.sdk.lib.a.d
    public final int IK() {
        return R.id.ksad_view_pager;
    }

    @Override // com.kwad.sdk.lib.a.d
    public final List<com.kwad.sdk.lib.widget.viewpager.tabstrip.b> IL() {
        return this.aPS;
    }
}
