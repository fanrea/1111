package com.android.gdt.qone.aj;

import android.text.TextUtils;
import com.android.gdt.qone.ad.h;
import com.android.gdt.qone.au.d;
import com.android.gdt.qone.report.beat.BeatType;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public abstract class c {
    public static final ConcurrentHashMap a = new ConcurrentHashMap();

    public static void a(String str, BeatType beatType, String str2) {
        boolean z;
        com.android.gdt.qone.w.c cVar;
        BeatType beatType2 = BeatType.NET_CHANGE;
        if (beatType == beatType2) {
            synchronized (com.android.gdt.qone.w.c.class) {
                cVar = com.android.gdt.qone.w.c.p;
            }
            if (!cVar.s()) {
                return;
            }
        }
        ConcurrentHashMap concurrentHashMap = a;
        Boolean boolValueOf = (Boolean) concurrentHashMap.get(str);
        if (boolValueOf == null) {
            if (TextUtils.isEmpty(h.a(str).c("is_first"))) {
                concurrentHashMap.put(str, Boolean.TRUE);
                z = true;
            } else {
                concurrentHashMap.put(str, Boolean.FALSE);
                z = false;
            }
            boolValueOf = Boolean.valueOf(z);
        }
        if (!Boolean.TRUE.equals(boolValueOf)) {
            int iIntValue = d.a(com.android.gdt.qone.au.b.B, com.android.gdt.qone.at.a.a(str).a.l).intValue();
            int i = b.a[beatType.ordinal()];
            if (i == 1) {
                int iA = BeatType.INIT.a();
                if ((iIntValue & iA) != iA) {
                    return;
                }
            } else if (i == 2) {
                int iA2 = BeatType.REGISTER.a();
                if ((iIntValue & iA2) != iA2) {
                    return;
                }
            } else if (i == 3) {
                int iA3 = BeatType.AUDIT.a();
                if ((iIntValue & iA3) != iA3) {
                    return;
                }
            } else {
                if (i != 4) {
                    return;
                }
                int iA4 = beatType2.a();
                if ((iIntValue & iA4) != iA4) {
                    return;
                }
            }
        }
        com.android.gdt.qone.v.a.a().a(new a(str, beatType, str2));
    }
}
