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
public class JavaCronetProvider extends CronetProvider {
    @Override // aegon.chrome.net.CronetProvider
    public String getName() {
        return CronetProvider.PROVIDER_NAME_FALLBACK;
    }

    @Override // aegon.chrome.net.CronetProvider
    public boolean isEnabled() {
        return true;
    }

    public JavaCronetProvider(Context context) {
        super(context);
    }

    @Override // aegon.chrome.net.CronetProvider
    public CronetEngine.Builder createBuilder() {
        return new ExperimentalCronetEngine.Builder(new JavaCronetEngineBuilderImpl(this.mContext));
    }

    @Override // aegon.chrome.net.CronetProvider
    public String getVersion() {
        return ImplVersion.getCronetVersion();
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{JavaCronetProvider.class, this.mContext});
    }

    public boolean equals(Object obj) {
        if (obj != this) {
            return (obj instanceof JavaCronetProvider) && this.mContext.equals(((JavaCronetProvider) obj).mContext);
        }
        return true;
    }
}
