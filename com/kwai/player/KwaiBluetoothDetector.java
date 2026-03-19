package com.kwai.player;

import android.bluetooth.BluetoothA2dp;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothHeadset;
import android.bluetooth.BluetoothProfile;
import android.content.Context;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class KwaiBluetoothDetector {
    private static KwaiBluetoothDetector sBluetoothUtil;
    private String TAG = "KwaiBluetoothDetector";
    private final Object mLock = new Object();
    private boolean misInited = false;
    BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    BluetoothHeadset mBluetoothHeadset = null;
    BluetoothA2dp mBluetoothA2dp = null;
    private BluetoothProfile.ServiceListener mProfileListener = new BluetoothProfile.ServiceListener() { // from class: com.kwai.player.KwaiBluetoothDetector.1
        @Override // android.bluetooth.BluetoothProfile.ServiceListener
        public void onServiceConnected(int i, BluetoothProfile bluetoothProfile) {
            synchronized (KwaiBluetoothDetector.this.mLock) {
                try {
                    if (i == 2) {
                        KwaiBluetoothDetector.this.mBluetoothA2dp = (BluetoothA2dp) bluetoothProfile;
                    } else if (i == 1) {
                        KwaiBluetoothDetector.this.mBluetoothHeadset = (BluetoothHeadset) bluetoothProfile;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // android.bluetooth.BluetoothProfile.ServiceListener
        public void onServiceDisconnected(int i) {
            synchronized (KwaiBluetoothDetector.this.mLock) {
                try {
                    if (i == 2) {
                        KwaiBluetoothDetector.this.mBluetoothA2dp = null;
                    } else if (i == 1) {
                        KwaiBluetoothDetector.this.mBluetoothHeadset = null;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    };

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    class KwaiBluetoothDeviceInfo {
        private String mName = null;
        private String mAddress = null;
        private String mDeviceInfo = null;

        KwaiBluetoothDeviceInfo() {
        }

        public String toString() {
            if (this.mName != null) {
                this.mDeviceInfo = "name: " + this.mName;
            }
            if (this.mAddress != null) {
                this.mDeviceInfo += ", address: " + this.mAddress;
            }
            return this.mDeviceInfo;
        }
    }

    public static synchronized KwaiBluetoothDetector getInstance() {
        if (sBluetoothUtil == null) {
            sBluetoothUtil = new KwaiBluetoothDetector();
        }
        return sBluetoothUtil;
    }

    public synchronized void init(Context context) {
        if (!this.misInited) {
            this.mBluetoothAdapter.getProfileProxy(context, this.mProfileListener, 2);
            this.mBluetoothAdapter.getProfileProxy(context, this.mProfileListener, 1);
            this.misInited = true;
        }
    }

    public synchronized void close() {
        if (this.misInited) {
            this.mBluetoothAdapter.closeProfileProxy(2, this.mBluetoothA2dp);
            this.mBluetoothAdapter.closeProfileProxy(1, this.mBluetoothHeadset);
            this.misInited = false;
        }
    }

    public String getBlueToothInfo() {
        KwaiBluetoothDeviceInfo kwaiBluetoothDeviceInfo = new KwaiBluetoothDeviceInfo();
        BluetoothAdapter bluetoothAdapter = this.mBluetoothAdapter;
        if (bluetoothAdapter != null && 12 == bluetoothAdapter.getState()) {
            synchronized (this.mLock) {
                BluetoothA2dp bluetoothA2dp = this.mBluetoothA2dp;
                if (bluetoothA2dp != null) {
                    for (BluetoothDevice bluetoothDevice : bluetoothA2dp.getConnectedDevices()) {
                        if (this.mBluetoothA2dp.isA2dpPlaying(bluetoothDevice)) {
                            kwaiBluetoothDeviceInfo.mName = bluetoothDevice.getName();
                            kwaiBluetoothDeviceInfo.mAddress = bluetoothDevice.getAddress();
                        }
                    }
                } else {
                    BluetoothHeadset bluetoothHeadset = this.mBluetoothHeadset;
                    if (bluetoothHeadset != null) {
                        for (BluetoothDevice bluetoothDevice2 : bluetoothHeadset.getConnectedDevices()) {
                            if (this.mBluetoothHeadset.isAudioConnected(bluetoothDevice2)) {
                                kwaiBluetoothDeviceInfo.mName = bluetoothDevice2.getName();
                                kwaiBluetoothDeviceInfo.mAddress = bluetoothDevice2.getAddress();
                            }
                        }
                    }
                }
            }
        }
        return kwaiBluetoothDeviceInfo.toString();
    }
}
