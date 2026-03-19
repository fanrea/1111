package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.util.Base64;
import com.baidu.mobads.sdk.internal.ca;
import java.io.File;
import java.io.FilenameFilter;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class bt extends File {
    public static final String a = "LocalApkFile";
    private static final long b = 6916965592955692235L;
    private static ClassLoader h;
    private by c;
    private Class<?> d;
    private Context e;
    private PublicKey f;
    private bu g;

    public bt(String str, Context context) {
        this(str, context, null);
    }

    public bt(String str, Context context, by byVar) {
        super(str);
        this.d = null;
        this.e = null;
        this.g = bu.a();
        this.e = context;
        this.c = byVar;
        if (byVar != null) {
            try {
                this.f = c("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDBcp8gg3O7bjdnz+pSxg+JH/mbcKfm7dEjcRqVNAFwG7bTpLwDQh40bZJzrcBKQWbD6kArR6TPuQUCMQ09/y55Vk1P2Kq7vJGGisFpjlqv2qlg8drLdhXkLQUt/SeZVJgT+CNxVbuzxAF61EEf8M0MHi1I2dm6n6lOA6fomiCD9wIDAQAB");
            } catch (Exception unused) {
                this.f = null;
            }
        }
    }

    protected void a() throws Throwable {
        if (this.c != null) {
            String strA = a(new File(getAbsolutePath()));
            String strB = b(this.c.d());
            if (!strA.equalsIgnoreCase(strB)) {
                throw new ca.a("doCheckApkIntegrity failed, md5sum: " + strA + ", checksum in json info: " + strB);
            }
            return;
        }
        this.g.a(a, "built-in apk, no need to check");
    }

    protected Class<?> b() {
        if (this.d == null) {
            File file = new File(getAbsolutePath());
            try {
                this.d = b(file);
            } catch (Exception unused) {
                file.delete();
            }
        }
        return this.d;
    }

    protected void a(String str) {
        renameTo(new File(str));
    }

    protected double c() {
        by byVar = this.c;
        if (byVar == null) {
            return 0.0d;
        }
        return byVar.b();
    }

    private String b(String str) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        if (this.f == null) {
            return null;
        }
        byte[] bArrDecode = Base64.decode(str, 0);
        try {
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(2, this.f);
            return new String(cipher.doFinal(bArrDecode), "UTF-8").trim();
        } catch (Exception e) {
            this.g.c("ErrorWhileVerifySigNature", e);
            return null;
        }
    }

    private static PublicKey c(String str) throws Exception {
        try {
            return KeyFactory.getInstance(com.alipay.sdk.m.n.d.a).generatePublic(new X509EncodedKeySpec(Base64.decode(str, 0)));
        } catch (NullPointerException unused) {
            throw new Exception("NullPointerException");
        } catch (NoSuchAlgorithmException unused2) {
            throw new Exception("NoSuchAlgorithmException");
        } catch (InvalidKeySpecException unused3) {
            throw new Exception("InvalidKeySpecException");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x009f A[Catch: Exception -> 0x009b, TRY_LEAVE, TryCatch #2 {Exception -> 0x009b, blocks: (B:46:0x0097, B:50:0x009f), top: B:56:0x0097 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0097 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String a(java.io.File r9) throws java.lang.Throwable {
        /*
            r8 = this;
            java.lang.String r0 = ""
            java.lang.String r1 = "LocalApkFile"
            r2 = 0
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L71
            r3.<init>(r9)     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L71
            java.lang.String r9 = "MD5"
            java.security.MessageDigest r9 = java.security.MessageDigest.getInstance(r9)     // Catch: java.lang.Throwable -> L66 java.lang.Exception -> L6a
            java.security.DigestInputStream r4 = new java.security.DigestInputStream     // Catch: java.lang.Throwable -> L66 java.lang.Exception -> L6a
            r4.<init>(r3, r9)     // Catch: java.lang.Throwable -> L66 java.lang.Exception -> L6a
            r2 = 4096(0x1000, float:5.74E-42)
            byte[] r2 = new byte[r2]     // Catch: java.lang.Throwable -> L62 java.lang.Exception -> L64
        L19:
            int r5 = r4.read(r2)     // Catch: java.lang.Throwable -> L62 java.lang.Exception -> L64
            r6 = -1
            if (r5 == r6) goto L21
            goto L19
        L21:
            byte[] r9 = r9.digest()     // Catch: java.lang.Throwable -> L62 java.lang.Exception -> L64
            r2 = 0
            r5 = r0
        L27:
            int r6 = r9.length     // Catch: java.lang.Throwable -> L62 java.lang.Exception -> L64
            if (r2 >= r6) goto L4f
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L62 java.lang.Exception -> L64
            r6.<init>()     // Catch: java.lang.Throwable -> L62 java.lang.Exception -> L64
            java.lang.StringBuilder r5 = r6.append(r5)     // Catch: java.lang.Throwable -> L62 java.lang.Exception -> L64
            r6 = r9[r2]     // Catch: java.lang.Throwable -> L62 java.lang.Exception -> L64
            r6 = r6 & 255(0xff, float:3.57E-43)
            int r6 = r6 + 256
            r7 = 16
            java.lang.String r6 = java.lang.Integer.toString(r6, r7)     // Catch: java.lang.Throwable -> L62 java.lang.Exception -> L64
            r7 = 1
            java.lang.String r6 = r6.substring(r7)     // Catch: java.lang.Throwable -> L62 java.lang.Exception -> L64
            java.lang.StringBuilder r5 = r5.append(r6)     // Catch: java.lang.Throwable -> L62 java.lang.Exception -> L64
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L62 java.lang.Exception -> L64
            int r2 = r2 + 1
            goto L27
        L4f:
            r3.close()     // Catch: java.lang.Exception -> L56
            r4.close()     // Catch: java.lang.Exception -> L56
            goto L60
        L56:
            r9 = move-exception
            com.baidu.mobads.sdk.internal.bu r0 = r8.g
            java.lang.String r9 = r9.getMessage()
            r0.a(r1, r9)
        L60:
            r0 = r5
            goto L93
        L62:
            r9 = move-exception
            goto L68
        L64:
            r9 = move-exception
            goto L6c
        L66:
            r9 = move-exception
            r4 = r2
        L68:
            r2 = r3
            goto L95
        L6a:
            r9 = move-exception
            r4 = r2
        L6c:
            r2 = r3
            goto L73
        L6e:
            r9 = move-exception
            r4 = r2
            goto L95
        L71:
            r9 = move-exception
            r4 = r2
        L73:
            com.baidu.mobads.sdk.internal.bu r3 = r8.g     // Catch: java.lang.Throwable -> L94
            java.lang.String r9 = r9.getMessage()     // Catch: java.lang.Throwable -> L94
            r3.a(r1, r9)     // Catch: java.lang.Throwable -> L94
            if (r2 == 0) goto L84
            r2.close()     // Catch: java.lang.Exception -> L82
            goto L84
        L82:
            r9 = move-exception
            goto L8a
        L84:
            if (r4 == 0) goto L93
            r4.close()     // Catch: java.lang.Exception -> L82
            goto L93
        L8a:
            com.baidu.mobads.sdk.internal.bu r2 = r8.g
            java.lang.String r9 = r9.getMessage()
            r2.a(r1, r9)
        L93:
            return r0
        L94:
            r9 = move-exception
        L95:
            if (r2 == 0) goto L9d
            r2.close()     // Catch: java.lang.Exception -> L9b
            goto L9d
        L9b:
            r0 = move-exception
            goto La3
        L9d:
            if (r4 == 0) goto Lac
            r4.close()     // Catch: java.lang.Exception -> L9b
            goto Lac
        La3:
            com.baidu.mobads.sdk.internal.bu r2 = r8.g
            java.lang.String r0 = r0.getMessage()
            r2.a(r1, r0)
        Lac:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.sdk.internal.bt.a(java.io.File):java.lang.String");
    }

    private void d() {
        File[] fileArrListFiles = this.e.getFilesDir().listFiles(new a());
        for (int i = 0; fileArrListFiles != null && i < fileArrListFiles.length; i++) {
            if (fileArrListFiles[i].getAbsolutePath().contains("__xadsdk__remote__final__")) {
                this.g.a(a, "clearDexCacheFiles-->" + i + "--" + fileArrListFiles[i].getAbsolutePath());
                fileArrListFiles[i].delete();
            }
        }
    }

    private Class<?> b(File file) {
        Class<?> cls;
        this.g.a(a, "Android version:" + bn.a(this.e).c());
        Class<?> cls2 = null;
        try {
            synchronized (ca.class) {
                String absolutePath = file.getAbsolutePath();
                ClassLoader classLoader = getClass().getClassLoader();
                String absolutePath2 = this.e.getFilesDir().getAbsolutePath();
                String str = z.aO;
                h = ao.a(absolutePath, absolutePath2, (String) null, classLoader);
                this.g.a(a, "dexPath=" + absolutePath + ", cl=" + classLoader + ", dir=" + absolutePath2 + ", len=" + file.length() + ", list=" + file.list());
                cls = Class.forName(str, true, h);
            }
            cls2 = cls;
        } catch (Exception e) {
            this.g.a(a, e.getMessage());
        }
        this.g.a(a, "jar.path=" + file.getAbsolutePath() + ", clz=" + cls2);
        return cls2;
    }

    public static ClassLoader a(Context context) {
        ClassLoader classLoader = h;
        return classLoader != null ? classLoader : av.a(context.getApplicationContext());
    }

    class a implements FilenameFilter {
        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return true;
        }

        a() {
        }
    }
}
