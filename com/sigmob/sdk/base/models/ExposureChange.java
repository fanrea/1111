package com.sigmob.sdk.base.models;

import android.graphics.Rect;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class ExposureChange {
    float exposedPercentage;
    List occlusionRectangles;
    Rect visibleRectangle;

    public ExposureChange(float exposedPercentage, Rect visibleRectangle, List occlusionRectangles) {
        this.exposedPercentage = exposedPercentage;
        this.visibleRectangle = visibleRectangle;
        this.occlusionRectangles = occlusionRectangles;
    }

    public String toString() {
        return "\"exposureChange\"={\"exposedPercentage\"=" + this.exposedPercentage + ", \"visibleRectangle\"={\"x\"=" + this.visibleRectangle.left + ",\"y\"=" + this.visibleRectangle.top + ",\"width\"=" + this.visibleRectangle.width() + ",\"height\"=" + this.visibleRectangle.height() + "}, \"occlusionRectangles\"=[]}";
    }
}
