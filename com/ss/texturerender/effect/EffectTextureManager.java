package com.ss.texturerender.effect;

import android.opengl.GLES20;
import android.opengl.GLES30;
import android.os.Build;
import com.ss.texturerender.DeviceManager;
import com.ss.texturerender.TexGLUtils;
import com.ss.texturerender.TextureRenderLog;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class EffectTextureManager {
    private static final String LOG_TAG = "TR_EffectTextureManager";
    private int mTexType;
    private boolean useGLForsr;
    private LinkedList<EffectTexture> mTextureList = new LinkedList<>();
    private int mMaxSize = 4;

    public EffectTextureManager(int i) {
        this.useGLForsr = false;
        this.mTexType = -1;
        if (DeviceManager.isVRDevice()) {
            this.useGLForsr = true;
        }
        this.mTexType = i;
    }

    public EffectTexture genTexture(int i, int i2) {
        return genTexture(i, i2, 6408, 6408, 5121);
    }

    public EffectTexture genTexture(int i, int i2, int i3) {
        if (i3 >= 10 && Build.VERSION.SDK_INT >= 18) {
            return genTexture(i, i2, 32857, 6408, 33640);
        }
        return genTexture(i, i2);
    }

    public EffectTexture genTexture(int i, int i2, int i3, int i4, int i5) {
        int iGenTexture;
        Iterator<EffectTexture> it = this.mTextureList.iterator();
        EffectTexture effectTexturePoll = null;
        while (it.hasNext()) {
            effectTexturePoll = it.next();
            if (i == effectTexturePoll.getWidth() && i2 == effectTexturePoll.getHeight()) {
                if (i3 == effectTexturePoll.getInternalFormat()) {
                    if (i4 == effectTexturePoll.getFormat()) {
                        if (i5 == effectTexturePoll.getType()) {
                            it.remove();
                            return effectTexturePoll;
                        }
                    }
                }
            }
        }
        if (!this.useGLForsr) {
            effectTexturePoll = this.mTextureList.poll();
        }
        if (effectTexturePoll == null || this.useGLForsr) {
            iGenTexture = TexGLUtils.genTexture(3553);
        } else {
            iGenTexture = effectTexturePoll.getTexID();
        }
        int i6 = iGenTexture;
        GLES20.glBindTexture(3553, i6);
        if (this.useGLForsr && Build.VERSION.SDK_INT >= 18) {
            GLES30.glTexStorage2D(3553, 1, 32856, i, i2);
        } else {
            GLES20.glTexImage2D(3553, 0, i3, i, i2, 0, i4, i5, null);
        }
        EffectTexture effectTexture = new EffectTexture(this, i6, i, i2, 3553, i3, i4, i5);
        TextureRenderLog.i(this.mTexType, LOG_TAG, "genTexture:" + effectTexture.toString());
        return effectTexture;
    }

    public void onTextureReturn(EffectTexture effectTexture) {
        Iterator<EffectTexture> it = this.mTextureList.iterator();
        while (it.hasNext()) {
            if (effectTexture.isEqualTo(it.next())) {
                return;
            }
        }
        this.mTextureList.offer(effectTexture);
        while (this.mTextureList.size() > this.mMaxSize) {
            EffectTexture effectTexturePoll = this.mTextureList.poll();
            TexGLUtils.deleteTexture(effectTexturePoll.getTexID());
            TextureRenderLog.i(this.mTexType, LOG_TAG, "onTextureReturn delTex:" + effectTexturePoll);
        }
    }

    public void release() {
        while (!this.mTextureList.isEmpty()) {
            EffectTexture effectTexturePoll = this.mTextureList.poll();
            TexGLUtils.deleteTexture(effectTexturePoll.getTexID());
            TextureRenderLog.i(this.mTexType, LOG_TAG, "release delTex:" + effectTexturePoll);
        }
    }
}
