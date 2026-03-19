package com.kwai.kanas.vader.persistent;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class f implements com.kwai.kanas.vader.d.a.a.a<e> {
    private final com.kwai.kanas.vader.d.a.a.c<com.kwai.kanas.vader.b> a;
    private final com.kwai.kanas.vader.d.a.a.c<LogRecordDatabase> b;

    public f(com.kwai.kanas.vader.d.a.a.c<com.kwai.kanas.vader.b> cVar, com.kwai.kanas.vader.d.a.a.c<LogRecordDatabase> cVar2) {
        this.a = cVar;
        this.b = cVar2;
    }

    public static f a(com.kwai.kanas.vader.d.a.a.c<com.kwai.kanas.vader.b> cVar, com.kwai.kanas.vader.d.a.a.c<LogRecordDatabase> cVar2) {
        return new f(cVar, cVar2);
    }

    public static e a(com.kwai.kanas.vader.b bVar, LogRecordDatabase logRecordDatabase) {
        return new e(bVar, logRecordDatabase);
    }

    @Override // com.kwai.kanas.vader.d.a.a.c
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final e b() {
        return new e(this.a.b(), this.b.b());
    }
}
