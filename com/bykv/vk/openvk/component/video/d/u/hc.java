package com.bykv.vk.openvk.component.video.d.u;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import com.alipay.sdk.m.l.a;
import java.util.HashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class hc {

    /* renamed from: com.bykv.vk.openvk.component.video.d.u.hc$hc, reason: collision with other inner class name */
    public interface InterfaceC0165hc {
        void d(Bitmap bitmap);
    }

    public static void d(long j, String str, InterfaceC0165hc interfaceC0165hc) {
        new d(interfaceC0165hc, j).d((Object[]) new String[]{str});
    }

    public static class d extends com.bytedance.sdk.component.tc.c.hc<String, Integer, Bitmap> {
        private long b;
        private InterfaceC0165hc hc;

        public d(InterfaceC0165hc interfaceC0165hc, long j) {
            this.hc = interfaceC0165hc;
            this.b = j;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public Bitmap doInBackground(String... strArr) {
            Bitmap frameAtTime = null;
            try {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                String str = strArr[0];
                if (str.startsWith(a.r)) {
                    mediaMetadataRetriever.setDataSource(str, new HashMap());
                } else {
                    mediaMetadataRetriever.setDataSource(str);
                }
                frameAtTime = mediaMetadataRetriever.getFrameAtTime(this.b * 1000, 3);
                mediaMetadataRetriever.release();
                return frameAtTime;
            } catch (Throwable th) {
                com.bykv.vk.openvk.component.video.api.an.b.b("MediaUtils", "MediaUtils doInBackground : ", th);
                return frameAtTime;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            InterfaceC0165hc interfaceC0165hc = this.hc;
            if (interfaceC0165hc != null) {
                interfaceC0165hc.d(bitmap);
            }
        }
    }
}
