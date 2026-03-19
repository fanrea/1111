package com.sigmob.sdk.downloader.core;

import java.io.File;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public abstract class a {
    public static final String f = "";
    public static final File g = new File("");

    public boolean a(a another) {
        if (!i().equals(another.i()) || i().equals("") || l().equals(g)) {
            return false;
        }
        if (k().equals(another.k())) {
            return true;
        }
        if (!l().equals(another.l())) {
            return false;
        }
        String strD = d();
        String strD2 = another.d();
        return (strD2 == null || strD == null || !strD2.equals(strD)) ? false : true;
    }

    public abstract int c();

    public abstract String d();

    public abstract String i();

    protected abstract File k();

    public abstract File l();
}
