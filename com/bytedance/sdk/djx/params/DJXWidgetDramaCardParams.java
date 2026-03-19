package com.bytedance.sdk.djx.params;

import com.bytedance.sdk.djx.interfaces.listener.IDJXDramaCardListener;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class DJXWidgetDramaCardParams {
    public int mWidth = 100;
    public boolean mHideSoundButton = false;
    public boolean mHideReplayButton = false;
    public boolean mIsMuteDefault = true;
    public boolean mIsLooping = false;
    public boolean mIsAutoPlay = true;
    public IDJXDramaCardListener mListener = null;
    public ICardClickListener mClickListener = null;

    public interface ICardClickListener {
        void onClick();
    }

    public static DJXWidgetDramaCardParams obtain() {
        return new DJXWidgetDramaCardParams();
    }

    public DJXWidgetDramaCardParams width(int i) {
        if (i > 0) {
            this.mWidth = i;
        }
        return this;
    }

    public DJXWidgetDramaCardParams hideSoundButton(boolean z) {
        this.mHideSoundButton = z;
        return this;
    }

    public DJXWidgetDramaCardParams hideReplayButton(boolean z) {
        this.mHideReplayButton = z;
        return this;
    }

    public DJXWidgetDramaCardParams looping(boolean z) {
        this.mIsLooping = z;
        return this;
    }

    public DJXWidgetDramaCardParams listener(IDJXDramaCardListener iDJXDramaCardListener) {
        this.mListener = iDJXDramaCardListener;
        return this;
    }

    public DJXWidgetDramaCardParams muteDefault(boolean z) {
        this.mIsMuteDefault = z;
        return this;
    }

    public DJXWidgetDramaCardParams clickListener(ICardClickListener iCardClickListener) {
        this.mClickListener = iCardClickListener;
        return this;
    }

    public DJXWidgetDramaCardParams autoPlay(boolean z) {
        this.mIsAutoPlay = z;
        return this;
    }

    public String toString() {
        return "width  = " + this.mWidth + ", hideSoundButton  = " + this.mHideSoundButton + ", hideReplayButton  = " + this.mHideReplayButton + ", isMuteDefault  = " + this.mIsMuteDefault + ", isLooping  = " + this.mIsLooping + ", isAutoPlay  = " + this.mIsAutoPlay;
    }
}
