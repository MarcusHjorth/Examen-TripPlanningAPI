package app.controller.impl;


import app.exceptions.ApiException;
import app.exceptions.Message;
import io.javalin.http.Context;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExceptionController {

    private final Logger log = LoggerFactory.getLogger(ExceptionController.class);

    public void apiExceptionsHandler(ApiException e, Context ctx) {
        log.error("{},{}", ctx.res().getStatus(), e.getMessage());
        ctx.status(e.getStatusCode());
        ctx.json(new Message(e.getStatusCode(), e.getMessage()));

    }


}

