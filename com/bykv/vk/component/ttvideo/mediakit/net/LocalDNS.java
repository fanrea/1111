package com.bykv.vk.component.ttvideo.mediakit.net;

import android.os.Handler;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bytedance.sdk.component.utils.mq;
import java.lang.ref.WeakReference;
import java.net.InetAddress;
import java.util.concurrent.Future;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class LocalDNS extends BaseDNS {
    private static final String TAG = "LocalDNS";
    private static final int TIME_OUT = 10000;
    private InetAddress[] mAddress;
    private Future mFuture;
    private boolean mRet;

    public LocalDNS(String str, Handler handler) {
        super(str, handler);
        this.mRet = false;
    }

    @Override // com.bykv.vk.component.ttvideo.mediakit.net.BaseDNS
    public void start() {
        try {
            this.mFuture = AVMDLThreadPool.addExecuteTask(new Runnable() { // from class: com.bykv.vk.component.ttvideo.mediakit.net.LocalDNS.1
                @Override // java.lang.Runnable
                public void run() {
                    String.format("----call local dns, host:%s", LocalDNS.this.mHostname);
                    try {
                        LocalDNS localDNS = LocalDNS.this;
                        localDNS.mAddress = InetAddress.getAllByName(localDNS.mHostname);
                        LocalDNS.this.mRet = true;
                        if (LocalDNS.this.mAddress != null) {
                            String str = "";
                            for (int i = 0; i < LocalDNS.this.mAddress.length; i++) {
                                String hostAddress = LocalDNS.this.mAddress[i].getHostAddress();
                                if (!TextUtils.isEmpty(hostAddress)) {
                                    if (TextUtils.isEmpty(str)) {
                                        str = str + hostAddress;
                                    } else {
                                        str = str + "," + hostAddress;
                                    }
                                }
                            }
                            if (TextUtils.isEmpty(str)) {
                                String.format("****end call local dns, iplist null host:%s", LocalDNS.this.mHostname);
                                LocalDNS.this.notifyError(new AVMDLDNSInfo(0, LocalDNS.this.mHostname, (String) null, 0L, LocalDNS.this.mId));
                                return;
                            }
                            String.format("****default expiredtime:%d force expiredtime:%d ", Integer.valueOf(AVMDLDNSParser.mGlobalDefaultExpiredTime), Integer.valueOf(AVMDLDNSParser.mGlobalForceExpiredTime));
                            AVMDLDNSInfo aVMDLDNSInfo = new AVMDLDNSInfo(0, LocalDNS.this.mHostname, str, System.currentTimeMillis() + ((AVMDLDNSParser.mGlobalForceExpiredTime > 0 ? AVMDLDNSParser.mGlobalForceExpiredTime : AVMDLDNSParser.mGlobalDefaultExpiredTime) * 1000), LocalDNS.this.mId);
                            IPCache.getInstance().put(LocalDNS.this.mHostname, aVMDLDNSInfo);
                            LocalDNS.this.notifySuccess(aVMDLDNSInfo);
                            String.format("****end call local dns, suc iplist:%s host:%s", str, LocalDNS.this.mHostname);
                            return;
                        }
                        String.format("****end call local dns, not get address host:%s", LocalDNS.this.mHostname);
                        LocalDNS.this.notifyError(new AVMDLDNSInfo(0, LocalDNS.this.mHostname, (String) null, 0L, LocalDNS.this.mId));
                    } catch (Throwable th) {
                        mq.d(th);
                        LocalDNS.this.mRet = true;
                        String.format("****end call local dns, end exception:%s host:%s", th, LocalDNS.this.mHostname);
                        LocalDNS.this.notifyError(new AVMDLDNSInfo(0, LocalDNS.this.mHostname, (String) null, 0L, LocalDNS.this.mId));
                    }
                }
            });
        } catch (Exception e) {
            String.format("****end call local dns, exception:%s host:%s", e, this.mHostname);
            notifyError(new AVMDLDNSInfo(0, this.mHostname, (String) null, 0L, this.mId));
        }
        this.mHandler.postDelayed(new MyRunnable(this), ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT);
    }

    private static class MyRunnable implements Runnable {
        private final WeakReference<LocalDNS> mLocalDNSRef;

        public MyRunnable(LocalDNS localDNS) {
            this.mLocalDNSRef = new WeakReference<>(localDNS);
        }

        @Override // java.lang.Runnable
        public void run() {
            String.format("----implement delayed check for local dns", new Object[0]);
            LocalDNS localDNS = this.mLocalDNSRef.get();
            if (localDNS != null) {
                if (localDNS.mRet) {
                    return;
                }
                localDNS.cancel();
                String.format("****end implement delayed check cancel local dns,", new Object[0]);
                localDNS.notifyError(new AVMDLDNSInfo(0, localDNS.mHostname, (String) null, 0L, localDNS.mId));
                return;
            }
            String.format("****end implement delayed check for local dns, dns object null", new Object[0]);
        }
    }

    @Override // com.bykv.vk.component.ttvideo.mediakit.net.BaseDNS
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

    @Override // com.bykv.vk.component.ttvideo.mediakit.net.BaseDNS
    public void close() {
        super.close();
        Future future = this.mFuture;
        if (future != null) {
            future.cancel(true);
            this.mFuture = null;
        }
    }

    @Override // com.bykv.vk.component.ttvideo.mediakit.net.BaseDNS
    public boolean isRunning() {
        return this.mRet;
    }
}
