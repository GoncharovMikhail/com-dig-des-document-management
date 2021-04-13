CREATE TABLE IF NOT EXISTS "catalog"
(
    id         BIGSERIAL PRIMARY KEY,
    /* Parent of current catalog.
     * For example, if we have catalog "work" with id=1 and it's sub-catalog "it" with id=2,
     * the parent_id will be 1  */
    parent_id  BIGINT,
    title      VARCHAR(255) NOT NULL UNIQUE,
    /* Persist ops author recoding */
    created_by BIGINT DEFAULT 0,
    updated_by BIGINT DEFAULT 0
);