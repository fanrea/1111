package com.bytedance.msdk.b.b.hc.d.hc;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.core.z;
import com.bytedance.sdk.openadsdk.w.b.b.hc;
import com.bytedance.sdk.openadsdk.w.b.hc.k;
import com.bytedance.sdk.openadsdk.w.b.hc.uo;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d extends com.bytedance.msdk.b.b.hc.d.hc.hc {
    private com.bytedance.msdk.b.an.hc.hc b;
    private com.bytedance.msdk.api.d.hc hc;

    public d(com.bytedance.msdk.b.d.hc hcVar) {
        super(hcVar);
    }

    @Override // com.bytedance.msdk.b.b.hc.d.hc
    public void hc(Context context, com.bytedance.msdk.b.an.hc.hc hcVar, com.bytedance.msdk.api.d.hc hcVar2, Map<String, Object> map) {
        this.hc = hcVar2;
        this.b = hcVar;
        if (hcVar2 == null) {
            d(new com.bytedance.msdk.api.d("load ad fail adSlot is null"));
            return;
        }
        if (map != null) {
            Object obj = map.get("tt_ad_sub_type");
            if (obj != null && ((Integer) obj).intValue() == 4) {
                Object obj2 = map.get("tt_ad_origin_type");
                if (obj2 != null) {
                    int iIntValue = ((Integer) obj2).intValue();
                    if (iIntValue == 1) {
                        hc(context.getApplicationContext());
                        return;
                    } else if (iIntValue == 2) {
                        b(context.getApplicationContext());
                        return;
                    } else {
                        d(new com.bytedance.msdk.api.d(80001, "originType is mismatch"));
                        return;
                    }
                }
                return;
            }
            new b().d(context.getApplicationContext());
        }
    }

    private void hc(final Context context) {
        z zVarD = d(context);
        if (zVarD == null) {
            return;
        }
        hc.d dVarHc = com.bytedance.msdk.d.b.hc.d(this.hc, this.b.mq(), this.b.cb(), this.b.w(), this.b.yi(), false).d(this.hc.yi()).hc(this.hc.he());
        float fK = this.hc.k();
        float fE = this.hc.e();
        boolean zD = com.bytedance.msdk.d.b.hc.d(this.hc);
        com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "pangle banner native express autoHeight:" + zD + " width:" + fK + "  height:" + fE);
        if (fE > 0.0f && !zD) {
            dVarHc.d(fK).hc(fE);
        } else {
            dVarHc.d(fK).hc(0.0f);
        }
        zVarD.d(dVarHc.d(), new com.bytedance.sdk.openadsdk.sy.d.hc.d.an(null) { // from class: com.bytedance.msdk.b.b.hc.d.hc.d.1
            public void d(int i, String str) {
                d.this.d(new com.bytedance.msdk.api.d(i, str));
            }

            public void d(List<k> list) {
                if (list == null || list.size() == 0) {
                    d.this.d(new com.bytedance.msdk.api.d(80001, "load list is null or empty"));
                    return;
                }
                for (k kVar : list) {
                    if (kVar != null) {
                        d.this.new hc(context, kVar).mk();
                        return;
                    }
                }
            }
        });
    }

    private void b(final Context context) {
        z zVarD = d(context);
        if (zVarD == null) {
            return;
        }
        hc.d dVarD = com.bytedance.msdk.d.b.hc.d(this.hc, this.b.mq(), this.b.cb(), this.b.w(), this.b.yi(), false);
        dVarD.d(this.hc.yi()).hc(this.hc.he());
        zVarD.d(dVarD.d(), new com.bytedance.sdk.openadsdk.sy.d.hc.d.b(null) { // from class: com.bytedance.msdk.b.b.hc.d.hc.d.2
            public void d(int i, String str) {
                d.this.d(new com.bytedance.msdk.api.d(i, str));
            }

            public void d(List<com.bytedance.sdk.openadsdk.w.b.hc.tc> list) {
                if (list == null || list.isEmpty()) {
                    d.this.d(new com.bytedance.msdk.api.d(80001, "load list is null or empty"));
                    return;
                }
                ArrayList arrayList = new ArrayList(1);
                arrayList.add(d.this.new C0222d(context, list.get(0)));
                d.this.d(arrayList);
            }
        });
    }

    class hc extends com.bytedance.msdk.hc.b {
        private boolean mk;
        private volatile boolean mq = false;
        k tt;
        private final com.bytedance.sdk.openadsdk.he.d.hc.d.hc uo;

        /* JADX INFO: Access modifiers changed from: private */
        public com.bytedance.msdk.d.hc.d g() {
            return (com.bytedance.msdk.d.hc.d) this.h;
        }

        hc(Context context, k kVar) {
            Map mapGb;
            Function function = null;
            com.bytedance.sdk.openadsdk.he.d.hc.d.hc hcVar = new com.bytedance.sdk.openadsdk.he.d.hc.d.hc(function) { // from class: com.bytedance.msdk.b.b.hc.d.hc.d.hc.3
                public void d(View view, int i) {
                    if (hc.this.h instanceof com.bytedance.msdk.d.hc.d) {
                        hc.this.g().d(view);
                    }
                }

                public void hc(View view, int i) {
                    if (hc.this.h instanceof com.bytedance.msdk.d.hc.d) {
                        hc.this.g().hc(view);
                    }
                }

                public void d(View view, String str, int i) {
                    d.this.d(new com.bytedance.msdk.api.d(i, str));
                }

                public void d(View view, float f, float f2) {
                    ArrayList arrayList = new ArrayList(1);
                    arrayList.add(hc.this);
                    d.this.d(arrayList);
                }
            };
            this.uo = hcVar;
            this.tt = kVar;
            mk(kVar.hc());
            mq(this.tt.b());
            h(true);
            this.tt.d(hcVar);
            if (context instanceof Activity) {
                this.tt.d((Activity) context, new com.bytedance.sdk.openadsdk.jh.d.hc.d.d(function) { // from class: com.bytedance.msdk.b.b.hc.d.hc.d.hc.1
                    public void d() {
                    }

                    public void hc() {
                    }

                    public void d(int i, String str, boolean z) {
                        if (hc.this.mk) {
                            return;
                        }
                        hc.this.mk = true;
                        if (hc.this.h instanceof com.bytedance.msdk.d.hc.d) {
                            com.bytedance.msdk.core.hc.d.d(d.this.b.hc());
                            hc.this.g().f_();
                        }
                    }
                });
            }
            if (!d.this.b.d() || (mapGb = this.tt.gb()) == null) {
                return;
            }
            double d = com.bytedance.msdk.d.b.hc.d(mapGb.get("price"));
            com.bytedance.msdk.d.u.b.d("TTMediationSDK_ECMP", "banner混存 pangle 模板native 返回的 cpm价格：".concat(String.valueOf(d)));
            d(d <= 0.0d ? 0.0d : d);
        }

        @Override // com.bytedance.msdk.hc.b
        public Map<String, Object> j() {
            Map<String, Object> mapGb;
            k kVar = this.tt;
            if (kVar == null || (mapGb = kVar.gb()) == null) {
                return null;
            }
            com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "getMediaExtraInfo ".concat(String.valueOf(mapGb)));
            b(mapGb);
            return super.j();
        }

        @Override // com.bytedance.msdk.hc.b
        public void mk() {
            k kVar = this.tt;
            if (kVar != null) {
                kVar.c();
            }
        }

        @Override // com.bytedance.msdk.hc.b
        public View tt() {
            k kVar = this.tt;
            if (kVar != null) {
                return kVar.d();
            }
            return null;
        }

        @Override // com.bytedance.msdk.hc.b
        public String ai() {
            k kVar = this.tt;
            return kVar != null ? com.bytedance.msdk.d.b.hc.b((Map<String, Object>) kVar.gb()) : "";
        }

        @Override // com.bytedance.msdk.hc.b
        public void yo() {
            this.mq = true;
            com.bytedance.msdk.d.u.an.b(new Runnable() { // from class: com.bytedance.msdk.b.b.hc.d.hc.d.hc.2
                @Override // java.lang.Runnable
                public void run() {
                    if (hc.this.tt != null) {
                        hc.this.tt.u();
                    }
                }
            });
        }

        @Override // com.bytedance.msdk.hc.b
        public boolean u() {
            return this.mq;
        }

        @Override // com.bytedance.msdk.hc.b
        public long xi() {
            k kVar = this.tt;
            if (kVar != null) {
                return com.bytedance.msdk.d.b.hc.d((Map<String, Object>) kVar.gb());
            }
            return 0L;
        }

        @Override // com.bytedance.msdk.hc.b
        public long yb() {
            k kVar = this.tt;
            if (kVar != null) {
                return com.bytedance.msdk.d.b.hc.hc((Map<String, Object>) kVar.gb());
            }
            return 0L;
        }

        @Override // com.bytedance.msdk.hc.b
        public void d(Activity activity, final com.bytedance.sdk.openadsdk.jh.d.hc.d.d dVar) {
            if (this.tt != null) {
                com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "pangle banner-native express:  activity = " + activity + " pluginDislikeInteractionCallback:" + dVar);
                this.tt.d(activity, new com.bytedance.sdk.openadsdk.jh.d.hc.d.d(null) { // from class: com.bytedance.msdk.b.b.hc.d.hc.d.hc.4
                    public void d() {
                        com.bytedance.sdk.openadsdk.jh.d.hc.d.d dVar2 = dVar;
                        if (dVar2 != null) {
                            dVar2.d();
                        }
                    }

                    public void d(int i, String str, boolean z) {
                        if (hc.this.mk) {
                            return;
                        }
                        hc.this.mk = true;
                        com.bytedance.msdk.core.hc.d.d(d.this.b.hc());
                        com.bytedance.sdk.openadsdk.jh.d.hc.d.d dVar2 = dVar;
                        if (dVar2 != null) {
                            dVar2.d(i, str, z);
                        }
                    }

                    public void hc() {
                        com.bytedance.sdk.openadsdk.jh.d.hc.d.d dVar2 = dVar;
                        if (dVar2 != null) {
                            dVar2.hc();
                        }
                    }
                });
            }
        }

        @Override // com.bytedance.msdk.hc.b
        public void d(Dialog dialog, Integer[] numArr) {
            if (this.tt != null) {
                com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "pangle banner-native express:  ttDislikeDialogAbstract = ".concat(String.valueOf(dialog)));
                this.tt.d(dialog, numArr);
            }
        }

        @Override // com.bytedance.msdk.hc.b
        public com.bytedance.sdk.openadsdk.w.b.hc.h d(Activity activity) {
            k kVar = this.tt;
            if (kVar != null) {
                return kVar.d(activity);
            }
            return super.d(activity);
        }

        @Override // com.bytedance.msdk.hc.b
        public com.bytedance.sdk.openadsdk.w.b.hc.c vg() {
            k kVar = this.tt;
            if (kVar != null) {
                return kVar.an();
            }
            return super.vg();
        }

        @Override // com.bytedance.msdk.hc.b
        public void mt(String str) {
            com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "pangle banner express: uploadDislikeEvent event = ".concat(String.valueOf(str)));
            k kVar = this.tt;
            if (kVar != null) {
                kVar.d(str);
            }
        }

        @Override // com.bytedance.msdk.hc.b
        public void d(com.bytedance.sdk.openadsdk.w.b.d.b bVar) {
            com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "pangle banner express: setDownloadListener pluginTTAppDownloadListener = ".concat(String.valueOf(bVar)));
            k kVar = this.tt;
            if (kVar != null) {
                kVar.d(bVar);
            }
        }

        @Override // com.bytedance.msdk.hc.b
        public void d(com.bytedance.sdk.openadsdk.he.d.hc.d.b bVar) {
            com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "pangle banner express: setVideoAdListener pluginExpressVideoAdListener = ".concat(String.valueOf(bVar)));
            k kVar = this.tt;
            if (kVar != null) {
                kVar.d(bVar);
            }
        }

        @Override // com.bytedance.msdk.hc.b
        public void d(com.bytedance.sdk.openadsdk.w.b.d.hc hcVar) {
            com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "pangle banner express: setAdInteractionListener pluginTTAdInteractionListener = ".concat(String.valueOf(hcVar)));
            k kVar = this.tt;
            if (kVar != null) {
                kVar.d(hcVar);
            }
        }
    }

    /* renamed from: com.bytedance.msdk.b.b.hc.d.hc.d$d, reason: collision with other inner class name */
    class C0222d extends com.bytedance.msdk.hc.b {
        private com.bytedance.sdk.openadsdk.w.b.hc.tc mk;
        private Context mq;
        private boolean uo;
        private volatile boolean k = false;
        com.bytedance.sdk.openadsdk.yi.d.hc.d.d tt = new com.bytedance.sdk.openadsdk.yi.d.hc.d.d(0 == true ? 1 : 0) { // from class: com.bytedance.msdk.b.b.hc.d.hc.d.d.3
            public void d(View view, uo uoVar) {
                if (C0222d.this.h instanceof com.bytedance.msdk.d.hc.d) {
                    C0222d.this.g().d(view);
                }
            }

            public void hc(View view, uo uoVar) {
                if (C0222d.this.h instanceof com.bytedance.msdk.d.hc.d) {
                    C0222d.this.g().d(view);
                }
            }

            public void d(uo uoVar) {
                if (C0222d.this.h instanceof com.bytedance.msdk.d.hc.d) {
                    C0222d.this.g().hc(null);
                }
            }
        };

        @Override // com.bytedance.msdk.hc.b
        public boolean jh() {
            return true;
        }

        C0222d(Context context, com.bytedance.sdk.openadsdk.w.b.hc.tc tcVar) {
            Map mapDe;
            this.mk = tcVar;
            this.mq = context;
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
                if (com.bytedance.msdk.d.b.hc.d("5.4.0.3")) {
                    mq(bVarRf.h());
                }
                if (com.bytedance.msdk.d.b.hc.d("6.8.1.6")) {
                    tc(bVarRf.gb());
                }
                mk(bVarRf.tt());
            }
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
            } else if (tcVar.w() == 4 && tcVar.e() != null && tcVar.e().size() > 0) {
                ArrayList arrayList = new ArrayList();
                Iterator it = tcVar.e().iterator();
                while (it.hasNext()) {
                    arrayList.add(((com.bytedance.sdk.openadsdk.w.b.hc.mq) it.next()).b());
                }
                d((List<String>) arrayList);
            }
            mk(tcVar.w());
            if (!d.this.b.d() || (mapDe = tcVar.de()) == null) {
                return;
            }
            double d = com.bytedance.msdk.d.b.hc.d(mapDe.get("price"));
            com.bytedance.msdk.d.u.b.d("TTMediationSDK_ECMP", "pangle native 返回的 cpm价格：".concat(String.valueOf(d)));
            d(d <= 0.0d ? 0.0d : d);
        }

        @Override // com.bytedance.msdk.hc.b
        public Map<String, Object> j() {
            Map mapDe;
            com.bytedance.sdk.openadsdk.w.b.hc.tc tcVar = this.mk;
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

        @Override // com.bytedance.msdk.hc.b
        public void d(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, com.bytedance.msdk.api.c.d.h.tc tcVar, List<View> list4) {
            FrameLayout frameLayout;
            com.bytedance.sdk.openadsdk.w.b.hc.tc tcVar2;
            View viewSy;
            View viewFindViewById;
            super.d(activity, viewGroup, list, list2, list3, tcVar, list4);
            com.bytedance.sdk.openadsdk.w.b.hc.tc tcVar3 = this.mk;
            if (tcVar3 != null) {
                tcVar3.d(viewGroup, (List) null, list, list2, list3, (View) null, this.tt);
                this.mk.d(activity, new com.bytedance.sdk.openadsdk.jh.d.hc.d.d(null) { // from class: com.bytedance.msdk.b.b.hc.d.hc.d.d.1
                    public void d() {
                    }

                    public void hc() {
                    }

                    public void d(int i, String str, boolean z) {
                        if (C0222d.this.uo) {
                            return;
                        }
                        C0222d.this.uo = true;
                        if (C0222d.this.h instanceof com.bytedance.msdk.d.hc.d) {
                            com.bytedance.msdk.core.hc.d.d(d.this.b.hc());
                            C0222d.this.g().f_();
                        }
                    }
                });
            }
            com.bytedance.sdk.openadsdk.w.b.hc.tc tcVar4 = this.mk;
            if (tcVar4 != null && tcVar4.an() != null && tcVar != null && (viewFindViewById = viewGroup.findViewById(tcVar.mq)) != null) {
                viewFindViewById.setVisibility(0);
                if (viewFindViewById instanceof ViewGroup) {
                    ViewGroup viewGroup2 = (ViewGroup) viewFindViewById;
                    viewGroup2.removeAllViews();
                    ImageView imageView = new ImageView(this.mq);
                    imageView.setImageBitmap(this.mk.an());
                    imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                    ViewGroup.LayoutParams layoutParams = viewFindViewById.getLayoutParams();
                    layoutParams.width = com.bytedance.msdk.api.u.b(this.mq, 38.0f);
                    layoutParams.height = com.bytedance.msdk.api.u.b(this.mq, 38.0f);
                    viewFindViewById.setLayoutParams(layoutParams);
                    viewGroup2.addView(imageView, -1, -1);
                } else if (viewFindViewById instanceof ImageView) {
                    ((ImageView) viewFindViewById).setImageBitmap(this.mk.an());
                }
            }
            if (tcVar == null || (frameLayout = (FrameLayout) viewGroup.findViewById(tcVar.h)) == null || (tcVar2 = this.mk) == null || (viewSy = tcVar2.sy()) == null) {
                return;
            }
            hc(viewSy);
            frameLayout.removeAllViews();
            frameLayout.addView(viewSy, -1, -1);
        }

        @Override // com.bytedance.msdk.hc.b
        public int mg() {
            com.bytedance.sdk.openadsdk.w.b.hc.tc tcVar = this.mk;
            if (tcVar != null) {
                return tcVar.b();
            }
            return 0;
        }

        @Override // com.bytedance.msdk.hc.b
        public int pa() {
            com.bytedance.sdk.openadsdk.w.b.hc.tc tcVar = this.mk;
            if (tcVar != null) {
                return tcVar.c();
            }
            return 0;
        }

        @Override // com.bytedance.msdk.hc.b
        public void yo() {
            this.k = true;
            com.bytedance.msdk.d.u.an.b(new Runnable() { // from class: com.bytedance.msdk.b.b.hc.d.hc.d.d.2
                @Override // java.lang.Runnable
                public void run() {
                    if (C0222d.this.mk != null) {
                        C0222d.this.mk.d((com.bytedance.sdk.openadsdk.v.d.hc.d.d) null);
                        C0222d.this.mk.d((com.bytedance.sdk.openadsdk.w.b.d.hc) null);
                        C0222d.this.mk.np();
                    }
                }
            });
        }

        @Override // com.bytedance.msdk.hc.b
        public boolean u() {
            return this.k;
        }

        @Override // com.bytedance.msdk.hc.b
        public String ai() {
            com.bytedance.sdk.openadsdk.w.b.hc.tc tcVar = this.mk;
            return tcVar != null ? com.bytedance.msdk.d.b.hc.b((Map<String, Object>) tcVar.de()) : "";
        }

        /* JADX INFO: Access modifiers changed from: private */
        public com.bytedance.msdk.d.hc.d g() {
            return (com.bytedance.msdk.d.hc.d) this.h;
        }

        @Override // com.bytedance.msdk.hc.b
        public long xi() {
            com.bytedance.sdk.openadsdk.w.b.hc.tc tcVar = this.mk;
            if (tcVar != null) {
                return com.bytedance.msdk.d.b.hc.d((Map<String, Object>) tcVar.de());
            }
            return 0L;
        }

        @Override // com.bytedance.msdk.hc.b
        public long yb() {
            com.bytedance.sdk.openadsdk.w.b.hc.tc tcVar = this.mk;
            if (tcVar != null) {
                return com.bytedance.msdk.d.b.hc.hc((Map<String, Object>) tcVar.de());
            }
            return 0L;
        }

        @Override // com.bytedance.msdk.hc.b
        public void d(Activity activity, final com.bytedance.sdk.openadsdk.jh.d.hc.d.d dVar) {
            if (this.mk != null) {
                com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "pangle banner native:  activity = " + activity + " pluginDislikeInteractionCallback:" + dVar);
                this.mk.d(activity, new com.bytedance.sdk.openadsdk.jh.d.hc.d.d(null) { // from class: com.bytedance.msdk.b.b.hc.d.hc.d.d.4
                    public void d() {
                        com.bytedance.sdk.openadsdk.jh.d.hc.d.d dVar2 = dVar;
                        if (dVar2 != null) {
                            dVar2.d();
                        }
                    }

                    public void d(int i, String str, boolean z) {
                        if (C0222d.this.uo) {
                            return;
                        }
                        C0222d.this.uo = true;
                        com.bytedance.msdk.core.hc.d.d(d.this.b.hc());
                        com.bytedance.sdk.openadsdk.jh.d.hc.d.d dVar2 = dVar;
                        if (dVar2 != null) {
                            dVar2.d(i, str, z);
                        }
                    }

                    public void hc() {
                        com.bytedance.sdk.openadsdk.jh.d.hc.d.d dVar2 = dVar;
                        if (dVar2 != null) {
                            dVar2.hc();
                        }
                    }
                });
            }
        }

        @Override // com.bytedance.msdk.hc.b
        public void d(Dialog dialog, Integer[] numArr) {
            if (this.mk != null) {
                com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "pangle banner native:  ttDislikeDialogAbstract = ".concat(String.valueOf(dialog)));
                if (dialog instanceof TTDislikeDialogAbstract) {
                    this.mk.hc(dialog, numArr);
                }
            }
        }

        @Override // com.bytedance.msdk.hc.b
        public com.bytedance.sdk.openadsdk.w.b.hc.h d(Activity activity) {
            if (this.mk == null) {
                return null;
            }
            com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "pangle banner native: getDislikeDialog = ".concat(String.valueOf(activity)));
            return this.mk.d(activity);
        }

        @Override // com.bytedance.msdk.hc.b
        public com.bytedance.sdk.openadsdk.w.b.hc.h hc(Dialog dialog, Integer[] numArr) {
            if (this.mk == null) {
                return null;
            }
            com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "pangle banner native : getDislikeDialog = ".concat(String.valueOf(dialog)));
            return this.mk.d(dialog, numArr);
        }

        @Override // com.bytedance.msdk.hc.b
        public com.bytedance.sdk.openadsdk.w.b.hc.c vg() {
            if (this.mk == null) {
                return null;
            }
            com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "pangle banner native : getDislikeInfo");
            return this.mk.yo();
        }

        @Override // com.bytedance.msdk.hc.b
        public void mt(String str) {
            com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "pangle banner native: uploadDislikeEvent event = ".concat(String.valueOf(str)));
            com.bytedance.sdk.openadsdk.w.b.hc.tc tcVar = this.mk;
            if (tcVar != null) {
                tcVar.d(str);
            }
        }

        @Override // com.bytedance.msdk.hc.b
        public void d(com.bytedance.sdk.openadsdk.w.b.d.hc hcVar) {
            com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "pangle banner native: setAdInteractionListener pluginTTAdInteractionListener = ".concat(String.valueOf(hcVar)));
            com.bytedance.sdk.openadsdk.w.b.hc.tc tcVar = this.mk;
            if (tcVar != null) {
                tcVar.d(hcVar);
            }
        }
    }

    class b extends com.bytedance.msdk.hc.b {
        private boolean k;
        SoftReference<FrameLayout> tc;
        k tt;
        private boolean uo;
        final Object mk = new Object();
        private volatile boolean e = false;
        private final com.bytedance.sdk.openadsdk.he.d.hc.d.hc cb = new com.bytedance.sdk.openadsdk.he.d.hc.d.hc(null) { // from class: com.bytedance.msdk.b.b.hc.d.hc.d.b.4
            public void d(View view, int i) {
                if (b.this.h instanceof com.bytedance.msdk.d.hc.d) {
                    b.this.g().d(view);
                }
            }

            public void hc(View view, int i) {
                if (b.this.h instanceof com.bytedance.msdk.d.hc.d) {
                    b.this.g().hc(view);
                }
            }

            public void d(View view, String str, int i) {
                b.this.k = false;
                com.bytedance.msdk.d.u.b.c("TTMediationSDK_banner", com.bytedance.msdk.d.u.u.hc(d.this.b.hc(), d.this.b.mq()) + "TTBannerView onRenderFail -> code=" + i + ",msg=" + str);
            }

            public void d(View view, float f, float f2) {
                com.bytedance.msdk.d.u.b.c("TTMediationSDK_banner", com.bytedance.msdk.d.u.u.hc(d.this.b.hc(), d.this.b.mq()) + "TTBannerView onRenderSuccess 渲染成功！！mBannerViewRef = " + b.this.tc);
                if (b.this.tc != null) {
                    FrameLayout frameLayout = b.this.tc.get();
                    if (frameLayout != null) {
                        com.bytedance.msdk.api.u.d(view);
                        frameLayout.addView(view, new ViewGroup.LayoutParams(-1, -1));
                    }
                    b.this.k = true;
                }
            }
        };

        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public com.bytedance.msdk.d.hc.d g() {
            return (com.bytedance.msdk.d.hc.d) this.h;
        }

        public void d(final Context context) {
            z zVarD = d.this.d(context);
            if (zVarD == null) {
                return;
            }
            hc.d dVarD = com.bytedance.msdk.d.b.hc.d(d.this.hc, d.this.b.mq(), d.this.b.cb(), d.this.b.w(), d.this.b.yi(), false);
            float fK = d.this.hc.k();
            dVarD.d(fK).hc(d.this.hc.e());
            zVarD.b(dVarD.d(), new com.bytedance.sdk.openadsdk.sy.d.hc.d.an(null) { // from class: com.bytedance.msdk.b.b.hc.d.hc.d.b.1
                public void d(int i, String str) {
                    d.this.d(new com.bytedance.msdk.api.d(i, str));
                }

                public void d(List<k> list) {
                    Map mapGb;
                    if (list == null || list.size() == 0 || context == null) {
                        d.this.d(new com.bytedance.msdk.api.d(80001, "load list is null or empty"));
                        return;
                    }
                    b.this.tt = list.get(0);
                    if (context instanceof Activity) {
                        b.this.tt.d((Activity) context, new com.bytedance.sdk.openadsdk.jh.d.hc.d.d(null) { // from class: com.bytedance.msdk.b.b.hc.d.hc.d.b.1.1
                            public void d() {
                            }

                            public void hc() {
                            }

                            public void d(int i, String str, boolean z) {
                                if (b.this.uo) {
                                    return;
                                }
                                b.this.uo = true;
                                if (b.this.h instanceof com.bytedance.msdk.d.hc.d) {
                                    com.bytedance.msdk.core.hc.d.d(d.this.b.hc());
                                    b.this.g().f_();
                                }
                            }
                        });
                    }
                    b.this.h(true);
                    b bVar = b.this;
                    bVar.mq(bVar.tt.b());
                    b bVar2 = b.this;
                    bVar2.mk(bVar2.tt.hc());
                    if (d.this.b.d() && (mapGb = b.this.tt.gb()) != null) {
                        double d = com.bytedance.msdk.d.b.hc.d(mapGb.get("price"));
                        com.bytedance.msdk.d.u.b.d("TTMediationSDK_ECMP", com.bytedance.msdk.d.u.u.hc(d.this.b.hc(), d.this.b.mq()) + "pangle banner 返回的 cpm价格：" + d);
                        b bVar3 = b.this;
                        if (d <= 0.0d) {
                            d = 0.0d;
                        }
                        bVar3.d(d);
                    }
                    b.this.tt.d(b.this.cb);
                    b.this.tc = new SoftReference<>(new FrameLayout(context));
                    b.this.tt.c();
                    ArrayList arrayList = new ArrayList(1);
                    arrayList.add(b.this);
                    d.this.d(arrayList);
                }
            });
        }

        @Override // com.bytedance.msdk.hc.b
        public Map<String, Object> j() {
            Map mapGb;
            k kVar = this.tt;
            if (kVar == null || (mapGb = kVar.gb()) == null) {
                return null;
            }
            HashMap map = new HashMap();
            map.put("coupon", mapGb.get("coupon"));
            map.put("live_room", mapGb.get("live_room"));
            map.put("product", mapGb.get("product"));
            b(map);
            return super.j();
        }

        @Override // com.bytedance.msdk.hc.b
        public long xi() {
            k kVar = this.tt;
            if (kVar != null) {
                return com.bytedance.msdk.d.b.hc.d((Map<String, Object>) kVar.gb());
            }
            return 0L;
        }

        @Override // com.bytedance.msdk.hc.b
        public long yb() {
            k kVar = this.tt;
            if (kVar != null) {
                return com.bytedance.msdk.d.b.hc.hc((Map<String, Object>) kVar.gb());
            }
            return 0L;
        }

        @Override // com.bytedance.msdk.hc.b
        public String ai() {
            k kVar = this.tt;
            return kVar != null ? com.bytedance.msdk.d.b.hc.b((Map<String, Object>) kVar.gb()) : "";
        }

        @Override // com.bytedance.msdk.hc.b
        public synchronized View tt() {
            SoftReference<FrameLayout> softReference = this.tc;
            if (softReference == null) {
                return null;
            }
            FrameLayout frameLayout = softReference.get();
            synchronized (this.mk) {
                if (frameLayout == null) {
                    try {
                        long jUptimeMillis = SystemClock.uptimeMillis();
                        long j = 2000 + jUptimeMillis;
                        while (!this.k && jUptimeMillis < j) {
                            this.mk.wait(j - jUptimeMillis);
                            jUptimeMillis = SystemClock.uptimeMillis();
                        }
                    } catch (InterruptedException e) {
                        com.bytedance.sdk.component.utils.mq.d(e);
                    }
                }
            }
            return frameLayout;
        }

        @Override // com.bytedance.msdk.hc.b
        public void yo() {
            this.e = true;
            com.bytedance.msdk.d.u.an.b(new Runnable() { // from class: com.bytedance.msdk.b.b.hc.d.hc.d.b.2
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.tt != null) {
                        b.this.tt.d((com.bytedance.sdk.openadsdk.he.d.hc.d.d) null);
                        b.this.tt.u();
                    }
                }
            });
        }

        @Override // com.bytedance.msdk.hc.b
        public boolean u() {
            return this.e;
        }

        @Override // com.bytedance.msdk.hc.b
        public void d(Activity activity, final com.bytedance.sdk.openadsdk.jh.d.hc.d.d dVar) {
            if (this.tt != null) {
                com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "pangle banner : activity = " + activity + " pluginDislikeInteractionCallback:" + dVar);
                this.tt.d(activity, new com.bytedance.sdk.openadsdk.jh.d.hc.d.d(null) { // from class: com.bytedance.msdk.b.b.hc.d.hc.d.b.3
                    public void d() {
                        com.bytedance.sdk.openadsdk.jh.d.hc.d.d dVar2 = dVar;
                        if (dVar2 != null) {
                            dVar2.d();
                        }
                    }

                    public void d(int i, String str, boolean z) {
                        if (b.this.uo) {
                            return;
                        }
                        b.this.uo = true;
                        com.bytedance.msdk.core.hc.d.d(d.this.b.hc());
                        com.bytedance.sdk.openadsdk.jh.d.hc.d.d dVar2 = dVar;
                        if (dVar2 != null) {
                            dVar2.d(i, str, z);
                        }
                    }

                    public void hc() {
                        com.bytedance.sdk.openadsdk.jh.d.hc.d.d dVar2 = dVar;
                        if (dVar2 != null) {
                            dVar2.hc();
                        }
                    }
                });
            }
        }

        @Override // com.bytedance.msdk.hc.b
        public void d(Dialog dialog, Integer[] numArr) {
            if (this.tt != null) {
                com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "pangle banner :  ttDislikeDialogAbstract = ".concat(String.valueOf(dialog)));
                this.tt.d(dialog, numArr);
            }
        }

        @Override // com.bytedance.msdk.hc.b
        public com.bytedance.sdk.openadsdk.w.b.hc.h d(Activity activity) {
            if (this.tt == null) {
                return null;
            }
            com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "pangle banner : getDislikeDialog = ".concat(String.valueOf(activity)));
            return this.tt.d(activity);
        }

        @Override // com.bytedance.msdk.hc.b
        public com.bytedance.sdk.openadsdk.w.b.hc.c vg() {
            if (this.tt == null) {
                return null;
            }
            com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "pangle banner : getDislikeInfo");
            return this.tt.an();
        }

        @Override // com.bytedance.msdk.hc.b
        public void mt(String str) {
            com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "pangle banner : uploadDislikeEvent event = ".concat(String.valueOf(str)));
            k kVar = this.tt;
            if (kVar != null) {
                kVar.d(str);
            }
        }

        @Override // com.bytedance.msdk.hc.b
        public void d(com.bytedance.sdk.openadsdk.w.b.d.hc hcVar) {
            com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "pangle banner : setAdInteractionListener pluginTTAdInteractionListener = ".concat(String.valueOf(hcVar)));
            k kVar = this.tt;
            if (kVar != null) {
                kVar.d(hcVar);
            }
        }

        @Override // com.bytedance.msdk.hc.b
        public void v(int i) {
            if (this.tt != null) {
                com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "pangle banner : setSlideIntervalTime  intervalTime = ".concat(String.valueOf(i)));
                this.tt.d(i);
            }
        }
    }
}
