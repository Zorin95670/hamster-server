CREATE TABLE IF NOT EXISTS user_tokens (
    ust_id           SERIAL PRIMARY KEY,
    usr_id           uuid REFERENCES users(usr_id) ON DELETE CASCADE NOT NULL UNIQUE,
    token            VARCHAR NOT NULL UNIQUE,
    expiration_date  TIMESTAMP NOT NULL,
    insert_date      TIMESTAMP NOT NULL DEFAULT now(),
    update_date      TIMESTAMP NOT NULL DEFAULT now()
);

COMMENT ON COLUMN user_tokens.ust_id          IS 'Primary key, uuid, reference to user id.';
COMMENT ON COLUMN user_tokens.usr_id          IS 'Reference to user id.';
COMMENT ON COLUMN user_tokens.token           IS 'Token for access.';
COMMENT ON COLUMN user_tokens.expiration_date IS 'Expiration date of the token.';
COMMENT ON COLUMN user_tokens.insert_date     IS 'Creation date of this row.';
COMMENT ON COLUMN user_tokens.update_date     IS 'Last update date of this row.';
