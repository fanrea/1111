package com.kwad.components.ct.api.tube;

import com.kwad.sdk.api.tube.KSTubeParam;
import java.io.Serializable;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class KSTubeParamInner implements Serializable {
    public static final int FREE_ALL = 100000;
    private static final long serialVersionUID = -888126990858676018L;
    public boolean disableAutoOpenPlayPage;
    public boolean disableShowTubePanelEntry;
    public boolean disableUnLockTipDialog;
    public boolean hideDetailBottomDesc;
    public boolean hideDetailBottomTitle;
    public boolean hideDetailPlaySeekbar;
    public boolean hideDetailTitleBar;
    public boolean showTitleBar;
    public int freeEpisodeCount = -1;
    public int unlockEpisodeCount = -1;
    public String userId = "";
    public String userName = "";
    public int dialogCloseNextStep = 2;
    public int pageMode = 1;

    private KSTubeParamInner() {
    }

    public static KSTubeParamInner obtain() {
        return new KSTubeParamInner();
    }

    public static KSTubeParamInner covertFrom(KSTubeParam kSTubeParam) {
        KSTubeParamInner disableAutoOpenPlayPage = obtain().setShowTitleBar(kSTubeParam.isShowTitleBar()).setFreeEpisodeCount(kSTubeParam.getFreeEpisodeCount()).setUnlockEpisodeCount(kSTubeParam.getUnlockEpisodeCount()).setUserId(kSTubeParam.getUserId()).setUserName(kSTubeParam.getUserName()).setDisableUnLockTipDialog(kSTubeParam.isDisableUnLockTipDialog()).setDisableAutoOpenPlayPage(kSTubeParam.isDisableAutoOpenPlayPage());
        try {
            disableAutoOpenPlayPage = disableAutoOpenPlayPage.setDisableShowTubePanelEntry(kSTubeParam.isDisableShowTubePanelEntry());
        } catch (Throwable unused) {
        }
        int i = 0;
        try {
            int unLockTipDialogCloseNextStep = kSTubeParam.getUnLockTipDialogCloseNextStep();
            int i2 = 2;
            if (unLockTipDialogCloseNextStep == 1) {
                i = 1;
            } else if (unLockTipDialogCloseNextStep == 2) {
                i = 2;
            }
            if (kSTubeParam.getDetailPageMode() != 1) {
                i2 = 1;
            } else {
                disableAutoOpenPlayPage.setDisableShowTubePanelEntry(true);
            }
            return disableAutoOpenPlayPage.setDialogCloseNextStep(i).setPageMode(i2).setHideDetailTitleBar(kSTubeParam.isHideDetailTitleBar()).setHideDetailBottomTitle(kSTubeParam.isHideDetailBottomTitle()).setHideDetailBottomDesc(kSTubeParam.isHideDetailBottomDesc()).setHideDetailPlaySeekbar(kSTubeParam.isHideDetailPlaySeekbar());
        } catch (Throwable unused2) {
            return disableAutoOpenPlayPage;
        }
    }

    public KSTubeParamInner setFreeEpisodeCount(int i) {
        this.freeEpisodeCount = i;
        return this;
    }

    public KSTubeParamInner setUnlockEpisodeCount(int i) {
        this.unlockEpisodeCount = i;
        return this;
    }

    public KSTubeParamInner setShowTitleBar(boolean z) {
        this.showTitleBar = z;
        return this;
    }

    public KSTubeParamInner setUserId(String str) {
        this.userId = str;
        return this;
    }

    public KSTubeParamInner setUserName(String str) {
        this.userName = str;
        return this;
    }

    public KSTubeParamInner setDisableUnLockTipDialog(boolean z) {
        this.disableUnLockTipDialog = z;
        return this;
    }

    public KSTubeParamInner setDisableAutoOpenPlayPage(boolean z) {
        this.disableAutoOpenPlayPage = z;
        return this;
    }

    public KSTubeParamInner setDisableShowTubePanelEntry(boolean z) {
        this.disableShowTubePanelEntry = z;
        return this;
    }

    public KSTubeParamInner setDialogCloseNextStep(int i) {
        this.dialogCloseNextStep = i;
        return this;
    }

    public KSTubeParamInner setPageMode(int i) {
        this.pageMode = i;
        return this;
    }

    public KSTubeParamInner setHideDetailTitleBar(boolean z) {
        this.hideDetailTitleBar = z;
        return this;
    }

    public KSTubeParamInner setHideDetailBottomTitle(boolean z) {
        this.hideDetailBottomTitle = z;
        return this;
    }

    public KSTubeParamInner setHideDetailBottomDesc(boolean z) {
        this.hideDetailBottomDesc = z;
        return this;
    }

    public KSTubeParamInner setHideDetailPlaySeekbar(boolean z) {
        this.hideDetailPlaySeekbar = z;
        return this;
    }
}
