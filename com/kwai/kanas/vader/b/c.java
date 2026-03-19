package com.kwai.kanas.vader.b;

import android.content.Context;
import com.kwai.kanas.vader.Channel;
import com.kwai.kanas.vader.f.f;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class c implements com.kwai.kanas.vader.d.a.a.a<b> {
    private final com.kwai.kanas.vader.d.a.a.c<Context> a;
    private final com.kwai.kanas.vader.d.a.a.c<Channel> b;
    private final com.kwai.kanas.vader.d.a.a.c<com.kwai.kanas.vader.b> c;
    private final com.kwai.kanas.vader.d.a.a.c<f> d;
    private final com.kwai.kanas.vader.d.a.a.c<com.kwai.kanas.vader.persistent.e> e;
    private final com.kwai.kanas.vader.d.a.a.c<com.kwai.kanas.vader.e.e> f;
    private final com.kwai.kanas.vader.d.a.a.c<Long> g;

    public c(com.kwai.kanas.vader.d.a.a.c<Context> cVar, com.kwai.kanas.vader.d.a.a.c<Channel> cVar2, com.kwai.kanas.vader.d.a.a.c<com.kwai.kanas.vader.b> cVar3, com.kwai.kanas.vader.d.a.a.c<f> cVar4, com.kwai.kanas.vader.d.a.a.c<com.kwai.kanas.vader.persistent.e> cVar5, com.kwai.kanas.vader.d.a.a.c<com.kwai.kanas.vader.e.e> cVar6, com.kwai.kanas.vader.d.a.a.c<Long> cVar7) {
        this.a = cVar;
        this.b = cVar2;
        this.c = cVar3;
        this.d = cVar4;
        this.e = cVar5;
        this.f = cVar6;
        this.g = cVar7;
    }

    @Override // com.kwai.kanas.vader.d.a.a.c
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final b b() {
        return new b(this.a.b(), this.b.b(), this.c.b(), this.d.b(), this.e.b(), this.f.b(), this.g.b().longValue());
    }

    public static c a(com.kwai.kanas.vader.d.a.a.c<Context> cVar, com.kwai.kanas.vader.d.a.a.c<Channel> cVar2, com.kwai.kanas.vader.d.a.a.c<com.kwai.kanas.vader.b> cVar3, com.kwai.kanas.vader.d.a.a.c<f> cVar4, com.kwai.kanas.vader.d.a.a.c<com.kwai.kanas.vader.persistent.e> cVar5, com.kwai.kanas.vader.d.a.a.c<com.kwai.kanas.vader.e.e> cVar6, com.kwai.kanas.vader.d.a.a.c<Long> cVar7) {
        return new c(cVar, cVar2, cVar3, cVar4, cVar5, cVar6, cVar7);
    }

    public static b a(Context context, Channel channel, com.kwai.kanas.vader.b bVar, f fVar, com.kwai.kanas.vader.persistent.e eVar, com.kwai.kanas.vader.e.e eVar2, long j) {
        return new b(context, channel, bVar, fVar, eVar, eVar2, j);
    }
}
