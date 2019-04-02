package com.security.javaclient;

import com.security.model.StudenteEnty;

public class JavaSpringClientTest {
    public static void main(String[] args) {

        //Teste os methodos do reste template
        StudenteEnty studentePost = new StudenteEnty();
        studentePost.setName("John Wick2");
        studentePost.setEmail("john@pencil.com");

        JavaClientDAO dao = new JavaClientDAO();

        //System.out.println(dao.save(studentePost));

//        System.out.println(dao.findById(1));
//        System.out.println(dao.listAll());


//        List<StudenteEnty> studenteEnties = dao.listAll();
//        System.out.println(studenteEnties);


//        studentePost.setId(7L);
//        dao.update(studentePost);
//        dao.delete(201);

    }

}
