package com.bytedance.msdk.core.c;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.sdk.m.u.i;
import com.bytedance.msdk.core.c.c;
import com.bytedance.msdk.core.tc.gb;
import com.bytedance.msdk.core.tc.h;
import com.bytedance.msdk.core.tc.tc;
import com.bytedance.msdk.core.uo.d;
import com.bytedance.msdk.gb.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class an implements c {
    @Override // com.bytedance.msdk.core.c.c
    public void d(Map<String, com.bytedance.msdk.b.d.d> map, Context context, final b bVar, final c.d dVar) {
        if (bVar == null || bVar.d == null || bVar.c == null || j.d(bVar.hc)) {
            dVar.d(null);
            return;
        }
        com.bytedance.msdk.d.u.b.c("TTMediationSDK", com.bytedance.msdk.d.u.u.d(bVar.d.v()) + "开启server bidding网络请求......：");
        com.bytedance.msdk.u.an.d(bVar.d, (JSONObject) null);
        final long jCurrentTimeMillis = System.currentTimeMillis();
        final int[] iArr = {4};
        com.bytedance.msdk.core.uo.d.d().d(map, context, bVar.d, bVar.hc, bVar.b, bVar.c, bVar.u, bVar.an, new d.InterfaceC0247d() { // from class: com.bytedance.msdk.core.c.an.1
            @Override // com.bytedance.msdk.core.uo.d.InterfaceC0247d
            public void d(h hVar) {
                an.this.d(jCurrentTimeMillis, bVar.d, bVar.c, iArr[0], hVar, dVar);
            }

            @Override // com.bytedance.msdk.core.uo.d.InterfaceC0247d
            public void d(com.bytedance.msdk.api.d dVar2) {
                an.this.d(jCurrentTimeMillis, iArr[0], dVar2, bVar.d, dVar);
            }
        });
    }

    public void d(String str, final long j, final com.bytedance.msdk.api.d.hc hcVar, final com.bytedance.msdk.core.tc.hc hcVar2, final c.d dVar) {
        com.bytedance.msdk.core.uo.d.d().d(str, new d.InterfaceC0247d() { // from class: com.bytedance.msdk.core.c.an.2
            @Override // com.bytedance.msdk.core.uo.d.InterfaceC0247d
            public void d(h hVar) {
                an.this.d(j, hcVar, hcVar2, 4, hVar, dVar);
            }

            @Override // com.bytedance.msdk.core.uo.d.InterfaceC0247d
            public void d(com.bytedance.msdk.api.d dVar2) {
                an.this.d(j, 4, dVar2, hcVar, dVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(long j, com.bytedance.msdk.api.d.hc hcVar, com.bytedance.msdk.core.tc.hc hcVar2, int i, h hVar, c.d dVar) {
        int i2;
        hc hcVar3;
        int i3;
        tc tcVarAn;
        com.bytedance.msdk.d.u.b.c("TTMediationSDK", com.bytedance.msdk.d.u.u.d(hcVar.v()) + "server bidding网络请求响返回.............");
        long jCurrentTimeMillis = System.currentTimeMillis() - j;
        if (hcVar2 != null && hVar != null && !j.d(hVar.c())) {
            List<gb> listC = hVar.c();
            hcVar3 = new hc();
            hcVar3.mq = hVar.d();
            hcVar3.uo = hVar.hc();
            hcVar3.k = hVar.b();
            hcVar3.mk = hVar.h();
            hcVar3.tt = listC.size();
            hcVar3.d = hVar.tt();
            hcVar3.tc = hcVar2.an();
            ArrayList arrayList = new ArrayList();
            StringBuilder sb = new StringBuilder();
            sb.append("winners : {");
            for (gb gbVar : listC) {
                if (gbVar != null && (tcVarAn = hcVar2.an(gbVar.h())) != null) {
                    tc tcVarU = tcVarAn.u();
                    sb.append(" [ AdnName:" + tcVarU.e() + ",slotId:" + tcVarU.yo() + ",loadSort:" + tcVarU.np() + ",showSort:" + tcVarU.yi() + "] ");
                    tcVarU.d(gbVar);
                    arrayList.add(tcVarU);
                }
            }
            sb.append(i.d);
            if (j.d(arrayList)) {
                i2 = j.d(hVar.tt()) ? i : 2;
                com.bytedance.msdk.d.u.b.c("TTMediationSDK", com.bytedance.msdk.d.u.u.d(hcVar.v()) + "server bidding网络请求响应失败......：数据有返回，但没有返回winner数据......");
            } else {
                com.bytedance.msdk.d.u.b.c("TTMediationSDK", com.bytedance.msdk.d.u.u.d(hcVar.v()) + "server bidding网络请求响应成功......：" + sb.toString());
                CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
                copyOnWriteArrayList.addAll(arrayList);
                List<tc> listD = d(hVar.tt(), hcVar2, hcVar3);
                if (listD != null && listD.size() > 0) {
                    com.bytedance.msdk.d.u.b.c("TTMediationSDK", com.bytedance.msdk.d.u.u.d(hcVar.v()) + "server bidding网络请求响应成功......waterfall+server bidding物料......");
                    copyOnWriteArrayList.addAll(listD);
                    i3 = 1;
                } else {
                    com.bytedance.msdk.d.u.b.c("TTMediationSDK", com.bytedance.msdk.d.u.u.d(hcVar.v()) + "server bidding网络请求响应成功......server bidding物料......");
                    i3 = 3;
                }
                hcVar3.hc = copyOnWriteArrayList;
                i2 = i3;
            }
        } else {
            i2 = (hVar == null || j.d(hVar.tt())) ? i : 2;
            com.bytedance.msdk.d.u.b.c("TTMediationSDK", com.bytedance.msdk.d.u.u.d(hcVar.v()) + "server bidding网络请求响应失败......没有返回serverBiddingModel相关数据");
            hcVar3 = null;
        }
        if (hVar != null) {
            String strAn = hVar.an();
            if (!TextUtils.isEmpty(strAn)) {
                if (hcVar3 == null) {
                    hcVar3 = new hc();
                }
                hcVar3.c = strAn;
            }
            if (hVar.gb()) {
                com.bytedance.msdk.d.u.b.c("TTMediationSDK", com.bytedance.msdk.d.u.u.d(hcVar.v()) + "server bidding发现config过期了，需要重新拉取配置......：");
                if (hcVar3 == null) {
                    hcVar3 = new hc();
                }
                hcVar3.b = true;
            }
            if (!j.d(hVar.u())) {
                if (hcVar3 == null) {
                    hcVar3 = new hc();
                }
                hcVar3.u = hVar.u();
            }
        }
        if (hcVar3 == null) {
            hcVar3 = new hc();
        }
        hcVar3.an = i2;
        hcVar3.h = jCurrentTimeMillis;
        if (dVar != null) {
            dVar.d(hcVar3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(long j, int i, com.bytedance.msdk.api.d dVar, com.bytedance.msdk.api.d.hc hcVar, c.d dVar2) {
        int i2 = (dVar == null || dVar.d != -1) ? 5 : 4;
        com.bytedance.msdk.d.u.b.c("TTMediationSDK", com.bytedance.msdk.d.u.u.d(hcVar.v()) + "server bidding网络请求响应失败......onFail  result:" + i2);
        hc hcVar2 = new hc();
        hcVar2.an = i2;
        hcVar2.h = System.currentTimeMillis() - j;
        hcVar2.gb = dVar;
        if (dVar2 != null) {
            dVar2.d(hcVar2);
        }
    }

    private List<tc> d(List<tc> list, com.bytedance.msdk.core.tc.hc hcVar, hc hcVar2) {
        List<tc> listY;
        if (list == null || list.size() == 0 || hcVar == null) {
            return null;
        }
        boolean zBooleanValue = hcVar.u().get("serverBidding_timeout") instanceof Boolean ? ((Boolean) hcVar.u().get("serverBidding_timeout")).booleanValue() : false;
        if (hcVar.an() == 4 && !zBooleanValue) {
            com.bytedance.msdk.core.tc.hc hcVarD = com.bytedance.msdk.h.d.b.d().d(hcVar.fs(), hcVar.ba(), 102);
            if (hcVarD == null) {
                return null;
            }
            listY = com.bytedance.msdk.core.tt.b.d(hcVarD, hcVarD.fs(), hcVar2 == null ? 0.0d : hcVar2.mq, hcVar2 != null ? hcVar2.k : 0.0d);
            hcVar.u().putAll(hcVarD.u());
        } else {
            listY = hcVar.y();
        }
        if (listY != null && listY.size() != 0) {
            ArrayList arrayList = new ArrayList();
            for (tc tcVar : listY) {
                Iterator<tc> it = list.iterator();
                while (true) {
                    if (it.hasNext()) {
                        tc next = it.next();
                        if (tcVar != null && next != null && tcVar.rf() == 0 && !TextUtils.isEmpty(tcVar.yo()) && tcVar.yo().equals(next.yo())) {
                            arrayList.add(tcVar);
                            break;
                        }
                    }
                }
            }
            return arrayList;
        }
        return null;
    }
}
