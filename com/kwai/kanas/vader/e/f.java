package com.kwai.kanas.vader.e;

import android.content.Context;
import com.kwai.kanas.vader.persistent.LogRecordDatabase;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class f implements com.kwai.kanas.vader.d.a.a.a<e> {
    private final com.kwai.kanas.vader.d.a.a.c<Context> a;
    private final com.kwai.kanas.vader.d.a.a.c<LogRecordDatabase> b;
    private final com.kwai.kanas.vader.d.a.a.c<com.kwai.kanas.vader.b> c;

    public f(com.kwai.kanas.vader.d.a.a.c<Context> cVar, com.kwai.kanas.vader.d.a.a.c<LogRecordDatabase> cVar2, com.kwai.kanas.vader.d.a.a.c<com.kwai.kanas.vader.b> cVar3) {
        this.a = cVar;
        this.b = cVar2;
        this.c = cVar3;
    }

    public static f a(com.kwai.kanas.vader.d.a.a.c<Context> cVar, com.kwai.kanas.vader.d.a.a.c<LogRecordDatabase> cVar2, com.kwai.kanas.vader.d.a.a.c<com.kwai.kanas.vader.b> cVar3) {
        return new f(cVar, cVar2, cVar3);
    }

    public static e a(Context context, LogRecordDatabase logRecordDatabase, com.kwai.kanas.vader.b bVar) {
        return new e(context, logRecordDatabase, bVar);
    }

    @Override // com.kwai.kanas.vader.d.a.a.c
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final e b() {
        return new e(this.a.b(), this.b.b(), this.c.b());
    }
}
