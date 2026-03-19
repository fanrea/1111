package com.tencent.turingfd.sdk.ams.au;

import android.content.Context;
import android.os.Process;
import com.sigmob.sdk.base.mta.PointType;
import java.io.File;
import java.util.HashMap;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class Nectarine {
    public static final String a = Cfinally.a(Cfinally.A0);
    public static final String b = Cfinally.a(Cfinally.B0);
    public static boolean c = false;

    public static void a(Context context, Kiwifruit kiwifruit) {
        try {
            if (c) {
                return;
            }
            c = true;
            long jA = kiwifruit.a(context, "502");
            int iMyUid = Process.myUid();
            if (jA == 0 || iMyUid == 0 || iMyUid == jA) {
                return;
            }
            kiwifruit.a(context, PointType.ANTI_SPAM, "", true);
            kiwifruit.b(context, 0L);
            HashMap map = new HashMap();
            map.put("901", "");
            Kiwifruit.a(context, map);
            new File(a(context)).delete();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static String a(Context context) {
        File dir = context.getDir(a, 0);
        if (dir == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(dir.getAbsolutePath());
        String str = File.separator;
        sb.append(str);
        sb.append("1");
        File file = new File(sb.toString());
        if (!file.exists() && !file.mkdirs()) {
            return "";
        }
        return file.getAbsolutePath() + str + b;
    }
}
