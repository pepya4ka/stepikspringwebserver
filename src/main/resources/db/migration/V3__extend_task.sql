alter table task
    add column account_id bigint references account(id);