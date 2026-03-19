package com.kwad.components.ct.profile.tabvideo;

import com.kwad.sdk.core.scene.URLPackage;
import java.io.Serializable;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class ProfileTabVideoParam implements Serializable {
    private static final long serialVersionUID = -6152648276167879373L;
    public long mAuthorId;
    public long mCurrentPhotoId;
    public long mEntryScene;
    public long mTabId;
    public String mTabName;
    public URLPackage mURLPackage;

    public boolean isValid() {
        return (this.mEntryScene == 0 || this.mURLPackage == null || this.mAuthorId == 0) ? false : true;
    }
}
