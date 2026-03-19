package com.kwad.components.ct.profile.home;

import com.kwad.components.ct.response.model.CtAdTemplate;
import java.io.Serializable;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class ProfileHomeParam implements Serializable {
    private static final long serialVersionUID = -6152648276167879373L;
    public CtAdTemplate mAdTemplate;
    public long mCurrentPhotoId;
    public long mEntryScene;

    public boolean isValid() {
        return (this.mEntryScene == 0 || com.kwad.components.ct.response.a.c.e(this.mAdTemplate.photoInfo) == 0) ? false : true;
    }
}
