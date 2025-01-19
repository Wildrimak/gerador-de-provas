ALTER TABLE questao
ALTER COLUMN resumo DROP NOT NULL;

ALTER TABLE questao
ALTER COLUMN nivel_dificuldade DROP NOT NULL;

ALTER TABLE alternativa
ALTER COLUMN eh_a_certa DROP NOT NULL;