package com.bytedance.pangle.gb;

import android.content.pm.Signature;
import com.bytedance.pangle.gb.b;
import com.kuaishou.weapon.p0.t;
import java.io.RandomAccessFile;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class c {
    public static e d(String str, int i) throws Throwable {
        int[] iArr;
        if (i > 3) {
            throw new w(4, "No signature found in package of version " + i + " or newer for package " + str);
        }
        RandomAccessFile randomAccessFile = null;
        Signature[] signatureArr = null;
        try {
            try {
                RandomAccessFile randomAccessFile2 = new RandomAccessFile(str, t.k);
                try {
                    try {
                        an.d(str, randomAccessFile2, -262969152, 1896449818);
                        try {
                            b.C0252b c0252bD = b.d(randomAccessFile2, str);
                            Signature[] signatureArrD = d(new Certificate[][]{c0252bD.d});
                            if (c0252bD.hc != null) {
                                int size = c0252bD.hc.d.size();
                                Signature[] signatureArr2 = new Signature[size];
                                iArr = new int[c0252bD.hc.hc.size()];
                                for (int i2 = 0; i2 < size; i2++) {
                                    signatureArr2[i2] = new Signature(c0252bD.hc.d.get(i2).getEncoded());
                                    iArr[i2] = c0252bD.hc.hc.get(i2).intValue();
                                }
                                signatureArr = signatureArr2;
                            } else {
                                iArr = null;
                            }
                            e eVar = new e(signatureArrD, 3, signatureArr, iArr);
                            try {
                                randomAccessFile2.close();
                            } catch (Exception unused) {
                            }
                            return eVar;
                        } catch (k e) {
                            if (i >= 3) {
                                throw new w(4, "No APK Signature Scheme v3 signature in package ".concat(String.valueOf(str)), e);
                            }
                            if (i > 2) {
                                throw new w(4, "No signature found in package of version " + i + " or newer for package " + str);
                            }
                            try {
                                try {
                                    e eVar2 = new e(d(hc.d(randomAccessFile2, str)), 2);
                                    try {
                                        randomAccessFile2.close();
                                    } catch (Exception unused2) {
                                    }
                                    return eVar2;
                                } catch (k e2) {
                                    if (i >= 2) {
                                        throw new w(4, "No APK Signature Scheme v2 signature in package ".concat(String.valueOf(str)), e2);
                                    }
                                    if (i > 1) {
                                        throw new w(4, "No signature found in package of version " + i + " or newer for package " + str);
                                    }
                                    e eVarD = d.d(str, true);
                                    try {
                                        randomAccessFile2.close();
                                    } catch (Exception unused3) {
                                    }
                                    return eVarD;
                                }
                            } catch (Exception e3) {
                                throw new w(4, "Failed to collect certificates from " + str + " using APK Signature Scheme v2", e3);
                            }
                        } catch (Exception e4) {
                            throw new w(4, "Failed to collect certificates from " + str + " using APK Signature Scheme v3", e4);
                        }
                    } catch (Exception e5) {
                        throw new w(4, "Failed to collect certificates from " + str + " when findSignatureInfo at once", e5);
                    }
                } catch (Throwable th) {
                    th = th;
                    randomAccessFile = randomAccessFile2;
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (Exception unused4) {
                        }
                    }
                    throw th;
                }
            } catch (Exception unused5) {
                throw new w(6, "failed to read apk file, minSignatureSchemeVersion : " + i + ", apkPath : " + str);
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static Signature[] d(Certificate[][] certificateArr) throws CertificateEncodingException {
        Signature[] signatureArr = new Signature[certificateArr.length];
        for (int i = 0; i < certificateArr.length; i++) {
            if (com.bytedance.pangle.util.tt.c()) {
                Constructor constructorD = com.bytedance.pangle.hc.hc.d.d((Class<?>) Signature.class, (Class<?>[]) new Class[]{Certificate[].class});
                if (constructorD != null) {
                    constructorD.setAccessible(true);
                }
                if (constructorD != null && constructorD.isAccessible()) {
                    try {
                        signatureArr[i] = (Signature) constructorD.newInstance(certificateArr[i]);
                    } catch (IllegalAccessException e) {
                        com.bytedance.sdk.openadsdk.api.an.d(e);
                    } catch (InstantiationException e2) {
                        com.bytedance.sdk.openadsdk.api.an.d(e2);
                    } catch (InvocationTargetException e3) {
                        com.bytedance.sdk.openadsdk.api.an.d(e3);
                    }
                }
            } else {
                signatureArr[i] = new Signature(certificateArr[i][0].getEncoded());
            }
        }
        return signatureArr;
    }
}
