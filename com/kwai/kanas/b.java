package com.kwai.kanas;

import android.util.Log;
import com.kwai.kanas.interfaces.CommonParams;
import com.kwai.middleware.azeroth.logger.CustomProtoEvent;
import com.kwai.middleware.azeroth.logger.CustomStatEvent;
import com.kwai.middleware.azeroth.logger.IKwaiLogger;
import com.kwai.middleware.azeroth.utils.SampleUtils;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
class b implements IKwaiLogger {
    b() {
    }

    @Override // com.kwai.middleware.azeroth.logger.IKwaiLogger
    public void addCustomStatEvent(CustomStatEvent customStatEvent) {
        if (!SampleUtils.sample(customStatEvent.commonParams().sampleRatio())) {
            Log.d(Kanas.c, "Drop a CustomStatEvent log, key: " + customStatEvent.key() + ", sampleRatio: " + customStatEvent.commonParams().sampleRatio());
            return;
        }
        Kanas.get().addCustomStatEvent(com.kwai.kanas.interfaces.CustomStatEvent.builder().eventId(customStatEvent.eventId()).key(customStatEvent.key()).value(customStatEvent.value()).commonParams(a(customStatEvent.commonParams())).build());
    }

    @Override // com.kwai.middleware.azeroth.logger.IKwaiLogger
    public void addCustomProtoEvent(CustomProtoEvent customProtoEvent) {
        if (!SampleUtils.sample(customProtoEvent.commonParams().sampleRatio())) {
            Log.d(Kanas.c, "Drop a CustomProtoEvent log, type: " + customProtoEvent.type() + ", sampleRatio: " + customProtoEvent.commonParams().sampleRatio());
            return;
        }
        Kanas.get().addCustomProtoEvent(com.kwai.kanas.interfaces.CustomProtoEvent.builder().eventId(customProtoEvent.eventId()).type(customProtoEvent.type()).payload(customProtoEvent.payload()).commonParams(a(customProtoEvent.commonParams())).build());
    }

    private CommonParams a(com.kwai.middleware.azeroth.logger.CommonParams commonParams) {
        return CommonParams.builder().sdkName(commonParams.sdkName()).subBiz(commonParams.subBiz()).realtime(commonParams.realtime()).sampleRatio(commonParams.sampleRatio()).container(commonParams.container()).build();
    }
}
