package lkxssdk.e;

import android.graphics.Color;
import android.widget.ImageView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public class d extends lkxssdk.b0.b<a, lkxssdk.b0.c> {
    public d(int i) {
        super(i);
    }

    @Override // lkxssdk.b0.b
    public void a(lkxssdk.b0.c cVar, a aVar, int i) {
        a aVar2 = aVar;
        lkxssdk.l0.e eVarA = lkxssdk.l0.e.a();
        cVar.a(eVarA.b.getResources().getIdentifier("name", "id", eVarA.c), aVar2.b);
        lkxssdk.l0.e eVarA2 = lkxssdk.l0.e.a();
        cVar.a(eVarA2.b.getResources().getIdentifier("count", "id", eVarA2.c), String.valueOf(i.b().h ? aVar2.c.size() - 1 : aVar2.c.size()));
        lkxssdk.l0.e eVarA3 = lkxssdk.l0.e.a();
        ImageView imageView = (ImageView) cVar.a(eVarA3.b.getResources().getIdentifier("image", "id", eVarA3.c));
        if (!i.b().h ? aVar2.c.size() != 0 : aVar2.c.size() > 1) {
            imageView.setBackgroundColor(Color.parseColor("#999999"));
        } else {
            String str = (i.b().h ? aVar2.c.get(1) : aVar2.c.get(0)).b;
            if (i.b().l) {
                lkxssdk.a.a.a(str, imageView, 100, 0, new b(this, imageView));
            } else {
                lkxssdk.a.a.a(str, imageView, 100, new c(this, imageView));
            }
        }
        if (aVar2.d <= 0) {
            lkxssdk.l0.e eVarA4 = lkxssdk.l0.e.a();
            cVar.a(eVarA4.b.getResources().getIdentifier("selectedCount", "id", eVarA4.c)).setVisibility(4);
        } else {
            lkxssdk.l0.e eVarA5 = lkxssdk.l0.e.a();
            cVar.a(eVarA5.b.getResources().getIdentifier("selectedCount", "id", eVarA5.c)).setVisibility(0);
            lkxssdk.l0.e eVarA6 = lkxssdk.l0.e.a();
            cVar.a(eVarA6.b.getResources().getIdentifier("selectedCount", "id", eVarA6.c), String.valueOf(aVar2.d));
        }
    }
}
