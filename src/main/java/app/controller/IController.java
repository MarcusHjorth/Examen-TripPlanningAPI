package app.controller;

import io.javalin.http.Context;

public interface IController<T, D> {
    void read(Context ctx);
    void readAll(Context ctx);
    void create(Context ctx);
    void update(Context ctx);
    void getByBirthdateRange(Context ctx);
    void getBySpeciality(Context ctx);
    boolean validatePrimaryKey(D d);
    T validateEntity(Context ctx);
}
