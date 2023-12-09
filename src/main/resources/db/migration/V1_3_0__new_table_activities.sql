CREATE TABLE IF NOT EXISTS activities (
    act_id           uuid PRIMARY KEY DEFAULT uuid_generate_v4(),
    usr_id           uuid REFERENCES users(usr_id) ON DELETE CASCADE NOT NULL,
    name             VARCHAR(255) NOT NULL,
    description      TEXT,
    link             TEXT,
    start_date       TIMESTAMP,
    end_date         TIMESTAMP,
    insert_date      TIMESTAMP NOT NULL DEFAULT now(),
    update_date      TIMESTAMP NOT NULL DEFAULT now()
);

COMMENT ON COLUMN activities.act_id      IS 'Primary key, uuid.';
COMMENT ON COLUMN activities.usr_id      IS 'Foreign key to users table, uuid.';
COMMENT ON COLUMN activities.name        IS 'Activity name.';
COMMENT ON COLUMN activities.description IS 'Activity description, markdown authorized.';
COMMENT ON COLUMN activities.link        IS 'Activity link, (github, jira, ...).';
COMMENT ON COLUMN activities.start_date  IS 'Start date of this activity.';
COMMENT ON COLUMN activities.end_date    IS 'End date of this activity.';
COMMENT ON COLUMN activities.insert_date IS 'Creation date of this row.';
COMMENT ON COLUMN activities.update_date IS 'Last update date of this row.';
