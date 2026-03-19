package com.luck.picture.lib.config;

import java.util.LinkedList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class SelectorProviders {
    private static volatile SelectorProviders selectorProviders;
    private final LinkedList<SelectorConfig> selectionConfigsQueue = new LinkedList<>();

    public void addSelectorConfigQueue(SelectorConfig selectorConfig) {
        this.selectionConfigsQueue.add(selectorConfig);
    }

    public SelectorConfig getSelectorConfig() {
        return this.selectionConfigsQueue.size() > 0 ? this.selectionConfigsQueue.getLast() : new SelectorConfig();
    }

    public void destroy() {
        SelectorConfig selectorConfig = getSelectorConfig();
        if (selectorConfig != null) {
            selectorConfig.destroy();
            this.selectionConfigsQueue.remove(selectorConfig);
        }
    }

    public void reset() {
        for (int i = 0; i < this.selectionConfigsQueue.size(); i++) {
            SelectorConfig selectorConfig = this.selectionConfigsQueue.get(i);
            if (selectorConfig != null) {
                selectorConfig.destroy();
            }
        }
        this.selectionConfigsQueue.clear();
    }

    public static SelectorProviders getInstance() {
        if (selectorProviders == null) {
            synchronized (SelectorProviders.class) {
                if (selectorProviders == null) {
                    selectorProviders = new SelectorProviders();
                }
            }
        }
        return selectorProviders;
    }
}
