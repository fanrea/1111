package com.ss.ttm.net;

import android.text.TextUtils;
import com.ss.ttm.player.AVThreadPool;
import com.ss.ttm.utils.AVLogger;
import java.net.InetAddress;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class AVResolver {
    public static int HOST_MAX_CACHE_TIME = 600000;
    private static final int MAX_CACHED = 128;
    private static final String TAG = "AVResolver";
    private static final Hashtable<String, HostInfo> mCacheHosts = new Hashtable<>();
    private HostInfo mHostInfo;
    private String mHostName;
    private String[] mIPStr;
    private boolean mRet = false;
    private Thread mThread = null;
    private String mError = null;

    public void getAddressInfo(String str) {
        this.mHostName = str;
        if (TextUtils.isEmpty(str)) {
            AVLogger.d(TAG, "getAddressInfo start.hostname is null:");
            this.mRet = true;
            return;
        }
        AVLogger.d(TAG, "getAddressInfo start.hostname:" + str);
        if (isIP(this.mHostName)) {
            AVLogger.d(TAG, "getAddressInfo is ip.ip:" + str);
            this.mIPStr = new String[]{this.mHostName};
            this.mRet = true;
            return;
        }
        Hashtable<String, HostInfo> hashtable = mCacheHosts;
        HostInfo hostInfo = hashtable.get(str);
        this.mHostInfo = hostInfo;
        if (hostInfo != null) {
            AVLogger.d(TAG, "getAddressInfo first find in cache.hostname:" + str);
            if (this.mHostInfo.ip != null && System.currentTimeMillis() - this.mHostInfo.time < HOST_MAX_CACHE_TIME) {
                this.mIPStr = new String[]{this.mHostInfo.ip};
                this.mRet = true;
                AVLogger.d(TAG, "getAddressInfo hit cached:ip:" + this.mHostInfo.ip + ",time:" + this.mHostInfo.time);
                return;
            } else {
                AVLogger.d(TAG, "getAddressInfo cache is to long.hostname:" + str);
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
        if (this.mRet && (strArr = this.mIPStr) != null && strArr[0] != null) {
            AVLogger.d(TAG, "getAddress return ip:" + this.mIPStr[0]);
            return this.mIPStr[0];
        }
        return "parser host name: " + this.mHostName + " error.err msg:" + this.mError;
    }

    public void freeAddress() {
        AVLogger.d(TAG, "free address ctx start");
        if (this.mThread != null) {
            AVLogger.d(TAG, "mthread not null");
            try {
                this.mThread.interrupt();
            } catch (Exception e) {
                e.printStackTrace();
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

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            String str;
            String str2;
            AVLogger.d(AVResolver.TAG, "start ParserHost task");
            String hostAddress = null;
            try {
                AVLogger.d(AVResolver.TAG, "getAddressInfo thread start");
                InetAddress byName = InetAddress.getByName(this.mHostName);
                try {
                    hostAddress = byName.getHostAddress();
                    AVLogger.d(AVResolver.TAG, "getAddressInfo thread ok");
                    str2 = byName;
                } catch (Throwable th) {
                    th = th;
                    str = hostAddress;
                    hostAddress = byName;
                    th.printStackTrace();
                    this.mResolver.mError = th.getMessage();
                    AVLogger.d(AVResolver.TAG, "getAddressInfo thread error");
                    String str3 = str;
                    str2 = hostAddress;
                    hostAddress = str3;
                    this.mResolver.mRet = true;
                    if (str2 != null) {
                        return;
                    } else {
                        return;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                str = null;
            }
            this.mResolver.mRet = true;
            if (str2 != null || hostAddress == null) {
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

    static synchronized void putHostInfo(String str, HostInfo hostInfo) {
        HostInfo hostInfo2;
        String str2;
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            Hashtable<String, HostInfo> hashtable = mCacheHosts;
            hostInfo2 = null;
            String key = null;
            if (hashtable.size() > 128) {
                Iterator<Map.Entry<String, HostInfo>> it = hashtable.entrySet().iterator();
                HostInfo hostInfo3 = null;
                while (it.hasNext()) {
                    HostInfo value = it.next().getValue();
                    key = it.next().getKey();
                    if (value != null && value.time < jCurrentTimeMillis) {
                        jCurrentTimeMillis = value.time;
                        hostInfo3 = value;
                    }
                }
                str2 = key;
                hostInfo2 = hostInfo3;
            } else {
                str2 = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            AVLogger.d(TAG, "putHostInfo remove host cache error");
        }
        if (hostInfo2 != null && str2 != null) {
            AVLogger.d(TAG, "putHostInfo remove host cache" + hostInfo2.ip);
            mCacheHosts.remove(str2);
            mCacheHosts.put(str, hostInfo);
        } else {
            mCacheHosts.put(str, hostInfo);
        }
    }

    public static final boolean isIP(String str) {
        if (str.length() < 7 || str.length() > 15) {
            return str.charAt(0) == '[' && str.charAt(str.length() - 1) == ']';
        }
        return Pattern.compile("([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}").matcher(str).find();
    }
}
