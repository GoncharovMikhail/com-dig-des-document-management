package com.dig.des.document.management.entity.document;

import com.dig.des.document.management.entity.audit.PersistOpsAuthorRecordingEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;
import org.springframework.data.history.RevisionMetadata;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "catalog"/* , schema = "public" */)
@Audited
@Data
@EqualsAndHashCode(callSuper = false, of = {"id"})
@NoArgsConstructor
@AllArgsConstructor
public class CatalogEntity extends PersistOpsAuthorRecordingEntity<Long> {
    @Id
    @Column(name = "id", updatable = false)
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Basic(optional = false)
    @Column(name = "title", nullable = false, unique = true)
    @NotBlank
    private String title;

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<DocumentEntity> documents;

    /* TODO: 13.04.2021 два следующих поля - полнейший ужас.
        Разве хранить такие сложные конструкции в реляционной бд - хорошая идея?
        https://thorben-janssen.com/self-referencing-associations/ - оттуда взял пример. */
    @ManyToOne(fetch = LAZY)
    private CatalogEntity parentId;

    @OneToMany(mappedBy = "parent_id")
    private Set<CatalogEntity> subCatalogs;

    @Transient
    private RevisionMetadata<Long> version;

    public CatalogEntity addSubCatalog(CatalogEntity subCatalog) {
        this.subCatalogs.add(subCatalog);
        subCatalog.setParentId(this);
        return subCatalog;
    }
}
