package com.kwad.components.ct.b;

import android.graphics.drawable.Drawable;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.glide.load.DataSource;
import com.kwad.sdk.glide.load.engine.GlideException;
import com.kwad.sdk.glide.request.a.j;
import com.kwad.sdk.glide.request.h;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a implements h<Drawable> {
    private String aGx;
    private CtAdTemplate arC;

    @Override // com.kwad.sdk.glide.request.h
    public final /* bridge */ /* synthetic */ boolean a(Drawable drawable, Object obj, j<Drawable> jVar, DataSource dataSource, boolean z) {
        return false;
    }

    public a(String str, CtAdTemplate ctAdTemplate) {
        this.aGx = str;
        this.arC = ctAdTemplate;
    }

    @Override // com.kwad.sdk.glide.request.h
    public final boolean a(GlideException glideException) {
        StringBuilder sb = new StringBuilder("KS_Glide:");
        if (glideException == null) {
            return false;
        }
        sb.append(glideException.getMessage());
        return false;
    }
}
