package com.qq.e.comm.plugin;

import com.qq.e.comm.plugin.aw;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class cw {
    public static aw a(String str, boolean z) {
        int iIndexOf;
        if (z && (iIndexOf = str.indexOf("?")) > 0 && iIndexOf < str.length() - 1) {
            String strSubstring = str.substring(0, iIndexOf);
            String strSubstring2 = str.substring(iIndexOf + 1);
            cu cuVar = new cu(strSubstring, aw.a.POST);
            cuVar.a(strSubstring2);
            return cuVar;
        }
        return new cu(str, aw.a.GET);
    }
}
