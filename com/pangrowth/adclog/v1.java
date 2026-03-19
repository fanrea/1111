package com.pangrowth.adclog;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class v1 extends r1 implements o2 {
    public File b = null;

    @Override // com.pangrowth.adclog.o2
    public List<String> a() {
        ArrayList arrayList = new ArrayList(1);
        File file = this.b;
        if (file != null) {
            arrayList.add(file.getAbsolutePath());
        }
        return arrayList;
    }

    @Override // com.pangrowth.adclog.r1
    public String b() {
        return "new_diskdir";
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0114 A[Catch: IOException -> 0x0110, TRY_LEAVE, TryCatch #4 {IOException -> 0x0110, blocks: (B:55:0x010c, B:59:0x0114), top: B:66:0x010c }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x010c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.pangrowth.adclog.r1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean b(com.pangrowth.adclog.p1 r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 284
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pangrowth.adclog.v1.b(com.pangrowth.adclog.p1):boolean");
    }
}
