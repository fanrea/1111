package com.bytedance.hmp;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class Tensor extends Ptr {
    public static Tensor wrap(long ptr, boolean own) {
        return new Tensor(ptr, own);
    }

    Tensor(long ptr_, boolean own_) {
        this.ptr = ptr_;
        this.own = own_;
    }

    public void free() {
        if (this.own) {
            Api.tensor_free(this.ptr);
        }
    }

    public String toString() {
        return Api.tensor_stringfy(this.ptr);
    }

    public void fill(long value) {
        Scalar scalar = new Scalar(value);
        Api.tensor_fill(this.ptr, scalar.getPtr());
        scalar.free();
    }

    public void fill(double value) {
        Scalar scalar = new Scalar(value);
        Api.tensor_fill(this.ptr, scalar.getPtr());
        scalar.free();
    }

    public void fill(boolean value) {
        Scalar scalar = new Scalar(value);
        Api.tensor_fill(this.ptr, scalar.getPtr());
        scalar.free();
    }

    public boolean defined() {
        return Api.tensor_defined(this.ptr);
    }

    public long dim() {
        return Api.tensor_dim(this.ptr);
    }

    public long size(long dim) {
        return Api.tensor_size(this.ptr, dim);
    }

    public long stride(long dim) {
        return Api.tensor_stride(this.ptr, dim);
    }

    public long nitems() {
        return Api.tensor_nitems(this.ptr);
    }

    public long itemsize() {
        return Api.tensor_itemsize(this.ptr);
    }

    public long nbytes() {
        return Api.tensor_nbytes(this.ptr);
    }

    public ScalarType dtype() {
        return (ScalarType) EnumUtil.fromValue(ScalarType.class, Integer.valueOf(Api.tensor_dtype(this.ptr)));
    }

    public boolean isContiguous() {
        return Api.tensor_is_contiguous(this.ptr);
    }

    public DeviceType deviceType() {
        return (DeviceType) EnumUtil.fromValue(DeviceType.class, Integer.valueOf(Api.tensor_device_type(this.ptr)));
    }

    public int deviceIndex() {
        return Api.tensor_device_index(this.ptr);
    }

    public long dataPtr() {
        return Api.tensor_data_ptr(this.ptr);
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public Tensor m350clone() {
        return wrap(Api.tensor_clone(this.ptr), true);
    }

    public Tensor alias() {
        return wrap(Api.tensor_alias(this.ptr), true);
    }

    public Tensor view(long[] shape) {
        return wrap(Api.tensor_view(this.ptr, shape), true);
    }

    public Tensor reshape(long[] shape) {
        return wrap(Api.tensor_reshape(this.ptr, shape), true);
    }

    public Tensor slice(long dim, long start, long end, long step) {
        return wrap(Api.tensor_slice(this.ptr, dim, start, end, step), true);
    }

    public Tensor select(long dim, long index) {
        return wrap(Api.tensor_select(this.ptr, dim, index), true);
    }

    public Tensor permute(long[] dims) {
        return wrap(Api.tensor_permute(this.ptr, dims), true);
    }

    public Tensor squeeze(long dim) {
        return wrap(Api.tensor_squeeze(this.ptr, dim), true);
    }

    public Tensor unsqueeze(long dim) {
        return wrap(Api.tensor_unsqueeze(this.ptr, dim), true);
    }

    public Tensor to(String device, boolean nonBlocking) {
        return wrap(Api.tensor_to_device(this.ptr, device, nonBlocking), true);
    }

    public Tensor to(Device device, boolean nonBlocking) {
        return to(device.toString(), nonBlocking);
    }

    public Tensor to(ScalarType dtype) {
        return wrap(Api.tensor_to_dtype(this.ptr, dtype.getValue()), true);
    }

    public void copyFrom(Tensor from) {
        Api.tensor_copy_from(this.ptr, from.getPtr());
    }

    public static Tensor empty(long[] shape, ScalarType dtype, String device, boolean pinned_memory) {
        return wrap(Api.tensor_empty(shape, dtype.getValue(), device, pinned_memory), true);
    }

    public static Tensor empty(long[] shape, ScalarType dtype, Device device, boolean pinned_memory) {
        return empty(shape, dtype, device.toString(), pinned_memory);
    }

    public static Tensor arange(long start, long end, long step, ScalarType dtype, String device, boolean pinned_memory) {
        return wrap(Api.tensor_arange(start, end, step, dtype.getValue(), device, pinned_memory), true);
    }

    public static Tensor arange(long start, long end, long step, ScalarType dtype, Device device, boolean pinned_memory) {
        return arange(start, end, step, dtype, device.toString(), pinned_memory);
    }

    public static Tensor fromFile(String fn, ScalarType dtype, long count, long offset) {
        return wrap(Api.tensor_from_file(fn, dtype.getValue(), count, offset), true);
    }

    public void toFile(String fn) {
        Api.tensor_to_file(this.ptr, fn);
    }
}
