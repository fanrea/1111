package com.kwad.components.ct.tube.d;

import android.app.Activity;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.kwad.components.ct.api.tube.KSTubeParamInner;
import com.kwad.components.ct.api.tube.TubeEpisodeHomeParam;
import com.kwad.components.ct.response.a.c;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.components.ct.response.model.CtPhotoInfo;
import com.kwad.components.ct.response.model.tube.TubeEpisode;
import com.kwad.components.ct.response.model.tube.TubeInfo;
import com.kwad.sdk.api.tube.KSTubeChannelData;
import com.kwad.sdk.api.tube.KSTubeData;
import com.kwad.sdk.api.tube.KSTubeDetailParam;
import com.kwad.sdk.api.tube.KSTubeParam;
import com.kwad.sdk.core.response.b.h;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.aa;
import com.kwad.sdk.utils.ap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b {
    public static String aq(long j) {
        if (j < 0 || j >= ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT) {
            return (j < ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT || j >= 100000000) ? j >= 100000000 ? String.format("%.1f", Float.valueOf(j / 1.0E8f)) + "亿" : "" : String.format("%.1f", Float.valueOf(j / 10000.0f)) + "w";
        }
        return new StringBuilder().append(j).toString();
    }

    public static String c(TubeInfo tubeInfo) {
        if (tubeInfo.isFinished) {
            return e(tubeInfo) + "集全";
        }
        return "更新至第" + f(tubeInfo) + "集";
    }

    public static String d(TubeInfo tubeInfo) {
        if (tubeInfo.isFinished) {
            return e(tubeInfo) + "集全 · 已完结";
        }
        return "更新至第" + f(tubeInfo) + "集";
    }

    public static String b(TubeEpisode tubeEpisode) {
        return "第" + tubeEpisode.episodeNumber + "集";
    }

    public static String a(TubeInfo tubeInfo, boolean z) {
        if (tubeInfo.isFinished && tubeInfo.watchEpisodeNum == f(tubeInfo) && z) {
            return "观看到第" + tubeInfo.watchEpisodeNum + "集 已看完";
        }
        return "观看到第" + tubeInfo.watchEpisodeNum + "集";
    }

    public static String c(TubeEpisode tubeEpisode) {
        return "点击解锁【" + tubeEpisode.tubeInfo.unlockEpisodeCount + "集】剧情";
    }

    public static long d(TubeEpisode tubeEpisode) {
        return tubeEpisode.tubeInfo.tubeId;
    }

    public static int e(TubeEpisode tubeEpisode) {
        return tubeEpisode.pcursor;
    }

    public static int f(TubeEpisode tubeEpisode) {
        return tubeEpisode.tubeInfo.totalEpisodeSize;
    }

    private static int e(TubeInfo tubeInfo) {
        return tubeInfo.lastEpisodeNum;
    }

    private static int f(TubeInfo tubeInfo) {
        return tubeInfo.lastEpisodeNum;
    }

    public static int g(TubeEpisode tubeEpisode) {
        return cX(f(tubeEpisode));
    }

    public static int cX(int i) {
        return ((i - 1) / 30) + 1;
    }

    public static TubeEpisode a(List<CtAdTemplate> list, long j, int i) {
        if (ap.aF(list)) {
            return null;
        }
        CtPhotoInfo ctPhotoInfoAy = com.kwad.components.ct.response.a.a.ay(list.get(0));
        if (c.t(ctPhotoInfoAy) != j) {
            return null;
        }
        int iQ = c.q(ctPhotoInfoAy);
        int iQ2 = c.q(com.kwad.components.ct.response.a.a.ay(list.get(list.size() - 1)));
        if (iQ <= i && i <= iQ2) {
            Iterator<CtAdTemplate> it = list.iterator();
            while (it.hasNext()) {
                CtPhotoInfo ctPhotoInfoAy2 = com.kwad.components.ct.response.a.a.ay(it.next());
                if (c.q(ctPhotoInfoAy2) >= i) {
                    return c.p(ctPhotoInfoAy2);
                }
            }
        }
        return null;
    }

    public static void a(Activity activity, long j, KSTubeParamInner kSTubeParamInner, TubeInfo tubeInfo) {
        com.kwad.components.ct.tube.b.a.Kv().b(tubeInfo);
        if (kSTubeParamInner.disableAutoOpenPlayPage) {
            return;
        }
        com.kwad.components.ct.tube.slide.a.a(activity, TubeEpisodeHomeParam.obtain().setEntryScene(j).setKSTubeParam(kSTubeParamInner).setTubeId(tubeInfo.tubeId).setWatchEpisodeNum(tubeInfo.watchEpisodeNum));
    }

    public static KSTubeChannelData g(TubeInfo tubeInfo) {
        return a(KSTubeChannelData.obtain().setAuthorId(String.valueOf(tubeInfo.authorId)).setAuthorName(tubeInfo.authorName).setTubeId(tubeInfo.tubeId).setTubeName(tubeInfo.name).setTotalEpisodeCount(e(tubeInfo)).setPlayCount(tubeInfo.viewCount).setCoverUrl(tubeInfo.coverUrl).setFinished(tubeInfo.isFinished).setFreeEpisodeCount(tubeInfo.freeEpisodeCount).setUnlockEpisodeCount(tubeInfo.unlockEpisodeCount), tubeInfo);
    }

    private static KSTubeChannelData a(KSTubeChannelData kSTubeChannelData, TubeInfo tubeInfo) {
        try {
            return kSTubeChannelData.setSecondChannelName(tubeInfo.secondChannelName).setLastEpisodeNum(tubeInfo.lastEpisodeNum).setLastWatchTime(tubeInfo.lastWatchTime).setWatchEpisodeNum(tubeInfo.watchEpisodeNum).setInnerDataStr(com.kwad.sdk.core.a.c.encodeKsSdk(tubeInfo.toJson().toString()));
        } catch (Throwable unused) {
            return kSTubeChannelData;
        }
    }

    public static TubeInfo a(KSTubeChannelData kSTubeChannelData) {
        TubeInfo tubeInfo = (TubeInfo) aa.b(com.kwad.sdk.core.a.c.decodeKsSdk(kSTubeChannelData.getInnerDataStr()), new com.kwad.sdk.core.c<TubeInfo>() { // from class: com.kwad.components.ct.tube.d.b.1
            @Override // com.kwad.sdk.core.c
            public final /* synthetic */ com.kwad.sdk.core.b Le() {
                return Ld();
            }

            private static TubeInfo Ld() {
                return new TubeInfo();
            }
        });
        tubeInfo.watchEpisodeNum = kSTubeChannelData.getWatchEpisodeNum();
        return tubeInfo;
    }

    public static KSTubeData L(CtPhotoInfo ctPhotoInfo) {
        TubeInfo tubeInfoC = c.C(ctPhotoInfo);
        KSTubeData unlockEpisodeCount = KSTubeData.obtain().setAuthorId(String.valueOf(c.e(ctPhotoInfo))).setAuthorName(c.g(ctPhotoInfo)).setTubeId(c.t(ctPhotoInfo)).setTubeName(c.w(ctPhotoInfo)).setEpisodeNumber(c.z(ctPhotoInfo)).setTotalEpisodeCount(c.y(ctPhotoInfo)).setPlayCount(c.A(ctPhotoInfo)).setCoverUrl(tubeInfoC.coverUrl).setFinished(tubeInfoC.isFinished).setLocked(c.B(ctPhotoInfo)).setFreeEpisodeCount(tubeInfoC.freeEpisodeCount).setUnlockEpisodeCount(tubeInfoC.unlockEpisodeCount);
        try {
            return unlockEpisodeCount.setVideoDesc(h.q(ctPhotoInfo));
        } catch (Throwable unused) {
            return unlockEpisodeCount;
        }
    }

    public static boolean q(int i, CtAdTemplate ctAdTemplate) {
        com.kwad.components.ct.tube.b.c cVarKw = com.kwad.components.ct.tube.b.a.Kv().Kw();
        if (cVarKw != null) {
            int iA = cVarKw.a(com.kwad.components.ct.detail.d.a.m(i, ctAdTemplate));
            if (iA == 1) {
                return true;
            }
            if (iA == 2) {
                return false;
            }
        }
        return c.B(com.kwad.components.ct.response.a.a.ay(ctAdTemplate));
    }

    public static KSTubeDetailParam a(SceneImpl sceneImpl, KSTubeParamInner kSTubeParamInner, TubeInfo tubeInfo) {
        String strEncodeKsSdk;
        if (kSTubeParamInner.disableAutoOpenPlayPage) {
            JSONObject jSONObject = new JSONObject();
            aa.putValue(jSONObject, "key_entry_scene", sceneImpl.entryScene);
            aa.a(jSONObject, "key_tube_info", tubeInfo);
            strEncodeKsSdk = com.kwad.sdk.core.a.c.encodeKsSdk(jSONObject.toString());
        } else {
            strEncodeKsSdk = "";
        }
        return KSTubeDetailParam.obtain().setKSTubeParam(KSTubeParam.obtain().setShowTitleBar(kSTubeParamInner.showTitleBar).setFreeEpisodeCount(kSTubeParamInner.freeEpisodeCount).setUnlockEpisodeCount(kSTubeParamInner.unlockEpisodeCount).setUserId(kSTubeParamInner.userId).setUserName(kSTubeParamInner.userName).setDisableUnLockTipDialog(kSTubeParamInner.disableUnLockTipDialog).setDisableAutoOpenPlayPage(kSTubeParamInner.disableAutoOpenPlayPage)).setTubeChannelData(g(tubeInfo)).setDetailData(strEncodeKsSdk);
    }

    public static TubeEpisodeHomeParam a(KSTubeDetailParam kSTubeDetailParam) {
        try {
            JSONObject jSONObject = new JSONObject(com.kwad.sdk.core.a.c.decodeKsSdk(kSTubeDetailParam.getDetailData()));
            TubeInfo tubeInfo = new TubeInfo();
            tubeInfo.parseJson(jSONObject.getJSONObject("key_tube_info"));
            long jOptLong = jSONObject.optLong("key_entry_scene");
            if (jOptLong != 0 && tubeInfo.tubeId != 0) {
                return TubeEpisodeHomeParam.obtain().setEntryScene(jOptLong).setKSTubeParam(KSTubeParamInner.covertFrom(kSTubeDetailParam.getKSTubeParam())).setTubeId(tubeInfo.tubeId).setWatchEpisodeNum(tubeInfo.watchEpisodeNum);
            }
        } catch (Throwable unused) {
        }
        return null;
    }
}
