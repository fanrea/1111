package com.kwai.video.ksliveplayer.midd;

import android.content.Context;
import android.text.TextUtils;
import com.kwai.video.ksliveplayer.switcher.DnsResolver;
import com.kwai.video.ksliveplayer.switcher.ResolvedIP;
import com.kwai.video.ksliveplayer.switcher.ResolverType;
import com.kwai.video.ksliveplayer.util.NetworkUtils;
import com.kwai.video.smartdns.KSResolvedIP;
import com.kwai.video.smartdns.KSSmartDns;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class KSMiddHttpDnsResolver implements DnsResolver {
    @Override // com.kwai.video.ksliveplayer.switcher.DnsResolver
    public void evictIp(String str) {
    }

    @Override // com.kwai.video.ksliveplayer.switcher.DnsResolver
    public void onBackground() {
    }

    @Override // com.kwai.video.ksliveplayer.switcher.DnsResolver
    public void onForeground() {
    }

    @Override // com.kwai.video.ksliveplayer.switcher.DnsResolver
    public void onHostsFromFeed(List<String> list) {
    }

    @Override // com.kwai.video.ksliveplayer.switcher.DnsResolver
    public void updateConfig(String str) {
    }

    @Override // com.kwai.video.ksliveplayer.switcher.DnsResolver
    public void initialize(Context context) {
        KSSmartDns.getInstance().startService(context);
    }

    @Override // com.kwai.video.ksliveplayer.switcher.DnsResolver
    public List<ResolvedIP> resolveHost(String str) {
        if (TextUtils.isEmpty(str) || NetworkUtils.isIp(str)) {
            return new ArrayList();
        }
        List<KSResolvedIP> resolvedIPs = KSSmartDns.getInstance().getResolvedIPs(str);
        ArrayList arrayList = new ArrayList();
        if (resolvedIPs != null && !resolvedIPs.isEmpty()) {
            for (KSResolvedIP kSResolvedIP : resolvedIPs) {
                if (kSResolvedIP != null) {
                    arrayList.add(new ResolvedIP(str, kSResolvedIP.getResolvedIP(), ResolverType.HTTP, kSResolvedIP.getRTT()));
                }
            }
        }
        return arrayList;
    }
}
