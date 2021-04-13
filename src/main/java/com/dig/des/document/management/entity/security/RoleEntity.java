package com.dig.des.document.management.entity.security;

import com.dig.des.document.management.entity.audit.PersistOpsAuthorRecordingEntity;
import com.dig.des.document.management.entity.user.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;
import org.springframework.data.history.RevisionMetadata;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "\"role\""/* , schema = "public" */)
@Audited
@Data
@EqualsAndHashCode(callSuper = false, of = {"id"})
@NoArgsConstructor
@AllArgsConstructor
public class RoleEntity extends PersistOpsAuthorRecordingEntity<Long> {
    @Id
    @Column(name = "id", updatable = false)
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Basic(optional = false)
    @Column(name = "role", unique = true, nullable = false)
    @NotBlank
    private String role;

    /* TODO: 13.04.2021 почему при generate-ddl: true  получаются дополнительные таблицы(которых не должно быть),
         с непонятными колонками?
         Чтоб этого избежать мне надо было сделать(почти) ктрл-ц + ктрл-в из UserEntity#roles поля */
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_role",
        joinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")},
        inverseJoinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")})
    private Set<UserEntity> users;

    @Transient
    private RevisionMetadata<Long> version;
}
