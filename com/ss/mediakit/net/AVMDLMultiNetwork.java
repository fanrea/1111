package com.ss.mediakit.net;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.ss.mediakit.medialoader.AVMDLDataLoader;
import com.ss.mediakit.medialoader.AVMDLLog;
import java.util.Locale;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class AVMDLMultiNetwork {
    public static final int MSG_IS_NETWORK_AVAILABLE = 0;
    public static final int MSG_IS_NETWORK_CHANGED = 3;
    public static final int MSG_IS_SWITCH_TO_CELLULAR_NETWORK = 1;
    public static final int MSG_IS_SWITCH_TO_DEFAULT_NETWORK = 2;
    private static final String TAG = "AVMDLMultiNetwork";
    static Runnable loopRefreshRunnable = new Runnable() { // from class: com.ss.mediakit.net.AVMDLMultiNetwork.1
        @Override // java.lang.Runnable
        public void run() {
            AVMDLMultiNetwork.refreshIpReachable();
            AVMDLMultiNetwork.mHandler.postDelayed(this, 60000L);
        }
    };
    private static Network mCellularNetwork = null;
    private static ConnectivityManager mCm = null;
    private static long mCurNetId = 0;
    private static Network mCurNetwork = null;
    protected static Handler mHandler = null;
    private static boolean mIsIPv4Reachable = true;
    private static boolean mIsIPv6Reachable = true;
    public static final int mLoopIpRefreshInterval = 60000;
    private static HandlerThread mThread;

    public static void refreshIpReachable() {
    }

    public static boolean registerNetworkChangeCallback(Context context) {
        if (Build.VERSION.SDK_INT < 21) {
            AVMDLLog.d(TAG, "build version not support:" + Build.VERSION.SDK_INT);
            return false;
        }
        initHandler(context);
        if (mCm == null) {
            AVMDLLog.d(TAG, "cm is null");
            return false;
        }
        NetworkRequest networkRequestBuild = new NetworkRequest.Builder().build();
        try {
            if (AVMDLDataLoader.getInstance().getConfig().mEnableNetworkChangeNotify == 1) {
                mCm.registerNetworkCallback(networkRequestBuild, new ConnectivityManager.NetworkCallback() { // from class: com.ss.mediakit.net.AVMDLMultiNetwork.2
                    @Override // android.net.ConnectivityManager.NetworkCallback
                    public void onLost(Network network) {
                        AVMDLLog.d(AVMDLMultiNetwork.TAG, "send msg of onLost ");
                        if (network == null || AVMDLMultiNetwork.mCm == null) {
                            return;
                        }
                        Message message = new Message();
                        message.obj = network;
                        message.what = 3;
                        AVMDLMultiNetwork.mHandler.sendMessageDelayed(message, 200L);
                    }

                    @Override // android.net.ConnectivityManager.NetworkCallback
                    public void onLinkPropertiesChanged(Network network, LinkProperties linkProperties) {
                        AVMDLLog.d(AVMDLMultiNetwork.TAG, "send msg of onLinkPropertiesChanged");
                        if (network == null || AVMDLMultiNetwork.mCm == null) {
                            return;
                        }
                        Message message = new Message();
                        message.obj = network;
                        message.what = 3;
                        AVMDLMultiNetwork.mHandler.sendMessage(message);
                    }
                });
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean alwayUpCellular(Context context) {
        if (Build.VERSION.SDK_INT < 21) {
            AVMDLLog.d(TAG, "build version not support:" + Build.VERSION.SDK_INT);
            return false;
        }
        initHandler(context);
        if (mCm == null) {
            AVMDLLog.d(TAG, "cm is null");
            return false;
        }
        try {
            mCm.requestNetwork(new NetworkRequest.Builder().addCapability(12).addTransportType(0).build(), new ConnectivityManager.NetworkCallback() { // from class: com.ss.mediakit.net.AVMDLMultiNetwork.3
                @Override // android.net.ConnectivityManager.NetworkCallback
                public void onAvailable(Network network) {
                    Message message = new Message();
                    message.obj = network;
                    message.what = 0;
                    AVMDLMultiNetwork.mHandler.sendMessage(message);
                    AVMDLLog.d(AVMDLMultiNetwork.TAG, "send msg of onavailable ");
                }
            });
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private static void initHandler(Context context) {
        synchronized (AVMDLMultiNetwork.class) {
            if (mThread == null) {
                HandlerThread handlerThread = new HandlerThread(TAG);
                mThread = handlerThread;
                handlerThread.start();
                mHandler = new Handler(mThread.getLooper()) { // from class: com.ss.mediakit.net.AVMDLMultiNetwork.4
                    @Override // android.os.Handler
                    public void handleMessage(Message message) {
                        Network network = message.obj != null ? (Network) message.obj : null;
                        AVMDLLog.d(AVMDLMultiNetwork.TAG, String.format(Locale.US, "----receive msg what:%d info:%s", Integer.valueOf(message.what), network));
                        int i = message.what;
                        if (i == 0) {
                            AVMDLMultiNetwork.onAvailableInternal(network);
                        } else if (i == 1) {
                            AVMDLMultiNetwork.switchToCellularNetworkInternal();
                        } else if (i == 2) {
                            AVMDLMultiNetwork.switchToDefaultNetworkInternal();
                        } else if (i == 3) {
                            AVMDLMultiNetwork.refreshIpReachable();
                        }
                        AVMDLLog.d(AVMDLMultiNetwork.TAG, String.format(Locale.US, "****end proc msg what:%d info:%s", Integer.valueOf(message.what), network));
                    }
                };
            }
            if (context != null && mCm == null) {
                mCm = (ConnectivityManager) context.getSystemService("connectivity");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void onAvailableInternal(Network network) {
        ConnectivityManager connectivityManager;
        if (network == null || (connectivityManager = mCm) == null) {
            return;
        }
        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(network);
        AVMDLLog.d(TAG, "start on available");
        if (networkInfo != null) {
            AVMDLLog.d(TAG, "network name: " + networkInfo.getTypeName() + "[" + networkInfo.getSubtypeName() + "], state: " + networkInfo.getDetailedState() + " netid:" + getNetId(network));
        }
        NetworkCapabilities networkCapabilities = mCm.getNetworkCapabilities(network);
        if (networkCapabilities != null && networkCapabilities.hasTransport(0) && networkCapabilities.hasCapability(12)) {
            onCellularNetwork(network);
            AVMDLDataLoader.getInstance().onInitMultiNetworkEnv();
        } else {
            AVMDLDataLoader.getInstance().onCellularAlwaysUp(0L);
        }
        AVMDLLog.d(TAG, "end on available");
    }

    public static void onCellularNetwork(Network network) {
        synchronized (AVMDLMultiNetwork.class) {
            mCellularNetwork = network;
        }
    }

    public static Network getCurNetwork() {
        Network network;
        synchronized (AVMDLMultiNetwork.class) {
            network = mCurNetwork;
        }
        return network;
    }

    public static void setCurNetwork(Network network) {
        synchronized (AVMDLMultiNetwork.class) {
            mCurNetwork = network;
        }
    }

    public static boolean isIPv6Reachable() {
        boolean z;
        synchronized (AVMDLMultiNetwork.class) {
            z = mIsIPv6Reachable;
        }
        return z;
    }

    public static void setIPv6Reachable(boolean z) {
        synchronized (AVMDLMultiNetwork.class) {
            mIsIPv6Reachable = z;
        }
    }

    public static boolean isIPv4Reachable() {
        boolean z;
        synchronized (AVMDLMultiNetwork.class) {
            z = mIsIPv4Reachable;
        }
        return z;
    }

    public static void setIPv4Reachable(boolean z) {
        synchronized (AVMDLMultiNetwork.class) {
            mIsIPv4Reachable = z;
        }
    }

    public static Network getCellularNetwork() {
        Network network;
        synchronized (AVMDLMultiNetwork.class) {
            network = mCellularNetwork;
        }
        return network;
    }

    public static void switchToCellularNetwork() {
        if (mHandler != null) {
            Message message = new Message();
            message.what = 1;
            mHandler.sendMessage(message);
            AVMDLLog.d(TAG, "send msg of switch to cellular network");
        }
    }

    public static void switchToDefaultNetwork() {
        if (mHandler != null) {
            Message message = new Message();
            message.what = 2;
            mHandler.sendMessage(message);
            AVMDLLog.d(TAG, "send msg of switch to default network");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void switchToCellularNetworkInternal() {
        int iOnCellularAlwaysUp;
        Network cellularNetwork = getCellularNetwork();
        if (cellularNetwork == null) {
            return;
        }
        long netId = getNetId(cellularNetwork);
        AVMDLLog.d(TAG, "try switch to cellular curNetId: " + mCurNetId + " netId:" + netId);
        if (mCurNetId != netId) {
            AVMDLLog.d(TAG, "do switch");
            IPCache.getInstance().clear();
            iOnCellularAlwaysUp = AVMDLDataLoader.getInstance().onCellularAlwaysUp(NetUtils.getNetId(cellularNetwork));
            mCurNetId = netId;
            setCurNetwork(cellularNetwork);
        } else {
            AVMDLLog.d(TAG, "cur is cellular, not need switch");
            iOnCellularAlwaysUp = 0;
        }
        AVMDLLog.d(TAG, "end switch to cellular, ret:" + iOnCellularAlwaysUp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void switchToDefaultNetworkInternal() {
        AVMDLLog.d(TAG, "try switch to default network");
        if (mCurNetId != 0) {
            AVMDLLog.d(TAG, "do switch");
            IPCache.getInstance().clear();
            AVMDLDataLoader.getInstance().onCellularAlwaysUp(0L);
            mCurNetId = 0L;
            setCurNetwork(null);
        }
        AVMDLLog.d(TAG, "end try switch to default network");
    }

    private static long getNetId(Network network) {
        if (Build.VERSION.SDK_INT >= 23) {
            return network.getNetworkHandle();
        }
        return Integer.parseInt(network.toString());
    }
}
