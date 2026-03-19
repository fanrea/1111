package aegon.chrome.net;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
final /* synthetic */ class ProxyChangeListener$$Lambda$1 implements Runnable {
    private final ProxyChangeListener arg$1;

    private ProxyChangeListener$$Lambda$1(ProxyChangeListener proxyChangeListener) {
        this.arg$1 = proxyChangeListener;
    }

    public static Runnable lambdaFactory$(ProxyChangeListener proxyChangeListener) {
        return new ProxyChangeListener$$Lambda$1(proxyChangeListener);
    }

    @Override // java.lang.Runnable
    public final void run() {
        ProxyChangeListener proxyChangeListener = this.arg$1;
        proxyChangeListener.proxySettingsChanged(proxyChangeListener.getProxyConfig());
    }
}
