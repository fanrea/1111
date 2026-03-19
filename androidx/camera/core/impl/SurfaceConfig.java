package androidx.camera.core.impl;

import android.util.Size;
import androidx.camera.core.internal.utils.SizeUtil;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public abstract class SurfaceConfig {

    public enum ConfigType {
        PRIV,
        YUV,
        JPEG,
        RAW
    }

    public abstract ConfigSize getConfigSize();

    public abstract ConfigType getConfigType();

    SurfaceConfig() {
    }

    public static SurfaceConfig create(ConfigType configType, ConfigSize configSize) {
        return new AutoValue_SurfaceConfig(configType, configSize);
    }

    public final boolean isSupported(SurfaceConfig surfaceConfig) {
        return surfaceConfig.getConfigSize().getId() <= getConfigSize().getId() && surfaceConfig.getConfigType() == getConfigType();
    }

    public static ConfigType getConfigType(int i) {
        if (i == 35) {
            return ConfigType.YUV;
        }
        if (i == 256) {
            return ConfigType.JPEG;
        }
        if (i == 32) {
            return ConfigType.RAW;
        }
        return ConfigType.PRIV;
    }

    public static SurfaceConfig transformSurfaceConfig(int i, Size size, SurfaceSizeDefinition surfaceSizeDefinition) {
        ConfigSize configSize;
        ConfigType configType = getConfigType(i);
        ConfigSize configSize2 = ConfigSize.NOT_SUPPORT;
        int area = SizeUtil.getArea(size);
        if (area <= SizeUtil.getArea(surfaceSizeDefinition.getAnalysisSize())) {
            configSize = ConfigSize.VGA;
        } else if (area <= SizeUtil.getArea(surfaceSizeDefinition.getPreviewSize())) {
            configSize = ConfigSize.PREVIEW;
        } else if (area <= SizeUtil.getArea(surfaceSizeDefinition.getRecordSize())) {
            configSize = ConfigSize.RECORD;
        } else {
            configSize = ConfigSize.MAXIMUM;
        }
        return create(configType, configSize);
    }

    public enum ConfigSize {
        VGA(0),
        PREVIEW(1),
        RECORD(2),
        MAXIMUM(3),
        NOT_SUPPORT(4);

        final int mId;

        ConfigSize(int i) {
            this.mId = i;
        }

        int getId() {
            return this.mId;
        }
    }
}
