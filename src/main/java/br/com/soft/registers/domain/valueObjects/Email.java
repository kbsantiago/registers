package br.com.soft.registers.domain.valueObjects;
import org.apache.commons.validator.routines.EmailValidator;

public class Email {

    private String address;

    public Email() { };

    public Email(String address) {
        this.address = address;
    }

    public boolean isValid() {
        if(address.isEmpty())
            return true;
        else {
            EmailValidator validator = EmailValidator.getInstance();
            return validator.isValid(address);
        }
    }

    public String getAddress() {
        return address;
    }
}
