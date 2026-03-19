package com.component.player;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Build;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import com.baidu.mobads.container.util.bq;
import com.baidu.mobads.container.util.d.d;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class w {
    public static final String a = "exoplayer";
    public static final String b = "media_player";
    private final AtomicBoolean c;
    private final n d;
    private s e;

    /* synthetic */ w(x xVar) {
        this();
    }

    private static class a {
        static final w a = new w(null);

        private a() {
        }
    }

    private w() {
        this.c = new AtomicBoolean(false);
        this.d = com.baidu.mobads.container.r.c.b();
    }

    public static w a() {
        return a.a;
    }

    public void a(Context context, String str, long j) {
        if (!this.c.get() && b()) {
            this.e = this.d.a();
            if (this.e != null) {
                File file = new File(str);
                if (!file.exists()) {
                    file.mkdirs();
                }
                this.e.a(context, file, j, PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE);
                this.c.set(true);
            }
        }
    }

    public String a(Context context, String str) {
        if (b()) {
            return str;
        }
        String strA = com.baidu.mobads.container.util.d.d.a(context).a(str, d.e.VIDEO);
        if (!TextUtils.isEmpty(strA)) {
            return strA;
        }
        return str;
    }

    public Bitmap b(Context context, String str, long j) {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        Bitmap frameAtTime = null;
        try {
            try {
                try {
                    mediaMetadataRetriever.setDataSource(context, Uri.parse(a(context, str)));
                    long j2 = j * 1000;
                    if (j2 > 0) {
                        frameAtTime = mediaMetadataRetriever.getFrameAtTime(j2, 3);
                    }
                    mediaMetadataRetriever.release();
                } catch (RuntimeException e) {
                    bq.a().a(e);
                    mediaMetadataRetriever.release();
                }
            } catch (Throwable th) {
                th.fillInStackTrace();
            }
            return frameAtTime;
        } catch (Throwable th2) {
            try {
                mediaMetadataRetriever.release();
            } catch (Throwable th3) {
                th3.fillInStackTrace();
            }
            throw th2;
        }
    }

    public void a(String str) {
        if (!this.c.get() && !b()) {
            File file = new File(str);
            if (file.exists()) {
                com.baidu.mobads.container.d.b.a().a(new x(this, file));
            }
        }
    }

    public boolean b() {
        if (this.d != null && Build.VERSION.SDK_INT >= 24) {
            return com.baidu.mobads.container.h.a.a().F();
        }
        return false;
    }

    public t a(Context context) {
        t tVarA;
        if (!b()) {
            tVarA = null;
        } else {
            tVarA = this.d.a(context);
        }
        if (tVarA == null) {
            return new f(context);
        }
        return tVarA;
    }

    public s c() {
        return this.e;
    }

    public void d() {
        if (this.c.get()) {
            if (this.e != null) {
                this.e.a();
            }
            this.c.set(false);
        }
    }
}
