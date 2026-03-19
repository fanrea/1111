package com.kwai.video.ksliveplayer.model;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class LiveRetryConfigModel implements Cloneable {
    public int emptyReadSizeDuration = 10;
    public int stalledDurationInOneMinute = 15;
    public boolean autoSwitchCDNEnabled = true;

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public LiveRetryConfigModel m464clone() {
        try {
            return (LiveRetryConfigModel) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
