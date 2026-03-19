package com.bytedance.msdk.b.b.hc;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.msdk.b.b.hc.d;
import com.bytedance.msdk.core.gb.k;
import com.bytedance.msdk.core.tc.tc;
import com.bytedance.msdk.core.tc.tt;
import com.bytedance.msdk.gb.j;
import com.bytedance.msdk.gb.rf;
import com.bytedance.msdk.gb.s;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.crypto.NoSuchPaddingException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class b implements d, com.bytedance.msdk.b.d.hc {
    private long an;
    private com.bytedance.msdk.api.d.hc b;
    private com.bytedance.msdk.b.an.hc.hc d;
    private long h;
    private com.bytedance.msdk.b.an.d.hc hc;
    private com.bytedance.msdk.b.d.d c = null;
    private volatile long u = -1;

    private List<com.bytedance.msdk.hc.b> hc(List<com.bytedance.msdk.hc.b> list) {
        ArrayList arrayList = new ArrayList();
        if (!j.d(list)) {
            arrayList.addAll(list);
        }
        if (this.d != null && !j.hc(list) && (this.d.d() || this.d.np())) {
            for (com.bytedance.msdk.hc.b bVar : list) {
                s.d(bVar, this.d.gb(), this.b, true);
                double dQ = this.b.q();
                if (dQ > 0.0d && dQ > bVar.kb()) {
                    arrayList.remove(bVar);
                    String strHc = null;
                    String strValueOf = String.valueOf(bVar.kb());
                    String strFu = bVar.fu();
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    long jCurrentTimeMillis2 = -1;
                    if (rf.d(this.d.gb())) {
                        strHc = rf.hc();
                        jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
                    }
                    com.bytedance.msdk.u.an.d(new com.bytedance.msdk.api.d(50100, com.bytedance.msdk.api.d.d(50100)), this.b, this.d.gb(), this.d.b(), this.d.h(), this.d.an(), d(this.d.uo()), this.an, strValueOf, strFu, strHc, jCurrentTimeMillis2);
                }
            }
        }
        return arrayList;
    }

    @Override // com.bytedance.msdk.b.d.hc
    public void d(List<com.bytedance.msdk.hc.b> list) {
        long jCurrentTimeMillis;
        String strHc;
        if (list == null) {
            return;
        }
        if (this.u == -1) {
            this.u = SystemClock.elapsedRealtime();
        }
        this.an = System.currentTimeMillis() - this.h;
        Iterator<com.bytedance.msdk.hc.b> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            com.bytedance.msdk.hc.b next = it.next();
            com.bytedance.msdk.api.d.hc hcVar = this.b;
            com.bytedance.msdk.b.an.hc.hc hcVar2 = this.d;
            com.bytedance.msdk.b.an.d.hc hcVar3 = this.hc;
            tt ttVarBa = hcVar3 != null ? hcVar3.ba() : null;
            com.bytedance.msdk.b.an.hc.hc hcVar4 = this.d;
            com.bytedance.msdk.b.gb.b.d(next, hcVar, hcVar2, ttVarBa, hcVar4 != null ? d(hcVar4.uo()) : "");
        }
        List<com.bytedance.msdk.hc.b> listHc = hc(list);
        if (listHc.size() != 0) {
            if (this.d != null) {
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                if (rf.d(this.d.gb())) {
                    strHc = rf.hc();
                    jCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis2;
                } else {
                    jCurrentTimeMillis = -1;
                    strHc = null;
                }
                int i = (list == null || list.size() <= 0) ? 820001 : 20000;
                if (this.d.d() || this.d.np()) {
                    for (com.bytedance.msdk.hc.b bVar : list) {
                        if (bVar != null) {
                            d(i, bVar, 1, strHc, jCurrentTimeMillis);
                        }
                    }
                } else {
                    d(i, listHc.get(0), listHc.size(), strHc, jCurrentTimeMillis);
                }
                if (this.d.v() && !j.hc(list)) {
                    com.bytedance.msdk.u.an.d(list.get(0), this.b, this.d.gb(), this.an);
                }
            }
            b(listHc);
            if (this.d.gb() != null && this.d.gb().uo() == 10 && this.d.gb().an() == 1) {
                d(listHc, (com.bytedance.msdk.api.d) null);
                return;
            }
            return;
        }
        d(new com.bytedance.msdk.api.d(50100, com.bytedance.msdk.api.d.d(50100)), false);
    }

    @Override // com.bytedance.msdk.b.d.hc
    public void d(com.bytedance.msdk.api.d dVar) {
        d(dVar, true);
    }

    private void d(com.bytedance.msdk.api.d dVar, boolean z) {
        long jCurrentTimeMillis;
        String strHc;
        this.an = System.currentTimeMillis() - this.h;
        com.bytedance.msdk.b.an.hc.hc hcVar = this.d;
        if (hcVar != null && hcVar.gb() != null) {
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            if (rf.d(this.d.gb())) {
                strHc = rf.hc();
                jCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis2;
            } else {
                jCurrentTimeMillis = -1;
                strHc = null;
            }
            if (!this.d.v() && z) {
                com.bytedance.msdk.u.an.d(dVar, this.b, this.d.gb(), this.d.b(), this.d.h(), this.d.an(), d(this.d.uo()), this.an, (String) null, (String) null, strHc, jCurrentTimeMillis);
            } else {
                com.bytedance.msdk.u.an.d(dVar, this.b, this.d.gb(), this.d.b(), this.d.h(), this.d.an(), d(this.d.uo()), this.an);
            }
            tc tcVarGb = this.d.gb();
            if (dVar != null) {
                if (this.b != null) {
                    if (com.bytedance.msdk.hc.hc.hc) {
                        StringBuilder sb = new StringBuilder();
                        com.bytedance.msdk.api.d.hc hcVar2 = this.b;
                        com.bytedance.msdk.d.u.b.c("TTMediationSDK", sb.append(com.bytedance.msdk.d.u.u.d(hcVar2 != null ? hcVar2.v() : "", "fill_fail")).append("AdNetWorkName[").append(tcVarGb.e()).append("] AdUnitId[").append(tcVarGb.yo()).append("] AdType[").append(com.bytedance.msdk.hc.d.d(this.b.de(), tcVarGb.an(), tcVarGb)).append("] 请求失败 (loadSort=").append(tcVarGb.np()).append(",showSort=").append(tcVarGb.yi()).append("),error=").append(dVar.b).append(",msg=").append(dVar.c).toString());
                    } else {
                        StringBuilder sb2 = new StringBuilder();
                        com.bytedance.msdk.api.d.hc hcVar3 = this.b;
                        com.bytedance.msdk.d.u.b.c("TTMediationSDK", sb2.append(com.bytedance.msdk.d.u.u.d(hcVar3 != null ? hcVar3.v() : "", "fill_fail")).append("AdNetWorkName[").append(tcVarGb.e()).append("] AdType[").append(com.bytedance.msdk.hc.d.d(this.b.de(), tcVarGb.an(), tcVarGb)).append("] 请求失败 error=").append(dVar.b).append(",msg=").append(dVar.c).toString());
                    }
                }
                String string = new StringBuilder().append(dVar.b).toString();
                String strD = com.bytedance.msdk.d.d.d(this.d.gb().e(), dVar.c);
                k kVarD = k.d();
                com.bytedance.msdk.api.d.hc hcVar4 = this.b;
                if (kVarD.d(hcVar4 == null ? null : hcVar4.v(), this.d.gb().w())) {
                    k kVarD2 = k.d();
                    com.bytedance.msdk.api.d.hc hcVar5 = this.b;
                    kVarD2.d(hcVar5 != null ? hcVar5.v() : null, this.d.gb().e(), this.d.gb().yo(), com.bytedance.msdk.d.d.d(this.d.gb().e(), string, strD));
                } else {
                    com.bytedance.msdk.core.gb.b.d().d(this.d.gb().e(), this.d.gb().yo(), com.bytedance.msdk.d.d.d(this.d.gb().e(), string, strD));
                }
            }
        }
        hc(dVar);
    }

    @Override // com.bytedance.msdk.b.d.hc
    public void d(final List<com.bytedance.msdk.hc.b> list, com.bytedance.msdk.api.d dVar) {
        if (list != null) {
            for (com.bytedance.msdk.hc.b bVar : list) {
                if (bVar != null) {
                    bVar.tt(true);
                    com.bytedance.msdk.api.d.hc hcVar = this.b;
                    com.bytedance.msdk.b.an.hc.hc hcVar2 = this.d;
                    com.bytedance.msdk.b.an.d.hc hcVar3 = this.hc;
                    tt ttVarBa = hcVar3 == null ? null : hcVar3.ba();
                    com.bytedance.msdk.b.an.hc.hc hcVar4 = this.d;
                    com.bytedance.msdk.b.gb.b.d(bVar, hcVar, hcVar2, ttVarBa, hcVar4 != null ? d(hcVar4.uo()) : "");
                    d(bVar);
                }
            }
        }
        if (dVar != null && dVar.d == 30010 && com.bytedance.msdk.d.d.d()) {
            com.bytedance.msdk.d.u.an.d(new Runnable() { // from class: com.bytedance.msdk.b.b.hc.b.1
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.d != null && b.this.d.v()) {
                        com.bytedance.msdk.u.an.d(!j.hc(list) ? (com.bytedance.msdk.hc.b) list.get(0) : null, b.this.b, b.this.d.gb());
                    }
                    b.this.d();
                }
            }, 1000L);
            return;
        }
        com.bytedance.msdk.b.an.hc.hc hcVar5 = this.d;
        if (hcVar5 != null && hcVar5.v()) {
            com.bytedance.msdk.u.an.d(j.hc(list) ? null : list.get(0), this.b, this.d.gb());
        }
        d();
    }

    private void b(List<com.bytedance.msdk.hc.b> list) {
        com.bytedance.msdk.b.an.hc.hc hcVar = this.d;
        if (hcVar != null) {
            hcVar.d(list, hcVar.gb());
        }
        d(new Runnable() { // from class: com.bytedance.msdk.b.b.hc.b.2
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.d != null) {
                    com.bytedance.msdk.core.b.b.b(b.this.d.uo(), b.this.d.hc(), b.this.d.mq());
                }
            }
        });
    }

    private void hc(com.bytedance.msdk.api.d dVar) {
        com.bytedance.msdk.b.an.hc.hc hcVar = this.d;
        if (hcVar != null) {
            hcVar.d(dVar, hcVar.gb());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        com.bytedance.msdk.b.an.hc.hc hcVar = this.d;
        if (hcVar != null) {
            hcVar.tt();
        }
    }

    private void d(Runnable runnable) {
        com.bytedance.msdk.d.u.an.d(runnable);
    }

    @Override // com.bytedance.msdk.b.d.hc
    public void d(com.bytedance.msdk.hc.b bVar, String str) {
        if (bVar == null || bVar.el() != 5) {
            return;
        }
        com.bytedance.msdk.u.an.d(bVar, this.b, str);
    }

    @Override // com.bytedance.msdk.b.b.hc.d
    public void d(d.InterfaceC0215d interfaceC0215d) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        if (interfaceC0215d == null) {
            return;
        }
        this.h = System.currentTimeMillis();
        this.d = interfaceC0215d.d();
        com.bytedance.msdk.b.an.d.hc hcVarHc = interfaceC0215d.hc();
        this.hc = hcVarHc;
        this.b = hcVarHc.rf();
        if (this.hc.getContext() == null) {
            com.bytedance.msdk.api.d dVar = new com.bytedance.msdk.api.d("request adn context is null");
            d(this.d, this.hc, dVar, "");
            d(dVar);
        } else {
            if (this.d != null) {
                hc();
                return;
            }
            com.bytedance.msdk.api.d dVar2 = new com.bytedance.msdk.api.d("request adn waterfall request is null");
            d(this.d, this.hc, dVar2, "");
            d(dVar2);
        }
    }

    private void d(com.bytedance.msdk.b.an.hc.hc hcVar, com.bytedance.msdk.b.an.d.hc hcVar2, com.bytedance.msdk.api.d dVar, String str) {
        if (hcVar == null || hcVar2 == null || hcVar.gb() == null) {
            return;
        }
        tc tcVarGb = hcVar.gb();
        String strD = TextUtils.isEmpty(str) ? com.bytedance.msdk.core.u.d.d.d().d(tcVarGb.yo()) : str;
        if (!tcVarGb.s()) {
            com.bytedance.msdk.u.an.d(tcVarGb, this.b, strD, hcVar.u(), hcVar.h() == 4 ? 3 : 0, hcVar.b(), hcVar.h(), hcVar.an(), dVar, hcVar.c(), hcVar2.ba().u, false);
        } else if (tcVarGb.zw() != null) {
            com.bytedance.msdk.u.an.d(tcVarGb, this.b, strD);
        }
    }

    private void d(com.bytedance.msdk.hc.b bVar) {
        com.bytedance.msdk.b.an.hc.hc hcVar;
        if (this.hc == null || this.b == null || (hcVar = this.d) == null || hcVar.gb() == null) {
            return;
        }
        tc tcVarGb = this.d.gb();
        if (!this.d.v() && bVar != null) {
            com.bytedance.msdk.u.an.d(this.b, bVar, this.d.gb());
        }
        if (com.bytedance.msdk.hc.hc.hc) {
            com.bytedance.msdk.d.u.b.hc("TTMediationSDK", com.bytedance.msdk.d.u.u.d(this.b.v(), "fill") + "AdNetWorkName[" + tcVarGb.e() + "] AdUnitId[" + tcVarGb.yo() + "] AdType[" + com.bytedance.msdk.hc.d.d(this.b.de(), tcVarGb.an(), tcVarGb) + "] 视频缓存成功 (loadSort=" + tcVarGb.np() + ",showSort=" + tcVarGb.yi() + ")");
        } else {
            com.bytedance.msdk.d.u.b.hc("TTMediationSDK", com.bytedance.msdk.d.u.u.d(this.b.v(), "fill") + "AdNetWorkName[" + tcVarGb.e() + "] AdType[" + com.bytedance.msdk.hc.d.d(this.b.de(), tcVarGb.an(), tcVarGb) + "] 视频缓存成功 ");
        }
    }

    private void d(int i, com.bytedance.msdk.hc.b bVar, int i2, String str, long j) {
        com.bytedance.msdk.b.an.hc.hc hcVar;
        if (this.hc == null || this.b == null || (hcVar = this.d) == null || hcVar.gb() == null) {
            return;
        }
        tc tcVarGb = this.d.gb();
        String str2 = i == 20000 ? "load success" : "请求成功，但无广告可用";
        boolean z = this.hc.ba().an;
        if (!this.d.v() && bVar != null) {
            com.bytedance.msdk.u.an.d(bVar, i, str2, this.an, this.b, this.d.b(), i2, z ? 1 : 0, str, j, this.u != -1 ? SystemClock.elapsedRealtime() - this.u : -1L);
        }
        if (com.bytedance.msdk.hc.hc.hc) {
            com.bytedance.msdk.d.u.b.hc("TTMediationSDK", com.bytedance.msdk.d.u.u.d(this.b.v(), "fill") + "AdNetWorkName[" + tcVarGb.e() + "] AdUnitId[" + tcVarGb.yo() + "] AdType[" + com.bytedance.msdk.hc.d.d(this.b.de(), tcVarGb.an(), tcVarGb) + "] 请求成功 (loadSort=" + tcVarGb.np() + ",showSort=" + tcVarGb.yi() + ")");
        } else {
            com.bytedance.msdk.d.u.b.hc("TTMediationSDK", com.bytedance.msdk.d.u.u.d(this.b.v(), "fill") + "AdNetWorkName[" + tcVarGb.e() + "] AdType[" + com.bytedance.msdk.hc.d.d(this.b.de(), tcVarGb.an(), tcVarGb) + "] 请求成功");
        }
    }

    private void hc() throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        com.bytedance.msdk.b.an.hc.hc hcVar;
        com.bytedance.msdk.b.an.hc.hc hcVar2 = this.d;
        hcVar2.d(com.bytedance.msdk.b.gb.b.d(this.b, hcVar2));
        this.d.hc(this.hc.mq().fs());
        if (!this.d.tc()) {
            if (this.d.mk()) {
                this.c = com.bytedance.msdk.b.b.hc.d.c.d(this.d, this);
            } else if (com.bytedance.msdk.core.h.b.d(this.d.gb())) {
                this.c = new com.bytedance.msdk.b.b.hc.d.b(this);
            }
        } else {
            Context context = com.bytedance.msdk.core.hc.getContext();
            com.bytedance.msdk.b.an.hc.hc hcVar3 = this.d;
            com.bytedance.msdk.an.hc.d(context, hcVar3 != null ? hcVar3.uo() : "");
            if (com.bytedance.msdk.an.hc.d.d(this.d.uo()) == null) {
                com.bytedance.msdk.u.an.d("", this.hc.mk(), this.b, this.d.gb(), new com.bytedance.msdk.api.d(49014, "创建自定义广告对象 configuration is null"));
            } else {
                com.bytedance.msdk.core.tc.d dVarD = com.bytedance.msdk.h.d.hc.d().d(this.d.uo());
                if (dVarD == null) {
                    com.bytedance.msdk.u.an.d("", (com.bytedance.msdk.hc.b) null, (com.bytedance.msdk.api.d.hc) null, (tc) null, new com.bytedance.msdk.api.d(49013, "创建自定义广告对象 adNetworkConfValue is null"));
                } else if (dVarD.b() == null) {
                    com.bytedance.msdk.u.an.d("", (com.bytedance.msdk.hc.b) null, (com.bytedance.msdk.api.d.hc) null, (tc) null, new com.bytedance.msdk.api.d(49013, "创建自定义广告对象 getGMCustomConfig is null"));
                } else {
                    com.bytedance.msdk.api.c.d.hc.b.d dVarD2 = dVarD.b().d(this.d.he(), this.d.e());
                    if (dVarD2 == null) {
                        com.bytedance.msdk.u.an.d("", (com.bytedance.msdk.hc.b) null, (com.bytedance.msdk.api.d.hc) null, (tc) null, new com.bytedance.msdk.api.d(49013, "创建自定义广告对象 adConfig is null"));
                    } else if (com.bytedance.msdk.b.gb.b.d(dVarD2)) {
                        this.c = com.bytedance.msdk.b.b.hc.d.c.d(dVarD2.d(), this.d, this);
                    } else {
                        com.bytedance.msdk.u.an.d("", (com.bytedance.msdk.hc.b) null, (com.bytedance.msdk.api.d.hc) null, (tc) null, new com.bytedance.msdk.api.d(49013, "创建自定义广告对象 check className false className is " + dVarD2.d()));
                    }
                }
            }
        }
        com.bytedance.msdk.b.d.d dVar = this.c;
        if (dVar != null) {
            String strD = dVar.d(this.d.uo());
            if (!TextUtils.isEmpty(strD) && (hcVar = this.d) != null && !TextUtils.isEmpty(hcVar.mq()) && !this.d.tc()) {
                com.bytedance.msdk.core.u.d.d.d().c(this.d.mq(), strD);
            }
            d(this.d, this.hc, null, strD);
            com.bytedance.msdk.b.d.d dVar2 = this.c;
            Context context2 = this.hc.getContext();
            com.bytedance.msdk.b.an.hc.hc hcVar4 = this.d;
            com.bytedance.msdk.api.d.hc hcVar5 = this.b;
            dVar2.d(context2, hcVar4, hcVar5, com.bytedance.msdk.b.gb.b.d(hcVar4, hcVar5, this.hc.j()));
            if (this.d.tc()) {
                return;
            }
            com.bytedance.msdk.core.u.d.d.d().d(this.d.hc(), this.d.mq(), this.d.gb(), this.d.b());
            return;
        }
        com.bytedance.msdk.d.u.b.c("TTMediationSDK", "**********【重要】" + this.d.uo() + "创建失败，请检查adapter是否接入 **********");
        com.bytedance.msdk.u.an.d(this.d.gb(), this.b, this.d.h(), this.d.an());
        d(this.d, this.hc, new com.bytedance.msdk.api.d("create adn loader fail"), "");
        d(new com.bytedance.msdk.api.d("create adn loader fail"));
    }

    private String d(String str) {
        com.bytedance.msdk.d.d.c cVarD = com.bytedance.msdk.an.hc.hc.d().d(str);
        if (cVarD != null) {
            return cVarD.hc();
        }
        return null;
    }
}
