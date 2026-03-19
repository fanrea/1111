package com.netease.htprotect;

import android.content.Context;
import android.content.res.Configuration;
import android.util.Base64;
import android.util.Pair;
import android.view.View;
import com.netease.htprotect.callback.GetTokenCallback;
import com.netease.htprotect.callback.HTPCallback;
import com.netease.htprotect.mobsec.WatchMan;
import com.netease.htprotect.p001OO8.o0O0O;
import com.netease.htprotect.p001OO8.oO;
import com.netease.htprotect.p020oO.O8oO888;
import com.netease.htprotect.p020oO.Ooo;
import com.netease.htprotect.poly.a;
import com.netease.htprotect.result.AntiCheatResult;
import com.netease.htprotect.result.SafeCommResult;
import com.netease.mobsec.xt.ClickHelper;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class HTProtect {

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private static boolean f20O8oO888 = false;
    private static String Oo0 = null;

    /* renamed from: 〇O, reason: contains not printable characters */
    private static HTProtectConfig f21O = null;

    /* renamed from: 〇O8, reason: contains not printable characters */
    private static volatile O8oO888 f22O8 = null;

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    private static boolean f23Ooo = false;

    /* renamed from: 〇o0〇o0, reason: contains not printable characters */
    private static com.netease.htprotect.factory.O8oO888 f24o0o0 = new com.netease.htprotect.factory.O8oO888();

    /* renamed from: 〇oO, reason: contains not printable characters */
    private static Context f25oO;

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private static SafeCommResult m471O8oO888(int i, int i2, byte[] bArr) {
        SafeCommResult safeCommResult;
        int i3;
        byte[] bArrM529O8oO888;
        SafeCommResult safeCommResult2;
        if (!f20O8oO888) {
            safeCommResult = new SafeCommResult();
            i3 = -201;
        } else {
            if (bArr != null && bArr.length != 0) {
                synchronized (HTProtect.class) {
                    bArrM529O8oO888 = f24o0o0.m529O8oO888(bArr, i, i2, true, 2, false);
                }
                int iM487O8oO888 = com.netease.htprotect.p001OO8.O8oO888.m487O8oO888(bArrM529O8oO888);
                if (iM487O8oO888 == 0) {
                    safeCommResult2 = new SafeCommResult(bArrM529O8oO888.length - 4);
                    safeCommResult2.ret = iM487O8oO888;
                    System.arraycopy(bArrM529O8oO888, 4, safeCommResult2.decResult, 0, bArrM529O8oO888.length - 4);
                } else {
                    safeCommResult2 = new SafeCommResult();
                    safeCommResult2.ret = iM487O8oO888;
                }
                return safeCommResult2;
            }
            safeCommResult = new SafeCommResult();
            i3 = -4;
        }
        safeCommResult.ret = i3;
        return safeCommResult;
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private static SafeCommResult m472O8oO888(int i, byte[] bArr, boolean z, int i2, boolean z2) {
        SafeCommResult safeCommResult;
        int i3;
        byte[] bArrM529O8oO888;
        SafeCommResult safeCommResult2;
        if (!f20O8oO888) {
            safeCommResult = new SafeCommResult();
            i3 = -201;
        } else {
            if (bArr != null && bArr.length != 0) {
                synchronized (HTProtect.class) {
                    bArrM529O8oO888 = f24o0o0.m529O8oO888(bArr, i, 0, false, i2, z2);
                }
                int iM487O8oO888 = com.netease.htprotect.p001OO8.O8oO888.m487O8oO888(bArrM529O8oO888);
                if (iM487O8oO888 == 0) {
                    safeCommResult2 = new SafeCommResult(bArrM529O8oO888.length - 4, z);
                    safeCommResult2.ret = iM487O8oO888;
                    if (z) {
                        safeCommResult2.encResult = Base64.encodeToString(bArrM529O8oO888, 4, bArrM529O8oO888.length - 4, 2);
                    } else {
                        System.arraycopy(bArrM529O8oO888, 4, safeCommResult2.encBytes, 0, bArrM529O8oO888.length - 4);
                    }
                } else {
                    safeCommResult2 = new SafeCommResult();
                    safeCommResult2.ret = iM487O8oO888;
                }
                return safeCommResult2;
            }
            safeCommResult = new SafeCommResult();
            i3 = -4;
        }
        safeCommResult.ret = i3;
        return safeCommResult;
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private static O8oO888 m473O8oO888() {
        if (f22O8 == null) {
            f22O8 = new Ooo();
        }
        return f22O8;
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private static void m474O8oO888(Context context, String str, String str2) {
        try {
            com.netease.htprotect.necrash.Ooo.m625O8oO888(context, str, str2);
        } catch (Exception unused) {
        }
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private static boolean m475O8oO888(Context context) throws NoSuchMethodException, IOException, SecurityException {
        String strM477Ooo = m477Ooo();
        if (strM477Ooo == null) {
            strM477Ooo = m476O8();
        }
        if (strM477Ooo == null) {
            return false;
        }
        return context.getPackageName().equals(strM477Ooo);
    }

    public static InputStream calcResource(Context context, InputStream inputStream) {
        InputStream inputStreamM521O8oO888;
        if (!f20O8oO888) {
            return null;
        }
        synchronized (HTProtect.class) {
            inputStreamM521O8oO888 = f24o0o0.m521O8oO888(inputStream);
        }
        return inputStreamM521O8oO888;
    }

    public static String getDataSign(String str, int i) {
        String strM523O8oO888 = "";
        synchronized (HTProtect.class) {
            if (f20O8oO888) {
                try {
                    strM523O8oO888 = f24o0o0.m523O8oO888(str, i);
                } catch (UnsatisfiedLinkError unused) {
                }
            }
        }
        return strM523O8oO888;
    }

    public static AntiCheatResult getToken(int i, String str) {
        if (!f20O8oO888) {
            return new AntiCheatResult("", 201, AntiCheatResult.ERROR_NOT_INIT_STR, "");
        }
        Context context = f25oO;
        if (context != null) {
            oO.m501O8oO888(context);
        }
        return WatchMan.getInstance().getToken(f24o0o0, i, str);
    }

    public static void getTokenAsync(int i, String str, GetTokenCallback getTokenCallback) {
        if (!f20O8oO888) {
            getTokenCallback.onResult(new AntiCheatResult("", 201, AntiCheatResult.ERROR_NOT_INIT_STR, ""));
            return;
        }
        Context context = f25oO;
        if (context != null) {
            oO.m501O8oO888(context);
        }
        WatchMan.getInstance().getTokenAsync(f24o0o0, i, str, getTokenCallback);
    }

    public static void init(Context context, String str, HTPCallback hTPCallback, HTProtectConfig hTProtectConfig) throws Throwable {
        f25oO = context;
        Oo0 = str;
        f21O = hTProtectConfig;
        String strM477Ooo = m477Ooo();
        if (strM477Ooo == null) {
            strM477Ooo = m476O8();
        }
        if (strM477Ooo == null ? false : context.getPackageName().equals(strM477Ooo)) {
            f23Ooo = true;
        }
        try {
            com.netease.htprotect.necrash.Ooo.m625O8oO888(context, str, BuildConfig.VERSION_NAME);
        } catch (Exception unused) {
        }
        if (f20O8oO888 || !f23Ooo) {
            return;
        }
        initOutMainProcess(context, str, hTPCallback, hTProtectConfig);
    }

    public static void initOutMainProcess(Context context, String str, HTPCallback hTPCallback, HTProtectConfig hTProtectConfig) throws Throwable {
        if (f25oO == null) {
            f25oO = context;
        }
        m473O8oO888().mo1091O8oO888(context);
        a.s(hTPCallback);
        f24o0o0.m525O8oO888(context, str, hTPCallback, hTProtectConfig);
        ClickHelper.get().init(context);
        f20O8oO888 = true;
    }

    public static String ioctl(int i, String str) {
        String strM522O8oO888 = "";
        synchronized (HTProtect.class) {
            if (f20O8oO888) {
                try {
                    strM522O8oO888 = f24o0o0.m522O8oO888(i, str);
                } catch (UnsatisfiedLinkError unused) {
                    m473O8oO888().mo1091O8oO888(f25oO);
                    f24o0o0.m525O8oO888(f25oO, Oo0, null, f21O);
                    strM522O8oO888 = f24o0o0.m522O8oO888(i, str);
                }
            }
        }
        return strM522O8oO888;
    }

    public static byte[] localSaveBytesDecode(String str, int i) {
        return Base64.decode(localSaveDecode(str, i).getBytes(), 0);
    }

    public static String localSaveBytesEncode(byte[] bArr, int i) {
        return localSaveEncode(new String(Base64.encode(bArr, 0)), i);
    }

    public static String localSaveDecode(String str, int i) {
        String strM530O8 = "";
        synchronized (HTProtect.class) {
            if (f20O8oO888) {
                try {
                    strM530O8 = f24o0o0.m530O8(str, i);
                } catch (UnsatisfiedLinkError unused) {
                }
            }
        }
        return strM530O8;
    }

    public static String localSaveEncode(String str, int i) {
        String strM531Ooo = "";
        synchronized (HTProtect.class) {
            if (f20O8oO888) {
                try {
                    strM531Ooo = f24o0o0.m531Ooo(str, i);
                } catch (UnsatisfiedLinkError unused) {
                }
            }
        }
        return strM531Ooo;
    }

    public static void logOut() {
        synchronized (HTProtect.class) {
            if (f20O8oO888) {
                try {
                    f24o0o0.m524O8oO888();
                } catch (UnsatisfiedLinkError unused) {
                }
            }
        }
    }

    public static void registerTouchEvent(int i, int i2) {
        synchronized (HTProtect.class) {
            if (f20O8oO888) {
                try {
                    Configuration configuration = f25oO.getResources().getConfiguration();
                    Pair pairM506O8oO888 = o0O0O.m506O8oO888(f25oO);
                    f24o0o0.m526O8oO888(true, configuration.orientation, ((Integer) pairM506O8oO888.first).intValue(), ((Integer) pairM506O8oO888.second).intValue(), i, i2);
                } catch (UnsatisfiedLinkError unused) {
                }
            }
        }
    }

    public static String safeComm(String str, int i, boolean z) {
        byte[] bArrM528O8oO888;
        if (!f20O8oO888) {
            return null;
        }
        synchronized (HTProtect.class) {
            bArrM528O8oO888 = f24o0o0.m528O8oO888(str, i, z);
        }
        if (bArrM528O8oO888 == null) {
            return null;
        }
        return new String(bArrM528O8oO888);
    }

    public static SafeCommResult safeCommFromServer(int i, int i2, String str) {
        SafeCommResult safeCommResult;
        if (str == null || str.length() == 0) {
            safeCommResult = new SafeCommResult();
        } else {
            try {
                return m471O8oO888(i, i2, Base64.decode(str, 2));
            } catch (Exception unused) {
                safeCommResult = new SafeCommResult();
            }
        }
        safeCommResult.ret = -4;
        return safeCommResult;
    }

    public static SafeCommResult safeCommFromServerByte(int i, int i2, byte[] bArr) {
        return m471O8oO888(i, i2, bArr);
    }

    public static SafeCommResult safeCommFromServerCSharp(int i, int i2, String str) {
        byte[] bArrM529O8oO888;
        if (!f20O8oO888) {
            SafeCommResult safeCommResult = new SafeCommResult();
            safeCommResult.ret = -201;
            return safeCommResult;
        }
        if (str == null || str.length() == 0) {
            SafeCommResult safeCommResult2 = new SafeCommResult();
            safeCommResult2.ret = -4;
            return safeCommResult2;
        }
        try {
            byte[] bArrDecode = Base64.decode(str, 2);
            synchronized (HTProtect.class) {
                bArrM529O8oO888 = f24o0o0.m529O8oO888(bArrDecode, i, i2, true, 2, false);
            }
            int iM487O8oO888 = com.netease.htprotect.p001OO8.O8oO888.m487O8oO888(bArrM529O8oO888);
            SafeCommResult safeCommResult3 = new SafeCommResult();
            safeCommResult3.ret = iM487O8oO888;
            if (iM487O8oO888 == 0) {
                safeCommResult3.encResult = Base64.encodeToString(bArrM529O8oO888, 4, bArrM529O8oO888.length - 4, 2);
            }
            return safeCommResult3;
        } catch (Exception unused) {
            SafeCommResult safeCommResult4 = new SafeCommResult();
            safeCommResult4.ret = -4;
            return safeCommResult4;
        }
    }

    public static SafeCommResult safeCommToServer(int i, byte[] bArr) {
        return m472O8oO888(i, bArr, true, 2, false);
    }

    public static SafeCommResult safeCommToServerByte(int i, byte[] bArr) {
        return m472O8oO888(i, bArr, false, 2, false);
    }

    public static SafeCommResult safeCommToServerByteV30(int i, int i2, byte[] bArr, boolean z) {
        return m472O8oO888(i2, bArr, false, i, z);
    }

    public static SafeCommResult safeCommToServerCSharp(int i, String str) {
        byte[] bArrM529O8oO888;
        if (!f20O8oO888) {
            SafeCommResult safeCommResult = new SafeCommResult();
            safeCommResult.ret = -201;
            return safeCommResult;
        }
        if (str == null || str.length() == 0) {
            SafeCommResult safeCommResult2 = new SafeCommResult();
            safeCommResult2.ret = -4;
            return safeCommResult2;
        }
        try {
            byte[] bArrDecode = Base64.decode(str, 2);
            synchronized (HTProtect.class) {
                bArrM529O8oO888 = f24o0o0.m529O8oO888(bArrDecode, i, 0, false, 2, false);
            }
            int iM487O8oO888 = com.netease.htprotect.p001OO8.O8oO888.m487O8oO888(bArrM529O8oO888);
            SafeCommResult safeCommResult3 = new SafeCommResult();
            safeCommResult3.ret = iM487O8oO888;
            if (iM487O8oO888 == 0) {
                safeCommResult3.encResult = Base64.encodeToString(bArrM529O8oO888, 4, bArrM529O8oO888.length - 4, 2);
            }
            return safeCommResult3;
        } catch (Exception unused) {
            SafeCommResult safeCommResult4 = new SafeCommResult();
            safeCommResult4.ret = -4;
            return safeCommResult4;
        }
    }

    public static SafeCommResult safeCommToServerCSharpByte(int i, byte[] bArr, boolean z, int i2, boolean z2) {
        SafeCommResult safeCommResult;
        int i3;
        SafeCommResult safeCommResult2;
        if (!f20O8oO888) {
            safeCommResult = new SafeCommResult();
            i3 = -201;
        } else {
            if (bArr != null && bArr.length != 0) {
                byte[] bArrM529O8oO888 = f24o0o0.m529O8oO888(bArr, i, 0, false, i2, z2);
                int iM487O8oO888 = com.netease.htprotect.p001OO8.O8oO888.m487O8oO888(bArrM529O8oO888);
                if (iM487O8oO888 == 0) {
                    safeCommResult2 = new SafeCommResult(bArrM529O8oO888.length - 4, z);
                    safeCommResult2.ret = iM487O8oO888;
                    if (z) {
                        safeCommResult2.encResult = Base64.encodeToString(bArrM529O8oO888, 4, bArrM529O8oO888.length - 4, 2);
                    } else {
                        System.arraycopy(bArrM529O8oO888, 4, safeCommResult2.encBytes, 0, bArrM529O8oO888.length - 4);
                    }
                } else {
                    safeCommResult2 = new SafeCommResult();
                    safeCommResult2.ret = iM487O8oO888;
                }
                return safeCommResult2;
            }
            safeCommResult = new SafeCommResult();
            i3 = -4;
        }
        safeCommResult.ret = i3;
        return safeCommResult;
    }

    public static SafeCommResult safeCommToServerV30(int i, int i2, byte[] bArr, boolean z) {
        return m472O8oO888(i2, bArr, true, i, z);
    }

    public static int setRoleInfo(String str, String str2, String str3, String str4, String str5, int i, String str6) {
        String str7;
        synchronized (HTProtect.class) {
            if (!f20O8oO888) {
                return 201;
            }
            if (str2 == null || str4 == null) {
                str7 = str2;
            } else {
                try {
                    str7 = str2 + "|" + str4;
                } catch (UnsatisfiedLinkError unused) {
                    m473O8oO888().mo1091O8oO888(f25oO);
                    f24o0o0.m525O8oO888(f25oO, Oo0, null, f21O);
                    return f24o0o0.m520O8oO888(str, str2, str3, str4, str5, i, str6);
                }
            }
            com.netease.htprotect.necrash.Ooo.m624O8oO888(f25oO, str7);
            Context context = f25oO;
            if (context != null) {
                oO.m501O8oO888(context);
            }
            return f24o0o0.m520O8oO888(str, str2, str3, str4, str5, i, str6);
        }
    }

    public static synchronized int track(View view, String str) {
        return 200;
    }

    public static void unregisterTouchEvent() {
        synchronized (HTProtect.class) {
            if (f20O8oO888) {
                try {
                    f24o0o0.m526O8oO888(false, -1, -1, -1, -1, -1);
                } catch (UnsatisfiedLinkError unused) {
                }
            }
        }
    }

    /* renamed from: 〇O8, reason: contains not printable characters */
    private static String m476O8() throws NoSuchMethodException, SecurityException {
        try {
            Method declaredMethod = Class.forName("android.app.ActivityThread").getDeclaredMethod("currentProcessName", new Class[0]);
            declaredMethod.setAccessible(true);
            return (String) declaredMethod.invoke(null, new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    private static String m477Ooo() throws IOException {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("/proc/self/cmdline")));
            String strTrim = bufferedReader.readLine().trim();
            bufferedReader.close();
            return strTrim;
        } catch (Exception unused) {
            return null;
        }
    }
}
