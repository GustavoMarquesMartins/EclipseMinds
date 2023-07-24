ALTER TABLE funcionarios
    ADD COLUMN status TINYINT;
UPDATE funcionarios set status = 1;
