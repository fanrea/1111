package net.security.device.api.id.oaid;

import net.security.device.api.id.IOAID;
import net.security.device.api.id.IOAIDGetter;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public class UnsupportedImpl implements IOAID {
    @Override // net.security.device.api.id.IOAID
    public boolean supportOAID() {
        return false;
    }

    @Override // net.security.device.api.id.IOAID
    public void doGet(IOAIDGetter iOAIDGetter) {
        iOAIDGetter.onOAIDGetError(new RuntimeException("OAID unsupported"));
    }
}
