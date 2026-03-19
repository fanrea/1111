package com.jeremyliao.liveeventbus.ipc.core;

import android.content.Intent;
import android.os.Bundle;
import com.jeremyliao.liveeventbus.ipc.annotation.IpcConfig;
import com.jeremyliao.liveeventbus.ipc.consts.IpcConst;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class ProcessorManager {
    private final List<Processor> baseProcessors;
    private final Map<String, Processor> processorMap;

    private static class SingletonHolder {
        private static final ProcessorManager INSTANCE = new ProcessorManager();

        private SingletonHolder() {
        }
    }

    public static ProcessorManager getManager() {
        return SingletonHolder.INSTANCE;
    }

    private ProcessorManager() {
        LinkedList<Processor> linkedList = new LinkedList(Arrays.asList(new StringProcessor(), new IntProcessor(), new BooleanProcessor(), new DoubleProcessor(), new FloatProcessor(), new LongProcessor(), new SerializableProcessor(), new ParcelableProcessor()));
        this.baseProcessors = linkedList;
        this.processorMap = new HashMap();
        for (Processor processor : linkedList) {
            this.processorMap.put(processor.getClass().getName(), processor);
        }
    }

    public boolean writeTo(Intent intent, Object obj) {
        boolean z = false;
        if (intent == null || obj == null) {
            return false;
        }
        Bundle bundle = new Bundle();
        IpcConfig ipcConfig = (IpcConfig) obj.getClass().getAnnotation(IpcConfig.class);
        if (ipcConfig != null) {
            Class<? extends Processor> clsProcessor = ipcConfig.processor();
            String name = clsProcessor.getName();
            if (!this.processorMap.containsKey(name)) {
                try {
                    this.processorMap.put(name, clsProcessor.newInstance());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            Processor processor = this.processorMap.get(name);
            if (processor != null) {
                try {
                    if (processor.writeToBundle(bundle, obj)) {
                        intent.putExtra(IpcConst.KEY_PROCESSOR_NAME, processor.getClass().getName());
                        intent.putExtra(IpcConst.KEY_BUNDLE, bundle);
                        z = true;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            if (z) {
                return true;
            }
        }
        for (Processor processor2 : this.baseProcessors) {
            try {
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            if (processor2.writeToBundle(bundle, obj)) {
                intent.putExtra(IpcConst.KEY_PROCESSOR_NAME, processor2.getClass().getName());
                intent.putExtra(IpcConst.KEY_BUNDLE, bundle);
                return true;
            }
            continue;
        }
        return z;
    }

    public Object createFrom(Intent intent) {
        if (intent == null) {
            return null;
        }
        String stringExtra = intent.getStringExtra(IpcConst.KEY_PROCESSOR_NAME);
        Bundle bundleExtra = intent.getBundleExtra(IpcConst.KEY_BUNDLE);
        if (stringExtra != null && stringExtra.length() != 0 && bundleExtra != null) {
            if (!this.processorMap.containsKey(stringExtra)) {
                try {
                    this.processorMap.put(stringExtra, (Processor) Class.forName(stringExtra).newInstance());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            Processor processor = this.processorMap.get(stringExtra);
            if (processor == null) {
                return null;
            }
            try {
                return processor.createFromBundle(bundleExtra);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }
}
