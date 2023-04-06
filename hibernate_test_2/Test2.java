// Работа с двумя связанными таблицами (связ по типу "One to one" bi-directional(двусторонняя)):

package hibernate_test_2;

import hibernate_test_2.entity.Detail;
import hibernate_test_2.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test2 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();
        Session session = null;

        // Создание сотрудника и его деталей с двусторонней связкой:
        try {
            session = factory.getCurrentSession();
            Employee employee = new Employee("Степан", "Винтиков", "MD", 320);
            Detail detail = new Detail ("Ufa", "126", "vintikov@mail.ru");

            employee.setEmpDetail(detail);
            detail.setEmployee(employee);

            session.beginTransaction();
            session.save(detail);

            session.getTransaction().commit();
            System.out.println("Done");
        }
        finally {
            session.close();
            factory.close();
        }

        // Вывод данных сотрудника через его детали:
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();

            Detail detail = session.get(Detail.class, 4);
            System.out.println(detail.getEmployee());

            session.getTransaction().commit();
            System.out.println("Done");
        }
        finally {
            session.close();
            factory.close();
        }

        // Удаление сотрудника через его детали:
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();

            Detail detail = session.get(Detail.class, 5);
            session.delete(detail);

            session.getTransaction().commit();
            System.out.println("Done");
        }
        finally {
            session.close();
            factory.close();
        }
    }
}
