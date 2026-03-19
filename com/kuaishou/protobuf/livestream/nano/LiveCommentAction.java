package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface LiveCommentAction {

    public static final class ActionFollow extends MessageNano {
        private static volatile ActionFollow[] _emptyArray;
        public long targetUid;

        public static ActionFollow[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new ActionFollow[0];
                    }
                }
            }
            return _emptyArray;
        }

        public ActionFollow() {
            clear();
        }

        public final ActionFollow clear() {
            this.targetUid = 0L;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            long j = this.targetUid;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(1, j);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            long j = this.targetUid;
            return j != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(1, j) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final ActionFollow mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag != 8) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.targetUid = codedInputByteBufferNano.readUInt64();
                }
            }
        }

        public static ActionFollow parseFrom(byte[] bArr) {
            return (ActionFollow) MessageNano.mergeFrom(new ActionFollow(), bArr);
        }

        public static ActionFollow parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new ActionFollow().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class ActionShowMenu extends MessageNano {
        private static volatile ActionShowMenu[] _emptyArray;
        public int contentIndex;
        public int nameIndex;

        public static ActionShowMenu[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new ActionShowMenu[0];
                    }
                }
            }
            return _emptyArray;
        }

        public ActionShowMenu() {
            clear();
        }

        public final ActionShowMenu clear() {
            this.nameIndex = 0;
            this.contentIndex = 0;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            int i = this.nameIndex;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(1, i);
            }
            int i2 = this.contentIndex;
            if (i2 != 0) {
                codedOutputByteBufferNano.writeUInt32(2, i2);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            int i = this.nameIndex;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i);
            }
            int i2 = this.contentIndex;
            return i2 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(2, i2) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final ActionShowMenu mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    this.nameIndex = codedInputByteBufferNano.readUInt32();
                } else if (tag != 16) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.contentIndex = codedInputByteBufferNano.readUInt32();
                }
            }
        }

        public static ActionShowMenu parseFrom(byte[] bArr) {
            return (ActionShowMenu) MessageNano.mergeFrom(new ActionShowMenu(), bArr);
        }

        public static ActionShowMenu parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new ActionShowMenu().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class ActionKwaiUrlJump extends MessageNano {
        private static volatile ActionKwaiUrlJump[] _emptyArray;
        public String link;

        public static ActionKwaiUrlJump[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new ActionKwaiUrlJump[0];
                    }
                }
            }
            return _emptyArray;
        }

        public ActionKwaiUrlJump() {
            clear();
        }

        public final ActionKwaiUrlJump clear() {
            this.link = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.link.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.link);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            return !this.link.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(1, this.link) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final ActionKwaiUrlJump mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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
                    this.link = codedInputByteBufferNano.readString();
                }
            }
        }

        public static ActionKwaiUrlJump parseFrom(byte[] bArr) {
            return (ActionKwaiUrlJump) MessageNano.mergeFrom(new ActionKwaiUrlJump(), bArr);
        }

        public static ActionKwaiUrlJump parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new ActionKwaiUrlJump().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class ActionWebViewJump extends MessageNano {
        private static volatile ActionWebViewJump[] _emptyArray;
        public float heightRatio;
        public String link;

        public static ActionWebViewJump[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new ActionWebViewJump[0];
                    }
                }
            }
            return _emptyArray;
        }

        public ActionWebViewJump() {
            clear();
        }

        public final ActionWebViewJump clear() {
            this.link = "";
            this.heightRatio = 0.0f;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.link.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.link);
            }
            if (Float.floatToIntBits(this.heightRatio) != Float.floatToIntBits(0.0f)) {
                codedOutputByteBufferNano.writeFloat(2, this.heightRatio);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.link.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.link);
            }
            return Float.floatToIntBits(this.heightRatio) != Float.floatToIntBits(0.0f) ? iComputeSerializedSize + CodedOutputByteBufferNano.computeFloatSize(2, this.heightRatio) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final ActionWebViewJump mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.link = codedInputByteBufferNano.readString();
                } else if (tag != 21) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.heightRatio = codedInputByteBufferNano.readFloat();
                }
            }
        }

        public static ActionWebViewJump parseFrom(byte[] bArr) {
            return (ActionWebViewJump) MessageNano.mergeFrom(new ActionWebViewJump(), bArr);
        }

        public static ActionWebViewJump parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new ActionWebViewJump().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class ActionLiveRouterJump extends MessageNano {
        private static volatile ActionLiveRouterJump[] _emptyArray;
        public String link;

        public static ActionLiveRouterJump[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new ActionLiveRouterJump[0];
                    }
                }
            }
            return _emptyArray;
        }

        public ActionLiveRouterJump() {
            clear();
        }

        public final ActionLiveRouterJump clear() {
            this.link = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.link.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.link);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            return !this.link.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(1, this.link) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final ActionLiveRouterJump mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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
                    this.link = codedInputByteBufferNano.readString();
                }
            }
        }

        public static ActionLiveRouterJump parseFrom(byte[] bArr) {
            return (ActionLiveRouterJump) MessageNano.mergeFrom(new ActionLiveRouterJump(), bArr);
        }

        public static ActionLiveRouterJump parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new ActionLiveRouterJump().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class ActionOpenProfile extends MessageNano {
        private static volatile ActionOpenProfile[] _emptyArray;
        public long targetUid;

        public static ActionOpenProfile[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new ActionOpenProfile[0];
                    }
                }
            }
            return _emptyArray;
        }

        public ActionOpenProfile() {
            clear();
        }

        public final ActionOpenProfile clear() {
            this.targetUid = 0L;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            long j = this.targetUid;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(1, j);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            long j = this.targetUid;
            return j != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(1, j) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final ActionOpenProfile mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag != 8) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.targetUid = codedInputByteBufferNano.readUInt64();
                }
            }
        }

        public static ActionOpenProfile parseFrom(byte[] bArr) {
            return (ActionOpenProfile) MessageNano.mergeFrom(new ActionOpenProfile(), bArr);
        }

        public static ActionOpenProfile parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new ActionOpenProfile().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class Action extends MessageNano {
        public static final int FOLLOW_FIELD_NUMBER = 1;
        public static final int KWAI_URL_JUMP_FIELD_NUMBER = 4;
        public static final int LIVE_ROUTER_JUMP_FIELD_NUMBER = 6;
        public static final int OPEN_PROFILE_FIELD_NUMBER = 3;
        public static final int SHOW_MENU_FIELD_NUMBER = 2;
        public static final int WEB_VIEW_JUMP_FIELD_NUMBER = 5;
        private static volatile Action[] _emptyArray;
        private int entryCase_ = 0;
        private Object entry_;

        public final int getEntryCase() {
            return this.entryCase_;
        }

        public final Action clearEntry() {
            this.entryCase_ = 0;
            this.entry_ = null;
            return this;
        }

        public static Action[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new Action[0];
                    }
                }
            }
            return _emptyArray;
        }

        public final boolean hasFollow() {
            return this.entryCase_ == 1;
        }

        public final ActionFollow getFollow() {
            if (this.entryCase_ == 1) {
                return (ActionFollow) this.entry_;
            }
            return null;
        }

        public final Action setFollow(ActionFollow actionFollow) {
            if (actionFollow == null) {
                throw new NullPointerException();
            }
            this.entryCase_ = 1;
            this.entry_ = actionFollow;
            return this;
        }

        public final boolean hasShowMenu() {
            return this.entryCase_ == 2;
        }

        public final ActionShowMenu getShowMenu() {
            if (this.entryCase_ == 2) {
                return (ActionShowMenu) this.entry_;
            }
            return null;
        }

        public final Action setShowMenu(ActionShowMenu actionShowMenu) {
            if (actionShowMenu == null) {
                throw new NullPointerException();
            }
            this.entryCase_ = 2;
            this.entry_ = actionShowMenu;
            return this;
        }

        public final boolean hasOpenProfile() {
            return this.entryCase_ == 3;
        }

        public final ActionOpenProfile getOpenProfile() {
            if (this.entryCase_ == 3) {
                return (ActionOpenProfile) this.entry_;
            }
            return null;
        }

        public final Action setOpenProfile(ActionOpenProfile actionOpenProfile) {
            if (actionOpenProfile == null) {
                throw new NullPointerException();
            }
            this.entryCase_ = 3;
            this.entry_ = actionOpenProfile;
            return this;
        }

        public final boolean hasKwaiUrlJump() {
            return this.entryCase_ == 4;
        }

        public final ActionKwaiUrlJump getKwaiUrlJump() {
            if (this.entryCase_ == 4) {
                return (ActionKwaiUrlJump) this.entry_;
            }
            return null;
        }

        public final Action setKwaiUrlJump(ActionKwaiUrlJump actionKwaiUrlJump) {
            if (actionKwaiUrlJump == null) {
                throw new NullPointerException();
            }
            this.entryCase_ = 4;
            this.entry_ = actionKwaiUrlJump;
            return this;
        }

        public final boolean hasWebViewJump() {
            return this.entryCase_ == 5;
        }

        public final ActionWebViewJump getWebViewJump() {
            if (this.entryCase_ == 5) {
                return (ActionWebViewJump) this.entry_;
            }
            return null;
        }

        public final Action setWebViewJump(ActionWebViewJump actionWebViewJump) {
            if (actionWebViewJump == null) {
                throw new NullPointerException();
            }
            this.entryCase_ = 5;
            this.entry_ = actionWebViewJump;
            return this;
        }

        public final boolean hasLiveRouterJump() {
            return this.entryCase_ == 6;
        }

        public final ActionLiveRouterJump getLiveRouterJump() {
            if (this.entryCase_ == 6) {
                return (ActionLiveRouterJump) this.entry_;
            }
            return null;
        }

        public final Action setLiveRouterJump(ActionLiveRouterJump actionLiveRouterJump) {
            if (actionLiveRouterJump == null) {
                throw new NullPointerException();
            }
            this.entryCase_ = 6;
            this.entry_ = actionLiveRouterJump;
            return this;
        }

        public Action() {
            clear();
        }

        public final Action clear() {
            clearEntry();
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (this.entryCase_ == 1) {
                codedOutputByteBufferNano.writeMessage(1, (MessageNano) this.entry_);
            }
            if (this.entryCase_ == 2) {
                codedOutputByteBufferNano.writeMessage(2, (MessageNano) this.entry_);
            }
            if (this.entryCase_ == 3) {
                codedOutputByteBufferNano.writeMessage(3, (MessageNano) this.entry_);
            }
            if (this.entryCase_ == 4) {
                codedOutputByteBufferNano.writeMessage(4, (MessageNano) this.entry_);
            }
            if (this.entryCase_ == 5) {
                codedOutputByteBufferNano.writeMessage(5, (MessageNano) this.entry_);
            }
            if (this.entryCase_ == 6) {
                codedOutputByteBufferNano.writeMessage(6, (MessageNano) this.entry_);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (this.entryCase_ == 1) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, (MessageNano) this.entry_);
            }
            if (this.entryCase_ == 2) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, (MessageNano) this.entry_);
            }
            if (this.entryCase_ == 3) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, (MessageNano) this.entry_);
            }
            if (this.entryCase_ == 4) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, (MessageNano) this.entry_);
            }
            if (this.entryCase_ == 5) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, (MessageNano) this.entry_);
            }
            return this.entryCase_ == 6 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(6, (MessageNano) this.entry_) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final Action mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    if (this.entryCase_ != 1) {
                        this.entry_ = new ActionFollow();
                    }
                    codedInputByteBufferNano.readMessage((MessageNano) this.entry_);
                    this.entryCase_ = 1;
                } else if (tag == 18) {
                    if (this.entryCase_ != 2) {
                        this.entry_ = new ActionShowMenu();
                    }
                    codedInputByteBufferNano.readMessage((MessageNano) this.entry_);
                    this.entryCase_ = 2;
                } else if (tag == 26) {
                    if (this.entryCase_ != 3) {
                        this.entry_ = new ActionOpenProfile();
                    }
                    codedInputByteBufferNano.readMessage((MessageNano) this.entry_);
                    this.entryCase_ = 3;
                } else if (tag == 34) {
                    if (this.entryCase_ != 4) {
                        this.entry_ = new ActionKwaiUrlJump();
                    }
                    codedInputByteBufferNano.readMessage((MessageNano) this.entry_);
                    this.entryCase_ = 4;
                } else if (tag == 42) {
                    if (this.entryCase_ != 5) {
                        this.entry_ = new ActionWebViewJump();
                    }
                    codedInputByteBufferNano.readMessage((MessageNano) this.entry_);
                    this.entryCase_ = 5;
                } else if (tag != 50) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    if (this.entryCase_ != 6) {
                        this.entry_ = new ActionLiveRouterJump();
                    }
                    codedInputByteBufferNano.readMessage((MessageNano) this.entry_);
                    this.entryCase_ = 6;
                }
            }
        }

        public static Action parseFrom(byte[] bArr) {
            return (Action) MessageNano.mergeFrom(new Action(), bArr);
        }

        public static Action parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new Action().mergeFrom(codedInputByteBufferNano);
        }
    }
}
