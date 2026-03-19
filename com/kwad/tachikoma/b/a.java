package com.kwad.tachikoma.b;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import com.kuaishou.tk.export.NativeModuleInitParams;
import com.kwad.components.offline.api.OfflineHostProvider;
import com.kwad.components.offline.api.core.api.IImageLoader;
import com.kwad.tachikoma.t.g;
import com.tk.core.component.TKBaseNativeModule;
import com.tkruntime.v8.V8Function;
import java.io.InputStream;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class a extends TKBaseNativeModule {
    private String BD;
    private g BE;
    private Bitmap BF;

    public a(NativeModuleInitParams nativeModuleInitParams) {
        super(nativeModuleInitParams);
    }

    public final void a(String str, V8Function v8Function) {
        this.BE = new g(v8Function, pO());
        if (TextUtils.isEmpty(str)) {
            g gVar = this.BE;
            if (gVar != null) {
                gVar.call(null, Boolean.FALSE, "bitmap src is null");
                return;
            }
            return;
        }
        this.BD = str;
        OfflineHostProvider.getApi().imageLoader().loadImage(this.BD, new IImageLoader.DisplayImageOptionsCompat.Builder().bitmapConfig(Bitmap.Config.ARGB_8888).cacheOnDisk(true).cacheInMemory(true).build(), new IImageLoader.ImageLoadingListener() { // from class: com.kwad.tachikoma.b.a.1
            @Override // com.kwad.components.offline.api.core.api.IImageLoader.ImageLoadingListener
            public final boolean onDecode(String str2, InputStream inputStream, Bitmap bitmap) {
                return false;
            }

            @Override // com.kwad.components.offline.api.core.api.IImageLoader.ImageLoadingListener
            public final void onLoadingStarted(String str2, View view) {
            }

            @Override // com.kwad.components.offline.api.core.api.IImageLoader.ImageLoadingListener
            public final void onLoadingFailed(String str2, View view, String str3, Throwable th) {
                if (a.this.BE != null) {
                    a.this.BE.call(null, Boolean.FALSE, th.getMessage());
                }
            }

            @Override // com.kwad.components.offline.api.core.api.IImageLoader.ImageLoadingListener
            public final void onLoadingComplete(String str2, View view, Bitmap bitmap) {
                a.this.BF = bitmap;
                if (a.this.BE != null) {
                    a.this.BE.call(null, Boolean.TRUE, "");
                }
            }

            @Override // com.kwad.components.offline.api.core.api.IImageLoader.ImageLoadingListener
            public final void onLoadingCancelled(String str2, View view) {
                if (a.this.BE != null) {
                    a.this.BE.call(null, Boolean.FALSE, "bitmap loading cancelled");
                }
            }
        });
    }

    public final Bitmap getBitmap() {
        return this.BF;
    }

    @Override // com.tk.core.component.TKBaseNativeModule
    public final void a(TKBaseNativeModule.DestroyReason destroyReason, boolean z) {
        super.a(destroyReason, z);
        g gVar = this.BE;
        if (gVar != null) {
            gVar.destroy();
        }
    }
}
