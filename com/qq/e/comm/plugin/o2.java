package com.qq.e.comm.plugin;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class o2 implements jl {
    o2() {
    }

    @Override // com.qq.e.comm.plugin.jl
    public boolean a(m7 m7Var) {
        String[] strArrI = g2.i();
        for (StackTraceElement stackTraceElement : m7Var.f) {
            String className = stackTraceElement.getClassName();
            for (String str : strArrI) {
                if (className.startsWith(str)) {
                    return false;
                }
            }
        }
        return true;
    }
}
