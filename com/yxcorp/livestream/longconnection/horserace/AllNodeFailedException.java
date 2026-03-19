package com.yxcorp.livestream.longconnection.horserace;

import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class AllNodeFailedException extends Exception {
    public final List<Throwable> mExceptions = new ArrayList();

    public AllNodeFailedException(List<Throwable> list) {
        this.mExceptions.addAll(list);
    }
}
