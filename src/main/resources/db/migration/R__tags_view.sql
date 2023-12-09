-- Ensure repeatable migration is really repeated on every start
-- ${flyway:timestamp}

DROP VIEW IF EXISTS tags_view;

CREATE VIEW tags_view AS
SELECT
    tags.tag_id           AS "tag_id",
    tags.usr_id           AS "usr_id",
    tags.name             AS "name",
    tags.background_color AS "background_color",
    tags.text_color       AS "text_color",
    tags.insert_date      AS "insert_date",
    tags.update_date      AS "update_date",
    activity_tags.count   AS "linked_activity"
FROM
    tags
LEFT OUTER JOIN (
    SELECT tag_id, count(*) as "count" from activity_tags group by tag_id
) AS activity_tags
ON
    activity_tags.tag_id = tags.tag_id;