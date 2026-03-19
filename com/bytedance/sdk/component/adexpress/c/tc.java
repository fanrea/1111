package com.bytedance.sdk.component.adexpress.c;

import android.net.Uri;
import android.text.TextUtils;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.config.SelectMimeType;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class tc {
    public static d d(String str) {
        d dVar = d.IMAGE;
        if (!TextUtils.isEmpty(str)) {
            try {
                String path = Uri.parse(str).getPath();
                if (path != null) {
                    if (path.endsWith(".css")) {
                        dVar = d.CSS;
                    } else if (path.endsWith(".js")) {
                        dVar = d.JS;
                    } else if (path.endsWith(PictureMimeType.JPG) || path.endsWith(PictureMimeType.GIF) || path.endsWith(PictureMimeType.PNG) || path.endsWith(".jpeg") || path.endsWith(PictureMimeType.WEBP) || path.endsWith(PictureMimeType.BMP) || path.endsWith(".ico")) {
                        dVar = d.IMAGE;
                    } else if (path.endsWith(".html")) {
                        dVar = d.HTML;
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return dVar;
    }

    public static boolean hc(String str) {
        Uri uri;
        if (TextUtils.isEmpty(str) || (uri = Uri.parse(str)) == null) {
            return false;
        }
        String path = uri.getPath();
        if (TextUtils.isEmpty(path)) {
            return false;
        }
        return path.endsWith(PictureMimeType.GIF);
    }

    public enum d {
        HTML("text/html"),
        CSS("text/css"),
        JS("application/x-javascript"),
        IMAGE(SelectMimeType.SYSTEM_IMAGE);

        private String u;

        d(String str) {
            this.u = str;
        }

        public String getType() {
            return this.u;
        }
    }
}
