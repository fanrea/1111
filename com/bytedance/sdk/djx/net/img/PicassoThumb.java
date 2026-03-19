package com.bytedance.sdk.djx.net.img;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.djx.net.img.Picasso;
import com.bytedance.sdk.djx.utils.ImageFileUtil;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class PicassoThumb {
    private static final Map<String, Exception> sErrorMap = new ConcurrentHashMap();
    private static volatile Picasso singleton;

    private PicassoThumb() {
    }

    public static Picasso with(Context context) {
        if (singleton == null) {
            synchronized (PicassoThumb.class) {
                if (singleton == null) {
                    singleton = new Picasso.Builder(context).downloader(Utils.createCustomDownloader(context, ImageFileUtil.getThumbCache(context))).listener(new Picasso.Listener() { // from class: com.bytedance.sdk.djx.net.img.PicassoThumb.1
                        @Override // com.bytedance.sdk.djx.net.img.Picasso.Listener
                        public void onImageLoadFailed(Picasso picasso, Uri uri, Exception exc) {
                            if (uri == null || exc == null) {
                                return;
                            }
                            PicassoThumb.sErrorMap.put(uri.toString(), exc);
                        }
                    }).build();
                }
            }
        }
        return singleton;
    }

    public static Exception getError(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return sErrorMap.remove(str);
        } catch (Exception unused) {
            return null;
        }
    }
}
