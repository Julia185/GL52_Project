-- -----------------------------------------------------------------------------
--             Génération d'une base de données pour
--                      Oracle Version 10g
--                        (19/5/2021 18:33:55)
-- -----------------------------------------------------------------------------
--      Nom de la base : Projet GL52
--      Projet : Projet GL52
--      Auteur : etudiant etudiant
--      Date de dernière modification : 19/5/2021 18:28:23
-- -----------------------------------------------------------------------------

DROP TABLE T_ENTREE_STOCK;

DROP TABLE T_REPARATION CASCADE CONSTRAINTS;

DROP TABLE T_VENTE CASCADE CONSTRAINTS;

DROP TABLE T_SORTIE_STOCK CASCADE CONSTRAINTS;

DROP TABLE T_EMPLOYE CASCADE CONSTRAINTS;

DROP TABLE T_CLIENT CASCADE CONSTRAINTS;

DROP TABLE T_LIGNE_VENTE CASCADE CONSTRAINTS;

DROP TABLE T_PRODUIT CASCADE CONSTRAINTS;

DROP TABLE DEMANDE CASCADE CONSTRAINTS;

-- -----------------------------------------------------------------------------
--       CREATION DE LA BASE 
-- -----------------------------------------------------------------------------

CREATE DATABASE Projet GL52;

-- -----------------------------------------------------------------------------
--       TABLE : T_ENTREE_STOCK
-- -----------------------------------------------------------------------------

CREATE TABLE T_ENTREE_STOCK
   (
    QTEENTSTK NUMBER(6)  NOT NULL,
    REFPROD NUMBER(4)  NOT NULL,
    DATEENTR DATE  NULL
,  CONSTRAINT PK_T_ENTREE_STOCK PRIMARY KEY (QTEENTSTK),
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
    LIBVTE VARCHAR2(128)  NULL,
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
--       TABLE : T_SORTIE_STOCK
-- -----------------------------------------------------------------------------

CREATE TABLE T_SORTIE_STOCK
   (
    QTESORTSTK NUMBER(6)  NOT NULL,
    REFPROD NUMBER(4)  NOT NULL,
    DATESORT DATE  NULL
,   CONSTRAINT PK_T_SORTIE_STOCK PRIMARY KEY (QTESORTSTK),
      CONSTRAINT FK_T_SORTIE_STOCK_T_PRODUIT
          FOREIGN KEY (REFPROD)
               REFERENCES T_PRODUIT (REFPROD)  
   ) ;

-- -----------------------------------------------------------------------------
--       INDEX DE LA TABLE T_SORTIE_STOCK
-- -----------------------------------------------------------------------------

CREATE  INDEX I_FK_T_SORTIE_STOCK_T_PRODUIT
     ON T_SORTIE_STOCK (REFPROD ASC)
    ;

-- -----------------------------------------------------------------------------
--       TABLE : T_EMPLOYE
-- -----------------------------------------------------------------------------

CREATE TABLE T_EMPLOYE
   (
    NUMEMP NUMBER(4)  NOT NULL,
    NOMEMP VARCHAR2(25)  NULL,
    PRENOMEMP VARCHAR2(25)  NULL,
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
    QTELIGN NUMBER(4)  NOT NULL,
    REFPROD NUMBER(4)  NOT NULL,
    NUMVTE NUMBER(4)  NOT NULL
,   CONSTRAINT PK_T_LIGNE_VENTE PRIMARY KEY (QTELIGN),
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
--       TABLE : DEMANDE
-- -----------------------------------------------------------------------------

CREATE TABLE DEMANDE
   (
    NUMREP NUMBER(4)  NOT NULL,
    NUMCLI NUMBER(4)  NOT NULL,
    NATUREREP VARCHAR2(75)  NULL,
    DESREP VARCHAR2(75)  NULL,
    REFPROD NUMBER(6)  NULL
,   CONSTRAINT PK_DEMANDE PRIMARY KEY (NUMREP, NUMCLI),
      CONSTRAINT FK_DEMANDE_T_REPARATION
          FOREIGN KEY (NUMREP)
               REFERENCES T_REPARATION (NUMREP),
               CONSTRAINT FK_DEMANDE_T_CLIENT
          FOREIGN KEY (NUMCLI)
               REFERENCES T_CLIENT (NUMCLI)  
   ) ;

-- -----------------------------------------------------------------------------
--       INDEX DE LA TABLE DEMANDE
-- -----------------------------------------------------------------------------

CREATE  INDEX I_FK_DEMANDE_T_REPARATION
     ON DEMANDE (NUMREP ASC)
    ;

CREATE  INDEX I_FK_DEMANDE_T_CLIENT
     ON DEMANDE (NUMCLI ASC)
    ;


-- -----------------------------------------------------------------------------
--                FIN DE GENERATION
-- -----------------------------------------------------------------------------