package com.bytedance.sdk.djx;

import com.bytedance.sdk.djx.model.DJXDrama;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DJXDramaLog {
    private DJXDrama drama;
    private DramaEvent event;

    public enum DramaEvent {
        APP_ACTIVATE,
        CLIENT_SHOW,
        ENTER_CATEGORY,
        STAY_CATEGORY
    }

    private DJXDramaLog(DramaEvent dramaEvent) {
        setEvent(dramaEvent);
    }

    public static DJXDramaLog obtain(DramaEvent dramaEvent) {
        return new DJXDramaLog(dramaEvent);
    }

    public DJXDramaLog setDrama(DJXDrama dJXDrama) {
        this.drama = dJXDrama;
        return this;
    }

    public DJXDramaLog setEvent(DramaEvent dramaEvent) {
        this.event = dramaEvent;
        return this;
    }

    public DJXDrama getDrama() {
        return this.drama;
    }

    public DramaEvent getEvent() {
        return this.event;
    }
}
