package com.kwad.components.ct.tube.channel.detail;

import com.kwad.components.ct.api.tube.KSTubeParamInner;
import com.kwad.components.ct.response.model.tube.ChannelInfo;
import java.io.Serializable;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class ChannelDetailParam implements Serializable {
    private static final long serialVersionUID = -5238032101385027454L;
    public ChannelInfo mChannelInfo;
    public long mEntryScene;
    public KSTubeParamInner mKSTubeParam;

    public boolean isValid() {
        return this.mEntryScene != 0;
    }
}
