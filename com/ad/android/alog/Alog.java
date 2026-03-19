package com.ad.android.alog;

import android.content.Context;
import android.text.TextUtils;
import androidx.profileinstaller.ProfileVerifier;
import com.baidu.mobstat.forbes.Config;
import com.bytedance.sdk.djx.core.log.ILogConst;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class Alog {
    public static final ArrayList<String> d = new ArrayList<>();
    public static boolean e = false;
    public int a;
    public String b;
    public long c;

    public enum a {
        NONE(0),
        EC_SECP256K1(1),
        /* JADX INFO: Fake field, exist only in values array */
        EC_SECP256R1(2);

        public final int a;

        a(int i) {
            this.a = i;
        }
    }

    public static class b {
        public Context a;
        public int b = 0;
        public boolean c = false;
        public String d = null;
        public String e = null;
        public int f = 2097152;
        public int g = 20971520;
        public int h = 7;
        public String i = null;
        public int j = 65536;
        public int k = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        public String l = null;
        public int m;
        public int n;
        public int o;
        public int p;
        public int q;
        public int r;
        public String s;

        public b(Context context) {
            ArrayList<String> arrayList = Alog.d;
            this.m = 1;
            this.n = 0;
            this.o = 0;
            this.p = 2;
            this.q = 1;
            this.r = 1;
            this.s = "b012e20c9aab1cb5257aca2069cb79a9339b3a2224f771c78d64972137936eaf0b2f7ebd8d46c2607e1d7fe7723d40b147b8ecfa8fe2eaeee05210c75822381a";
            Context applicationContext = context.getApplicationContext();
            this.a = applicationContext != null ? applicationContext : context;
        }

        public b a(String str) {
            if (!TextUtils.isEmpty(str)) {
                if (str.contains("-")) {
                    str = str.replace("-", "");
                }
                if (str.contains(Config.replace)) {
                    str = str.replace(Config.replace, "");
                }
                if (!TextUtils.isEmpty(str)) {
                    this.d = str;
                }
            }
            return this;
        }

        public Alog a() {
            if (this.d == null) {
                this.d = ILogConst.PLAY_SOURCE_DEFAULT;
            }
            ArrayList<String> arrayList = Alog.d;
            synchronized (arrayList) {
                Iterator<String> it = arrayList.iterator();
                do {
                    String str = null;
                    if (!it.hasNext()) {
                        Alog.d.add(this.d);
                        if (this.e == null) {
                            File externalFilesDir = this.a.getExternalFilesDir(null);
                            this.e = (externalFilesDir != null ? new StringBuilder().append(externalFilesDir.getPath()) : new StringBuilder().append(this.a.getFilesDir())).append("/alog").toString();
                        }
                        if (this.i == null) {
                            this.i = this.a.getFilesDir() + "/alog";
                        }
                        if (this.l == null) {
                            Context context = this.a;
                            try {
                                str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
                            } catch (Exception unused) {
                            }
                            if (TextUtils.isEmpty(str)) {
                                str = "unknown";
                            }
                            this.l = str;
                        }
                        int i = (this.j / 4096) * 4096;
                        this.j = i;
                        int i2 = (this.k / 4096) * 4096;
                        this.k = i2;
                        if (i < 4096) {
                            this.j = 4096;
                        }
                        int i3 = this.j * 2;
                        if (i2 < i3) {
                            this.k = i3;
                        }
                        return new Alog(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p, this.q, this.r, this.s);
                    }
                } while (!it.next().equals(this.d));
                return null;
            }
        }
    }

    public enum c {
        NONE(0),
        ZLIB(1),
        ZSTD(2);

        public final int a;

        c(int i) {
            this.a = i;
        }
    }

    public enum d {
        NONE(0),
        TEA_16(1),
        TEA_32(2),
        /* JADX INFO: Fake field, exist only in values array */
        TEA_64(3);

        public final int a;

        d(int i) {
            this.a = i;
        }
    }

    public Alog(Context context, int i, boolean z, String str, String str2, int i2, int i3, int i4, String str3, int i5, int i6, String str4, int i7, int i8, int i9, int i10, int i11, int i12, String str5) {
        this.a = i;
        this.b = str2;
        int i13 = i6 / i5;
        this.c = nativeCreate(i, z, str, str2, i2, i3, i4, str3, i5, i6, str4, i7, i8, i9, i10, i11, i12, str5);
    }

    private static native void nativeAsyncFlush(long j);

    private static native long nativeCreate(int i, boolean z, String str, String str2, int i2, int i3, int i4, String str3, int i5, int i6, String str4, int i7, int i8, int i9, int i10, int i11, int i12, String str5);

    private static native void nativeDestroy(long j);

    private static native long nativeGetLegacyFlushFuncAddr();

    private static native long nativeGetLegacyGetLogFileDirFuncAddr();

    private static native long nativeGetLegacyWriteFuncAddr();

    private static native long nativeGetNativeWriteFuncAddr();

    public static native void nativeSetDefaultInstance(long j);

    private static native void nativeSetLevel(long j, int i);

    private static native void nativeSetSyslog(long j, boolean z);

    private static native void nativeSyncFlush(long j);

    private static native void nativeTimedSyncFlush(long j, int i);

    private static native void nativeWrite(long j, int i, String str, String str2);

    private static native void nativeWriteAsyncMsg(long j, int i, String str, String str2, long j2, long j3);

    public void a() {
        long j = this.c;
        if (j != 0) {
            nativeAsyncFlush(j);
        }
    }

    public void a(int i, String str, String str2) {
        long j = this.c;
        if (j == 0 || i < this.a || str == null || str2 == null) {
            return;
        }
        nativeWrite(j, i, str, str2);
    }

    public void a(int i, String str, String str2, long j, long j2) {
        long j3 = this.c;
        if (j3 == 0 || i < this.a || str == null || str2 == null) {
            return;
        }
        nativeWriteAsyncMsg(j3, i, str, str2, j, j2);
    }

    public void b() {
        synchronized (this) {
            long j = this.c;
            if (j != 0) {
                this.a = 6;
                nativeDestroy(j);
                this.c = 0L;
            }
        }
    }

    public long c() {
        if (this.c != 0) {
            return nativeGetLegacyWriteFuncAddr();
        }
        return 0L;
    }

    public void finalize() {
        try {
            super.finalize();
        } finally {
            b();
        }
    }
}
