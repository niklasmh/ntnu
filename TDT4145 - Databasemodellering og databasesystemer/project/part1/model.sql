CREATE SCHEMA IF NOT EXISTS diary;
USE diary;

CREATE TABLE IF NOT EXISTS workout (
  id                     INT               NOT NULL,
  name                   VARCHAR(45)       NOT NULL,
  description            VARCHAR(512)      NOT NULL,
  replacement_workout    INT                   NULL,
  PRIMARY KEY (id),
  INDEX fk_workout_workout_id (replacement_workout ASC),
  CONSTRAINT fk_workout_workout FOREIGN KEY (replacement_workout) REFERENCES workout (id)
);

CREATE TABLE IF NOT EXISTS session (
  id                     INT               NOT NULL AUTO_INCREMENT,
  start_datetime         DATETIME          NOT NULL,
  end_datetime           DATETIME          NOT NULL,
  preformance            TINYINT               NULL,
  shape                  TINYINT               NULL,
  note                   VARCHAR(45)           NULL,
  workout_id             INT               NOT NULL,
  PRIMARY KEY (id),
  INDEX fk_session_workout_id (workout_id ASC),
  CONSTRAINT fk_session_workout FOREIGN KEY (workout_id) REFERENCES workout (id)
);

CREATE TABLE IF NOT EXISTS session_type (
  id                     INT               NOT NULL AUTO_INCREMENT,
  indoor                 TINYINT(1)        NOT NULL,
  weather_condition      INT                   NULL,
  temperature            FLOAT                 NULL,
  spectators             INT                   NULL,
  session_id             INT               NOT NULL,
  PRIMARY KEY (id),
  INDEX fk_session_type_session_id (session_id ASC),
  CONSTRAINT fk_session_type_session FOREIGN KEY (session_id) REFERENCES session (id)
);

CREATE TABLE IF NOT EXISTS session_info (
  id                     INT               NOT NULL AUTO_INCREMENT,
  time                   VARCHAR(45)       NOT NULL,
  session_id             INT               NOT NULL,
  hearbeat               FLOAT             NOT NULL,
  lat                    DECIMAL(2,12)     NOT NULL,
  lng                    DECIMAL(3,12)     NOT NULL,
  altitude               FLOAT                 NULL,
  PRIMARY KEY (id),
  INDEX fk_session_info_session_id (session_id ASC),
  CONSTRAINT fk_session_info_session FOREIGN KEY (session_id) REFERENCES session (id)
);

CREATE TABLE IF NOT EXISTS exercise_group (
  id                     INT               NOT NULL AUTO_INCREMENT,
  name                   VARCHAR(45)       NOT NULL,
  part_of                INT                   NULL,
  PRIMARY KEY (id),
  INDEX fk_exercise_group_exercise_group_id (part_of ASC),
  CONSTRAINT fk_exercise_group_exercise_group FOREIGN KEY (part_of) REFERENCES exercise_group (id)
);

CREATE TABLE IF NOT EXISTS goal (
  id                     INT               NOT NULL AUTO_INCREMENT,
  set_time               TIME              NOT NULL,
  deadline               DATETIME          NOT NULL,
  max_load               FLOAT                 NULL,
  distance               FLOAT                 NULL,
  time                   FLOAT                 NULL,
  speed                  FLOAT                 NULL,
  PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS exercise (
  id                     INT               NOT NULL AUTO_INCREMENT,
  name                   VARCHAR(45)       NOT NULL,
  description            VARCHAR(512)      NOT NULL,
  km                     FLOAT                 NULL,
  time                   FLOAT                 NULL,
  type                   VARCHAR(45)           NULL,
  exercise_group_id      INT               NOT NULL,
  goal_id                INT               NOT NULL,
  PRIMARY KEY (id),
  INDEX fk_exercise_exercise_group_id (exercise_group_id ASC),
  INDEX fk_exercise_goal_id (goal_id ASC),
  CONSTRAINT fk_exercise_exercise_group FOREIGN KEY (exercise_group_id) REFERENCES exercise_group (id),
  CONSTRAINT fk_exercise_goal FOREIGN KEY (goal_id) REFERENCES goal (id)
);

CREATE TABLE IF NOT EXISTS result (
  id                     INT               NOT NULL AUTO_INCREMENT,
  time                   TIME                  NULL,
  index                  INT                   NULL,
  repetitions            INT                   NULL,
  load                   FLOAT                 NULL,
  result_info            VARCHAR(100)          NULL,
  exercise_id            INT               NOT NULL,
  session_id             INT               NOT NULL,
  PRIMARY KEY (id),
  INDEX fk_result_exercise_id (exercise_id ASC),
  INDEX fk_result_session_id (session_id ASC),
  CONSTRAINT fk_result_exercise FOREIGN KEY (exercise_id) REFERENCES exercise (id),
  CONSTRAINT fk_result_session FOREIGN KEY (session_id) REFERENCES session (id)
);

CREATE TABLE IF NOT EXISTS workout_exercise (
  workout_id             INT               NOT NULL,
  exercise_id            INT               NOT NULL,
  PRIMARY KEY (workout_id, exercise_id),
  INDEX fk_workout_exercise_exercise_id (exercise_id ASC),
  CONSTRAINT fk_workout_exercise_workout FOREIGN KEY (workout_id) REFERENCES workout (id),
  CONSTRAINT fk_workout_exercise_exercise FOREIGN KEY (exercise_id) REFERENCES exercise (id)
);
