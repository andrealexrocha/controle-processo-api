INSERT INTO setor (codigo, descricao, ativo)
SELECT * FROM (SELECT '001', 'Setor 01', true) AS tmp
WHERE NOT EXISTS (
    SELECT codigo FROM setor WHERE codigo = '001'
) LIMIT 1;

INSERT INTO setor (codigo, descricao, ativo)
    SELECT * FROM (SELECT '002', 'Setor 02', true) AS tmp
    WHERE NOT EXISTS (
        SELECT codigo FROM setor WHERE codigo = '002'
) LIMIT 1;
