package com.bytedance.msdk.b.b.hc.d.hc;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.mobads.container.adrequest.n;
import com.bytedance.sdk.djx.core.business.ad.IDJXAd;
import com.bytedance.sdk.openadsdk.core.z;
import com.bytedance.sdk.openadsdk.w.b.hc.uo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class gb {
    public void d(final boolean z, z zVar, final com.bytedance.sdk.openadsdk.w.b.b.hc hcVar, final com.bytedance.msdk.b.b.hc.d.hc hcVar2) {
        if (zVar == null || hcVar2 == null || hcVar == null) {
            return;
        }
        zVar.d(hcVar, new com.bytedance.sdk.openadsdk.sy.d.hc.d.b(null) { // from class: com.bytedance.msdk.b.b.hc.d.hc.gb.1
            public void d(int i, String str) {
                hcVar2.d(new com.bytedance.msdk.api.d(i, str));
            }

            public void d(List<com.bytedance.sdk.openadsdk.w.b.hc.tc> list) {
                com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "PangleNativeAd_onFeedAdLoad_SupportRenderControl:" + hcVar.mk());
                if (list == null || list.isEmpty()) {
                    hcVar2.d(new com.bytedance.msdk.api.d(80001, "load成功但返回广告是空"));
                    return;
                }
                if (hcVar.mk()) {
                    gb.this.d(list, hcVar2, z);
                    return;
                }
                ArrayList arrayList = new ArrayList();
                Iterator<com.bytedance.sdk.openadsdk.w.b.hc.tc> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(new d(it.next(), z, false));
                }
                hcVar2.d(arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(List<com.bytedance.sdk.openadsdk.w.b.hc.tc> list, final com.bytedance.msdk.b.b.hc.d.hc hcVar, final boolean z) {
        int size = list.size();
        com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "PangleNativeAd_nativeSupportRenderControl_adNum:".concat(String.valueOf(size)));
        final AtomicInteger atomicInteger = new AtomicInteger();
        final ArrayList arrayList = new ArrayList();
        for (final com.bytedance.sdk.openadsdk.w.b.hc.tc tcVar : list) {
            final long jCurrentTimeMillis = System.currentTimeMillis();
            final int i = size;
            tcVar.d(new com.bytedance.sdk.openadsdk.yi.d.hc.d.b(null) { // from class: com.bytedance.msdk.b.b.hc.d.hc.gb.2
                public void d(View view, float f, float f2, boolean z2) {
                    com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "PangleNativeAd_nativeSupportRenderControl_onRenderSuccess:" + z2 + " duration:" + (System.currentTimeMillis() - jCurrentTimeMillis));
                    arrayList.add(new d(tcVar, z, z2));
                    if (atomicInteger.incrementAndGet() != i || hcVar == null) {
                        return;
                    }
                    com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "PangleNativeAd_nativeSupportRenderControl_notifyAdSuccess!!!!!");
                    hcVar.d(arrayList);
                }
            });
            tcVar.v();
            size = size;
        }
    }

    private static class d extends com.bytedance.msdk.hc.b {
        private com.bytedance.sdk.openadsdk.w.b.hc.tc mq;
        private int uo;
        com.bytedance.sdk.openadsdk.yi.d.hc.d.d tt = new com.bytedance.sdk.openadsdk.yi.d.hc.d.d(0 == true ? 1 : 0) { // from class: com.bytedance.msdk.b.b.hc.d.hc.gb.d.2
            public void d(View view, uo uoVar) {
                if (d.this.d != null) {
                    d.this.d.d(view);
                }
            }

            public void hc(View view, uo uoVar) {
                if (d.this.d != null) {
                    d.this.d.d(view);
                }
            }

            public void d(uo uoVar) {
                if (d.this.d != null) {
                    d.this.d.d();
                }
            }
        };
        com.bytedance.sdk.openadsdk.v.d.hc.d.d tc = new com.bytedance.sdk.openadsdk.v.d.hc.d.d(0 == true ? 1 : 0) { // from class: com.bytedance.msdk.b.b.hc.d.hc.gb.d.3
            public void d(com.bytedance.sdk.openadsdk.w.b.hc.tc tcVar) {
                if (d.this.hc != null) {
                    d.this.hc.d();
                }
            }

            public void d(int i, int i2) {
                if (d.this.hc != null) {
                    d.this.hc.d(new com.bytedance.msdk.api.d(i, "Android MediaPlay Error Code :".concat(String.valueOf(i2))));
                }
            }

            public void hc(com.bytedance.sdk.openadsdk.w.b.hc.tc tcVar) {
                if (d.this.hc != null) {
                    d.this.hc.hc();
                }
            }

            public void b(com.bytedance.sdk.openadsdk.w.b.hc.tc tcVar) {
                if (d.this.hc != null) {
                    d.this.hc.b();
                }
            }

            public void c(com.bytedance.sdk.openadsdk.w.b.hc.tc tcVar) {
                if (d.this.hc != null) {
                    d.this.hc.c();
                }
            }

            public void d(long j, long j2) {
                if (d.this.hc != null) {
                    d.this.hc.d(j, j2);
                }
            }

            public void u(com.bytedance.sdk.openadsdk.w.b.hc.tc tcVar) {
                if (d.this.hc != null) {
                    d.this.hc.u();
                }
            }
        };
        com.bytedance.sdk.openadsdk.w.b.d.b mk = new com.bytedance.sdk.openadsdk.w.b.d.b(0 == true ? 1 : 0) { // from class: com.bytedance.msdk.b.b.hc.d.hc.gb.d.4
            public void d() {
                d.this.uo = 0;
                if (d.this.b != null) {
                    d.this.b.d();
                }
            }

            public void d(long j, long j2, String str, String str2) {
                d.this.uo = 2;
                if (d.this.b != null) {
                    d.this.b.d(j, j2, (int) (j != 0 ? j2 / j : 0L), -1, str, str2);
                }
            }

            public void hc(long j, long j2, String str, String str2) {
                d.this.uo = 3;
                if (d.this.b != null) {
                    d.this.b.d(j, j2, str, str2);
                }
            }

            public void b(long j, long j2, String str, String str2) {
                d.this.uo = 4;
                if (d.this.b != null) {
                    d.this.b.hc(j, j2, str, str2);
                }
            }

            public void d(long j, String str, String str2) {
                d.this.uo = 5;
                if (d.this.b != null) {
                    d.this.b.d(j, str, str2);
                }
            }

            public void d(String str, String str2) {
                d.this.uo = 6;
                if (d.this.b != null) {
                    d.this.b.d(str, str2);
                }
            }
        };

        @Override // com.bytedance.msdk.hc.b
        public boolean jh() {
            return true;
        }

        d(com.bytedance.sdk.openadsdk.w.b.hc.tc tcVar, boolean z, boolean z2) {
            Map mapDe;
            this.mq = tcVar;
            com.bytedance.sdk.openadsdk.w.b.hc.b bVarRf = tcVar.rf();
            if (bVarRf != null) {
                de(bVarRf.d());
                v(bVarRf.b());
                yi(bVarRf.c());
                he(bVarRf.hc());
                HashMap map = new HashMap();
                Map<? extends String, ? extends String> mapU = bVarRf.u();
                if (mapU != null && mapU.size() > 0) {
                    map.putAll(mapU);
                }
                u(map);
                if (com.bytedance.msdk.d.b.hc.d("5.1.0.0")) {
                    np(bVarRf.an());
                }
                if (com.bytedance.msdk.d.b.hc.d("5.4.0.3")) {
                    mq(bVarRf.h());
                }
                if (com.bytedance.msdk.d.b.hc.d("6.8.1.6")) {
                    tc(bVarRf.gb());
                }
                mk(bVarRf.tt());
            }
            hc(z2 ? 1 : 0);
            us(tcVar.h());
            z(tcVar.gb());
            j(tcVar.tt());
            vv(tcVar.k() != null ? tcVar.k().b() : null);
            mk(tcVar.w());
            mq(tcVar.cb());
            fs(tcVar.uo());
            c(tcVar.tc());
            gb(tcVar.cb() == 4);
            h(false);
            if (tcVar.w() == 16 || tcVar.w() == 3 || tcVar.w() == 2 || tcVar.w() == 131) {
                if (tcVar.e() != null && !tcVar.e().isEmpty() && tcVar.e().get(0) != null) {
                    com.bytedance.sdk.openadsdk.w.b.hc.mq mqVar = (com.bytedance.sdk.openadsdk.w.b.hc.mq) tcVar.e().get(0);
                    zw(mqVar.b());
                    rf(mqVar.d());
                    yo(mqVar.hc());
                }
            } else if (tcVar.w() == 4) {
                if (tcVar.e() != null && tcVar.e().size() > 0) {
                    ArrayList arrayList = new ArrayList();
                    Iterator it = tcVar.e().iterator();
                    while (it.hasNext()) {
                        arrayList.add(((com.bytedance.sdk.openadsdk.w.b.hc.mq) it.next()).b());
                    }
                    d((List<String>) arrayList);
                }
            } else {
                com.bytedance.sdk.openadsdk.w.b.hc.mq mqVarU = tcVar.u();
                if (mqVarU == null && tcVar.e() != null && !tcVar.e().isEmpty() && tcVar.e().get(0) != null) {
                    mqVarU = (com.bytedance.sdk.openadsdk.w.b.hc.mq) tcVar.e().get(0);
                }
                if (mqVarU != null) {
                    zw(mqVarU.b());
                    rf(mqVarU.d());
                    yo(mqVarU.hc());
                }
            }
            if (z && (mapDe = tcVar.de()) != null) {
                double d = com.bytedance.msdk.d.b.hc.d(mapDe.get("price"));
                com.bytedance.msdk.d.u.b.d("TTMediationSDK_ECMP", "pangle native 返回的 cpm价格：".concat(String.valueOf(d)));
                d(d <= 0.0d ? 0.0d : d);
            }
            this.mq.d(this.tc);
            this.mq.d(this.mk);
            new HashMap();
            d(IDJXAd.AD_CODE_ID, Long.valueOf(yb()));
            d(n.o, Long.valueOf(xi()));
            d("duration", Double.valueOf(this.mq.d()));
            Map<String, Object> mapDe2 = this.mq.de();
            if (mapDe2 != null) {
                c(mapDe2);
                d("log_extra", mapDe2.toString());
            }
        }

        @Override // com.bytedance.msdk.hc.b
        public Map<String, Object> j() {
            Map mapDe;
            com.bytedance.sdk.openadsdk.w.b.hc.tc tcVar = this.mq;
            if (tcVar == null || (mapDe = tcVar.de()) == null) {
                return null;
            }
            HashMap map = new HashMap();
            map.put("coupon", mapDe.get("coupon"));
            map.put("live_room", mapDe.get("live_room"));
            map.put("product", mapDe.get("product"));
            b(map);
            return super.j();
        }

        private void hc(ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, List<View> list4, View view) {
            com.bytedance.sdk.openadsdk.w.b.hc.tc tcVar = this.mq;
            if (tcVar != null) {
                tcVar.d(this.mk);
                try {
                    this.mq.d(new com.bytedance.sdk.openadsdk.v.d.hc.d.hc(null) { // from class: com.bytedance.msdk.b.b.hc.d.hc.gb.d.1
                        public void d(int i) {
                            if (d.this.u != null) {
                                d.this.u.d(i);
                            }
                        }
                    });
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.mq.d(th);
                }
                this.mq.d(viewGroup, list, list2, list3, list4, view, this.tt);
            }
        }

        @Override // com.bytedance.msdk.hc.b
        public void d(ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, List<View> list4, View view) {
            super.d(viewGroup, list, list2, list3, list4, view);
            hc(viewGroup, list, list2, list3, list4, view);
        }

        @Override // com.bytedance.msdk.hc.b
        public void d(com.bytedance.sdk.openadsdk.w.b.d.hc hcVar) {
            this.mq.d(hcVar);
        }

        @Override // com.bytedance.msdk.hc.b
        public void d(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, com.bytedance.msdk.api.c.d.h.tc tcVar, List<View> list4) {
            FrameLayout frameLayout;
            com.bytedance.sdk.openadsdk.w.b.hc.tc tcVar2;
            View viewSy;
            com.bytedance.sdk.openadsdk.w.b.hc.tc tcVar3;
            View viewFindViewById;
            super.d(activity, viewGroup, list, list2, list3, tcVar, list4);
            hc(viewGroup, null, list, list2, list3, null);
            com.bytedance.sdk.openadsdk.w.b.hc.tc tcVar4 = this.mq;
            if (tcVar4 != null && tcVar4.an() != null && tcVar != null && (viewFindViewById = viewGroup.findViewById(tcVar.mq)) != null) {
                viewFindViewById.setVisibility(0);
                if (viewFindViewById instanceof ViewGroup) {
                    ViewGroup viewGroup2 = (ViewGroup) viewFindViewById;
                    viewGroup2.removeAllViews();
                    ImageView imageView = new ImageView(viewGroup.getContext());
                    imageView.setImageBitmap(this.mq.an());
                    imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                    ViewGroup.LayoutParams layoutParams = viewFindViewById.getLayoutParams();
                    layoutParams.width = com.bytedance.msdk.d.u.h.hc(viewGroup.getContext(), 38.0f);
                    layoutParams.height = com.bytedance.msdk.d.u.h.hc(viewGroup.getContext(), 38.0f);
                    viewFindViewById.setLayoutParams(layoutParams);
                    viewGroup2.addView(imageView, -1, -1);
                } else if (viewFindViewById instanceof ImageView) {
                    ((ImageView) viewFindViewById).setImageBitmap(this.mq.an());
                }
            }
            if ((mt() && (tcVar3 = this.mq) != null && tcVar3.hc() != null && !TextUtils.isEmpty(this.mq.hc().d())) || tcVar == null || (frameLayout = (FrameLayout) viewGroup.findViewById(tcVar.h)) == null || (tcVar2 = this.mq) == null || (viewSy = tcVar2.sy()) == null) {
                return;
            }
            hc(viewSy);
            frameLayout.removeAllViews();
            frameLayout.addView(viewSy, -1, -1);
        }

        @Override // com.bytedance.msdk.hc.b
        public int mg() {
            com.bytedance.sdk.openadsdk.w.b.hc.tc tcVar = this.mq;
            if (tcVar != null) {
                return tcVar.b();
            }
            return 0;
        }

        @Override // com.bytedance.msdk.hc.b
        public int pa() {
            com.bytedance.sdk.openadsdk.w.b.hc.tc tcVar = this.mq;
            if (tcVar != null) {
                return tcVar.c();
            }
            return 0;
        }

        @Override // com.bytedance.msdk.hc.b
        public View tc() {
            com.bytedance.sdk.openadsdk.w.b.hc.tc tcVar = this.mq;
            if (tcVar != null) {
                return tcVar.sy();
            }
            return null;
        }

        @Override // com.bytedance.msdk.hc.b
        public String h() {
            com.bytedance.sdk.openadsdk.w.b.hc.tc tcVar;
            if (!mt() || (tcVar = this.mq) == null || tcVar.hc() == null) {
                return null;
            }
            return this.mq.hc().d();
        }

        @Override // com.bytedance.msdk.hc.b
        public Bitmap uq() {
            com.bytedance.sdk.openadsdk.w.b.hc.tc tcVar = this.mq;
            if (tcVar != null) {
                return tcVar.an();
            }
            return super.uq();
        }

        @Override // com.bytedance.msdk.hc.b
        public double bd() {
            com.bytedance.sdk.openadsdk.w.b.hc.tc tcVar = this.mq;
            if (tcVar != null) {
                return tcVar.d();
            }
            return super.bd();
        }

        @Override // com.bytedance.msdk.hc.b
        public com.bytedance.sdk.openadsdk.w.b.hc.mq n() {
            com.bytedance.sdk.openadsdk.w.b.hc.tc tcVar = this.mq;
            if (tcVar != null) {
                return tcVar.u();
            }
            return super.n();
        }

        @Override // com.bytedance.msdk.hc.b
        public int dr() {
            com.bytedance.sdk.openadsdk.w.b.hc.tc tcVar = this.mq;
            if (tcVar != null) {
                return tcVar.mk();
            }
            return super.dr();
        }

        @Override // com.bytedance.msdk.hc.b
        public void hc(Activity activity) {
            com.bytedance.sdk.openadsdk.w.b.hc.tc tcVar = this.mq;
            if (tcVar != null) {
                tcVar.hc(activity);
            }
        }

        @Override // com.bytedance.msdk.hc.b
        public void yo() {
            com.bytedance.sdk.openadsdk.w.b.hc.tc tcVar = this.mq;
            if (tcVar != null) {
                tcVar.d((com.bytedance.sdk.openadsdk.v.d.hc.d.d) null);
                this.mq.np();
                this.mq = null;
            }
        }

        @Override // com.bytedance.msdk.hc.b
        public boolean u() {
            return this.mq == null;
        }

        @Override // com.bytedance.msdk.hc.b
        public String ai() {
            com.bytedance.sdk.openadsdk.w.b.hc.tc tcVar = this.mq;
            if (tcVar != null) {
                return com.bytedance.msdk.d.b.hc.b((Map<String, Object>) tcVar.de());
            }
            return null;
        }

        @Override // com.bytedance.msdk.hc.b
        public void d() {
            com.bytedance.sdk.openadsdk.w.b.hc.tc tcVar = this.mq;
            if (tcVar == null || tcVar.jh() == null || this.uo != 2) {
                return;
            }
            this.mq.jh().d();
        }

        @Override // com.bytedance.msdk.hc.b
        public void hc() {
            com.bytedance.sdk.openadsdk.w.b.hc.tc tcVar = this.mq;
            if (tcVar == null || tcVar.jh() == null || this.uo != 3) {
                return;
            }
            this.mq.jh().d();
        }

        @Override // com.bytedance.msdk.hc.b
        public void b() {
            com.bytedance.sdk.openadsdk.w.b.hc.tc tcVar = this.mq;
            if (tcVar == null || tcVar.jh() == null) {
                return;
            }
            this.mq.jh().hc();
        }

        @Override // com.bytedance.msdk.hc.b
        public int c() {
            return this.uo;
        }

        @Override // com.bytedance.msdk.hc.b
        public long xi() {
            com.bytedance.sdk.openadsdk.w.b.hc.tc tcVar = this.mq;
            if (tcVar != null) {
                return com.bytedance.msdk.d.b.hc.d((Map<String, Object>) tcVar.de());
            }
            return 0L;
        }

        @Override // com.bytedance.msdk.hc.b
        public long yb() {
            com.bytedance.sdk.openadsdk.w.b.hc.tc tcVar = this.mq;
            if (tcVar != null) {
                return com.bytedance.msdk.d.b.hc.hc((Map<String, Object>) tcVar.de());
            }
            return 0L;
        }

        @Override // com.bytedance.msdk.hc.b
        public void d(Activity activity, com.bytedance.sdk.openadsdk.jh.d.hc.d.d dVar) {
            if (this.mq != null) {
                com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "pangle native:  activity = " + activity + " pluginDislikeInteractionCallback:" + dVar);
                this.mq.d(activity, dVar);
            }
        }

        @Override // com.bytedance.msdk.hc.b
        public void d(Dialog dialog, Integer[] numArr) {
            if (this.mq != null) {
                com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "pangle native:  ttDislikeDialogAbstract = ".concat(String.valueOf(dialog)));
                this.mq.hc(dialog, numArr);
            }
        }

        @Override // com.bytedance.msdk.hc.b
        public com.bytedance.sdk.openadsdk.w.b.hc.h d(Activity activity) {
            if (this.mq == null) {
                return null;
            }
            com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "pangle native : getDislikeDialog = ".concat(String.valueOf(activity)));
            return this.mq.d(activity);
        }

        @Override // com.bytedance.msdk.hc.b
        public com.bytedance.sdk.openadsdk.w.b.hc.h hc(Dialog dialog, Integer[] numArr) {
            if (this.mq == null) {
                return null;
            }
            com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "pangle native : getDislikeDialog = ".concat(String.valueOf(dialog)));
            return this.mq.d(dialog, numArr);
        }

        @Override // com.bytedance.msdk.hc.b
        public com.bytedance.sdk.openadsdk.w.b.hc.c vg() {
            if (this.mq == null) {
                return null;
            }
            com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "pangle native : getDislikeInfo");
            return this.mq.yo();
        }

        @Override // com.bytedance.msdk.hc.b
        public void mt(String str) {
            if (this.mq != null) {
                com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "pangle native : uploadDislikeEvent event = ".concat(String.valueOf(str)));
                this.mq.d(str);
            }
        }

        @Override // com.bytedance.msdk.hc.b
        public com.bytedance.msdk.api.c.d.h.u gb() {
            if (mt()) {
                return new com.bytedance.msdk.api.c.d.h.u() { // from class: com.bytedance.msdk.b.b.hc.d.hc.gb.d.5
                    @Override // com.bytedance.msdk.api.c.d.h.u
                    public void d(long j) {
                        if (d.this.mq == null || d.this.mq.hc() == null) {
                            return;
                        }
                        d.this.mq.hc().d(j);
                    }

                    @Override // com.bytedance.msdk.api.c.d.h.u
                    public void hc(long j) {
                        if (d.this.mq == null || d.this.mq.hc() == null) {
                            return;
                        }
                        d.this.mq.hc().hc(j);
                    }

                    @Override // com.bytedance.msdk.api.c.d.h.u
                    public void d() {
                        if (d.this.mq == null || d.this.mq.hc() == null) {
                            return;
                        }
                        d.this.mq.hc().b();
                    }

                    @Override // com.bytedance.msdk.api.c.d.h.u
                    public void b(long j) {
                        if (d.this.mq == null || d.this.mq.hc() == null) {
                            return;
                        }
                        d.this.mq.hc().b(j);
                    }

                    @Override // com.bytedance.msdk.api.c.d.h.u
                    public void hc() {
                        if (d.this.mq == null || d.this.mq.hc() == null) {
                            return;
                        }
                        d.this.mq.hc().c();
                    }

                    @Override // com.bytedance.msdk.api.c.d.h.u
                    public void d(int i, int i2) {
                        if (d.this.mq == null || d.this.mq.hc() == null) {
                            return;
                        }
                        d.this.mq.hc().d(i, i2);
                    }

                    @Override // com.bytedance.msdk.api.c.d.h.u
                    public void d(long j, int i, int i2) {
                        if (d.this.mq == null || d.this.mq.hc() == null) {
                            return;
                        }
                        d.this.mq.hc().d(j, i, i2);
                    }
                };
            }
            return null;
        }
    }
}
