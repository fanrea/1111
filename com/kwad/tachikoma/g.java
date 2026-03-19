package com.kwad.tachikoma;

import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import com.kwad.components.offline.api.OfflineHostProvider;
import com.kwad.components.offline.api.core.api.IImageLoader;
import com.tk.core.a.l;
import com.tk.core.o.z;
import java.io.File;
import java.io.InputStream;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class g implements l {
    @Override // com.tk.core.a.l
    public final void a(String str, int i, int i2, com.tk.core.a.a aVar) {
        a(str, aVar);
    }

    private void a(String str, final com.tk.core.a.a aVar) {
        Uri uriBuild;
        if (TextUtils.isEmpty(str)) {
            if (aVar != null) {
                aVar.a(null);
                return;
            }
            return;
        }
        if (str.startsWith(com.alipay.sdk.m.l.a.r)) {
            uriBuild = Uri.parse(str);
        } else {
            int iB = z.b(str, "drawable", null);
            if (iB == 0) {
                uriBuild = Uri.fromFile(new File(str));
            } else {
                uriBuild = new Uri.Builder().scheme("res").path(String.valueOf(iB)).build();
            }
        }
        if (uriBuild != null) {
            OfflineHostProvider.getApi().imageLoader().loadImage(uriBuild.toString(), new IImageLoader.DisplayImageOptionsCompat.Builder().bitmapConfig(Bitmap.Config.ARGB_8888).cacheOnDisk(true).cacheInMemory(true).build(), new IImageLoader.ImageLoadingListener() { // from class: com.kwad.tachikoma.g.1
                @Override // com.kwad.components.offline.api.core.api.IImageLoader.ImageLoadingListener
                public final boolean onDecode(String str2, InputStream inputStream, Bitmap bitmap) {
                    return false;
                }

                @Override // com.kwad.components.offline.api.core.api.IImageLoader.ImageLoadingListener
                public final void onLoadingStarted(String str2, View view) {
                }

                @Override // com.kwad.components.offline.api.core.api.IImageLoader.ImageLoadingListener
                public final void onLoadingFailed(String str2, View view, String str3, Throwable th) {
                    if (e.isDebug()) {
                        e.log().e("TKImageResourceImpl", "onLoadingFailed failType: " + str3 + " imageUri: " + str2, th);
                    }
                    com.tk.core.a.a aVar2 = aVar;
                    if (aVar2 != null) {
                        aVar2.a(null);
                    }
                }

                @Override // com.kwad.components.offline.api.core.api.IImageLoader.ImageLoadingListener
                public final void onLoadingComplete(String str2, View view, Bitmap bitmap) {
                    if (e.isDebug()) {
                        e.log().v("TKImageResourceImpl", "onLoadingComplete imageUri: " + str2);
                    }
                    com.tk.core.a.a aVar2 = aVar;
                    if (aVar2 != null) {
                        aVar2.a(bitmap);
                    }
                }

                @Override // com.kwad.components.offline.api.core.api.IImageLoader.ImageLoadingListener
                public final void onLoadingCancelled(String str2, View view) {
                    if (e.isDebug()) {
                        e.log().d("TKImageResourceImpl", "onLoadingCancelled imageUri: " + str2);
                    }
                    com.tk.core.a.a aVar2 = aVar;
                    if (aVar2 != null) {
                        aVar2.a(null);
                    }
                }
            });
        } else if (aVar != null) {
            aVar.a(null);
        }
    }
}
