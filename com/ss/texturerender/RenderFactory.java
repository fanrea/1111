package com.ss.texturerender;

import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import com.ss.texturerender.effect.EffectConfig;
import com.ss.texturerender.overlay.OverlayVideoTextureRenderer;
import java.lang.reflect.Constructor;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
class RenderFactory {
    public static final String PICO_VIDEO_VR = "com.ss.texturerenderpicovr.PicoVRVideoTextureRender";

    RenderFactory() {
    }

    public static TextureRenderer createRender(EffectConfig effectConfig, int i, EGLContext eGLContext, EGLConfig eGLConfig, boolean z) throws NoSuchMethodException, SecurityException {
        if ((i & 4) > 0) {
            return new OverlayVideoTextureRenderer(effectConfig, i, eGLContext, eGLConfig);
        }
        if ((i & 8) > 0) {
            TextureRenderer textureRenderer = null;
            try {
                Class<?> clzUsingPluginLoader = TextureRenderHelper.getClzUsingPluginLoader(0, PICO_VIDEO_VR);
                if (clzUsingPluginLoader != null) {
                    Constructor<?> constructor = clzUsingPluginLoader.getConstructor(EffectConfig.class, Integer.TYPE);
                    if (constructor != null) {
                        textureRenderer = (TextureRenderer) constructor.newInstance(effectConfig, Integer.valueOf(i));
                    } else {
                        TextureRenderLog.e(i, "PicoTextureRender", "PicoTextureCreate fail constructor is null");
                    }
                } else {
                    TextureRenderLog.e(i, "PicoTextureRender", "PicoTextureCreate fail srClz is null");
                }
            } catch (Exception e) {
                TextureRenderLog.e(i, "PicoTextureRender", "PicoTextureCreate fail:" + e.toString());
            }
            return textureRenderer;
        }
        return new VideoTextureRenderer(effectConfig, i, eGLContext, eGLConfig, z);
    }
}
