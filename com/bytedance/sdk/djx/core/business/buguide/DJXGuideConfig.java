package com.bytedance.sdk.djx.core.business.buguide;

import android.view.View;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DJXGuideConfig {
    private Anchor mAnchor;
    private View mHintView;
    private int mHintPosition = 0;
    private int mGap = 0;
    private int mBackgroundColorInt = 0;
    private int mLinkAnchorRes = 0;
    private int mLinkAnchorInterval = 0;

    public interface HintViewPosition {
        public static final int BOTTOM = 3;
        public static final int LEFT = 0;
        public static final int RIGHT = 1;
        public static final int TOP = 2;
    }

    private DJXGuideConfig() {
    }

    public static DJXGuideConfig get() {
        return new DJXGuideConfig();
    }

    public DJXGuideConfig hintView(View view) {
        this.mHintView = view;
        return this;
    }

    public DJXGuideConfig hintPosition(int i) {
        this.mHintPosition = i;
        return this;
    }

    public DJXGuideConfig gap(int i) {
        this.mGap = i;
        return this;
    }

    public DJXGuideConfig backgroundColorInt(int i) {
        this.mBackgroundColorInt = i;
        return this;
    }

    public DJXGuideConfig linkAnchorImage(int i) {
        this.mLinkAnchorRes = i;
        return this;
    }

    public DJXGuideConfig linkAnchorInterval(int i) {
        this.mLinkAnchorInterval = i;
        return this;
    }

    public DJXGuideConfig anchor(Anchor anchor) {
        this.mAnchor = anchor;
        return this;
    }

    public int getLinkAnchorInterval() {
        return this.mLinkAnchorInterval;
    }

    public int getLinkAnchorRes() {
        return this.mLinkAnchorRes;
    }

    public View getHintView() {
        return this.mHintView;
    }

    public int getHintPosition() {
        return this.mHintPosition;
    }

    public int getGap() {
        return this.mGap;
    }

    public int getBackgroundColorInt() {
        return this.mBackgroundColorInt;
    }

    public Anchor getAnchor() {
        return this.mAnchor;
    }

    public static class Anchor {
        private int[] mAnchorCoordinate;
        private int[] mAnchorViewSize;

        private Anchor() {
        }

        public static Anchor get() {
            return new Anchor();
        }

        public Anchor anchorCoordinate(int[] iArr) {
            this.mAnchorCoordinate = iArr;
            return this;
        }

        public Anchor anchorViewSize(int[] iArr) {
            this.mAnchorViewSize = iArr;
            return this;
        }

        public int[] getAnchorCoordinate() {
            return this.mAnchorCoordinate;
        }

        public int[] getAnchorViewSize() {
            return this.mAnchorViewSize;
        }
    }
}
