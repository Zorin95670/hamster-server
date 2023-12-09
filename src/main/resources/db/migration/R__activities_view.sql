-- Ensure repeatable migration is really repeated on every start
-- ${flyway:timestamp}

DROP VIEW IF EXISTS activities_view;

CREATE VIEW activities_view AS
SELECT
    activities.act_id      AS "act_id",
    activities.usr_id      AS "usr_id",
    activities.name        AS "name",
    activities.description AS "description",
    activities.link        AS "link",
    activities.start_date  AS "start_date",
    activities.end_date    AS "end_date",
    activities.insert_date AS "insert_date",
    activities.update_date AS "update_date",
    CASE WHEN COUNT(tags.id) > 0
    THEN json_agg(tags)::text
    ELSE '[]' END          AS "tags"
FROM
    activities
LEFT OUTER JOIN
    activity_tags
ON
    activity_tags.act_id = activities.act_id
LEFT OUTER JOIN (
        SELECT
            tag_id as "id",
            name,
            background_color as "backgroundColor",
            text_color as "textColor"
        FROM
            tags
        ORDER BY
            name
    ) tags
ON
    tags.id = activity_tags.tag_id
GROUP BY
    activities.act_id;