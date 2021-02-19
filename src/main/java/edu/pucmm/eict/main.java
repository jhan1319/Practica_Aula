package edu.pucmm.eict;

import io.javalin.Javalin;

import java.util.concurrent.atomic.AtomicBoolean;

public class main {

    public static void main(String[] args){

        String usuario = null;

        Javalin app = Javalin.create(config -> {
            //set configs
            config.addStaticFiles("/Public");

        }).start(7000);

        app.before( "/",ctx -> {

            if(ctx.sessionAttribute("usuario") == null){

                ctx.redirect("/Login.html");
            }

                }

        );

        app.get("/", ctx -> {
            ctx.redirect("/pagina.html");
        });

        app.post("/Login", ctx -> {

           String user = ctx.formParam("uname");
            String pass = ctx.formParam("psw");

            System.out.printf("ESTE ES EL USER INGRESADO"+user);

            if((user).contentEquals("admin") && (pass).contentEquals("admin")){
                ctx.sessionAttribute("usuario", user);
                ctx.redirect("/");
            }






        });

    }
}
