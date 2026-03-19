package com.ss.ttm.player;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public abstract class HLSChooseStreamInterface extends TraitObject {
    private static final int Version0 = 0;

    public static class Playlist {
        public int mIndex = 0;
        public Rendition[] mRenditions = null;
    }

    public static class Rendition {
        public int mMediaTrackType = 0;
        public int mInfoId = -1;
        public String mGroupId = null;
        public String mLanguage = null;
        public String mName = null;
    }

    public static class Variant {
        public int mAverageBandwidth;
        public String mClosedCaptions;
        public String mCodecs;
        public float mFrameRate;
        public String mHDCPLevel;
        public int mHeight;
        public int mWidth;
        public int mBandWidth = 0;
        public String mAudioGroup = null;
        public String mVideoGroup = null;
        public String mSubtitlesGroup = null;
        public Playlist[] mPlaylists = null;
    }

    private static int covertMediaType(int i) {
        if (i == 0) {
            return 1;
        }
        if (i != 1) {
            return i != 3 ? 0 : 4;
        }
        return 2;
    }

    public abstract int chooseRenditionInfoId(int i);

    public abstract int chooseVariantBandWidth();

    public abstract void streamInfos(Variant[] variantArr);

    public HLSChooseStreamInterface() {
        super(7, 0, 0L);
    }

    protected void stream_info(String str) throws JSONException {
        Variant[] variant = parseVariant(str);
        if (variant == null) {
            return;
        }
        streamInfos(variant);
    }

    protected int choose_variant_bandWidth() {
        return chooseVariantBandWidth();
    }

    protected int choose_rendition_infoId(int i) {
        return chooseRenditionInfoId(i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v4, types: [com.ss.ttm.player.HLSChooseStreamInterface$Playlist[]] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9, types: [com.ss.ttm.player.HLSChooseStreamInterface$Rendition[]] */
    private Variant[] parseVariant(String str) throws JSONException {
        JSONArray jSONArray;
        ?? r1;
        JSONArray jSONArray2;
        Variant[] variantArr = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONArray jSONArray3 = new JSONArray(str);
            int length = jSONArray3.length();
            Variant[] variantArr2 = new Variant[length];
            int i = 0;
            int i2 = 0;
            while (i2 < length) {
                try {
                    JSONObject jSONObject = jSONArray3.getJSONObject(i2);
                    Variant variant = new Variant();
                    variant.mBandWidth = jSONObject.optInt("bandwidth", i);
                    variant.mAverageBandwidth = jSONObject.optInt("average_bandwidth", i);
                    variant.mCodecs = jSONObject.optString("codecs", "");
                    variant.mWidth = jSONObject.optInt("width", i);
                    variant.mHeight = jSONObject.optInt("height", i);
                    variant.mFrameRate = (float) jSONObject.optDouble("frame_rate", 0.0d);
                    variant.mHDCPLevel = jSONObject.optString("HDCP_level", "");
                    variant.mClosedCaptions = jSONObject.optString("closed_captions", "");
                    variant.mAudioGroup = jSONObject.optString("audio_group", "");
                    variant.mVideoGroup = jSONObject.optString("video_group", "");
                    variant.mSubtitlesGroup = jSONObject.optString("subtitles_group", "");
                    int iOptInt = jSONObject.optInt("n_playlists", i);
                    JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("playlists");
                    if (jSONArrayOptJSONArray == null || iOptInt <= 0) {
                        jSONArray = jSONArray3;
                        r1 = variantArr;
                        variant.mPlaylists = r1;
                        variantArr2[i2] = variant;
                    } else {
                        variant.mPlaylists = new Playlist[iOptInt];
                        int i3 = i;
                        while (i3 < iOptInt) {
                            JSONObject jSONObject2 = jSONArrayOptJSONArray.getJSONObject(i3);
                            Playlist playlist = new Playlist();
                            playlist.mIndex = jSONObject2.optInt("index", i);
                            int iOptInt2 = jSONObject2.optInt("n_renditions", i);
                            JSONArray jSONArrayOptJSONArray2 = jSONObject2.optJSONArray("renditions");
                            if (iOptInt2 <= 0 || jSONArrayOptJSONArray2 == null) {
                                jSONArray2 = jSONArray3;
                                playlist.mRenditions = variantArr;
                                variant.mPlaylists[i3] = playlist;
                            } else {
                                playlist.mRenditions = new Rendition[iOptInt2];
                                int i4 = i;
                                while (i4 < iOptInt2) {
                                    JSONObject jSONObject3 = jSONArrayOptJSONArray2.getJSONObject(i4);
                                    Rendition rendition = new Rendition();
                                    rendition.mMediaTrackType = covertMediaType(jSONObject3.optInt("type", -1));
                                    rendition.mName = jSONObject3.optString("name", "");
                                    rendition.mInfoId = jSONObject3.optInt("info_id", -1);
                                    rendition.mGroupId = jSONObject3.optString("group_id", "");
                                    rendition.mLanguage = jSONObject3.optString("language", "");
                                    playlist.mRenditions[i4] = rendition;
                                    i4++;
                                    jSONArray3 = jSONArray3;
                                }
                                jSONArray2 = jSONArray3;
                                variant.mPlaylists[i3] = playlist;
                            }
                            i3++;
                            jSONArray3 = jSONArray2;
                            variantArr = null;
                            i = 0;
                        }
                        jSONArray = jSONArray3;
                        variantArr2[i2] = variant;
                        r1 = 0;
                    }
                    i2++;
                    variantArr = r1;
                    jSONArray3 = jSONArray;
                    i = 0;
                } catch (JSONException e) {
                    e = e;
                    variantArr = variantArr2;
                    e.printStackTrace();
                    return variantArr;
                }
            }
            return variantArr2;
        } catch (JSONException e2) {
            e = e2;
        }
    }
}
