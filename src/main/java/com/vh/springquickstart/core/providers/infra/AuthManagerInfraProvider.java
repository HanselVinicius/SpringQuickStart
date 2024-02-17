package com.vh.springquickstart.core.providers.infra;

public interface AuthManagerInfraProvider {

    String authenticate(String username, String password);
}
