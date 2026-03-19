package com.fendasz.moku;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.fendasz.moku.callback.MoguOaidCallBack;
import com.fendasz.moku.exception.NotInitException;
import com.fendasz.moku.rules.DeviceId;
import com.github.gzuliyujiang.oaid.DeviceID;
import com.github.gzuliyujiang.oaid.DeviceIdentifier;
import com.github.gzuliyujiang.oaid.IGetter;
import com.sigmob.sdk.base.mta.PointCategory;
import java.lang.reflect.InvocationTargetException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class MoguID {
    private static final String MOGU_SP_DEVICE_ID_KEY = "mogu_sp_device_id_key";
    private static final String TAG = "MoguID==>";
    private static boolean isInit = false;
    private static MoguID moguID;

    private MoguID() {
    }

    public static MoguID getInstance() {
        MoguID moguID2;
        synchronized (MoguID.class) {
            moguID2 = new MoguID();
            moguID = moguID2;
        }
        return moguID2;
    }

    public void init(Application application) {
        Log.d(TAG, PointCategory.INIT);
        DeviceIdentifier.register(application);
        isInit = true;
    }

    public static synchronized String deviceId(Context context) {
        String deviceID;
        synchronized (MoguID.class) {
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

    public synchronized String getOAID(Application application) throws NotInitException {
        String oaid;
        Log.d(TAG, "synchronized get oaid start");
        if (!isInit) {
            throw new NotInitException();
        }
        oaid = DeviceIdentifier.getOAID(application);
        Log.d(TAG, "synchronized get oaid end,oaid=>" + oaid);
        return oaid;
    }

    public synchronized void oaid(Context context, final MoguOaidCallBack moguOaidCallBack) throws NotInitException {
        Log.d(TAG, "Asyn get oaid start");
        if (!isInit) {
            throw new NotInitException();
        }
        DeviceID.getOAID(context, new IGetter() { // from class: com.fendasz.moku.MoguID.1
            @Override // com.github.gzuliyujiang.oaid.IGetter
            public void onOAIDGetComplete(String str) {
                Log.d(MoguID.TAG, "Asyn get oaid success,oaid=>" + str);
                moguOaidCallBack.oaidSuccess(str);
            }

            @Override // com.github.gzuliyujiang.oaid.IGetter
            public void onOAIDGetError(Exception exc) {
                Log.d(MoguID.TAG, "Asyn get oaid error,error msg=>" + exc.getMessage());
                moguOaidCallBack.oaidError(exc);
            }
        });
    }

    private Application getApplication(Context context) {
        Application application = context instanceof Activity ? ((Activity) context).getApplication() : null;
        if (application == null && (context instanceof Application)) {
            application = (Application) context;
        }
        if (application == null) {
            try {
                application = (Application) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, new Object[0]);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            } catch (NoSuchMethodException e3) {
                e3.printStackTrace();
            } catch (InvocationTargetException e4) {
                e4.printStackTrace();
            }
        }
        if (application != null) {
            return application;
        }
        throw new NullPointerException("mogu id know application");
    }
}
