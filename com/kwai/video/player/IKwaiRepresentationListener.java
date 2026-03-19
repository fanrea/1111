package com.kwai.video.player;

import com.kwai.player.KwaiRepresentation;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public interface IKwaiRepresentationListener {
    int onSelectRepresentation(List<KwaiRepresentation> list);

    void representationChangeEnd(int i);

    void representationChangeStart(int i, int i2);
}
