package com.kwad.sdk.core.videocache.c;

import android.content.Context;
import com.kwad.sdk.core.videocache.f;
import com.kwai.video.player.KsMediaMeta;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class a {
    private static f bJP;

    public static f ch(Context context) {
        return b(context, 0, 0);
    }

    public static f b(Context context, int i, int i2) {
        f fVar = bJP;
        if (fVar != null) {
            return fVar;
        }
        f fVarC = c(context, i, i2);
        bJP = fVarC;
        return fVarC;
    }

    private static f c(Context context, int i, int i2) {
        return new f.a(context).bi(KsMediaMeta.AV_CH_STEREO_LEFT).fD(i).fE(i2).acX();
    }
}
