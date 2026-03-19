package com.kwad.components.ct.emotion.b;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.kwad.components.ct.emotion.model.CDNUrl;
import com.kwad.components.ct.emotion.model.EmotionInfo;
import com.kwad.framework.filedownloader.r;
import com.luck.picture.lib.config.PictureMimeType;
import java.io.File;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class d {
    private volatile Queue<com.kwad.framework.filedownloader.a> aCr = new ConcurrentLinkedQueue();
    private volatile Queue<com.kwad.framework.filedownloader.a> aCs = new ConcurrentLinkedQueue();

    public interface a {
        void onError();

        void onSuccess(String str);
    }

    public final void a(EmotionInfo emotionInfo, boolean z, a aVar) {
        a(z ? emotionInfo.emotionImageBigUrl : emotionInfo.emotionImageSmallUrl, emotionInfo.id, z, aVar);
        DR();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DR() {
        synchronized (d.class) {
            if (this.aCr.isEmpty() && this.aCs.isEmpty()) {
                return;
            }
            int size = 10 - this.aCs.size();
            int size2 = this.aCr.size();
            for (int i = 0; i < size && i < size2; i++) {
                com.kwad.framework.filedownloader.a aVarPoll = this.aCr.poll();
                if (aVarPoll != null && !aVarPoll.isRunning()) {
                    this.aCs.offer(aVarPoll);
                    aVarPoll.start();
                }
            }
        }
    }

    private void a(List<CDNUrl> list, String str, boolean z, a aVar) {
        String strC = b.DO().c(str, z);
        if (strC != null) {
            if (aVar != null) {
                aVar.onSuccess(strC);
            }
        } else {
            if (list == null || list.isEmpty()) {
                return;
            }
            a(0, com.kwad.components.ct.emotion.b.a.c(list, null), str, z, aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final int i, final String[] strArr, final String str, final boolean z, final a aVar) {
        String strDP;
        if (i >= strArr.length) {
            aVar.onError();
            return;
        }
        final b bVarDO = b.DO();
        final String strY = y(str, strArr[i]);
        r.Ne();
        com.kwad.framework.filedownloader.a aVarCo = r.co(strArr[i]);
        StringBuilder sb = new StringBuilder();
        if (z) {
            strDP = bVarDO.DQ();
        } else {
            strDP = bVarDO.DP();
        }
        this.aCr.offer(aVarCo.cm(sb.append(strDP).append(File.separator).append(strY).toString()).ch(false).a(new c() { // from class: com.kwad.components.ct.emotion.b.d.1
            @Override // com.kwad.framework.filedownloader.i
            public final void b(com.kwad.framework.filedownloader.a aVar2) {
                d.this.aCs.remove(aVar2);
                a aVar3 = aVar;
                if (aVar3 != null) {
                    aVar3.onSuccess(aVar2.getTargetFilePath());
                }
                bVarDO.f(str, strY, z);
                d.this.DR();
            }

            @Override // com.kwad.components.ct.emotion.b.c, com.kwad.framework.filedownloader.i
            public final void a(com.kwad.framework.filedownloader.a aVar2, Throwable th) {
                d.this.aCs.remove(aVar2);
                d.this.a(i + 1, strArr, str, z, aVar);
                d.this.DR();
            }
        }));
    }

    public static Bitmap e(String str, boolean z) {
        if (b.DO().d(str, z)) {
            return BitmapFactory.decodeFile(b.DO().c(str, z));
        }
        return null;
    }

    private static String y(String str, String str2) {
        String strSubstring;
        if (str2 != null) {
            String strSubstring2 = str2.substring(str2.lastIndexOf("/") + 1);
            strSubstring = strSubstring2.substring(strSubstring2.lastIndexOf("."));
        } else {
            strSubstring = PictureMimeType.PNG;
        }
        return str + strSubstring;
    }
}
