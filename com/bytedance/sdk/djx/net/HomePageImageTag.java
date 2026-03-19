package com.bytedance.sdk.djx.net;

import android.content.Context;
import com.bytedance.sdk.djx.net.img.Picasso;
import com.bytedance.sdk.djx.utils.InnerManager;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class HomePageImageTag {
    public static final String TAG_HOME_PAGE = "home_page";

    public static void pauseHomePageImageLoad(Context context) {
        if (context == null) {
            context = InnerManager.getContext();
        }
        Picasso.with(context).pauseTag("home_page");
    }

    public static void resumeHomePageImageLoad(Context context) {
        if (context == null) {
            context = InnerManager.getContext();
        }
        Picasso.with(context).resumeTag("home_page");
    }
}
