package com.kwad.sdk.glide.load.c;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.kwad.sdk.glide.load.c.n;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class w<Data> implements n<Uri, Data> {
    private static final Set<String> bWW = Collections.unmodifiableSet(new HashSet(Arrays.asList(com.sigmob.sdk.base.n.z, "android.resource", "content")));
    private final c<Data> bWX;

    public interface c<Data> {
        com.kwad.sdk.glide.load.a.d<Data> k(Uri uri);
    }

    @Override // com.kwad.sdk.glide.load.c.n
    public final /* synthetic */ boolean E(Uri uri) {
        return j(uri);
    }

    @Override // com.kwad.sdk.glide.load.c.n
    public final /* synthetic */ n.a b(Uri uri, int i, int i2, com.kwad.sdk.glide.load.f fVar) {
        return i(uri);
    }

    public w(c<Data> cVar) {
        this.bWX = cVar;
    }

    private n.a<Data> i(Uri uri) {
        return new n.a<>(new com.kwad.sdk.glide.d.b(uri), this.bWX.k(uri));
    }

    private static boolean j(Uri uri) {
        return bWW.contains(uri.getScheme());
    }

    public static class d implements o<Uri, InputStream>, c<InputStream> {
        private final ContentResolver bRU;

        public d(ContentResolver contentResolver) {
            this.bRU = contentResolver;
        }

        @Override // com.kwad.sdk.glide.load.c.w.c
        public final com.kwad.sdk.glide.load.a.d<InputStream> k(Uri uri) {
            return new com.kwad.sdk.glide.load.a.n(this.bRU, uri);
        }

        @Override // com.kwad.sdk.glide.load.c.o
        public final n<Uri, InputStream> a(r rVar) {
            return new w(this);
        }
    }

    public static class b implements o<Uri, ParcelFileDescriptor>, c<ParcelFileDescriptor> {
        private final ContentResolver bRU;

        public b(ContentResolver contentResolver) {
            this.bRU = contentResolver;
        }

        @Override // com.kwad.sdk.glide.load.c.w.c
        public final com.kwad.sdk.glide.load.a.d<ParcelFileDescriptor> k(Uri uri) {
            return new com.kwad.sdk.glide.load.a.i(this.bRU, uri);
        }

        @Override // com.kwad.sdk.glide.load.c.o
        public final n<Uri, ParcelFileDescriptor> a(r rVar) {
            return new w(this);
        }
    }

    public static final class a implements o<Uri, AssetFileDescriptor>, c<AssetFileDescriptor> {
        private final ContentResolver bRU;

        public a(ContentResolver contentResolver) {
            this.bRU = contentResolver;
        }

        @Override // com.kwad.sdk.glide.load.c.o
        public final n<Uri, AssetFileDescriptor> a(r rVar) {
            return new w(this);
        }

        @Override // com.kwad.sdk.glide.load.c.w.c
        public final com.kwad.sdk.glide.load.a.d<AssetFileDescriptor> k(Uri uri) {
            return new com.kwad.sdk.glide.load.a.a(this.bRU, uri);
        }
    }
}
