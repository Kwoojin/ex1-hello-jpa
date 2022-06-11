package domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;


/**
 * 상속관계 X
 * 엔티티 X테이블 x
 */
@MappedSuperclass   //공통
@Getter @Setter
public abstract class BaseEntity {

    private String createBy;
    private LocalDateTime createdDate;
    private String lastModifiedBy;
    private LocalDateTime lastModifiedDate;

}
