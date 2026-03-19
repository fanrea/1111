package com.ss.texturerender;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class TextureRenderConfig {
    private static final String TAG = "TR_TextureRenderConfig";
    private static ITextureRenderPluginLoader gPluginLoader;

    public static String getValue(int i) {
        return i != 24 ? "" : BuildConfig.VERSION_NAME;
    }

    public static void setClassLoaderCallback(ITextureRenderPluginLoader iTextureRenderPluginLoader) {
        TextureRenderLog.i(-1, TAG, "setClassLoaderCallback");
        gPluginLoader = iTextureRenderPluginLoader;
    }

    public static ClassLoader getClassLoader(int i) {
        ITextureRenderPluginLoader iTextureRenderPluginLoader = gPluginLoader;
        if (iTextureRenderPluginLoader != null) {
            return iTextureRenderPluginLoader.loadPlugin(i);
        }
        return null;
    }
}
