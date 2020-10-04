package org.primefaces.test;

import java.util.Collection;

import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.omnifaces.converter.ToCollectionConverter;

@FacesConverter(forClass = Collection.class)
public class ImplicitToCollectionConverter extends ToCollectionConverter implements Converter<Collection> {

}
