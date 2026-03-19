package com.bytedance.bmf;

import com.bytedance.hmp.EnumUtil;
import com.bytedance.hmp.Ptr;
import com.bytedance.hmp.ScalarType;
import com.bytedance.hmp.Tensor;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class AudioFrame extends Ptr {
    public static AudioFrame wrap(long p, boolean own) {
        return new AudioFrame(p, own);
    }

    AudioFrame(long p, boolean own) {
        this.ptr = p;
        this.own = own;
    }

    public AudioFrame(Tensor[] data, int size, int layout, boolean planer) {
        int length = data.length;
        long[] jArr = new long[length];
        for (int i = 0; i < length; i++) {
            jArr[i] = data[i].getPtr();
        }
        this.ptr = API.bmf_af_make_from_data(jArr, size, layout, planer);
        this.own = true;
    }

    public AudioFrame(int samples, int layout, boolean planer, ScalarType dtype) {
        this.ptr = API.bmf_af_make(samples, layout, planer, dtype.getValue());
        this.own = true;
    }

    public void free() {
        if (this.own) {
            API.bmf_af_free(this.ptr);
        }
    }

    public boolean defined() {
        return API.bmf_af_defined(this.ptr);
    }

    public ScalarType dtype() {
        return (ScalarType) EnumUtil.fromValue(ScalarType.class, Integer.valueOf(API.bmf_af_dtype(this.ptr)));
    }

    public boolean planer() {
        return API.bmf_af_planer(this.ptr);
    }

    public int nsamples() {
        return API.bmf_af_nsamples(this.ptr);
    }

    public int nchannels() {
        return API.bmf_af_nchannels(this.ptr);
    }

    public void setSampleRate(float sampleRate) {
        API.bmf_af_set_sample_rate(this.ptr, sampleRate);
    }

    public float sampleRate() {
        return API.bmf_af_sample_rate(this.ptr);
    }

    public Tensor[] planes() {
        long[] jArrBmf_af_planes = API.bmf_af_planes(this.ptr);
        int length = jArrBmf_af_planes.length;
        Tensor[] tensorArr = new Tensor[length];
        for (int i = 0; i < length; i++) {
            tensorArr[i] = Tensor.wrap(jArrBmf_af_planes[i], true);
        }
        return tensorArr;
    }

    public int nplanes() {
        return API.bmf_af_nplanes(this.ptr);
    }

    public Tensor plane(int i) {
        return Tensor.wrap(API.bmf_af_plane(this.ptr, i), true);
    }

    public void copyProps(AudioFrame from) {
        API.bmf_af_copy_props(this.ptr, from.ptr);
    }

    public void privateMerge(AudioFrame from) {
        API.bmf_af_private_merge(this.ptr, from.ptr);
    }

    /* renamed from: com.bytedance.bmf.AudioFrame$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$bytedance$bmf$OpaqueDataKey;

        static {
            int[] iArr = new int[OpaqueDataKey.values().length];
            $SwitchMap$com$bytedance$bmf$OpaqueDataKey = iArr;
            try {
                iArr[OpaqueDataKey.kJsonParam.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public Object privateGet(OpaqueDataKey opaqueDataKey) throws IllegalArgumentException {
        if (AnonymousClass1.$SwitchMap$com$bytedance$bmf$OpaqueDataKey[opaqueDataKey.ordinal()] == 1) {
            return new Gson().fromJson(API.bmf_json_param_dump(API.bmf_af_private_get_json_param(this.ptr)), JsonObject.class);
        }
        throw new IllegalArgumentException("Unknown opaque data key in PrivateGet");
    }

    public void privateAttach(OpaqueDataKey opaqueDataKey, Object option) throws IllegalArgumentException {
        if (AnonymousClass1.$SwitchMap$com$bytedance$bmf$OpaqueDataKey[opaqueDataKey.ordinal()] == 1) {
            API.bmf_af_private_attach_json_param(this.ptr, API.bmf_json_param_parse(((JsonObject) option).toString()));
            return;
        }
        throw new IllegalArgumentException("Unknown opaque data key in PrivateAttach");
    }

    public void setPts(long pts) {
        API.bmf_af_set_pts(this.ptr, pts);
    }

    public long pts() {
        return API.bmf_af_pts(this.ptr);
    }

    public void setTimeBase(Rational rational) {
        API.bmf_af_set_time_base(this.ptr, rational.num, rational.den);
    }

    public Rational timeBase() {
        int[] iArrBmf_af_time_base = API.bmf_af_time_base(this.ptr);
        return new Rational(iArrBmf_af_time_base[0], iArrBmf_af_time_base[1]);
    }
}
