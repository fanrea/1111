package com.kwad.sdk.glide.load.a;

import android.content.res.AssetManager;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class m extends b<InputStream> {
    @Override // com.kwad.sdk.glide.load.a.b
    protected final /* synthetic */ InputStream c(AssetManager assetManager, String str) {
        return e(assetManager, str);
    }

    @Override // com.kwad.sdk.glide.load.a.b
    protected final /* synthetic */ void w(InputStream inputStream) throws IOException {
        i(inputStream);
    }

    public m(AssetManager assetManager, String str) {
        super(assetManager, str);
    }

    private static InputStream e(AssetManager assetManager, String str) {
        return assetManager.open(str);
    }

    private static void i(InputStream inputStream) throws IOException {
        inputStream.close();
    }

    @Override // com.kwad.sdk.glide.load.a.d
    public final Class<InputStream> afT() {
        return InputStream.class;
    }
}
