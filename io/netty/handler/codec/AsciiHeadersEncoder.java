package io.netty.handler.codec;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.util.AsciiString;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class AsciiHeadersEncoder {
    private final ByteBuf buf;
    private final NewlineType newlineType;
    private final SeparatorType separatorType;

    public enum NewlineType {
        LF,
        CRLF
    }

    public enum SeparatorType {
        COLON,
        COLON_SPACE
    }

    private static int c2b(char c) {
        if (c < 256) {
            return (byte) c;
        }
        return 63;
    }

    public AsciiHeadersEncoder(ByteBuf byteBuf) {
        this(byteBuf, SeparatorType.COLON_SPACE, NewlineType.CRLF);
    }

    public AsciiHeadersEncoder(ByteBuf byteBuf, SeparatorType separatorType, NewlineType newlineType) {
        if (byteBuf == null) {
            throw new NullPointerException("buf");
        }
        if (separatorType == null) {
            throw new NullPointerException("separatorType");
        }
        if (newlineType == null) {
            throw new NullPointerException("newlineType");
        }
        this.buf = byteBuf;
        this.separatorType = separatorType;
        this.newlineType = newlineType;
    }

    public final void encode(Map.Entry<CharSequence, CharSequence> entry) {
        int i;
        int i2;
        CharSequence key = entry.getKey();
        CharSequence value = entry.getValue();
        ByteBuf byteBuf = this.buf;
        int length = key.length();
        int length2 = value.length();
        int iWriterIndex = byteBuf.writerIndex();
        byteBuf.ensureWritable(length + length2 + 4);
        writeAscii(byteBuf, iWriterIndex, key, length);
        int i3 = iWriterIndex + length;
        int i4 = AnonymousClass1.$SwitchMap$io$netty$handler$codec$AsciiHeadersEncoder$SeparatorType[this.separatorType.ordinal()];
        if (i4 == 1) {
            i = i3 + 1;
            byteBuf.setByte(i3, 58);
        } else if (i4 == 2) {
            int i5 = i3 + 1;
            byteBuf.setByte(i3, 58);
            byteBuf.setByte(i5, 32);
            i = i5 + 1;
        } else {
            throw new Error();
        }
        writeAscii(byteBuf, i, value, length2);
        int i6 = i + length2;
        int i7 = AnonymousClass1.$SwitchMap$io$netty$handler$codec$AsciiHeadersEncoder$NewlineType[this.newlineType.ordinal()];
        if (i7 == 1) {
            i2 = i6 + 1;
            byteBuf.setByte(i6, 10);
        } else if (i7 == 2) {
            int i8 = i6 + 1;
            byteBuf.setByte(i6, 13);
            byteBuf.setByte(i8, 10);
            i2 = i8 + 1;
        } else {
            throw new Error();
        }
        byteBuf.writerIndex(i2);
    }

    /* renamed from: io.netty.handler.codec.AsciiHeadersEncoder$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$AsciiHeadersEncoder$NewlineType = new int[NewlineType.values().length];
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$AsciiHeadersEncoder$SeparatorType;

        static {
            try {
                $SwitchMap$io$netty$handler$codec$AsciiHeadersEncoder$NewlineType[NewlineType.LF.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$AsciiHeadersEncoder$NewlineType[NewlineType.CRLF.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $SwitchMap$io$netty$handler$codec$AsciiHeadersEncoder$SeparatorType = new int[SeparatorType.values().length];
            try {
                $SwitchMap$io$netty$handler$codec$AsciiHeadersEncoder$SeparatorType[SeparatorType.COLON.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$AsciiHeadersEncoder$SeparatorType[SeparatorType.COLON_SPACE.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private static void writeAscii(ByteBuf byteBuf, int i, CharSequence charSequence, int i2) {
        if (charSequence instanceof AsciiString) {
            writeAsciiString(byteBuf, i, (AsciiString) charSequence, i2);
        } else {
            writeCharSequence(byteBuf, i, charSequence, i2);
        }
    }

    private static void writeAsciiString(ByteBuf byteBuf, int i, AsciiString asciiString, int i2) {
        ByteBufUtil.copy(asciiString, 0, byteBuf, i, i2);
    }

    private static void writeCharSequence(ByteBuf byteBuf, int i, CharSequence charSequence, int i2) {
        int i3 = 0;
        while (i3 < i2) {
            byteBuf.setByte(i, c2b(charSequence.charAt(i3)));
            i3++;
            i++;
        }
    }
}
