package com.kuaishou.weapon.p0;

import android.content.Context;
import java.util.Date;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class dd {
    private static volatile dd b;
    private Context a;

    private dd(Context context) {
        this.a = context;
    }

    public static dd a(Context context) {
        if (b == null) {
            synchronized (dd.class) {
                if (b == null) {
                    b = new dd(context);
                }
            }
        }
        return b;
    }

    public void a(final int i) {
        n.a().a(new Runnable() { // from class: com.kuaishou.weapon.p0.dd.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (h.a(dd.this.a, "re_po_rt").b(df.aC, 1) == 1) {
                        long jA = df.a(dd.this.a).a();
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        long jB = r0.b(df.aE, 8) * 3600000;
                        if (jA > 0 && jCurrentTimeMillis - jA < WeaponHI.ii * 3600000 && WeaponHI.isList != null) {
                            if (WeaponHI.isList.contains(new StringBuilder().append(new Date(jCurrentTimeMillis).getHours()).toString())) {
                                return;
                            }
                        }
                        if (jCurrentTimeMillis - jA >= jB || i == 106) {
                            cp.a(dd.this.a, new cn(dd.this.a, i).a(ck.b), ck.b, true, true);
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }
}
