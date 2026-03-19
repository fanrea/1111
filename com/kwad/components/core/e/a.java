package com.kwad.components.core.e;

import android.view.View;
import com.kwad.sdk.core.imageloader.core.assist.FailReason;
import com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener;
import com.kwad.sdk.core.network.idc.DomainException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a extends SimpleImageLoadingListener {
    @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
    public final void onLoadingFailed(String str, View view, FailReason failReason) {
        if (failReason.getType() == FailReason.FailType.IO_ERROR) {
            com.kwad.sdk.core.network.idc.a.aaw().a(str, "cdn", f(failReason.getCause()));
        }
    }

    public static DomainException f(Throwable th) {
        if (th instanceof Exception) {
            return new DomainException((Exception) th);
        }
        return null;
    }
}
