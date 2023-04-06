// Простые запросы:

package hibernate_test;

import hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test2 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class).buildSessionFactory();
        Session session = null;
        try {
            session = factory.getCurrentSession();
            Employee emp = new Employee("Елена", "Петрова", "Sales", 800);
            session.beginTransaction();
            session.save(emp);
            session.getTransaction().commit();

            int myId = emp.getId();
            session = factory.getCurrentSession();
            session.beginTransaction();
            Employee employee = session.get(Employee.class, myId);
            session.getTransaction().commit();
            System.out.println(employee);

            System.out.println("Done");
        }
        finally {
            session.close();
            factory.close();
        }

        /* можно в одной сессии совершать сразу несколько действий (создание сотрудника и получение его
        через get.Id: */
        try {
            session = factory.getCurrentSession();
            Employee emp = new Employee("Ольга", "Еременко", "PR", 300);
            session.beginTransaction();
            session.save(emp);

            int myId = emp.getId();
            Employee employee = session.get(Employee.class, myId);
            session.getTransaction().commit();
            System.out.println(employee);
            System.out.println("Done");
        }
        finally {
            session.close();
            factory.close();
        }
    }
}
