package com.kwad.framework.filedownloader.a;

import com.baidu.mobstat.forbes.Config;
import com.kwad.framework.filedownloader.f.c;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a implements c.a {
    @Override // com.kwad.framework.filedownloader.f.c.a
    public final int at(long j) {
        if (j < 1048576) {
            return 1;
        }
        if (j < 5242880) {
            return 2;
        }
        if (j < Config.RAVEN_LOG_LIMIT) {
            return 3;
        }
        return j < 104857600 ? 4 : 5;
    }
}
