package com.bykv.vk.component.ttvideo.network;

import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class IPCache {
    private static IPCache mInstance = null;
    private static String mNetExtraInfo = null;
    private static int mNetType = -1;
    private ConcurrentHashMap<String, IpInfo> mIpRecord = new ConcurrentHashMap<>();

    static class IpInfo {
        public int count;
        public String ipaddr;
        public long iptime;
        public boolean needUpdate;

        IpInfo() {
        }
    }

    public static IPCache getInstance() {
        if (mInstance == null) {
            synchronized (IPCache.class) {
                if (mInstance == null) {
                    mInstance = new IPCache();
                }
            }
        }
        return mInstance;
    }

    private IPCache() {
    }

    public IpInfo get(String str) {
        ConcurrentHashMap<String, IpInfo> concurrentHashMap = this.mIpRecord;
        if (concurrentHashMap != null) {
            return concurrentHashMap.get(str);
        }
        return null;
    }

    public void put(String str, IpInfo ipInfo) {
        ConcurrentHashMap<String, IpInfo> concurrentHashMap = this.mIpRecord;
        if (concurrentHashMap != null) {
            concurrentHashMap.put(str, ipInfo);
        }
    }

    public int getRecordSize() {
        ConcurrentHashMap<String, IpInfo> concurrentHashMap = this.mIpRecord;
        if (concurrentHashMap != null) {
            return concurrentHashMap.size();
        }
        return -1;
    }

    public void disableIpAddress(String str) {
        if (str == null) {
            return;
        }
        ConcurrentHashMap<String, IpInfo> concurrentHashMap = this.mIpRecord;
        IpInfo ipInfo = concurrentHashMap != null ? concurrentHashMap.get(str) : null;
        if (ipInfo != null) {
            ipInfo.needUpdate = true;
        }
    }

    public void clear() {
        ConcurrentHashMap<String, IpInfo> concurrentHashMap = this.mIpRecord;
        if (concurrentHashMap != null) {
            concurrentHashMap.clear();
        }
    }

    public int getCurNetType() {
        return mNetType;
    }

    public void setCurNetType(int i) {
        mNetType = i;
    }

    public String getCurNetExtraInfo() {
        return mNetExtraInfo;
    }

    public void setCurNetExtraInfo(String str) {
        mNetExtraInfo = str;
    }
}
