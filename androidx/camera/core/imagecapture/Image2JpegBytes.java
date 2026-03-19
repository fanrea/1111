package androidx.camera.core.imagecapture;

import android.graphics.Rect;
import android.graphics.YuvImage;
import android.util.Size;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.impl.utils.Exif;
import androidx.camera.core.impl.utils.ExifData;
import androidx.camera.core.impl.utils.ExifOutputStream;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.camera.core.internal.ByteBufferOutputStream;
import androidx.camera.core.internal.utils.ImageUtil;
import androidx.camera.core.processing.Operation;
import androidx.camera.core.processing.Packet;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Objects;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
final class Image2JpegBytes implements Operation<In, Packet<byte[]>> {
    Image2JpegBytes() {
    }

    @Override // androidx.camera.core.processing.Operation
    public Packet<byte[]> apply(In in) throws ImageCaptureException {
        Packet<byte[]> packetProcessYuvImage;
        try {
            int format = in.getPacket().getFormat();
            if (format == 35) {
                packetProcessYuvImage = processYuvImage(in);
            } else if (format == 256) {
                packetProcessYuvImage = processJpegImage(in);
            } else {
                throw new IllegalArgumentException("Unexpected format: " + format);
            }
            return packetProcessYuvImage;
        } finally {
            in.getPacket().getData().close();
        }
    }

    private Packet<byte[]> processJpegImage(In in) {
        Packet<ImageProxy> packet = in.getPacket();
        return Packet.of(ImageUtil.jpegImageToJpegByteArray(packet.getData()), (Exif) Objects.requireNonNull(packet.getExif()), 256, packet.getSize(), packet.getCropRect(), packet.getRotationDegrees(), packet.getSensorToBufferTransform(), packet.getCameraCaptureResult());
    }

    private Packet<byte[]> processYuvImage(In in) throws ImageCaptureException {
        Packet<ImageProxy> packet = in.getPacket();
        ImageProxy data = packet.getData();
        Rect cropRect = packet.getCropRect();
        YuvImage yuvImage = new YuvImage(ImageUtil.yuv_420_888toNv21(data), 17, data.getWidth(), data.getHeight(), null);
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(cropRect.width() * cropRect.height() * 2);
        yuvImage.compressToJpeg(cropRect, in.getJpegQuality(), new ExifOutputStream(new ByteBufferOutputStream(byteBufferAllocateDirect), ExifData.create(data, packet.getRotationDegrees())));
        byte[] bArrByteBufferToByteArray = byteBufferToByteArray(byteBufferAllocateDirect);
        return Packet.of(bArrByteBufferToByteArray, extractExif(bArrByteBufferToByteArray), 256, new Size(cropRect.width(), cropRect.height()), new Rect(0, 0, cropRect.width(), cropRect.height()), packet.getRotationDegrees(), TransformUtils.updateSensorToBufferTransform(packet.getSensorToBufferTransform(), cropRect), packet.getCameraCaptureResult());
    }

    private static byte[] byteBufferToByteArray(ByteBuffer byteBuffer) {
        int iPosition = byteBuffer.position();
        byte[] bArr = new byte[iPosition];
        byteBuffer.rewind();
        byteBuffer.get(bArr, 0, iPosition);
        return bArr;
    }

    private static Exif extractExif(byte[] bArr) throws ImageCaptureException {
        try {
            return Exif.createFromInputStream(new ByteArrayInputStream(bArr));
        } catch (IOException e) {
            throw new ImageCaptureException(0, "Failed to extract Exif from YUV-generated JPEG", e);
        }
    }

    static abstract class In {
        abstract int getJpegQuality();

        abstract Packet<ImageProxy> getPacket();

        In() {
        }

        static In of(Packet<ImageProxy> packet, int i) {
            return new AutoValue_Image2JpegBytes_In(packet, i);
        }
    }
}
