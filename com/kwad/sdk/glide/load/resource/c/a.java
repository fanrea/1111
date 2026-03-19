package com.kwad.sdk.glide.load.resource.c;

import com.kwad.sdk.glide.load.engine.s;
import com.kwad.sdk.glide.load.f;
import com.kwad.sdk.glide.load.g;
import java.io.File;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class a implements g<File, File> {
    @Override // com.kwad.sdk.glide.load.g
    public final /* bridge */ /* synthetic */ boolean a(File file, f fVar) {
        return true;
    }

    @Override // com.kwad.sdk.glide.load.g
    public final /* synthetic */ s<File> a(File file, int i, int i2, f fVar) {
        return U(file);
    }

    private static s<File> U(File file) {
        return new b(file);
    }
}
