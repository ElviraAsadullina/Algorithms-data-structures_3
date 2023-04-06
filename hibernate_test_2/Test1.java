// Работа с двумя связанными таблицами (связ по типу "One to one" Uni-directional(односторонняя)):

package hibernate_test_2;

import hibernate_test_2.entity.Detail;
import hibernate_test_2.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();
        Session session = null;

        // Создаем нового сотрудника и крепим к нему Details:
        try {
            session = factory.getCurrentSession();
            Employee employee = new Employee("Сергей", "Иванов", "IT", 600);
            Detail detail = new Detail ("Ufa", "123", "ivanov@mail.ru");
            employee.setEmpDetail(detail);
            session.beginTransaction();
            session.save(employee);

            session.getTransaction().commit();
            System.out.println("Done");
        }
        finally {
            session.close();
            factory.close();
        }

        // Создаем второго сотрудника и крепим к нему Details:
        try {
            session = factory.getCurrentSession();
            Employee employee = new Employee("Олег", "Свиридов", "HR", 300);
            Detail detail = new Detail ("Ufa", "124", "sviridov@mail.ru");
            employee.setEmpDetail(detail);
            session.beginTransaction();
            session.save(employee);

            session.getTransaction().commit();
            System.out.println("Done");
        }
        finally {
            session.close();
            factory.close();
        }

        // Вызываем из базы сотрудника и удаляем его:
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();

            Employee emp = session.get(Employee.class, 2);
            session.delete(emp);


            session.getTransaction().commit();
            System.out.println("Done");
        }
        finally {
            session.close();
            factory.close();
        }
    }
}
