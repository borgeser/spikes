package com.novoda.tpbot.bot.device;

public abstract class DeviceConnection {

    private final DeviceConnectionListener deviceConnectionListener;

    public DeviceConnection(DeviceConnectionListener deviceConnectionListener) {
        this.deviceConnectionListener = deviceConnectionListener;
    }

    public final DeviceConnectionListener deviceConnectionListener() {
        return deviceConnectionListener;
    }

    public abstract void connect();

    public abstract void disconnect();

    public abstract void send(String data);

    public interface DeviceConnectionListener {
        void onDeviceConnected();

        void onDeviceDisconnected();

        void onDataReceived(String data);

    }
}