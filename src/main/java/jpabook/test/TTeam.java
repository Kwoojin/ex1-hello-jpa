package jpabook.test;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//@Entity
@Getter @Setter
public class TTeam {

    @Id
    @GeneratedValue
    @Column(name = "team_id")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "team")
    private List<TestMember> members = new ArrayList<>();

    /*public void addMember(TestMember member) {
        member.setTeam(this);
        members.add(member);
    }*/
}
