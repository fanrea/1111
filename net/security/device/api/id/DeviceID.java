package net.security.device.api.id;

import android.content.Context;
import net.security.device.api.id.gaid.GAIDImpl;
import net.security.device.api.id.oaid.AsusImpl;
import net.security.device.api.id.oaid.HuaweiImpl;
import net.security.device.api.id.oaid.LenovoImpl;
import net.security.device.api.id.oaid.MeizuImpl;
import net.security.device.api.id.oaid.MsaImpl;
import net.security.device.api.id.oaid.NubiaImpl;
import net.security.device.api.id.oaid.OppoImpl;
import net.security.device.api.id.oaid.SamsungImpl;
import net.security.device.api.id.oaid.UnsupportedImpl;
import net.security.device.api.id.oaid.VivoImpl;
import net.security.device.api.id.oaid.XiaomiImpl;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public final class DeviceID {
    private DeviceID() {
    }

    public static IOAID withOAID(Context context) {
        if (context == null) {
            return null;
        }
        if (SystemUtils.isXiaomi() || SystemUtils.isBlackShark()) {
            return new XiaomiImpl(context);
        }
        if (SystemUtils.isHuawei()) {
            return new HuaweiImpl(context);
        }
        if (SystemUtils.isLenovo() || SystemUtils.isMotolora()) {
            return new LenovoImpl(context);
        }
        if (SystemUtils.isMeizu()) {
            return new MeizuImpl(context);
        }
        if (SystemUtils.isNubia()) {
            return new NubiaImpl(context);
        }
        if (SystemUtils.isSamsung()) {
            return new SamsungImpl(context);
        }
        if (SystemUtils.isVivo()) {
            return new VivoImpl(context);
        }
        if (SystemUtils.isASUS()) {
            return new AsusImpl(context);
        }
        if (SystemUtils.isOppo() || SystemUtils.isOnePlus()) {
            return new OppoImpl(context);
        }
        if (SystemUtils.isZTE() || SystemUtils.isFreeme() || SystemUtils.isSSUI()) {
            return new MsaImpl(context);
        }
        return new UnsupportedImpl();
    }

    public static IGAID withGAID(Context context) {
        if (context == null) {
            return null;
        }
        return new GAIDImpl(context);
    }
}
