package com.android.gdt.edge;

import android.text.TextUtils;
import com.android.gdt.qone.af.c;
import com.android.gdt.qone.codez.jni.X;
import com.android.gdt.qone.uin.U;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class LKSdk {
    public static String glk(String str) {
        if (U.a) {
            String strA = X.a(str);
            return TextUtils.isEmpty(strA) ? "" : strA;
        }
        c.a("lkey", "query lkey error, init not finished, please try again", new Object[0]);
        return "";
    }
}
