package DAOs;

import Entities.Empresa;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@Data
@Getter
@Setter
@NoArgsConstructor
public class EmpresaDAO {

    public void conectarDB(){
        SessionFactory sessionFactory = new Configuration() // Inicia la configuración de Hibernate.
                .configure("hibernate.cfg.xml") // Carga la configuración desde hibernate.cfg.xml.
                .addAnnotatedClass(Empresa.class) // Agrega la entidad Empresa para mapeo.
                .buildSessionFactory(); // Construye la fábrica de sesiones.

        try (Session session = sessionFactory.openSession()) { // Abre una nueva sesión de Hibernate (auto-cerrable).
            session.beginTransaction(); // Inicia una transacción de base de datos.

            //---- EMPRESA ----
            Empresa empresa = Empresa.builder()
                    .nombre("Mental") // Asigna el nombre.
                    .razonSocial("El Heredero de Dios") // Asigna la razón social.
                    .cuil(54584569) // Asigna el CUIL.
                    .build(); // Construye el objeto Empresa.
            System.out.println("Empresa guardada con ID: " + empresa.getId()); // Imprime el ID de la empresa guardada.
            session.persist(empresa); // Guarda la entidad Empresa en la base de datos. (Persist es preferido para nuevos objetos)

            Empresa empresa2 = Empresa.builder()
                    .nombre("Buen Sabor")
                    .razonSocial("Ricardini Empanadini")
                    .cuil(65431654)
                    .build();
            System.out.println("Empresa guardada con ID: " + empresa2.getId());
            session.persist(empresa2);

            session.getTransaction().commit(); // Confirma la transacción, guardando los cambios.

        } // La sesión se cierra automáticamente aquí gracias al try-with-resources.

        sessionFactory.close(); // Cierra la fábrica de sesiones al finalizar la aplicación.
    }

    public void cargarEmpresaEnDB(Empresa empresa){
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Empresa.class)
                .buildSessionFactory();

        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            System.out.println("Empresa guardada con ID: " + empresa.getId());
            session.persist(empresa);

            session.getTransaction().commit();

        }
        sessionFactory.close();
    }

}
