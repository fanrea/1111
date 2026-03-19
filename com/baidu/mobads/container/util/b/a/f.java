package com.baidu.mobads.container.util.b.a;

import com.baidu.mobads.container.util.b.a.k;
import com.baidu.mobads.container.util.b.g;
import java.io.File;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class f implements g.a {
    final /* synthetic */ String a;
    final /* synthetic */ k.a b;
    final /* synthetic */ String c;
    final /* synthetic */ d d;

    f(d dVar, String str, k.a aVar, String str2) {
        this.d = dVar;
        this.a = str;
        this.b = aVar;
        this.c = str2;
    }

    @Override // com.baidu.mobads.container.util.b.g.a
    public void a(String str, com.baidu.mobads.container.util.b.f<File> fVar) {
        if (this.a.equals(str)) {
            this.b.a(str, this.c, fVar);
            this.d.a.b(this);
        }
    }

    @Override // com.baidu.mobads.container.util.b.g.a
    public void a(String str, com.baidu.mobads.container.util.b.f<File> fVar, com.baidu.mobads.container.util.d.c cVar) {
        if (this.a.equals(str)) {
            this.b.a(str, this.c, cVar);
            this.d.a.b(this);
        }
    }

    @Override // com.baidu.mobads.container.util.b.g.a
    public void b(String str, com.baidu.mobads.container.util.b.f<File> fVar) {
    }
}
