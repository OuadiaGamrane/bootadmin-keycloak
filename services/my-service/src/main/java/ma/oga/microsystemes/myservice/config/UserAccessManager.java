package ma.oga.microsystemes.myservice.config;

import org.springframework.stereotype.Component;

@Component
public class UserAccessManager {

    public boolean hasRole(String role) {
        // if u want to manage roles
        return true;
    }

}
