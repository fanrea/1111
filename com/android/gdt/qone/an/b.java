package com.android.gdt.qone.an;

import android.content.Context;
import com.android.gdt.qone.af.c;
import com.android.gdt.qone.ai.f;
import com.android.gdt.qone.uin.U;
import java.io.File;
import java.util.Arrays;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class b {
    public boolean a;

    public final boolean a(String str, Context context, String str2, String str3, boolean z, boolean z2) {
        if (this.a) {
            return true;
        }
        File filesDir = context.getFilesDir();
        if (!filesDir.exists()) {
            filesDir.mkdir();
        }
        boolean zA = U.a(context, new File(filesDir, str2).getAbsolutePath(), str3, z, z2);
        this.a = zA;
        if (!zA) {
            com.android.gdt.qone.ai.a.a(str);
        }
        c.b("SDK_INIT ｜ LOCAL_ENC", " initialization is complete (%b),fileName is %s ", Boolean.valueOf(this.a), str2);
        return this.a;
    }

    public final String a(String str) {
        byte[] bArrB;
        if (!this.a || (bArrB = U.b(str)) == null || bArrB.length <= 1) {
            return "";
        }
        byte b = bArrB[0];
        if (b != 0 && b != 104 && b != 101) {
            if (b == 100) {
                com.android.gdt.qone.am.a.a(str).c = true;
            } else {
                f fVarA = f.a();
                com.android.gdt.qone.ai.c cVarA = com.android.gdt.qone.r.b.a(fVarA);
                cVarA.a.put("6", String.valueOf((int) b));
                fVarA.a(cVarA, "v6", str);
            }
        }
        return (b == 0 || b == 100) ? new String(Arrays.copyOfRange(bArrB, 1, bArrB.length)) : "";
    }
}
