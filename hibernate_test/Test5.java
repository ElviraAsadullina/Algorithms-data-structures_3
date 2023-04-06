// Удаление сотрудников:

package hibernate_test;

import hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test5 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class).buildSessionFactory();
        Session session = null;
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();

            // Удалить данные по одному сотруднику:
            Employee emp = session.get(Employee.class, 5);
            session.delete(emp);

            // Удалить данные сразу по нескольким сотрудникам и/или по условию:
            session.createQuery("delete Employee " + "where name = 'Сергей'").executeUpdate();

            session.getTransaction().commit();
            System.out.println("Done");
        }
        finally {
            session.close();
            factory.close();
        }
    }
}
