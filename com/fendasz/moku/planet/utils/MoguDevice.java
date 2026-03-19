package com.fendasz.moku.planet.utils;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.fendasz.moku.planet.utils.thirdparty.baidu.util.DeviceId;
import com.github.gzuliyujiang.oaid.DeviceID;
import com.github.gzuliyujiang.oaid.IGetter;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class MoguDevice {
    private static final String TAG = "MOKU_MoguDevice=>";
    private static MoguDevice moguDevice;

    private MoguDevice() {
    }

    public static MoguDevice getInstance() {
        MoguDevice moguDevice2;
        synchronized (MoguDevice.class) {
            if (moguDevice == null) {
                moguDevice = new MoguDevice();
            }
            moguDevice2 = moguDevice;
        }
        return moguDevice2;
    }

    public static synchronized String deviceId(Context context) {
        String deviceID;
        synchronized (MoguDevice.class) {
            deviceID = DeviceId.getDeviceID(context);
            Log.d(TAG, "get device success,deviceId=>" + deviceID);
            if (deviceID == null || TextUtils.isEmpty(deviceID)) {
                Log.e(TAG, "get device error once，get again");
                deviceID = DeviceId.getDeviceID(context);
                if (deviceID == null || TextUtils.isEmpty(deviceID)) {
                    Log.e(TAG, "get device error");
                }
            }
            if (deviceID == null || TextUtils.isEmpty(deviceID)) {
                deviceID = "error-empty-device";
            }
        }
        return deviceID;
        return deviceID;
    }

    public synchronized void oaid(Context context, final MoguOaidCallBack moguOaidCallBack) {
        Log.d(TAG, "Asyn get oaid start");
        DeviceID.getOAID(context, new IGetter() { // from class: com.fendasz.moku.planet.utils.MoguDevice.1
            @Override // com.github.gzuliyujiang.oaid.IGetter
            public void onOAIDGetComplete(String str) {
                Log.d(MoguDevice.TAG, "Asyn get oaid success,oaid=>" + str);
                moguOaidCallBack.oaidSuccess(str);
            }

            @Override // com.github.gzuliyujiang.oaid.IGetter
            public void onOAIDGetError(Exception exc) {
                Log.d(MoguDevice.TAG, "Asyn get oaid error,error msg=>" + exc.getMessage());
                moguOaidCallBack.oaidError(exc);
            }
        });
    }
}
