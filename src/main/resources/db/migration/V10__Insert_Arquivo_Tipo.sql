INSERT INTO arquivo_tipo (descricao, ativo)
SELECT * FROM (SELECT 'Identificação', true) AS tmp
WHERE NOT EXISTS (
    SELECT descricao FROM arquivo_tipo WHERE descricao = 'Identificação'
) LIMIT 1;

INSERT INTO arquivo_tipo (descricao, ativo)
    SELECT * FROM (SELECT 'Vida Funcional', true) AS tmp
    WHERE NOT EXISTS (
        SELECT descricao FROM arquivo_tipo WHERE descricao = 'Vida Funcional'
) LIMIT 1;

INSERT INTO arquivo_tipo (descricao, ativo)
    SELECT * FROM (SELECT 'Contagem Tempo', true) AS tmp
    WHERE NOT EXISTS (
        SELECT descricao FROM arquivo_tipo WHERE descricao = 'Contagem Tempo'
) LIMIT 1;

INSERT INTO arquivo_tipo (descricao, ativo)
    SELECT * FROM (SELECT 'Remuneração/Provento', true) AS tmp
    WHERE NOT EXISTS (
        SELECT descricao FROM arquivo_tipo WHERE descricao = 'Remuneração/Provento'
    ) LIMIT 1;