import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    private static EntityManager entityManager;
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("softuni");
        entityManager = emf.createEntityManager();

        Engine engine = new Engine(entityManager);
        engine.run();
    }
}
