package com.kwad.sdk.glide.load.a;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import com.kuaishou.weapon.p0.t;
import java.io.FileNotFoundException;
import java.io.IOException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class a extends l<AssetFileDescriptor> {
    @Override // com.kwad.sdk.glide.load.a.l
    protected final /* synthetic */ AssetFileDescriptor b(Uri uri, ContentResolver contentResolver) {
        return a(uri, contentResolver);
    }

    @Override // com.kwad.sdk.glide.load.a.l
    protected final /* synthetic */ void w(AssetFileDescriptor assetFileDescriptor) throws IOException {
        a(assetFileDescriptor);
    }

    public a(ContentResolver contentResolver, Uri uri) {
        super(contentResolver, uri);
    }

    private static AssetFileDescriptor a(Uri uri, ContentResolver contentResolver) throws FileNotFoundException {
        AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor = contentResolver.openAssetFileDescriptor(uri, t.k);
        if (assetFileDescriptorOpenAssetFileDescriptor != null) {
            return assetFileDescriptorOpenAssetFileDescriptor;
        }
        throw new FileNotFoundException("FileDescriptor is null for: " + uri);
    }

    private static void a(AssetFileDescriptor assetFileDescriptor) throws IOException {
        assetFileDescriptor.close();
    }

    @Override // com.kwad.sdk.glide.load.a.d
    public final Class<AssetFileDescriptor> afT() {
        return AssetFileDescriptor.class;
    }
}
