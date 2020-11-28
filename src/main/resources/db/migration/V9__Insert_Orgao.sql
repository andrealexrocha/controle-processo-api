INSERT INTO orgao (codigo, descricao, ativo)
SELECT * FROM (SELECT '001', 'Seplag', true) AS tmp
WHERE NOT EXISTS (
    SELECT codigo FROM orgao WHERE codigo = '001'
) LIMIT 1;

INSERT INTO orgao (codigo, descricao, ativo)
    SELECT * FROM (SELECT '002', 'TCM', true) AS tmp
    WHERE NOT EXISTS (
        SELECT codigo FROM orgao WHERE codigo = '002'
) LIMIT 1;

INSERT INTO orgao (codigo, descricao, ativo)
    SELECT * FROM (SELECT '003', 'TCE', true) AS tmp
    WHERE NOT EXISTS (
        SELECT codigo FROM orgao WHERE codigo = '003'
) LIMIT 1;

