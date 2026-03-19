package com.kwai.player;

import android.content.Context;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import com.pandora.common.Constants;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class KwaiHdrCodecCapabilities {
    private static KwaiHdrCodecCapabilities sHdrCapabilitiesUtil;
    private boolean misInited = false;
    private String mHdr10 = "";
    private String mHdrDolby = "";
    private String mHdrVp9 = "";

    public static synchronized KwaiHdrCodecCapabilities getInstance() {
        if (sHdrCapabilitiesUtil == null) {
            sHdrCapabilitiesUtil = new KwaiHdrCodecCapabilities();
        }
        return sHdrCapabilitiesUtil;
    }

    public void init(Context context) {
        if (this.misInited) {
            return;
        }
        int codecCount = MediaCodecList.getCodecCount();
        for (int i = 0; i < codecCount; i++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i);
            if (!codecInfoAt.isEncoder()) {
                for (String str : codecInfoAt.getSupportedTypes()) {
                    if (str.equalsIgnoreCase(Constants.CodecType.VIDEO_H265)) {
                        for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : codecInfoAt.getCapabilitiesForType(Constants.CodecType.VIDEO_H265).profileLevels) {
                            if (codecProfileLevel.profile == 4096 && !this.mHdr10.contains("HEVCProfileMain10HDR10")) {
                                this.mHdr10 = "HEVCProfileMain10HDR10";
                            }
                        }
                    }
                    if (str.equalsIgnoreCase("video/x-vnd.on2.vp9")) {
                        for (MediaCodecInfo.CodecProfileLevel codecProfileLevel2 : codecInfoAt.getCapabilitiesForType("video/x-vnd.on2.vp9").profileLevels) {
                            int i2 = codecProfileLevel2.profile;
                            if (i2 == 4096) {
                                if (!this.mHdrVp9.contains("VP9Profile2HDR")) {
                                    this.mHdrVp9 += "VP9Profile2HDR, ";
                                }
                            } else if (i2 == 8192 && !this.mHdrVp9.contains("VP9Profile3HDR")) {
                                this.mHdrVp9 += "VP9Profile3HDR, ";
                            }
                        }
                    }
                    if (str.equalsIgnoreCase("video/dolby-vision")) {
                        for (MediaCodecInfo.CodecProfileLevel codecProfileLevel3 : codecInfoAt.getCapabilitiesForType("video/dolby-vision").profileLevels) {
                            int i3 = codecProfileLevel3.profile;
                            if (i3 != 1) {
                                if (i3 != 2) {
                                    if (i3 != 4) {
                                        if (i3 != 8) {
                                            if (i3 != 16) {
                                                if (i3 != 32) {
                                                    if (i3 != 64) {
                                                        if (i3 == 128 && !this.mHdrDolby.contains("DolbyVisionProfileDvheDtb")) {
                                                            this.mHdrDolby += "DolbyVisionProfileDvheDtb, ";
                                                        }
                                                    } else if (!this.mHdrDolby.contains("DolbyVisionProfileDvheDth")) {
                                                        this.mHdrDolby += "DolbyVisionProfileDvheDth, ";
                                                    }
                                                } else if (!this.mHdrDolby.contains("DolbyVisionProfileDvheStn")) {
                                                    this.mHdrDolby += "DolbyVisionProfileDvheStn, ";
                                                }
                                            } else if (!this.mHdrDolby.contains("DolbyVisionProfileDvheDtr")) {
                                                this.mHdrDolby += "DolbyVisionProfileDvheDtr, ";
                                            }
                                        } else if (!this.mHdrDolby.contains("DolbyVisionProfileDvheDen")) {
                                            this.mHdrDolby += "DolbyVisionProfileDvheDen, ";
                                        }
                                    } else if (!this.mHdrDolby.contains("DolbyVisionProfileDvheDer")) {
                                        this.mHdrDolby += "DolbyVisionProfileDvheDer, ";
                                    }
                                } else if (!this.mHdrDolby.contains("DolbyVisionProfileDvavPen")) {
                                    this.mHdrDolby += "DolbyVisionProfileDvavPen, ";
                                }
                            } else if (!this.mHdrDolby.contains("DolbyVisionProfileDvavPer")) {
                                this.mHdrDolby += "DolbyVisionProfileDvavPer, ";
                            }
                        }
                    }
                }
            }
        }
        this.misInited = true;
    }

    public String getHdr10() {
        return this.mHdr10;
    }

    public String getHdrDolby() {
        return this.mHdrDolby;
    }

    public String getHdrVp9() {
        return this.mHdrVp9;
    }
}
