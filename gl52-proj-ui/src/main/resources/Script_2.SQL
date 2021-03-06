-- -----------------------------------------------------------------------------
--             G�n�ration d'une base de donn�es pour
--                      Oracle Version 10g
--                        (2/6/2021 14:44:53)
-- -----------------------------------------------------------------------------
--      Nom de la base : MLR Projet GL52
--      Projet : Projet GL52
--      Auteur : etudiant etudiant
--      Date de derni�re modification : 2/6/2021 14:44:34
-- -----------------------------------------------------------------------------

DROP TABLE T_ENTREE_STOCK CASCADE CONSTRAINTS;

DROP TABLE T_REPARATION CASCADE CONSTRAINTS;

DROP TABLE T_VENTE CASCADE CONSTRAINTS;

DROP TABLE T_EMPLOYE CASCADE CONSTRAINTS;

DROP TABLE T_CLIENT CASCADE CONSTRAINTS;

DROP TABLE T_LIGNE_VENTE CASCADE CONSTRAINTS;

DROP TABLE T_PRODUIT CASCADE CONSTRAINTS;

DROP TABLE T_DEMANDE CASCADE CONSTRAINTS;

-- -----------------------------------------------------------------------------
--       CREATION DE LA BASE 
-- -----------------------------------------------------------------------------

CREATE DATABASE MLR Projet GL52;

-- -----------------------------------------------------------------------------
--       TABLE : T_ENTREE_STOCK
-- -----------------------------------------------------------------------------

CREATE TABLE T_ENTREE_STOCK
   (
    IDENTR NUMBER(2)  NOT NULL,
    REFPROD NUMBER(4)  NOT NULL,
    QTEENTSTK NUMBER(6)  NULL,
    DATEENTR DATE  NULL
,   CONSTRAINT PK_T_ENTREE_STOCK PRIMARY KEY (IDENTR),
     CONSTRAINT FK_T_ENTREE_STOCK_T_PRODUIT
               FOREIGN KEY (REFPROD)
                    REFERENCES T_PRODUIT (REFPROD)  
   ) ;

-- -----------------------------------------------------------------------------
--       INDEX DE LA TABLE T_ENTREE_STOCK
-- -----------------------------------------------------------------------------

CREATE  INDEX I_FK_T_ENTREE_STOCK_T_PRODUIT
     ON T_ENTREE_STOCK (REFPROD ASC)
    ;

-- -----------------------------------------------------------------------------
--       TABLE : T_REPARATION
-- -----------------------------------------------------------------------------

CREATE TABLE T_REPARATION
   (
    NUMREP NUMBER(4)  NOT NULL,
    ETATREP VARCHAR2(75)  NULL
,   CONSTRAINT PK_T_REPARATION PRIMARY KEY (NUMREP)  
   ) ;

-- -----------------------------------------------------------------------------
--       TABLE : T_VENTE
-- -----------------------------------------------------------------------------

CREATE TABLE T_VENTE
   (
    NUMVTE NUMBER(4)  NOT NULL,
    NUMCLI NUMBER(4)  NOT NULL,
    NUMEMP NUMBER(4)  NOT NULL,
    DATEVTE DATE  NULL,
    MONTANTVTE NUMBER(13,2)  NULL
,   CONSTRAINT PK_T_VENTE PRIMARY KEY (NUMVTE),
     CONSTRAINT FK_T_VENTE_T_CLIENT
          FOREIGN KEY (NUMCLI)
               REFERENCES T_CLIENT (NUMCLI),
     CONSTRAINT FK_T_VENTE_T_EMPLOYE
          FOREIGN KEY (NUMEMP)
               REFERENCES T_EMPLOYE (NUMEMP)
   ) ;

-- -----------------------------------------------------------------------------
--       INDEX DE LA TABLE T_VENTE
-- -----------------------------------------------------------------------------

CREATE  INDEX I_FK_T_VENTE_T_CLIENT
     ON T_VENTE (NUMCLI ASC)
    ;

CREATE  INDEX I_FK_T_VENTE_T_EMPLOYE
     ON T_VENTE (NUMEMP ASC)
    ;

-- -----------------------------------------------------------------------------
--       TABLE : T_EMPLOYE
-- -----------------------------------------------------------------------------

CREATE TABLE T_EMPLOYE
   (
    NUMEMP NUMBER(4)  NOT NULL,
    NOMEMP VARCHAR2(25)  NULL,
    PRENOMEMP VARCHAR2(25)  NULL,
    TELEMP VARCHAR2(12)  NULL,
    MAILEMP VARCHAR2(128)  NULL,
    RUEEMP VARCHAR2(50)  NULL,
    VILLEEMP VARCHAR2(50)  NULL,
    CPEMP NUMBER(7)  NULL,
    PAYSEMP VARCHAR2(50)  NULL
,   CONSTRAINT PK_T_EMPLOYE PRIMARY KEY (NUMEMP)  
   ) ;

-- -----------------------------------------------------------------------------
--       TABLE : T_CLIENT
-- -----------------------------------------------------------------------------

CREATE TABLE T_CLIENT
   (
    NUMCLI NUMBER(4)  NOT NULL,
    NOMCLI VARCHAR2(25)  NULL,
    PRENOMCLI VARCHAR2(25)  NULL,
    TELCLI VARCHAR2(12)  NULL,
    MAILCLI VARCHAR2(128)  NULL,
    RUECLI VARCHAR2(50)  NULL,
    VILLECLI VARCHAR2(50)  NULL,
    CPCLI NUMBER(7)  NULL,
    PAYSCLI VARCHAR2(50)  NULL
,   CONSTRAINT PK_T_CLIENT PRIMARY KEY (NUMCLI)  
   ) ;

-- -----------------------------------------------------------------------------
--       TABLE : T_LIGNE_VENTE
-- -----------------------------------------------------------------------------

CREATE TABLE T_LIGNE_VENTE
   (
    IDLIGNEVENTE NUMBER(4)  NOT NULL,
    REFPROD NUMBER(4)  NOT NULL,
    NUMVTE NUMBER(4)  NOT NULL,
    QTELIGN NUMBER(4)  NULL
,   CONSTRAINT PK_T_LIGNE_VENTE PRIMARY KEY (IDLIGNEVENTE),
     CONSTRAINT FK_T_LIGNE_VENTE_T_PRODUIT
          FOREIGN KEY (REFPROD)
               REFERENCES T_PRODUIT (REFPROD),
     CONSTRAINT FK_T_LIGNE_VENTE_T_VENTE
          FOREIGN KEY (NUMVTE)
               REFERENCES T_VENTE (NUMVTE)
   ) ;

-- -----------------------------------------------------------------------------
--       INDEX DE LA TABLE T_LIGNE_VENTE
-- -----------------------------------------------------------------------------

CREATE  INDEX I_FK_T_LIGNE_VENTE_T_PRODUIT
     ON T_LIGNE_VENTE (REFPROD ASC)
    ;

CREATE  INDEX I_FK_T_LIGNE_VENTE_T_VENTE
     ON T_LIGNE_VENTE (NUMVTE ASC)
    ;

-- -----------------------------------------------------------------------------
--       TABLE : T_PRODUIT
-- -----------------------------------------------------------------------------

CREATE TABLE T_PRODUIT
   (
    REFPROD NUMBER(4)  NOT NULL,
    DESPROD VARCHAR2(125)  NULL,
    QTEPROD NUMBER(4)  NULL,
    PRIXHTPROD NUMBER(13,2)  NULL,
    PRIXTTCPROD NUMBER(13,2)  NULL,
    TVAPROD NUMBER(10,2)  NULL
,   CONSTRAINT PK_T_PRODUIT PRIMARY KEY (REFPROD)  
   ) ;

-- -----------------------------------------------------------------------------
--       TABLE : T_DEMANDE
-- -----------------------------------------------------------------------------

CREATE TABLE T_DEMANDE
   (
    NUMREP NUMBER(4)  NOT NULL,
    NUMCLI NUMBER(4)  NOT NULL,
    REFPROD NUMBER(4)  NOT NULL,
    NATUREREP VARCHAR2(75)  NULL,
    DESREP VARCHAR2(75)  NULL,
    NUMFCT NUMBER(4) NOT NULL
,   CONSTRAINT PK_T_DEMANDE PRIMARY KEY (NUMREP, NUMCLI, REFPROD),
     CONSTRAINT FK_T_DEMANDE_T_REPARATION
          FOREIGN KEY (NUMREP)
               REFERENCES T_REPARATION (NUMREP),
     CONSTRAINT FK_T_DEMANDE_T_CLIENT
          FOREIGN KEY (NUMCLI)
               REFERENCES T_CLIENT (NUMCLI),
     CONSTRAINT FK_T_DEMANDE_T_PRODUIT
          FOREIGN KEY (REFPROD)
               REFERENCES T_PRODUIT (REFPROD),
     CONSTRAINT FK_T_DEMANDE_T_FACTURE
          FOREIGN KEY (NUMFCT)
               REFERENCES T_FACTURE (NUMFCT)  
   ) ;


-- -----------------------------------------------------------------------------
--       TABLE : T_FACTURE
-- -----------------------------------------------------------------------------

CREATE TABLE T_FACTURE
     (
          NUMFCT NUMBER(4) NOT NULL,
          DATEFCT DATE NULL,
          NUMEMP NUMBER(4)  NOT NULL,
          CONSTRAINT PK_T_FACTURE PRIMARY KEY (NUMFCT),
     CONSTRAINT FK_T_FACTURE_T_EMPLOYE
          FOREIGN KEY (NUMEMP)
               REFERENCES T_EMPLOYE (NUMEMP)
     ) ;

-- -----------------------------------------------------------------------------
--       INDEX DE LA TABLE T_FACTURE
-- -----------------------------------------------------------------------------

CREATE INDEX I_FK_T_FACTURE_T_EMPLOYE
     ON T_FACTURE (NUMEMP ASC)
     ;

-- -----------------------------------------------------------------------------
--       TABLE : T_LIGNE_FACTURE
-- -----------------------------------------------------------------------------

CREATE TABLE T_LIGNE_FACTURE
     (
          IDLIGNEFCT NUMBER(4) NOT NULL,
          NUMFCT NUMBER(4) NOT NULL,
          MONTANTLIGNFCT NUMBER(13,2) NULL,
          DESCLIGNEFCT VARCHAR2(75) NULL,
          CONSTRAINT PK_T_LIGNE_FACTURE PRIMARY KEY (IDLIGNEFCT),
     CONSTRAINT FK_T_LIGNE_FACTURE_T_FACTURE
          FOREIGN KEY (NUMFCT)
             REFERENCES T_FACTURE (NUMFCT)
     ) ;

-- -----------------------------------------------------------------------------
--       INDEX DE LA TABLE T_LIGNE_FACTURE
-- -----------------------------------------------------------------------------

CREATE INDEX I_FK_T_LIGNE_FACTURE_T_FACTURE
     ON T_FACTURE (NUMFCT ASC)
     ;

-- -----------------------------------------------------------------------------
--       INDEX DE LA TABLE T_DEMANDE
-- -----------------------------------------------------------------------------

CREATE  INDEX I_FK_T_DEMANDE_T_REPARATION
     ON T_DEMANDE (NUMREP ASC)
    ;

CREATE  INDEX I_FK_T_DEMANDE_T_CLIENT
     ON T_DEMANDE (NUMCLI ASC)
    ;

CREATE  INDEX I_FK_T_DEMANDE_T_PRODUIT
     ON T_DEMANDE (REFPROD ASC)
    ;




-- -----------------------------------------------------------------------------
--                FIN DE GENERATION
-- -----------------------------------------------------------------------------