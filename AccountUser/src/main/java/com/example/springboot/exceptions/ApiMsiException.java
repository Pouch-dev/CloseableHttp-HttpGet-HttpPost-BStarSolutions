package com.example.springboot.exceptions;

import java.util.Map;

public interface ApiMsiException {

    Map<String, String> getConfigGroup(String key);


}
