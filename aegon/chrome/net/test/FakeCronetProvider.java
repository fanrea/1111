package aegon.chrome.net.test;

import aegon.chrome.net.CronetEngine;
import aegon.chrome.net.CronetProvider;
import aegon.chrome.net.ExperimentalCronetEngine;
import aegon.chrome.net.impl.ImplVersion;
import aegon.chrome.net.test.FakeCronetEngine;
import android.content.Context;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class FakeCronetProvider extends CronetProvider {
    public static final String PROVIDER_NAME_FAKE = "Fake-Cronet-Provider";

    @Override // aegon.chrome.net.CronetProvider
    public String getName() {
        return PROVIDER_NAME_FAKE;
    }

    @Override // aegon.chrome.net.CronetProvider
    public boolean isEnabled() {
        return true;
    }

    public FakeCronetProvider(Context context) {
        super(context);
    }

    @Override // aegon.chrome.net.CronetProvider
    public CronetEngine.Builder createBuilder() {
        return new ExperimentalCronetEngine.Builder(new FakeCronetEngine.Builder(this.mContext));
    }

    @Override // aegon.chrome.net.CronetProvider
    public String getVersion() {
        return ImplVersion.getCronetVersion();
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{FakeCronetProvider.class, this.mContext});
    }

    public boolean equals(Object obj) {
        if (obj != this) {
            return (obj instanceof FakeCronetProvider) && this.mContext.equals(((FakeCronetProvider) obj).mContext);
        }
        return true;
    }
}
