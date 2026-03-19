package com.ss.ttm.ttvideodecode;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class Native {
    private static native byte[] _encryptAesCbc128(byte[] bArr, byte[] bArr2);

    private static native String _getDecodedStr(byte[] bArr, byte[] bArr2);

    private static native String _getEncryptionKey(byte[] bArr);

    private static native byte[] _getSignature(String str);

    private static native int _getSupportedMethod();

    public static String getEncryptionKey(byte[] bArr) {
        return _getEncryptionKey(bArr);
    }

    public static String getDecodedStr(byte[] bArr, byte[] bArr2) {
        return _getDecodedStr(bArr, bArr2);
    }

    public static int getSupportedMethod() {
        return _getSupportedMethod();
    }

    public static byte[] getSignature(String str) {
        return _getSignature(str);
    }

    public static byte[] encryptAesCbc128(byte[] bArr, byte[] bArr2) {
        return _encryptAesCbc128(bArr, bArr2);
    }
}
