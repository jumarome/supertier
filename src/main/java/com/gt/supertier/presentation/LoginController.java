package com.gt.supertier.presentation;

import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.security.enterprise.AuthenticationStatus;
import javax.security.enterprise.SecurityContext;
import javax.security.enterprise.authentication.mechanism.http.AuthenticationParameters;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;
import java.io.IOException;

import static javax.security.enterprise.AuthenticationStatus.SEND_CONTINUE;
import static javax.security.enterprise.AuthenticationStatus.SEND_FAILURE;


@Model
public class LoginController {
    @Inject
    private SecurityContext securityContext;

    @Inject
    private ExternalContext externalContext;

    @Inject
    private FacesContext facesContext;

    @NotNull
    private String username;

    @NotNull
    private String password;

    public void login() throws IOException {
        HttpServletRequest servletRequest = (HttpServletRequest) externalContext.getRequest();
        HttpServletResponse servletResponse = (HttpServletResponse) externalContext.getResponse();
        UsernamePasswordCredential usernamePasswordCredential = new UsernamePasswordCredential(username,password);
        AuthenticationParameters authenticationParameters = AuthenticationParameters.withParams().credential(usernamePasswordCredential);
        AuthenticationStatus authenticationStatus = securityContext.authenticate(servletRequest,servletResponse,authenticationParameters);
        if(authenticationStatus.equals(SEND_CONTINUE))
            facesContext.responseComplete();

        else if(authenticationStatus.equals(SEND_FAILURE)){
            FacesMessage facesMessage = new FacesMessage("Usuario y/o contraseña inválido");
            facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
            facesContext.addMessage(null,facesMessage);
        }

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void checkAuthentication() throws IOException {
        if(securityContext.getCallerPrincipal()!=null)
            externalContext.redirect(externalContext.getRequestContextPath() + "/index.xhtml");
    }

}
