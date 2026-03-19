package com.bytedance.pangle.an;

import android.os.Build;
import com.bytedance.pangle.an.an;
import com.bytedance.pangle.log.ZeusLogger;
import java.io.File;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class c implements an.d {
    @Override // com.bytedance.pangle.an.an.d
    public boolean d(String str, int i) {
        String strHc = com.bytedance.pangle.u.b.hc(str, i);
        ZeusLogger.d(ZeusLogger.TAG_INSTALL, "full DexOpt:".concat(String.valueOf(strHc)));
        String strB = com.bytedance.pangle.u.b.b(str, i);
        String str2 = strB + File.separator + "compFully" + hc.hc(strHc);
        String str3 = strB + File.separator + hc.d(strHc);
        if (!hc(strHc, str2)) {
            return false;
        }
        d(str2, str3);
        boolean zD = hc.d(str3);
        ZeusLogger.i(ZeusLogger.TAG_INSTALL, "full DexOpt result:".concat(String.valueOf(zD)));
        return zD;
    }

    private void d(String str, String str2) {
        File file = new File(str);
        if (file.exists()) {
            file.renameTo(new File(str2));
        }
        String str3 = Build.VERSION.SDK_INT >= 26 ? ".odex" : ".dex";
        File file2 = new File(str.replace(str3, ".vdex"));
        if (file2.exists()) {
            file2.renameTo(new File(str2.replace(str3, ".vdex")));
        }
    }

    private static boolean hc(String str, String str2) {
        try {
            return d.d(hc.d(str, str2, hc.hc));
        } catch (Exception unused) {
            return false;
        }
    }
}
