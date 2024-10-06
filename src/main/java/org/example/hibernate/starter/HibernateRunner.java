package org.example.hibernate.starter;

import org.example.hibernate.starter.entity.Role;
import org.example.hibernate.starter.entity.User;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;

public class HibernateRunner
{
    public static void main( String[] args )
    {
        Configuration config = new Configuration();
        config.configure( "hibernate.cfg.xml" );
        config.addAnnotatedClass(User.class);
        try(var sessionFactory = config.buildSessionFactory(); var session = sessionFactory.openSession();)
        {
            session.beginTransaction();
            User user = User.builder()
                    .username("egor1@mail.ru")
                    .firstname("Egor")
                    .lastname("Balashenko")
                    .birthDate(LocalDate.of(2005, 05, 18))
                    .age(19)
                    .role(Role.ADMIN).build();
            //session.save(user);
            //session.delete(user);
            session.get(User.class, "egor1@mail.ru");
            System.out.println(user);
            session.getTransaction().commit();

        }

    }
}
