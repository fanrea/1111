package lkxssdk.l;

import android.content.Intent;
import lkxssdk.i.e;
import lkxssdk.l.g;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public class i extends lkxssdk.h.b {
    public final /* synthetic */ lkxssdk.h.c a;
    public final /* synthetic */ g b;

    public i(g gVar, lkxssdk.h.c cVar) {
        this.b = gVar;
        this.a = cVar;
    }

    @Override // lkxssdk.h.b
    public void b() {
        this.a.a();
        g.b bVar = this.b.b;
        if (bVar != null) {
            ((e.a) bVar).a(2);
        }
    }

    @Override // lkxssdk.h.b
    public void c() {
        this.a.a();
        this.b.c = true;
        this.b.getClass();
        lkxssdk.a.a.d().startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS").addFlags(268435456));
    }
}
