package Week13.Lab.Task4;


interface OldDevice {
    void operateOldFunction();
}

interface NewDevice {
    void operateNewFunction();
}

class OldDeviceImpl implements OldDevice {
    @Override
    public void operateOldFunction() {
        System.out.println("I am operating an old function");
    }
}

class NewDeviceImpl implements NewDevice {
    @Override
    public void operateNewFunction() {
        System.out.println("I am operating a new function");
    }
}

class DeviceAdapter implements NewDevice {

    private OldDevice device;
    public DeviceAdapter(OldDevice device) {
        this.device = device;
    }

    @Override
    public void operateNewFunction() {
        device.operateOldFunction(); // da li ovako treba ili da old device executea newFunction()?
    }
}

class Main {
    public static void main(String[] args) {
        OldDevice oldDevice = new OldDeviceImpl();

        NewDevice newDevice = new DeviceAdapter(oldDevice);
        newDevice.operateNewFunction(); // operatea old function
    }
}
