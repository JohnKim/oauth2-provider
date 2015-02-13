package com.porterhead.oauth2;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import javax.persistence.AttributeConverter;

import org.springframework.security.oauth2.provider.OAuth2Authentication;

public class OAuth2AuthenticationConverter implements
		AttributeConverter<OAuth2Authentication, String> {

	@Override
	public String convertToDatabaseColumn(OAuth2Authentication auth) {
		ByteArrayOutputStream st = new ByteArrayOutputStream();
		XMLEncoder e = new XMLEncoder(st);
		e.writeObject(auth);
		e.close();
		return st.toString();
	}

	@Override
	public OAuth2Authentication convertToEntityAttribute(String token) {
		ByteArrayInputStream is = new ByteArrayInputStream(token.getBytes());
		XMLDecoder e = new XMLDecoder(is);
		OAuth2Authentication t = (OAuth2Authentication) e.readObject();
		e.close();
		return t;
	}
}
