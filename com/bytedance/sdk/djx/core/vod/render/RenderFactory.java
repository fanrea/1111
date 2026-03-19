package com.bytedance.sdk.djx.core.vod.render;

import android.content.Context;
import com.bytedance.sdk.djx.core.vod.IVideoRender;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class RenderFactory {
    public static IVideoRender createSurface(Context context) {
        return new DJXSurfaceRender(context);
    }

    public static IVideoRender createTexture(Context context) {
        return new DJXTextureRender(context);
    }
}
