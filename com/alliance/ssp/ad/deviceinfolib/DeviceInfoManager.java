package com.alliance.ssp.ad.deviceinfolib;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class DeviceInfoManager {
    public static String a = "";
    public static String b = "";
    public static String c = "";
    public static String d = "";
    public static String e = "";

    public static class ApplicationPO {
        private String app_name;
        private String package_name;
        private String timestamp;
        private String version;

        public String getApp_name() {
            return this.app_name;
        }

        public String getPackage_name() {
            return this.package_name;
        }

        public String getTimestamp() {
            return this.timestamp;
        }

        public String getVersion() {
            return this.version;
        }

        public void setApp_name(String str) {
            this.app_name = str;
        }

        public void setPackage_name(String str) {
            this.package_name = str;
        }

        public void setTimestamp(String str) {
            this.timestamp = str;
        }

        public void setVersion(String str) {
            this.version = str;
        }
    }

    public static String a() {
        String str = b;
        if (str != null && !str.isEmpty()) {
            return b;
        }
        try {
            b = String.valueOf(TimeZone.getDefault().getRawOffset() / 1000);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return b;
    }

    public static String b(Context context) {
        ArrayList arrayList = new ArrayList();
        List<PackageInfo> installedPackages = context.getPackageManager().getInstalledPackages(0);
        for (int i = 0; i < installedPackages.size(); i++) {
            PackageInfo packageInfo = installedPackages.get(i);
            if ((packageInfo.applicationInfo.flags & 1) == 0) {
                ApplicationPO applicationPO = new ApplicationPO();
                applicationPO.setApp_name(packageInfo.applicationInfo.loadLabel(context.getPackageManager()).toString());
                applicationPO.setPackage_name(packageInfo.packageName);
                applicationPO.setVersion(packageInfo.versionName);
                applicationPO.setTimestamp(packageInfo.firstInstallTime + "");
                arrayList.add(applicationPO);
            }
        }
        return new Gson().toJson(arrayList);
    }

    public static String c(Context context) {
        String str = e;
        if (str != null && !str.isEmpty()) {
            return e;
        }
        if (context == null) {
            return "";
        }
        try {
            e = context.getResources().getConfiguration().locale.toString();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return e;
    }

    public static String a(Context context) {
        String str = d;
        if (str != null && !str.isEmpty()) {
            return d;
        }
        if (context == null) {
            return "";
        }
        try {
            d = context.getResources().getConfiguration().locale.getCountry();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return d;
    }
}
