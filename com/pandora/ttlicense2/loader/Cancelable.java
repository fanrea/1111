package com.pandora.ttlicense2.loader;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public interface Cancelable {
    void cancel(boolean notify, boolean interrupt, String reason);

    boolean isCanceled();
}
