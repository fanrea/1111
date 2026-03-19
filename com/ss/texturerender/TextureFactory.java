package com.ss.texturerender;

import android.opengl.GLES20;
import com.sigmob.sdk.archives.tar.d;
import com.ss.texturerender.Texture;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class TextureFactory implements Texture.OnTextureReturnListener {
    private static final String TAG = "TextureFactory";
    private TextureRenderer mTextureRenderer;
    private ArrayList<ITexture> mTextures = new ArrayList<>();

    public TextureFactory(TextureRenderer textureRenderer) {
        this.mTextureRenderer = textureRenderer;
    }

    @Override // com.ss.texturerender.Texture.OnTextureReturnListener
    public void onTextureReturn(ITexture iTexture) {
        synchronized (this.mTextures) {
            if (((Texture) iTexture).getForbidTextureReuse() > 0) {
                TextureRenderer textureRenderer = this.mTextureRenderer;
                if (textureRenderer != null) {
                    TextureRenderLog.i(textureRenderer.texType(), TAG, "release texture = " + iTexture);
                }
                ((Texture) iTexture).release();
            } else {
                TextureRenderer textureRenderer2 = this.mTextureRenderer;
                if (textureRenderer2 != null) {
                    TextureRenderLog.i(textureRenderer2.texType(), TAG, "add texture = " + iTexture + "size = " + this.mTextures.size());
                }
                this.mTextures.add(iTexture);
            }
        }
    }

    private static int loadTexture(int i) {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        int i2 = iArr[0];
        if (i2 == 0) {
            throw new RuntimeException("Error gen texture.");
        }
        if (i2 != 0) {
            GLES20.glBindTexture(i, i2);
            GLES20.glTexParameteri(i, 10242, 33071);
            GLES20.glTexParameteri(i, 10243, 33071);
            if (i == 36197 && DeviceManager.isVRDevice()) {
                GLES20.glTexParameteri(i, 10241, 9728);
                GLES20.glTexParameteri(i, d.b, 9728);
            } else {
                GLES20.glTexParameteri(i, 10241, 9729);
                GLES20.glTexParameteri(i, d.b, 9729);
            }
        }
        return iArr[0];
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0050 A[Catch: all -> 0x0080, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x000b, B:7:0x0011, B:9:0x0017, B:11:0x0023, B:14:0x0050, B:15:0x007b), top: B:21:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.ss.texturerender.ITexture createTexture(int r6, int r7) {
        /*
            r5 = this;
            java.util.ArrayList<com.ss.texturerender.ITexture> r0 = r5.mTextures
            monitor-enter(r0)
            java.util.ArrayList<com.ss.texturerender.ITexture> r1 = r5.mTextures     // Catch: java.lang.Throwable -> L80
            int r1 = r1.size()     // Catch: java.lang.Throwable -> L80
            if (r1 <= 0) goto L4d
            java.util.ArrayList<com.ss.texturerender.ITexture> r1 = r5.mTextures     // Catch: java.lang.Throwable -> L80
            java.util.Iterator r1 = r1.iterator()     // Catch: java.lang.Throwable -> L80
        L11:
            boolean r2 = r1.hasNext()     // Catch: java.lang.Throwable -> L80
            if (r2 == 0) goto L4d
            java.lang.Object r2 = r1.next()     // Catch: java.lang.Throwable -> L80
            com.ss.texturerender.ITexture r2 = (com.ss.texturerender.ITexture) r2     // Catch: java.lang.Throwable -> L80
            int r3 = r2.getTexTarget()     // Catch: java.lang.Throwable -> L80
            if (r3 != r6) goto L11
            r1.remove()     // Catch: java.lang.Throwable -> L80
            java.lang.String r1 = "TextureFactory"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L80
            r3.<init>()     // Catch: java.lang.Throwable -> L80
            java.lang.String r4 = "reuse texture:"
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch: java.lang.Throwable -> L80
            java.lang.StringBuilder r3 = r3.append(r2)     // Catch: java.lang.Throwable -> L80
            java.lang.String r4 = " texTarget:"
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch: java.lang.Throwable -> L80
            int r4 = r2.getTexTarget()     // Catch: java.lang.Throwable -> L80
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch: java.lang.Throwable -> L80
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L80
            android.util.Log.d(r1, r3)     // Catch: java.lang.Throwable -> L80
            goto L4e
        L4d:
            r2 = 0
        L4e:
            if (r2 != 0) goto L7b
            int r1 = loadTexture(r6)     // Catch: java.lang.Throwable -> L80
            com.ss.texturerender.Texture r2 = new com.ss.texturerender.Texture     // Catch: java.lang.Throwable -> L80
            r2.<init>(r1, r6, r5, r7)     // Catch: java.lang.Throwable -> L80
            java.lang.String r6 = "TextureFactory"
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L80
            r7.<init>()     // Catch: java.lang.Throwable -> L80
            java.lang.String r3 = "new Texture = "
            java.lang.StringBuilder r7 = r7.append(r3)     // Catch: java.lang.Throwable -> L80
            java.lang.StringBuilder r7 = r7.append(r2)     // Catch: java.lang.Throwable -> L80
            java.lang.String r3 = "id = "
            java.lang.StringBuilder r7 = r7.append(r3)     // Catch: java.lang.Throwable -> L80
            java.lang.StringBuilder r7 = r7.append(r1)     // Catch: java.lang.Throwable -> L80
            java.lang.String r7 = r7.toString()     // Catch: java.lang.Throwable -> L80
            android.util.Log.i(r6, r7)     // Catch: java.lang.Throwable -> L80
        L7b:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L80
            r2.addRef()
            return r2
        L80:
            r6 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L80
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.texturerender.TextureFactory.createTexture(int, int):com.ss.texturerender.ITexture");
    }

    public void release() {
        synchronized (this.mTextures) {
            Iterator<ITexture> it = this.mTextures.iterator();
            while (it.hasNext()) {
                ((Texture) it.next()).release();
                it.remove();
            }
        }
    }
}
