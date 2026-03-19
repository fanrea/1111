package com.ss.texturerender;

import android.content.Context;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.os.Bundle;
import android.view.Surface;
import com.ss.texturerender.effect.EffectConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class TextureRenderManager {
    private static final String TAG = "TextureRenderManager";
    public static final int TEX_EXT = 2;
    public static final int TEX_LIVE = 1;
    public static final int TEX_OVERLAY = 4;
    public static final int TEX_PICOVR = 8;
    public static final int TEX_VOD = 0;
    private static TextureRenderManager mManager;
    private Context mContext;
    private List<TextureRenderer> mRenderers = new ArrayList();
    private ReentrantLock mListLock = new ReentrantLock();
    private String mTextureError = null;

    private TextureRenderManager() {
    }

    public String getTextureError() {
        return this.mTextureError;
    }

    public static synchronized TextureRenderManager getManager() {
        if (mManager == null) {
            mManager = new TextureRenderManager();
        }
        return mManager;
    }

    public synchronized void release() {
        releaseRenderers();
        mManager = null;
    }

    private void releaseRenderers() {
        if (this.mRenderers.size() == 0) {
            return;
        }
        this.mListLock.lock();
        Iterator<TextureRenderer> it = this.mRenderers.iterator();
        while (it.hasNext()) {
            TextureRenderer next = it.next();
            int iTexType = next.texType();
            TextureRenderLog.i(iTexType, TAG, "render = " + next + ", call release");
            next.release();
            it.remove();
            TextureRenderLog.i(iTexType, TAG, "release : remove render =" + next + "size = " + this.mRenderers.size());
        }
        this.mListLock.unlock();
    }

    public void releaseAllEffectNodes() {
        if (this.mRenderers.size() == 0) {
            return;
        }
        this.mListLock.lock();
        TextureRenderer next = null;
        Iterator<TextureRenderer> it = this.mRenderers.iterator();
        Bundle bundle = new Bundle();
        bundle.putInt("action", 32);
        bundle.putInt(TextureRenderKeys.KEY_IS_EFFECT_TYPE, 24);
        while (it.hasNext()) {
            next = it.next();
            TextureRenderLog.i(next.texType(), TAG, "render = " + next + ", call release nodes");
            next.sendMessage(36, bundle);
        }
        TextureRenderLog.i(-1, TAG, "releaseAllEffectNodes end," + next + "size = " + this.mRenderers.size());
        this.mListLock.unlock();
    }

    private VideoSurface genRenderSurface(EffectConfig effectConfig, int i) {
        return genRenderSurface(effectConfig, i, null, null, false);
    }

    private VideoSurface genRenderSurface(EffectConfig effectConfig, int i, EGLContext eGLContext, EGLConfig eGLConfig) {
        return genRenderSurface(effectConfig, i, null, null, false);
    }

    private VideoSurface genRenderSurface(EffectConfig effectConfig, int i, EGLContext eGLContext, EGLConfig eGLConfig, boolean z) throws NoSuchMethodException, SecurityException {
        TextureRenderer textureRendererCreateRender = RenderFactory.createRender(effectConfig, i, eGLContext, eGLConfig, z);
        TextureRenderLog.i(textureRendererCreateRender.texType(), TAG, "new TextureRenderer use:" + textureRendererCreateRender);
        if (textureRendererCreateRender.getState() != -1) {
            VideoSurface videoSurfaceGenOffscreenSurface = textureRendererCreateRender.genOffscreenSurface();
            if (videoSurfaceGenOffscreenSurface == null) {
                this.mTextureError = textureRendererCreateRender.getErrorReason();
                textureRendererCreateRender.release();
                return null;
            }
            this.mListLock.lock();
            this.mRenderers.add(textureRendererCreateRender);
            TextureRenderLog.i(textureRendererCreateRender.texType(), TAG, "add render = " + textureRendererCreateRender + ", effectconfig= " + effectConfig + ", texType =" + i + ",size = " + this.mRenderers.size());
            this.mListLock.unlock();
            return videoSurfaceGenOffscreenSurface;
        }
        this.mTextureError = textureRendererCreateRender.getErrorReason();
        textureRendererCreateRender.release();
        return null;
    }

    public synchronized VideoSurface genAvaiableSurface(EffectConfig effectConfig, int i) {
        return genAvaiableSurface(effectConfig, i, (EGLContext) null, (EGLConfig) null);
    }

    public synchronized VideoSurface genAvaiableSurface(EffectConfig effectConfig, int i, EGLContext eGLContext, EGLConfig eGLConfig) {
        return genAvaiableSurface(effectConfig, i, null, null, false);
    }

    public synchronized VideoSurface genAvaiableSurface(EffectConfig effectConfig, int i, EGLContext eGLContext, EGLConfig eGLConfig, boolean z) {
        if (this.mRenderers.size() == 0) {
            return genRenderSurface(effectConfig, i, eGLContext, eGLConfig, z);
        }
        this.mListLock.lock();
        Iterator<TextureRenderer> it = this.mRenderers.iterator();
        VideoSurface videoSurfaceGenOffscreenSurface = null;
        while (it.hasNext()) {
            TextureRenderer next = it.next();
            EffectConfig effectConfig2 = next.getEffectConfig();
            TextureRenderLog.i(next.texType(), TAG, "tmpConfig: " + effectConfig2 + ", config: " + effectConfig);
            if (!effectConfig2.isSubSet(effectConfig)) {
                TextureRenderLog.i(next.texType(), TAG, "render type is mis match = " + effectConfig2 + ", " + effectConfig);
            } else if (next.texType() != i) {
                TextureRenderLog.i(next.texType(), TAG, "tex type is mis match = " + next.texType() + ", " + i);
            } else if ((i & 4) == (next.texType() & 4)) {
                TextureRenderLog.i(next.texType(), TAG, "TextureRenderer use:" + next);
                videoSurfaceGenOffscreenSurface = next.genOffscreenSurface();
                if (videoSurfaceGenOffscreenSurface == null && next.getState() < 1) {
                    TextureRenderLog.i(next.texType(), TAG, "remove render =" + next + " state = " + next.getState());
                    next.release();
                    it.remove();
                } else if (videoSurfaceGenOffscreenSurface != null) {
                    this.mListLock.unlock();
                    return videoSurfaceGenOffscreenSurface;
                }
            }
        }
        this.mListLock.unlock();
        if (videoSurfaceGenOffscreenSurface != null) {
            return null;
        }
        return genRenderSurface(effectConfig, i, eGLContext, eGLConfig, z);
    }

    public synchronized VideoSurface genAvaiableSurface(boolean z, int i) {
        EffectConfig effectConfig;
        effectConfig = new EffectConfig(i);
        effectConfig.setOpenSR(z);
        return genAvaiableSurface(effectConfig, i);
    }

    public synchronized VideoSurface genAvaiableSurface(boolean z, int i, EGLContext eGLContext, EGLConfig eGLConfig) {
        EffectConfig effectConfig;
        effectConfig = new EffectConfig(i);
        effectConfig.setOpenSR(z);
        return genAvaiableSurface(effectConfig, i, eGLContext, eGLConfig);
    }

    public synchronized boolean isSRRenderAvaiable(int i) {
        boolean z = false;
        if (this.mRenderers.size() == 0) {
            return false;
        }
        this.mListLock.lock();
        Iterator<TextureRenderer> it = this.mRenderers.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            TextureRenderer next = it.next();
            if (next.getEffectConfig().isOpenSR() && next.texType() == i && (next.texType() & 4) == 0) {
                z = true;
                break;
            }
        }
        this.mListLock.unlock();
        return z;
    }

    public synchronized boolean isEffectAvailable(EffectConfig effectConfig, int i) {
        boolean z = false;
        if (this.mRenderers.size() == 0) {
            return false;
        }
        this.mListLock.lock();
        Iterator<TextureRenderer> it = this.mRenderers.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            TextureRenderer next = it.next();
            if (next.getEffectConfig().isSubSet(effectConfig) && next.texType() == i && (next.texType() & 4) == 0) {
                z = true;
                break;
            }
        }
        this.mListLock.unlock();
        return z;
    }

    public synchronized void asyncInitSR(int i, int i2, String str, String str2, String str3) {
        if (isSRRenderAvaiable(i)) {
            return;
        }
        VideoSurface videoSurfaceGenAvaiableSurface = genAvaiableSurface(true, i);
        if (videoSurfaceGenAvaiableSurface != null) {
            videoSurfaceGenAvaiableSurface.setSuperResolutionInitConfig(i2, str, str2, str3);
            videoSurfaceGenAvaiableSurface.release();
        }
    }

    public synchronized void asyncInitSR(int i, int i2, String str, String str2, String str3, int i3, int i4) {
        asyncInitSR(i, i2, str, str2, str3, i3, i4, null);
    }

    public synchronized void asyncInitSR(int i, int i2, String str, String str2, String str3, int i3, int i4, String str4) {
        if (isSRRenderAvaiable(i)) {
            return;
        }
        VideoSurface videoSurfaceGenAvaiableSurface = genAvaiableSurface(true, i);
        if (videoSurfaceGenAvaiableSurface != null) {
            videoSurfaceGenAvaiableSurface.setSuperResolutionInitConfig(i2, str, str2, str3, i3, i4, str4);
            videoSurfaceGenAvaiableSurface.release();
        }
    }

    private TextureRenderer getRenderer(EffectConfig effectConfig, int i, EGLContext eGLContext, EGLConfig eGLConfig) throws NoSuchMethodException, SecurityException {
        TextureRenderer textureRenderer;
        TextureRenderer next;
        this.mListLock.lock();
        Iterator<TextureRenderer> it = this.mRenderers.iterator();
        while (true) {
            textureRenderer = null;
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (next.texType() == i) {
                if (next.getState() >= 1) {
                    break;
                }
                TextureRenderLog.i(next.texType(), TAG, "remove render =" + next + " state = " + next.getState());
                next.release();
                it.remove();
            }
        }
        if (next == null) {
            TextureRenderer textureRendererCreateRender = RenderFactory.createRender(effectConfig, i, eGLContext, eGLConfig, false);
            if (textureRendererCreateRender.getState() != -1) {
                this.mRenderers.add(textureRendererCreateRender);
                TextureRenderLog.i(textureRendererCreateRender.texType(), TAG, "add render = " + textureRendererCreateRender + ", effectconfig= " + effectConfig + ", texType =" + i + ",size = " + this.mRenderers.size());
                textureRenderer = textureRendererCreateRender;
            } else {
                this.mTextureError = textureRendererCreateRender.getErrorReason();
                textureRendererCreateRender.release();
            }
        } else {
            textureRenderer = next;
        }
        this.mListLock.unlock();
        return textureRenderer;
    }

    public boolean clearSurface(Surface surface, boolean z) {
        return clearSurface(surface, z, null, null);
    }

    public boolean clearSurface(Surface surface, boolean z, EGLContext eGLContext, EGLConfig eGLConfig) throws NoSuchMethodException, SecurityException {
        if (surface == null) {
            TextureRenderLog.e(-1, TAG, "invalid parameter");
            return false;
        }
        TextureRenderer renderer = getRenderer(new EffectConfig(2), 2, eGLContext, eGLConfig);
        if (renderer == null) {
            TextureRenderLog.e(-1, TAG, "couldn't get a renderer return");
            return false;
        }
        return renderer.clearSurface(surface, z);
    }

    public void setContext(Context context) {
        if (context != null) {
            this.mContext = context.getApplicationContext();
        }
    }

    public Context getContext() {
        return this.mContext;
    }
}
