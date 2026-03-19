package com.luck.picture.lib.engine;

import android.content.Context;
import android.widget.ImageView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public interface ImageEngine {
    void loadAlbumCover(Context context, String str, ImageView imageView);

    void loadGridImage(Context context, String str, ImageView imageView);

    void loadImage(Context context, ImageView imageView, String str, int i, int i2);

    void loadImage(Context context, String str, ImageView imageView);

    void pauseRequests(Context context);

    void resumeRequests(Context context);
}
