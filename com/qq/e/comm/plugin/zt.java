package com.qq.e.comm.plugin;

import android.text.TextUtils;
import com.qq.e.comm.plugin.aw;
import com.qq.e.comm.plugin.rr;
import com.qq.e.comm.plugin.s20;
import java.util.HashMap;
import java.util.Map;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class zt {

    /* compiled from: A */
    class a implements qr {
        final /* synthetic */ String a;

        @Override // com.qq.e.comm.plugin.qr
        public void a(aw awVar, hw hwVar) {
            hwVar.a();
        }

        @Override // com.qq.e.comm.plugin.qr
        public void a(aw awVar, Exception exc) {
            exc.getMessage();
        }

        a(String str) {
            this.a = str;
        }
    }

    public static void a(String str) {
        a(str, true, null);
    }

    public static void a(String str, boolean z) {
        a(str, z, null);
    }

    public static void a(String str, boolean z, qr qrVar) {
        a(str, z, null, qrVar, false, null, 0, 0);
    }

    public static void a(String str, boolean z, Map<String, String> map, qr qrVar, boolean z2, s20.h hVar, int i, int i2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        cu cuVar = new cu(str, aw.a.GET, (byte[]) null);
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                cuVar.b(entry.getKey(), entry.getValue());
            }
        }
        if (z2) {
            cuVar.e(z2);
            cuVar.a(hVar);
            cuVar.a(i);
        }
        if (i2 == 2 || i2 == 3) {
            Map<String, String> mapP = cuVar.p();
            if (mapP == null) {
                mapP = new HashMap<>();
                cuVar.a(mapP);
            }
            String str2 = i2 == 3 ? "1" : "2";
            String str3 = jh.e;
            mapP.put("NET_STRATEGY", str2);
        }
        rr rrVarA = sr.a();
        rr.a aVar = z ? rr.a.High : rr.a.Low;
        if (qrVar == null) {
            qrVar = new a(str);
        }
        rrVarA.a(cuVar, aVar, qrVar);
    }
}
