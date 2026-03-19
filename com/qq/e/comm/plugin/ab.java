package com.qq.e.comm.plugin;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class ab implements pj {
    private static final int c = r1.d().f().a("tcd", 500);
    private static final Class<oj>[] d = {g5.class, sv.class};
    private static final Class<oj>[] e = {zh.class};
    private boolean a = false;
    private Class<oj>[] b;

    public ab(Class<oj>[] clsArr) {
        this.b = clsArr;
    }

    private boolean a(Class<oj>[] clsArr, l6 l6Var, qs qsVar) throws IllegalAccessException, InstantiationException {
        oj ojVarNewInstance;
        boolean z;
        if (clsArr != null && clsArr.length != 0) {
            for (Class<oj> cls : clsArr) {
                try {
                    ojVarNewInstance = cls.newInstance();
                    z = true;
                    l6Var.H = !this.a;
                } catch (Exception unused) {
                }
                if (ojVarNewInstance.a(l6Var) && ojVarNewInstance.a(l6Var, qsVar)) {
                    return true;
                }
                if (ojVarNewInstance instanceof tj) {
                    if (!this.a && !((tj) ojVarNewInstance).a()) {
                        z = false;
                    }
                    this.a = z;
                }
            }
        }
        return false;
    }

    @Override // com.qq.e.comm.plugin.pj
    public void a(l6 l6Var, qs qsVar) throws IllegalAccessException, InterruptedException, InstantiationException {
        int i;
        yo yoVar = new yo(qsVar);
        o6.a(false, 0, l6Var);
        if (a(d, l6Var, yoVar)) {
            return;
        }
        boolean zA = a(e, l6Var, yoVar);
        if (zA && l6Var.B.J() == 1) {
            b10.a(1200210, l6Var.x);
        }
        if (zA && (i = c) > 0) {
            try {
                Thread.sleep(i);
            } catch (InterruptedException unused) {
            }
        }
        a(this.b, l6Var, yoVar);
        wv wvVar = new wv();
        if (wvVar.a(l6Var)) {
            wvVar.a(l6Var, yoVar);
        }
    }
}
