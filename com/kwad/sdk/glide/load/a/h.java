package com.kwad.sdk.glide.load.a;

import android.content.res.AssetManager;
import android.os.ParcelFileDescriptor;
import java.io.IOException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class h extends b<ParcelFileDescriptor> {
    @Override // com.kwad.sdk.glide.load.a.b
    protected final /* synthetic */ ParcelFileDescriptor c(AssetManager assetManager, String str) {
        return d(assetManager, str);
    }

    @Override // com.kwad.sdk.glide.load.a.b
    protected final /* synthetic */ void w(ParcelFileDescriptor parcelFileDescriptor) throws IOException {
        a(parcelFileDescriptor);
    }

    public h(AssetManager assetManager, String str) {
        super(assetManager, str);
    }

    private static ParcelFileDescriptor d(AssetManager assetManager, String str) {
        return assetManager.openFd(str).getParcelFileDescriptor();
    }

    private static void a(ParcelFileDescriptor parcelFileDescriptor) throws IOException {
        parcelFileDescriptor.close();
    }

    @Override // com.kwad.sdk.glide.load.a.d
    public final Class<ParcelFileDescriptor> afT() {
        return ParcelFileDescriptor.class;
    }
}
