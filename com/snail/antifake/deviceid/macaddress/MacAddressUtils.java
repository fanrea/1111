package com.snail.antifake.deviceid.macaddress;

import android.app.Application;
import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.mobads.container.util.e.a;
import com.snail.antifake.deviceid.ShellAdbUtils;
import java.lang.reflect.Method;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class MacAddressUtils {
    public static String getMacAddress(Context context) throws SocketException, IllegalAccessException, NoSuchFieldException, NoSuchMethodException, SecurityException, IllegalArgumentException {
        String macInfoByAdb = getMacInfoByAdb();
        if (!TextUtils.isEmpty(macInfoByAdb)) {
            return macInfoByAdb;
        }
        String macAddressByWlan0 = getMacAddressByWlan0(context);
        if (!TextUtils.isEmpty(macAddressByWlan0)) {
            return macAddressByWlan0;
        }
        String macAddress = IWifiManagerUtil.getMacAddress(context);
        return !TextUtils.isEmpty(macAddress) ? macAddress : "";
    }

    public static String getMacInfoByAdb() {
        return ShellAdbUtils.execCommand("cat /sys/class/net/wlan0/address", false).successMsg;
    }

    private static String getProp(Context context, String str) throws NoSuchMethodException, ClassNotFoundException, SecurityException {
        try {
            Class<?> clsLoadClass = context.getClassLoader().loadClass("android.os.SystemProperties");
            Method declaredMethod = clsLoadClass.getDeclaredMethod("native_get", String.class);
            Object[] objArr = {str};
            declaredMethod.setAccessible(true);
            return (String) declaredMethod.invoke(clsLoadClass, objArr);
        } catch (Exception unused) {
            return null;
        }
    }

    public static String getMacAddressByWlan0(Context context) throws SocketException {
        Enumeration<NetworkInterface> networkInterfaces;
        try {
            networkInterfaces = NetworkInterface.getNetworkInterfaces();
        } catch (SocketException e) {
            e.printStackTrace();
            networkInterfaces = null;
        }
        while (networkInterfaces.hasMoreElements()) {
            NetworkInterface networkInterfaceNextElement = networkInterfaces.nextElement();
            byte[] hardwareAddress = new byte[0];
            if (Build.VERSION.SDK_INT >= 9) {
                try {
                    hardwareAddress = networkInterfaceNextElement.getHardwareAddress();
                } catch (SocketException e2) {
                    e2.printStackTrace();
                }
            }
            if (networkInterfaceNextElement.getDisplayName().equals(getProp(context, "wifi.interface")) && hardwareAddress != null && hardwareAddress.length != 0) {
                StringBuilder sb = new StringBuilder();
                for (byte b : hardwareAddress) {
                    sb.append(String.format("%02X:", Byte.valueOf(b)));
                }
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                return sb.toString();
            }
        }
        return "";
    }

    public static String getConnectedWifiMacAddress(Application application) {
        WifiManager wifiManager = (WifiManager) application.getSystemService(a.a);
        String str = null;
        if (wifiManager != null) {
            List<ScanResult> scanResults = wifiManager.getScanResults();
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            if (scanResults != null && connectionInfo != null) {
                for (int i = 0; i < scanResults.size(); i++) {
                    ScanResult scanResult = scanResults.get(i);
                    if (!TextUtils.isEmpty(connectionInfo.getBSSID()) && connectionInfo.getBSSID().equals(scanResult.BSSID)) {
                        str = scanResult.BSSID;
                    }
                }
            }
        }
        return str;
    }
}
