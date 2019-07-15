package name.quanke.aidldemo.model;

import android.bluetooth.BluetoothDevice;
import android.os.Parcel;
import android.os.Parcelable;

/**
 *
 * Created by quanke on 16/7/23.
 */
public class Message implements Parcelable {
    private long id;
    private String content;
    private BluetoothDevice mDevice;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public BluetoothDevice getDevice() {
        return mDevice;
    }

    public void setDevice(BluetoothDevice mDevice) {
        this.mDevice = mDevice;
    }


    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", content='" + content + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.id);
        dest.writeString(this.content);
        dest.writeParcelable(this.mDevice, flags);
    }

    public Message() {
    }

    protected Message(Parcel in) {
        this.id = in.readLong();
        this.content = in.readString();
        this.mDevice = in.readParcelable(BluetoothDevice.class.getClassLoader());
    }

    public static final Creator<Message> CREATOR = new Creator<Message>() {
        @Override
        public Message createFromParcel(Parcel source) {
            return new Message(source);
        }

        @Override
        public Message[] newArray(int size) {
            return new Message[size];
        }
    };
}
