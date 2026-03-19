package com.bytedance.sdk.component.gb.hc.b;

import android.text.TextUtils;
import com.baidu.mobads.container.components.j.a;
import com.bytedance.sdk.component.gb.d.c;
import com.bytedance.sdk.component.gb.d.u;
import com.bytedance.sdk.component.utils.mq;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class b {
    private static boolean d(String str) {
        c cVarC;
        u uVarB = b(str);
        if (uVarB == null || (cVarC = uVarB.c()) == null) {
            return false;
        }
        return cVarC.d();
    }

    private static String hc(String str) {
        c cVarC;
        u uVarB = b(str);
        if (uVarB == null || (cVarC = uVarB.c()) == null) {
            return null;
        }
        return cVarC.hc();
    }

    private static u b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return com.bytedance.sdk.component.gb.hc.d.u(str);
    }

    public static void d(String str, u uVar) {
        if (uVar == null) {
            return;
        }
        d(null, str, uVar.u(), 4);
    }

    public static void hc(String str, u uVar) {
        if (uVar == null) {
            return;
        }
        d(null, str, uVar.u(), 5);
    }

    public static void b(String str, u uVar) {
        if (uVar == null) {
            return;
        }
        d(null, str, uVar.u(), 6);
    }

    public static void c(String str, u uVar) {
        if (uVar == null) {
            return;
        }
        d(null, str, uVar.u(), 100);
    }

    public static void d(String str, String str2, u uVar) {
        if (uVar == null) {
            return;
        }
        d(str, str2, uVar.u(), 4);
    }

    public static void hc(String str, String str2, u uVar) {
        if (uVar == null) {
            return;
        }
        d(str, str2, uVar.u(), 5);
    }

    public static void b(String str, String str2, u uVar) {
        if (uVar == null) {
            return;
        }
        d(str, str2, uVar.u(), 6);
    }

    public static void d(String str, String str2, String str3) {
        d(str, str2, str3, 4);
    }

    private static void d(String str, String str2, String str3, int i) {
        try {
            if (d(str3) || i == 100) {
                String strHc = hc(str3);
                if (strHc == null) {
                    strHc = "";
                }
                String str4 = strHc + a.b;
                if (!TextUtils.isEmpty(str)) {
                    str4 = str4 + str;
                }
                if (i == 4) {
                    mq.d(str4, str2);
                    return;
                }
                if (i == 5) {
                    mq.hc(str4, str2);
                } else if (i == 6 || i == 100) {
                    mq.c(str4, str2);
                }
            }
        } catch (Exception e) {
            mq.d(e);
        }
    }
}
