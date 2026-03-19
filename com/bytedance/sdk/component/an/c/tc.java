package com.bytedance.sdk.component.an.c;

import android.graphics.Bitmap;
import com.bytedance.sdk.component.an.yo;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class tc extends d {
    @Override // com.bytedance.sdk.component.an.c.tt
    public String d() {
        return "memory_cache";
    }

    @Override // com.bytedance.sdk.component.an.c.tt
    public void d(com.bytedance.sdk.component.an.b.b bVar) {
        Bitmap bitmapHc;
        int iUo = bVar.uo();
        if (iUo != 2 && iUo != 1) {
            bitmapHc = null;
        } else if (bVar.de() || bVar.sy().an()) {
            bitmapHc = hc(bVar);
        } else {
            bitmapHc = b(bVar);
        }
        if (bitmapHc == null) {
            if (bVar.sy().h()) {
                bVar.d(new mq());
                return;
            } else {
                bVar.d(new an());
                return;
            }
        }
        bVar.d(new uo(bitmapHc, null, null, false));
    }

    private Bitmap hc(com.bytedance.sdk.component.an.b.b bVar) {
        Collection<yo> collectionD = bVar.jh().d();
        Bitmap bitmapD = null;
        if (collectionD == null) {
            return null;
        }
        Iterator<yo> it = collectionD.iterator();
        while (it.hasNext() && (bitmapD = it.next().d((yo) bVar.h())) == null) {
        }
        return bitmapD;
    }

    private Bitmap b(com.bytedance.sdk.component.an.b.b bVar) {
        return bVar.jh().d(bVar.sy()).d((yo) bVar.h());
    }
}
