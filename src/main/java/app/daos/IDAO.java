package app.daos;

import java.util.List;

public interface IDAO<T, I> {
    List<T> readAll();
    T read(I i);                                                    // *) use streams
   // List<T> doctorBySpeciality(Speciality speciality);              // *) use streams
   // List<T> doctorByBirthdateRange(LocalDate from, LocalDate to);   // *) use streams
    T create(T t);
    T update(I i, T t);
    T delete(I i);
}
