package br.com.soft.registers.domain.valueObjects;

import br.com.caelum.stella.validation.CPFValidator;

public class Cpf {

    private String code;

    private CPFValidator validator;

    public Cpf() { };

    public Cpf(String code) {
        this.code = code;
    }

    public boolean isValid() {
        try
        {
            validator = new CPFValidator();
            validator.assertValid(code);
            return true;
        } catch(Exception ex) {
            return false;
        }
    }

    public String getCode() {
        return code.replace(".","").replace("-", "");
    }
}
