package com.kwad.components.ct.tube.d;

import com.kwad.components.ct.response.model.tube.TubeInfo;
import com.kwad.sdk.lib.widget.a.a.e;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a extends e<TubeInfo> {
    @Override // com.kwad.sdk.lib.widget.a.a.e
    public final /* synthetic */ boolean areContentsTheSame(TubeInfo tubeInfo, TubeInfo tubeInfo2) {
        return c(tubeInfo, tubeInfo2);
    }

    @Override // com.kwad.sdk.lib.widget.a.a.e
    public final /* synthetic */ boolean areItemsTheSame(TubeInfo tubeInfo, TubeInfo tubeInfo2) {
        return b(tubeInfo, tubeInfo2);
    }

    private static boolean b(TubeInfo tubeInfo, TubeInfo tubeInfo2) {
        return tubeInfo.tubeId == tubeInfo2.tubeId;
    }

    private static boolean c(TubeInfo tubeInfo, TubeInfo tubeInfo2) {
        return tubeInfo != null && tubeInfo2 != null && tubeInfo.tubeId == tubeInfo2.tubeId && tubeInfo.mIsShowTitle == tubeInfo2.mIsShowTitle && tubeInfo.lastWatchTime == tubeInfo2.lastWatchTime;
    }
}
