/*
--Cross join

Prodotto cartesiano

*/


--sql92
SELECT c.custid, e.empid

FROM Sales.Customers AS c

CROSS JOIN HR.Employees AS e


--sql89 è molto error prone per la virgola

SELECT c.custid, e.empid

FROM Sales.Customers AS c, HR.Employees as e

--inner join


	--sql 92

SELECT e.empid, e.firstname, e.lastname, o.orderid

FROM HR.Employees AS E

INNER JOIN Sales.Orders AS O
ON E.EMPID = O.EMPID   -- unisco colone hanno una corrispondenza. i.e. prendo solo i dipendenti che hanno fatto un ordine
					   --

	-- sql 89              senza il where farei un prodotto cartesiano enorme
SELECT e.empid, e.firstname, e.lastname, o.orderid

FROM HR.Employees AS E,Sales.Orders AS O

where E.EMPID = O.EMPID   




--more than 2 tables

SELECT e.firstname, o.orderid, od.qty

FROM HR.Employees AS E

INNER JOIN Sales.Orders AS O                  --as è opzionale
ON E.EMPID = O.EMPID

Join Sales.OrderDetails od
on o.orderid=od.orderid                       --esegue prima il join che esclude prima la maggiore quantità di oggetti

--outer join (left,right,full)
SELECT e.firstname, o.orderid
FROM hr.employees as e
left outer join sales.orders as o
on e.empid=o.empid


SELECT c.companyname, o.orderid
FROM Sales.Customers as c
inner join sales.orders as o           --clienti che hanno fatto ordini
on c.custid=o.custid


-- nella left dico che voglio vedere tutto della tabella di sinistra
SELECT c.companyname, o.orderid,c.custid
FROM Sales.Customers as c
left outer join sales.orders as o           --clienti che hanno fatto ordini + quelli che non ne hanno fatti
on c.custid=o.custid
											-- se mettessi na right chiderei tutti gli ordini a cui assocerei i clienti ma non ha senso perché è evidente che un ordine abbia un cliente
where o.orderid is null




