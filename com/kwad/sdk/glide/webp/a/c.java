package com.kwad.sdk.glide.webp.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.kwad.sdk.glide.a.h;
import com.kwad.sdk.glide.a.l;
import com.kwad.sdk.glide.g;
import com.kwad.sdk.glide.request.i;
import java.io.File;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class c extends g {
    public c(com.kwad.sdk.glide.c cVar, h hVar, l lVar, Context context) {
        super(cVar, hVar, lVar, context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.glide.g
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public <ResourceType> b<ResourceType> i(Class<ResourceType> cls) {
        return new b<>(this.bPw, this, cls, this.dR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.glide.g
    /* renamed from: akd, reason: merged with bridge method [inline-methods] */
    public b<Bitmap> afq() {
        return (b) super.afq();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.glide.g
    /* renamed from: ake, reason: merged with bridge method [inline-methods] */
    public b<Drawable> afr() {
        return (b) super.afr();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.glide.g
    /* renamed from: hs, reason: merged with bridge method [inline-methods] */
    public b<Drawable> hh(String str) {
        return (b) super.hh(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.glide.g
    /* renamed from: akf, reason: merged with bridge method [inline-methods] */
    public b<File> afs() {
        return (b) super.afs();
    }

    @Override // com.kwad.sdk.glide.g
    public final void a(i iVar) {
        if (iVar instanceof a) {
            super.a(iVar);
        } else {
            super.a(new a().c(iVar));
        }
    }
}
