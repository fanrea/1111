package com.pangrowth.adclog;

import java.util.ArrayList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class j0 extends UnsatisfiedLinkError {
    public static final ArrayList<j0> a = new ArrayList<>();

    public j0(String str) {
        super(str);
        ArrayList<j0> arrayList = a;
        synchronized (arrayList) {
            arrayList.add(this);
        }
    }

    public j0(String str, Throwable th) {
        super(str);
        initCause(th);
        ArrayList<j0> arrayList = a;
        synchronized (arrayList) {
            arrayList.add(this);
        }
    }
}
