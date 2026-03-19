package com.bytedance.sdk.djx.net.img;

import android.content.Context;
import com.bytedance.sdk.djx.net.img.Picasso;
import com.bytedance.sdk.djx.utils.ImageFileUtil;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class PicassoAi {
    public static final String IMG_PATH_ROOT_NAME = "paisdk";
    private static volatile Picasso singleton;

    private PicassoAi() {
    }

    public static Picasso with(Context context) {
        if (singleton == null) {
            synchronized (PicassoAi.class) {
                if (singleton == null) {
                    singleton = new Picasso.Builder(context).downloader(Utils.createCustomDownloader(context, ImageFileUtil.getImageCache(context, IMG_PATH_ROOT_NAME))).build();
                }
            }
        }
        return singleton;
    }
}
