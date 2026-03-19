package com.fendasz.moku.planet.utils;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.alipay.sdk.m.u.i;
import com.baidu.mobads.container.util.e.a;
import com.baidu.mobstat.forbes.Config;
import com.dhylive.app.utils.JumpParam;
import com.fendasz.moku.planet.entity.PhoneInfo;
import com.fendasz.moku.planet.helper.MokuConfigure;
import com.fendasz.moku.planet.utils.PermissionUtils;
import com.fendasz.moku.planet.utils.system.utils.SystemUtils;
import com.fendasz.moku.planet.utils.thirdparty.baidu.util.DeviceId;
import com.kwad.sdk.live.audience.KSLiveNetwork;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class PhoneInfoUtils {
    private static final String ID_ERROR_IDENTIFY_VALUE = "moku_device_system_id_error_identify";
    private static final String KEY_ANDROID_ID = "moku_cache_android_id_key";
    private static final String KEY_IMEI = "moku_cache_imei_key";
    private static final String KEY_IMEI2 = "moku_cache_imei_two_key";
    private static final String KEY_IMSI = "moku_cache_imsi_key";
    private static final String KEY_IMSI2 = "moku_cache_imsi_tow_key";
    private static final String KEY_MEID = "moku_cache_meid_key";
    private static String TAG = "MOKU_PhoneInfoUtils=>";
    private static Map<String, String> cacheMap;
    private static PhoneInfoUtils sPhoneInfoUtils;

    public static PhoneInfoUtils getInstance() {
        PhoneInfoUtils phoneInfoUtils;
        synchronized (PhoneInfoUtils.class) {
            if (sPhoneInfoUtils == null) {
                sPhoneInfoUtils = new PhoneInfoUtils();
            }
            if (cacheMap == null) {
                cacheMap = new HashMap();
            }
            phoneInfoUtils = sPhoneInfoUtils;
        }
        return phoneInfoUtils;
    }

    public String getDeviceId(Context context) {
        String string = SharedPreferencesUtils.getInstance(context).getString("deviceId", "");
        if (TextUtils.isEmpty(string)) {
            string = DeviceId.getDeviceID(context);
        }
        SharedPreferencesUtils.getInstance(context).putString("deviceId", string);
        return string;
    }

    public String getPhoneImeiNum(Context context) {
        LogUtils.logD(TAG, "getPhoneImeiNum invoke");
        String fromCache = getFromCache(context, KEY_IMEI);
        if (isErrorIdentify(fromCache)) {
            LogUtils.logD(TAG, "getPhoneImeiNum error,can't get imei from device");
            return "";
        }
        if (!StringUtils.isEmpty(fromCache)) {
            LogUtils.logD(TAG, "getPhoneImeiNum from cache");
            return fromCache;
        }
        LogUtils.logD(TAG, "getPhoneImeiNum from device start");
        try {
            String deviceId = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
            LogUtils.logD(TAG, "getPhoneImeiNum from device success,cache imei=>" + deviceId);
            if (deviceId == null) {
                putCache(context, KEY_IMEI, ID_ERROR_IDENTIFY_VALUE);
            }
            return deviceId;
        } catch (Exception unused) {
            LogUtils.logD(TAG, "getPhoneImeiNum invoke error,cache default id error");
            putCache(context, KEY_IMEI, ID_ERROR_IDENTIFY_VALUE);
            return "";
        }
    }

    public String getImei2(Context context) {
        LogUtils.logD(TAG, "getImei2 invoke");
        String fromCache = getFromCache(context, KEY_IMEI2);
        if (isErrorIdentify(fromCache)) {
            LogUtils.logD(TAG, "getImei2 error,can't get imei2 from device");
            return "";
        }
        if (!StringUtils.isEmpty(fromCache)) {
            LogUtils.logD(TAG, "getImei2 from cache");
            return fromCache;
        }
        LogUtils.logD(TAG, "getImei2 from device start");
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            String str = (String) telephonyManager.getClass().getMethod("getDeviceId", Integer.TYPE).invoke(telephonyManager, 1);
            LogUtils.logD(TAG, "getImei2 from device success,cache imei2=>" + str);
            putCache(context, KEY_IMEI2, str);
            return str;
        } catch (Exception unused) {
            LogUtils.logE(TAG, "getImei2 invoke error,cache default id error");
            putCache(context, KEY_IMEI2, ID_ERROR_IDENTIFY_VALUE);
            return null;
        }
    }

    public String getMeid(Context context) {
        LogUtils.logD(TAG, "getMeid invoke");
        String fromCache = getFromCache(context, KEY_MEID);
        if (isErrorIdentify(fromCache)) {
            LogUtils.logD(TAG, "getMeid error,can't get meid from device");
            return "";
        }
        if (!StringUtils.isEmpty(fromCache)) {
            LogUtils.logD(TAG, "getMeid from cache");
            return fromCache;
        }
        LogUtils.logD(TAG, "getMeid from device start");
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (Build.VERSION.SDK_INT >= 26) {
                fromCache = telephonyManager.getMeid();
            }
            if (!StringUtils.isEmpty(fromCache)) {
                LogUtils.logD(TAG, "getMeid from device success,cache meid=>" + fromCache);
                putCache(context, KEY_MEID, fromCache);
            } else {
                putCache(context, KEY_MEID, ID_ERROR_IDENTIFY_VALUE);
            }
            return fromCache;
        } catch (Exception unused) {
            LogUtils.logE(TAG, "getMeid invoke error,cache default id error");
            putCache(context, KEY_MEID, ID_ERROR_IDENTIFY_VALUE);
            return null;
        }
    }

    public String getPhoneImsiNum(Context context) {
        LogUtils.logD(TAG, "getPhoneImsiNum invoke");
        String fromCache = getFromCache(context, KEY_IMSI);
        if (isErrorIdentify(fromCache)) {
            LogUtils.logD(TAG, "getPhoneImsiNum error,can't get imsi from device");
            return "";
        }
        if (!StringUtils.isEmpty(fromCache)) {
            LogUtils.logD(TAG, "getPhoneImsiNum from cache");
            return fromCache;
        }
        LogUtils.logD(TAG, "getPhoneImsiNum from device start");
        try {
            String subscriberId = ((TelephonyManager) context.getSystemService("phone")).getSubscriberId();
            if (StringUtils.isEmpty(subscriberId)) {
                putCache(context, KEY_IMSI, ID_ERROR_IDENTIFY_VALUE);
            } else {
                LogUtils.logD(TAG, "getMeid from device success,cache meid=>" + subscriberId);
                putCache(context, KEY_IMSI, subscriberId);
            }
            return subscriberId;
        } catch (Exception unused) {
            LogUtils.logE(TAG, "getMeid invoke error,cache default id error");
            putCache(context, KEY_IMSI, ID_ERROR_IDENTIFY_VALUE);
            return "";
        }
    }

    public String getImsi2(Context context) throws NoSuchFieldException, ClassNotFoundException, SecurityException {
        String subscriberId;
        LogUtils.logD(TAG, "getImsi2 invoke");
        String fromCache = getFromCache(context, KEY_IMSI2);
        if (isErrorIdentify(fromCache)) {
            LogUtils.logD(TAG, "getImsi2 error,can't get imei2 from device");
            return "";
        }
        if (!StringUtils.isEmpty(fromCache)) {
            LogUtils.logD(TAG, "getImsi2 from cache");
            return fromCache;
        }
        LogUtils.logD(TAG, "getImsi2 from device start");
        try {
            if (isHardWareVendorQualcomm()) {
                subscriberId = (String) Class.forName("android.telephony.MSimTelephonyManager").getMethod("getSubscriberId", Integer.TYPE).invoke(context.getSystemService("phone_msim"), 1);
            } else if (isHardWareVendorMediaTek()) {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                Class<?> cls = Class.forName("com.android.internal.telephony.Phone");
                cls.getFields();
                Field field = cls.getField("GEMINI_SIM_2");
                field.setAccessible(true);
                subscriberId = ((TelephonyManager) TelephonyManager.class.getMethod("getDefault", Integer.TYPE).invoke(telephonyManager, (Integer) field.get(null))).getSubscriberId();
            } else if (isHardWareVendorSprd()) {
                Class<?> cls2 = Class.forName("com.android.internal.telephony.PhoneFactory");
                subscriberId = ((TelephonyManager) context.getSystemService((String) cls2.getMethod("getServiceName", String.class, Integer.TYPE).invoke(cls2, "phone", 1))).getSubscriberId();
            } else {
                LogUtils.logD(TAG, "getImsi2 unknow hardword");
                subscriberId = null;
            }
            if (StringUtils.isEmpty(subscriberId)) {
                Object phoneDeviceInfo = getPhoneDeviceInfo(1, "getSubscriberId", context);
                if (phoneDeviceInfo == null) {
                    subscriberId = phoneDeviceInfo.toString();
                }
                if (StringUtils.isEmpty(subscriberId)) {
                    LogUtils.logD(TAG, "getImsi2 error,cache default id error");
                    putCache(context, KEY_IMSI2, ID_ERROR_IDENTIFY_VALUE);
                    return subscriberId;
                }
                LogUtils.logD(TAG, "getImsi2 success,cache it=>" + subscriberId);
                putCache(context, KEY_IMSI2, subscriberId);
                return phoneDeviceInfo.toString();
            }
            LogUtils.logD(TAG, "getImsi2 success,cache it=>" + subscriberId);
            putCache(context, KEY_IMSI2, subscriberId);
            return subscriberId;
        } catch (Exception unused) {
            LogUtils.logE(TAG, "get imsi2 error");
            putCache(context, KEY_IMSI2, ID_ERROR_IDENTIFY_VALUE);
            return null;
        }
    }

    public String getAndroidId(Context context) {
        LogUtils.logD(TAG, "getAndroidId invoke");
        String fromCache = getFromCache(context, KEY_ANDROID_ID);
        if (isErrorIdentify(fromCache)) {
            LogUtils.logD(TAG, "getAndroidId error,can't get androidId from device");
            return "";
        }
        if (!StringUtils.isEmpty(fromCache)) {
            LogUtils.logD(TAG, "getAndroidId from cache=>" + fromCache);
            return fromCache;
        }
        LogUtils.logD(TAG, "getAndroidId from device start");
        String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
        if (StringUtils.isEmpty(string)) {
            LogUtils.logE(TAG, "getAndroidId error，cache default id");
            putCache(context, KEY_ANDROID_ID, ID_ERROR_IDENTIFY_VALUE);
        } else {
            LogUtils.logD(TAG, "getAndroidId success,cache it=>" + string);
            putCache(context, KEY_ANDROID_ID, string);
        }
        return string;
    }

    public String getAndroidVersion() {
        String str = Build.VERSION.RELEASE;
        if (Pattern.compile("[0-9]*").matcher(str).matches()) {
            str = str + ".0";
        }
        if (!OSUtil.isHarmonyOS()) {
            return str;
        }
        return str + "_H" + OSUtil.getCustomOSVersion(OSUtil.getBrandName());
    }

    public String getMobileBrandName() {
        return Build.BRAND;
    }

    public String getMobileBrandModel() {
        String str = Build.MODEL;
        if (!str.contains(" ")) {
            return str;
        }
        String[] strArrSplit = str.split(" ");
        return strArrSplit[0] + Config.replace + strArrSplit[1];
    }

    public String getPhoneUseMobileType(Context context) {
        if (!hasSim(context)) {
            return "has not Sim";
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null) {
            return "manager is null";
        }
        String networkOperator = telephonyManager.getNetworkOperator();
        return !TextUtils.isEmpty(networkOperator) ? ("46001".equals(networkOperator) || "46006".equals(networkOperator) || "46009".equals(networkOperator)) ? KSLiveNetwork.LIANTONG_OPERATOR_NAME : ("46003".equals(networkOperator) || "46005".equals(networkOperator) || "46011".equals(networkOperator)) ? KSLiveNetwork.DIANXIN_OPERATOR_NAME : ("46000".equals(networkOperator) || "46002".equals(networkOperator) || "46004".equals(networkOperator) || "46007".equals(networkOperator)) ? KSLiveNetwork.YIDONG_OPERATOR_NAME : "46015".equals(networkOperator) ? "CBN" : "OTHER" : "MNO is null";
    }

    private static boolean hasSim(Context context) {
        return ((TelephonyManager) context.getSystemService("phone")).getSimState() == 5;
    }

    public String getNetType(Context context) {
        return isPhoneCurrWifiOpen(context) ? "WIFI" : getPhoneUseNetWorkType(context);
    }

    private boolean isPhoneCurrWifiOpen(Context context) {
        WifiInfo connectionInfo;
        WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService(a.a);
        try {
            connectionInfo = wifiManager.getConnectionInfo();
        } catch (Exception e) {
            e.printStackTrace();
            connectionInfo = null;
        }
        return wifiManager.isWifiEnabled() && (connectionInfo == null ? 0 : connectionInfo.getIpAddress()) != 0;
    }

    private String getPhoneUseNetWorkType(Context context) {
        int networkType;
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (Build.VERSION.SDK_INT >= 24) {
            networkType = telephonyManager.getDataNetworkType();
        } else {
            networkType = telephonyManager.getNetworkType();
        }
        switch (networkType) {
            case 0:
                return "UNKNOWN";
            case 1:
                return "GPRS";
            case 2:
                return "EDGE";
            case 3:
                return "UMTS";
            case 4:
                return "CDMA";
            case 5:
                return "EVDO_0";
            case 6:
                return "EVDO_A";
            case 7:
                return "1xRTT";
            case 8:
                return "HSDPA";
            case 9:
                return "HSUPA";
            case 10:
                return "HSPA";
            case 11:
                return "IDEN";
            case 12:
                return "EVDO_B";
            case 13:
                return "LTE";
            case 14:
                return "EHRPD";
            case 15:
                return "HSPAP";
            case 16:
                return "GSM";
            case 17:
                return "TD_SCDMA";
            case 18:
                return "IWLAN";
            case 19:
            default:
                return "NOTYPE";
            case 20:
                return "NR";
        }
    }

    public void setLocationInfo(final Context context, final PhoneInfo phoneInfo) {
        PermissionUtils.requestPermission((Activity) context, 5, new PermissionUtils.PermissionInterface() { // from class: com.fendasz.moku.planet.utils.PhoneInfoUtils.1
            @Override // com.fendasz.moku.planet.utils.PermissionUtils.PermissionInterface
            public void onShouldShowRationale(String[] strArr) {
            }

            @Override // com.fendasz.moku.planet.utils.PermissionUtils.PermissionInterface
            public void onPermissionGranted(int i) {
                Location lastKnownLocation = PhoneInfoUtils.this.getLastKnownLocation(context);
                if (lastKnownLocation != null) {
                    LogUtils.log(PhoneInfoUtils.TAG, "经度 " + lastKnownLocation.getLongitude());
                    LogUtils.log(PhoneInfoUtils.TAG, "纬度 " + lastKnownLocation.getLatitude());
                    phoneInfo.setLocation(lastKnownLocation.getLongitude() + i.b + lastKnownLocation.getLatitude());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Location getLastKnownLocation(Context context) {
        LocationManager locationManager = (LocationManager) context.getApplicationContext().getSystemService("location");
        Iterator<String> it = locationManager.getProviders(true).iterator();
        Location location = null;
        while (it.hasNext()) {
            Location lastKnownLocation = locationManager.getLastKnownLocation(it.next());
            if (lastKnownLocation != null && (location == null || lastKnownLocation.getAccuracy() < location.getAccuracy())) {
                location = lastKnownLocation;
            }
        }
        return location;
    }

    public String getLocalIpAddress(Context context) throws SocketException {
        try {
        } catch (SocketException e) {
            e.printStackTrace();
        }
        if (isPhoneCurrWifiOpen(context)) {
            WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService(a.a);
            if (wifiManager != null) {
                return int2ip(wifiManager.getConnectionInfo().getIpAddress());
            }
            return null;
        }
        Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
        String hostAddress = null;
        while (networkInterfaces.hasMoreElements()) {
            Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
            while (true) {
                if (inetAddresses.hasMoreElements()) {
                    InetAddress inetAddressNextElement = inetAddresses.nextElement();
                    if (!(inetAddressNextElement instanceof Inet6Address) && !"127.0.0.1".equals(inetAddressNextElement.getHostAddress())) {
                        hostAddress = inetAddressNextElement.getHostAddress();
                        break;
                    }
                }
            }
        }
        return hostAddress;
    }

    private static String int2ip(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(i & 255).append(".");
        sb.append((i >> 8) & 255).append(".");
        sb.append((i >> 16) & 255).append(".");
        sb.append((i >> 24) & 255);
        return sb.toString();
    }

    public static boolean isHardWareVendorQualcomm() {
        if (!Build.HARDWARE.matches("qcom")) {
            return false;
        }
        LogUtils.logD(TAG, "Qualcomm platform");
        return true;
    }

    public static boolean isHardWareVendorMediaTek() {
        if (!Build.HARDWARE.matches("mt[0-9]*")) {
            return false;
        }
        LogUtils.logD(TAG, "MediaTek platform");
        return true;
    }

    public static boolean isHardWareVendorSprd() {
        if (!Build.HARDWARE.matches("sp[0-9]*")) {
            return false;
        }
        LogUtils.logD(TAG, "MediaTek platform");
        return true;
    }

    private static Object getPhoneDeviceInfo(int i, String str, Context context) throws NoSuchMethodException, SecurityException {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (Build.VERSION.SDK_INT < 21) {
                return null;
            }
            Method method = telephonyManager.getClass().getMethod(str, SystemUtils.getMethodParamTypes(str));
            if (i >= 0) {
                return method.invoke(telephonyManager, Integer.valueOf(i));
            }
            return null;
        } catch (Exception e) {
            LogUtils.logE(TAG, e.toString());
            return null;
        }
    }

    private static boolean isErrorIdentify(String str) {
        if (StringUtils.isEmpty(str)) {
            return false;
        }
        return ID_ERROR_IDENTIFY_VALUE.equals(str);
    }

    private String getFromCache(Context context, String str) {
        String str2 = cacheMap.get(str);
        if (!StringUtils.isEmpty(str2)) {
            LogUtils.logD(TAG, "getFromCache from cache map");
            return str2;
        }
        LogUtils.logD(TAG, "getFromCache from sp start");
        if (MokuConfigure.getInstance().getMokuOptions(context) == null) {
            return null;
        }
        return SharedPreferencesUtils.getInstance(context).getString(createSPKey(context, str), "");
    }

    private void putCache(Context context, String str, String str2) {
        LogUtils.logD(TAG, "put_cache=>" + str + ",value=>" + str2);
        if (StringUtils.isEmpty(str2) || MokuConfigure.getInstance().getMokuOptions(context) == null) {
            return;
        }
        String strCreateSPKey = createSPKey(context, str);
        cacheMap.put(strCreateSPKey, str2);
        SharedPreferencesUtils.getInstance(context).putString(strCreateSPKey, str2);
    }

    private String createSPKey(Context context, String str) {
        String str2 = MokuConfigure.getInstance().getMokuOptions(context).getString(JumpParam.USER_ID, "") + Config.replace + str + Config.replace + TimeUtil.formatData(new Date(), "yyyy_MM_dd");
        LogUtils.logD(TAG, "createSPKey invoke,key=>" + str2);
        return str2;
    }
}
