package com.bytedance.msdk.b.c;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.msdk.b.b.d.d;
import com.bytedance.msdk.gb.j;
import com.bytedance.msdk.hc.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class h extends hc {
    private d.InterfaceC0214d cb;
    private com.bytedance.msdk.api.c.d.b.hc d;
    private com.bytedance.msdk.api.c.d.b hc;

    public h(Context context) {
        super(context);
    }

    public void d(com.bytedance.msdk.api.d.hc hcVar, com.bytedance.msdk.api.c.d.b.hc hcVar2) {
        d(hcVar);
        this.d = hcVar2;
        tt();
    }

    @Override // com.bytedance.msdk.b.c.hc, com.bytedance.msdk.b.hc.d.d
    public void hc(com.bytedance.msdk.api.d dVar) {
        com.bytedance.msdk.api.c.d.b.hc hcVar = this.d;
        if (hcVar != null) {
            hcVar.d(dVar);
            if (this.mk != 0 || this.hc == null) {
                return;
            }
            this.mk = 2;
            this.hc.d(dVar);
        }
    }

    @Override // com.bytedance.msdk.b.c.hc, com.bytedance.msdk.b.hc.d.d
    public void h() {
        List<com.bytedance.msdk.hc.b> listD;
        if (this.d == null || (listD = d(this.b.jh(), this.an.vv())) == null || listD.size() <= 0) {
            return;
        }
        if (com.bytedance.msdk.d.u.b.hc()) {
            com.bytedance.msdk.d.u.b.c("TTMediationSDK", "返回给外部开发者的广告数量：sumList.size=" + listD.size());
        }
        CopyOnWriteArrayList<com.bytedance.msdk.hc.b> copyOnWriteArrayList = new CopyOnWriteArrayList<>(this.b.jh());
        for (com.bytedance.msdk.hc.b bVar : listD) {
            if (bVar != null) {
                bVar.u(true);
                if (bVar.rs() && com.bytedance.msdk.core.u.d.d.d().c(this.u, bVar.ph(), this.an.u())) {
                    com.bytedance.msdk.b.gb.u.d(bVar, this.u, bVar.ph());
                    d(copyOnWriteArrayList, bVar);
                }
                d(this.b.h(), bVar);
                d(this.b.gb(), bVar);
                d(this.b.tt(), bVar);
                d(this.b.tc(), bVar);
            }
        }
        com.bytedance.msdk.core.u.d.d.d().d(copyOnWriteArrayList, this.u, this.an, this.an.u(), null);
        this.d.d(listD);
    }

    @Override // com.bytedance.msdk.b.c.hc, com.bytedance.msdk.b.hc.d.d
    public void d(List<com.bytedance.msdk.hc.b> list, com.bytedance.msdk.api.d dVar) {
        super.d(list, dVar);
        if (!(this.d instanceof com.bytedance.msdk.api.c.d.b.u) || j.d(list)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (com.bytedance.msdk.hc.b bVar : list) {
            bVar.d(new b.d() { // from class: com.bytedance.msdk.b.c.h.1
                @Override // com.bytedance.msdk.hc.b.d
                public void d() {
                    h.this.mq = true;
                }

                @Override // com.bytedance.msdk.hc.b.d
                public void d(com.bytedance.msdk.hc.b bVar2) {
                    h.this.d(bVar2, -1);
                }
            });
            arrayList.add(bVar);
        }
    }

    @Override // com.bytedance.msdk.b.c.hc, com.bytedance.msdk.b.hc.d.d
    public void d(String str) {
        if (this.mk != 0 || this.hc == null) {
            return;
        }
        this.mk = 1;
        this.hc.d(str);
    }

    public void d(String str, com.bytedance.msdk.api.c.d.b.hc hcVar) {
        if (this.mk != 1) {
            if (hcVar != null) {
                hcVar.d(new com.bytedance.msdk.api.d(10015, com.bytedance.msdk.api.d.d(10015)));
            }
        } else if (this.tc) {
            if (hcVar != null) {
                hcVar.d(new com.bytedance.msdk.api.d(40047, com.bytedance.msdk.api.d.d(40047)));
            }
        } else {
            this.tc = true;
            this.d = hcVar;
            d.InterfaceC0214d interfaceC0214d = this.cb;
            if (interfaceC0214d != null) {
                interfaceC0214d.d(str);
            }
        }
    }

    public void d(com.bytedance.msdk.api.d.hc hcVar, com.bytedance.msdk.api.c.d.b bVar) {
        d(hcVar);
        this.hc = bVar;
        if (this.b.mq() != null && this.b.mq().mq()) {
            this.cb = tt();
        } else if (bVar != null) {
            bVar.d(new com.bytedance.msdk.api.d(10014, com.bytedance.msdk.api.d.d(10014)));
        }
    }

    @Override // com.bytedance.msdk.b.c.hc
    public void d() {
        super.d();
        this.d = null;
    }

    private List<com.bytedance.msdk.hc.b> d(List<com.bytedance.msdk.hc.b> list, int i) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        b(list);
        b();
        final ArrayList arrayList = new ArrayList();
        Iterator<com.bytedance.msdk.hc.b> it = list.iterator();
        while (it.hasNext() && arrayList.size() < i) {
            com.bytedance.msdk.hc.b next = it.next();
            next.d(new b.d() { // from class: com.bytedance.msdk.b.c.h.2
                @Override // com.bytedance.msdk.hc.b.d
                public void d() {
                    h.this.mq = true;
                }

                @Override // com.bytedance.msdk.hc.b.d
                public void d(com.bytedance.msdk.hc.b bVar) {
                    int i2 = 0;
                    while (i2 < arrayList.size() && bVar != arrayList.get(i2)) {
                        i2++;
                    }
                    h.this.d(bVar, i2);
                }
            });
            arrayList.add(next);
            if (com.bytedance.msdk.d.u.b.hc()) {
                com.bytedance.msdk.d.u.b.c("TTMediationSDK", "");
                com.bytedance.msdk.d.u.b.c("TTMediationSDK", com.bytedance.msdk.d.u.u.d(this.u, "show") + "返回给开发者最终广告：slotId=" + next.ph() + ",slotType:" + next.hg() + ",cpm=" + next.kb() + ",广告类型：" + com.bytedance.msdk.hc.d.d(next.t()) + ",ImageMode=" + next.ar() + ",showSort=" + next.gu() + ",isExpressAd=" + next.ey());
            }
            it.remove();
        }
        d(arrayList);
        return arrayList;
    }

    public void d(com.bytedance.msdk.hc.b bVar, int i) {
        if (bVar != null && bVar.rs() && com.bytedance.msdk.core.u.d.d.d().c(this.u, bVar.ph(), this.an.u())) {
            com.bytedance.msdk.core.u.d.d.d().d(bVar.ph(), this.an, this.b.j(), i == 0, this.b.s(), this.b.ba(), this.gb.get());
        }
    }

    private void d(CopyOnWriteArrayList<com.bytedance.msdk.hc.b> copyOnWriteArrayList, com.bytedance.msdk.hc.b bVar) {
        Iterator<com.bytedance.msdk.hc.b> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            com.bytedance.msdk.hc.b next = it.next();
            if (next == bVar && next != null) {
                copyOnWriteArrayList.remove(next);
            }
        }
    }

    private void b(List<com.bytedance.msdk.hc.b> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        ArrayList<com.bytedance.msdk.hc.b> arrayList = new ArrayList(list.size());
        arrayList.addAll(list);
        list.clear();
        for (com.bytedance.msdk.hc.b bVar : arrayList) {
            if (bVar != null && !bVar.xp() && bVar.ba(this.u)) {
                list.add(bVar);
            }
        }
    }

    private void b() {
        try {
            List<com.bytedance.msdk.core.tc.tc> listHc = hc();
            if (listHc == null || listHc.size() <= 0) {
                return;
            }
            for (com.bytedance.msdk.core.tc.tc tcVar : listHc) {
                if (tcVar != null) {
                    String strYo = tcVar.yo();
                    if (com.bytedance.msdk.core.u.d.d.d().c(this.u, strYo, this.an.u())) {
                        if (tcVar.rf() == 100) {
                            d(strYo, this.b.h());
                        } else if (tcVar.rf() == 0) {
                            d(strYo, this.b.gb());
                        }
                    }
                }
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.mq.d(th);
        }
    }

    private void d(String str, List<com.bytedance.msdk.hc.b> list) {
        List<com.bytedance.msdk.core.u.hc.h> listD;
        if (hc(str, list) || com.bytedance.msdk.core.u.d.d.d().d(str, this.an, false) != 3 || (listD = com.bytedance.msdk.core.u.d.d.d().d(str, this.an, this.an.u())) == null || listD.size() <= 0) {
            return;
        }
        for (com.bytedance.msdk.core.u.hc.h hVar : listD) {
            if (hVar != null && hVar.d != null && !hVar.d.xp() && hVar.d.ba(this.u)) {
                list.add(hVar.d);
                hc(hVar.d);
            }
        }
    }

    private boolean hc(String str, List<com.bytedance.msdk.hc.b> list) {
        if (list == null || list.size() <= 0) {
            return false;
        }
        for (com.bytedance.msdk.hc.b bVar : list) {
            if (bVar != null && TextUtils.equals(str, bVar.ph())) {
                return true;
            }
        }
        return false;
    }
}
