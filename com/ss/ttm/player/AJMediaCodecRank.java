package com.ss.ttm.player;

import android.media.MediaCodecInfo;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class AJMediaCodecRank {
    public static final int RANK_ACCEPTABLE = 70;
    public static final int RANK_CODEC2_ACCEPTABLE = 150;
    public static final int RANK_CODEC2_TESTED = 200;
    public static final int RANK_IMPL_AMBIGUOUS = 40;
    public static final int RANK_NO_CAPS = 60;
    public static final int RANK_SOFTWARE = 20;
    public static final int RANK_TESTED = 100;
    private static final String TAG = "AJMediaCodecRank";
    private static Map<String, Integer> mTestHWCodecs;
    public String mCodecType;
    public MediaCodecInfo mMediaCodecInfo;
    public int mRank = 0;

    private static Map<String, Integer> getTestHWcodecs() {
        Map<String, Integer> map = mTestHWCodecs;
        if (map != null) {
            return map;
        }
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        mTestHWCodecs = treeMap;
        treeMap.put("OMX.qcom.video.decoder.avc", 100);
        mTestHWCodecs.put("OMX.qcom.video.decoder.hevc", 100);
        mTestHWCodecs.put("OMX.qcom.video.decoder.hevcswvdec", 20);
        mTestHWCodecs.put("OMX.MTK.VIDEO.DECODER.HEVC", 100);
        mTestHWCodecs.put("OMX.MTK.VIDEO.DECODER.AVC", 100);
        mTestHWCodecs.put("OMX.Nvidia.h264.decode", 100);
        mTestHWCodecs.put("OMX.Intel.hw_vd.h264", 100);
        mTestHWCodecs.put("OMX.Intel.VideoDecoder.AVC", 99);
        mTestHWCodecs.put("OMX.SEC.avc.dec", 100);
        mTestHWCodecs.put("OMX.SEC.AVC.Decoder", 99);
        mTestHWCodecs.put("OMX.SEC.avcdec", 98);
        mTestHWCodecs.put("OMX.SEC.avc.sw.dec", 20);
        mTestHWCodecs.put("OMX.SEC.hevc.sw.dec", 20);
        mTestHWCodecs.put("OMX.Exynos.avc.dec", 100);
        mTestHWCodecs.put("OMX.Exynos.AVC.Decoder", 99);
        mTestHWCodecs.put("OMX.TI.DUCATI1.VIDEO.DECODER", 100);
        mTestHWCodecs.put("OMX.rk.video_decoder.avc", 100);
        mTestHWCodecs.put("OMX.amlogic.avc.decoder.awesome", 100);
        mTestHWCodecs.put("OMX.MARVELL.VIDEO.HW.CODA7542DECODER", 100);
        mTestHWCodecs.put("OMX.brcm.video.h264.hw.decoder", 40);
        mTestHWCodecs.put("OMX.k3.video.decoder.avc", 40);
        mTestHWCodecs.put("OMX.IMG.MSVDX.Decoder.AVC", 100);
        mTestHWCodecs.put("OMX.hisi.video.decoder.avc", 100);
        mTestHWCodecs.put("OMX.hisi.video.decoder.hevc", 100);
        mTestHWCodecs.put("OMX.MARVELL.VIDEO.H264DECODER", 20);
        mTestHWCodecs.put("OMX.sprd.soft.h264.decoder", 20);
        mTestHWCodecs.put("OMX.google.aac.decoder", 100);
        return mTestHWCodecs;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.ss.ttm.player.AJMediaCodecRank setupRank(android.media.MediaCodecInfo r4, java.lang.String r5) {
        /*
            r0 = 0
            if (r4 != 0) goto L4
            return r0
        L4:
            java.lang.String r1 = r4.getName()
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 == 0) goto Lf
            return r0
        Lf:
            java.util.Map r0 = getTestHWcodecs()
            java.lang.Object r0 = r0.get(r1)
            java.lang.Integer r0 = (java.lang.Integer) r0
            r2 = 60
            if (r0 == 0) goto L22
            int r2 = r0.intValue()
            goto L40
        L22:
            android.media.MediaCodecInfo$CodecCapabilities r0 = r4.getCapabilitiesForType(r5)     // Catch: java.lang.Exception -> L40
            if (r0 == 0) goto L40
            r0 = 48
            r3 = 0
            int r0 = com.ss.ttm.player.TTPlayerConfiger.getValue(r0, r3)     // Catch: java.lang.Exception -> L40
            r3 = 1
            if (r0 != r3) goto L3d
            java.lang.String r0 = "c2."
            boolean r0 = r1.startsWith(r0)     // Catch: java.lang.Exception -> L40
            if (r0 == 0) goto L3d
            r0 = 150(0x96, float:2.1E-43)
            goto L3f
        L3d:
            r0 = 70
        L3f:
            r2 = r0
        L40:
            com.ss.ttm.player.AJMediaCodecRank r0 = new com.ss.ttm.player.AJMediaCodecRank
            r0.<init>()
            r0.mMediaCodecInfo = r4
            r0.mCodecType = r5
            r0.mRank = r2
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.ttm.player.AJMediaCodecRank.setupRank(android.media.MediaCodecInfo, java.lang.String):com.ss.ttm.player.AJMediaCodecRank");
    }
}
