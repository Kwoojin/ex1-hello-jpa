package jpabook.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class TestMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{
            System.out.println("======== TeamA 등록 ========");
            TestTeam teamA = new TestTeam();
            teamA.setName("TeamA");
            em.persist(teamA);

            System.out.println("======== TeamB 등록 ========");
            TestTeam teamB = new TestTeam();
            teamB.setName("TeamB");
            em.persist(teamB);


            System.out.println("======== member1 등록 ========");
            TestMember testMember = new TestMember();
            testMember.setUsername("member1");
            testMember.changeTeam(teamA);
            em.persist(testMember);

            System.out.println("======== member2 등록 ========");
            TestMember testMember2 = new TestMember();
            testMember2.setUsername("member2");
            testMember2.changeTeam(teamA);
            em.persist(testMember2);

//            teamA.addMember(testMember2);

//            System.out.println("======== member2 팀 변경 ========");
//            testMember2.setTeam(teamB);

            em.flush();
            em.clear();

            System.out.println("======== 데이터 조회 ========");
            TestMember findMember = em.find(TestMember.class, testMember.getId());
            List<TestMember> members = findMember.getTeam().getMembers();

//            members.add(testMember2);
            em.flush();
            em.clear();

            findMember = em.find(TestMember.class, testMember.getId());
            members = findMember.getTeam().getMembers();

            System.out.println("======== 출력 ========");
            members
                    .stream()
                    .forEach((member) -> {
                        System.out.println("memberId = " + member.getId());
                    });

/*
            Member member = new Member(1l, "member", 30, RoleType.ADMIN, Date.valueOf(LocalDate.now()), Date.valueOf(LocalDate.now()), "관리자");
            member.setId(4L);
            member.setName("memberB");
            em.persist(member);
*/

//            em.detach(member);

//            Member findMember = em.find(Member.class, 1L);
//            findMember.setName("memberB");
//
//            List<Member> result = em.createQuery("select m from Member m", Member.class)
//                    .setMaxResults(3)
//                    .getResultList();
//
//            result.stream().forEach(member -> {
//                System.out.println("{ " + member.getId() + ", " + member.getName() + " }");
//            });

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
