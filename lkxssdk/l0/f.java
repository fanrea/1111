package lkxssdk.l0;

import android.content.SharedPreferences;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public final class f {
    public static final Map<String, f> a = new HashMap();
    public SharedPreferences b;

    public f(String str, int i) {
        this.b = lkxssdk.a.a.d().getSharedPreferences(str, i);
    }

    public static f a() {
        Map<String, f> map = a;
        f fVar = map.get("XswaWeb");
        if (fVar == null) {
            synchronized (f.class) {
                fVar = map.get("XswaWeb");
                if (fVar == null) {
                    fVar = new f("XswaWeb", 0);
                    map.put("XswaWeb", fVar);
                }
            }
        }
        return fVar;
    }
}
