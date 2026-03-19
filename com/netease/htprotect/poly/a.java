package com.netease.htprotect.poly;

import android.content.Context;
import android.os.Build;
import android.security.keystore.KeyGenParameterSpec;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.ArraySet;
import com.baidu.mobstat.forbes.Config;
import com.bytedance.common.utility.StringEncryptUtils;
import com.netease.htprotect.HTProtect;
import com.netease.htprotect.callback.HTPCallback;
import com.netease.htprotect.p001OO8.Ooo;
import com.netease.htprotect.p001OO8.o0o0;
import com.netease.htprotect.p001OO8.oO;
import com.netease.htprotect.p010Ooo.O8oO888;
import com.netease.htprotect.p023o0O0O.O;
import com.netease.htprotect.result.VResult;
import com.netease.mobsec.xt.ClickHelper;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Inet4Address;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509Certificate;
import java.security.spec.ECGenParameterSpec;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class a {

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private static volatile HTPCallback f187O8oO888 = null;
    public static volatile boolean a = false;

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    private static volatile X509Certificate[] f188Ooo;

    public static void acd(String str) {
        HTProtect.ioctl(19, str);
    }

    public static String cr() throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, ClassNotFoundException, SecurityException, IllegalArgumentException, InvocationTargetException {
        ArrayMap arrayMap;
        try {
            if (Build.VERSION.SDK_INT < 23) {
                return "";
            }
            Field declaredField = Class.forName("android.app.ActivityThread$ActivityClientRecord").getDeclaredField("referrer");
            declaredField.setAccessible(true);
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Method declaredMethod = cls.getDeclaredMethod("currentActivityThread", new Class[0]);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(null, new Object[0]);
            Field declaredField2 = cls.getDeclaredField("mActivities");
            declaredField2.setAccessible(true);
            Object obj = declaredField2.get(objInvoke);
            if (!(obj instanceof ArrayMap) || (arrayMap = (ArrayMap) obj) == null || arrayMap.size() <= 0) {
                return "";
            }
            ArraySet arraySet = new ArraySet();
            int i = 0;
            for (Object obj2 : arrayMap.values().toArray()) {
                if (i > 50 || arraySet.size() > 10) {
                    break;
                }
                if (obj2 != null) {
                    String str = (String) declaredField.get(obj2);
                    if (!TextUtils.isEmpty(str)) {
                        arraySet.add(str);
                    }
                    i++;
                }
            }
            return TextUtils.join(",", arraySet);
        } catch (Exception unused) {
            return "";
        }
    }

    public static String d() {
        return oO.m502O8();
    }

    public static void din(Context context) {
        Ooo.m491O8oO888(context);
    }

    public static int e(int i) {
        return ClickHelper.get().startHook(i);
    }

    public static String f() {
        return ClickHelper.get().getClickInfos();
    }

    public static byte[] g(byte[] bArr, String str, HashMap map, int i, int i2) {
        return com.netease.htprotect.Oo0.Ooo.m517O8oO888(bArr, str, map, i2);
    }

    public static boolean ga(String str, String str2, String str3, boolean z) throws NoSuchAlgorithmException, IOException, KeyStoreException, CertificateException {
        try {
            KeyStore keyStore = KeyStore.getInstance(str2);
            keyStore.load(null);
            Certificate[] certificateChain = keyStore.getCertificateChain(str);
            if (certificateChain == null) {
                ge(str, str2, str3, z);
                certificateChain = keyStore.getCertificateChain(str);
            }
            if (certificateChain == null) {
                return false;
            }
            int length = certificateChain.length;
            f188Ooo = new X509Certificate[length];
            for (int i = 0; i < length; i++) {
                Certificate certificate = certificateChain[i];
                if (certificate == null) {
                    return false;
                }
                f188Ooo[i] = (X509Certificate) certificate;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static void ge(String str, String str2, String str3, boolean z) throws NoSuchAlgorithmException, NoSuchProviderException, InvalidAlgorithmParameterException {
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("EC", str2);
                KeyGenParameterSpec.Builder digests = new KeyGenParameterSpec.Builder(str, 4).setAlgorithmParameterSpec(new ECGenParameterSpec(str3)).setUserAuthenticationRequired(false).setDigests("NONE", StringEncryptUtils.SHA_256);
                if (Build.VERSION.SDK_INT >= 24) {
                    byte[] bArr = new byte[32];
                    new SecureRandom().nextBytes(bArr);
                    digests.setAttestationChallenge(bArr);
                }
                if (Build.VERSION.SDK_INT >= 28 && z) {
                    digests.setIsStrongBoxBacked(true);
                }
                keyPairGenerator.initialize(digests.build());
                keyPairGenerator.generateKeyPair();
            }
        } catch (Exception unused) {
        }
    }

    public static byte[] gn() {
        if (f188Ooo != null && f188Ooo.length > 0) {
            try {
                return f188Ooo[0].getEncoded();
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static int gni() {
        short networkPrefixLength = -1;
        try {
            Iterator it = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
            while (it.hasNext()) {
                NetworkInterface networkInterface = (NetworkInterface) it.next();
                if (networkInterface.getName().equalsIgnoreCase("wlan0")) {
                    for (InterfaceAddress interfaceAddress : networkInterface.getInterfaceAddresses()) {
                        if (interfaceAddress.getAddress() instanceof Inet4Address) {
                            networkPrefixLength = interfaceAddress.getNetworkPrefixLength();
                        }
                    }
                }
            }
        } catch (Exception unused) {
        }
        return networkPrefixLength;
    }

    public static byte[] h(String str, HashMap map, int i, int i2) {
        return com.netease.htprotect.Oo0.Ooo.m516O8oO888(str, map, i2);
    }

    public static String i() {
        return oO.m503Ooo();
    }

    public static String in(String str, boolean z, boolean z2) {
        String string;
        O8oO888 o8oO888M721O8oO888 = O8oO888.m721O8oO888(str);
        JSONObject jSONObject = new JSONObject();
        if (z) {
            try {
                try {
                    Object obj = o8oO888M721O8oO888.m729Ooo().f319Ooo;
                    if (obj != null) {
                        jSONObject.put("la", obj);
                    }
                } catch (Throwable th) {
                    o8oO888M721O8oO888.close();
                    throw th;
                }
            } catch (Exception unused) {
                string = "";
            }
        }
        if (z2) {
            JSONArray jSONArray = new JSONArray();
            List list = o8oO888M721O8oO888.m729Ooo().f313o0o8;
            jSONObject.put("pers", list.size());
            Iterator it = list.iterator();
            while (it.hasNext()) {
                jSONArray.put((String) it.next());
            }
            jSONObject.put("per", jSONArray);
            JSONArray jSONArray2 = new JSONArray();
            List<com.netease.htprotect.p010Ooo.p013Ooo.O8oO888> list2 = o8oO888M721O8oO888.m728O8oO888().f304O8;
            jSONObject.put("sers", list2.size());
            for (com.netease.htprotect.p010Ooo.p013Ooo.O8oO888 o8oO888 : list2) {
                if (o8oO888.f287 != null) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("per", o8oO888.f287);
                    jSONObject2.put("nam", o8oO888.f285oO);
                    jSONArray2.put(jSONObject2);
                }
            }
            jSONObject.put("ser", jSONArray2);
            jSONObject.put("acts", o8oO888M721O8oO888.m728O8oO888().f303O8oO888.size());
            jSONObject.put("pros", o8oO888M721O8oO888.m728O8oO888().f306o0o0.size());
            jSONObject.put("recs", o8oO888M721O8oO888.m728O8oO888().f305Ooo.size());
            jSONObject.put("mets", o8oO888M721O8oO888.m729Ooo().f31680.size());
        }
        if (o8oO888M721O8oO888.m729Ooo().Oo0 != null) {
            jSONObject.put("sha", o8oO888M721O8oO888.m729Ooo().Oo0);
        }
        if (o8oO888M721O8oO888.m729Ooo().f31680.containsKey("xposedmodule")) {
            jSONObject.put(Config.EVENT_HEAT_XP, Integer.parseInt((String) o8oO888M721O8oO888.m729Ooo().f31680.get("xposedminversion")));
        }
        Object obj2 = o8oO888M721O8oO888.m729Ooo().f322o0O0O;
        if (obj2 != null) {
            jSONObject.put("min", obj2);
        }
        Object obj3 = o8oO888M721O8oO888.m729Ooo().f323;
        if (obj3 != null) {
            jSONObject.put("tar", obj3);
        }
        string = jSONObject.toString();
        try {
            o8oO888M721O8oO888.close();
        } catch (Exception unused2) {
        }
        o8oO888M721O8oO888.close();
        return string;
    }

    public static void m(boolean z, int i, int i2, int i3, int i4, int i5) {
        O.m1148O8oO888().m1161O8oO888(z, i, i2, i3, i4, i5);
    }

    public static String main2(int i, Context context) {
        return o0o0.m494O8oO888(i, context);
    }

    public static boolean n(Context context, boolean z) {
        return com.netease.htprotect.p023o0O0O.Ooo.m1168O8oO888(context);
    }

    public static void s(HTPCallback hTPCallback) {
        f187O8oO888 = hTPCallback;
    }

    public static int sbh(Context context) {
        return com.netease.htprotect.p019o0o0.O8oO888.m1088O8oO888(context);
    }

    public static int v(byte[] bArr, byte[] bArr2) throws CertificateNotYetValidException, CertificateExpiredException {
        if (f188Ooo == null || f188Ooo.length <= 0) {
            return -1;
        }
        X509Certificate[] x509CertificateArr = f188Ooo;
        X509Certificate x509Certificate = x509CertificateArr[x509CertificateArr.length - 1];
        int length = f188Ooo.length - 1;
        while (length >= 0) {
            X509Certificate x509Certificate2 = f188Ooo[length];
            try {
                x509Certificate2.checkValidity();
                x509Certificate2.verify(x509Certificate.getPublicKey());
                length--;
                x509Certificate = x509Certificate2;
            } catch (Exception unused) {
                return -1;
            }
        }
        byte[] encoded = f188Ooo[f188Ooo.length - 1].getPublicKey().getEncoded();
        if (Arrays.equals(encoded, bArr)) {
            return 2;
        }
        return Arrays.equals(encoded, bArr2) ? 1 : 0;
    }

    public static VResult vs(String str, int i, int i2) {
        return com.netease.htprotect.p024.O8oO888.m1176O8oO888(str, i, i2);
    }

    public static void wdo() throws InterruptedException {
        oO.m500O8oO888();
    }

    public static void wli(String str) {
        HTProtect.ioctl(21, str);
    }

    public static void y(int i, String str) {
        if (f187O8oO888 != null) {
            f187O8oO888.onReceive(i, str);
        }
    }

    public static void z(String str) {
        HTProtect.ioctl(18, str);
    }
}
