package Model;

public class ParkingSlot {
    private int id;
    private boolean isAvailable;

    // Constructor
    public ParkingSlot() {
    	
    }
    
    public ParkingSlot(int id,  boolean isAvailable) {
        this.id = id;
        this.isAvailable = isAvailable;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "ParkingSlot{" +
                "id=" + id +
                ", isAvailable=" + isAvailable +
                '}';
    }
}

