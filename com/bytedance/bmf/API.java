package com.bytedance.bmf;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class API {
    private static final String LIBBMFMODULESDK = "_jbmf";

    static native void bmf_af_copy_props(long self, long from);

    static native boolean bmf_af_defined(long p);

    static native int bmf_af_dtype(long p);

    static native void bmf_af_free(long p);

    static native long bmf_af_make(int samples, int layout, boolean planer, int sType);

    static native long bmf_af_make_from_data(long[] data_ptr, int size, int layout, boolean planer);

    static native int bmf_af_nchannels(long p);

    static native int bmf_af_nplanes(long p);

    static native int bmf_af_nsamples(long p);

    static native long bmf_af_plane(long p, int i);

    static native boolean bmf_af_planer(long p);

    static native long[] bmf_af_planes(long p);

    static native void bmf_af_private_attach_json_param(long p, long ptr);

    static native long bmf_af_private_get_json_param(long p);

    static native void bmf_af_private_merge(long self, long from);

    static native long bmf_af_pts(long p);

    static native float bmf_af_sample_rate(long p);

    static native void bmf_af_set_pts(long p, long pts);

    static native void bmf_af_set_sample_rate(long p, float sampleRate);

    static native void bmf_af_set_time_base(long p, int num, int den);

    static native int[] bmf_af_time_base(long p);

    static native String bmf_json_dump(long p);

    static native boolean bmf_json_erase(long p, String key);

    static native void bmf_json_free(long p);

    static native double bmf_json_get_double(long p, String key);

    static native double[] bmf_json_get_double_list(long p, String key);

    static native float bmf_json_get_float(long p, String key);

    static native float[] bmf_json_get_float_list(long p, String key);

    static native int bmf_json_get_int(long p, String key);

    static native int[] bmf_json_get_int_list(long p, String key);

    static native long bmf_json_get_long(long p, String key);

    static native String bmf_json_get_string(long p, String key);

    static native String[] bmf_json_get_string_list(long p, String key);

    static native boolean bmf_json_has_key(long p, String key);

    static native long bmf_json_make();

    static native String bmf_json_param_dump(long p);

    static native long bmf_json_param_parse(String opt);

    static native void bmf_json_set_double(long p, String key, double n);

    static native void bmf_json_set_double_list(long p, String key, double[] arr);

    static native void bmf_json_set_float(long p, String key, float f);

    static native void bmf_json_set_float_list(long p, String key, float[] arr);

    static native void bmf_json_set_int(long p, String key, int n);

    static native void bmf_json_set_int_list(long p, String key, int[] arr);

    static native void bmf_json_set_long(long p, String key, long n);

    static native void bmf_json_set_string(long p, String key, String str);

    static native void bmf_json_set_string_list(long p, String key, String[] arr);

    static native long[] bmf_module_functor_call(long p, long[] pkts);

    static native void bmf_module_functor_execute(long p, long[] pkts, boolean cleanup);

    static native long[] bmf_module_functor_fetch(long p, int index);

    static native void bmf_module_functor_free(long p);

    static native long bmf_module_functor_make(String name, String type, String path, String entry, String option, int ninputs, int noutputs, int node_id);

    static native int bmf_packet_defined(long p);

    static native void bmf_packet_free(long p);

    static native long bmf_packet_from_json_param(long p);

    static native long bmf_packet_from_json_str(String json);

    static native long bmf_packet_from_videoframe(long p);

    static native long bmf_packet_generate_eof_packet();

    static native long bmf_packet_generate_eos_packet();

    static native long bmf_packet_get_json_param(long p);

    static native long bmf_packet_get_videoframe(long p);

    static native boolean bmf_packet_is_json_param(long p);

    static native boolean bmf_packet_is_videoframe(long p);

    static native void bmf_packet_set_timestamp(long p, long ts);

    static native long bmf_packet_timestamp(long p);

    static native String bmf_packet_to_json_str(long p);

    static native void bmf_task_fill_input_packet(long p, int stream_id, long pkt_ptr);

    static native void bmf_task_fill_output_packet(long p, int stream_id, long pkt_ptr);

    static native void bmf_task_free(long p);

    static native int[] bmf_task_get_input_stream_ids(long p);

    static native int[] bmf_task_get_output_stream_ids(long p);

    static native long bmf_task_make(int nodeId, int[] istream_ids, int[] ostream_ids);

    static native long bmf_task_pop_packet_from_input_queue(long p, int stream_id);

    static native long bmf_task_pop_packet_from_out_queue(long p, int stream_id);

    static native void bmf_task_set_timestamp(long p, long ts);

    static native long bmf_task_timestamp(long p);

    static native void bmf_vf_copy_from(long self, long from);

    static native void bmf_vf_copy_props(long self, long from);

    static native boolean bmf_vf_defined(long p);

    static native int bmf_vf_device_index(long p);

    static native int bmf_vf_device_type(long p);

    static native int bmf_vf_dtype(long p);

    static native long bmf_vf_frame(long p);

    static native void bmf_vf_free(long p);

    static native long bmf_vf_from_frame(long p);

    static native long bmf_vf_from_image(long p);

    static native int bmf_vf_height(long p);

    static native long bmf_vf_image(long p);

    static native boolean bmf_vf_is_image(long p);

    static native long bmf_vf_make_frame(int width, int height, long pixInfoPtr, String dType);

    static native long bmf_vf_make_image(int width, int height, int channels, int cfmt, int sType, String dType, boolean pinned_memory);

    static native void bmf_vf_private_attach_json_param(long p, long ptr);

    static native long bmf_vf_private_get_json_param(long p);

    static native void bmf_vf_private_merge(long self, long from);

    static native long bmf_vf_pts(long p);

    static native boolean bmf_vf_ready(long p);

    static native void bmf_vf_record(long p, boolean use_current);

    static native void bmf_vf_set_pts(long p, long pts);

    static native void bmf_vf_set_time_base(long p, int num, int den);

    static native void bmf_vf_synchronize(long p);

    static native int[] bmf_vf_time_base(long p);

    static native long bmf_vf_to_device(long p, String device, boolean non_blocking);

    static native long bmf_vf_to_dtype(long p, int sType);

    static native long bmf_vf_to_frame(long p, long pixInfoPtr);

    static native long bmf_vf_to_image(long p, int format, boolean contiguous);

    static native int bmf_vf_width(long p);

    static {
        System.loadLibrary(LIBBMFMODULESDK);
    }
}
