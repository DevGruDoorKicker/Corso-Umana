--Self contained subqueries
SELECT *
FROM Sales.Customers 
where custid = (select custid from Sales.Orders where orderid = 10000)     -- ci sono le tonde; differenza con le join è la provenienza da una singola tabella
																			-- si usano quando si richiede un valore assoluto

-- questa non funziona perché uguale funzionerebbe in presenza di un singolo valore																		   -- la sottoquery può funzionare di per sé da sola
SELECT *
FROM Sales.Orders
where empid = (select e.empid from HR.Employees as e where e.lastname like 'd%') 

--questa è corretta
SELECT *
FROM Sales.Orders
where empid in (select e.empid from HR.Employees as e where e.lastname like 'd%') 



SELECT *
FROM Sales.Orders
where custid not in (select c.custid from Sales.Customers as c where c.country = 'USA') 



-- Parametrized (correlated) subqueries
-- si usano quando voglio valori relativi
select * from Sales.Orders
where orderid = (select max (orderid) from Sales.Orders)  -- mi dà l'ultimo ordine
														


select * from Sales.Orders as o1
where orderid = (select max (orderid) from Sales.Orders as o2 where o2.custid=o1.custid)  -- la query interna non può restituire nulla senza convocare quella esterna, restituisce l'ultimo ordine di ogni cliente



(select max (orderid) from Sales.Orders as o2 where o2.custid=85)       -- l'ordine massimo del cliente 85


--view è una query complessa
select orderid, custid, val,cast(100* val/
(select sum(val) from sales.OrderValues as o2 where o2.custid=o1.custid)as numeric(5,2)) as pct
from sales.OrderValues as o1
order by custid, orderid

--exists
select * from Sales.customers as c
where country='Spain'
and exists (select * from sales.Orders as o where o.custid=c.custid)        -- interruzione di svolgimento query anche se non avesse finito
order by custid																--clienti spagnoli che hanno fatto ordini


select * from Sales.customers as c
where country='Spain'
and not exists (select * from sales.Orders as o where o.custid=c.custid)        --
order by custid


--kpi
select orderyear, qty,
(select sum(o2.qty) from sales.OrderTotalsByYear as o2 where o2.qty<=o1.qty) as runqty     --somma a ritroso per anno
from sales.OrderTotalsByYear as o1
order by orderyear






