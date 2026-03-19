package com.kwad.sdk.glide.load.a;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.kuaishou.weapon.p0.t;
import java.io.FileNotFoundException;
import java.io.IOException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class i extends l<ParcelFileDescriptor> {
    @Override // com.kwad.sdk.glide.load.a.l
    protected final /* synthetic */ ParcelFileDescriptor b(Uri uri, ContentResolver contentResolver) {
        return c(uri, contentResolver);
    }

    @Override // com.kwad.sdk.glide.load.a.l
    protected final /* synthetic */ void w(ParcelFileDescriptor parcelFileDescriptor) throws IOException {
        a(parcelFileDescriptor);
    }

    public i(ContentResolver contentResolver, Uri uri) {
        super(contentResolver, uri);
    }

    private static ParcelFileDescriptor c(Uri uri, ContentResolver contentResolver) throws FileNotFoundException {
        AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor = contentResolver.openAssetFileDescriptor(uri, t.k);
        if (assetFileDescriptorOpenAssetFileDescriptor == null) {
            throw new FileNotFoundException("FileDescriptor is null for: " + uri);
        }
        return assetFileDescriptorOpenAssetFileDescriptor.getParcelFileDescriptor();
    }

    private static void a(ParcelFileDescriptor parcelFileDescriptor) throws IOException {
        parcelFileDescriptor.close();
    }

    @Override // com.kwad.sdk.glide.load.a.d
    public final Class<ParcelFileDescriptor> afT() {
        return ParcelFileDescriptor.class;
    }
}
