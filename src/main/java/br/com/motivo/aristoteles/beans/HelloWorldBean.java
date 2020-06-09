package br.com.motivo.aristoteles.beans;

import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named("helloworld")
@ViewScoped
public class HelloWorldBean implements Serializable {

    public String getMessage() {
        return "Hello World from Fuertefentura";
    }

}
