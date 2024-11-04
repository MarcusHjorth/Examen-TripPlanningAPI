package app.routes;

import app.controller.impl.TripController;
import app.security.enums.Role;
import io.javalin.apibuilder.EndpointGroup;

import static io.javalin.apibuilder.ApiBuilder.*;

public class TripRoute {

    private final TripController tripController = new TripController();

    protected EndpointGroup getTripRoutes() {
        return () -> {
            //CRUD
            get("/", tripController::readAll, Role.ANYONE);
            get("/{id}", tripController::read, Role.ANYONE);
            post("/", tripController::create, Role.ANYONE);
            put("/{id}", tripController::update, Role.ANYONE);
            delete("/{id}", tripController::delete, Role.ANYONE);
            //Custom

        };
    }
}
