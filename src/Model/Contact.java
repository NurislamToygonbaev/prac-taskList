package Model;

public class Contact {
    private long phoneNumber;
    private String fullName;
    private long id;

    public Contact() {
    }

    public Contact(long phoneNumber, String fullName, long id) {
        this.phoneNumber = phoneNumber;
        this.fullName = fullName;
        this.id = id;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Contact: " +
                "phoneNumber=" + phoneNumber +
                "fullName='" + fullName + '\'' +
                "id=" + id +
                "\n";
    }
}
