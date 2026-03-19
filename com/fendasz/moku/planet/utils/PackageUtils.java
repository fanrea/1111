package com.fendasz.moku.planet.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class PackageUtils {
    public static String getMetaDataFromApp(Context context, String str) throws PackageManager.NameNotFoundException {
        ApplicationInfo applicationInfo;
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            applicationInfo = null;
        }
        return applicationInfo != null ? applicationInfo.metaData.getString(str) : "";
    }

    public static List<String> getManifestPermissions(Context context) throws PackageManager.NameNotFoundException {
        PackageInfo packageInfo;
        String[] strArr;
        ArrayList arrayList = new ArrayList();
        try {
            packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            packageInfo = null;
        }
        if (packageInfo != null && (strArr = packageInfo.requestedPermissions) != null) {
            arrayList.addAll(Arrays.asList(strArr));
        }
        return arrayList;
    }

    public String getSHA1Signature(Context context) {
        byte[] byteArray;
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                byteArray = context.getPackageManager().getPackageInfo(context.getPackageName(), 134217728).signingInfo.getApkContentsSigners()[0].toByteArray();
            } else {
                byteArray = context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures[0].toByteArray();
            }
            byte[] bArrDigest = MessageDigest.getInstance("SHA1").digest(byteArray);
            StringBuilder sb = new StringBuilder();
            for (byte b : bArrDigest) {
                String upperCase = Integer.toHexString(b & 255).toUpperCase(Locale.US);
                if (upperCase.length() == 1) {
                    sb.append("0");
                }
                sb.append(upperCase);
                sb.append(":");
            }
            return sb.toString();
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
