package domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//@Entity
//@SequenceGenerator(
//        name="MEMBER_SEQ_GENERATOR",
//        sequenceName = "MEMBER_SEQ", //매핑할 데이터베이스 시퀀스 이름
//        initialValue = 1, allocationSize = 50
//)
/*@TableGenerator(
        name="MEMBER_SEQ_GENERATOR",
        table = "MY_SEQUENCES",
        pkColumnValue = "MEMBER_SEQ", allocationSize = 1
)*/
//@Table(name = "Member")
@Getter @Setter
public class Member extends BaseEntity {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //권장 : Long형 + 대체키 + 키 생성전략
    /*@GeneratedValue(strategy = GenerationType.TABLE,
            generator = "MEMBER_SEQ_GENERATOR")*/
//    @GeneratedValue(strategy = GenerationType.SEQUENCE,
//            generator = "MEMBER_SEQ_GENERATOR")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String username;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team team;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "locker_id")
    private Locker locker;

    //기간 Period
    @Embedded
    private Period workPeriod;

    //주소
    @Embedded
    private Address homeAddress;

    /**
     * 한 엔티티 에서 같은 값 타입 사용 시
     */
    /*@Embedded
    @AttributeOverrides({
            @AttributeOverride(name="city",
                    column=@Column(name = "work_city")),
            @AttributeOverride(name="street",
                    column=@Column(name = "work_street")),
            @AttributeOverride(name="zipcode",
                    column=@Column(name = "work_zipcode")),
    })
    private Address workAddress;*/

    @ElementCollection
    @CollectionTable(name = "favorite_food", joinColumns =
        @JoinColumn(name = "member_id")
    )
    @Column(name = "food_name") // 예외적
    private Set<String> favoriteFoods = new HashSet<>();

    /**
     * 변경 사항이 발생하면, 해당 member_id 모두 삭제한 이후에
     * 모두 Insert 함
     * 되도록 사용하지 말자..
     *
     * @ElementCollection
     * @CollectionTable(name = "address", joinColumns =
     * @JoinColumn(name = "member_id")
     * )
     * private List<Address> addressHistory = new ArrayList<>();
     */

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "member_id")
    private List<AddressEntity> addressHistory = new ArrayList<>();


    // 연관 관계 편의 메서드
    public void changeTeam(Team team) {
        this.team = team;
        team.getMembers().add(this);
    }

    /*
    private Integer age;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

//    @Temporal(TemporalType.TIMESTAMP)
    private LocalDate createDate;

//    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime lastModifiedDate;

    @Lob
    private String description;

    public Member() {
    }

    public Member(Long id, String username, Integer age, RoleType roleType, LocalDate createDate, LocalDateTime lastModifiedDate, String description) {
        this.id = id;
        this.username = username;
        this.age = age;
        this.roleType = roleType;
        this.createDate = createDate;
        this.lastModifiedDate = lastModifiedDate;
        this.description = description;
    }*/
}
