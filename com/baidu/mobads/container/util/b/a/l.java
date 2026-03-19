package com.baidu.mobads.container.util.b.a;

import android.graphics.Bitmap;
import android.util.LruCache;
import com.baidu.mobads.container.util.b.a;
import com.baidu.mobads.container.util.b.a.k;
import com.baidu.mobads.container.util.d.d;
import java.io.File;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class l implements k {
    private final LruCache<String, com.baidu.mobads.container.util.b.f<?>> a;

    public l(LruCache<String, com.baidu.mobads.container.util.b.f<?>> lruCache) {
        this.a = lruCache;
    }

    @Override // com.baidu.mobads.container.util.b.a.k
    public com.baidu.mobads.container.util.b.f<?> a(k.b bVar, k.a aVar) {
        b bVarA = bVar.a();
        com.baidu.mobads.container.util.b.f<?> fVar = this.a.get(bVarA.d);
        if (fVar != null) {
            Object objB = fVar.b();
            if ((objB instanceof Bitmap) && ((Bitmap) objB).isRecycled()) {
                this.a.remove(bVarA.d);
            } else if (objB != null) {
                return fVar;
            }
        }
        return a(bVarA, bVar.a(bVarA, new m(this, aVar, bVarA)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.mobads.container.util.b.f<?> a(b bVar, com.baidu.mobads.container.util.b.f<?> fVar) {
        com.baidu.mobads.container.util.b.f<?> fVar2;
        Bitmap bitmapA;
        if (bVar.c && fVar != null && fVar.b() != null) {
            String str = bVar.d;
            Object objB = fVar.b();
            if (d.e.PICTURE.equals(bVar.b) && ((fVar2 = this.a.get(str)) == null || (fVar2.b() instanceof File))) {
                a.C0134a c0134a = new a.C0134a();
                if (objB instanceof File) {
                    bitmapA = c0134a.b((File) objB);
                } else if (!(objB instanceof byte[]) && (objB instanceof Bitmap)) {
                    bitmapA = c0134a.a((a.C0134a) objB);
                } else {
                    bitmapA = null;
                }
                if (bitmapA != null) {
                    objB = bitmapA;
                }
            }
            if (objB instanceof Bitmap) {
                LruCache<String, com.baidu.mobads.container.util.b.f<?>> lruCache = this.a;
                com.baidu.mobads.container.util.b.f<?> fVar3 = new com.baidu.mobads.container.util.b.f<>((Bitmap) objB);
                lruCache.put(str, fVar3);
                return fVar3;
            }
            if (objB instanceof byte[]) {
                LruCache<String, com.baidu.mobads.container.util.b.f<?>> lruCache2 = this.a;
                com.baidu.mobads.container.util.b.f<?> fVar4 = new com.baidu.mobads.container.util.b.f<>((byte[]) objB);
                lruCache2.put(str, fVar4);
                return fVar4;
            }
            if (!(objB instanceof File)) {
                return null;
            }
            LruCache<String, com.baidu.mobads.container.util.b.f<?>> lruCache3 = this.a;
            com.baidu.mobads.container.util.b.f<?> fVar5 = new com.baidu.mobads.container.util.b.f<>((File) objB);
            lruCache3.put(str, fVar5);
            return fVar5;
        }
        return fVar;
    }
}
