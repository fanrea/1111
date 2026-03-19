package com.tk.core.o;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class z {
    public static int b(String str, String str2, String str3) {
        try {
            return s.getContext().getResources().getIdentifier(str, str2, s.getContext().getPackageName());
        } catch (Exception e) {
            throw new RuntimeException("Error getResourceId by TKContextUtil.getContext()", e);
        }
    }
}
