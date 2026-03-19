package com.tk.component.imageview;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Base64;
import com.tk.core.o.w;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class k implements com.tachikoma.lottie.b {
    private final String RC;
    private final String TAG = "TKLottieImageAssetDelegate";

    public k(String str) {
        this.RC = str;
    }

    @Override // com.tachikoma.lottie.b
    public final Bitmap a(com.tachikoma.lottie.h hVar) {
        if (hVar == null || TextUtils.isEmpty(hVar.getFileName())) {
            return null;
        }
        Bitmap bitmapB = b(hVar);
        if (bitmapB == null) {
            bitmapB = d(hVar);
        }
        if (bitmapB == null) {
            bitmapB = c(hVar);
        }
        if (bitmapB != null) {
            hVar.setBitmap(bitmapB);
            if (!TextUtils.isEmpty(this.RC)) {
                w.sR().b(this.RC.concat(hVar.jL()).concat(hVar.getFileName()), bitmapB);
            }
        }
        return bitmapB;
    }

    private Bitmap b(com.tachikoma.lottie.h hVar) {
        if (TextUtils.isEmpty(this.RC)) {
            com.tk.core.i.a.y("TKLottieImageAssetDelegate", "TKLottieImageAssetDelegate fetchFromAsset: You must set an images folder before loading an image. Set it with TKLottieImageView#setImageFolder");
            return null;
        }
        return w.sR().cZ(this.RC.concat(hVar.jL()).concat(hVar.getFileName()));
    }

    private Bitmap c(com.tachikoma.lottie.h hVar) {
        if (TextUtils.isEmpty(this.RC)) {
            com.tk.core.i.a.y("TKLottieImageAssetDelegate", "TKLottieImageAssetDelegate fetchFromAsset: You must set an images folder before loading an image. Set it with TKLottieImageView#setImageFolder");
            return null;
        }
        String strConcat = this.RC.concat(hVar.jL()).concat(hVar.getFileName());
        if (com.tk.core.o.f.cS(strConcat)) {
            return BitmapFactory.decodeFile(strConcat, nk());
        }
        return null;
    }

    private Bitmap d(com.tachikoma.lottie.h hVar) {
        String fileName = hVar.getFileName();
        if (fileName.startsWith("data:") && fileName.indexOf("base64,") > 0) {
            try {
                byte[] bArrDecode = Base64.decode(fileName.substring(fileName.indexOf(44) + 1), 0);
                return BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length, nk());
            } catch (IllegalArgumentException e) {
                com.tk.core.i.a.b("TKLottieImageAssetDelegate", "data URL did not have correct base64 format.", e);
            }
        }
        return null;
    }

    private static BitmapFactory.Options nk() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = true;
        options.inDensity = 160;
        return options;
    }
}
