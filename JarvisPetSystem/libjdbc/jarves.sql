-- Gerado por Humberto
--   em:        2014-10-17 10:56:08 BRT
--   site:      Oracle Database 10g
--   tipo:      Oracle Database 10g




CREATE USER JARVES IDENTIFIED BY PROFILE DEFAULT ACCOUNT UNLOCK ;
  GRANT UNLIMITED TABLESPACE,
CREATE PUBLIC SYNONYM,
CREATE ROLE,
CREATE DATABASE LINK,
  CREATE VIEW, CREATE SYNONYM,
  CREATE TABLE,
    CREATE MATERIALIZED VIEW,
    CREATE SEQUENCE,
    CREATE TRIGGER,
    CREATE TYPE,
    CREATE PROCEDURE TO JARVES ;

CREATE SEQUENCE JARVES.SEQ_ID_CLIENTE INCREMENT BY 1 MAXVALUE 999999999999999999999999999 MINVALUE 0 CACHE 20 ;

CREATE SEQUENCE JARVES.SEQ_ID_CONTATO INCREMENT BY 1 MAXVALUE 999999 MINVALUE 1 CACHE 20 ;

CREATE SEQUENCE JARVES.SEQ_ID_ENDERECO INCREMENT BY 1 MAXVALUE 99999999 MINVALUE 0 CACHE 20 ;

CREATE TABLE JARVES.TAB_CLIENTE
  (
    ID_CLIENTE     NUMBER (*,0) NOT NULL ,
    NOME_CLIENTE   VARCHAR2 (80 BYTE) ,
    CPF_CLIENTE    VARCHAR2 (11 BYTE) NOT NULL ,
    RG_CLIENTE     VARCHAR2 (11 BYTE) ,
    DTNASC_CLIENTE DATE ,
    SEXO_CLIENTE   VARCHAR2 (20 BYTE) ,
    DTCAD_CLIENTE  DATE
  )
  PCTFREE 10 PCTUSED 40 MAXTRANS 255 TABLESPACE USERS LOGGING STORAGE
  (
    INITIAL 65536 PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS 2147483645 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT
  ) ;
CREATE UNIQUE INDEX JARVES.TAB_CLIENTE_PK ON JARVES.TAB_CLIENTE
  (
    ID_CLIENTE ASC
  )
  TABLESPACE USERS PCTFREE 10 MAXTRANS 255 STORAGE
  (
    INITIAL 65536 PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS 2147483645 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT
  )
  LOGGING ;
  ALTER TABLE JARVES.TAB_CLIENTE ADD CONSTRAINT TAB_CLIENTE_PK PRIMARY KEY ( ID_CLIENTE ) USING INDEX JARVES.TAB_CLIENTE_PK ;

CREATE TABLE JARVES.TAB_ENDERECO
  (
    ID_ENDERECO      NUMBER (*,0) NOT NULL ,
    ID_CLIENTE_FK    NUMBER (*,0) NOT NULL ,
    NR_ENDERECO      NUMBER (*,0) ,
    COMP_ENDERECO    VARCHAR2 (60 BYTE) ,
    ID_LOGRADOURO_FK NUMBER (6) NOT NULL ,
    ID_FORNECEDOR_FK NUMBER (*,0)
  )
  PCTFREE 10 PCTUSED 40 MAXTRANS 255 TABLESPACE USERS LOGGING STORAGE
  (
    INITIAL 65536 PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS 2147483645 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT
  ) ;
CREATE UNIQUE INDEX JARVES.TAB_ENDERECO_PK ON JARVES.TAB_ENDERECO
  (
    ID_ENDERECO ASC
  )
  TABLESPACE USERS PCTFREE 10 MAXTRANS 255 STORAGE
  (
    INITIAL 65536 PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS 2147483645 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT
  )
  LOGGING ;
  ALTER TABLE JARVES.TAB_ENDERECO ADD CONSTRAINT TAB_ENDERECO_PK PRIMARY KEY ( ID_ENDERECO ) USING INDEX JARVES.TAB_ENDERECO_PK ;

CREATE TABLE JARVES.TAB_CONTATO
  (
    ID_CONTATO       NUMBER (*,0) NOT NULL ,
    EMAIL_CONTATO    VARCHAR2 (60 BYTE) ,
    TEL_CONTATO      VARCHAR2 (12 BYTE) ,
    CEL_CONTATO      VARCHAR2 (12 BYTE) ,
    OBS_CONTATO      VARCHAR2 (60 BYTE) ,
    ID_CLIENTE_FK    NUMBER (*,0) NOT NULL ,
    ID_FORNECEDOR_FK NUMBER (*,0)
  )
  PCTFREE 10 PCTUSED 40 MAXTRANS 255 TABLESPACE USERS LOGGING STORAGE
  (
    INITIAL 65536 PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS 2147483645 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT
  ) ;
CREATE UNIQUE INDEX JARVES.TAB_CONTATO_PK ON JARVES.TAB_CONTATO
  (
    ID_CONTATO ASC
  )
  TABLESPACE USERS PCTFREE 10 MAXTRANS 255 STORAGE
  (
    INITIAL 65536 PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS 2147483645 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT
  )
  LOGGING ;
  ALTER TABLE JARVES.TAB_CONTATO ADD CONSTRAINT TAB_CONTATO_PK PRIMARY KEY ( ID_CONTATO ) USING INDEX JARVES.TAB_CONTATO_PK ;


CREATE OR REPLACE PROCEDURE JARVES.INSERE_CLIENTE
(
nome IN tab_cliente.nome_cliente%TYPE, cpf IN tab_cliente.cpf_cliente%TYPE, rg IN tab_cliente.rg_cliente%TYPE,
dtnasc IN tab_cliente.dtnasc_cliente%TYPE, sexo tab_cliente.sexo_cliente%TYPE, numero IN tab_endereco.nr_endereco%TYPE,
comp IN tab_endereco.comp_endereco%TYPE, id_log IN tab_endereco.id_logradouro_fk%TYPE, email IN tab_contato.email_contato%TYPE,
tel IN tab_contato.tel_contato%TYPE, cel IN tab_contato.cel_contato%TYPE, obs IN tab_contato.obs_contato%TYPE
)
IS
BEGIN
  INSERT INTO tab_cliente (id_cliente,nome_cliente,cpf_cliente,rg_cliente,dtnasc_cliente,sexo_cliente,dtcad_cliente)
  VALUES (seq_id_cliente.nextval,nome,cpf,rg,dtnasc,sexo,SYSDATE);
  
  INSERT INTO tab_endereco(id_endereco,id_cliente_fk,nr_endereco,comp_endereco,id_logradouro_fk,id_fornecedor_fk) 
  VALUES(seq_id_endereco.nextval,seq_id_cliente.currval,numero,comp,id_log,null);
  
  INSERT INTO tab_contato(id_contato,email_contato,tel_contato,cel_contato,obs_contato,id_cliente_fk,id_fornecedor_fk)
  VALUES (seq_id_contato.nextval,email,tel,cel,obs,seq_id_cliente.currval,null);
END insere_cliente;
/

CREATE TABLE JARVES.TAB_ANIMAL
  (
    ID_ANIMAL     NUMBER (*,0) NOT NULL ,
    ID_CLIENTE_FK NUMBER (*,0) NOT NULL ,
    ID_RACA_FK    NUMBER (*,0) NOT NULL ,
    PESO_ANIMAL   NUMBER ,
    DTNASC_ANIMAL DATE ,
    SEXO_ANIMAL   CHAR (1 BYTE) ,
    STATUS_ANIMAL CHAR (1 BYTE) ,
    OBS_ANIMAL    VARCHAR2 (60 BYTE)
  )
  PCTFREE 10 PCTUSED 40 MAXTRANS 255 TABLESPACE USERS LOGGING STORAGE
  (
    INITIAL 65536 PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS 2147483645 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT
  ) ;
CREATE UNIQUE INDEX JARVES.TAB_ANIMAL_PK ON JARVES.TAB_ANIMAL
  (
    ID_ANIMAL ASC
  )
  TABLESPACE USERS PCTFREE 10 MAXTRANS 255 STORAGE
  (
    INITIAL 65536 PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS 2147483645 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT
  )
  LOGGING ;
  ALTER TABLE JARVES.TAB_ANIMAL ADD CONSTRAINT TAB_ANIMAL_PK PRIMARY KEY ( ID_ANIMAL ) USING INDEX JARVES.TAB_ANIMAL_PK ;

CREATE TABLE JARVES.TAB_BAIRRO
  (
    ID_BAIRRO    NUMBER (6) NOT NULL ,
    ID_MUNICIPIO NUMBER (6) NOT NULL ,
    NOME_BAIRRO  VARCHAR2 (60 BYTE) NOT NULL
  )
  PCTFREE 10 PCTUSED 40 MAXTRANS 255 TABLESPACE USERS LOGGING STORAGE
  (
    INITIAL 65536 PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS 2147483645 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT
  ) ;
CREATE UNIQUE INDEX JARVES.TAB_BAIRRO_ID_BAIRRO_PK ON JARVES.TAB_BAIRRO
  (
    ID_BAIRRO ASC
  )
  TABLESPACE USERS PCTFREE 10 MAXTRANS 255 STORAGE
  (
    INITIAL 65536 PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS 2147483645 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT
  )
  LOGGING ;
  ALTER TABLE JARVES.TAB_BAIRRO ADD CONSTRAINT TAB_BAIRRO_ID_BAIRRO_PK PRIMARY KEY ( ID_BAIRRO ) USING INDEX JARVES.TAB_BAIRRO_ID_BAIRRO_PK ;

CREATE TABLE JARVES.TAB_ESPECIE
  (
    ID_ESPECIE   NUMBER (*,0) NOT NULL ,
    NOME_ESPECIE VARCHAR2 (60 BYTE)
  )
  PCTFREE 10 PCTUSED 40 MAXTRANS 255 TABLESPACE USERS LOGGING STORAGE
  (
    INITIAL 65536 PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS 2147483645 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT
  ) ;
CREATE UNIQUE INDEX JARVES.TAB_ESPECIE_PK ON JARVES.TAB_ESPECIE
  (
    ID_ESPECIE ASC
  )
  TABLESPACE USERS PCTFREE 10 MAXTRANS 255 STORAGE
  (
    INITIAL 65536 PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS 2147483645 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT
  )
  LOGGING ;
  ALTER TABLE JARVES.TAB_ESPECIE ADD CONSTRAINT TAB_ESPECIE_PK PRIMARY KEY ( ID_ESPECIE ) USING INDEX JARVES.TAB_ESPECIE_PK ;

CREATE TABLE JARVES.TAB_ESTADO
  (
    ID_ESTADO    NUMBER (6) NOT NULL ,
    SIGLA_ESTADO VARCHAR2 (2 BYTE) NOT NULL ,
    NOME_ESTADO  VARCHAR2 (60 BYTE) NOT NULL
  )
  PCTFREE 10 PCTUSED 40 MAXTRANS 255 TABLESPACE USERS LOGGING STORAGE
  (
    INITIAL 65536 PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS 2147483645 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT
  ) ;
CREATE UNIQUE INDEX JARVES.TAB_ESTADO_ID_ESTADO_PK ON JARVES.TAB_ESTADO
  (
    ID_ESTADO ASC
  )
  TABLESPACE USERS PCTFREE 10 MAXTRANS 255 STORAGE
  (
    INITIAL 65536 PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS 2147483645 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT
  )
  LOGGING ;
  ALTER TABLE JARVES.TAB_ESTADO ADD CONSTRAINT TAB_ESTADO_ID_ESTADO_PK PRIMARY KEY ( ID_ESTADO ) USING INDEX JARVES.TAB_ESTADO_ID_ESTADO_PK ;

CREATE TABLE JARVES.TAB_ESTOQUE
  (
    ID_ESTOQUE    NUMBER (*,0) NOT NULL ,
    ID_PRODUTO_FK NUMBER (*,0) NOT NULL ,
    COR_ESTOQUE   VARCHAR2 (10 BYTE) ,
    COL_ESTOQUE   VARCHAR2 (10 BYTE) ,
    LIN_ESTOQUE   VARCHAR2 (10 BYTE)
  )
  PCTFREE 10 PCTUSED 40 MAXTRANS 255 TABLESPACE USERS LOGGING STORAGE
  (
    INITIAL 65536 PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS 2147483645 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT
  ) ;
CREATE UNIQUE INDEX JARVES.TAB_ESTOQUE_PK ON JARVES.TAB_ESTOQUE
  (
    ID_ESTOQUE ASC
  )
  TABLESPACE USERS PCTFREE 10 MAXTRANS 255 STORAGE
  (
    INITIAL 65536 PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS 2147483645 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT
  )
  LOGGING ;
  ALTER TABLE JARVES.TAB_ESTOQUE ADD CONSTRAINT TAB_ESTOQUE_PK PRIMARY KEY ( ID_ESTOQUE ) USING INDEX JARVES.TAB_ESTOQUE_PK ;

CREATE TABLE JARVES.TAB_FORNECEDOR
  (
    ID_FORNECEDOR    NUMBER (*,0) NOT NULL ,
    NOME_FORNECEDOR  VARCHAR2 (60 BYTE) ,
    CNPJ_FORNECEDOR  VARCHAR2 (14 BYTE) NOT NULL ,
    IE_FORNECEDOR    VARCHAR2 (20 BYTE) ,
    DTCAD_FORNECEDOR DATE NOT NULL
  )
  PCTFREE 10 PCTUSED 40 MAXTRANS 255 TABLESPACE USERS LOGGING STORAGE
  (
    INITIAL 65536 PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS 2147483645 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT
  ) ;
CREATE UNIQUE INDEX JARVES.TAB_FORNECEDOR_PK ON JARVES.TAB_FORNECEDOR
  (
    ID_FORNECEDOR ASC
  )
  TABLESPACE USERS PCTFREE 10 MAXTRANS 255 STORAGE
  (
    INITIAL 65536 PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS 2147483645 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT
  )
  LOGGING ;
  ALTER TABLE JARVES.TAB_FORNECEDOR ADD CONSTRAINT TAB_FORNECEDOR_PK PRIMARY KEY ( ID_FORNECEDOR ) USING INDEX JARVES.TAB_FORNECEDOR_PK ;

CREATE TABLE JARVES.TAB_IMPOSTO
  (
    ID_IMPOSTO NUMBER (*,0) NOT NULL ,
    VL_IMPOSTO NUMBER (*,0)
  )
  PCTFREE 10 PCTUSED 40 MAXTRANS 255 TABLESPACE USERS LOGGING STORAGE
  (
    INITIAL 65536 PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS 2147483645 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT
  ) ;
CREATE UNIQUE INDEX JARVES.TAB_IMPOSTO_PK ON JARVES.TAB_IMPOSTO
  (
    ID_IMPOSTO ASC
  )
  TABLESPACE USERS PCTFREE 10 MAXTRANS 255 STORAGE
  (
    INITIAL 65536 PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS 2147483645 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT
  )
  LOGGING ;
  ALTER TABLE JARVES.TAB_IMPOSTO ADD CONSTRAINT TAB_IMPOSTO_PK PRIMARY KEY ( ID_IMPOSTO ) USING INDEX JARVES.TAB_IMPOSTO_PK ;

CREATE TABLE JARVES.TAB_LOGRADOURO
  (
    ID_LOGRADOURO   NUMBER (6) NOT NULL ,
    ID_BAIRRO       NUMBER (6) NOT NULL ,
    NOME_LOGRADOURO VARCHAR2 (100 BYTE) NOT NULL ,
    CEP_LOGRADOURO  VARCHAR2 (8 BYTE) NOT NULL
  )
  PCTFREE 10 PCTUSED 40 MAXTRANS 255 TABLESPACE USERS LOGGING STORAGE
  (
    INITIAL 65536 PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS 2147483645 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT
  ) ;
CREATE UNIQUE INDEX JARVES.TAB_LOGRADOURO_ID_LOGR_PK ON JARVES.TAB_LOGRADOURO
  (
    ID_LOGRADOURO ASC
  )
  TABLESPACE USERS PCTFREE 10 MAXTRANS 255 STORAGE
  (
    INITIAL 65536 PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS 2147483645 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT
  )
  LOGGING ;
  ALTER TABLE JARVES.TAB_LOGRADOURO ADD CONSTRAINT TAB_LOGRADOURO_ID_LOGR_PK PRIMARY KEY ( ID_LOGRADOURO ) USING INDEX JARVES.TAB_LOGRADOURO_ID_LOGR_PK ;

CREATE TABLE JARVES.TAB_MUNICIPIO
  (
    ID_MUNICIPIO   NUMBER (6) NOT NULL ,
    ID_ESTADO      NUMBER (6) NOT NULL ,
    NOME_MUNICIPIO VARCHAR2 (60 BYTE) NOT NULL
  )
  PCTFREE 10 PCTUSED 40 MAXTRANS 255 TABLESPACE USERS LOGGING STORAGE
  (
    INITIAL 65536 PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS 2147483645 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT
  ) ;
CREATE UNIQUE INDEX JARVES.TAB_MUNICIPIO_ID_MUCIPIO_PK ON JARVES.TAB_MUNICIPIO
  (
    ID_MUNICIPIO ASC
  )
  TABLESPACE USERS PCTFREE 10 MAXTRANS 255 STORAGE
  (
    INITIAL 65536 PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS 2147483645 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT
  )
  LOGGING ;
  ALTER TABLE JARVES.TAB_MUNICIPIO ADD CONSTRAINT TAB_MUNICIPIO_ID_MUCIPIO_PK PRIMARY KEY ( ID_MUNICIPIO ) USING INDEX JARVES.TAB_MUNICIPIO_ID_MUCIPIO_PK ;

CREATE TABLE JARVES.TAB_PRECO_PROD
  (
    ID_PRECO_PROD NUMBER (*,0) NOT NULL ,
    ID_PROD_FK    NUMBER (*,0) NOT NULL ,
    DT_INICIO     DATE ,
    DT_FIM        DATE ,
    VALOR_VENDA   NUMBER ,
    VALOR_COMPRA  NUMBER ,
    LUCRO         NUMBER
  )
  PCTFREE 10 PCTUSED 40 MAXTRANS 255 TABLESPACE USERS LOGGING STORAGE
  (
    INITIAL 65536 PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS 2147483645 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT
  ) ;
CREATE UNIQUE INDEX JARVES.TAB_PRECO_PROD_PK ON JARVES.TAB_PRECO_PROD
  (
    ID_PRECO_PROD ASC
  )
  TABLESPACE USERS PCTFREE 10 MAXTRANS 255 STORAGE
  (
    INITIAL 65536 PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS 2147483645 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT
  )
  LOGGING ;
  ALTER TABLE JARVES.TAB_PRECO_PROD ADD CONSTRAINT TAB_PRECO_PROD_PK PRIMARY KEY ( ID_PRECO_PROD ) USING INDEX JARVES.TAB_PRECO_PROD_PK ;

CREATE TABLE JARVES.TAB_PRODUTO
  (
    ID_PRODUTO    NUMBER (*,0) NOT NULL ,
    EAN_PRODUTO   VARCHAR2 (20 BYTE) ,
    DESC_PRODUTO  VARCHAR2 (60 BYTE) ,
    UN_PRODUTO    VARCHAR2 (20 BYTE) ,
    QTDE_PRODUTO  NUMBER ,
    ID_IMPOSTO_FK NUMBER (*,0) NOT NULL
  )
  PCTFREE 10 PCTUSED 40 MAXTRANS 255 TABLESPACE USERS LOGGING STORAGE
  (
    INITIAL 65536 PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS 2147483645 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT
  ) ;
CREATE UNIQUE INDEX JARVES.TAB_PRODUTO_PK ON JARVES.TAB_PRODUTO
  (
    ID_PRODUTO ASC
  )
  TABLESPACE USERS PCTFREE 10 MAXTRANS 255 STORAGE
  (
    INITIAL 65536 PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS 2147483645 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT
  )
  LOGGING ;
  ALTER TABLE JARVES.TAB_PRODUTO ADD CONSTRAINT TAB_PRODUTO_PK PRIMARY KEY ( ID_PRODUTO ) USING INDEX JARVES.TAB_PRODUTO_PK ;

CREATE TABLE JARVES.TAB_RACA
  (
    ID_RACA       NUMBER (*,0) NOT NULL ,
    ID_ESPECIE_FK NUMBER (*,0) NOT NULL ,
    NOME_RACA     VARCHAR2 (60 BYTE)
  )
  PCTFREE 10 PCTUSED 40 MAXTRANS 255 TABLESPACE USERS LOGGING STORAGE
  (
    INITIAL 65536 PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS 2147483645 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT
  ) ;
CREATE UNIQUE INDEX JARVES.TAB_RACA_PK ON JARVES.TAB_RACA
  (
    ID_RACA ASC
  )
  TABLESPACE USERS PCTFREE 10 MAXTRANS 255 STORAGE
  (
    INITIAL 65536 PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS 2147483645 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT
  )
  LOGGING ;
  ALTER TABLE JARVES.TAB_RACA ADD CONSTRAINT TAB_RACA_PK PRIMARY KEY ( ID_RACA ) USING INDEX JARVES.TAB_RACA_PK ;

CREATE TABLE JARVES.TAB_VACINACAO
  (
    ID_VACINACAO  NUMBER (*,0) NOT NULL ,
    ID_ANIMAL_FK  NUMBER (*,0) NOT NULL ,
    ID_PRODUTO_FK NUMBER (*,0) NOT NULL ,
    DT_VACINACAO  DATE ,
    OBS_VACINACAO VARCHAR2 (60 BYTE)
  )
  PCTFREE 10 PCTUSED 40 MAXTRANS 255 TABLESPACE USERS LOGGING STORAGE
  (
    INITIAL 65536 PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS 2147483645 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT
  ) ;
CREATE UNIQUE INDEX JARVES.TAB_VACINACAO_PK ON JARVES.TAB_VACINACAO
  (
    ID_VACINACAO ASC
  )
  TABLESPACE USERS PCTFREE 10 MAXTRANS 255 STORAGE
  (
    INITIAL 65536 PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS 2147483645 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT
  )
  LOGGING ;
  ALTER TABLE JARVES.TAB_VACINACAO ADD CONSTRAINT TAB_VACINACAO_PK PRIMARY KEY ( ID_VACINACAO ) USING INDEX JARVES.TAB_VACINACAO_PK ;

ALTER TABLE JARVES.TAB_ANIMAL ADD CONSTRAINT TAB_ANIMAL_TAB_CLIENTE_FK FOREIGN KEY ( ID_CLIENTE_FK ) REFERENCES JARVES.TAB_CLIENTE ( ID_CLIENTE ) NOT DEFERRABLE ;

ALTER TABLE JARVES.TAB_ANIMAL ADD CONSTRAINT TAB_ANIMAL_TAB_RACA_FK FOREIGN KEY ( ID_RACA_FK ) REFERENCES JARVES.TAB_RACA ( ID_RACA ) NOT DEFERRABLE ;

ALTER TABLE JARVES.TAB_BAIRRO ADD CONSTRAINT TAB_BAIRRO_ID_MUNICIPIO_FK FOREIGN KEY ( ID_MUNICIPIO ) REFERENCES JARVES.TAB_MUNICIPIO ( ID_MUNICIPIO ) NOT DEFERRABLE ;

ALTER TABLE JARVES.TAB_CONTATO ADD CONSTRAINT TAB_CONTATO_TAB_CLIENTE_FK FOREIGN KEY ( ID_CLIENTE_FK ) REFERENCES JARVES.TAB_CLIENTE ( ID_CLIENTE ) NOT DEFERRABLE ;

ALTER TABLE JARVES.TAB_CONTATO ADD CONSTRAINT TAB_CONTATO_TAB_FORNECEDOR_FK FOREIGN KEY ( ID_FORNECEDOR_FK ) REFERENCES JARVES.TAB_FORNECEDOR ( ID_FORNECEDOR ) NOT DEFERRABLE ;

ALTER TABLE JARVES.TAB_ENDERECO ADD CONSTRAINT TAB_ENDERECO_TAB_CLIENTE_FK FOREIGN KEY ( ID_CLIENTE_FK ) REFERENCES JARVES.TAB_CLIENTE ( ID_CLIENTE ) NOT DEFERRABLE ;

ALTER TABLE JARVES.TAB_ENDERECO ADD CONSTRAINT TAB_ENDERECO_TAB_FORNECEDOR_FK FOREIGN KEY ( ID_FORNECEDOR_FK ) REFERENCES JARVES.TAB_FORNECEDOR ( ID_FORNECEDOR ) NOT DEFERRABLE ;

ALTER TABLE JARVES.TAB_ENDERECO ADD CONSTRAINT TAB_ENDERECO_TAB_LOGRADOURO_FK FOREIGN KEY ( ID_LOGRADOURO_FK ) REFERENCES JARVES.TAB_LOGRADOURO ( ID_LOGRADOURO ) NOT DEFERRABLE ;

ALTER TABLE JARVES.TAB_ESTOQUE ADD CONSTRAINT TAB_ESTOQUE_TAB_PRODUTO_FK FOREIGN KEY ( ID_PRODUTO_FK ) REFERENCES JARVES.TAB_PRODUTO ( ID_PRODUTO ) NOT DEFERRABLE ;

ALTER TABLE JARVES.TAB_LOGRADOURO ADD CONSTRAINT TAB_LOGRADOURO_ID_BAIRRO_FK FOREIGN KEY ( ID_BAIRRO ) REFERENCES JARVES.TAB_BAIRRO ( ID_BAIRRO ) NOT DEFERRABLE ;

ALTER TABLE JARVES.TAB_MUNICIPIO ADD CONSTRAINT TAB_MUNICIPIO_ID_ESTADO_FK FOREIGN KEY ( ID_ESTADO ) REFERENCES JARVES.TAB_ESTADO ( ID_ESTADO ) NOT DEFERRABLE ;

ALTER TABLE JARVES.TAB_PRECO_PROD ADD CONSTRAINT TAB_PRECO_PROD_TAB_PRODUTO_FK FOREIGN KEY ( ID_PROD_FK ) REFERENCES JARVES.TAB_PRODUTO ( ID_PRODUTO ) NOT DEFERRABLE ;

ALTER TABLE JARVES.TAB_PRODUTO ADD CONSTRAINT TAB_PRODUTO_TAB_IMPOSTO_FK FOREIGN KEY ( ID_IMPOSTO_FK ) REFERENCES JARVES.TAB_IMPOSTO ( ID_IMPOSTO ) NOT DEFERRABLE ;

ALTER TABLE JARVES.TAB_RACA ADD CONSTRAINT TAB_RACA_TAB_ESPECIE_FK FOREIGN KEY ( ID_ESPECIE_FK ) REFERENCES JARVES.TAB_ESPECIE ( ID_ESPECIE ) NOT DEFERRABLE ;

ALTER TABLE JARVES.TAB_VACINACAO ADD CONSTRAINT TAB_VACINACAO_TAB_ANIMAL_FK FOREIGN KEY ( ID_ANIMAL_FK ) REFERENCES JARVES.TAB_ANIMAL ( ID_ANIMAL ) NOT DEFERRABLE ;

ALTER TABLE JARVES.TAB_VACINACAO ADD CONSTRAINT TAB_VACINACAO_TAB_PRODUTO_FK FOREIGN KEY ( ID_PRODUTO_FK ) REFERENCES JARVES.TAB_PRODUTO ( ID_PRODUTO ) NOT DEFERRABLE ;

CREATE OR REPLACE TRIGGER JARVES.SEQ_CLIENTE 
    BEFORE INSERT ON JARVES.TAB_CLIENTE 
    FOR EACH ROW 
begin  
   if inserting then 
      if :NEW."ID_CLIENTE" is null then 
         select SEQ_ID_CLIENTE.nextval into :NEW."ID_CLIENTE" from dual; 
      end if; 
   end if; 
end; 
/




-- Relatório do Resumo do Oracle SQL Developer Data Modeler: 
-- 
-- CREATE TABLE                            16
-- CREATE INDEX                            16
-- ALTER TABLE                             32
-- CREATE VIEW                              0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         1
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           1
-- ALTER TRIGGER                            0
-- CREATE COLLECTION TYPE                   0
-- CREATE STRUCTURED TYPE                   0
-- CREATE STRUCTURED TYPE BODY              0
-- CREATE CLUSTER                           0
-- CREATE CONTEXT                           0
-- CREATE DATABASE                          0
-- CREATE DIMENSION                         0
-- CREATE DIRECTORY                         0
-- CREATE DISK GROUP                        0
-- CREATE ROLE                              0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE SEQUENCE                          3
-- CREATE MATERIALIZED VIEW                 0
-- CREATE SYNONYM                           0
-- CREATE TABLESPACE                        0
-- CREATE USER                              1
-- 
-- DROP TABLESPACE                          0
-- DROP DATABASE                            0
-- 
-- ERRORS                                   0
-- WARNINGS                                 0
