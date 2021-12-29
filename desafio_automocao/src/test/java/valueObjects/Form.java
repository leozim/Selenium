package valueObjects;

import org.apache.commons.lang3.RandomStringUtils;

public class Form {

    private String firstName;
    private String lastName;
    private String password;
    private String publicPlace;
    private String city;
    private String zipCode;
    private String cellPhone;
    private String mailAddressAlias;

    public Form(String firstName, String lastName, String password, String publicPlace, String city,
                String zipCode, String cellPhone, String mailAddressAlias) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.publicPlace = publicPlace;
        this.city = city;
        this.zipCode = zipCode;
        this.cellPhone = cellPhone;
        this.mailAddressAlias = mailAddressAlias;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public String getPublicPlace() {
        return publicPlace;
    }

    public String getCity() {
        return city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public String getMailAddressAlias() {
        return mailAddressAlias;
    }

    public static Form build(String address) {

        var firstName = RandomStringUtils.random(20, true, false);
        var lastName = RandomStringUtils.random(20, true, false);
        var password = RandomStringUtils.random(10, true, true);
        var publicPlace = RandomStringUtils.random(10, true, true);
        var city = RandomStringUtils.random(10, true, true);
        var zipCode = RandomStringUtils.random(5, false, true);
        var cellPhone = RandomStringUtils.random(11, false, true);
        var mailAddressAlias = address + RandomStringUtils.random(2, true, false);

        return new Form(firstName, lastName, password, publicPlace, city, zipCode, cellPhone, mailAddressAlias);
    }
}
