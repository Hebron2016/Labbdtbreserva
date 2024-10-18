CREATE DATABASE AuditoriaJPA 
GO
USE AuditoriaJPA

CREATE TRIGGER t_ipvalido ON sessao
AFTER INSERT, UPDATE
AS
BEGIN
	DECLARE @vldIp VARCHAR(12),
			@numIp BIGINT,
			@vldNum BIT
	SET @vldIp = (SELECT ip FROM inserted)
	IF(LEN(@vldIp) > 12 OR LEN(@vldIp)<4)
	BEGIN
		ROLLBACK
		RAISERROR('Não existe IP maior que 12 ou menor 4 digitos',16,2)
	END
	ELSE 
	BEGIN 
		SET @vldNum = (ISNUMERIC(@vldIp))
		IF(@vldNum = 1)	
		BEGIN
			SET @numIp = CAST(@vldIp AS bigint)
			IF( @numIp > 255255255255 OR @numIp < 1000 )
			BEGIN
				ROLLBACK
				RAISERROR('Não existe IP maior que 255255255255, OU menor que 1000',16,2)
			END
		END
		ELSE
		BEGIN
			ROLLBACK
			RAISERROR('Serão aceito apenas números',16,2)
		END
	END
END

CREATE TRIGGER t_vldhttp ON requisicao
AFTER INSERT, UPDATE 
AS
    DECLARE @vldhttp INT
    SET @vldhttp = (SELECT http FROM inserted)
    IF( LEN(@vldhttp) > 3)
    BEGIN
         ROLLBACK 
         RAISERROR('O protocolo HTTP que você busca não existe', 16,2)
    END
    ELSE
    BEGIN
         IF( @vldhttp <100 OR @vldhttp > 599)
         BEGIN
              ROLLBACK 
              RAISERROR('O protocolo HTTP que você digitou não existe favor informar um protocolo HTTP entre 100 e 599', 16,2)
         END
    END

CREATE TRIGGER t_checklen ON pagina
AFTER INSERT, UPDATE 
AS
	DECLARE @vldArq INT
	SET @vldArq = (SELECT lenArqBytes FROM inserted)
	IF (LEN(@vldArq) > 7 OR @vldArq >1048576)
	BEGIN
		ROLLBACK
		RAISERROR('São aceitos somentes arquivos com peso menor que 1MB por extenso',16,2)
	END

CREATE TRIGGER t_vldtarget ON link
AFTER INSERT, UPDATE
AS
	DECLARE @vldtarget VARCHAR (8)
	SET @vldtarget = (SELECT target FROM inserted)
	SET @vldtarget = (LOWER(@vldtarget))
	IF (@vldtarget != '_blank')
	BEGIN
		IF( @vldtarget != '_self')
		BEGIN
			IF (@vldtarget != '_parent')
			BEGIN
				IF( @vldtarget != '_top')
				BEGIN
					ROLLBACK
					RAISERROR('Os target que você inseriu não é valido são permitidos apenas: _blank, _self, _parent, _top',16,2)
				END
			END
		END
	END

CREATE TRIGGER t_vldtime ON	requisicao
AFTER INSERT, UPDATE
AS
	DECLARE @vldtime INT
	SET @vldtime = (SELECT tempo FROM inserted)
	IF(@vldtime > 60000)
	BEGIN
		ROLLBACK
		RAISERROR('timeout',16,3)
	END

CREATE FUNCTION fn_qtdLinks(@codigoLink INT)
RETURNS INT
AS
BEGIN
	DECLARE @qtdLink INT
		SET @qtdLink = (SELECT COUNT(li.codigoLink) FROM link li, requisicaolink rl WHERE  rl.linkCodigoLink = li.codigoLink AND li.codigoLink = @codigoLink)
	RETURN @qtdLink
END

---TESTE AVL---
---T_ipInvalido---
INSERT INTO sessao VALUES
(1,1,'LALAND')
INSERT INTO sessao VALUES
(2,1,'LALAND')
INSERT INTO sessao VALUES
(3,1,'LALAND')
INSERT INTO sessao VALUES
(4,1,'LALAND')
INSERT INTO sessao VALUES
(4,999,'LALAND')
INSERT INTO sessao VALUES
(4,1000,'LALAND')
INSERT INTO sessao VALUES
(6,255255255255,'LALAND')
INSERT INTO sessao VALUES
(7,'255255255255','LALAND')
INSERT INTO sessao VALUES
(8,'2552552552551','LALAND')
INSERT INTO sessao VALUES
(8,'juratempest','LALAND')

---t_vldhttp---
---Temque alterar a sequência dos atributos
INSERT INTO pagina VALUES
('FAZOM1','<html></html>',1000000 ,'digimon','Digimon')
INSERT INTO requisicao VALUES
(1,90,'0200','FAZOM',4)
INSERT INTO requisicao VALUES
(1,100,'0200','FAZOM',4)
INSERT INTO requisicao VALUES
(2,101,'0200','FAZOM',4)
INSERT INTO requisicao VALUES
(3,500,'0200','FAZOM',4)
INSERT INTO requisicao VALUES
(4,599,'0200','FAZOM',4)
INSERT INTO requisicao VALUES
(5,600,'0200','FAZOM',4)
INSERT INTO requisicao VALUES
(5,1000,'0200','FAZOM',4)
---t_checklen---
INSERT INTO pagina VALUES
('FAZOM1','<html></html>',1000000 ,'digimon','Digimon')
INSERT INTO pagina VALUES
('FAZOM2','<html></html>',10000000 ,'digimon','Digimon')
INSERT INTO pagina VALUES
('FAZOM3','<html></html>',1048576 ,'digimon','Digimon')
INSERT INTO pagina VALUES
('FAZOM4','<html></html>',1048577 ,'digimon','Digimon')
INSERT INTO pagina VALUES
('FAZOM5','<html></html>',104857 ,'digimon','Digimon')
---t_vldtarget---
INSERT INTO link VALUES
(1,'_blank','leBlank','FAZOM')
INSERT INTO link VALUES
(2,'_self','leBlank','FAZOM')
INSERT INTO link VALUES
(3,'_parent','leBlank','FAZOM')
INSERT INTO link VALUES
(4,'_top','leBlank','FAZOM')
INSERT INTO link VALUES
(5,'_top1','leBlank','FAZOM')
---t_vld---
INSERT INTO requisicao VALUES
(1,200,60000,'FAZOM1',7)
INSERT INTO requisicao VALUES
(2,200,60001,'FAZOM1',7)
INSERT INTO requisicao VALUES
(2,90,60001,'FAZOM1',7)

SELECT * FROM sessao
SELECT * FROM requisicao
SELECT * FROM link
SELECT * FROM pagina
SELECT * FROM log
SELECT * FROM requisicaolink


---SELECTS para Repository
SELECT * FROM pagina p WHERE p.url = !
SELECT * FROM pagina p WHERE p.lenArqBytes = 1000000
SELECT * FROM requisicao r WHERE r.tempo < 60001
SELECT * FROM sessao s WHERE s.ip = ! 
SELECT * FROM log l, sessao s WHERE s.ip = 255255255255 AND s.codigoSessao = l.sessaoCodigoSessao
SELECT r.codigoRequisicao, r.http, r.paginaUrl , r.sessaoCodigoSessao, r.tempo FROM requisicao r, sessao s 
		WHERE r.sessaoCodigoSessao = s.codigoSessao AND s.usuario = 'LALAND'


INSERT INTO logs VALUES
(1,'LALALAL',7)

SELECT dbo.fn_qtdLinks(1) AS codigoLink

