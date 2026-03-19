package com.kuaishou.common.netty;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class Constants {
    public static final int HEADER_RESERVED_BYTES = 8;
    public static final int MAX_BODY_LENGTH = 131072;
    public static final byte PROTOCOL_VERSION = 1;
    public static final byte[] MAGIC_BYTES = {26, 43, 60};
    public static final int HEADER_LENGTH = ((MAGIC_BYTES.length + 1) + 8) + 4;
}
