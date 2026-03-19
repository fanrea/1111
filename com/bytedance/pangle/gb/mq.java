package com.bytedance.pangle.gb;

import android.system.Os;
import android.system.OsConstants;
import java.io.FileDescriptor;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class mq implements mk {
    private static final long d = Os.sysconf(OsConstants._SC_PAGESIZE);
    private final long b;
    private final long c;
    private final FileDescriptor hc;

    mq(FileDescriptor fileDescriptor, long j, long j2) {
        this.hc = fileDescriptor;
        this.b = j;
        this.c = j2;
    }

    @Override // com.bytedance.pangle.gb.mk
    public long d() {
        return this.c;
    }

    /* JADX WARN: Removed duplicated region for block: B:69:0x010a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x013b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00b9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0051 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:84:? A[RETURN, SYNTHETIC] */
    @Override // com.bytedance.pangle.gb.mk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void d(com.bytedance.pangle.gb.tc r19, long r20, int r22) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 319
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.gb.mq.d(com.bytedance.pangle.gb.tc, long, int):void");
    }
}
