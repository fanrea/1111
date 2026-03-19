package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.socket.nano.UserInfos;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface LivePopUp {

    public static final class LiveToast extends MessageNano {
        private static volatile LiveToast[] _emptyArray;
        public String content;

        public static LiveToast[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveToast[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveToast() {
            clear();
        }

        public final LiveToast clear() {
            this.content = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.content.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.content);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            return !this.content.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(1, this.content) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveToast mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag != 10) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.content = codedInputByteBufferNano.readString();
                }
            }
        }

        public static LiveToast parseFrom(byte[] bArr) {
            return (LiveToast) MessageNano.mergeFrom(new LiveToast(), bArr);
        }

        public static LiveToast parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveToast().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LiveDialog extends MessageNano {
        private static volatile LiveDialog[] _emptyArray;
        public String bizType;
        public String button;
        public String content;
        public UserInfos.PicUrl[] icon;
        public String title;

        public static LiveDialog[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveDialog[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveDialog() {
            clear();
        }

        public final LiveDialog clear() {
            this.title = "";
            this.content = "";
            this.button = "";
            this.icon = UserInfos.PicUrl.emptyArray();
            this.bizType = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.title.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.title);
            }
            if (!this.content.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.content);
            }
            if (!this.button.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.button);
            }
            UserInfos.PicUrl[] picUrlArr = this.icon;
            if (picUrlArr != null && picUrlArr.length > 0) {
                int i = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr2 = this.icon;
                    if (i >= picUrlArr2.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl = picUrlArr2[i];
                    if (picUrl != null) {
                        codedOutputByteBufferNano.writeMessage(4, picUrl);
                    }
                    i++;
                }
            }
            if (!this.bizType.equals("")) {
                codedOutputByteBufferNano.writeString(5, this.bizType);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.title.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.title);
            }
            if (!this.content.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.content);
            }
            if (!this.button.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.button);
            }
            UserInfos.PicUrl[] picUrlArr = this.icon;
            if (picUrlArr != null && picUrlArr.length > 0) {
                int i = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr2 = this.icon;
                    if (i >= picUrlArr2.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl = picUrlArr2[i];
                    if (picUrl != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, picUrl);
                    }
                    i++;
                }
            }
            return !this.bizType.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(5, this.bizType) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveDialog mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.title = codedInputByteBufferNano.readString();
                } else if (tag == 18) {
                    this.content = codedInputByteBufferNano.readString();
                } else if (tag == 26) {
                    this.button = codedInputByteBufferNano.readString();
                } else if (tag == 34) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                    UserInfos.PicUrl[] picUrlArr = this.icon;
                    int length = picUrlArr == null ? 0 : picUrlArr.length;
                    UserInfos.PicUrl[] picUrlArr2 = new UserInfos.PicUrl[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.icon, 0, picUrlArr2, 0, length);
                    }
                    while (length < picUrlArr2.length - 1) {
                        picUrlArr2[length] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    picUrlArr2[length] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                    this.icon = picUrlArr2;
                } else if (tag != 42) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.bizType = codedInputByteBufferNano.readString();
                }
            }
        }

        public static LiveDialog parseFrom(byte[] bArr) {
            return (LiveDialog) MessageNano.mergeFrom(new LiveDialog(), bArr);
        }

        public static LiveDialog parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveDialog().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCLivePopUp extends MessageNano {
        public static final int DIALOG_FIELD_NUMBER = 2;
        public static final int TOAST_FIELD_NUMBER = 1;
        private static volatile SCLivePopUp[] _emptyArray;
        private int popUpCase_ = 0;
        private Object popUp_;

        public final int getPopUpCase() {
            return this.popUpCase_;
        }

        public final SCLivePopUp clearPopUp() {
            this.popUpCase_ = 0;
            this.popUp_ = null;
            return this;
        }

        public static SCLivePopUp[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLivePopUp[0];
                    }
                }
            }
            return _emptyArray;
        }

        public final boolean hasToast() {
            return this.popUpCase_ == 1;
        }

        public final LiveToast getToast() {
            if (this.popUpCase_ == 1) {
                return (LiveToast) this.popUp_;
            }
            return null;
        }

        public final SCLivePopUp setToast(LiveToast liveToast) {
            if (liveToast == null) {
                throw new NullPointerException();
            }
            this.popUpCase_ = 1;
            this.popUp_ = liveToast;
            return this;
        }

        public final boolean hasDialog() {
            return this.popUpCase_ == 2;
        }

        public final LiveDialog getDialog() {
            if (this.popUpCase_ == 2) {
                return (LiveDialog) this.popUp_;
            }
            return null;
        }

        public final SCLivePopUp setDialog(LiveDialog liveDialog) {
            if (liveDialog == null) {
                throw new NullPointerException();
            }
            this.popUpCase_ = 2;
            this.popUp_ = liveDialog;
            return this;
        }

        public SCLivePopUp() {
            clear();
        }

        public final SCLivePopUp clear() {
            clearPopUp();
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (this.popUpCase_ == 1) {
                codedOutputByteBufferNano.writeMessage(1, (MessageNano) this.popUp_);
            }
            if (this.popUpCase_ == 2) {
                codedOutputByteBufferNano.writeMessage(2, (MessageNano) this.popUp_);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (this.popUpCase_ == 1) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, (MessageNano) this.popUp_);
            }
            return this.popUpCase_ == 2 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(2, (MessageNano) this.popUp_) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLivePopUp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    if (this.popUpCase_ != 1) {
                        this.popUp_ = new LiveToast();
                    }
                    codedInputByteBufferNano.readMessage((MessageNano) this.popUp_);
                    this.popUpCase_ = 1;
                } else if (tag != 18) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    if (this.popUpCase_ != 2) {
                        this.popUp_ = new LiveDialog();
                    }
                    codedInputByteBufferNano.readMessage((MessageNano) this.popUp_);
                    this.popUpCase_ = 2;
                }
            }
        }

        public static SCLivePopUp parseFrom(byte[] bArr) {
            return (SCLivePopUp) MessageNano.mergeFrom(new SCLivePopUp(), bArr);
        }

        public static SCLivePopUp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLivePopUp().mergeFrom(codedInputByteBufferNano);
        }
    }
}
