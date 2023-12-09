CREATE TABLE IF NOT EXISTS tags (
    tag_id           uuid PRIMARY KEY DEFAULT uuid_generate_v4(),
    usr_id           uuid REFERENCES users(usr_id) ON DELETE CASCADE NOT NULL,
    name             VARCHAR(100) NOT NULL UNIQUE,
    background_color VARCHAR(50) NOT NULL,
    text_color       VARCHAR(50) NOT NULL,
    insert_date      TIMESTAMP NOT NULL DEFAULT now(),
    update_date      TIMESTAMP NOT NULL DEFAULT now()
);

COMMENT ON COLUMN tags.tag_id           IS 'Primary key, uuid.';
COMMENT ON COLUMN tags.usr_id           IS 'Foreign key to users table, uuid.';
COMMENT ON COLUMN tags.name             IS 'Tag name.';
COMMENT ON COLUMN tags.background_color IS 'Background color of tag.';
COMMENT ON COLUMN tags.text_color       IS 'Text color of tag.';
COMMENT ON COLUMN tags.insert_date      IS 'Creation date of this row.';
COMMENT ON COLUMN tags.update_date      IS 'Last update date of this row.';
