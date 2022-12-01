/*


Argomenti di oggi:

Single table queries
Join
Subqueries
Operatori set
Data manipulation (inesert, update, delete, merge)
Transaction



Schema sono i prefessi che precedono il punto nel nome delle tabelle


L'ordine di esecuzione di comandi:
From
Where
Group by
Having
Select
Order by


*/

-- Single table queries 

SELECT	empid,
		year(orderdate) as orderyear,

		count(*)	as numorders		        -- le funzioni matematiche hanno accesso a colonne extra
-- Group by impedisce di usare un dominio più grande del suo
-- as crea un alias che posso mettere solo in select
-- è case insensitive

FROM [Sales].[Orders]							--Nome schema . Nome oggetto
												

WHERE custid = 71

GROUP BY empid,YEAR(orderdate)        -- year permette di prendere colonne di tipo data gg/mm/aa  

HAVING count(*) > 1

ORDER BY empid, orderyear            --uso l'ordine di esecuzione per semplificare il linguaggio

SELECT *
		
FROM
	[Sales].[Orders]                       -- from è obbligatoria

where                                -- clausola opzionale
	custid=73

		





SELECT	empid,
		year(orderdate) as orderyear,

		sum (freight),
		count (*)as numorders		


FROM [Sales].[Orders]							

WHERE custid = 71

GROUP BY empid,YEAR(orderdate)          

HAVING count (*)> 1

ORDER BY empid, orderyear



SELECT DISTINCT	empid,                    -- DISTINCT VA DOPO SELECT ED ELIMINA I DUPLICATI, viene applicata a tutta la n-upla (tutti i campi)
				year(orderdate) as orderyear

FROM [Sales].[Orders]							

WHERE custid = 71

	ORDER BY empid, orderyear
			


SELECT	empid,
		year(orderdate) as orderyear,

		sum (freight),
		count (*)as numorders		


FROM [Sales].[Orders]							

WHERE custid = 71

GROUP BY empid,YEAR(orderdate)          

HAVING count (*)> 1

ORDER BY empid desc,                      --ordine discendente con desc
		 orderyear asc



SELECT	empid,
		year(orderdate) as orderyear,

		sum (freight),
		count (*)as numorders		


FROM [Sales].[Orders]							

WHERE custid = 71

GROUP BY empid,YEAR(orderdate)          

HAVING count (*)> 1

ORDER BY 1 desc,                      --ordine discendente con desc
		 2 desc


--Campionamento (Sampling)

SELECT TOP (5) *                  -- si accoppia sempre alla order by di solito

FROM Sales.Orders

ORDER BY orderdate desc


SELECT TOP (1) percent *                  -- mostra l'1 percento degli ordini

FROM Sales.Orders

ORDER BY orderdate desc



SELECT TOP (5) with ties  *                  -- aggiungo i parimerito in base al parametro scelto (i.e. data)

FROM Sales.Orders

ORDER BY orderdate desc


--Scrolling


SELECT *

FROM Sales.Orders

ORDER BY orderdate

OFFSET 50 ROWS FETCH NEXT 25 ROWS ONLY                -- A PARTIRE DALL'ORDINE 50 FAMMI VEDERE SOLO LE PROSSIMA 25 RIGHE
													  -- PARTENDO DA 50 è COME SE AVESSI FATTO SCROLL 2 VOLTE
													  -- OFFSET HA SENSO SOLO DOPO ORDER BY



SELECT *

FROM Sales.Orders

ORDER BY orderdate

OFFSET 0 ROWS FETCH NEXT 25 ROWS ONLY


-- PREDICATES AND OPERATORS:
-- WHERE VAL BETWEEN...  AND...
-- WHERE VAL IN (1,..,n)                    OPERATORI DI RICERCA PER RANGE 


--Priorità degli operatori:
/*
()
*,/,%
+,-,+(addition),+(concatenation),-(subtraction)
=(confronto),<,<=..., != (o <>)
not
and
between, in, like, or
=(assignement)
*/

SELECT *

FROM SALES.ORDERS

WHERE CUSTID = 1 AND EMPID in (1,3,5) or                  --And è operatore binario che ha precedenza sull'or quindi qui ho 2 coppie
														  -- separate dall'or.
	  custid = 85 and empid in (2,4,6)						

--CASE EXPRESSIONS


--Simple case

SELECT productid, 
	case categoryid 
		when 1 then 'beverage'         -- quando ho 1 nella colonna categoryid lo cambio a beverage
		when 2 then 'food'
		else 'unknown'
	end as categoryname

FROM Production.Products


--Searched case

SELECT  
	case 
		when val<1000 then 'less then 1000'       
		when val between 1000 and 3000 then 'compreso tra 1000 e 3000 estremi inclusi' 
		else 'unknown'                  -- else deve sempre prevedere casistiche non contemplate
	end as valuecategory

FROM Sales.OrderValues             --view e non tabella (??)


--Null

SELECT *

FROM SALES.CUSTOMERS

WHERE region = 'WA'            --case sensitive  



SELECT *

FROM SALES.CUSTOMERS

WHERE region <> 'WA'            --mi da quelli di versi da WA e non null



SELECT *

FROM SALES.CUSTOMERS

WHERE region = NULL            --non funziona



SELECT *

FROM SALES.CUSTOMERS

WHERE region is NULL            -- funziona


SELECT *

FROM SALES.CUSTOMERS

WHERE region is not NULL            -- funziona dandomi i non null




--Like                                 --cercare con pattern, i.e. cercare val che iniziano con ...
SELECT *

FROM HR.Employees

WHERE lastname like 'd%'              --% dice è il numero di caratteri indefinito dopo la d


SELECT *

FROM HR.Employees

WHERE lastname like 'd_'              --singolo carattere indefinito dopo la d


SELECT *

FROM HR.Employees

WHERE lastname like 'd_v%'              --singolo carattere indefinito dopo la d e dopo deve iniziare con v












