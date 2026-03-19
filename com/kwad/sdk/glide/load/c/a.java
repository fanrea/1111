package com.kwad.sdk.glide.load.c;

import android.content.res.AssetManager;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.kwad.sdk.glide.load.c.n;
import java.io.InputStream;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class a<Data> implements n<Uri, Data> {
    private static final int bVX = 22;
    private final InterfaceC0604a<Data> bVY;
    private final AssetManager bmM;

    /* renamed from: com.kwad.sdk.glide.load.c.a$a, reason: collision with other inner class name */
    public interface InterfaceC0604a<Data> {
        com.kwad.sdk.glide.load.a.d<Data> f(AssetManager assetManager, String str);
    }

    @Override // com.kwad.sdk.glide.load.c.n
    public final /* synthetic */ boolean E(Uri uri) {
        return j(uri);
    }

    @Override // com.kwad.sdk.glide.load.c.n
    public final /* synthetic */ n.a b(Uri uri, int i, int i2, com.kwad.sdk.glide.load.f fVar) {
        return i(uri);
    }

    public a(AssetManager assetManager, InterfaceC0604a<Data> interfaceC0604a) {
        this.bmM = assetManager;
        this.bVY = interfaceC0604a;
    }

    private n.a<Data> i(Uri uri) {
        return new n.a<>(new com.kwad.sdk.glide.d.b(uri), this.bVY.f(this.bmM, uri.toString().substring(bVX)));
    }

    private static boolean j(Uri uri) {
        return com.sigmob.sdk.base.n.z.equals(uri.getScheme()) && !uri.getPathSegments().isEmpty() && "android_asset".equals(uri.getPathSegments().get(0));
    }

    public static class c implements InterfaceC0604a<InputStream>, o<Uri, InputStream> {
        private final AssetManager bmM;

        public c(AssetManager assetManager) {
            this.bmM = assetManager;
        }

        @Override // com.kwad.sdk.glide.load.c.o
        public final n<Uri, InputStream> a(r rVar) {
            return new a(this.bmM, this);
        }

        @Override // com.kwad.sdk.glide.load.c.a.InterfaceC0604a
        public final com.kwad.sdk.glide.load.a.d<InputStream> f(AssetManager assetManager, String str) {
            return new com.kwad.sdk.glide.load.a.m(assetManager, str);
        }
    }

    public static class b implements InterfaceC0604a<ParcelFileDescriptor>, o<Uri, ParcelFileDescriptor> {
        private final AssetManager bmM;

        public b(AssetManager assetManager) {
            this.bmM = assetManager;
        }

        @Override // com.kwad.sdk.glide.load.c.o
        public final n<Uri, ParcelFileDescriptor> a(r rVar) {
            return new a(this.bmM, this);
        }

        @Override // com.kwad.sdk.glide.load.c.a.InterfaceC0604a
        public final com.kwad.sdk.glide.load.a.d<ParcelFileDescriptor> f(AssetManager assetManager, String str) {
            return new com.kwad.sdk.glide.load.a.h(assetManager, str);
        }
    }
}
