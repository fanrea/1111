package com.bytedance.msdk.b.b.hc.d;

import com.bytedance.msdk.b.b.hc.d.d.gb;
import com.bytedance.msdk.b.b.hc.d.hc.an;
import com.bytedance.msdk.b.b.hc.d.hc.h;
import com.bytedance.msdk.b.b.hc.d.hc.mk;
import com.bytedance.msdk.b.b.hc.d.hc.mq;
import com.bytedance.msdk.b.b.hc.d.hc.tc;
import com.bytedance.msdk.b.b.hc.d.hc.u;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class c {
    public static com.bytedance.msdk.b.d.d d(com.bytedance.msdk.b.an.hc.hc hcVar, com.bytedance.msdk.b.d.hc hcVar2) {
        if (hcVar == null) {
            return null;
        }
        int iE = hcVar.e();
        switch (hcVar.he()) {
            case 1:
                return new com.bytedance.msdk.b.b.hc.d.hc.d(hcVar2);
            case 2:
                return new h(hcVar2);
            case 3:
                return new mq(hcVar2);
            case 4:
            case 6:
            default:
                return null;
            case 5:
                if (iE == 4) {
                    return new tc(hcVar2);
                }
                if (iE == 5) {
                    return new u(hcVar2);
                }
                if (iE == 3) {
                    return new com.bytedance.msdk.b.b.hc.d.hc.d(hcVar2);
                }
                return new tc(hcVar2);
            case 7:
                if (iE == 6) {
                    return new mk(hcVar2);
                }
                if (iE == 7) {
                    return new an(hcVar2);
                }
                return new mk(hcVar2);
            case 8:
                return new an(hcVar2);
            case 9:
                return new u(hcVar2);
            case 10:
                if (iE == 1) {
                    return new h(hcVar2);
                }
                if (iE == 2) {
                    return new an(hcVar2);
                }
                return null;
        }
    }

    public static com.bytedance.msdk.b.d.d d(String str, com.bytedance.msdk.b.an.hc.hc hcVar, com.bytedance.msdk.b.d.hc hcVar2) {
        if (hcVar == null) {
            return null;
        }
        int iE = hcVar.e();
        switch (hcVar.he()) {
            case 1:
                return new com.bytedance.msdk.b.b.hc.d.d.d(str, hcVar2);
            case 2:
                return new com.bytedance.msdk.b.b.hc.d.d.an(str, hcVar2);
            case 3:
                return new gb(str, hcVar2);
            case 4:
            case 6:
            default:
                return null;
            case 5:
                if (iE == 4) {
                    return new com.bytedance.msdk.b.b.hc.d.d.c(str, hcVar2);
                }
                if (iE == 5) {
                    return new com.bytedance.msdk.b.b.hc.d.d.b(str, hcVar2);
                }
                if (iE == 3) {
                    return new com.bytedance.msdk.b.b.hc.d.d.d(str, hcVar2);
                }
                return new com.bytedance.msdk.b.b.hc.d.d.c(str, hcVar2);
            case 7:
                if (iE == 6) {
                    return new com.bytedance.msdk.b.b.hc.d.d.h(str, hcVar2);
                }
                if (iE == 7) {
                    return new com.bytedance.msdk.b.b.hc.d.d.u(str, hcVar2);
                }
                return new com.bytedance.msdk.b.b.hc.d.d.h(str, hcVar2);
            case 8:
                return new com.bytedance.msdk.b.b.hc.d.d.u(str, hcVar2);
            case 9:
                return new com.bytedance.msdk.b.b.hc.d.d.b(str, hcVar2);
            case 10:
                if (iE == 1) {
                    return new com.bytedance.msdk.b.b.hc.d.d.an(str, hcVar2);
                }
                if (iE == 2) {
                    return new com.bytedance.msdk.b.b.hc.d.d.u(str, hcVar2);
                }
                return null;
        }
    }
}
