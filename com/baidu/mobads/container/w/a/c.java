package com.baidu.mobads.container.w.a;

import android.os.FileObserver;
import com.baidu.mobstat.forbes.Config;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class c extends FileObserver {
    final /* synthetic */ a a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    c(a aVar, String str, int i) {
        super(str, i);
        this.a = aVar;
    }

    @Override // android.os.FileObserver
    public void onEvent(int i, String str) {
        if (str != null && ("/data/anr/" + str).contains(Config.TRACE_PART)) {
            this.a.h();
        }
    }
}
