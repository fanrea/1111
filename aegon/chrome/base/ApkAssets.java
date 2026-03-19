package aegon.chrome.base;

import aegon.chrome.base.annotations.JNINamespace;
import android.content.res.AssetFileDescriptor;
import java.io.IOException;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
@JNINamespace("base::android")
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class ApkAssets {
    private static final String LOGTAG = "ApkAssets";

    public static long[] open(String str) throws IOException {
        AssetFileDescriptor assetFileDescriptorOpenNonAssetFd = null;
        try {
            try {
                assetFileDescriptorOpenNonAssetFd = ContextUtils.getApplicationContext().getAssets().openNonAssetFd(str);
                long[] jArr = {assetFileDescriptorOpenNonAssetFd.getParcelFileDescriptor().detachFd(), assetFileDescriptorOpenNonAssetFd.getStartOffset(), assetFileDescriptorOpenNonAssetFd.getLength()};
                if (assetFileDescriptorOpenNonAssetFd != null) {
                    try {
                        assetFileDescriptorOpenNonAssetFd.close();
                    } catch (IOException e) {
                        android.util.Log.e(LOGTAG, "Unable to close AssetFileDescriptor", e);
                    }
                }
                return jArr;
            } catch (IOException e2) {
                if (!e2.getMessage().equals("") && !e2.getMessage().equals(str)) {
                    android.util.Log.e(LOGTAG, "Error while loading asset " + str + ": " + e2);
                }
                long[] jArr2 = {-1, -1, -1};
                if (assetFileDescriptorOpenNonAssetFd != null) {
                    try {
                        assetFileDescriptorOpenNonAssetFd.close();
                    } catch (IOException e3) {
                        android.util.Log.e(LOGTAG, "Unable to close AssetFileDescriptor", e3);
                    }
                }
                return jArr2;
            }
        } catch (Throwable th) {
            if (assetFileDescriptorOpenNonAssetFd != null) {
                try {
                    assetFileDescriptorOpenNonAssetFd.close();
                } catch (IOException e4) {
                    android.util.Log.e(LOGTAG, "Unable to close AssetFileDescriptor", e4);
                }
            }
            throw th;
        }
    }
}
