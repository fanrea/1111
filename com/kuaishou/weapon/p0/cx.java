package com.kuaishou.weapon.p0;

import android.content.Context;
import java.util.Date;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class cx {
    private static volatile cx b;
    private Context a;

    private cx(Context context) {
        this.a = context;
    }

    public static cx a(Context context) {
        if (b == null) {
            synchronized (cx.class) {
                if (b == null) {
                    b = new cx(context);
                }
            }
        }
        return b;
    }

    public void a(final int i) {
        n.a().a(new Runnable() { // from class: com.kuaishou.weapon.p0.cx.1
            @Override // java.lang.Runnable
            public void run() {
                int i2;
                try {
                    h hVarA = h.a(cx.this.a, "re_po_rt");
                    if (hVarA.b(df.y, 0) == 1) {
                        long jA = df.a(cx.this.a).a(df.bh);
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        long jB = hVarA.b(df.z, 8) * 3600000;
                        int iB = hVarA.b(df.q, 0);
                        if (jA > 0 && jCurrentTimeMillis - jA < WeaponHI.ii * 3600000 && WeaponHI.isList != null) {
                            if (WeaponHI.isList.contains(new StringBuilder().append(new Date(jCurrentTimeMillis).getHours()).toString())) {
                                return;
                            }
                        }
                        if (jCurrentTimeMillis - jA >= jB || (i2 = i) == 106 || (i2 == 100 && iB == 1)) {
                            cp.a(cx.this.a, new ch(cx.this.a, i).a(ck.i), ck.i, false, true);
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }
}
