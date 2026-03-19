package com.qq.e.comm.plugin;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
abstract class n0 implements pj {
    protected final List<Class<? extends oj>> a;
    private boolean b;

    protected n0() {
        ArrayList arrayList = new ArrayList();
        this.a = arrayList;
        this.b = false;
        arrayList.add(g5.class);
    }

    private oj a(Class<? extends oj> cls) {
        try {
            return cls.newInstance();
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.qq.e.comm.plugin.pj
    public void a(l6 l6Var, qs qsVar) {
        if (this.a.size() <= 0) {
            return;
        }
        yo yoVar = new yo(qsVar);
        o6.a(false, 0, l6Var);
        long jCurrentTimeMillis = System.currentTimeMillis();
        Iterator<Class<? extends oj>> it = this.a.iterator();
        while (true) {
            boolean z = true;
            if (it.hasNext()) {
                Class<? extends oj> next = it.next();
                oj ojVarA = a(next);
                if (ojVarA == null) {
                    o6.a(true, 1, l6Var);
                    return;
                }
                boolean zA = ojVarA.a(l6Var);
                next.getSimpleName();
                if (zA) {
                    l6Var.H = !this.b;
                    boolean zA2 = ojVarA.a(l6Var, yoVar);
                    next.getSimpleName();
                    if (zA2) {
                        oj ojVarA2 = a(wv.class);
                        if (ojVarA2 != null && ojVarA2.a(l6Var)) {
                            ojVarA2.a(l6Var, yoVar);
                        }
                        o6.a(2300008, jCurrentTimeMillis, l6Var);
                        return;
                    }
                    if (ojVarA instanceof tj) {
                        if (!this.b && !((tj) ojVarA).a()) {
                            z = false;
                        }
                        this.b = z;
                    }
                }
            } else {
                if (l6Var.u) {
                    yoVar.i();
                }
                l6Var.a();
                o6.a(true, 2, l6Var);
                return;
            }
        }
    }
}
