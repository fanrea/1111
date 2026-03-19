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
public class LocalDNSHosts {
    private static final String TAG = "BatchParseLocalDNSHosts";
    private static final int TIME_OUT = 10000;
    private InetAddress[] mAddress;
    private Future mFuture;
    protected Handler mHandler;
    public String[] mHosts;
    public String mId;
    private boolean mRet = false;
    protected boolean mCancelled = false;
    protected AVMDLNetClient mNetClient = null;

    public LocalDNSHosts(String[] strArr, Handler handler) {
        this.mHosts = strArr;
        this.mHandler = handler;
    }

    public void start() {
        try {
            this.mFuture = AVMDLThreadPool.addExecuteTask(new Runnable() { // from class: com.ss.mediakit.net.LocalDNSHosts.1
                @Override // java.lang.Runnable
                public void run() {
                    String str;
                    AVMDLLog.d(LocalDNSHosts.TAG, "----call local dns batch parse");
                    for (int i = 0; i < LocalDNSHosts.this.mHosts.length; i++) {
                        if (!TextUtils.isEmpty(LocalDNSHosts.this.mHosts[i])) {
                            try {
                                LocalDNSHosts localDNSHosts = LocalDNSHosts.this;
                                localDNSHosts.mAddress = InetAddress.getAllByName(localDNSHosts.mHosts[i]);
                                String str2 = "";
                                for (int i2 = 0; i2 < LocalDNSHosts.this.mAddress.length; i2++) {
                                    String hostAddress = LocalDNSHosts.this.mAddress[i2].getHostAddress();
                                    if (!TextUtils.isEmpty(hostAddress)) {
                                        if (TextUtils.isEmpty(str2)) {
                                            str = str2 + hostAddress;
                                        } else {
                                            str = str2 + "," + hostAddress;
                                        }
                                        str2 = str;
                                    }
                                }
                                AVMDLLog.d(LocalDNSHosts.TAG, String.format(Locale.US, "host:%s pasrse suc result:%s", LocalDNSHosts.this.mHosts[i], str2));
                                if (!TextUtils.isEmpty(str2)) {
                                    AVMDLLog.d(LocalDNSHosts.TAG, String.format(Locale.US, "****default expiredtime:%d force expiredtime:%d ", Integer.valueOf(AVMDLDNSParser.mGlobalDefaultExpiredTime), Integer.valueOf(AVMDLDNSParser.mGlobalForceExpiredTime)));
                                    IPCache.getInstance().put(LocalDNSHosts.this.mHosts[i], new AVMDLDNSInfo(0, LocalDNSHosts.this.mHosts[i], str2, ((AVMDLDNSParser.mGlobalForceExpiredTime > 0 ? AVMDLDNSParser.mGlobalForceExpiredTime : AVMDLDNSParser.mGlobalDefaultExpiredTime) * 1000) + System.currentTimeMillis(), LocalDNSHosts.this.mId));
                                }
                            } catch (Throwable th) {
                                AVMDLLog.d(LocalDNSHosts.TAG, String.format(Locale.US, "host:%s pasrse err:%s", LocalDNSHosts.this.mHosts[i], th.getMessage()));
                            }
                        }
                    }
                    LocalDNSHosts.this.mRet = true;
                    AVMDLLog.d(LocalDNSHosts.TAG, "****end call local dns batch parse");
                }
            });
        } catch (Exception e) {
            AVMDLLog.d(TAG, String.format(Locale.US, "****end call local dns, exception:%s", e));
        }
        this.mHandler.postDelayed(new MyRunnable(this), ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT);
    }

    private static class MyRunnable implements Runnable {
        private final WeakReference<LocalDNSHosts> mLocalDNSRef;

        public MyRunnable(LocalDNSHosts localDNSHosts) {
            this.mLocalDNSRef = new WeakReference<>(localDNSHosts);
        }

        @Override // java.lang.Runnable
        public void run() {
            AVMDLLog.d(LocalDNSHosts.TAG, String.format(Locale.US, "----implement delayed check for local dns", new Object[0]));
            LocalDNSHosts localDNSHosts = this.mLocalDNSRef.get();
            if (localDNSHosts != null) {
                if (localDNSHosts.mRet) {
                    return;
                }
                localDNSHosts.cancel();
                AVMDLLog.d(LocalDNSHosts.TAG, String.format(Locale.US, "****end implement delayed check cancel local dns,", new Object[0]));
                return;
            }
            AVMDLLog.d(LocalDNSHosts.TAG, String.format(Locale.US, "****end implement delayed check for local dns, dns object null", new Object[0]));
        }
    }

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

    public void close() {
        Future future = this.mFuture;
        if (future != null) {
            future.cancel(true);
            this.mFuture = null;
        }
    }

    public boolean isRunning() {
        return this.mRet;
    }
}
