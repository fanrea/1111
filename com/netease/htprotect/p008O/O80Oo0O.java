package com.netease.htprotect.p008O;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.IBinder;
import android.provider.Settings;
import android.text.TextUtils;
import com.netease.htprotect.p008O.O;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.netease.htprotect.〇O.O〇80Oo0O, reason: invalid class name */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class O80Oo0O {

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public static final ThreadPoolExecutor f225O8oO888 = new ThreadPoolExecutor(0, 3, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(2048), new ThreadPoolExecutor.DiscardPolicy());

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    private static final Uri f226Ooo = new Uri.Builder().scheme("content").authority("com.huawei.hwid.pps.apiprovider").path("/oaid/query").build();

    /* renamed from: com.netease.htprotect.〇O.O〇80Oo0O$O8〇oO8〇88, reason: invalid class name */
    static class O8oO888 {
        /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
        private static PackageInfo m666O8oO888(Context context, String str) {
            if (!TextUtils.isEmpty(str) && context != null) {
                try {
                    PackageManager packageManager = context.getPackageManager();
                    if (packageManager != null) {
                        return packageManager.getPackageInfo(str, 128);
                    }
                } catch (Exception unused) {
                }
            }
            return null;
        }

        /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
        public static String m667O8oO888(Context context) {
            if (!(m666O8oO888(context, "com.huawei.hwid") != null)) {
                if (m666O8oO888(context, "com.huawei.hms") != null) {
                    return "com.huawei.hms";
                }
                if (m666O8oO888(context, "com.huawei.hwid.tv") != null) {
                    return "com.huawei.hwid.tv";
                }
            }
            return "com.huawei.hwid";
        }
    }

    /* renamed from: com.netease.htprotect.〇O.O〇80Oo0O$〇Ooo, reason: invalid class name */
    static final class Ooo {

        /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
        final String f227O8oO888;

        /* renamed from: 〇Ooo, reason: contains not printable characters */
        private final boolean f228Ooo;

        public Ooo(String str, boolean z) {
            this.f227O8oO888 = str;
            this.f228Ooo = z;
        }
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public static String m660O8oO888(Context context) {
        Ooo oooM662O8 = m662O8(context);
        if (oooM662O8 == null) {
            return null;
        }
        return oooM662O8.f227O8oO888;
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private static boolean m661O8oO888(Context context, Uri uri) {
        PackageManager packageManager;
        ProviderInfo providerInfoResolveContentProvider;
        ApplicationInfo applicationInfo;
        if (context != null && uri != null) {
            try {
                String authority = uri.getAuthority();
                if (authority == null || (providerInfoResolveContentProvider = (packageManager = context.getPackageManager()).resolveContentProvider(authority, 0)) == null || (applicationInfo = providerInfoResolveContentProvider.applicationInfo) == null) {
                    return false;
                }
                String str = applicationInfo.packageName;
                if (TextUtils.isEmpty(str)) {
                    return false;
                }
                if (packageManager.checkSignatures(context.getPackageName(), str) != 0) {
                    if ((applicationInfo.flags & 1) != 1) {
                        return false;
                    }
                }
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    private static Ooo Oo0(Context context) throws PackageManager.NameNotFoundException {
        try {
            context.getPackageManager().getPackageInfo(O8oO888.m667O8oO888(context), 128);
            O8O00oo o8O00oo = new O8O00oo();
            Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
            intent.setPackage(O8oO888.m667O8oO888(context));
            if (!context.bindService(intent, o8O00oo, 1)) {
                return null;
            }
            try {
                if (o8O00oo.f236O8oO888) {
                    throw new IllegalStateException();
                }
                o8O00oo.f236O8oO888 = true;
                O oM657O8oO888 = O.O8oO888.m657O8oO888((IBinder) o8O00oo.f237Ooo.take());
                Ooo ooo = new Ooo(oM657O8oO888.mo655O8oO888(), oM657O8oO888.mo656Ooo());
                try {
                    context.unbindService(o8O00oo);
                } catch (PackageManager.NameNotFoundException | Exception unused) {
                }
                return ooo;
            } catch (Exception unused2) {
                context.unbindService(o8O00oo);
                return null;
            } catch (Throwable th) {
                try {
                    context.unbindService(o8O00oo);
                } catch (Exception unused3) {
                }
                throw th;
            }
        } catch (PackageManager.NameNotFoundException | Exception unused4) {
            return null;
        }
    }

    /* renamed from: 〇O8, reason: contains not printable characters */
    private static Ooo m662O8(Context context) {
        Uri uri;
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                String string = Settings.Global.getString(context.getContentResolver(), "pps_oaid");
                String string2 = Settings.Global.getString(context.getContentResolver(), "pps_track_limit");
                if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
                    f225O8oO888.execute(new Oo(context));
                    return new Ooo(string, Boolean.parseBoolean(string2));
                }
            } catch (Throwable unused) {
            }
        }
        return (context == null || (uri = f226Ooo) == null || m664o0o0(context) < 30462100) ? false : m661O8oO888(context, uri) ? m665oO(context) : Oo0(context);
    }

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    static /* synthetic */ Ooo m663Ooo(Context context) {
        Uri uri;
        return (context == null || (uri = f226Ooo) == null || m664o0o0(context) < 30462100) ? false : m661O8oO888(context, uri) ? m665oO(context) : Oo0(context);
    }

    /* renamed from: 〇o0〇o0, reason: contains not printable characters */
    private static int m664o0o0(Context context) {
        Object obj;
        if (context == null) {
            return -1;
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(O8oO888.m667O8oO888(context), 128);
            if (applicationInfo != null && applicationInfo.metaData != null && (obj = applicationInfo.metaData.get("ppskit_ver_code")) != null) {
                return Integer.parseInt(obj.toString());
            }
        } catch (Throwable unused) {
        }
        return -1;
    }

    /* renamed from: 〇oO, reason: contains not printable characters */
    private static Ooo m665oO(Context context) {
        Uri uri;
        if (context != null) {
            if ((context == null || (uri = f226Ooo) == null || m664o0o0(context) < 30462100) ? false : m661O8oO888(context, uri)) {
                try {
                    Cursor cursorQuery = context.getContentResolver().query(f226Ooo, null, null, null, null);
                    if (cursorQuery != null && cursorQuery.moveToFirst()) {
                        int columnIndexOrThrow = cursorQuery.getColumnIndexOrThrow("oaid");
                        int columnIndexOrThrow2 = cursorQuery.getColumnIndexOrThrow("limit_track");
                        String string = cursorQuery.getString(columnIndexOrThrow);
                        Ooo ooo = new Ooo(string, "00000000-0000-0000-0000-000000000000".equalsIgnoreCase(string) || Boolean.parseBoolean(cursorQuery.getString(columnIndexOrThrow2)));
                        if (cursorQuery != null) {
                            try {
                                cursorQuery.close();
                            } catch (Throwable unused) {
                            }
                        }
                        return ooo;
                    }
                    if (cursorQuery != null) {
                        try {
                            cursorQuery.close();
                        } catch (Throwable unused2) {
                        }
                    }
                    return new Ooo("00000000-0000-0000-0000-000000000000", true);
                } catch (Throwable unused3) {
                    return new Ooo("00000000-0000-0000-0000-000000000000", true);
                }
            }
        }
        return new Ooo("00000000-0000-0000-0000-000000000000", true);
    }
}
