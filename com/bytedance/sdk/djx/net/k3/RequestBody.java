package com.bytedance.sdk.djx.net.k3;

import com.bytedance.sdk.djx.net.io.BufferedSink;
import com.bytedance.sdk.djx.net.io.ByteString;
import com.bytedance.sdk.djx.net.io.Okio;
import com.bytedance.sdk.djx.net.io.Source;
import com.bytedance.sdk.djx.net.k3.internal.Util;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public abstract class RequestBody {
    public long contentLength() throws IOException {
        return -1L;
    }

    public abstract MediaType contentType();

    public abstract void writeTo(BufferedSink bufferedSink) throws IOException;

    public static RequestBody create(MediaType mediaType, String str) {
        Charset charset = Util.UTF_8;
        if (mediaType != null && (charset = mediaType.charset()) == null) {
            charset = Util.UTF_8;
            mediaType = MediaType.parse(mediaType + "; charset=utf-8");
        }
        return create(mediaType, str.getBytes(charset));
    }

    public static RequestBody create(final MediaType mediaType, final ByteString byteString) {
        return new RequestBody() { // from class: com.bytedance.sdk.djx.net.k3.RequestBody.1
            @Override // com.bytedance.sdk.djx.net.k3.RequestBody
            public MediaType contentType() {
                return mediaType;
            }

            @Override // com.bytedance.sdk.djx.net.k3.RequestBody
            public long contentLength() throws IOException {
                return byteString.size();
            }

            @Override // com.bytedance.sdk.djx.net.k3.RequestBody
            public void writeTo(BufferedSink bufferedSink) throws IOException {
                bufferedSink.write(byteString);
            }
        };
    }

    public static RequestBody create(MediaType mediaType, byte[] bArr) {
        return create(mediaType, bArr, 0, bArr.length);
    }

    public static RequestBody create(final MediaType mediaType, final byte[] bArr, final int i, final int i2) {
        if (bArr == null) {
            throw new NullPointerException("content == null");
        }
        Util.checkOffsetAndCount(bArr.length, i, i2);
        return new RequestBody() { // from class: com.bytedance.sdk.djx.net.k3.RequestBody.2
            @Override // com.bytedance.sdk.djx.net.k3.RequestBody
            public MediaType contentType() {
                return mediaType;
            }

            @Override // com.bytedance.sdk.djx.net.k3.RequestBody
            public long contentLength() {
                return i2;
            }

            @Override // com.bytedance.sdk.djx.net.k3.RequestBody
            public void writeTo(BufferedSink bufferedSink) throws IOException {
                bufferedSink.write(bArr, i, i2);
            }
        };
    }

    public static RequestBody create(final MediaType mediaType, final File file) {
        if (file == null) {
            throw new NullPointerException("content == null");
        }
        return new RequestBody() { // from class: com.bytedance.sdk.djx.net.k3.RequestBody.3
            @Override // com.bytedance.sdk.djx.net.k3.RequestBody
            public MediaType contentType() {
                return mediaType;
            }

            @Override // com.bytedance.sdk.djx.net.k3.RequestBody
            public long contentLength() {
                return file.length();
            }

            @Override // com.bytedance.sdk.djx.net.k3.RequestBody
            public void writeTo(BufferedSink bufferedSink) throws IOException {
                Source source = null;
                try {
                    source = Okio.source(file);
                    bufferedSink.writeAll(source);
                } finally {
                    Util.closeQuietly(source);
                }
            }
        };
    }
}
