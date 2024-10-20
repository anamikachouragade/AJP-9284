package Exception;

public class ParkingSlotException extends Exception {
    public ParkingSlotException(String message) {
        super(message);
    }

    public ParkingSlotException(String message, Throwable cause) {
        super(message, cause);
    }
}

