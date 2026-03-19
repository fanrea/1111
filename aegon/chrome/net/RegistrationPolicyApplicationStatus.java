package aegon.chrome.net;

import aegon.chrome.base.ApplicationStatus;
import aegon.chrome.net.NetworkChangeNotifierAutoDetect;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class RegistrationPolicyApplicationStatus extends NetworkChangeNotifierAutoDetect.RegistrationPolicy implements ApplicationStatus.ApplicationStateListener {
    private boolean mDestroyed;

    @Override // aegon.chrome.net.NetworkChangeNotifierAutoDetect.RegistrationPolicy
    protected void init(NetworkChangeNotifierAutoDetect networkChangeNotifierAutoDetect) {
        super.init(networkChangeNotifierAutoDetect);
        ApplicationStatus.registerApplicationStateListener(this);
        onApplicationStateChange(getApplicationState());
    }

    @Override // aegon.chrome.net.NetworkChangeNotifierAutoDetect.RegistrationPolicy
    protected void destroy() {
        if (this.mDestroyed) {
            return;
        }
        ApplicationStatus.unregisterApplicationStateListener(this);
        this.mDestroyed = true;
    }

    @Override // aegon.chrome.base.ApplicationStatus.ApplicationStateListener
    public void onApplicationStateChange(int i) {
        if (i == 1) {
            register();
        } else if (i == 2) {
            unregister();
        }
    }

    int getApplicationState() {
        return ApplicationStatus.getStateForApplication();
    }
}
