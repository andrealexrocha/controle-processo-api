INSERT INTO funcionario (cpf, matricula, name, orgao_id)
SELECT * FROM (SELECT '000.001.002-01', '001', 'Antônio José da Silva', (SELECT id FROM orgao WHERE codigo = '003')) AS tmp
WHERE NOT EXISTS (
    SELECT matricula FROM funcionario WHERE matricula = '001'
) LIMIT 1;

INSERT INTO funcionario (cpf, matricula, name, orgao_id)
    SELECT * FROM (SELECT '100.001.002-11', '002', 'Paulo Silvino', (SELECT id FROM orgao WHERE codigo = '002')) AS tmp
    WHERE NOT EXISTS (
        SELECT matricula FROM funcionario WHERE matricula = '002'
) LIMIT 1;

INSERT INTO funcionario (cpf, matricula, name, orgao_id)
    SELECT * FROM (SELECT '101.001.102-12', '003', 'Maria Aparecida', (SELECT id FROM orgao WHERE codigo = '001')) AS tmp
    WHERE NOT EXISTS (
        SELECT matricula FROM funcionario WHERE matricula = '003'
) LIMIT 1;

INSERT INTO funcionario (cpf, matricula, name, orgao_id)
    SELECT * FROM (SELECT '700.001.502-11', '004', 'Americo da Silva', (SELECT id FROM orgao WHERE codigo = '002')) AS tmp
    WHERE NOT EXISTS (
        SELECT matricula FROM funcionario WHERE matricula = '004'
    ) LIMIT 1;

INSERT INTO funcionario (cpf, matricula, name, orgao_id)
    SELECT * FROM (SELECT '050.101.202-01', '005', 'Antônio da Silva', (SELECT id FROM orgao WHERE codigo = '001')) AS tmp
    WHERE NOT EXISTS (
        SELECT matricula FROM funcionario WHERE matricula = '005'
    ) LIMIT 1;