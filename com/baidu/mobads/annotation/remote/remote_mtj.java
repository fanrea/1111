package com.baidu.mobads.annotation.remote;

import com.baidu.mobads.container.annotation.RouteInfo;
import com.baidu.mobads.container.r.a;
import com.baidu.mobads.upgrade.remote.mtj.MTJDexLoaderImpl;
import java.util.HashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class remote_mtj {
    public static HashMap<String, RouteInfo> getRoutesMap() {
        HashMap<String, RouteInfo> map = new HashMap<>();
        map.put(a.InterfaceC0131a.d, RouteInfo.build(MTJDexLoaderImpl.class, a.InterfaceC0131a.d));
        return map;
    }
}
