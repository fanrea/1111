package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.os.Process;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public final class d1 {
    public static boolean d(String... strArr) {
        try {
            Context contextHc = pblv.d().hc();
            for (String str : strArr) {
                if (contextHc.checkPermission(str, Process.myPid(), Process.myUid()) != 0) {
                    return false;
                }
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }
}
