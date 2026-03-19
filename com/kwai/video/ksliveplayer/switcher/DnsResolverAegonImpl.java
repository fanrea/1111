package com.kwai.video.ksliveplayer.switcher;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.aegon.httpdns.HttpDnsResolver;
import com.kwai.video.ksliveplayer.util.NetworkUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class DnsResolverAegonImpl implements DnsResolver {
    public static final String DEFAULT_AEGON_CONFIG_JSON = "{\"enable_quic\":true,\"quic_hints\":[[\"g-br-cdn.kwai.net\",80,443],[\"tx-br-cdn.kwai.net\",80,443],[\"g-ind-cdn.kwai.net\",80,443],[\"tx-ind-cdn.kwai.net\",80,443]],\"quic_idle_timeout_sec\":30,\"preconnect_urls\":[\"http:\\/\\/g-api.kwai.com\"],\"preconnect_num_streams\":3,\"preconnect_non_altsvc\":true,\"altsvc_broken_time_base\":300,\"altsvc_broken_time_max\":86400}";
    public static final String DEFAULT_HTTP_DNS_JSON = "{\"defaultPingConfig\":{\"mIcmpPingUseCmd\":false},\"defaultResolveConfig\":{},\"feedTimeout\":600000,\"hosts\":{\"ali.pull.yximgs.com\":{\"pingConfig\":{\"mIcmpPingUseCmd\":false},\"priority\":1,\"resolveConfig\":{},\"vendor\":\"ali\"},\"ali-origin.pull.yximgs.com\":{\"pingConfig\":{\"mIcmpPingUseCmd\":false},\"priority\":7,\"resolveConfig\":{},\"vendor\":\"ali\"},\"ali-pclivemate.pull.yximgs.com\":{\"pingConfig\":{\"mIcmpPingUseCmd\":false},\"priority\":5,\"resolveConfig\":{},\"vendor\":\"ali\"},\"ali-livemate.pull.yximgs.com\":{\"pingConfig\":{\"mIcmpPingUseCmd\":false},\"priority\":5,\"resolveConfig\":{},\"vendor\":\"ali\"},\"ali-adaptive.pull.yximgs.com\":{\"pingConfig\":{\"mIcmpPingUseCmd\":false},\"priority\":5,\"resolveConfig\":{},\"vendor\":\"ali\"},\"ali-proxy.pull.yximgs.com\":{\"pingConfig\":{\"mIcmpPingUseCmd\":false},\"priority\":5,\"resolveConfig\":{},\"vendor\":\"ali\"},\"ali-rwk.pull.etoote.com\":{\"pingConfig\":{\"mIcmpPingUseCmd\":false},\"priority\":5,\"resolveConfig\":{},\"vendor\":\"ali\"},\"ali-kmplive.pull.yximgs.com\":{\"pingConfig\":{\"mIcmpPingUseCmd\":false},\"priority\":5,\"resolveConfig\":{},\"vendor\":\"ali\"},\"ali-kmpaudio.pull.yximgs.com\":{\"pingConfig\":{\"mIcmpPingUseCmd\":false},\"priority\":5,\"resolveConfig\":{},\"vendor\":\"ali\"},\"bd.pull.yximgs.com\":{\"pingConfig\":{\"mIcmpPingUseCmd\":false},\"priority\":3,\"resolveConfig\":{},\"vendor\":\"bd\"},\"bd-origin.pull.yximgs.com\":{\"pingConfig\":{\"mIcmpPingUseCmd\":false},\"priority\":3,\"resolveConfig\":{},\"vendor\":\"bd\"},\"bd-pclivemate.pull.yximgs.com\":{\"pingConfig\":{\"mIcmpPingUseCmd\":false},\"priority\":8,\"resolveConfig\":{},\"vendor\":\"bd\"},\"bd-livemate.pull.yximgs.com\":{\"pingConfig\":{\"mIcmpPingUseCmd\":false},\"priority\":9,\"resolveConfig\":{},\"vendor\":\"bd\"},\"bd-adaptive.pull.yximgs.com\":{\"pingConfig\":{\"mIcmpPingUseCmd\":false},\"priority\":9,\"resolveConfig\":{},\"vendor\":\"bd\"},\"bd-proxy.pull.yximgs.com\":{\"pingConfig\":{\"mIcmpPingUseCmd\":false},\"priority\":9,\"resolveConfig\":{},\"vendor\":\"bd\"},\"bd-rwk.pull.etoote.com\":{\"pingConfig\":{\"mIcmpPingUseCmd\":false},\"priority\":9,\"resolveConfig\":{},\"vendor\":\"bd\"},\"bd-rwk.pull.etoote.com\":{\"pingConfig\":{\"mIcmpPingUseCmd\":false},\"priority\":9,\"resolveConfig\":{},\"vendor\":\"bd\"},\"ks.pull.yximgs.com\":{\"pingConfig\":{\"mIcmpPingUseCmd\":false},\"priority\":4,\"resolveConfig\":{},\"vendor\":\"ks\"},\"ks-origin.pull.yximgs.com\":{\"pingConfig\":{\"mIcmpPingUseCmd\":false},\"priority\":4,\"resolveConfig\":{},\"vendor\":\"ks\"},\"ks-livemate.pull.yximgs.com\":{\"pingConfig\":{\"mIcmpPingUseCmd\":false},\"priority\":8,\"resolveConfig\":{},\"vendor\":\"ks\"},\"ks-adaptive.pull.yximgs.com\":{\"pingConfig\":{\"mIcmpPingUseCmd\":false},\"priority\":8,\"resolveConfig\":{},\"vendor\":\"ks\"},\"ks-pclivemate.pull.yximgs.com\":{\"pingConfig\":{\"mIcmpPingUseCmd\":false},\"priority\":8,\"resolveConfig\":{},\"vendor\":\"ks\"},\"ks-proxy.pull.yximgs.com\":{\"pingConfig\":{\"mIcmpPingUseCmd\":false},\"priority\":8,\"resolveConfig\":{},\"vendor\":\"ks\"},\"js-rwk.pull.etoote.com\":{\"pingConfig\":{\"mIcmpPingUseCmd\":false},\"priority\":8,\"resolveConfig\":{},\"vendor\":\"ks\"},\"tx.pull.yximgs.com\":{\"pingConfig\":{\"mIcmpPingUseCmd\":false},\"priority\":3,\"resolveConfig\":{},\"vendor\":\"tx\"},\"tx-origin.pull.yximgs.com\":{\"pingConfig\":{\"mIcmpPingUseCmd\":false},\"priority\":4,\"resolveConfig\":{},\"vendor\":\"tx\"},\"tx-pclivemate.pull.yximgs.com\":{\"pingConfig\":{\"mIcmpPingUseCmd\":false},\"priority\":8,\"resolveConfig\":{},\"vendor\":\"tx\"},\"tx-livemate.pull.yximgs.com\":{\"pingConfig\":{\"mIcmpPingUseCmd\":false},\"priority\":8,\"resolveConfig\":{},\"vendor\":\"tx\"},\"tx-adaptive.pull.yximgs.com\":{\"pingConfig\":{\"mIcmpPingUseCmd\":false},\"priority\":8,\"resolveConfig\":{},\"vendor\":\"tx\"},\"tx-game.pull.yximgs.com\":{\"pingConfig\":{\"mIcmpPingUseCmd\":false},\"priority\":8,\"resolveConfig\":{},\"vendor\":\"tx\"},\"tx-proxy.pull.yximgs.com\":{\"pingConfig\":{\"mIcmpPingUseCmd\":false},\"priority\":8,\"resolveConfig\":{},\"vendor\":\"tx\"},\"tx-rwk.pull.etoote.com\":{\"pingConfig\":{\"mIcmpPingUseCmd\":false},\"priority\":8,\"resolveConfig\":{},\"vendor\":\"tx\"},\"tx-dwk.pull.yximgs.com\":{\"pingConfig\":{\"mIcmpPingUseCmd\":false},\"priority\":8,\"resolveConfig\":{},\"vendor\":\"tx\"},\"tx-kmplive.pull.yximgs.com\":{\"pingConfig\":{\"mIcmpPingUseCmd\":false},\"priority\":8,\"resolveConfig\":{},\"vendor\":\"tx\"},\"tx-kmpaudio.pull.yximgs.com\":{\"pingConfig\":{\"mIcmpPingUseCmd\":false},\"priority\":8,\"resolveConfig\":{},\"vendor\":\"tx\"},\"ws.pull.yximgs.com\":{\"pingConfig\":{\"mIcmpPingUseCmd\":false},\"priority\":1,\"resolveConfig\":{},\"vendor\":\"ws\"},\"ws-origin.pull.yximgs.com\":{\"pingConfig\":{\"mIcmpPingUseCmd\":false},\"priority\":2,\"resolveConfig\":{},\"vendor\":\"ws\"},\"ws-pclivemate.pull.yximgs.com\":{\"pingConfig\":{\"mIcmpPingUseCmd\":false},\"priority\":4,\"resolveConfig\":{},\"vendor\":\"ws\"},\"ws-livemate.pull.yximgs.com\":{\"pingConfig\":{\"mIcmpPingUseCmd\":false},\"priority\":4,\"resolveConfig\":{},\"vendor\":\"ws\"},\"ws-adaptive.pull.yximgs.com\":{\"pingConfig\":{\"mIcmpPingUseCmd\":false},\"priority\":4,\"resolveConfig\":{},\"vendor\":\"ws\"},\"ws-proxy.pull.yximgs.com\":{\"pingConfig\":{\"mIcmpPingUseCmd\":false},\"priority\":5,\"resolveConfig\":{},\"vendor\":\"ws\"},\"ws-rwk.pull.etoote.com\":{\"pingConfig\":{\"mIcmpPingUseCmd\":false},\"priority\":5,\"resolveConfig\":{},\"vendor\":\"ws\"}},\"parallelism\":1,\"pauseOnBackground\":false}";

    @Override // com.kwai.video.ksliveplayer.switcher.DnsResolver
    public void evictIp(String str) {
    }

    @Override // com.kwai.video.ksliveplayer.switcher.DnsResolver
    public void initialize(Context context) {
    }

    @Override // com.kwai.video.ksliveplayer.switcher.DnsResolver
    public void onBackground() {
    }

    @Override // com.kwai.video.ksliveplayer.switcher.DnsResolver
    public void onForeground() {
    }

    @Override // com.kwai.video.ksliveplayer.switcher.DnsResolver
    public void updateConfig(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        HttpDnsResolver.updateConfig(str);
    }

    @Override // com.kwai.video.ksliveplayer.switcher.DnsResolver
    public List<ResolvedIP> resolveHost(String str) {
        if (TextUtils.isEmpty(str) || NetworkUtils.isIp(str)) {
            return new ArrayList();
        }
        List<com.kuaishou.aegon.httpdns.ResolvedIP> listResolve = HttpDnsResolver.resolve(str);
        ArrayList arrayList = new ArrayList();
        if (listResolve != null && !listResolve.isEmpty()) {
            for (com.kuaishou.aegon.httpdns.ResolvedIP resolvedIP : listResolve) {
                if (resolvedIP != null) {
                    ResolvedIP resolvedIP2 = new ResolvedIP(resolvedIP.mHost, resolvedIP.mIP, ResolverType.HTTP, resolvedIP.mTtl);
                    resolvedIP2.mResolver = resolvedIP.mResolver;
                    arrayList.add(resolvedIP2);
                }
            }
        }
        return arrayList;
    }

    @Override // com.kwai.video.ksliveplayer.switcher.DnsResolver
    public void onHostsFromFeed(List<String> list) {
        HttpDnsResolver.increasePriority(list);
    }
}
