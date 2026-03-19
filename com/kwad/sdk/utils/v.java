package com.kwad.sdk.utils;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.kwad.sdk.liteapi.encrypt.LiteEncryptUtils;
import com.kwad.sdk.service.ServiceProvider;
import java.io.InputStream;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class v {
    private static String sAESKey = "";
    private static String sRSEPrivateKey = "";
    private static String sRSEPublicKey = "";

    public static String hs(int i) {
        Context contextAnu = ServiceProvider.anu();
        String str = sAESKey;
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        if (TextUtils.isEmpty(LiteEncryptUtils.KEY_AES)) {
            Log.e(LiteEncryptUtils.TAG, "EncryptUtils getKey get id is error ");
        }
        InputStream inputStreamOpen = null;
        try {
            try {
                inputStreamOpen = contextAnu.getResources().getAssets().open("ksad_common_encrypt_image.png");
            } catch (Throwable th) {
                Log.e(LiteEncryptUtils.TAG, "EncryptUtils getKey get InputStream from loader is null,  e: " + th);
            }
            if (inputStreamOpen == null) {
                inputStreamOpen = contextAnu.getAssets().open("ksad_common_encrypt_image.png");
            }
            String key = readKey(LiteEncryptUtils.KEY_AES, inputStreamOpen);
            if (TextUtils.isEmpty(key)) {
                Log.e(LiteEncryptUtils.TAG, "EncryptUtils getKey get encryptedKey is invalid ");
            }
            sAESKey = key;
            return key;
        } catch (Throwable unused) {
            return "";
        }
    }

    private static String readKey(String str, InputStream inputStream) {
        String strIa;
        synchronized (v.class) {
            com.kwad.sdk.pngencrypt.o oVar = new com.kwad.sdk.pngencrypt.o(inputStream, true);
            oVar.amP();
            strIa = oVar.amO().ia(str);
            oVar.end();
        }
        return strIa;
    }
}
