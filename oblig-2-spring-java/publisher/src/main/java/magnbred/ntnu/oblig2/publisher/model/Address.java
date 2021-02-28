package magnbred.ntnu.oblig2.publisher.model;

/**
 * Address
 */
public class Address {

    private String address;
    

    public Address() {
    }

    public Address(String address) {
        this.address = address;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Address address(String address) {
        setAddress(address);
        return this;
    }
}