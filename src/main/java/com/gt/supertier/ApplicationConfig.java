package com.gt.supertier;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.annotation.FacesConfig;
import javax.security.enterprise.authentication.mechanism.http.CustomFormAuthenticationMechanismDefinition;
import javax.security.enterprise.authentication.mechanism.http.LoginToContinue;
import javax.security.enterprise.identitystore.DatabaseIdentityStoreDefinition;

import static javax.faces.annotation.FacesConfig.Version.*;

@DatabaseIdentityStoreDefinition(
        dataSourceLookup = "supertier-app",
        callerQuery = "select password_hash from users where username = ?",
        groupsQuery = "SELECT g.name FROM groups g " +
                "INNER JOIN users_groups ug ON g.id = ug.groups_id " +
                "WHERE ug.user_id =(SELECT person_id FROM users WHERE username = ?)",
        hashAlgorithm = BCryptHash.class

)
@CustomFormAuthenticationMechanismDefinition(
        loginToContinue = @LoginToContinue(loginPage="/login.xhtml",errorPage="")
)
@FacesConfig(version = JSF_2_3)
@ApplicationScoped
public class ApplicationConfig {


}
