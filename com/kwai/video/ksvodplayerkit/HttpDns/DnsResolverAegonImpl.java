package com.kwai.video.ksvodplayerkit.HttpDns;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.aegon.httpdns.HttpDnsResolver;
import com.kuaishou.aegon.httpdns.ResolveFinishedInfo;
import com.kwai.video.ksvodplayerkit.Utils.NetworkUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class DnsResolverAegonImpl implements DnsResolver {
    public static final String DEFAULT_AEGON_CONFIG_JSON = "{\"enable_quic\":true,\"quic_hints\":[[\"g-br-cdn.kwai.net\",80,443],[\"tx-br-cdn.kwai.net\",80,443],[\"g-ind-cdn.kwai.net\",80,443],[\"tx-ind-cdn.kwai.net\",80,443]],\"quic_idle_timeout_sec\":30,\"preconnect_urls\":[\"http:\\/\\/g-api.kwai.com\"],\"preconnect_num_streams\":3,\"preconnect_non_altsvc\":true,\"altsvc_broken_time_base\":300,\"altsvc_broken_time_max\":86400}";
    public static final String DEFAULT_HTTP_DNS_JSON = "{\"defaultPingConfig\":{\"mIcmpPingUseCmd\":false},\"defaultResolveConfig\":{},\"feedTimeout\":600000,\"hosts\":{\"ks.pull.yximgs.com\":{\"pingConfig\":{\"mIcmpPingUseCmd\":false},\"priority\":8,\"resolveConfig\":{},\"vendor\":\"ks\"},\"ws.pull.yximgs.com\":{\"pingConfig\":{\"mIcmpPingUseCmd\":false},\"priority\":1,\"resolveConfig\":{},\"vendor\":\"ws\"},\"ws01.pull.yximgs.com\":{\"pingConfig\":{\"mIcmpPingUseCmd\":false},\"priority\":2,\"resolveConfig\":{},\"vendor\":\"ws\"},\"aliimg.a.yximgs.com\":{\"pingConfig\":{\"mIcmpPingUseCmd\":false},\"priority\":7,\"resolveConfig\":{},\"vendor\":\"ali\"},\"ali2.a.yximgs.com\":{\"pingConfig\":{\"mIcmpPingUseCmd\":false},\"priority\":5,\"resolveConfig\":{},\"vendor\":\"ali\"},\"bd.pull.yximgs.com\":{\"pingConfig\":{\"mIcmpPingUseCmd\":false},\"priority\":12,\"resolveConfig\":{},\"vendor\":\"bd\"},\"ws02.pull.yximgs.com\":{\"pingConfig\":{\"mIcmpPingUseCmd\":false},\"priority\":3,\"resolveConfig\":{},\"vendor\":\"ws\"},\"tx.pull.yximgs.com\":{\"pingConfig\":{\"mIcmpPingUseCmd\":false},\"priority\":10,\"resolveConfig\":{},\"vendor\":\"tx\"},\"xy.pull.yximgs.com\":{\"pingConfig\":{\"mIcmpPingUseCmd\":false},\"priority\":11,\"resolveConfig\":{},\"vendor\":\"xy\"},\"ali.pull.yximgs.com\":{\"pingConfig\":{\"mIcmpPingUseCmd\":false},\"priority\":9,\"resolveConfig\":{},\"vendor\":\"ali\"},\"js.a.yximgs.com\":{\"pingConfig\":{\"mIcmpPingUseCmd\":false},\"priority\":0,\"resolveConfig\":{},\"vendor\":\"ks\"},\"tx2.a.yximgs.com\":{\"pingConfig\":{\"mIcmpPingUseCmd\":false},\"priority\":4,\"resolveConfig\":{},\"vendor\":\"tx\"},\"alimov2.a.yximgs.com\":{\"pingConfig\":{\"mIcmpPingUseCmd\":false},\"priority\":6,\"resolveConfig\":{},\"vendor\":\"ali\"}},\"parallelism\":1,\"pauseOnBackground\":false}";

    @Override // com.kwai.video.ksvodplayerkit.HttpDns.DnsResolver
    public void evictIp(String str) {
    }

    @Override // com.kwai.video.ksvodplayerkit.HttpDns.DnsResolver
    public void initialize(Context context) {
    }

    @Override // com.kwai.video.ksvodplayerkit.HttpDns.DnsResolver
    public void onBackground() {
    }

    @Override // com.kwai.video.ksvodplayerkit.HttpDns.DnsResolver
    public void onForeground() {
    }

    public DnsResolverAegonImpl() {
        HttpDnsResolver.setLogger(new HttpDnsResolver.a() { // from class: com.kwai.video.ksvodplayerkit.HttpDns.DnsResolverAegonImpl.1
            @Override // com.kuaishou.aegon.httpdns.HttpDnsResolver.a
            public void onResolveFinish(ResolveFinishedInfo resolveFinishedInfo) {
            }
        });
    }

    @Override // com.kwai.video.ksvodplayerkit.HttpDns.DnsResolver
    public void updateConfig(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        HttpDnsResolver.updateConfig(str);
    }

    @Override // com.kwai.video.ksvodplayerkit.HttpDns.DnsResolver
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

    @Override // com.kwai.video.ksvodplayerkit.HttpDns.DnsResolver
    public void onHostsFromFeed(List<String> list) {
        HttpDnsResolver.increasePriority(list);
    }
}
