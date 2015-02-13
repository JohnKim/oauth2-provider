package com.porterhead.oauth2;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import javax.persistence.AttributeConverter;

import org.springframework.security.oauth2.common.OAuth2AccessToken;

public class OAuth2AccesTokenConverter implements
		AttributeConverter<OAuth2AccessToken, String> {

	@Override
	public String convertToDatabaseColumn(OAuth2AccessToken token) {
		ByteArrayOutputStream st = new ByteArrayOutputStream();
		XMLEncoder e = new XMLEncoder(st);
		e.writeObject(token);
		e.close();
		return st.toString();
	}

	@Override
	public OAuth2AccessToken convertToEntityAttribute(String token) {
		ByteArrayInputStream is = new ByteArrayInputStream(token.getBytes());
		XMLDecoder e = new XMLDecoder(is);
		OAuth2AccessToken t = (OAuth2AccessToken) e.readObject();
		e.close();
		return t;
	}
}
