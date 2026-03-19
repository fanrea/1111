package com.bytedance.msdk.b.b.d;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.msdk.b.b.d.d;
import com.bytedance.msdk.core.c.c;
import com.bytedance.msdk.gb.j;
import com.bytedance.msdk.gb.jh;
import com.bytedance.msdk.gb.us;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class hc implements d, com.bytedance.msdk.b.hc.hc.d {
    private com.bytedance.msdk.core.tc.hc an;
    protected long c;
    Map<Integer, List<com.bytedance.msdk.core.tc.tc>> d;
    private com.bytedance.msdk.api.d.hc gb;
    private String h;
    protected com.bytedance.msdk.b.an.d.d hc;
    private com.bytedance.msdk.b.h.hc.d mk;
    private Handler tc;
    private List<Integer> tt;
    private com.bytedance.msdk.b.an.d.hc u;
    protected final List<com.bytedance.msdk.core.tc.tc> b = new CopyOnWriteArrayList();
    private boolean mq = false;

    public hc() {
        Looper looperHc = com.bytedance.msdk.d.u.an.hc();
        if (looperHc != null) {
            this.tc = new Handler(looperHc) { // from class: com.bytedance.msdk.b.b.d.hc.1
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    hc.this.d(message);
                }
            };
        } else {
            com.bytedance.msdk.d.u.an.d();
            this.tc = new Handler(com.bytedance.msdk.d.u.an.hc()) { // from class: com.bytedance.msdk.b.b.d.hc.2
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    hc.this.d(message);
                }
            };
        }
    }

    @Override // com.bytedance.msdk.b.b.d.d
    public void d(d.InterfaceC0214d interfaceC0214d) {
        com.bytedance.msdk.b.an.d.hc hcVarD = interfaceC0214d.d();
        this.u = hcVarD;
        hcVarD.d(this.tc);
        this.hc = this.u.uo();
        this.an = this.u.mq();
        com.bytedance.msdk.api.d.hc hcVarRf = this.u.rf();
        this.gb = hcVarRf;
        this.h = hcVarRf.v();
        this.d = this.an.yi();
        ArrayList arrayList = new ArrayList();
        this.tt = arrayList;
        arrayList.addAll(this.d.keySet());
        com.bytedance.msdk.core.h.hc.d(this.tt);
        this.hc.d(this.tt);
        this.hc.h(this.an.de());
        List<com.bytedance.msdk.core.tc.tc> listD = com.bytedance.msdk.b.gb.an.d(this.an.y());
        List<com.bytedance.msdk.core.tc.tc> listHc = com.bytedance.msdk.b.gb.an.hc(this.an.y());
        this.hc.gb(listD == null ? 0 : listD.size());
        this.hc.tt(listHc == null ? 0 : listHc.size());
        Handler handler = this.tc;
        if (handler != null) {
            handler.sendEmptyMessageDelayed(6, this.an.hv());
        }
        if (!this.u.de()) {
            com.bytedance.msdk.u.an.d(this.gb, this.an.wl(), !this.u.v(), this.u.ba().d, 0, (Map<String, Object>) null);
        }
        if (this.an.mq()) {
            interfaceC0214d.d(interfaceC0214d.d());
        } else {
            if (com.bytedance.msdk.d.u.b.hc()) {
                com.bytedance.msdk.d.u.b.hc("TTMediationSDK", com.bytedance.msdk.d.u.u.d(this.an) + "开始加载广告 num:" + this.an.de());
            }
            b(0);
        }
        com.bytedance.msdk.core.k.hc.d(com.bytedance.msdk.core.hc.hc()).hc(1);
    }

    @Override // com.bytedance.msdk.b.b.d.d
    public void hc(d.InterfaceC0214d interfaceC0214d) {
        ((com.bytedance.msdk.core.c.an) com.bytedance.msdk.core.c.u.d()).d(this.u.mt(), this.c, this.gb, this.an, new c.d() { // from class: com.bytedance.msdk.b.b.d.hc.3
            @Override // com.bytedance.msdk.core.c.c.d
            public void d(com.bytedance.msdk.core.c.hc hcVar) {
                List<com.bytedance.msdk.core.tc.tc> list = hc.this.d != null ? hc.this.d.get(0) : null;
                hc hcVar2 = hc.this;
                hcVar2.d(hcVar2.gb, list, hcVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i) {
        if (i < 0) {
            return;
        }
        if (com.bytedance.msdk.b.gb.an.d(i, this.tt)) {
            int iRu = this.an.ru();
            com.bytedance.msdk.d.u.b.hc("TTMediationSDK", com.bytedance.msdk.d.u.u.d(this.an) + "the " + i + " level is first level normal ad and ParallelNum:" + iRu);
            for (int i2 = 0; i2 < iRu; i2++) {
                c(i + i2);
            }
            return;
        }
        c(i);
    }

    private void c(int i) {
        if (this.u.d() || u()) {
            com.bytedance.msdk.d.u.b.hc("TTMediationSDK", com.bytedance.msdk.d.u.u.d(this.an) + "已经触发过成功、失败回调...");
            return;
        }
        if (this.u.an()) {
            com.bytedance.msdk.d.u.b.hc("TTMediationSDK", com.bytedance.msdk.d.u.u.d(this.an) + "已经触发过destroy操作...");
            return;
        }
        if (hc()) {
            return;
        }
        if (i >= this.tt.size()) {
            com.bytedance.msdk.d.u.b.hc("TTMediationSDK", com.bytedance.msdk.d.u.u.d(this.an) + "第 " + i + " 层没有广告可以请求...");
            return;
        }
        int iIntValue = this.tt.get(i).intValue();
        if (this.hc.b(iIntValue)) {
            b(i + 1);
            return;
        }
        if (com.bytedance.msdk.b.gb.an.hc(iIntValue) && this.hc.hc() == -1) {
            com.bytedance.msdk.d.u.b.hc("TTMediationSDK", com.bytedance.msdk.d.u.u.d(this.an) + "开启serverBidding exchange 请求....");
            d(this.d.get(Integer.valueOf(iIntValue)));
            d(i);
            return;
        }
        this.hc.hc(iIntValue);
        d(iIntValue, i);
        if (com.bytedance.msdk.b.gb.an.b(iIntValue) || com.bytedance.msdk.b.gb.an.hc(iIntValue)) {
            com.bytedance.msdk.d.u.b.hc("TTMediationSDK", com.bytedance.msdk.d.u.u.d(this.an) + "第 " + i + "层 ClientBidding,ServerBidding 广告，levelSort：" + iIntValue + "，同时请求下一层广告...");
            b(i + 1);
        }
    }

    private void d(int i, int i2) {
        long jR;
        Handler handler;
        Map<Integer, List<com.bytedance.msdk.core.tc.tc>> map = this.d;
        if (map == null) {
            return;
        }
        final List<com.bytedance.msdk.core.tc.tc> list = map.get(Integer.valueOf(i));
        com.bytedance.msdk.d.u.b.hc("TTMediationSDK", com.bytedance.msdk.d.u.u.d(this.an) + "loadLevelWaterFall start...执行当前加载层级 ：" + i2 + " levelSort:" + i + "  waterFallConfig.size:" + (list == null ? 0 : list.size()));
        if (j.d(list)) {
            return;
        }
        this.hc.d(i, list.size());
        if (com.bytedance.msdk.b.gb.an.b(i)) {
            jR = this.an.jh();
        } else {
            jR = this.an.r();
        }
        Message messageObtain = Message.obtain();
        if (com.bytedance.msdk.b.gb.an.d(i)) {
            messageObtain.what = 1;
        } else if (com.bytedance.msdk.b.gb.an.b(i)) {
            messageObtain.what = 2;
        } else if (com.bytedance.msdk.b.gb.an.hc(i)) {
            messageObtain.what = 3;
        } else {
            messageObtain.what = 4;
            messageObtain.obj = jh.d(i);
        }
        messageObtain.arg1 = i;
        Handler handler2 = this.tc;
        if (handler2 != null) {
            handler2.sendMessageDelayed(messageObtain, jR);
        }
        long jMt = this.an.mt();
        if (jMt != 0 && (handler = this.tc) != null) {
            handler.removeMessages(5);
            this.tc.sendEmptyMessageDelayed(5, jMt);
        }
        for (final int i3 = 0; i3 < list.size(); i3++) {
            try {
                com.bytedance.msdk.d.u.an.c(new Runnable() { // from class: com.bytedance.msdk.b.b.d.hc.4
                    @Override // java.lang.Runnable
                    public void run() {
                        hc.this.d((com.bytedance.msdk.core.tc.tc) list.get(i3), list.size());
                    }
                });
                if (this.u.v()) {
                    this.u.vv();
                }
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.mq.d(th);
            }
        }
    }

    protected void d(com.bytedance.msdk.core.tc.tc tcVar, int i) {
        if (tcVar != null && this.gb != null) {
            d(tcVar.yo(), tcVar.e(), tcVar.cb(), com.bytedance.msdk.hc.d.d(this.gb.de(), tcVar.an()), 0, "广告请求中");
        }
        com.bytedance.msdk.d.u.b.hc("TTMediationSDK", com.bytedance.msdk.d.u.u.d(this.an) + "开始 某一层级的waterFallConfig请求 WaterFallConfig:" + tcVar.toString());
        com.bytedance.msdk.b.an.hc.hc hcVarD = com.bytedance.msdk.b.an.hc.hc.d(tcVar, this);
        hcVarD.b(1);
        hcVarD.hc(1);
        hcVarD.d(i);
        hcVarD.d(!this.u.v());
        hcVarD.d(SystemClock.elapsedRealtime());
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.bytedance.msdk.b.b.hc.hc());
        arrayList.add(new com.bytedance.msdk.b.b.hc.c());
        arrayList.add(new com.bytedance.msdk.b.b.hc.an());
        arrayList.add(new com.bytedance.msdk.b.b.hc.b());
        new com.bytedance.msdk.b.b.hc.u(arrayList).d(this.u, hcVarD);
    }

    protected void d(final List<com.bytedance.msdk.core.tc.tc> list) {
        final Context context = this.u.getContext();
        if (context != null) {
            com.bytedance.msdk.d.u.an.c(new Runnable() { // from class: com.bytedance.msdk.b.b.d.hc.5
                @Override // java.lang.Runnable
                public void run() {
                    hc hcVar = hc.this;
                    hcVar.d(context, hcVar.gb, list, !hc.this.u.v());
                }
            });
        }
    }

    public void d(final int i) {
        com.bytedance.msdk.b.h.hc.d dVarD = com.bytedance.msdk.b.h.hc.u.d(this.an);
        this.mk = dVarD;
        dVarD.d(this.tc, this.an, new com.bytedance.msdk.b.h.hc.hc(this.an, new Runnable() { // from class: com.bytedance.msdk.b.b.d.hc.6
            @Override // java.lang.Runnable
            public void run() {
                hc.this.b(i + 1);
            }
        }));
    }

    public boolean hc() {
        return hc(null, 3);
    }

    public boolean hc(com.bytedance.msdk.core.tc.tc tcVar, int i) {
        if (this.u.d() || u()) {
            return true;
        }
        if (this.hc.u()) {
            com.bytedance.msdk.d.u.b.c("TTMediationSDK", com.bytedance.msdk.d.u.u.d(this.an) + "触发总超时或全部代码位响应结束.....totalTimeout：" + this.hc.u() + "  allWtfFinish:" + this.hc.gb());
            if (!j.d(this.u.h()) || !j.d(this.u.gb()) || !j.d(this.u.tc())) {
                b();
            } else {
                if (com.bytedance.msdk.gb.hc.d.hc(this.an)) {
                    com.bytedance.msdk.d.u.b.hc("TTMediationSDK", com.bytedance.msdk.d.u.u.d(this.an) + "总加载时间超时.......isCallback:true");
                    if (com.bytedance.msdk.gb.hc.d.d(this.u, this.tt, this.d)) {
                        b();
                        return true;
                    }
                }
                this.mq = true;
                d(new com.bytedance.msdk.api.d(10003, com.bytedance.msdk.api.d.d(10003)));
            }
            return true;
        }
        if (this.hc.gb()) {
            com.bytedance.msdk.d.u.b.c("TTMediationSDK", com.bytedance.msdk.d.u.u.d(this.an) + "全部广告完成响应...");
            if (!j.d(this.u.h()) || !j.d(this.u.gb()) || !j.d(this.u.tc())) {
                b();
            } else {
                d(new com.bytedance.msdk.api.d(20005, com.bytedance.msdk.api.d.d(20005)));
            }
            return true;
        }
        if (this.u.k()) {
            com.bytedance.msdk.d.u.b.c("TTMediationSDK", com.bytedance.msdk.d.u.u.d(this.an) + "p层广告已经满足返回条件...");
            b();
            return true;
        }
        if (!(this.an.j() && this.hc.b()) && this.an.j()) {
            return false;
        }
        if (tcVar == null) {
            if (this.u.e() && this.u.w()) {
                com.bytedance.msdk.d.u.b.c("TTMediationSDK", com.bytedance.msdk.d.u.u.d(this.an) + "p层&普通层广告 已经满足返回条件 V1 .........");
                b();
                return true;
            }
            if (!this.u.cb() || !this.hc.tt() || !this.hc.tc() || !this.u.yo()) {
                return false;
            }
            com.bytedance.msdk.d.u.b.c("TTMediationSDK", com.bytedance.msdk.d.u.u.d(this.an) + "p层&普通&Bidding层广告 已经满足返回条件 V2 .........");
            b();
            return true;
        }
        if (this.u.e() && this.u.w()) {
            Iterator<com.bytedance.msdk.hc.b> it = this.u.gb().iterator();
            while (it.hasNext()) {
                com.bytedance.msdk.hc.b next = it.next();
                com.bytedance.msdk.b.h.d.d dVarD = com.bytedance.msdk.b.h.d.c.d(this.an);
                com.bytedance.msdk.b.an.d.hc hcVar = this.u;
                Map<Integer, List<com.bytedance.msdk.core.tc.tc>> map = this.d;
                if (dVarD.d(hcVar, next, map == null ? null : map.get(Integer.valueOf(com.bytedance.msdk.b.gb.an.d(this.an, next))))) {
                    com.bytedance.msdk.d.u.b.c("TTMediationSDK", com.bytedance.msdk.d.u.u.d(this.an) + "p层&普通层广告 已经满足返回条件 V3 .........");
                    b();
                    return true;
                }
            }
            return false;
        }
        if (!this.u.cb() || !this.hc.tt() || !this.hc.tc() || !this.u.yo()) {
            return false;
        }
        com.bytedance.msdk.d.u.b.c("TTMediationSDK", com.bytedance.msdk.d.u.u.d(this.an) + "p层&普通&Bidding层广告 已经满足返回条件 V4 .........");
        b();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(Message message) {
        int i = message.arg1;
        switch (message.what) {
            case 1:
            case 4:
                com.bytedance.msdk.d.u.b.c("TTMediationSDK", com.bytedance.msdk.d.u.u.d(this.an) + (message.what == 1 ? "P层" : "普通层") + "广告触发层超时.........levelSort:" + i);
                this.hc.c(i);
                if (!hc()) {
                    b(hc(i));
                    break;
                }
                break;
            case 2:
            case 3:
                com.bytedance.msdk.d.u.b.c("TTMediationSDK", com.bytedance.msdk.d.u.u.d(this.an) + (message.what == 2 ? "ClientBidding层" : "ServerBidding层层") + "广告触发层超时.........levelSort:" + i);
                this.hc.c(i);
                hc();
                break;
            case 5:
                com.bytedance.msdk.d.u.b.c("TTMediationSDK", com.bytedance.msdk.d.u.u.d(this.an) + "触发最小层超时.........levelSort:" + i);
                hc();
                break;
            case 6:
                com.bytedance.msdk.d.u.b.c("TTMediationSDK", com.bytedance.msdk.d.u.u.d(this.an) + "触发总超时.........");
                this.hc.c();
                this.u.ba().an = true;
                hc();
                break;
        }
    }

    @Override // com.bytedance.msdk.b.hc.hc.d
    public void d(List<com.bytedance.msdk.hc.b> list, com.bytedance.msdk.core.tc.tc tcVar) {
        if (j.d(list) || tcVar == null) {
            return;
        }
        d(list, this.an);
        d(tcVar.yo(), tcVar.e(), tcVar.cb(), com.bytedance.msdk.hc.d.d(tcVar.uo(), tcVar.an()), 0, "广告加载成功");
        com.bytedance.msdk.core.h.b.d(this.h, tcVar, !j.hc(list) ? list.get(0) : null);
        hc(list);
        int iD = com.bytedance.msdk.b.gb.an.d(this.an, tcVar);
        if (tcVar.mt() && com.bytedance.msdk.b.h.d.d(this.hc, this.b, tcVar.yo())) {
            com.bytedance.msdk.d.u.b.c("TTMediationSDK", com.bytedance.msdk.d.u.u.d(this.an) + "返回的普通广告被server Bidding过滤了......slotId:" + tcVar.yo());
            this.u.tt().addAll(list);
            return;
        }
        com.bytedance.msdk.b.gb.d.d(this.u, list, false);
        this.hc.d(iD, tcVar.yo());
        if (this.u.v()) {
            b(list);
        }
        if (this.hc.u()) {
            d((List<com.bytedance.msdk.hc.b>) null, new com.bytedance.msdk.api.d(10012, "load ad timeout !!!"));
        } else {
            d(list, (com.bytedance.msdk.api.d) null);
        }
        this.u.d(list);
        if (hc(tcVar, 1) || this.hc.an(iD) != 0 || tcVar.ba()) {
            return;
        }
        int iHc = hc(iD);
        b(tcVar, iD);
        com.bytedance.msdk.d.u.b.c("TTMediationSDK", com.bytedance.msdk.d.u.u.d(this.an) + "onAdLoaded levelSort: " + iD + " 广告全部响应结束&不满足返回条件，直接请求下一层广告 nextIdx：" + iHc);
        b(iHc);
    }

    @Override // com.bytedance.msdk.b.hc.hc.d
    public void d(com.bytedance.msdk.api.d dVar, com.bytedance.msdk.core.tc.tc tcVar) {
        if (tcVar == null) {
            return;
        }
        d((List<com.bytedance.msdk.hc.b>) null, dVar);
        if (dVar != null) {
            d(tcVar.yo(), tcVar.w(), tcVar.cb(), com.bytedance.msdk.hc.d.d(tcVar.uo(), tcVar.an()), dVar.b, dVar.c);
        }
        com.bytedance.msdk.core.h.b.d(dVar, tcVar);
        if (tcVar.mt() && com.bytedance.msdk.b.h.d.d(this.hc, this.b, tcVar.yo())) {
            return;
        }
        int iD = com.bytedance.msdk.b.gb.an.d(this.an, tcVar);
        this.hc.d(iD, tcVar.yo());
        if (hc(tcVar, 2) || this.hc.u(iD) || this.hc.an(iD) != 0 || tcVar.ba()) {
            return;
        }
        int iHc = hc(iD);
        b(tcVar, iD);
        com.bytedance.msdk.d.u.b.c("TTMediationSDK", com.bytedance.msdk.d.u.u.d(this.an) + "onAdFailed levelSort " + iD + " 广告全部响应结束&不满足返回条件，直接请求下一层广告 nextIdx：" + iHc);
        b(iHc);
    }

    private void b(com.bytedance.msdk.core.tc.tc tcVar, int i) {
        int i2;
        if (tcVar == null || this.tc == null) {
            return;
        }
        if (tcVar.z()) {
            i2 = 1;
        } else if (tcVar.us() || tcVar.fs()) {
            i2 = 2;
        } else {
            i2 = tcVar.s() ? 3 : 4;
        }
        if (tcVar.mt()) {
            this.tc.removeMessages(i2, jh.d(i));
        } else {
            this.tc.removeMessages(i2);
        }
    }

    @Override // com.bytedance.msdk.b.hc.hc.d
    public void d() {
        com.bytedance.msdk.d.u.b.hc("TTMediationSDK", com.bytedance.msdk.d.u.u.d(this.an) + "onAdVideoCache.....");
        c();
    }

    void b() {
        this.mq = false;
        this.u.c();
    }

    void d(com.bytedance.msdk.api.d dVar) {
        this.u.d(dVar);
    }

    void c() {
        this.u.u();
    }

    void d(List<com.bytedance.msdk.hc.b> list, com.bytedance.msdk.api.d dVar) {
        this.u.d(list, dVar);
    }

    protected int hc(int i) {
        int iIndexOf;
        List<Integer> list = this.tt;
        if (list == null || (iIndexOf = list.indexOf(Integer.valueOf(i))) == -1) {
            return -1;
        }
        return iIndexOf + 1;
    }

    protected void d(Context context, final com.bytedance.msdk.api.d.hc hcVar, final List<com.bytedance.msdk.core.tc.tc> list, boolean z) {
        com.bytedance.msdk.core.c.c cVarD = com.bytedance.msdk.core.c.u.d();
        if (cVarD != null) {
            this.hc.d(0);
            this.u.ba().c = true;
            com.bytedance.msdk.core.c.b bVar = new com.bytedance.msdk.core.c.b();
            bVar.d = hcVar;
            bVar.hc = list;
            bVar.c = this.an;
            bVar.an = z;
            bVar.u = hcVar != null ? hcVar.b() : 1;
            cVarD.d(this.u.sy(), context, bVar, new c.d() { // from class: com.bytedance.msdk.b.b.d.hc.7
                @Override // com.bytedance.msdk.core.c.c.d
                public void d(com.bytedance.msdk.core.c.hc hcVar2) {
                    hc.this.d(hcVar, list, hcVar2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.bytedance.msdk.api.d.hc hcVar, List<com.bytedance.msdk.core.tc.tc> list, com.bytedance.msdk.core.c.hc hcVar2) {
        com.bytedance.msdk.b.h.hc.d dVar;
        if (this.u != null && hcVar2 != null && !TextUtils.isEmpty(hcVar2.c)) {
            this.u.ba().d = hcVar2.c;
        }
        com.bytedance.msdk.core.tc.hc hcVar3 = this.an;
        if (hcVar3 != null && hcVar2 != null) {
            hcVar3.u().put("price_source", Integer.valueOf(hcVar2.uo));
        }
        if (hcVar2 != null) {
            com.bytedance.msdk.u.an.d(hcVar, hcVar2, this.hc.u() ? 1 : 0);
        }
        if (hcVar2 != null && !j.d(hcVar2.hc)) {
            this.hc.d(1);
            if (this.u.d() || this.u.hc()) {
                return;
            }
            this.b.clear();
            this.b.addAll(hcVar2.hc);
            Handler handler = this.tc;
            if (handler != null) {
                handler.removeMessages(1);
                this.tc.removeMessages(4);
                this.tc.removeMessages(5);
            }
            us.d(hcVar2.hc);
            this.d = com.bytedance.msdk.b.gb.an.d(hcVar2.hc, this.an.mk());
            ArrayList arrayList = new ArrayList();
            this.tt = arrayList;
            arrayList.addAll(this.d.keySet());
            com.bytedance.msdk.core.h.hc.d(this.tt);
            this.hc.d(this.tt);
            this.hc.d(hcVar2.hc, com.bytedance.msdk.b.gb.an.d(this.an.y()), com.bytedance.msdk.b.gb.an.b(this.an.y()));
            com.bytedance.msdk.b.h.d.d(this.an, this.u, hcVar2.hc);
            com.bytedance.msdk.d.u.b.c("TTMediationSDK", com.bytedance.msdk.d.u.u.d(this.an) + "serverBidding响应回来..........开始从头开始请求waterFallConfig  代码位总数量：" + hcVar2.hc.size());
            b(0);
            hc();
        } else {
            this.hc.d(2);
            if (this.u.d() || this.u.hc()) {
                return;
            }
            com.bytedance.msdk.d.u.b.c("TTMediationSDK", com.bytedance.msdk.d.u.u.d(this.an) + "serverBidding响应失败了.......... ");
            this.hc.hc(0);
            if (list != null) {
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    com.bytedance.msdk.core.tc.tc tcVar = list.get(i);
                    this.hc.d(com.bytedance.msdk.b.gb.an.d(this.an, tcVar), tcVar.yo());
                }
            }
            if (!hc() && (dVar = this.mk) != null) {
                dVar.d();
            }
        }
        if (this.an != null && hcVar2 != null) {
            com.bytedance.msdk.core.tt.hc.c().d(hcVar2.mq, hcVar2.k, this.an.fs(), this.an.us());
        }
        if (hcVar2 == null || !hcVar2.b) {
            return;
        }
        com.bytedance.msdk.core.k.hc.d(com.bytedance.msdk.core.hc.hc()).d().hc(1);
    }

    public boolean u() {
        if (this.u.hc()) {
            return (this.mq && com.bytedance.msdk.gb.hc.d.d(this.an)) ? false : true;
        }
        return false;
    }

    protected void d(List<com.bytedance.msdk.hc.b> list, com.bytedance.msdk.core.tc.hc hcVar) {
        com.bytedance.msdk.core.tt.c.d(list, hcVar);
        com.bytedance.msdk.core.hc.d.d(list, hcVar);
    }

    protected void d(String str, String str2, String str3, String str4, int i, String str5) {
        com.bytedance.msdk.api.hc hcVar = this.u.np().get(str);
        if (hcVar == null) {
            hcVar = new com.bytedance.msdk.api.hc();
        }
        hcVar.hc(str).b(str2).c(str3).d(i).u(str5).d(str4);
        this.u.np().put(str, hcVar);
    }

    private void hc(List<com.bytedance.msdk.hc.b> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        String strPh = list.get(0).ph();
        if (list.get(0).rs() && com.bytedance.msdk.core.u.d.d.d().u(this.h, strPh, this.gb.u()) == 1) {
            ArrayList arrayList = new ArrayList();
            for (com.bytedance.msdk.hc.b bVar : list) {
                if (bVar != null) {
                    arrayList.add(new com.bytedance.msdk.core.u.hc.h(bVar, 0L, this.gb));
                }
            }
            if (arrayList.size() > 0) {
                com.bytedance.msdk.hc.b bVar2 = ((com.bytedance.msdk.core.u.hc.h) arrayList.get(0)).d;
                com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "--==-- 广告复用:广告缓存成功 -------" + bVar2.nw() + ", adType: " + com.bytedance.msdk.hc.d.d(bVar2.el(), bVar2.nv()) + ", adnSlotId: " + bVar2.ph() + ", ad个数: " + arrayList.size());
                com.bytedance.msdk.core.u.d.d.d().d(strPh, (List<com.bytedance.msdk.core.u.hc.h>) arrayList, false);
            }
        }
    }

    private void b(List<com.bytedance.msdk.hc.b> list) {
        if (list == null) {
            return;
        }
        for (com.bytedance.msdk.hc.b bVar : list) {
            if (bVar != null) {
                com.bytedance.msdk.core.u.hc.c.d().d(this.h, new com.bytedance.msdk.core.u.hc.h(bVar, this.u.zw(), this.gb));
            }
        }
    }
}
