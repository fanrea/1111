package com.bytedance.pangle.gb;

import android.util.ArrayMap;
import android.util.Pair;
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
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class hc {
    private static boolean d(int i) {
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

    public static X509Certificate[][] d(RandomAccessFile randomAccessFile, String str) throws SecurityException, IOException, k {
        uo uoVar = an.d.get(str).get(1896449818);
        if (uoVar == null) {
            throw new k("findVerifiedSigner, No APK Signature Scheme v2 signature in package");
        }
        return d(randomAccessFile, uoVar, true).d;
    }

    private static d d(RandomAccessFile randomAccessFile, uo uoVar, boolean z) throws SecurityException, IOException, CertificateException {
        ArrayMap arrayMap = new ArrayMap();
        ArrayList arrayList = new ArrayList();
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            try {
                ByteBuffer byteBufferD = an.d(uoVar.d);
                int i = 0;
                while (byteBufferD.hasRemaining()) {
                    i++;
                    try {
                        arrayList.add(d(an.d(byteBufferD), arrayMap, certificateFactory));
                    } catch (IOException | SecurityException | BufferUnderflowException e) {
                        throw new SecurityException("Failed to parse/verify signer #" + i + " block", e);
                    }
                }
                if (i <= 0) {
                    throw new SecurityException("No signers found");
                }
                if (arrayMap.isEmpty()) {
                    throw new SecurityException("No content digests found");
                }
                if (z) {
                    an.d(arrayMap, randomAccessFile, uoVar);
                }
                return new d((X509Certificate[][]) arrayList.toArray(new X509Certificate[arrayList.size()][]), arrayMap.containsKey(3) ? an.d((byte[]) arrayMap.get(3), randomAccessFile.length(), uoVar) : null);
            } catch (IOException e2) {
                throw new SecurityException("Failed to read list of signers", e2);
            }
        } catch (CertificateException e3) {
            throw new RuntimeException("Failed to obtain X.509 CertificateFactory", e3);
        }
    }

    private static X509Certificate[] d(ByteBuffer byteBuffer, Map<Integer, byte[]> map, CertificateFactory certificateFactory) throws InvalidKeySpecException, NoSuchAlgorithmException, SignatureException, IOException, InvalidKeyException, SecurityException, InvalidAlgorithmParameterException {
        ByteBuffer byteBufferD = an.d(byteBuffer);
        ByteBuffer byteBufferD2 = an.d(byteBuffer);
        byte[] bArrHc = an.hc(byteBuffer);
        ArrayList arrayList = new ArrayList();
        byte[] bArrHc2 = null;
        byte[] bArrHc3 = null;
        int i = -1;
        int i2 = 0;
        while (byteBufferD2.hasRemaining()) {
            i2++;
            try {
                ByteBuffer byteBufferD3 = an.d(byteBufferD2);
                if (byteBufferD3.remaining() < 8) {
                    throw new SecurityException("Signature record too short");
                }
                int i3 = byteBufferD3.getInt();
                arrayList.add(Integer.valueOf(i3));
                if (d(i3) && (i == -1 || an.d(i3, i) > 0)) {
                    bArrHc3 = an.hc(byteBufferD3);
                    i = i3;
                }
            } catch (IOException | BufferUnderflowException e) {
                throw new SecurityException("Failed to parse signature record #".concat(String.valueOf(i2)), e);
            }
        }
        if (i == -1) {
            if (i2 == 0) {
                throw new SecurityException("No signatures found");
            }
            throw new SecurityException("No supported signatures found");
        }
        String strB = an.b(i);
        Pair<String, ? extends AlgorithmParameterSpec> pairC = an.c(i);
        String str = (String) pairC.first;
        AlgorithmParameterSpec algorithmParameterSpec = (AlgorithmParameterSpec) pairC.second;
        try {
            PublicKey publicKeyGeneratePublic = KeyFactory.getInstance(strB).generatePublic(new X509EncodedKeySpec(bArrHc));
            Signature signature = Signature.getInstance(str);
            signature.initVerify(publicKeyGeneratePublic);
            if (algorithmParameterSpec != null) {
                signature.setParameter(algorithmParameterSpec);
            }
            signature.update(byteBufferD);
            if (!signature.verify(bArrHc3)) {
                throw new SecurityException(str + " signature did not verify");
            }
            byteBufferD.clear();
            ByteBuffer byteBufferD4 = an.d(byteBufferD);
            ArrayList arrayList2 = new ArrayList();
            int i4 = 0;
            while (byteBufferD4.hasRemaining()) {
                i4++;
                try {
                    ByteBuffer byteBufferD5 = an.d(byteBufferD4);
                    if (byteBufferD5.remaining() < 8) {
                        throw new IOException("Record too short");
                    }
                    int i5 = byteBufferD5.getInt();
                    arrayList2.add(Integer.valueOf(i5));
                    if (i5 == i) {
                        bArrHc2 = an.hc(byteBufferD5);
                    }
                } catch (IOException | BufferUnderflowException e2) {
                    throw new IOException("Failed to parse digest record #".concat(String.valueOf(i4)), e2);
                }
            }
            if (!arrayList.equals(arrayList2)) {
                throw new SecurityException("Signature algorithms don't match between digests and signatures records");
            }
            int iD = an.d(i);
            byte[] bArrPut = map.put(Integer.valueOf(iD), bArrHc2);
            if (bArrPut != null && !MessageDigest.isEqual(bArrPut, bArrHc2)) {
                throw new SecurityException(an.hc(iD) + " contents digest does not match the digest specified by a preceding signer");
            }
            ByteBuffer byteBufferD6 = an.d(byteBufferD);
            ArrayList arrayList3 = new ArrayList();
            int i6 = 0;
            while (byteBufferD6.hasRemaining()) {
                i6++;
                byte[] bArrHc4 = an.hc(byteBufferD6);
                try {
                    arrayList3.add(new cb((X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(bArrHc4)), bArrHc4));
                } catch (CertificateException e3) {
                    throw new SecurityException("Failed to decode certificate #".concat(String.valueOf(i6)), e3);
                }
            }
            if (arrayList3.isEmpty()) {
                throw new SecurityException("No certificates listed");
            }
            if (!Arrays.equals(bArrHc, ((X509Certificate) arrayList3.get(0)).getPublicKey().getEncoded())) {
                throw new SecurityException("Public key mismatch between certificate and signature record");
            }
            d(an.d(byteBufferD));
            return (X509Certificate[]) arrayList3.toArray(new X509Certificate[arrayList3.size()]);
        } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | SignatureException | InvalidKeySpecException e4) {
            throw new SecurityException("Failed to verify " + str + " signature", e4);
        }
    }

    private static void d(ByteBuffer byteBuffer) throws IOException, SecurityException {
        while (byteBuffer.hasRemaining()) {
            ByteBuffer byteBufferD = an.d(byteBuffer);
            if (byteBufferD.remaining() < 4) {
                throw new IOException("Remaining buffer too short to contain additional attribute ID. Remaining: " + byteBufferD.remaining());
            }
            if (byteBufferD.getInt() == -1091571699) {
                if (byteBufferD.remaining() < 4) {
                    throw new IOException("V2 Signature Scheme Stripping Protection Attribute  value too small. Expected 4 bytes, but found " + byteBufferD.remaining());
                }
                if (byteBufferD.getInt() == 3) {
                    throw new SecurityException("V2 signature indicates APK is signed using APK Signature Scheme v3, but none was found. Signature stripped?");
                }
            }
        }
    }

    public static class d {
        public final X509Certificate[][] d;
        public final byte[] hc;

        public d(X509Certificate[][] x509CertificateArr, byte[] bArr) {
            this.d = x509CertificateArr;
            this.hc = bArr;
        }
    }
}
