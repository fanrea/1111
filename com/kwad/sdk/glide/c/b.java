package com.kwad.sdk.glide.c;

import com.kwad.sdk.glide.load.ImageHeaderParser;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class b {
    private final List<ImageHeaderParser> bQG = new ArrayList();

    public final synchronized List<ImageHeaderParser> aiw() {
        return this.bQG;
    }

    public final synchronized void b(ImageHeaderParser imageHeaderParser) {
        this.bQG.add(imageHeaderParser);
    }
}
