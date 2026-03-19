package com.android.gdt.qone.aw;

import com.android.gdt.qone.r.c;
import com.android.gdt.qone.r.d;
import com.android.gdt.qone.z.e;
import java.util.Collection;
import okhttp3.HttpUrl;
import org.json.JSONArray;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public abstract class a {
    public static String a() throws SecurityException {
        com.android.gdt.qone.q.a aVar = new com.android.gdt.qone.q.a();
        aVar.a("k1", d.class);
        aVar.a("k2", c.class);
        aVar.a("k3", com.android.gdt.qone.p.a.class);
        aVar.a("k4", e.class);
        aVar.a("k5", com.android.gdt.qone.z.c.class);
        aVar.a("k6", com.android.gdt.qone.z.b.class);
        aVar.a("k7", com.android.gdt.qone.v.e.class);
        aVar.a("k8", com.android.gdt.qone.ai.a.class);
        aVar.a("k9", com.android.gdt.qone.z.a.class);
        try {
            return new JSONArray((Collection) aVar.a).toString();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                StringBuilder sb = new StringBuilder();
                sb.append("[");
                int i = 0;
                while (i < aVar.a.size()) {
                    String[] strArr = (String[]) aVar.a.get(i);
                    sb.append("[\"" + strArr[0] + "\",\"" + strArr[1] + "\",\"" + strArr[2] + "\",\"" + strArr[3] + "\"]");
                    i++;
                    if (i != aVar.a.size()) {
                        sb.append(",");
                    }
                }
                sb.append("]");
                return sb.toString();
            } catch (Exception e2) {
                e2.printStackTrace();
                return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
            }
        }
    }
}
