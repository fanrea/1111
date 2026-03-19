package com.kuaishou.tk.api.app;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public interface ITKCache {
    boolean exist(String str);

    Object get(String str);

    void remove(String str);

    void set(String str, Object obj);
}
