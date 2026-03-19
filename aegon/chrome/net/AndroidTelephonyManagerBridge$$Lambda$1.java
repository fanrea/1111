package aegon.chrome.net;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
final /* synthetic */ class AndroidTelephonyManagerBridge$$Lambda$1 implements Runnable {
    private final AndroidTelephonyManagerBridge arg$1;

    private AndroidTelephonyManagerBridge$$Lambda$1(AndroidTelephonyManagerBridge androidTelephonyManagerBridge) {
        this.arg$1 = androidTelephonyManagerBridge;
    }

    public static Runnable lambdaFactory$(AndroidTelephonyManagerBridge androidTelephonyManagerBridge) {
        return new AndroidTelephonyManagerBridge$$Lambda$1(androidTelephonyManagerBridge);
    }

    @Override // java.lang.Runnable
    public final void run() {
        AndroidTelephonyManagerBridge.lambda$create$0(this.arg$1);
    }
}
