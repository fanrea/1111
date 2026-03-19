package aegon.chrome.net.impl;

import aegon.chrome.net.ExperimentalCronetEngine;
import android.content.Context;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class JavaCronetEngineBuilderImpl extends CronetEngineBuilderImpl {
    public JavaCronetEngineBuilderImpl(Context context) {
        super(context);
    }

    @Override // aegon.chrome.net.ICronetEngineBuilder
    public ExperimentalCronetEngine build() {
        if (getUserAgent() == null) {
            setUserAgent(getDefaultUserAgent());
        }
        return new JavaCronetEngine(this);
    }
}
