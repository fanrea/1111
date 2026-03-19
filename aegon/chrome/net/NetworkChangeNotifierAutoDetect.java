package aegon.chrome.net;

import aegon.chrome.base.ApplicationStatus;
import aegon.chrome.base.BuildConfig;
import aegon.chrome.base.ContextUtils;
import aegon.chrome.base.StrictModeContext;
import aegon.chrome.base.compat.ApiHelperForM;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.baidu.mobads.container.util.e.a;
import com.kuaishou.weapon.p0.g;
import java.io.IOException;
import java.net.Socket;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class NetworkChangeNotifierAutoDetect extends BroadcastReceiver {
    private static final String TAG = "NetworkChangeNotifierAutoDetect";
    private static final int UNKNOWN_LINK_SPEED = -1;
    private ConnectivityManagerDelegate mConnectivityManagerDelegate;
    private DefaultNetworkCallback mDefaultNetworkCallback;
    private final Handler mHandler;
    private boolean mIgnoreNextBroadcast;
    private final NetworkConnectivityIntentFilter mIntentFilter;
    private final Looper mLooper;
    private MyNetworkCallback mNetworkCallback;
    private NetworkRequest mNetworkRequest;
    private NetworkState mNetworkState;
    private final Observer mObserver;
    private boolean mRegisterNetworkCallbackFailed;
    private boolean mRegistered;
    private final RegistrationPolicy mRegistrationPolicy;
    private boolean mShouldSignalObserver;
    private WifiManagerDelegate mWifiManagerDelegate;

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    public interface Observer {
        void onConnectionSubtypeChanged(int i);

        void onConnectionTypeChanged(int i);

        void onNetworkConnect(long j, int i);

        void onNetworkDisconnect(long j);

        void onNetworkSoonToDisconnect(long j);

        void purgeActiveNetworkList(long[] jArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int convertToConnectionType(int i, int i2) {
        int i3 = 5;
        if (i == 0) {
            switch (i2) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                    return 3;
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                    return 4;
                case 13:
                    return 5;
                default:
                    return 0;
            }
        }
        if (i == 1) {
            return 2;
        }
        if (i != 6) {
            i3 = 7;
            if (i != 7) {
                return i != 9 ? 0 : 1;
            }
        }
        return i3;
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    public static class NetworkState {
        private final boolean mConnected;
        private final boolean mIsPrivateDnsActive;
        private final String mNetworkIdentifier;
        private final int mSubtype;
        private final int mType;

        public NetworkState(boolean z, int i, int i2, String str, boolean z2) {
            this.mConnected = z;
            this.mType = i;
            this.mSubtype = i2;
            this.mNetworkIdentifier = str == null ? "" : str;
            this.mIsPrivateDnsActive = z2;
        }

        public boolean isConnected() {
            return this.mConnected;
        }

        public int getNetworkType() {
            return this.mType;
        }

        public int getNetworkSubType() {
            return this.mSubtype;
        }

        public String getNetworkIdentifier() {
            return this.mNetworkIdentifier;
        }

        public int getConnectionType() {
            if (isConnected()) {
                return NetworkChangeNotifierAutoDetect.convertToConnectionType(getNetworkType(), getNetworkSubType());
            }
            return 6;
        }

        public int getConnectionSubtype() {
            if (!isConnected()) {
                return 1;
            }
            if (getNetworkType() != 0) {
                return 0;
            }
            switch (getNetworkSubType()) {
            }
            return 0;
        }

        public boolean isPrivateDnsActive() {
            return this.mIsPrivateDnsActive;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    static class ConnectivityManagerDelegate {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final ConnectivityManager mConnectivityManager;

        ConnectivityManagerDelegate(Context context) {
            this.mConnectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        }

        ConnectivityManagerDelegate() {
            this.mConnectivityManager = null;
        }

        private NetworkInfo processActiveNetworkInfo(NetworkInfo networkInfo) {
            if (networkInfo == null) {
                return null;
            }
            if (networkInfo.isConnected()) {
                return networkInfo;
            }
            if (Build.VERSION.SDK_INT >= 21 && networkInfo.getDetailedState() == NetworkInfo.DetailedState.BLOCKED && ApplicationStatus.getStateForApplication() == 1) {
                return networkInfo;
            }
            return null;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0041  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        aegon.chrome.net.NetworkChangeNotifierAutoDetect.NetworkState getNetworkState(aegon.chrome.net.NetworkChangeNotifierAutoDetect.WifiManagerDelegate r15) {
            /*
                r14 = this;
                int r0 = android.os.Build.VERSION.SDK_INT
                r1 = 23
                if (r0 < r1) goto L11
                android.net.Network r0 = r14.getDefaultNetwork()
                android.net.ConnectivityManager r1 = r14.mConnectivityManager
                android.net.NetworkInfo r1 = aegon.chrome.base.compat.ApiHelperForM.getNetworkInfo(r1, r0)
                goto L18
            L11:
                android.net.ConnectivityManager r0 = r14.mConnectivityManager
                android.net.NetworkInfo r1 = r0.getActiveNetworkInfo()
                r0 = 0
            L18:
                android.net.NetworkInfo r1 = r14.processActiveNetworkInfo(r1)
                if (r1 != 0) goto L2a
                aegon.chrome.net.NetworkChangeNotifierAutoDetect$NetworkState r15 = new aegon.chrome.net.NetworkChangeNotifierAutoDetect$NetworkState
                r3 = 0
                r4 = -1
                r5 = -1
                r6 = 0
                r7 = 0
                r2 = r15
                r2.<init>(r3, r4, r5, r6, r7)
                return r15
            L2a:
                r2 = 1
                if (r0 == 0) goto L5d
                r15 = 0
                int r3 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Exception -> L44
                r4 = 28
                if (r3 < r4) goto L41
                android.net.ConnectivityManager r3 = r14.mConnectivityManager     // Catch: java.lang.Exception -> L44
                android.net.LinkProperties r3 = r3.getLinkProperties(r0)     // Catch: java.lang.Exception -> L44
                boolean r3 = aegon.chrome.net.AndroidNetworkLibrary.isPrivateDnsActive(r3)     // Catch: java.lang.Exception -> L44
                if (r3 == 0) goto L41
                goto L42
            L41:
                r2 = r15
            L42:
                r8 = r2
                goto L45
            L44:
                r8 = r15
            L45:
                aegon.chrome.net.NetworkChangeNotifierAutoDetect$NetworkState r15 = new aegon.chrome.net.NetworkChangeNotifierAutoDetect$NetworkState
                r4 = 1
                int r5 = r1.getType()
                int r6 = r1.getSubtype()
                long r0 = aegon.chrome.net.NetworkChangeNotifierAutoDetect.networkToNetId(r0)
                java.lang.String r7 = java.lang.String.valueOf(r0)
                r3 = r15
                r3.<init>(r4, r5, r6, r7, r8)
                return r15
            L5d:
                int r0 = r1.getType()
                if (r0 != r2) goto L9f
                java.lang.String r0 = r1.getExtraInfo()
                if (r0 == 0) goto L8a
                java.lang.String r0 = r1.getExtraInfo()
                java.lang.String r2 = ""
                boolean r0 = r2.equals(r0)
                if (r0 != 0) goto L8a
                aegon.chrome.net.NetworkChangeNotifierAutoDetect$NetworkState r15 = new aegon.chrome.net.NetworkChangeNotifierAutoDetect$NetworkState
                r3 = 1
                int r4 = r1.getType()
                int r5 = r1.getSubtype()
                java.lang.String r6 = r1.getExtraInfo()
                r7 = 0
                r2 = r15
                r2.<init>(r3, r4, r5, r6, r7)
                return r15
            L8a:
                aegon.chrome.net.NetworkChangeNotifierAutoDetect$NetworkState r0 = new aegon.chrome.net.NetworkChangeNotifierAutoDetect$NetworkState
                r9 = 1
                int r10 = r1.getType()
                int r11 = r1.getSubtype()
                java.lang.String r12 = r15.getWifiSsid()
                r13 = 0
                r8 = r0
                r8.<init>(r9, r10, r11, r12, r13)
                return r0
            L9f:
                aegon.chrome.net.NetworkChangeNotifierAutoDetect$NetworkState r15 = new aegon.chrome.net.NetworkChangeNotifierAutoDetect$NetworkState
                r2 = 1
                int r3 = r1.getType()
                int r4 = r1.getSubtype()
                r5 = 0
                r6 = 0
                r1 = r15
                r1.<init>(r2, r3, r4, r5, r6)
                return r15
            */
            throw new UnsupportedOperationException("Method not decompiled: aegon.chrome.net.NetworkChangeNotifierAutoDetect.ConnectivityManagerDelegate.getNetworkState(aegon.chrome.net.NetworkChangeNotifierAutoDetect$WifiManagerDelegate):aegon.chrome.net.NetworkChangeNotifierAutoDetect$NetworkState");
        }

        private NetworkInfo getNetworkInfo(Network network) {
            try {
                try {
                    return this.mConnectivityManager.getNetworkInfo(network);
                } catch (Exception unused) {
                    return this.mConnectivityManager.getNetworkInfo(network);
                }
            } catch (Exception unused2) {
                return null;
            }
        }

        int getConnectionType(Network network) {
            NetworkInfo networkInfo = getNetworkInfo(network);
            if (networkInfo != null && networkInfo.getType() == 17) {
                networkInfo = this.mConnectivityManager.getActiveNetworkInfo();
            }
            if (networkInfo == null || !networkInfo.isConnected()) {
                return 6;
            }
            return NetworkChangeNotifierAutoDetect.convertToConnectionType(networkInfo.getType(), networkInfo.getSubtype());
        }

        protected Network[] getAllNetworksUnfiltered() {
            Network[] allNetworks = this.mConnectivityManager.getAllNetworks();
            return allNetworks == null ? new Network[0] : allNetworks;
        }

        protected boolean vpnAccessible(Network network) throws IOException {
            Socket socket = new Socket();
            try {
                try {
                    StrictModeContext strictModeContextAllowAllVmPolicies = StrictModeContext.allowAllVmPolicies();
                    try {
                        network.bindSocket(socket);
                        if (strictModeContextAllowAllVmPolicies != null) {
                            strictModeContextAllowAllVmPolicies.close();
                        }
                        try {
                            socket.close();
                            return true;
                        } catch (IOException unused) {
                            return true;
                        }
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            if (strictModeContextAllowAllVmPolicies != null) {
                                try {
                                    strictModeContextAllowAllVmPolicies.close();
                                } catch (Throwable th3) {
                                    th.addSuppressed(th3);
                                }
                            }
                            throw th2;
                        }
                    }
                } catch (IOException unused2) {
                    socket.close();
                    return false;
                } catch (Throwable th4) {
                    try {
                        socket.close();
                    } catch (IOException unused3) {
                    }
                    throw th4;
                }
            } catch (IOException unused4) {
                return false;
            }
        }

        protected NetworkCapabilities getNetworkCapabilities(Network network) {
            try {
                return this.mConnectivityManager.getNetworkCapabilities(network);
            } catch (Exception unused) {
                return null;
            }
        }

        void registerNetworkCallback(NetworkRequest networkRequest, ConnectivityManager.NetworkCallback networkCallback, Handler handler) {
            if (Build.VERSION.SDK_INT >= 26) {
                this.mConnectivityManager.registerNetworkCallback(networkRequest, networkCallback, handler);
            } else {
                this.mConnectivityManager.registerNetworkCallback(networkRequest, networkCallback);
            }
        }

        void registerDefaultNetworkCallback(ConnectivityManager.NetworkCallback networkCallback, Handler handler) {
            this.mConnectivityManager.registerDefaultNetworkCallback(networkCallback, handler);
        }

        void unregisterNetworkCallback(ConnectivityManager.NetworkCallback networkCallback) {
            this.mConnectivityManager.unregisterNetworkCallback(networkCallback);
        }

        Network getDefaultNetwork() {
            Network activeNetwork;
            if (Build.VERSION.SDK_INT >= 23) {
                activeNetwork = ApiHelperForM.getActiveNetwork(this.mConnectivityManager);
                if (activeNetwork != null) {
                    return activeNetwork;
                }
            } else {
                activeNetwork = null;
            }
            NetworkInfo activeNetworkInfo = this.mConnectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return null;
            }
            for (Network network : NetworkChangeNotifierAutoDetect.getAllNetworksFiltered(this, null)) {
                NetworkInfo networkInfo = getNetworkInfo(network);
                if (networkInfo != null && (networkInfo.getType() == activeNetworkInfo.getType() || networkInfo.getType() == 17)) {
                    activeNetwork = network;
                }
            }
            return activeNetwork;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    static class WifiManagerDelegate {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final Context mContext;
        private boolean mHasWifiPermission;
        private boolean mHasWifiPermissionComputed;
        private final Object mLock;
        private WifiManager mWifiManager;

        WifiManagerDelegate(Context context) {
            this.mLock = new Object();
            this.mContext = context;
        }

        WifiManagerDelegate() {
            this.mLock = new Object();
            this.mContext = null;
        }

        private boolean hasPermissionLocked() {
            if (this.mHasWifiPermissionComputed) {
                return this.mHasWifiPermission;
            }
            boolean z = this.mContext.getPackageManager().checkPermission(g.d, this.mContext.getPackageName()) == 0;
            this.mHasWifiPermission = z;
            this.mWifiManager = z ? (WifiManager) this.mContext.getSystemService(a.a) : null;
            this.mHasWifiPermissionComputed = true;
            return this.mHasWifiPermission;
        }

        String getWifiSsid() {
            synchronized (this.mLock) {
                if (hasPermissionLocked()) {
                    WifiInfo wifiInfoLocked = getWifiInfoLocked();
                    if (wifiInfoLocked == null) {
                        return "";
                    }
                    return wifiInfoLocked.getSSID();
                }
                return AndroidNetworkLibrary.getWifiSSID();
            }
        }

        private WifiInfo getWifiInfoLocked() {
            try {
                try {
                    return this.mWifiManager.getConnectionInfo();
                } catch (NullPointerException unused) {
                    return this.mWifiManager.getConnectionInfo();
                }
            } catch (NullPointerException unused2) {
                return null;
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    class DefaultNetworkCallback extends ConnectivityManager.NetworkCallback {
        private DefaultNetworkCallback() {
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            if (NetworkChangeNotifierAutoDetect.this.mRegistered) {
                NetworkChangeNotifierAutoDetect.this.connectionTypeChanged();
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            onAvailable(null);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLinkPropertiesChanged(Network network, LinkProperties linkProperties) {
            onAvailable(null);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    class MyNetworkCallback extends ConnectivityManager.NetworkCallback {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private Network mVpnInPlace;

        private MyNetworkCallback() {
        }

        void initializeVpnInPlace() {
            NetworkCapabilities networkCapabilities;
            Network[] allNetworksFiltered = NetworkChangeNotifierAutoDetect.getAllNetworksFiltered(NetworkChangeNotifierAutoDetect.this.mConnectivityManagerDelegate, null);
            this.mVpnInPlace = null;
            if (allNetworksFiltered.length == 1 && (networkCapabilities = NetworkChangeNotifierAutoDetect.this.mConnectivityManagerDelegate.getNetworkCapabilities(allNetworksFiltered[0])) != null && networkCapabilities.hasTransport(4)) {
                this.mVpnInPlace = allNetworksFiltered[0];
            }
        }

        private boolean ignoreNetworkDueToVpn(Network network) {
            Network network2 = this.mVpnInPlace;
            return (network2 == null || network2.equals(network)) ? false : true;
        }

        private boolean ignoreConnectedInaccessibleVpn(Network network, NetworkCapabilities networkCapabilities) {
            if (networkCapabilities == null) {
                networkCapabilities = NetworkChangeNotifierAutoDetect.this.mConnectivityManagerDelegate.getNetworkCapabilities(network);
            }
            if (networkCapabilities != null) {
                return networkCapabilities.hasTransport(4) && !NetworkChangeNotifierAutoDetect.this.mConnectivityManagerDelegate.vpnAccessible(network);
            }
            return true;
        }

        private boolean ignoreConnectedNetwork(Network network, NetworkCapabilities networkCapabilities) {
            return ignoreNetworkDueToVpn(network) || ignoreConnectedInaccessibleVpn(network, networkCapabilities);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            NetworkCapabilities networkCapabilities = NetworkChangeNotifierAutoDetect.this.mConnectivityManagerDelegate.getNetworkCapabilities(network);
            if (ignoreConnectedNetwork(network, networkCapabilities)) {
                return;
            }
            final boolean zHasTransport = networkCapabilities.hasTransport(4);
            if (zHasTransport) {
                this.mVpnInPlace = network;
            }
            final long jNetworkToNetId = NetworkChangeNotifierAutoDetect.networkToNetId(network);
            final int connectionType = NetworkChangeNotifierAutoDetect.this.mConnectivityManagerDelegate.getConnectionType(network);
            NetworkChangeNotifierAutoDetect.this.runOnThread(new Runnable() { // from class: aegon.chrome.net.NetworkChangeNotifierAutoDetect.MyNetworkCallback.1
                @Override // java.lang.Runnable
                public void run() {
                    NetworkChangeNotifierAutoDetect.this.mObserver.onNetworkConnect(jNetworkToNetId, connectionType);
                    if (zHasTransport) {
                        NetworkChangeNotifierAutoDetect.this.mObserver.onConnectionTypeChanged(connectionType);
                        NetworkChangeNotifierAutoDetect.this.mObserver.purgeActiveNetworkList(new long[]{jNetworkToNetId});
                    }
                }
            });
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
            if (ignoreConnectedNetwork(network, networkCapabilities)) {
                return;
            }
            final long jNetworkToNetId = NetworkChangeNotifierAutoDetect.networkToNetId(network);
            final int connectionType = NetworkChangeNotifierAutoDetect.this.mConnectivityManagerDelegate.getConnectionType(network);
            NetworkChangeNotifierAutoDetect.this.runOnThread(new Runnable() { // from class: aegon.chrome.net.NetworkChangeNotifierAutoDetect.MyNetworkCallback.2
                @Override // java.lang.Runnable
                public void run() {
                    NetworkChangeNotifierAutoDetect.this.mObserver.onNetworkConnect(jNetworkToNetId, connectionType);
                }
            });
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLosing(Network network, int i) {
            if (ignoreConnectedNetwork(network, null)) {
                return;
            }
            final long jNetworkToNetId = NetworkChangeNotifierAutoDetect.networkToNetId(network);
            NetworkChangeNotifierAutoDetect.this.runOnThread(new Runnable() { // from class: aegon.chrome.net.NetworkChangeNotifierAutoDetect.MyNetworkCallback.3
                @Override // java.lang.Runnable
                public void run() {
                    NetworkChangeNotifierAutoDetect.this.mObserver.onNetworkSoonToDisconnect(jNetworkToNetId);
                }
            });
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(final Network network) {
            if (ignoreNetworkDueToVpn(network)) {
                return;
            }
            NetworkChangeNotifierAutoDetect.this.runOnThread(new Runnable() { // from class: aegon.chrome.net.NetworkChangeNotifierAutoDetect.MyNetworkCallback.4
                @Override // java.lang.Runnable
                public void run() {
                    NetworkChangeNotifierAutoDetect.this.mObserver.onNetworkDisconnect(NetworkChangeNotifierAutoDetect.networkToNetId(network));
                }
            });
            if (this.mVpnInPlace != null) {
                this.mVpnInPlace = null;
                for (Network network2 : NetworkChangeNotifierAutoDetect.getAllNetworksFiltered(NetworkChangeNotifierAutoDetect.this.mConnectivityManagerDelegate, network)) {
                    onAvailable(network2);
                }
                final int connectionType = NetworkChangeNotifierAutoDetect.this.getCurrentNetworkState().getConnectionType();
                NetworkChangeNotifierAutoDetect.this.runOnThread(new Runnable() { // from class: aegon.chrome.net.NetworkChangeNotifierAutoDetect.MyNetworkCallback.5
                    @Override // java.lang.Runnable
                    public void run() {
                        NetworkChangeNotifierAutoDetect.this.mObserver.onConnectionTypeChanged(connectionType);
                    }
                });
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    public static abstract class RegistrationPolicy {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private NetworkChangeNotifierAutoDetect mNotifier;

        protected abstract void destroy();

        protected final void register() {
            this.mNotifier.register();
        }

        protected final void unregister() {
            this.mNotifier.unregister();
        }

        protected void init(NetworkChangeNotifierAutoDetect networkChangeNotifierAutoDetect) {
            this.mNotifier = networkChangeNotifierAutoDetect;
        }
    }

    public NetworkChangeNotifierAutoDetect(Observer observer, RegistrationPolicy registrationPolicy) {
        Looper looperMyLooper = Looper.myLooper();
        this.mLooper = looperMyLooper;
        this.mHandler = new Handler(looperMyLooper);
        this.mObserver = observer;
        this.mConnectivityManagerDelegate = new ConnectivityManagerDelegate(ContextUtils.getApplicationContext());
        if (Build.VERSION.SDK_INT < 23) {
            this.mWifiManagerDelegate = new WifiManagerDelegate(ContextUtils.getApplicationContext());
        }
        byte b = 0;
        byte b2 = 0;
        if (Build.VERSION.SDK_INT >= 21) {
            this.mNetworkCallback = new MyNetworkCallback();
            this.mNetworkRequest = new NetworkRequest.Builder().addCapability(12).removeCapability(15).build();
        } else {
            this.mNetworkCallback = null;
            this.mNetworkRequest = null;
        }
        this.mDefaultNetworkCallback = Build.VERSION.SDK_INT >= 28 ? new DefaultNetworkCallback() : null;
        this.mNetworkState = getCurrentNetworkState();
        this.mIntentFilter = new NetworkConnectivityIntentFilter();
        this.mIgnoreNextBroadcast = false;
        this.mShouldSignalObserver = false;
        this.mRegistrationPolicy = registrationPolicy;
        registrationPolicy.init(this);
        this.mShouldSignalObserver = true;
    }

    private boolean onThread() {
        return this.mLooper == Looper.myLooper();
    }

    private void assertOnThread() {
        if (BuildConfig.DCHECK_IS_ON && !onThread()) {
            throw new IllegalStateException("Must be called on NetworkChangeNotifierAutoDetect thread.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void runOnThread(Runnable runnable) {
        if (onThread()) {
            runnable.run();
        } else {
            this.mHandler.post(runnable);
        }
    }

    void setConnectivityManagerDelegateForTests(ConnectivityManagerDelegate connectivityManagerDelegate) {
        this.mConnectivityManagerDelegate = connectivityManagerDelegate;
    }

    void setWifiManagerDelegateForTests(WifiManagerDelegate wifiManagerDelegate) {
        this.mWifiManagerDelegate = wifiManagerDelegate;
    }

    RegistrationPolicy getRegistrationPolicy() {
        return this.mRegistrationPolicy;
    }

    boolean isReceiverRegisteredForTesting() {
        return this.mRegistered;
    }

    public void destroy() {
        assertOnThread();
        this.mRegistrationPolicy.destroy();
        unregister();
    }

    public void register() {
        assertOnThread();
        if (this.mRegistered) {
            return;
        }
        if (this.mShouldSignalObserver) {
            connectionTypeChanged();
        }
        DefaultNetworkCallback defaultNetworkCallback = this.mDefaultNetworkCallback;
        if (defaultNetworkCallback != null) {
            try {
                this.mConnectivityManagerDelegate.registerDefaultNetworkCallback(defaultNetworkCallback, this.mHandler);
            } catch (RuntimeException unused) {
                this.mDefaultNetworkCallback = null;
            }
        }
        if (this.mDefaultNetworkCallback == null) {
            this.mIgnoreNextBroadcast = ContextUtils.getApplicationContext().registerReceiver(this, this.mIntentFilter) != null;
        }
        this.mRegistered = true;
        MyNetworkCallback myNetworkCallback = this.mNetworkCallback;
        if (myNetworkCallback != null) {
            myNetworkCallback.initializeVpnInPlace();
            try {
                this.mConnectivityManagerDelegate.registerNetworkCallback(this.mNetworkRequest, this.mNetworkCallback, this.mHandler);
            } catch (RuntimeException unused2) {
                this.mRegisterNetworkCallbackFailed = true;
                this.mNetworkCallback = null;
            }
            if (this.mRegisterNetworkCallbackFailed || !this.mShouldSignalObserver) {
                return;
            }
            Network[] allNetworksFiltered = getAllNetworksFiltered(this.mConnectivityManagerDelegate, null);
            long[] jArr = new long[allNetworksFiltered.length];
            for (int i = 0; i < allNetworksFiltered.length; i++) {
                jArr[i] = networkToNetId(allNetworksFiltered[i]);
            }
            this.mObserver.purgeActiveNetworkList(jArr);
        }
    }

    public void unregister() {
        assertOnThread();
        if (this.mRegistered) {
            this.mRegistered = false;
            MyNetworkCallback myNetworkCallback = this.mNetworkCallback;
            if (myNetworkCallback != null) {
                this.mConnectivityManagerDelegate.unregisterNetworkCallback(myNetworkCallback);
            }
            DefaultNetworkCallback defaultNetworkCallback = this.mDefaultNetworkCallback;
            if (defaultNetworkCallback != null) {
                this.mConnectivityManagerDelegate.unregisterNetworkCallback(defaultNetworkCallback);
            } else {
                ContextUtils.getApplicationContext().unregisterReceiver(this);
            }
        }
    }

    public NetworkState getCurrentNetworkState() {
        return this.mConnectivityManagerDelegate.getNetworkState(this.mWifiManagerDelegate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Network[] getAllNetworksFiltered(ConnectivityManagerDelegate connectivityManagerDelegate, Network network) {
        NetworkCapabilities networkCapabilities;
        Network[] allNetworksUnfiltered = connectivityManagerDelegate.getAllNetworksUnfiltered();
        int i = 0;
        for (Network network2 : allNetworksUnfiltered) {
            if (!network2.equals(network) && (networkCapabilities = connectivityManagerDelegate.getNetworkCapabilities(network2)) != null && networkCapabilities.hasCapability(12)) {
                if (networkCapabilities.hasTransport(4)) {
                    if (connectivityManagerDelegate.vpnAccessible(network2)) {
                        return new Network[]{network2};
                    }
                } else {
                    allNetworksUnfiltered[i] = network2;
                    i++;
                }
            }
        }
        return (Network[]) Arrays.copyOf(allNetworksUnfiltered, i);
    }

    public long[] getNetworksAndTypes() {
        if (Build.VERSION.SDK_INT < 21) {
            return new long[0];
        }
        Network[] allNetworksFiltered = getAllNetworksFiltered(this.mConnectivityManagerDelegate, null);
        long[] jArr = new long[allNetworksFiltered.length * 2];
        int i = 0;
        for (Network network : allNetworksFiltered) {
            int i2 = i + 1;
            jArr[i] = networkToNetId(network);
            i = i2 + 1;
            jArr[i2] = this.mConnectivityManagerDelegate.getConnectionType(r5);
        }
        return jArr;
    }

    public long getDefaultNetId() {
        Network defaultNetwork;
        if (Build.VERSION.SDK_INT >= 21 && (defaultNetwork = this.mConnectivityManagerDelegate.getDefaultNetwork()) != null) {
            return networkToNetId(defaultNetwork);
        }
        return -1L;
    }

    public boolean registerNetworkCallbackFailed() {
        return this.mRegisterNetworkCallbackFailed;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        runOnThread(new Runnable() { // from class: aegon.chrome.net.NetworkChangeNotifierAutoDetect.1
            @Override // java.lang.Runnable
            public void run() {
                if (NetworkChangeNotifierAutoDetect.this.mRegistered) {
                    if (NetworkChangeNotifierAutoDetect.this.mIgnoreNextBroadcast) {
                        NetworkChangeNotifierAutoDetect.this.mIgnoreNextBroadcast = false;
                    } else {
                        NetworkChangeNotifierAutoDetect.this.connectionTypeChanged();
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void connectionTypeChanged() {
        NetworkState currentNetworkState = getCurrentNetworkState();
        if (currentNetworkState.getConnectionType() != this.mNetworkState.getConnectionType() || !currentNetworkState.getNetworkIdentifier().equals(this.mNetworkState.getNetworkIdentifier()) || currentNetworkState.isPrivateDnsActive() != this.mNetworkState.isPrivateDnsActive()) {
            this.mObserver.onConnectionTypeChanged(currentNetworkState.getConnectionType());
        }
        if (currentNetworkState.getConnectionType() != this.mNetworkState.getConnectionType() || currentNetworkState.getConnectionSubtype() != this.mNetworkState.getConnectionSubtype()) {
            this.mObserver.onConnectionSubtypeChanged(currentNetworkState.getConnectionSubtype());
        }
        this.mNetworkState = currentNetworkState;
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    static class NetworkConnectivityIntentFilter extends IntentFilter {
        NetworkConnectivityIntentFilter() {
            addAction("android.net.conn.CONNECTIVITY_CHANGE");
        }
    }

    static long networkToNetId(Network network) {
        if (Build.VERSION.SDK_INT >= 23) {
            return ApiHelperForM.getNetworkHandle(network);
        }
        return Integer.parseInt(network.toString());
    }
}
