import entities.Product;

import javax.persistence.EntityManager;

import javax.persistence.Persistence;
import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {

        EntityManager entityManager = Persistence.createEntityManagerFactory("sales")
                .createEntityManager();

        entityManager.getTransaction().begin();
        Product product = new Product();
        product.setName("test");
        product.setPrice(BigDecimal.TEN);
        product.setQuantity(5);


        entityManager.getTransaction().commit();

    }
}
