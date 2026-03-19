package com.kwad.tachikoma.j;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.kwad.components.offline.api.OfflineHostProvider;
import com.kwad.components.offline.api.core.api.IImageLoader;
import com.kwad.tachikoma.e;
import com.tk.component.imageview.a.c;
import com.tk.component.imageview.model.TKCDNUrl;
import com.tk.core.o.z;
import java.io.File;
import java.io.InputStream;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class a implements c {
    private static String e(List<TKCDNUrl> list) {
        if (list != null && !list.isEmpty()) {
            for (TKCDNUrl tKCDNUrl : list) {
                if (tKCDNUrl != null) {
                    return tKCDNUrl.getUrl();
                }
            }
        }
        return "";
    }

    @Override // com.tk.component.imageview.a.c
    public final void a(ImageView imageView, List<TKCDNUrl> list, String str, String str2, int i, int i2, int i3) {
        if (e.isDebug()) {
            e.log().d("TK-KsAdWebImageHandler", "setCDNUrls ");
        }
        if (list == null || list.isEmpty()) {
            a(imageView, str2, i2, i3, i, (c.a) null);
        } else {
            a(imageView, e(list), null, str2, i, i2, i3, null);
        }
    }

    @Override // com.tk.component.imageview.a.c
    public final void a(ImageView imageView, String str, String str2, String str3, int i, int i2, int i3, c.a aVar) {
        if (e.isDebug()) {
            e.log().d("TK-KsAdWebImageHandler", "load ");
        }
        if (!TextUtils.isEmpty(str2)) {
            a(imageView, str2, i2, i3, i, aVar);
        }
        a(imageView, str, str3, i2, i3, i, aVar);
    }

    @Override // com.tk.component.imageview.a.c
    public final void a(String str, ImageView imageView, int i, c.a aVar) {
        if (e.isDebug()) {
            e.log().d("TK-KsAdWebImageHandler", "load url: " + str);
        }
        a(imageView, str, -1, -1, i, aVar);
    }

    @Override // com.tk.component.imageview.a.c
    public final void a(ImageView imageView, String str, Drawable drawable, int i, c.a aVar) {
        if (e.isDebug()) {
            e.log().d("TK-KsAdWebImageHandler", "load url: " + str);
        }
        a(imageView, str, i, drawable, aVar);
    }

    @Override // com.tk.component.imageview.a.c
    public final void a(ImageView imageView, List<TKCDNUrl> list, int i, int i2, int i3, c.a aVar) {
        String strE = e(list);
        if (e.isDebug()) {
            e.log().d("TK-KsAdWebImageHandler", "load url: " + strE);
        }
        a(imageView, strE, i, i2, i3, aVar);
    }

    @Override // com.tk.component.imageview.a.c
    public final void a(ImageView imageView, List<TKCDNUrl> list, int i, int i2, Drawable drawable, int i3, c.a aVar) {
        String strE = e(list);
        if (e.isDebug()) {
            e.log().d("TK-KsAdWebImageHandler", "load url: " + strE);
        }
        a(imageView, strE, i3, drawable, (c.a) null);
    }

    private void a(final ImageView imageView, String str, final String str2, final int i, final int i2, final int i3, c.a aVar) {
        if (!TextUtils.isEmpty(str)) {
            if (!TextUtils.isEmpty(str2)) {
                aVar = new c.a() { // from class: com.kwad.tachikoma.j.a.1
                    @Override // com.tk.component.imageview.a.c.a
                    public final void a(BitmapDrawable bitmapDrawable) {
                        if (bitmapDrawable == null) {
                            a.this.a(imageView, str2, i, i2, i3, (c.a) null);
                        }
                    }
                };
            }
            a(imageView, str, i, i2, i3, aVar);
            return;
        }
        a(imageView, str2, i, i2, i3, aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImageView imageView, String str, int i, int i2, int i3, c.a aVar) {
        a(imageView, str, i3, (Drawable) null, aVar);
    }

    private void a(ImageView imageView, String str, int i, Drawable drawable, final c.a aVar) {
        Uri uriBuild;
        if (e.isDebug()) {
            e.log().d("TK-KsAdWebImageHandler", "showImage url: " + str);
        }
        if (TextUtils.isEmpty(str)) {
            if (e.isDebug()) {
                e.log().d("TK-KsAdWebImageHandler", "onLoadingFailed uri is null: " + str);
            }
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
        if (uriBuild == null) {
            if (e.isDebug()) {
                e.log().d("TK-KsAdWebImageHandler", "onLoadingFailed realUri is null: " + uriBuild);
            }
            if (aVar != null) {
                aVar.a(null);
                return;
            }
            return;
        }
        OfflineHostProvider.getApi().imageLoader().loadImage(imageView, uriBuild.toString(), new IImageLoader.DisplayImageOptionsCompat.Builder().bitmapConfig(Bitmap.Config.ARGB_8888).cacheOnDisk(true).cacheInMemory(true).showImageOnFail(drawable).showImageForEmptyUri(drawable).showImageOnLoading(drawable).setBlurRadius(i).build(), new IImageLoader.ImageLoadingListener() { // from class: com.kwad.tachikoma.j.a.2
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
                    e.log().e("TK-KsAdWebImageHandler", "onLoadingFailed failType: " + str3 + " imageUri: " + str2, th);
                }
                c.a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.a(null);
                }
            }

            @Override // com.kwad.components.offline.api.core.api.IImageLoader.ImageLoadingListener
            public final void onLoadingComplete(String str2, View view, Bitmap bitmap) {
                if (e.isDebug()) {
                    e.log().v("TK-KsAdWebImageHandler", "onLoadingComplete imageUri: " + str2);
                }
                c.a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.a(new BitmapDrawable(view.getResources(), bitmap));
                }
            }

            @Override // com.kwad.components.offline.api.core.api.IImageLoader.ImageLoadingListener
            public final void onLoadingCancelled(String str2, View view) {
                if (e.isDebug()) {
                    e.log().d("TK-KsAdWebImageHandler", "onLoadingCancelled imageUri: " + str2);
                }
                c.a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.a(null);
                }
            }
        });
    }
}
