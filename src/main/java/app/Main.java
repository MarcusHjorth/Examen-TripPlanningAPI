package app;

import app.config.AppConfig;
import app.config.Populate;
import app.utils.ApiProperties;

public class Main {
    public static void main(String[] args) {
        AppConfig.startServer(ApiProperties.PORT);
        Populate.main(args);
    }
}