// Изменение данных по одному или нескольким сотрудникам:

package hibernate_test;

import hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Test4 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class).buildSessionFactory();
        Session session = null;
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();

            // Изменить данные по одному сотруднику:
            Employee emp = session.get(Employee.class, 1);
            emp.setSalary(550);

            // Изменить данные сразу по нескольким сотрудникам и/или по условию:
            session.createQuery("update Employee set salary = 1000" + "where name = 'Сергей'").executeUpdate();

            session.getTransaction().commit();
            System.out.println("Done");
        }
        finally {
            session.close();
            factory.close();
        }
    }
}
