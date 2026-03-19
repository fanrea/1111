package com.bytedance.msdk.b.b.hc.d.hc;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import com.baidu.mobads.container.adrequest.n;
import com.bytedance.sdk.djx.core.business.ad.IDJXAd;
import com.bytedance.sdk.openadsdk.core.z;
import com.bytedance.sdk.openadsdk.w.b.hc.k;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class c {
    public void d(final boolean z, z zVar, com.bytedance.sdk.openadsdk.w.b.b.hc hcVar, final com.bytedance.msdk.b.b.hc.d.hc hcVar2) {
        if (zVar == null || hcVar2 == null) {
            return;
        }
        zVar.hc(hcVar, new com.bytedance.sdk.openadsdk.sy.d.hc.d.an(null) { // from class: com.bytedance.msdk.b.b.hc.d.hc.c.1
            public void d(int i, String str) {
                hcVar2.d(new com.bytedance.msdk.api.d(i, str));
            }

            public void d(List<k> list) {
                if (list == null || list.size() == 0) {
                    hcVar2.d(new com.bytedance.msdk.api.d(80001, "load成功但返回广告是空"));
                    return;
                }
                ArrayList arrayList = new ArrayList();
                for (k kVar : list) {
                    if (kVar != null) {
                        arrayList.add(new d(kVar, z));
                    }
                }
                hcVar2.d(arrayList);
            }
        });
    }

    private static class d extends com.bytedance.msdk.hc.b {
        private k mk;
        com.bytedance.sdk.openadsdk.he.d.hc.d.b tc;
        com.bytedance.sdk.openadsdk.he.d.hc.d.hc tt;

        @Override // com.bytedance.msdk.hc.b
        public boolean jh() {
            return true;
        }

        d(k kVar, boolean z) {
            Map mapGb;
            Function function = null;
            this.tt = new com.bytedance.sdk.openadsdk.he.d.hc.d.hc(function) { // from class: com.bytedance.msdk.b.b.hc.d.hc.c.d.1
                public void d(View view, int i) {
                    if (d.this.an != null) {
                        d.this.an.d(view);
                    }
                }

                public void hc(View view, int i) {
                    if (d.this.an != null) {
                        d.this.an.d();
                    }
                }

                public void d(View view, String str, int i) {
                    if (d.this.an instanceof com.bytedance.msdk.api.c.d.b.c) {
                        ((com.bytedance.msdk.api.c.d.b.c) d.this.an).d(view, str, i);
                    }
                }

                public void d(View view, float f, float f2) {
                    if (d.this.an instanceof com.bytedance.msdk.api.c.d.b.c) {
                        ((com.bytedance.msdk.api.c.d.b.c) d.this.an).d(f, f2);
                    }
                }
            };
            this.tc = new com.bytedance.sdk.openadsdk.he.d.hc.d.b(function) { // from class: com.bytedance.msdk.b.b.hc.d.hc.c.d.2
                public void d() {
                    if (d.this.hc != null) {
                        d.this.hc.d();
                    }
                }

                public void d(int i, int i2) {
                    if (d.this.hc != null) {
                        d.this.hc.d(new com.bytedance.msdk.api.d(i, "MediaPlayer inter error code:".concat(String.valueOf(i2))));
                    }
                }

                public void hc() {
                    if (d.this.hc != null) {
                        d.this.hc.hc();
                    }
                }

                public void b() {
                    if (d.this.hc != null) {
                        d.this.hc.b();
                    }
                }

                public void c() {
                    if (d.this.hc != null) {
                        d.this.hc.c();
                    }
                }

                public void d(long j, long j2) {
                    if (d.this.hc != null) {
                        d.this.hc.d(j, j2);
                    }
                }

                public void u() {
                    if (d.this.hc != null) {
                        d.this.hc.u();
                    }
                }
            };
            this.mk = kVar;
            mk(kVar.hc());
            mq(this.mk.b());
            h(true);
            if (z && (mapGb = kVar.gb()) != null) {
                double d = com.bytedance.msdk.d.b.hc.d(mapGb.get("price"));
                com.bytedance.msdk.d.u.b.d("TTMediationSDK_ECMP", "pangle 模板draw 返回的 cpm价格：".concat(String.valueOf(d)));
                d(d <= 0.0d ? 0.0d : d);
            }
            this.mk.d(this.tt);
            this.mk.d(this.tc);
            d(IDJXAd.AD_CODE_ID, Long.valueOf(yb()));
            d(n.o, Long.valueOf(xi()));
            Map<String, Object> mapGb2 = this.mk.gb();
            if (mapGb2 != null) {
                c(mapGb2);
                d("log_extra", mapGb2.toString());
            }
        }

        @Override // com.bytedance.msdk.hc.b
        public Map<String, Object> j() {
            Map<String, Object> mapGb;
            k kVar = this.mk;
            if (kVar == null || (mapGb = kVar.gb()) == null) {
                return null;
            }
            b(mapGb);
            return super.j();
        }

        @Override // com.bytedance.msdk.hc.b
        public void mk() {
            k kVar = this.mk;
            if (kVar != null) {
                kVar.c();
            }
        }

        @Override // com.bytedance.msdk.hc.b
        public View tt() {
            k kVar = this.mk;
            if (kVar != null) {
                return kVar.d();
            }
            return null;
        }

        @Override // com.bytedance.msdk.hc.b
        public String ai() {
            k kVar = this.mk;
            return kVar != null ? com.bytedance.msdk.d.b.hc.b((Map<String, Object>) kVar.gb()) : "";
        }

        @Override // com.bytedance.msdk.hc.b
        public void yo() {
            k kVar = this.mk;
            if (kVar != null) {
                kVar.u();
                this.mk = null;
            }
        }

        @Override // com.bytedance.msdk.hc.b
        public boolean u() {
            return this.mk == null;
        }

        @Override // com.bytedance.msdk.hc.b
        public long xi() {
            k kVar = this.mk;
            if (kVar != null) {
                return com.bytedance.msdk.d.b.hc.d((Map<String, Object>) kVar.gb());
            }
            return 0L;
        }

        @Override // com.bytedance.msdk.hc.b
        public long yb() {
            k kVar = this.mk;
            if (kVar != null) {
                return com.bytedance.msdk.d.b.hc.hc((Map<String, Object>) kVar.gb());
            }
            return 0L;
        }

        @Override // com.bytedance.msdk.hc.b
        public void d(Activity activity, com.bytedance.sdk.openadsdk.jh.d.hc.d.d dVar) {
            if (this.mk != null) {
                com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "pangle draw express:  activity = " + activity + " pluginDislikeInteractionCallback:" + dVar);
                this.mk.d(activity, dVar);
            }
        }

        @Override // com.bytedance.msdk.hc.b
        public void d(Dialog dialog, Integer[] numArr) {
            if (this.mk != null) {
                com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "pangle draw express:  ttDislikeDialogAbstract = ".concat(String.valueOf(dialog)));
                this.mk.d(dialog, numArr);
            }
        }

        @Override // com.bytedance.msdk.hc.b
        public com.bytedance.sdk.openadsdk.w.b.hc.h d(Activity activity) {
            k kVar = this.mk;
            if (kVar != null) {
                return kVar.d(activity);
            }
            return super.d(activity);
        }

        @Override // com.bytedance.msdk.hc.b
        public com.bytedance.sdk.openadsdk.w.b.hc.c vg() {
            k kVar = this.mk;
            if (kVar != null) {
                return kVar.an();
            }
            return super.vg();
        }

        @Override // com.bytedance.msdk.hc.b
        public void mt(String str) {
            if (this.mk != null) {
                com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "pangle draw express: uploadDislikeEvent event = ".concat(String.valueOf(str)));
                this.mk.d(str);
            }
        }

        @Override // com.bytedance.msdk.hc.b
        public void tc(boolean z) {
            com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "pangle draw express : setCanInterruptVideoPlay b = ".concat(String.valueOf(z)));
            k kVar = this.mk;
            if (kVar != null) {
                kVar.d(z);
            }
        }

        @Override // com.bytedance.msdk.hc.b
        public void d(com.bytedance.sdk.openadsdk.w.b.d.b bVar) {
            com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "pangle draw express: setDownloadListener pluginTTAppDownloadListener = ".concat(String.valueOf(bVar)));
            k kVar = this.mk;
            if (kVar != null) {
                kVar.d(bVar);
            }
        }

        @Override // com.bytedance.msdk.hc.b
        public void d(com.bytedance.sdk.openadsdk.w.b.d.hc hcVar) {
            com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "pangle draw express: setAdInteractionListener pluginTTAdInteractionListener = ".concat(String.valueOf(hcVar)));
            k kVar = this.mk;
            if (kVar != null) {
                kVar.d(hcVar);
            }
        }
    }
}
