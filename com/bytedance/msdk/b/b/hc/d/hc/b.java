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

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class b {
    public void d(final boolean z, z zVar, com.bytedance.sdk.openadsdk.w.b.b.hc hcVar, final com.bytedance.msdk.b.b.hc.d.hc hcVar2) {
        if (zVar == null || hcVar2 == null) {
            return;
        }
        zVar.d(hcVar, new com.bytedance.sdk.openadsdk.sy.d.hc.d.hc(null) { // from class: com.bytedance.msdk.b.b.hc.d.hc.b.1
            public void d(int i, String str) {
                hcVar2.d(new com.bytedance.msdk.api.d(i, str));
            }

            public void d(List<com.bytedance.sdk.openadsdk.w.b.hc.tt> list) {
                if (list == null || list.isEmpty()) {
                    hcVar2.d(new com.bytedance.msdk.api.d(80001, "load成功但返回广告是空"));
                    return;
                }
                ArrayList arrayList = new ArrayList();
                Iterator<com.bytedance.sdk.openadsdk.w.b.hc.tt> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(new d(it.next(), z));
                }
                hcVar2.d(arrayList);
            }
        });
    }

    private static class d extends com.bytedance.msdk.hc.b {
        private com.bytedance.sdk.openadsdk.w.b.hc.tt mk;
        private int mq;
        com.bytedance.sdk.openadsdk.yi.d.hc.d.d tt = new com.bytedance.sdk.openadsdk.yi.d.hc.d.d(0 == true ? 1 : 0) { // from class: com.bytedance.msdk.b.b.hc.d.hc.b.d.3
            public void d(View view, uo uoVar) {
                if (d.this.an != null) {
                    d.this.an.d(view);
                }
            }

            public void hc(View view, uo uoVar) {
                if (d.this.an != null) {
                    d.this.an.d(view);
                }
            }

            public void d(uo uoVar) {
                if (d.this.an != null) {
                    d.this.an.d();
                }
            }
        };
        com.bytedance.sdk.openadsdk.v.d.hc.d.d tc = new com.bytedance.sdk.openadsdk.v.d.hc.d.d(0 == true ? 1 : 0) { // from class: com.bytedance.msdk.b.b.hc.d.hc.b.d.4
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

        @Override // com.bytedance.msdk.hc.b
        public boolean jh() {
            return true;
        }

        d(com.bytedance.sdk.openadsdk.w.b.hc.tt ttVar, boolean z) {
            Map mapDe;
            this.mk = ttVar;
            com.bytedance.sdk.openadsdk.w.b.hc.b bVarRf = ttVar.rf();
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
            us(ttVar.h());
            z(ttVar.gb());
            j(ttVar.tt());
            vv(ttVar.k() != null ? ttVar.k().b() : null);
            mk(ttVar.w());
            mq(ttVar.cb());
            fs(ttVar.uo());
            c(ttVar.tc());
            gb(ttVar.cb() == 4);
            h(false);
            if (ttVar.w() == 16 || ttVar.w() == 3 || ttVar.w() == 2 || ttVar.w() == 131) {
                if (ttVar.e() != null && !ttVar.e().isEmpty() && ttVar.e().get(0) != null) {
                    com.bytedance.sdk.openadsdk.w.b.hc.mq mqVar = (com.bytedance.sdk.openadsdk.w.b.hc.mq) ttVar.e().get(0);
                    zw(mqVar.b());
                    rf(mqVar.d());
                    yo(mqVar.hc());
                }
            } else if (ttVar.w() == 4) {
                if (ttVar.e() != null && ttVar.e().size() > 0) {
                    ArrayList arrayList = new ArrayList();
                    Iterator it = ttVar.e().iterator();
                    while (it.hasNext()) {
                        arrayList.add(((com.bytedance.sdk.openadsdk.w.b.hc.mq) it.next()).b());
                    }
                    d((List<String>) arrayList);
                }
            } else {
                com.bytedance.sdk.openadsdk.w.b.hc.mq mqVarU = ttVar.u();
                if (mqVarU == null && ttVar.e() != null && !ttVar.e().isEmpty() && ttVar.e().get(0) != null) {
                    mqVarU = (com.bytedance.sdk.openadsdk.w.b.hc.mq) ttVar.e().get(0);
                }
                if (mqVarU != null) {
                    zw(mqVarU.b());
                    rf(mqVarU.d());
                    yo(mqVarU.hc());
                }
            }
            if (z && (mapDe = ttVar.de()) != null) {
                double d = com.bytedance.msdk.d.b.hc.d(mapDe.get("price"));
                com.bytedance.msdk.d.u.b.d("TTMediationSDK_ECMP", "pangle draw 返回的 cpm价格：".concat(String.valueOf(d)));
                d(d <= 0.0d ? 0.0d : d);
            }
            this.mk.d(this.tc);
            d(IDJXAd.AD_CODE_ID, Long.valueOf(yb()));
            d(n.o, Long.valueOf(xi()));
            d("duration", Double.valueOf(this.mk.d()));
            Map<String, Object> mapDe2 = this.mk.de();
            if (mapDe2 != null) {
                c(mapDe2);
                d("log_extra", mapDe2.toString());
            }
        }

        @Override // com.bytedance.msdk.hc.b
        public Map<String, Object> j() {
            Map<String, Object> mapDe;
            com.bytedance.sdk.openadsdk.w.b.hc.tt ttVar = this.mk;
            if (ttVar == null || (mapDe = ttVar.de()) == null) {
                return null;
            }
            b(mapDe);
            return super.j();
        }

        @Override // com.bytedance.msdk.hc.b
        public void d(ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, List<View> list4, View view) {
            super.d(viewGroup, list, list2, list3, list4, view);
            hc(viewGroup, list, list2, list3, list4, view);
        }

        @Override // com.bytedance.msdk.hc.b
        public void d(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, com.bytedance.msdk.api.c.d.h.tc tcVar, List<View> list4) {
            FrameLayout frameLayout;
            com.bytedance.sdk.openadsdk.w.b.hc.tt ttVar;
            View viewSy;
            com.bytedance.sdk.openadsdk.w.b.hc.tt ttVar2;
            View viewFindViewById;
            super.d(activity, viewGroup, list, list2, list3, tcVar, list4);
            hc(viewGroup, null, list, list2, list3, null);
            com.bytedance.sdk.openadsdk.w.b.hc.tt ttVar3 = this.mk;
            if (ttVar3 != null && ttVar3.an() != null && tcVar != null && (viewFindViewById = viewGroup.findViewById(tcVar.mq)) != null) {
                viewFindViewById.setVisibility(0);
                if (viewFindViewById instanceof ViewGroup) {
                    ViewGroup viewGroup2 = (ViewGroup) viewFindViewById;
                    viewGroup2.removeAllViews();
                    ImageView imageView = new ImageView(viewGroup.getContext());
                    imageView.setImageBitmap(this.mk.an());
                    imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                    ViewGroup.LayoutParams layoutParams = viewFindViewById.getLayoutParams();
                    layoutParams.width = com.bytedance.msdk.d.u.h.hc(viewGroup.getContext(), 38.0f);
                    layoutParams.height = com.bytedance.msdk.d.u.h.hc(viewGroup.getContext(), 38.0f);
                    viewFindViewById.setLayoutParams(layoutParams);
                    viewGroup2.addView(imageView, -1, -1);
                } else if (viewFindViewById instanceof ImageView) {
                    ((ImageView) viewFindViewById).setImageBitmap(this.mk.an());
                }
            }
            if ((mt() && (ttVar2 = this.mk) != null && ttVar2.hc() != null && !TextUtils.isEmpty(this.mk.hc().d())) || tcVar == null || (frameLayout = (FrameLayout) viewGroup.findViewById(tcVar.h)) == null || (ttVar = this.mk) == null || (viewSy = ttVar.sy()) == null) {
                return;
            }
            hc(viewSy);
            frameLayout.removeAllViews();
            frameLayout.addView(viewSy, -1, -1);
        }

        private void hc(ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, List<View> list4, View view) {
            com.bytedance.sdk.openadsdk.w.b.hc.tt ttVar = this.mk;
            if (ttVar != null) {
                try {
                    ttVar.d(new com.bytedance.sdk.openadsdk.v.d.hc.d.hc(null) { // from class: com.bytedance.msdk.b.b.hc.d.hc.b.d.1
                        public void d(int i) {
                            if (d.this.u != null) {
                                d.this.u.d(i);
                            }
                        }
                    });
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.mq.d(th);
                }
                this.mk.d(viewGroup, list, list2, list3, list4, view, this.tt);
            }
        }

        @Override // com.bytedance.msdk.hc.b
        public int mg() {
            com.bytedance.sdk.openadsdk.w.b.hc.tt ttVar = this.mk;
            if (ttVar != null) {
                return ttVar.b();
            }
            return 0;
        }

        @Override // com.bytedance.msdk.hc.b
        public int pa() {
            com.bytedance.sdk.openadsdk.w.b.hc.tt ttVar = this.mk;
            if (ttVar != null) {
                return ttVar.c();
            }
            return 0;
        }

        @Override // com.bytedance.msdk.hc.b
        public String h() {
            com.bytedance.sdk.openadsdk.w.b.hc.tt ttVar;
            if (!mt() || (ttVar = this.mk) == null || ttVar.hc() == null) {
                return null;
            }
            return this.mk.hc().d();
        }

        @Override // com.bytedance.msdk.hc.b
        public com.bytedance.msdk.api.c.d.h.u gb() {
            if (mt()) {
                return new com.bytedance.msdk.api.c.d.h.u() { // from class: com.bytedance.msdk.b.b.hc.d.hc.b.d.2
                    @Override // com.bytedance.msdk.api.c.d.h.u
                    public void d(long j) {
                        if (d.this.mk == null || d.this.mk.hc() == null) {
                            return;
                        }
                        d.this.mk.hc().d(j);
                    }

                    @Override // com.bytedance.msdk.api.c.d.h.u
                    public void hc(long j) {
                        if (d.this.mk == null || d.this.mk.hc() == null) {
                            return;
                        }
                        d.this.mk.hc().hc(j);
                    }

                    @Override // com.bytedance.msdk.api.c.d.h.u
                    public void d() {
                        if (d.this.mk == null || d.this.mk.hc() == null) {
                            return;
                        }
                        d.this.mk.hc().b();
                    }

                    @Override // com.bytedance.msdk.api.c.d.h.u
                    public void b(long j) {
                        if (d.this.mk == null || d.this.mk.hc() == null) {
                            return;
                        }
                        d.this.mk.hc().b(j);
                    }

                    @Override // com.bytedance.msdk.api.c.d.h.u
                    public void hc() {
                        if (d.this.mk == null || d.this.mk.hc() == null) {
                            return;
                        }
                        d.this.mk.hc().c();
                    }

                    @Override // com.bytedance.msdk.api.c.d.h.u
                    public void d(int i, int i2) {
                        if (d.this.mk == null || d.this.mk.hc() == null) {
                            return;
                        }
                        d.this.mk.hc().d(i, i2);
                    }

                    @Override // com.bytedance.msdk.api.c.d.h.u
                    public void d(long j, int i, int i2) {
                        if (d.this.mk == null || d.this.mk.hc() == null) {
                            return;
                        }
                        d.this.mk.hc().d(j, i, i2);
                    }
                };
            }
            return null;
        }

        @Override // com.bytedance.msdk.hc.b
        public void yo() {
            com.bytedance.sdk.openadsdk.w.b.hc.tt ttVar = this.mk;
            if (ttVar != null) {
                ttVar.d((com.bytedance.sdk.openadsdk.v.d.hc.d.d) null);
                this.mk = null;
            }
        }

        @Override // com.bytedance.msdk.hc.b
        public boolean u() {
            return this.mk == null;
        }

        @Override // com.bytedance.msdk.hc.b
        public String ai() {
            com.bytedance.sdk.openadsdk.w.b.hc.tt ttVar = this.mk;
            return ttVar != null ? com.bytedance.msdk.d.b.hc.b((Map<String, Object>) ttVar.de()) : "";
        }

        @Override // com.bytedance.msdk.hc.b
        public void d() {
            com.bytedance.sdk.openadsdk.w.b.hc.tt ttVar = this.mk;
            if (ttVar == null || ttVar.jh() == null || this.mq != 2) {
                return;
            }
            this.mk.jh().d();
        }

        @Override // com.bytedance.msdk.hc.b
        public void hc() {
            com.bytedance.sdk.openadsdk.w.b.hc.tt ttVar = this.mk;
            if (ttVar == null || ttVar.jh() == null || this.mq != 3) {
                return;
            }
            this.mk.jh().d();
        }

        @Override // com.bytedance.msdk.hc.b
        public void b() {
            com.bytedance.sdk.openadsdk.w.b.hc.tt ttVar = this.mk;
            if (ttVar == null || ttVar.jh() == null) {
                return;
            }
            this.mk.jh().hc();
        }

        @Override // com.bytedance.msdk.hc.b
        public int c() {
            return this.mq;
        }

        @Override // com.bytedance.msdk.hc.b
        public long xi() {
            com.bytedance.sdk.openadsdk.w.b.hc.tt ttVar = this.mk;
            if (ttVar != null) {
                return com.bytedance.msdk.d.b.hc.d((Map<String, Object>) ttVar.de());
            }
            return 0L;
        }

        @Override // com.bytedance.msdk.hc.b
        public long yb() {
            com.bytedance.sdk.openadsdk.w.b.hc.tt ttVar = this.mk;
            if (ttVar != null) {
                return com.bytedance.msdk.d.b.hc.hc((Map<String, Object>) ttVar.de());
            }
            return 0L;
        }

        @Override // com.bytedance.msdk.hc.b
        public void d(Activity activity, com.bytedance.sdk.openadsdk.jh.d.hc.d.d dVar) {
            if (this.mk != null) {
                com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "pangle draw :  activity = " + activity + " pluginDislikeInteractionCallback:" + dVar);
                this.mk.d(activity, dVar);
            }
        }

        @Override // com.bytedance.msdk.hc.b
        public void d(Dialog dialog, Integer[] numArr) {
            if (this.mk != null) {
                com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "pangle draw :  ttDislikeDialogAbstract = ".concat(String.valueOf(dialog)));
                this.mk.hc(dialog, numArr);
            }
        }

        @Override // com.bytedance.msdk.hc.b
        public com.bytedance.sdk.openadsdk.w.b.hc.h d(Activity activity) {
            if (this.mk != null) {
                com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "pangle draw : getDislikeDialog = ".concat(String.valueOf(activity)));
                return this.mk.d(activity);
            }
            return super.d(activity);
        }

        @Override // com.bytedance.msdk.hc.b
        public com.bytedance.sdk.openadsdk.w.b.hc.h hc(Dialog dialog, Integer[] numArr) {
            if (this.mk == null) {
                return null;
            }
            com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "pangle draw : getDislikeDialog = ".concat(String.valueOf(dialog)));
            return this.mk.d(dialog, numArr);
        }

        @Override // com.bytedance.msdk.hc.b
        public com.bytedance.sdk.openadsdk.w.b.hc.c vg() {
            if (this.mk == null) {
                return null;
            }
            com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "pangle draw : getDislikeInfo");
            return this.mk.yo();
        }

        @Override // com.bytedance.msdk.hc.b
        public void mt(String str) {
            if (this.mk != null) {
                com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "pangle draw : uploadDislikeEvent event = ".concat(String.valueOf(str)));
                this.mk.d(str);
            }
        }

        @Override // com.bytedance.msdk.hc.b
        public View tc() {
            if (this.mk == null) {
                return null;
            }
            com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "pangle draw : getVideoView = " + this.mk.sy());
            return this.mk.sy();
        }

        @Override // com.bytedance.msdk.hc.b
        public void tc(boolean z) {
            com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "pangle draw : setCanInterruptVideoPlay b = ".concat(String.valueOf(z)));
            com.bytedance.sdk.openadsdk.w.b.hc.tt ttVar = this.mk;
            if (ttVar != null) {
                ttVar.d(z);
            }
        }

        @Override // com.bytedance.msdk.hc.b
        public void d(Bitmap bitmap, int i) {
            com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "pangle draw : setPauseIcon bitmap = " + bitmap + " i = " + i);
            com.bytedance.sdk.openadsdk.w.b.hc.tt ttVar = this.mk;
            if (ttVar != null) {
                ttVar.d(bitmap, i);
            }
        }

        @Override // com.bytedance.msdk.hc.b
        public void d(com.bytedance.sdk.openadsdk.de.d.hc.d.d dVar) {
            com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "pangle draw : setDrawVideoListener pluginDrawVideoListener = ".concat(String.valueOf(dVar)));
            com.bytedance.sdk.openadsdk.w.b.hc.tt ttVar = this.mk;
            if (ttVar != null) {
                ttVar.d(dVar);
            }
        }

        @Override // com.bytedance.msdk.hc.b
        public double bd() {
            if (this.mk != null) {
                com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "pangle draw : getVideoDuration = " + this.mk.d());
                return this.mk.d();
            }
            return super.bd();
        }

        @Override // com.bytedance.msdk.hc.b
        public com.bytedance.sdk.openadsdk.w.b.hc.mq n() {
            if (this.mk != null) {
                com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "pangle draw : getVideoCoverImage = " + this.mk.u());
                return this.mk.u();
            }
            return super.n();
        }

        @Override // com.bytedance.msdk.hc.b
        public Bitmap uq() {
            if (this.mk != null) {
                com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "pangle draw : getAdLogo = " + this.mk.an());
                return this.mk.an();
            }
            return super.uq();
        }

        @Override // com.bytedance.msdk.hc.b
        public int dr() {
            if (this.mk != null) {
                com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "pangle draw : getAppCommentNum = " + this.mk.mk());
                return this.mk.mk();
            }
            return super.dr();
        }

        @Override // com.bytedance.msdk.hc.b
        public com.bytedance.sdk.openadsdk.w.b.hc.u vs() {
            com.bytedance.sdk.openadsdk.w.b.hc.tt ttVar = this.mk;
            if (ttVar != null) {
                com.bytedance.sdk.openadsdk.w.b.hc.u uVarJh = ttVar.jh();
                com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "pangle draw : getDownloadStatusController = ".concat(String.valueOf(uVarJh)));
                return uVarJh;
            }
            return super.vs();
        }

        @Override // com.bytedance.msdk.hc.b
        public void d(com.bytedance.sdk.openadsdk.w.b.d.b bVar) {
            com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "pangle draw : setDownloadListener pluginTTAppDownloadListener = ".concat(String.valueOf(bVar)));
            com.bytedance.sdk.openadsdk.w.b.hc.tt ttVar = this.mk;
            if (ttVar != null) {
                ttVar.d(bVar);
            }
        }

        @Override // com.bytedance.msdk.hc.b
        public void hc(Activity activity) {
            com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "pangle draw : setActivityForDownloadApp  activity = ".concat(String.valueOf(activity)));
            com.bytedance.sdk.openadsdk.w.b.hc.tt ttVar = this.mk;
            if (ttVar != null) {
                ttVar.hc(activity);
            }
        }
    }
}
