package aegon.chrome.net.impl;

import aegon.chrome.net.CronetEngine;
import aegon.chrome.net.CronetProvider;
import aegon.chrome.net.ExperimentalCronetEngine;
import android.content.Context;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class NativeCronetProvider extends CronetProvider {
    @Override // aegon.chrome.net.CronetProvider
    public String getName() {
        return CronetProvider.PROVIDER_NAME_APP_PACKAGED;
    }

    @Override // aegon.chrome.net.CronetProvider
    public boolean isEnabled() {
        return true;
    }

    public NativeCronetProvider(Context context) {
        super(context);
    }

    @Override // aegon.chrome.net.CronetProvider
    public CronetEngine.Builder createBuilder() {
        return new ExperimentalCronetEngine.Builder(new NativeCronetEngineBuilderWithLibraryLoaderImpl(this.mContext));
    }

    @Override // aegon.chrome.net.CronetProvider
    public String getVersion() {
        return ImplVersion.getCronetVersion();
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{NativeCronetProvider.class, this.mContext});
    }

    public boolean equals(Object obj) {
        if (obj != this) {
            return (obj instanceof NativeCronetProvider) && this.mContext.equals(((NativeCronetProvider) obj).mContext);
        }
        return true;
    }
}
