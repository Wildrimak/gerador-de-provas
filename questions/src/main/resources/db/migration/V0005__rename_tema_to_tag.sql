ALTER TABLE tema RENAME TO tag;
ALTER TABLE tema_questao RENAME TO tag_questao;
ALTER TABLE tag_questao RENAME COLUMN id_tema TO id_tag;

