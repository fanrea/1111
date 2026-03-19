package com.kwad.components.ct.response.a;

import android.graphics.Matrix;
import android.text.TextUtils;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.components.ct.response.model.CtPhotoInfo;
import com.kwad.components.ct.response.model.hotspot.HotspotInfo;
import com.kwad.components.ct.response.model.tube.TubeEpisode;
import com.kwad.components.ct.response.model.tube.TubeInfo;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.core.response.b.h;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.utils.bq;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class c extends h {
    public static CtPhotoInfo a(PhotoInfo photoInfo) {
        if (photoInfo instanceof CtPhotoInfo) {
            return (CtPhotoInfo) photoInfo;
        }
        return new CtPhotoInfo(photoInfo);
    }

    public static String a(CtPhotoInfo ctPhotoInfo) {
        return ctPhotoInfo.coverInfo.coverUrl;
    }

    public static String b(CtPhotoInfo ctPhotoInfo) {
        return ctPhotoInfo.coverInfo.blurBackgroundUrl;
    }

    private static int c(CtPhotoInfo ctPhotoInfo) {
        return ctPhotoInfo.coverInfo.width;
    }

    private static int d(CtPhotoInfo ctPhotoInfo) {
        return ctPhotoInfo.coverInfo.height;
    }

    public static long e(CtPhotoInfo ctPhotoInfo) {
        return ctPhotoInfo.authorInfo.authorId;
    }

    public static boolean f(CtPhotoInfo ctPhotoInfo) {
        return ctPhotoInfo.authorInfo.isJoinedBlacklist;
    }

    public static String g(CtPhotoInfo ctPhotoInfo) {
        return ctPhotoInfo.authorInfo.authorName;
    }

    public static int h(CtPhotoInfo ctPhotoInfo) {
        return ctPhotoInfo.baseInfo.photoTitleSize;
    }

    public static int i(CtPhotoInfo ctPhotoInfo) {
        return ctPhotoInfo.baseInfo.photoDescribeSize;
    }

    public static String j(CtPhotoInfo ctPhotoInfo) {
        return ctPhotoInfo.authorInfo.authorArea;
    }

    public static String k(CtPhotoInfo ctPhotoInfo) {
        return ctPhotoInfo.authorInfo.rawAuthorName;
    }

    public static String l(CtPhotoInfo ctPhotoInfo) {
        return ctPhotoInfo.authorInfo.authorIcon;
    }

    public static String m(CtPhotoInfo ctPhotoInfo) {
        return ctPhotoInfo.authorInfo.authorIconGuide;
    }

    public static String n(CtPhotoInfo ctPhotoInfo) {
        return ctPhotoInfo.authorInfo.authorText;
    }

    public static boolean o(CtPhotoInfo ctPhotoInfo) {
        return ctPhotoInfo.tubeEpisode.tubeInfo.tubeId > 0;
    }

    public static TubeEpisode p(CtPhotoInfo ctPhotoInfo) {
        return ctPhotoInfo.tubeEpisode;
    }

    public static int q(CtPhotoInfo ctPhotoInfo) {
        return ctPhotoInfo.tubeEpisode.episodeNumber;
    }

    public static int r(CtPhotoInfo ctPhotoInfo) {
        return ctPhotoInfo.tubeEpisode.tubeInfo.nextLockedEpisodeNum;
    }

    public static List<Integer> s(CtPhotoInfo ctPhotoInfo) {
        return ctPhotoInfo.tubeEpisode.tubeInfo.episodeNumberList;
    }

    public static long t(CtPhotoInfo ctPhotoInfo) {
        return ctPhotoInfo.tubeEpisode.tubeInfo.tubeId;
    }

    public static int u(CtPhotoInfo ctPhotoInfo) {
        return ctPhotoInfo.tubeEpisode.tubeInfo.unlockEpisodeCount;
    }

    public static int v(CtPhotoInfo ctPhotoInfo) {
        return ctPhotoInfo.tubeEpisode.tubeInfo.freeEpisodeCount;
    }

    public static String w(CtPhotoInfo ctPhotoInfo) {
        return ctPhotoInfo.tubeEpisode.tubeInfo.name;
    }

    public static String x(CtPhotoInfo ctPhotoInfo) {
        return ctPhotoInfo.tubeEpisode.episodeName;
    }

    public static int y(CtPhotoInfo ctPhotoInfo) {
        return ctPhotoInfo.tubeEpisode.tubeInfo.totalEpisodeSize;
    }

    public static int z(CtPhotoInfo ctPhotoInfo) {
        return ctPhotoInfo.tubeEpisode.episodeNumber;
    }

    public static long A(CtPhotoInfo ctPhotoInfo) {
        return ctPhotoInfo.tubeEpisode.playCount;
    }

    public static boolean B(CtPhotoInfo ctPhotoInfo) {
        return ctPhotoInfo.tubeEpisode.locked;
    }

    public static void a(CtPhotoInfo ctPhotoInfo, boolean z) {
        ctPhotoInfo.tubeEpisode.locked = false;
    }

    public static TubeInfo C(CtPhotoInfo ctPhotoInfo) {
        return ctPhotoInfo.tubeEpisode.tubeInfo;
    }

    public static com.kwad.sdk.core.response.model.b D(CtPhotoInfo ctPhotoInfo) {
        boolean z;
        String strG = g((PhotoInfo) ctPhotoInfo);
        int iH = h((PhotoInfo) ctPhotoInfo);
        int i = i((PhotoInfo) ctPhotoInfo);
        if (bq.isNullString(strG) || bq.iI(strG) || iH == 0 || i == 0) {
            strG = a(ctPhotoInfo);
            iH = c(ctPhotoInfo);
            i = d(ctPhotoInfo);
            z = true;
        } else {
            z = false;
        }
        boolean z2 = z;
        String str = strG;
        com.kwad.sdk.core.d.c.d("CtPhotoInfoHelper", "frameUrl=" + str + " useCover=" + z2 + " isAd=false");
        return new com.kwad.sdk.core.response.model.b(str, iH, i, false, z2);
    }

    public static com.kwad.sdk.core.response.model.b E(CtPhotoInfo ctPhotoInfo) {
        boolean z;
        String strA = a(ctPhotoInfo);
        int iC = c(ctPhotoInfo);
        int iD = d(ctPhotoInfo);
        if (bq.isNullString(strA) || iC == 0 || iD == 0) {
            strA = g((PhotoInfo) ctPhotoInfo);
            iC = h((PhotoInfo) ctPhotoInfo);
            iD = d(ctPhotoInfo);
            z = false;
        } else {
            z = true;
        }
        return new com.kwad.sdk.core.response.model.b(strA, iC, iD, false, z);
    }

    public static boolean F(CtPhotoInfo ctPhotoInfo) {
        return !TextUtils.isEmpty(ctPhotoInfo.mHotspotInfo.name);
    }

    public static boolean bd(CtAdTemplate ctAdTemplate) {
        return ctAdTemplate.photoAd.requestPatchAd;
    }

    public static boolean G(CtPhotoInfo ctPhotoInfo) {
        com.kwad.sdk.components.d.g(DevelopMangerComponents.class);
        return ctPhotoInfo.wallpaperInfo.isWallpaperPhoto;
    }

    public static boolean be(CtAdTemplate ctAdTemplate) {
        return ctAdTemplate.photoAd.requestBannerAd;
    }

    public static long H(CtPhotoInfo ctPhotoInfo) {
        return ctPhotoInfo.mHotspotInfo.trendId;
    }

    public static String I(CtPhotoInfo ctPhotoInfo) {
        return ctPhotoInfo.mHotspotInfo.name;
    }

    public static HotspotInfo J(CtPhotoInfo ctPhotoInfo) {
        return ctPhotoInfo.mHotspotInfo;
    }

    public static String K(CtPhotoInfo ctPhotoInfo) {
        return ctPhotoInfo.coverInfo.webpCoverUrl;
    }

    public static boolean a(Matrix matrix, int i, int i2, PhotoInfo.VideoInfo videoInfo) {
        if (videoInfo == null) {
            return false;
        }
        float f = videoInfo.width;
        float f2 = videoInfo.height;
        if (f >= f2) {
            return false;
        }
        float f3 = (float) videoInfo.leftRatio;
        float f4 = (float) videoInfo.topRatio;
        float f5 = (float) videoInfo.widthRatio;
        float f6 = (float) videoInfo.heightRatio;
        float f7 = i / f;
        float f8 = i2 / f2;
        float f9 = f7 / f8;
        if (Math.abs(f9 - 1.0f) < 0.01d) {
            return false;
        }
        if (f7 > f8) {
            float f10 = f8 / f7;
            float f11 = (1.0f - f10) / 2.0f;
            float f12 = (f10 + 1.0f) / 2.0f;
            if (f4 < f11 || f4 + f6 > f12) {
                return false;
            }
        } else {
            float f13 = (1.0f - f9) / 2.0f;
            float f14 = (f9 + 1.0f) / 2.0f;
            if (f3 < f13 || f3 + f5 > f14) {
                return false;
            }
        }
        return true;
    }

    public static boolean b(PhotoInfo photoInfo) {
        return photoInfo.baseInfo.toolbarDisable;
    }
}
