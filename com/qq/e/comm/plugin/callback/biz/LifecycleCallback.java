package com.qq.e.comm.plugin.callback.biz;

import com.qq.e.comm.plugin.ls;
import com.qq.e.comm.plugin.nj;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public interface LifecycleCallback extends nj {

    /* compiled from: A */
    public enum a {
        AFTER_CREATED,
        RESUMED,
        PAUSED,
        STOPPED,
        DESTROYED
    }

    ls<a> I();
}
