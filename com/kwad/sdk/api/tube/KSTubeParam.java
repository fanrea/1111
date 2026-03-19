package com.kwad.sdk.api.tube;

import com.kwad.sdk.api.core.KsAdSdkApi;
import java.io.Serializable;

@KsAdSdkApi
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class KSTubeParam implements Serializable {
    private static final int DEFAULT = -1;
    private static final int FREE_ALL = 100000;
    private static final long serialVersionUID = 6615973133935328712L;
    private boolean disableAutoOpenPlayPage;
    private boolean disableShowTubePanelEntry;
    private boolean disableUnLockTipDialog;
    private boolean hideDetailBottomDesc;
    private boolean hideDetailBottomTitle;
    private boolean hideDetailPlaySeekbar;
    private boolean hideDetailTitleBar;
    private boolean showTitleBar;
    private int unLockTipDialogCloseNextStep;
    private int freeEpisodeCount = -1;
    private int unlockEpisodeCount = -1;
    private String userId = "";
    private String userName = "";
    private int detailPageMode = 0;

    private KSTubeParam() {
    }

    public static KSTubeParam obtain() {
        return new KSTubeParam();
    }

    public KSTubeParam setFreeEpisodeCount(int i) {
        if (i < 0) {
            i = -1;
        } else if (i > 100000) {
            i = 100000;
        }
        this.freeEpisodeCount = i;
        return this;
    }

    public KSTubeParam setUnlockEpisodeCount(int i) {
        if (i <= 0) {
            i = -1;
        }
        this.unlockEpisodeCount = i;
        return this;
    }

    public KSTubeParam setShowTitleBar(boolean z) {
        this.showTitleBar = z;
        return this;
    }

    public KSTubeParam setUserId(String str) {
        this.userId = str;
        return this;
    }

    public KSTubeParam setUserName(String str) {
        this.userName = str;
        return this;
    }

    public KSTubeParam setDisableUnLockTipDialog(boolean z) {
        this.disableUnLockTipDialog = z;
        return this;
    }

    public KSTubeParam setDisableAutoOpenPlayPage(boolean z) {
        this.disableAutoOpenPlayPage = z;
        return this;
    }

    public KSTubeParam setDisableShowTubePanelEntry(boolean z) {
        this.disableShowTubePanelEntry = z;
        return this;
    }

    public KSTubeParam setUnLockTipDialogCloseNextStep(int i) {
        this.unLockTipDialogCloseNextStep = i;
        return this;
    }

    public KSTubeParam setDetailPageMode(int i) {
        this.detailPageMode = i;
        return this;
    }

    public KSTubeParam setHideDetailTitleBar(boolean z) {
        this.hideDetailTitleBar = z;
        return this;
    }

    public KSTubeParam setHideDetailBottomTitle(boolean z) {
        this.hideDetailBottomTitle = z;
        return this;
    }

    public KSTubeParam setHideDetailBottomDesc(boolean z) {
        this.hideDetailBottomDesc = z;
        return this;
    }

    public KSTubeParam setHideDetailPlaySeekbar(boolean z) {
        this.hideDetailPlaySeekbar = z;
        return this;
    }

    public int getFreeEpisodeCount() {
        return this.freeEpisodeCount;
    }

    public int getUnlockEpisodeCount() {
        return this.unlockEpisodeCount;
    }

    public String getUserId() {
        return this.userId;
    }

    public String getUserName() {
        return this.userName;
    }

    public boolean isShowTitleBar() {
        return this.showTitleBar;
    }

    public boolean isDisableUnLockTipDialog() {
        return this.disableUnLockTipDialog;
    }

    public boolean isDisableAutoOpenPlayPage() {
        return this.disableAutoOpenPlayPage;
    }

    public boolean isDisableShowTubePanelEntry() {
        return this.disableShowTubePanelEntry;
    }

    public int getUnLockTipDialogCloseNextStep() {
        return this.unLockTipDialogCloseNextStep;
    }

    public int getDetailPageMode() {
        return this.detailPageMode;
    }

    public boolean isHideDetailTitleBar() {
        return this.hideDetailTitleBar;
    }

    public boolean isHideDetailBottomTitle() {
        return this.hideDetailBottomTitle;
    }

    public boolean isHideDetailBottomDesc() {
        return this.hideDetailBottomDesc;
    }

    public boolean isHideDetailPlaySeekbar() {
        return this.hideDetailPlaySeekbar;
    }
}
