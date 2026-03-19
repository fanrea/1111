package com.kwai.video.ksvodplayerkit.HttpDns;

import android.content.Context;
import android.text.TextUtils;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class HttpDns {
    private static final String TAG = "HttpDns";
    private DnsResolver mImpl;

    private HttpDns() {
        this.mImpl = new DnsResolverAegonImpl();
    }

    public static HttpDns get() {
        return Holder.INSTANCE;
    }

    public void setImpl(DnsResolver dnsResolver) {
        this.mImpl = dnsResolver;
    }

    public void init(Context context) {
        DnsResolver dnsResolver = this.mImpl;
        if (dnsResolver != null) {
            dnsResolver.initialize(context);
        }
    }

    public List<ResolvedIP> getResolvedIPs(String str) {
        return this.mImpl.resolveHost(str);
    }

    public void updateConfig(String str) {
        DnsResolver dnsResolver;
        if (TextUtils.isEmpty(str) || (dnsResolver = this.mImpl) == null) {
            return;
        }
        dnsResolver.updateConfig(str);
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    static final class Holder {
        private static final HttpDns INSTANCE = new HttpDns();

        private Holder() {
        }
    }
}
