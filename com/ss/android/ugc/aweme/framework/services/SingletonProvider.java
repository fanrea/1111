package com.ss.android.ugc.aweme.framework.services;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class SingletonProvider<T> implements ServiceProvider<T> {
    volatile T service;
    ServiceProvider<T> serviceProvider;

    public SingletonProvider(ServiceProvider serviceProvider) {
        this.serviceProvider = serviceProvider;
    }

    @Override // com.ss.android.ugc.aweme.framework.services.ServiceProvider
    public synchronized T get() {
        if (this.service == null) {
            this.service = this.serviceProvider.get();
        }
        return this.service;
    }
}
