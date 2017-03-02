package abd.p1;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import abd.p1.bd.UsuarioDAO;
import abd.p1.controller.Controlador;
import abd.p1.view.DialogLogin;

/**
 * Ésta es la clase que arranca la aplicación. La ejecución del método main()
 * no reconstruirá la base de datos. La base de datos se supone ya construida
 * por el método CreateDB.main()
 *
 */
public class Main {
    
    private static SessionFactory buildSessionFactory() {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure().build();
        try {
            return new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy(registry);
            return null;
        } 
    }
   
    public static void main(String[] args) {

        SessionFactory sf = null;
        
        try {
            sf = buildSessionFactory();
            UsuarioDAO udao = new UsuarioDAO(sf);
            Controlador c = new Controlador(udao, null);
            // Mostrar ventana de login y comprobar validez del usuario y contraseña.
            new DialogLogin (null, true, c);
            // Si son validos, mostrar ventana principal.    

        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            if (sf != null) {
            	System.out.println("SF cerrado!!");
            	sf.close();
            }
        }
    }

}
