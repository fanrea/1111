package com.fendasz.moku.planet.utils;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class QrCodeUtils {
    /* JADX WARN: Removed duplicated region for block: B:13:0x0042 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String parseQrCode(android.graphics.Bitmap r11) {
        /*
            int r8 = r11.getWidth()
            int r9 = r11.getHeight()
            int r0 = r8 * r9
            int[] r10 = new int[r0]
            r2 = 0
            r4 = 0
            r5 = 0
            r0 = r11
            r1 = r10
            r3 = r8
            r6 = r8
            r7 = r9
            r0.getPixels(r1, r2, r3, r4, r5, r6, r7)
            com.google.zxing.RGBLuminanceSource r11 = new com.google.zxing.RGBLuminanceSource
            r11.<init>(r8, r9, r10)
            com.google.zxing.BinaryBitmap r0 = new com.google.zxing.BinaryBitmap
            com.google.zxing.common.HybridBinarizer r1 = new com.google.zxing.common.HybridBinarizer
            r1.<init>(r11)
            r0.<init>(r1)
            com.google.zxing.qrcode.QRCodeReader r11 = new com.google.zxing.qrcode.QRCodeReader
            r11.<init>()
            r1 = 0
            com.google.zxing.Result r11 = r11.decode(r0)     // Catch: com.google.zxing.FormatException -> L31 com.google.zxing.ChecksumException -> L36 com.google.zxing.NotFoundException -> L3b
            goto L40
        L31:
            r11 = move-exception
            r11.printStackTrace()
            goto L3f
        L36:
            r11 = move-exception
            r11.printStackTrace()
            goto L3f
        L3b:
            r11 = move-exception
            r11.printStackTrace()
        L3f:
            r11 = r1
        L40:
            if (r11 != 0) goto L43
            return r1
        L43:
            java.lang.String r11 = r11.getText()
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fendasz.moku.planet.utils.QrCodeUtils.parseQrCode(android.graphics.Bitmap):java.lang.String");
    }
}
