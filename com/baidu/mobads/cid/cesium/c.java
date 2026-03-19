package com.baidu.mobads.cid.cesium;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import java.security.InvalidKeyException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import javax.crypto.NoSuchPaddingException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class c {
    private com.baidu.mobads.cid.cesium.c.d.d a;
    private List<b> b;

    public c() {
        a();
    }

    private static String a(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("Argument b ( byte array ) is null! ");
        }
        String string = "";
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            string = (hexString.length() == 1 ? new StringBuilder().append(string).append("0") : new StringBuilder().append(string)).append(hexString).toString();
        }
        return string.toLowerCase();
    }

    private void a() {
        this.a = new com.baidu.mobads.cid.cesium.c.d.e(d.a(), d.b());
    }

    private boolean a(String[] strArr, String[] strArr2) {
        if (strArr == null || strArr2 == null || strArr.length != strArr2.length) {
            return false;
        }
        HashSet hashSet = new HashSet();
        for (String str : strArr) {
            hashSet.add(str);
        }
        HashSet hashSet2 = new HashSet();
        for (String str2 : strArr2) {
            hashSet2.add(str2);
        }
        return hashSet.equals(hashSet2);
    }

    private static byte[] a(byte[] bArr, com.baidu.mobads.cid.cesium.c.d.d dVar) throws NoSuchPaddingException, InvalidKeyException {
        com.baidu.mobads.cid.cesium.c.d.a aVarA = com.baidu.mobads.cid.cesium.c.d.a.a();
        aVarA.a(2, dVar);
        return aVarA.a(bArr);
    }

    private String[] a(Signature[] signatureArr) {
        int length = signatureArr.length;
        String[] strArr = new String[length];
        for (int i = 0; i < length; i++) {
            strArr[i] = a(com.baidu.mobads.cid.cesium.d.c.a(signatureArr[i].toByteArray()));
        }
        return strArr;
    }

    List<b> a(Context context, Intent intent, boolean z) throws JSONException, PackageManager.NameNotFoundException {
        ArrayList arrayList = new ArrayList();
        PackageManager packageManager = context.getPackageManager();
        List<ResolveInfo> listQueryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent, 0);
        if (listQueryBroadcastReceivers != null) {
            for (ResolveInfo resolveInfo : listQueryBroadcastReceivers) {
                if (resolveInfo.activityInfo != null && resolveInfo.activityInfo.applicationInfo != null) {
                    try {
                        Bundle bundle = packageManager.getReceiverInfo(new ComponentName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name), 128).metaData;
                        if (bundle != null) {
                            String string = bundle.getString("galaxy_data");
                            if (!TextUtils.isEmpty(string)) {
                                byte[] bArrA = com.baidu.mobads.cid.cesium.d.a.a(string.getBytes("utf-8"));
                                JSONObject jSONObject = new JSONObject(new String(bArrA));
                                b bVar = new b();
                                bVar.b = jSONObject.getInt("priority");
                                bVar.a = resolveInfo.activityInfo.applicationInfo;
                                if (context.getPackageName().equals(resolveInfo.activityInfo.applicationInfo.packageName)) {
                                    bVar.d = true;
                                }
                                if (z) {
                                    String string2 = bundle.getString("galaxy_sf");
                                    if (!TextUtils.isEmpty(string2)) {
                                        PackageInfo packageInfo = packageManager.getPackageInfo(resolveInfo.activityInfo.applicationInfo.packageName, 64);
                                        JSONArray jSONArray = jSONObject.getJSONArray("sigs");
                                        int length = jSONArray.length();
                                        String[] strArr = new String[length];
                                        for (int i = 0; i < length; i++) {
                                            strArr[i] = jSONArray.getString(i);
                                        }
                                        if (a(strArr, a(packageInfo.signatures))) {
                                            byte[] bArrA2 = a(com.baidu.mobads.cid.cesium.d.a.a(string2.getBytes()), this.a);
                                            byte[] bArrA3 = com.baidu.mobads.cid.cesium.d.c.a(bArrA);
                                            if (bArrA2 != null && Arrays.equals(bArrA2, bArrA3)) {
                                                bVar.c = true;
                                            }
                                        }
                                    }
                                }
                                arrayList.add(bVar);
                            }
                        }
                    } catch (Exception e) {
                    }
                }
            }
        }
        Collections.sort(arrayList, new Comparator<b>() { // from class: com.baidu.mobads.cid.cesium.c.1
            @Override // java.util.Comparator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public int compare(b bVar2, b bVar3) {
                int i2 = bVar3.b - bVar2.b;
                if (i2 == 0) {
                    if (bVar2.d && bVar3.d) {
                        return 0;
                    }
                    if (bVar2.d) {
                        return -1;
                    }
                    if (bVar3.d) {
                        return 1;
                    }
                }
                return i2;
            }
        });
        return arrayList;
    }

    public boolean a(Context context) throws JSONException, PackageManager.NameNotFoundException {
        List<b> listA = a(context, new Intent("com.baidu.intent.action.GALAXY").setPackage(context.getPackageName()), true);
        if (listA == null || listA.size() == 0) {
            for (int i = 0; i < 3; i++) {
                Log.w("CuidBuddyInfoManager", "galaxy lib host missing meta-data,make sure you know the right way to integrate galaxy");
            }
            return false;
        }
        b bVar = listA.get(0);
        boolean z = bVar.c;
        if (!bVar.c) {
            for (int i2 = 0; i2 < 3; i2++) {
                Log.w("CuidBuddyInfoManager", "galaxy config err, In the release version of the signature should be matched");
            }
        }
        return z;
    }

    List<b> b(Context context) {
        if (this.b != null) {
            return this.b;
        }
        a(context);
        List<b> listA = a(context, new Intent("com.baidu.intent.action.GALAXY"), true);
        this.b = listA;
        return listA;
    }
}
