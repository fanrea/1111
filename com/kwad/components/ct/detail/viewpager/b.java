package com.kwad.components.ct.detail.viewpager;

import android.os.Bundle;
import android.util.SparseArray;
import android.view.ViewGroup;
import com.kwad.components.ct.api.h;
import com.kwad.components.ct.detail.viewpager.e;
import com.kwad.components.ct.home.j;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.components.ec.api.EcLiveComponents;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.api.core.fragment.KsFragmentManager;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public abstract class b extends d {
    protected SlidePlayViewPager amK;
    private j aol;
    private final SparseArray<KsFragment> azH;
    private boolean azI;
    protected final com.kwad.sdk.lib.widget.b<CtAdTemplate> azJ;
    private List<CtAdTemplate> azK;
    private com.kwad.components.ct.g.a azL;
    protected int azM;
    protected int azN;
    protected int azO;

    public void a(List<CtAdTemplate> list, CtAdTemplate ctAdTemplate, int i, int i2, boolean z) {
    }

    public void a(List<CtAdTemplate> list, CtAdTemplate ctAdTemplate, CtAdTemplate ctAdTemplate2, int i, int i2) {
    }

    public abstract int bO(int i);

    public abstract int bP(int i);

    public void bQ(int i) {
    }

    public abstract int getFirstValidItemPosition();

    public abstract int getLastValidItemPosition();

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i) {
        return "";
    }

    public void a(SlidePlayViewPager slidePlayViewPager) {
        this.amK = slidePlayViewPager;
    }

    public final void z(List<CtAdTemplate> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        this.azK = list;
        synchronized (this.azJ) {
            this.azJ.clear();
            this.azJ.addAll(list);
        }
        if (bT(this.amK.getCurrentItem())) {
            return;
        }
        notifyDataSetChanged();
    }

    public final int CR() {
        return this.azJ.size();
    }

    public final List<CtAdTemplate> getData() {
        return this.azJ;
    }

    public final CtAdTemplate bR(int i) {
        int iBO = bO(i);
        if (iBO < 0 || iBO >= this.azJ.size()) {
            return null;
        }
        return this.azJ.get(iBO);
    }

    public final void b(com.kwad.components.ct.g.a aVar) {
        this.azL = aVar;
    }

    public final void a(j jVar) {
        this.aol = jVar;
    }

    public b(KsFragmentManager ksFragmentManager) {
        super(ksFragmentManager);
        this.azH = new SparseArray<>();
        this.azJ = new com.kwad.sdk.lib.widget.b<>(new ArrayList());
        this.azM = -1;
        this.azN = -1;
        this.azO = 0;
    }

    @Override // com.kwad.components.ct.detail.viewpager.d
    protected final KsFragment bS(int i) {
        h hVar = (h) com.kwad.sdk.components.d.g(h.class);
        if (i >= 1000) {
            return new com.kwad.components.ct.detail.c.a();
        }
        if (i == 0) {
            return new com.kwad.components.ct.detail.ad.a();
        }
        if (i == 101 && hVar != null) {
            return hVar.xb();
        }
        if (i == 100) {
            return new com.kwad.components.ct.detail.photo.a();
        }
        if (i == 200) {
            EcLiveComponents ecLiveComponents = (EcLiveComponents) com.kwad.sdk.components.d.g(EcLiveComponents.class);
            if (ecLiveComponents != null) {
                return ecLiveComponents.LG();
            }
            return new com.kwad.components.core.proxy.h();
        }
        return CS();
    }

    private static KsFragment CS() {
        return new com.kwad.components.core.proxy.h();
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x004b  */
    @Override // com.kwad.components.ct.detail.viewpager.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected final int getItemViewType(int r9) {
        /*
            r8 = this;
            int r0 = r8.bO(r9)
            com.kwad.components.ct.response.model.CtAdTemplate r1 = r8.bU(r0)
            r2 = -2
            r3 = -1
            r4 = 0
            if (r1 == 0) goto L5e
            int r5 = r1.contentType
            r6 = 1
            if (r5 == r6) goto L4e
            r6 = 2
            if (r5 == r6) goto L4b
            r7 = 3
            if (r5 == r7) goto L2e
            r1 = 4
            if (r5 == r1) goto L20
            r1 = 6
            if (r5 == r1) goto L20
            r2 = r3
            goto L4c
        L20:
            java.lang.Class<com.kwad.components.ec.api.EcLiveComponents> r1 = com.kwad.components.ec.api.EcLiveComponents.class
            com.kwad.sdk.components.b r1 = com.kwad.sdk.components.d.g(r1)
            com.kwad.components.ec.api.EcLiveComponents r1 = (com.kwad.components.ec.api.EcLiveComponents) r1
            if (r1 != 0) goto L2b
            goto L4c
        L2b:
            r2 = 200(0xc8, float:2.8E-43)
            goto L4c
        L2e:
            com.kwad.components.ct.g.a r3 = r8.azL
            if (r3 == 0) goto L37
            int r3 = r3.r(r1, r0)
            goto L38
        L37:
            r3 = r4
        L38:
            if (r3 != r7) goto L49
            com.kwad.components.ct.g.a r7 = r8.azL
            if (r7 == 0) goto L49
            com.kwad.sdk.api.KsContentPage$SubShowItem r1 = r7.bg(r1)
            int r1 = r1.getItemViewType()
            int r2 = r1 + 1000
            goto L4c
        L49:
            if (r3 != r6) goto L4c
        L4b:
            r2 = r4
        L4c:
            r4 = r5
            goto L5f
        L4e:
            com.kwad.components.ct.response.model.CtPhotoInfo r1 = com.kwad.components.ct.response.a.a.ay(r1)
            boolean r1 = com.kwad.components.ct.response.a.c.G(r1)
            if (r1 == 0) goto L5b
            r2 = 101(0x65, float:1.42E-43)
            goto L4c
        L5b:
            r2 = 100
            goto L4c
        L5e:
            r2 = r3
        L5f:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r3 = "getItemViewType position="
            r1.<init>(r3)
            java.lang.StringBuilder r9 = r1.append(r9)
            java.lang.String r1 = "--realPosition="
            java.lang.StringBuilder r9 = r9.append(r1)
            java.lang.StringBuilder r9 = r9.append(r0)
            java.lang.String r0 = "--itemType="
            java.lang.StringBuilder r9 = r9.append(r0)
            java.lang.StringBuilder r9 = r9.append(r2)
            java.lang.String r0 = "--contentType="
            java.lang.StringBuilder r9 = r9.append(r0)
            java.lang.StringBuilder r9 = r9.append(r4)
            java.lang.String r0 = "--size="
            java.lang.StringBuilder r9 = r9.append(r0)
            com.kwad.sdk.lib.widget.b<com.kwad.components.ct.response.model.CtAdTemplate> r0 = r8.azJ
            int r0 = r0.size()
            java.lang.StringBuilder r9 = r9.append(r0)
            java.lang.String r9 = r9.toString()
            java.lang.String r0 = "SlidePlayPagerAdapter"
            com.kwad.sdk.core.d.c.d(r0, r9)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.ct.detail.viewpager.b.getItemViewType(int):int");
    }

    @Override // com.kwad.components.ct.detail.viewpager.d
    protected final int d(KsFragment ksFragment) {
        h hVar = (h) com.kwad.sdk.components.d.g(h.class);
        if (ksFragment instanceof com.kwad.components.ct.detail.ad.a) {
            return 0;
        }
        if (hVar != null && hVar.b(ksFragment)) {
            return 101;
        }
        if (ksFragment instanceof com.kwad.components.ct.detail.photo.a) {
            return 100;
        }
        EcLiveComponents ecLiveComponents = (EcLiveComponents) com.kwad.sdk.components.d.g(EcLiveComponents.class);
        return (ecLiveComponents == null || !ecLiveComponents.LH()) ? -1 : 200;
    }

    @Override // com.kwad.components.ct.detail.viewpager.d
    protected final void a(KsFragment ksFragment, int i) {
        int iBO = bO(i);
        CtAdTemplate ctAdTemplateBU = bU(iBO);
        if (ctAdTemplateBU == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("KEY_INDEX_IN_VIEW_PAGER", iBO);
        bundle.putSerializable("key_template", ctAdTemplateBU);
        if (ksFragment.getArguments() != null) {
            ksFragment.getArguments().clear();
            ksFragment.getArguments().putAll(bundle);
        } else {
            ksFragment.setArguments(bundle);
        }
        if (ksFragment instanceof com.kwad.components.ct.detail.c.a) {
            ((com.kwad.components.ct.detail.c.a) ksFragment).a(this.azL);
        }
        if (ksFragment instanceof com.kwad.components.ct.detail.a) {
            ((com.kwad.components.ct.detail.a) ksFragment).a(this.aol);
        }
    }

    @Override // com.kwad.components.ct.detail.viewpager.d
    protected final boolean e(KsFragment ksFragment) {
        return ksFragment instanceof com.kwad.components.ct.detail.a;
    }

    @Override // com.kwad.components.ct.detail.viewpager.d, androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        KsFragment ksFragment = (KsFragment) super.instantiateItem(viewGroup, i);
        this.azH.put(i, ksFragment);
        return ksFragment;
    }

    @Override // com.kwad.components.ct.detail.viewpager.d, androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        super.destroyItem(viewGroup, i, obj);
        this.azH.remove(i);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object obj) {
        if (obj instanceof e.b) {
            e.b bVar = (e.b) obj;
            int i = this.azM;
            if (i >= 0 && i == bVar.position) {
                this.azM = -1;
                com.kwad.sdk.core.d.c.d("SlidePlayPagerAdapter", "getItemPosition11 position:" + bVar.position + "--POSITION_UNCHANGED");
                return -1;
            }
            if (!(bVar.aBm instanceof com.kwad.components.ct.detail.a) && getItemViewType(bVar.position) != -1) {
                com.kwad.sdk.core.d.c.d("SlidePlayPagerAdapter", "getItemPosition22 position:" + bVar.position + "--POSITION_NONE");
                return -2;
            }
            com.kwad.sdk.core.d.c.d("SlidePlayPagerAdapter", "getItemPosition33 position:" + bVar.position + "--mItemPosition=" + (this.azN == -1 ? "POSITION_UNCHANGED" : "POSITION_NONE"));
        } else {
            com.kwad.sdk.core.d.c.d("SlidePlayPagerAdapter", "getItemPosition 1111111 object:" + obj);
        }
        return this.azN;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }

    public final void e(int i, boolean z) {
        if (this.azI) {
            return;
        }
        f(i, z);
        g(i, z);
        bT(i);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0097  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean bT(int r9) {
        /*
            r8 = this;
            int r0 = r8.bO(r9)
            r1 = 0
            if (r0 >= 0) goto L8
            return r1
        L8:
            com.kwad.sdk.lib.widget.b<com.kwad.components.ct.response.model.CtAdTemplate> r2 = r8.azJ
            monitor-enter(r2)
            com.kwad.sdk.lib.widget.b<com.kwad.components.ct.response.model.CtAdTemplate> r3 = r8.azJ     // Catch: java.lang.Throwable -> L9f
            int r3 = r3.size()     // Catch: java.lang.Throwable -> L9f
            r4 = 1
            int r3 = r3 - r4
            r5 = -2
            if (r0 >= r3) goto L51
            com.kwad.sdk.lib.widget.b<com.kwad.components.ct.response.model.CtAdTemplate> r3 = r8.azJ     // Catch: java.lang.Throwable -> L9f
            int r6 = r0 + 1
            java.lang.Object r3 = r3.get(r6)     // Catch: java.lang.Throwable -> L9f
            com.kwad.components.ct.response.model.CtAdTemplate r3 = (com.kwad.components.ct.response.model.CtAdTemplate) r3     // Catch: java.lang.Throwable -> L9f
            int r6 = r9 + 1
            int r6 = r8.getItemViewType(r6)     // Catch: java.lang.Throwable -> L9f
            if (r6 != r5) goto L51
            com.kwad.sdk.lib.widget.b<com.kwad.components.ct.response.model.CtAdTemplate> r1 = r8.azJ     // Catch: java.lang.Throwable -> L9f
            r1.remove(r3)     // Catch: java.lang.Throwable -> L9f
            java.util.List<com.kwad.components.ct.response.model.CtAdTemplate> r1 = r8.azK     // Catch: java.lang.Throwable -> L9f
            if (r1 == 0) goto L34
            r1.remove(r3)     // Catch: java.lang.Throwable -> L9f
        L34:
            boolean r1 = com.kwad.sdk.core.d.c.sEnableLog     // Catch: java.lang.Throwable -> L9f
            if (r1 == 0) goto L50
            java.lang.String r1 = "SlidePlayPagerAdapter"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L9f
            java.lang.String r7 = "无效作品移除 template:"
            r6.<init>(r7)     // Catch: java.lang.Throwable -> L9f
            org.json.JSONObject r3 = r3.toJson()     // Catch: java.lang.Throwable -> L9f
            java.lang.StringBuilder r3 = r6.append(r3)     // Catch: java.lang.Throwable -> L9f
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L9f
            com.kwad.sdk.core.d.c.d(r1, r3)     // Catch: java.lang.Throwable -> L9f
        L50:
            r1 = r4
        L51:
            if (r0 <= 0) goto L97
            com.kwad.sdk.lib.widget.b<com.kwad.components.ct.response.model.CtAdTemplate> r3 = r8.azJ     // Catch: java.lang.Throwable -> L9f
            int r3 = r3.size()     // Catch: java.lang.Throwable -> L9f
            if (r0 >= r3) goto L97
            com.kwad.sdk.lib.widget.b<com.kwad.components.ct.response.model.CtAdTemplate> r3 = r8.azJ     // Catch: java.lang.Throwable -> L9f
            int r0 = r0 - r4
            java.lang.Object r0 = r3.get(r0)     // Catch: java.lang.Throwable -> L9f
            com.kwad.components.ct.response.model.CtAdTemplate r0 = (com.kwad.components.ct.response.model.CtAdTemplate) r0     // Catch: java.lang.Throwable -> L9f
            int r9 = r9 - r4
            int r9 = r8.getItemViewType(r9)     // Catch: java.lang.Throwable -> L9f
            if (r9 != r5) goto L97
            com.kwad.sdk.lib.widget.b<com.kwad.components.ct.response.model.CtAdTemplate> r9 = r8.azJ     // Catch: java.lang.Throwable -> L9f
            r9.remove(r0)     // Catch: java.lang.Throwable -> L9f
            java.util.List<com.kwad.components.ct.response.model.CtAdTemplate> r9 = r8.azK     // Catch: java.lang.Throwable -> L9f
            if (r9 == 0) goto L77
            r9.remove(r0)     // Catch: java.lang.Throwable -> L9f
        L77:
            r8.bQ(r4)     // Catch: java.lang.Throwable -> L9f
            boolean r9 = com.kwad.sdk.core.d.c.sEnableLog     // Catch: java.lang.Throwable -> L9f
            if (r9 == 0) goto L98
            java.lang.String r9 = "SlidePlayPagerAdapter"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L9f
            java.lang.String r3 = "无效作品移除 template:"
            r1.<init>(r3)     // Catch: java.lang.Throwable -> L9f
            org.json.JSONObject r0 = r0.toJson()     // Catch: java.lang.Throwable -> L9f
            java.lang.StringBuilder r0 = r1.append(r0)     // Catch: java.lang.Throwable -> L9f
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L9f
            com.kwad.sdk.core.d.c.d(r9, r0)     // Catch: java.lang.Throwable -> L9f
            goto L98
        L97:
            r4 = r1
        L98:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L9f
            if (r4 == 0) goto L9e
            r8.notifyDataSetChanged()
        L9e:
            return r4
        L9f:
            r9 = move-exception
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L9f
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.ct.detail.viewpager.b.bT(int):boolean");
    }

    private void f(int i, boolean z) {
        for (int i2 = 0; i2 < this.azH.size(); i2++) {
            int iKeyAt = this.azH.keyAt(i2);
            KsFragment ksFragmentValueAt = this.azH.valueAt(i2);
            if (iKeyAt != i && (ksFragmentValueAt instanceof com.kwad.components.ct.detail.a)) {
                com.kwad.components.ct.detail.a aVar = (com.kwad.components.ct.detail.a) ksFragmentValueAt;
                if (aVar.yj()) {
                    if (z) {
                        aVar.yh();
                    } else {
                        aVar.yf();
                    }
                }
            }
        }
    }

    private void g(int i, boolean z) {
        KsFragment ksFragment = this.azH.get(i);
        if (ksFragment instanceof com.kwad.components.ct.detail.a) {
            com.kwad.components.ct.detail.a aVar = (com.kwad.components.ct.detail.a) ksFragment;
            if (aVar.yj()) {
                if (z) {
                    aVar.yg();
                } else {
                    aVar.ye();
                }
            }
        }
    }

    public final CtAdTemplate bU(int i) {
        if (i < 0 || this.azJ.size() <= i) {
            return null;
        }
        return this.azJ.get(i);
    }

    public void bF(boolean z) {
        this.aol.Ft();
        bG(z);
        this.azI = true;
        this.azH.clear();
    }

    private void bG(boolean z) {
        for (int i = 0; i < this.azH.size(); i++) {
            KsFragment ksFragmentValueAt = this.azH.valueAt(i);
            if (ksFragmentValueAt instanceof com.kwad.components.ct.detail.a) {
                com.kwad.components.ct.detail.a aVar = (com.kwad.components.ct.detail.a) ksFragmentValueAt;
                aVar.yf();
                aVar.yh();
                if (z) {
                    aVar.onActivityDestroy();
                }
            }
        }
    }

    public final void CT() {
        for (int i = 0; i < this.aAf.size(); i++) {
            List<KsFragment> listValueAt = this.aAf.valueAt(i);
            if (listValueAt != null && listValueAt.size() != 0) {
                for (KsFragment ksFragment : listValueAt) {
                    if (ksFragment instanceof com.kwad.components.ct.detail.a) {
                        com.kwad.components.ct.detail.a aVar = (com.kwad.components.ct.detail.a) ksFragment;
                        aVar.yf();
                        aVar.yh();
                        aVar.onActivityDestroy();
                    }
                }
            }
        }
        this.aAf.clear();
    }
}
