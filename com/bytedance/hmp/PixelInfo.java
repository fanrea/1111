package com.bytedance.hmp;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class PixelInfo extends Ptr {
    public static PixelInfo wrap(long ptr, boolean own) {
        return new PixelInfo(ptr, own);
    }

    private PixelInfo(long ptr_, boolean own_) {
        this.ptr = ptr_;
        this.own = own_;
    }

    public PixelInfo(PixelFormat format, ColorModel cm) {
        this.ptr = Api.pixel_info_make(format.getValue(), cm.getPtr());
        this.own = true;
    }

    public PixelInfo(PixelFormat format) {
        this.ptr = Api.pixel_info_make(format.getValue(), ColorSpace.CS_UNSPECIFIED.getValue(), ColorRange.CR_UNSPECIFIED.getValue());
        this.own = true;
    }

    public PixelInfo(PixelFormat format, ColorSpace cs, ColorRange cr) {
        this.ptr = Api.pixel_info_make(format.getValue(), cs.getValue(), cr.getValue());
        this.own = true;
    }

    public void free() {
        if (this.own) {
            Api.pixel_info_free(this.ptr);
        }
    }

    public PixelFormat format() {
        return (PixelFormat) EnumUtil.fromValue(PixelFormat.class, Integer.valueOf(Api.pixel_info_format(this.ptr)));
    }

    public ColorSpace space() {
        return (ColorSpace) EnumUtil.fromValue(ColorSpace.class, Integer.valueOf(Api.pixel_info_space(this.ptr)));
    }

    public ColorRange range() {
        return (ColorRange) EnumUtil.fromValue(ColorRange.class, Integer.valueOf(Api.pixel_info_range(this.ptr)));
    }

    public ColorPrimaries primaries() {
        return (ColorPrimaries) EnumUtil.fromValue(ColorPrimaries.class, Integer.valueOf(Api.pixel_info_primaries(this.ptr)));
    }

    public ColorTransferCharacteristic colorTransferCharacteristic() {
        return (ColorTransferCharacteristic) EnumUtil.fromValue(ColorTransferCharacteristic.class, Integer.valueOf(Api.pixel_info_primaries(this.ptr)));
    }

    public ColorSpace inferSpace() {
        return (ColorSpace) EnumUtil.fromValue(ColorSpace.class, Integer.valueOf(Api.pixel_info_infer_space(this.ptr)));
    }

    public ColorModel colorModel() {
        return ColorModel.wrap(Api.pixel_info_color_model(this.ptr), false);
    }

    public boolean isRgbx() {
        return Api.pixel_info_is_rgbx(this.ptr);
    }

    public String toString() {
        return Api.pixel_info_stringfy(this.ptr);
    }
}
