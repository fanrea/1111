package io.netty.resolver;

import java.net.InetAddress;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class DefaultHostsFileEntriesResolver implements HostsFileEntriesResolver {
    private final Map<String, InetAddress> entries = HostsFileParser.parseSilently();

    @Override // io.netty.resolver.HostsFileEntriesResolver
    public final InetAddress address(String str) {
        return this.entries.get(str);
    }
}
