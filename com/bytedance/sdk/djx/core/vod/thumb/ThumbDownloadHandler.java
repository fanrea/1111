package com.bytedance.sdk.djx.core.vod.thumb;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.bytedance.sdk.djx.model.DramaDetail;
import com.bytedance.sdk.djx.model.ThumbM;
import com.bytedance.sdk.djx.net.img.Picasso;
import com.bytedance.sdk.djx.net.img.PicassoThumb;
import com.bytedance.sdk.djx.net.img.Target;
import com.bytedance.sdk.djx.utils.InnerManager;
import com.bytedance.sdk.djx.utils.LG;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class ThumbDownloadHandler {
    private static final String TAG = "ThumbHandler";
    private static final List<String> mDownloading = new CopyOnWriteArrayList();
    private static volatile ThumbDownloadHandler sInstance;

    public static ThumbDownloadHandler inst() {
        if (sInstance == null) {
            synchronized (ThumbDownloadHandler.class) {
                if (sInstance == null) {
                    sInstance = new ThumbDownloadHandler();
                }
            }
        }
        return sInstance;
    }

    private ThumbDownloadHandler() {
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x005e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x005f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.graphics.Bitmap getThumbBitmap(final com.bytedance.sdk.djx.model.DramaDetail r9, final com.bytedance.sdk.djx.model.ThumbM r10, long r11, long r13) {
        /*
            r8 = this;
            java.lang.String r13 = "ThumbHandler"
            java.util.List<java.lang.String> r14 = r10.urls
            r0 = 0
            if (r14 == 0) goto Ld7
            java.util.List<java.lang.String> r14 = r10.urls
            boolean r14 = r14.isEmpty()
            if (r14 == 0) goto L11
            goto Ld7
        L11:
            float r11 = (float) r11
            r12 = 1148846080(0x447a0000, float:1000.0)
            float r11 = r11 / r12
            float r12 = r10.interval
            r14 = 0
            int r12 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r12 == 0) goto L1f
            float r12 = r10.interval
            goto L21
        L1f:
            r12 = 1065353216(0x3f800000, float:1.0)
        L21:
            float r11 = r11 / r12
            java.lang.Float r11 = java.lang.Float.valueOf(r11)
            int r11 = r11.intValue()
            java.util.List<java.lang.String> r12 = r10.urls
            int r12 = r12.size()
            r14 = 1
            r1 = 0
            if (r12 <= r14) goto L4e
            int r12 = r10.xLen
            int r14 = r10.yLen
            int r12 = r12 * r14
            r14 = r1
        L3a:
            java.util.List<java.lang.String> r2 = r10.urls
            int r2 = r2.size()
            if (r14 >= r2) goto L4e
            int r2 = r14 * r12
            int r3 = r2 + r12
            if (r11 < r2) goto L4b
            if (r11 >= r3) goto L4b
            goto L4f
        L4b:
            int r14 = r14 + 1
            goto L3a
        L4e:
            r14 = r1
        L4f:
            java.util.List<java.lang.String> r11 = r10.urls
            java.lang.Object r11 = r11.get(r14)
            r4 = r11
            java.lang.String r4 = (java.lang.String) r4
            boolean r11 = android.text.TextUtils.isEmpty(r4)
            if (r11 == 0) goto L5f
            return r0
        L5f:
            android.net.Uri r11 = android.net.Uri.parse(r4)
            java.lang.String r11 = r11.getPath()
            boolean r12 = android.text.TextUtils.isEmpty(r11)
            if (r12 == 0) goto L6e
            r11 = r4
        L6e:
            java.lang.String r5 = com.bytedance.sdk.djx.utils.Encrypt.md5ToString(r11)
            android.content.Context r11 = com.bytedance.sdk.djx.utils.InnerManager.getContext()     // Catch: java.lang.Exception -> L8d
            com.bytedance.sdk.djx.net.img.Picasso r11 = com.bytedance.sdk.djx.net.img.PicassoThumb.with(r11)     // Catch: java.lang.Exception -> L8d
            com.bytedance.sdk.djx.net.img.RequestCreator r11 = r11.load(r4)     // Catch: java.lang.Exception -> L8d
            com.bytedance.sdk.djx.net.img.NetworkPolicy r12 = com.bytedance.sdk.djx.net.img.NetworkPolicy.OFFLINE     // Catch: java.lang.Exception -> L8d
            com.bytedance.sdk.djx.net.img.NetworkPolicy[] r14 = new com.bytedance.sdk.djx.net.img.NetworkPolicy[r1]     // Catch: java.lang.Exception -> L8d
            com.bytedance.sdk.djx.net.img.RequestCreator r11 = r11.networkPolicy(r12, r14)     // Catch: java.lang.Exception -> L8d
            android.graphics.Bitmap r11 = r11.get()     // Catch: java.lang.Exception -> L8d
            if (r11 == 0) goto La4
            return r11
        L8d:
            r11 = move-exception
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r14 = "get thumb from cache error: "
            java.lang.StringBuilder r12 = r12.append(r14)
            java.lang.StringBuilder r11 = r12.append(r11)
            java.lang.String r11 = r11.toString()
            com.bytedance.sdk.djx.utils.LG.d(r13, r11)
        La4:
            java.util.List<java.lang.String> r11 = com.bytedance.sdk.djx.core.vod.thumb.ThumbDownloadHandler.mDownloading
            boolean r12 = r11.contains(r5)
            if (r12 == 0) goto Lc3
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "thumb has downloading: "
            java.lang.StringBuilder r9 = r9.append(r10)
            java.lang.StringBuilder r9 = r9.append(r5)
            java.lang.String r9 = r9.toString()
            com.bytedance.sdk.djx.utils.LG.d(r13, r9)
            return r0
        Lc3:
            r11.add(r5)
            java.lang.String r11 = "thumb file not exists, start download"
            com.bytedance.sdk.djx.utils.LG.d(r13, r11)
            com.bytedance.sdk.djx.core.vod.thumb.ThumbDownloadHandler$1 r11 = new com.bytedance.sdk.djx.core.vod.thumb.ThumbDownloadHandler$1
            r2 = r11
            r3 = r8
            r6 = r9
            r7 = r10
            r2.<init>()
            com.bytedance.sdk.djx.utils.DJXThread.runOnUiThread(r11)
        Ld7:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.djx.core.vod.thumb.ThumbDownloadHandler.getThumbBitmap(com.bytedance.sdk.djx.model.DramaDetail, com.bytedance.sdk.djx.model.ThumbM, long, long):android.graphics.Bitmap");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void downloadThumbImage(final String str, final String str2, final DramaDetail dramaDetail, final ThumbM thumbM) {
        PicassoThumb.with(InnerManager.getContext()).load(str).into(new Target() { // from class: com.bytedance.sdk.djx.core.vod.thumb.ThumbDownloadHandler.2
            private final long startTime = System.currentTimeMillis();

            @Override // com.bytedance.sdk.djx.net.img.Target
            public void onPrepareLoad(Drawable drawable) {
            }

            @Override // com.bytedance.sdk.djx.net.img.Target
            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom loadedFrom) {
                LG.d(ThumbDownloadHandler.TAG, "thumb url download success");
                ThumbDownloadHandler.mDownloading.remove(str2);
                ThumbLog.download(true, dramaDetail, thumbM, System.currentTimeMillis() - this.startTime, 0, "ok");
            }

            @Override // com.bytedance.sdk.djx.net.img.Target
            public void onBitmapFailed(Drawable drawable) {
                LG.d(ThumbDownloadHandler.TAG, "thumb url download error");
                ThumbDownloadHandler.mDownloading.remove(str2);
                Exception error = PicassoThumb.getError(str);
                ThumbLog.download(false, dramaDetail, thumbM, System.currentTimeMillis() - this.startTime, -1, error != null ? error.toString() : "unknown");
            }
        });
    }
}
