package com.kwad.sdk.glide.load.a;

import android.content.ContentResolver;
import android.content.UriMatcher;
import android.net.Uri;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class n extends l<InputStream> {
    private static final UriMatcher bRV = new UriMatcher(-1);

    @Override // com.kwad.sdk.glide.load.a.l
    protected final /* synthetic */ void w(InputStream inputStream) throws IOException {
        i(inputStream);
    }

    public n(ContentResolver contentResolver, Uri uri) {
        super(contentResolver, uri);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.glide.load.a.l
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public InputStream b(Uri uri, ContentResolver contentResolver) throws FileNotFoundException {
        InputStream inputStreamE = e(uri, contentResolver);
        if (inputStreamE != null) {
            return inputStreamE;
        }
        throw new FileNotFoundException("InputStream is null for " + uri);
    }

    private static InputStream e(Uri uri, ContentResolver contentResolver) {
        return contentResolver.openInputStream(uri);
    }

    private static void i(InputStream inputStream) throws IOException {
        inputStream.close();
    }

    @Override // com.kwad.sdk.glide.load.a.d
    public final Class<InputStream> afT() {
        return InputStream.class;
    }
}
