package com.kwad.components.ct.home.c;

import android.app.Activity;
import com.kwad.components.adx.api.model.KsAdxScene;
import com.kwad.components.ct.detail.viewpager.SlidePlayViewPager;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.az;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a extends com.kwad.components.ct.home.e {
    private com.kwad.components.adx.api.b aJA;
    private com.kwad.components.adx.api.a aJy;
    private boolean aJz;
    public SlidePlayViewPager aok;
    private com.kwad.components.ct.api.a.a.b ayn;
    private int mRequestCount = 0;
    private Map<Integer, az<Integer>> aJB = new HashMap();
    private Map<Integer, List<CtAdTemplate>> aJC = new HashMap();
    private final List<com.kwad.components.adx.api.model.b> aJD = new LinkedList();

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        com.kwad.components.adx.api.a aVar = (com.kwad.components.adx.api.a) com.kwad.sdk.components.d.g(com.kwad.components.adx.api.a.class);
        this.aJy = aVar;
        if (aVar != null) {
            this.aJz = com.kwad.components.core.u.d.tu();
            this.aJA = this.aJy.ob();
        }
        StringBuilder sbAppend = new StringBuilder("onCreate source.isUseAdx:").append(com.kwad.components.ct.home.a.OT).append(" config.useAdx: ");
        com.kwad.components.adx.api.a aVar2 = this.aJy;
        com.kwad.sdk.core.d.c.d("AdxDataLoaderPresenter", sbAppend.append(aVar2 != null && aVar2.oc()).toString());
    }

    @Override // com.kwad.components.ct.home.e, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        com.kwad.sdk.core.d.c.d("AdxDataLoaderPresenter", "onBind isUseAdx:" + this.aJz);
        if (this.aJy == null || this.aJz) {
            this.aok = this.aGP.aok;
            GC();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        if (this.ayn != null) {
            this.aGP.ayi.b(this.ayn);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
        if (this.aJD.isEmpty()) {
            return;
        }
        Iterator<com.kwad.components.adx.api.model.b> it = this.aJD.iterator();
        while (it.hasNext()) {
            it.next();
        }
        this.aJD.clear();
    }

    private void GC() {
        if (this.ayn == null) {
            this.ayn = new com.kwad.components.ct.home.b.d() { // from class: com.kwad.components.ct.home.c.a.1
                @Override // com.kwad.components.ct.home.b.d, com.kwad.components.ct.api.a.a.b
                public final void a(boolean z, boolean z2, int i, int i2) {
                    super.a(z, z2, i, i2);
                    com.kwad.sdk.core.d.c.d("AdxDataLoaderPresenter", "initAdxDataLoader DataFetcherListenerAdapter onStartLoading , isRefresh: " + z + " , loadMore: " + z2 + " , requestType: " + i + " , pageCount: " + i2);
                    a.this.aJB.put(Integer.valueOf(i2), new az(Integer.valueOf(a.this.aok.getAdapter().CR()), Integer.MAX_VALUE));
                }

                @Override // com.kwad.components.ct.home.b.d, com.kwad.components.ct.api.a.a.b
                public final void c(boolean z, int i, int i2) {
                    super.c(z, i, i2);
                    com.kwad.sdk.core.d.c.d("AdxDataLoaderPresenter", "initAdxDataLoader DataFetcherListenerAdapter onFinishLoading , isRefresh: " + z + " , pageCount: " + i);
                    a.this.i(z, i);
                }
            };
        }
        this.aGP.ayi.a(this.ayn);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(boolean z, int i) {
        List<T> listXc = this.aGP.ayi.xc();
        if (listXc == 0) {
            return;
        }
        int size = listXc.size();
        if (z) {
            this.aJB.clear();
            this.aJB.put(Integer.valueOf(i), new az<>(0, Integer.valueOf(size)));
            this.aJC.clear();
        } else {
            az<Integer> azVar = this.aJB.get(Integer.valueOf(i));
            iIntValue = azVar != null ? ((Integer) azVar.getLower()).intValue() : 0;
            this.aJB.put(Integer.valueOf(i), new az<>(Integer.valueOf(iIntValue), Integer.valueOf(size)));
        }
        ArrayList arrayList = new ArrayList();
        while (iIntValue < listXc.size()) {
            CtAdTemplate ctAdTemplate = (CtAdTemplate) listXc.get(iIntValue);
            if (t(ctAdTemplate)) {
                arrayList.add(ctAdTemplate);
            }
            iIntValue++;
        }
        if (arrayList.isEmpty()) {
            return;
        }
        this.aJC.put(Integer.valueOf(i), arrayList);
        a(i, arrayList);
    }

    private boolean t(CtAdTemplate ctAdTemplate) {
        return (ctAdTemplate == null || ctAdTemplate.mHasSelected || this.aok.getCurrentData() == ctAdTemplate || !com.kwad.components.ct.response.a.a.eH(ctAdTemplate)) ? false : true;
    }

    private void a(final int i, List<CtAdTemplate> list) {
        com.kwad.sdk.core.d.c.d("AdxDataLoaderPresenter", "loadDrawAd ");
        if (!this.aJz || list.isEmpty()) {
            com.kwad.sdk.core.d.c.e("AdxDataLoaderPresenter", "loadDrawAd failed useAdx false, drawAdTemplateList: " + list);
            return;
        }
        KsAdxScene ksAdxSceneA = a(getActivity(), this.aGP.mSceneImpl, this.mRequestCount, list);
        ksAdxSceneA.setWidth(this.aGP.aok.getWidth());
        ksAdxSceneA.setHeight(this.aGP.aok.getHeight());
        this.mRequestCount++;
        final int size = list.size();
        new Object() { // from class: com.kwad.components.ct.home.c.a.2
        };
    }

    private static KsAdxScene a(Activity activity, SceneImpl sceneImpl, int i, List<CtAdTemplate> list) {
        return new KsAdxScene.a().aw(Math.min(2, list.size())).ax(sceneImpl.getAction()).ay(sceneImpl.getWidth()).az(sceneImpl.getHeight()).af(sceneImpl.getPromoteId()).ag(sceneImpl.getComment()).ah(sceneImpl.getBackUrl()).b(activity).av(i).k(list).oe();
    }
}
