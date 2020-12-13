package guru.springframework.spring5webapp.domain;

public class Address {
    private String addressLine1;
    private String zip;
    private String country;
    private String city;
    private String state;

    public Address() {
    }

    public Address(String addressLine1, String zip, String country, String city, String state) {
        this.addressLine1 = addressLine1;
        this.zip = zip;
        this.country = country;
        this.city = city;
        this.state = state;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public String getZip() {
        return zip;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressLine1='" + addressLine1 + '\'' +
                ", zip='" + zip + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address = (Address) o;

        if (!addressLine1.equals(address.addressLine1)) return false;
        if (!zip.equals(address.zip)) return false;
        if (!country.equals(address.country)) return false;
        if (!city.equals(address.city)) return false;
        return state != null ? state.equals(address.state) : address.state == null;
    }

    @Override
    public int hashCode() {
        int result = addressLine1.hashCode();
        result = 31 * result + zip.hashCode();
        result = 31 * result + country.hashCode();
        result = 31 * result + city.hashCode();
        result = 31 * result + (state != null ? state.hashCode() : 0);
        return result;
    }
}
