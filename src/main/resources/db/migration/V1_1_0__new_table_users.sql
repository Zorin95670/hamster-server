CREATE TABLE IF NOT EXISTS users (
    usr_id           uuid PRIMARY KEY,
    google_id        VARCHAR(255) NOT NULL UNIQUE,
    email            VARCHAR(255) NOT NULL UNIQUE,
    first_name       VARCHAR(255),
    last_name        VARCHAR(255),
    picture          TEXT,
    insert_date      TIMESTAMP NOT NULL DEFAULT now(),
    update_date      TIMESTAMP NOT NULL DEFAULT now()
);

COMMENT ON COLUMN users.usr_id      IS 'Primary key, uuid.';
COMMENT ON COLUMN users.google_id   IS 'Id of google user.';
COMMENT ON COLUMN users.email       IS 'User email.';
COMMENT ON COLUMN users.first_name  IS 'User first name.';
COMMENT ON COLUMN users.last_name   IS 'User last name.';
COMMENT ON COLUMN users.picture     IS 'Url of user picture.';
COMMENT ON COLUMN users.insert_date IS 'Creation date of this row.';
COMMENT ON COLUMN users.update_date IS 'Last update date of this row.';
