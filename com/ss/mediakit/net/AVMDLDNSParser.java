package com.ss.mediakit.net;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.alipay.sdk.m.u.b;
import com.ss.mediakit.medialoader.AVMDLDataLoader;
import com.ss.mediakit.medialoader.AVMDLLog;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class AVMDLDNSParser {
    public static final int AVMDL_DNS_BACKUP_TYPE = 1;
    public static final int AVMDL_DNS_DEFAULT_EXPIRED_TIME = 2;
    public static final int AVMDL_DNS_DISABLE_PARALLEL_FOR_EXPIRED_CACHE = 11;
    public static final int AVMDL_DNS_ENABLE_BACKUP_IP = 5;
    public static final int AVMDL_DNS_ENABLE_DNS_LOG = 7;
    public static final int AVMDL_DNS_ENABLE_PARALLEL = 4;
    public static final int AVMDL_DNS_ENABLE_REFRESH = 6;
    public static final int AVMDL_DNS_FORCE_EXPIRED_TIME = 10;
    public static final int AVMDL_DNS_GOOGLE_PARSE_HOST = 9;
    public static final int AVMDL_DNS_MAIN_DELAYED_USE_BACKUP_FOR_EXPIRED_CACHE_TIME = 12;
    public static final int AVMDL_DNS_MAIN_DELAYED_USE_BACKUP_TIME = 3;
    public static final int AVMDL_DNS_MAIN_TYPE = 0;
    public static final int AVMDL_DNS_OWN_PARSE_HOST = 8;
    public static final int DNS_TYPE_BACKUP_IP = 11;
    public static final int DNS_TYPE_HTTP_ALI = 1;
    public static final int DNS_TYPE_HTTP_CUSTOM = 4;
    public static final int DNS_TYPE_HTTP_GOOGLE = 3;
    public static final int DNS_TYPE_HTTP_OWN = 2;
    public static final int DNS_TYPE_HTTP_SERVER = 10;
    public static final int DNS_TYPE_LOCAL = 0;
    public static final int PARSER_IS_BACKUP = 1;
    public static final int PARSER_IS_MAIN = 0;
    private static final String TAG = "AVMDLDNSParser";
    public static AVMDLCustomHTTPDNSParser mCustomHttpDNSParser = null;
    public static int mGloabalDisableParallelForExpiredCache = 0;
    public static int mGlobalBackType = 2;
    public static int mGlobalBackUpDelayedTime = 0;
    public static int mGlobalBackUpDelayedTimeForExpiredCache = 0;
    public static int mGlobalDefaultExpiredTime = 60;
    public static int mGlobalEnableBackUpIp = 0;
    public static int mGlobalEnableDNSLog = 0;
    public static int mGlobalEnableParallel = 0;
    public static int mGlobalEnableRefresh = 0;
    public static int mGlobalForceExpiredTime = 0;
    public static String mGlobalGoogleDNSParseHost = "";
    public static int mGlobalMainType = 0;
    public static String mGlobalOwnDNSParseHost = "";
    private static volatile AVMDLDNSParser mInstance;
    public static AVMDLNetClientMaker mNetClientMaker;
    private Handler mHandler;
    private int mRefCount;
    private int mState;
    private HandlerThread mThread;
    private int mType;
    private int mTimeOut = 5;
    private Lock mLock = new ReentrantLock();
    private Map<String, AVMDLHostProcessor> mProcessors = new HashMap();

    public void release() {
    }

    public static AVMDLDNSParser getInstance() {
        if (mInstance == null) {
            synchronized (AVMDLDNSParser.class) {
                if (mInstance == null) {
                    mInstance = new AVMDLDNSParser();
                }
            }
        }
        return mInstance;
    }

    public static void setIntValue(int i, int i2) {
        AVMDLLog.d(TAG, String.format(Locale.US, "****set value:%d for key:%d", Integer.valueOf(i2), Integer.valueOf(i)));
        synchronized (AVMDLDNSParser.class) {
            switch (i) {
                case 0:
                    mGlobalMainType = i2;
                    break;
                case 1:
                    mGlobalBackType = i2;
                    break;
                case 2:
                    mGlobalDefaultExpiredTime = i2;
                    break;
                case 3:
                    mGlobalBackUpDelayedTime = i2;
                    break;
                case 4:
                    mGlobalEnableParallel = i2;
                    break;
                case 5:
                    mGlobalEnableBackUpIp = i2;
                    break;
                case 6:
                    mGlobalEnableRefresh = i2;
                    break;
                case 7:
                    mGlobalEnableDNSLog = i2;
                    break;
                case 10:
                    mGlobalForceExpiredTime = i2;
                    break;
                case 11:
                    mGloabalDisableParallelForExpiredCache = i2;
                    break;
                case 12:
                    mGlobalBackUpDelayedTimeForExpiredCache = i2;
                    break;
            }
        }
    }

    public static int getIntValue(int i) {
        int i2;
        AVMDLLog.d(TAG, String.format(Locale.US, "----get value for key:%d", Integer.valueOf(i)));
        synchronized (AVMDLDNSParser.class) {
            switch (i) {
                case 0:
                    i2 = mGlobalMainType;
                    break;
                case 1:
                    i2 = mGlobalBackType;
                    break;
                case 2:
                    i2 = mGlobalDefaultExpiredTime;
                    break;
                case 3:
                    i2 = mGlobalBackUpDelayedTime;
                    break;
                case 4:
                    i2 = mGlobalEnableParallel;
                    break;
                case 5:
                    i2 = mGlobalEnableBackUpIp;
                    break;
                case 6:
                    i2 = mGlobalEnableRefresh;
                    break;
                case 7:
                    i2 = mGlobalEnableDNSLog;
                    break;
                case 8:
                case 9:
                default:
                    i2 = Integer.MIN_VALUE;
                    break;
                case 10:
                    i2 = mGlobalForceExpiredTime;
                    break;
                case 11:
                    i2 = mGloabalDisableParallelForExpiredCache;
                    break;
                case 12:
                    i2 = mGlobalBackUpDelayedTimeForExpiredCache;
                    break;
            }
        }
        AVMDLLog.d(TAG, String.format(Locale.US, "****get value:%d for key:%d", Integer.valueOf(i2), Integer.valueOf(i)));
        return i2;
    }

    public static void setStringValue(int i, String str) {
        AVMDLLog.d(TAG, String.format(Locale.US, "****set value:%s for key:%d", str, Integer.valueOf(i)));
        synchronized (AVMDLDNSParser.class) {
            if (i == 8) {
                if (!TextUtils.isEmpty(str)) {
                    mGlobalOwnDNSParseHost = str;
                }
            } else if (i == 9 && !TextUtils.isEmpty(str)) {
                mGlobalGoogleDNSParseHost = str;
            }
        }
    }

    public static void processHijack() {
        AVMDLLog.d(TAG, String.format(Locale.US, "----process hijack old dnsmain:%d back:%d", Integer.valueOf(mGlobalMainType), Integer.valueOf(mGlobalBackType)));
        int i = mGlobalMainType;
        if (i == 0) {
            mGlobalMainType = mGlobalBackType;
            mGlobalBackType = i;
        }
        AVMDLLog.d(TAG, String.format(Locale.US, "****process hijack new dnsmain:%d back:%d", Integer.valueOf(mGlobalMainType), Integer.valueOf(mGlobalBackType)));
    }

    public static void updateDNSInfo(String str, String str2, long j) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            AVMDLLog.d(TAG, "ip direct info invalid");
            return;
        }
        AVMDLDNSInfo aVMDLDNSInfo = new AVMDLDNSInfo(10, str, str2, (j + mGlobalDefaultExpiredTime) * 1000, (String) null);
        AVMDLLog.d(TAG, "server iplist, host = " + str + " type = 10 iplist = " + str2);
        IPCache.getInstance().put(str, aVMDLDNSInfo);
    }

    public AVMDLDNSParser() {
        HandlerThread handlerThread = new HandlerThread(TAG);
        this.mThread = handlerThread;
        handlerThread.start();
        this.mHandler = new Handler(this.mThread.getLooper()) { // from class: com.ss.mediakit.net.AVMDLDNSParser.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                AVMDLDNSInfo aVMDLDNSInfo = message.obj != null ? (AVMDLDNSInfo) message.obj : null;
                AVMDLLog.d(AVMDLDNSParser.TAG, String.format(Locale.US, "----receive msg what:%d info:%s", Integer.valueOf(message.what), aVMDLDNSInfo));
                int i = message.what;
                if (i == 2) {
                    AVMDLDNSParser.this.proccessFailMsg(message.what, aVMDLDNSInfo);
                } else if (i == 3) {
                    AVMDLDNSParser.this.proccessSucMsg(message.what, aVMDLDNSInfo);
                } else if (i == 4) {
                    AVMDLDNSParser.this.proccessPreParseMsg(message.what, aVMDLDNSInfo);
                } else if (i == 6) {
                    AVMDLDNSParser.this.processBackupParseMsg(message.what, aVMDLDNSInfo);
                } else if (i == 7) {
                    AVMDLDNSParser.this.processBatchParseMsg(message.what, aVMDLDNSInfo);
                } else if (i == 8) {
                    AVMDLDNSParser.this.processDNSTypeChangedParseMsg(message.what, aVMDLDNSInfo);
                }
                AVMDLLog.d(AVMDLDNSParser.TAG, String.format(Locale.US, "****end proc msg what:%d info:%s", Integer.valueOf(message.what), aVMDLDNSInfo));
            }
        };
    }

    public static void setClientMaker(AVMDLNetClientMaker aVMDLNetClientMaker) {
        synchronized (AVMDLDNSParser.class) {
            if (aVMDLNetClientMaker != null) {
                mNetClientMaker = aVMDLNetClientMaker;
            }
        }
    }

    public static void setCustomHttpDNSParser(AVMDLCustomHTTPDNSParser aVMDLCustomHTTPDNSParser) {
        synchronized (AVMDLDNSParser.class) {
            Locale locale = Locale.US;
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(aVMDLCustomHTTPDNSParser == null ? 0 : 1);
            AVMDLLog.d(TAG, String.format(locale, "set custom http dns parser:%d", objArr));
            if (aVMDLCustomHTTPDNSParser != null) {
                mCustomHttpDNSParser = aVMDLCustomHTTPDNSParser;
            }
        }
    }

    public static AVMDLNetClient getNetClient() {
        AVMDLNetClient netClient;
        synchronized (AVMDLDNSParser.class) {
            AVMDLNetClientMaker aVMDLNetClientMaker = mNetClientMaker;
            netClient = aVMDLNetClientMaker != null ? aVMDLNetClientMaker.getNetClient() : null;
        }
        return netClient == null ? new AVMDLHTTPNetwork() : netClient;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processBackupParseMsg(int i, AVMDLDNSInfo aVMDLDNSInfo) {
        if (aVMDLDNSInfo == null || aVMDLDNSInfo.mHost == null) {
            AVMDLLog.d(TAG, String.format(Locale.US, "proc parser msg  fail, info or host is null", new Object[0]));
            return;
        }
        AVMDLLog.d(TAG, String.format(Locale.US, "----proc parser msg what:%d host:%s", Integer.valueOf(i), aVMDLDNSInfo.mHost));
        this.mLock.lock();
        try {
            AVMDLHostProcessor aVMDLHostProcessor = this.mProcessors.get(aVMDLDNSInfo.mHost);
            if (aVMDLHostProcessor != null) {
                AVMDLLog.d(TAG, String.format(Locale.US, "----get processor:%s host:%s", aVMDLHostProcessor, aVMDLDNSInfo.mHost));
                aVMDLHostProcessor.processMsg(i, aVMDLDNSInfo);
            } else {
                AVMDLLog.d(TAG, String.format(Locale.US, "****get processor null for host:%s", aVMDLDNSInfo.mHost));
            }
            this.mLock.unlock();
            AVMDLLog.d(TAG, String.format(Locale.US, "****end proc parser msg", new Object[0]));
        } catch (Throwable th) {
            this.mLock.unlock();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processBatchParseMsg(int i, AVMDLDNSInfo aVMDLDNSInfo) {
        if (aVMDLDNSInfo == null || aVMDLDNSInfo.mHosts == null || aVMDLDNSInfo.mHosts.length == 0) {
            AVMDLLog.d(TAG, String.format(Locale.US, "proc parser msg  fail, info or host is null", new Object[0]));
            return;
        }
        AVMDLLog.d(TAG, String.format(Locale.US, "----proc batch parse msg what:%d", Integer.valueOf(i)));
        if (mGlobalEnableParallel > 0 || mGlobalMainType == 2) {
            try {
                new HTTPDNSHosts(aVMDLDNSInfo.mHosts, null, 2, this.mHandler).start();
                return;
            } catch (Exception e) {
                AVMDLLog.d(TAG, String.format(Locale.US, "parse end create httpdnshosts fail" + e, new Object[0]));
                return;
            }
        }
        new LocalDNSHosts(aVMDLDNSInfo.mHosts, this.mHandler).start();
        AVMDLLog.d(TAG, String.format(Locale.US, "****end proc batch parser msg", new Object[0]));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void proccessSucMsg(int i, AVMDLDNSInfo aVMDLDNSInfo) {
        if (aVMDLDNSInfo == null || aVMDLDNSInfo.mHost == null) {
            AVMDLLog.d(TAG, String.format(Locale.US, "proc suc msg  fail, info or host is null", new Object[0]));
            return;
        }
        AVMDLLog.d(TAG, String.format(Locale.US, "----proc suc msg what:%d host:%s", Integer.valueOf(i), aVMDLDNSInfo.mHost));
        this.mLock.lock();
        try {
            AVMDLHostProcessor aVMDLHostProcessor = this.mProcessors.get(aVMDLDNSInfo.mHost);
            AVMDLLog.d(TAG, String.format(Locale.US, "get processor:%s host:%s", aVMDLHostProcessor, aVMDLDNSInfo.mHost));
            if (aVMDLHostProcessor != null && aVMDLHostProcessor.mListeners != null) {
                for (AVMDLDNSParserListener aVMDLDNSParserListener : aVMDLHostProcessor.mListeners.keySet()) {
                    if (aVMDLDNSParserListener != null) {
                        AVMDLLog.d(TAG, String.format(Locale.US, "listener:%s oncompletion suc", aVMDLDNSParserListener));
                        aVMDLDNSParserListener.onCompletion(0, aVMDLDNSInfo.mHost, aVMDLDNSInfo.mIpList, aVMDLDNSInfo.mExpiredTime, null, aVMDLDNSInfo.mType);
                    }
                }
                aVMDLHostProcessor.mListeners.clear();
                this.mProcessors.remove(aVMDLDNSInfo.mHost);
                AVMDLLog.d(TAG, String.format(Locale.US, "remove all listeners and remove host", new Object[0]));
            }
            sendPreParseMsg(aVMDLDNSInfo.mHost, aVMDLDNSInfo.mExpiredTime - System.currentTimeMillis());
            reportLog(aVMDLDNSInfo);
            this.mLock.unlock();
            AVMDLLog.d(TAG, String.format(Locale.US, "****end proc suc msg", new Object[0]));
        } catch (Throwable th) {
            this.mLock.unlock();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processDNSTypeChangedParseMsg(int i, AVMDLDNSInfo aVMDLDNSInfo) {
        if (aVMDLDNSInfo == null || aVMDLDNSInfo.mHost == null) {
            AVMDLLog.d(TAG, String.format(Locale.US, "proc main parse msg  fail, info or host is null", new Object[0]));
            return;
        }
        AVMDLLog.d(TAG, String.format(Locale.US, "----proc dnstype change parse msg what:%d host:%s", Integer.valueOf(i), aVMDLDNSInfo.mHost));
        this.mLock.lock();
        try {
            getInstance().addHost(aVMDLDNSInfo.mHost, null, aVMDLDNSInfo.mType);
            this.mLock.unlock();
            AVMDLLog.d(TAG, String.format(Locale.US, "****end proc main parse msg", new Object[0]));
        } catch (Throwable th) {
            this.mLock.unlock();
            throw th;
        }
    }

    private void reportLog(AVMDLDNSInfo aVMDLDNSInfo) throws JSONException {
        if (aVMDLDNSInfo == null || TextUtils.isEmpty(aVMDLDNSInfo.mIpList) || mGlobalEnableDNSLog <= 0) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("log_type", "mdl_dns_log");
            jSONObject.put("dns_type", aVMDLDNSInfo.mType);
            jSONObject.put("ip_list", aVMDLDNSInfo.mIpList);
            AVMDLDataLoader.getInstance().onLogInfo(15, 0, jSONObject.toString());
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void proccessPreParseMsg(int i, AVMDLDNSInfo aVMDLDNSInfo) {
        if (mGlobalEnableRefresh <= 0) {
            AVMDLLog.d(TAG, "not support preparse");
            return;
        }
        if (aVMDLDNSInfo == null || aVMDLDNSInfo.mHost == null) {
            AVMDLLog.d(TAG, String.format(Locale.US, "proc pre msg  fail, info or host is null", new Object[0]));
            return;
        }
        AVMDLLog.d(TAG, String.format(Locale.US, "----proc pre parse msg what:%d host:%s", Integer.valueOf(i), aVMDLDNSInfo.mHost));
        AVMDLDNSInfo aVMDLDNSInfo2 = IPCache.getInstance().get(aVMDLDNSInfo.mHost);
        long jCurrentTimeMillis = System.currentTimeMillis();
        Locale locale = Locale.US;
        Object[] objArr = new Object[2];
        objArr[0] = aVMDLDNSInfo2;
        objArr[1] = Long.valueOf(aVMDLDNSInfo2 == null ? -1L : aVMDLDNSInfo2.mExpiredTime);
        AVMDLLog.d(TAG, String.format(locale, "cache:%s expiredT:%d", objArr));
        if (aVMDLDNSInfo2 == null || aVMDLDNSInfo2.mExpiredTime < jCurrentTimeMillis) {
            AVMDLLog.d(TAG, "add host for preparse");
            addListenerInternal(aVMDLDNSInfo.mHost, null, aVMDLDNSInfo.mType);
        }
        AVMDLLog.d(TAG, "****proc pre parse msg what:%d host:%s");
    }

    private void sendPreParseMsg(String str, long j) {
        if (TextUtils.isEmpty(str) || j <= 0) {
            AVMDLLog.d(TAG, "host is null or delayTimeMs invalid,not support preparse");
            return;
        }
        if (mGlobalEnableRefresh > 0) {
            AVMDLDNSInfo aVMDLDNSInfo = new AVMDLDNSInfo(mGlobalMainType, str, (String) null, 0L, (String) null);
            Message message = new Message();
            message.obj = aVMDLDNSInfo;
            message.what = 4;
            message.obj = aVMDLDNSInfo;
            Locale locale = Locale.US;
            long j2 = j + b.a;
            AVMDLLog.d(TAG, String.format(locale, "send preparse for host:%s delayTime:%d", aVMDLDNSInfo.mHost, Long.valueOf(j2)));
            this.mHandler.sendMessageDelayed(message, j2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void proccessFailMsg(int i, AVMDLDNSInfo aVMDLDNSInfo) {
        if (aVMDLDNSInfo == null || aVMDLDNSInfo.mHost == null) {
            AVMDLLog.d(TAG, String.format(Locale.US, "proc fail msg  fail, info or host is null", new Object[0]));
            return;
        }
        AVMDLLog.d(TAG, String.format(Locale.US, "----proc fail msg what:%d host:%s", Integer.valueOf(i), aVMDLDNSInfo.mHost));
        this.mLock.lock();
        try {
            AVMDLHostProcessor aVMDLHostProcessor = this.mProcessors.get(aVMDLDNSInfo.mHost);
            AVMDLLog.d(TAG, String.format(Locale.US, "get processor:%s host:%s", aVMDLHostProcessor, aVMDLDNSInfo.mHost));
            if (aVMDLHostProcessor != null && aVMDLHostProcessor.isValidSourceId(aVMDLDNSInfo.mId)) {
                aVMDLHostProcessor.processResult(i, aVMDLDNSInfo);
                if (aVMDLHostProcessor.isEnd()) {
                    AVMDLLog.d(TAG, String.format(Locale.US, "processor end, notify result", new Object[0]));
                    for (AVMDLDNSParserListener aVMDLDNSParserListener : aVMDLHostProcessor.mListeners.keySet()) {
                        if (aVMDLDNSParserListener != null) {
                            AVMDLLog.d(TAG, String.format(Locale.US, "listener:%s oncompletion fail", aVMDLDNSParserListener));
                            aVMDLDNSParserListener.onCompletion(0, aVMDLDNSInfo.mHost, null, 0L, null, aVMDLDNSInfo.mType);
                        }
                    }
                    aVMDLHostProcessor.mListeners.clear();
                    this.mProcessors.remove(aVMDLDNSInfo.mHost);
                } else {
                    AVMDLLog.d(TAG, String.format(Locale.US, "processor is not end", new Object[0]));
                }
            }
            this.mLock.unlock();
            AVMDLLog.d(TAG, String.format(Locale.US, "****end proc fail msg what", new Object[0]));
        } catch (Throwable th) {
            this.mLock.unlock();
            throw th;
        }
    }

    public void addHost(String str, AVMDLDNSParserListener aVMDLDNSParserListener, int i) {
        addListenerInternal(str, aVMDLDNSParserListener, i);
    }

    public void removeHost(String str, AVMDLDNSParserListener aVMDLDNSParserListener) {
        removeListenerInternal(str, aVMDLDNSParserListener);
    }

    public void postParseHostMsg(String str, int i) {
        AVMDLDNSInfo aVMDLDNSInfo = new AVMDLDNSInfo(i, str, (String) null, 0L, (String) null);
        Message message = new Message();
        message.what = 5;
        message.obj = aVMDLDNSInfo;
        this.mHandler.sendMessage(message);
    }

    public void postDNSInfoRefreshMsg(String str, int i) {
        AVMDLDNSInfo aVMDLDNSInfo = new AVMDLDNSInfo(i, str, (String) null, 0L, (String) null);
        Message message = new Message();
        message.what = 8;
        message.obj = aVMDLDNSInfo;
        this.mHandler.sendMessage(message);
    }

    public void doParseHosts(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            AVMDLLog.d(TAG, "hosts is null, not need do batch host parse");
            return;
        }
        int length = strArr.length;
        for (int i = 0; i < strArr.length; i++) {
            if (!TextUtils.isEmpty(strArr[i])) {
                if (IPCache.getInstance().get(strArr[i]) != null) {
                    AVMDLLog.d(TAG, String.format(Locale.US, "for host:%s has dns info not need do batch parse", strArr[i]));
                    strArr[i] = null;
                    length--;
                } else {
                    this.mLock.lock();
                    try {
                        if (this.mProcessors.get(strArr[i]) != null) {
                            AVMDLLog.d(TAG, String.format(Locale.US, "for host:%s has processor not need do batch parse", strArr[i]));
                            strArr[i] = null;
                            length--;
                        }
                    } finally {
                        this.mLock.unlock();
                    }
                }
            }
        }
        if (length == 0) {
            AVMDLLog.d(TAG, "has no hosts need do batch parse");
        } else {
            sendBatchParseMsg(strArr);
        }
    }

    public void setBackUpIP(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        IPCache.getInstance().putBackUpIp(str, new AVMDLDNSInfo(11, str, str2, 0L, (String) null));
    }

    private void sendBatchParseMsg(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            AVMDLLog.d(TAG, "hosts null not need do batch parse");
            return;
        }
        AVMDLDNSInfo aVMDLDNSInfo = new AVMDLDNSInfo(mGlobalMainType, strArr, (String) null, 0L, (String) null);
        Message message = new Message();
        message.what = 7;
        message.obj = aVMDLDNSInfo;
        AVMDLLog.d(TAG, String.format(Locale.US, "send msg for batch parse", new Object[0]));
        this.mHandler.sendMessage(message);
    }

    private void addListenerInternal(String str, AVMDLDNSParserListener aVMDLDNSParserListener, int i) {
        int i2;
        AVMDLHostProcessor aVMDLHostProcessor;
        boolean z;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        AVMDLLog.d(TAG, String.format(Locale.US, "---add listener:%s for host:%s dnstype:%d", aVMDLDNSParserListener, str, Integer.valueOf(i)));
        this.mLock.lock();
        try {
            AVMDLHostProcessor aVMDLHostProcessor2 = this.mProcessors.get(str);
            AVMDLLog.d(TAG, String.format(Locale.US, "get processor:%s", aVMDLHostProcessor2));
            int i3 = mGlobalMainType;
            int i4 = mGlobalBackType;
            if (i == 2 || i == 3) {
                i2 = i;
                i4 = 0;
            } else {
                i2 = i3;
            }
            AVMDLLog.d(TAG, String.format(Locale.US, "mainType:%d backType:%d", Integer.valueOf(i2), Integer.valueOf(i4)));
            if (aVMDLHostProcessor2 == null) {
                aVMDLHostProcessor = new AVMDLHostProcessor(str, this.mHandler, i2, i4, mGlobalBackUpDelayedTime, mGlobalEnableParallel, mGlobalBackUpDelayedTimeForExpiredCache);
                AVMDLLog.d(TAG, String.format(Locale.US, "create processor:%s", aVMDLHostProcessor));
                z = true;
            } else {
                aVMDLHostProcessor = aVMDLHostProcessor2;
                z = false;
            }
            if (aVMDLDNSParserListener != null && !aVMDLHostProcessor.mListeners.containsKey(aVMDLDNSParserListener)) {
                AVMDLLog.d(TAG, String.format(Locale.US, "add listener", new Object[0]));
                aVMDLHostProcessor.mListeners.put(aVMDLDNSParserListener, 1);
            }
            this.mProcessors.put(str, aVMDLHostProcessor);
            if (z) {
                AVMDLLog.d(TAG, String.format(Locale.US, "new processor implement parse", new Object[0]));
                AVMDLDNSInfo aVMDLDNSInfo = new AVMDLDNSInfo(i2, str, (String) null, 0L, (String) null);
                if (mGloabalDisableParallelForExpiredCache > 0 && aVMDLDNSParserListener == null) {
                    aVMDLHostProcessor.processMsg(9, aVMDLDNSInfo);
                } else {
                    aVMDLHostProcessor.processMsg(5, aVMDLDNSInfo);
                }
            }
            this.mLock.unlock();
            AVMDLLog.d(TAG, String.format(Locale.US, "****end add listener", new Object[0]));
        } catch (Throwable th) {
            this.mLock.unlock();
            throw th;
        }
    }

    private void removeListenerInternal(String str, AVMDLDNSParserListener aVMDLDNSParserListener) {
        if (TextUtils.isEmpty(str) || aVMDLDNSParserListener == null) {
            return;
        }
        AVMDLLog.d(TAG, String.format(Locale.US, "---remove listener:%s for host:%s", aVMDLDNSParserListener, str));
        this.mLock.lock();
        try {
            AVMDLHostProcessor aVMDLHostProcessor = this.mProcessors.get(str);
            AVMDLLog.d(TAG, String.format(Locale.US, "get processor:%s", aVMDLHostProcessor));
            if (aVMDLHostProcessor != null) {
                AVMDLLog.d(TAG, String.format(Locale.US, "remove listener", new Object[0]));
                aVMDLHostProcessor.mListeners.remove(aVMDLDNSParserListener);
            }
            if (aVMDLHostProcessor != null && aVMDLHostProcessor.mListeners.size() == 0) {
                AVMDLLog.d(TAG, String.format(Locale.US, "listeners empty for processors", new Object[0]));
            }
            this.mLock.unlock();
            AVMDLLog.d(TAG, String.format(Locale.US, "****end remove listener", new Object[0]));
        } catch (Throwable th) {
            this.mLock.unlock();
            throw th;
        }
    }
}
