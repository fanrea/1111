package com.kuaishou.tk.api.exception;

import com.kuaishou.tk.api.export.sdk.TkBundleInfo;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public class ContainerInfoMap {
    private static final ConcurrentHashMap<Integer, ContainerInfo> sMap = new ConcurrentHashMap<>();

    public static void preload() {
    }

    public static void setContainerInfo(int i, ContainerInfo containerInfo) {
        sMap.put(Integer.valueOf(i), containerInfo);
    }

    public static void setBusinessName(int i, String str) {
        if (sMap.containsKey(Integer.valueOf(i))) {
            ContainerInfo containerInfo = sMap.get(Integer.valueOf(i));
            if (containerInfo != null) {
                containerInfo.businessName = str;
                return;
            }
            return;
        }
        ContainerInfo containerInfo2 = new ContainerInfo();
        containerInfo2.businessName = str;
        sMap.put(Integer.valueOf(i), containerInfo2);
    }

    public static void setBundleInfo(int i, TkBundleInfo tkBundleInfo) {
        if (sMap.containsKey(Integer.valueOf(i))) {
            ContainerInfo containerInfo = sMap.get(Integer.valueOf(i));
            if (containerInfo != null) {
                containerInfo.bundleInfo = tkBundleInfo;
                return;
            }
            return;
        }
        ContainerInfo containerInfo2 = new ContainerInfo();
        containerInfo2.bundleInfo = tkBundleInfo;
        sMap.put(Integer.valueOf(i), containerInfo2);
    }

    public static void setContainerSessionId(int i, String str) {
        if (sMap.containsKey(Integer.valueOf(i))) {
            ContainerInfo containerInfo = sMap.get(Integer.valueOf(i));
            if (containerInfo != null) {
                containerInfo.containerSessionId = str;
                return;
            }
            return;
        }
        ContainerInfo containerInfo2 = new ContainerInfo();
        containerInfo2.containerSessionId = str;
        sMap.put(Integer.valueOf(i), containerInfo2);
    }

    public static void setBizExtraInfo(int i, String str) {
        if (sMap.containsKey(Integer.valueOf(i))) {
            ContainerInfo containerInfo = sMap.get(Integer.valueOf(i));
            if (containerInfo != null) {
                containerInfo.bizExtraInfo = str;
                return;
            }
            return;
        }
        ContainerInfo containerInfo2 = new ContainerInfo();
        containerInfo2.bizExtraInfo = str;
        sMap.put(Integer.valueOf(i), containerInfo2);
    }

    public static void remove(int i) {
        sMap.remove(Integer.valueOf(i));
    }

    public static ContainerInfo get(int i) {
        return sMap.get(Integer.valueOf(i));
    }
}
