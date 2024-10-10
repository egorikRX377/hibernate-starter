package org.example.hibernate.starter;

import lombok.extern.slf4j.Slf4j;
import org.example.hibernate.starter.entity.PersonalInfo;
import org.example.hibernate.starter.entity.Role;
import org.example.hibernate.starter.entity.User;

import java.time.LocalDate;


@Slf4j
public class HibernateRunner
{

    public static void main( String[] args )
    {
        try(var sessionFactory = HibernateUtil.getSessionFactory(); var session = sessionFactory.openSession())
        {
//            User user = User.builder()
//                    .username("egor1@mail.ru")
//                    .firstname("Egor")
//                    .lastname("Balashenko")
//                    .birthDate(LocalDate.of(2005, 5, 18))
//                    .age(19)
//                    .role(Role.ADMIN).build();
            //session.save(user);
            //session.delete(user);
            session.beginTransaction();
            User user1 = User.builder()
                    .username("masha21000@gmail.com")
                    .personalInfo(PersonalInfo.builder()
                            .firstName("Masha222")
                            .lastName("Belyakova333")
                            .birthDate(LocalDate.of(2004, 4, 19)).build())
                    .age(20)
                    .role(Role.USER).build();
            log.info("user1 is transient state");
            session.save(user1);


            session.getTransaction().commit();
        }

    }
}
