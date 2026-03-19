package com.kwad.sdk.glide.load.c;

import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import com.kwad.sdk.glide.load.c.n;
import java.io.File;
import java.io.InputStream;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class u<Data> implements n<String, Data> {
    private final n<Uri, Data> bWS;

    @Override // com.kwad.sdk.glide.load.c.n
    public final /* bridge */ /* synthetic */ boolean E(String str) {
        return true;
    }

    public u(n<Uri, Data> nVar) {
        this.bWS = nVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.glide.load.c.n
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public n.a<Data> b(String str, int i, int i2, com.kwad.sdk.glide.load.f fVar) {
        Uri uriHo = ho(str);
        if (uriHo == null || !this.bWS.E(uriHo)) {
            return null;
        }
        return this.bWS.b(uriHo, i, i2, fVar);
    }

    private static Uri ho(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.charAt(0) == '/') {
            return hp(str);
        }
        Uri uri = Uri.parse(str);
        return uri.getScheme() == null ? hp(str) : uri;
    }

    private static Uri hp(String str) {
        return Uri.fromFile(new File(str));
    }

    public static class c implements o<String, InputStream> {
        @Override // com.kwad.sdk.glide.load.c.o
        public final n<String, InputStream> a(r rVar) {
            return new u(rVar.a(Uri.class, InputStream.class));
        }
    }

    public static class b implements o<String, ParcelFileDescriptor> {
        @Override // com.kwad.sdk.glide.load.c.o
        public final n<String, ParcelFileDescriptor> a(r rVar) {
            return new u(rVar.a(Uri.class, ParcelFileDescriptor.class));
        }
    }

    public static final class a implements o<String, AssetFileDescriptor> {
        @Override // com.kwad.sdk.glide.load.c.o
        public final n<String, AssetFileDescriptor> a(r rVar) {
            return new u(rVar.a(Uri.class, AssetFileDescriptor.class));
        }
    }
}
