package com.bytedance.hmp;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class Scalar extends Ptr {
    public static Scalar wrap(long ptr, boolean own) {
        return new Scalar(ptr, own);
    }

    Scalar(long ptr_, boolean own_) {
        this.ptr = ptr_;
        this.own = own_;
    }

    public Scalar(double v) {
        this.ptr = Api.scalar(v);
        this.own = true;
    }

    public Scalar(long v) {
        this.ptr = Api.scalar(v);
        this.own = true;
    }

    public Scalar(boolean v) {
        this.ptr = Api.scalar(v);
        this.own = true;
    }

    public void free() {
        if (this.own) {
            Api.scalar_free(this.ptr);
        }
    }
}
