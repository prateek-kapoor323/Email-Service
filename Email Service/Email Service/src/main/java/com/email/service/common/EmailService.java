 package com.email.service.common;

import java.util.List;

public interface EmailService {
	    int send(List<String> to, String title, String body, String from);
	}