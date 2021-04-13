package com.dig.des.document.management.entity.document;

import com.dig.des.document.management.entity.audit.PersistOpsAuthorRecordingEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;
import org.springframework.data.history.RevisionMetadata;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "file"/* , schema = "public" */)
@Audited
@Data
@EqualsAndHashCode(callSuper = false, of = {"id"})
@NoArgsConstructor
@AllArgsConstructor
public class FileEntity extends PersistOpsAuthorRecordingEntity<Long> {
    @Id
    @Column(name = "id", updatable = false)
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    // TODO: 13.04.2021 ???? Блобы это плохо =(
    @Lob
    @Basic(optional = false)
    @Column(name = "file", nullable = false, columnDefinition = "BLOB NOT NULL")
    @NotNull
    private byte[] file;

    @ManyToOne(optional = false)
    @JoinColumn(name = "document_id", nullable = false)
    @NotNull
    private DocumentEntity document;

    @Transient
    private RevisionMetadata<Long> version;
}
