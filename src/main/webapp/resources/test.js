/* Place any Javascript here you want loaded in test.xhtml */
PrimeFaces.converter["halfup"] = {
    convert: function(element, submitValue) {
        const decimalValue = PrimeFaces.converter["javax.faces.BigDecimal"].convert(element, submitValue);
        return Math.round(decimalValue);
    }
};
// avoid error of #8385
PrimeFaces.locales['en'].messages['javax.faces.validator.LongRangeValidator.TYPE'] = '{0}: Validation Error: Value is not of the correct type.'
