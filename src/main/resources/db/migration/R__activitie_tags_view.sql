-- Ensure repeatable migration is really repeated on every start
-- ${flyway:timestamp}

DROP VIEW IF EXISTS activity_tags_view;

CREATE VIEW activity_tags_view AS
SELECT
    activity_tags.atg_id      AS "atg_id",
    activity_tags.act_id      AS "act_id",
    activity_tags.tag_id      AS "tag_id",
    activities.name           AS "activity_name",
    tags.name                 AS "tag_name",
    tags.background_color     AS "tag_background_color",
    tags.text_color           AS "tag_text_color",
    activity_tags.insert_date AS "insert_date",
    activity_tags.update_date AS "update_date"
FROM
    activity_tags
LEFT OUTER JOIN
    activities
ON
    activity_tags.act_id = activities.act_id
LEFT OUTER JOIN
    tags
ON
    activity_tags.tag_id = tags.tag_id;
