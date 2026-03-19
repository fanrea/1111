package com.tencent.turingfd.sdk.ams.au;

import android.os.Process;
import com.tencent.turingfd.sdk.ams.au.Vulpecula;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class Flat {
    public static String a() throws NumberFormatException {
        StringBuilder sb = new StringBuilder();
        int iMyPid = Process.myPid();
        Vulpecula.Cdo cdoB = Vulpecula.b(iMyPid);
        if (cdoB == null) {
            return sb.toString();
        }
        int i = cdoB.e;
        if (i == 0) {
            return sb.toString();
        }
        if (i == iMyPid) {
            return sb.toString();
        }
        sb.append(iMyPid);
        sb.append(",");
        sb.append(cdoB.b);
        sb.append(",");
        sb.append(cdoB.c);
        sb.append(",");
        sb.append(i);
        sb.append(",");
        Vulpecula.Cdo cdoB2 = Vulpecula.b(i);
        if (cdoB2 != null) {
            sb.append(cdoB2.d);
            sb.append(",");
            sb.append(cdoB2.c);
            sb.append(",");
            sb.append(cdoB2.b);
        }
        return sb.toString();
    }
}
