package com.ty.prop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ReadConfig {

	@Value(value = "${db.url}")
	private String url;

	@Value(value = "${db.username}")
	private String user;

	@Value(value = "${db.pwd}")
	private String pwd;

	@Value(value = "${secret.key}")
	private String secrete;

	public String getUrl() {
		return url;
	}

	public String getUser() {
		return user;
	}

	public String getPwd() {
		return pwd;
	}

	public String getSecrete() {
		return secrete;
	}

}
