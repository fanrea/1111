package aegon.chrome.net.impl;

import aegon.chrome.net.CronetEngine;
import aegon.chrome.net.impl.VersionSafeCallbacks;
import android.content.Context;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class NativeCronetEngineBuilderWithLibraryLoaderImpl extends NativeCronetEngineBuilderImpl {
    private VersionSafeCallbacks.LibraryLoader mLibraryLoader;

    public NativeCronetEngineBuilderWithLibraryLoaderImpl(Context context) {
        super(context);
    }

    @Override // aegon.chrome.net.impl.CronetEngineBuilderImpl, aegon.chrome.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setLibraryLoader(CronetEngine.Builder.LibraryLoader libraryLoader) {
        this.mLibraryLoader = new VersionSafeCallbacks.LibraryLoader(libraryLoader);
        return this;
    }

    @Override // aegon.chrome.net.impl.CronetEngineBuilderImpl
    VersionSafeCallbacks.LibraryLoader libraryLoader() {
        return this.mLibraryLoader;
    }
}
