package com.kwad.sdk.core.video.videoview;

import java.lang.ref.WeakReference;
import java.util.HashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class AdVideoPlayerViewCache {
    private HashMap<String, WeakReference<a>> Hd;

    /* synthetic */ AdVideoPlayerViewCache(byte b) {
        this();
    }

    enum Holder {
        INSTANCE;

        private AdVideoPlayerViewCache mInstance = new AdVideoPlayerViewCache(0);

        Holder() {
        }

        final AdVideoPlayerViewCache getInstance() {
            return this.mInstance;
        }
    }

    public static AdVideoPlayerViewCache getInstance() {
        return Holder.INSTANCE.getInstance();
    }

    private AdVideoPlayerViewCache() {
        this.Hd = new HashMap<>(1);
    }

    public final void a(String str, a aVar) {
        this.Hd.put(str, new WeakReference<>(aVar));
    }

    public final void remove(String str) {
        this.Hd.remove(str);
    }

    public final a fW(String str) {
        WeakReference<a> weakReference = this.Hd.get(str);
        if (weakReference != null) {
            a aVar = weakReference.get();
            if (aVar != null) {
                return aVar;
            }
            this.Hd.remove(str);
        }
        return null;
    }
}
