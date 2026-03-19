package com.kwai.player;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.view.Display;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class KwaiDisplayHdrCapabilitiesDetector {
    private static KwaiDisplayHdrCapabilitiesDetector sHdrCapabilitiesUtil;
    private Context mContext;
    private float mDesiredMaxAverageLuminance;
    private float mDesiredMaxLuminance;
    private float mDesiredMinLuminance;
    private DisplayManager mDisplayManager;
    private Display.HdrCapabilities mHdrCapabilities;
    private String mHdrTypes = "";
    private boolean misInited = false;

    public static synchronized KwaiDisplayHdrCapabilitiesDetector getInstance() {
        if (sHdrCapabilitiesUtil == null) {
            sHdrCapabilitiesUtil = new KwaiDisplayHdrCapabilitiesDetector();
        }
        return sHdrCapabilitiesUtil;
    }

    public synchronized void init(Context context) {
        if (this.misInited) {
            return;
        }
        this.mContext = context;
        DisplayManager displayManager = (DisplayManager) context.getSystemService("display");
        this.mDisplayManager = displayManager;
        Display.HdrCapabilities hdrCapabilities = displayManager.getDisplay(0).getHdrCapabilities();
        this.mHdrCapabilities = hdrCapabilities;
        for (int i : hdrCapabilities.getSupportedHdrTypes()) {
            if (i == 1) {
                this.mHdrTypes += "HDR_TYPE_DOLBY_VISION,";
            } else if (i == 2) {
                this.mHdrTypes += "HDR_TYPE_HDR10,";
            } else if (i == 3) {
                this.mHdrTypes += "HDR_TYPE_HLG";
            }
        }
        this.mDesiredMaxAverageLuminance = this.mHdrCapabilities.getDesiredMaxAverageLuminance();
        this.mDesiredMaxLuminance = this.mHdrCapabilities.getDesiredMaxLuminance();
        this.mDesiredMinLuminance = this.mHdrCapabilities.getDesiredMinLuminance();
        this.misInited = true;
    }

    public String getHdrCapabilitiesTypes() {
        return this.mHdrTypes;
    }

    public float getHdrMaxAverageLuminance() {
        return this.mDesiredMaxAverageLuminance;
    }

    public float getHdrMaxLuminance() {
        return this.mDesiredMaxLuminance;
    }

    public float getHdrMinLuminance() {
        return this.mDesiredMinLuminance;
    }
}
