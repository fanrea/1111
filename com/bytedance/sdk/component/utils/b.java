package com.bytedance.sdk.component.utils;

import android.content.Context;
import android.content.pm.Signature;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class b {
    private static HashMap<String, ArrayList<String>> d = new HashMap<>();

    public static ArrayList<String> d(Context context, String str) {
        ArrayList<String> arrayList = null;
        if (context != null && str != null) {
            String packageName = context.getPackageName();
            if (packageName == null) {
                return null;
            }
            if (d.get(str) != null) {
                return d.get(str);
            }
            arrayList = new ArrayList<>();
            try {
                for (Signature signature : hc(context, packageName)) {
                    String strD = "error!";
                    if ("MD5".equals(str)) {
                        strD = d(signature, "MD5");
                    } else if ("SHA1".equals(str)) {
                        strD = d(signature, "SHA1");
                    } else if ("SHA256".equals(str)) {
                        strD = d(signature, "SHA256");
                    }
                    arrayList.add(strD);
                }
            } catch (Exception e) {
                mq.b(e.toString());
            }
            d.put(str, arrayList);
        }
        return arrayList;
    }

    public static String d(Context context) {
        StringBuilder sb = new StringBuilder();
        ArrayList<String> arrayListD = d(context, "SHA1");
        if (arrayListD != null && arrayListD.size() != 0) {
            for (int i = 0; i < arrayListD.size(); i++) {
                sb.append(arrayListD.get(i));
                if (i < arrayListD.size() - 1) {
                    sb.append(",");
                }
            }
        }
        return sb.toString();
    }

    private static Signature[] hc(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 64).signatures;
        } catch (Exception e) {
            mq.b(e.toString());
            return null;
        }
    }

    private static String d(Signature signature, String str) throws NoSuchAlgorithmException {
        byte[] byteArray = signature.toByteArray();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            if (messageDigest == null) {
                return "error!";
            }
            byte[] bArrDigest = messageDigest.digest(byteArray);
            StringBuilder sb = new StringBuilder();
            for (byte b : bArrDigest) {
                sb.append(Integer.toHexString((b & 255) | 256).substring(1, 3).toUpperCase());
                sb.append(":");
            }
            return sb.substring(0, sb.length() - 1).toString();
        } catch (Exception e) {
            mq.b(e.toString());
            return "error!";
        }
    }
}
