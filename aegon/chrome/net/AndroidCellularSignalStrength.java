package aegon.chrome.net;

import aegon.chrome.base.ApplicationStatus;
import aegon.chrome.base.ContextUtils;
import aegon.chrome.base.ThreadUtils;
import aegon.chrome.base.annotations.JNINamespace;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
@JNINamespace("net::android")
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class AndroidCellularSignalStrength {
    private static final AndroidCellularSignalStrength sInstance = new AndroidCellularSignalStrength();
    private volatile int mSignalLevel = Integer.MIN_VALUE;

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    class CellStateListener extends PhoneStateListener implements ApplicationStatus.ApplicationStateListener {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final TelephonyManager mTelephonyManager;

        CellStateListener() {
            ThreadUtils.assertOnBackgroundThread();
            TelephonyManager telephonyManager = (TelephonyManager) ContextUtils.getApplicationContext().getSystemService("phone");
            this.mTelephonyManager = telephonyManager;
            if (telephonyManager.getSimState() != 5) {
                return;
            }
            ApplicationStatus.registerApplicationStateListener(this);
            onApplicationStateChange(1);
        }

        private void register() {
            this.mTelephonyManager.listen(this, 256);
        }

        private void unregister() {
            AndroidCellularSignalStrength.this.mSignalLevel = Integer.MIN_VALUE;
            this.mTelephonyManager.listen(this, 0);
        }

        @Override // android.telephony.PhoneStateListener
        public void onSignalStrengthsChanged(SignalStrength signalStrength) {
            try {
                AndroidCellularSignalStrength.this.mSignalLevel = signalStrength.getLevel();
            } catch (SecurityException unused) {
                AndroidCellularSignalStrength.this.mSignalLevel = Integer.MIN_VALUE;
            }
        }

        @Override // aegon.chrome.base.ApplicationStatus.ApplicationStateListener
        public void onApplicationStateChange(int i) {
            if (i == 1) {
                register();
            } else if (i == 2) {
                unregister();
            }
        }
    }

    private AndroidCellularSignalStrength() {
        if (Build.VERSION.SDK_INT < 23) {
            return;
        }
        HandlerThread handlerThread = new HandlerThread("AndroidCellularSignalStrength");
        handlerThread.start();
        new Handler(handlerThread.getLooper()).post(new Runnable() { // from class: aegon.chrome.net.AndroidCellularSignalStrength.1
            @Override // java.lang.Runnable
            public void run() {
                AndroidCellularSignalStrength.this.new CellStateListener();
            }
        });
    }

    private static int getSignalStrengthLevel() {
        return sInstance.mSignalLevel;
    }
}
