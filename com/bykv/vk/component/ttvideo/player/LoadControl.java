package com.bykv.vk.component.ttvideo.player;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public abstract class LoadControl extends NativeObject {
    protected abstract int onCodecStackSelected(int i);

    protected abstract int onFilterStackSelected(int i);

    protected abstract int onTrackSelected(int i);

    protected abstract boolean shouldStartPlayback(long j, float f, boolean z);
}
