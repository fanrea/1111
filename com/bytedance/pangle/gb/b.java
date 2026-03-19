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
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class b {

    private static class d extends Exception {
    }

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

    public static C0252b d(RandomAccessFile randomAccessFile, String str) throws IOException, k {
        uo uoVar = an.d.get(str).get(-262969152);
        if (uoVar == null) {
            throw new k("findVerifiedSigner, No APK Signature Scheme v3 signature in package");
        }
        return d(randomAccessFile, uoVar, true);
    }

    private static C0252b d(RandomAccessFile randomAccessFile, uo uoVar, boolean z) throws InvalidKeySpecException, NoSuchAlgorithmException, SignatureException, InvalidKeyException, SecurityException, IOException, CertificateException, InvalidAlgorithmParameterException {
        ArrayMap arrayMap = new ArrayMap();
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            try {
                ByteBuffer byteBufferD = an.d(uoVar.d);
                int i = 0;
                C0252b c0252bD = null;
                while (byteBufferD.hasRemaining()) {
                    try {
                        c0252bD = d(an.d(byteBufferD), arrayMap, certificateFactory);
                        i++;
                    } catch (d unused) {
                    } catch (IOException e) {
                        e = e;
                        throw new SecurityException("Failed to parse/verify signer #" + i + " block", e);
                    } catch (SecurityException e2) {
                        e = e2;
                        throw new SecurityException("Failed to parse/verify signer #" + i + " block", e);
                    } catch (BufferUnderflowException e3) {
                        e = e3;
                        throw new SecurityException("Failed to parse/verify signer #" + i + " block", e);
                    }
                }
                if (i <= 0 || c0252bD == null) {
                    throw new SecurityException("No signers found");
                }
                if (i != 1) {
                    throw new SecurityException("APK Signature Scheme V3 only supports one signer: multiple signers found.");
                }
                if (arrayMap.isEmpty()) {
                    throw new SecurityException("No content digests found");
                }
                if (z) {
                    an.d(arrayMap, randomAccessFile, uoVar);
                }
                if (arrayMap.containsKey(3)) {
                    c0252bD.b = an.d((byte[]) arrayMap.get(3), randomAccessFile.length(), uoVar);
                }
                return c0252bD;
            } catch (IOException e4) {
                throw new SecurityException("Failed to read list of signers", e4);
            }
        } catch (CertificateException e5) {
            throw new RuntimeException("Failed to obtain X.509 CertificateFactory", e5);
        }
    }

    private static C0252b d(ByteBuffer byteBuffer, Map<Integer, byte[]> map, CertificateFactory certificateFactory) throws InvalidKeySpecException, NoSuchAlgorithmException, SignatureException, IOException, InvalidKeyException, SecurityException, d, InvalidAlgorithmParameterException {
        ByteBuffer byteBufferD = an.d(byteBuffer);
        int i = byteBuffer.getInt();
        int i2 = byteBuffer.getInt();
        ByteBuffer byteBufferD2 = an.d(byteBuffer);
        byte[] bArrHc = an.hc(byteBuffer);
        ArrayList arrayList = new ArrayList();
        byte[] bArrHc2 = null;
        byte[] bArrHc3 = null;
        int i3 = -1;
        int i4 = 0;
        while (byteBufferD2.hasRemaining()) {
            i4++;
            try {
                ByteBuffer byteBufferD3 = an.d(byteBufferD2);
                if (byteBufferD3.remaining() < 8) {
                    throw new SecurityException("Signature record too short");
                }
                int i5 = byteBufferD3.getInt();
                arrayList.add(Integer.valueOf(i5));
                if (d(i5) && (i3 == -1 || an.d(i5, i3) > 0)) {
                    bArrHc3 = an.hc(byteBufferD3);
                    i3 = i5;
                }
            } catch (IOException | BufferUnderflowException e) {
                throw new SecurityException("Failed to parse signature record #".concat(String.valueOf(i4)), e);
            }
        }
        if (i3 == -1) {
            if (i4 == 0) {
                throw new SecurityException("No signatures found");
            }
            throw new SecurityException("No supported signatures found");
        }
        String strB = an.b(i3);
        Pair<String, ? extends AlgorithmParameterSpec> pairC = an.c(i3);
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
            int i6 = 0;
            while (byteBufferD4.hasRemaining()) {
                i6++;
                try {
                    ByteBuffer byteBufferD5 = an.d(byteBufferD4);
                    if (byteBufferD5.remaining() < 8) {
                        throw new IOException("Record too short");
                    }
                    int i7 = byteBufferD5.getInt();
                    arrayList2.add(Integer.valueOf(i7));
                    if (i7 == i3) {
                        bArrHc2 = an.hc(byteBufferD5);
                    }
                } catch (IOException | BufferUnderflowException e2) {
                    throw new IOException("Failed to parse digest record #".concat(String.valueOf(i6)), e2);
                }
            }
            if (!arrayList.equals(arrayList2)) {
                throw new SecurityException("Signature algorithms don't match between digests and signatures records");
            }
            int iD = an.d(i3);
            byte[] bArrPut = map.put(Integer.valueOf(iD), bArrHc2);
            if (bArrPut != null && !MessageDigest.isEqual(bArrPut, bArrHc2)) {
                throw new SecurityException(an.hc(iD) + " contents digest does not match the digest specified by a preceding signer");
            }
            ByteBuffer byteBufferD6 = an.d(byteBufferD);
            ArrayList arrayList3 = new ArrayList();
            int i8 = 0;
            while (byteBufferD6.hasRemaining()) {
                i8++;
                byte[] bArrHc4 = an.hc(byteBufferD6);
                try {
                    arrayList3.add(new cb((X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(bArrHc4)), bArrHc4));
                } catch (CertificateException e3) {
                    throw new SecurityException("Failed to decode certificate #".concat(String.valueOf(i8)), e3);
                }
            }
            if (arrayList3.isEmpty()) {
                throw new SecurityException("No certificates listed");
            }
            if (!Arrays.equals(bArrHc, ((X509Certificate) arrayList3.get(0)).getPublicKey().getEncoded())) {
                throw new SecurityException("Public key mismatch between certificate and signature record");
            }
            if (byteBufferD.getInt() != i) {
                throw new SecurityException("minSdkVersion mismatch between signed and unsigned in v3 signer block.");
            }
            if (byteBufferD.getInt() != i2) {
                throw new SecurityException("maxSdkVersion mismatch between signed and unsigned in v3 signer block.");
            }
            return d(an.d(byteBufferD), arrayList3, certificateFactory);
        } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | SignatureException | InvalidKeySpecException e4) {
            throw new SecurityException("Failed to verify " + str + " signature", e4);
        }
    }

    private static C0252b d(ByteBuffer byteBuffer, List<X509Certificate> list, CertificateFactory certificateFactory) throws NoSuchAlgorithmException, SignatureException, IOException, InvalidKeyException, SecurityException, InvalidAlgorithmParameterException {
        X509Certificate[] x509CertificateArr = (X509Certificate[]) list.toArray(new X509Certificate[list.size()]);
        hc hcVarD = null;
        while (byteBuffer.hasRemaining()) {
            ByteBuffer byteBufferD = an.d(byteBuffer);
            if (byteBufferD.remaining() < 4) {
                throw new IOException("Remaining buffer too short to contain additional attribute ID. Remaining: " + byteBufferD.remaining());
            }
            if (byteBufferD.getInt() == 1000370060) {
                if (hcVarD != null) {
                    throw new SecurityException("Encountered multiple Proof-of-rotation records when verifying APK Signature Scheme v3 signature");
                }
                hcVarD = d(byteBufferD, certificateFactory);
                try {
                    if (hcVarD.d.size() > 0 && !Arrays.equals(hcVarD.d.get(hcVarD.d.size() - 1).getEncoded(), x509CertificateArr[0].getEncoded())) {
                        throw new SecurityException("Terminal certificate in Proof-of-rotation record does not match APK signing certificate");
                    }
                } catch (CertificateEncodingException e) {
                    throw new SecurityException("Failed to encode certificate when comparing Proof-of-rotation record and signing certificate", e);
                }
            }
        }
        return new C0252b(x509CertificateArr, hcVarD);
    }

    private static hc d(ByteBuffer byteBuffer, CertificateFactory certificateFactory) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException, IOException, SecurityException, InvalidAlgorithmParameterException {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int i = 0;
        try {
            byteBuffer.getInt();
            HashSet hashSet = new HashSet();
            int i2 = -1;
            cb cbVar = null;
            while (byteBuffer.hasRemaining()) {
                i++;
                ByteBuffer byteBufferD = an.d(byteBuffer);
                ByteBuffer byteBufferD2 = an.d(byteBufferD);
                int i3 = byteBufferD.getInt();
                int i4 = byteBufferD.getInt();
                byte[] bArrHc = an.hc(byteBufferD);
                if (cbVar != null) {
                    Pair<String, ? extends AlgorithmParameterSpec> pairC = an.c(i2);
                    PublicKey publicKey = cbVar.getPublicKey();
                    Signature signature = Signature.getInstance((String) pairC.first);
                    signature.initVerify(publicKey);
                    if (pairC.second != null) {
                        signature.setParameter((AlgorithmParameterSpec) pairC.second);
                    }
                    signature.update(byteBufferD2);
                    if (!signature.verify(bArrHc)) {
                        throw new SecurityException("Unable to verify signature of certificate #" + i + " using " + ((String) pairC.first) + " when verifying Proof-of-rotation record");
                    }
                }
                byteBufferD2.rewind();
                byte[] bArrHc2 = an.hc(byteBufferD2);
                int i5 = byteBufferD2.getInt();
                if (cbVar != null && i2 != i5) {
                    throw new SecurityException("Signing algorithm ID mismatch for certificate #" + i + " when verifying Proof-of-rotation record");
                }
                cbVar = new cb((X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(bArrHc2)), bArrHc2);
                if (hashSet.contains(cbVar)) {
                    throw new SecurityException("Encountered duplicate entries in Proof-of-rotation record at certificate #" + i + ".  All signing certificates should be unique");
                }
                hashSet.add(cbVar);
                arrayList.add(cbVar);
                arrayList2.add(Integer.valueOf(i3));
                i2 = i4;
            }
            return new hc(arrayList, arrayList2);
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

    public static class hc {
        public final List<X509Certificate> d;
        public final List<Integer> hc;

        public hc(List<X509Certificate> list, List<Integer> list2) {
            this.d = list;
            this.hc = list2;
        }
    }

    /* renamed from: com.bytedance.pangle.gb.b$b, reason: collision with other inner class name */
    public static class C0252b {
        public byte[] b;
        public final X509Certificate[] d;
        public final hc hc;

        public C0252b(X509Certificate[] x509CertificateArr, hc hcVar) {
            this.d = x509CertificateArr;
            this.hc = hcVar;
        }
    }
}
