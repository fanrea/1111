package com.bykv.vk.component.ttvideo.net;

import com.bykv.vk.component.ttvideo.player.AVThreadPool;
import com.bytedance.sdk.component.utils.mq;
import java.net.InetAddress;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class AVResolver {
    public static int HOST_MAX_CACHE_TIME = 600000;
    private static final int MAX_CACHED = 128;
    private static final String TAG = "ttmj";
    private static final Hashtable<String, HostInfo> mCacheHosts = new Hashtable<>();
    private String mError;
    private HostInfo mHostInfo;
    private String mHostName;
    private String[] mIPStr;
    private boolean mRet = false;
    private Thread mThread = null;

    public void getAddressInfo(String str) {
        this.mHostName = str;
        if (str == null || str.length() <= 0 || "".equals(str)) {
            this.mRet = true;
            return;
        }
        if (isIP(this.mHostName)) {
            this.mIPStr = new String[]{this.mHostName};
            this.mRet = true;
            return;
        }
        Hashtable<String, HostInfo> hashtable = mCacheHosts;
        HostInfo hostInfo = hashtable.get(str);
        this.mHostInfo = hostInfo;
        if (hostInfo != null) {
            if (hostInfo.ip != null && System.currentTimeMillis() - this.mHostInfo.time < HOST_MAX_CACHE_TIME) {
                this.mIPStr = new String[]{this.mHostInfo.ip};
                this.mRet = true;
                return;
            } else {
                hashtable.remove(str);
                this.mHostInfo = null;
            }
        }
        try {
            AVThreadPool.addTask(new ParserHost(this, this.mHostName));
        } catch (Exception e) {
            this.mRet = true;
            this.mError = e.getMessage();
        }
    }

    public int isSuccess() {
        if (!this.mRet) {
            return 0;
        }
        String[] strArr = this.mIPStr;
        return (strArr == null || strArr[0] == null) ? -1 : 1;
    }

    public String getAddress() {
        String[] strArr;
        String str;
        return (!this.mRet || (strArr = this.mIPStr) == null || (str = strArr[0]) == null) ? "parser host name: " + this.mHostName + " error.err msg:" + this.mError : str;
    }

    public void freeAddress() {
        Thread thread = this.mThread;
        if (thread != null) {
            try {
                thread.interrupt();
            } catch (Exception e) {
                mq.d(e);
            }
        }
    }

    static class HostInfo {
        public String ip;
        public long time;

        HostInfo() {
        }
    }

    static class ParserHost implements Runnable {
        String mHostName;
        AVResolver mResolver;

        public ParserHost(AVResolver aVResolver, String str) {
            this.mResolver = aVResolver;
            this.mHostName = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            InetAddress byName;
            mq.d(AVResolver.TAG, "start ParserHost task");
            String hostAddress = null;
            try {
                byName = InetAddress.getByName(this.mHostName);
            } catch (Throwable th) {
                th = th;
                byName = null;
            }
            try {
                hostAddress = byName.getHostAddress();
            } catch (Throwable th2) {
                th = th2;
                mq.d(th);
                this.mResolver.mError = th.getMessage();
                this.mResolver.mRet = true;
                if (byName != null) {
                    return;
                } else {
                    return;
                }
            }
            this.mResolver.mRet = true;
            if (byName != null || hostAddress == null) {
                return;
            }
            this.mResolver.mIPStr = new String[1];
            this.mResolver.mIPStr[0] = hostAddress;
            HostInfo hostInfo = new HostInfo();
            hostInfo.time = System.currentTimeMillis();
            hostInfo.ip = hostAddress;
            AVResolver.putHostInfo(this.mHostName, hostInfo);
            hostInfo.time = System.currentTimeMillis();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static synchronized void putHostInfo(String str, HostInfo hostInfo) {
        String str2;
        long jCurrentTimeMillis = System.currentTimeMillis();
        Hashtable<String, HostInfo> hashtable = mCacheHosts;
        String key = null;
        if (hashtable.size() > 128) {
            Iterator<Map.Entry<String, HostInfo>> it = hashtable.entrySet().iterator();
            String str3 = null;
            while (it.hasNext()) {
                HostInfo value = it.next().getValue();
                key = it.next().getKey();
                if (value != 0 && value.time < jCurrentTimeMillis) {
                    jCurrentTimeMillis = value.time;
                    str3 = value;
                }
            }
            str2 = key;
            key = str3;
        } else {
            str2 = null;
        }
        if (key != null && str2 != null) {
            mCacheHosts.remove(str2);
        }
        mCacheHosts.put(str, hostInfo);
    }

    public static final boolean isIP(String str) {
        if (str.length() < 7 || str.length() > 15) {
            return str.charAt(0) == '[' && str.charAt(str.length() - 1) == ']';
        }
        return Pattern.compile("([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}").matcher(str).find();
    }
}
