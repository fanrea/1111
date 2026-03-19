package com.bytedance.hmp;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class PixelFormatDesc extends Ptr {
    public static PixelFormatDesc wrap(long ptr, boolean own) {
        return new PixelFormatDesc(ptr, own);
    }

    private PixelFormatDesc(long ptr_, boolean own_) {
        this.ptr = ptr_;
        this.own = own_;
    }

    public PixelFormatDesc(PixelFormat format) {
        this.ptr = Api.pixel_format_desc_make(format.getValue());
        this.own = true;
    }

    public void free() {
        if (this.own) {
            Api.pixel_format_desc_free(this.ptr);
        }
    }

    public int nplanes() {
        return Api.pixel_format_desc_nplanes(this.ptr);
    }

    public ScalarType dtype() {
        return (ScalarType) EnumUtil.fromValue(ScalarType.class, Integer.valueOf(Api.pixel_format_desc_dtype(this.ptr)));
    }

    public int format() {
        return Api.pixel_format_desc_format(this.ptr);
    }

    public int channels(int plane) {
        return Api.pixel_format_desc_channels(this.ptr, plane);
    }

    public int infer_width(int width, int plane) {
        return Api.pixel_format_desc_infer_width(this.ptr, width, plane);
    }

    public int infer_height(int height, int plane) {
        return Api.pixel_format_desc_infer_height(this.ptr, height, plane);
    }

    public int infer_nitems(int width, int height) {
        return Api.pixel_format_desc_infer_nitems(this.ptr, width, height);
    }

    public int infer_nitems(int width, int height, int plane) {
        return Api.pixel_format_desc_infer_nitems(this.ptr, width, height, plane);
    }
}
