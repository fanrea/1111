package com.pangrowth.adclog;

import java.util.Enumeration;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class c2 implements s1 {
    @Override // com.pangrowth.adclog.s1
    public boolean a(p1 p1Var) {
        Enumeration enumerationElements = f1.c().a.elements();
        if (enumerationElements != null) {
            while (enumerationElements.hasMoreElements()) {
                l2 l2Var = (l2) enumerationElements.nextElement();
                if (l2Var != null && l2Var.a(p1Var)) {
                    n2.a(new q2(0L, false, p1Var.c, null));
                    return true;
                }
            }
        }
        return false;
    }
}
