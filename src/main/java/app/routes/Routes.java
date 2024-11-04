package app.routes;

import io.javalin.apibuilder.EndpointGroup;

import static io.javalin.apibuilder.ApiBuilder.path;

public class Routes {

    private final TripRoute tripRoutes = new TripRoute();

    public EndpointGroup getApiRoutes() {

        return () -> {
            path("/trip", tripRoutes.getTripRoutes());
        };
    }
}