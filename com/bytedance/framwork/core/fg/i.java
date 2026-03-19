package com.bytedance.framwork.core.fg;

import android.content.Context;
import com.baidu.mobstat.forbes.Config;

/* compiled from: MonitorHelper.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class i {
    private static String a;

    public static String a(Context context) {
        if (a == null) {
            String strReplace = com.bytedance.framwork.core.de.ha.i.a(context).replace(context.getPackageName(), "p").replace(":", Config.replace);
            a = strReplace;
            a = strReplace.replace(".", Config.replace);
        }
        return a;
    }
}
