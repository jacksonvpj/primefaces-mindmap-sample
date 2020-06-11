package br.com.motivo.aristoteles.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import java.io.Serializable;

@ManagedBean(name = "helloworld")
@ViewScoped
public class HelloWorldBean implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public String getMessage() {
        return "Hello World from Fuertefentura";
    }

}
