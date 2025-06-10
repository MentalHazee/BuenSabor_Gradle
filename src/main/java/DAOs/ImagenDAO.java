package DAOs;

import lombok.experimental.SuperBuilder;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import Entities.Imagen;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class ImagenDAO {

    public void cargarImagenEnDB(Imagen imagen){
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Imagen.class)
                .buildSessionFactory();

        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            System.out.println("Imagen guardada con ID: " + imagen.getId());
            session.persist(imagen);

            session.getTransaction().commit();

        }
        sessionFactory.close();
    }

    public void borrarImagenDeDB(Imagen imagen){
        // Configura Hibernate y crea la SessionFactory.
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Imagen.class)
                .buildSessionFactory();

        try (Session session = sessionFactory.openSession()) {
            // Abre una nueva sesión de Hibernate.
            session.beginTransaction();

            // Obtiene la imagen de la DB por su ID para asegurar que está gestionada.
            Imagen imagenToDelete = session.get(Imagen.class, imagen.getId());
            if (imagenToDelete != null) { // Verifica si la imagen fue encontrada.
                session.remove(imagenToDelete); // Marca la imagen para eliminación.
                System.out.println("Imagen con ID: " + imagen.getId() + " borrada exitosamente.");
            } else {
                System.out.println("No se encontró la imagen con ID: " + imagen.getId() + " para borrar.");
            }

            session.getTransaction().commit();

        } catch (Exception e) {
            // Captura y muestra errores durante la operación.
            System.err.println("Error al intentar borrar la imagen: " + e.getMessage());
        } finally {
            sessionFactory.close(); // Cierra la SessionFactory para liberar recursos.
        }
    }

}
