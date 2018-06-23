create table IF NOT EXISTS logs
(
  EVENT_ID integer not null,
  EVENT_DATE TIMESTAMP not null,
  LEVEL varchar(255) not null,
  LOGGER varchar(255) not null,
  MESSAGE varchar(255) not null,
  THROWABLE varchar(255)
);