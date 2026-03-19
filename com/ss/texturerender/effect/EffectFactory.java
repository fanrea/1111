package com.ss.texturerender.effect;

import com.ss.texturerender.TextureRenderHelper;
import com.ss.texturerender.TextureRenderLog;
import com.ss.texturerender.effect.ICEffect.ICEffectWrapper;
import com.ss.texturerender.effect.vr.GLPanorama180To360Filter;
import com.ss.texturerender.effect.vr.GLPanoramaFilter;
import com.ss.texturerender.fov.GLTileCompositeFilter;
import java.lang.reflect.Constructor;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class EffectFactory {
    public static final String PICO_VIDEO_VR_SR_EFFECT = "com.ss.texturerenderpicovr.PicoVRVideoOCLSREffect";
    public static final String PICO_VIDEO_VR_VR_EFFECT = "com.ss.texturerenderpicovr.PicoVRVideoVREffect";

    public static AbsEffect createEffect(int i, int i2) throws NoSuchMethodException, SecurityException {
        AbsEffect absEffect = null;
        switch (i2) {
            case 1:
                return new AdaptiveSharpenEffect(i);
            case 2:
                return new GLLutFilter(i);
            case 3:
                return new GLOesTo2DFilter(i);
            case 4:
                return new GLHDR2SDRFilter(i);
            case 5:
                if ((i & 8) > 0) {
                    try {
                        Class<?> clzUsingPluginLoader = TextureRenderHelper.getClzUsingPluginLoader(0, PICO_VIDEO_VR_SR_EFFECT);
                        if (clzUsingPluginLoader != null) {
                            Constructor<?> constructor = clzUsingPluginLoader.getConstructor(Integer.TYPE);
                            if (constructor != null) {
                                absEffect = (AbsEffect) constructor.newInstance(Integer.valueOf(i));
                            } else {
                                TextureRenderLog.e(i, "PicoTextureSREffect", "PicoTextureSREffect fail constructor is null");
                            }
                        } else {
                            TextureRenderLog.e(i, "PicoTextureSREffect", "PicoTextureSREffect fail srClz is null");
                        }
                    } catch (Exception e) {
                        TextureRenderLog.e(i, "PicoTextureSREffect", "PicoTextureSREffect fail:" + e.toString());
                    }
                    return absEffect;
                }
                return new VideoOCLSREffect(i);
            case 6:
            case 11:
            case 13:
            case 19:
            case 20:
            default:
                return null;
            case 7:
                return new GLDefaultFilter(i);
            case 8:
                if ((i & 8) > 0) {
                    try {
                        Class<?> clzUsingPluginLoader2 = TextureRenderHelper.getClzUsingPluginLoader(0, PICO_VIDEO_VR_VR_EFFECT);
                        if (clzUsingPluginLoader2 != null) {
                            Constructor<?> constructor2 = clzUsingPluginLoader2.getConstructor(Integer.TYPE);
                            if (constructor2 != null) {
                                absEffect = (AbsEffect) constructor2.newInstance(Integer.valueOf(i));
                            } else {
                                TextureRenderLog.e(i, "PicoTextureVREffect", "PicoTextureVREffect fail constructor is null");
                            }
                        } else {
                            TextureRenderLog.e(i, "PicoTextureVREffect", "PicoTextureVREffect fail srClz is null");
                        }
                    } catch (Exception e2) {
                        TextureRenderLog.e(i, "PicoTextureVREffect", "PicoTextureVREffect fail:" + e2.toString());
                    }
                    return absEffect;
                }
                return new GLPanoramaFilter(i);
            case 9:
                return new GLMattingFilter(i);
            case 10:
                return new GLGaussianBlurFilter(i);
            case 12:
                return new GLPanorama180To360Filter(i);
            case 14:
                return new AdaptiveGradingEffect(i);
            case 15:
                return new GLSelectiveGaussianBlurFilter3(i);
            case 16:
                return new BMFVQScoreWrapper(i);
            case 17:
                return new GLWatermarkFilter(i);
            case 18:
                return new GLTileCompositeFilter(i);
            case 21:
                return new ICEffectWrapper(i);
            case 22:
                return new GLAutoStereoScopyFilter(i);
        }
    }
}
