package RouteTest;

import Populator.Populator;
import app.config.HibernateConfig;
import app.daos.impl.TripDAO;
import app.enums.Category;
import io.javalin.Javalin;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jdk.jfr.Name;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import app.dtos.TripDTO;

import app.config.AppConfig;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class RoutesTripsTest {
    private static Javalin app;
    private static final EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryForTest();
    private static final TripDAO dao = TripDAO.getInstance(emf);
    private static final Populator populator = new Populator(emf, dao);
    private static final String BASE_URL = "http://localhost:7077/api/trip";

    private static TripDTO t1DTO, t2DTO;

    @BeforeAll
    static void beforeAll() {
        app = AppConfig.startServer(7077);
    }

    @BeforeEach
    void setUp() {
        populator.populateDataBase();

        t1DTO = dao.readAll().get(0);
        t2DTO = dao.readAll().get(1);
    }

    @AfterEach
    void tearDown() {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.createQuery("DELETE FROM Guide").executeUpdate();
            em.createQuery("DELETE FROM Trip").executeUpdate();
            em.getTransaction().commit();
        }
    }

    @AfterAll
    static void afterAll() {
        AppConfig.stopServer(app);
    }

    @Test
    @Name("GET getById")
    void getByID() {
        TripDTO tripDTO =
                given()
                        .when()
                        .get(BASE_URL + "/" + t1DTO.getId())
                        .then()
                        .log().all()
                        .statusCode(200)
                        .extract()
                        .as(TripDTO.class);
        assertThat(tripDTO, is(equalTo(t1DTO)));
    }


    @Test
    @Name("POST create")
    void create() {
        TripDTO newTrip = new TripDTO("14:00","16:00", "Denmark", "Enjoy the rain", 200.0, Category.CITY);
        TripDTO created =
                given()
                        .contentType("application/json")
                        .body(newTrip)
                        .when()
                        .post(BASE_URL)
                        .then()
                        .log().all()
                        .statusCode(201)
                        .extract()
                        .as(TripDTO.class);
        assertThat(created.getName(), equalTo(newTrip.getName()));
    }
}
