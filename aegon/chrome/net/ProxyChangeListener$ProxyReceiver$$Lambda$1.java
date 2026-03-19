package aegon.chrome.net;

import aegon.chrome.net.ProxyChangeListener;
import android.content.Intent;
import java.lang.reflect.InvocationTargetException;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
final /* synthetic */ class ProxyChangeListener$ProxyReceiver$$Lambda$1 implements Runnable {
    private final ProxyChangeListener.ProxyReceiver arg$1;
    private final Intent arg$2;

    private ProxyChangeListener$ProxyReceiver$$Lambda$1(ProxyChangeListener.ProxyReceiver proxyReceiver, Intent intent) {
        this.arg$1 = proxyReceiver;
        this.arg$2 = intent;
    }

    public static Runnable lambdaFactory$(ProxyChangeListener.ProxyReceiver proxyReceiver, Intent intent) {
        return new ProxyChangeListener$ProxyReceiver$$Lambda$1(proxyReceiver, intent);
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException, SecurityException, IllegalArgumentException, InvocationTargetException {
        ProxyChangeListener.ProxyReceiver.lambda$onReceive$0(this.arg$1, this.arg$2);
    }
}
