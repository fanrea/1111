package com.ss.mediakit.net;

import android.os.Handler;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.ss.mediakit.medialoader.AVMDLLog;
import java.lang.ref.WeakReference;
import java.net.InetAddress;
import java.util.Locale;
import java.util.concurrent.Future;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class CustomHTTPDNS extends BaseDNS {
    private static final String TAG = "CustomHTTPDNS";
    private static final int TIME_OUT = 10000;
    private InetAddress[] mAddress;
    private Future mFuture;
    private boolean mRet;

    public CustomHTTPDNS(String str, Handler handler) {
        super(str, handler);
        this.mRet = false;
    }

    @Override // com.ss.mediakit.net.BaseDNS
    public void start() {
        try {
            this.mFuture = AVMDLThreadPool.addExecuteTask(new Runnable() { // from class: com.ss.mediakit.net.CustomHTTPDNS.1
                @Override // java.lang.Runnable
                public void run() {
                    Locale locale = Locale.US;
                    Object[] objArr = new Object[2];
                    objArr[0] = CustomHTTPDNS.this.mHostname;
                    objArr[1] = Integer.valueOf(AVMDLDNSParser.mCustomHttpDNSParser == null ? 0 : 1);
                    AVMDLLog.d(CustomHTTPDNS.TAG, String.format(locale, "----call custom httpdns, host:%s custom parser:%d", objArr));
                    AVMDLCustomHTTPDNSParserResult host = AVMDLDNSParser.mCustomHttpDNSParser != null ? AVMDLDNSParser.mCustomHttpDNSParser.parseHost(CustomHTTPDNS.this.mHostname) : null;
                    CustomHTTPDNS.this.mRet = true;
                    if (host == null || TextUtils.isEmpty(host.mIPList)) {
                        AVMDLLog.d(CustomHTTPDNS.TAG, String.format(Locale.US, "****end call custom httpdns, result null or iplist null host:%s", CustomHTTPDNS.this.mHostname));
                        CustomHTTPDNS.this.notifyError(new AVMDLDNSInfo(4, CustomHTTPDNS.this.mHostname, (String) null, 0L, CustomHTTPDNS.this.mId));
                        return;
                    }
                    AVMDLLog.d(CustomHTTPDNS.TAG, String.format(Locale.US, "****default expiredtime:%d force expiredtime:%d ", Integer.valueOf(AVMDLDNSParser.mGlobalDefaultExpiredTime), Integer.valueOf(AVMDLDNSParser.mGlobalForceExpiredTime)));
                    AVMDLDNSInfo aVMDLDNSInfo = new AVMDLDNSInfo(4, CustomHTTPDNS.this.mHostname, host.mIPList, System.currentTimeMillis() + ((AVMDLDNSParser.mGlobalForceExpiredTime > 0 ? AVMDLDNSParser.mGlobalForceExpiredTime : host.mTTL) * 1000), CustomHTTPDNS.this.mId);
                    IPCache.getInstance().put(CustomHTTPDNS.this.mHostname, aVMDLDNSInfo);
                    CustomHTTPDNS.this.notifySuccess(aVMDLDNSInfo);
                    AVMDLLog.d(CustomHTTPDNS.TAG, String.format(Locale.US, "****end call custom httpdns, suc iplist:%s host:%s", host.mIPList, CustomHTTPDNS.this.mHostname));
                }
            });
        } catch (Exception e) {
            AVMDLLog.d(TAG, String.format(Locale.US, "****end call custom httpdns, exception:%s host:%s", e, this.mHostname));
            notifyError(new AVMDLDNSInfo(4, this.mHostname, (String) null, 0L, this.mId));
        }
        this.mHandler.postDelayed(new MyRunnable(this), ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT);
    }

    private static class MyRunnable implements Runnable {
        private final WeakReference<CustomHTTPDNS> mCustomHTTPDNSRef;

        public MyRunnable(CustomHTTPDNS customHTTPDNS) {
            this.mCustomHTTPDNSRef = new WeakReference<>(customHTTPDNS);
        }

        @Override // java.lang.Runnable
        public void run() {
            AVMDLLog.d(CustomHTTPDNS.TAG, String.format(Locale.US, "----implement delayed check for custom httpdns", new Object[0]));
            CustomHTTPDNS customHTTPDNS = this.mCustomHTTPDNSRef.get();
            if (customHTTPDNS != null) {
                if (customHTTPDNS.mRet) {
                    return;
                }
                customHTTPDNS.cancel();
                AVMDLLog.d(CustomHTTPDNS.TAG, String.format(Locale.US, "****end implement delayed check cancel custom httpdns,", new Object[0]));
                customHTTPDNS.notifyError(new AVMDLDNSInfo(4, customHTTPDNS.mHostname, (String) null, 0L, customHTTPDNS.mId));
                return;
            }
            AVMDLLog.d(CustomHTTPDNS.TAG, String.format(Locale.US, "****end implement delayed check for custom httpdns, dns object null", new Object[0]));
        }
    }

    @Override // com.ss.mediakit.net.BaseDNS
    public void cancel() {
        if (this.mCancelled) {
            return;
        }
        this.mCancelled = true;
        Future future = this.mFuture;
        if (future != null) {
            future.cancel(true);
            this.mFuture = null;
        }
    }

    @Override // com.ss.mediakit.net.BaseDNS
    public void close() {
        super.close();
        Future future = this.mFuture;
        if (future != null) {
            future.cancel(true);
            this.mFuture = null;
        }
    }

    @Override // com.ss.mediakit.net.BaseDNS
    public boolean isRunning() {
        return this.mRet;
    }
}
