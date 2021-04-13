CREATE TABLE IF NOT EXISTS document
(
    id         BIGSERIAL PRIMARY KEY,
    /* Persist ops author recoding */
    created_by BIGINT DEFAULT 0,
    updated_by BIGINT DEFAULT 0
);

CREATE TABLE IF NOT EXISTS file
(
    id          BIGSERIAL PRIMARY KEY,
    document_id BIGINT NOT NULL,
    CONSTRAINT fk_file__document__many_to_one_constraint
        FOREIGN KEY (document_id)
            REFERENCES document (id),
    /* TODO это аналог блоба? Как это правильно организоавть? */
    file        BYTEA  NOT NULL,
    /* Persist ops author recoding */
    created_by  BIGINT DEFAULT 0,
    updated_by  BIGINT DEFAULT 0
);

CREATE TABLE IF NOT EXISTS user_document
(
    user_id     BIGINT NOT NULL,
    CONSTRAINT fk_user_product__user__many_to_many_constraint
        FOREIGN KEY (user_id)
            REFERENCES "user" (id),
    document_id BIGINT NOT NULL,
    CONSTRAINT fk_user_product__product__many_to_many_constraint
        FOREIGN KEY (document_id)
            REFERENCES document (id)
);

CREATE TABLE IF NOT EXISTS document_document_category
(
    document_id          BIGINT NOT NULL,
    CONSTRAINT fk_document_document_category__product__many_to_many_constraint
        FOREIGN KEY (document_id)
            REFERENCES document (id),
    document_category_id BIGINT NOT NULL,
    CONSTRAINT fk_document_document_category__product_category__many_to_many_constraint
        FOREIGN KEY (document_category_id)
            REFERENCES document_category (id)
);