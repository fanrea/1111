package com.qq.e.comm.plugin;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.ImageView;
import com.qq.e.comm.plugin.pk;
import java.io.File;
import org.json.JSONException;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class l8 implements pk {
    l8() {
    }

    @Override // com.qq.e.comm.plugin.pk
    public void a(String str, pk.a aVar) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (str.startsWith("http://") || str.startsWith("https://")) {
            mm.a().b(str, new a(aVar));
        }
    }

    private void b(String str, pk.a aVar) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!str.startsWith("http://") && !str.startsWith("https://")) {
            Bitmap bitmapA = gw.a(str);
            if (bitmapA != null) {
                aVar.a(null, bitmapA);
                return;
            }
            return;
        }
        mm.a().a(str, (ImageView) null, new a(aVar));
    }

    /* compiled from: A */
    private static class a implements nm {
        private final pk.a a;

        a(pk.a aVar) {
            this.a = aVar;
        }

        @Override // com.qq.e.comm.plugin.nm
        public void a(String str, ImageView imageView, ko koVar) {
            Object objB;
            if (this.a == null) {
                return;
            }
            int iF = koVar.f();
            if (iF == 1) {
                objB = koVar.b();
            } else if (iF == 2) {
                objB = koVar.e();
            } else if (iF != 3) {
                objB = koVar.d();
            } else {
                objB = koVar.c();
            }
            if (objB == null) {
                return;
            }
            this.a.a(koVar.d(), objB);
        }

        @Override // com.qq.e.comm.plugin.nm
        public void a(String str, int i, Exception exc) {
            pk.a aVar = this.a;
            if (aVar == null) {
                return;
            }
            aVar.a(str, i, exc);
        }
    }

    @Override // com.qq.e.comm.plugin.pk
    public void a(Object obj, pk.a aVar) throws JSONException {
        if (obj instanceof String) {
            b((String) obj, aVar);
        } else if (obj instanceof File) {
            mm.a().a((File) obj, (ImageView) null, new a(aVar));
        } else {
            aVar.a(null, obj);
        }
    }
}
