package jpabook.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestMain {

    public static void main(String[] args) {
/*
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{

            TestMember testMember = new TestMember();
            testMember.setUsername("TEST");
            System.out.println("================= start");
            em.persist(testMember);
            System.out.println("================= end");

*//*
            Member member = new Member(1l, "member", 30, RoleType.ADMIN, Date.valueOf(LocalDate.now()), Date.valueOf(LocalDate.now()), "관리자");
            member.setId(4L);
            member.setName("memberB");
            em.persist(member);
*//*

//            em.detach(member);

            *//*
            Member findMember = em.find(Member.class, 1L);
            findMember.setName("memberB");
            *//*

            *//*
            List<Member> result = em.createQuery("select m from Member m", Member.class)
                    .setMaxResults(3)
                    .getResultList();

            result.stream().forEach(member -> {
                System.out.println("{ " + member.getId() + ", " + member.getName() + " }");
            });
*//*

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.clear();
        }
        emf.close();*/
    }
}
