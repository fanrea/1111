package com.kwad.components.core.p.b.a;

import com.kwad.components.offline.api.core.api.IZipper;
import com.kwad.sdk.utils.cf;
import java.io.File;
import java.io.InputStream;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
final class r implements IZipper {
    r() {
    }

    @Override // com.kwad.components.offline.api.core.api.IZipper
    public final boolean unZip(InputStream inputStream, String str) {
        return cf.unZip(inputStream, str);
    }

    @Override // com.kwad.components.offline.api.core.api.IZipper
    public final void zipFile(File file) {
        cf.zipFile(file);
    }

    @Override // com.kwad.components.offline.api.core.api.IZipper
    public final boolean zip(File file, File file2) {
        return cf.zip(file, file2);
    }
}
