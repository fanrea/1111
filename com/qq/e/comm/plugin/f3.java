package com.qq.e.comm.plugin;

import android.os.Build;
import android.util.ArrayMap;
import android.util.Pair;
import com.bytedance.common.utility.StringEncryptUtils;
import com.qq.e.comm.plugin.g3;
import com.qq.e.comm.plugin.lh;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PSSParameterSpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import yaq.pro;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class f3 {
    private final RandomAccessFile a;
    private int b = -1;
    private int c;
    private int d;
    private boolean e;

    public static lh.a a(RandomAccessFile randomAccessFile, boolean z) throws bz, SecurityException, IOException {
        return (lh.a) pro.getobjresult(641, 1, randomAccessFile, Boolean.valueOf(z));
    }

    static boolean e(int i) {
        if (i == 513 || i == 514 || i == 769 || i == 1057 || i == 1059 || i == 1061) {
            return true;
        }
        switch (i) {
            case 257:
            case 258:
            case 259:
            case 260:
                return true;
            default:
                return false;
        }
    }

    private f3(RandomAccessFile randomAccessFile, boolean z) {
        this.a = randomAccessFile;
        this.e = z;
    }

    /* compiled from: A */
    private static class a extends Exception {
        a(String str) {
            super(str);
        }
    }

    static String c(int i) {
        if (i == 513 || i == 514) {
            return "EC";
        }
        if (i == 769) {
            return "DSA";
        }
        if (i == 1057) {
            return com.alipay.sdk.m.n.d.a;
        }
        if (i == 1059) {
            return "EC";
        }
        if (i == 1061) {
            return "DSA";
        }
        switch (i) {
            case 257:
            case 258:
            case 259:
            case 260:
                return com.alipay.sdk.m.n.d.a;
            default:
                throw new IllegalArgumentException("Unknown signature algorithm: 0x" + Long.toHexString(i));
        }
    }

    static int b(int i, int i2) {
        return a(b(i), b(i2));
    }

    private static int a(int i, int i2) {
        if (i == 1) {
            if (i2 == 1) {
                return 0;
            }
            if (i2 == 2 || i2 == 3) {
                return -1;
            }
            throw new IllegalArgumentException("Unknown digestAlgorithm2: " + i2);
        }
        if (i == 2) {
            if (i2 != 1) {
                if (i2 == 2) {
                    return 0;
                }
                if (i2 != 3) {
                    throw new IllegalArgumentException("Unknown digestAlgorithm2: " + i2);
                }
            }
            return 1;
        }
        if (i != 3) {
            throw new IllegalArgumentException("Unknown digestAlgorithm1: " + i);
        }
        if (i2 == 1) {
            return 1;
        }
        if (i2 == 2) {
            return -1;
        }
        if (i2 == 3) {
            return 0;
        }
        throw new IllegalArgumentException("Unknown digestAlgorithm2: " + i2);
    }

    static Pair<String, ? extends AlgorithmParameterSpec> d(int i) {
        if (i != 513) {
            if (i != 514) {
                if (i != 769) {
                    if (i != 1057) {
                        if (i != 1059) {
                            if (i != 1061) {
                                switch (i) {
                                    case 257:
                                        return Pair.create("SHA256withRSA/PSS", new PSSParameterSpec(StringEncryptUtils.SHA_256, "MGF1", MGF1ParameterSpec.SHA256, 32, 1));
                                    case 258:
                                        return Pair.create("SHA512withRSA/PSS", new PSSParameterSpec("SHA-512", "MGF1", MGF1ParameterSpec.SHA512, 64, 1));
                                    case 259:
                                        break;
                                    case 260:
                                        return Pair.create("SHA512withRSA", null);
                                    default:
                                        throw new IllegalArgumentException("Unknown signature algorithm: 0x" + Long.toHexString(i));
                                }
                            }
                        }
                    }
                    return Pair.create("SHA256withRSA", null);
                }
                return Pair.create("SHA256withDSA", null);
            }
            return Pair.create("SHA512withECDSA", null);
        }
        return Pair.create("SHA256withECDSA", null);
    }

    private static az a(RandomAccessFile randomAccessFile, int i) throws bz, IOException {
        return g3.a(randomAccessFile, i);
    }

    static int b(int i) {
        if (i == 513) {
            return 1;
        }
        if (i == 514) {
            return 2;
        }
        if (i == 769) {
            return 1;
        }
        if (i == 1057 || i == 1059 || i == 1061) {
            return 3;
        }
        switch (i) {
            case 257:
            case 259:
                return 1;
            case 258:
            case 260:
                return 2;
            default:
                throw new IllegalArgumentException("Unknown signature algorithm: 0x" + Long.toHexString(i));
        }
    }

    static String a(int i) {
        if (i == 1) {
            return StringEncryptUtils.SHA_256;
        }
        if (i == 2) {
            return "SHA-512";
        }
        if (i == 3) {
            return StringEncryptUtils.SHA_256;
        }
        throw new IllegalArgumentException("Unknown content digest algorthm: " + i);
    }

    static ByteBuffer a(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer.remaining() >= 4) {
            int i = byteBuffer.getInt();
            if (i >= 0) {
                if (i <= byteBuffer.remaining()) {
                    return g3.b(byteBuffer, i);
                }
                throw new IOException("Length-prefixed field longer than remaining buffer. Field length: " + i + ", remaining: " + byteBuffer.remaining());
            }
            throw new IllegalArgumentException("Negative length");
        }
        throw new IOException("Remaining buffer too short to contain length of length-prefixed field. Remaining: " + byteBuffer.remaining());
    }

    static byte[] b(ByteBuffer byteBuffer) throws IOException {
        int i = byteBuffer.getInt();
        if (i >= 0) {
            if (i <= byteBuffer.remaining()) {
                byte[] bArr = new byte[i];
                byteBuffer.get(bArr);
                return bArr;
            }
            throw new IOException("Underflow while reading length-prefixed value. Length: " + i + ", available: " + byteBuffer.remaining());
        }
        throw new IOException("Negative length");
    }

    private lh.a a(az azVar, int i) throws InvalidKeySpecException, NoSuchAlgorithmException, SignatureException, a, InvalidKeyException, SecurityException, IOException, CertificateException, InvalidAlgorithmParameterException {
        this.d = i;
        ArrayMap arrayMap = new ArrayMap();
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            try {
                ByteBuffer byteBufferA = a(azVar.a);
                int i2 = 0;
                Pair<X509Certificate[], g3.a> pairA = null;
                while (byteBufferA.hasRemaining()) {
                    try {
                        pairA = a(a(byteBufferA), arrayMap, certificateFactory);
                        i2++;
                    } catch (a unused) {
                    } catch (IOException e) {
                        e = e;
                        throw new SecurityException("Failed to parse/verify signer #" + i2 + " block", e);
                    } catch (SecurityException e2) {
                        e = e2;
                        throw new SecurityException("Failed to parse/verify signer #" + i2 + " block", e);
                    } catch (BufferUnderflowException e3) {
                        e = e3;
                        throw new SecurityException("Failed to parse/verify signer #" + i2 + " block", e);
                    }
                }
                if (i2 < 1 || pairA == null) {
                    if (i == -262969152) {
                        throw new SecurityException("No signers found");
                    }
                    throw new a("None of the signers support the current platform version");
                }
                if (i2 == 1) {
                    if (!arrayMap.isEmpty()) {
                        return new lh.a((X509Certificate[]) pairA.first, (g3.a) pairA.second, arrayMap.containsKey(3) ? g3.a(arrayMap.get(3), this.a.getChannel().size(), azVar) : null, arrayMap, i);
                    }
                    throw new SecurityException("No content digests found");
                }
                throw new SecurityException("APK Signature Scheme V3 only supports one signer: multiple signers found.");
            } catch (IOException e4) {
                throw new SecurityException("Failed to read list of signers", e4);
            }
        } catch (CertificateException e5) {
            throw new RuntimeException("Failed to obtain X.509 CertificateFactory", e5);
        }
    }

    private Pair<X509Certificate[], g3.a> a(ByteBuffer byteBuffer, List<X509Certificate> list, CertificateFactory certificateFactory) throws a, NoSuchAlgorithmException, SignatureException, IOException, InvalidKeyException, SecurityException, InvalidAlgorithmParameterException {
        X509Certificate[] x509CertificateArr = (X509Certificate[]) list.toArray(new X509Certificate[list.size()]);
        g3.a aVarA = null;
        while (byteBuffer.hasRemaining()) {
            ByteBuffer byteBufferA = a(byteBuffer);
            if (byteBufferA.remaining() >= 4) {
                int i = byteBufferA.getInt();
                if (i != -1029262406) {
                    if (i != 1000370060) {
                        if (i != 1436519170) {
                            continue;
                        } else if (byteBufferA.remaining() >= 4) {
                            int i2 = byteBufferA.getInt();
                            int i3 = this.b;
                            if (i3 < 0) {
                                throw new SecurityException("Expected a v3.1 signing block targeting SDK version " + i2 + ", but a v3.1 block was not found");
                            }
                            if (i3 != i2) {
                                throw new SecurityException("Expected a v3.1 signing block targeting SDK version " + i2 + ", but the v3.1 block was targeting " + i3);
                            }
                        } else {
                            throw new IOException("Remaining buffer too short to contain rotation minSdkVersion value. Remaining: " + byteBufferA.remaining());
                        }
                    } else if (aVarA == null) {
                        aVarA = a(byteBufferA, certificateFactory);
                        try {
                            if (aVarA.a.size() > 0) {
                                if (!Arrays.equals(aVarA.a.get(r1.size() - 1).getEncoded(), x509CertificateArr[0].getEncoded())) {
                                    throw new SecurityException("Terminal certificate in Proof-of-rotation record does not match APK signing certificate");
                                }
                            } else {
                                continue;
                            }
                        } catch (CertificateEncodingException e) {
                            throw new SecurityException("Failed to encode certificate when comparing Proof-of-rotation record and signing certificate", e);
                        }
                    } else {
                        throw new SecurityException("Encountered multiple Proof-of-rotation records when verifying APK Signature Scheme v3 signature");
                    }
                } else if (this.d == 462663009 && Build.VERSION.SDK_INT == this.c && "REL".equals(Build.VERSION.CODENAME)) {
                    this.b = this.c;
                    throw new a("The device is running a release version of " + this.c + ", but the signer is targeting a dev release");
                }
            } else {
                throw new IOException("Remaining buffer too short to contain additional attribute ID. Remaining: " + byteBufferA.remaining());
            }
        }
        return Pair.create(x509CertificateArr, aVarA);
    }

    static g3.a a(ByteBuffer byteBuffer, CertificateFactory certificateFactory) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException, IOException, SecurityException, InvalidAlgorithmParameterException {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int i = 0;
        try {
            byteBuffer.getInt();
            HashSet hashSet = new HashSet();
            int i2 = -1;
            x30 x30Var = null;
            while (byteBuffer.hasRemaining()) {
                i++;
                ByteBuffer byteBufferA = a(byteBuffer);
                ByteBuffer byteBufferA2 = a(byteBufferA);
                int i3 = byteBufferA.getInt();
                int i4 = byteBufferA.getInt();
                byte[] bArrB = b(byteBufferA);
                if (x30Var != null) {
                    Pair<String, ? extends AlgorithmParameterSpec> pairD = d(i2);
                    PublicKey publicKey = x30Var.getPublicKey();
                    Signature signature = Signature.getInstance((String) pairD.first);
                    signature.initVerify(publicKey);
                    Object obj = pairD.second;
                    if (obj != null) {
                        signature.setParameter((AlgorithmParameterSpec) obj);
                    }
                    signature.update(byteBufferA2);
                    if (!signature.verify(bArrB)) {
                        throw new SecurityException("Unable to verify signature of certificate #" + i + " using " + ((String) pairD.first) + " when verifying Proof-of-rotation record");
                    }
                }
                byteBufferA2.rewind();
                byte[] bArrB2 = b(byteBufferA2);
                int i5 = byteBufferA2.getInt();
                if (x30Var != null && i2 != i5) {
                    throw new SecurityException("Signing algorithm ID mismatch for certificate #" + i + " when verifying Proof-of-rotation record");
                }
                x30Var = new x30((X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(bArrB2)), bArrB2);
                if (!hashSet.contains(x30Var)) {
                    hashSet.add(x30Var);
                    arrayList.add(x30Var);
                    arrayList2.add(Integer.valueOf(i3));
                    i2 = i4;
                } else {
                    throw new SecurityException("Encountered duplicate entries in Proof-of-rotation record at certificate #" + i + ".  All signing certificates should be unique");
                }
            }
            return new g3.a(arrayList, arrayList2);
        } catch (IOException e) {
            e = e;
            throw new IOException("Failed to parse Proof-of-rotation record", e);
        } catch (BufferUnderflowException e2) {
            e = e2;
            throw new IOException("Failed to parse Proof-of-rotation record", e);
        } catch (InvalidAlgorithmParameterException e3) {
            e = e3;
            throw new SecurityException("Failed to verify signature over signed data for certificate #0 when verifying Proof-of-rotation record", e);
        } catch (InvalidKeyException e4) {
            e = e4;
            throw new SecurityException("Failed to verify signature over signed data for certificate #0 when verifying Proof-of-rotation record", e);
        } catch (NoSuchAlgorithmException e5) {
            e = e5;
            throw new SecurityException("Failed to verify signature over signed data for certificate #0 when verifying Proof-of-rotation record", e);
        } catch (SignatureException e6) {
            e = e6;
            throw new SecurityException("Failed to verify signature over signed data for certificate #0 when verifying Proof-of-rotation record", e);
        } catch (CertificateException e7) {
            throw new SecurityException("Failed to decode certificate #0 when verifying Proof-of-rotation record", e7);
        }
    }

    private Pair<X509Certificate[], g3.a> a(ByteBuffer byteBuffer, Map<Integer, byte[]> map, CertificateFactory certificateFactory) throws InvalidKeySpecException, NoSuchAlgorithmException, SignatureException, a, IOException, InvalidKeyException, SecurityException, InvalidAlgorithmParameterException {
        int i;
        ByteBuffer byteBufferA = a(byteBuffer);
        int i2 = byteBuffer.getInt();
        int i3 = byteBuffer.getInt();
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= i2 && i4 <= i3) {
            ByteBuffer byteBufferA2 = a(byteBuffer);
            byte[] bArrB = b(byteBuffer);
            ArrayList arrayList = new ArrayList();
            int i5 = -1;
            int i6 = 0;
            byte[] bArrB2 = null;
            while (true) {
                int i7 = 8;
                if (!byteBufferA2.hasRemaining()) {
                    if (i5 == -1) {
                        if (i6 == 0) {
                            throw new SecurityException("No signatures found");
                        }
                        throw new SecurityException("No supported signatures found");
                    }
                    String strC = c(i5);
                    Pair<String, ? extends AlgorithmParameterSpec> pairD = d(i5);
                    String str = (String) pairD.first;
                    AlgorithmParameterSpec algorithmParameterSpec = (AlgorithmParameterSpec) pairD.second;
                    try {
                        PublicKey publicKeyGeneratePublic = KeyFactory.getInstance(strC).generatePublic(new X509EncodedKeySpec(bArrB));
                        Signature signature = Signature.getInstance(str);
                        signature.initVerify(publicKeyGeneratePublic);
                        if (algorithmParameterSpec != null) {
                            signature.setParameter(algorithmParameterSpec);
                        }
                        signature.update(byteBufferA);
                        if (signature.verify(bArrB2)) {
                            byteBufferA.clear();
                            ByteBuffer byteBufferA3 = a(byteBufferA);
                            ArrayList arrayList2 = new ArrayList();
                            byte[] bArrB3 = null;
                            int i8 = 0;
                            while (byteBufferA3.hasRemaining()) {
                                i8++;
                                try {
                                    ByteBuffer byteBufferA4 = a(byteBufferA3);
                                    if (byteBufferA4.remaining() >= i7) {
                                        int i9 = byteBufferA4.getInt();
                                        arrayList2.add(Integer.valueOf(i9));
                                        if (i9 == i5) {
                                            bArrB3 = b(byteBufferA4);
                                        }
                                        i7 = 8;
                                    } else {
                                        throw new IOException("Record too short");
                                    }
                                } catch (IOException | BufferUnderflowException e) {
                                    throw new IOException("Failed to parse digest record #" + i8, e);
                                }
                            }
                            if (arrayList.equals(arrayList2)) {
                                int iB = b(i5);
                                byte[] bArrPut = map.put(Integer.valueOf(iB), bArrB3);
                                if (bArrPut != null && !MessageDigest.isEqual(bArrPut, bArrB3)) {
                                    throw new SecurityException(a(iB) + " contents digest does not match the digest specified by a preceding signer");
                                }
                                ByteBuffer byteBufferA5 = a(byteBufferA);
                                ArrayList arrayList3 = new ArrayList();
                                int i10 = 0;
                                while (byteBufferA5.hasRemaining()) {
                                    i10++;
                                    byte[] bArrB4 = b(byteBufferA5);
                                    try {
                                        arrayList3.add(new x30((X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(bArrB4)), bArrB4));
                                    } catch (CertificateException e2) {
                                        throw new SecurityException("Failed to decode certificate #" + i10, e2);
                                    }
                                }
                                if (!arrayList3.isEmpty()) {
                                    if (Arrays.equals(bArrB, arrayList3.get(0).getPublicKey().getEncoded())) {
                                        int i11 = byteBufferA.getInt();
                                        if (i11 == i2) {
                                            this.c = i11;
                                            if (byteBufferA.getInt() == i3) {
                                                return a(a(byteBufferA), arrayList3, certificateFactory);
                                            }
                                            throw new SecurityException("maxSdkVersion mismatch between signed and unsigned in v3 signer block.");
                                        }
                                        throw new SecurityException("minSdkVersion mismatch between signed and unsigned in v3 signer block.");
                                    }
                                    throw new SecurityException("Public key mismatch between certificate and signature record");
                                }
                                throw new SecurityException("No certificates listed");
                            }
                            throw new SecurityException("Signature algorithms don't match between digests and signatures records");
                        }
                        throw new SecurityException(str + " signature did not verify");
                    } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | SignatureException | InvalidKeySpecException e3) {
                        throw new SecurityException("Failed to verify " + str + " signature", e3);
                    }
                }
                i6++;
                try {
                    ByteBuffer byteBufferA6 = a(byteBufferA2);
                    if (byteBufferA6.remaining() >= 8) {
                        int i12 = byteBufferA6.getInt();
                        arrayList.add(Integer.valueOf(i12));
                        if (e(i12) && (i5 == -1 || b(i12, i5) > 0)) {
                            bArrB2 = b(byteBufferA6);
                            i5 = i12;
                        }
                    } else {
                        throw new SecurityException("Signature record too short");
                    }
                } catch (IOException | BufferUnderflowException e4) {
                    throw new SecurityException("Failed to parse signature record #" + i6, e4);
                }
            }
        } else {
            if (this.d == 462663009 && ((i = this.b) < 0 || i > i2)) {
                this.b = i2;
            }
            throw new a("Signer not supported by this platform version. This platform: " + i4 + ", signer minSdkVersion: " + i2 + ", maxSdkVersion: " + i3);
        }
    }
}
