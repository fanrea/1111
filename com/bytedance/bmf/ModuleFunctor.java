package com.bytedance.bmf;

import com.bytedance.hmp.Ptr;
import com.google.gson.Gson;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class ModuleFunctor extends Ptr {
    boolean cleanup;
    Class[] inputTypes;
    Class[] outputTypes;

    public static ModuleFunctor wrap(long p, boolean own) {
        return new ModuleFunctor(p, own);
    }

    ModuleFunctor(long p, boolean own) {
        this.cleanup = true;
        this.ptr = p;
        this.own = own;
    }

    public ModuleFunctor(ModuleInfo moduleInfo, Object option, Class[] inputTypes, Class[] outputTypes) {
        this.cleanup = true;
        this.ptr = API.bmf_module_functor_make(moduleInfo.name, moduleInfo.type, moduleInfo.path, moduleInfo.entry, new Gson().toJson(option), inputTypes.length, outputTypes.length, -1);
        this.own = true;
        this.inputTypes = inputTypes;
        this.outputTypes = outputTypes;
    }

    public ModuleFunctor(ModuleInfo moduleInfo, Object option, Class[] inputTypes, Class[] outputTypes, boolean cleanup) {
        this(moduleInfo, option, inputTypes, outputTypes);
        this.cleanup = cleanup;
    }

    public void free() {
        if (this.own) {
            API.bmf_module_functor_free(this.ptr);
        }
    }

    Packet[] _inputs(Object[] inputs) throws Exception {
        Class cls;
        if (inputs == null) {
            return new Packet[this.inputTypes.length];
        }
        int length = inputs.length;
        Class[] clsArr = this.inputTypes;
        if (length != clsArr.length) {
            throw new IllegalArgumentException(String.format("Expect %d inputs, got %d", Integer.valueOf(this.inputTypes.length), Integer.valueOf(inputs.length)));
        }
        int length2 = clsArr.length;
        Packet[] packetArr = new Packet[length2];
        for (int i = 0; i < inputs.length; i++) {
            try {
                Object obj = inputs[i];
                if (obj != null && (cls = this.inputTypes[i]) != null && !cls.isInstance(obj)) {
                    throw new IllegalArgumentException(String.format("Expect input type %s at %d, got %s", this.inputTypes[i].getName(), Integer.valueOf(i), inputs[i].getClass().getName()));
                }
                packetArr[i] = new Packet(inputs[i]);
            } catch (Exception e) {
                for (int i2 = 0; i2 < length2; i2++) {
                    Packet packet = packetArr[i2];
                    if (packet != null) {
                        packet.free();
                    }
                }
                throw e;
            }
        }
        return packetArr;
    }

    Object _output(Packet pkt, int port) throws Exception {
        if (pkt.getPtr() == 0) {
            return null;
        }
        Class cls = this.outputTypes[port];
        return cls == null ? pkt : pkt.get(cls);
    }

    public Object[] call(Object... inputs) throws Exception {
        Class cls;
        Packet[] packetArr_inputs = _inputs(inputs);
        int length = this.outputTypes.length;
        Packet[] packetArr = new Packet[length];
        int i = 0;
        try {
            long[] jArr = new long[packetArr_inputs.length];
            for (int i2 = 0; i2 < packetArr_inputs.length; i2++) {
                jArr[i2] = packetArr_inputs[i2].getPtr();
            }
            long[] jArrBmf_module_functor_call = API.bmf_module_functor_call(this.ptr, jArr);
            if (jArrBmf_module_functor_call == null) {
                throw new IllegalStateException("output pkt (opktPtrs) is null");
            }
            if (jArrBmf_module_functor_call.length != this.outputTypes.length) {
                for (long j : jArrBmf_module_functor_call) {
                    API.bmf_packet_free(j);
                }
                throw new IllegalStateException(String.format("Expect %d outputs, got %d", Integer.valueOf(this.outputTypes.length), Integer.valueOf(jArrBmf_module_functor_call.length)));
            }
            for (int i3 = 0; i3 < jArrBmf_module_functor_call.length; i3++) {
                packetArr[i3] = Packet.wrap(jArrBmf_module_functor_call[i3], true);
            }
            for (int i4 = 0; i4 < length; i4++) {
                if (packetArr[i4].getPtr() != 0 && (cls = this.outputTypes[i4]) != null && !packetArr[i4].is(cls)) {
                    throw new IllegalStateException(String.format("Invalid output packet type at port %d, expect %s", Integer.valueOf(i4), this.outputTypes[i4].getName()));
                }
            }
            Object[] objArr = new Object[jArrBmf_module_functor_call.length];
            for (int i5 = 0; i5 < jArrBmf_module_functor_call.length; i5++) {
                objArr[i5] = _output(packetArr[i5], i5);
            }
            return objArr;
        } catch (Throwable th) {
            try {
                th.printStackTrace();
                for (Packet packet : packetArr_inputs) {
                    packet.free();
                }
                while (i < length) {
                    Packet packet2 = packetArr[i];
                    if (packet2 != null) {
                        packet2.free();
                    }
                    i++;
                }
                return null;
            } finally {
                for (Packet packet3 : packetArr_inputs) {
                    packet3.free();
                }
                while (i < length) {
                    Packet packet4 = packetArr[i];
                    if (packet4 != null) {
                        packet4.free();
                    }
                    i++;
                }
            }
        }
    }

    public void execute(Object... inputs) throws Exception {
        Packet[] packetArr_inputs = _inputs(inputs);
        int i = 0;
        try {
            long[] jArr = new long[packetArr_inputs.length];
            for (int i2 = 0; i2 < packetArr_inputs.length; i2++) {
                jArr[i2] = packetArr_inputs[i2].getPtr();
            }
            API.bmf_module_functor_execute(this.ptr, jArr, this.cleanup);
        } finally {
            while (i < packetArr_inputs.length) {
                packetArr_inputs[i].free();
                i++;
            }
        }
    }

    public Object[] fetch(int port) throws Exception {
        Class cls;
        long[] jArrBmf_module_functor_fetch = API.bmf_module_functor_fetch(this.ptr, port);
        int length = jArrBmf_module_functor_fetch.length;
        Packet[] packetArr = new Packet[length];
        int i = 0;
        for (int i2 = 0; i2 < jArrBmf_module_functor_fetch.length; i2++) {
            packetArr[i2] = Packet.wrap(jArrBmf_module_functor_fetch[i2], true);
        }
        for (int i3 = 0; i3 < length; i3++) {
            try {
                if (packetArr[i3].getPtr() != 0 && (cls = this.outputTypes[port]) != null && !packetArr[i3].is(cls)) {
                    throw new IllegalStateException(String.format("Invalid output packet type at %d from port %d, expect %s", Integer.valueOf(i3), Integer.valueOf(port), this.outputTypes[port].getName()));
                }
            } finally {
                while (i < length) {
                    packetArr[i].free();
                    i++;
                }
            }
        }
        Object[] objArr = new Object[jArrBmf_module_functor_fetch.length];
        for (int i4 = 0; i4 < jArrBmf_module_functor_fetch.length; i4++) {
            objArr[i4] = _output(packetArr[i4], port);
        }
        return objArr;
    }
}
