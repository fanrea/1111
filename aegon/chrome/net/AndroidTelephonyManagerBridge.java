package aegon.chrome.net;

import aegon.chrome.base.ContextUtils;
import aegon.chrome.base.ThreadUtils;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.TelephonyManager;
import javax.annotation.CheckForNull;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class AndroidTelephonyManagerBridge {
    private static volatile AndroidTelephonyManagerBridge sInstance;
    private Listener mListener;

    @CheckForNull
    private volatile String mNetworkCountryIso;

    @CheckForNull
    private volatile String mNetworkOperator;

    @CheckForNull
    private volatile String mSimOperator;

    private AndroidTelephonyManagerBridge() {
    }

    public String getNetworkCountryIso() {
        if (this.mNetworkCountryIso == null) {
            TelephonyManager telephonyManager = getTelephonyManager();
            if (telephonyManager == null) {
                return "";
            }
            this.mNetworkCountryIso = telephonyManager.getNetworkCountryIso();
        }
        return this.mNetworkCountryIso;
    }

    public String getNetworkOperator() {
        if (this.mNetworkOperator == null) {
            TelephonyManager telephonyManager = getTelephonyManager();
            if (telephonyManager == null) {
                return "";
            }
            this.mNetworkOperator = telephonyManager.getNetworkOperator();
        }
        return this.mNetworkOperator;
    }

    public String getSimOperator() {
        if (this.mSimOperator == null) {
            TelephonyManager telephonyManager = getTelephonyManager();
            if (telephonyManager == null) {
                return "";
            }
            this.mSimOperator = telephonyManager.getSimOperator();
        }
        return this.mSimOperator;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void update(@CheckForNull TelephonyManager telephonyManager) {
        if (telephonyManager == null) {
            return;
        }
        this.mNetworkCountryIso = telephonyManager.getNetworkCountryIso();
        this.mNetworkOperator = telephonyManager.getNetworkOperator();
        this.mSimOperator = telephonyManager.getSimOperator();
    }

    private void listenTelephonyServiceState(TelephonyManager telephonyManager) {
        ThreadUtils.assertOnUiThread();
        Listener listener = new Listener();
        this.mListener = listener;
        telephonyManager.listen(listener, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @CheckForNull
    public static TelephonyManager getTelephonyManager() {
        return (TelephonyManager) ContextUtils.getApplicationContext().getSystemService("phone");
    }

    private static AndroidTelephonyManagerBridge create() {
        AndroidTelephonyManagerBridge androidTelephonyManagerBridge = new AndroidTelephonyManagerBridge();
        ThreadUtils.runOnUiThread(AndroidTelephonyManagerBridge$$Lambda$1.lambdaFactory$(androidTelephonyManagerBridge));
        return androidTelephonyManagerBridge;
    }

    static /* synthetic */ void lambda$create$0(AndroidTelephonyManagerBridge androidTelephonyManagerBridge) {
        TelephonyManager telephonyManager = getTelephonyManager();
        if (telephonyManager != null) {
            androidTelephonyManagerBridge.listenTelephonyServiceState(telephonyManager);
        }
    }

    public static AndroidTelephonyManagerBridge getInstance() {
        AndroidTelephonyManagerBridge androidTelephonyManagerBridgeCreate = sInstance;
        if (androidTelephonyManagerBridgeCreate == null) {
            synchronized (AndroidTelephonyManagerBridge.class) {
                androidTelephonyManagerBridgeCreate = sInstance;
                if (androidTelephonyManagerBridgeCreate == null) {
                    androidTelephonyManagerBridgeCreate = create();
                    sInstance = androidTelephonyManagerBridgeCreate;
                }
            }
        }
        return androidTelephonyManagerBridgeCreate;
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    class Listener extends PhoneStateListener {

        @CheckForNull
        private ServiceState mServiceState;

        private Listener() {
        }

        @Override // android.telephony.PhoneStateListener
        public void onServiceStateChanged(ServiceState serviceState) {
            ServiceState serviceState2 = this.mServiceState;
            if (serviceState2 == null || !serviceState2.equals(serviceState)) {
                this.mServiceState = serviceState;
                AndroidTelephonyManagerBridge.this.update(AndroidTelephonyManagerBridge.getTelephonyManager());
            }
        }
    }
}
