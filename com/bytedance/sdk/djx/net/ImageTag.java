package com.bytedance.sdk.djx.net;

import android.content.Context;
import com.bytedance.sdk.djx.net.img.Picasso;
import com.bytedance.sdk.djx.utils.InnerManager;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class ImageTag {
    public static final String TAG_DRAMA_CARD = "drama_card";
    public static final String TAG_DRAMA_DETAIL = "drama_detail";
    public static final String TAG_DRAMA_HOME = "drama_home";
    public static final String TAG_DRAW_VIDEO = "draw_video";
    public static final String TAG_NOVEL_DEFAULT = "novel_default";

    public static void pause(Context context, String str) {
        if (context == null) {
            context = InnerManager.getContext();
        }
        Picasso.with(context).pauseTag(str);
    }

    public static void resume(Context context, String str) {
        if (context == null) {
            context = InnerManager.getContext();
        }
        Picasso.with(context).resumeTag(str);
    }
}
