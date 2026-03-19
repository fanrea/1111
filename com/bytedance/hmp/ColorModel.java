package com.bytedance.hmp;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class ColorModel extends Ptr {
    public static ColorModel wrap(long ptr, boolean own) {
        return new ColorModel(ptr, own);
    }

    private ColorModel(long ptr_, boolean own_) {
        this.ptr = ptr_;
        this.own = own_;
    }

    public ColorModel(ColorSpace cs, ColorRange cr, ColorPrimaries cp, ColorTransferCharacteristic ctc) {
        this.ptr = Api.color_model_make(cs.getValue(), cr.getValue(), cp.getValue(), ctc.getValue());
        this.own = true;
    }

    public void free() {
        if (this.own) {
            Api.color_model_free(this.ptr);
        }
    }

    public ColorSpace space() {
        return (ColorSpace) EnumUtil.fromValue(ColorSpace.class, Integer.valueOf(Api.color_model_space(this.ptr)));
    }

    public ColorRange range() {
        return (ColorRange) EnumUtil.fromValue(ColorRange.class, Integer.valueOf(Api.color_model_range(this.ptr)));
    }

    public ColorPrimaries primaries() {
        return (ColorPrimaries) EnumUtil.fromValue(ColorPrimaries.class, Integer.valueOf(Api.color_model_primaries(this.ptr)));
    }

    public ColorTransferCharacteristic colorTransferCharacteristic() {
        return (ColorTransferCharacteristic) EnumUtil.fromValue(ColorTransferCharacteristic.class, Integer.valueOf(Api.color_model_ctc(this.ptr)));
    }
}
