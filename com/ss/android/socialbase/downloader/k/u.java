package com.ss.android.socialbase.downloader.k;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.bytedance.sdk.component.utils.mq;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class u implements Handler.Callback {
    private volatile Handler d = new Handler(d.d, this);

    public interface hc {
        long d();
    }

    private static class d {
        private static final Looper d;

        static {
            HandlerThread handlerThread = new HandlerThread("DownloadWatchDog");
            handlerThread.start();
            d = handlerThread.getLooper();
        }
    }

    public static Looper d() {
        return d.d;
    }

    public void d(hc hcVar, long j) {
        Handler handler = this.d;
        if (handler == null) {
            return;
        }
        Message messageObtain = Message.obtain();
        messageObtain.what = 0;
        messageObtain.obj = hcVar;
        handler.sendMessageDelayed(messageObtain, j);
    }

    public void hc() {
        Handler handler = this.d;
        if (handler == null) {
            return;
        }
        this.d = null;
        handler.removeCallbacksAndMessages(null);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what != 0) {
            return true;
        }
        try {
            hc hcVar = (hc) message.obj;
            long jD = hcVar.d();
            if (jD <= 0) {
                return true;
            }
            d(hcVar, jD);
            return true;
        } catch (Throwable th) {
            mq.d(th);
            return true;
        }
    }
}
