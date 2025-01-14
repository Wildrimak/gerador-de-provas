CREATE TABLE questao (
  id SERIAL PRIMARY KEY,
  resumo VARCHAR(25) NOT NULL,
  descricao TEXT NOT NULL,
  nivel_dificuldade INT NOT NULL
);

CREATE TABLE alternativa (
  id SERIAL PRIMARY KEY,
  questao_id INT NOT NULL,
  descricao TEXT NOT NULL,
  eh_a_certa BOOLEAN NOT NULL,
  FOREIGN KEY (questao_id) REFERENCES questao (id) ON DELETE CASCADE
);

CREATE TABLE tema (
  id SERIAL PRIMARY KEY,
  descricao VARCHAR(50) NOT NULL
);

CREATE TABLE tema_questao (
  id_questao INT NOT NULL,
  id_tema INT NOT NULL,
  PRIMARY KEY (id_questao, id_tema),
  FOREIGN KEY (id_questao) REFERENCES questao (id) ON DELETE CASCADE,
  FOREIGN KEY (id_tema) REFERENCES tema (id) ON DELETE CASCADE
);
