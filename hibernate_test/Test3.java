// Запросы с условиями:

package hibernate_test;

import hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Test3 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class).buildSessionFactory();
        Session session = null;
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();
            List<Employee> emps = session.createQuery("from Employee").getResultList();
            List<Employee> emps1 = session.createQuery("from Employee " + "where name = 'Сергей' and salary > 500")
                    .getResultList();
            for (Employee e: emps)
                System.out.println(e);
            System.out.println("");
            for (Employee e: emps1)
                System.out.println(e);
            session.getTransaction().commit();
            System.out.println("Done");
        }
        finally {
            session.close();
            factory.close();
        }
    }
}
