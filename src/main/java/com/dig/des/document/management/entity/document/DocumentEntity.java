package com.dig.des.document.management.entity.document;

import com.dig.des.document.management.entity.audit.PersistOpsAuthorRecordingEntity;
import lombok.*;
import org.hibernate.envers.Audited;
import org.springframework.data.history.RevisionMetadata;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "document")
@Audited
@Data
@EqualsAndHashCode(callSuper = false, of = {"id"})
@NoArgsConstructor
@AllArgsConstructor
public class DocumentEntity extends PersistOpsAuthorRecordingEntity<Long> {
    @Id
    @Column(name = "id", updatable = false)
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Basic(optional = false)
    @Column(name = "title", nullable = false)
    @NotNull
    private String title;

    // TODO: 13.04.2021 может быть null'ом?
    @Basic
    @Column(name = "description")
    private String description;

    @Basic(optional = false)
    @Column(name = "priority", nullable = false)
    @Enumerated(value = EnumType.STRING)
    @NotNull
    private Priority priority;

    private static enum Priority {
        LOW, MEDIUM, HIGH
    }

    @ManyToOne(optional = false)
    @JoinColumn(name = "catalog_id", nullable = false)
    @NonNull
    private CatalogEntity catalog;

    @Transient
    private RevisionMetadata<Long> version;
}
