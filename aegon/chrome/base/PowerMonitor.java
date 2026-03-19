package aegon.chrome.base;

import aegon.chrome.base.annotations.JNINamespace;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
@JNINamespace("base::android")
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class PowerMonitor {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static PowerMonitor sInstance;
    private boolean mIsBatteryPower;

    private static native void nativeOnBatteryChargingChanged();

    public static void createForTests() {
        sInstance = new PowerMonitor();
    }

    public static void create() {
        ThreadUtils.assertOnUiThread();
        if (sInstance != null) {
            return;
        }
        Context applicationContext = ContextUtils.getApplicationContext();
        sInstance = new PowerMonitor();
        Intent intentRegisterReceiver = applicationContext.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (intentRegisterReceiver != null) {
            onBatteryChargingChanged(intentRegisterReceiver);
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
        intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        applicationContext.registerReceiver(new BroadcastReceiver() { // from class: aegon.chrome.base.PowerMonitor.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                PowerMonitor.onBatteryChargingChanged(intent);
            }
        }, intentFilter);
    }

    private PowerMonitor() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void onBatteryChargingChanged(Intent intent) {
        int intExtra = intent.getIntExtra("plugged", -1);
        sInstance.mIsBatteryPower = (intExtra == 2 || intExtra == 1) ? false : true;
        nativeOnBatteryChargingChanged();
    }

    private static boolean isBatteryPower() {
        if (sInstance == null) {
            create();
        }
        return sInstance.mIsBatteryPower;
    }
}
