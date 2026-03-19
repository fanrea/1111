package com.pangrowth.adclog;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class a2 extends r1 implements o2 {
    public k1 b;
    public File c = null;
    public ConcurrentLinkedQueue<b> d = new ConcurrentLinkedQueue<>();
    public b e = new b(this, "error_data", "error_ids");

    public class a implements a1 {
        public a(a2 a2Var) {
        }
    }

    public class b {
        public String a;
        public String b;

        public b(a2 a2Var, String str, String str2) {
            this.a = str;
            this.b = str2;
        }
    }

    @Override // com.pangrowth.adclog.o2
    public List<String> a() {
        ArrayList arrayList = new ArrayList();
        File file = this.c;
        if (file != null) {
            arrayList.add(file.getAbsolutePath());
        }
        return arrayList;
    }

    @Override // com.pangrowth.adclog.r1
    public String b() {
        return "monitor_log";
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x017f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0131  */
    @Override // com.pangrowth.adclog.r1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean b(com.pangrowth.adclog.p1 r25) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 436
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pangrowth.adclog.a2.b(com.pangrowth.adclog.p1):boolean");
    }
}
