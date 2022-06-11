package jpabook.jpashop.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@SequenceGenerator(
        name="category_seq_generator",
        sequenceName = "category_seq",
        initialValue = 1, allocationSize = 50
)
public class Category extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_seq_generator")
    @Column(name = "category_id")
    private Long id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id", foreignKey = @ForeignKey(name = "fk_category_to_category"))
    private Category parent;

    /**
     * cascade
     * - Parent - Child 의 LifeCycle 이 완전 돌일 할 때
     * - Child 가 다른 Entity 에 연관 관계가 없고, Parent 에 완전 종속적일 때
     * > 사용 가능
     *
     * orphanRemoval
     * - 참조하는 곳이 하나일 때만 사용
     * - 특정 엔티티가 개인 소유할 때 사용
     * cascade = CascadeType.ALL, orphanRemoval = true
     * 두 옵션을 모두 활성화 하면 부모 엔티티를 통해서,
     * 자식의 생명 주기 관리 가능
     */

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Category> child = new ArrayList<>();

    /**
     * 테스트 하기 위해 굳이 만듦
     */
    @ManyToMany
    @JoinTable(name = "category_item",
            joinColumns = @JoinColumn(name = "category_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id"),
            foreignKey = @ForeignKey(name = "fk_categoryItem_to_category"),
            inverseForeignKey = @ForeignKey(name = "fk_categoryItem_to_item")
    )
    private List<Item> items = new ArrayList<>();
}
