package com.baidu.mobads.container.util.b.a;

import android.graphics.Bitmap;
import com.baidu.mobads.container.util.b.a.k;
import com.baidu.mobads.container.util.bq;
import java.io.File;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class d implements k {
    private final com.baidu.mobads.container.util.b.g a;

    public d(com.baidu.mobads.container.util.b.g gVar) {
        this.a = gVar;
    }

    @Override // com.baidu.mobads.container.util.b.a.k
    public com.baidu.mobads.container.util.b.f<?> a(k.b bVar, k.a aVar) {
        b bVarA = bVar.a();
        String str = bVarA.d;
        com.baidu.mobads.container.util.b.f<File> fVarA = this.a.a(str);
        if (fVarA != null) {
            return fVarA;
        }
        if (!this.a.a) {
            File file = new File(this.a.a() + str);
            if (file.exists()) {
                return new com.baidu.mobads.container.util.b.f<>(file);
            }
        }
        return bVar.a(bVarA, new e(this, aVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, long j, Object obj, k.a aVar) {
        try {
            if (!(obj instanceof Bitmap) && j > this.a.e()) {
                aVar.a(str, str2, com.baidu.mobads.container.util.d.c.b);
            }
            this.a.a(new f(this, str, aVar, str2));
            this.a.a(new com.baidu.mobads.container.util.b.f<>(new File(this.a.a() + str)), obj, false);
        } catch (Throwable th) {
            bq.a().a("Failed to cache resource.", th);
            aVar.a(str, str2, com.baidu.mobads.container.util.d.c.i);
        }
    }
}
