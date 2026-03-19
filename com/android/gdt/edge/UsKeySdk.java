package com.android.gdt.edge;

import com.android.gdt.qone.af.c;
import com.android.gdt.qone.codez.jni.X;
import com.android.gdt.qone.uin.U;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class UsKeySdk {
    public static String getUsKey(String str, String str2, String str3, String str4, String str5) {
        if (U.a) {
            return X.a(str, str2, str3, str4, str5);
        }
        c.a("uskey", "query uskey error, init not finished, please try again", new Object[0]);
        return "";
    }
}
