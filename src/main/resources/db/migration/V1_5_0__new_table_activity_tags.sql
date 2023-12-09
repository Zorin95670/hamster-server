CREATE TABLE IF NOT EXISTS activity_tags (
    atg_id      SERIAL PRIMARY KEY,
    act_id      uuid REFERENCES activities(act_id) ON DELETE CASCADE NOT NULL,
    tag_id      uuid REFERENCES tags(tag_id)       ON DELETE CASCADE NOT NULL,
    insert_date TIMESTAMP NOT NULL DEFAULT now(),
    update_date TIMESTAMP NOT NULL DEFAULT now(),
    CONSTRAINT  uc_activity_tags UNIQUE (act_id,tag_id)
);

COMMENT ON COLUMN activity_tags.atg_id      IS 'Primary key, uuid.';
COMMENT ON COLUMN activity_tags.act_id      IS 'Reference of activity id.';
COMMENT ON COLUMN activity_tags.tag_id      IS 'Reference of tag id.';
COMMENT ON COLUMN activity_tags.insert_date IS 'Creation date of this row.';
COMMENT ON COLUMN activity_tags.update_date IS 'Last update date of this row.';

COMMENT ON CONSTRAINT uc_activity_tags ON activity_tags IS 'Can not have same tags on one activity.';
