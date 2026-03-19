package androidx.profileinstaller;

import com.sigmob.sdk.archives.tar.e;
import java.util.Arrays;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class ProfileVersion {
    public static final int MAX_SUPPORTED_SDK = 33;
    public static final int MIN_SUPPORTED_SDK = 24;
    static final byte[] V015_S = {e.H, e.I, e.M, 0};
    static final byte[] V010_P = {e.H, e.I, e.H, 0};
    static final byte[] V009_O_MR1 = {e.H, e.H, 57, 0};
    static final byte[] V005_O = {e.H, e.H, e.M, 0};
    static final byte[] V001_N = {e.H, e.H, e.I, 0};
    static final byte[] METADATA_V001_N = {e.H, e.H, e.I, 0};
    static final byte[] METADATA_V002 = {e.H, e.H, e.J, 0};

    private ProfileVersion() {
    }

    static String dexKeySeparator(byte[] bArr) {
        return (Arrays.equals(bArr, V001_N) || Arrays.equals(bArr, V005_O)) ? ":" : "!";
    }
}
