package br.com.projetos.gametracker.domain.validation.annotation;

import br.com.projetos.gametracker.domain.enumeration.Country;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CountryValidator implements ConstraintValidator<ValidCountry, String> {
    @Override
    public void initialize(ValidCountry constraintAnnotation) {}

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        var isValid = Country.isValidCountry(value);

        if(!isValid) {
            String supportedCountries = Stream.of(Country.values())
                                              .map(Country::getCode)
                                              .collect(Collectors.joining(", "));
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Invalid country code. Supported countries are: " +
                                                        supportedCountries)
                                                        .addConstraintViolation();
        }
        return isValid;
    }

}
