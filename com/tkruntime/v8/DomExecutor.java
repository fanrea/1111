package com.tkruntime.v8;

import com.tkruntime.v8.V8;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public interface DomExecutor {
    void addCmdRunner(V8.CommandRunner commandRunner);

    void attachToRoot();

    void detachToRoot();

    boolean hasRemainRunner();

    boolean isAttachedToRoot();
}
